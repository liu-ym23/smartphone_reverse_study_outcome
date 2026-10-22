package o1;

import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final j f9016a = new j(kb.s.f7404c, null);

    public static final w0.m a(w0.m mVar, Object obj, xb.p pVar) {
        c0 c0Var = new c0();
        c0Var.f9007c = pVar;
        VarHandle.storeStoreFence();
        return mVar.d(new SuspendPointerInputElement(obj, null, c0Var, 6));
    }
}
