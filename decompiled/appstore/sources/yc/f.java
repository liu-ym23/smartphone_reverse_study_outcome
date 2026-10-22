package yc;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.google.common.base.Ascii;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f extends vc.l {

    public static class a extends f {
        public a() {
        }

        @Override // yc.f
        public boolean i(View r10, float r11, long r12, vc.d r13) {
            r10.setAlpha(f(r11, r12, r10, r13));
            return this.f25216h;
        }
    }

    public static class b extends f {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f26242l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public SparseArray f26243m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public SparseArray f26244n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float[] f26245o;

        public b(String r10, SparseArray r11) {
            this.f26244n = new SparseArray();
            this.f26242l = r10.split(",")[1];
            this.f26243m = r11;
        }

        @Override // vc.l
        public void b(int r10, float r11, float r12, int r13, float r14) {
            throw new RuntimeException("Wrong call for custom attribute");
        }

        @Override // vc.l
        public void e(int r15) {
            int r10 = this.f26243m.size();
            int r11 = ((ConstraintAttribute) this.f26243m.valueAt(0)).h();
            double[] r12 = new double[r10];
            int r13 = r11 + 2;
            this.f26245o = new float[r13];
            this.f25215g = new float[r11];
            double[][] r14 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r10, r13});
            int r16 = 0;
        L3:
            if (r16 >= r10) goto L9;
            int r17 = this.f26243m.keyAt(r16);
            ConstraintAttribute r18 = (ConstraintAttribute) this.f26243m.valueAt(r16);
            float[] r19 = (float[]) this.f26244n.valueAt(r16);
            r12[r16] = ((double) r17) * 0.01d;
            r18.f(this.f26245o);
            int r20 = 0;
        L5:
            float[] r21 = this.f26245o;
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
            this.f25209a = vc.b.a(r15, r12, r14);
        }

        @Override // yc.f
        public boolean i(View r17, float r18, long r19, vc.d r21) {
            this.f25209a.e(r18, this.f26245o);
            float[] r10 = this.f26245o;
            float r11 = r10[r10.length - 2];
            float r12 = r10[r10.length - 1];
            long r13 = r19 - this.f25217i;
            if (Float.isNaN(this.f25218j) == false) goto L7;
            float r14 = r21.a(r17, this.f26242l, 0);
            this.f25218j = r14;
            if (Float.isNaN(r14) == false) goto L7;
            this.f25218j = 0.0f;
        L7:
            float r15 = (float) ((((double) this.f25218j) + ((r13 * 1.0E-9d) * ((double) r11))) % 1.0d);
            this.f25218j = r15;
            this.f25217i = r19;
            float r16 = a(r15);
            this.f25216h = false;
            int r20 = 0;
        L8:
            float[] r22 = this.f25215g;
            if (r20 >= r22.length) goto L15;
            boolean r23 = this.f25216h;
            float r24 = this.f26245o[r20];
            if (r24 == 0.0d) goto L13;
            boolean r110 = true;
        L14:
            this.f25216h = r23 | r110;
            r22[r20] = (r24 * r16) + r12;
            r20 = r20 + 1;
            goto L8
        L13:
            r110 = false;
            goto L14
        L15:
            yc.a.b((ConstraintAttribute) this.f26243m.valueAt(0), r17, this.f25215g);
            if (r11 == 0.0f) goto L19;
            this.f25216h = true;
        L19:
            return this.f25216h;
        }

        public void j(int r10, ConstraintAttribute r11, float r12, int r13, float r14) {
            this.f26243m.append(r10, r11);
            this.f26244n.append(r10, new float[]{r12, r14});
            this.f25210b = Math.max(this.f25210b, r13);
        }
    }

    public static class c extends f {
        public c() {
        }

        @Override // yc.f
        public boolean i(View r10, float r11, long r12, vc.d r13) {
            r10.setElevation(f(r11, r12, r10, r13));
            return this.f25216h;
        }
    }

    public static class d extends f {
        public d() {
        }

        @Override // yc.f
        public boolean i(View r10, float r11, long r12, vc.d r13) {
            return this.f25216h;
        }

        public boolean j(View r10, vc.d r11, float r12, long r13, double r14, double r15) {
            r10.setRotation(f(r12, r13, r10, r11) + ((float) Math.toDegrees(Math.atan2(r15, r14))));
            return this.f25216h;
        }
    }

    public static class e extends f {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f26246l;

        public e() {
            this.f26246l = false;
        }

        @Override // yc.f
        public boolean i(View r10, float r11, long r12, vc.d r14) {
            if ((r10 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r10).setProgress(f(r11, r12, r10, r14));
        L23:
            return this.f25216h;
        L6:
            if (this.f26246l == false) goto L24;
            return false;
        L24:
            Method r13 = r10.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r13 == null) goto L23;
            r13.invoke(r10, new Object[]{Float.valueOf(f(r11, r12, r10, r14))});     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18
        L18:
            e = move-exception;
            Log.e("ViewTimeCycle", "unable to setProgress", e);
        L16:
            e = move-exception;
            Log.e("ViewTimeCycle", "unable to setProgress", e);
        L11:
            this.f26246l = true;
            r13 = null;
            goto L12
        }
    }

    /* JADX INFO: renamed from: yc.f$f, reason: collision with other inner class name */
    public static class C0419f extends f {
        public C0419f() {
        }

        @Override // yc.f
        public boolean i(View r10, float r11, long r12, vc.d r13) {
            r10.setRotation(f(r11, r12, r10, r13));
            return this.f25216h;
        }
    }

    public static class g extends f {
        public g() {
        }

        @Override // yc.f
        public boolean i(View r10, float r11, long r12, vc.d r13) {
            r10.setRotationX(f(r11, r12, r10, r13));
            return this.f25216h;
        }
    }

    public static class h extends f {
        public h() {
        }

        @Override // yc.f
        public boolean i(View r10, float r11, long r12, vc.d r13) {
            r10.setRotationY(f(r11, r12, r10, r13));
            return this.f25216h;
        }
    }

    public static class i extends f {
        public i() {
        }

        @Override // yc.f
        public boolean i(View r10, float r11, long r12, vc.d r13) {
            r10.setScaleX(f(r11, r12, r10, r13));
            return this.f25216h;
        }
    }

    public static class j extends f {
        public j() {
        }

        @Override // yc.f
        public boolean i(View r10, float r11, long r12, vc.d r13) {
            r10.setScaleY(f(r11, r12, r10, r13));
            return this.f25216h;
        }
    }

    public static class k extends f {
        public k() {
        }

        @Override // yc.f
        public boolean i(View r10, float r11, long r12, vc.d r13) {
            r10.setTranslationX(f(r11, r12, r10, r13));
            return this.f25216h;
        }
    }

    public static class l extends f {
        public l() {
        }

        @Override // yc.f
        public boolean i(View r10, float r11, long r12, vc.d r13) {
            r10.setTranslationY(f(r11, r12, r10, r13));
            return this.f25216h;
        }
    }

    public static class m extends f {
        public m() {
        }

        @Override // yc.f
        public boolean i(View r10, float r11, long r12, vc.d r13) {
            r10.setTranslationZ(f(r11, r12, r10, r13));
            return this.f25216h;
        }
    }

    public f() {
    }

    public static f g(String r10, SparseArray r11) {
        return new b(r10, r11);
    }

    public static f h(String r10, long r11) {
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
        r13.c(r11);
        return r13;
    L57:
        r13 = new d();
        goto L68
    L58:
        r13 = new c();
        goto L68
    L59:
        r13 = new C0419f();
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

    public float f(float r19, long r20, View r22, vc.d r23) {
        this.f25209a.e(r19, this.f25215g);
        float[] r10 = this.f25215g;
        float r11 = r10[1];
        if (r11 != 0.0f) goto L7;
        this.f25216h = false;
        return r10[2];
    L7:
        if (Float.isNaN(this.f25218j) == false) goto L11;
        float r12 = r23.a(r22, this.f25214f, 0);
        this.f25218j = r12;
        if (Float.isNaN(r12) == false) goto L11;
        this.f25218j = 0.0f;
    L11:
        float r13 = (float) ((((double) this.f25218j) + (((r20 - this.f25217i) * 1.0E-9d) * ((double) r11))) % 1.0d);
        this.f25218j = r13;
        r23.b(r22, this.f25214f, 0, r13);
        this.f25217i = r20;
        float r14 = this.f25215g[0];
        float r15 = (a(this.f25218j) * r14) + this.f25215g[2];
        if (r14 != 0.0f) goto L16;
        if (r11 != 0.0f) goto L16;
        boolean r16 = false;
    L17:
        this.f25216h = r16;
        return r15;
    L16:
        r16 = true;
        goto L17
    }

    public abstract boolean i(View r10, float r11, long r12, vc.d r13);
}
