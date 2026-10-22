package androidx.core.view;

import android.graphics.Rect;
import android.view.DisplayCutout;
import java.util.List;

/* renamed from: androidx.core.view.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0462g {

    /* renamed from: a, reason: collision with root package name */
    private final DisplayCutout f9813a;

    /* renamed from: androidx.core.view.g$a */
    static class a {
        static DisplayCutout a(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        static List<Rect> b(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        static int e(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        static int f(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    private C0462g(DisplayCutout displayCutout) {
        this.f9813a = displayCutout;
    }

    static C0462g e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new C0462g(displayCutout);
    }

    public int a() {
        return a.c(this.f9813a);
    }

    public int b() {
        return a.d(this.f9813a);
    }

    public int c() {
        return a.e(this.f9813a);
    }

    public int d() {
        return a.f(this.f9813a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0462g.class != obj.getClass()) {
            return false;
        }
        return D.c.a(this.f9813a, ((C0462g) obj).f9813a);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f9813a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f9813a + "}";
    }
}
