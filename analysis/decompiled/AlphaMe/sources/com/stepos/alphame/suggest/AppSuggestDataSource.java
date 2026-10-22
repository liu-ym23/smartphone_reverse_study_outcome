package com.stepos.alphame.suggest;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.app.AppEventDataItem;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.DataSource;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.ThreadPool;
import com.stepos.alphame.utils.Utils;
import com.stepos.common.alphame.b;
import com.stepos.common.alphame.c;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public class AppSuggestDataSource extends DataSource {
    private static final byte[] ARGS_TYPE = {6};
    private static final long DAY = 86400000;
    private static final String KEY_NOTIFY_NEW_APP_DATA = "onNotifyNewAppData";
    private ArrayList<DataItem> mCacheList;
    private b mEventReceiver;
    private String mFrontPackageName;
    private final HashSet<String> mSkipPkgs;

    public class SuggestClearJob implements ThreadPool.Job<Boolean> {
        public /* synthetic */ SuggestClearJob(AppSuggestDataSource appSuggestDataSource, int i4) {
            this();
        }

        private SuggestClearJob() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.stepos.alphame.utils.ThreadPool.Job
        public Boolean run() {
            try {
                AlphaMeLogger.debugLog("AppSuggestReport SuggestClearJob exec");
                ((AppSuggestStorable) AppSuggestDataSource.this.getStorable()).deleteInvalidData(System.currentTimeMillis() - 259200000);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return Boolean.TRUE;
        }
    }

    public class SuggestStorableJob implements ThreadPool.Job<Boolean> {
        public /* synthetic */ SuggestStorableJob(AppSuggestDataSource appSuggestDataSource, int i4) {
            this();
        }

        private SuggestStorableJob() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.stepos.alphame.utils.ThreadPool.Job
        public Boolean run() {
            try {
                AppSuggestDataSource.this.execSave("job");
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return Boolean.TRUE;
        }
    }

    public AppSuggestDataSource(String str) {
        super(str);
        this.mSkipPkgs = new HashSet<>();
        this.mCacheList = new ArrayList<>();
        this.mFrontPackageName = "";
        this.mEventReceiver = new b("APP_EVENT") { // from class: com.stepos.alphame.suggest.AppSuggestDataSource.1
            @Override // com.stepos.common.alphame.b
            public void onReceiver(String str2, Object obj) {
                if (obj != null) {
                    try {
                        String[] strArr = (String[]) obj;
                        String str3 = strArr[0];
                        String str4 = strArr[1];
                        String str5 = strArr[2];
                        if (!"resume".equals(str4)) {
                            if (AppEventDataItem.APP_HOME.equals(str4)) {
                                AppSuggestDataSource.this.setSkipPkgs(str3);
                                return;
                            }
                            return;
                        }
                        if (TextUtils.isEmpty(str3)) {
                            return;
                        }
                        if (str3.equals(AppSuggestDataSource.this.mFrontPackageName) && !AppSuggestReport.mShortFunList.contains(str5)) {
                            AlphaMeLogger.debugLog("AppSuggestReport same ".concat(str3));
                            return;
                        }
                        AppSuggestDataSource.this.mFrontPackageName = str3;
                        if (AppSuggestDataSource.this.mSkipPkgs.contains(str3)) {
                            return;
                        }
                        AlphaMeLogger.debugLog("AppSuggestReport resume " + str3 + "/" + str5);
                        AppSuggestDataItem appSuggestDataItem = new AppSuggestDataItem();
                        AppSuggestReport.getInstance().pickItem(appSuggestDataItem, str3, str5);
                        AppSuggestDataSource.this.collect(appSuggestDataItem);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        };
    }

    private void clearExpired() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - Property.getLong(Property.KEY_LAST_CLEAR_INVALID_TIME, 0L) >= 86400000) {
                AlphaMeLogger.debugLog("AppSuggestReport clearExpired exec");
                ThreadPool.getInstance().submit(new SuggestClearJob(this, 0));
                Property.setLong(Property.KEY_LAST_CLEAR_INVALID_TIME, jCurrentTimeMillis);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void collect(DataItem dataItem) {
        synchronized (this.mSyncObject) {
            try {
                AppSuggestDataItem appSuggestDataItem = (AppSuggestDataItem) dataItem;
                if (TextUtils.isEmpty(appSuggestDataItem.getPkgName())) {
                    return;
                }
                this.mCacheList.add(appSuggestDataItem);
                int size = this.mCacheList.size();
                AlphaMeLogger.debugLog("AppSuggestReport collect " + appSuggestDataItem + " size: " + size);
                if (size >= 30 || AppSuggestReport.getInstance().testMode()) {
                    ThreadPool.getInstance().submit(new SuggestStorableJob(this, 0));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void notifyExternal() {
        try {
            ApplicationImpl.getApplication().sendBroadcast(new Intent("com.stepos.suggestion.action.ALPHAME_APP_ACTION"), "stepos.app.suggestion.permission.alphame.action");
            AlphaMeLogger.debugLog("notifyExternal success");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSkipPkgs(String str) {
        this.mSkipPkgs.clear();
        this.mSkipPkgs.add("com.android.systemui");
        this.mSkipPkgs.add("com.android.incallui");
        this.mSkipPkgs.add("com.android.launcher3");
        if (str != null) {
            this.mSkipPkgs.add(str);
        }
    }

    @Override // com.stepos.alphame.data.DataSource
    public Storable createStorable() {
        return new AppSuggestStorable();
    }

    public void execSave(String str) {
        AlphaMeLogger.debugLog("AppSuggestReport execSave from=" + str);
        synchronized (this.mSyncObject) {
            ArrayList<DataItem> arrayList = this.mCacheList;
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<DataItem> arrayList2 = new ArrayList<>(this.mCacheList);
                this.mCacheList.clear();
                long jCurrentTimeMillis = System.currentTimeMillis();
                getStorable().writeItem(arrayList2);
                if (Utils.DEBUG.get()) {
                    Log.i("AlphaMe", String.format("Write item %s cost time %d", this.mTag, Integer.valueOf((int) (System.currentTimeMillis() - jCurrentTimeMillis))));
                }
                clearExpired();
            }
        }
    }

    @Override // com.stepos.alphame.data.DataSource
    public Class<? extends DataItem> getDataItemClass() {
        return AppSuggestDataItem.class;
    }

    @Override // com.stepos.alphame.data.DataSource
    public byte[] getFillArgsType() {
        return ARGS_TYPE;
    }

    @Override // com.stepos.alphame.data.DataSource
    public void onStart() {
        super.onStart();
        AlphaMeLogger.debugLog("AppSuggestReport source start");
        c.f11224a.f(this.mEventReceiver);
        setSkipPkgs(null);
    }

    @Override // com.stepos.alphame.data.DataSource
    public void process(DataItem dataItem) {
    }
}
