package com.stepos.alphame.scene;

import B0.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.EngineContract;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.ReceiverUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class QuickAppHelper {
    private static final String ACTION_START_QUICK_APP = "com.stepos.directservice.MSG_START_QUICK_APP";
    private static final String ACTION_START_QUICK_GAME = "com.stepos.directservice.MSG_START_QUICK_GAME";
    private static final String EXTRA_ACTIVITY = "EXTRA_ACTIVITY";
    private static final String EXTRA_NAME = "EXTRA_NAME";
    private static final String EXTRA_PACKAGE = "EXTRA_PACKAGE";
    public static final String PKG_QUICK_APP = "com.stepos.directservice";
    public static final String PREFIX_QUICK_APP = "quick_";
    public static final String PREFIX_QUICK_GAME = "quickgame_";
    private static QuickAppHelper sInstance;
    private String mLastQuickAppName;
    private String mLastPrefixQuickAppPkg = null;
    private String mLastQuickAppActivity = null;
    private String mLastQuickAppRealPkg = null;
    private List<QuickAppListener> mListeners = new ArrayList();
    private BroadcastReceiver mQuickAppReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.scene.QuickAppHelper.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                boolean z4 = !QuickAppHelper.ACTION_START_QUICK_APP.equals(intent.getAction());
                AlphaMeLogger.debugLog(EngineContract.GAME_MODE, "onQuickReceiver action " + intent.getAction() + " isGame " + z4);
                QuickAppHelper.this.onQuickAppStart(intent, z4);
            }
        }
    };

    public interface QuickAppListener {
        void onQuickStart(String str, String str2, String str3);

        void onQuickStop(String str);
    }

    private QuickAppHelper() {
        registerReceivers();
    }

    public static QuickAppHelper getInstance() {
        if (sInstance == null) {
            sInstance = new QuickAppHelper();
        }
        return sInstance;
    }

    public static boolean isQuickApp(String str) {
        return "com.stepos.directservice".equals(str);
    }

    public static boolean isQuickPrefix(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.indexOf(PREFIX_QUICK_APP) == 0 || str.indexOf(PREFIX_QUICK_GAME) == 0;
    }

    private void onAppEvent(String str, String str2, String str3, boolean z4) {
        for (QuickAppListener quickAppListener : this.mListeners) {
            if (z4) {
                quickAppListener.onQuickStart(str, str2, str3);
            } else {
                quickAppListener.onQuickStop(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQuickAppStart(Intent intent, boolean z4) {
        String stringExtra = intent.getStringExtra("EXTRA_PACKAGE");
        String stringExtra2 = intent.getStringExtra(EXTRA_NAME);
        String stringExtra3 = intent.getStringExtra(EXTRA_ACTIVITY);
        this.mLastPrefixQuickAppPkg = g.r(new StringBuilder(), z4 ? PREFIX_QUICK_GAME : PREFIX_QUICK_APP, stringExtra);
        this.mLastQuickAppActivity = stringExtra3;
        this.mLastQuickAppRealPkg = stringExtra;
        this.mLastQuickAppName = stringExtra2;
        StringBuilder sbX = g.x("onQuickAppStart ", stringExtra, ", ", stringExtra2, ", ");
        sbX.append(stringExtra3);
        AlphaMeLogger.debugILog(EngineContract.GAME_MODE, sbX.toString());
        onAppEvent(this.mLastPrefixQuickAppPkg, stringExtra, stringExtra2, true);
    }

    private void registerReceivers() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_START_QUICK_GAME);
        intentFilter.addAction(ACTION_START_QUICK_APP);
        ReceiverUtils.registerReceiverExported(ApplicationImpl.getApplication(), this.mQuickAppReceiver, intentFilter);
    }

    public void addQuickStartListener(QuickAppListener quickAppListener) {
        if (quickAppListener != null) {
            this.mListeners.add(quickAppListener);
        }
    }

    public void appPaused(String str, String str2) {
        AlphaMeLogger.debugLog(EngineContract.GAME_MODE, " quick app Paused pkgName " + str + " activity " + str2);
        if (!TextUtils.isEmpty(this.mLastPrefixQuickAppPkg) && isQuickApp(str) && TextUtils.equals(this.mLastQuickAppActivity, str2)) {
            onAppEvent(this.mLastPrefixQuickAppPkg, this.mLastQuickAppRealPkg, this.mLastQuickAppName, false);
            this.mLastPrefixQuickAppPkg = null;
            this.mLastQuickAppActivity = null;
        }
    }

    public boolean isGame(String str) {
        return !TextUtils.isEmpty(str) && str.indexOf(PREFIX_QUICK_GAME) == 0;
    }

    public void removeQuickStartListener(QuickAppListener quickAppListener) {
        if (quickAppListener == null || !this.mListeners.contains(quickAppListener)) {
            return;
        }
        this.mListeners.remove(quickAppListener);
    }

    public void unregisterReceivers() {
        ApplicationImpl.getApplication().unregisterReceiver(this.mQuickAppReceiver);
    }
}
