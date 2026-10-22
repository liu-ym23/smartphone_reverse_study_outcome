package com.obric.matrix.platform.sdk.ones.init;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.crash.MatrixCrashConfigBuilder;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsManager;
import com.obric.matrix.platform.sdk.ones.settings.SettingsUpdateListener;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class InitHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InitHelper f11908a = null;

    public static final class a implements SettingsUpdateListener {
        public a() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.settings.SettingsUpdateListener
        public void onSettingsUpdate(String r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.length() == 0) goto L9;
            c.f11924a.b(r10);
            return;
        }
    }

    static {
        f11908a = new InitHelper();
    }

    public InitHelper() {
    }

    public final int a(Application r10) {
        return r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).versionCode;
    L5:
        e = move-exception;
        Log.e("InitHelper", "Failed to get version code", e);
        return 0;
    }

    public final String b(Application r10) {
        String r11 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).versionName;     // Catch: PackageManager.NameNotFoundException -> L7
        if (r11 != null) goto L12;
        return "";
    L12:
        return r11;
    L7:
        e = move-exception;
        Log.e("InitHelper", "Failed to get version name", e);
        return "";
    }

    public final void c(Application r10) {
        c.f11924a.b(MatrixSettingsManager.f11938g.a().h());     // Catch: Exception -> L4
        MatrixCrashConfigBuilder r11 = new MatrixCrashConfigBuilder(r10).h(true).i(true).g(true).d(true).e(true).f(true).j(true).l(true).k(true);     // Catch: Exception -> L4
        String r12 = r10.getPackageName();     // Catch: Exception -> L4
        q.f(r12, "application.packageName");     // Catch: Exception -> L4
        r11.A(r12).a(b(r10)).B(a(r10)).c(InitHelper$initCrashProtect$1.INSTANCE).z(InitHelper$initCrashProtect$2.INSTANCE).b();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        hc.b.c("InitHelper", "initCrashProtect error", e);
    }

    public final void d(Application r10, boolean r11) {
        q.g(r10, "application");
        MatrixSettingsManager.a r12 = MatrixSettingsManager.f11938g;
        if (r12.c() == true) goto L5;
        com.obric.matrix.platform.sdk.ones.settings.a.C0188a r13 = new com.obric.matrix.platform.sdk.ones.settings.a.C0188a();
        String r14 = r10.getPackageName();
        q.f(r14, "application.packageName");
        r12.b(r10, r13.c(r14).d(a(r10)).b(r11).e(b(r10)).a());
    L5:
        r12.a().g(new a());
        c(r10);
    }
}
