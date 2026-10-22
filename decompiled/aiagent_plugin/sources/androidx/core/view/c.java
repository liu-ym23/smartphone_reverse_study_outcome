package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: DisplayCutoutCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DisplayCutout f1500a;

    /* JADX INFO: compiled from: DisplayCutoutCompat.java */
    static class a {
        static DisplayCutout a(Rect r2, List<Rect> r3) {
            return new DisplayCutout(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        static int a(DisplayCutout r0) {
            return r0.getSafeInsetTop();
        }

        static int b(DisplayCutout r0) {
            return r0.getSafeInsetBottom();
        }

        static int c(DisplayCutout r0) {
            return r0.getSafeInsetLeft();
        }

        static int d(DisplayCutout r0) {
            return r0.getSafeInsetRight();
        }

        static List<Rect> e(DisplayCutout r0) {
            return r0.getBoundingRects();
        }
    }

    private c(DisplayCutout r1) {
        this.f1500a = r1;
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return a.a(this.f1500a);
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return a.b(this.f1500a);
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return a.c(this.f1500a);
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return a.d(this.f1500a);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() != r3.getClass()) goto L13;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
        return androidx.core.util.d.a(this.f1500a, r4.f1500a);
    L13:
        return false;
    }

    public int hashCode() {
        DisplayCutout r0 = this.f1500a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f1500a + "}";
    }

    static c a(DisplayCutout r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return new c(r1);
    }
}
