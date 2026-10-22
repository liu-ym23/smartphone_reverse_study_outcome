package wd;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Size;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.graphics.e;
import androidx.core.view.WindowInsetsCompat;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.interfaces.OnWindowConfigChangeListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import tc.f;
import yd.b;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25402a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Boolean f25403b;

    static {
        f25402a = new a();
    }

    public a() {
    }

    public static final void a(Context r10, WindowManager.LayoutParams r11, Boolean r12) {
        q.g(r11, "params");
        if (r10 != null) goto L5;
        return;
    L5:
        a r13 = f25402a;
        if (r13.n(r10) == true) goto L8;
        return;
    L8:
        r11.layoutInDisplayCutoutMode = e(r13.b(r10), r12);
    }

    @JvmStatic
    public static final void addWindowConfigChangeListener(@NotNull OnWindowConfigChangeListener r10) {
        q.g(r10, "listener");
        ae.a.f85a.addListener(r10);
    }

    public static final Size c(Context r10) {
        if (r10 == null) goto L4;
        Activity r11 = f25402a.b(r10);
        if (r11 == null) goto L9;
        b r12 = b.f26248a;
        return new Size(r12.a(r11).a().width(), r12.a(r11).a().height());
    L9:
        Object r13 = r10.getSystemService("window");
        Rect r14 = null;
        if ((r13 instanceof WindowManager) == false) goto L12;
        WindowManager r15 = (WindowManager) r13;
    L13:
        if (r15 == null) goto L19;
        WindowMetrics r16 = r15.getCurrentWindowMetrics();
        if (r16 == null) goto L19;
        r14 = r16.getBounds();
    L19:
        if (r14 == null) goto L23;
        return new Size(r14.width(), r14.height());
    L23:
        return new Size(f.n(r10), f.m(r10));
    L12:
        r15 = null;
        goto L13
    L4:
        return new Size(0, 0);
    }

    public static final int e(Activity r10, Boolean r11) {
        if (r11 != null) goto L5;
        if (r10 != null) goto L10;
        return 2;
    L10:
        Window r12 = r10.getWindow();
        if (r12 == null) goto L19;
        WindowManager.LayoutParams r13 = r12.getAttributes();
        if (r13 != null) goto L17;
        return 2;
    L17:
        return r13.layoutInDisplayCutoutMode;
    L19:
        return 2;
    L5:
        if (r11.booleanValue() == false) goto L18;
        return 3;
    L18:
        return 2;
    }

    public static final int g(Context r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = r10.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r11 > 0) goto L8;
        Class<?> r12 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L11
        Object r13 = r12.newInstance();     // Catch: Exception -> L11
        int r14 = Integer.parseInt(r12.getField("status_bar_height").get(r13).toString());     // Catch: Exception -> L11
        return r10.getResources().getDimensionPixelSize(r14);
    L11:
        return 0;
    L8:
        return r10.getResources().getDimensionPixelSize(r11);
    }

    public static final e h(View r10, WindowInsets r11) {
        q.g(r10, "view");
        return j(r10, r11, false, 4, null);
    }

    public static final e i(View r10, WindowInsets r11, boolean r12) {
        q.g(r10, "view");
        if (r11 != null) goto L5;
        r11 = r10.getRootWindowInsets();
    L5:
        if (r11 != null) goto L8;
        e r13 = e.f2555e;
        q.f(r13, "NONE");
        return r13;
    L8:
        if (r12 == false) goto L11;
        e r14 = WindowInsetsCompat.y(r11).f(WindowInsetsCompat.Type.d());
        q.f(r14, "toWindowInsetsCompat(ins…Compat.Type.systemBars())");
        return r14;
    L11:
        e r15 = WindowInsetsCompat.y(r11).n();
        q.f(r15, "toWindowInsetsCompat(insets).systemWindowInsets");
        return r15;
    }

    public static /* synthetic */ e j(View r10, WindowInsets r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = true;
    L9:
        return i(r10, r11, r12);
    }

    public static final boolean k(Context r10) {
        q.g(r10, "context");
        return l(r10);
    }

    public static final boolean l(Context r10) {
        q.g(r10, "context");
        Resources r11 = r10.getResources();
        int r12 = r11.getIdentifier("config_navBarInteractionMode", "integer", "android");
        if (r12 > 0) goto L5;
        return false;
    L5:
        if (r11.getInteger(r12) != 2) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmStatic
    public static final void removeWindowConfigChangeListener(@NotNull OnWindowConfigChangeListener r10) {
        q.g(r10, "listener");
        ae.a.f85a.removeListener(r10);
    }

    public final Activity b(Context r10) {
        q.g(r10, "context");
        if ((r10 instanceof Activity) == false) goto L7;
        return (Activity) r10;
    L7:
        if ((r10 instanceof ContextWrapper) == false) goto L10;
        Context r11 = ((ContextWrapper) r10).getBaseContext();
        q.f(r11, "context.baseContext");
        return b(r11);
    L10:
        return null;
    }

    public final int d(View r10) {
        q.g(r10, "rootView");
        WindowInsetsController r11 = r10.getWindowInsetsController();     // Catch: Exception -> L9
        if (r11 != null) goto L6;
        return 0;
    L6:
        Rect r12 = null;
        Method r13 = r11.getClass().getDeclaredMethod("getState", null);     // Catch: Exception -> L9
        r13.setAccessible(true);     // Catch: Exception -> L9
        Object r14 = r13.invoke(r11, null);     // Catch: Exception -> L9
        int r15 = Build.VERSION.SDK_INT;     // Catch: Exception -> L9
        if (r15 < 35) goto L11;
        Class<?> r16 = Class.forName("android.view.InsetsSource");     // Catch: Exception -> L9
    L12:
        if (r15 < 35) goto L14;
        Field r17 = r16.getDeclaredField("ID_IME");     // Catch: Exception -> L9
    L15:
        r17.setAccessible(true);     // Catch: Exception -> L9
        int r18 = r17.getInt(null);     // Catch: Exception -> L9
        Method r19 = r14.getClass().getDeclaredMethod("peekSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L9
        r19.setAccessible(true);     // Catch: Exception -> L9
        Object r20 = r19.invoke(r14, new Object[]{Integer.valueOf(r18)});     // Catch: Exception -> L9
        if (r20 != null) goto L19;
        r20 = null;
    L19:
        if (r20 != null) goto L21;
        return 0;
    L21:
        Method r21 = r20.getClass().getDeclaredMethod("isVisible", null);     // Catch: Exception -> L9
        r21.setAccessible(true);     // Catch: Exception -> L9
        Object r22 = r21.invoke(r20, null);     // Catch: Exception -> L9
        if ((r22 instanceof Boolean) == false) goto L24;
        Boolean r23 = (Boolean) r22;     // Catch: Exception -> L9
    L25:
        if (r23 != null) goto L28;
        return 0;
    L28:
        if (r23.booleanValue() == false) goto L37;
        Method r24 = r20.getClass().getDeclaredMethod("getFrame", null);     // Catch: Exception -> L9
        r24.setAccessible(true);     // Catch: Exception -> L9
        Object r25 = r24.invoke(r20, null);     // Catch: Exception -> L9
        if ((r25 instanceof Rect) == false) goto L32;
        r12 = (Rect) r25;     // Catch: Exception -> L9
    L32:
        if (r12 != null) goto L34;
        return 0;
    L34:
        return r12.height();
    L37:
        return 0;
    L24:
        r23 = null;
        goto L25
    L14:
        r17 = r16.getDeclaredField("ITYPE_IME");     // Catch: Exception -> L9
        goto L15
    L11:
        r16 = Class.forName("android.view.InsetsState");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L37
    }

    public final int f(Context r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = r10.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (r11 > 0) goto L8;
        Class<?> r12 = Class.forName("com.android.internal.R$dimen");     // Catch: Exception -> L11
        Object r13 = r12.newInstance();     // Catch: Exception -> L11
        int r14 = Integer.parseInt(r12.getField("navigation_bar_height").get(r13).toString());     // Catch: Exception -> L11
        return r10.getResources().getDimensionPixelSize(r14);
    L14:
        return 0;
    L8:
        return r10.getResources().getDimensionPixelSize(r11);
    }

    public final boolean m(Context r10) {
        q.g(r10, "context");
        Activity r11 = b(r10);
        if (r11 != null) goto L6;
        return false;
    L6:
        return r11.isInMultiWindowMode();
    }

    public final boolean n(Context r10) {
        q.g(r10, "context");
        if (r10.getResources().getConfiguration().orientation != 2) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        L.c("OWindowConfigController", "isLandscape error", e);
        return false;
    }

    public final void o(boolean r10) {
        f25403b = Boolean.valueOf(r10);
    }
}
