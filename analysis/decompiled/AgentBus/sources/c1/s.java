package c1;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;

/* loaded from: classes.dex */
public final /* synthetic */ class s implements PointerInputEventHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i7.i f1839a;

    /* JADX WARN: Multi-variable type inference failed */
    public s(p7.n nVar) {
        this.f1839a = (i7.i) nVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PointerInputEventHandler) || !(obj instanceof s)) {
            return false;
        }
        return this.f1839a.equals(((s) obj).f1839a);
    }

    public final int hashCode() {
        return this.f1839a.hashCode();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [i7.i, p7.n] */
    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final /* synthetic */ Object invoke(q qVar, g7.d dVar) {
        return this.f1839a.invoke(qVar, dVar);
    }
}
