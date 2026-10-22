package com.stepos.stability;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import com.stepos.pps.reflect.SystemProperties;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ExceptionManager {
    private static final String TAG = "ExceptionManager";

    public ExceptionManager(Context context) throws IllegalAccessException, PackageManager.NameNotFoundException, IllegalArgumentException, InvocationTargetException {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme(ExceptionManagerStepOS.PACKAGE);
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        context.registerReceiver(new BroadcastReceiver(this) { // from class: com.stepos.stability.ExceptionManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) throws IllegalAccessException, PackageManager.NameNotFoundException, IllegalArgumentException, InvocationTargetException {
                ExceptionManager.notifyEmsUpdated(intent.getData().getSchemeSpecificPart(), context2);
            }
        }, intentFilter, 2);
        notifyEmsUpdated("com.stepos.ems", context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyEmsUpdated(String str, Context context) throws IllegalAccessException, PackageManager.NameNotFoundException, IllegalArgumentException, InvocationTargetException {
        if ("com.stepos.ems".equals(str)) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.stepos.ems", 0);
                String str2 = SystemProperties.get("persist.sys.exceptionmanager");
                if (applicationInfo.sourceDir == null || applicationInfo.sourceDir.equals(str2)) {
                    return;
                }
                SystemProperties.set("persist.sys.exceptionmanager", applicationInfo.sourceDir);
            } catch (PackageManager.NameNotFoundException e) {
                Log.d(TAG, e.getMessage());
            }
        }
    }
}
