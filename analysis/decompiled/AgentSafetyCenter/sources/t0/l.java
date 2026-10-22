package t0;

import java.lang.invoke.VarHandle;
import p5.u;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final u f13125a = a(new k8.d(23), new d(1));

    public static final u a(p pVar, xb.l lVar) {
        u uVar = new u(10);
        uVar.f9807f = pVar;
        uVar.f9808g = lVar;
        VarHandle.storeStoreFence();
        return uVar;
    }
}
