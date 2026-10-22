package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
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
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public class MotionScene {
    private static final String TAG = "MotionScene";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.obric.oui.constraintlayout.widget.f f34846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Transition f34847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final r f34848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f34849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f34850e;
    private final MotionLayout f;
    private boolean g;
    private ArrayList<Transition> h;
    private Transition i;
    private ArrayList<Transition> j;
    private SparseArray<com.obric.oui.constraintlayout.widget.c> k;
    private HashMap<String, Integer> l;
    private SparseIntArray m;
    private int n;
    private int o;
    private MotionEvent p;
    private boolean q;
    private boolean r;
    private MotionLayout.c s;
    private boolean t;

    public static class Transition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f34851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f34852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f34853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f34854d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f34855e;
        private String f;
        private int g;
        private int h;
        private float i;
        private final MotionScene j;
        private ArrayList<g> k;
        private p l;
        private ArrayList<TransitionOnClick> m;
        private int n;
        private boolean o;
        private int p;
        private int q;
        private int r;

        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public static /* synthetic */ int access$000(String r0, String r1) {
                return Log.e(r0, r1);
            }

            public TransitionOnClick(Context r5, Transition r6, XmlPullParser r7) {
                Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
                XmlPullParser r9 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r7, XmlPullParser.class, "com.obric.aiagent.plugin");
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = r6;
                TypedArray r10 = r8.obtainStyledAttributes(Xml.asAttributeSet(r9), R.styleable.OnClick);
                int r11 = r10.getIndexCount();
                int r12 = 0;
            L3:
                if (r12 >= r11) goto L11;
                int r0 = r10.getIndex(r12);
                if (r0 != ZeusTransformUtils.mapRes(R.styleable.OnClick_targetId, "styleable", "OnClick_targetId")) goto L8;
                this.mTargetId = r10.getResourceId(r0, this.mTargetId);
            L10:
                r12 = r12 + 1;
                goto L3
            L8:
                if (r0 != ZeusTransformUtils.mapRes(R.styleable.OnClick_clickAction, "styleable", "OnClick_clickAction")) goto L10;
                this.mMode = r10.getInt(r0, this.mMode);
                goto L10
            L11:
                r10.recycle();
            }

            public TransitionOnClick(Transition r2, int r3, int r4) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = r2;
                this.mTargetId = r3;
                this.mMode = r4;
            }

            public void addOnClickListeners(MotionLayout r7, int r8, Transition r9) {
                int r0 = this.mTargetId;
                MotionLayout r10 = r7;
                if (r0 == (-1)) goto L6;
                r10 = r7.findViewById(r0);
            L6:
                if (r10 != null) goto L9;
                INVOKESTATIC_com_obric_oui_constraintlayout_motion_widget_MotionScene$Transition$TransitionOnClick_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(MotionScene.TAG, "OnClick could not find id " + this.mTargetId);
                return;
            L9:
                int r1 = Transition.b(r9);
                int r11 = Transition.a(r9);
                if (r1 != (-1)) goto L13;
                r10.setOnClickListener(this);
                return;
            L13:
                int r2 = this.mMode;
                boolean r3 = false;
                if ((r2 & 1) == 0) goto L17;
                if (r8 != r1) goto L17;
                boolean r4 = true;
            L19:
                if ((r2 & 256) == 0) goto L22;
                if (r8 != r1) goto L22;
                boolean r5 = true;
            L23:
                boolean r6 = r4 | r5;
                if ((r2 & 1) == 0) goto L27;
                if (r8 != r1) goto L27;
                boolean r12 = true;
            L28:
                boolean r13 = r12 | r6;
                if ((r2 & 16) == 0) goto L32;
                if (r8 != r11) goto L32;
                boolean r14 = true;
            L33:
                boolean r15 = r13 | r14;
                if ((r2 & 4096) == 0) goto L38;
                if (r8 != r11) goto L38;
                r3 = true;
            L38:
                if ((r15 | r3) == false) goto L41;
                r10.setOnClickListener(this);
                return;
            L41:
                return;
            L32:
                r14 = false;
            L27:
                r12 = false;
            L22:
                r5 = false;
            L17:
                r4 = false;
                goto L19
            }

            public void removeOnClickListeners(MotionLayout r3) {
                int r0 = this.mTargetId;
                if (r0 != (-1)) goto L5;
                return;
            L5:
                View r4 = r3.findViewById(r0);
                if (r4 != null) goto L9;
                INVOKESTATIC_com_obric_oui_constraintlayout_motion_widget_MotionScene$Transition$TransitionOnClick_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(MotionScene.TAG, " (*)  could not find id " + this.mTargetId);
                return;
            L9:
                r4.setOnClickListener(null);
            }

            boolean isTransitionViable(Transition r4, MotionLayout r5) {
                Transition r0 = this.mTransition;
                if (r0 != r4) goto L5;
                return true;
            L5:
                int r6 = Transition.a(r0);
                int r3 = Transition.b(this.mTransition);
                if (r3 != (-1)) goto L13;
                if (r5.mCurrentState == r6) goto L11;
                return true;
            L11:
                return false;
            L13:
                if (r5.mCurrentState != r3) goto L15;
                return true;
            L15:
                if (r5.mCurrentState != r6) goto L18;
                return true;
            L18:
                return false;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View r8) {
                MotionLayout r9 = MotionScene.a(Transition.h(this.mTransition));
                if (r9.isInteractionEnabled() == true) goto L6;
                return;
            L6:
                if (Transition.b(this.mTransition) != (-1)) goto L13;
                int r0 = r9.getCurrentState();
                if (r0 != (-1)) goto L11;
                r9.transitionToState(Transition.a(this.mTransition));
                return;
            L11:
                Transition r1 = new Transition(Transition.h(this.mTransition), this.mTransition);
                Transition.a(r1, r0);
                Transition.b(r1, Transition.a(this.mTransition));
                r9.setTransition(r1);
                r9.transitionToEnd();
                return;
            L13:
                Transition r2 = Transition.h(this.mTransition).f34847b;
                int r3 = this.mMode;
                boolean r4 = false;
                if ((r3 & 1) == 0) goto L16;
            L19:
                boolean r5 = true;
            L21:
                if ((r3 & 16) == 0) goto L23;
            L26:
                boolean r6 = true;
            L27:
                if (r5 == false) goto L30;
                if (r6 == false) goto L30;
                boolean r7 = true;
            L31:
                if (r7 == false) goto L41;
                Transition r10 = Transition.h(this.mTransition).f34847b;
                Transition r11 = this.mTransition;
                if (r10 == r11) goto L36;
                r9.setTransition(r11);
            L36:
                if (r9.getCurrentState() == r9.getEndState()) goto L43;
                if (r9.getProgress() > 0.5f) goto L43;
                r6 = false;
            L43:
                if (isTransitionViable(r2, r9) == false) goto L61;
                if (r4 == true) goto L46;
            L48:
                if (r6 == true) goto L50;
            L52:
                if (r4 == true) goto L54;
            L56:
                if (r6 == true) goto L58;
                return;
            L58:
                if ((this.mMode & 4096) == 0) goto L66;
                r9.setTransition(this.mTransition);
                r9.setProgress(0.0f);
                return;
            L66:
                return;
            L54:
                if ((this.mMode & 256) == 0) goto L56;
                r9.setTransition(this.mTransition);
                r9.setProgress(1.0f);
                return;
            L50:
                if ((this.mMode & 16) == 0) goto L52;
                r9.setTransition(this.mTransition);
                r9.transitionToStart();
                return;
            L46:
                if ((this.mMode & 1) == 0) goto L48;
                r9.setTransition(this.mTransition);
                r9.transitionToEnd();
                return;
            L61:
                return;
            L41:
                r4 = r5;
            L30:
                r7 = false;
                goto L31
            L23:
                if ((r3 & 4096) != 0) goto L26;
                r6 = false;
                goto L27
            L16:
                if ((r3 & 256) != 0) goto L19;
                r5 = false;
                goto L21
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int INVOKESTATIC_com_obric_oui_constraintlayout_motion_widget_MotionScene$Transition$TransitionOnClick_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
                return Log.e(r0, r1);
            }
        }

        static /* synthetic */ int a(Transition r0) {
            return r0.f34853c;
        }

        static /* synthetic */ int a(Transition r0, int r1) {
            r0.f34854d = r1;
            return r1;
        }

        static /* synthetic */ p a(Transition r0, p r1) {
            r0.l = r1;
            return r1;
        }

        static /* synthetic */ int b(Transition r0) {
            return r0.f34854d;
        }

        static /* synthetic */ int b(Transition r0, int r1) {
            r0.f34853c = r1;
            return r1;
        }

        static /* synthetic */ p c(Transition r0) {
            return r0.l;
        }

        static /* synthetic */ int d(Transition r0) {
            return r0.f34851a;
        }

        static /* synthetic */ ArrayList e(Transition r0) {
            return r0.m;
        }

        static /* synthetic */ boolean f(Transition r0) {
            return r0.o;
        }

        static /* synthetic */ int g(Transition r0) {
            return r0.n;
        }

        static /* synthetic */ MotionScene h(Transition r0) {
            return r0.j;
        }

        static /* synthetic */ boolean i(Transition r0) {
            return r0.f34852b;
        }

        static /* synthetic */ ArrayList j(Transition r0) {
            return r0.k;
        }

        static /* synthetic */ int k(Transition r0) {
            return r0.f34855e;
        }

        static /* synthetic */ String l(Transition r0) {
            return r0.f;
        }

        static /* synthetic */ int m(Transition r0) {
            return r0.g;
        }

        static /* synthetic */ int n(Transition r0) {
            return r0.h;
        }

        static /* synthetic */ int o(Transition r0) {
            return r0.p;
        }

        static /* synthetic */ float p(Transition r0) {
            return r0.i;
        }

        public int a() {
            return this.q;
        }

        public void a(Context r3, XmlPullParser r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.m.add(new TransitionOnClick(r5, this, r6));
        }

        public int b() {
            return this.n;
        }

        public int c() {
            return this.f34853c;
        }

        public int d() {
            return this.f34854d;
        }

        public void a(int r2) {
            this.h = Math.max(r2, 8);
        }

        public void a(g r1) {
            this.k.add(r1);
        }

        public p e() {
            return this.l;
        }

        public void b(int r1) {
            this.p = r1;
        }

        public boolean f() {
            return !this.o;
        }

        public void a(boolean r1) {
            this.o = !r1;
        }

        public boolean c(int r1) {
            if ((this.r & r1) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void d(int r1) {
            p r0 = e();
            if (r0 == null) goto L6;
            r0.a(r1);
            return;
        }

        Transition(MotionScene r5, Transition r6) {
            this.f34851a = -1;
            this.f34852b = false;
            this.f34853c = -1;
            this.f34854d = -1;
            this.f34855e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList();
            this.l = null;
            this.m = new ArrayList();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.j = r5;
            this.h = MotionScene.b(r5);
            if (r6 == null) goto L6;
            this.p = r6.p;
            this.f34855e = r6.f34855e;
            this.f = r6.f;
            this.g = r6.g;
            this.h = r6.h;
            this.k = r6.k;
            this.i = r6.i;
            this.q = r6.q;
            return;
        }

        public Transition(int r5, MotionScene r6, int r7, int r8) {
            this.f34851a = -1;
            this.f34852b = false;
            this.f34853c = -1;
            this.f34854d = -1;
            this.f34855e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList();
            this.l = null;
            this.m = new ArrayList();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.f34851a = r5;
            this.j = r6;
            this.f34854d = r7;
            this.f34853c = r8;
            this.h = MotionScene.b(r6);
            this.q = MotionScene.c(r6);
        }

        Transition(MotionScene r5, Context r6, XmlPullParser r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r9 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r7, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.f34851a = -1;
            this.f34852b = false;
            this.f34853c = -1;
            this.f34854d = -1;
            this.f34855e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList();
            this.l = null;
            this.m = new ArrayList();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.h = MotionScene.b(r5);
            this.q = MotionScene.c(r5);
            this.j = r5;
            a(r5, r8, Xml.asAttributeSet(r9));
        }

        public void a(int r1, String r2, int r3) {
            this.f34855e = r1;
            this.f = r2;
            this.g = r3;
        }

        private void a(MotionScene r3, Context r4, AttributeSet r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            TypedArray r7 = r6.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.Transition);
            a(r3, r6, r7);
            r7.recycle();
        }

        private void a(MotionScene r13, Context r14, TypedArray r15) {
            Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
            int r0 = r15.getIndexCount();
            int r3 = 0;
        L4:
            if (r3 >= r0) goto L65;
            int r6 = r15.getIndex(r3);
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_constraintSetEnd, "styleable", "Transition_constraintSetEnd")) goto L14;
            this.f34853c = r15.getResourceId(r6, -1);
            String r4 = ZeusTransformUtils.getResources(r16, "com.obric.aiagent.plugin").getResourceTypeName(this.f34853c);
            if ("layout".equals(r4) == false) goto L11;
            com.obric.oui.constraintlayout.widget.c r5 = new com.obric.oui.constraintlayout.widget.c();
            r5.b(r16, this.f34853c);
            MotionScene.d(r13).append(this.f34853c, r5);
        L63:
            r3 = r3 + 1;
            goto L4
        L11:
            if ("xml".equals(r4) == false) goto L63;
            this.f34853c = MotionScene.a(r13, r16, this.f34853c);
            goto L63
        L14:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_constraintSetStart, "styleable", "Transition_constraintSetStart")) goto L22;
            this.f34854d = r15.getResourceId(r6, this.f34854d);
            String r7 = ZeusTransformUtils.getResources(r16, "com.obric.aiagent.plugin").getResourceTypeName(this.f34854d);
            if ("layout".equals(r7) == false) goto L19;
            com.obric.oui.constraintlayout.widget.c r8 = new com.obric.oui.constraintlayout.widget.c();
            r8.b(r16, this.f34854d);
            MotionScene.d(r13).append(this.f34854d, r8);
            goto L63
        L19:
            if ("xml".equals(r7) == false) goto L63;
            this.f34854d = MotionScene.a(r13, r16, this.f34854d);
            goto L63
        L22:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_motionInterpolator, "styleable", "Transition_motionInterpolator")) goto L38;
            TypedValue r9 = r15.peekValue(r6);
            if (r9.type != 1) goto L29;
            int r10 = r15.getResourceId(r6, -1);
            this.g = r10;
            if (r10 == (-1)) goto L63;
            this.f34855e = -2;
            goto L63
        L29:
            if (r9.type != 3) goto L36;
            String r11 = r15.getString(r6);
            this.f = r11;
            if (r11 == null) goto L63;
            if (r11.indexOf("/") <= 0) goto L35;
            this.g = r15.getResourceId(r6, -1);
            this.f34855e = -2;
            goto L63
        L35:
            this.f34855e = -1;
            goto L63
        L36:
            this.f34855e = r15.getInteger(r6, this.f34855e);
            goto L63
        L38:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_duration, "styleable", "Transition_duration")) goto L43;
            int r12 = r15.getInt(r6, this.h);
            this.h = r12;
            if (r12 >= 8) goto L63;
            this.h = 8;
            goto L63
        L43:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_staggered, "styleable", "Transition_staggered")) goto L46;
            this.i = r15.getFloat(r6, this.i);
            goto L63
        L46:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_autoTransition, "styleable", "Transition_autoTransition")) goto L49;
            this.n = r15.getInteger(r6, this.n);
            goto L63
        L49:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_android_id, "styleable", "Transition_android_id")) goto L52;
            this.f34851a = r15.getResourceId(r6, this.f34851a);
            goto L63
        L52:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_transitionDisable, "styleable", "Transition_transitionDisable")) goto L55;
            this.o = r15.getBoolean(r6, this.o);
            goto L63
        L55:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_pathMotionArc, "styleable", "Transition_pathMotionArc")) goto L58;
            this.p = r15.getInteger(r6, -1);
            goto L63
        L58:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_layoutDuringTransition, "styleable", "Transition_layoutDuringTransition")) goto L61;
            this.q = r15.getInteger(r6, 0);
            goto L63
        L61:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_transitionFlags, "styleable", "Transition_transitionFlags")) goto L63;
            this.r = r15.getInteger(r6, 0);
            goto L63
        L65:
            if (this.f34854d != (-1)) goto L91;
            this.f34852b = true;
            return;
        }
    }

    static /* synthetic */ int a(MotionScene r2, Context r3, int r4) {
        return r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    static /* synthetic */ MotionLayout a(MotionScene r0) {
        return r0.f;
    }

    static /* synthetic */ int b(MotionScene r0) {
        return r0.n;
    }

    static /* synthetic */ int c(MotionScene r0) {
        return r0.o;
    }

    static /* synthetic */ SparseArray d(MotionScene r0) {
        return r0.k;
    }

    void a(int r8, int r9) {
        com.obric.oui.constraintlayout.widget.f r0 = this.f34846a;
        if (r0 == null) goto L11;
        int r1 = r0.a(r8, -1, -1);
        if (r1 != (-1)) goto L8;
        r1 = r8;
    L8:
        int r2 = this.f34846a.a(r9, -1, -1);
        if (r2 != (-1)) goto L13;
    L12:
        r2 = r9;
    L13:
        Transition r3 = this.f34847b;
        if (r3 != null) goto L16;
    L20:
        Iterator<Transition> r4 = this.h.iterator();
    L22:
        if (r4.hasNext() == false) goto L37;
        Transition r5 = (Transition) ZeusTransformUtils.preCheckCast(r4.next(), Transition.class, "com.obric.aiagent.plugin");
        if (Transition.a(r5) != r2) goto L28;
        if (Transition.b(r5) != r1) goto L28;
    L31:
        this.f34847b = r5;
        if (r5 != null) goto L34;
        return;
    L34:
        if (Transition.c(r5) == null) goto L61;
        Transition.c(this.f34847b).a(this.t);
        return;
    L61:
        return;
    L28:
        if (Transition.a(r5) != r9) goto L22;
        if (Transition.b(r5) != r8) goto L22;
    L37:
        Transition r10 = this.i;
        Iterator<Transition> r6 = this.j.iterator();
    L39:
        if (r6.hasNext() == false) goto L43;
        Transition r7 = (Transition) ZeusTransformUtils.preCheckCast(r6.next(), Transition.class, "com.obric.aiagent.plugin");
        if (Transition.a(r7) != r9) goto L39;
        r10 = r7;
        goto L39
    L43:
        Transition r11 = new Transition(this, r10);
        Transition.a(r11, r1);
        Transition.b(r11, r2);
        if (r1 == (-1)) goto L46;
        this.h.add(r11);
    L46:
        this.f34847b = r11;
        return;
    L16:
        if (Transition.a(r3) != r9) goto L20;
        if (Transition.b(this.f34847b) != r8) goto L20;
        return;
    L11:
        r1 = r8;
        goto L12
    }

    public void a(Transition r1) {
        this.f34847b = r1;
        if (r1 != null) goto L5;
        return;
    L5:
        if (Transition.c(r1) == null) goto L9;
        Transition.c(this.f34847b).a(this.t);
        return;
    }

    private int g(int r2) {
        com.obric.oui.constraintlayout.widget.f r1 = this.f34846a;
        if (r1 == null) goto L7;
        int r3 = r1.a(r2, -1, -1);
        if (r3 == (-1)) goto L7;
        return r3;
    L7:
        return r2;
    }

    public List<Transition> a(int r5) {
        int r6 = g(r5);
        ArrayList r0 = new ArrayList();
        Iterator<Transition> r4 = this.h.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Transition r1 = (Transition) ZeusTransformUtils.preCheckCast(r4.next(), Transition.class, "com.obric.aiagent.plugin");
        if (Transition.b(r1) == r6) goto L9;
        if (Transition.a(r1) != r6) goto L4;
    L9:
        r0.add(r1);
        goto L4
    L10:
        return r0;
    }

    public void a(MotionLayout r7, int r8) {
        Iterator<Transition> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Transition r1 = (Transition) ZeusTransformUtils.preCheckCast(r0.next(), Transition.class, "com.obric.aiagent.plugin");
        if (Transition.e(r1).size() <= 0) goto L4;
        Iterator r2 = Transition.e(r1).iterator();
    L9:
        if (r2.hasNext() == false) goto L4;
        ((Transition.TransitionOnClick) ZeusTransformUtils.preCheckCast(r2.next(), Transition.TransitionOnClick.class, "com.obric.aiagent.plugin")).removeOnClickListeners(r7);
        goto L9
    L11:
        Iterator<Transition> r3 = this.j.iterator();
    L13:
        if (r3.hasNext() == false) goto L20;
        Transition r4 = (Transition) ZeusTransformUtils.preCheckCast(r3.next(), Transition.class, "com.obric.aiagent.plugin");
        if (Transition.e(r4).size() <= 0) goto L13;
        Iterator r5 = Transition.e(r4).iterator();
    L18:
        if (r5.hasNext() == false) goto L13;
        ((Transition.TransitionOnClick) ZeusTransformUtils.preCheckCast(r5.next(), Transition.TransitionOnClick.class, "com.obric.aiagent.plugin")).removeOnClickListeners(r7);
        goto L18
    L20:
        Iterator<Transition> r6 = this.h.iterator();
    L22:
        if (r6.hasNext() == false) goto L29;
        Transition r9 = (Transition) ZeusTransformUtils.preCheckCast(r6.next(), Transition.class, "com.obric.aiagent.plugin");
        if (Transition.e(r9).size() <= 0) goto L22;
        Iterator r10 = Transition.e(r9).iterator();
    L27:
        if (r10.hasNext() == false) goto L22;
        ((Transition.TransitionOnClick) ZeusTransformUtils.preCheckCast(r10.next(), Transition.TransitionOnClick.class, "com.obric.aiagent.plugin")).addOnClickListeners(r7, r8, r9);
        goto L27
    L29:
        Iterator<Transition> r11 = this.j.iterator();
    L31:
        if (r11.hasNext() == false) goto L38;
        Transition r12 = (Transition) ZeusTransformUtils.preCheckCast(r11.next(), Transition.class, "com.obric.aiagent.plugin");
        if (Transition.e(r12).size() <= 0) goto L31;
        Iterator r13 = Transition.e(r12).iterator();
    L36:
        if (r13.hasNext() == false) goto L31;
        ((Transition.TransitionOnClick) ZeusTransformUtils.preCheckCast(r13.next(), Transition.TransitionOnClick.class, "com.obric.aiagent.plugin")).addOnClickListeners(r7, r8, r12);
        goto L36
    }

    public Transition a(int r17, float r18, float r19, MotionEvent r20) {
        if (r17 == (-1)) goto L37;
        List<Transition> r4 = a(r17);
        float r5 = 0.0f;
        Transition r6 = null;
        RectF r7 = new RectF();
        Iterator<Transition> r8 = r4.iterator();
    L6:
        if (r8.hasNext() == false) goto L35;
        Transition r9 = (Transition) ZeusTransformUtils.preCheckCast(r8.next(), Transition.class, "com.obric.aiagent.plugin");
        if (Transition.f(r9) == true) goto L6;
        if (Transition.c(r9) == null) goto L6;
        Transition.c(r9).a(this.t);
        RectF r10 = Transition.c(r9).a(this.f, r7);
        if (r10 == null) goto L18;
        if (r20 == null) goto L18;
        if (r10.contains(r20.getX(), r20.getY()) == false) goto L6;
    L18:
        RectF r11 = Transition.c(r9).b(this.f, r7);
        if (r11 == null) goto L24;
        if (r20 == null) goto L24;
        if (r11.contains(r20.getX(), r20.getY()) == false) goto L6;
    L24:
        float r12 = Transition.c(r9).f(r18, r19);
        if (Transition.c(r9).f34891c == false) goto L29;
        if (r20 == null) goto L29;
        float r13 = r20.getX() - Transition.c(r9).f34889a;
        float r14 = r20.getY() - Transition.c(r9).f34890b;
        r12 = ((float) (Math.atan2(r19 + r14, r18 + r13) - Math.atan2(r13, r14))) * 10.0f;
    L29:
        if (Transition.a(r9) != r17) goto L31;
        float r15 = -1.0f;
    L32:
        float r16 = r12 * r15;
        if (r16 <= r5) goto L6;
        r6 = r9;
        r5 = r16;
        goto L6
    L31:
        r15 = 1.1f;
        goto L32
    L35:
        return r6;
    L37:
        return this.f34847b;
    }

    public ArrayList<Transition> a() {
        return this.h;
    }

    public Transition b(int r4) {
        Iterator<Transition> r3 = this.h.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Transition r0 = (Transition) ZeusTransformUtils.preCheckCast(r3.next(), Transition.class, "com.obric.aiagent.plugin");
        if (Transition.d(r0) != r4) goto L4;
        return r0;
    L8:
        return null;
    }

    public int[] b() {
        int r0 = this.k.size();
        int[] r1 = new int[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.k.keyAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public int[] a(String... r8) {
        int r0 = this.k.size();
        int[] r1 = new int[r0];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L9;
        com.obric.oui.constraintlayout.widget.c r4 = (com.obric.oui.constraintlayout.widget.c) ZeusTransformUtils.preCheckCast(this.k.valueAt(r2), com.obric.oui.constraintlayout.widget.c.class, "com.obric.aiagent.plugin");
        int r5 = this.k.keyAt(r2);
        if (r4.a(r8) == false) goto L7;
        r4.a();
        r1[r3] = r5;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        return Arrays.copyOf(r1, r3);
    }

    boolean b(MotionLayout r8, int r9) {
        if (t() == false) goto L6;
        return false;
    L6:
        if (this.g == false) goto L8;
        return false;
    L8:
        Iterator<Transition> r0 = this.h.iterator();
    L10:
        if (r0.hasNext() == false) goto L41;
        Transition r2 = (Transition) ZeusTransformUtils.preCheckCast(r0.next(), Transition.class, "com.obric.aiagent.plugin");
        if (Transition.g(r2) == 0) goto L10;
        Transition r3 = this.f34847b;
        if (r3 != r2) goto L20;
        if (r3.c(2) == true) goto L10;
    L20:
        if (r9 != Transition.b(r2)) goto L31;
        if (Transition.g(r2) == 4) goto L25;
        if (Transition.g(r2) != 2) goto L31;
    L25:
        r8.setState(MotionLayout.g.f34844d);
        r8.setTransition(r2);
        if (Transition.g(r2) != 4) goto L28;
        r8.transitionToEnd();
        r8.setState(MotionLayout.g.f34842b);
        r8.setState(MotionLayout.g.f34843c);
    L29:
        return true;
    L28:
        r8.setProgress(1.0f);
        r8.evaluate(true);
        r8.setState(MotionLayout.g.f34842b);
        r8.setState(MotionLayout.g.f34843c);
        r8.setState(MotionLayout.g.f34844d);
        r8.onNewStateAttachHandlers();
    L31:
        if (r9 != Transition.a(r2)) goto L10;
        if (Transition.g(r2) == 3) goto L36;
        if (Transition.g(r2) != 1) goto L10;
    L36:
        r8.setState(MotionLayout.g.f34844d);
        r8.setTransition(r2);
        if (Transition.g(r2) != 3) goto L39;
        r8.transitionToStart();
        r8.setState(MotionLayout.g.f34842b);
        r8.setState(MotionLayout.g.f34843c);
    L40:
        return true;
    L39:
        r8.setProgress(0.0f);
        r8.evaluate(true);
        r8.setState(MotionLayout.g.f34842b);
        r8.setState(MotionLayout.g.f34843c);
        r8.setState(MotionLayout.g.f34844d);
        r8.onNewStateAttachHandlers();
        goto L40
    L41:
        return false;
    }

    private boolean t() {
        if (this.s == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void a(boolean r1) {
        this.t = r1;
        Transition r2 = this.f34847b;
        if (r2 != null) goto L5;
        return;
    L5:
        if (Transition.c(r2) == null) goto L9;
        Transition.c(this.f34847b).a(this.t);
        return;
    }

    public void a(int r1, View... r2) {
        this.f34848c.a(r1, r2);
    }

    public void a(int r1, boolean r2) {
        this.f34848c.a(r1, r2);
    }

    public boolean c(int r1) {
        return this.f34848c.a(r1);
    }

    public boolean a(int r1, m r2) {
        return this.f34848c.a(r1, r2);
    }

    MotionScene(Context r4, MotionLayout r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f34846a = null;
        this.f34847b = null;
        this.g = false;
        this.h = new ArrayList();
        this.i = null;
        this.j = new ArrayList();
        this.k = new SparseArray();
        this.l = new HashMap();
        this.m = new SparseIntArray();
        this.n = 400;
        this.o = 0;
        this.q = false;
        this.r = false;
        this.f = r5;
        this.f34848c = new r(r5);
        a(r7, r6);
        this.k.put(ZeusTransformUtils.mapRes(R.id.motion_base, DbHelper.COL_ID, "motion_base"), new com.obric.oui.constraintlayout.widget.c());
        this.l.put("motion_base", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.motion_base, DbHelper.COL_ID, "motion_base")));
    }

    private void a(Context r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        XmlResourceParser r2 = ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getXml(r12);
        Transition r4 = null;
        int r5 = r2.getEventType();     // Catch: IOException -> L78 XmlPullParserException -> L80
    L4:
        byte r6 = 1;
        if (r5 == 1) goto L103;
        if (r5 != 2) goto L76;
        String r7 = r2.getName();     // Catch: IOException -> L78 XmlPullParserException -> L80
        switch(r7.hashCode()) {
            case -1349929691: goto L40;
            case -1239391468: goto L37;
            case -687739768: goto L34;
            case 61998586: goto L31;
            case 269306229: goto L28;
            case 312750793: goto L25;
            case 327855227: goto L22;
            case 793277014: goto L19;
            case 1382829617: goto L16;
            case 1942574248: goto L13;
            default: goto L42;
        };     // Catch: IOException -> L78 XmlPullParserException -> L80
    L42:
        r6 = -1;
    L43:
        switch(r6) {
            case 0: goto L75;
            case 1: goto L60;
            case 2: goto L56;
            case 3: goto L52;
            case 4: goto L51;
            case 5: goto L50;
            case 6: goto L49;
            case 7: goto L49;
            case 8: goto L46;
            case 9: goto L45;
            default: goto L76;
        };     // Catch: IOException -> L78 XmlPullParserException -> L80
    L45:
        this.f34848c.a(new q(r13, r2));     // Catch: IOException -> L78 XmlPullParserException -> L80
        goto L76
    L46:
        g r8 = new g(r13, r2);     // Catch: IOException -> L78 XmlPullParserException -> L80
        if (r4 == null) goto L76;
        Transition.j(r4).add(r8);     // Catch: IOException -> L78 XmlPullParserException -> L80
        goto L76
    L49:
        b(r13, r2);     // Catch: IOException -> L78 XmlPullParserException -> L80
        goto L76
    L50:
        c(r13, r2);     // Catch: IOException -> L78 XmlPullParserException -> L80
        goto L76
    L51:
        this.f34846a = new com.obric.oui.constraintlayout.widget.f(r13, r2);     // Catch: IOException -> L78 XmlPullParserException -> L80
        goto L76
    L52:
        if (r4 == null) goto L76;
        if (this.f.isInEditMode() == true) goto L76;
        r4.a(r13, r2);     // Catch: IOException -> L78 XmlPullParserException -> L80
        goto L76
    L56:
        if (r4 != null) goto L58;
        a(TAG, " OnSwipe (" + ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getResourceEntryName(r12) + ".xml:" + r2.getLineNumber() + ")");     // Catch: IOException -> L78 XmlPullParserException -> L80
    L58:
        if (r4 == null) goto L76;
        Transition.a(r4, new p(r13, this.f, r2));     // Catch: IOException -> L78 XmlPullParserException -> L80
        goto L76
    L60:
        ArrayList<Transition> r9 = this.h;     // Catch: IOException -> L78 XmlPullParserException -> L80
        Transition r10 = new Transition(this, r13, r2);     // Catch: IOException -> L78 XmlPullParserException -> L80
        r9.add(r10);     // Catch: IOException -> L78 XmlPullParserException -> L80
        if (this.f34847b != null) goto L68;
        if (Transition.i(r10) == true) goto L68;
        this.f34847b = r10;     // Catch: IOException -> L78 XmlPullParserException -> L80
        if (Transition.c(r10) == null) goto L68;
        Transition.c(this.f34847b).a(this.t);     // Catch: IOException -> L78 XmlPullParserException -> L80
    L68:
        if (Transition.i(r10) == true) goto L70;
    L74:
        r4 = r10;
        goto L76
    L70:
        if (Transition.a(r10) != (-1)) goto L72;
        this.i = r10;     // Catch: IOException -> L78 XmlPullParserException -> L80
    L73:
        this.h.remove(r10);     // Catch: IOException -> L78 XmlPullParserException -> L80
        goto L74
    L72:
        this.j.add(r10);     // Catch: IOException -> L78 XmlPullParserException -> L80
        goto L73
    L75:
        a(r13, r2);     // Catch: IOException -> L78 XmlPullParserException -> L80
        goto L76
    L13:
        if (r7.equals("include") == false) goto L42;
        r6 = 6;
        goto L43
    L16:
        if (r7.equals("StateSet") == false) goto L42;
        r6 = 4;
        goto L43
    L19:
        if (r7.equals(TAG) == false) goto L42;
        r6 = 0;
        goto L43
    L22:
        if (r7.equals("OnSwipe") == false) goto L42;
        r6 = 2;
        goto L43
    L25:
        if (r7.equals("OnClick") == false) goto L42;
        r6 = 3;
        goto L43
    L28:
        if (r7.equals("Transition") == false) goto L42;
    L31:
        if (r7.equals("ViewTransition") == false) goto L42;
        r6 = 9;
        goto L43
    L34:
        if (r7.equals("Include") == false) goto L42;
        r6 = 7;
        goto L43
    L37:
        if (r7.equals("KeyFrameSet") == false) goto L42;
        r6 = 8;
        goto L43
    L40:
        if (r7.equals("ConstraintSet") == false) goto L42;
        r6 = 5;
    L76:
        r5 = r2.next();     // Catch: IOException -> L78 XmlPullParserException -> L80
    L103:
        return;
    L78:
        e = move-exception;
        a(TAG, "Error parsing resource: " + r12, e);
        return;
    L80:
        e = move-exception;
        a(TAG, "Error parsing resource: " + r12, e);
    }

    private void a(Context r7, XmlPullParser r8) {
        TypedArray r9 = ((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r8, XmlPullParser.class, "com.obric.aiagent.plugin")), R.styleable.MotionScene);
        int r10 = r9.getIndexCount();
        int r1 = 0;
    L3:
        if (r1 >= r10) goto L13;
        int r2 = r9.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionScene_defaultDuration, "styleable", "MotionScene_defaultDuration")) goto L10;
        int r3 = r9.getInt(r2, this.n);
        this.n = r3;
        if (r3 >= 8) goto L12;
        this.n = 8;
    L12:
        r1 = r1 + 1;
        goto L3
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionScene_layoutDuringTransition, "styleable", "MotionScene_layoutDuringTransition")) goto L12;
        this.o = r9.getInteger(r2, 0);
        goto L12
    L13:
        r9.recycle();
    }

    private int a(Context r6, String r7) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (r7.contains("/") == false) goto L5;
        int r8 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin"), r7.substring(r7.indexOf(47) + 1), DbHelper.COL_ID, r5.getPackageName(), "com.obric.aiagent.plugin");
    L6:
        if (r8 != (-1)) goto L13;
        if (r7 != null) goto L9;
    L11:
        b(TAG, "error in parsing id");
        return r8;
    L9:
        if (r7.length() <= 1) goto L11;
        return Integer.parseInt(r7.substring(1));
    L13:
        return r8;
    L5:
        r8 = -1;
        goto L6
    }

    private void b(Context r7, XmlPullParser r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        TypedArray r10 = r9.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r8, XmlPullParser.class, "com.obric.aiagent.plugin")), R.styleable.include);
        int r0 = r10.getIndexCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r10.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.include_constraintSet, "styleable", "include_constraintSet")) goto L7;
        b(r9, r10.getResourceId(r2, -1));
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        r10.recycle();
    }

    private int b(Context r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        XmlResourceParser r2 = ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin").getXml(r8);
        int r3 = r2.getEventType();     // Catch: IOException -> L14 XmlPullParserException -> L16
    L5:
        if (r3 == 1) goto L27;
        String r4 = r2.getName();     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (2 != r3) goto L12;
        if ("ConstraintSet".equals(r4) == false) goto L12;
        return c(r9, r2);
    L12:
        r3 = r2.next();     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L5
    L27:
        return -1;
    L14:
        e = move-exception;
        a(TAG, "Error parsing resource: " + r8, e);
        return -1;
    L16:
        e = move-exception;
        a(TAG, "Error parsing resource: " + r8, e);
        return -1;
    }

    private int c(Context r14, XmlPullParser r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r17 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r15, XmlPullParser.class, "com.obric.aiagent.plugin");
        com.obric.oui.constraintlayout.widget.c r0 = new com.obric.oui.constraintlayout.widget.c();
        r0.a(false);
        int r2 = r17.getAttributeCount();
        int r4 = 0;
        int r5 = -1;
        int r6 = -1;
    L4:
        if (r4 >= r2) goto L62;
        String r8 = r17.getAttributeName(r4);
        String r9 = r17.getAttributeValue(r4);
        r8.hashCode();
        switch(r8.hashCode()) {
            case -1496482599: goto L21;
            case -1153153640: goto L17;
            case 3355: goto L13;
            case 973381616: goto L9;
            default: goto L7;
        };
    L7:
        byte r10 = -1;
    L24:
        switch(r10) {
            case 0: goto L60;
            case 1: goto L71;
            case 2: goto L27;
            case 3: goto L26;
            default: goto L61;
        };
    L26:
        r0.a(r9);
        goto L61
    L27:
        r5 = a(r16, r9);
        this.l.put(a(r9), Integer.valueOf(r5));
        r0.f34952a = a.a(r16, r5);
        goto L61
    L60:
        r6 = a(r16, r9);
        goto L61
    L71:
        r0.f34954c = Integer.parseInt(r9);     // Catch: NumberFormatException -> L30
    L30:
        r9.hashCode();
        switch(r9.hashCode()) {
            case -768416914: goto L50;
            case 3317767: goto L46;
            case 3387192: goto L42;
            case 108511772: goto L38;
            case 1954540437: goto L34;
            default: goto L32;
        };
    L32:
        byte r11 = -1;
    L53:
        switch(r11) {
            case 0: goto L59;
            case 1: goto L58;
            case 2: goto L57;
            case 3: goto L56;
            case 4: goto L55;
            default: goto L61;
        };
    L55:
        r0.f34954c = 3;
        goto L61
    L56:
        r0.f34954c = 1;
        goto L61
    L57:
        r0.f34954c = 0;
        goto L61
    L58:
        r0.f34954c = 2;
        goto L61
    L59:
        r0.f34954c = 4;
        goto L61
    L34:
        if (r9.equals("x_right") == false) goto L89;
        r11 = 4;
        goto L53
    L89:
        r11 = -1;
        goto L53
    L38:
        if (r9.equals("right") == false) goto L90;
        r11 = 3;
        goto L53
    L90:
        r11 = -1;
        goto L53
    L42:
        if (r9.equals(OProtocolTextEffectTextView.EffectNameNone) == false) goto L91;
        r11 = 2;
        goto L53
    L91:
        r11 = -1;
        goto L53
    L46:
        if (r9.equals("left") == false) goto L92;
        r11 = 1;
        goto L53
    L92:
        r11 = -1;
        goto L53
    L50:
        if (r9.equals("x_left") == false) goto L93;
        r11 = 0;
        goto L53
    L93:
        r11 = -1;
    L61:
        r4 = r4 + 1;
        goto L4
    L9:
        if (r8.equals("stateLabels") == false) goto L85;
        r10 = 3;
        goto L24
    L85:
        r10 = -1;
        goto L24
    L13:
        if (r8.equals(DbHelper.COL_ID) == false) goto L86;
        r10 = 2;
        goto L24
    L86:
        r10 = -1;
        goto L24
    L17:
        if (r8.equals("constraintRotate") == false) goto L87;
        r10 = 1;
        goto L24
    L87:
        r10 = -1;
        goto L24
    L21:
        if (r8.equals("deriveConstraintsFrom") == false) goto L88;
        r10 = 0;
        goto L24
    L88:
        r10 = -1;
        goto L24
    L62:
        if (r5 != (-1)) goto L64;
    L70:
        return r5;
    L64:
        if (this.f.mDebugPath == 0) goto L66;
        r0.b(true);
    L66:
        r0.a(r16, r17);
        if (r6 == (-1)) goto L69;
        this.m.put(r5, r6);
    L69:
        this.k.put(r5, r0);
        goto L70
    }

    com.obric.oui.constraintlayout.widget.c d(int r2) {
        return a(r2, -1, -1);
    }

    com.obric.oui.constraintlayout.widget.c a(int r3, int r4, int r5) {
        com.obric.oui.constraintlayout.widget.f r0 = this.f34846a;
        if (r0 == null) goto L8;
        int r6 = r0.a(r3, r4, r5);
        if (r6 == (-1)) goto L8;
        r3 = r6;
    L8:
        if (this.k.get(r3) != null) goto L12;
        b(TAG, "Warning could not find ConstraintSet id/" + a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3) + " In MotionScene");
        SparseArray<com.obric.oui.constraintlayout.widget.c> r2 = this.k;
        return (com.obric.oui.constraintlayout.widget.c) ZeusTransformUtils.preCheckCast(r2.get(r2.keyAt(0)), com.obric.oui.constraintlayout.widget.c.class, "com.obric.aiagent.plugin");
    L12:
        return (com.obric.oui.constraintlayout.widget.c) ZeusTransformUtils.preCheckCast(this.k.get(r3), com.obric.oui.constraintlayout.widget.c.class, "com.obric.aiagent.plugin");
    }

    public void a(int r1, com.obric.oui.constraintlayout.widget.c r2) {
        this.k.put(r1, r2);
    }

    public void a(m r4) {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L11;
        Transition r3 = this.i;
        if (r3 == null) goto L10;
        Iterator r5 = Transition.j(r3).iterator();
    L8:
        if (r5.hasNext() == false) goto L18;
        ((g) ZeusTransformUtils.preCheckCast(r5.next(), g.class, "com.obric.aiagent.plugin")).b(r4);
        goto L8
    L18:
        return;
    L10:
        return;
    L11:
        Iterator r6 = Transition.j(r0).iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        ((g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.aiagent.plugin")).b(r4);
        goto L13
    }

    boolean c() {
        Iterator<Transition> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (Transition.c((Transition) ZeusTransformUtils.preCheckCast(r0.next(), Transition.class, "com.obric.aiagent.plugin")) == null) goto L4;
        return true;
    L8:
        Transition r5 = this.f34847b;
        if (r5 != null) goto L11;
    L13:
        return false;
    L11:
        if (Transition.c(r5) == null) goto L13;
        return true;
    }

    void a(MotionEvent r12, int r13, MotionLayout r14) {
        RectF r0 = new RectF();
        if (this.s != null) goto L5;
        this.s = this.f.obtainVelocityTracker();
    L5:
        this.s.a(r12);
        if (r13 == (-1)) goto L47;
        int r4 = r12.getAction();
        boolean r5 = false;
        if (r4 != 0) goto L10;
        this.f34849d = r12.getRawX();
        this.f34850e = r12.getRawY();
        this.p = r12;
        this.q = false;
        if (Transition.c(this.f34847b) == null) goto L65;
        RectF r15 = Transition.c(this.f34847b).b(this.f, r0);
        if (r15 != null) goto L35;
    L38:
        RectF r16 = Transition.c(this.f34847b).a(this.f, r0);
        if (r16 != null) goto L41;
    L43:
        this.r = false;
    L44:
        Transition.c(this.f34847b).b(this.f34849d, this.f34850e);
        return;
    L41:
        if (r16.contains(this.p.getX(), this.p.getY()) == true) goto L43;
        this.r = true;
        goto L44
    L35:
        if (r15.contains(this.p.getX(), this.p.getY()) == true) goto L38;
        this.p = null;
        this.q = true;
        return;
    L65:
        return;
    L10:
        if (r4 != 2) goto L47;
        if (this.q == true) goto L47;
        float r6 = r12.getRawY() - this.f34850e;
        float r7 = r12.getRawX() - this.f34849d;
        if (r7 == 0.0d) goto L18;
    L19:
        MotionEvent r8 = this.p;
        if (r8 == null) goto L64;
        Transition r9 = a(r13, r7, r6, r8);
        if (r9 == null) goto L47;
        r14.setTransition(r9);
        RectF r1 = Transition.c(this.f34847b).a(this.f, r0);
        if (r1 != null) goto L27;
    L29:
        this.r = r5;
        Transition.c(this.f34847b).a(this.f34849d, this.f34850e);
        goto L47
    L27:
        if (r1.contains(this.p.getX(), this.p.getY()) == true) goto L29;
        r5 = true;
        goto L29
    L64:
        return;
    L18:
        if (r6 != 0.0d) goto L19;
        return;
    L47:
        if (this.q == false) goto L49;
        return;
    L49:
        Transition r2 = this.f34847b;
        if (r2 != null) goto L52;
    L56:
        this.f34849d = r12.getRawX();
        this.f34850e = r12.getRawY();
        if (r12.getAction() != 1) goto L66;
        MotionLayout.c r17 = this.s;
        if (r17 == null) goto L67;
        r17.a();
        this.s = null;
        if (r14.mCurrentState == (-1)) goto L68;
        b(r14, r14.mCurrentState);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L52:
        if (Transition.c(r2) == null) goto L56;
        if (this.r == true) goto L56;
        Transition.c(this.f34847b).b(r12, this.s, r13, this);
        goto L56
    }

    void a(float r2, float r3) {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.c(r0) == null) goto L9;
        Transition.c(this.f34847b).e(r2, r3);
        return;
    }

    void b(float r2, float r3) {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.c(r0) == null) goto L9;
        Transition.c(this.f34847b).d(r2, r3);
        return;
    }

    float c(float r2, float r3) {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f34847b).c(r2, r3);
    }

    int d() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.b(r0);
    }

    int e() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.a(r0);
    }

    public Interpolator f() {
        int r0 = Transition.k(this.f34847b);
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
        final com.obric.oui.constraintlayout.a.a.a.c r1 = com.obric.oui.constraintlayout.a.a.a.c.a(Transition.l(this.f34847b));
        return new AnonymousClass1(this, r1);
    L34:
        return AnimationUtils.loadInterpolator((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Transition.m(this.f34847b));
    }

    public int g() {
        Transition r0 = this.f34847b;
        if (r0 == null) goto L7;
        return Transition.n(r0);
    L7:
        return this.n;
    }

    public void e(int r2) {
        Transition r0 = this.f34847b;
        if (r0 == null) goto L5;
        r0.a(r2);
        return;
    L5:
        this.n = r2;
    }

    public int h() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.o(r0);
    }

    public float i() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        return Transition.p(r0);
    }

    float j() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f34847b).b();
    }

    float k() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f34847b).c();
    }

    float l() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f34847b).h();
    }

    float m() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f34847b).i();
    }

    float n() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f34847b).j();
    }

    float o() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f34847b).k();
    }

    int p() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0;
    L7:
        return Transition.c(this.f34847b).l();
    }

    int q() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0;
    L7:
        return Transition.c(this.f34847b).e();
    }

    void r() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.c(r0) == null) goto L9;
        Transition.c(this.f34847b).a();
        return;
    }

    boolean s() {
        Transition r0 = this.f34847b;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return false;
    L7:
        return Transition.c(this.f34847b).d();
    }

    void a(MotionLayout r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.k.size()) goto L10;
        int r1 = this.k.keyAt(r0);
        if (h(r1) == true) goto L7;
        a(r1, r4);
        r0 = r0 + 1;
        goto L4
    L7:
        b(TAG, "Cannot be derived from yourself");
        return;
    }

    private boolean h(int r5) {
        int r0 = this.m.get(r5);
        int r1 = this.m.size();
    L3:
        if (r0 <= 0) goto L11;
        if (r0 == r5) goto L6;
        int r3 = r1 - 1;
        if (r1 < 0) goto L9;
        r0 = this.m.get(r0);
        r1 = r3;
        goto L3
    L9:
        return true;
    L6:
        return true;
    L11:
        return false;
    }

    private void a(int r4, MotionLayout r5) {
        com.obric.oui.constraintlayout.widget.c r0 = (com.obric.oui.constraintlayout.widget.c) ZeusTransformUtils.preCheckCast(this.k.get(r4), com.obric.oui.constraintlayout.widget.c.class, "com.obric.aiagent.plugin");
        r0.f34953b = r0.f34952a;
        int r6 = this.m.get(r4);
        if (r6 <= 0) goto L9;
        a(r6, r5);
        com.obric.oui.constraintlayout.widget.c r7 = (com.obric.oui.constraintlayout.widget.c) ZeusTransformUtils.preCheckCast(this.k.get(r6), com.obric.oui.constraintlayout.widget.c.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L8;
        b(TAG, "ERROR! invalid deriveConstraintsFrom: @id/" + a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6));
        return;
    L8:
        r0.f34953b += "/" + r7.f34953b;
        r0.a(r7);
    L10:
        r0.b(r0);
        return;
    L9:
        r0.f34953b += "  layout";
        r0.a(r5);
        goto L10
    }

    public static String a(String r1) {
        if (r1 != null) goto L5;
        return "";
    L5:
        int r0 = r1.indexOf(47);
        if (r0 >= 0) goto L9;
        return r1;
    L9:
        return r1.substring(r0 + 1);
    }

    public int b(String r2) {
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.l.get(r2), Integer.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.intValue();
    }

    public String f(int r5) {
        Iterator<Map.Entry<String, Integer>> r4 = this.l.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.getValue(), Integer.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L4;
        if (r1.intValue() != r5) goto L4;
        return (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
    L12:
        return null;
    }

    public void b(boolean r1) {
        this.g = r1;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
