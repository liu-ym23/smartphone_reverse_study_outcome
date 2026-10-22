package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ViewOscillator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends androidx.constraintlayout.a.a.a.e {
    private static final String TAG = "ViewOscillator";

    /* JADX INFO: compiled from: ViewOscillator.java */
    static class a extends b {
        a() {
        }

        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r1, float r2) {
            r1.setAlpha(a(r2));
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.utils.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ViewOscillator.java */
    static class C0014b extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float[] f825c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected androidx.constraintlayout.widget.a f826d;

        C0014b() {
            this.f825c = new float[1];
        }

        @Override // androidx.constraintlayout.a.a.a.e
        public void a(Object r3) {
            this.f826d = (androidx.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(r3, androidx.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r3, float r4) {
            this.f825c[0] = a(r4);
            androidx.constraintlayout.motion.utils.a.a(this.f826d, r3, this.f825c);
        }
    }

    /* JADX INFO: compiled from: ViewOscillator.java */
    static class c extends b {
        c() {
        }

        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r3, float r4) {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r3.setElevation(a(r4));
            return;
        }
    }

    /* JADX INFO: compiled from: ViewOscillator.java */
    public static class d extends b {
        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r1, float r2) {
        }

        public d() {
        }

        public void a(View r1, float r2, double r3, double r5) {
            r1.setRotation(a(r2) + ((float) Math.toDegrees(Math.atan2(r5, r3))));
        }
    }

    /* JADX INFO: compiled from: ViewOscillator.java */
    static class e extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f827c;

        e() {
            this.f827c = false;
        }

        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r10, float r11) {
            if (ZeusTransformUtils.instanceOf(r10, MotionLayout.class) == false) goto L6;
            ((MotionLayout) ZeusTransformUtils.preCheckCast(r10, MotionLayout.class, "com.obric.aiagent.plugin")).setProgress(a(r11));
            return;
        L6:
            if (this.f827c == false) goto L8;
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
            a(b.TAG, "unable to setProgress", e);
            return;
        L15:
            e = move-exception;
            a(b.TAG, "unable to setProgress", e);
            return;
        L25:
            return;
        L11:
            this.f827c = true;
            goto L12
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: ViewOscillator.java */
    static class f extends b {
        f() {
        }

        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r1, float r2) {
            r1.setRotation(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewOscillator.java */
    static class g extends b {
        g() {
        }

        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r1, float r2) {
            r1.setRotationX(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewOscillator.java */
    static class h extends b {
        h() {
        }

        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r1, float r2) {
            r1.setRotationY(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewOscillator.java */
    static class i extends b {
        i() {
        }

        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r1, float r2) {
            r1.setScaleX(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewOscillator.java */
    static class j extends b {
        j() {
        }

        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r1, float r2) {
            r1.setScaleY(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewOscillator.java */
    static class k extends b {
        k() {
        }

        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r1, float r2) {
            r1.setTranslationX(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewOscillator.java */
    static class l extends b {
        l() {
        }

        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r1, float r2) {
            r1.setTranslationY(a(r2));
        }
    }

    /* JADX INFO: compiled from: ViewOscillator.java */
    static class m extends b {
        m() {
        }

        @Override // androidx.constraintlayout.motion.utils.b
        public void a(View r3, float r4) {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r3.setTranslationZ(a(r4));
            return;
        }
    }

    public abstract void a(View r1, float r2);

    public b() {
    }

    public static b b(String r2) {
        if (r2.startsWith("CUSTOM") == true) goto L5;
        r2.hashCode();
        byte r0 = -1;
        switch(r2.hashCode()) {
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1225497655: goto L46;
            case -1001078227: goto L42;
            case -908189618: goto L38;
            case -908189617: goto L34;
            case -797520672: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 156108012: goto L10;
            default: goto L65;
        };
    L65:
        switch(r0) {
            case 0: goto L95;
            case 1: goto L93;
            case 2: goto L91;
            case 3: goto L89;
            case 4: goto L87;
            case 5: goto L85;
            case 6: goto L83;
            case 7: goto L81;
            case 8: goto L79;
            case 9: goto L77;
            case 10: goto L75;
            case 11: goto L73;
            case 12: goto L71;
            case 13: goto L69;
            default: goto L66;
        };
    L66:
        return null;
    L69:
        return new a();
    L71:
        return new a();
    L73:
        return new d();
    L75:
        return new c();
    L77:
        return new f();
    L79:
        return new a();
    L81:
        return new j();
    L83:
        return new i();
    L85:
        return new e();
    L87:
        return new m();
    L89:
        return new l();
    L91:
        return new k();
    L93:
        return new h();
    L95:
        return new g();
    L10:
        if (r2.equals("waveOffset") == false) goto L65;
        r0 = 13;
        goto L65
    L14:
        if (r2.equals("alpha") == false) goto L65;
        r0 = 12;
        goto L65
    L18:
        if (r2.equals("transitionPathRotate") == false) goto L65;
        r0 = 11;
        goto L65
    L22:
        if (r2.equals("elevation") == false) goto L65;
        r0 = 10;
        goto L65
    L26:
        if (r2.equals("rotation") == false) goto L65;
        r0 = 9;
        goto L65
    L30:
        if (r2.equals("waveVariesBy") == false) goto L65;
        r0 = 8;
        goto L65
    L34:
        if (r2.equals("scaleY") == false) goto L65;
        r0 = 7;
        goto L65
    L38:
        if (r2.equals("scaleX") == false) goto L65;
        r0 = 6;
        goto L65
    L42:
        if (r2.equals("progress") == false) goto L65;
        r0 = 5;
        goto L65
    L46:
        if (r2.equals("translationZ") == false) goto L65;
        r0 = 4;
        goto L65
    L50:
        if (r2.equals("translationY") == false) goto L65;
        r0 = 3;
        goto L65
    L54:
        if (r2.equals("translationX") == false) goto L65;
        r0 = 2;
        goto L65
    L58:
        if (r2.equals("rotationY") == false) goto L65;
        r0 = 1;
        goto L65
    L62:
        if (r2.equals("rotationX") == false) goto L65;
        r0 = 0;
        goto L65
    L5:
        return new C0014b();
    }
}
