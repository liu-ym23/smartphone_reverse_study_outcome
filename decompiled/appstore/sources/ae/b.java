package ae;

import android.graphics.Rect;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f95a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f96b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f97c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f98d;

    public b(int r10, int r11, int r12, int r13) {
        this.f95a = r10;
        this.f96b = r11;
        this.f97c = r12;
        this.f98d = r13;
    }

    public final Rect a() {
        return new Rect(this.f95a, this.f96b, this.f97c, this.f98d);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        Class<?> r11 = null;
    L9:
        if (q.b(b.class, r11) == true) goto L11;
        return false;
    L11:
        if (r10 == null) goto L26;
        b r12 = (b) r10;
        if (this.f95a == r12.f95a) goto L16;
        return false;
    L16:
        if (this.f96b == r12.f96b) goto L19;
        return false;
    L19:
        if (this.f97c == r12.f97c) goto L22;
        return false;
    L22:
        if (this.f98d == r12.f98d) goto L24;
        return false;
    L24:
        return true;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.window.model.Bounds");
    L7:
        r11 = r10.getClass();
        goto L9
    }

    public int hashCode() {
        return (((((this.f95a * 31) + this.f96b) * 31) + this.f97c) * 31) + this.f98d;
    }

    public String toString() {
        return b.class.getSimpleName() + " { [" + this.f95a + ',' + this.f96b + ',' + this.f97c + ',' + this.f98d + "] }";
    }

    public b(Rect r10) {
        q.g(r10, "rect");
        this(r10.left, r10.top, r10.right, r10.bottom);
    }
}
