package r1;

import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s0;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.g;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final s0 f11685a;

    /* renamed from: b, reason: collision with root package name */
    public final r0.b f11686b;

    /* renamed from: c, reason: collision with root package name */
    public final q1.a f11687c;

    /* renamed from: d, reason: collision with root package name */
    public final y f11688d;

    public b(s0 store, r0.b bVar, q1.a defaultExtras) {
        g.f(store, "store");
        g.f(defaultExtras, "defaultExtras");
        this.f11685a = store;
        this.f11686b = bVar;
        this.f11687c = defaultExtras;
        this.f11688d = new y();
    }

    public final q0 a(c cVar, String key) {
        q0 viewModel;
        q0 q0VarA;
        g.f(key, "key");
        synchronized (this.f11688d) {
            try {
                s0 s0Var = this.f11685a;
                s0Var.getClass();
                viewModel = (q0) s0Var.f2318a.get(key);
                if (cVar.b(viewModel)) {
                    Object obj = this.f11686b;
                    if (obj instanceof r0.d) {
                        g.c(viewModel);
                        ((r0.d) obj).d(viewModel);
                    }
                    g.d(viewModel, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.internal.ViewModelProviderImpl.getViewModel");
                } else {
                    q1.b bVar = new q1.b(this.f11687c);
                    bVar.f11486a.put(r0.f2303a, key);
                    r0.b bVar2 = this.f11686b;
                    try {
                        try {
                            q0VarA = bVar2.b(cVar, bVar);
                        } catch (AbstractMethodError unused) {
                            q0VarA = bVar2.c(xb.a.e(cVar), bVar);
                        }
                    } catch (AbstractMethodError unused2) {
                        q0VarA = bVar2.a(xb.a.e(cVar));
                    }
                    viewModel = q0VarA;
                    s0 s0Var2 = this.f11685a;
                    s0Var2.getClass();
                    g.f(viewModel, "viewModel");
                    q0 q0Var = (q0) s0Var2.f2318a.put(key, viewModel);
                    if (q0Var != null) {
                        q0Var.a();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return viewModel;
    }
}
