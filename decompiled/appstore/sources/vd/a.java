package vd;

import android.view.DisplayCutout;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f25225a;

    public a(Object r10) {
        this.f25225a = r10;
    }

    public static a e(Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return new a(r10);
    }

    public int a() {
        return ((DisplayCutout) this.f25225a).getSafeInsetBottom();
    }

    public int b() {
        return ((DisplayCutout) this.f25225a).getSafeInsetLeft();
    }

    public int c() {
        return ((DisplayCutout) this.f25225a).getSafeInsetRight();
    }

    public int d() {
        return ((DisplayCutout) this.f25225a).getSafeInsetTop();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        return false;
    L7:
        if (a.class == r10.getClass()) goto L10;
        return false;
    L10:
        return androidx.core.util.b.a(this.f25225a, ((a) r10).f25225a);
    }

    public int hashCode() {
        Object r10 = this.f25225a;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f25225a + "}";
    }
}
