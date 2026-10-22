package com.stepos.alphame.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.Tags;
import com.stepos.alphame.data.DataSource;
import com.stepos.alphame.data.DataSourceManager;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.scene.AppInstallReceiver;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.ThreadPool;
import com.stepos.alphame.utils.Utils;
import com.stepos.common.alphame.Args;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class AppInfoEngine extends EngineBase {
    private static final int CALCULATE_PERIOD = 7;
    public static final int FAVORITE_APP = 3;
    public static final int NORMAL_WHITE_APP = 5;
    public static final int RECENT_LOCK_APP = 2;
    private static final String RECENT_LOCK_SAVED_APPS = "recent_lock_apps";
    public static final int SUPER_WHITE_APP = 4;
    private static final String TAG = "AppInfoEngine";
    public static final int USER_WHITE_APP = 1;
    public static final int WORK_STATE_APP = 0;
    private static AppInfoEngine sInstance;
    private final List<String> mFavoriteApps = Collections.synchronizedList(new ArrayList());
    private final List<String> mRecentLockApps = Collections.synchronizedList(new ArrayList());
    private int mLastDay = 0;
    private Handler mHandler = new Handler();
    private SettingObserver mSettingObserver = new SettingObserver(this.mHandler);
    private int mFavoriteAppCount = 10;
    private AppInstallReceiver.OnAppInsatllChangeListener mPackageChangeReceiver = new AppInstallReceiver.OnAppInsatllChangeListener() { // from class: com.stepos.alphame.app.AppInfoEngine.1
        @Override // com.stepos.alphame.scene.AppInstallReceiver.OnAppInsatllChangeListener
        public void onChanged(String str, int i4, int i5) {
        }
    };
    private BroadcastReceiver mUerPresentReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.app.AppInfoEngine.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                ThreadPool.getInstance().submit(new UpdateFavoriteAppJob(AppInfoEngine.this, 0));
            }
        }
    };

    public class AppListByType extends EngineFunc {
        public AppListByType(EngineBase engineBase) {
            super(engineBase);
            this.name = "getAppListByType";
            this.isPublic = true;
            this.argsType = new byte[]{4};
            this.argsName = new String[]{"type"};
            this.returnType = (byte) 12;
            this.annotation = new String[]{"根据类型获取名单列表", "@author wangwen1", "@param type 获取名单类型", "@return 对应类型的名单列表"};
        }
    }

    public class FavoriteAppList extends EngineFunc {
        public FavoriteAppList(EngineBase engineBase) {
            super(engineBase);
            this.name = "getFavoriteApps";
            this.argsType = new byte[]{0};
            this.returnType = (byte) 12;
            this.annotation = new String[]{"获取当前用户喜爱的应用", "@author zhuhequan", "@return 用户喜爱的应用"};
        }
    }

    public static class KeyIntElement implements Comparable<KeyIntElement> {
        String key;
        int day = 0;
        int value = 0;

        public KeyIntElement(String str) {
            this.key = str;
        }

        public static KeyIntElement find(List<KeyIntElement> list, String str) {
            for (KeyIntElement keyIntElement : list) {
                if (keyIntElement.key.equals(str)) {
                    return keyIntElement;
                }
            }
            return null;
        }

        @Override // java.lang.Comparable
        public int compareTo(KeyIntElement keyIntElement) {
            return keyIntElement.value - this.value;
        }
    }

    public class SettingObserver extends ContentObserver {
        public SettingObserver(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z4, Uri uri) {
            super.onChange(z4, uri);
            if (Settings.System.getUriFor(AppInfoEngine.RECENT_LOCK_SAVED_APPS).equals(uri)) {
                AppInfoEngine.this.updateRecentApps();
                ArrayList arrayList = new ArrayList(AppInfoEngine.this.mRecentLockApps);
                ActionManager.getInstance().broadcast("APP_LIST_CHANGED", new Args(2, arrayList));
                if (Utils.DEBUG.get()) {
                    Log.d(AppInfoEngine.TAG, "getAppListByType recent app = " + arrayList);
                }
            }
        }
    }

    public class UpdateFavoriteAppJob implements ThreadPool.Job<Boolean> {
        public /* synthetic */ UpdateFavoriteAppJob(AppInfoEngine appInfoEngine, int i4) {
            this();
        }

        private UpdateFavoriteAppJob() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.stepos.alphame.utils.ThreadPool.Job
        public Boolean run() {
            AppInfoEngine.this.updateFavoriteApps();
            return Boolean.TRUE;
        }
    }

    private AppInfoEngine() {
    }

    private ArrayList<KeyIntElement> getAppClickedInfo(int i4, int i5) {
        DataSource dataSource = DataSourceManager.getInstance().getDataSource(Tags.APP_CLICK);
        dataSource.store(true);
        Cursor cursor = AppClickStorable.getCursor(AppClickStorable.QUERY_ITEM_1, new String[]{Integer.toString(i4), Integer.toString(i5)});
        if (cursor == null) {
            return null;
        }
        Storable storable = dataSource.getStorable();
        ArrayList<KeyIntElement> arrayList = new ArrayList<>(32);
        AppClickDataItem appClickDataItem = new AppClickDataItem();
        while (cursor.moveToNext()) {
            try {
                storable.fillItem(cursor, appClickDataItem);
                KeyIntElement keyIntElementFind = KeyIntElement.find(arrayList, appClickDataItem.getPackageName());
                if (keyIntElementFind == null) {
                    keyIntElementFind = new KeyIntElement(appClickDataItem.getPackageName());
                    arrayList.add(keyIntElementFind);
                }
                if (appClickDataItem.getDay() <= i5 && appClickDataItem.getDay() >= i5 - 2) {
                    keyIntElementFind.day++;
                }
                keyIntElementFind.value += appClickDataItem.getClick();
            } catch (Throwable th) {
                cursor.close();
                throw th;
            }
        }
        cursor.close();
        Collections.sort(arrayList);
        return arrayList;
    }

    private ArrayList<String> getDeprecatedWhiteApp(int i4) {
        AlphaMeLogger.dLog("getAppListByType: white list type " + i4 + " deprecated, return empty");
        return new ArrayList<>();
    }

    public static AppInfoEngine getInstance() {
        if (sInstance == null) {
            sInstance = new AppInfoEngine();
        }
        return sInstance;
    }

    private void registerReceiver() {
        AppInstallReceiver.addListener(this.mPackageChangeReceiver);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        ApplicationImpl.getApplication().registerReceiver(this.mUerPresentReceiver, intentFilter);
        ApplicationImpl.getApplication().getContentResolver().registerContentObserver(Settings.System.getUriFor(RECENT_LOCK_SAVED_APPS), false, this.mSettingObserver);
    }

    private void unregisterReceiver() {
        AppInstallReceiver.removeListener(this.mPackageChangeReceiver);
        ApplicationImpl.getApplication().unregisterReceiver(this.mUerPresentReceiver);
        ApplicationImpl.getApplication().getContentResolver().unregisterContentObserver(this.mSettingObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFavoriteApps() {
        int iCurrentDay = Utils.currentDay();
        if (iCurrentDay != this.mLastDay) {
            this.mLastDay = iCurrentDay;
            ArrayList<KeyIntElement> appClickedInfo = getAppClickedInfo(iCurrentDay - 8, iCurrentDay - 1);
            ArrayList arrayList = new ArrayList(this.mFavoriteAppCount);
            int iMin = Math.min(this.mFavoriteAppCount, appClickedInfo != null ? appClickedInfo.size() : 0);
            for (int i4 = 0; i4 < iMin; i4++) {
                if (appClickedInfo.get(i4).value >= 21 && appClickedInfo.get(i4).day > 0) {
                    arrayList.add(appClickedInfo.get(i4).key);
                }
            }
            if (this.mFavoriteApps.size() == arrayList.size() && this.mFavoriteApps.containsAll(arrayList)) {
                return;
            }
            this.mFavoriteApps.clear();
            this.mFavoriteApps.addAll(arrayList);
            ActionManager.getInstance().broadcast("APP_LIST_CHANGED", new Args(3, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecentApps() {
        String string = Settings.System.getString(ApplicationImpl.getApplication().getContentResolver(), RECENT_LOCK_SAVED_APPS);
        this.mRecentLockApps.clear();
        if (string != null) {
            Collections.addAll(this.mRecentLockApps, string.split(";"));
        }
    }

    @NotProguard
    public ArrayList<String> getAppListByType(int i4) {
        if (i4 == 0) {
            ArrayList<String> workingAppList = AppStateEngine.getInstance().getWorkingAppList();
            if (Utils.DEBUG.get()) {
                Log.d(TAG, "getAppListByType work state = " + workingAppList.toString());
            }
            return workingAppList;
        }
        if (i4 != 1) {
            if (i4 == 2) {
                ArrayList<String> arrayList = new ArrayList<>(this.mRecentLockApps);
                if (Utils.DEBUG.get()) {
                    Log.d(TAG, "getAppListByType recent lock = " + arrayList.toString());
                }
                return arrayList;
            }
            if (i4 == 3) {
                return getFavoriteApps();
            }
            if (i4 != 4 && i4 != 5) {
                return null;
            }
        }
        return getDeprecatedWhiteApp(i4);
    }

    @NotProguard
    public ArrayList<String> getFavoriteApps() {
        updateFavoriteApps();
        ArrayList<String> arrayList = new ArrayList<>(this.mFavoriteApps);
        if (Utils.DEBUG.get()) {
            Log.d(TAG, "getAppListByType favorite = " + arrayList.toString());
        }
        return arrayList;
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
        EngineBase.addFunc(new FavoriteAppList(this));
        EngineBase.addFunc(new AppListByType(this));
        updateRecentApps();
        registerReceiver();
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        super.onStop();
        unregisterReceiver();
    }
}
