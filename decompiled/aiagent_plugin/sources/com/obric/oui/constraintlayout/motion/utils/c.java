package com.obric.oui.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ViewSpline.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c extends com.obric.oui.constraintlayout.a.a.a.j {
    private static final String TAG = "ViewSpline";

    /* JADX INFO: compiled from: ViewSpline.java */
    static class a extends c {
        a() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
            r1.setAlpha(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    public static class b extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f34810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        SparseArray<com.obric.oui.constraintlayout.widget.a> f34811e;
        float[] f;

        public b(String r2, SparseArray<com.obric.oui.constraintlayout.widget.a> r3) {
            this.f34810d = r2.split(",")[1];
            this.f34811e = r3;
        }

        @Override // com.obric.oui.constraintlayout.a.a.a.j
        public void a(int r13) {
            int r0 = this.f34811e.size();
            int r1 = ((com.obric.oui.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.f34811e.valueAt(0), com.obric.oui.constraintlayout.widget.a.class, "com.obric.aiagent.plugin")).c();
            double[] r3 = new double[r0];
            this.f = new float[r1];
            double[][] r2 = (double[][]) Array.newInstance(double.class, new int[]{r0, r1});
            int r5 = 0;
        L3:
            if (r5 >= r0) goto L9;
            int r6 = this.f34811e.keyAt(r5);
            com.obric.oui.constraintlayout.widget.a r7 = (com.obric.oui.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.f34811e.valueAt(r5), com.obric.oui.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
            r3[r5] = ((double) r6) * 0.01d;
            r7.a(this.f);
            int r8 = 0;
        L5:
            float[] r9 = this.f;
            if (r8 >= r9.length) goto L8;
            r2[r5][r8] = r9[r8];
            r8 = r8 + 1;
            goto L5
        L8:
            r5 = r5 + 1;
            goto L3
        L9:
            this.f34630a = com.obric.oui.constraintlayout.a.a.a.b.a(r13, r3, r2);
        }

        @Override // com.obric.oui.constraintlayout.a.a.a.j
        public void a(int r1, float r2) {
            throw new RuntimeException("call of custom attribute setPoint");
        }

        public void a(int r1, com.obric.oui.constraintlayout.widget.a r2) {
            this.f34811e.append(r1, r2);
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r4, float r5) {
            this.f34630a.a(r5, this.f);
            com.obric.oui.constraintlayout.motion.utils.a.a((com.obric.oui.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.f34811e.valueAt(0), com.obric.oui.constraintlayout.widget.a.class, "com.obric.aiagent.plugin"), r4, this.f);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.motion.utils.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ViewSpline.java */
    static class C0941c extends c {
        C0941c() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
            r1.setElevation(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    public static class d extends c {
        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
        }

        public d() {
        }

        public void a(View r1, float r2, double r3, double r5) {
            r1.setRotation(a(r2) + ((float) Math.toDegrees(Math.atan2(r5, r3))));
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    static class e extends c {
        e() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
            r1.setPivotX(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    static class f extends c {
        f() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
            r1.setPivotY(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    static class g extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f34812d;

        g() {
            this.f34812d = false;
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r10, float r11) {
            if (ZeusTransformUtils.instanceOf(r10, MotionLayout.class) == false) goto L6;
            ((MotionLayout) ZeusTransformUtils.preCheckCast(r10, MotionLayout.class, "com.obric.aiagent.plugin")).setProgress(a(r11));
            return;
        L6:
            if (this.f34812d == false) goto L8;
            return;
        L8:
            Method r2 = null;
            r2 = r10.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r2 == null) goto L25;
            r2.invoke(r10, new Object[]{Float.valueOf(a(r11))});     // Catch: InvocationTargetException -> L15 IllegalAccessException -> L17
        L27:
            return;
        L17:
            e = move-exception;
            a(c.TAG, "unable to setProgress", e);
            return;
        L15:
            e = move-exception;
            a(c.TAG, "unable to setProgress", e);
            return;
        L25:
            return;
        L11:
            this.f34812d = true;
            goto L12
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    static class h extends c {
        h() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
            r1.setRotation(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    static class i extends c {
        i() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
            r1.setRotationX(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    static class j extends c {
        j() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
            r1.setRotationY(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    static class k extends c {
        k() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
            r1.setScaleX(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    static class l extends c {
        l() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
            r1.setScaleY(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    static class m extends c {
        m() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
            r1.setTranslationX(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    static class n extends c {
        n() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
            r1.setTranslationY(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewSpline.java */
    static class o extends c {
        o() {
        }

        @Override // com.obric.oui.constraintlayout.motion.utils.c
        public void a(View r1, float r2) {
            r1.setTranslationZ(a(r2));
        }
    }

    public abstract void a(View r1, float r2);

    public c() {
    }

    public static c a(String r1, SparseArray<com.obric.oui.constraintlayout.widget.a> r2) {
        return new b(r1, r2);
    }

    public static c b(String r2) {
        r2.hashCode();
        byte r1 = -1;
        switch(r2.hashCode()) {
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
        switch(r1) {
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
        return new d();
    L79:
        return new C0941c();
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
        if (r2.equals("waveOffset") == false) goto L69;
        r1 = 15;
        goto L69
    L10:
        if (r2.equals("alpha") == false) goto L69;
        r1 = 14;
        goto L69
    L14:
        if (r2.equals("transitionPathRotate") == false) goto L69;
        r1 = 13;
        goto L69
    L18:
        if (r2.equals("elevation") == false) goto L69;
        r1 = 12;
        goto L69
    L22:
        if (r2.equals("rotation") == false) goto L69;
        r1 = 11;
        goto L69
    L26:
        if (r2.equals("transformPivotY") == false) goto L69;
        r1 = 10;
        goto L69
    L30:
        if (r2.equals("transformPivotX") == false) goto L69;
        r1 = 9;
        goto L69
    L34:
        if (r2.equals("waveVariesBy") == false) goto L69;
        r1 = 8;
        goto L69
    L38:
        if (r2.equals("scaleY") == false) goto L69;
        r1 = 7;
        goto L69
    L42:
        if (r2.equals("scaleX") == false) goto L69;
        r1 = 6;
        goto L69
    L46:
        if (r2.equals("progress") == false) goto L69;
        r1 = 5;
        goto L69
    L50:
        if (r2.equals("translationZ") == false) goto L69;
        r1 = 4;
        goto L69
    L54:
        if (r2.equals("translationY") == false) goto L69;
        r1 = 3;
        goto L69
    L58:
        if (r2.equals("translationX") == false) goto L69;
        r1 = 2;
        goto L69
    L62:
        if (r2.equals("rotationY") == false) goto L69;
        r1 = 1;
        goto L69
    L66:
        if (r2.equals("rotationX") == false) goto L69;
        r1 = 0;
        goto L69
    }
}
