package n3;

import android.view.WindowInsets;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class e1 extends d1 {

    /* renamed from: o, reason: collision with root package name */
    public f3.b f8709o;

    /* renamed from: p, reason: collision with root package name */
    public f3.b f8710p;

    /* renamed from: q, reason: collision with root package name */
    public f3.b f8711q;

    public e1(m1 m1Var, WindowInsets windowInsets) {
        super(m1Var, windowInsets);
        this.f8709o = null;
        this.f8710p = null;
        this.f8711q = null;
    }

    @Override // n3.j1
    public f3.b k() {
        if (this.f8710p == null) {
            this.f8710p = f3.b.b(this.f8687c.getMandatorySystemGestureInsets());
        }
        return this.f8710p;
    }

    @Override // n3.j1
    public f3.b m() {
        if (this.f8709o == null) {
            this.f8709o = f3.b.b(this.f8687c.getSystemGestureInsets());
        }
        return this.f8709o;
    }

    @Override // n3.j1
    public f3.b o() {
        if (this.f8711q == null) {
            this.f8711q = f3.b.b(this.f8687c.getTappableElementInsets());
        }
        return this.f8711q;
    }

    @Override // n3.b1, n3.j1
    public m1 r(int i, int i3, int i10, int i11) {
        return m1.h(null, this.f8687c.inset(i, i3, i10, i11));
    }

    public e1(m1 m1Var, e1 e1Var) {
        super(m1Var, e1Var);
        this.f8709o = null;
        this.f8710p = null;
        this.f8711q = null;
    }
}
