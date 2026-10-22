package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.common.base.Ascii;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class e extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f13668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f13671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f13672k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f13673l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13674m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13675n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13676o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13677p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13678q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f13679r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f13680s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f13681t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f13682u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f13683v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f13684w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f13685x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f13686y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f13687z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SparseIntArray f13688a;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f13688a = r10;
            r10.append(R$styleable.KeyCycle_motionTarget, 1);
            f13688a.append(R$styleable.KeyCycle_framePosition, 2);
            f13688a.append(R$styleable.KeyCycle_transitionEasing, 3);
            f13688a.append(R$styleable.KeyCycle_curveFit, 4);
            f13688a.append(R$styleable.KeyCycle_waveShape, 5);
            f13688a.append(R$styleable.KeyCycle_wavePeriod, 6);
            f13688a.append(R$styleable.KeyCycle_waveOffset, 7);
            f13688a.append(R$styleable.KeyCycle_waveVariesBy, 8);
            f13688a.append(R$styleable.KeyCycle_android_alpha, 9);
            f13688a.append(R$styleable.KeyCycle_android_elevation, 10);
            f13688a.append(R$styleable.KeyCycle_android_rotation, 11);
            f13688a.append(R$styleable.KeyCycle_android_rotationX, 12);
            f13688a.append(R$styleable.KeyCycle_android_rotationY, 13);
            f13688a.append(R$styleable.KeyCycle_transitionPathRotate, 14);
            f13688a.append(R$styleable.KeyCycle_android_scaleX, 15);
            f13688a.append(R$styleable.KeyCycle_android_scaleY, 16);
            f13688a.append(R$styleable.KeyCycle_android_translationX, 17);
            f13688a.append(R$styleable.KeyCycle_android_translationY, 18);
            f13688a.append(R$styleable.KeyCycle_android_translationZ, 19);
            f13688a.append(R$styleable.KeyCycle_motionProgress, 20);
            f13688a.append(R$styleable.KeyCycle_wavePhase, 21);
        }

        public static /* synthetic */ void a(e r10, TypedArray r11) {
            b(r10, r11);
        }

        public static void b(e r10, TypedArray r11) {
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L43;
            int r14 = r11.getIndex(r13);
            switch(f13688a.get(r14)) {
                case 1: goto L34;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L27;
                case 6: goto L25;
                case 7: goto L22;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                case 14: goto L14;
                case 15: goto L13;
                case 16: goto L12;
                case 17: goto L11;
                case 18: goto L10;
                case 19: goto L9;
                case 20: goto L8;
                case 21: goto L7;
                default: goto L6;
            };
        L6:
            Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(r14) + "   " + f13688a.get(r14));
        L42:
            r13 = r13 + 1;
            goto L3
        L7:
            e.J(r10, r11.getFloat(r14, e.I(r10)) / 360.0f);
            goto L42
        L8:
            e.G(r10, r11.getFloat(r14, e.F(r10)));
            goto L42
        L9:
            e.E(r10, r11.getDimension(r14, e.D(r10)));
            goto L42
        L10:
            e.C(r10, r11.getDimension(r14, e.B(r10)));
            goto L42
        L11:
            e.A(r10, r11.getDimension(r14, e.z(r10)));
            goto L42
        L12:
            e.y(r10, r11.getFloat(r14, e.x(r10)));
            goto L42
        L13:
            e.w(r10, r11.getFloat(r14, e.v(r10)));
            goto L42
        L14:
            e.u(r10, r11.getFloat(r14, e.t(r10)));
            goto L42
        L15:
            e.s(r10, r11.getFloat(r14, e.r(r10)));
            goto L42
        L16:
            e.q(r10, r11.getFloat(r14, e.p(r10)));
            goto L42
        L17:
            e.n(r10, r11.getFloat(r14, e.m(r10)));
            goto L42
        L18:
            e.X(r10, r11.getDimension(r14, e.W(r10)));
            goto L42
        L19:
            e.V(r10, r11.getFloat(r14, e.U(r10)));
            goto L42
        L20:
            e.T(r10, r11.getInt(r14, e.S(r10)));
            goto L42
        L25:
            e.P(r10, r11.getFloat(r14, e.O(r10)));
            goto L42
        L30:
            e.K(r10, r11.getInteger(r14, e.H(r10)));
            goto L42
        L31:
            e.o(r10, r11.getString(r14));
            goto L42
        L32:
            r10.f13645a = r11.getInt(r14, r10.f13645a);
            goto L42
        L22:
            if (r11.peekValue(r14).type != 5) goto L24;
            e.R(r10, r11.getDimension(r14, e.Q(r10)));
            goto L42
        L24:
            e.R(r10, r11.getFloat(r14, e.Q(r10)));
            goto L42
        L27:
            if (r11.peekValue(r14).type != 3) goto L29;
            e.L(r10, r11.getString(r14));
            e.N(r10, 7);
            goto L42
        L29:
            e.N(r10, r11.getInt(r14, e.M(r10)));
            goto L42
        L34:
            if (MotionLayout.f13558d1 == false) goto L39;
            int r15 = r11.getResourceId(r14, r10.f13646b);
            r10.f13646b = r15;
            if (r15 != (-1)) goto L42;
            r10.f13647c = r11.getString(r14);
            goto L42
        L39:
            if (r11.peekValue(r14).type != 3) goto L41;
            r10.f13647c = r11.getString(r14);
            goto L42
        L41:
            r10.f13646b = r11.getResourceId(r14, r10.f13646b);
            goto L42
        }
    }

    public e() {
        this.f13668g = null;
        this.f13669h = 0;
        this.f13670i = -1;
        this.f13671j = null;
        this.f13672k = Float.NaN;
        this.f13673l = 0.0f;
        this.f13674m = 0.0f;
        this.f13675n = Float.NaN;
        this.f13676o = -1;
        this.f13677p = Float.NaN;
        this.f13678q = Float.NaN;
        this.f13679r = Float.NaN;
        this.f13680s = Float.NaN;
        this.f13681t = Float.NaN;
        this.f13682u = Float.NaN;
        this.f13683v = Float.NaN;
        this.f13684w = Float.NaN;
        this.f13685x = Float.NaN;
        this.f13686y = Float.NaN;
        this.f13687z = Float.NaN;
        this.f13648d = 4;
        this.f13649e = new HashMap();
    }

    public static /* synthetic */ float A(e r10, float r11) {
        r10.f13685x = r11;
        return r11;
    }

    public static /* synthetic */ float B(e r10) {
        return r10.f13686y;
    }

    public static /* synthetic */ float C(e r10, float r11) {
        r10.f13686y = r11;
        return r11;
    }

    public static /* synthetic */ float D(e r10) {
        return r10.f13687z;
    }

    public static /* synthetic */ float E(e r10, float r11) {
        r10.f13687z = r11;
        return r11;
    }

    public static /* synthetic */ float F(e r10) {
        return r10.f13675n;
    }

    public static /* synthetic */ float G(e r10, float r11) {
        r10.f13675n = r11;
        return r11;
    }

    public static /* synthetic */ int H(e r10) {
        return r10.f13669h;
    }

    public static /* synthetic */ float I(e r10) {
        return r10.f13674m;
    }

    public static /* synthetic */ float J(e r10, float r11) {
        r10.f13674m = r11;
        return r11;
    }

    public static /* synthetic */ int K(e r10, int r11) {
        r10.f13669h = r11;
        return r11;
    }

    public static /* synthetic */ String L(e r10, String r11) {
        r10.f13671j = r11;
        return r11;
    }

    public static /* synthetic */ int M(e r10) {
        return r10.f13670i;
    }

    public static /* synthetic */ int N(e r10, int r11) {
        r10.f13670i = r11;
        return r11;
    }

    public static /* synthetic */ float O(e r10) {
        return r10.f13672k;
    }

    public static /* synthetic */ float P(e r10, float r11) {
        r10.f13672k = r11;
        return r11;
    }

    public static /* synthetic */ float Q(e r10) {
        return r10.f13673l;
    }

    public static /* synthetic */ float R(e r10, float r11) {
        r10.f13673l = r11;
        return r11;
    }

    public static /* synthetic */ int S(e r10) {
        return r10.f13676o;
    }

    public static /* synthetic */ int T(e r10, int r11) {
        r10.f13676o = r11;
        return r11;
    }

    public static /* synthetic */ float U(e r10) {
        return r10.f13677p;
    }

    public static /* synthetic */ float V(e r10, float r11) {
        r10.f13677p = r11;
        return r11;
    }

    public static /* synthetic */ float W(e r10) {
        return r10.f13678q;
    }

    public static /* synthetic */ float X(e r10, float r11) {
        r10.f13678q = r11;
        return r11;
    }

    public static /* synthetic */ float m(e r10) {
        return r10.f13679r;
    }

    public static /* synthetic */ float n(e r10, float r11) {
        r10.f13679r = r11;
        return r11;
    }

    public static /* synthetic */ String o(e r10, String r11) {
        r10.f13668g = r11;
        return r11;
    }

    public static /* synthetic */ float p(e r10) {
        return r10.f13681t;
    }

    public static /* synthetic */ float q(e r10, float r11) {
        r10.f13681t = r11;
        return r11;
    }

    public static /* synthetic */ float r(e r10) {
        return r10.f13682u;
    }

    public static /* synthetic */ float s(e r10, float r11) {
        r10.f13682u = r11;
        return r11;
    }

    public static /* synthetic */ float t(e r10) {
        return r10.f13680s;
    }

    public static /* synthetic */ float u(e r10, float r11) {
        r10.f13680s = r11;
        return r11;
    }

    public static /* synthetic */ float v(e r10) {
        return r10.f13683v;
    }

    public static /* synthetic */ float w(e r10, float r11) {
        r10.f13683v = r11;
        return r11;
    }

    public static /* synthetic */ float x(e r10) {
        return r10.f13684w;
    }

    public static /* synthetic */ float y(e r10, float r11) {
        r10.f13684w = r11;
        return r11;
    }

    public static /* synthetic */ float z(e r10) {
        return r10.f13685x;
    }

    public void Y(HashMap r25) {
        Iterator r10 = r25.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L23;
        String r11 = (String) r10.next();
        if (r11.startsWith("CUSTOM") == true) goto L7;
        float r23 = Z(r11);
        if (Float.isNaN(r23) == true) goto L4;
        yc.c r15 = (yc.c) r25.get(r11);
        if (r15 == null) goto L4;
        r15.d(this.f13645a, this.f13670i, this.f13671j, this.f13676o, this.f13672k, this.f13673l, this.f13674m, r23);
        goto L4
    L7:
        String r12 = r11.substring(7);
        ConstraintAttribute r14 = (ConstraintAttribute) this.f13649e.get(r12);
        if (r14 == null) goto L4;
        if (r14.d() != ConstraintAttribute.AttributeType.FLOAT_TYPE) goto L4;
        yc.c r13 = (yc.c) r25.get(r11);
        if (r13 == null) goto L4;
        r13.e(this.f13645a, this.f13670i, this.f13671j, this.f13676o, this.f13672k, this.f13673l, this.f13674m, r14.e(), r14);
        goto L4
    }

    public float Z(String r10) {
        r10.hashCode();
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -1249320806: goto L58;
            case -1249320805: goto L54;
            case -1225497657: goto L50;
            case -1225497656: goto L46;
            case -1225497655: goto L42;
            case -1001078227: goto L38;
            case -908189618: goto L34;
            case -908189617: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 156108012: goto L10;
            case 1530034690: goto L6;
            default: goto L61;
        };
    L61:
        switch(r11) {
            case 0: goto L94;
            case 1: goto L92;
            case 2: goto L90;
            case 3: goto L88;
            case 4: goto L86;
            case 5: goto L84;
            case 6: goto L82;
            case 7: goto L80;
            case 8: goto L78;
            case 9: goto L76;
            case 10: goto L74;
            case 11: goto L72;
            case 12: goto L70;
            case 13: goto L68;
            default: goto L63;
        };
    L63:
        if (r10.startsWith("CUSTOM") == true) goto L95;
        Log.v("WARNING! KeyCycle", "  UNKNOWN  " + r10);
        return Float.NaN;
    L95:
        return Float.NaN;
    L68:
        return this.f13674m;
    L70:
        return this.f13673l;
    L72:
        return this.f13677p;
    L74:
        return this.f13680s;
    L76:
        return this.f13678q;
    L78:
        return this.f13679r;
    L80:
        return this.f13684w;
    L82:
        return this.f13683v;
    L84:
        return this.f13675n;
    L86:
        return this.f13687z;
    L88:
        return this.f13686y;
    L90:
        return this.f13685x;
    L92:
        return this.f13682u;
    L94:
        return this.f13681t;
    L6:
        if (r10.equals("wavePhase") == false) goto L61;
        r11 = Ascii.CR;
        goto L61
    L10:
        if (r10.equals("waveOffset") == false) goto L61;
        r11 = Ascii.FF;
        goto L61
    L14:
        if (r10.equals("alpha") == false) goto L61;
        r11 = Ascii.VT;
        goto L61
    L18:
        if (r10.equals("transitionPathRotate") == false) goto L61;
        r11 = 10;
        goto L61
    L22:
        if (r10.equals("elevation") == false) goto L61;
        r11 = 9;
        goto L61
    L26:
        if (r10.equals("rotation") == false) goto L61;
        r11 = 8;
        goto L61
    L30:
        if (r10.equals("scaleY") == false) goto L61;
        r11 = 7;
        goto L61
    L34:
        if (r10.equals("scaleX") == false) goto L61;
        r11 = 6;
        goto L61
    L38:
        if (r10.equals("progress") == false) goto L61;
        r11 = 5;
        goto L61
    L42:
        if (r10.equals("translationZ") == false) goto L61;
        r11 = 4;
        goto L61
    L46:
        if (r10.equals("translationY") == false) goto L61;
        r11 = 3;
        goto L61
    L50:
        if (r10.equals("translationX") == false) goto L61;
        r11 = 2;
        goto L61
    L54:
        if (r10.equals("rotationY") == false) goto L61;
        r11 = 1;
        goto L61
    L58:
        if (r10.equals("rotationX") == false) goto L61;
        r11 = 0;
        goto L61
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void a(HashMap r10) {
        com.obric.oui.constraintlayout.motion.widget.a.g("KeyCycle", "add " + r10.size() + " values", 2);
        Iterator r11 = r10.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L85;
        String r12 = (String) r11.next();
        com.obric.oui.constraintlayout.core.motion.utils.b r13 = (com.obric.oui.constraintlayout.core.motion.utils.b) r10.get(r12);
        if (r13 == null) goto L4;
        r12.hashCode();
        byte r14 = -1;
        switch(r12.hashCode()) {
            case -1249320806: goto L64;
            case -1249320805: goto L60;
            case -1225497657: goto L56;
            case -1225497656: goto L52;
            case -1225497655: goto L48;
            case -1001078227: goto L44;
            case -908189618: goto L40;
            case -908189617: goto L36;
            case -40300674: goto L32;
            case -4379043: goto L28;
            case 37232917: goto L24;
            case 92909918: goto L20;
            case 156108012: goto L16;
            case 1530034690: goto L12;
            default: goto L67;
        };
    L67:
        switch(r14) {
            case 0: goto L84;
            case 1: goto L83;
            case 2: goto L82;
            case 3: goto L81;
            case 4: goto L80;
            case 5: goto L79;
            case 6: goto L78;
            case 7: goto L77;
            case 8: goto L76;
            case 9: goto L75;
            case 10: goto L74;
            case 11: goto L73;
            case 12: goto L72;
            case 13: goto L71;
            default: goto L69;
        };
    L71:
        r13.c(this.f13645a, this.f13674m);
        goto L4
    L72:
        r13.c(this.f13645a, this.f13673l);
        goto L4
    L73:
        r13.c(this.f13645a, this.f13677p);
        goto L4
    L74:
        r13.c(this.f13645a, this.f13680s);
        goto L4
    L75:
        r13.c(this.f13645a, this.f13678q);
        goto L4
    L76:
        r13.c(this.f13645a, this.f13679r);
        goto L4
    L77:
        r13.c(this.f13645a, this.f13684w);
        goto L4
    L78:
        r13.c(this.f13645a, this.f13683v);
        goto L4
    L79:
        r13.c(this.f13645a, this.f13675n);
        goto L4
    L80:
        r13.c(this.f13645a, this.f13687z);
        goto L4
    L81:
        r13.c(this.f13645a, this.f13686y);
        goto L4
    L82:
        r13.c(this.f13645a, this.f13685x);
        goto L4
    L83:
        r13.c(this.f13645a, this.f13682u);
        goto L4
    L84:
        r13.c(this.f13645a, this.f13681t);
        goto L4
    L69:
        if (r12.startsWith("CUSTOM") == true) goto L4;
        Log.v("WARNING KeyCycle", "  UNKNOWN  " + r12);
        goto L4
    L12:
        if (r12.equals("wavePhase") == false) goto L67;
        r14 = Ascii.CR;
        goto L67
    L16:
        if (r12.equals("waveOffset") == false) goto L67;
        r14 = Ascii.FF;
        goto L67
    L20:
        if (r12.equals("alpha") == false) goto L67;
        r14 = Ascii.VT;
        goto L67
    L24:
        if (r12.equals("transitionPathRotate") == false) goto L67;
        r14 = 10;
        goto L67
    L28:
        if (r12.equals("elevation") == false) goto L67;
        r14 = 9;
        goto L67
    L32:
        if (r12.equals("rotation") == false) goto L67;
        r14 = 8;
        goto L67
    L36:
        if (r12.equals("scaleY") == false) goto L67;
        r14 = 7;
        goto L67
    L40:
        if (r12.equals("scaleX") == false) goto L67;
        r14 = 6;
        goto L67
    L44:
        if (r12.equals("progress") == false) goto L67;
        r14 = 5;
        goto L67
    L48:
        if (r12.equals("translationZ") == false) goto L67;
        r14 = 4;
        goto L67
    L52:
        if (r12.equals("translationY") == false) goto L67;
        r14 = 3;
        goto L67
    L56:
        if (r12.equals("translationX") == false) goto L67;
        r14 = 2;
        goto L67
    L60:
        if (r12.equals("rotationY") == false) goto L67;
        r14 = 1;
        goto L67
    L64:
        if (r12.equals("rotationX") == false) goto L67;
        r14 = 0;
        goto L67
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public c b() {
        return new e().c(this);
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public c c(c r10) {
        super.c(r10);
        e r11 = (e) r10;
        this.f13668g = r11.f13668g;
        this.f13669h = r11.f13669h;
        this.f13670i = r11.f13670i;
        this.f13671j = r11.f13671j;
        this.f13672k = r11.f13672k;
        this.f13673l = r11.f13673l;
        this.f13674m = r11.f13674m;
        this.f13675n = r11.f13675n;
        this.f13676o = r11.f13676o;
        this.f13677p = r11.f13677p;
        this.f13678q = r11.f13678q;
        this.f13679r = r11.f13679r;
        this.f13680s = r11.f13680s;
        this.f13681t = r11.f13681t;
        this.f13682u = r11.f13682u;
        this.f13683v = r11.f13683v;
        this.f13684w = r11.f13684w;
        this.f13685x = r11.f13685x;
        this.f13686y = r11.f13686y;
        this.f13687z = r11.f13687z;
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void d(HashSet r10) {
        if (Float.isNaN(this.f13677p) == true) goto L6;
        r10.add("alpha");
    L6:
        if (Float.isNaN(this.f13678q) == true) goto L9;
        r10.add("elevation");
    L9:
        if (Float.isNaN(this.f13679r) == true) goto L12;
        r10.add("rotation");
    L12:
        if (Float.isNaN(this.f13681t) == true) goto L15;
        r10.add("rotationX");
    L15:
        if (Float.isNaN(this.f13682u) == true) goto L18;
        r10.add("rotationY");
    L18:
        if (Float.isNaN(this.f13683v) == true) goto L21;
        r10.add("scaleX");
    L21:
        if (Float.isNaN(this.f13684w) == true) goto L24;
        r10.add("scaleY");
    L24:
        if (Float.isNaN(this.f13680s) == true) goto L27;
        r10.add("transitionPathRotate");
    L27:
        if (Float.isNaN(this.f13685x) == true) goto L30;
        r10.add("translationX");
    L30:
        if (Float.isNaN(this.f13686y) == true) goto L33;
        r10.add("translationY");
    L33:
        if (Float.isNaN(this.f13687z) == true) goto L36;
        r10.add("translationZ");
    L36:
        if (this.f13649e.size() <= 0) goto L41;
        Iterator r11 = this.f13649e.keySet().iterator();
    L39:
        if (r11.hasNext() == false) goto L43;
        r10.add("CUSTOM," + ((String) r11.next()));
        goto L39
    L43:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void e(Context r10, AttributeSet r11) {
        a.a(this, r10.obtainStyledAttributes(r11, R$styleable.KeyCycle));
    }
}
