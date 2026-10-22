package com.stepos.alphame.scene;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.reflect.UserHandle;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class AppInstallReceiver extends BroadcastReceiver {
    public static final int ACTION_ADDED = 0;
    public static final int ACTION_REMOVED = 1;
    public static final int ACTION_REPLACED = 2;
    private static List<OnAppInsatllChangeListener> mListeners = new CopyOnWriteArrayList();
    private static final Handler ALPHAME_HANDLER = new Handler(ApplicationImpl.getAlphaMeLooper());

    public static abstract class OnAppInsatllChangeListener {
        public abstract void onChanged(String str, int i4, int i5);
    }

    public static void addListener(OnAppInsatllChangeListener onAppInsatllChangeListener) {
        mListeners.add(onAppInsatllChangeListener);
    }

    private void onChanged(String str, int i4, int i5) {
        AlphaMeLogger.dLog("AppInstallReceiver pkgName = " + str + ", action = " + i4);
        for (OnAppInsatllChangeListener onAppInsatllChangeListener : mListeners) {
            if (onAppInsatllChangeListener != null) {
                onAppInsatllChangeListener.onChanged(str, i4, i5);
            }
        }
    }

    private void onPackageReplaced(final String str) {
        ALPHAME_HANDLER.postDelayed(new Runnable() { // from class: com.stepos.alphame.scene.AppInstallReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                AppInstallReceiver.this.wakeupPackage(str);
            }
        }, 5000L);
    }

    public static void removeListener(OnAppInsatllChangeListener onAppInsatllChangeListener) {
        mListeners.remove(onAppInsatllChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wakeupPackage(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        AlphaMeLogger.iLog("wakeupPackage: ".concat(str));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        String schemeSpecificPart;
        int intExtra;
        if (intent == null) {
            AlphaMeLogger.dLog("AppInstallReceiver onReceive intent is null");
            return;
        }
        if (PerfBinderHelper.ACTION_PACKAGE_CHANGED_FORWARD.equals(intent.getAction())) {
            action = intent.getStringExtra(PerfBinderHelper.EXTRA_ORIG_ACTION);
            schemeSpecificPart = intent.getStringExtra(PerfBinderHelper.EXTRA_PACKAGE);
            intExtra = intent.getIntExtra("android.intent.extra.UID", -1);
        } else if (intent.getData() == null) {
            AlphaMeLogger.dLog("AppInstallReceiver onReceive data is null");
            return;
        } else {
            action = intent.getAction();
            schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            intExtra = intent.getIntExtra("android.intent.extra.UID", -1);
        }
        if (action == null || schemeSpecificPart == null) {
            AlphaMeLogger.dLog("AppInstallReceiver missing action/package");
            return;
        }
        AlphaMeLogger.dLog("AppInstallReceiver onReceive action=" + action + ", pkg=" + schemeSpecificPart);
        int userId = intExtra == -1 ? 0 : UserHandle.getUserId(intExtra);
        if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            onChanged(schemeSpecificPart, 0, userId);
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
            onChanged(schemeSpecificPart, 1, userId);
        }
        if ("android.intent.action.PACKAGE_REPLACED".equals(action)) {
            onChanged(schemeSpecificPart, 2, userId);
            onPackageReplaced(schemeSpecificPart);
        }
    }
}
