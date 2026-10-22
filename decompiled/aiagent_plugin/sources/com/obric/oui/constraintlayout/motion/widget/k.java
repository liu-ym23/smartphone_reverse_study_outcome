package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: KeyTrigger.java */
/* JADX INFO: loaded from: classes4.dex */
public class k extends d {
    private static final String TAG = "KeyTrigger";
    private boolean A;
    float g;
    int h;
    int i;
    int j;
    RectF k;
    RectF l;
    HashMap<String, Method> m;
    private int n;
    private String o;
    private int p;
    private String q;
    private String r;
    private int s;
    private int t;
    private View u;
    private boolean v;
    private boolean w;
    private boolean x;
    private float y;
    private float z;

    /* JADX INFO: compiled from: KeyTrigger.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SparseIntArray f34872a;

        static {
            SparseIntArray r0 = new SparseIntArray();
            f34872a = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_framePosition, "styleable", "KeyTrigger_framePosition"), 8);
            f34872a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_onCross, "styleable", "KeyTrigger_onCross"), 4);
            f34872a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_onNegativeCross, "styleable", "KeyTrigger_onNegativeCross"), 1);
            f34872a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_onPositiveCross, "styleable", "KeyTrigger_onPositiveCross"), 2);
            f34872a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_motionTarget, "styleable", "KeyTrigger_motionTarget"), 7);
            f34872a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_triggerId, "styleable", "KeyTrigger_triggerId"), 6);
            f34872a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_triggerSlack, "styleable", "KeyTrigger_triggerSlack"), 5);
            f34872a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_motion_triggerOnCollision, "styleable", "KeyTrigger_motion_triggerOnCollision"), 9);
            f34872a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_motion_postLayoutCollision, "styleable", "KeyTrigger_motion_postLayoutCollision"), 10);
            f34872a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_triggerReceiver, "styleable", "KeyTrigger_triggerReceiver"), 11);
            f34872a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_viewTransitionOnCross, "styleable", "KeyTrigger_viewTransitionOnCross"), 12);
            f34872a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_viewTransitionOnNegativeCross, "styleable", "KeyTrigger_viewTransitionOnNegativeCross"), 13);
            f34872a.append(ZeusTransformUtils.mapRes(R.styleable.KeyTrigger_viewTransitionOnPositiveCross, "styleable", "KeyTrigger_viewTransitionOnPositiveCross"), 14);
        }

        public static void a(k r4, TypedArray r5, Context r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            int r8 = r5.getIndexCount();
            int r0 = 0;
        L3:
            if (r0 >= r8) goto L29;
            int r1 = r5.getIndex(r0);
            switch(f34872a.get(r1)) {
                case 1: goto L27;
                case 2: goto L26;
                case 3: goto L6;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L15;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L6:
            a(k.TAG, "unused attribute 0x" + Integer.toHexString(r1) + "   " + f34872a.get(r1));
        L28:
            r0 = r0 + 1;
            goto L3
        L7:
            r4.i = r5.getResourceId(r1, r4.i);
            goto L28
        L8:
            r4.h = r5.getResourceId(r1, r4.h);
            goto L28
        L9:
            r4.j = r5.getResourceId(r1, r4.j);
            goto L28
        L10:
            k.c(r4, r5.getResourceId(r1, k.d(r4)));
            goto L28
        L11:
            k.a(r4, r5.getBoolean(r1, k.c(r4)));
            goto L28
        L12:
            k.b(r4, r5.getResourceId(r1, k.b(r4)));
            goto L28
        L13:
            r4.f34862b = r5.getInteger(r1, r4.f34862b);
            k.a(r4, (r4.f34862b + 0.5f) / 100.0f);
            goto L28
        L23:
            k.a(r4, r5.getResourceId(r1, k.a(r4)));
            goto L28
        L24:
            r4.g = r5.getFloat(r1, r4.g);
            goto L28
        L25:
            k.c(r4, r5.getString(r1));
            goto L28
        L26:
            k.b(r4, r5.getString(r1));
            goto L28
        L27:
            k.a(r4, r5.getString(r1));
            goto L28
        L15:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L20;
            r4.f34863c = r5.getResourceId(r1, r4.f34863c);
            if (r4.f34863c != (-1)) goto L28;
            r4.f34864d = r5.getString(r1);
            goto L28
        L20:
            if (r5.peekValue(r1).type != 3) goto L22;
            r4.f34864d = r5.getString(r1);
            goto L28
        L22:
            r4.f34863c = r5.getResourceId(r1, r4.f34863c);
            goto L28
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(HashMap<String, com.obric.oui.constraintlayout.motion.utils.c> r1) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(HashSet<String> r1) {
    }

    public k() {
        this.g = 0.1f;
        this.h = f34861a;
        this.i = f34861a;
        this.j = f34861a;
        this.k = new RectF();
        this.l = new RectF();
        this.m = new HashMap();
        this.n = -1;
        this.o = null;
        this.p = f34861a;
        this.q = null;
        this.r = null;
        this.s = f34861a;
        this.t = f34861a;
        this.u = null;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = Float.NaN;
        this.A = false;
        this.f34865e = 5;
        this.f = new HashMap();
    }

    static /* synthetic */ float a(k r0, float r1) {
        r0.y = r1;
        return r1;
    }

