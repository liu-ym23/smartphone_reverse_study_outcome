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
public abstract class f extends p001j.l {

    public static class a extends f {
        public a() {
        }

        @Override // m.f
        public boolean h(View r10, float r11, long r12, p001j.d r13) {
            r10.setAlpha(e(r11, r12, r10, r13));
            return this.f20845h;
        }
    }

    public static class b extends f {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f22008l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public SparseArray f22009m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public SparseArray f22010n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float[] f22011o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float[] f22012p;

        public b(String r10, SparseArray r11) {
            this.f22010n = new SparseArray();
            this.f22008l = r10.split(",")[1];
            this.f22009m = r11;
        }

        @Override // p001j.l
        public void d(int r15) {
            int r10 = this.f22009m.size();
            int r11 = ((ConstraintAttribute) this.f22009m.valueAt(0)).g();
            double[] r12 = new double[r10];
            int r13 = r11 + 2;
            this.f22011o = new float[r13];
            this.f22012p = new float[r11];
            double[][] r14 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r10, r13});
            int r16 = 0;
        L3:
            if (r16 >= r10) goto L9;
            int r17 = this.f22009m.keyAt(r16);
            ConstraintAttribute r18 = (ConstraintAttribute) this.f22009m.valueAt(r16);
            float[] r19 = (float[]) this.f22010n.valueAt(r16);
            r12[r16] = ((double) r17) * 0.01d;
            r18.e(this.f22011o);
            int r20 = 0;
        L5:
            float[] r21 = this.f22011o;
            if (r20 >= r21.length) goto L8;
            r14[r16][r20] = r21[r20];
            r20 = r20 + 1;
            goto L5
        L8:
            double[] r22 = r14[r16];
            r22[r11] = r19[0];
            r22[r11 + 1] = r19[1];
            r16 = r16 + 1;
            goto L3
        L9:
            this.f20838a = p001j.b.a(r15, r12, r14);
        }

        @Override // m.f
        public boolean h(View r17, float r18, long r19, p001j.d r21) {
            this.f20838a.e(r18, this.f22011o);
            float[] r10 = this.f22011o;
            float r11 = r10[r10.length - 2];
            float r12 = r10[r10.length - 1];
            long r13 = r19 - this.f20846i;
            if (Float.isNaN(this.f20847j) == false) goto L7;
            float r14 = r21.a(r17, this.f22008l, 0);
            this.f20847j = r14;
            if (Float.isNaN(r14) == false) goto L7;
            this.f20847j = 0.0f;
        L7:
            float r15 = (float) ((((double) this.f20847j) + ((r13 * 1.0E-9d) * ((double) r11))) % 1.0d);
            this.f20847j = r15;
            this.f20846i = r19;
            float r16 = a(r15);
            this.f20845h = false;
            int r20 = 0;
        L8:
            float[] r22 = this.f22012p;
            if (r20 >= r22.length) goto L15;
            boolean r23 = this.f20845h;
            float r24 = this.f22011o[r20];
            if (r24 == 0.0d) goto L13;
            boolean r110 = true;
        L14:
            this.f20845h = r23 | r110;
            r22[r20] = (r24 * r16) + r12;
            r20 = r20 + 1;
            goto L8
        L13:
            r110 = false;
            goto L14
        L15:
            m.a.b((ConstraintAttribute) this.f22009m.valueAt(0), r17, this.f22012p);
            if (r11 == 0.0f) goto L19;
            this.f20845h = true;
        L19:
            return this.f20845h;
        }
    }

    public static class c extends f {
        public c() {
        }

        @Override // m.f
        public boolean h(View r10, float r11, long r12, p001j.d r13) {
            r10.setElevation(e(r11, r12, r10, r13));
            return this.f20845h;
        }
    }

    public static class d extends f {
        public d() {
        }

        @Override // m.f
        public boolean h(View r10, float r11, long r12, p001j.d r13) {
            return this.f20845h;
        }

        public boolean i(View r10, p001j.d r11, float r12, long r13, double r14, double r15) {
            r10.setRotation(e(r12, r13, r10, r11) + ((float) Math.toDegrees(Math.atan2(r15, r14))));
            return this.f20845h;
        }
    }

    public static class e extends f {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f22013l;

        public e() {
            this.f22013l = false;
        }

        @Override // m.f
        public boolean h(View r10, float r11, long r12, p001j.d r14) {
            if ((r10 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r10).setProgress(e(r11, r12, r10, r14));
        L23:
            return this.f20845h;
        L6:
            if (this.f22013l == false) goto L24;
            return false;
        L24:
            Method r13 = r10.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r13 == null) goto L23;
            r13.invoke(r10, new Object[]{Float.valueOf(e(r11, r12, r10, r14))});     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18
        L18:
            e = move-exception;
            Log.e("ViewTimeCycle", "unable to setProgress", e);
        L16:
            e = move-exception;
            Log.e("ViewTimeCycle", "unable to setProgress", e);
        L11:
            this.f22013l = true;
            r13 = null;
            goto L12
        }
    }

    /* JADX INFO: renamed from: m.f$f, reason: collision with other inner class name */
    public static class C0311f extends f {
        public C0311f() {
        }

        @Override // m.f
        public boolean h(View r10, float r11, long r12, p001j.d r13) {
            r10.setRotation(e(r11, r12, r10, r13));
            return this.f20845h;
        }
    }

    public static class g extends f {
        public g() {
        }

        @Override // m.f
        public boolean h(View r10, float r11, long r12, p001j.d r13) {
            r10.setRotationX(e(r11, r12, r10, r13));
            return this.f20845h;
        }
    }

    public static class h extends f {
        public h() {
        }

        @Override // m.f
        public boolean h(View r10, float r11, long r12, p001j.d r13) {
            r10.setRotationY(e(r11, r12, r10, r13));
            return this.f20845h;
        }
    }

    public static class i extends f {
        public i() {
        }

        @Override // m.f
        public boolean h(View r10, float r11, long r12, p001j.d r13) {
            r10.setScaleX(e(r11, r12, r10, r13));
            return this.f20845h;
        }
    }

    public static class j extends f {
        public j() {
        }

        @Override // m.f
        public boolean h(View r10, float r11, long r12, p001j.d r13) {
            r10.setScaleY(e(r11, r12, r10, r13));
            return this.f20845h;
        }
    }

    public static class k extends f {
        public k() {
        }

        @Override // m.f
        public boolean h(View r10, float r11, long r12, p001j.d r13) {
            r10.setTranslationX(e(r11, r12, r10, r13));
            return this.f20845h;
        }
    }

    public static class l extends f {
        public l() {
        }

        @Override // m.f
        public boolean h(View r10, float r11, long r12, p001j.d r13) {
            r10.setTranslationY(e(r11, r12, r10, r13));
            return this.f20845h;
        }
    }

    public static class m extends f {
        public m() {
        }

        @Override // m.f
        public boolean h(View r10, float r11, long r12, p001j.d r13) {
            r10.setTranslationZ(e(r11, r12, r10, r13));
            return this.f20845h;
        }
    }

    public f() {
    }

    public static f f(String r10, SparseArray r11) {
        return new b(r10, r11);
    }

    public static f g(String r10, long r11) {
        r10.hashCode();
        byte r12 = -1;
        switch(r10.hashCode()) {
            case -1249320806: goto L50;
            case -1249320805: goto L46;
            case -1225497657: goto L42;
            case -1225497656: goto L38;
            case -1225497655: goto L34;
            case -1001078227: goto L30;
            case -908189618: goto L26;
            case -908189617: goto L22;
            case -40300674: goto L18;
            case -4379043: goto L14;
            case 37232917: goto L10;
            case 92909918: goto L6;
            default: goto L53;
        };
    L53:
        switch(r12) {
            case 0: goto L67;
            case 1: goto L66;
            case 2: goto L65;
            case 3: goto L64;
            case 4: goto L63;
            case 5: goto L62;
            case 6: goto L61;
            case 7: goto L60;
            case 8: goto L59;
            case 9: goto L58;
            case 10: goto L57;
            case 11: goto L56;
            default: goto L54;
        };
    L54:
        return null;
    L56:
        f r13 = new a();
    L68:
        r13.b(r11);
        return r13;
    L57:
        r13 = new d();
        goto L68
    L58:
        r13 = new c();
        goto L68
    L59:
        r13 = new C0311f();
        goto L68
    L60:
        r13 = new j();
        goto L68
    L61:
        r13 = new i();
        goto L68
    L62:
        r13 = new e();
        goto L68
    L63:
        r13 = new m();
        goto L68
    L64:
        r13 = new l();
        goto L68
    L65:
        r13 = new k();
        goto L68
    L66:
        r13 = new h();
        goto L68
    L67:
        r13 = new g();
        goto L68
    L6:
        if (r10.equals("alpha") == false) goto L53;
        r12 = Ascii.VT;
        goto L53
    L10:
        if (r10.equals("transitionPathRotate") == false) goto L53;
        r12 = 10;
        goto L53
    L14:
        if (r10.equals("elevation") == false) goto L53;
        r12 = 9;
        goto L53
    L18:
        if (r10.equals("rotation") == false) goto L53;
        r12 = 8;
        goto L53
    L22:
        if (r10.equals("scaleY") == false) goto L53;
        r12 = 7;
        goto L53
    L26:
        if (r10.equals("scaleX") == false) goto L53;
        r12 = 6;
        goto L53
    L30:
        if (r10.equals("progress") == false) goto L53;
        r12 = 5;
        goto L53
    L34:
        if (r10.equals("translationZ") == false) goto L53;
        r12 = 4;
        goto L53
    L38:
        if (r10.equals("translationY") == false) goto L53;
        r12 = 3;
        goto L53
    L42:
        if (r10.equals("translationX") == false) goto L53;
        r12 = 2;
        goto L53
    L46:
        if (r10.equals("rotationY") == false) goto L53;
        r12 = 1;
        goto L53
    L50:
        if (r10.equals("rotationX") == false) goto L53;
        r12 = 0;
        goto L53
    }

    public float e(float r19, long r20, View r22, p001j.d r23) {
        this.f20838a.e(r19, this.f20844g);
        float[] r10 = this.f20844g;
        float r11 = r10[1];
        if (r11 != 0.0f) goto L7;
        this.f20845h = false;
        return r10[2];
    L7:
        if (Float.isNaN(this.f20847j) == false) goto L11;
        float r12 = r23.a(r22, this.f20843f, 0);
        this.f20847j = r12;
        if (Float.isNaN(r12) == false) goto L11;
        this.f20847j = 0.0f;
    L11:
        float r13 = (float) ((((double) this.f20847j) + (((r20 - this.f20846i) * 1.0E-9d) * ((double) r11))) % 1.0d);
        this.f20847j = r13;
        r23.b(r22, this.f20843f, 0, r13);
        this.f20846i = r20;
        float r14 = this.f20844g[0];
        float r15 = (a(this.f20847j) * r14) + this.f20844g[2];
        if (r14 != 0.0f) goto L16;
        if (r11 != 0.0f) goto L16;
        boolean r16 = false;
    L17:
        this.f20845h = r16;
        return r15;
    L16:
        r16 = true;
        goto L17
    }

    public abstract boolean h(View r10, float r11, long r12, p001j.d r13);
}
