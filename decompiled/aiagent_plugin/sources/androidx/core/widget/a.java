package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CheckedTextView;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CheckedTextViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String TAG = "CheckedTextViewCompat";

    /* JADX INFO: renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CheckedTextViewCompat.java */
    private static class C0043a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Field f1539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static boolean f1540b;

        static Drawable a(CheckedTextView r4) {
            if (f1540b == false) goto L19;
        L10:
            Field r0 = f1539a;
            if (r0 != null) goto L17;
        L16:
            return null;
        L17:
            return (Drawable) ZeusTransformUtils.preCheckCast(r0.get(r4), Drawable.class, "com.obric.aiagent.plugin");
        L14:
            e = move-exception;
            a(a.TAG, "Failed to get check mark drawable via reflection", e);
            f1539a = null;
            goto L16
        L19:
            Field r2 = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");     // Catch: NoSuchFieldException -> L7
            f1539a = r2;     // Catch: NoSuchFieldException -> L7
            r2.setAccessible(true);     // Catch: NoSuchFieldException -> L7
        L9:
            f1540b = true;
        L7:
            e = move-exception;
            a(a.TAG, "Failed to retrieve mCheckMarkDrawable field", e);
            goto L9
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2, r3);
        }
    }

    /* JADX INFO: compiled from: CheckedTextViewCompat.java */
    private static class b {
        static Drawable a(CheckedTextView r0) {
            return r0.getCheckMarkDrawable();
        }
    }

    /* JADX INFO: compiled from: CheckedTextViewCompat.java */
    private static class c {
        static void a(CheckedTextView r0, ColorStateList r1) {
            r0.setCheckMarkTintList(r1);
        }

        static void a(CheckedTextView r0, PorterDuff.Mode r1) {
            r0.setCheckMarkTintMode(r1);
        }
    }

    public static void a(CheckedTextView r2, ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        c.a(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, i.class) == false) goto L10;
        ((i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.aiagent.plugin")).setSupportCheckMarkTintList(r3);
        return;
    }

    public static void a(CheckedTextView r2, PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        c.a(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, i.class) == false) goto L10;
        ((i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.aiagent.plugin")).setSupportCheckMarkTintMode(r3);
        return;
    }

    public static Drawable a(CheckedTextView r2) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return b.a(r2);
    L7:
        return C0043a.a(r2);
    }
}
