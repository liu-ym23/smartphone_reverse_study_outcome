package lc;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.obric.oui.common.style.j;
import com.obric.oui.utils.log.L;
import kotlin.jvm.internal.q;
import qb.b;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21930a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f21931b;

    static {
        f21930a = new a();
    }

    public a() {
    }

    public final Application a() {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
    L5:
        e = move-exception;
        L.c("OUISdk", "getApplicationReflect failed", e);
        return null;
    }

    public final void b() {
    L10:
        e = move-exception;
        L.c("OUISdk", "init failed", e);
        return;
    L4:
        if (f21931b == true) goto L12;
        long r10 = System.currentTimeMillis();     // Catch: Exception -> L10
        Application r11 = a();     // Catch: Exception -> L10
        if (r11 == null) goto L9;
        r11.registerComponentCallbacks(this);     // Catch: Exception -> L10
    L9:
        b.f23627c.d();     // Catch: Exception -> L10
        f21931b = true;     // Catch: Exception -> L10
        L.a("OUISdk", "init success, cost: " + (System.currentTimeMillis() - r10) + " ms");     // Catch: Exception -> L10
        return;
    L12:
        L.a("OUISdk", "init already");     // Catch: Exception -> L10
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r10) {
        q.g(r10, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        j.f13077a.a();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r10) {
        j.f13077a.a();
    }
}
