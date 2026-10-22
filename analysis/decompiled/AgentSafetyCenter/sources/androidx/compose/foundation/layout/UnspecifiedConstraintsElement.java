package androidx.compose.foundation.layout;

import o2.f;
import u1.y0;
import w.w0;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class UnspecifiedConstraintsElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public float f895c;

    /* renamed from: f, reason: collision with root package name */
    public float f896f;

    public final boolean equals(Object obj) {
        if (!(obj instanceof UnspecifiedConstraintsElement)) {
            return false;
        }
        UnspecifiedConstraintsElement unspecifiedConstraintsElement = (UnspecifiedConstraintsElement) obj;
        return f.b(this.f895c, unspecifiedConstraintsElement.f895c) && f.b(this.f896f, unspecifiedConstraintsElement.f896f);
    }

    @Override // u1.y0
    public final l g() {
        float f5 = this.f895c;
        float f10 = this.f896f;
        w0 w0Var = new w0();
        w0Var.f15060s = f5;
        w0Var.f15061t = f10;
        return w0Var;
    }

    public final int hashCode() {
        return Float.hashCode(this.f896f) + (Float.hashCode(this.f895c) * 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        w0 w0Var = (w0) lVar;
        w0Var.f15060s = this.f895c;
        w0Var.f15061t = this.f896f;
    }
}
