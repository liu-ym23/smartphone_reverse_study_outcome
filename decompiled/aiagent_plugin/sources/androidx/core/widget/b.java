package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CompoundButtonCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final String TAG = "CompoundButtonCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f1541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1542b;

    /* JADX INFO: compiled from: CompoundButtonCompat.java */
    static class a {
        static void a(CompoundButton r0, ColorStateList r1) {
            r0.setButtonTintList(r1);
        }

        static ColorStateList a(CompoundButton r0) {
            return r0.getButtonTintList();
        }

        static void a(CompoundButton r0, PorterDuff.Mode r1) {
            r0.setButtonTintMode(r1);
        }

        static PorterDuff.Mode b(CompoundButton r0) {
            return r0.getButtonTintMode();
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CompoundButtonCompat.java */
    static class C0044b {
        static Drawable a(CompoundButton r0) {
            return r0.getButtonDrawable();
        }
    }

    public static void a(CompoundButton r2, ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        a.a(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, j.class) == false) goto L10;
        ((j) ZeusTransformUtils.preCheckCast(r2, j.class, "com.obric.aiagent.plugin")).setSupportButtonTintList(r3);
        return;
    }

    public static ColorStateList a(CompoundButton r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return a.a(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, j.class) == true) goto L9;
        return null;
    L9:
        return ((j) ZeusTransformUtils.preCheckCast(r2, j.class, "com.obric.aiagent.plugin")).getSupportButtonTintList();
    }

    public static void a(CompoundButton r2, PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        a.a(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, j.class) == false) goto L10;
        ((j) ZeusTransformUtils.preCheckCast(r2, j.class, "com.obric.aiagent.plugin")).setSupportButtonTintMode(r3);
        return;
    }

    public static Drawable b(CompoundButton r4) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return C0044b.a(r4);
    L7:
        if (f1542b == false) goto L23;
    L14:
        Field r0 = f1541a;
        if (r0 != null) goto L21;
    L20:
        return null;
    L21:
        return (Drawable) ZeusTransformUtils.preCheckCast(r0.get(r4), Drawable.class, "com.obric.aiagent.plugin");
    L18:
        e = move-exception;
        a(TAG, "Failed to get button drawable via reflection", e);
        f1541a = null;
        goto L20
    L23:
        Field r2 = CompoundButton.class.getDeclaredField("mButtonDrawable");     // Catch: NoSuchFieldException -> L11
        f1541a = r2;     // Catch: NoSuchFieldException -> L11
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L11
    L13:
        f1542b = true;
    L11:
        e = move-exception;
        a(TAG, "Failed to retrieve mButtonDrawable field", e);
        goto L13
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }
}
