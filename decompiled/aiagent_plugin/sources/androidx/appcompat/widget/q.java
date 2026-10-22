package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: DrawableUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Rect f468a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f469b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f470c = null;

    /* JADX INFO: compiled from: DrawableUtils.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final boolean f471a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Method f472b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Field f473c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Field f474d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Field f475e = null;
        private static final Field f = null;

        static {
            Class r3 = ZeusTransformUtils.forName("android.graphics.Insets", "com.obric.aiagent.plugin");     // Catch: NoSuchFieldException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L20
            Method r4 = Drawable.class.getMethod("getOpticalInsets", new Class[0]);     // Catch: NoSuchFieldException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L20
            Field r5 = r3.getField("left");     // Catch: NoSuchFieldException -> L13 ClassNotFoundException -> L14 NoSuchMethodException -> L15
        L35:
            Field r6 = r3.getField("top");     // Catch: NoSuchFieldException -> L10 ClassNotFoundException -> L11 NoSuchMethodException -> L12
            Field r7 = r3.getField("right");     // Catch: Throwable -> L9
            Field r8 = r3.getField("bottom");     // Catch: Throwable -> L28
            boolean r9 = true;
        L24:
            if (r9 == false) goto L26;
            f472b = r4;
            f473c = r5;
            f474d = r6;
            f475e = r7;
            f = r8;
            f471a = true;
            return;
        L26:
            f472b = null;
            f473c = null;
            f474d = null;
            f475e = null;
            f = null;
            f471a = false;
            return;
        L23:
            r9 = false;
            r8 = null;
        L9:
            r7 = null;
            goto L23
        L11:
            r6 = null;
        L22:
            r7 = r6;
        L10:
            r6 = null;
        L12:
            r6 = null;
        L14:
            r5 = null;
        L19:
            r6 = r5;
        L13:
            r5 = null;
        L17:
            r6 = r5;
        L15:
            r5 = null;
        L21:
            r6 = r5;
            goto L22
        L18:
            r4 = null;
            r5 = null;
        L16:
            r4 = null;
            r5 = null;
        L20:
            r4 = null;
            r5 = null;
            goto L21
        }

        static Rect a(Drawable r5) {
            if (Build.VERSION.SDK_INT >= 29) goto L11;
            if (f471a == false) goto L11;
            Object r6 = f472b.invoke(r5, new Object[0]);     // Catch: Throwable -> L12
            if (r6 == null) goto L11;
            return new Rect(f473c.getInt(r6), f474d.getInt(r6), f475e.getInt(r6), f.getInt(r6));
        L11:
            return q.f468a;
        }
    }

    /* JADX INFO: compiled from: DrawableUtils.java */
    static class b {
        static Insets a(Drawable r0) {
            return r0.getOpticalInsets();
        }
    }

    static {
        f469b = new int[]{R.attr.state_checked};
        f470c = new int[0];
        f468a = new Rect();
    }

    public static Rect a(Drawable r4) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Insets r5 = b.a(r4);
        return new Rect(r5.left, r5.top, r5.right, r5.bottom);
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L11;
        return a.a(androidx.core.graphics.drawable.a.h(r4));
    L11:
        return f468a;
    }

    static void b(Drawable r3) {
        String r0 = r3.getClass().getName();
        if (Build.VERSION.SDK_INT != 21) goto L8;
        if ("android.graphics.drawable.VectorDrawable".equals(r0) == false) goto L8;
        d(r3);
        return;
    L8:
        if (Build.VERSION.SDK_INT >= 29) goto L10;
        return;
    L10:
        if (Build.VERSION.SDK_INT < 31) goto L12;
        return;
    L12:
        if ("android.graphics.drawable.ColorStateListDrawable".equals(r0) == false) goto L18;
        d(r3);
        return;
    }

    public static boolean c(Drawable r5) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT >= 15) goto L11;
        if (ZeusTransformUtils.instanceOf(r5, InsetDrawable.class) == false) goto L11;
        return false;
    L11:
        if (Build.VERSION.SDK_INT >= 15) goto L16;
        if (ZeusTransformUtils.instanceOf(r5, GradientDrawable.class) == false) goto L16;
        return false;
    L16:
        if (Build.VERSION.SDK_INT >= 17) goto L21;
        if (ZeusTransformUtils.instanceOf(r5, LayerDrawable.class) == false) goto L21;
        return false;
    L21:
        if (ZeusTransformUtils.instanceOf(r5, DrawableContainer.class) == false) goto L31;
        Drawable.ConstantState r6 = r5.getConstantState();
        if (ZeusTransformUtils.instanceOf(r6, DrawableContainer.DrawableContainerState.class) == false) goto L42;
        Drawable[] r7 = ((DrawableContainer.DrawableContainerState) ZeusTransformUtils.preCheckCast(r6, DrawableContainer.DrawableContainerState.class, "com.obric.aiagent.plugin")).getChildren();
        int r0 = r7.length;
        int r1 = 0;
    L25:
        if (r1 >= r0) goto L42;
        if (c(r7[r1]) == false) goto L28;
        r1 = r1 + 1;
        goto L25
    L28:
        return false;
    L42:
        return true;
    L31:
        if (ZeusTransformUtils.instanceOf(r5, androidx.core.graphics.drawable.d.class) == false) goto L35;
        return c(((androidx.core.graphics.drawable.d) ZeusTransformUtils.preCheckCast(r5, androidx.core.graphics.drawable.d.class, "com.obric.aiagent.plugin")).getWrappedDrawable());
    L35:
        if (ZeusTransformUtils.instanceOf(r5, DrawableWrapperCompat.class) == false) goto L39;
        return c(((DrawableWrapperCompat) ZeusTransformUtils.preCheckCast(r5, DrawableWrapperCompat.class, "com.obric.aiagent.plugin")).getDrawable());
    L39:
        if (ZeusTransformUtils.instanceOf(r5, ScaleDrawable.class) == false) goto L42;
        return c(((ScaleDrawable) ZeusTransformUtils.preCheckCast(r5, ScaleDrawable.class, "com.obric.aiagent.plugin")).getDrawable());
    }

    private static void d(Drawable r2) {
        int[] r0 = r2.getState();
        if (r0 != null) goto L5;
    L8:
        r2.setState(f469b);
    L9:
        r2.setState(r0);
        return;
    L5:
        if (r0.length == 0) goto L8;
        r2.setState(f470c);
        goto L9
    }

    public static PorterDuff.Mode a(int r1, PorterDuff.Mode r2) {
        if (r1 == 3) goto L21;
        if (r1 == 5) goto L19;
        if (r1 == 9) goto L17;
        switch(r1) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r2;
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
