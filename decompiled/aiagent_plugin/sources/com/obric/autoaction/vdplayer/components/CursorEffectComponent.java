package com.obric.autoaction.vdplayer.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.components.cursor.CursorPressDownEffectView;
import com.obric.autoaction.vdplayer.components.cursor.CursorThoughtTextView;
import com.obric.autoaction.vdplayer.d.f;
import com.obric.autoaction.vdplayer.d.l;
import com.obric.autoaction.vdplayer.d.s;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.common.oea.foundation.animation.AnimationLifecycleListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.x;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: CursorEffectComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CursorEffectComponent extends BaseVDPlayerSlotComponent<b> {
    private static final String TAG = "CursorEffectComponent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25235a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.autogui.vdplayer.a.a f25236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autoaction.vdplayer.components.cursor.b f25237c;

    /* JADX INFO: compiled from: CursorEffectComponent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: CursorEffectComponent.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l f25238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f25239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final f f25240c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f25238a == r6.f25238a) goto L12;
            return false;
        L12:
            if (this.f25239b == r6.f25239b) goto L15;
            return false;
        L15:
            if (o.a(this.f25240c, r6.f25240c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f25238a.hashCode() * 31) + Boolean.hashCode(this.f25239b)) * 31;
            f r2 = this.f25240c;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "CursorEffectState(panelStatus=" + this.f25238a + ", isUserOperating=" + this.f25239b + ", cursorActionState=" + this.f25240c + ')';
        }

        public b(l r2, boolean r3, f r4) {
            o.e(r2, "panelStatus");
            this.f25238a = r2;
            this.f25239b = r3;
            this.f25240c = r4;
        }

        public final l a() {
            return this.f25238a;
        }

        public final boolean b() {
            return this.f25239b;
        }

        public final f c() {
            return this.f25240c;
        }
    }

    /* JADX INFO: compiled from: CursorEffectComponent.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25241a = null;

        static {
            int[] r0 = new int[l.values().length];
            r0[l.f25507a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[l.f25508b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[l.f25509c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[l.f25510d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[l.f25511e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[l.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[l.g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f25241a = r0;
        }
    }

    /* JADX INFO: compiled from: CursorEffectComponent.kt */
    @d.c.b.a.f(b = "CursorEffectComponent.kt", c = {62}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.CursorEffectComponent$onViewCreated$1")
    static final class d extends d.c.b.a.l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.a.c f25243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f25244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ CursorEffectComponent f25245d;

        d(com.obric.autoaction.a.c r3, View r4, CursorEffectComponent r5, d.c.d<? super d> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25243b = r3;
            this.f25244c = r4;
            this.f25245d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f25243b, this.f25244c, this.f25245d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25242a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r7);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            ab<com.obric.autoaction.vdplayer.components.cursor.c> r8 = com.obric.autoaction.vdplayer.components.cursor.d.f25391a.a();
            final com.obric.autoaction.a.c r3 = this.f25243b;
            final View r4 = this.f25244c;
            final CursorEffectComponent r5 = this.f25245d;
            i<? super com.obric.autoaction.vdplayer.components.cursor.c> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3, r4, r5), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25242a = 1;
            if (r8.collect(r2, r6) != r0) goto L12;
            return r0;
        }
    }

    static {
        f25235a = new a(null);
    }

    public static /* synthetic */ String lambda$4WoH0pj_qFoC6hlumHOil5OyMow(b r0) {
        return a(r0);
    }

    public static /* synthetic */ b lambda$Y15IS1Jq00tigtOnt3CpJiuoZqc(s r0) {
        return a(r0);
    }

    public CursorEffectComponent() {
        super($$Lambda$CursorEffectComponent$Y15IS1Jq00tigtOnt3CpJiuoZqc.INSTANCE);
    }

    public static final /* synthetic */ com.obric.autoaction.vdplayer.components.cursor.b a(CursorEffectComponent r0) {
        return r0.f25237c;
    }

    public static final /* synthetic */ void a(CursorEffectComponent r0, f r1, boolean r2) {
        r0.a(r1, r2);
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3, Object r4) {
        a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin"));
    }

    private static final b a(s r3) {
        o.e(r3, "it");
        return new b(r3.b().a().a(), r3.g(), r3.f());
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r6, com.obric.autoaction.a.c r7) {
        o.e(r6, "container");
        o.e(r7, "componentHost");
        View r8 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.vd_component_cursor_effect_layout, "layout", "vd_component_cursor_effect_layout"), r6, false, "com.obric.aiagent.plugin");
        com.obric.autogui.vdplayer.a.a r0 = com.obric.autogui.vdplayer.a.a.a(r8);
        this.f25236b = r0;
        CursorPressDownEffectView r2 = null;
        if (r0 == null) goto L5;
        View r1 = r0.f31585b;
    L6:
        com.obric.autogui.vdplayer.a.a r3 = this.f25236b;
        if (r3 == null) goto L9;
        CursorThoughtTextView r4 = r3.f31586c;
    L10:
        com.obric.autogui.vdplayer.a.a r5 = this.f25236b;
        if (r5 == null) goto L13;
        r2 = r5.f31587d;
    L13:
        if (r1 == null) goto L17;
        if (r4 == null) goto L17;
        if (r2 == null) goto L17;
        this.f25237c = (com.obric.autoaction.vdplayer.components.cursor.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.vdplayer.components.cursor.a(r1, r4, r2, r7), com.obric.autoaction.vdplayer.components.cursor.b.class, "com.obric.aiagent.plugin");
    L17:
        o.a(r8);
        return r8;
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.autoaction.vdplayer.components.BaseVDPlayerComponent, com.obric.autoaction.a.h
    public void a(View r8, com.obric.autoaction.a.c r9) {
        o.e(r8, "boundView");
        o.e(r9, "componentHost");
        super.a(r8, r9);
        kotlinx.coroutines.i.a(r9.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new d(r9, r8, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public void a(b r4, final b r5) {
        o.e(r5, "state");
        super.a(r4, r5);
        Loog.INSTANCE.dp(TAG, new $$Lambda$CursorEffectComponent$4WoH0pj_qFoC6hlumHOil5OyMow(r5));
        com.obric.autoaction.vdplayer.components.cursor.b r0 = this.f25237c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r5.b() == false) goto L9;
        r0.c();
        return;
    L9:
        l r1 = r5.a();
        switch(c.f25241a[r1.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L13;
            case 7: goto L13;
            default: goto L12;
        };
    L13:
        r0.c();
        return;
    L14:
        r0.a();
        if (r5.c() == null) goto L28;
        f r2 = r5.c();
        if (r4 == null) goto L19;
        f r3 = r4.c();
    L21:
        if (o.a(r2, r3) == true) goto L29;
        if (r4 == null) goto L24;
        boolean r6 = true;
    L25:
        a(r5.c(), r6);
        return;
    L24:
        r6 = false;
        goto L25
    L29:
        return;
    L19:
        r3 = null;
        goto L21
    L28:
        return;
    L12:
        throw new k();
    }

    private static final String a(b r2) {
        return "render: " + r2;
    }

    private final void a(f r19, boolean r20) {
        com.obric.autoaction.vdplayer.components.cursor.b r9 = this.f25237c;
        if (r9 != null) goto L5;
        return;
    L5:
        Loog.INSTANCE.i(TAG, "handleCursorAction: " + r19);
        List<Float> r10 = r19.b();
        String r11 = r19.a();
        List<Float> r12 = r19.c();
        if (r10 == null) goto L10;
        com.obric.autoaction.vdplayer.components.cursor.b.a.a(r9, ((Number) ZeusTransformUtils.preCheckCast(r10.get(0), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r10.get(1), Number.class, "com.obric.aiagent.plugin")).floatValue(), null, null, r20, 12, null);
        if (r20 == false) goto L10;
        r9.d();
    L10:
        if (r12 == null) goto L30;
        Float r14 = (Float) ZeusTransformUtils.preCheckCast(p.d(r12, 0), Float.class, "com.obric.aiagent.plugin");
        Float r13 = (Float) ZeusTransformUtils.preCheckCast(p.d(r12, 1), Float.class, "com.obric.aiagent.plugin");
        Float r16 = (Float) ZeusTransformUtils.preCheckCast(p.d(r12, 2), Float.class, "com.obric.aiagent.plugin");
        Float r15 = (Float) ZeusTransformUtils.preCheckCast(p.d(r12, 3), Float.class, "com.obric.aiagent.plugin");
        if (r20 == false) goto L27;
        float r17 = 0.0f;
        if (r14 == null) goto L16;
        float r1 = r14.floatValue();
    L17:
        if (r13 == null) goto L19;
        float r2 = r13.floatValue();
    L20:
        com.obric.autoaction.vdplayer.components.cursor.b.a.a(r9, r1, r2, null, null, false, 28, null);
        if (r16 == null) goto L23;
        float r0 = r16.floatValue();
    L24:
        if (r15 == null) goto L26;
        r17 = r15.floatValue();
    L26:
        r9.a(r0, r17, r14, r13);
        goto L30
    L23:
        r0 = 0.0f;
        goto L24
    L19:
        r2 = 0.0f;
        goto L20
    L16:
        r1 = 0.0f;
        goto L17
    L27:
        if (r16 == null) goto L30;
        if (r15 == null) goto L30;
        com.obric.autoaction.vdplayer.components.cursor.b.a.a(r9, r16.floatValue(), r15.floatValue(), null, null, false, 12, null);
    L30:
        r9.a(r11, r20);
        if (r12 != null) goto L35;
        if (r10 != null) goto L36;
        r9.e();
        return;
    L36:
        return;
    }

    @Override // androidx.lifecycle.d
    public void d(androidx.lifecycle.p r3) {
        androidx.lifecycle.p r4 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r3, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.d(r4);
        AnimationLifecycleListener.f32287a.a();
        com.obric.autoaction.vdplayer.components.cursor.b r2 = this.f25237c;
        if (r2 == null) goto L6;
        r2.f();
        return;
    }

    @Override // androidx.lifecycle.d
    public void e(androidx.lifecycle.p r3) {
        androidx.lifecycle.p r4 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r3, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.e(r4);
        this.f25237c = null;
        this.f25236b = null;
    }
}
