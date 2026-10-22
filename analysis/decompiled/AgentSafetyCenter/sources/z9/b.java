package z9;

import android.graphics.RenderEffect;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f16514a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f16515b;

    static {
        boolean z10;
        Method method;
        try {
            Class.forName("stepos.view.effects.StepOSViewEffects");
            z10 = true;
        } catch (Throwable th) {
            Log.i("BackdropBlur", "StepOSViewEffects 不可用，将尝试反射 View#setBackdropRenderEffect: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            z10 = false;
        }
        f16514a = z10;
        try {
            method = View.class.getMethod("setBackdropRenderEffect", RenderEffect.class);
            method.setAccessible(true);
        } catch (Throwable th2) {
            Log.e("BackdropBlur", "View#setBackdropRenderEffect 反射不可用: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
            method = null;
        }
        f16515b = method;
    }

    public static void a(View view, RenderEffect renderEffect) {
        if (f16514a) {
            try {
                a.a(view, renderEffect);
                return;
            } catch (Throwable th) {
                th = th;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                Log.w("BackdropBlur", "StepOSViewEffects 调用失败，回退反射: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            }
        }
        Method method = f16515b;
        if (method == null) {
            return;
        }
        try {
            method.invoke(view, renderEffect);
        } catch (Throwable th2) {
            th = th2;
            Throwable cause2 = th.getCause();
            if (cause2 != null) {
                th = cause2;
            }
            Log.e("BackdropBlur", "反射 setBackdropRenderEffect 失败: " + th.getClass().getSimpleName() + ": " + th.getMessage());
        }
    }
}
