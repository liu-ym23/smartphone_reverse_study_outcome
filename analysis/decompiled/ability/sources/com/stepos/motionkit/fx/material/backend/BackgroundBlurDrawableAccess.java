package com.stepos.motionkit.fx.material.backend;

import B7.a;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepos.view.effects.StepOSBackgroundBlur;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\bJ\u001d\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b\u001f\u0010\u001aR\u0014\u0010 \u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u0004\u0018\u00010&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u0004\u0018\u00010&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010,\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010-\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b-\u0010+¨\u0006/"}, d2 = {"Lcom/stepos/motionkit/fx/material/backend/BackgroundBlurDrawableAccess;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/View;", "view", "Landroid/graphics/drawable/Drawable;", "createByReflection", "(Landroid/view/View;)Landroid/graphics/drawable/Drawable;", "drawable", "", HintConstants.AUTOFILL_HINT_NAME, "Ljava/lang/Class;", "paramType", "value", "LC7/r;", "invoke", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)V", "", "t", "warnFallback", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "create", "", "radius", "setBlurRadius", "(Landroid/graphics/drawable/Drawable;I)V", "", "setCornerRadius", "(Landroid/graphics/drawable/Drawable;F)V", TypedValues.Custom.S_COLOR, "setColor", "TAG", "Ljava/lang/String;", "SDK_CLASS", "", "sdkAvailable", "Z", "Ljava/lang/reflect/Method;", "getViewRootImpl", "Ljava/lang/reflect/Method;", "createMethod", "getReflectAvailable", "()Z", "reflectAvailable", "isAvailable", "Api", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackgroundBlurDrawableAccess {
    public static final BackgroundBlurDrawableAccess INSTANCE = new BackgroundBlurDrawableAccess();
    private static final String SDK_CLASS = "stepos.view.effects.StepOSBackgroundBlur";
    private static final String TAG = "CrossWindowBlur";
    private static final Method createMethod;
    private static final Method getViewRootImpl;
    private static final boolean sdkAvailable;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/stepos/motionkit/fx/material/backend/BackgroundBlurDrawableAccess$Api;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/View;", "view", "Landroid/graphics/drawable/Drawable;", "create", "(Landroid/view/View;)Landroid/graphics/drawable/Drawable;", "drawable", "", "radius", "LC7/r;", "setBlurRadius", "(Landroid/graphics/drawable/Drawable;I)V", "", "setCornerRadius", "(Landroid/graphics/drawable/Drawable;F)V", TypedValues.Custom.S_COLOR, "setColor", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Api {
        public static final Api INSTANCE = new Api();

        private Api() {
        }

        public final Drawable create(View view) {
            k.f(view, "view");
            return StepOSBackgroundBlur.createBackgroundBlurDrawable(view);
        }

        public final void setBlurRadius(Drawable drawable, int radius) {
            k.f(drawable, "drawable");
            StepOSBackgroundBlur.setBlurRadius(drawable, radius);
        }

        public final void setColor(Drawable drawable, int color) {
            k.f(drawable, "drawable");
            StepOSBackgroundBlur.setColor(drawable, color);
        }

        public final void setCornerRadius(Drawable drawable, float radius) {
            k.f(drawable, "drawable");
            StepOSBackgroundBlur.setCornerRadius(drawable, radius);
        }
    }

    static {
        boolean z10;
        Method method;
        try {
            Class.forName(SDK_CLASS);
            z10 = true;
        } catch (Throwable th) {
            Log.i(TAG, "StepOSBackgroundBlur 不可用，将尝试反射 createBackgroundBlurDrawable: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            z10 = false;
        }
        sdkAvailable = z10;
        Method method2 = null;
        try {
            method = View.class.getMethod("getViewRootImpl", null);
            method.setAccessible(true);
        } catch (Throwable unused) {
            method = null;
        }
        getViewRootImpl = method;
        try {
            Method method3 = Class.forName("android.view.ViewRootImpl").getMethod("createBackgroundBlurDrawable", null);
            method3.setAccessible(true);
            method2 = method3;
        } catch (Throwable th2) {
            Log.e(TAG, "createBackgroundBlurDrawable 不可用: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
        }
        createMethod = method2;
    }

    private BackgroundBlurDrawableAccess() {
    }

    private final Drawable createByReflection(View view) {
        Method method;
        Method method2 = getViewRootImpl;
        if (method2 == null || (method = createMethod) == null) {
            return null;
        }
        try {
            Object objInvoke = method2.invoke(view, null);
            if (objInvoke == null) {
                Log.e(TAG, "ViewRootImpl 为 null(View 未附着)");
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
            Log.e(TAG, "createBackgroundBlurDrawable 失败: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            return null;
        }
    }

    private final boolean getReflectAvailable() {
        return (getViewRootImpl == null || createMethod == null) ? false : true;
    }

    private final void invoke(Drawable drawable, String name, Class<?> paramType, Object value) {
        try {
            drawable.getClass().getMethod(name, paramType).invoke(drawable, value);
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e(TAG, name + " 失败: " + th.getClass().getSimpleName() + ": " + th.getMessage());
        }
    }

    private final void warnFallback(String name, Throwable t9) {
        Throwable cause = t9.getCause();
        if (cause != null) {
            t9 = cause;
        }
        String simpleName = t9.getClass().getSimpleName();
        String message = t9.getMessage();
        StringBuilder sbW = a.w("StepOSBackgroundBlur.", name, " 失败，回退反射: ", simpleName, ": ");
        sbW.append(message);
        Log.w(TAG, sbW.toString());
    }

    public final Drawable create(View view) {
        k.f(view, "view");
        if (sdkAvailable) {
            try {
                return Api.INSTANCE.create(view);
            } catch (Throwable th) {
                th = th;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                androidx.constraintlayout.core.dsl.a.x("StepOSBackgroundBlur.create 失败，回退反射: ", th.getClass().getSimpleName(), ": ", th.getMessage(), TAG);
            }
        }
        return this.createByReflection(view);
    }

    public final boolean isAvailable() {
        return sdkAvailable || getReflectAvailable();
    }

    public final void setBlurRadius(Drawable drawable, int radius) {
        k.f(drawable, "drawable");
        if (sdkAvailable) {
            try {
                Api.INSTANCE.setBlurRadius(drawable, radius);
                return;
            } catch (Throwable th) {
                warnFallback("setBlurRadius", th);
            }
        }
        Class<?> cls = Integer.TYPE;
        k.c(cls);
        invoke(drawable, "setBlurRadius", cls, Integer.valueOf(radius));
    }

    public final void setColor(Drawable drawable, int color) {
        k.f(drawable, "drawable");
        if (sdkAvailable) {
            try {
                Api.INSTANCE.setColor(drawable, color);
                return;
            } catch (Throwable th) {
                warnFallback("setColor", th);
            }
        }
        Class<?> cls = Integer.TYPE;
        k.c(cls);
        invoke(drawable, "setColor", cls, Integer.valueOf(color));
    }

    public final void setCornerRadius(Drawable drawable, float radius) {
        k.f(drawable, "drawable");
        if (sdkAvailable) {
            try {
                Api.INSTANCE.setCornerRadius(drawable, radius);
                return;
            } catch (Throwable th) {
                warnFallback("setCornerRadius", th);
            }
        }
        Class<?> cls = Float.TYPE;
        k.c(cls);
        invoke(drawable, "setCornerRadius", cls, Float.valueOf(radius));
    }
}
