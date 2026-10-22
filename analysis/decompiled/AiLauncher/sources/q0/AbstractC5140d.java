package q0;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import m0.AbstractC4889b;

/* renamed from: q0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5140d extends m0.j {

    /* renamed from: q0.d$a */
    public static class a extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            view.setAlpha(a(f10));
        }
    }

    /* renamed from: q0.d$b */
    public static class b extends AbstractC5140d {

        /* renamed from: f, reason: collision with root package name */
        public String f38479f;

        /* renamed from: g, reason: collision with root package name */
        public SparseArray<ConstraintAttribute> f38480g;

        /* renamed from: h, reason: collision with root package name */
        public float[] f38481h;

        public b(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f38479f = str.split(Const.STR_MART_COMMA)[1];
            this.f38480g = sparseArray;
        }

        @Override // m0.j
        public void b(int i10, float f10) {
            throw new RuntimeException("call of custom attribute setPoint");
        }

        @Override // m0.j
        public void d(int i10) {
            int size = this.f38480g.size();
            int iH = this.f38480g.valueAt(0).h();
            double[] dArr = new double[size];
            this.f38481h = new float[iH];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, iH);
            for (int i11 = 0; i11 < size; i11++) {
                int iKeyAt = this.f38480g.keyAt(i11);
                ConstraintAttribute constraintAttributeValueAt = this.f38480g.valueAt(i11);
                dArr[i11] = iKeyAt * 0.01d;
                constraintAttributeValueAt.f(this.f38481h);
                int i12 = 0;
                while (true) {
                    if (i12 < this.f38481h.length) {
                        dArr2[i11][i12] = r6[i12];
                        i12++;
                    }
                }
            }
            this.f37110a = AbstractC4889b.a(i10, dArr, dArr2);
        }

        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            this.f37110a.e(f10, this.f38481h);
            C5137a.b(this.f38480g.valueAt(0), view, this.f38481h);
        }

        public void h(int i10, ConstraintAttribute constraintAttribute) {
            this.f38480g.append(i10, constraintAttribute);
        }
    }

    /* renamed from: q0.d$c */
    public static class c extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            view.setElevation(a(f10));
        }
    }

    /* renamed from: q0.d$d, reason: collision with other inner class name */
    public static class C0501d extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
        }

        public void h(View view, float f10, double d10, double d11) {
            view.setRotation(a(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }
    }

    /* renamed from: q0.d$e */
    public static class e extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            view.setPivotX(a(f10));
        }
    }

    /* renamed from: q0.d$f */
    public static class f extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            view.setPivotY(a(f10));
        }
    }

    /* renamed from: q0.d$g */
    public static class g extends AbstractC5140d {

        /* renamed from: f, reason: collision with root package name */
        public boolean f38482f = false;

        @Override // q0.AbstractC5140d
        public void g(View view, float f10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f10));
                return;
            }
            if (this.f38482f) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f38482f = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f10)));
                } catch (IllegalAccessException e10) {
                    Log.e("ViewSpline", "unable to setProgress", e10);
                } catch (InvocationTargetException e11) {
                    Log.e("ViewSpline", "unable to setProgress", e11);
                }
            }
        }
    }

    /* renamed from: q0.d$h */
    public static class h extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            view.setRotation(a(f10));
        }
    }

    /* renamed from: q0.d$i */
    public static class i extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            view.setRotationX(a(f10));
        }
    }

    /* renamed from: q0.d$j */
    public static class j extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            view.setRotationY(a(f10));
        }
    }

    /* renamed from: q0.d$k */
    public static class k extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            view.setScaleX(a(f10));
        }
    }

    /* renamed from: q0.d$l */
    public static class l extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            view.setScaleY(a(f10));
        }
    }

    /* renamed from: q0.d$m */
    public static class m extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            view.setTranslationX(a(f10));
        }
    }

    /* renamed from: q0.d$n */
    public static class n extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            view.setTranslationY(a(f10));
        }
    }

    /* renamed from: q0.d$o */
    public static class o extends AbstractC5140d {
        @Override // q0.AbstractC5140d
        public void g(View view, float f10) {
            view.setTranslationZ(a(f10));
        }
    }

    public static AbstractC5140d e(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new b(str, sparseArray);
    }

    public static AbstractC5140d f(String str) {
        str.getClass();
        switch (str) {
        }
        return new a();
    }

    public abstract void g(View view, float f10);
}
