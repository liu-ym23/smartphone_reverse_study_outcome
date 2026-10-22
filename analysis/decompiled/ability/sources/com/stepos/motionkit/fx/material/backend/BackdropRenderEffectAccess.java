package com.stepos.motionkit.fx.material.backend;

import android.graphics.RenderEffect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepos.view.effects.StepOSViewEffects;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/motionkit/fx/material/backend/BackdropRenderEffectAccess;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/View;", "view", "Landroid/graphics/RenderEffect;", "effect", "LC7/r;", "setByReflection", "(Landroid/view/View;Landroid/graphics/RenderEffect;)V", "set", "", "TAG", "Ljava/lang/String;", "SDK_CLASS", "", "sdkAvailable", "Z", "Ljava/lang/reflect/Method;", "reflectMethod", "Ljava/lang/reflect/Method;", "isAvailable", "()Z", "Api", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackdropRenderEffectAccess {
    public static final BackdropRenderEffectAccess INSTANCE = new BackdropRenderEffectAccess();
    private static final String SDK_CLASS = "stepos.view.effects.StepOSViewEffects";
    private static final String TAG = "BackdropBlur";
    private static final Method reflectMethod;
    private static final boolean sdkAvailable;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/motionkit/fx/material/backend/BackdropRenderEffectAccess$Api;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/View;", "view", "Landroid/graphics/RenderEffect;", "effect", "LC7/r;", "set", "(Landroid/view/View;Landroid/graphics/RenderEffect;)V", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Api {
        public static final Api INSTANCE = new Api();

        private Api() {
        }

        public final void set(View view, RenderEffect effect) {
            k.f(view, "view");
            StepOSViewEffects.setBackdropRenderEffect(view, effect);
        }
    }

    static {
        boolean z10;
        Method method;
        try {
            Class.forName(SDK_CLASS);
            z10 = true;
        } catch (Throwable th) {
            Log.i(TAG, "StepOSViewEffects 不可用，将尝试反射 View#setBackdropRenderEffect: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            z10 = false;
        }
        sdkAvailable = z10;
        try {
            method = View.class.getMethod("setBackdropRenderEffect", RenderEffect.class);
            method.setAccessible(true);
        } catch (Throwable th2) {
            Log.e(TAG, "View#setBackdropRenderEffect 反射不可用: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
            method = null;
        }
        reflectMethod = method;
    }

    private BackdropRenderEffectAccess() {
    }

    private final void setByReflection(View view, RenderEffect effect) {
        Method method = reflectMethod;
        if (method == null) {
            return;
        }
        try {
            method.invoke(view, effect);
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e(TAG, "反射 setBackdropRenderEffect 失败: " + th.getClass().getSimpleName() + ": " + th.getMessage());
        }
    }

    public final boolean isAvailable() {
        return sdkAvailable || reflectMethod != null;
    }

    public final void set(View view, RenderEffect effect) {
        k.f(view, "view");
        if (sdkAvailable) {
            try {
                Api.INSTANCE.set(view, effect);
                return;
            } catch (Throwable th) {
                th = th;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                a.x("StepOSViewEffects 调用失败，回退反射: ", th.getClass().getSimpleName(), ": ", th.getMessage(), TAG);
            }
        }
        setByReflection(view, effect);
    }
}
