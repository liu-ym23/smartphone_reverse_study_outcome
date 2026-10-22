package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: KeyTimeCycle.java */
/* JADX INFO: loaded from: classes4.dex */
public class j extends d {
    private static final String TAG = "KeyTimeCycle";
    private String g;
    private int h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private int u;
    private String v;
    private float w;
    private float x;

    /* JADX INFO: compiled from: KeyTimeCycle.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SparseIntArray f34871a;

        static {
            SparseIntArray r0 = new SparseIntArray();
            f34871a = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_android_alpha, "styleable", "KeyTimeCycle_android_alpha"), 1);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_android_elevation, "styleable", "KeyTimeCycle_android_elevation"), 2);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_android_rotation, "styleable", "KeyTimeCycle_android_rotation"), 4);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_android_rotationX, "styleable", "KeyTimeCycle_android_rotationX"), 5);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_android_rotationY, "styleable", "KeyTimeCycle_android_rotationY"), 6);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_android_scaleX, "styleable", "KeyTimeCycle_android_scaleX"), 7);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_transitionPathRotate, "styleable", "KeyTimeCycle_transitionPathRotate"), 8);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_transitionEasing, "styleable", "KeyTimeCycle_transitionEasing"), 9);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_motionTarget, "styleable", "KeyTimeCycle_motionTarget"), 10);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_framePosition, "styleable", "KeyTimeCycle_framePosition"), 12);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_curveFit, "styleable", "KeyTimeCycle_curveFit"), 13);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_android_scaleY, "styleable", "KeyTimeCycle_android_scaleY"), 14);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_android_translationX, "styleable", "KeyTimeCycle_android_translationX"), 15);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_android_translationY, "styleable", "KeyTimeCycle_android_translationY"), 16);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_android_translationZ, "styleable", "KeyTimeCycle_android_translationZ"), 17);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_motionProgress, "styleable", "KeyTimeCycle_motionProgress"), 18);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_wavePeriod, "styleable", "KeyTimeCycle_wavePeriod"), 20);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_waveOffset, "styleable", "KeyTimeCycle_waveOffset"), 21);
            f34871a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTimeCycle_waveShape, "styleable", "KeyTimeCycle_waveShape"), 19);
        }

        public static void a(j r5, TypedArray r6) {
            int r0 = r6.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L41;
            int r2 = r6.getIndex(r1);
            switch(f34871a.get(r2)) {
                case 1: goto L39;
                case 2: goto L38;
                case 3: goto L6;
                case 4: goto L37;
                case 5: goto L36;
                case 6: goto L35;
                case 7: goto L34;
                case 8: goto L33;
                case 9: goto L32;
                case 10: goto L24;
                case 11: goto L6;
                case 12: goto L22;
                case 13: goto L21;
                case 14: goto L20;
                case 15: goto L19;
                case 16: goto L18;
                case 17: goto L17;
                case 18: goto L16;
                case 19: goto L13;
                case 20: goto L11;
                case 21: goto L8;
                default: goto L6;
            };
        L6:
            a(j.TAG, "unused attribute 0x" + Integer.toHexString(r2) + "   " + f34871a.get(r2));
        L40:
            r1 = r1 + 1;
            goto L3
        L11:
            j.d(r5, r6.getFloat(r2, j.f(r5)));
            goto L40
        L16:
            j.n(r5, r6.getFloat(r2, j.p(r5)));
            goto L40
        L17:
            j.m(r5, r6.getDimension(r2, j.o(r5)));
            goto L40
        L18:
            j.l(r5, r6.getDimension(r2, j.n(r5)));
            goto L40
        L19:
            j.k(r5, r6.getDimension(r2, j.m(r5)));
            goto L40
        L20:
            j.i(r5, r6.getFloat(r2, j.k(r5)));
            goto L40
        L21:
            j.a(r5, r6.getInteger(r2, j.d(r5)));
            goto L40
        L22:
            r5.f34862b = r6.getInt(r2, r5.f34862b);
            goto L40
        L32:
            j.b(r5, r6.getString(r2));
            goto L40
        L33:
            j.j(r5, r6.getFloat(r2, j.l(r5)));
            goto L40
        L34:
            j.f(r5, r6.getFloat(r2, j.h(r5)));
            goto L40
        L35:
            j.h(r5, r6.getFloat(r2, j.j(r5)));
            goto L40
        L36:
            j.g(r5, r6.getFloat(r2, j.i(r5)));
            goto L40
        L37:
            j.c(r5, r6.getFloat(r2, j.c(r5)));
            goto L40
        L38:
            j.b(r5, r6.getDimension(r2, j.b(r5)));
            goto L40
        L39:
            j.a(r5, r6.getFloat(r2, j.a(r5)));
            goto L40
        L8:
            if (r6.peekValue(r2).type != 5) goto L10;
            j.e(r5, r6.getDimension(r2, j.g(r5)));
            goto L40
        L10:
            j.e(r5, r6.getFloat(r2, j.g(r5)));
            goto L40
        L13:
            if (r6.peekValue(r2).type != 3) goto L15;
            j.a(r5, r6.getString(r2));
            j.b(r5, 7);
            goto L40
        L15:
            j.b(r5, r6.getInt(r2, j.e(r5)));
            goto L40
        L24:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L29;
            r5.f34863c = r6.getResourceId(r2, r5.f34863c);
            if (r5.f34863c != (-1)) goto L40;
            r5.f34864d = r6.getString(r2);
            goto L40
        L29:
            if (r6.peekValue(r2).type != 3) goto L31;
            r5.f34864d = r6.getString(r2);
            goto L40
        L31:
            r5.f34863c = r6.getResourceId(r2, r5.f34863c);
            goto L40
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    public j() {
        this.h = -1;
        this.i = Float.NaN;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = 0;
        this.v = null;
        this.w = Float.NaN;
        this.x = 0.0f;
        this.f34865e = 3;
        this.f = new HashMap();
    }

    static /* synthetic */ float a(j r0) {
        return r0.i;
    }

