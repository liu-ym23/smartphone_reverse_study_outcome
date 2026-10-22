package com.obric.autoaction.vdplayer.components.cursor;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.obric.autoaction.view.AiStrokeView;
import com.obric.common.oea.foundation.animation.h.e;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.z;
import d.o;
import d.s;
import d.x;
import java.util.LinkedList;
import java.util.Queue;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: CursorView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.autoaction.vdplayer.components.cursor.b {
    private static final String TAG = "CursorView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0621a f25377a = null;
    private static final int m = 0;
    private static final int n = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f25378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CursorThoughtTextView f25379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CursorPressDownEffectView f25380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autoaction.a.c f25381e;
    private b f;
    private final am g;
    private ca h;
    private com.obric.common.oea.foundation.animation.manager.d i;
    private com.obric.common.oea.foundation.animation.manager.d j;
    private boolean k;
    private final Queue<d.h.a.a<com.obric.common.oea.foundation.animation.a.b.a>> l;

    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.cursor.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CursorView.kt */
    private static final class C0621a {
        public /* synthetic */ C0621a(h r1) {
            this();
        }

        private C0621a() {
        }
    }

    /* JADX INFO: compiled from: CursorView.kt */
    private static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f25382a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f25383b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f25384c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f25385d = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f25382a, f25383b};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f25382a = new b("VISIBLE", 0);
            f25383b = new b("HIDE", 1);
            b[] r0 = a();
            f25384c = r0;
            f25385d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f25384c.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: CursorView.kt */
    @f(b = "CursorView.kt", c = {229}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.cursor.CursorView$idle$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f25387b;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25387b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f25387b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25386a;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            if (a.a(this.f25387b).isAttachedToWindow() == false) goto L20;
            if (a.a(this.f25387b).getVisibility() == 0) goto L17;
            r2 = false;
        L17:
            if (r2 == false) goto L20;
            a.b(this.f25387b);
            a.c(this.f25387b);
        L20:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25386a = 1;
            if (ax.a(2000, r7) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.a.b.a lambda$51cH8rB47QhImShCpkyrajL6ja4(a r0) {
        return f(r0);
    }

    public static /* synthetic */ x lambda$5FHu_TVC1mNEOsV5qlM_SqLYC4I(a r0, String r1, Object r2, Object r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$AYvZUB-sQHy-HgF71N07uWEmack, reason: not valid java name */
    public static /* synthetic */ x m663lambda$AYvZUBsQHyHgF71N07uWEmack(a r0) {
        return e(r0);
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.a.b.a lambda$FmPeG7sQMrIcYxIzA_jI7u2GUzw(a r0) {
        return h(r0);
    }

    public static /* synthetic */ x lambda$IuJJDX5oZn6Prwoi763YQZPJb5s(a r0, boolean r1, Throwable r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$KgYL5mthsKDgqn97g3RjWHbLve8(a r0, float r1, float r2, boolean r3, Throwable r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$MBuaxuxyauW6ndCMMUSTnQvf-_A, reason: not valid java name */
    public static /* synthetic */ x m664lambda$MBuaxuxyauW6ndCMMUSTnQvf_A(a r0, String r1, Object r2, Object r3) {
        return b(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$NJovZwd6_z9piNnIWwaQnuCklDs(a r0, String r1, Object r2, Object r3) {
        return c(r0, r1, r2, r3);
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.a.b.a lambda$a24GInlPPB3goFY1UtcKqNY5bFc(a r0, float r1, float r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$j4Hv35AY1qhFPeHQ7sr-45WDOFg, reason: not valid java name */
    public static /* synthetic */ x m665lambda$j4Hv35AY1qhFPeHQ7sr45WDOFg(a r0, float r1, int r2, float r3, z.d r4, z.c r5, z.c r6, String r7, Object r8, Object r9) {
        return a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ x lambda$m2pGbBCXXsZ8O8COZJC62akRr7E(d.h.a.a r0, boolean r1, Throwable r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.a.b.a lambda$x6Q63zxhTC2eRbpJ_JvRh7KUWqU(a r0) {
        return g(r0);
    }

    /* JADX INFO: renamed from: lambda$yXdLHPcS-UlZ64y1rxVWOA2JRzg, reason: not valid java name */
    public static /* synthetic */ x m666lambda$yXdLHPcSUlZ64y1rxVWOA2JRzg(a r0, String r1) {
        return a(r0, r1);
    }

    public a(View r2, CursorThoughtTextView r3, CursorPressDownEffectView r4, com.obric.autoaction.a.c r5) {
        d.h.b.o.e(r2, "cursorView");
        d.h.b.o.e(r3, "cursorTextView");
        d.h.b.o.e(r4, "pressEffectView");
        d.h.b.o.e(r5, "componentHost");
        this.f25378b = r2;
        this.f25379c = r3;
        this.f25380d = r4;
        this.f25381e = r5;
        this.f = b.f25383b;
        r3.setOnSizeChangedListener(new $$Lambda$a$AYvZUBsQHyHgF71N07uWEmack(this));
        this.g = r5.a();
        this.l = (Queue) ZeusTransformUtils.preCheckCast(new LinkedList(), Queue.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ View a(a r0) {
        return r0.f25378b;
    }

    public static final /* synthetic */ void b(a r0) {
        r0.i();
    }

    public static final /* synthetic */ void c(a r0) {
        r0.j();
    }

    public static final /* synthetic */ CursorPressDownEffectView d(a r0) {
        return r0.f25380d;
    }

    private static final x e(a r7) {
        if (r7.f25379c.isAttachedToWindow() == false) goto L5;
        d.m r0 = a(r7, 0.0f, 0.0f, null, null, 15, null);
        r7.a(((Number) ZeusTransformUtils.preCheckCast(r0.c(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.d(), Number.class, "com.obric.aiagent.plugin")).floatValue(), false);
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    private final void a(d.h.a.a<com.obric.common.oea.foundation.animation.a.b.a> r3) {
        d.h.a.a<com.obric.common.oea.foundation.animation.a.b.a> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        this.l.offer(r4);
        g();
    }

    private final void g() {
        if (this.l.isEmpty() == false) goto L7;
        this.k = false;
        return;
    L7:
        if (this.k == false) goto L9;
        return;
    L9:
        d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.preCheckCast(this.l.poll(), d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L12;
        return;
    L12:
        this.j = com.obric.autoaction.vdplayer.components.cursor.a.a.a(((com.obric.common.oea.foundation.animation.a.b.a) ZeusTransformUtils.preCheckCast(r0.invoke(), com.obric.common.oea.foundation.animation.a.b.a.class, "com.obric.aiagent.plugin")).a(new $$Lambda$a$IuJJDX5oZn6Prwoi763YQZPJb5s(this)).b(), null, null, 3, null);
        AiStrokeView r1 = com.obric.autoaction.vdplayer.components.c.a();
        if (r1 == null) goto L15;
        r1.syncAnimation();
    L15:
        this.k = true;
    }

    private static final x a(a r0, boolean r1, Throwable r2) {
        r0.k = false;
        r0.j = null;
        r0.g();
        return x.f38692a;
    }

    @Override // com.obric.autoaction.vdplayer.components.cursor.b
    public void a() {
        this.f = b.f25382a;
        CharSequence r0 = this.f25379c.getText();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        h();
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.autoaction.vdplayer.components.cursor.b
    public void b() {
        this.f = b.f25382a;
        this.f25378b.setVisibility(0);
        CursorThoughtTextView r2 = this.f25379c;
        r2.setText(null);
        ((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin")).setVisibility(4);
    }

    private final void h() {
        boolean r1 = true;
        if (this.f25378b.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.f25378b.setVisibility(0);
    L9:
        if (((View) ZeusTransformUtils.preCheckCast(this.f25379c, View.class, "com.obric.aiagent.plugin")).getVisibility() == 0) goto L12;
        r1 = false;
    L12:
        if (r1 == true) goto L15;
        ((View) ZeusTransformUtils.preCheckCast(this.f25379c, View.class, "com.obric.aiagent.plugin")).setVisibility(0);
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.autoaction.vdplayer.components.cursor.b
    public void c() {
        k();
        this.f25378b.setVisibility(8);
        ((View) ZeusTransformUtils.preCheckCast(this.f25379c, View.class, "com.obric.aiagent.plugin")).setVisibility(8);
        m();
        this.f = b.f25383b;
    }

    @Override // com.obric.autoaction.vdplayer.components.cursor.b
    public void a(float r8, float r9, Float r10, Float r11, boolean r12) {
        l();
        d.m<Float, Float> r13 = a(r8, r9);
        float r14 = ((Number) ZeusTransformUtils.preCheckCast(r13.c(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r15 = ((Number) ZeusTransformUtils.preCheckCast(r13.d(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        a(this, this.f25378b, r14, r15, false, 4, null);
        float r16 = r14 - (this.f25378b.getWidth() / 2);
        float r17 = r15 - (this.f25378b.getHeight() / 2);
        ViewParent r18 = this.f25378b.getParent();
        d.h.b.o.a(r18, "null cannot be cast to non-null type android.view.ViewGroup");
        d.m<Float, Float> r19 = a(r16, r17, (View) ZeusTransformUtils.preCheckCast((ViewGroup) ZeusTransformUtils.preCheckCast(r18, ViewGroup.class, "com.obric.aiagent.plugin"), View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(this.f25379c, View.class, "com.obric.aiagent.plugin"));
        a(((Number) ZeusTransformUtils.preCheckCast(r19.c(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r19.d(), Number.class, "com.obric.aiagent.plugin")).floatValue(), false);
    }

    @Override // com.obric.autoaction.vdplayer.components.cursor.b
    public void d() {
        a(new $$Lambda$a$51cH8rB47QhImShCpkyrajL6ja4(this));
        a(new $$Lambda$a$x6Q63zxhTC2eRbpJ_JvRh7KUWqU(this));
    }

    private static final com.obric.common.oea.foundation.animation.a.b.a f(a r4) {
        r4.f25380d.pressDown();
        return a(r4, com.obric.autoaction.vdplayer.components.cursor.a.a.a(r4.f25378b, 0.0f, 0.0f, 3, null), 0.0f, 1, null);
    }

    private static final com.obric.common.oea.foundation.animation.a.b.a g(a r4) {
        r4.f25380d.pressUp();
        return r4.a(com.obric.autoaction.vdplayer.components.cursor.a.a.a(r4.f25378b, 0.0f, 0.0f, 3, null), e.b.f32437e);
    }

    @Override // com.obric.autoaction.vdplayer.components.cursor.b
    public void a(final float r1, final float r2, Float r3, Float r4) {
        l();
        a(new $$Lambda$a$a24GInlPPB3goFY1UtcKqNY5bFc(this, r1, r2));
        a(new $$Lambda$a$FmPeG7sQMrIcYxIzA_jI7u2GUzw(this));
    }

    private static final com.obric.common.oea.foundation.animation.a.b.a a(a r12, float r13, float r14) {
        r12.f25380d.pressDown();
        r12.f25378b.setScaleX(1.0f);
        r12.f25378b.setScaleY(1.0f);
        com.obric.autoaction.vdplayer.components.cursor.a.a.a(r12.a(com.obric.autoaction.vdplayer.components.cursor.a.a.a(r12.f25378b, 0.0f, 0.0f, 3, null), 1.0f).b(), null, null, 3, null);
        d.m<Float, Float> r0 = r12.a(r13, r14);
        float r10 = ((Number) ZeusTransformUtils.preCheckCast(r0.c(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r11 = ((Number) ZeusTransformUtils.preCheckCast(r0.d(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r1 = r10 - (r12.f25378b.getWidth() / 2);
        float r2 = r11 - (r12.f25378b.getHeight() / 2);
        ViewParent r3 = r12.f25378b.getParent();
        d.h.b.o.a(r3, "null cannot be cast to non-null type android.view.ViewGroup");
        d.m<Float, Float> r4 = r12.a(r1, r2, (View) ZeusTransformUtils.preCheckCast((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin"), View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(r12.f25379c, View.class, "com.obric.aiagent.plugin"));
        a(r12, ((Number) ZeusTransformUtils.preCheckCast(r4.c(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r4.d(), Number.class, "com.obric.aiagent.plugin")).floatValue(), false, 4, null);
        return a(r12, com.obric.autoaction.vdplayer.components.cursor.a.a.a(r12.f25378b, 0.0f, 0.0f, 3, null), r10, r11, false, 4, null);
    }

    private static final com.obric.common.oea.foundation.animation.a.b.a h(a r4) {
        r4.f25380d.pressUp();
        return r4.a(com.obric.autoaction.vdplayer.components.cursor.a.a.a(r4.f25378b, 0.0f, 0.0f, 3, null), e.b.f32433a);
    }

    @Override // com.obric.autoaction.vdplayer.components.cursor.b
    public void e() {
        if (this.i == null) goto L6;
        return;
    L6:
        if (this.h == null) goto L8;
        return;
    L8:
        this.h = i.a(this.g, null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.autoaction.vdplayer.components.cursor.b
    public void f() {
        k();
    }

    private final void i() {
        if (this.f25378b.getAlpha() != 1.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        com.obric.autoaction.vdplayer.components.cursor.a.a.a(a(com.obric.autoaction.vdplayer.components.cursor.a.a.a(this.f25378b, 0.0f, 0.0f, 3, null)).b(), null, null, 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void a(String r13) {
        if (this.f != b.f25383b) goto L5;
        return;
    L5:
        CursorThoughtTextView r0 = this.f25379c;
        r0.setAlpha(0.0f);
        r0.setVisibility(0);
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"));
        d.m r14 = a(this, 0.0f, 0.0f, null, null, 15, null);
        a(((Number) ZeusTransformUtils.preCheckCast(r14.c(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r14.d(), Number.class, "com.obric.aiagent.plugin")).floatValue(), false);
        com.obric.common.oea.foundation.animation.a.b.a r5 = com.obric.autoaction.vdplayer.components.cursor.a.a.a((View) ZeusTransformUtils.preCheckCast(this.f25379c, View.class, "com.obric.aiagent.plugin"), 0.0f, 0.0f, 3, null).a(1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.c.f, e.b.f32434b, e.d.f32443a), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), Float.valueOf(0.0f));
        e.c r12 = e.c.j;
        com.obric.autoaction.vdplayer.components.cursor.a.a.a(com.obric.common.oea.foundation.animation.a.b.a.b(r5, 1.0f, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.a.f, r12, e.b.f32434b), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).b(), null, null, 3, null);
    }

    private final void b(d.h.a.a<x> r20) {
        final d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.obric.common.oea.foundation.animation.a.b.a r6 = com.obric.autoaction.vdplayer.components.cursor.a.a.a((View) ZeusTransformUtils.preCheckCast(this.f25379c, View.class, "com.obric.aiagent.plugin"), 0.0f, 0.0f, 3, null);
        e.c r2 = e.c.f32440c;
        e.d r3 = e.d.j;
        com.obric.autoaction.vdplayer.components.cursor.a.a.a(com.obric.common.oea.foundation.animation.a.b.a.a(com.obric.common.oea.foundation.animation.a.b.a.b(r6, 0.2f, 0.2f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(r2, e.b.f32433a, r3), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null), 0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.c.f32440c, e.b.f32433a, e.d.j), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 4, null).a(new $$Lambda$a$m2pGbBCXXsZ8O8COZJC62akRr7E(r0)).b(), null, null, 3, null);
    }

    private static final x a(d.h.a.a r0, boolean r1, Throwable r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r0, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.invoke();
    L6:
        return x.f38692a;
    }

    private static final x a(a r15, float r16, int r17, float r18, z.d r19, z.c r20, z.c r21, String r22, Object r23, Object r24) {
        d.h.b.o.e(r22, "<unused var>");
        d.h.b.o.e(r23, "value");
        d.h.b.o.e(r24, "<unused var>");
        if (ZeusTransformUtils.instanceOf(r23, Float.class) == false) goto L5;
        Float r0 = (Float) ZeusTransformUtils.preCheckCast(r23, Float.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L17;
        float r12 = r17;
        double r13 = r0.floatValue();
        r15.f25378b.setX(r16 + (((float) Math.cos(r13)) * r12));
        r15.f25378b.setY(r18 + (((float) Math.sin(r13)) * r12));
        if (r15.f25379c.getWidth() == r19.f38502a) goto L10;
        d.m r1 = a(r15, r16, r18, null, null, 12, null);
        float r2 = ((Number) ZeusTransformUtils.preCheckCast(r1.c(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r3 = ((Number) ZeusTransformUtils.preCheckCast(r1.d(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        r19.f38502a = r15.f25379c.getWidth();
        r20.f38501a = r2;
        r21.f38501a = r3;
    L10:
        r15.f25379c.setX(r20.f38501a + (((float) Math.cos(r13)) * r12));
        r15.f25379c.setY(r21.f38501a + (r12 * ((float) Math.sin(r13))));
        if (r13 >= 3.141592653589793d) goto L13;
        r15.f25378b.setAlpha((float) (((double) 0.2f) + (((double) 0.2f) * (r13 / 3.141592653589793d))));
    L15:
        return x.f38692a;
    L13:
        r15.f25378b.setAlpha((float) (((double) 0.4f) + ((((double) (-0.2f)) * (r13 - 3.141592653589793d)) / 3.141592653589793d)));
        goto L15
    L17:
        return x.f38692a;
    L5:
        r0 = null;
        goto L6
    }

    private static final x a(a r0, float r1, float r2, boolean r3, Throwable r4) {
        if (r3 == true) goto L5;
        r0.f25378b.setX(r1);
        r0.f25378b.setY(r2);
    L5:
        return x.f38692a;
    }

    private final void k() {
        this.l.clear();
        com.obric.common.oea.foundation.animation.manager.d r0 = this.j;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        com.obric.common.oea.foundation.animation.manager.d r1 = this.j;
        if (r1 == null) goto L8;
        com.obric.common.oea.foundation.animation.manager.d.a(r1, false, 1, null);
    L8:
        this.j = null;
        this.f25380d.stopAllAnimation();
        l();
    }

    private final void l() {
        ca r0 = this.h;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        this.h = null;
        if (this.f25378b.getAlpha() != 1.0f) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        com.obric.autoaction.vdplayer.components.cursor.a.a.a(b(com.obric.autoaction.vdplayer.components.cursor.a.a.a(this.f25378b, 0.0f, 0.0f, 3, null)).b(), null, null, 3, null);
    L11:
        com.obric.common.oea.foundation.animation.manager.d r2 = this.i;
        if (r2 == null) goto L14;
        r2.a();
    L14:
        com.obric.common.oea.foundation.animation.manager.d r3 = this.i;
        if (r3 == null) goto L17;
        com.obric.common.oea.foundation.animation.manager.d.a(r3, false, 1, null);
    L17:
        this.i = null;
        return;
    L8:
        r1 = false;
        goto L9
    }

    @Override // com.obric.autoaction.vdplayer.components.cursor.b
    public void a(final String r12, boolean r13) {
        if (this.f != b.f25383b) goto L5;
        return;
    L5:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        return;
    L15:
        if (d.h.b.o.a(r12, this.f25379c.getText()) == false) goto L17;
        return;
    L17:
        h();
        if (r13 == true) goto L22;
        CursorThoughtTextView r14 = this.f25379c;
        r14.setAlpha(1.0f);
        r14.setVisibility(0);
        r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"));
        d.m r15 = a(this, 0.0f, 0.0f, null, null, 15, null);
        a(((Number) ZeusTransformUtils.preCheckCast(r15.c(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r15.d(), Number.class, "com.obric.aiagent.plugin")).floatValue(), false);
        return;
    L22:
        if (((View) ZeusTransformUtils.preCheckCast(this.f25379c, View.class, "com.obric.aiagent.plugin")).getVisibility() == 4) goto L25;
        r2 = false;
    L25:
        if (r2 == false) goto L27;
        a(r12);
        return;
    L27:
        b(new $$Lambda$a$yXdLHPcSUlZ64y1rxVWOA2JRzg(this, r12));
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    private static final x a(a r0, String r1) {
        r0.a(r1);
        return x.f38692a;
    }

    static /* synthetic */ void a(a r0, float r1, float r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = true;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(float r12, float r13, boolean r14) {
        if (r14 == true) goto L6;
        a((View) ZeusTransformUtils.preCheckCast(this.f25379c, View.class, "com.obric.aiagent.plugin"), r12, r13, false);
        return;
    L6:
        com.obric.common.oea.foundation.animation.a.b.a r4 = com.obric.autoaction.vdplayer.components.cursor.a.a.a((View) ZeusTransformUtils.preCheckCast(this.f25379c, View.class, "com.obric.aiagent.plugin"), 0.0f, 0.0f, 3, null);
        e.c r11 = e.c.j;
        com.obric.autoaction.vdplayer.components.cursor.a.a.a(com.obric.common.oea.foundation.animation.a.b.a.a(r4, r12, r13, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.a.f32428a, r11, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).b(), null, null, 3, null);
    }

    static /* synthetic */ void a(a r0, View r1, float r2, float r3, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r4 = true;
    L5:
        r0.a(r1, r2, r3, r4);
    }

    private final void a(final View r7, final float r8, final float r9, boolean r10) {
        if (r10 == false) goto L4;
        r8 = r8 - (r7.getWidth() / 2);
    L4:
        if (r10 == false) goto L7;
        r9 = r9 - (r7.getHeight() / 2);
    L7:
        if (ViewCompat.F(r7) == true) goto L9;
    L11:
        r7.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new CursorView$moveWithoutAnimation$$inlined$doOnLayout$1(r7, r8, r9, this), View.OnLayoutChangeListener.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        if (r7.isLayoutRequested() == true) goto L11;
        r7.setX(r8);
        r7.setY(r9);
        a(this, (View) ZeusTransformUtils.preCheckCast(d(this), View.class, "com.obric.aiagent.plugin"), a(this), 0.0f, 2, null);
    }

    static /* synthetic */ com.obric.common.oea.foundation.animation.a.b.a a(a r0, com.obric.common.oea.foundation.animation.a.b.a r1, float r2, float r3, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r4 = true;
    L6:
        return r0.a(r1, r2, r3, r4);
    }

    private final com.obric.common.oea.foundation.animation.a.b.a a(com.obric.common.oea.foundation.animation.a.b.a r8, float r9, float r10, boolean r11) {
        if (r11 == false) goto L4;
        r9 = r9 - (r8.a().getWidth() / 2);
    L4:
        float r1 = r9;
        if (r11 == false) goto L8;
        r10 = r10 - (r8.a().getHeight() / 2);
    L8:
        return com.obric.common.oea.foundation.animation.a.b.a.a(r8, r1, r10, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.a.f32428a, e.c.f, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a(new $$Lambda$a$5FHu_TVC1mNEOsV5qlM_SqLYC4I(this));
    }

    private static final x a(a r6, String r7, Object r8, Object r9) {
        d.h.b.o.e(r7, "property");
        d.h.b.o.e(r8, "targetValue");
        d.h.b.o.e(r9, "velocity");
        a(r6, (View) ZeusTransformUtils.preCheckCast(r6.f25380d, View.class, "com.obric.aiagent.plugin"), r6.f25378b, 0.0f, 2, null);
        return x.f38692a;
    }

    static /* synthetic */ com.obric.common.oea.foundation.animation.a.b.a a(a r0, com.obric.common.oea.foundation.animation.a.b.a r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = 0.667f;
    L6:
        return r0.a(r1, r2);
    }

    private final com.obric.common.oea.foundation.animation.a.b.a a(com.obric.common.oea.foundation.animation.a.b.a r19, float r20) {
        e.c r0 = e.c.f32440c;
        return com.obric.common.oea.foundation.animation.a.b.a.b(com.obric.common.oea.foundation.animation.a.b.a.b(r19, r20, r20, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.a.g, r0, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null), com.obric.common.oea.foundation.animation.h.a.b.f32420d, Integer.valueOf(m), n, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.b(e.c.f32441d, e.b.f32433a, e.d.k), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null).a(new $$Lambda$a$MBuaxuxyauW6ndCMMUSTnQvf_A(this));
    }

    private static final x b(a r2, String r3, Object r4, Object r5) {
        d.h.b.o.e(r3, "property");
        d.h.b.o.e(r4, "targetValue");
        d.h.b.o.e(r5, "<unused var>");
        if (d.h.b.o.a(r3, "scaleX") == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L7;
        Float r6 = (Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin");
    L8:
        if (r6 == null) goto L11;
        float r7 = r6.floatValue();
        Resources r0 = Resources.getSystem();
        d.h.b.o.c(r0, "Resources.getSystem()");
        r2.a(r2.f25378b, (int) (d.i.a.a(TypedValue.applyDimension(1, 3, r0.getDisplayMetrics())) / r7));
        goto L13
    L11:
        return x.f38692a;
    L7:
        r6 = null;
    L13:
        return x.f38692a;
    }

    private final com.obric.common.oea.foundation.animation.a.b.a a(com.obric.common.oea.foundation.animation.a.b.a r19, e.b r20) {
        e.c r0 = e.c.g;
        e.a r1 = e.a.i;
        if (r20 != null) goto L5;
        e.b r2 = e.b.f32433a;
    L6:
        com.obric.common.oea.foundation.animation.a.b.a r10 = com.obric.common.oea.foundation.animation.a.b.a.b(r19, 1.0f, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(r1, r0, r2), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null);
        com.obric.common.oea.foundation.animation.h.a.b r11 = com.obric.common.oea.foundation.animation.h.a.b.f32420d;
        Integer r12 = Integer.valueOf(n);
        int r13 = m;
        e.c r3 = e.c.f32441d;
        if (r20 != null) goto L9;
        e.b r4 = e.b.f32433a;
    L11:
        return com.obric.common.oea.foundation.animation.a.b.a.b(r10, r11, r12, r13, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.b(r3, r4, e.d.k), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null).a(new $$Lambda$a$NJovZwd6_z9piNnIWwaQnuCklDs(this));
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r20;
        goto L6
    }

    private static final x c(a r2, String r3, Object r4, Object r5) {
        d.h.b.o.e(r3, "property");
        d.h.b.o.e(r4, "targetValue");
        d.h.b.o.e(r5, "<unused var>");
        if (d.h.b.o.a(r3, "scaleX") == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L7;
        Float r6 = (Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin");
    L8:
        if (r6 == null) goto L11;
        float r7 = r6.floatValue();
        Resources r0 = Resources.getSystem();
        d.h.b.o.c(r0, "Resources.getSystem()");
        r2.a(r2.f25378b, (int) (d.i.a.a(TypedValue.applyDimension(1, 3, r0.getDisplayMetrics())) / r7));
        goto L13
    L11:
        return x.f38692a;
    L7:
        r6 = null;
    L13:
        return x.f38692a;
    }

    private final com.obric.common.oea.foundation.animation.a.b.a a(com.obric.common.oea.foundation.animation.a.b.a r3) {
        e.c r2 = e.c.p;
        e.d r0 = e.d.f32444b;
        return r3.a(0.4f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(r2, e.b.f32433a, r0), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), Float.valueOf(1.0f));
    }

    private final com.obric.common.oea.foundation.animation.a.b.a b(com.obric.common.oea.foundation.animation.a.b.a r3) {
        e.c r2 = e.c.f;
        e.d r0 = e.d.f32444b;
        return r3.a(1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(r2, e.b.f32433a, r0), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), Float.valueOf(0.4f));
    }

    private final void a(View r2, int r3) {
        Drawable r1 = r2.getBackground();
        if (ZeusTransformUtils.instanceOf(r1, GradientDrawable.class) == false) goto L6;
        ((GradientDrawable) ZeusTransformUtils.preCheckCast(r1, GradientDrawable.class, "com.obric.aiagent.plugin")).setStroke(r3, -1);
        return;
    }

    static /* synthetic */ d.m a(a r1, float r2, float r3, View r4, View r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.f25378b.getX();
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.f25378b.getY();
    L9:
        if ((r6 & 4) == 0) goto L12;
        ViewParent r8 = r1.f25378b.getParent();
        d.h.b.o.a(r8, "null cannot be cast to non-null type android.view.View");
        r4 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin");
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = (View) ZeusTransformUtils.preCheckCast(r1.f25379c, View.class, "com.obric.aiagent.plugin");
    L15:
        return r1.a(r2, r3, r4, r5);
    }

    private final d.m<Float, Float> a(float r8, float r9, View r10, View r11) {
        float r12 = (r8 + (this.f25378b.getWidth() / 2)) - (r11.getMeasuredWidth() / 2);
        float r0 = this.f25378b.getHeight() + r9;
        com.obric.autoaction.vdplayer.components.a.a r7 = (com.obric.autoaction.vdplayer.components.a.a) ZeusTransformUtils.preCheckCast(this.f25381e.a(com.obric.autoaction.vdplayer.components.a.a.class), com.obric.autoaction.vdplayer.components.a.a.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r7 == null) goto L5;
        int r13 = r7.a();
    L7:
        if (r13 <= 0) goto L9;
        int r5 = r10.getHeight() - r13;
        Resources r6 = Resources.getSystem();
        d.h.b.o.c(r6, "Resources.getSystem()");
        int r14 = r5 + d.i.a.a(TypedValue.applyDimension(1, 8, r6.getDisplayMetrics()));
    L10:
        float r15 = (r10.getY() + r10.getHeight()) - r14;
        if ((r15 - r0) >= r11.getMeasuredHeight()) goto L13;
        r1 = true;
    L13:
        if (r1 == false) goto L15;
        float r16 = r9 - r11.getMeasuredHeight();
        Resources r2 = Resources.getSystem();
        d.h.b.o.c(r2, "Resources.getSystem()");
        float r17 = Math.min(r16 - d.i.a.a(TypedValue.applyDimension(1, 8, r2.getDisplayMetrics())), r15 - r11.getMeasuredHeight());
    L16:
        float r18 = TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics());
        if (r12 >= r18) goto L20;
        r12 = r18;
    L23:
        return s.a(Float.valueOf(r12), Float.valueOf(r17));
    L20:
        if ((r11.getMeasuredWidth() + r12) <= (r10.getWidth() - r18)) goto L23;
        r12 = (r10.getWidth() - r11.getMeasuredWidth()) - r18;
        goto L23
    L15:
        Resources r19 = Resources.getSystem();
        d.h.b.o.c(r19, "Resources.getSystem()");
        r17 = d.i.a.a(TypedValue.applyDimension(1, 8, r19.getDisplayMetrics())) + r0;
        goto L16
    L9:
        r14 = 0;
        goto L10
    L5:
        r13 = 0;
        goto L7
    }

    private final d.m<Float, Float> a(float r4, float r5) {
        ViewParent r3 = this.f25378b.getParent();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L5;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin");
    L6:
        if (r6 != null) goto L10;
        return s.a(Float.valueOf(r4), Float.valueOf(r5));
    L10:
        if (r6.getWidth() == 0) goto L29;
        if (r6.getHeight() == 0) goto L29;
        float r0 = r6.getX() + r6.getWidth();
        float r1 = r6.getY() + r6.getHeight();
        if (r4 >= 0.0f) goto L18;
        r4 = 0.0f;
    L21:
        if (r5 >= 0.0f) goto L24;
        r5 = 0.0f;
    L27:
        return s.a(Float.valueOf(r4), Float.valueOf(r5));
    L24:
        if (r5 <= r1) goto L27;
        r5 = r1;
        goto L27
    L18:
        if (r4 <= r0) goto L21;
        r4 = r0;
    L29:
        return s.a(Float.valueOf(r4), Float.valueOf(r5));
    L5:
        r6 = null;
        goto L6
    }

    private final d.m<Float, Float> a(View r2) {
        return s.a(Float.valueOf(r2.getX() + (r2.getWidth() / 2)), Float.valueOf(r2.getY() + (r2.getHeight() / 2)));
    }

    private final d.m<Float, Float> a(View r1, float r2, float r3) {
        return s.a(Float.valueOf(r2 - (r1.getWidth() / 2)), Float.valueOf(r3 - (r1.getHeight() / 2)));
    }

    static /* synthetic */ void a(a r0, View r1, View r2, float r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = 0.0f;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(View r4, View r5, float r6) {
        d.m<Float, Float> r7 = a(r5);
        d.m<Float, Float> r3 = a(r4, ((Number) ZeusTransformUtils.preCheckCast(r7.c(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r7.d(), Number.class, "com.obric.aiagent.plugin")).floatValue());
        float r8 = ((Number) ZeusTransformUtils.preCheckCast(r3.c(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r9 = ((Number) ZeusTransformUtils.preCheckCast(r3.d(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        r4.setX(r8);
        r4.setY(r9 + r6);
    }

    private final void m() {
        this.f25378b.setScaleX(1.0f);
        this.f25378b.setScaleY(1.0f);
        this.f25378b.setAlpha(1.0f);
        this.f25379c.setScaleX(1.0f);
        this.f25379c.setScaleY(1.0f);
        this.f25379c.setAlpha(1.0f);
    }

    private final void j() {
        Resources r1 = Resources.getSystem();
        d.h.b.o.c(r1, "Resources.getSystem()");
        final int r3 = d.i.a.a(TypedValue.applyDimension(1, 6, r1.getDisplayMetrics()));
        final float r10 = this.f25378b.getX();
        final float r11 = this.f25378b.getY();
        final z.d r5 = new z.d();
        r5.f38502a = this.f25379c.getWidth();
        final z.c r6 = new z.c();
        r6.f38501a = this.f25379c.getX();
        final z.c r7 = new z.c();
        r7.f38501a = this.f25379c.getY();
        this.i = com.obric.autoaction.vdplayer.components.cursor.a.a.a(com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a().b(30.0f), 0.0f, 6.2831855f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(DownloadErrorCode.ERROR_CRONET_HTTP_ERROR_END, 0, e.d.f32443a), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a(new $$Lambda$a$j4Hv35AY1qhFPeHQ7sr45WDOFg(this, r10, r3, r11, r5, r6, r7)).a(new $$Lambda$a$KgYL5mthsKDgqn97g3RjWHbLve8(this, r10, r11)).a(), null, com.obric.common.oea.foundation.animation.d.a.f32341b, 1, null);
        AiStrokeView r0 = com.obric.autoaction.vdplayer.components.c.a();
        if (r0 == null) goto L6;
        r0.syncAnimation();
        return;
    }

    static {
        f25377a = new C0621a(null);
        m = Color.parseColor("#99FFFFFF");
        n = Color.parseColor("#66FFFFFF");
    }
}
