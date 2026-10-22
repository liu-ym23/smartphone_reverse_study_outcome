package yc;

import android.util.Log;
import android.view.View;
import com.google.common.base.Ascii;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c extends com.obric.oui.constraintlayout.core.motion.utils.a {

    public static class a extends c {
        public a() {
        }

        @Override // yc.c
        public void j(View r10, float r11) {
            r10.setAlpha(a(r11));
        }
    }

    public static class b extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float[] f26235h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ConstraintAttribute f26236i;

        public b() {
            this.f26235h = new float[1];
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.a
        public void c(Object r10) {
            this.f26236i = (ConstraintAttribute) r10;
        }

        @Override // yc.c
        public void j(View r10, float r11) {
            this.f26235h[0] = a(r11);
            yc.a.b(this.f26236i, r10, this.f26235h);
        }
    }

    /* JADX INFO: renamed from: yc.c$c, reason: collision with other inner class name */
    public static class C0417c extends c {
        public C0417c() {
        }

        @Override // yc.c
        public void j(View r10, float r11) {
            r10.setElevation(a(r11));
        }
    }

    public static class d extends c {
        public d() {
        }

        @Override // yc.c
        public void j(View r10, float r11) {
        }

        public void k(View r10, float r11, double r12, double r13) {
            r10.setRotation(a(r11) + ((float) Math.toDegrees(Math.atan2(r13, r12))));
        }
    }

    public static class e extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f26237h;

        public e() {
            this.f26237h = false;
        }

        @Override // yc.c
        public void j(View r10, float r11) {
            if ((r10 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r10).setProgress(a(r11));
            return;
        L6:
            if (this.f26237h == false) goto L21;
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
            Log.e("ViewOscillator", "unable to setProgress", e);
            return;
        L14:
            e = move-exception;
            Log.e("ViewOscillator", "unable to setProgress", e);
            return;
        L26:
            return;
        L10:
            this.f26237h = true;
            r12 = null;
            goto L11
        }
    }

    public static class f extends c {
        public f() {
        }

        @Override // yc.c
        public void j(View r10, float r11) {
            r10.setRotation(a(r11));
        }
    }

    public static class g extends c {
        public g() {
        }

        @Override // yc.c
        public void j(View r10, float r11) {
            r10.setRotationX(a(r11));
        }
    }

    public static class h extends c {
        public h() {
        }

        @Override // yc.c
        public void j(View r10, float r11) {
            r10.setRotationY(a(r11));
        }
    }

    public static class i extends c {
        public i() {
        }

        @Override // yc.c
        public void j(View r10, float r11) {
            r10.setScaleX(a(r11));
        }
    }

    public static class j extends c {
        public j() {
        }

        @Override // yc.c
        public void j(View r10, float r11) {
            r10.setScaleY(a(r11));
        }
    }

    public static class k extends c {
        public k() {
        }

        @Override // yc.c
        public void j(View r10, float r11) {
            r10.setTranslationX(a(r11));
        }
    }

    public static class l extends c {
        public l() {
        }

        @Override // yc.c
        public void j(View r10, float r11) {
            r10.setTranslationY(a(r11));
        }
    }

    public static class m extends c {
        public m() {
        }

        @Override // yc.c
        public void j(View r10, float r11) {
            r10.setTranslationZ(a(r11));
        }
    }

    public c() {
    }

    public static c i(String r10) {
        if (r10.startsWith("CUSTOM") == true) goto L5;
        byte r11 = -1;
        switch(r10.hashCode()) {
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
        switch(r11) {
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
        return new C0417c();
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
        if (r10.equals("waveOffset") == false) goto L65;
        r11 = Ascii.CR;
        goto L65
    L14:
        if (r10.equals("alpha") == false) goto L65;
        r11 = Ascii.FF;
        goto L65
    L18:
        if (r10.equals("transitionPathRotate") == false) goto L65;
        r11 = Ascii.VT;
        goto L65
    L22:
        if (r10.equals("elevation") == false) goto L65;
        r11 = 10;
        goto L65
    L26:
        if (r10.equals("rotation") == false) goto L65;
        r11 = 9;
        goto L65
    L30:
        if (r10.equals("waveVariesBy") == false) goto L65;
        r11 = 8;
        goto L65
    L34:
        if (r10.equals("scaleY") == false) goto L65;
        r11 = 7;
        goto L65
    L38:
        if (r10.equals("scaleX") == false) goto L65;
        r11 = 6;
        goto L65
    L42:
        if (r10.equals("progress") == false) goto L65;
        r11 = 5;
        goto L65
    L46:
        if (r10.equals("translationZ") == false) goto L65;
        r11 = 4;
        goto L65
    L50:
        if (r10.equals("translationY") == false) goto L65;
        r11 = 3;
        goto L65
    L54:
        if (r10.equals("translationX") == false) goto L65;
        r11 = 2;
        goto L65
    L58:
        if (r10.equals("rotationY") == false) goto L65;
        r11 = 1;
        goto L65
    L62:
        if (r10.equals("rotationX") == false) goto L65;
        r11 = 0;
        goto L65
    L5:
        return new b();
    }

    public abstract void j(View r10, float r11);
}