    static /* synthetic */ int a(k r0) {
        return r0.s;
    }

    static /* synthetic */ int a(k r0, int r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ String a(k r0, String r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ boolean a(k r0, boolean r1) {
        r0.A = r1;
        return r1;
    }

    static /* synthetic */ int b(k r0) {
        return r0.t;
    }

    static /* synthetic */ int b(k r0, int r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ String b(k r0, String r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ int c(k r0, int r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ String c(k r0, String r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ boolean c(k r0) {
        return r0.A;
    }

    static /* synthetic */ int d(k r0) {
        return r0.p;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public /* synthetic */ Object clone() {
        return a();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        a.a(this, r5.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.KeyTrigger), r5);
    }

    private void a(RectF r1, View r2, boolean r3) {
        r1.top = r2.getTop();
        r1.bottom = r2.getBottom();
        r1.left = r2.getLeft();
        r1.right = r2.getRight();
        if (r3 == false) goto L6;
        r2.getMatrix().mapRect(r1);
        return;
    }

    public void a(float r11, View r12) {
        if (this.t == f34861a) goto L28;
        if (this.u != null) goto L7;
        this.u = ((ViewGroup) ZeusTransformUtils.preCheckCast(r12.getParent(), ViewGroup.class, "com.obric.aiagent.plugin")).findViewById(this.t);
    L7:
        a(this.k, this.u, this.A);
        a(this.l, r12, this.A);
        if (this.k.intersect(this.l) == false) goto L19;
        if (this.v == false) goto L12;
        this.v = false;
        boolean r0 = true;
    L14:
        if (this.x == false) goto L16;
        this.x = false;
        boolean r1 = true;
    L17:
        this.w = true;
        boolean r5 = r1;
        boolean r2 = false;
    L61:
        this.z = r11;
        if (r2 == true) goto L65;
        if (r0 == true) goto L65;
        if (r5 == true) goto L65;
    L67:
        if (this.p != f34861a) goto L69;
        View r13 = r12;
    L70:
        if (r2 == false) goto L77;
        String r3 = this.q;
        if (r3 == null) goto L75;
        a(r3, r13);
    L75:
        if (this.h == f34861a) goto L77;
        ((MotionLayout) ZeusTransformUtils.preCheckCast(r12.getParent(), MotionLayout.class, "com.obric.aiagent.plugin")).viewTransition(this.h, new View[]{r13});
    L77:
        if (r5 == false) goto L84;
        String r4 = this.r;
        if (r4 == null) goto L82;
        a(r4, r13);
    L82:
        if (this.i == f34861a) goto L84;
        ((MotionLayout) ZeusTransformUtils.preCheckCast(r12.getParent(), MotionLayout.class, "com.obric.aiagent.plugin")).viewTransition(this.i, new View[]{r13});
    L84:
        if (r0 == false) goto L92;
        String r6 = this.o;
        if (r6 == null) goto L89;
        a(r6, r13);
    L89:
        if (this.j == f34861a) goto L93;
        ((MotionLayout) ZeusTransformUtils.preCheckCast(r12.getParent(), MotionLayout.class, "com.obric.aiagent.plugin")).viewTransition(this.j, new View[]{r13});
        return;
    L93:
        return;
    L92:
        return;
    L69:
        r13 = ((MotionLayout) ZeusTransformUtils.preCheckCast(r12.getParent(), MotionLayout.class, "com.obric.aiagent.plugin")).findViewById(this.p);
    L65:
        ((MotionLayout) ZeusTransformUtils.preCheckCast(r12.getParent(), MotionLayout.class, "com.obric.aiagent.plugin")).fireTrigger(this.s, r5, r11);
        goto L67
    L16:
        r1 = false;
        goto L17
    L12:
        r0 = false;
        goto L14
    L19:
        if (this.v == true) goto L21;
        this.v = true;
        r0 = true;
    L23:
        if (this.w == false) goto L25;
        this.w = false;
        r2 = true;
    L26:
        this.x = true;
    L60:
        r5 = false;
        goto L61
    L25:
        r2 = false;
        goto L26
    L21:
        r0 = false;
        goto L23
    L28:
        if (this.v == false) goto L33;
        float r7 = this.y;
        if (((r11 - r7) * (this.z - r7)) >= 0.0f) goto L35;
        this.v = false;
        r0 = true;
    L37:
        if (this.w == false) goto L44;
        float r8 = this.y;
        float r9 = r11 - r8;
        if (((this.z - r8) * r9) < 0.0f) goto L41;
    L46:
        boolean r10 = false;
    L48:
        if (this.x == false) goto L57;
        float r14 = this.y;
        float r15 = r11 - r14;
        if (((this.z - r14) * r15) < 0.0f) goto L52;
    L54:
        boolean r16 = false;
    L55:
        boolean r17 = r10;
        r5 = r16;
        r2 = r17;
        goto L61
    L52:
        if (r15 <= 0.0f) goto L54;
        this.x = false;
        r16 = true;
        goto L55
    L57:
        if (Math.abs(r11 - this.y) <= this.g) goto L59;
        this.x = true;
    L59:
        r2 = r10;
        goto L60
    L41:
        if (r9 >= 0.0f) goto L46;
        this.w = false;
        r10 = true;
        goto L48
    L44:
        if (Math.abs(r11 - this.y) <= this.g) goto L46;
        this.w = true;
    L35:
        r0 = false;
        goto L37
    L33:
        if (Math.abs(r11 - this.y) <= this.g) goto L35;
        this.v = true;
        goto L35
    }

    private void a(String r8, View r9) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.startsWith(".") == false) goto L9;
        b(r8, r9);
        return;
    L9:
        if (this.m.containsKey(r8) == false) goto L13;
        Method r0 = (Method) ZeusTransformUtils.preCheckCast(this.m.get(r8), Method.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L15;
        return;
    L15:
        if (r0 != null) goto L26;
        r0 = r9.getClass().getMethod(r8, new Class[0]);     // Catch: NoSuchMethodException -> L18
        this.m.put(r8, r0);     // Catch: NoSuchMethodException -> L18
    L18:
        this.m.put(r8, null);
        a(TAG, "Could not find method \"" + r8 + "\"on class " + r9.getClass().getSimpleName() + " " + com.obric.oui.constraintlayout.motion.widget.a.a(r9));
        return;
    L26:
        r0.invoke(r9, new Object[0]);     // Catch: Exception -> L22
        return;
    L22:
        a(TAG, "Exception in call \"" + this.o + "\"on class " + r9.getClass().getSimpleName() + " " + com.obric.oui.constraintlayout.motion.widget.a.a(r9));
        return;
    L13:
        r0 = null;
        goto L15
    }

    private void b(String r6, View r7) {
        if (r6.length() != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        r6 = r6.substring(1).toLowerCase(Locale.ROOT);
    L8:
        Iterator<String> r1 = this.f.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L18;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        String r3 = r2.toLowerCase(Locale.ROOT);
        if (r0 == true) goto L15;
        if (r3.matches(r6) == false) goto L10;
    L15:
        com.obric.oui.constraintlayout.widget.a r4 = (com.obric.oui.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(this.f.get(r2), com.obric.oui.constraintlayout.widget.a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        r4.a(r7);
        goto L10
    L18:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public d a(d r3) {
        super.a(r3);
        k r4 = (k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.aiagent.plugin");
        this.n = r4.n;
        this.o = r4.o;
        this.p = r4.p;
        this.q = r4.q;
        this.r = r4.r;
        this.s = r4.s;
        this.t = r4.t;
        this.u = r4.u;
        this.g = r4.g;
        this.v = r4.v;
        this.w = r4.w;
        this.x = r4.x;
        this.y = r4.y;
        this.z = r4.z;
        this.A = r4.A;
        this.k = r4.k;
        this.l = r4.l;
        this.m = r4.m;
        return this;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public d a() {
        return new k().a(this);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
