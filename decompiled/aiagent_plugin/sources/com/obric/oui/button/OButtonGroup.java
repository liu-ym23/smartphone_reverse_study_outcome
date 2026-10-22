package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OButtonGroup.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OButtonGroup extends OShadowFrame {
    private static final float ALPHA_ACCELERATION_FACTOR = 0.7f;
    public static final c Companion = null;
    private static final int DEFAULT_CAPACITY = 5;
    private static final String TAG = "OButtonGroup";
    private final List<d.h.a.a<d.x>> animationEndListeners;
    private d.h.a.a<d.x> animationUpdateListener;
    private int capacity;
    private d contentAnimationState;
    private final List<com.obric.common.oea.foundation.animation.manager.d> contentAnimators;
    private float currentGroupBlur;
    private final List<d.h.a.a<d.x>> groupAlphaAnimationEndListeners;
    private d.h.a.a<d.x> groupAlphaAnimationUpdateListener;
    private e groupAnimationState;
    private final List<com.obric.common.oea.foundation.animation.manager.d> groupAnimators;
    private float groupScaleForAnimation;
    private LinearLayout itemContainer;
    private int itemMargin;
    private int minWidth;
    private float pressScaleForAnimation;
    private float rawGroupAlpha;
    private List<? extends Object> runningTargetItemKeys;
    private boolean singleItemSuppressPressEffectApplied;
    private View singleItemView;
    private boolean touchEventBlocked;

    /* JADX INFO: compiled from: OButtonGroup.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.h.a.a<d.x> f34160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<d.h.a.b<d.h.a.a<d.x>, d.x>> f34161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f34162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f34163d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f34164e;

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        /* synthetic */ class C0929a extends d.h.b.l implements d.h.a.a<d.x> {
            C0929a(Object r8) {
                super(0, r8, a.class, "done", "done()V", 0);
            }

            public final void a() {
                a.a((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.h.a.a
            public /* synthetic */ d.x invoke() {
                a();
                return d.x.f38692a;
            }
        }

        public a(d.h.a.a<d.x> r3) {
            d.h.a.a<d.x> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "onFinished");
            this.f34160a = r4;
            this.f34161b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        }

        public static final /* synthetic */ void a(a r0) {
            r0.b();
        }

        public final void a(d.h.a.b<? super d.h.a.a<d.x>, d.x> r3) {
            d.h.a.b<d.h.a.a<d.x>, d.x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "starter");
            this.f34161b.add(r4);
        }

        public final void a() {
            if (this.f34161b.isEmpty() == false) goto L6;
            c();
            return;
        L6:
            this.f34162c = this.f34161b.size();
            this.f34163d = true;
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f34161b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            ((d.h.a.b) ZeusTransformUtils.preCheckCast(r0.next(), d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(new C0929a(this));
            goto L8
        }

        private final void b() {
            if (this.f34163d == true) goto L5;
            return;
        L5:
            if (this.f34164e == true) goto L13;
            int r0 = this.f34162c - 1;
            this.f34162c = r0;
            if (r0 != 0) goto L12;
            c();
            return;
        L12:
            return;
        }

        private final void c() {
            if (this.f34164e == false) goto L5;
            return;
        L5:
            this.f34164e = true;
            this.f34160a.invoke();
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class aa extends d.h.b.p implements d.h.a.b<Float, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34165a;

        aa(OButtonGroup r1) {
            this.f34165a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return d.x.f38692a;
        }

        public final void a(float r1) {
            OButtonGroup.access$setGroupBlurForAnimation(this.f34165a, r1);
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class ab extends d.h.b.p implements d.h.a.b<Float, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34166a;

        ab(OButtonGroup r1) {
            this.f34166a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return d.x.f38692a;
        }

        public final void a(float r1) {
            OButtonGroup.access$setGroupScaleForAnimation(this.f34166a, r1);
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class ac extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f34167a;

        ac(d.h.a.a<d.x> r3) {
            this.f34167a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            this.f34167a.invoke();
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class ad extends d.h.b.p implements d.h.a.b<Float, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Float, d.x> f34168a;

        ad(d.h.a.b<? super Float, d.x> r3) {
            this.f34168a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return d.x.f38692a;
        }

        public final void a(float r1) {
            this.f34168a.invoke(Float.valueOf(r1));
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class ae extends d.h.b.p implements d.h.a.b<Float, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f34170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<com.obric.oui.common.style.j> f34171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<com.obric.oui.common.style.j> f34172d;

        ae(OButtonGroup r3, float r4, List<com.obric.oui.common.style.j> r5, List<com.obric.oui.common.style.j> r6) {
            List<com.obric.oui.common.style.j> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            List<com.obric.oui.common.style.j> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            this.f34169a = r3;
            this.f34170b = r4;
            this.f34171c = r7;
            this.f34172d = r8;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return d.x.f38692a;
        }

        public final void a(float r4) {
            this.f34169a.updateContentShadowAlphaTransition(this.f34170b, r4, this.f34171c, this.f34172d);
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class af extends d.h.b.p implements d.h.a.b<Float, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34173a;

        af(OButtonGroup r1) {
            this.f34173a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return d.x.f38692a;
        }

        public final void a(float r1) {
            int r2 = d.i.a.a(r1);
            OButtonGroup.access$freezeGroupWidth(this.f34173a, r2);
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class ag extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f34175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f34176c;

        ag(OButtonGroup r3, int r4, d.h.a.a<d.x> r5) {
            d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f34174a = r3;
            this.f34175b = r4;
            this.f34176c = r6;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OButtonGroup.access$freezeGroupWidth(this.f34174a, this.f34175b);
            this.f34176c.invoke();
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class ah extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34177a;

        ah(OButtonGroup r1) {
            this.f34177a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OButtonGroup.access$markCurrentTargetReached(this.f34177a);
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class ai extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34178a;

        ai(OButtonGroup r1) {
            this.f34178a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OButtonGroup.access$replaceItems(this.f34178a, d.a.p.b());
            OButtonGroup.access$markCurrentTargetReached(this.f34178a);
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f34179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f34180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f34181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f34182d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f34183e;
        private final int f;
        private final List<f> g;

        public static /* synthetic */ b a(b r9, int r10, float r11, float r12, float r13, float r14, int r15, List r16, int r17, Object r18) {
            List<f> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
            if ((r17 & 1) == 0) goto L5;
            int r2 = r9.f34179a;
        L7:
            if ((r17 & 2) == 0) goto L9;
            float r3 = r9.f34180b;
        L11:
            if ((r17 & 4) == 0) goto L13;
            float r4 = r9.f34181c;
        L15:
            if ((r17 & 8) == 0) goto L17;
            float r5 = r9.f34182d;
        L19:
            if ((r17 & 16) == 0) goto L21;
            float r6 = r9.f34183e;
        L23:
            if ((r17 & 32) == 0) goto L25;
            int r7 = r9.f;
        L27:
            if ((r17 & 64) == 0) goto L30;
            r1 = r9.g;
        L30:
            return r9.a(r2, r3, r4, r5, r6, r7, r1);
        L25:
            r7 = r15;
            goto L27
        L21:
            r6 = r14;
            goto L23
        L17:
            r5 = r13;
            goto L19
        L13:
            r4 = r12;
            goto L15
        L9:
            r3 = r11;
            goto L11
        L5:
            r2 = r10;
            goto L7
        }

        public final b a(int r9, float r10, float r11, float r12, float r13, int r14, List<f> r15) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r7, "items");
            return new b(r9, r10, r11, r12, r13, r14, r7);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f34179a == r6.f34179a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(Float.valueOf(this.f34180b), Float.valueOf(r6.f34180b)) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(Float.valueOf(this.f34181c), Float.valueOf(r6.f34181c)) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(Float.valueOf(this.f34182d), Float.valueOf(r6.f34182d)) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(Float.valueOf(this.f34183e), Float.valueOf(r6.f34183e)) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (d.h.b.o.a(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            return (((((((((((Integer.hashCode(this.f34179a) * 31) + Float.hashCode(this.f34180b)) * 31) + Float.hashCode(this.f34181c)) * 31) + Float.hashCode(this.f34182d)) * 31) + Float.hashCode(this.f34183e)) * 31) + Integer.hashCode(this.f)) * 31) + this.g.hashCode();
        }

        public String toString() {
            return "AnimationState(visibility=" + this.f34179a + ", alpha=" + this.f34180b + ", scaleX=" + this.f34181c + ", scaleY=" + this.f34182d + ", groupBlur=" + this.f34183e + ", groupWidth=" + this.f + ", items=" + this.g + ')';
        }

        public b(int r3, float r4, float r5, float r6, float r7, int r8, List<f> r9) {
            List<f> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r10, "items");
            this.f34179a = r3;
            this.f34180b = r4;
            this.f34181c = r5;
            this.f34182d = r6;
            this.f34183e = r7;
            this.f = r8;
            this.g = r10;
        }

        public final int a() {
            return this.f34179a;
        }

        public final float b() {
            return this.f34180b;
        }

        public final float c() {
            return this.f34181c;
        }

        public final float d() {
            return this.f34182d;
        }

        public final float e() {
            return this.f34183e;
        }

        public final int f() {
            return this.f;
        }

        public final List<f> g() {
            return this.g;
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    public static final class c {

        /* JADX INFO: compiled from: OButtonGroup.kt */
        public static final class a {
            private static final b A = null;
            private static final b B = null;
            private static final b C = null;
            private static final b D = null;
            private static final b E = null;
            private static final b F = null;
            private static final b G = null;
            private static final b H = null;
            private static final b I = null;

            /* JADX INFO: renamed from: J, reason: collision with root package name */
            private static final b f34184J = null;
            private static final b K = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f34185a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static float f34186b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static int f34187c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static float f34188d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private static float f34189e;
            private static float f;
            private static int g;
            private static float h;
            private static float i;
            private static float j;
            private static int k;
            private static final b l = null;
            private static final b m = null;
            private static final b n = null;
            private static final b o = null;
            private static final b p = null;
            private static final b q = null;
            private static final b r = null;
            private static final b s = null;
            private static final b t = null;
            private static final b u = null;
            private static final b v = null;
            private static final b w = null;
            private static final b x = null;
            private static final b y = null;
            private static final b z = null;

            private a() {
            }

            static {
                f34185a = new a();
                f34186b = 1.1f;
                f34187c = 7;
                f34188d = 1.04f;
                f34189e = 1.03f;
                f = 1.5f;
                g = 7;
                h = 1.05f;
                i = 1.5f;
                j = 1.2f;
                k = 7;
                l = new b(com.obric.common.oea.foundation.animation.h.e.a.i, com.obric.common.oea.foundation.animation.h.e.c.f);
                m = new b(com.obric.common.oea.foundation.animation.h.e.a.i, com.obric.common.oea.foundation.animation.h.e.c.g);
                n = new b(com.obric.common.oea.foundation.animation.h.e.a.f, com.obric.common.oea.foundation.animation.h.e.c.f);
                o = new b(com.obric.common.oea.foundation.animation.h.e.a.f, com.obric.common.oea.foundation.animation.h.e.c.g);
                p = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f);
                q = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.g);
                r = new b(com.obric.common.oea.foundation.animation.h.e.a.i, com.obric.common.oea.foundation.animation.h.e.c.f32442e);
                s = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f32439b);
                t = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f);
                u = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.g);
                v = new b(com.obric.common.oea.foundation.animation.h.e.a.f, com.obric.common.oea.foundation.animation.h.e.c.f);
                w = new b(com.obric.common.oea.foundation.animation.h.e.a.f, com.obric.common.oea.foundation.animation.h.e.c.g);
                x = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f);
                y = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.g);
                z = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f);
                A = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f);
                B = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f32439b);
                C = new b(com.obric.common.oea.foundation.animation.h.e.a.i, com.obric.common.oea.foundation.animation.h.e.c.f);
                D = new b(com.obric.common.oea.foundation.animation.h.e.a.g, com.obric.common.oea.foundation.animation.h.e.c.h);
                E = new b(com.obric.common.oea.foundation.animation.h.e.a.g, com.obric.common.oea.foundation.animation.h.e.c.i);
                F = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f32439b);
                G = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f32439b);
                H = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f32439b);
                I = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f);
                f34184J = new b(com.obric.common.oea.foundation.animation.h.e.a.i, com.obric.common.oea.foundation.animation.h.e.c.f32442e);
                K = new b(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f);
            }

            public final float a() {
                return f34186b;
            }

            public final int b() {
                return f34187c;
            }

            public final float a(int r1) {
                if (r1 >= 150) goto L6;
                return f34188d;
            L6:
                return f34189e;
            }

            public final float c() {
                return f;
            }

            public final int d() {
                return g;
            }

            public final float e() {
                return h;
            }

            public final float f() {
                return i;
            }

            public final float g() {
                return j;
            }

            public final int h() {
                return k;
            }

            public final b b(int r1) {
                if (r1 >= 150) goto L6;
                return l;
            L6:
                return m;
            }

            public final b c(int r1) {
                if (r1 >= 150) goto L6;
                return n;
            L6:
                return o;
            }

            public final b d(int r1) {
                if (r1 >= 150) goto L6;
                return p;
            L6:
                return q;
            }

            public final b i() {
                return r;
            }

            public final b j() {
                return s;
            }

            public final b e(int r1) {
                if (r1 >= 150) goto L6;
                return t;
            L6:
                return u;
            }

            public final b f(int r1) {
                if (r1 >= 150) goto L6;
                return v;
            L6:
                return w;
            }

            public final b g(int r1) {
                if (r1 >= 150) goto L6;
                return x;
            L6:
                return y;
            }

            public final b k() {
                return z;
            }

            public final b l() {
                return A;
            }

            public final b m() {
                return B;
            }

            public final b n() {
                return C;
            }

            public final b h(int r1) {
                if (r1 >= 150) goto L6;
                return D;
            L6:
                return E;
            }

            public final b o() {
                return F;
            }

            public final b p() {
                return G;
            }

            public final b q() {
                return H;
            }

            public final b r() {
                return I;
            }

            public final b s() {
                return f34184J;
            }

            public final b t() {
                return K;
            }
        }

        /* JADX INFO: compiled from: OButtonGroup.kt */
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private com.obric.common.oea.foundation.animation.h.e.a f34190a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private com.obric.common.oea.foundation.animation.h.e.c f34191b;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
                if (this.f34190a == r6.f34190a) goto L12;
                return false;
            L12:
                if (this.f34191b == r6.f34191b) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f34190a.hashCode() * 31) + this.f34191b.hashCode();
            }

            public String toString() {
                return "SpringTokenConfig(bounce=" + this.f34190a + ", duration=" + this.f34191b + ')';
            }

            public b(com.obric.common.oea.foundation.animation.h.e.a r2, com.obric.common.oea.foundation.animation.h.e.c r3) {
                d.h.b.o.e(r2, "bounce");
                d.h.b.o.e(r3, "duration");
                this.f34190a = r2;
                this.f34191b = r3;
            }

            public final com.obric.common.oea.foundation.animation.g.a<Float> a() {
                return (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(this.f34190a, this.f34191b, com.obric.common.oea.foundation.animation.h.e.b.f32433a), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            }
        }

        public /* synthetic */ c(d.h.b.h r1) {
            this();
        }

        private c() {
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    private static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f34192a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f34193b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f34194c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f34195d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d[] f34196e = null;

        private static final /* synthetic */ d[] a() {
            return new d[]{f34192a, f34193b, f34194c, f34195d};
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f34196e.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f34192a = new d("IDLE", 0);
            f34193b = new d("OUT", 1);
            f34194c = new d("IN", 2);
            f34195d = new d("SETTLING", 3);
            f34196e = a();
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    private static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f34197a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f34198b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f34199c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ e[] f34200d = null;

        private static final /* synthetic */ e[] a() {
            return new e[]{f34197a, f34198b, f34199c};
        }

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f34200d.clone(), e[].class, "com.obric.aiagent.plugin");
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f34197a = new e("IDLE", 0);
            f34198b = new e("APPEARING", 1);
            f34199c = new e("DISAPPEARING", 2);
            f34200d = a();
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f34201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f34202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f34203c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f34204d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f34205e;

        public static /* synthetic */ f a(f r3, Object r4, int r5, float r6, float r7, float r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.f34201a;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.f34202b;
        L8:
            int r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.f34203c;
        L11:
            float r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.f34204d;
        L14:
            float r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.f34205e;
        L17:
            Object r12 = r4;
            return r3.a(r12, r11, r0, r1, r8);
        }

        public final f a(Object r7, int r8, float r9, float r10, float r11) {
            return new f(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f34201a, r6.f34201a) == true) goto L12;
            return false;
        L12:
            if (this.f34202b == r6.f34202b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(Float.valueOf(this.f34203c), Float.valueOf(r6.f34203c)) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(Float.valueOf(this.f34204d), Float.valueOf(r6.f34204d)) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(Float.valueOf(this.f34205e), Float.valueOf(r6.f34205e)) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            Object r0 = this.f34201a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((((((r1 * 31) + Integer.hashCode(this.f34202b)) * 31) + Float.hashCode(this.f34203c)) * 31) + Float.hashCode(this.f34204d)) * 31) + Float.hashCode(this.f34205e);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "ItemAnimationState(key=" + this.f34201a + ", visibility=" + this.f34202b + ", alpha=" + this.f34203c + ", scaleX=" + this.f34204d + ", scaleY=" + this.f34205e + ')';
        }

        public f(Object r1, int r2, float r3, float r4, float r5) {
            this.f34201a = r1;
            this.f34202b = r2;
            this.f34203c = r3;
            this.f34204d = r4;
            this.f34205e = r5;
        }

        public final Object a() {
            return this.f34201a;
        }

        public final int b() {
            return this.f34202b;
        }

        public final float c() {
            return this.f34203c;
        }

        public final float d() {
            return this.f34204d;
        }

        public final float e() {
            return this.f34205e;
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class g extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f34206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<View> f34208c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f34209d;

        g(d.h.b.z.a r3, OButtonGroup r4, List<? extends View> r5, d.h.b.z.a r6) {
            List<View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            this.f34206a = r3;
            this.f34207b = r4;
            this.f34208c = r7;
            this.f34209d = r6;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            this.f34206a.f38499a = true;
            OButtonGroup.access$finishContentChangeIfReady(this.f34207b, this.f34208c, this.f34206a.f38499a, this.f34209d.f38499a);
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class h extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<View> f34211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f34212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f34213d;

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$h$1, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.a<d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.h.b.z.a f34214a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34215b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ List<View> f34216c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ d.h.b.z.a f34217d;

            AnonymousClass1(d.h.b.z.a r3, OButtonGroup r4, List<? extends View> r5, d.h.b.z.a r6) {
                List<View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                this.f34214a = r3;
                this.f34215b = r4;
                this.f34216c = r7;
                this.f34217d = r6;
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ d.x invoke() {
                a();
                return d.x.f38692a;
            }

            public final void a() {
                this.f34214a.f38499a = true;
                OButtonGroup.access$finishContentChangeIfReady(this.f34215b, this.f34216c, this.f34217d.f38499a, this.f34214a.f38499a);
            }
        }

        h(OButtonGroup r3, List<? extends View> r4, d.h.b.z.a r5, d.h.b.z.a r6) {
            List<View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f34210a = r3;
            this.f34211b = r7;
            this.f34212c = r5;
            this.f34213d = r6;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OButtonGroup.access$startContentFadeInPhase(this.f34210a, this.f34211b, (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f34212c, this.f34210a, this.f34211b, this.f34213d), d.h.a.a.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class i extends d.h.b.p implements d.h.a.b<a, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f34218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f34219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<View> f34220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f34222e;

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$i$1, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34223a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f34224b;

            AnonymousClass1(OButtonGroup r1, int r2) {
                this.f34223a = r1;
                this.f34224b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r4) {
                d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r5, "done");
                OButtonGroup.access$startGroupAlphaAnimation(this.f34223a, 1.0f, c.a.f34185a.c(this.f34224b).a(), r5, OButtonGroup.access$getContentAnimators$p(this.f34223a));
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$i$2, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass2 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34225a;

            AnonymousClass2(OButtonGroup r1) {
                this.f34225a = r1;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r4) {
                d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r5, "done");
                OButtonGroup.access$startGroupShadowAnimation(this.f34225a, 1.0f, c.a.f34185a.o().a(), r5, OButtonGroup.access$getContentAnimators$p(this.f34225a));
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$i$3, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass3 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34226a;

            AnonymousClass3(OButtonGroup r1) {
                this.f34226a = r1;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r4) {
                d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r5, "done");
                OButtonGroup.access$startGroupScaleAnimation(this.f34226a, c.a.f34185a.e(), c.a.f34185a.m().a(), r5, OButtonGroup.access$getContentAnimators$p(this.f34226a));
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$i$4, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass4 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34227a;

            AnonymousClass4(OButtonGroup r1) {
                this.f34227a = r1;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r4) {
                d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r5, "done");
                OButtonGroup r0 = this.f34227a;
                OButtonGroup.access$startGroupBlurAnimation(r0, OButtonGroup.access$changeBlurRadius(r0), c.a.f34185a.o().a(), r5, OButtonGroup.access$getContentAnimators$p(this.f34227a));
            }
        }

        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class a extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34228a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f34229b;

            a(OButtonGroup r1, View r2) {
                this.f34228a = r1;
                this.f34229b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r7) {
                d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "done");
                OButtonGroup.access$startChildAlphaAnimation(this.f34228a, this.f34229b, 0.0f, c.a.f34185a.q().a(), r4, OButtonGroup.access$getContentAnimators$p(this.f34228a));
            }
        }

        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class b extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34230a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f34231b;

            b(OButtonGroup r1, View r2) {
                this.f34230a = r1;
                this.f34231b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r7) {
                d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "done");
                OButtonGroup r0 = this.f34230a;
                View r1 = this.f34231b;
                OButtonGroup.access$startChildScaleAnimation(r0, r1, OButtonGroup.access$hiddenContentScale(r0, r1), c.a.f34185a.p().a(), r4, OButtonGroup.access$getContentAnimators$p(this.f34230a));
            }
        }

        i(boolean r3, boolean r4, List<? extends View> r5, OButtonGroup r6, int r7) {
            List<View> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            this.f34218a = r3;
            this.f34219b = r4;
            this.f34220c = r8;
            this.f34221d = r6;
            this.f34222e = r7;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(a r3) {
            a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(a r6) {
            d.h.b.o.e(r6, "$this$startAnimationBatch");
            if (this.f34218a == false) goto L6;
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f34221d, this.f34222e), d.h.a.b.class, "com.obric.aiagent.plugin"));
        L6:
            if (this.f34219b == false) goto L8;
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f34221d), d.h.a.b.class, "com.obric.aiagent.plugin"));
        L8:
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.f34221d), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.f34221d), d.h.a.b.class, "com.obric.aiagent.plugin"));
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f34220c, Iterable.class, "com.obric.aiagent.plugin");
            OButtonGroup r5 = this.f34221d;
            Iterator r1 = r0.iterator();
        L10:
            if (r1.hasNext() == false) goto L12;
            View r2 = (View) ZeusTransformUtils.preCheckCast(r1.next(), View.class, "com.obric.aiagent.plugin");
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r5, r2), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r5, r2), d.h.a.b.class, "com.obric.aiagent.plugin"));
            goto L10
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class j extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<View> f34233b;

        j(OButtonGroup r3, List<? extends View> r4) {
            List<View> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f34232a = r3;
            this.f34233b = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OButtonGroup.access$finishContentAnimation(this.f34232a);
            OButtonGroup.access$settleChildrenVisualState(this.f34232a, this.f34233b);
            OButtonGroup.access$freezeGroupWidth(this.f34232a, -2);
            OButtonGroup.access$setGroupBlurForAnimation(this.f34232a, 0.0f);
            OButtonGroup.access$markCurrentTargetReached(this.f34232a);
            OButtonGroup.access$dispatchAnimationEndIfIdle(this.f34232a);
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class k extends d.h.b.p implements d.h.a.b<a, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<View> f34234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f34236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f34237d;

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$k$1, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34238a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f34239b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f34240c;

            AnonymousClass1(OButtonGroup r1, int r2, int r3) {
                this.f34238a = r1;
                this.f34239b = r2;
                this.f34240c = r3;
                super(1);
            }

            public final void a(d.h.a.a<d.x> r3) {
                d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "done");
                OButtonGroup.access$startWidthChangeAnimation(this.f34238a, this.f34239b, this.f34240c, r4);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$k$2, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass2 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34241a;

            AnonymousClass2(OButtonGroup r1) {
                this.f34241a = r1;
                super(1);
            }

            public final void a(d.h.a.a<d.x> r4) {
                d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r5, "done");
                OButtonGroup.access$startGroupShadowAnimation(this.f34241a, 1.0f, c.a.f34185a.o().a(), r5, OButtonGroup.access$getContentAnimators$p(this.f34241a));
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$k$3, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass3 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34242a;

            AnonymousClass3(OButtonGroup r1) {
                this.f34242a = r1;
                super(1);
            }

            public final void a(d.h.a.a<d.x> r4) {
                d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r5, "done");
                OButtonGroup.access$startGroupBlurAnimation(this.f34242a, 0.0f, c.a.f34185a.r().a(), r5, OButtonGroup.access$getContentAnimators$p(this.f34242a));
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class a extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34243a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f34244b;

            a(OButtonGroup r1, View r2) {
                this.f34243a = r1;
                this.f34244b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r7) {
                d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "done");
                OButtonGroup r0 = this.f34243a;
                View r1 = this.f34244b;
                OButtonGroup.access$startChildAlphaAnimation(r0, r1, OButtonGroup.access$childTargetAlpha(r0, r1), c.a.f34185a.t().a(), r4, OButtonGroup.access$getContentAnimators$p(this.f34243a));
            }
        }

        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class b extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34245a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f34246b;

            b(OButtonGroup r1, View r2) {
                this.f34245a = r1;
                this.f34246b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r7) {
                d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "done");
                OButtonGroup.access$startChildScaleAnimation(this.f34245a, this.f34246b, 1.0f, c.a.f34185a.s().a(), r4, OButtonGroup.access$getContentAnimators$p(this.f34245a));
            }
        }

        k(List<? extends View> r3, OButtonGroup r4, int r5, int r6) {
            this.f34234a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            this.f34235b = r4;
            this.f34236c = r5;
            this.f34237d = r6;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(a r3) {
            a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(a r6) {
            d.h.b.o.e(r6, "$this$startAnimationBatch");
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f34235b, this.f34236c, this.f34237d), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f34235b), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.f34235b), d.h.a.b.class, "com.obric.aiagent.plugin"));
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f34234a, Iterable.class, "com.obric.aiagent.plugin");
            OButtonGroup r5 = this.f34235b;
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            View r2 = (View) ZeusTransformUtils.preCheckCast(r1.next(), View.class, "com.obric.aiagent.plugin");
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r5, r2), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r5, r2), d.h.a.b.class, "com.obric.aiagent.plugin"));
            goto L4
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class l extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f34248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<View> f34249c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f34250d;

        l(OButtonGroup r3, boolean r4, List<? extends View> r5, d.h.a.a<d.x> r6) {
            List<View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            d.h.a.a<d.x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f34247a = r3;
            this.f34248b = r4;
            this.f34249c = r7;
            this.f34250d = r8;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OButtonGroup.access$setGroupAnimationState$p(this.f34247a, e.f34197a);
            OButtonGroup.access$applyGroupVisualState(this.f34247a, 1.0f, 1.0f, 0.0f);
            this.f34247a.resetPressAnimationState();
            if (this.f34248b == false) goto L5;
            OButtonGroup.access$settleChildrenVisualState(this.f34247a, this.f34249c);
        L5:
            OButtonGroup.access$getGroupAnimators$p(this.f34247a).clear();
            d.h.a.a<d.x> r0 = this.f34250d;
            if (r0 == null) goto L9;
            r0.invoke();
        L9:
            OButtonGroup.access$dispatchGroupAlphaAnimationEnd(this.f34247a);
            OButtonGroup.access$dispatchAnimationEndIfIdle(this.f34247a);
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class m extends d.h.b.p implements d.h.a.b<a, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<View> f34251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f34253c;

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$m$1, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34254a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f34255b;

            AnonymousClass1(OButtonGroup r1, int r2) {
                this.f34254a = r1;
                this.f34255b = r2;
                super(1);
            }

            public final void a(d.h.a.a<d.x> r8) {
                d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r3, "done");
                OButtonGroup.startGroupAlphaAnimation$default(this.f34254a, 1.0f, c.a.f34185a.c(this.f34255b).a(), r3, null, 8, null);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$m$2, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass2 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34256a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f34257b;

            AnonymousClass2(OButtonGroup r1, int r2) {
                this.f34256a = r1;
                this.f34257b = r2;
                super(1);
            }

            public final void a(d.h.a.a<d.x> r8) {
                d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r3, "done");
                OButtonGroup.startGroupScaleAnimation$default(this.f34256a, 1.0f, c.a.f34185a.b(this.f34257b).a(), r3, null, 8, null);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$m$3, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass3 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34258a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f34259b;

            AnonymousClass3(OButtonGroup r1, int r2) {
                this.f34258a = r1;
                this.f34259b = r2;
                super(1);
            }

            public final void a(d.h.a.a<d.x> r8) {
                d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r3, "done");
                OButtonGroup.startGroupBlurAnimation$default(this.f34258a, 0.0f, c.a.f34185a.d(this.f34259b).a(), r3, null, 8, null);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class a extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34260a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f34261b;

            a(OButtonGroup r1, View r2) {
                this.f34260a = r1;
                this.f34261b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r7) {
                d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "done");
                OButtonGroup r0 = this.f34260a;
                View r1 = this.f34261b;
                OButtonGroup.access$startChildAlphaAnimation(r0, r1, OButtonGroup.access$childTargetAlpha(r0, r1), c.a.f34185a.j().a(), r4, OButtonGroup.access$getGroupAnimators$p(this.f34260a));
            }
        }

        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class b extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34262a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f34263b;

            b(OButtonGroup r1, View r2) {
                this.f34262a = r1;
                this.f34263b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r7) {
                d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "done");
                OButtonGroup.access$startChildScaleAnimation(this.f34262a, this.f34263b, 1.0f, c.a.f34185a.i().a(), r4, OButtonGroup.access$getGroupAnimators$p(this.f34262a));
            }
        }

        m(List<? extends View> r3, OButtonGroup r4, int r5) {
            this.f34251a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            this.f34252b = r4;
            this.f34253c = r5;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(a r3) {
            a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(a r6) {
            d.h.b.o.e(r6, "$this$startAnimationBatch");
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f34252b, this.f34253c), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f34252b, this.f34253c), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.f34252b, this.f34253c), d.h.a.b.class, "com.obric.aiagent.plugin"));
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f34251a, Iterable.class, "com.obric.aiagent.plugin");
            OButtonGroup r5 = this.f34252b;
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            View r2 = (View) ZeusTransformUtils.preCheckCast(r1.next(), View.class, "com.obric.aiagent.plugin");
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r5, r2), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r5, r2), d.h.a.b.class, "com.obric.aiagent.plugin"));
            goto L4
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class n extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f34265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f34266c;

        n(OButtonGroup r3, d.h.a.a<d.x> r4, boolean r5) {
            d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f34264a = r3;
            this.f34265b = r6;
            this.f34266c = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            OButtonGroup.access$setGroupAnimationState$p(this.f34264a, e.f34197a);
            this.f34265b.invoke();
            if (this.f34266c == false) goto L5;
            OButtonGroup.access$resetVisualState(this.f34264a);
        L5:
            OButtonGroup.access$getGroupAnimators$p(this.f34264a).clear();
            OButtonGroup.access$dispatchGroupAlphaAnimationEnd(this.f34264a);
            OButtonGroup.access$dispatchAnimationEndIfIdle(this.f34264a);
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class o extends d.h.b.p implements d.h.a.b<a, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<View> f34267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f34269c;

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$o$1, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34270a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f34271b;

            AnonymousClass1(OButtonGroup r1, int r2) {
                this.f34270a = r1;
                this.f34271b = r2;
                super(1);
            }

            public final void a(d.h.a.a<d.x> r8) {
                d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r3, "done");
                OButtonGroup.startGroupAlphaAnimation$default(this.f34270a, 0.0f, c.a.f34185a.f(this.f34271b).a(), r3, null, 8, null);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$o$2, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass2 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34272a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f34273b;

            AnonymousClass2(OButtonGroup r1, int r2) {
                this.f34272a = r1;
                this.f34273b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r8) {
                d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r3, "done");
                OButtonGroup.startGroupScaleAnimation$default(this.f34272a, c.a.f34185a.a(this.f34273b), c.a.f34185a.e(this.f34273b).a(), r3, null, 8, null);
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$o$3, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass3 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34274a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f34275b;

            AnonymousClass3(OButtonGroup r1, int r2) {
                this.f34274a = r1;
                this.f34275b = r2;
                super(1);
            }

            public final void a(d.h.a.a<d.x> r8) {
                d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r3, "done");
                OButtonGroup r0 = this.f34274a;
                OButtonGroup.startGroupBlurAnimation$default(r0, OButtonGroup.access$disappearBlurRadius(r0), c.a.f34185a.g(this.f34275b).a(), r3, null, 8, null);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class a extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34276a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f34277b;

            a(OButtonGroup r1, View r2) {
                this.f34276a = r1;
                this.f34277b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r7) {
                d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "done");
                OButtonGroup.access$startChildAlphaAnimation(this.f34276a, this.f34277b, 0.0f, c.a.f34185a.l().a(), r4, OButtonGroup.access$getGroupAnimators$p(this.f34276a));
            }
        }

        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class b extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34278a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f34279b;

            b(OButtonGroup r1, View r2) {
                this.f34278a = r1;
                this.f34279b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r7) {
                d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "done");
                OButtonGroup.access$startChildScaleAnimation(this.f34278a, this.f34279b, c.a.f34185a.c(), c.a.f34185a.k().a(), r4, OButtonGroup.access$getGroupAnimators$p(this.f34278a));
            }
        }

        o(List<? extends View> r3, OButtonGroup r4, int r5) {
            this.f34267a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            this.f34268b = r4;
            this.f34269c = r5;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(a r3) {
            a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(a r6) {
            d.h.b.o.e(r6, "$this$startAnimationBatch");
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f34268b, this.f34269c), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f34268b, this.f34269c), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.f34268b, this.f34269c), d.h.a.b.class, "com.obric.aiagent.plugin"));
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f34267a, Iterable.class, "com.obric.aiagent.plugin");
            OButtonGroup r5 = this.f34268b;
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            View r2 = (View) ZeusTransformUtils.preCheckCast(r1.next(), View.class, "com.obric.aiagent.plugin");
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r5, r2), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r5, r2), d.h.a.b.class, "com.obric.aiagent.plugin"));
            goto L4
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class p extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f34280a;

        p(d.h.a.a<d.x> r3) {
            this.f34280a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            d.h.a.a<d.x> r0 = this.f34280a;
            if (r0 == null) goto L7;
            r0.invoke();
            return;
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class q extends d.h.b.p implements d.h.a.b<Float, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.a f34281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f34282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f34283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f34284d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34285e;
        final /* synthetic */ float f;
        final /* synthetic */ d.h.a.b<Float, d.x> g;

        q(d.h.b.z.a r3, float r4, boolean r5, boolean r6, OButtonGroup r7, float r8, d.h.a.b<? super Float, d.x> r9) {
            d.h.a.b<Float, d.x> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
            this.f34281a = r3;
            this.f34282b = r4;
            this.f34283c = r5;
            this.f34284d = r6;
            this.f34285e = r7;
            this.f = r8;
            this.g = r10;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return d.x.f38692a;
        }

        public final void a(float r4) {
            if (this.f34281a.f38499a == false) goto L6;
            float r5 = this.f34282b;
        L16:
            this.g.invoke(Float.valueOf(r5));
            return;
        L6:
            if (this.f34283c == false) goto L11;
            if (r4 < this.f34282b) goto L11;
            this.f34281a.f38499a = true;
            r5 = this.f34282b;
        L11:
            if (this.f34284d == true) goto L13;
        L15:
            r5 = OButtonGroup.access$accelerateBoundedAlpha(this.f34285e, r4, this.f, this.f34282b);
            goto L16
        L13:
            if (r4 > this.f34282b) goto L15;
            this.f34281a.f38499a = true;
            r5 = this.f34282b;
            goto L16
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class r extends d.h.b.p implements d.h.a.b<Float, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Float, d.x> f34286a;

        r(d.h.a.b<? super Float, d.x> r3) {
            this.f34286a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return d.x.f38692a;
        }

        public final void a(float r1) {
            this.f34286a.invoke(Float.valueOf(r1));
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class s extends d.h.b.p implements d.h.a.b<Float, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34287a;

        s(View r1) {
            this.f34287a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return d.x.f38692a;
        }

        public final void a(float r1) {
            this.f34287a.setAlpha(r1);
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class t extends d.h.b.p implements d.h.a.b<Float, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34288a;

        t(View r1) {
            this.f34288a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return d.x.f38692a;
        }

        public final void a(float r2) {
            this.f34288a.setScaleX(r2);
            this.f34288a.setScaleY(r2);
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class u extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f34289a;

        u(d.h.a.a<d.x> r3) {
            this.f34289a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }

        public final void a() {
            this.f34289a.invoke();
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class v extends d.h.b.p implements d.h.a.b<a, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<View> f34290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34291b;

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$v$1, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34292a;

            AnonymousClass1(OButtonGroup r1) {
                this.f34292a = r1;
                super(1);
            }

            public final void a(d.h.a.a<d.x> r4) {
                d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r5, "done");
                OButtonGroup.access$startGroupScaleAnimation(this.f34292a, 1.0f, c.a.f34185a.n().a(), r5, OButtonGroup.access$getContentAnimators$p(this.f34292a));
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        /* JADX INFO: renamed from: com.obric.oui.button.OButtonGroup$v$2, reason: invalid class name */
        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class AnonymousClass2 extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34293a;

            AnonymousClass2(OButtonGroup r1) {
                this.f34293a = r1;
                super(1);
            }

            public final void a(d.h.a.a<d.x> r4) {
                d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r5, "done");
                OButtonGroup.access$startGroupBlurAnimation(this.f34293a, 0.0f, c.a.f34185a.r().a(), r5, OButtonGroup.access$getContentAnimators$p(this.f34293a));
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class a extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34294a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f34295b;

            a(OButtonGroup r1, View r2) {
                this.f34294a = r1;
                this.f34295b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r7) {
                d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "done");
                OButtonGroup r0 = this.f34294a;
                View r1 = this.f34295b;
                OButtonGroup.access$startChildAlphaAnimation(r0, r1, OButtonGroup.access$childTargetAlpha(r0, r1), c.a.f34185a.t().a(), r4, OButtonGroup.access$getContentAnimators$p(this.f34294a));
            }
        }

        /* JADX INFO: compiled from: OButtonGroup.kt */
        static final class b extends d.h.b.p implements d.h.a.b<d.h.a.a<? extends d.x>, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OButtonGroup f34296a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f34297b;

            b(OButtonGroup r1, View r2) {
                this.f34296a = r1;
                this.f34297b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(d.h.a.a<? extends d.x> r3) {
                a((d.h.a.a) ZeusTransformUtils.preCheckCast(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }

            public final void a(d.h.a.a<d.x> r7) {
                d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "done");
                OButtonGroup.access$startChildScaleAnimation(this.f34296a, this.f34297b, 1.0f, c.a.f34185a.s().a(), r4, OButtonGroup.access$getContentAnimators$p(this.f34296a));
            }
        }

        v(List<? extends View> r3, OButtonGroup r4) {
            this.f34290a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            this.f34291b = r4;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(a r3) {
            a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(a r6) {
            d.h.b.o.e(r6, "$this$startAnimationBatch");
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f34291b), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f34291b), d.h.a.b.class, "com.obric.aiagent.plugin"));
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f34290a, Iterable.class, "com.obric.aiagent.plugin");
            OButtonGroup r5 = this.f34291b;
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            View r2 = (View) ZeusTransformUtils.preCheckCast(r1.next(), View.class, "com.obric.aiagent.plugin");
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r5, r2), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r5, r2), d.h.a.b.class, "com.obric.aiagent.plugin"));
            goto L4
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class w extends d.h.b.p implements d.h.a.q<String, Object, Object, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Float, d.x> f34298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34299b;

        w(d.h.a.b<? super Float, d.x> r3, OButtonGroup r4) {
            this.f34298a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            this.f34299b = r4;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ d.x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return d.x.f38692a;
        }

        public final void a(String r2, Object r3, Object r4) {
            d.h.b.o.e(r2, "$noName_0");
            d.h.b.o.e(r3, "value");
            d.h.b.o.e(r4, "$noName_2");
            float r5 = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue();
            this.f34298a.invoke(Float.valueOf(r5));
            this.f34299b.invalidate();
            d.h.a.a r1 = OButtonGroup.access$getAnimationUpdateListener$p(this.f34299b);
            if (r1 == null) goto L7;
            r1.invoke();
            return;
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class x extends d.h.b.p implements d.h.a.m<Boolean, Throwable, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<d.x> f34300a;

        x(d.h.a.a<d.x> r3) {
            this.f34300a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ d.x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(boolean r1, Throwable r2) {
            if (r1 == false) goto L5;
            this.f34300a.invoke();
            return;
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class y extends d.h.b.p implements d.h.a.b<Float, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Float, d.x> f34302b;

        y(OButtonGroup r3, d.h.a.b<? super Float, d.x> r4) {
            d.h.a.b<Float, d.x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            this.f34301a = r3;
            this.f34302b = r5;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return d.x.f38692a;
        }

        public final void a(float r2) {
            OButtonGroup.access$setRawGroupAlpha$p(this.f34301a, r2);
            this.f34302b.invoke(Float.valueOf(r2));
            d.h.a.a r1 = OButtonGroup.access$getGroupAlphaAnimationUpdateListener$p(this.f34301a);
            if (r1 == null) goto L7;
            r1.invoke();
            return;
        }
    }

    /* JADX INFO: compiled from: OButtonGroup.kt */
    static final class z extends d.h.b.p implements d.h.a.b<Float, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OButtonGroup f34303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f34304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f34305c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<com.obric.oui.common.style.j> f34306d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<com.obric.oui.common.style.j> f34307e;

        z(OButtonGroup r3, float r4, float r5, List<com.obric.oui.common.style.j> r6, List<com.obric.oui.common.style.j> r7) {
            List<com.obric.oui.common.style.j> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            List<com.obric.oui.common.style.j> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            this.f34303a = r3;
            this.f34304b = r4;
            this.f34305c = r5;
            this.f34306d = r8;
            this.f34307e = r9;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Float r3) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return d.x.f38692a;
        }

        public final void a(float r5) {
            this.f34303a.getContentView().setAlpha(r5);
            float r0 = this.f34304b;
            float r1 = this.f34305c;
            if (r0 != r1) goto L5;
            boolean r2 = true;
        L6:
            float r3 = 1.0f;
            if (r2 == true) goto L10;
            r3 = d.l.n.a((r5 - r1) / (r0 - r1), 0.0f, 1.0f);
        L10:
            this.f34303a.updateContentShadowAlphaTransition(r5, r3, this.f34306d, this.f34307e);
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    static {
        Companion = new c(null);
    }

    public OButtonGroup(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OButtonGroup(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OButtonGroup(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public final void hide() {
        hide$default(this, false, null, 3, null);
    }

    public final void hide(boolean r3) {
        hide$default(this, r3, null, 2, null);
    }

    public final void show() {
        show$default(this, false, null, 3, null);
    }

    public final void show(boolean r3) {
        show$default(this, r3, null, 2, null);
    }

    public final void updateItemViews(List<? extends View> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "views");
        updateItemViews$default(this, r5, false, 2, null);
    }

    public /* synthetic */ OButtonGroup(Context r2, AttributeSet r3, int r4, int r5, int r6, d.h.b.h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r8, r9, r4, r5);
    }

    public static final /* synthetic */ float access$accelerateBoundedAlpha(OButtonGroup r0, float r1, float r2, float r3) {
        return r0.accelerateBoundedAlpha(r1, r2, r3);
    }

    public static final /* synthetic */ void access$applyGroupVisualState(OButtonGroup r0, float r1, float r2, float r3) {
        r0.applyGroupVisualState(r1, r2, r3);
    }

    public static final /* synthetic */ float access$changeBlurRadius(OButtonGroup r0) {
        return r0.changeBlurRadius();
    }

    public static final /* synthetic */ float access$childTargetAlpha(OButtonGroup r0, View r1) {
        return r0.childTargetAlpha(r1);
    }

    public static final /* synthetic */ float access$disappearBlurRadius(OButtonGroup r0) {
        return r0.disappearBlurRadius();
    }

    public static final /* synthetic */ void access$dispatchAnimationEndIfIdle(OButtonGroup r0) {
        r0.dispatchAnimationEndIfIdle();
    }

    public static final /* synthetic */ void access$dispatchGroupAlphaAnimationEnd(OButtonGroup r0) {
        r0.dispatchGroupAlphaAnimationEnd();
    }

    public static final /* synthetic */ void access$finishContentAnimation(OButtonGroup r0) {
        r0.finishContentAnimation();
    }

    public static final /* synthetic */ void access$finishContentChangeIfReady(OButtonGroup r2, List r3, boolean r4, boolean r5) {
        r2.finishContentChangeIfReady((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public static final /* synthetic */ void access$freezeGroupWidth(OButtonGroup r0, int r1) {
        r0.freezeGroupWidth(r1);
    }

    public static final /* synthetic */ d.h.a.a access$getAnimationUpdateListener$p(OButtonGroup r0) {
        return r0.animationUpdateListener;
    }

    public static final /* synthetic */ List access$getContentAnimators$p(OButtonGroup r0) {
        return r0.contentAnimators;
    }

    public static final /* synthetic */ d.h.a.a access$getGroupAlphaAnimationUpdateListener$p(OButtonGroup r0) {
        return r0.groupAlphaAnimationUpdateListener;
    }

    public static final /* synthetic */ List access$getGroupAnimators$p(OButtonGroup r0) {
        return r0.groupAnimators;
    }

    public static final /* synthetic */ float access$hiddenContentScale(OButtonGroup r0, View r1) {
        return r0.hiddenContentScale(r1);
    }

    public static final /* synthetic */ void access$markCurrentTargetReached(OButtonGroup r0) {
        r0.markCurrentTargetReached();
    }

    public static final /* synthetic */ void access$replaceItems(OButtonGroup r2, List r3) {
        r2.replaceItems((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$resetVisualState(OButtonGroup r0) {
        r0.resetVisualState();
    }

    public static final /* synthetic */ void access$setGroupAnimationState$p(OButtonGroup r0, e r1) {
        r0.groupAnimationState = r1;
    }

    public static final /* synthetic */ void access$setGroupBlurForAnimation(OButtonGroup r0, float r1) {
        r0.setGroupBlurForAnimation(r1);
    }

    public static final /* synthetic */ void access$setGroupScaleForAnimation(OButtonGroup r0, float r1) {
        r0.setGroupScaleForAnimation(r1);
    }

    public static final /* synthetic */ void access$setRawGroupAlpha$p(OButtonGroup r0, float r1) {
        r0.rawGroupAlpha = r1;
    }

    public static final /* synthetic */ void access$settleChildrenVisualState(OButtonGroup r2, List r3) {
        r2.settleChildrenVisualState((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$startChildAlphaAnimation(OButtonGroup r8, View r9, float r10, com.obric.common.oea.foundation.animation.g.a r11, d.h.a.a r12, List r13) {
        r8.startChildAlphaAnimation(r9, r10, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$startChildScaleAnimation(OButtonGroup r8, View r9, float r10, com.obric.common.oea.foundation.animation.g.a r11, d.h.a.a r12, List r13) {
        r8.startChildScaleAnimation(r9, r10, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$startContentFadeInPhase(OButtonGroup r2, List r3, d.h.a.a r4) {
        r2.startContentFadeInPhase((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$startGroupAlphaAnimation(OButtonGroup r2, float r3, com.obric.common.oea.foundation.animation.g.a r4, d.h.a.a r5, List r6) {
        r2.startGroupAlphaAnimation(r3, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$startGroupBlurAnimation(OButtonGroup r2, float r3, com.obric.common.oea.foundation.animation.g.a r4, d.h.a.a r5, List r6) {
        r2.startGroupBlurAnimation(r3, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$startGroupScaleAnimation(OButtonGroup r2, float r3, com.obric.common.oea.foundation.animation.g.a r4, d.h.a.a r5, List r6) {
        r2.startGroupScaleAnimation(r3, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$startGroupShadowAnimation(OButtonGroup r2, float r3, com.obric.common.oea.foundation.animation.g.a r4, d.h.a.a r5, List r6) {
        r2.startGroupShadowAnimation(r3, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$startWidthChangeAnimation(OButtonGroup r2, int r3, int r4, d.h.a.a r5) {
        r2.startWidthChangeAnimation(r3, r4, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public OButtonGroup(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "context");
        super(r13, r14, r11, 0, 8, null);
        this.capacity = 5;
        this.groupAnimators = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.contentAnimators = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.contentAnimationState = d.f34192a;
        this.groupAlphaAnimationEndListeners = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.animationEndListeners = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.rawGroupAlpha = 1.0f;
        this.groupScaleForAnimation = 1.0f;
        this.pressScaleForAnimation = 1.0f;
        this.groupAnimationState = e.f34197a;
        setClipChildren(false);
        setClipToPadding(false);
        int[] r0 = R.styleable.OButtonGroup;
        d.h.b.o.c(r0, TAG);
        TypedArray r15 = r13.obtainStyledAttributes(r14, r0, 0, 0);
        d.h.b.o.c(r15, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.minWidth = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OButtonGroup_oui_widgetMinWidth, "styleable", "OButtonGroup_oui_widgetMinWidth"), 0);
        this.itemMargin = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OButtonGroup_oui_widgetInnerItemMargin, "styleable", "OButtonGroup_oui_widgetInnerItemMargin"), 0);
        this.capacity = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OButtonGroup_oui_OButtonGroupCapacity, "styleable", "OButtonGroup_oui_OButtonGroupCapacity"), 5);
        r15.recycle();
    }

    public final void setGroupAlphaAnimationUpdateListener$OUI_standardRelease(d.h.a.a<d.x> r3) {
        this.groupAlphaAnimationUpdateListener = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final void setAnimationUpdateListener$OUI_standardRelease(d.h.a.a<d.x> r3) {
        this.animationUpdateListener = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final void addGroupAlphaAnimationEndListener$OUI_standardRelease(d.h.a.a<d.x> r3) {
        d.h.a.a<d.x> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        this.groupAlphaAnimationEndListeners.add(r4);
    }

    public final void clearGroupAlphaAnimationEndListeners$OUI_standardRelease() {
        this.groupAlphaAnimationEndListeners.clear();
    }

    public final void addAnimationEndListener$OUI_standardRelease(d.h.a.a<d.x> r3) {
        d.h.a.a<d.x> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        if (isAnimating() == true) goto L6;
        r4.invoke();
        return;
    L6:
        this.animationEndListeners.add(r4);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void initContent(Context r3, FrameLayout r4, AttributeSet r5, TypedArray r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "context");
        d.h.b.o.e(r4, "contentView");
        if (r6 != null) goto L5;
        return;
    L5:
        r4.removeAllViews();
        setChangeAlphaWhenPress(false);
        getContentView().setDuplicateParentStateEnabled(false);
        LinearLayout r0 = new LinearLayout(r7);
        r0.setOrientation(0);
        r0.setGravity(17);
        this.itemContainer = r0;
        r4.addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        setWidthMin(this.minWidth);
        getContentView().setWidthMin(this.minWidth);
        updateSingleItemDelegateMode();
        checkVisibility();
        if (getEnableMaterial() == false) goto L9;
        initMaterials(r7, r6);
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.b
    public void setWidthMin(int r1) {
        getLayoutHelper().setWidthMin(r1);
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r8) {
        d.h.b.o.e(r8, "event");
        boolean r1 = true;
        if (this.touchEventBlocked == false) goto L6;
        return true;
    L6:
        if (getItemCount() != 1) goto L8;
        boolean r0 = true;
    L9:
        boolean r3 = super.dispatchTouchEvent(r8);
        if (r0 == false) goto L37;
        boolean r2 = shouldHandlePressAnimation(true);
        int r4 = r8.getActionMasked();
        if (r4 == 0) goto L36;
        if (r4 != 1) goto L15;
    L35:
        getContentView().setPressed(false);
        goto L37
    L15:
        if (r4 == 2) goto L20;
        if (r4 == 3) goto L35;
    L20:
        if (r8.getX() >= 0.0f) goto L22;
    L28:
        boolean r9 = false;
    L29:
        OUIFrameLayout r7 = getContentView();
        if (r2 == false) goto L33;
        if (r9 == false) goto L33;
    L34:
        r7.setPressed(r1);
    L33:
        r1 = false;
        goto L34
    L22:
        if (r8.getX() >= getWidth()) goto L28;
        if (r8.getY() < 0.0f) goto L28;
        if (r8.getY() >= getHeight()) goto L28;
        r9 = true;
        goto L29
    L36:
        getContentView().setPressed(r2);
    L37:
        return r3;
    L8:
        r0 = false;
        goto L9
    }

    public final void setTouchEventBlocked$OUI_standardRelease(boolean r1) {
        this.touchEventBlocked = r1;
    }

    public final boolean isTouchEventBlocked$OUI_standardRelease() {
        return this.touchEventBlocked;
    }

    public final View addItemView(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        View r7 = ZeusTransformUtils.inflate(LayoutInflater.from(r6), r5, null, false, "com.obric.aiagent.plugin");
        d.h.b.o.c(r7, "itemView");
        addItemView(r7, new ViewGroup.MarginLayoutParams(-2, -2));
        return r7;
    }

    public final void addItemView(View r2, ViewGroup.MarginLayoutParams r3) {
        d.h.b.o.e(r2, "itemView");
        d.h.b.o.e(r3, "layoutParams");
        addItemView(r2, r3, -1);
    }

    public final void addItemView(View r2, ViewGroup.MarginLayoutParams r3, int r4) {
        d.h.b.o.e(r2, "itemView");
        d.h.b.o.e(r3, "layoutParams");
        addItemView(r2, r3, r4, false);
    }

    public final void addItemView(View r3, ViewGroup.MarginLayoutParams r4, int r5, boolean r6) {
        d.h.b.o.e(r3, "itemView");
        d.h.b.o.e(r4, "layoutParams");
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        List<? extends View> r7 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(currentItemViews(), Collection.class, "com.obric.aiagent.plugin"));
        if (r5 >= 0) goto L5;
    L6:
        r5 = r7.size();
    L7:
        r7.add(r5, r3);
        updateItemViews(r7, r6);
        return;
    L5:
        if (r5 <= r7.size()) goto L7;
        goto L6
    }

    public final void removeItemView() {
        removeItemView(false);
    }

    public final void removeItemView(boolean r4) {
        List<? extends View> r0 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(currentItemViews(), Collection.class, "com.obric.aiagent.plugin"));
        if (r0.isEmpty() == false) goto L6;
        com.obric.oui.d.a.b.d(TAG, "itemContainer is empty");
        return;
    L6:
        r0.remove(d.a.p.b(r0));
        updateItemViews(r0, r4);
    }

    public final void removeItemViewAt(int r2) {
        removeItemViewAt(r2, false);
    }

    public final void removeItemViewAt(int r4, boolean r5) {
        List<? extends View> r0 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(currentItemViews(), Collection.class, "com.obric.aiagent.plugin"));
        if (r4 >= 0) goto L5;
        return;
    L5:
        if (r4 >= r0.size()) goto L10;
        r0.remove(r4);
        updateItemViews(r0, r5);
        return;
    }

    public final void removeAllItemViews() {
        removeAllItemViews(false);
    }

    public final void removeAllItemViews(boolean r2) {
        updateItemViews(d.a.p.b(), r2);
    }

    public static /* synthetic */ void hide$default(OButtonGroup r1, boolean r2, d.h.a.a r3, int r4, Object r5) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = null;
    L8:
        r1.hide(r2, r6);
    }

    public final void hide(boolean r3, d.h.a.a<d.x> r4) {
        animateGroupVisible(false, r3, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ void show$default(OButtonGroup r1, boolean r2, d.h.a.a r3, int r4, Object r5) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = null;
    L8:
        r1.show(r2, r6);
    }

    public final void show(boolean r3, d.h.a.a<d.x> r4) {
        animateGroupVisible(true, r3, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public final int getItemCount() {
        LinearLayout r0 = this.itemContainer;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getChildCount();
    }

    public final View getItemViewAt(int r1) {
        LinearLayout r0 = this.itemContainer;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getChildAt(r1);
    }

    public final void setItemEnabled(int r2, boolean r3) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 > (getItemCount() - 1)) goto L12;
        View r4 = getItemViewAt(r2);
        if (r4 == null) goto L9;
        r4.setEnabled(r3);
    L9:
        updateGroupEnabledByItems();
        updateSingleItemDelegateMode();
        return;
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r6) {
        if (isAnimating() == false) goto L5;
        b r0 = saveAnimationState();
    L6:
        super.setEnabled(r6);
        LinearLayout r1 = this.itemContainer;
        if (r1 == null) goto L13;
        r1.setEnabled(r6);
        Iterator<View> r2 = androidx.core.view.ab.b((ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.aiagent.plugin")).a();
    L11:
        if (r2.hasNext() == false) goto L13;
        ((View) ZeusTransformUtils.preCheckCast(r2.next(), View.class, "com.obric.aiagent.plugin")).setEnabled(r6);
    L13:
        updateSingleItemDelegateMode();
        if (r0 == null) goto L19;
        restoreVisualStateOnly(r0);
        return;
    L19:
        return;
    L5:
        r0 = null;
        goto L6
    }

    private final void updateGroupEnabledByItems() {
        List<View> r0 = currentItemViews();
        boolean r2 = true;
        if (r0.isEmpty() == true) goto L19;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L7;
    L9:
        Iterator r3 = r1.iterator();
    L11:
        if (r3.hasNext() == false) goto L8;
        if (((View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.aiagent.plugin")).isEnabled() == false) goto L11;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L19;
        r2 = false;
    L8:
        r4 = false;
        goto L15
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
    L19:
        if (isEnabled() != r2) goto L22;
        return;
    L22:
        if (isAnimating() == false) goto L24;
        b r5 = saveAnimationState();
    L25:
        super.setEnabled(r2);
        LinearLayout r6 = this.itemContainer;
        if (r6 == null) goto L29;
        r6.setEnabled(r2);
    L29:
        if (r5 == null) goto L36;
        restoreVisualStateOnly(r5);
        return;
    L36:
        return;
    L24:
        r5 = null;
        goto L25
    }

    private final void checkVisibility() {
        if (getItemCount() != 0) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
    }

    private final void updateSingleItemDelegateMode() {
        LinearLayout r0 = this.itemContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (r0.getChildCount() != 1) goto L17;
        View r1 = r0.getChildAt(0);
        if (this.singleItemView == r1) goto L10;
        restoreSingleItemViewState();
        this.singleItemView = r1;
    L10:
        d.h.b.o.c(r1, "only");
        applySingleItemPressEffectSuppression(r1);
        OUIFrameLayout r3 = getContentView();
        if (isEnabled() == true) goto L13;
    L15:
        r2 = false;
    L16:
        r3.setChangeAlphaWhenPress(r2);
        return;
    L13:
        if (r1.isEnabled() == false) goto L15;
    L17:
        getContentView().setChangeAlphaWhenPress(false);
        restoreSingleItemViewState();
    }

    private final void restoreSingleItemViewState() {
        View r0 = this.singleItemView;
        if (r0 != null) goto L5;
    L13:
        this.singleItemView = null;
        this.singleItemSuppressPressEffectApplied = false;
        return;
    L5:
        if (this.singleItemSuppressPressEffectApplied == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.common.style.a.class) == false) goto L9;
        com.obric.oui.common.style.a r1 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
    L10:
        if (r1 == null) goto L13;
        r1.setChangeAlphaWhenPress(true);
        goto L13
    L9:
        r1 = null;
        goto L10
    }

    private final void applySingleItemPressEffectSuppression(View r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.common.style.a.class) == false) goto L5;
        com.obric.oui.common.style.a r4 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        r4.setChangeAlphaWhenPress(false);
        this.singleItemSuppressPressEffectApplied = true;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static /* synthetic */ void updateItemViews$default(OButtonGroup r1, List r2, boolean r3, int r4, Object r5) {
        List<? extends View> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r1.updateItemViews(r6, r3);
    }

    public final void updateItemViews(List<? extends View> r6, boolean r7) {
        List<? extends View> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "views");
        LinearLayout r0 = this.itemContainer;
        if (r0 != null) goto L7;
        OButtonGroup r5 = (OButtonGroup) ZeusTransformUtils.preCheckCast(this, OButtonGroup.class, "com.obric.aiagent.plugin");
        com.obric.oui.d.a.b.e(TAG, "itemContainer is null");
        return;
    L7:
        if (r8.size() <= this.capacity) goto L9;
        com.obric.oui.d.a.b.d(TAG, "views size exceeds capacity: " + this.capacity + ", truncated");
        r8 = d.a.p.c((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin"), this.capacity);
    L9:
        int r1 = r0.getChildCount();
        int r2 = r8.size();
        List<? extends Object> r3 = itemKeys(r8);
        List<Object> r4 = itemKeys(currentItemViews());
        if (d.h.b.o.a(r3, r4) == false) goto L16;
        if (isCurrentTargetVisuallySettled() == false) goto L16;
        applyCurrentItemEnabledStates(r8);
        return;
    L16:
        if (isAnimating() == true) goto L18;
    L21:
        if (r7 == true) goto L24;
        cancelAnimationInternal(true);
        replaceItems(r8);
        resetVisualState();
        checkVisibility();
        markCurrentTargetReached();
        return;
    L24:
        this.runningTargetItemKeys = r3;
        if (d.h.b.o.a(r3, r4) == true) goto L27;
    L30:
        dispatchTransition(r1, r2, r8);
        return;
    L27:
        if (isCurrentTargetVisuallySettled() == true) goto L30;
        resumeCurrentTargetAnimation();
        return;
    L18:
        if (d.h.b.o.a(r3, this.runningTargetItemKeys) == false) goto L21;
        applyCurrentItemEnabledStates(r8);
    }

    public final void cancelAnimation() {
        cancelAnimationInternal(true);
    }

    public final boolean isAnimating() {
        if (this.groupAnimationState == e.f34197a) goto L5;
    L8:
        return true;
    L5:
        if (this.contentAnimationState != d.f34192a) goto L8;
        return false;
    }

    public final int measureTargetItemViewsWidth(List<? extends View> r3) {
        List<? extends View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "views");
        return measureTargetWidth(r4);
    }

    public final float getRawGroupAlphaForTitleBarTransition$OUI_standardRelease() {
        return this.rawGroupAlpha;
    }

    @Override // com.obric.oui.button.OShadowFrame
    public float getCurrentPressScaleForAnimation() {
        return this.pressScaleForAnimation;
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void applyPressScaleForAnimation(float r1) {
        this.pressScaleForAnimation = r1;
        applyCombinedGroupScale();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public boolean shouldHandlePressAnimation(boolean r2) {
        if (this.groupAnimationState == e.f34197a) goto L5;
    L9:
        return false;
    L5:
        if (this.rawGroupAlpha < 1.0f) goto L9;
        if (isSingleItemPressEnabled() == false) goto L9;
        return true;
    }

    private final boolean isSingleItemPressEnabled() {
        if (getItemCount() != 1) goto L12;
        View r3 = getItemViewAt(0);
        if (r3 != null) goto L8;
    L6:
        boolean r4 = false;
    L10:
        if (r4 == true) goto L12;
        return false;
    L8:
        if (r3.isEnabled() != true) goto L6;
        r4 = true;
    L12:
        return true;
    }

    public final b saveAnimationState() {
        LinearLayout r1 = this.itemContainer;
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        int r2 = 0;
        int r3 = r1.getChildCount();
    L5:
        if (r2 >= r3) goto L7;
        int r4 = r2 + 1;
        View r5 = r1.getChildAt(r2);
        r10.add(new f(r5.getTag(), r5.getVisibility(), r5.getAlpha(), r5.getScaleX(), r5.getScaleY()));
        r2 = r4;
    L7:
        int r6 = getVisibility();
        float r7 = getContentView().getAlpha();
        float r8 = this.groupScaleForAnimation;
        float r9 = this.currentGroupBlur;
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 != null) goto L10;
        int r11 = -2;
    L12:
        return new b(r6, r7, r8, r8, r9, r11, r10);
    L10:
        r11 = r0.width;
        goto L12
    }

    public final void restoreAnimationState(b r7, d.h.a.b<? super f, ? extends View> r8) {
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "state");
        d.h.b.o.e(r9, "itemFactory");
        cancelAnimationInternal(true);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7.g(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        f r3 = (f) ZeusTransformUtils.preCheckCast(r1.next(), f.class, "com.obric.aiagent.plugin");
        View r4 = (View) ZeusTransformUtils.preCheckCast(r9.invoke(r3), View.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L8;
        r4 = null;
    L9:
        if (r4 == null) goto L4;
        r2.add(r4);
        goto L4
    L8:
        r4.setVisibility(r3.b());
        r4.setAlpha(r3.c());
        r4.setScaleX(r3.d());
        r4.setScaleY(r3.e());
        goto L9
    L11:
        replaceItems((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"));
        markCurrentTargetReached();
        freezeGroupWidth(r7.f());
        setVisibility(r7.a());
        applyGroupVisualState(r7.b(), r7.c(), r7.e());
        updateSingleItemDelegateMode();
    }

    private final void restoreVisualStateOnly(b r6) {
        setVisibility(r6.a());
        applyGroupVisualState(r6.b(), r6.c(), r6.e());
        freezeGroupWidth(r6.f());
        LinearLayout r5 = this.itemContainer;
        if (r5 == null) goto L16;
        int r0 = 0;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.g(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r7.hasNext() == false) goto L20;
        Object r2 = r7.next();
        int r3 = r0 + 1;
        if (r0 >= 0) goto L11;
        d.a.p.c();
    L11:
        f r4 = (f) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.aiagent.plugin");
        View r1 = r5.getChildAt(r0);
        if (r1 == null) goto L15;
        r1.setVisibility(r4.b());
        r1.setAlpha(r4.c());
        r1.setScaleX(r4.d());
        r1.setScaleY(r4.e());
    L15:
        r0 = r3;
        goto L7
    L20:
        return;
    }

    private final List<View> currentItemViews() {
        LinearLayout r4 = this.itemContainer;
        if (r4 == null) goto L5;
        ArrayList r0 = new ArrayList(r4.getChildCount());
        int r1 = 0;
        int r2 = r4.getChildCount();
    L7:
        if (r1 >= r2) goto L10;
        int r3 = r1 + 1;
        r0.add(r4.getChildAt(r1));
        r1 = r3;
        goto L7
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L5:
        return d.a.p.b();
    }

    private final void applyCurrentItemEnabledStates(List<? extends View> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        LinearLayout r0 = this.itemContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 0;
        int r3 = Math.min(r0.getChildCount(), r9.size());
    L6:
        if (r2 >= r3) goto L8;
        int r4 = r2 + 1;
        r0.getChildAt(r2).setEnabled(((View) ZeusTransformUtils.preCheckCast(r9.get(r2), View.class, "com.obric.aiagent.plugin")).isEnabled());
        r2 = r4;
        goto L6
    L8:
        updateGroupEnabledByItems();
        updateSingleItemDelegateMode();
    }

    private final List<Object> itemKeys(List<? extends View> r4) {
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r6.next(), View.class, "com.obric.aiagent.plugin");
        Object r2 = r1.getTag();
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        r5.add(r1);
        goto L4
    L11:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
    }

    private final void markCurrentTargetReached() {
        this.runningTargetItemKeys = null;
    }

    private final void replaceItems(List<? extends View> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        LinearLayout r0 = this.itemContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeAllViews();
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r3 = 0;
    L7:
        if (r12.hasNext() == false) goto L27;
        Object r4 = r12.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L11;
        d.a.p.c();
    L11:
        View r6 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin");
        ViewParent r7 = r6.getParent();
        ViewGroup.MarginLayoutParams r8 = null;
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.class) == false) goto L14;
        ViewGroup r9 = (ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.aiagent.plugin");
    L15:
        if (r9 == null) goto L18;
        r9.removeView(r6);
    L18:
        ensureItemMinimumWidth(r6);
        ViewGroup.LayoutParams r13 = r6.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r13, ViewGroup.MarginLayoutParams.class) == false) goto L21;
        r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L21:
        if (r8 != null) goto L23;
        r8 = new ViewGroup.MarginLayoutParams(-2, -2);
    L23:
        if (r3 != 0) goto L25;
        int r14 = 0;
    L26:
        r8.setMarginStart(r14);
        r0.addView(r6, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r3 = r5;
        goto L7
    L25:
        r14 = this.itemMargin;
        goto L26
    L14:
        r9 = null;
        goto L15
    L27:
        updateSingleItemDelegateMode();
        checkVisibility();
    }

    private final void resetVisualState() {
        applyGroupVisualState(1.0f, 1.0f, 0.0f);
        resetChildrenVisualState();
    }

    private final void resetChildrenVisualState() {
        freezeGroupWidth(-2);
        LinearLayout r0 = this.itemContainer;
        if (r0 == null) goto L8;
        int r1 = 0;
        int r2 = r0.getChildCount();
    L6:
        if (r1 >= r2) goto L10;
        int r3 = r1 + 1;
        View r4 = r0.getChildAt(r1);
        d.h.b.o.c(r4, "child");
        resetChildAlpha(r4);
        r4.setScaleX(1.0f);
        r4.setScaleY(1.0f);
        r1 = r3;
        goto L6
    L10:
        return;
    }

    private final void resetChildAlpha(View r1) {
        if (r1.isEnabled() == false) goto L5;
        r1.setAlpha(1.0f);
        return;
    L5:
        r1.setEnabled(false);
    }

    private final float childTargetAlpha(View r2) {
        if (r2.isEnabled() == false) goto L6;
        return 1.0f;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.common.style.a.class) == true) goto L8;
        return 1.0f;
    L8:
        float r1 = r2.getAlpha();
        r2.setAlpha(1.0f);
        r2.setEnabled(false);
        float r0 = r2.getAlpha();
        r2.setAlpha(r1);
        return r0;
    }

    private final boolean isChildAlphaSettled(View r2) {
        if (Math.abs(r2.getAlpha() - childTargetAlpha(r2)) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isCurrentTargetVisuallySettled() {
        if (getItemCount() == 0) goto L5;
        LinearLayout r0 = this.itemContainer;
        if (r0 != null) goto L13;
        return true;
    L13:
        if (getVisibility() == 0) goto L15;
    L41:
        return false;
    L15:
        if (needsGroupVisibleRecovery() == true) goto L41;
        ViewGroup.LayoutParams r3 = getLayoutParams();
        if (r3 != null) goto L20;
        int r4 = -2;
    L21:
        if (r4 == (-2)) goto L23;
        return false;
    L23:
        int r5 = r0.getChildCount();
        int r6 = 0;
    L24:
        if (r6 >= r5) goto L40;
        int r7 = r6 + 1;
        View r8 = r0.getChildAt(r6);
        d.h.b.o.c(r8, "child");
        if (isChildAlphaSettled(r8) == false) goto L39;
        if (r8.getScaleX() != 1.0f) goto L30;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L39;
        if (r8.getScaleY() != 1.0f) goto L35;
        boolean r10 = true;
    L36:
        if (r10 == false) goto L39;
        r6 = r7;
        goto L24
    L35:
        r10 = false;
        goto L36
    L30:
        r9 = false;
    L39:
        return false;
    L40:
        return true;
    L20:
        r4 = r3.width;
        goto L21
    L5:
        if (getVisibility() == 0) goto L8;
        return true;
    L8:
        return false;
    }

    private final void resumeCurrentTargetAnimation() {
        List<View> r0 = currentItemViews();
        if (r0.isEmpty() == false) goto L6;
        resetVisualState();
        checkVisibility();
        return;
    L6:
        cancelAnimationInternal$default(this, false, 1, null);
        if (needsGroupVisibleRecovery() == false) goto L9;
    L10:
        animateGroupAppear$default(this, false, null, 2, null);
    L12:
        if (needsContentVisibleRecovery() == false) goto L15;
        animateContentSettle(r0);
        return;
    L15:
        return;
    L9:
        if (getVisibility() == 0) goto L12;
        goto L10
    }

    private final boolean needsContentVisibleRecovery() {
        LinearLayout r0 = this.itemContainer;
        if (r0 != null) goto L5;
        return false;
    L5:
        ViewGroup.LayoutParams r2 = getLayoutParams();
        if (r2 != null) goto L8;
        int r3 = -2;
    L10:
        if (r3 == (-2)) goto L12;
        return true;
    L12:
        int r4 = r0.getChildCount();
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L29;
        int r6 = r5 + 1;
        View r7 = r0.getChildAt(r5);
        d.h.b.o.c(r7, "child");
        if (isChildAlphaSettled(r7) == false) goto L28;
        if (r7.getScaleX() != 1.0f) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L28;
        if (r7.getScaleY() != 1.0f) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == false) goto L28;
        r5 = r6;
        goto L13
    L24:
        r9 = false;
        goto L25
    L19:
        r8 = false;
    L28:
        return true;
    L29:
        return false;
    L8:
        r3 = r2.width;
        goto L10
    }

    static /* synthetic */ void cancelAnimationInternal$default(OButtonGroup r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.cancelAnimationInternal(r1);
    }

    private final void cancelAnimationInternal(boolean r2) {
        cancelGroupAnimationInternal();
        cancelContentAnimationInternal();
        this.groupAlphaAnimationEndListeners.clear();
        this.animationEndListeners.clear();
        if (r2 == false) goto L6;
        this.runningTargetItemKeys = null;
        return;
    }

    private final void cancelContentAnimationInternal() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.contentAnimators, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.obric.common.oea.foundation.animation.manager.d.a((com.obric.common.oea.foundation.animation.manager.d) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.common.oea.foundation.animation.manager.d.class, "com.obric.aiagent.plugin"), false, 1, null);
        goto L4
    L6:
        finishContentAnimation();
    }

    private final void startContentAnimation(d r1) {
        this.contentAnimationState = r1;
        this.contentAnimators.clear();
    }

    private final void finishContentAnimation() {
        this.contentAnimators.clear();
        this.contentAnimationState = d.f34192a;
    }

    private final void dispatchTransition(int r3, int r4, List<? extends View> r5) {
        List<? extends View> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r4 != 0) goto L6;
        transitionToEmpty();
        return;
    L6:
        if (r3 != 0) goto L9;
        transitionFromEmpty(r6);
        return;
    L9:
        transitionBetweenNonEmpty(r6);
    }

    private final void transitionToEmpty() {
        if (this.groupAnimationState != e.f34199c) goto L5;
        return;
    L5:
        cancelContentAnimationInternal();
        cancelGroupAnimationInternal();
        animateGroupDisappear$default(this, (d.h.a.a) ZeusTransformUtils.preCheckCast(new ai(this), d.h.a.a.class, "com.obric.aiagent.plugin"), false, false, 6, null);
    }

    private final void transitionFromEmpty(List<? extends View> r5) {
        List<? extends View> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        cancelAnimationInternal$default(this, false, 1, null);
        replaceItems(r6);
        animateGroupAppear(true, (d.h.a.a) ZeusTransformUtils.preCheckCast(new ah(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final void transitionBetweenNonEmpty(List<? extends View> r3) {
        List<? extends View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (this.groupAnimationState == e.f34197a) goto L5;
        cancelGroupAnimationInternal();
    L5:
        cancelContentAnimationInternal();
        animateContentChange(r4, needsGroupVisibleRecovery());
    }

    private final void animateGroupVisible(boolean r7, boolean r8, d.h.a.a<d.x> r9) {
        d.h.a.a<d.x> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L5;
        float r3 = 1.0f;
    L6:
        if (r7 == false) goto L8;
        e r4 = e.f34198b;
    L10:
        if (this.groupAnimationState != r4) goto L12;
        return;
    L12:
        cancelPressAnimationForGroupTransition();
        cancelGroupAnimationInternal();
        clearGroupAlphaAnimationEndListeners$OUI_standardRelease();
        if (r8 == true) goto L17;
        animateGroupVisible$finishWithoutAnimation(r7, this, r10);
        return;
    L17:
        if (getContentView().getAlpha() != r3) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == false) goto L28;
        if (r7 == false) goto L23;
        applyGroupVisualState(1.0f, 1.0f, 0.0f);
        resetPressAnimationState();
    L23:
        if (r10 == null) goto L35;
        r10.invoke();
        return;
    L35:
        return;
    L28:
        if (this.itemContainer != null) goto L31;
        animateGroupVisible$finishWithoutAnimation(r7, this, r10);
        return;
    L31:
        if (r7 == false) goto L33;
        animateGroupAppear(false, r10);
        return;
    L33:
        animateGroupDisappear((d.h.a.a) ZeusTransformUtils.preCheckCast(new p(r10), d.h.a.a.class, "com.obric.aiagent.plugin"), false, false);
        return;
    L19:
        r11 = false;
        goto L20
    L8:
        r4 = e.f34199c;
        goto L10
    L5:
        r3 = 0.0f;
        goto L6
    }

    private static final void animateGroupVisible$finishWithoutAnimation(boolean r2, OButtonGroup r3, d.h.a.a<d.x> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r2 == false) goto L5;
        r3.applyGroupVisualState(1.0f, 1.0f, 0.0f);
        r3.resetPressAnimationState();
    L6:
        if (r5 == null) goto L10;
        r5.invoke();
        return;
    L10:
        return;
    L5:
        r3.setGroupAlpha(0.0f);
        goto L6
    }

    private final void cancelGroupAnimationInternal() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.groupAnimators, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.obric.common.oea.foundation.animation.manager.d.a((com.obric.common.oea.foundation.animation.manager.d) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.common.oea.foundation.animation.manager.d.class, "com.obric.aiagent.plugin"), false, 1, null);
        goto L4
    L6:
        this.groupAnimators.clear();
        this.groupAnimationState = e.f34197a;
    }

    static /* synthetic */ void animateGroupAppear$default(OButtonGroup r1, boolean r2, d.h.a.a r3, int r4, Object r5) {
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.animateGroupAppear(r2, r6);
    }

    private final void animateGroupAppear(boolean r6, d.h.a.a<d.x> r7) {
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        cancelPressAnimationForGroupTransition();
        if (getContentView().getAlpha() > 0.0f) goto L5;
        resetPressAnimationState();
    L5:
        boolean r0 = false;
        setVisibility(0);
        if (r6 == false) goto L8;
        applyGroupVisualState(0.0f, c.a.f34185a.a(), appearBlurRadius());
        prepareChildrenForAppear(currentItemViews());
    L8:
        LinearLayout r2 = this.itemContainer;
        if (r2 != null) goto L11;
        return;
    L11:
        Integer r3 = Integer.valueOf(r2.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L14;
        r0 = true;
    L14:
        if (r0 == true) goto L17;
        r3 = null;
    L17:
        if (r3 != null) goto L19;
        int r1 = r2.getMeasuredWidth();
    L20:
        if (r6 == false) goto L22;
        List<View> r4 = currentItemViews();
    L23:
        this.groupAnimationState = e.f34198b;
        this.groupAnimators.clear();
        startAnimationBatch((d.h.a.a) ZeusTransformUtils.preCheckCast(new l(this, r6, r4, r8), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new m(r4, this, r1), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L22:
        r4 = d.a.p.b();
        goto L23
    L19:
        r1 = r3.intValue();
        goto L20
    }

    static /* synthetic */ void animateGroupDisappear$default(OButtonGroup r1, d.h.a.a r2, boolean r3, boolean r4, int r5, Object r6) {
        d.h.a.a<d.x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = true;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = true;
    L8:
        r1.animateGroupDisappear(r7, r3, r4);
    }

    private final void animateGroupDisappear(d.h.a.a<d.x> r5, boolean r6, boolean r7) {
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        LinearLayout r0 = this.itemContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        Integer r2 = Integer.valueOf(r0.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        r2 = null;
    L12:
        if (r2 != null) goto L14;
        int r1 = r0.getMeasuredWidth();
    L15:
        if (r7 == false) goto L17;
        List<View> r9 = currentItemViews();
    L18:
        cancelPressAnimationForGroupTransition();
        this.groupAnimationState = e.f34199c;
        this.groupAnimators.clear();
        startAnimationBatch((d.h.a.a) ZeusTransformUtils.preCheckCast(new n(this, r8, r6), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new o(r9, this, r1), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L17:
        r9 = d.a.p.b();
        goto L18
    L14:
        r1 = r2.intValue();
        goto L15
    L8:
        r3 = false;
        goto L9
    }

    private final void cancelPressAnimationForGroupTransition() {
        getContentView().setPressed(false);
        cancelPressAnimation();
    }

    static /* synthetic */ void animateContentChange$default(OButtonGroup r1, List r2, boolean r3, int r4, Object r5) {
        List<? extends View> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        r1.animateContentChange(r6, r3);
    }

    private final void animateContentChange(List<? extends View> r10, boolean r11) {
        List<? extends View> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List<View> r5 = currentItemViews();
        Integer r0 = Integer.valueOf(getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L11;
        int r1 = getMeasuredWidth();
    L12:
        int r7 = measureTargetWidth(r12);
        freezeGroupWidth(r1);
        startContentAnimation(d.f34193b);
        d.h.b.z.a r3 = new d.h.b.z.a();
        d.h.b.z.a r4 = new d.h.b.z.a();
        startWidthChangeAnimation(r1, r7, (d.h.a.a) ZeusTransformUtils.preCheckCast(new g(r3, this, r12, r4), d.h.a.a.class, "com.obric.aiagent.plugin"));
        if (r11 == false) goto L15;
        setVisibility(0);
    L15:
        startAnimationBatch((d.h.a.a) ZeusTransformUtils.preCheckCast(new h(this, r12, r4, r3), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new i(r11, !r11, r5, this, r7), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        r1 = r0.intValue();
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    private final void finishContentChangeIfReady(List<? extends View> r3, boolean r4, boolean r5) {
        List<? extends View> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r4 == false) goto L8;
        if (r5 == false) goto L9;
        finishContentAnimation();
        settleChildrenVisualState(r6);
        freezeGroupWidth(-2);
        setGroupScaleForAnimation(1.0f);
        setGroupBlurForAnimation(0.0f);
        markCurrentTargetReached();
        dispatchAnimationEndIfIdle();
        return;
    L9:
        return;
    }

    private final void replaceItemsForFadeIn(List<? extends View> r4) {
        List<? extends View> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        replaceItems(r5);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        View r0 = (View) ZeusTransformUtils.preCheckCast(r6.next(), View.class, "com.obric.aiagent.plugin");
        r0.setAlpha(0.0f);
        float r2 = hiddenContentScale(r0);
        r0.setScaleX(r2);
        r0.setScaleY(r2);
        goto L4
    }

    private final void startContentFadeInPhase(List<? extends View> r3, d.h.a.a<d.x> r4) {
        List<? extends View> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        replaceItemsForFadeIn(r5);
        this.contentAnimationState = d.f34194c;
        startAnimationBatch(r6, (d.h.a.b) ZeusTransformUtils.preCheckCast(new v(r5, this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final void animateContentSettle(List<? extends View> r6) {
        List<? extends View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        Integer r0 = Integer.valueOf(getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L11;
        int r1 = getMeasuredWidth();
    L12:
        int r3 = measureTargetWidth(r7);
        freezeGroupWidth(r1);
        startContentAnimation(d.f34195d);
        startAnimationBatch((d.h.a.a) ZeusTransformUtils.preCheckCast(new j(this, r7), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new k(r7, this, r1, r3), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        r1 = r0.intValue();
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    private final int measureTargetWidth(List<? extends View> r3) {
        List<? extends View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r4.isEmpty() == false) goto L6;
        return 0;
    L6:
        int r0 = getContentContainer().getPaddingLeft() + getContentContainer().getPaddingRight();
        return Math.max(measureTargetContentWidth(r4) + r0, this.minWidth);
    }

    private final int measureTargetContentWidth(List<? extends View> r9) {
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r10.hasNext() == false) goto L12;
        Object r4 = r10.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        d.a.p.c();
    L8:
        View r6 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin");
        ensureItemMinimumWidth(r6);
        r6.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r2 = r2 + r6.getMeasuredWidth();
        if (r3 <= 0) goto L11;
        r2 = r2 + this.itemMargin;
    L11:
        r3 = r5;
        goto L4
    L12:
        return r2;
    }

    private final void ensureItemMinimumWidth(View r2) {
        int r1 = r2.getMinimumHeight();
        if (r1 > 0) goto L5;
        return;
    L5:
        if (r2.getMinimumWidth() >= r1) goto L9;
        r2.setMinimumWidth(r1);
        return;
    }

    private final boolean needsGroupVisibleRecovery() {
        if (getContentView().getAlpha() < 1.0f) goto L17;
        if (getScaleX() != 1.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L17;
        if (getScaleY() != 1.0f) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L17;
        if (this.currentGroupBlur > 0.0f) goto L17;
        return false;
    L12:
        r1 = false;
        goto L13
    L7:
        r0 = false;
    L17:
        return true;
    }

    private final void setGroupAlpha(float r2) {
        this.rawGroupAlpha = r2;
        getContentView().setAlpha(r2);
        setContentShadowAlphaProgress(r2);
    }

    private final void applyGroupVisualState(float r1, float r2, float r3) {
        setGroupAlpha(r1);
        this.groupScaleForAnimation = r2;
        applyCombinedGroupScale();
        setGroupBlurForAnimation(r3);
    }

    private final void startAnimationBatch(d.h.a.a<d.x> r2, d.h.a.b<? super a, d.x> r3) {
        d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        a r5 = new a(r1);
        r4.invoke(r5);
        r5.a();
    }

    static /* synthetic */ void startGroupAlphaAnimation$default(OButtonGroup r1, float r2, com.obric.common.oea.foundation.animation.g.a r3, d.h.a.a r4, List r5, int r6, Object r7) {
        com.obric.common.oea.foundation.animation.g.a<Float> r8 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        List<com.obric.common.oea.foundation.animation.manager.d> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r10 = r1.groupAnimators;
    L5:
        r1.startGroupAlphaAnimation(r2, r8, r9, r10);
    }

    private final void startGroupAlphaAnimation(float r14, com.obric.common.oea.foundation.animation.g.a<Float> r15, d.h.a.a<d.x> r16, List<com.obric.common.oea.foundation.animation.manager.d> r17) {
        com.obric.common.oea.foundation.animation.g.a<Float> r8 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.a.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        float r11 = getContentView().getAlpha();
        r10.add(startFloatAnimation(r11, r14, r8, 0.390625f, (d.h.a.b) ZeusTransformUtils.preCheckCast(new y(this, boundedAlphaUpdater(r11, r14, (d.h.a.b) ZeusTransformUtils.preCheckCast(new z(this, r14, r11, currentShadowSnapshot(), normalShadowSnapshotWithAlphaProgress(r14)), d.h.a.b.class, "com.obric.aiagent.plugin"))), d.h.a.b.class, "com.obric.aiagent.plugin"), r9));
    }

    static /* synthetic */ void startGroupScaleAnimation$default(OButtonGroup r1, float r2, com.obric.common.oea.foundation.animation.g.a r3, d.h.a.a r4, List r5, int r6, Object r7) {
        com.obric.common.oea.foundation.animation.g.a<Float> r8 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        List<com.obric.common.oea.foundation.animation.manager.d> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r10 = r1.groupAnimators;
    L5:
        r1.startGroupScaleAnimation(r2, r8, r9, r10);
    }

    private final void startGroupScaleAnimation(float r10, com.obric.common.oea.foundation.animation.g.a<Float> r11, d.h.a.a<d.x> r12, List<com.obric.common.oea.foundation.animation.manager.d> r13) {
        com.obric.common.oea.foundation.animation.g.a<Float> r5 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        ((List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin")).add(startFloatAnimation(this.groupScaleForAnimation, r10, r5, 0.390625f, (d.h.a.b) ZeusTransformUtils.preCheckCast(new ab(this), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new ac(r14), d.h.a.a.class, "com.obric.aiagent.plugin")));
    }

    private final void startGroupShadowAnimation(float r10, com.obric.common.oea.foundation.animation.g.a<Float> r11, d.h.a.a<d.x> r12, List<com.obric.common.oea.foundation.animation.manager.d> r13) {
        com.obric.common.oea.foundation.animation.g.a<Float> r5 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        ((List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin")).add(startFloatAnimation(0.0f, 1.0f, r5, 0.390625f, (d.h.a.b) ZeusTransformUtils.preCheckCast(new ad(boundedAlphaUpdater(0.0f, 1.0f, (d.h.a.b) ZeusTransformUtils.preCheckCast(new ae(this, r10, currentShadowSnapshot(), normalShadowSnapshotWithAlphaProgress(r10)), d.h.a.b.class, "com.obric.aiagent.plugin"))), d.h.a.b.class, "com.obric.aiagent.plugin"), r8));
    }

    static /* synthetic */ void startGroupBlurAnimation$default(OButtonGroup r1, float r2, com.obric.common.oea.foundation.animation.g.a r3, d.h.a.a r4, List r5, int r6, Object r7) {
        com.obric.common.oea.foundation.animation.g.a<Float> r8 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        List<com.obric.common.oea.foundation.animation.manager.d> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r10 = r1.groupAnimators;
    L5:
        r1.startGroupBlurAnimation(r2, r8, r9, r10);
    }

    private final void startGroupBlurAnimation(float r10, com.obric.common.oea.foundation.animation.g.a<Float> r11, d.h.a.a<d.x> r12, List<com.obric.common.oea.foundation.animation.manager.d> r13) {
        com.obric.common.oea.foundation.animation.g.a<Float> r5 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        ((List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin")).add(startFloatAnimation(this.currentGroupBlur, r10, r5, 10.0f, (d.h.a.b) ZeusTransformUtils.preCheckCast(new aa(this), d.h.a.b.class, "com.obric.aiagent.plugin"), r8));
    }

    private final void startChildAlphaAnimation(View r10, float r11, com.obric.common.oea.foundation.animation.g.a<Float> r12, d.h.a.a<d.x> r13, List<com.obric.common.oea.foundation.animation.manager.d> r14) {
        com.obric.common.oea.foundation.animation.g.a<Float> r5 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        d.h.a.b<Float, d.x> r16 = boundedAlphaUpdater(r10.getAlpha(), r11, (d.h.a.b) ZeusTransformUtils.preCheckCast(new s(r10), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r15.add(startFloatAnimation(r10.getAlpha(), r11, r5, 0.390625f, (d.h.a.b) ZeusTransformUtils.preCheckCast(new r(r16), d.h.a.b.class, "com.obric.aiagent.plugin"), r8));
    }

    private final d.h.a.b<Float, d.x> boundedAlphaUpdater(float r11, float r12, d.h.a.b<? super Float, d.x> r13) {
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        float r4 = d.l.n.a(r12, 0.0f, 1.0f);
        if (r4 != 1.0f) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L8;
    L10:
        boolean r5 = false;
    L12:
        if (r4 != 0.0f) goto L14;
        boolean r15 = true;
    L15:
        if (r15 == true) goto L17;
    L19:
        boolean r6 = false;
    L21:
        return (d.h.a.b) ZeusTransformUtils.preCheckCast(new q(new d.h.b.z.a(), r4, r5, r6, this, r11, r9), d.h.a.b.class, "com.obric.aiagent.plugin");
    L17:
        if (r11 <= r4) goto L19;
        r6 = true;
        goto L21
    L14:
        r15 = false;
        goto L15
    L8:
        if (r11 >= r4) goto L10;
        r5 = true;
        goto L12
    L5:
        r14 = false;
        goto L6
    }

    private final float accelerateBoundedAlpha(float r4, float r5, float r6) {
        float r3 = r6 - r5;
        if (r3 != 0.0f) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L9;
        float r7 = d.l.n.a((r4 - r5) / r3, 0.0f, 1.0f);
        return d.l.n.a(r5 + (r3 * d.l.n.a(r7 + (((1.0f - r7) * r7) * 0.7f), 0.0f, 1.0f)), 0.0f, 1.0f);
    L9:
        return d.l.n.a(r6, 0.0f, 1.0f);
    L5:
        r1 = false;
        goto L7
    }

    private final void startChildScaleAnimation(View r10, float r11, com.obric.common.oea.foundation.animation.g.a<Float> r12, d.h.a.a<d.x> r13, List<com.obric.common.oea.foundation.animation.manager.d> r14) {
        com.obric.common.oea.foundation.animation.g.a<Float> r5 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        ((List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin")).add(startFloatAnimation(r10.getScaleX(), r11, r5, 0.390625f, (d.h.a.b) ZeusTransformUtils.preCheckCast(new t(r10), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new u(r15), d.h.a.a.class, "com.obric.aiagent.plugin")));
    }

    private final void startWidthChangeAnimation(int r10, int r11, d.h.a.a<d.x> r12) {
        this.contentAnimators.add(startFloatAnimation(r10, r11, c.a.f34185a.h(r11).a(), 10.0f, (d.h.a.b) ZeusTransformUtils.preCheckCast(new af(this), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new ag(this, r11, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin")), d.h.a.a.class, "com.obric.aiagent.plugin")));
    }

    private final com.obric.common.oea.foundation.animation.manager.d startFloatAnimation(float r10, float r11, com.obric.common.oea.foundation.animation.g.a<Float> r12, float r13, d.h.a.b<? super Float, d.x> r14, d.h.a.a<d.x> r15) {
        com.obric.common.oea.foundation.animation.g.a r16 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r17 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a r18 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        return com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a(), r10, r11, com.obric.oui.common.util.a.a(r16, r13), null, 8, null).a((d.h.a.q) ZeusTransformUtils.preCheckCast(new w(r17, this), d.h.a.q.class, "com.obric.aiagent.plugin")).a((d.h.a.m) ZeusTransformUtils.preCheckCast(new x(r18), d.h.a.m.class, "com.obric.aiagent.plugin")).a().a();
    }

    private final void prepareChildrenForAppear(List<? extends View> r3) {
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        View r4 = (View) ZeusTransformUtils.preCheckCast(r2.next(), View.class, "com.obric.aiagent.plugin");
        r4.setAlpha(0.0f);
        r4.setScaleX(c.a.f34185a.c());
        r4.setScaleY(c.a.f34185a.c());
        goto L4
    }

    private final void settleChildrenVisualState(List<? extends View> r4) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        View r0 = (View) ZeusTransformUtils.preCheckCast(r5.next(), View.class, "com.obric.aiagent.plugin");
        resetChildAlpha(r0);
        r0.setScaleX(1.0f);
        r0.setScaleY(1.0f);
        goto L4
    }

    private final float hiddenContentScale(View r1) {
        if (containsTextView(r1) == false) goto L6;
        return c.a.f34185a.g();
    L6:
        return c.a.f34185a.f();
    }

    private final boolean containsTextView(View r8) {
        if (ZeusTransformUtils.instanceOf(r8, TextView.class) == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, ViewGroup.class) == false) goto L13;
        int r0 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount();
        int r4 = 0;
    L8:
        if (r4 >= r0) goto L13;
        int r5 = r4 + 1;
        View r6 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.aiagent.plugin")).getChildAt(r4);
        d.h.b.o.c(r6, "view.getChildAt(index)");
        if (containsTextView(r6) == true) goto L11;
        r4 = r5;
        goto L8
    L11:
        return true;
    L13:
        return false;
    }

    private final float appearBlurRadius() {
        return c.a.f34185a.b();
    }

    private final float disappearBlurRadius() {
        return c.a.f34185a.d();
    }

    private final float changeBlurRadius() {
        return c.a.f34185a.h();
    }

    private final void freezeGroupWidth(int r2) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.width = r2;
        setLayoutParams(r0);
    }

    private final void setGroupScaleForAnimation(float r1) {
        this.groupScaleForAnimation = r1;
        applyCombinedGroupScale();
    }

    private final void applyCombinedGroupScale() {
        float r0 = this.groupScaleForAnimation * this.pressScaleForAnimation;
        setScaleX(r0);
        setScaleY(r0);
    }

    private final void setGroupBlur(float r1) {
        setContentSelfBlur(r1);
    }

    private final void setGroupBlurForAnimation(float r1) {
        this.currentGroupBlur = r1;
        setGroupBlur(r1);
    }

    private final void dispatchGroupAlphaAnimationEnd() {
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.groupAlphaAnimationEndListeners, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L8;
        List r0 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.groupAlphaAnimationEndListeners, Iterable.class, "com.obric.aiagent.plugin"));
        this.groupAlphaAnimationEndListeners.clear();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        ((d.h.a.a) ZeusTransformUtils.preCheckCast(r3.next(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
        goto L6
    L10:
        return;
    }

    private final void dispatchAnimationEndIfIdle() {
        if (isAnimating() == false) goto L5;
        return;
    L5:
        if (this.animationEndListeners.isEmpty() == true) goto L13;
        List r0 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.animationEndListeners, Iterable.class, "com.obric.aiagent.plugin"));
        this.animationEndListeners.clear();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        ((d.h.a.a) ZeusTransformUtils.preCheckCast(r3.next(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
        goto L9
    L14:
        return;
    }
}
