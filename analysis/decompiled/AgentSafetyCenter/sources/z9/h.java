package z9;

import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.util.Log;
import android.view.Display;
import android.view.View;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import kb.s;
import stepos.view.effects.StepOSGlassMaterial;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f16556a;

    /* renamed from: b, reason: collision with root package name */
    public int f16557b;

    /* renamed from: c, reason: collision with root package name */
    public final g f16558c;

    public h(View view) {
        view.getClass();
        this.f16556a = new WeakReference(view);
        g gVar = new g();
        gVar.f16533c = 2;
        gVar.f16534d = 0.1f;
        gVar.f16536f = s.f7404c;
        gVar.f16541l = 0.5f;
        gVar.f16544o = 2.0f;
        gVar.f16545p = 2.0f;
        gVar.f16546q = 1.0f;
        gVar.f16547r = 2.0f;
        gVar.f16548s = -1;
        gVar.f16550u = -1.0f;
        gVar.f16552w = 1.0f;
        gVar.f16555z = -3355444;
        gVar.A = -3092272;
        gVar.B = 1.0f;
        gVar.C = 1.0f;
        gVar.E = 1711276032;
        gVar.F = 14.0f;
        gVar.G = 1.0f;
        gVar.I = 20.0f;
        gVar.J = 40.0f;
        gVar.L = 0.4f;
        this.f16558c = gVar;
    }

    public final void a(l lVar) {
        lVar.invoke(this.f16558c);
        if (i.f16566h > 0) {
            i.i.add(this);
        } else {
            b();
        }
    }

    public final void b() {
        RenderEffect renderEffectCreateStepOSBlurEffect;
        RenderEffect renderEffectCreateBlurEffect;
        View view;
        g gVar = this.f16558c;
        View view2 = (View) this.f16556a.get();
        if (view2 == null) {
            return;
        }
        try {
            if (gVar.f16531a <= 0.0f && !gVar.a()) {
                Log.d("MotionKitInWindowMaterial", "rebuild: radius<=0 且无玻璃 → clear effect");
                b.a(view2, null);
                Object parent = view2.getParent();
                view = parent instanceof View ? (View) parent : null;
                if (view != null) {
                    view.invalidate();
                    return;
                }
                return;
            }
            float f5 = gVar.f16531a;
            if (f5 <= 0.0f) {
                f5 = 0.1f;
            }
            boolean z10 = i.f16560b;
            boolean z11 = z10 || i.f16564f != null;
            Display display = view2.getDisplay();
            int rotation = display != null ? display.getRotation() : 0;
            if (z11) {
                int iB = i.b(gVar.f16537g, rotation);
                if (z10) {
                    renderEffectCreateStepOSBlurEffect = StepOSGlassMaterial.createStepOSBlurEffect(f5, iB, gVar.f16538h);
                } else {
                    Method method = i.f16564f;
                    method.getClass();
                    Object objInvoke = method.invoke(null, Float.valueOf(f5), Integer.valueOf(iB), Float.valueOf(gVar.f16538h));
                    renderEffectCreateStepOSBlurEffect = objInvoke instanceof RenderEffect ? (RenderEffect) objInvoke : null;
                }
                if (renderEffectCreateStepOSBlurEffect == null) {
                    renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(f5, f5, Shader.TileMode.CLAMP);
                    renderEffectCreateBlurEffect.getClass();
                } else {
                    renderEffectCreateBlurEffect = renderEffectCreateStepOSBlurEffect;
                }
            } else {
                renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(f5, f5, Shader.TileMode.CLAMP);
                renderEffectCreateBlurEffect.getClass();
            }
            i iVar = i.f16559a;
            int iB2 = i.b(gVar.f16542m, rotation);
            if (gVar.a()) {
                if (z10) {
                    renderEffectCreateBlurEffect = i.f(gVar, renderEffectCreateBlurEffect, iB2);
                } else {
                    Object objA = i.a(gVar, iB2);
                    if (objA != null) {
                        Method method2 = i.f16563e;
                        method2.getClass();
                        Object objInvoke2 = method2.invoke(null, objA, 16777215, renderEffectCreateBlurEffect);
                        objInvoke2.getClass();
                        renderEffectCreateBlurEffect = (RenderEffect) objInvoke2;
                    }
                }
            }
            Log.d("MotionKitInWindowMaterial", "rebuild: r=" + gVar.f16531a + " anyGlass=" + gVar.a() + " stroke=" + gVar.f16543n + " inner=" + gVar.D + " refract=" + gVar.H + " effect=" + System.identityHashCode(renderEffectCreateBlurEffect) + " view=" + System.identityHashCode(view2));
            b.a(view2, renderEffectCreateBlurEffect);
            Object parent2 = view2.getParent();
            view = parent2 instanceof View ? (View) parent2 : null;
            if (view != null) {
                view.invalidate();
            }
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e("MotionKitInWindowMaterial", androidx.activity.b.j("rebuild failed: ", th.getClass().getSimpleName(), ": ", th.getMessage()), th);
        }
    }
}
