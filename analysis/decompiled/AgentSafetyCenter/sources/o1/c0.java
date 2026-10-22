package o1;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c0 implements PointerInputEventHandler, yb.g {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ xb.p f9007c;

    @Override // yb.g
    public final jb.b a() {
        return this.f9007c;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof PointerInputEventHandler) && (obj instanceof yb.g)) {
            return yb.k.a(this.f9007c, ((yb.g) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f9007c.hashCode();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final /* synthetic */ Object invoke(w wVar, nb.c cVar) {
        return this.f9007c.invoke(wVar, cVar);
    }
}
