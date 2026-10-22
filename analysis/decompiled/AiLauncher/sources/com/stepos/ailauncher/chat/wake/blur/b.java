package com.stepos.ailauncher.chat.wake.blur;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\t\u0010\rJ\u001d\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\rJ3\u0010\u0018\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0017\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0017\u0010!\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/blur/b;", "", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/graphics/drawable/Drawable;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)Landroid/graphics/drawable/Drawable;", Const.INTENT_KEY_UMID, "", "radius", "LY8/t;", "(Landroid/graphics/drawable/Drawable;I)V", "", "f", "(Landroid/graphics/drawable/Drawable;F)V", "color", "e", "", "name", "Ljava/lang/Class;", "type", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)V", "TAG", "Ljava/lang/String;", "Ljava/lang/reflect/Method;", "getViewRootImpl", "Ljava/lang/reflect/Method;", "createMethod", "", "isAvailable", "Z", "c", "()Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    private static final String TAG = "CrossWindowBlur";
    private static final Method createMethod;
    private static final Method getViewRootImpl;
    private static final boolean isAvailable;

    static {
        Method method;
        Method method2 = null;
        try {
            method = View.class.getMethod("getViewRootImpl", null);
            method.setAccessible(true);
        } catch (Throwable th) {
            Log.w(TAG, "View.getViewRootImpl 不可用: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            method = null;
        }
        getViewRootImpl = method;
        try {
            Method method3 = Class.forName("android.view.ViewRootImpl").getMethod("createBackgroundBlurDrawable", null);
            method3.setAccessible(true);
            method2 = method3;
        } catch (Throwable th2) {
            Log.w(TAG, "createBackgroundBlurDrawable 不可用: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
        }
        createMethod = method2;
        isAvailable = (getViewRootImpl == null || method2 == null) ? false : true;
    }

    public final Drawable a(View view) {
        Method method;
        p.i(view, "view");
        Method method2 = getViewRootImpl;
        if (method2 == null || (method = createMethod) == null) {
            return null;
        }
        try {
            Object objInvoke = method2.invoke(view, null);
            if (objInvoke == null) {
                Log.w(TAG, "ViewRootImpl == null (view 未 attach)");
                return null;
            }
            Object objInvoke2 = method.invoke(objInvoke, null);
            if (objInvoke2 instanceof Drawable) {
                return (Drawable) objInvoke2;
            }
            return null;
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.w(TAG, "create 失败: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            return null;
        }
    }

    public final void b(Drawable d10, String name, Class<?> type, Object value) {
        try {
            d10.getClass().getMethod(name, type).invoke(d10, value);
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.w(TAG, name + " 失败: " + th.getClass().getSimpleName() + ": " + th.getMessage());
        }
    }

    public final boolean c() {
        return isAvailable;
    }

    public final void d(Drawable d10, int radius) {
        p.i(d10, "d");
        Class<?> cls = Integer.TYPE;
        p.f(cls);
        b(d10, "setBlurRadius", cls, Integer.valueOf(radius));
    }

    public final void e(Drawable d10, int color) {
        p.i(d10, "d");
        Class<?> cls = Integer.TYPE;
        p.f(cls);
        b(d10, "setColor", cls, Integer.valueOf(color));
    }

    public final void f(Drawable d10, float radius) {
        p.i(d10, "d");
        Class<?> cls = Float.TYPE;
        p.f(cls);
        b(d10, "setCornerRadius", cls, Float.valueOf(radius));
    }
}
