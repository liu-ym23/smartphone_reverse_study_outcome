package com.smt.obric.appstore.domain.sysapp.autoupdate;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.channels.b;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes4.dex */
public final class SysAppAutoUpdateWhitelistManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SysAppAutoUpdateWhitelistManager f18107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Job f18108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f18109c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f18110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Context f18111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static SysAppAutoUpdateWhitelistRepository f18112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final SendChannel f18113g = null;

    static {
        f18107a = new SysAppAutoUpdateWhitelistManager();
        CoroutineScope r10 = d0.a(l0.b());
        f18109c = r10;
        f18113g = b.b(r10, l0.b(), -1, null, null, new SysAppAutoUpdateWhitelistManager$syncActor$1(null), 12, null);
    }

    public SysAppAutoUpdateWhitelistManager() {
    }

    public static final /* synthetic */ SysAppAutoUpdateWhitelistRepository a() {
        return f18112f;
    }

    public static final /* synthetic */ void b(SysAppAutoUpdateWhitelistManager r10) {
        r10.d();
    }

    public final void c(Context r10) {
        q.g(r10, "context");
        if (f18110d == false) goto L5;
        return;
    L5:
        f18110d = true;
        Context r11 = r10.getApplicationContext();
        q.f(r11, "getApplicationContext(...)");
        f18111e = r11;
        SysAppAutoUpdateWhitelistRepository.a r12 = SysAppAutoUpdateWhitelistRepository.f18114c;
        Context r13 = f18111e;
        if (r13 != null) goto L8;
        q.y("appContext");
        r13 = null;
    L8:
        f18112f = r12.a(r13);
        h.d(f18109c, l0.b(), null, new SysAppAutoUpdateWhitelistManager$init$1(null), 2, null);
        d();
        e();
    }

    public final void d() {
        f18113g.mo53trySendJP2dKIU(Unit.f21064a);
    }

    public final void e() {
        Job r10 = f18108b;
        if (r10 == null) goto L5;
        Job.a.b(r10, null, 1, null);
    L5:
        f18108b = h.d(f18109c, null, null, new SysAppAutoUpdateWhitelistManager$startPeriodicSync$1(null), 3, null);
    }
}
