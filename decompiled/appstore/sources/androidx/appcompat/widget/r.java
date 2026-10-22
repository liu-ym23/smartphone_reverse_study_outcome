package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f1085a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1086b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Rect f1087c = null;

    public static class a {
        @DoNotInline
        public static Insets a(Drawable r10) {
            return r10.getOpticalInsets();
        }
    }

    static {
        f1085a = new int[]{R.attr.state_checked};
        f1086b = new int[0];
        f1087c = new Rect();
    }

    public static boolean a(Drawable r10) {
        return true;
    }

    public static void b(Drawable r10) {
        String r11 = r10.getClass().getName();
        if (Build.VERSION.SDK_INT < 31) goto L5;
        return;
    L5:
        if ("android.graphics.drawable.ColorStateListDrawable".equals(r11) == false) goto L9;
        c(r10);
        return;
    }

    public static void c(Drawable r10) {
        int[] r11 = r10.getState();
        if (r11 != null) goto L5;
    L8:
        r10.setState(f1085a);
    L9:
        r10.setState(r11);
        return;
    L5:
        if (r11.length == 0) goto L8;
        r10.setState(f1086b);
        goto L9
    }

    public static Rect d(Drawable r10) {
        Insets r11 = a.a(r10);
        return new Rect(r11.left, r11.top, r11.right, r11.bottom);
    }

    public static PorterDuff.Mode e(int r10, PorterDuff.Mode r11) {
        if (r10 == 3) goto L21;
        if (r10 == 5) goto L19;
        if (r10 == 9) goto L17;
        switch(r10) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r11;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }
}
