package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: TouchResponse.java */
/* JADX INFO: loaded from: classes4.dex */
class p {
    private static final String TAG = "TouchResponse";
    private static final float[][] u = null;
    private static final float[][] v = null;
    private int A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private int G;
    private int H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f34889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f34890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f34891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f34893e;
    private int f;
    private int g;
    private int h;
    private int i;
    private float j;
    private float k;
    private int l;
    private float m;
    private float n;
    private boolean o;
    private float[] p;
    private int[] q;
    private float r;
    private float s;
    private final MotionLayout t;
    private float w;
    private float x;
    private boolean y;
    private float z;

    static {
        u = new float[][]{new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
        v = new float[][]{new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    }

    p(Context r5, MotionLayout r6, XmlPullParser r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r9 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r7, XmlPullParser.class, "com.obric.aiagent.plugin");
        this.f34892d = 0;
        this.f34893e = 0;
        this.f = 0;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = 0.5f;
        this.k = 0.5f;
        this.f34889a = 0.5f;
        this.f34890b = 0.5f;
        this.l = -1;
        this.f34891c = false;
        this.m = 0.0f;
        this.n = 1.0f;
        this.o = false;
        this.p = new float[2];
        this.q = new int[2];
        this.w = 4.0f;
        this.x = 1.2f;
        this.y = true;
        this.z = 1.0f;
        this.A = 0;
        this.B = 10.0f;
        this.C = 10.0f;
        this.D = 1.0f;
        this.E = Float.NaN;
        this.F = Float.NaN;
        this.G = 0;
        this.H = 0;
        this.t = r6;
        a(r8, Xml.asAttributeSet(r9));
    }

    public void a(boolean r8) {
        if (r8 == false) goto L5;
        float[][] r9 = v;
        r9[4] = r9[3];
        r9[5] = r9[2];
        float[][] r10 = u;
        r10[5] = r10[2];
        r10[6] = r10[1];
    L6:
        float[][] r11 = u;
        int r0 = this.f34892d;
        this.k = r11[r0][0];
        this.j = r11[r0][1];
        int r12 = this.f34893e;
        float[][] r1 = v;
        if (r12 < r1.length) goto L9;
        return;
    L9:
        this.m = r1[r12][0];
        this.n = r1[r12][1];
        return;
    L5:
        float[][] r13 = v;
        r13[4] = r13[2];
        r13[5] = r13[3];
        float[][] r14 = u;
        r14[5] = r14[1];
        r14[6] = r14[2];
        goto L6
    }

    private void a(Context r3, AttributeSet r4) {
        TypedArray r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.OnSwipe);
        a(r5);
        r5.recycle();
    }

