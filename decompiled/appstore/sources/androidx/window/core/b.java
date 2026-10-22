package androidx.window.core;

import android.graphics.Rect;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5237d;

    public b(int r10, int r11, int r12, int r13) {
        this.f5234a = r10;
        this.f5235b = r11;
        this.f5236c = r12;
        this.f5237d = r13;
    }

    public final int a() {
        return this.f5237d - this.f5235b;
    }

    public final int b() {
        return this.f5234a;
    }

    public final int c() {
        return this.f5235b;
    }

    public final int d() {
        return this.f5236c - this.f5234a;
    }

    public final boolean e() {
        if (a() == 0) goto L5;
    L7:
        return false;
    L5:
        if (d() != 0) goto L7;
        return true;
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
        if (this.f5234a == r12.f5234a) goto L16;
        return false;
    L16:
        if (this.f5235b == r12.f5235b) goto L19;
        return false;
    L19:
        if (this.f5236c == r12.f5236c) goto L22;
        return false;
    L22:
        if (this.f5237d == r12.f5237d) goto L24;
        return false;
    L24:
        return true;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type androidx.window.core.Bounds");
    L7:
        r11 = r10.getClass();
        goto L9
    }

    public final Rect f() {
        return new Rect(this.f5234a, this.f5235b, this.f5236c, this.f5237d);
    }

    public int hashCode() {
        return (((((this.f5234a * 31) + this.f5235b) * 31) + this.f5236c) * 31) + this.f5237d;
    }

    public String toString() {
        return b.class.getSimpleName() + " { [" + this.f5234a + ',' + this.f5235b + ',' + this.f5236c + ',' + this.f5237d + "] }";
    }

    public b(Rect r10) {
        q.g(r10, "rect");
        this(r10.left, r10.top, r10.right, r10.bottom);
    }
}
