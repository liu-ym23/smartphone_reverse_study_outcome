package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: DrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String TAG = "DrawableCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f1204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f1206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1207d;

    /* JADX INFO: renamed from: androidx.core.graphics.drawable.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DrawableCompat.java */
    static class C0028a {
        static void a(Drawable r0, boolean r1) {
            r0.setAutoMirrored(r1);
        }

        static boolean a(Drawable r0) {
            return r0.isAutoMirrored();
        }

        static int b(Drawable r0) {
            return r0.getAlpha();
        }

        static Drawable a(DrawableContainer.DrawableContainerState r0, int r1) {
            return r0.getChild(r1);
        }

        static Drawable a(InsetDrawable r0) {
            return r0.getDrawable();
        }
    }

    /* JADX INFO: compiled from: DrawableCompat.java */
    static class b {
        static void a(Drawable r0, float r1, float r2) {
            r0.setHotspot(r1, r2);
        }

        static void a(Drawable r0, int r1) {
            r0.setTint(r1);
        }

        static void a(Drawable r0, ColorStateList r1) {
            r0.setTintList(r1);
        }

        static void a(Drawable r0, PorterDuff.Mode r1) {
            r0.setTintMode(r1);
        }

        static void a(Drawable r0, Resources.Theme r1) {
            r0.applyTheme(r1);
        }

        static boolean a(Drawable r0) {
            return r0.canApplyTheme();
        }

        static ColorFilter b(Drawable r0) {
            return r0.getColorFilter();
        }

        static void a(Drawable r2, Resources r3, XmlPullParser r4, AttributeSet r5, Resources.Theme r6) {
            r2.inflate(r3, (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), r6);
        }

        static void a(Drawable r0, int r1, int r2, int r3, int r4) {
            r0.setHotspotBounds(r1, r2, r3, r4);
        }
    }

    /* JADX INFO: compiled from: DrawableCompat.java */
    static class c {
        static boolean a(Drawable r0, int r1) {
            return r0.setLayoutDirection(r1);
        }

        static int a(Drawable r0) {
            return r0.getLayoutDirection();
        }
    }

    @Deprecated
    public static void a(Drawable r0) {
        r0.jumpToCurrentState();
    }

    public static void a(Drawable r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        C0028a.a(r2, r3);
        return;
    }

    public static boolean b(Drawable r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return C0028a.a(r2);
    }

    public static void a(Drawable r2, float r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        b.a(r2, r3, r4);
        return;
    }

    public static void a(Drawable r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        b.a(r2, r3, r4, r5, r6);
        return;
    }

    public static void a(Drawable r2, int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        b.a(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, androidx.core.graphics.drawable.c.class) == false) goto L10;
        ((androidx.core.graphics.drawable.c) ZeusTransformUtils.preCheckCast(r2, androidx.core.graphics.drawable.c.class, "com.obric.aiagent.plugin")).setTint(r3);
        return;
    }

    public static void a(Drawable r2, ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        b.a(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, androidx.core.graphics.drawable.c.class) == false) goto L10;
        ((androidx.core.graphics.drawable.c) ZeusTransformUtils.preCheckCast(r2, androidx.core.graphics.drawable.c.class, "com.obric.aiagent.plugin")).setTintList(r3);
        return;
    }

    public static void a(Drawable r2, PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        b.a(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, androidx.core.graphics.drawable.c.class) == false) goto L10;
        ((androidx.core.graphics.drawable.c) ZeusTransformUtils.preCheckCast(r2, androidx.core.graphics.drawable.c.class, "com.obric.aiagent.plugin")).setTintMode(r3);
        return;
    }

    public static int c(Drawable r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return C0028a.b(r2);
    }

    public static void a(Drawable r2, Resources.Theme r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        b.a(r2, r3);
        return;
    }

    public static boolean d(Drawable r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return b.a(r2);
    }

    public static ColorFilter e(Drawable r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return b.b(r2);
    }

    public static void f(Drawable r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r3.clearColorFilter();
        return;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L23;
        r3.clearColorFilter();
        if (ZeusTransformUtils.instanceOf(r3, InsetDrawable.class) == false) goto L11;
        f(C0028a.a((InsetDrawable) ZeusTransformUtils.preCheckCast(r3, InsetDrawable.class, "com.obric.aiagent.plugin")));
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L14;
        f(((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin")).getWrappedDrawable());
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r3, DrawableContainer.class) == false) goto L31;
        DrawableContainer.DrawableContainerState r4 = (DrawableContainer.DrawableContainerState) ZeusTransformUtils.preCheckCast(((DrawableContainer) ZeusTransformUtils.preCheckCast(r3, DrawableContainer.class, "com.obric.aiagent.plugin")).getConstantState(), DrawableContainer.DrawableContainerState.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L32;
        int r0 = 0;
        int r1 = r4.getChildCount();
    L18:
        if (r0 >= r1) goto L33;
        Drawable r2 = C0028a.a(r4, r0);
        if (r2 == null) goto L22;
        f(r2);
    L22:
        r0 = r0 + 1;
        goto L18
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L23:
        r3.clearColorFilter();
    }

    public static void a(Drawable r2, Resources r3, XmlPullParser r4, AttributeSet r5, Resources.Theme r6) {
        XmlPullParser r7 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L5;
        b.a(r2, r3, r7, r8, r6);
        return;
    L5:
        r2.inflate(r3, r7, r8);
    }

    public static Drawable g(Drawable r2) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return r2;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        if (ZeusTransformUtils.instanceOf(r2, androidx.core.graphics.drawable.c.class) == false) goto L10;
        return r2;
    L10:
        return new WrappedDrawableApi21(r2);
    L13:
        if (ZeusTransformUtils.instanceOf(r2, androidx.core.graphics.drawable.c.class) == false) goto L15;
        return r2;
    L15:
        return new WrappedDrawableApi14(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T h(Drawable r2) {
        if (ZeusTransformUtils.instanceOf(r2, d.class) == true) goto L5;
        return r2;
    L5:
        return (T) ((d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin")).getWrappedDrawable();
    }

    public static boolean b(Drawable r7, int r8) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return c.a(r7, r8);
    L7:
        if (Build.VERSION.SDK_INT >= 17) goto L9;
    L21:
        return false;
    L9:
        if (f1205b == false) goto L22;
    L15:
        Method r0 = f1204a;
        if (r0 == null) goto L21;
        r0.invoke(r7, new Object[]{Integer.valueOf(r8)});     // Catch: Exception -> L19
        return true;
    L19:
        e = move-exception;
        a(TAG, "Failed to invoke setLayoutDirection(int) via reflection", e);
        f1204a = null;
        goto L21
    L22:
        Method r1 = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L12
        f1204a = r1;     // Catch: NoSuchMethodException -> L12
        r1.setAccessible(true);     // Catch: NoSuchMethodException -> L12
    L14:
        f1205b = true;
    L12:
        e = move-exception;
        a(TAG, "Failed to retrieve setLayoutDirection(int) method", e);
        goto L14
    }

    public static int i(Drawable r6) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return c.a(r6);
    L7:
        if (Build.VERSION.SDK_INT >= 17) goto L9;
    L22:
        return 0;
    L9:
        if (f1207d == false) goto L23;
    L16:
        Method r0 = f1206c;
        if (r0 == null) goto L22;
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.invoke(r6, new Object[0]), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L20:
        e = move-exception;
        a(TAG, "Failed to invoke getLayoutDirection() via reflection", e);
        f1206c = null;
        goto L22
    L23:
        Method r3 = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);     // Catch: NoSuchMethodException -> L13
        f1206c = r3;     // Catch: NoSuchMethodException -> L13
        r3.setAccessible(true);     // Catch: NoSuchMethodException -> L13
    L15:
        f1207d = true;
    L13:
        e = move-exception;
        a(TAG, "Failed to retrieve getLayoutDirection() method", e);
        goto L15
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }
}
