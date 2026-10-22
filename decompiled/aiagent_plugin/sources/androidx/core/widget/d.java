package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ImageViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: compiled from: ImageViewCompat.java */
    static class a {
        static ColorStateList a(ImageView r0) {
            return r0.getImageTintList();
        }

        static void a(ImageView r0, ColorStateList r1) {
            r0.setImageTintList(r1);
        }

        static PorterDuff.Mode b(ImageView r0) {
            return r0.getImageTintMode();
        }

        static void a(ImageView r0, PorterDuff.Mode r1) {
            r0.setImageTintMode(r1);
        }
    }

    public static ColorStateList a(ImageView r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return a.a(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, l.class) == true) goto L11;
        return null;
    L11:
        return ((l) ZeusTransformUtils.preCheckCast(r2, l.class, "com.obric.aiagent.plugin")).getSupportImageTintList();
    }

    public static void a(ImageView r2, ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L15;
        a.a(r2, r3);
        if (Build.VERSION.SDK_INT != 21) goto L18;
        Drawable r4 = r2.getDrawable();
        if (r4 != null) goto L9;
        return;
    L9:
        if (a.a(r2) != null) goto L11;
        return;
    L11:
        if (r4.isStateful() == false) goto L13;
        r4.setState(r2.getDrawableState());
    L13:
        r2.setImageDrawable(r4);
        return;
    L18:
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, l.class) == false) goto L22;
        ((l) ZeusTransformUtils.preCheckCast(r2, l.class, "com.obric.aiagent.plugin")).setSupportImageTintList(r3);
        return;
    }

    public static PorterDuff.Mode b(ImageView r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return a.b(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, l.class) == true) goto L11;
        return null;
    L11:
        return ((l) ZeusTransformUtils.preCheckCast(r2, l.class, "com.obric.aiagent.plugin")).getSupportImageTintMode();
    }

    public static void a(ImageView r2, PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L15;
        a.a(r2, r3);
        if (Build.VERSION.SDK_INT != 21) goto L18;
        Drawable r4 = r2.getDrawable();
        if (r4 != null) goto L9;
        return;
    L9:
        if (a.a(r2) != null) goto L11;
        return;
    L11:
        if (r4.isStateful() == false) goto L13;
        r4.setState(r2.getDrawableState());
    L13:
        r2.setImageDrawable(r4);
        return;
    L18:
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, l.class) == false) goto L22;
        ((l) ZeusTransformUtils.preCheckCast(r2, l.class, "com.obric.aiagent.plugin")).setSupportImageTintMode(r3);
        return;
    }
}
