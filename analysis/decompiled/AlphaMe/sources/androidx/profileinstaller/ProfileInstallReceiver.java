package androidx.profileinstaller;

import Z2.I;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import d.C0527a;
import g0.AbstractC0565e;
import g0.RunnableC0561a;
import java.io.File;
import l.ExecutorC0743a;

/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) throws Throwable {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            AbstractC0565e.o(context, new ExecutorC0743a(2), new C0527a(28, this), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        C0527a c0527a = new C0527a(28, this);
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        new RunnableC0561a(c0527a, 11, null, 1).run();
                        return;
                    }
                    return;
                }
                C0527a c0527a2 = new C0527a(28, this);
                try {
                    AbstractC0565e.d(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    new RunnableC0561a(c0527a2, 10, null, 1).run();
                    return;
                } catch (PackageManager.NameNotFoundException e4) {
                    new RunnableC0561a(c0527a2, 7, e4, 1).run();
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            Process.sendSignal(Process.myPid(), 10);
            Log.d("ProfileInstaller", "");
            setResultCode(12);
        } else {
            if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
                return;
            }
            String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
            C0527a c0527a3 = new C0527a(28, this);
            if (!"DROP_SHADER_CACHE".equals(string2)) {
                c0527a3.j(16, null);
            } else if (I.h(context.createDeviceProtectedStorageContext().getCodeCacheDir())) {
                c0527a3.j(14, null);
            } else {
                c0527a3.j(15, null);
            }
        }
    }
}
