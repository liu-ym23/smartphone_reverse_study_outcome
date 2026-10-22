package androidx.core.view;

import android.view.DisplayCutout;

/* renamed from: androidx.core.view.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1320h {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f13200a;

    /* renamed from: androidx.core.view.h$a */
    public static class a {
        public static int a(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        public static int b(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        public static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        public static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    public C1320h(DisplayCutout displayCutout) {
        this.f13200a = displayCutout;
    }

    public static C1320h e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new C1320h(displayCutout);
    }

    public int a() {
        return a.a(this.f13200a);
    }

    public int b() {
        return a.b(this.f13200a);
    }

    public int c() {
        return a.c(this.f13200a);
    }

    public int d() {
        return a.d(this.f13200a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1320h.class != obj.getClass()) {
            return false;
        }
        return B0.c.a(this.f13200a, ((C1320h) obj).f13200a);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f13200a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f13200a + "}";
    }
}
