package androidx.core.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    public static class a {
        @DoNotInline
        public static void a(EdgeEffect r10, float r11, float r12) {
            r10.onPull(r11, r12);
        }
    }

    public static class b {
        @DoNotInline
        public static EdgeEffect a(Context r10, AttributeSet r11) {
            return new EdgeEffect(r10, r11);
        L5:
            return new EdgeEffect(r10);
        }

        @DoNotInline
        public static float b(EdgeEffect r10) {
            return r10.getDistance();
        L4:
            return 0.0f;
        }

        @DoNotInline
        public static float c(EdgeEffect r10, float r11, float r12) {
            return r10.onPullDistance(r11, r12);
        L4:
            r10.onPull(r11, r12);
            return 0.0f;
        }
    }

    public static EdgeEffect a(Context r10, AttributeSet r11) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return b.a(r10, r11);
    L7:
        return new EdgeEffect(r10);
    }

    public static float b(EdgeEffect r10) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return 0.0f;
    L5:
        return b.b(r10);
    }

    public static void c(EdgeEffect r10, float r11, float r12) {
        a.a(r10, r11, r12);
    }

    public static float d(EdgeEffect r10, float r11, float r12) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        c(r10, r11, r12);
        return r11;
    L5:
        return b.c(r10, r11, r12);
    }
}
