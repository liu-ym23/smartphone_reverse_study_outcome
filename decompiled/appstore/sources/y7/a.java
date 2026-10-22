package y7;

import android.app.Application;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.appstore.analytics.SysAppAutoUpdateAnalyticsImpl;
import com.smt.obric.appstore.domain.analytics.autoupdate.SysAppAutoUpdateAnalytics;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.smt.obric.appstore.domain.app.db.AppBD;
import com.smt.obric.appstore.domain.sysapp.autoupdate.SysAppAutoUpdateWhitelistManager;
import kotlin.Unit;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.x1;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26131a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f26132b = null;

    static {
        f26131a = new a();
        f26132b = d0.a(x1.b(null, 1, null).plus(l0.c().e()));
    }

    public a() {
    }

    public static final void a(Application r10) {
        q.g(r10, ServerElements.APP);
        AppBD.a r11 = AppBD.f17955p;
        AppBD r12 = r11.a(r10);
        r11.c(r12);
        SysAppAutoUpdateAnalytics.Companion.b(SysAppAutoUpdateAnalyticsImpl.f10521a);
        SysAppAutoUpdateWhitelistManager.f18107a.c(r10);
        AppInstallActor.Companion r13 = AppInstallActor.f17891n;
        r13.d(r13.c(f26132b, r10, r12.F()));
        r13.a().complete(Unit.f21064a);
    }
}
