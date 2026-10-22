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
import m0.C4891d;
import m0.o;

/* renamed from: q0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5142f extends o {

    /* renamed from: q0.f$a */
    public static class a extends AbstractC5142f {
        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) {
            view.setAlpha(f(f10, j10, view, c4891d));
            return this.f37151h;
        }
    }

    /* renamed from: q0.f$b */
    public static class b extends AbstractC5142f {

        /* renamed from: l, reason: collision with root package name */
        public String f38488l;

        /* renamed from: m, reason: collision with root package name */
        public SparseArray<ConstraintAttribute> f38489m;

        /* renamed from: n, reason: collision with root package name */
        public SparseArray<float[]> f38490n = new SparseArray<>();

        /* renamed from: o, reason: collision with root package name */
        public float[] f38491o;

        public b(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f38488l = str.split(Const.STR_MART_COMMA)[1];
            this.f38489m = sparseArray;
        }

        @Override // m0.o
        public void b(int i10, float f10, float f11, int i11, float f12) {
            throw new RuntimeException("Wrong call for custom attribute");
        }

        @Override // m0.o
        public void e(int i10) {
            int size = this.f38489m.size();
            int iH = this.f38489m.valueAt(0).h();
            double[] dArr = new double[size];
            int i11 = iH + 2;
            this.f38491o = new float[i11];
            this.f37150g = new float[iH];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i11);
            for (int i12 = 0; i12 < size; i12++) {
                int iKeyAt = this.f38489m.keyAt(i12);
                ConstraintAttribute constraintAttributeValueAt = this.f38489m.valueAt(i12);
                float[] fArrValueAt = this.f38490n.valueAt(i12);
                dArr[i12] = iKeyAt * 0.01d;
                constraintAttributeValueAt.f(this.f38491o);
                int i13 = 0;
                while (true) {
                    if (i13 < this.f38491o.length) {
                        dArr2[i12][i13] = r8[i13];
                        i13++;
                    }
                }
                double[] dArr3 = dArr2[i12];
                dArr3[iH] = fArrValueAt[0];
                dArr3[iH + 1] = fArrValueAt[1];
            }
            this.f37144a = AbstractC4889b.a(i10, dArr, dArr2);
        }

        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) {
            this.f37144a.e(f10, this.f38491o);
            float[] fArr = this.f38491o;
            float f11 = fArr[fArr.length - 2];
            float f12 = fArr[fArr.length - 1];
            long j11 = j10 - this.f37152i;
            if (Float.isNaN(this.f37153j)) {
                float fA = c4891d.a(view, this.f38488l, 0);
                this.f37153j = fA;
                if (Float.isNaN(fA)) {
                    this.f37153j = 0.0f;
                }
            }
            float f13 = (float) ((this.f37153j + ((j11 * 1.0E-9d) * f11)) % 1.0d);
            this.f37153j = f13;
            this.f37152i = j10;
            float fA2 = a(f13);
            this.f37151h = false;
            int i10 = 0;
            while (true) {
                float[] fArr2 = this.f37150g;
                if (i10 >= fArr2.length) {
                    break;
                }
                boolean z10 = this.f37151h;
                float f14 = this.f38491o[i10];
                this.f37151h = z10 | (((double) f14) != 0.0d);
                fArr2[i10] = (f14 * fA2) + f12;
                i10++;
            }
            C5137a.b(this.f38489m.valueAt(0), view, this.f37150g);
            if (f11 != 0.0f) {
                this.f37151h = true;
            }
            return this.f37151h;
        }

        public void j(int i10, ConstraintAttribute constraintAttribute, float f10, int i11, float f11) {
            this.f38489m.append(i10, constraintAttribute);
            this.f38490n.append(i10, new float[]{f10, f11});
            this.f37145b = Math.max(this.f37145b, i11);
        }
    }

    /* renamed from: q0.f$c */
    public static class c extends AbstractC5142f {
        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) {
            view.setElevation(f(f10, j10, view, c4891d));
            return this.f37151h;
        }
    }

    /* renamed from: q0.f$d */
    public static class d extends AbstractC5142f {
        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) {
            return this.f37151h;
        }

        public boolean j(View view, C4891d c4891d, float f10, long j10, double d10, double d11) {
            view.setRotation(f(f10, j10, view, c4891d) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
            return this.f37151h;
        }
    }

    /* renamed from: q0.f$e */
    public static class e extends AbstractC5142f {

        /* renamed from: l, reason: collision with root package name */
        public boolean f38492l = false;

        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(f(f10, j10, view, c4891d));
            } else {
                if (this.f38492l) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f38492l = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(f(f10, j10, view, c4891d)));
                    } catch (IllegalAccessException e10) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e10);
                    } catch (InvocationTargetException e11) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e11);
                    }
                }
            }
            return this.f37151h;
        }
    }

    /* renamed from: q0.f$f, reason: collision with other inner class name */
    public static class C0502f extends AbstractC5142f {
        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) {
            view.setRotation(f(f10, j10, view, c4891d));
            return this.f37151h;
        }
    }

    /* renamed from: q0.f$g */
    public static class g extends AbstractC5142f {
        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) {
            view.setRotationX(f(f10, j10, view, c4891d));
            return this.f37151h;
        }
    }

    /* renamed from: q0.f$h */
    public static class h extends AbstractC5142f {
        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) {
            view.setRotationY(f(f10, j10, view, c4891d));
            return this.f37151h;
        }
    }

    /* renamed from: q0.f$i */
    public static class i extends AbstractC5142f {
        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) {
            view.setScaleX(f(f10, j10, view, c4891d));
            return this.f37151h;
        }
    }

    /* renamed from: q0.f$j */
    public static class j extends AbstractC5142f {
        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) {
            view.setScaleY(f(f10, j10, view, c4891d));
            return this.f37151h;
        }
    }

    /* renamed from: q0.f$k */
    public static class k extends AbstractC5142f {
        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) {
            view.setTranslationX(f(f10, j10, view, c4891d));
            return this.f37151h;
        }
    }

    /* renamed from: q0.f$l */
    public static class l extends AbstractC5142f {
        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) {
            view.setTranslationY(f(f10, j10, view, c4891d));
            return this.f37151h;
        }
    }

    /* renamed from: q0.f$m */
    public static class m extends AbstractC5142f {
        @Override // q0.AbstractC5142f
        public boolean i(View view, float f10, long j10, C4891d c4891d) {
            view.setTranslationZ(f(f10, j10, view, c4891d));
            return this.f37151h;
        }
    }

    public static AbstractC5142f g(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new b(str, sparseArray);
    }

    public static AbstractC5142f h(String str, long j10) {
        AbstractC5142f gVar;
        str.getClass();
        switch (str) {
            case "rotationX":
                gVar = new g();
                break;
            case "rotationY":
                gVar = new h();
                break;
            case "translationX":
                gVar = new k();
                break;
            case "translationY":
                gVar = new l();
                break;
            case "translationZ":
                gVar = new m();
                break;
            case "progress":
                gVar = new e();
                break;
            case "scaleX":
                gVar = new i();
                break;
            case "scaleY":
                gVar = new j();
                break;
            case "rotation":
                gVar = new C0502f();
                break;
            case "elevation":
                gVar = new c();
                break;
            case "transitionPathRotate":
                gVar = new d();
                break;
            case "alpha":
                gVar = new a();
                break;
            default:
                return null;
        }
        gVar.c(j10);
        return gVar;
    }

    public float f(float f10, long j10, View view, C4891d c4891d) {
        this.f37144a.e(f10, this.f37150g);
        float[] fArr = this.f37150g;
        float f11 = fArr[1];
        if (f11 == 0.0f) {
            this.f37151h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f37153j)) {
            float fA = c4891d.a(view, this.f37149f, 0);
            this.f37153j = fA;
            if (Float.isNaN(fA)) {
                this.f37153j = 0.0f;
            }
        }
        float f12 = (float) ((this.f37153j + (((j10 - this.f37152i) * 1.0E-9d) * f11)) % 1.0d);
        this.f37153j = f12;
        c4891d.b(view, this.f37149f, 0, f12);
        this.f37152i = j10;
        float f13 = this.f37150g[0];
        float fA2 = (a(this.f37153j) * f13) + this.f37150g[2];
        this.f37151h = (f13 == 0.0f && f11 == 0.0f) ? false : true;
        return fA2;
    }

    public abstract boolean i(View view, float f10, long j10, C4891d c4891d);
}
