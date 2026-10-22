package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f9641e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f9642a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9643b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9644c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9645d;

    static class a {
        static Insets a(int i5, int i6, int i7, int i8) {
            return Insets.of(i5, i6, i7, i8);
        }
    }

    private b(int i5, int i6, int i7, int i8) {
        this.f9642a = i5;
        this.f9643b = i6;
        this.f9644c = i7;
        this.f9645d = i8;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f9642a, bVar2.f9642a), Math.max(bVar.f9643b, bVar2.f9643b), Math.max(bVar.f9644c, bVar2.f9644c), Math.max(bVar.f9645d, bVar2.f9645d));
    }

    public static b b(int i5, int i6, int i7, int i8) {
        return (i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) ? f9641e : new b(i5, i6, i7, i8);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f9642a, this.f9643b, this.f9644c, this.f9645d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f9645d == bVar.f9645d && this.f9642a == bVar.f9642a && this.f9644c == bVar.f9644c && this.f9643b == bVar.f9643b;
    }

    public int hashCode() {
        return (((((this.f9642a * 31) + this.f9643b) * 31) + this.f9644c) * 31) + this.f9645d;
    }

    public String toString() {
        return "Insets{left=" + this.f9642a + ", top=" + this.f9643b + ", right=" + this.f9644c + ", bottom=" + this.f9645d + '}';
    }
}
