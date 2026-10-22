package androidx.transition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: ImageViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2845a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f2846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2847c;

    static {
    }

    static void a(ImageView r4, Matrix r5) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        r4.animateTransform(r5);
        return;
    L6:
        if (r5 != null) goto L11;
        Drawable r6 = r4.getDrawable();
        if (r6 == null) goto L34;
        r6.setBounds(0, 0, (r4.getWidth() - r4.getPaddingLeft()) - r4.getPaddingRight(), (r4.getHeight() - r4.getPaddingTop()) - r4.getPaddingBottom());
        r4.invalidate();
        return;
    L34:
        return;
    L11:
        if (Build.VERSION.SDK_INT < 21) goto L13;
        b(r4, r5);
        return;
    L13:
        Drawable r1 = r4.getDrawable();
        if (r1 == null) goto L37;
        r1.setBounds(0, 0, r1.getIntrinsicWidth(), r1.getIntrinsicHeight());
        Matrix r0 = null;
        a();
        Field r2 = f2846b;
        if (r2 != null) goto L29;
    L23:
        if (r0 == null) goto L25;
        r0.set(r5);
    L25:
        r4.invalidate();
        return;
    L29:
        Matrix r3 = (Matrix) ZeusTransformUtils.preCheckCast(r2.get(r4), Matrix.class, "com.obric.aiagent.plugin");     // Catch: IllegalAccessException -> L28
        if (r3 == null) goto L31;
    L22:
        r0 = r3;
        goto L23
    L31:
        r0 = new Matrix();     // Catch: IllegalAccessException -> L27
        f2846b.set(r4, r0);     // Catch: IllegalAccessException -> L28
        goto L23
    }

    private static void b(ImageView r1, Matrix r2) {
        if (f2845a == false) goto L10;
        r1.animateTransform(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        f2845a = false;
        return;
    }

    private static void a() {
        if (f2847c == false) goto L9;
        return;
    L9:
        Field r1 = ImageView.class.getDeclaredField("mDrawMatrix");     // Catch: NoSuchFieldException -> L8
        f2846b = r1;     // Catch: NoSuchFieldException -> L8
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L6:
        f2847c = true;
    }
}
