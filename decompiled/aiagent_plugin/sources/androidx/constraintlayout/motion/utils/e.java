package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.a.a.a.o;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ViewTimeCycle.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends o {
    private static final String TAG = "ViewTimeCycle";

    /* JADX INFO: compiled from: ViewTimeCycle.java */
    static class a extends e {
        a() {
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r7, float r8, long r9, androidx.constraintlayout.a.a.a.d r11) {
            r7.setAlpha(a(r8, r9, r7, r11));
            return this.i;
        }
    }

    /* JADX INFO: compiled from: ViewTimeCycle.java */
    public static class b extends e {
        String l;
        SparseArray<androidx.constraintlayout.widget.a> m;
        SparseArray<float[]> n;
        float[] o;
        float[] p;

        public b(String r2, SparseArray<androidx.constraintlayout.widget.a> r3) {
            this.n = new SparseArray();
            this.l = r2.split(",")[1];
            this.m = r3;
        }

        @Override // androidx.constraintlayout.a.a.a.o
        public void a(int r17) {
            int r1 = this.m.size();
            int r2 = ((androidx.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.m.valueAt(0), androidx.constraintlayout.widget.a.class, "com.obric.aiagent.plugin")).c();
            double[] r4 = new double[r1];
            int r6 = r2 + 2;
            this.o = new float[r6];
            this.p = new float[r2];
            double[][] r7 = (double[][]) Array.newInstance(double.class, new int[]{r1, r6});
            int r8 = 0;
        L3:
            if (r8 >= r1) goto L9;
            int r9 = this.m.keyAt(r8);
            androidx.constraintlayout.widget.a r10 = (androidx.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.m.valueAt(r8), androidx.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
            float[] r11 = (float[]) ZeusTransformUtils.preCheckCast(this.n.valueAt(r8), float[].class, "com.obric.aiagent.plugin");
            r4[r8] = ((double) r9) * 0.01d;
            r10.a(this.o);
            int r12 = 0;
        L5:
            float[] r13 = this.o;
            if (r12 >= r13.length) goto L8;
            r7[r8][r12] = r13[r12];
            r12 = r12 + 1;
            goto L5
        L8:
            r7[r8][r2] = r11[0];
            r7[r8][r2 + 1] = r11[1];
            r8 = r8 + 1;
            goto L3
        L9:
            this.f669a = androidx.constraintlayout.a.a.a.b.a(r17, r4, r7);
        }

        @Override // androidx.constraintlayout.a.a.a.o
        public void a(int r1, float r2, float r3, int r4, float r5) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void a(int r3, androidx.constraintlayout.widget.a r4, float r5, int r6, float r7) {
            this.m.append(r3, r4);
            this.n.append(r3, new float[]{r5, r7});
            this.f670b = Math.max(this.f670b, r6);
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r17, float r18, long r19, androidx.constraintlayout.a.a.a.d r21) {
            this.f669a.a(r18, this.o);
            float[] r4 = this.o;
            float r5 = r4[r4.length - 2];
            float r6 = r4[r4.length - 1];
            long r8 = r19 - this.j;
            if (Float.isNaN(this.k) == false) goto L7;
            this.k = r21.a(r17, this.l, 0);
            if (Float.isNaN(this.k) == false) goto L7;
            this.k = 0.0f;
        L7:
            this.k = (float) ((((double) this.k) + ((r8 * 1.0E-9d) * ((double) r5))) % 1.0d);
            this.j = r19;
            float r2 = a(this.k);
            this.i = false;
            int r3 = 0;
        L9:
            if (r3 >= this.p.length) goto L15;
            boolean r7 = this.i;
            if (this.o[r3] == 0.0d) goto L13;
            boolean r9 = true;
        L14:
            this.i = r7 | r9;
            this.p[r3] = (this.o[r3] * r2) + r6;
            r3 = r3 + 1;
            goto L9
        L13:
            r9 = false;
            goto L14
        L15:
            androidx.constraintlayout.motion.utils.a.a((androidx.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.m.valueAt(0), androidx.constraintlayout.widget.a.class, "com.obric.aiagent.plugin"), r17, this.p);
            if (r5 == 0.0f) goto L19;
            this.i = true;
        L19:
            return this.i;
        }
    }

    /* JADX INFO: compiled from: ViewTimeCycle.java */
    static class c extends e {
        c() {
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r7, float r8, long r9, androidx.constraintlayout.a.a.a.d r11) {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r7.setElevation(a(r8, r9, r7, r11));
        L6:
            return this.i;
        }
    }

    /* JADX INFO: compiled from: ViewTimeCycle.java */
    public static class d extends e {
        public d() {
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r1, float r2, long r3, androidx.constraintlayout.a.a.a.d r5) {
            return this.i;
        }

        public boolean a(View r7, androidx.constraintlayout.a.a.a.d r8, float r9, long r10, double r12, double r14) {
            r7.setRotation(a(r9, r10, r7, r8) + ((float) Math.toDegrees(Math.atan2(r14, r12))));
            return this.i;
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.utils.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ViewTimeCycle.java */
    static class C0016e extends e {
        boolean l;

        C0016e() {
            this.l = false;
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r14, float r15, long r16, androidx.constraintlayout.a.a.a.d r18) {
            if (ZeusTransformUtils.instanceOf(r14, MotionLayout.class) == false) goto L6;
            ((MotionLayout) ZeusTransformUtils.preCheckCast(r14, MotionLayout.class, "com.obric.aiagent.plugin")).setProgress(a(r15, r16, r14, r18));
        L21:
            return this.i;
        L6:
            if (this.l == false) goto L8;
            return false;
        L8:
            Method r1 = null;
            r1 = r14.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            Method r11 = r1;
            if (r11 == null) goto L21;
            r11.invoke(r14, new Object[]{Float.valueOf(a(r15, r16, r14, r18))});     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18
        L18:
            e = move-exception;
            a(e.TAG, "unable to setProgress", e);
        L16:
            e = move-exception;
            a(e.TAG, "unable to setProgress", e);
        L11:
            this.l = true;
            goto L12
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: ViewTimeCycle.java */
    static class f extends e {
        f() {
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r7, float r8, long r9, androidx.constraintlayout.a.a.a.d r11) {
            r7.setRotation(a(r8, r9, r7, r11));
            return this.i;
        }
    }

    /* JADX INFO: compiled from: ViewTimeCycle.java */
    static class g extends e {
        g() {
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r7, float r8, long r9, androidx.constraintlayout.a.a.a.d r11) {
            r7.setRotationX(a(r8, r9, r7, r11));
            return this.i;
        }
    }

    /* JADX INFO: compiled from: ViewTimeCycle.java */
    static class h extends e {
        h() {
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r7, float r8, long r9, androidx.constraintlayout.a.a.a.d r11) {
            r7.setRotationY(a(r8, r9, r7, r11));
            return this.i;
        }
    }

    /* JADX INFO: compiled from: ViewTimeCycle.java */
    static class i extends e {
        i() {
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r7, float r8, long r9, androidx.constraintlayout.a.a.a.d r11) {
            r7.setScaleX(a(r8, r9, r7, r11));
            return this.i;
        }
    }

    /* JADX INFO: compiled from: ViewTimeCycle.java */
    static class j extends e {
        j() {
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r7, float r8, long r9, androidx.constraintlayout.a.a.a.d r11) {
            r7.setScaleY(a(r8, r9, r7, r11));
            return this.i;
        }
    }

    /* JADX INFO: compiled from: ViewTimeCycle.java */
    static class k extends e {
        k() {
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r7, float r8, long r9, androidx.constraintlayout.a.a.a.d r11) {
            r7.setTranslationX(a(r8, r9, r7, r11));
            return this.i;
        }
    }

    /* JADX INFO: compiled from: ViewTimeCycle.java */
    static class l extends e {
        l() {
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r7, float r8, long r9, androidx.constraintlayout.a.a.a.d r11) {
            r7.setTranslationY(a(r8, r9, r7, r11));
            return this.i;
        }
    }

    /* JADX INFO: compiled from: ViewTimeCycle.java */
    static class m extends e {
        m() {
        }

        @Override // androidx.constraintlayout.motion.utils.e
        public boolean a(View r7, float r8, long r9, androidx.constraintlayout.a.a.a.d r11) {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r7.setTranslationZ(a(r8, r9, r7, r11));
        L6:
            return this.i;
        }
    }

    public abstract boolean a(View r1, float r2, long r3, androidx.constraintlayout.a.a.a.d r5);

    public e() {
    }

    public float a(float r18, long r19, View r21, androidx.constraintlayout.a.a.a.d r22) {
        this.f669a.a(r18, this.g);
        float r5 = this.g[1];
        if (r5 != 0.0f) goto L7;
        this.i = false;
        return this.g[2];
    L7:
        if (Float.isNaN(this.k) == false) goto L11;
        this.k = r22.a(r21, this.f, 0);
        if (Float.isNaN(this.k) == false) goto L11;
        this.k = 0.0f;
    L11:
        this.k = (float) ((((double) this.k) + (((r19 - this.j) * 1.0E-9d) * ((double) r5))) % 1.0d);
        r22.a(r21, this.f, 0, this.k);
        this.j = r19;
        float r1 = this.g[0];
        float r2 = (a(this.k) * r1) + this.g[2];
        if (r1 != 0.0f) goto L16;
        if (r5 != 0.0f) goto L16;
        boolean r6 = false;
    L17:
        this.i = r6;
        return r2;
    L16:
        r6 = true;
        goto L17
    }

    public static e a(String r1, SparseArray<androidx.constraintlayout.widget.a> r2) {
        return new b(r1, r2);
    }

    public static e a(String r2, long r3) {
        r2.hashCode();
        byte r1 = -1;
        switch(r2.hashCode()) {
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
        switch(r1) {
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
        e r4 = new a();
    L68:
        r4.a(r3);
        return r4;
    L57:
        r4 = new d();
        goto L68
    L58:
        r4 = new c();
        goto L68
    L59:
        r4 = new f();
        goto L68
    L60:
        r4 = new j();
        goto L68
    L61:
        r4 = new i();
        goto L68
    L62:
        r4 = new C0016e();
        goto L68
    L63:
        r4 = new m();
        goto L68
    L64:
        r4 = new l();
        goto L68
    L65:
        r4 = new k();
        goto L68
    L66:
        r4 = new h();
        goto L68
    L67:
        r4 = new g();
        goto L68
    L6:
        if (r2.equals("alpha") == false) goto L53;
        r1 = 11;
        goto L53
    L10:
        if (r2.equals("transitionPathRotate") == false) goto L53;
        r1 = 10;
        goto L53
    L14:
        if (r2.equals("elevation") == false) goto L53;
        r1 = 9;
        goto L53
    L18:
        if (r2.equals("rotation") == false) goto L53;
        r1 = 8;
        goto L53
    L22:
        if (r2.equals("scaleY") == false) goto L53;
        r1 = 7;
        goto L53
    L26:
        if (r2.equals("scaleX") == false) goto L53;
        r1 = 6;
        goto L53
    L30:
        if (r2.equals("progress") == false) goto L53;
        r1 = 5;
        goto L53
    L34:
        if (r2.equals("translationZ") == false) goto L53;
        r1 = 4;
        goto L53
    L38:
        if (r2.equals("translationY") == false) goto L53;
        r1 = 3;
        goto L53
    L42:
        if (r2.equals("translationX") == false) goto L53;
        r1 = 2;
        goto L53
    L46:
        if (r2.equals("rotationY") == false) goto L53;
        r1 = 1;
        goto L53
    L50:
        if (r2.equals("rotationX") == false) goto L53;
        r1 = 0;
        goto L53
    }
}
