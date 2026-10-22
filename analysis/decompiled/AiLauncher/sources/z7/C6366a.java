package z7;

import android.graphics.RenderEffect;
import android.util.Log;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import stepos.view.effects.StepOSViewEffects;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lz7/a;", "", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/graphics/RenderEffect;", "effect", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;Landroid/graphics/RenderEffect;)V", "c", "", "Z", "sdkAvailable", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "reflectMethod", Const.INTENT_KEY_APIKEY, "()Z", "isAvailable", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: z7.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6366a {

    /* renamed from: a, reason: collision with root package name */
    public static final C6366a f45183a = new C6366a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final boolean sdkAvailable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Method reflectMethod;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lz7/a$a;", "", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/graphics/RenderEffect;", "effect", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Landroid/graphics/RenderEffect;)V", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: z7.a$a, reason: collision with other inner class name */
    public static final class C0565a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0565a f45186a = new C0565a();

        public final void a(View view, RenderEffect effect) {
            p.i(view, "view");
            StepOSViewEffects.setBackdropRenderEffect(view, effect);
        }
    }

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
        sdkAvailable = z10;
        try {
            method = View.class.getMethod("setBackdropRenderEffect", RenderEffect.class);
            method.setAccessible(true);
        } catch (Throwable th2) {
            Log.e("BackdropBlur", "View#setBackdropRenderEffect 反射不可用: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
            method = null;
        }
        reflectMethod = method;
    }

    public final boolean a() {
        return sdkAvailable || reflectMethod != null;
    }

    public final void b(View view, RenderEffect effect) {
        p.i(view, "view");
        if (sdkAvailable) {
            try {
                C0565a.f45186a.a(view, effect);
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
        c(view, effect);
    }

    public final void c(View view, RenderEffect effect) {
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
            Log.e("BackdropBlur", "反射 setBackdropRenderEffect 失败: " + th.getClass().getSimpleName() + ": " + th.getMessage());
        }
    }
}
