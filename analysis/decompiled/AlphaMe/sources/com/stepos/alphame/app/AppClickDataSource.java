package com.stepos.alphame.app;

import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.DataSource;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.utils.Utils;
import com.stepos.common.alphame.b;
import com.stepos.common.alphame.c;
import java.util.HashSet;

/* loaded from: classes.dex */
public class AppClickDataSource extends DataSource {
    private static final byte[] ARGS_TYPE = {6};
    private b mEventReceiver;
    private int mSize;
    private final HashSet<String> mSkipPkgs;

    public AppClickDataSource(String str) {
        super(str);
        this.mSkipPkgs = new HashSet<>();
        this.mSize = 0;
        this.mEventReceiver = new b("APP_EVENT") { // from class: com.stepos.alphame.app.AppClickDataSource.1
            private String mForegroundApp;

            @Override // com.stepos.common.alphame.b
            public void onReceiver(String str2, Object obj) {
                if (obj != null) {
                    String[] strArr = (String[]) obj;
                    String str3 = strArr[0];
                    String str4 = strArr[1];
                    if (!"resume".equals(str4)) {
                        if (AppEventDataItem.APP_HOME.equals(str4)) {
                            AppClickDataSource.this.setSkipPkgs(str3);
                            return;
                        }
                        return;
                    }
                    String str5 = this.mForegroundApp;
                    if (str5 == null) {
                        this.mForegroundApp = str3;
                        return;
                    }
                    if (str5.equals(str3)) {
                        return;
                    }
                    if (!AppClickDataSource.this.mSkipPkgs.contains(this.mForegroundApp)) {
                        AppClickDataItem appClickDataItem = (AppClickDataItem) AppClickDataSource.this.itemCache().pop();
                        appClickDataItem.fill(this.mForegroundApp);
                        if (Utils.DEBUG.get()) {
                            Log.d("AlphaMe", "click pkg = " + this.mForegroundApp);
                        }
                        AppClickDataSource.this.collect(appClickDataItem);
                    }
                    this.mForegroundApp = str3;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void collect(DataItem dataItem) {
        synchronized (this.mSyncObject) {
            try {
                AppClickDataItem appClickDataItem = (AppClickDataItem) dataItem;
                if (TextUtils.isEmpty(appClickDataItem.getPackageName())) {
                    return;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= this.mHistory.size()) {
                        this.mHistory.add(appClickDataItem);
                        break;
                    }
                    AppClickDataItem appClickDataItem2 = (AppClickDataItem) this.mHistory.get(i4);
                    if (appClickDataItem.getPackageName().equals(appClickDataItem2.getPackageName()) && appClickDataItem.getDay() == appClickDataItem2.getDay()) {
                        appClickDataItem2.setClick(appClickDataItem2.getClick() + appClickDataItem.getClick());
                        break;
                    }
                    i4++;
                }
                int i5 = this.mSize + 1;
                this.mSize = i5;
                if (i5 >= 10) {
                    store();
                    this.mSize = 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSkipPkgs(String str) {
        this.mSkipPkgs.clear();
        this.mSkipPkgs.add("com.android.systemui");
        this.mSkipPkgs.add("com.android.incallui");
        if (str != null) {
            this.mSkipPkgs.add(str);
        } else {
            this.mSkipPkgs.add("com.android.launcher3");
        }
    }

    @Override // com.stepos.alphame.data.DataSource
    public Storable createStorable() {
        return new AppClickStorable();
    }

    @Override // com.stepos.alphame.data.DataSource
    public Class<? extends DataItem> getDataItemClass() {
        return AppClickDataItem.class;
    }

    @Override // com.stepos.alphame.data.DataSource
    public byte[] getFillArgsType() {
        return ARGS_TYPE;
    }

    @Override // com.stepos.alphame.data.DataSource
    public void onStart() {
        super.onStart();
        c.f11224a.f(this.mEventReceiver);
        setSkipPkgs(null);
    }

    @Override // com.stepos.alphame.data.DataSource
    public void process(DataItem dataItem) {
    }
}
