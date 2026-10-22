package c4;

import android.text.InputFilter;
import android.text.method.TransformationMethod;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends ac.a {

    /* renamed from: g, reason: collision with root package name */
    public f f2201g;

    @Override // ac.a
    public final boolean B() {
        return this.f2201g.i;
    }

    @Override // ac.a
    public final void S(boolean z10) {
        if (a4.j.c()) {
            this.f2201g.S(z10);
        }
    }

    @Override // ac.a
    public final void T(boolean z10) {
        boolean zC = a4.j.c();
        f fVar = this.f2201g;
        if (zC) {
            fVar.T(z10);
        } else {
            fVar.i = z10;
        }
    }

    @Override // ac.a
    public final TransformationMethod k0(TransformationMethod transformationMethod) {
        return !a4.j.c() ? transformationMethod : this.f2201g.k0(transformationMethod);
    }

    @Override // ac.a
    public final InputFilter[] w(InputFilter[] inputFilterArr) {
        return !a4.j.c() ? inputFilterArr : this.f2201g.w(inputFilterArr);
    }
}
