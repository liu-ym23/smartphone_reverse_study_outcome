package L2;

import android.graphics.RenderEffect;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import stepos.view.effects.StepOSViewEffects;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3809a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f3810b;

    /* renamed from: c, reason: collision with root package name */
    private static final Method f3811c;

    /* renamed from: L2.a$a, reason: collision with other inner class name */
    private static final class C0057a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0057a f3812a = new C0057a();

        private C0057a() {
        }

        public final void a(View view, RenderEffect renderEffect) {
            j4.k.g(view, "view");
            StepOSViewEffects.setBackdropRenderEffect(view, renderEffect);
        }
    }

    static {
        boolean z5;
        Method method;
        try {
            Class.forName("stepos.view.effects.StepOSViewEffects");
            z5 = true;
        } catch (Throwable th) {
            Log.i("BackdropBlur", "StepOSViewEffects 不可用，将尝试反射 View#setBackdropRenderEffect: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            z5 = false;
        }
        f3810b = z5;
        try {
            method = View.class.getMethod("setBackdropRenderEffect", RenderEffect.class);
            method.setAccessible(true);
        } catch (Throwable th2) {
            Log.e("BackdropBlur", "View#setBackdropRenderEffect 反射不可用: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
            method = null;
        }
        f3811c = method;
    }

    private a() {
    }

    private final void c(View view, RenderEffect renderEffect) {
        Method method = f3811c;
        if (method == null) {
            return;
        }
        try {
            method.invoke(view, renderEffect);
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e("BackdropBlur", "反射 setBackdropRenderEffect 失败: " + th.getClass().getSimpleName() + ": " + th.getMessage());
        }
    }

    public final boolean a() {
        return f3810b || f3811c != null;
    }

    public final void b(View view, RenderEffect renderEffect) {
        j4.k.g(view, "view");
        if (f3810b) {
            try {
                C0057a.f3812a.a(view, renderEffect);
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
        c(view, renderEffect);
    }
}
