package z9;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import kb.j;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f16517a;

    /* renamed from: b, reason: collision with root package name */
    public int f16518b;

    /* renamed from: c, reason: collision with root package name */
    public Object f16519c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f16520d;

    /* renamed from: e, reason: collision with root package name */
    public j f16521e;

    /* renamed from: f, reason: collision with root package name */
    public ab.b f16522f;

    public final void a(l lVar) {
        Object obj = this.f16519c;
        if (obj != null) {
            lVar.invoke(obj);
        } else {
            this.f16521e.addLast(lVar);
        }
    }

    public final void b() {
        View view;
        View view2;
        WeakReference weakReference = this.f16517a;
        if (this.f16519c == null && (view = (View) weakReference.get()) != null) {
            if (view.isAttachedToWindow()) {
                c();
                return;
            }
            if (this.f16522f == null && (view2 = (View) weakReference.get()) != null) {
                ab.b bVar = new ab.b(9);
                bVar.f379f = this;
                VarHandle.storeStoreFence();
                this.f16522f = bVar;
                view2.addOnAttachStateChangeListener(bVar);
            }
        }
    }

    public final void c() {
        Object objA;
        Method method;
        Object objInvoke;
        j jVar = this.f16521e;
        View view = (View) this.f16517a.get();
        if (view == null) {
            return;
        }
        if (f.f16524b) {
            try {
                objA = d.a(view);
            } catch (Throwable th) {
                th = th;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                Log.w("MotionKitCrossWindowMaterial", "StepOSBackdropLayer.create 失败，回退反射: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            }
        } else {
            Method method2 = f.f16525c;
            if (method2 == null || (method = f.f16526d) == null) {
                objA = null;
            } else {
                try {
                    objInvoke = method2.invoke(view, null);
                } catch (Throwable th2) {
                    th = th2;
                    Throwable cause2 = th.getCause();
                    if (cause2 != null) {
                        th = cause2;
                    }
                    Log.e("MotionKitCrossWindowMaterial", "createBackdropLayerDrawable failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
                }
                if (objInvoke == null) {
                    Log.e("MotionKitCrossWindowMaterial", "ViewRootImpl is null (View not attached)");
                    objA = null;
                } else {
                    objA = method.invoke(objInvoke, null);
                }
            }
        }
        if (objA == null) {
            return;
        }
        this.f16519c = objA;
        this.f16520d = view.getBackground();
        view.setBackground((Drawable) objA);
        while (!jVar.isEmpty()) {
            ((l) jVar.removeFirst()).invoke(objA);
        }
    }

    public final void d() {
        View view = (View) this.f16517a.get();
        ab.b bVar = this.f16522f;
        if (bVar != null && view != null) {
            view.removeOnAttachStateChangeListener(bVar);
        }
        this.f16522f = null;
        Object obj = this.f16519c;
        if (obj != null && view != null && view.getBackground() == obj) {
            view.setBackground(this.f16520d);
        }
        this.f16519c = null;
        this.f16520d = null;
        this.f16521e.clear();
    }
}
