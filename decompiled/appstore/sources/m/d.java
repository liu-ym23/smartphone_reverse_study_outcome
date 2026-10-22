package m;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends androidx.constraintlayout.core.motion.utils.b {

    public static class a extends d {
        public a() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
            r10.setAlpha(a(r11));
        }
    }

    public static class b extends d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f22004f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public SparseArray f22005g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float[] f22006h;

        public b(String r10, SparseArray r11) {
            this.f22004f = r10.split(",")[1];
            this.f22005g = r11;
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public void c(int r10, float r11) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public void e(int r12) {
            int r10 = this.f22005g.size();
            int r11 = ((ConstraintAttribute) this.f22005g.valueAt(0)).g();
            double[] r13 = new double[r10];
            this.f22006h = new float[r11];
            double[][] r14 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r10, r11});
            int r15 = 0;
        L3:
            if (r15 >= r10) goto L9;
            int r16 = this.f22005g.keyAt(r15);
            ConstraintAttribute r17 = (ConstraintAttribute) this.f22005g.valueAt(r15);
            r13[r15] = ((double) r16) * 0.01d;
            r17.e(this.f22006h);
            int r18 = 0;
        L5:
            float[] r19 = this.f22006h;
            if (r18 >= r19.length) goto L8;
            r14[r15][r18] = r19[r18];
            r18 = r18 + 1;
            goto L5
        L8:
            r15 = r15 + 1;
            goto L3
        L9:
            this.f1396a = p001j.b.a(r12, r13, r14);
        }

        @Override // m.d
        public void h(View r10, float r11) {
            this.f1396a.e(r11, this.f22006h);
            m.a.b((ConstraintAttribute) this.f22005g.valueAt(0), r10, this.f22006h);
        }

        public void i(int r10, ConstraintAttribute r11) {
            this.f22005g.append(r10, r11);
        }
    }

    public static class c extends d {
        public c() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
            r10.setElevation(a(r11));
        }
    }

    /* JADX INFO: renamed from: m.d$d, reason: collision with other inner class name */
    public static class C0310d extends d {
        public C0310d() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
        }

        public void i(View r10, float r11, double r12, double r13) {
            r10.setRotation(a(r11) + ((float) Math.toDegrees(Math.atan2(r13, r12))));
        }
    }

    public static class e extends d {
        public e() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
            r10.setPivotX(a(r11));
        }
    }

    public static class f extends d {
        public f() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
            r10.setPivotY(a(r11));
        }
    }

    public static class g extends d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f22007f;

        public g() {
            this.f22007f = false;
        }

        @Override // m.d
        public void h(View r10, float r11) {
            if ((r10 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r10).setProgress(a(r11));
            return;
        L6:
            if (this.f22007f == false) goto L21;
            return;
        L21:
            Method r12 = r10.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L10
        L11:
            if (r12 == null) goto L26;
            r12.invoke(r10, new Object[]{Float.valueOf(a(r11))});     // Catch: InvocationTargetException -> L14 IllegalAccessException -> L16
        L28:
            return;
        L16:
            e = move-exception;
            Log.e("ViewSpline", "unable to setProgress", e);
            return;
        L14:
            e = move-exception;
            Log.e("ViewSpline", "unable to setProgress", e);
            return;
        L26:
            return;
        L10:
            this.f22007f = true;
            r12 = null;
            goto L11
        }
    }

    public static class h extends d {
        public h() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
            r10.setRotation(a(r11));
        }
    }

    public static class i extends d {
        public i() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
            r10.setRotationX(a(r11));
        }
    }

    public static class j extends d {
        public j() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
            r10.setRotationY(a(r11));
        }
    }

    public static class k extends d {
        public k() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
            r10.setScaleX(a(r11));
        }
    }

    public static class l extends d {
        public l() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
            r10.setScaleY(a(r11));
        }
    }

    public static class m extends d {
        public m() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
            r10.setTranslationX(a(r11));
        }
    }

    public static class n extends d {
        public n() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
            r10.setTranslationY(a(r11));
        }
    }

    public static class o extends d {
        public o() {
        }

        @Override // m.d
        public void h(View r10, float r11) {
            r10.setTranslationZ(a(r11));
        }
    }

    public d() {
    }

    public static d f(String r10, SparseArray r11) {
        return new b(r10, r11);
    }

    public static d g(String r10) {
        r10.hashCode();
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -1249320806: goto L66;
            case -1249320805: goto L62;
            case -1225497657: goto L58;
            case -1225497656: goto L54;
            case -1225497655: goto L50;
            case -1001078227: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -797520672: goto L34;
            case -760884510: goto L30;
            case -760884509: goto L26;
            case -40300674: goto L22;
            case -4379043: goto L18;
            case 37232917: goto L14;
            case 92909918: goto L10;
            case 156108012: goto L6;
            default: goto L69;
        };
    L69:
        switch(r11) {
            case 0: goto L103;
            case 1: goto L101;
            case 2: goto L99;
            case 3: goto L97;
            case 4: goto L95;
            case 5: goto L93;
            case 6: goto L91;
            case 7: goto L89;
            case 8: goto L87;
            case 9: goto L85;
            case 10: goto L83;
            case 11: goto L81;
            case 12: goto L79;
            case 13: goto L77;
            case 14: goto L75;
            case 15: goto L73;
            default: goto L70;
        };
    L70:
        return null;
    L73:
        return new a();
    L75:
        return new a();
    L77:
        return new C0310d();
    L79:
        return new c();
    L81:
        return new h();
    L83:
        return new f();
    L85:
        return new e();
    L87:
        return new a();
    L89:
        return new l();
    L91:
        return new k();
    L93:
        return new g();
    L95:
        return new o();
    L97:
        return new n();
    L99:
        return new m();
    L101:
        return new j();
    L103:
        return new i();
    L6:
        if (r10.equals("waveOffset") == false) goto L69;
        r11 = Ascii.SI;
        goto L69
    L10:
        if (r10.equals("alpha") == false) goto L69;
        r11 = Ascii.SO;
        goto L69
    L14:
        if (r10.equals("transitionPathRotate") == false) goto L69;
        r11 = Ascii.CR;
        goto L69
    L18:
        if (r10.equals("elevation") == false) goto L69;
        r11 = Ascii.FF;
        goto L69
    L22:
        if (r10.equals("rotation") == false) goto L69;
        r11 = Ascii.VT;
        goto L69
    L26:
        if (r10.equals("transformPivotY") == false) goto L69;
        r11 = 10;
        goto L69
    L30:
        if (r10.equals("transformPivotX") == false) goto L69;
        r11 = 9;
        goto L69
    L34:
        if (r10.equals("waveVariesBy") == false) goto L69;
        r11 = 8;
        goto L69
    L38:
        if (r10.equals("scaleY") == false) goto L69;
        r11 = 7;
        goto L69
    L42:
        if (r10.equals("scaleX") == false) goto L69;
        r11 = 6;
        goto L69
    L46:
        if (r10.equals("progress") == false) goto L69;
        r11 = 5;
        goto L69
    L50:
        if (r10.equals("translationZ") == false) goto L69;
        r11 = 4;
        goto L69
    L54:
        if (r10.equals("translationY") == false) goto L69;
        r11 = 3;
        goto L69
    L58:
        if (r10.equals("translationX") == false) goto L69;
        r11 = 2;
        goto L69
    L62:
        if (r10.equals("rotationY") == false) goto L69;
        r11 = 1;
        goto L69
    L66:
        if (r10.equals("rotationX") == false) goto L69;
        r11 = 0;
        goto L69
    }

    public abstract void h(View r10, float r11);
}
