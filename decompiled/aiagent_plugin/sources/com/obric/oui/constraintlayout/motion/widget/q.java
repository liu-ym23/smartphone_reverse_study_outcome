package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ViewTransition.java */
/* JADX INFO: loaded from: classes4.dex */
public class q {
    private static final String TAG = "ViewTransition";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f34895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    g f34896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.obric.oui.constraintlayout.widget.c.a f34897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Context f34898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f34899e;
    private int f;
    private boolean g;
    private int h;
    private int i;
    private int j;
    private int k;
    private String l;
    private int m;
    private String n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;

    /* JADX INFO: compiled from: ViewTransition.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f34900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        m f34901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f34902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f34903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        com.obric.oui.constraintlayout.a.a.a.d f34904e;
        r f;
        Interpolator g;
        boolean h;
        float i;
        float j;
        long k;
        Rect l;
        boolean m;
        private final int n;
        private final int o;

        a(r r3, m r4, int r5, int r6, int r7, Interpolator r8, int r9, int r10) {
            Interpolator r11 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r8, Interpolator.class, "com.obric.aiagent.plugin");
            this.f34904e = new com.obric.oui.constraintlayout.a.a.a.d();
            this.h = false;
            this.l = new Rect();
            this.m = false;
            this.f = r3;
            this.f34901b = r4;
            this.f34902c = r5;
            this.f34903d = r6;
            long r12 = System.nanoTime();
            this.f34900a = r12;
            this.k = r12;
            this.f.a(this);
            this.g = r11;
            this.n = r9;
            this.o = r10;
            if (r7 != 3) goto L5;
            this.m = true;
        L5:
            if (r5 != 0) goto L7;
            float r13 = Float.MAX_VALUE;
        L8:
            this.j = r13;
            a();
            return;
        L7:
            r13 = 1.0f / r5;
            goto L8
        }

        void a(boolean r3) {
            this.h = r3;
            if (r3 == false) goto L10;
            int r4 = this.f34903d;
            if (r4 == (-1)) goto L10;
            if (r4 != 0) goto L8;
            float r5 = Float.MAX_VALUE;
        L9:
            this.j = r5;
            goto L10
        L8:
            r5 = 1.0f / r4;
        L10:
            this.f.b();
            this.k = System.nanoTime();
        }

        void a() {
            if (this.h == false) goto L5;
            b();
            return;
        L5:
            c();
        }

        void b() {
            long r3 = System.nanoTime();
            long r0 = r3 - this.k;
            this.k = r3;
            float r2 = this.i - (((float) (r0 * 1.0E-6d)) * this.j);
            this.i = r2;
            if (r2 >= 0.0f) goto L5;
            this.i = 0.0f;
        L5:
            Interpolator r1 = this.g;
            if (r1 != null) goto L8;
            float r4 = this.i;
        L9:
            float r5 = r4;
            m r6 = this.f34901b;
            boolean r7 = r6.a(r6.f34880b, r5, r3, this.f34904e);
            if (this.i > 0.0f) goto L19;
            if (this.n == (-1)) goto L15;
            this.f34901b.i().setTag(this.n, Long.valueOf(System.nanoTime()));
        L15:
            if (this.o == (-1)) goto L17;
            this.f34901b.i().setTag(this.o, null);
        L17:
            this.f.b(this);
        L19:
            if (this.i > 0.0f) goto L21;
            if (r7 == true) goto L21;
            return;
        L21:
            this.f.b();
            return;
        L8:
            r4 = r1.getInterpolation(this.i);
            goto L9
        }

        void c() {
            long r3 = System.nanoTime();
            long r0 = r3 - this.k;
            this.k = r3;
            float r2 = this.i + (((float) (r0 * 1.0E-6d)) * this.j);
            this.i = r2;
            if (r2 < 1.0f) goto L5;
            this.i = 1.0f;
        L5:
            Interpolator r1 = this.g;
            if (r1 != null) goto L8;
            float r4 = this.i;
        L9:
            float r5 = r4;
            m r6 = this.f34901b;
            boolean r7 = r6.a(r6.f34880b, r5, r3, this.f34904e);
            if (this.i < 1.0f) goto L21;
            if (this.n == (-1)) goto L15;
            this.f34901b.i().setTag(this.n, Long.valueOf(System.nanoTime()));
        L15:
            if (this.o == (-1)) goto L18;
            this.f34901b.i().setTag(this.o, null);
        L18:
            if (this.m == true) goto L21;
            this.f.b(this);
        L21:
            if (this.i < 1.0f) goto L23;
            if (r7 == true) goto L23;
            return;
        L23:
            this.f.b();
            return;
        L8:
            r4 = r1.getInterpolation(this.i);
            goto L9
        }

        public void a(int r3, float r4, float r5) {
            if (r3 == 1) goto L14;
            if (r3 != 2) goto L19;
            this.f34901b.i().getHitRect(this.l);
            if (this.l.contains((int) r4, (int) r5) == false) goto L10;
            return;
        L10:
            if (this.h == true) goto L18;
            a(true);
            return;
        L18:
            return;
        L19:
            return;
        L14:
            if (this.h == true) goto L20;
            a(true);
            return;
        }
    }

    public static /* synthetic */ void lambda$Uirc99yqoZa3eIXxHvS0eK0CWCE(q r0, View[] r1) {
        r0.a(r1);
    }

