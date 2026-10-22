package k8;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.s0;
import com.stepos.agentsafetycenter.MainActivity;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.c1;
import kc.e0;
import m8.k0;
import s8.g1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements androidx.lifecycle.v {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Context f7323c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ k0 f7324f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ c1 f7325g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ AtomicBoolean f7326h;
    public /* synthetic */ c1 i;

    @Override // androidx.lifecycle.v
    public final void e(androidx.lifecycle.x xVar, androidx.lifecycle.o oVar) {
        Context context = this.f7323c;
        k0 k0Var = this.f7324f;
        c1 c1Var = this.f7325g;
        AtomicBoolean atomicBoolean = this.f7326h;
        c1 c1Var2 = this.i;
        int i = MainActivity.f2491h;
        if (oVar != androidx.lifecycle.o.ON_RESUME) {
            return;
        }
        boolean zA = g1.A(context);
        nb.c cVar = null;
        if (!((Boolean) c1Var2.getValue()).booleanValue() && zA) {
            c1Var2.setValue(Boolean.TRUE);
            Application application = k0Var.f1355b;
            application.getClass();
            if (g1.A(application)) {
                kc.w.u(s0.h(k0Var), null, null, new m8.d(5, k0Var, cVar), 3);
            }
        }
        if ((c1Var.getValue() instanceof x) && !atomicBoolean.getAndSet(false)) {
            j4.a aVarH = s0.h(k0Var);
            rc.e eVar = e0.f7430a;
            kc.w.u(aVarH, rc.d.f10552f, null, new m8.d(4, k0Var, cVar), 2);
            k0Var.Q(null, false);
        }
    }
}