    private void a(TypedArray r9) {
        int r0 = r9.getIndexCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L65;
        int r3 = r9.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_touchAnchorId, "styleable", "OnSwipe_touchAnchorId")) goto L8;
        this.g = r9.getResourceId(r3, this.g);
    L64:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_touchAnchorSide, "styleable", "OnSwipe_touchAnchorSide")) goto L11;
        int r4 = r9.getInt(r3, this.f34892d);
        this.f34892d = r4;
        float[][] r5 = u;
        this.k = r5[r4][0];
        this.j = r5[r4][1];
        goto L64
    L11:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_dragDirection, "styleable", "OnSwipe_dragDirection")) goto L17;
        int r6 = r9.getInt(r3, this.f34893e);
        this.f34893e = r6;
        float[][] r7 = v;
        if (r6 >= r7.length) goto L15;
        this.m = r7[r6][0];
        this.n = r7[r6][1];
        goto L64
    L15:
        this.n = Float.NaN;
        this.m = Float.NaN;
        this.f34891c = true;
        goto L64
    L17:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_maxVelocity, "styleable", "OnSwipe_maxVelocity")) goto L20;
        this.w = r9.getFloat(r3, this.w);
        goto L64
    L20:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_maxAcceleration, "styleable", "OnSwipe_maxAcceleration")) goto L23;
        this.x = r9.getFloat(r3, this.x);
        goto L64
    L23:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_moveWhenScrollAtTop, "styleable", "OnSwipe_moveWhenScrollAtTop")) goto L26;
        this.y = r9.getBoolean(r3, this.y);
        goto L64
    L26:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_dragScale, "styleable", "OnSwipe_dragScale")) goto L29;
        this.z = r9.getFloat(r3, this.z);
        goto L64
    L29:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_dragThreshold, "styleable", "OnSwipe_dragThreshold")) goto L32;
        this.B = r9.getFloat(r3, this.B);
        goto L64
    L32:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_touchRegionId, "styleable", "OnSwipe_touchRegionId")) goto L35;
        this.h = r9.getResourceId(r3, this.h);
        goto L64
    L35:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_onTouchUp, "styleable", "OnSwipe_onTouchUp")) goto L38;
        this.f = r9.getInt(r3, this.f);
        goto L64
    L38:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_nestedScrollFlags, "styleable", "OnSwipe_nestedScrollFlags")) goto L41;
        this.A = r9.getInteger(r3, 0);
        goto L64
    L41:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_limitBoundsTo, "styleable", "OnSwipe_limitBoundsTo")) goto L44;
        this.i = r9.getResourceId(r3, 0);
        goto L64
    L44:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_rotationCenterId, "styleable", "OnSwipe_rotationCenterId")) goto L47;
        this.l = r9.getResourceId(r3, this.l);
        goto L64
    L47:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_springDamping, "styleable", "OnSwipe_springDamping")) goto L50;
        this.C = r9.getFloat(r3, this.C);
        goto L64
    L50:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_springMass, "styleable", "OnSwipe_springMass")) goto L53;
        this.D = r9.getFloat(r3, this.D);
        goto L64
    L53:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_springStiffness, "styleable", "OnSwipe_springStiffness")) goto L56;
        this.E = r9.getFloat(r3, this.E);
        goto L64
    L56:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_springStopThreshold, "styleable", "OnSwipe_springStopThreshold")) goto L59;
        this.F = r9.getFloat(r3, this.F);
        goto L64
    L59:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_springBoundary, "styleable", "OnSwipe_springBoundary")) goto L62;
        this.G = r9.getInt(r3, this.G);
        goto L64
    L62:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.OnSwipe_autoCompleteMode, "styleable", "OnSwipe_autoCompleteMode")) goto L64;
        this.H = r9.getInt(r3, this.H);
        goto L64
    }

    void a(float r1, float r2) {
        this.r = r1;
        this.s = r2;
        this.o = false;
    }

    void a(MotionEvent r21, MotionLayout.c r22, int r23, MotionScene r24) {
        MotionLayout.c r1 = (MotionLayout.c) ZeusTransformUtils.wrapperContextForParams(r22, MotionLayout.c.class, "com.obric.aiagent.plugin");
        r1.a(r21);
        int r3 = r21.getAction();
        boolean r4 = false;
        if (r3 != 0) goto L5;
        this.r = r21.getRawX();
        this.s = r21.getRawY();
        this.o = false;
        return;
    L5:
        if (r3 != 1) goto L7;
        this.o = false;
        r1.a(16);
        float r6 = r1.b();
        float r2 = r1.c();
        float r7 = this.t.getProgress();
        float r8 = this.t.getWidth() / 2.0f;
        float r11 = this.t.getHeight() / 2.0f;
        int r12 = this.l;
        if (r12 == (-1)) goto L52;
        View r9 = this.t.findViewById(r12);
        this.t.getLocationOnScreen(this.q);
        float r5 = this.q[0] + ((r9.getLeft() + r9.getRight()) / 2.0f);
        float r13 = this.q[1];
        int r14 = r9.getTop();
        int r10 = r9.getBottom();
    L51:
        r11 = r13 + ((r14 + r10) / 2.0f);
        r8 = r5;
    L55:
        float r15 = r21.getRawX() - r8;
        float r16 = r21.getRawY() - r11;
        double r17 = Math.toDegrees(Math.atan2(r16, r15));
        int r18 = this.g;
        if (r18 == (-1)) goto L58;
        this.t.getAnchorDpDt(r18, r7, this.k, this.j, this.p);
        float[] r19 = this.p;
        r19[1] = (float) Math.toDegrees(r19[1]);
    L59:
        float r20 = ((float) (Math.toDegrees(Math.atan2(r2 + r16, r6 + r15)) - r17)) * 62.5f;
        if (Float.isNaN(r20) == true) goto L62;
        float r25 = (((r20 * 3.0f) * this.z) / this.p[1]) + r7;
    L64:
        if (r25 == 0.0f) goto L91;
        if (r25 == 1.0f) goto L91;
        int r26 = this.f;
        if (r26 == 3) goto L91;
        float r27 = (r20 * this.z) / this.p[1];
        if (r25 >= 0.5d) goto L72;
        float r28 = 0.0f;
    L74:
        if (r26 != 6) goto L80;
        if ((r7 + r27) >= 0.0f) goto L78;
        r27 = Math.abs(r27);
    L78:
        r28 = 1.0f;
    L80:
        if (this.f == 7) goto L82;
    L85:
        this.t.touchAnimateTo(this.f, r28, r27 * 3.0f);
        if (0.0f < r7) goto L88;
    L89:
        this.t.setState(MotionLayout.g.f34844d);
        return;
    L88:
        if (1.0f <= r7) goto L89;
        return;
    L82:
        if ((r7 + r27) <= 1.0f) goto L84;
        r27 = -Math.abs(r27);
    L84:
        r28 = 0.0f;
        goto L85
    L72:
        r28 = 1.0f;
    L91:
        if (0.0f < r25) goto L93;
    L94:
        this.t.setState(MotionLayout.g.f34844d);
        return;
    L93:
        if (1.0f <= r25) goto L94;
        return;
    L62:
        r25 = r7;
        goto L64
    L58:
        this.p[1] = 360.0f;
        goto L59
    L52:
        int r110 = this.g;
        if (r110 == (-1)) goto L55;
        View r29 = this.t.findViewById(this.t.getMotionController(r110).e());
        this.t.getLocationOnScreen(this.q);
        r5 = this.q[0] + ((r29.getLeft() + r29.getRight()) / 2.0f);
        r13 = this.q[1];
        r14 = r29.getTop();
        r10 = r29.getBottom();
        goto L51
    L7:
        if (r3 != 2) goto L103;
        r21.getRawY();
        r21.getRawX();
        float r30 = this.t.getWidth() / 2.0f;
        float r111 = this.t.getHeight() / 2.0f;
        int r112 = this.l;
        if (r112 == (-1)) goto L12;
        View r31 = this.t.findViewById(r112);
        this.t.getLocationOnScreen(this.q);
        float r113 = this.q[0] + ((r31.getLeft() + r31.getRight()) / 2.0f);
        r111 = ((r31.getTop() + r31.getBottom()) / 2.0f) + this.q[1];
        r30 = r113;
    L18:
        float r32 = r21.getRawX() - r30;
        float r114 = r21.getRawY() - r111;
        double r33 = Math.atan2(r21.getRawY() - r111, r21.getRawX() - r30);
        float r34 = (float) (((r33 - Math.atan2(this.s - r111, this.r - r30)) * 180.0d) / 3.141592653589793d);
        if (r34 <= 330.0f) goto L22;
        r34 = r34 - 360.0f;
    L25:
        if (Math.abs(r34) <= 0.01d) goto L27;
    L28:
        float r35 = this.t.getProgress();
        if (this.o == true) goto L31;
        this.o = true;
        this.t.setProgress(r35);
    L31:
        int r115 = this.g;
        if (r115 == (-1)) goto L34;
        this.t.getAnchorDpDt(r115, r35, this.k, this.j, this.p);
        float[] r36 = this.p;
        r36[1] = (float) Math.toDegrees(r36[1]);
    L35:
        float r37 = Math.max(Math.min(r35 + ((r34 * this.z) / this.p[1]), 1.0f), 0.0f);
        float r38 = this.t.getProgress();
        if (r37 != r38) goto L38;
        this.t.mLastVelocity = 0.0f;
    L47:
        this.r = r21.getRawX();
        this.s = r21.getRawY();
        return;
    L38:
        if (r38 != 0.0f) goto L40;
    L41:
        MotionLayout r39 = this.t;
        if (r38 != 0.0f) goto L44;
        r4 = true;
    L44:
        r39.endTrigger(r4);
    L45:
        this.t.setProgress(r37);
        r1.a(1000);
        float r40 = r1.b();
        double r41 = r1.c();
        double r42 = r40;
        float r43 = (float) ((Math.hypot(r41, r42) * Math.sin(Math.atan2(r41, r42) - r33)) / Math.hypot(r32, r114));
        this.t.mLastVelocity = (float) Math.toDegrees(r43);
        goto L47
    L40:
        if (r38 != 1.0f) goto L45;
    L34:
        this.p[1] = 360.0f;
        goto L35
    L27:
        if (this.o == true) goto L28;
        return;
    L22:
        if (r34 >= (-330.0f)) goto L25;
        r34 = r34 + 360.0f;
        goto L25
    L12:
        int r116 = this.g;
        if (r116 == (-1)) goto L18;
        View r117 = this.t.findViewById(this.t.getMotionController(r116).e());
        if (r117 != null) goto L17;
        a(TAG, "could not find view to animate to");
        goto L18
    L17:
        this.t.getLocationOnScreen(this.q);
        r30 = this.q[0] + ((r117.getLeft() + r117.getRight()) / 2.0f);
        r111 = this.q[1] + ((r117.getTop() + r117.getBottom()) / 2.0f);
        goto L18
    }

    void b(MotionEvent r21, MotionLayout.c r22, int r23, MotionScene r24) {
        MotionLayout.c r2 = (MotionLayout.c) ZeusTransformUtils.wrapperContextForParams(r22, MotionLayout.c.class, "com.obric.aiagent.plugin");
        if (this.f34891c == false) goto L6;
        a(r21, r2, r23, r24);
        return;
    L6:
        r2.a(r21);
        int r3 = r21.getAction();
        if (r3 != 0) goto L9;
        this.r = r21.getRawX();
        this.s = r21.getRawY();
        this.o = false;
        return;
    L9:
        if (r3 != 1) goto L11;
        this.o = false;
        r2.a(1000);
        float r1 = r2.b();
        float r4 = r2.c();
        float r5 = this.t.getProgress();
        int r13 = this.g;
        if (r13 == (-1)) goto L58;
        this.t.getAnchorDpDt(r13, r5, this.k, this.j, this.p);
    L59:
        float r6 = this.m;
        float[] r7 = this.p;
        float r8 = r7[0];
        float r9 = r7[1];
        if (r6 == 0.0f) goto L62;
        float r10 = r1 / r7[0];
    L64:
        if (Float.isNaN(r10) == true) goto L66;
        float r11 = (r10 / 3.0f) + r5;
    L68:
        if (r11 == 0.0f) goto L94;
        if (r11 == 1.0f) goto L94;
        int r12 = this.f;
        if (r12 == 3) goto L94;
        if (r11 >= 0.5d) goto L76;
        float r14 = 0.0f;
    L77:
        if (r12 != 6) goto L83;
        if ((r5 + r10) >= 0.0f) goto L81;
        r10 = Math.abs(r10);
    L81:
        r14 = 1.0f;
    L83:
        if (this.f == 7) goto L85;
    L88:
        this.t.touchAnimateTo(this.f, r14, r10);
        if (0.0f < r5) goto L91;
    L92:
        this.t.setState(MotionLayout.g.f34844d);
        return;
    L91:
        if (1.0f <= r5) goto L92;
        return;
    L85:
        if ((r5 + r10) <= 1.0f) goto L87;
        r10 = -Math.abs(r10);
    L87:
        r14 = 0.0f;
        goto L88
    L76:
        r14 = 1.0f;
    L94:
        if (0.0f < r11) goto L96;
    L97:
        this.t.setState(MotionLayout.g.f34844d);
        return;
    L96:
        if (1.0f <= r11) goto L97;
        return;
    L66:
        r11 = r5;
        goto L68
    L62:
        r10 = r4 / r7[1];
        goto L64
    L58:
        float r15 = Math.min(this.t.getWidth(), this.t.getHeight());
        float[] r16 = this.p;
        r16[1] = this.n * r15;
        r16[0] = r15 * this.m;
        goto L59
    L11:
        if (r3 != 2) goto L106;
        float r17 = r21.getRawY() - this.s;
        float r18 = r21.getRawX() - this.r;
        if (Math.abs((this.m * r18) + (this.n * r17)) <= this.B) goto L16;
    L17:
        float r19 = this.t.getProgress();
        if (this.o == true) goto L20;
        this.o = true;
        this.t.setProgress(r19);
    L20:
        int r110 = this.g;
        if (r110 == (-1)) goto L23;
        this.t.getAnchorDpDt(r110, r19, this.k, this.j, this.p);
    L24:
        float r20 = this.m;
        float[] r25 = this.p;
        if (Math.abs(((r20 * r25[0]) + (this.n * r25[1])) * this.z) >= 0.01d) goto L28;
        float[] r26 = this.p;
        r26[0] = 0.01f;
        r26[1] = 0.01f;
    L28:
        if (this.m == 0.0f) goto L30;
        float r111 = r18 / this.p[0];
    L31:
        float r27 = Math.max(Math.min(r19 + r111, 1.0f), 0.0f);
        if (this.f != 6) goto L35;
        r27 = Math.max(r27, 0.01f);
    L35:
        if (this.f != 7) goto L37;
        r27 = Math.min(r27, 0.99f);
    L37:
        float r28 = this.t.getProgress();
        if (r27 != r28) goto L40;
        this.t.mLastVelocity = 0.0f;
    L54:
        this.r = r21.getRawX();
        this.s = r21.getRawY();
        return;
    L40:
        if (r28 != 0.0f) goto L42;
    L43:
        MotionLayout r29 = this.t;
        if (r28 != 0.0f) goto L46;
        boolean r30 = true;
    L47:
        r29.endTrigger(r30);
    L48:
        this.t.setProgress(r27);
        r2.a(1000);
        float r31 = r2.b();
        float r32 = r2.c();
        if (this.m == 0.0f) goto L51;
        float r33 = r31 / this.p[0];
    L52:
        this.t.mLastVelocity = r33;
        goto L54
    L51:
        r33 = r32 / this.p[1];
        goto L52
    L46:
        r30 = false;
        goto L47
    L42:
        if (r28 != 1.0f) goto L48;
    L30:
        r111 = r17 / this.p[1];
        goto L31
    L23:
        float r34 = Math.min(this.t.getWidth(), this.t.getHeight());
        float[] r35 = this.p;
        r35[1] = this.n * r34;
        r35[0] = r34 * this.m;
        goto L24
    L16:
        if (this.o == true) goto L17;
        return;
    }

    void b(float r1, float r2) {
        this.r = r1;
        this.s = r2;
    }

    float c(float r8, float r9) {
        float r3 = this.t.getProgress();
        this.t.getAnchorDpDt(this.g, r3, this.k, this.j, this.p);
        float r0 = this.m;
        if (r0 == 0.0f) goto L8;
        float[] r7 = this.p;
        if (r7[0] != 0.0f) goto L13;
        r7[0] = 1.0E-7f;
    L13:
        return (r8 * r0) / r7[0];
    L8:
        float[] r10 = this.p;
        if (r10[1] != 0.0f) goto L12;
        r10[1] = 1.0E-7f;
    L12:
        return (r9 * this.n) / r10[1];
    }

    void d(float r9, float r10) {
        this.o = false;
        float r1 = this.t.getProgress();
        this.t.getAnchorDpDt(this.g, r1, this.k, this.j, this.p);
        float r2 = this.m;
        float[] r3 = this.p;
        float r4 = r3[0];
        float r5 = this.n;
        float r6 = r3[1];
        float r7 = 0.0f;
        if (r2 == 0.0f) goto L5;
        float r11 = (r9 * r2) / r3[0];
    L7:
        if (Float.isNaN(r11) == true) goto L10;
        r1 = r1 + (r11 / 3.0f);
    L10:
        if (r1 != 0.0f) goto L12;
        return;
    L12:
        if (r1 == 1.0f) goto L22;
        int r0 = this.f;
        if (r0 == 3) goto L23;
        MotionLayout r8 = this.t;
        if (r1 < 0.5d) goto L19;
        r7 = 1.0f;
    L19:
        r8.touchAnimateTo(r0, r7, r11);
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r11 = (r10 * r5) / r3[1];
        goto L7
    }

    void e(float r9, float r10) {
        float r0 = this.t.getProgress();
        if (this.o == true) goto L5;
        this.o = true;
        this.t.setProgress(r0);
    L5:
        this.t.getAnchorDpDt(this.g, r0, this.k, this.j, this.p);
        float r1 = this.m;
        float[] r2 = this.p;
        if (Math.abs((r1 * r2[0]) + (this.n * r2[1])) >= 0.01d) goto L8;
        float[] r3 = this.p;
        r3[0] = 0.01f;
        r3[1] = 0.01f;
    L8:
        float r4 = this.m;
        if (r4 == 0.0f) goto L11;
        float r11 = (r9 * r4) / this.p[0];
    L12:
        float r12 = Math.max(Math.min(r0 + r11, 1.0f), 0.0f);
        if (r12 == this.t.getProgress()) goto L16;
        this.t.setProgress(r12);
        return;
    L16:
        return;
    L11:
        r11 = (r10 * this.n) / this.p[1];
        goto L12
    }

    void a() {
        int r0 = this.g;
        if (r0 == (-1)) goto L7;
        View r1 = this.t.findViewById(r0);
        if (r1 != null) goto L9;
        a(TAG, "cannot find TouchAnchorId @id/" + a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.t.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.g));
    L9:
        if (ZeusTransformUtils.instanceOf(r1, NestedScrollView.class) == false) goto L12;
        NestedScrollView r2 = (NestedScrollView) ZeusTransformUtils.preCheckCast(r1, NestedScrollView.class, "com.obric.aiagent.plugin");
        r2.setOnTouchListener(new TouchResponse$1(this));
        r2.setOnScrollChangeListener(new AnonymousClass1(this));
        return;
    L12:
        return;
    L7:
        r1 = null;
        goto L9
    }

    float b() {
        return this.x;
    }

    public float c() {
        return this.w;
    }

    boolean d() {
        return this.y;
    }

    public int e() {
        return this.H;
    }

    RectF a(ViewGroup r3, RectF r4) {
        int r2 = this.h;
        if (r2 != (-1)) goto L5;
        return null;
    L5:
        View r5 = r3.findViewById(r2);
        if (r5 != null) goto L8;
        return null;
    L8:
        r4.set(r5.getLeft(), r5.getTop(), r5.getRight(), r5.getBottom());
        return r4;
    }

    int f() {
        return this.h;
    }

    RectF b(ViewGroup r3, RectF r4) {
        int r2 = this.i;
        if (r2 != (-1)) goto L5;
        return null;
    L5:
        View r5 = r3.findViewById(r2);
        if (r5 != null) goto L8;
        return null;
    L8:
        r4.set(r5.getLeft(), r5.getTop(), r5.getRight(), r5.getBottom());
        return r4;
    }

    float f(float r2, float r3) {
        return (r2 * this.m) + (r3 * this.n);
    }

    public String toString() {
        if (Float.isNaN(this.m) == false) goto L6;
        return "rotation";
    L6:
        return this.m + " , " + this.n;
    }

    public int g() {
        return this.A;
    }

    public void a(int r1) {
        this.f = r1;
    }

    public float h() {
        return this.E;
    }

    public float i() {
        return this.D;
    }

    public float j() {
        return this.C;
    }

    public float k() {
        return this.F;
    }

    public int l() {
        return this.G;
    }

    boolean m() {
        return this.o;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