    public int a() {
        return this.f;
    }

    public int b() {
        return this.t;
    }

    public int c() {
        return this.u;
    }

    public String toString() {
        return "ViewTransition(" + com.obric.oui.constraintlayout.motion.widget.a.a(this.f34898d, this.f34899e) + ")";
    }

    Interpolator a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        int r0 = this.m;
        if (r0 == (-2)) goto L34;
        if (r0 == (-1)) goto L31;
        if (r0 == 0) goto L30;
        if (r0 == 1) goto L28;
        if (r0 == 2) goto L26;
        if (r0 == 4) goto L24;
        if (r0 == 5) goto L22;
        if (r0 == 6) goto L20;
        return null;
    L20:
        return new AnticipateInterpolator();
    L22:
        return new OvershootInterpolator();
    L24:
        return new BounceInterpolator();
    L26:
        return new DecelerateInterpolator();
    L28:
        return new AccelerateInterpolator();
    L30:
        return new AccelerateDecelerateInterpolator();
    L31:
        final com.obric.oui.constraintlayout.a.a.a.c r5 = com.obric.oui.constraintlayout.a.a.a.c.a(this.n);
        return new ViewTransition$1(this, r5);
    L34:
        return AnimationUtils.loadInterpolator(r4, this.o);
    }

    q(Context r11, XmlPullParser r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r14 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r12, XmlPullParser.class, "com.obric.aiagent.plugin");
        this.f = -1;
        this.g = false;
        this.h = 0;
        this.i = -1;
        this.j = -1;
        this.m = 0;
        this.n = null;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.f34898d = ZeusTransformUtils.wrapperContext(r13, "com.obric.aiagent.plugin");
        int r3 = r14.getEventType();     // Catch: IOException -> L44 XmlPullParserException -> L46
    L5:
        if (r3 == 1) goto L62;
        if (r3 == 2) goto L13;
        if (r3 == 3) goto L11;
    L42:
        r3 = r14.next();     // Catch: IOException -> L44 XmlPullParserException -> L46
    L11:
        if (TAG.equals(r14.getName()) == false) goto L42;
        return;
    L13:
        String r4 = r14.getName();     // Catch: IOException -> L44 XmlPullParserException -> L46
        switch(r4.hashCode()) {
            case -1962203927: goto L29;
            case -1239391468: goto L26;
            case 61998586: goto L23;
            case 366511058: goto L20;
            case 1791837707: goto L17;
            default: goto L31;
        };     // Catch: IOException -> L44 XmlPullParserException -> L46
    L31:
        byte r8 = -1;
    L32:
        if (r8 == 0) goto L41;
        if (r8 == 1) goto L40;
        if (r8 == 2) goto L39;
        if (r8 == 3) goto L38;
        if (r8 == 4) goto L38;
        a(TAG, com.obric.oui.constraintlayout.motion.widget.a.b() + " unknown tag " + r4);     // Catch: IOException -> L44 XmlPullParserException -> L46
        a(TAG, ".xml:" + r14.getLineNumber());     // Catch: IOException -> L44 XmlPullParserException -> L46
    L38:
        com.obric.oui.constraintlayout.widget.a.a(r13, r14, this.f34897c.g);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L39:
        this.f34897c = com.obric.oui.constraintlayout.widget.c.b(r13, r14);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L40:
        this.f34896b = new g(r13, r14);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L41:
        a(r13, r14);     // Catch: IOException -> L44 XmlPullParserException -> L46
        goto L42
    L17:
        if (r4.equals("CustomAttribute") == false) goto L31;
        r8 = 3;
        goto L32
    L20:
        if (r4.equals("CustomMethod") == false) goto L31;
        r8 = 4;
        goto L32
    L23:
        if (r4.equals(TAG) == false) goto L31;
        r8 = 0;
        goto L32
    L26:
        if (r4.equals("KeyFrameSet") == false) goto L31;
        r8 = 1;
        goto L32
    L29:
        if (r4.equals("ConstraintOverride") == false) goto L31;
        r8 = 2;
        goto L32
    L62:
        return;
    L44:
        e = move-exception;
        a(TAG, "Error parsing XML resource", e);
        return;
    L46:
        e = move-exception;
        a(TAG, "Error parsing XML resource", e);
    }

    private void a(Context r9, XmlPullParser r10) {
        TypedArray r11 = ((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r10, XmlPullParser.class, "com.obric.aiagent.plugin")), R.styleable.ViewTransition);
        int r12 = r11.getIndexCount();
        int r0 = 0;
    L3:
        if (r0 >= r12) goto L71;
        int r1 = r11.getIndex(r0);
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_android_id, "styleable", "ViewTransition_android_id")) goto L8;
        this.f34899e = r11.getResourceId(r1, this.f34899e);
    L70:
        r0 = r0 + 1;
        goto L3
    L8:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_motionTarget, "styleable", "ViewTransition_motionTarget")) goto L19;
        if (MotionLayout.IS_IN_EDIT_MODE == false) goto L15;
        int r2 = r11.getResourceId(r1, this.k);
        this.k = r2;
        if (r2 != (-1)) goto L70;
        this.l = r11.getString(r1);
        goto L70
    L15:
        if (r11.peekValue(r1).type != 3) goto L17;
        this.l = r11.getString(r1);
        goto L70
    L17:
        this.k = r11.getResourceId(r1, this.k);
        goto L70
    L19:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_onStateTransition, "styleable", "ViewTransition_onStateTransition")) goto L22;
        this.f = r11.getInt(r1, this.f);
        goto L70
    L22:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_transitionDisable, "styleable", "ViewTransition_transitionDisable")) goto L25;
        this.g = r11.getBoolean(r1, this.g);
        goto L70
    L25:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_pathMotionArc, "styleable", "ViewTransition_pathMotionArc")) goto L28;
        this.h = r11.getInt(r1, this.h);
        goto L70
    L28:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_duration, "styleable", "ViewTransition_duration")) goto L31;
        this.i = r11.getInt(r1, this.i);
        goto L70
    L31:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_upDuration, "styleable", "ViewTransition_upDuration")) goto L34;
        this.j = r11.getInt(r1, this.j);
        goto L70
    L34:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_viewTransitionMode, "styleable", "ViewTransition_viewTransitionMode")) goto L37;
        this.f34895a = r11.getInt(r1, this.f34895a);
        goto L70
    L37:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_motionInterpolator, "styleable", "ViewTransition_motionInterpolator")) goto L53;
        TypedValue r3 = r11.peekValue(r1);
        if (r3.type != 1) goto L44;
        int r4 = r11.getResourceId(r1, -1);
        this.o = r4;
        if (r4 == (-1)) goto L70;
        this.m = -2;
        goto L70
    L44:
        if (r3.type != 3) goto L51;
        String r5 = r11.getString(r1);
        this.n = r5;
        if (r5 != null) goto L48;
    L50:
        this.m = -1;
        goto L70
    L48:
        if (r5.indexOf("/") <= 0) goto L50;
        this.o = r11.getResourceId(r1, -1);
        this.m = -2;
        goto L70
    L51:
        this.m = r11.getInteger(r1, this.m);
        goto L70
    L53:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_setsTag, "styleable", "ViewTransition_setsTag")) goto L56;
        this.p = r11.getResourceId(r1, this.p);
        goto L70
    L56:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_clearsTag, "styleable", "ViewTransition_clearsTag")) goto L59;
        this.q = r11.getResourceId(r1, this.q);
        goto L70
    L59:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_ifTagSet, "styleable", "ViewTransition_ifTagSet")) goto L62;
        this.r = r11.getResourceId(r1, this.r);
        goto L70
    L62:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_ifTagNotSet, "styleable", "ViewTransition_ifTagNotSet")) goto L65;
        this.s = r11.getResourceId(r1, this.s);
        goto L70
    L65:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_SharedValueId, "styleable", "ViewTransition_SharedValueId")) goto L68;
        this.u = r11.getResourceId(r1, this.u);
        goto L70
    L68:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.ViewTransition_SharedValue, "styleable", "ViewTransition_SharedValue")) goto L70;
        this.t = r11.getInteger(r1, this.t);
        goto L70
    L71:
        r11.recycle();
    }

    void a(r r10, MotionLayout r11, View r12) {
        m r6 = new m(r12);
        r6.c(r12);
        this.f34896b.a(r6);
        r6.a(r11.getWidth(), r11.getHeight(), this.i, System.nanoTime());
        new a(r10, r6, this.i, this.j, this.f, a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), this.p, this.q);
    }

    void a(r r8, MotionLayout r9, int r10, com.obric.oui.constraintlayout.widget.c r11, final View... r12) {
        if (this.g == false) goto L5;
        return;
    L5:
        int r0 = this.f34895a;
        int r2 = 0;
        if (r0 != 2) goto L10;
        a(r8, r9, r12[0]);
        return;
    L10:
        if (r0 != 1) goto L24;
        int[] r13 = r9.getConstraintSetIds();
        int r1 = 0;
    L13:
        if (r1 >= r13.length) goto L24;
        int r3 = r13[r1];
        if (r3 == r10) goto L23;
        com.obric.oui.constraintlayout.widget.c r4 = r9.getConstraintSet(r3);
        int r5 = r12.length;
        int r6 = 0;
    L18:
        if (r6 >= r5) goto L23;
        com.obric.oui.constraintlayout.widget.c.a r7 = r4.f(r12[r6].getId());
        com.obric.oui.constraintlayout.widget.c.a r14 = this.f34897c;
        if (r14 == null) goto L22;
        r14.a(r7);
        r7.g.putAll(this.f34897c.g);
    L22:
        r6 = r6 + 1;
    L23:
        r1 = r1 + 1;
    L24:
        com.obric.oui.constraintlayout.widget.c r15 = new com.obric.oui.constraintlayout.widget.c();
        r15.c(r11);
        int r16 = r12.length;
        int r17 = 0;
    L25:
        if (r17 >= r16) goto L30;
        com.obric.oui.constraintlayout.widget.c.a r18 = r15.f(r12[r17].getId());
        com.obric.oui.constraintlayout.widget.c.a r19 = this.f34897c;
        if (r19 == null) goto L29;
        r19.a(r18);
        r18.g.putAll(this.f34897c.g);
    L29:
        r17 = r17 + 1;
        goto L25
    L30:
        r9.updateState(r10, r15);
        r9.updateState(ZeusTransformUtils.mapRes(R.id.view_transition, DbHelper.COL_ID, "view_transition"), r11);
        r9.setState(ZeusTransformUtils.mapRes(R.id.view_transition, DbHelper.COL_ID, "view_transition"), -1, -1);
        MotionScene.Transition r20 = new MotionScene.Transition(-1, r9.mScene, ZeusTransformUtils.mapRes(R.id.view_transition, DbHelper.COL_ID, "view_transition"), r10);
        int r110 = r12.length;
    L31:
        if (r2 >= r110) goto L33;
        a(r20, r12[r2]);
        r2 = r2 + 1;
        goto L31
    L33:
        r9.setTransition(r20);
        r9.transitionToEnd(new $$Lambda$q$Uirc99yqoZa3eIXxHvS0eK0CWCE(this, r12));
    }

    private /* synthetic */ void a(View[] r9) {
        int r1 = 0;
        if (this.p == (-1)) goto L8;
        int r0 = r9.length;
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L8;
        r9[r3].setTag(this.p, Long.valueOf(System.nanoTime()));
        r3 = r3 + 1;
    L8:
        if (this.q == (-1)) goto L12;
        int r2 = r9.length;
    L10:
        if (r1 >= r2) goto L15;
        r9[r1].setTag(this.q, null);
        r1 = r1 + 1;
        goto L10
    L15:
        return;
    }

    private void a(MotionScene.Transition r5, View r6) {
        int r0 = this.i;
        if (r0 == (-1)) goto L5;
        r5.a(r0);
    L5:
        r5.b(this.h);
        r5.a(this.m, this.n, this.o);
        int r7 = r6.getId();
        g r4 = this.f34896b;
        if (r4 == null) goto L14;
        ArrayList<d> r8 = r4.a(-1);
        g r1 = new g();
        Iterator<d> r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L11;
        r1.a(((d) ZeusTransformUtils.preCheckCast(r9.next(), d.class, "com.obric.aiagent.plugin")).a().a(r7));
        goto L9
    L11:
        r5.a(r1);
        return;
    }

    int d() {
        return this.f34899e;
    }

    boolean a(View r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.k != (-1)) goto L11;
        if (this.l != null) goto L11;
        return false;
    L11:
        if (b(r5) == true) goto L14;
        return false;
    L14:
        if (r5.getId() != this.k) goto L17;
        return true;
    L17:
        if (this.l != null) goto L20;
        return false;
    L20:
        if (ZeusTransformUtils.instanceOf(r5.getLayoutParams(), ConstraintLayout.LayoutParams.class) == false) goto L26;
        String r6 = ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin")).constraintTag;
        if (r6 == null) goto L26;
        if (r6.matches(this.l) == false) goto L26;
        return true;
    L26:
        return false;
    }

    boolean a(int r4) {
        int r3 = this.f;
        if (r3 != 1) goto L8;
        if (r4 == 0) goto L6;
        return false;
    L6:
        return true;
    L8:
        if (r3 != 2) goto L13;
        if (r4 == 1) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (r3 != 3) goto L19;
        if (r4 == 0) goto L16;
        return false;
    L16:
        return true;
    L19:
        return false;
    }

    boolean e() {
        return !this.g;
    }

    void a(boolean r1) {
        this.g = !r1;
    }

    boolean b(View r5) {
        int r0 = this.r;
        if (r0 != (-1)) goto L6;
    L4:
        boolean r1 = true;
    L9:
        int r4 = this.s;
        if (r4 != (-1)) goto L13;
    L11:
        boolean r6 = true;
    L16:
        if (r1 == false) goto L20;
        if (r6 == true) goto L19;
        return false;
    L19:
        return true;
    L20:
        return false;
    L13:
        if (r5.getTag(r4) == null) goto L11;
        r6 = false;
        goto L16
    L6:
        if (r5.getTag(r0) != null) goto L4;
        r1 = false;
        goto L9
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
