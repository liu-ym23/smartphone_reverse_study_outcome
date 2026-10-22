package q0;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: q0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5139c extends m0.e {

    /* renamed from: q0.c$a */
    public static class a extends AbstractC5139c {
        @Override // q0.AbstractC5139c
        public void i(View view, float f10) {
            view.setAlpha(a(f10));
        }
    }

    /* renamed from: q0.c$b */
    public static class b extends AbstractC5139c {

        /* renamed from: h, reason: collision with root package name */
        public float[] f38476h = new float[1];

        /* renamed from: i, reason: collision with root package name */
        public ConstraintAttribute f38477i;

        @Override // m0.e
        public void b(Object obj) {
            this.f38477i = (ConstraintAttribute) obj;
        }

        @Override // q0.AbstractC5139c
        public void i(View view, float f10) {
            this.f38476h[0] = a(f10);
            C5137a.b(this.f38477i, view, this.f38476h);
        }
    }

    /* renamed from: q0.c$c, reason: collision with other inner class name */
    public static class C0500c extends AbstractC5139c {
        @Override // q0.AbstractC5139c
        public void i(View view, float f10) {
            view.setElevation(a(f10));
        }
    }

    /* renamed from: q0.c$d */
    public static class d extends AbstractC5139c {
        @Override // q0.AbstractC5139c
        public void i(View view, float f10) {
        }

        public void j(View view, float f10, double d10, double d11) {
            view.setRotation(a(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }
    }

    /* renamed from: q0.c$e */
    public static class e extends AbstractC5139c {

        /* renamed from: h, reason: collision with root package name */
        public boolean f38478h = false;

        @Override // q0.AbstractC5139c
        public void i(View view, float f10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f10));
                return;
            }
            if (this.f38478h) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f38478h = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f10)));
                } catch (IllegalAccessException e10) {
                    Log.e("ViewOscillator", "unable to setProgress", e10);
                } catch (InvocationTargetException e11) {
                    Log.e("ViewOscillator", "unable to setProgress", e11);
                }
            }
        }
    }

    /* renamed from: q0.c$f */
    public static class f extends AbstractC5139c {
        @Override // q0.AbstractC5139c
        public void i(View view, float f10) {
            view.setRotation(a(f10));
        }
    }

    /* renamed from: q0.c$g */
    public static class g extends AbstractC5139c {
        @Override // q0.AbstractC5139c
        public void i(View view, float f10) {
            view.setRotationX(a(f10));
        }
    }

    /* renamed from: q0.c$h */
    public static class h extends AbstractC5139c {
        @Override // q0.AbstractC5139c
        public void i(View view, float f10) {
            view.setRotationY(a(f10));
        }
    }

    /* renamed from: q0.c$i */
    public static class i extends AbstractC5139c {
        @Override // q0.AbstractC5139c
        public void i(View view, float f10) {
            view.setScaleX(a(f10));
        }
    }

    /* renamed from: q0.c$j */
    public static class j extends AbstractC5139c {
        @Override // q0.AbstractC5139c
        public void i(View view, float f10) {
            view.setScaleY(a(f10));
        }
    }

    /* renamed from: q0.c$k */
    public static class k extends AbstractC5139c {
        @Override // q0.AbstractC5139c
        public void i(View view, float f10) {
            view.setTranslationX(a(f10));
        }
    }

    /* renamed from: q0.c$l */
    public static class l extends AbstractC5139c {
        @Override // q0.AbstractC5139c
        public void i(View view, float f10) {
            view.setTranslationY(a(f10));
        }
    }

    /* renamed from: q0.c$m */
    public static class m extends AbstractC5139c {
        @Override // q0.AbstractC5139c
        public void i(View view, float f10) {
            view.setTranslationZ(a(f10));
        }
    }

    public static AbstractC5139c h(String str) {
        if (str.startsWith("CUSTOM")) {
            return new b();
        }
        switch (str) {
            case "rotationX":
                return new g();
            case "rotationY":
                return new h();
            case "translationX":
                return new k();
            case "translationY":
                return new l();
            case "translationZ":
                return new m();
            case "progress":
                return new e();
            case "scaleX":
                return new i();
            case "scaleY":
                return new j();
            case "waveVariesBy":
                return new a();
            case "rotation":
                return new f();
            case "elevation":
                return new C0500c();
            case "transitionPathRotate":
                return new d();
            case "alpha":
                return new a();
            case "waveOffset":
                return new a();
            default:
                return null;
        }
    }

    public abstract void i(View view, float f10);
}
