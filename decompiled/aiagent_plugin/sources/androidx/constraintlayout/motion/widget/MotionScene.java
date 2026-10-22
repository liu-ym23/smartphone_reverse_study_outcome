package androidx.constraintlayout.motion.widget;

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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class MotionScene {
    private static final String TAG = "MotionScene";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    androidx.constraintlayout.widget.f f863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Transition f864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final r f865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f867e;
    private final MotionLayout f;
    private boolean g;
    private ArrayList<Transition> h;
    private Transition i;
    private ArrayList<Transition> j;
    private SparseArray<androidx.constraintlayout.widget.c> k;
    private HashMap<String, Integer> l;
    private SparseIntArray m;
    private boolean n;
    private int o;
    private int p;
    private MotionEvent q;
    private boolean r;
    private boolean s;
    private MotionLayout.c t;
    private boolean u;

    public static class Transition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f871d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f872e;
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
                INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionScene$Transition$TransitionOnClick_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(MotionScene.TAG, "OnClick could not find id " + this.mTargetId);
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
                INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionScene$Transition$TransitionOnClick_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(MotionScene.TAG, " (*)  could not find id " + this.mTargetId);
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
                Transition r2 = Transition.h(this.mTransition).f864b;
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
                Transition r10 = Transition.h(this.mTransition).f864b;
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
            public static int INVOKESTATIC_androidx_constraintlayout_motion_widget_MotionScene$Transition$TransitionOnClick_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
                return Log.e(r0, r1);
            }
        }

        static /* synthetic */ int a(Transition r0) {
            return r0.f870c;
        }

        static /* synthetic */ int a(Transition r0, int r1) {
            r0.f871d = r1;
            return r1;
        }

        static /* synthetic */ p a(Transition r0, p r1) {
            r0.l = r1;
            return r1;
        }

        static /* synthetic */ int b(Transition r0) {
            return r0.f871d;
        }

        static /* synthetic */ int b(Transition r0, int r1) {
            r0.f870c = r1;
            return r1;
        }

        static /* synthetic */ p c(Transition r0) {
            return r0.l;
        }

        static /* synthetic */ int d(Transition r0) {
            return r0.f868a;
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
            return r0.f869b;
        }

        static /* synthetic */ ArrayList j(Transition r0) {
            return r0.k;
        }

        static /* synthetic */ int k(Transition r0) {
            return r0.f872e;
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
            return this.f870c;
        }

        public int d() {
            return this.f871d;
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
            this.f868a = -1;
            this.f869b = false;
            this.f870c = -1;
            this.f871d = -1;
            this.f872e = 0;
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
            this.f872e = r6.f872e;
            this.f = r6.f;
            this.g = r6.g;
            this.h = r6.h;
            this.k = r6.k;
            this.i = r6.i;
            this.q = r6.q;
            return;
        }

        public Transition(int r5, MotionScene r6, int r7, int r8) {
            this.f868a = -1;
            this.f869b = false;
            this.f870c = -1;
            this.f871d = -1;
            this.f872e = 0;
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
            this.f868a = r5;
            this.j = r6;
            this.f871d = r7;
            this.f870c = r8;
            this.h = MotionScene.b(r6);
            this.q = MotionScene.c(r6);
        }

        Transition(MotionScene r5, Context r6, XmlPullParser r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r9 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r7, XmlPullParser.class, "com.obric.aiagent.plugin");
            this.f868a = -1;
            this.f869b = false;
            this.f870c = -1;
            this.f871d = -1;
            this.f872e = 0;
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
            this.f872e = r1;
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
            this.f870c = r15.getResourceId(r6, -1);
            String r4 = ZeusTransformUtils.getResources(r16, "com.obric.aiagent.plugin").getResourceTypeName(this.f870c);
            if ("layout".equals(r4) == false) goto L11;
            androidx.constraintlayout.widget.c r5 = new androidx.constraintlayout.widget.c();
            r5.b(r16, this.f870c);
            MotionScene.d(r13).append(this.f870c, r5);
        L63:
            r3 = r3 + 1;
            goto L4
        L11:
            if ("xml".equals(r4) == false) goto L63;
            this.f870c = MotionScene.a(r13, r16, this.f870c);
            goto L63
        L14:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_constraintSetStart, "styleable", "Transition_constraintSetStart")) goto L22;
            this.f871d = r15.getResourceId(r6, this.f871d);
            String r7 = ZeusTransformUtils.getResources(r16, "com.obric.aiagent.plugin").getResourceTypeName(this.f871d);
            if ("layout".equals(r7) == false) goto L19;
            androidx.constraintlayout.widget.c r8 = new androidx.constraintlayout.widget.c();
            r8.b(r16, this.f871d);
            MotionScene.d(r13).append(this.f871d, r8);
            goto L63
        L19:
            if ("xml".equals(r7) == false) goto L63;
            this.f871d = MotionScene.a(r13, r16, this.f871d);
            goto L63
        L22:
            if (r6 != ZeusTransformUtils.mapRes(R.styleable.Transition_motionInterpolator, "styleable", "Transition_motionInterpolator")) goto L38;
            TypedValue r9 = r15.peekValue(r6);
            if (r9.type != 1) goto L29;
            int r10 = r15.getResourceId(r6, -1);
            this.g = r10;
            if (r10 == (-1)) goto L63;
            this.f872e = -2;
            goto L63
        L29:
            if (r9.type != 3) goto L36;
            String r11 = r15.getString(r6);
            this.f = r11;
            if (r11 == null) goto L63;
            if (r11.indexOf("/") <= 0) goto L35;
            this.g = r15.getResourceId(r6, -1);
            this.f872e = -2;
            goto L63
        L35:
            this.f872e = -1;
            goto L63
        L36:
            this.f872e = r15.getInteger(r6, this.f872e);
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
            this.f868a = r15.getResourceId(r6, this.f868a);
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
            if (this.f871d != (-1)) goto L91;
            this.f869b = true;
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
        return r0.o;
    }

    static /* synthetic */ int c(MotionScene r0) {
        return r0.p;
    }

    static /* synthetic */ SparseArray d(MotionScene r0) {
        return r0.k;
    }

    void a(int r8, int r9) {
        androidx.constraintlayout.widget.f r0 = this.f863a;
        if (r0 == null) goto L11;
        int r1 = r0.a(r8, -1, -1);
        if (r1 != (-1)) goto L8;
        r1 = r8;
    L8:
        int r2 = this.f863a.a(r9, -1, -1);
        if (r2 != (-1)) goto L13;
    L12:
        r2 = r9;
    L13:
        Transition r3 = this.f864b;
        if (r3 != null) goto L16;
    L20:
        Iterator<Transition> r4 = this.h.iterator();
    L22:
        if (r4.hasNext() == false) goto L37;
        Transition r5 = (Transition) ZeusTransformUtils.preCheckCast(r4.next(), Transition.class, "com.obric.aiagent.plugin");
        if (Transition.a(r5) != r2) goto L28;
        if (Transition.b(r5) != r1) goto L28;
    L31:
        this.f864b = r5;
        if (r5 != null) goto L34;
        return;
    L34:
        if (Transition.c(r5) == null) goto L61;
        Transition.c(this.f864b).a(this.u);
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
        this.f864b = r11;
        return;
    L16:
        if (Transition.a(r3) != r9) goto L20;
        if (Transition.b(this.f864b) != r8) goto L20;
        return;
    L11:
        r1 = r8;
        goto L12
    }

    public void a(Transition r1) {
        this.f864b = r1;
        if (r1 != null) goto L5;
        return;
    L5:
        if (Transition.c(r1) == null) goto L9;
        Transition.c(this.f864b).a(this.u);
        return;
    }

    private int g(int r2) {
        androidx.constraintlayout.widget.f r1 = this.f863a;
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
        Transition.c(r9).a(this.u);
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
        if (Transition.c(r9).f908c == false) goto L29;
        if (r20 == null) goto L29;
        float r13 = r20.getX() - Transition.c(r9).f906a;
        float r14 = r20.getY() - Transition.c(r9).f907b;
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
        return this.f864b;
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
        Transition r3 = this.f864b;
        if (r3 != r2) goto L20;
        if (r3.c(2) == true) goto L10;
    L20:
        if (r9 != Transition.b(r2)) goto L31;
        if (Transition.g(r2) == 4) goto L25;
        if (Transition.g(r2) != 2) goto L31;
    L25:
        r8.setState(MotionLayout.g.f861d);
        r8.setTransition(r2);
        if (Transition.g(r2) != 4) goto L28;
        r8.transitionToEnd();
        r8.setState(MotionLayout.g.f859b);
        r8.setState(MotionLayout.g.f860c);
    L29:
        return true;
    L28:
        r8.setProgress(1.0f);
        r8.evaluate(true);
        r8.setState(MotionLayout.g.f859b);
        r8.setState(MotionLayout.g.f860c);
        r8.setState(MotionLayout.g.f861d);
        r8.onNewStateAttachHandlers();
    L31:
        if (r9 != Transition.a(r2)) goto L10;
        if (Transition.g(r2) == 3) goto L36;
        if (Transition.g(r2) != 1) goto L10;
    L36:
        r8.setState(MotionLayout.g.f861d);
        r8.setTransition(r2);
        if (Transition.g(r2) != 3) goto L39;
        r8.transitionToStart();
        r8.setState(MotionLayout.g.f859b);
        r8.setState(MotionLayout.g.f860c);
    L40:
        return true;
    L39:
        r8.setProgress(0.0f);
        r8.evaluate(true);
        r8.setState(MotionLayout.g.f859b);
        r8.setState(MotionLayout.g.f860c);
        r8.setState(MotionLayout.g.f861d);
        r8.onNewStateAttachHandlers();
        goto L40
    L41:
        return false;
    }

    private boolean t() {
        if (this.t == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void a(boolean r1) {
        this.u = r1;
        Transition r2 = this.f864b;
        if (r2 != null) goto L5;
        return;
    L5:
        if (Transition.c(r2) == null) goto L9;
        Transition.c(this.f864b).a(this.u);
        return;
    }

    public void a(int r1, View... r2) {
        this.f865c.a(r1, r2);
    }

    public void a(int r1, boolean r2) {
        this.f865c.a(r1, r2);
    }

    public boolean c(int r1) {
        return this.f865c.a(r1);
    }

    public boolean a(int r1, m r2) {
        return this.f865c.a(r1, r2);
    }

    MotionScene(Context r4, MotionLayout r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f863a = null;
        this.f864b = null;
        this.g = false;
        this.h = new ArrayList();
        this.i = null;
        this.j = new ArrayList();
        this.k = new SparseArray();
        this.l = new HashMap();
        this.m = new SparseIntArray();
        this.n = false;
        this.o = 400;
        this.p = 0;
        this.r = false;
        this.s = false;
        this.f = r5;
        this.f865c = new r(r5);
        a(r7, r6);
        this.k.put(ZeusTransformUtils.mapRes(R.id.motion_base, DbHelper.COL_ID, "motion_base"), new androidx.constraintlayout.widget.c());
        this.l.put("motion_base", Integer.valueOf(ZeusTransformUtils.mapRes(R.id.motion_base, DbHelper.COL_ID, "motion_base")));
    }

    private void a(Context r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        XmlResourceParser r0 = ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getXml(r11);
        Transition r2 = null;
        int r3 = r0.getEventType();     // Catch: IOException -> L82 XmlPullParserException -> L84
    L4:
        byte r4 = 1;
        if (r3 == 1) goto L117;
        if (r3 != 0) goto L8;
        r0.getName();     // Catch: IOException -> L82 XmlPullParserException -> L84
    L80:
        r3 = r0.next();     // Catch: IOException -> L82 XmlPullParserException -> L84
    L8:
        if (r3 != 2) goto L80;
        String r5 = r0.getName();     // Catch: IOException -> L82 XmlPullParserException -> L84
        if (this.n == false) goto L15;
        System.out.println("parsing = " + r5);     // Catch: IOException -> L82 XmlPullParserException -> L84
    L15:
        switch(r5.hashCode()) {
            case -1349929691: goto L45;
            case -1239391468: goto L42;
            case -687739768: goto L39;
            case 61998586: goto L36;
            case 269306229: goto L33;
            case 312750793: goto L30;
            case 327855227: goto L27;
            case 793277014: goto L24;
            case 1382829617: goto L21;
            case 1942574248: goto L18;
            default: goto L115;
        };
    L115:
        r4 = -1;
    L48:
        switch(r4) {
            case 0: goto L78;
            case 1: goto L63;
            case 2: goto L59;
            case 3: goto L57;
            case 4: goto L56;
            case 5: goto L55;
            case 6: goto L54;
            case 7: goto L54;
            case 8: goto L51;
            case 9: goto L50;
            default: goto L80;
        };     // Catch: IOException -> L82 XmlPullParserException -> L84
    L50:
        this.f865c.a(new q(r12, r0));     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L51:
        g r6 = new g(r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        if (r2 == null) goto L80;
        Transition.j(r2).add(r6);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L54:
        b(r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L55:
        c(r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L56:
        this.f863a = new androidx.constraintlayout.widget.f(r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L57:
        if (r2 == null) goto L80;
        r2.a(r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L59:
        if (r2 != null) goto L61;
        a(TAG, " OnSwipe (" + ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getResourceEntryName(r11) + ".xml:" + r0.getLineNumber() + ")");     // Catch: IOException -> L82 XmlPullParserException -> L84
    L61:
        if (r2 == null) goto L80;
        Transition.a(r2, new p(r12, this.f, r0));     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L63:
        ArrayList<Transition> r7 = this.h;     // Catch: IOException -> L82 XmlPullParserException -> L84
        Transition r8 = new Transition(this, r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        r7.add(r8);     // Catch: IOException -> L82 XmlPullParserException -> L84
        if (this.f864b != null) goto L71;
        if (Transition.i(r8) == true) goto L71;
        this.f864b = r8;     // Catch: IOException -> L82 XmlPullParserException -> L84
        if (Transition.c(r8) == null) goto L71;
        Transition.c(this.f864b).a(this.u);     // Catch: IOException -> L82 XmlPullParserException -> L84
    L71:
        if (Transition.i(r8) == true) goto L73;
    L77:
        r2 = r8;
        goto L80
    L73:
        if (Transition.a(r8) != (-1)) goto L75;
        this.i = r8;     // Catch: IOException -> L82 XmlPullParserException -> L84
    L76:
        this.h.remove(r8);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L77
    L75:
        this.j.add(r8);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L76
    L78:
        a(r12, r0);     // Catch: IOException -> L82 XmlPullParserException -> L84
        goto L80
    L18:
        if (r5.equals("include") == false) goto L47;
        r4 = 6;
        goto L48
    L47:
        r4 = -1;
        goto L48
    L21:
        if (r5.equals("StateSet") == false) goto L106;
        r4 = 4;
        goto L48
    L106:
        r4 = -1;
        goto L48
    L24:
        if (r5.equals(TAG) == false) goto L107;
        r4 = 0;
        goto L48
    L107:
        r4 = -1;
        goto L48
    L27:
        if (r5.equals("OnSwipe") == false) goto L108;
        r4 = 2;
        goto L48
    L108:
        r4 = -1;
        goto L48
    L30:
        if (r5.equals("OnClick") == false) goto L109;
        r4 = 3;
        goto L48
    L109:
        r4 = -1;
        goto L48
    L33:
        if (r5.equals("Transition") == true) goto L48;
        r4 = -1;
        goto L48
    L36:
        if (r5.equals("ViewTransition") == false) goto L111;
        r4 = 9;
        goto L48
    L111:
        r4 = -1;
        goto L48
    L39:
        if (r5.equals("Include") == false) goto L112;
        r4 = 7;
        goto L48
    L112:
        r4 = -1;
        goto L48
    L42:
        if (r5.equals("KeyFrameSet") == false) goto L113;
        r4 = 8;
        goto L48
    L113:
        r4 = -1;
        goto L48
    L45:
        if (r5.equals("ConstraintSet") == false) goto L114;
        r4 = 5;
        goto L48
    L114:
        r4 = -1;
        goto L48
    L117:
        return;
    L82:
        e = move-exception;
        e.printStackTrace();
        return;
    L84:
        e = move-exception;
        e.printStackTrace();
    }

    private void a(Context r7, XmlPullParser r8) {
        TypedArray r9 = ((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r8, XmlPullParser.class, "com.obric.aiagent.plugin")), R.styleable.MotionScene);
        int r10 = r9.getIndexCount();
        int r1 = 0;
    L3:
        if (r1 >= r10) goto L13;
        int r2 = r9.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionScene_defaultDuration, "styleable", "MotionScene_defaultDuration")) goto L10;
        int r3 = r9.getInt(r2, this.o);
        this.o = r3;
        if (r3 >= 8) goto L12;
        this.o = 8;
    L12:
        r1 = r1 + 1;
        goto L3
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.MotionScene_layoutDuringTransition, "styleable", "MotionScene_layoutDuringTransition")) goto L12;
        this.p = r9.getInteger(r2, 0);
        goto L12
    L13:
        r9.recycle();
    }

    private int a(Context r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if (r8.contains("/") == false) goto L7;
        int r10 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin"), r8.substring(r8.indexOf(47) + 1), DbHelper.COL_ID, r9.getPackageName(), "com.obric.aiagent.plugin");
        if (this.n == false) goto L8;
        System.out.println("id getMap res = " + r10);
    L8:
        if (r10 != (-1)) goto L15;
        if (r8 != null) goto L11;
    L13:
        b(TAG, "error in parsing id");
        return r10;
    L11:
        if (r8.length() <= 1) goto L13;
        return Integer.parseInt(r8.substring(1));
    L15:
        return r10;
    L7:
        r10 = -1;
        goto L8
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

    private int b(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        XmlResourceParser r7 = ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getXml(r5);
        int r0 = r7.getEventType();     // Catch: IOException -> L14 XmlPullParserException -> L16
    L5:
        if (r0 == 1) goto L27;
        String r1 = r7.getName();     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (2 != r0) goto L12;
        if ("ConstraintSet".equals(r1) == false) goto L12;
        return c(r6, r7);
    L12:
        r0 = r7.next();     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L5
    L27:
        return -1;
    L14:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L16:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    private int c(Context r14, XmlPullParser r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r17 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r15, XmlPullParser.class, "com.obric.aiagent.plugin");
        androidx.constraintlayout.widget.c r0 = new androidx.constraintlayout.widget.c();
        r0.a(false);
        int r2 = r17.getAttributeCount();
        int r4 = 0;
        int r5 = -1;
        int r6 = -1;
    L4:
        if (r4 >= r2) goto L60;
        String r8 = r17.getAttributeName(r4);
        String r9 = r17.getAttributeValue(r4);
        if (this.n == false) goto L8;
        System.out.println("id string = " + r9);
    L8:
        r8.hashCode();
        switch(r8.hashCode()) {
            case -1496482599: goto L20;
            case -1153153640: goto L16;
            case 3355: goto L12;
            default: goto L10;
        };
    L10:
        byte r10 = -1;
    L23:
        switch(r10) {
            case 0: goto L58;
            case 1: goto L69;
            case 2: goto L25;
            default: goto L59;
        };
    L25:
        r5 = a(r16, r9);
        this.l.put(a(r9), Integer.valueOf(r5));
        r0.f968a = a.a(r16, r5);
        goto L59
    L58:
        r6 = a(r16, r9);
        goto L59
    L69:
        r0.f970c = Integer.parseInt(r9);     // Catch: NumberFormatException -> L28
    L28:
        r9.hashCode();
        switch(r9.hashCode()) {
            case -768416914: goto L48;
            case 3317767: goto L44;
            case 3387192: goto L40;
            case 108511772: goto L36;
            case 1954540437: goto L32;
            default: goto L30;
        };
    L30:
        byte r11 = -1;
    L51:
        switch(r11) {
            case 0: goto L57;
            case 1: goto L56;
            case 2: goto L55;
            case 3: goto L54;
            case 4: goto L53;
            default: goto L59;
        };
    L53:
        r0.f970c = 3;
        goto L59
    L54:
        r0.f970c = 1;
        goto L59
    L55:
        r0.f970c = 0;
        goto L59
    L56:
        r0.f970c = 2;
        goto L59
    L57:
        r0.f970c = 4;
        goto L59
    L32:
        if (r9.equals("x_right") == false) goto L85;
        r11 = 4;
        goto L51
    L85:
        r11 = -1;
        goto L51
    L36:
        if (r9.equals("right") == false) goto L86;
        r11 = 3;
        goto L51
    L86:
        r11 = -1;
        goto L51
    L40:
        if (r9.equals(OProtocolTextEffectTextView.EffectNameNone) == false) goto L87;
        r11 = 2;
        goto L51
    L87:
        r11 = -1;
        goto L51
    L44:
        if (r9.equals("left") == false) goto L88;
        r11 = 1;
        goto L51
    L88:
        r11 = -1;
        goto L51
    L48:
        if (r9.equals("x_left") == false) goto L89;
        r11 = 0;
        goto L51
    L89:
        r11 = -1;
    L59:
        r4 = r4 + 1;
        goto L4
    L12:
        if (r8.equals(DbHelper.COL_ID) == false) goto L82;
        r10 = 2;
        goto L23
    L82:
        r10 = -1;
        goto L23
    L16:
        if (r8.equals("constraintRotate") == false) goto L83;
        r10 = 1;
        goto L23
    L83:
        r10 = -1;
        goto L23
    L20:
        if (r8.equals("deriveConstraintsFrom") == false) goto L84;
        r10 = 0;
        goto L23
    L84:
        r10 = -1;
        goto L23
    L60:
        if (r5 != (-1)) goto L62;
    L68:
        return r5;
    L62:
        if (this.f.mDebugPath == 0) goto L64;
        r0.b(true);
    L64:
        r0.a(r16, r17);
        if (r6 == (-1)) goto L67;
        this.m.put(r5, r6);
    L67:
        this.k.put(r5, r0);
        goto L68
    }

    androidx.constraintlayout.widget.c d(int r2) {
        return a(r2, -1, -1);
    }

    androidx.constraintlayout.widget.c a(int r4, int r5, int r6) {
        if (this.n == false) goto L5;
        System.out.println("id " + r4);
        System.out.println("size " + this.k.size());
    L5:
        androidx.constraintlayout.widget.f r0 = this.f863a;
        if (r0 == null) goto L11;
        int r7 = r0.a(r4, r5, r6);
        if (r7 == (-1)) goto L11;
        r4 = r7;
    L11:
        if (this.k.get(r4) != null) goto L15;
        b(TAG, "Warning could not find ConstraintSet id/" + a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4) + " In MotionScene");
        SparseArray<androidx.constraintlayout.widget.c> r3 = this.k;
        return (androidx.constraintlayout.widget.c) ZeusTransformUtils.preCheckCast(r3.get(r3.keyAt(0)), androidx.constraintlayout.widget.c.class, "com.obric.aiagent.plugin");
    L15:
        return (androidx.constraintlayout.widget.c) ZeusTransformUtils.preCheckCast(this.k.get(r4), androidx.constraintlayout.widget.c.class, "com.obric.aiagent.plugin");
    }

    public void a(int r1, androidx.constraintlayout.widget.c r2) {
        this.k.put(r1, r2);
    }

    public void a(m r4) {
        Transition r0 = this.f864b;
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
        Transition r5 = this.f864b;
        if (r5 != null) goto L11;
    L13:
        return false;
    L11:
        if (Transition.c(r5) == null) goto L13;
        return true;
    }

    void a(MotionEvent r12, int r13, MotionLayout r14) {
        RectF r0 = new RectF();
        if (this.t != null) goto L5;
        this.t = this.f.obtainVelocityTracker();
    L5:
        this.t.a(r12);
        if (r13 == (-1)) goto L47;
        int r4 = r12.getAction();
        boolean r5 = false;
        if (r4 != 0) goto L10;
        this.f866d = r12.getRawX();
        this.f867e = r12.getRawY();
        this.q = r12;
        this.r = false;
        if (Transition.c(this.f864b) == null) goto L65;
        RectF r15 = Transition.c(this.f864b).b(this.f, r0);
        if (r15 != null) goto L35;
    L38:
        RectF r16 = Transition.c(this.f864b).a(this.f, r0);
        if (r16 != null) goto L41;
    L43:
        this.s = false;
    L44:
        Transition.c(this.f864b).b(this.f866d, this.f867e);
        return;
    L41:
        if (r16.contains(this.q.getX(), this.q.getY()) == true) goto L43;
        this.s = true;
        goto L44
    L35:
        if (r15.contains(this.q.getX(), this.q.getY()) == true) goto L38;
        this.q = null;
        this.r = true;
        return;
    L65:
        return;
    L10:
        if (r4 != 2) goto L47;
        if (this.r == true) goto L47;
        float r6 = r12.getRawY() - this.f867e;
        float r7 = r12.getRawX() - this.f866d;
        if (r7 == 0.0d) goto L18;
    L19:
        MotionEvent r8 = this.q;
        if (r8 == null) goto L64;
        Transition r9 = a(r13, r7, r6, r8);
        if (r9 == null) goto L47;
        r14.setTransition(r9);
        RectF r1 = Transition.c(this.f864b).a(this.f, r0);
        if (r1 != null) goto L27;
    L29:
        this.s = r5;
        Transition.c(this.f864b).a(this.f866d, this.f867e);
        goto L47
    L27:
        if (r1.contains(this.q.getX(), this.q.getY()) == true) goto L29;
        r5 = true;
        goto L29
    L64:
        return;
    L18:
        if (r6 != 0.0d) goto L19;
        return;
    L47:
        if (this.r == false) goto L49;
        return;
    L49:
        Transition r2 = this.f864b;
        if (r2 != null) goto L52;
    L56:
        this.f866d = r12.getRawX();
        this.f867e = r12.getRawY();
        if (r12.getAction() != 1) goto L66;
        MotionLayout.c r17 = this.t;
        if (r17 == null) goto L67;
        r17.a();
        this.t = null;
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
        if (this.s == true) goto L56;
        Transition.c(this.f864b).b(r12, this.t, r13, this);
        goto L56
    }

    void a(float r2, float r3) {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.c(r0) == null) goto L9;
        Transition.c(this.f864b).e(r2, r3);
        return;
    }

    void b(float r2, float r3) {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.c(r0) == null) goto L9;
        Transition.c(this.f864b).d(r2, r3);
        return;
    }

    float c(float r2, float r3) {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f864b).c(r2, r3);
    }

    int d() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.b(r0);
    }

    int e() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.a(r0);
    }

    public Interpolator f() {
        int r0 = Transition.k(this.f864b);
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
        final androidx.constraintlayout.a.a.a.c r1 = androidx.constraintlayout.a.a.a.c.a(Transition.l(this.f864b));
        return new AnonymousClass1(this, r1);
    L34:
        return AnimationUtils.loadInterpolator((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), Transition.m(this.f864b));
    }

    public int g() {
        Transition r0 = this.f864b;
        if (r0 == null) goto L7;
        return Transition.n(r0);
    L7:
        return this.o;
    }

    public void e(int r2) {
        Transition r0 = this.f864b;
        if (r0 == null) goto L5;
        r0.a(r2);
        return;
    L5:
        this.o = r2;
    }

    public int h() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return Transition.o(r0);
    }

    public float i() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        return Transition.p(r0);
    }

    float j() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f864b).b();
    }

    float k() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f864b).c();
    }

    float l() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f864b).h();
    }

    float m() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f864b).i();
    }

    float n() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f864b).j();
    }

    float o() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0.0f;
    L7:
        return Transition.c(this.f864b).k();
    }

    int p() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0;
    L7:
        return Transition.c(this.f864b).l();
    }

    int q() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return 0;
    L7:
        return Transition.c(this.f864b).e();
    }

    void r() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Transition.c(r0) == null) goto L9;
        Transition.c(this.f864b).a();
        return;
    }

    boolean s() {
        Transition r0 = this.f864b;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (Transition.c(r0) != null) goto L7;
        return false;
    L7:
        return Transition.c(this.f864b).d();
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
        androidx.constraintlayout.widget.c r0 = (androidx.constraintlayout.widget.c) ZeusTransformUtils.preCheckCast(this.k.get(r4), androidx.constraintlayout.widget.c.class, "com.obric.aiagent.plugin");
        r0.f969b = r0.f968a;
        int r6 = this.m.get(r4);
        if (r6 <= 0) goto L9;
        a(r6, r5);
        androidx.constraintlayout.widget.c r7 = (androidx.constraintlayout.widget.c) ZeusTransformUtils.preCheckCast(this.k.get(r6), androidx.constraintlayout.widget.c.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L8;
        b(TAG, "ERROR! invalid deriveConstraintsFrom: @id/" + a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6));
        return;
    L8:
        r0.f969b += "/" + r7.f969b;
        r0.a(r7);
    L10:
        r0.b(r0);
        return;
    L9:
        r0.f969b += "  layout";
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
}
