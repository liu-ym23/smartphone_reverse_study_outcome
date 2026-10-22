package androidx.core.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ViewConfigurationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class z {
    private static final String TAG = "ViewConfigCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f1528a;

    /* JADX INFO: compiled from: ViewConfigurationCompat.java */
    static class a {
        static float a(ViewConfiguration r0) {
            return r0.getScaledHorizontalScrollFactor();
        }

        static float b(ViewConfiguration r0) {
            return r0.getScaledVerticalScrollFactor();
        }
    }

    /* JADX INFO: compiled from: ViewConfigurationCompat.java */
    static class b {
        static int a(ViewConfiguration r0) {
            return r0.getScaledHoverSlop();
        }

        static boolean b(ViewConfiguration r0) {
            return r0.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static {
        if (Build.VERSION.SDK_INT != 25) goto L10;
        f1528a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);     // Catch: Exception -> L6
        return;
    L6:
        a(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
        return;
    }

    public static float a(ViewConfiguration r2, Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return a.a(r2);
    L7:
        return d(r2, r4);
    }

    public static float b(ViewConfiguration r2, Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return a.b(r2);
    L7:
        return d(r2, r4);
    }

    private static float d(ViewConfiguration r4, Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 25) goto L11;
        Method r0 = f1528a;
        if (r0 == null) goto L11;
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.invoke(r4, new Object[0]), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L10:
        a(TAG, "Could not find method getScaledScrollFactor() on ViewConfiguration");
    L11:
        TypedValue r7 = new TypedValue();
        if (r6.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r7, true) == true) goto L14;
        return 0.0f;
    L14:
        return r7.getDimension(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDisplayMetrics());
    }

    public static int a(ViewConfiguration r2) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return b.a(r2);
    L7:
        return r2.getScaledTouchSlop() / 2;
    }

    public static boolean c(ViewConfiguration r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        Resources r6 = ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin");
        int r7 = a(r6, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        if (r7 != 0) goto L9;
    L11:
        return false;
    L9:
        if (r6.getBoolean(r7) == false) goto L11;
        return true;
    L5:
        return b.b(r3);
    }

    private static int a(Resources r2, String r3, String r4) {
        return ZeusTransformUtils.getIdentifier(r2, r3, r4, "android", "com.obric.aiagent.plugin");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
