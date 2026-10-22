package u3;

import K2.C0357a;
import V3.v;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import i4.InterfaceC0772l;
import i4.p;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import r3.C1009e;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final View f22899a;

    /* renamed from: b, reason: collision with root package name */
    private final C1009e f22900b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f22901c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f22902d;

    /* renamed from: e, reason: collision with root package name */
    private Method f22903e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f22904f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f22905g;

    /* renamed from: h, reason: collision with root package name */
    private final d f22906h;

    public i(View view) {
        j4.k.g(view, "view");
        this.f22899a = view;
        this.f22900b = new C1009e(view);
        this.f22906h = new d(new p() { // from class: u3.f
            @Override // i4.p
            public final Object invoke(Object obj, Object obj2) {
                return i.e(this.f22897a, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
            }
        }, new InterfaceC0772l() { // from class: u3.g
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return i.f(this.f22898a, ((Float) obj).floatValue());
            }
        }, new InterfaceC0772l() { // from class: u3.h
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return i.g((Exception) obj);
            }
        });
    }

    private final void d() {
        this.f22902d = null;
        this.f22903e = null;
        this.f22904f = null;
        this.f22905g = null;
        this.f22906h.a();
        this.f22900b.i();
        this.f22900b.m();
        this.f22899a.setBackground(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v e(i iVar, float f5, float f6) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method = iVar.f22903e;
        if (method == null) {
            Class<?> cls = Class.forName("stepos.view.effects.StepOSBackdropLayer");
            Class cls2 = Float.TYPE;
            method = cls.getMethod("setCornerRadius", Drawable.class, cls2, cls2, cls2, cls2);
            iVar.f22903e = method;
        }
        Drawable drawable = iVar.f22902d;
        if (drawable == null) {
            throw new IllegalStateException("Required value was null.");
        }
        method.invoke(null, drawable, Float.valueOf(f5), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f6));
        return v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v f(i iVar, float f5) {
        Drawable drawable = iVar.f22902d;
        if (drawable == null) {
            throw new IllegalStateException("Required value was null.");
        }
        C0357a.e(drawable, f5);
        return v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v g(Exception exc) {
        j4.k.g(exc, "error");
        Log.w("StepOSLiteSheetGlass", "Corner update unavailable; keeping glass material", exc);
        return v.f5542a;
    }

    public final boolean h() {
        return this.f22902d != null && this.f22900b.l();
    }

    public final void i() {
        d();
        this.f22901c = false;
    }

    public final void j(float f5, float f6, int i5, int i6) {
        if (!this.f22901c || h()) {
            try {
                if (!this.f22901c) {
                    this.f22901c = true;
                    if (C0357a.b() && this.f22900b.e(1, f5, i5, i6)) {
                        Drawable background = this.f22899a.getBackground();
                        if (background == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        this.f22902d = background;
                    }
                    d();
                    return;
                }
                Drawable drawable = this.f22902d;
                if (drawable == null) {
                    return;
                }
                Integer num = this.f22904f;
                if (num == null || num.intValue() != i5) {
                    C0357a.c(drawable, i5);
                    this.f22904f = Integer.valueOf(i5);
                }
                Integer num2 = this.f22905g;
                if (num2 == null || num2.intValue() != i6) {
                    C0357a.d(drawable, i6);
                    this.f22905g = Integer.valueOf(i6);
                }
                this.f22906h.b(f5, f6);
            } catch (Exception e6) {
                Log.w("StepOSLiteSheetGlass", "Glass unavailable; using opaque sheet background", e6);
                d();
            }
        }
    }
}