    static /* synthetic */ float a(j r0, float r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ int a(j r0, int r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ String a(j r0, String r1) {
        r0.v = r1;
        return r1;
    }

    static /* synthetic */ float b(j r0) {
        return r0.j;
    }

    static /* synthetic */ float b(j r0, float r1) {
        r0.j = r1;
        return r1;
    }

    static /* synthetic */ int b(j r0, int r1) {
        r0.u = r1;
        return r1;
    }

    static /* synthetic */ String b(j r0, String r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ float c(j r0) {
        return r0.k;
    }

    static /* synthetic */ float c(j r0, float r1) {
        r0.k = r1;
        return r1;
    }

    static /* synthetic */ float d(j r0, float r1) {
        r0.w = r1;
        return r1;
    }

    static /* synthetic */ int d(j r0) {
        return r0.h;
    }

    static /* synthetic */ float e(j r0, float r1) {
        r0.x = r1;
        return r1;
    }

    static /* synthetic */ int e(j r0) {
        return r0.u;
    }

    static /* synthetic */ float f(j r0) {
        return r0.w;
    }

    static /* synthetic */ float f(j r0, float r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ float g(j r0) {
        return r0.x;
    }

    static /* synthetic */ float g(j r0, float r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ float h(j r0) {
        return r0.o;
    }

    static /* synthetic */ float h(j r0, float r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ float i(j r0) {
        return r0.l;
    }

    static /* synthetic */ float i(j r0, float r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ float j(j r0) {
        return r0.m;
    }

    static /* synthetic */ float j(j r0, float r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ float k(j r0) {
        return r0.p;
    }

    static /* synthetic */ float k(j r0, float r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ float l(j r0) {
        return r0.n;
    }

    static /* synthetic */ float l(j r0, float r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ float m(j r0) {
        return r0.q;
    }

    static /* synthetic */ float m(j r0, float r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ float n(j r0) {
        return r0.r;
    }

    static /* synthetic */ float n(j r0, float r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ float o(j r0) {
        return r0.s;
    }

    static /* synthetic */ float p(j r0) {
        return r0.t;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public /* synthetic */ Object clone() {
        return a();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(Context r3, AttributeSet r4) {
        a.a(this, ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.KeyTimeCycle));
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(HashSet<String> r4) {
        if (Float.isNaN(this.i) == true) goto L6;
        r4.add("alpha");
    L6:
        if (Float.isNaN(this.j) == true) goto L9;
        r4.add("elevation");
    L9:
        if (Float.isNaN(this.k) == true) goto L12;
        r4.add("rotation");
    L12:
        if (Float.isNaN(this.l) == true) goto L15;
        r4.add("rotationX");
    L15:
        if (Float.isNaN(this.m) == true) goto L18;
        r4.add("rotationY");
    L18:
        if (Float.isNaN(this.q) == true) goto L21;
        r4.add("translationX");
    L21:
        if (Float.isNaN(this.r) == true) goto L24;
        r4.add("translationY");
    L24:
        if (Float.isNaN(this.s) == true) goto L27;
        r4.add("translationZ");
    L27:
        if (Float.isNaN(this.n) == true) goto L30;
        r4.add("transitionPathRotate");
    L30:
        if (Float.isNaN(this.o) == true) goto L33;
        r4.add("scaleX");
    L33:
        if (Float.isNaN(this.p) == true) goto L36;
        r4.add("scaleY");
    L36:
        if (Float.isNaN(this.t) == true) goto L39;
        r4.add("progress");
    L39:
        if (this.f.size() <= 0) goto L44;
        Iterator<String> r3 = this.f.keySet().iterator();
    L42:
        if (r3.hasNext() == false) goto L46;
        r4.add("CUSTOM," + ((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin")));
        goto L42
    L46:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void b(HashMap<String, Integer> r5) {
        if (this.h != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.i) == true) goto L9;
        r5.put("alpha", Integer.valueOf(this.h));
    L9:
        if (Float.isNaN(this.j) == true) goto L12;
        r5.put("elevation", Integer.valueOf(this.h));
    L12:
        if (Float.isNaN(this.k) == true) goto L15;
        r5.put("rotation", Integer.valueOf(this.h));
    L15:
        if (Float.isNaN(this.l) == true) goto L18;
        r5.put("rotationX", Integer.valueOf(this.h));
    L18:
        if (Float.isNaN(this.m) == true) goto L21;
        r5.put("rotationY", Integer.valueOf(this.h));
    L21:
        if (Float.isNaN(this.q) == true) goto L24;
        r5.put("translationX", Integer.valueOf(this.h));
    L24:
        if (Float.isNaN(this.r) == true) goto L27;
        r5.put("translationY", Integer.valueOf(this.h));
    L27:
        if (Float.isNaN(this.s) == true) goto L30;
        r5.put("translationZ", Integer.valueOf(this.h));
    L30:
        if (Float.isNaN(this.n) == true) goto L33;
        r5.put("transitionPathRotate", Integer.valueOf(this.h));
    L33:
        if (Float.isNaN(this.o) == true) goto L36;
        r5.put("scaleX", Integer.valueOf(this.h));
    L36:
        if (Float.isNaN(this.o) == true) goto L39;
        r5.put("scaleY", Integer.valueOf(this.h));
    L39:
        if (Float.isNaN(this.t) == true) goto L42;
        r5.put("progress", Integer.valueOf(this.h));
    L42:
        if (this.f.size() <= 0) goto L47;
        Iterator<String> r0 = this.f.keySet().iterator();
    L45:
        if (r0.hasNext() == false) goto L49;
        r5.put("CUSTOM," + ((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin")), Integer.valueOf(this.h));
        goto L45
    L49:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(HashMap<String, com.obric.oui.constraintlayout.motion.utils.c> r1) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    public void c(HashMap<String, com.obric.oui.constraintlayout.motion.utils.e> r12) {
        Iterator<String> r0 = r12.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L101;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        com.obric.oui.constraintlayout.motion.utils.e r4 = (com.obric.oui.constraintlayout.motion.utils.e) ZeusTransformUtils.preCheckCast(r12.get(r1), com.obric.oui.constraintlayout.motion.utils.e.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L4;
        byte r5 = 7;
        if (r1.startsWith("CUSTOM") == true) goto L10;
        r1.hashCode();
        switch(r1.hashCode()) {
            case -1249320806: goto L60;
            case -1249320805: goto L56;
            case -1225497657: goto L52;
            case -1225497656: goto L48;
            case -1225497655: goto L44;
            case -1001078227: goto L40;
            case -908189618: goto L36;
            case -908189617: goto L33;
            case -40300674: goto L29;
            case -4379043: goto L25;
            case 37232917: goto L21;
            case 92909918: goto L17;
            default: goto L15;
        };
    L15:
        r5 = -1;
    L63:
        switch(r5) {
            case 0: goto L99;
            case 1: goto L96;
            case 2: goto L93;
            case 3: goto L90;
            case 4: goto L87;
            case 5: goto L84;
            case 6: goto L81;
            case 7: goto L78;
            case 8: goto L75;
            case 9: goto L72;
            case 10: goto L69;
            case 11: goto L66;
            default: goto L64;
        };
    L66:
        if (Float.isNaN(this.i) == true) goto L4;
        r4.a(this.f34862b, this.i, this.w, this.u, this.x);
        goto L4
    L69:
        if (Float.isNaN(this.n) == true) goto L4;
        r4.a(this.f34862b, this.n, this.w, this.u, this.x);
        goto L4
    L72:
        if (Float.isNaN(this.j) == true) goto L4;
        r4.a(this.f34862b, this.j, this.w, this.u, this.x);
        goto L4
    L75:
        if (Float.isNaN(this.k) == true) goto L4;
        r4.a(this.f34862b, this.k, this.w, this.u, this.x);
        goto L4
    L78:
        if (Float.isNaN(this.p) == true) goto L4;
        r4.a(this.f34862b, this.p, this.w, this.u, this.x);
        goto L4
    L81:
        if (Float.isNaN(this.o) == true) goto L4;
        r4.a(this.f34862b, this.o, this.w, this.u, this.x);
        goto L4
    L84:
        if (Float.isNaN(this.t) == true) goto L4;
        r4.a(this.f34862b, this.t, this.w, this.u, this.x);
        goto L4
    L87:
        if (Float.isNaN(this.s) == true) goto L4;
        r4.a(this.f34862b, this.s, this.w, this.u, this.x);
        goto L4
    L90:
        if (Float.isNaN(this.r) == true) goto L4;
        r4.a(this.f34862b, this.r, this.w, this.u, this.x);
        goto L4
    L93:
        if (Float.isNaN(this.q) == true) goto L4;
        r4.a(this.f34862b, this.q, this.w, this.u, this.x);
        goto L4
    L96:
        if (Float.isNaN(this.m) == true) goto L4;
        r4.a(this.f34862b, this.m, this.w, this.u, this.x);
        goto L4
    L99:
        if (Float.isNaN(this.l) == true) goto L4;
        r4.a(this.f34862b, this.l, this.w, this.u, this.x);
        goto L4
    L64:
        a("KeyTimeCycles", "UNKNOWN addValues \"" + r1 + "\"");
        goto L4
    L17:
        if (r1.equals("alpha") == false) goto L161;
        r5 = 11;
        goto L63
    L161:
        r5 = -1;
        goto L63
    L21:
        if (r1.equals("transitionPathRotate") == false) goto L162;
        r5 = 10;
        goto L63
    L162:
        r5 = -1;
        goto L63
    L25:
        if (r1.equals("elevation") == false) goto L163;
        r5 = 9;
        goto L63
    L163:
        r5 = -1;
        goto L63
    L29:
        if (r1.equals("rotation") == false) goto L164;
        r5 = 8;
        goto L63
    L164:
        r5 = -1;
        goto L63
    L33:
        if (r1.equals("scaleY") == true) goto L63;
        r5 = -1;
        goto L63
    L36:
        if (r1.equals("scaleX") == false) goto L166;
        r5 = 6;
        goto L63
    L166:
        r5 = -1;
        goto L63
    L40:
        if (r1.equals("progress") == false) goto L167;
        r5 = 5;
        goto L63
    L167:
        r5 = -1;
        goto L63
    L44:
        if (r1.equals("translationZ") == false) goto L168;
        r5 = 4;
        goto L63
    L168:
        r5 = -1;
        goto L63
    L48:
        if (r1.equals("translationY") == false) goto L169;
        r5 = 3;
        goto L63
    L169:
        r5 = -1;
        goto L63
    L52:
        if (r1.equals("translationX") == false) goto L170;
        r5 = 2;
        goto L63
    L170:
        r5 = -1;
        goto L63
    L56:
        if (r1.equals("rotationY") == false) goto L171;
        r5 = 1;
        goto L63
    L171:
        r5 = -1;
        goto L63
    L60:
        if (r1.equals("rotationX") == false) goto L172;
        r5 = 0;
        goto L63
    L172:
        r5 = -1;
        goto L63
    L10:
        com.obric.oui.constraintlayout.widget.a r7 = (com.obric.oui.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.f.get(r1.substring(7)), com.obric.oui.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L4;
        ((com.obric.oui.constraintlayout.motion.utils.e.b) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.constraintlayout.motion.utils.e.b.class, "com.obric.aiagent.plugin")).a(this.f34862b, r7, this.w, this.u, this.x);
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public d a(d r3) {
        super.a(r3);
        j r4 = (j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin");
        this.g = r4.g;
        this.h = r4.h;
        this.u = r4.u;
        this.w = r4.w;
        this.x = r4.x;
        this.t = r4.t;
        this.i = r4.i;
        this.j = r4.j;
        this.k = r4.k;
        this.n = r4.n;
        this.l = r4.l;
        this.m = r4.m;
        this.o = r4.o;
        this.p = r4.p;
        this.q = r4.q;
        this.r = r4.r;
        this.s = r4.s;
        this.v = r4.v;
        return this;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public d a() {
        return new j().a(this);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
