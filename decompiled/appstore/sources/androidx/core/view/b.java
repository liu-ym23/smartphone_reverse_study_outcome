package androidx.core.view;

import android.graphics.Rect;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayCutout f2767a;

    public static class a {
        @DoNotInline
        public static DisplayCutout a(Rect r10, List<Rect> r11) {
            return new DisplayCutout(r10, r11);
        }

        @DoNotInline
        public static List<Rect> b(DisplayCutout r10) {
            return r10.getBoundingRects();
        }

        @DoNotInline
        public static int c(DisplayCutout r10) {
            return r10.getSafeInsetBottom();
        }

        @DoNotInline
        public static int d(DisplayCutout r10) {
            return r10.getSafeInsetLeft();
        }

        @DoNotInline
        public static int e(DisplayCutout r10) {
            return r10.getSafeInsetRight();
        }

        @DoNotInline
        public static int f(DisplayCutout r10) {
            return r10.getSafeInsetTop();
        }
    }

    public b(DisplayCutout r10) {
        this.f2767a = r10;
    }

    public static b e(DisplayCutout r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return new b(r10);
    }

    public int a() {
        return a.c(this.f2767a);
    }

    public int b() {
        return a.d(this.f2767a);
    }

    public int c() {
        return a.e(this.f2767a);
    }

    public int d() {
        return a.f(this.f2767a);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        return false;
    L7:
        if (b.class == r10.getClass()) goto L10;
        return false;
    L10:
        return androidx.core.util.b.a(this.f2767a, ((b) r10).f2767a);
    }

    public int hashCode() {
        DisplayCutout r10 = this.f2767a;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f2767a + "}";
    }
}
