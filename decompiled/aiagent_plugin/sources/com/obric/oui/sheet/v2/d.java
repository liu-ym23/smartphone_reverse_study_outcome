package com.obric.oui.sheet.v2;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.o;
import d.h.b.p;
import d.h.b.z;
import d.l.n;
import d.m;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SheetAnimStyle.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f36236a = null;

    /* JADX INFO: compiled from: SheetAnimStyle.kt */
    static final class a extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f36237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f36238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Window f36239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f36240d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f36241e;
        final /* synthetic */ float f;
        final /* synthetic */ float g;
        final /* synthetic */ View h;
        final /* synthetic */ View i;
        final /* synthetic */ Runnable j;

        a(boolean r3, boolean r4, Window r5, float r6, float r7, float r8, float r9, View r10, View r11, Runnable r12) {
            Runnable r13 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r12, Runnable.class, "com.obric.aiagent.plugin");
            this.f36237a = r3;
            this.f36238b = r4;
            this.f36239c = r5;
            this.f36240d = r6;
            this.f36241e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r13;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r5, Object r6, Object r7) {
            o.e(r5, "$noName_0");
            o.e(r6, "value");
            o.e(r7, "$noName_2");
            if (this.f36237a == false) goto L9;
            if (this.f36238b == false) goto L7;
            d r8 = d.f36236a;
            Window r0 = this.f36239c;
            o.a(r0);
            d.a(r8, r0, com.obric.oui.d.b.c(((Float) ZeusTransformUtils.preCheckCast(r6, Float.class, "com.obric.aiagent.plugin")).floatValue(), this.f36240d, this.f36241e), this.f, this.g);
            goto L9
        L7:
            d r9 = d.f36236a;
            View r1 = this.h;
            o.a(r1);
            d.a(r9, r1, com.obric.oui.d.b.c(((Float) ZeusTransformUtils.preCheckCast(r6, Float.class, "com.obric.aiagent.plugin")).floatValue(), this.f36240d, this.f36241e), this.f, this.g);
        L9:
            if (((Float) ZeusTransformUtils.preCheckCast(r6, Float.class, "com.obric.aiagent.plugin")).floatValue() <= this.i.getHeight()) goto L15;
            Runnable r4 = this.j;
            if (r4 == null) goto L16;
            r4.run();
            return;
        L16:
            return;
        }
    }

    /* JADX INFO: compiled from: SheetAnimStyle.kt */
    static final class b extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f36242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f36243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Window f36244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f36245d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f36246e;
        final /* synthetic */ float f;
        final /* synthetic */ float g;
        final /* synthetic */ View h;

        b(boolean r1, boolean r2, Window r3, float r4, float r5, float r6, float r7, View r8) {
            this.f36242a = r1;
            this.f36243b = r2;
            this.f36244c = r3;
            this.f36245d = r4;
            this.f36246e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r3, Object r4, Object r5) {
            o.e(r3, "$noName_0");
            o.e(r4, "value");
            o.e(r5, "$noName_2");
            if (this.f36242a == true) goto L5;
            return;
        L5:
            if (this.f36243b == false) goto L7;
            d r6 = d.f36236a;
            Window r0 = this.f36244c;
            o.a(r0);
            d.a(r6, r0, com.obric.oui.d.b.c(((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue(), this.f36245d, this.f36246e), this.f, this.g);
            return;
        L7:
            d r7 = d.f36236a;
            View r1 = this.h;
            o.a(r1);
            d.a(r7, r1, com.obric.oui.d.b.c(((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue(), this.f36245d, this.f36246e), this.f, this.g);
        }
    }

    /* JADX INFO: compiled from: SheetAnimStyle.kt */
    static final class c extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f36247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f36248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Window f36249c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f36250d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f36251e;
        final /* synthetic */ float f;
        final /* synthetic */ View g;

        c(boolean r1, boolean r2, Window r3, float r4, float r5, float r6, View r7) {
            this.f36247a = r1;
            this.f36248b = r2;
            this.f36249c = r3;
            this.f36250d = r4;
            this.f36251e = r5;
            this.f = r6;
            this.g = r7;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r4, Object r5, Object r6) {
            o.e(r4, "$noName_0");
            o.e(r5, "value");
            o.e(r6, "$noName_2");
            if (this.f36247a == true) goto L5;
            return;
        L5:
            if (this.f36248b == false) goto L7;
            d r7 = d.f36236a;
            Window r1 = this.f36249c;
            o.a(r1);
            d.a(r7, r1, com.obric.oui.d.b.c(((Float) ZeusTransformUtils.preCheckCast(r5, Float.class, "com.obric.aiagent.plugin")).floatValue(), this.f36250d, this.f36251e), 0.0f, this.f);
            return;
        L7:
            d r8 = d.f36236a;
            View r2 = this.g;
            o.a(r2);
            d.a(r8, r2, com.obric.oui.d.b.c(((Float) ZeusTransformUtils.preCheckCast(r5, Float.class, "com.obric.aiagent.plugin")).floatValue(), this.f36250d, this.f36251e), 0.0f, this.f);
        }
    }

    static {
        f36236a = new d();
    }

    private d() {
    }

    public static final /* synthetic */ void a(d r0, View r1, float r2, float r3, float r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(d r0, Window r1, float r2, float r3, float r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.a.b.a a(d r7, View r8, Window r9, View r10, boolean r11, boolean r12, float r13, Integer r14, int r15, Object r16) {
        Integer r1 = null;
        if ((r15 & 1) == 0) goto L5;
        Window r0 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        View r2 = null;
    L10:
        boolean r4 = true;
        if ((r15 & 4) == 0) goto L13;
        boolean r3 = true;
    L15:
        if ((r15 & 8) != 0) goto L19;
        r4 = r12;
    L19:
        if ((r15 & 16) == 0) goto L21;
        float r5 = 0.6f;
    L23:
        if ((r15 & 32) != 0) goto L27;
        r1 = r14;
    L27:
        return r7.a(r8, r0, r2, r3, r4, r5, r1);
    L21:
        r5 = r13;
        goto L23
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L10
    L5:
        r0 = r9;
        goto L7
    }

    public final com.obric.common.oea.foundation.animation.a.b.a a(View r19, Window r20, View r21, boolean r22, boolean r23, float r24, Integer r25) {
        o.e(r19, "<this>");
        if (r25 != null) goto L5;
        int r0 = Resources.getSystem().getDisplayMetrics().heightPixels;
    L6:
        int r3 = r0;
        if (r22 == false) goto L14;
        if (r23 == false) goto L14;
        if (r20 == null) goto L14;
        r20.addFlags(2);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        a("SheetAnimStyle", o.a("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L14:
        int r1 = r19.getHeight() + g.a(r19, 32);
        r19.setAlpha(1.0f);
        float r2 = r1;
        r19.setTranslationY(r2);
        m<Float, Float> r4 = a(r19.getHeight() / r3, true);
        float r7 = ((Number) ZeusTransformUtils.preCheckCast(r4.c(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r5 = ((Number) ZeusTransformUtils.preCheckCast(r4.d(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r8 = g.a(r19, 2);
        com.obric.common.oea.foundation.animation.a.b.a r10 = b(r19, ZeusTransformUtils.mapRes(R.id.o_dialog_anim_in, DbHelper.COL_ID, "o_dialog_anim_in"));
        com.obric.common.oea.foundation.animation.h.a.EnumC0885a r11 = com.obric.common.oea.foundation.animation.h.a.EnumC0885a.i;
        Float r12 = Float.valueOf(r2);
        com.obric.common.oea.foundation.animation.g.a.b r6 = com.obric.common.oea.foundation.animation.g.b.a(r7, r5, 0, 4, null);
        r6.a(1.0f);
        x r9 = x.f38692a;
        return com.obric.common.oea.foundation.animation.a.b.a.a(r10, r11, r12, r8, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(r6, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null).a((q) ZeusTransformUtils.preCheckCast(new c(r22, r23, r20, r2, r8, r24, r21), q.class, "com.obric.aiagent.plugin"));
    L5:
        r0 = r25.intValue();
        goto L6
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.a.b.a a(d r8, View r9, Window r10, View r11, boolean r12, boolean r13, float r14, Runnable r15, Integer r16, int r17, Object r18) {
        Runnable r0 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r15, Runnable.class, "com.obric.aiagent.plugin");
        Integer r2 = null;
        if ((r17 & 1) == 0) goto L5;
        Window r1 = null;
    L7:
        if ((r17 & 2) == 0) goto L9;
        View r3 = null;
    L10:
        boolean r5 = true;
        if ((r17 & 4) == 0) goto L13;
        boolean r4 = true;
    L15:
        if ((r17 & 8) != 0) goto L19;
        r5 = r13;
    L19:
        if ((r17 & 16) == 0) goto L21;
        float r6 = 0.0f;
    L23:
        if ((r17 & 32) == 0) goto L26;
        r0 = null;
    L26:
        if ((r17 & 64) != 0) goto L30;
        r2 = r16;
    L30:
        return r8.a(r9, r1, r3, r4, r5, r6, r0, r2);
    L21:
        r6 = r14;
        goto L23
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L10
    L5:
        r1 = r10;
        goto L7
    }

    public final com.obric.common.oea.foundation.animation.a.b.a a(View r21, Window r22, View r23, boolean r24, boolean r25, float r26, Runnable r27, Integer r28) {
        Runnable r11 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r27, Runnable.class, "com.obric.aiagent.plugin");
        o.e(r21, "<this>");
        if (r28 != null) goto L5;
        int r0 = Resources.getSystem().getDisplayMetrics().heightPixels;
    L6:
        int r2 = r0;
        if (r24 == false) goto L15;
        if (r25 == false) goto L15;
        if (r22 == null) goto L15;
        r22.addFlags(2);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        a("SheetAnimStyle", o.a("dialogBottomHide, can't show dim anim: ", e.getMessage()));
    L15:
        int r1 = r21.getHeight() + g.a(r21, 32);
        m<Float, Float> r3 = a(r21.getHeight() / r2, false);
        float r5 = ((Number) ZeusTransformUtils.preCheckCast(r3.c(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r4 = ((Number) ZeusTransformUtils.preCheckCast(r3.d(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r6 = r21.getTranslationY();
        float r7 = r1;
        float r8 = 0.0f;
        if (r25 == false) goto L23;
        if (r22 == null) goto L26;
        WindowManager.LayoutParams r9 = r22.getAttributes();
        if (r9 == null) goto L26;
        r8 = r9.dimAmount;
    L26:
        com.obric.common.oea.foundation.animation.a.b.a r14 = b(r21, ZeusTransformUtils.mapRes(R.id.o_dialog_anim_out, DbHelper.COL_ID, "o_dialog_anim_out"));
        com.obric.common.oea.foundation.animation.h.a.EnumC0885a r15 = com.obric.common.oea.foundation.animation.h.a.EnumC0885a.i;
        float r10 = r21.getTranslationY();
        com.obric.common.oea.foundation.animation.g.a.b r12 = com.obric.common.oea.foundation.animation.g.b.a(r5, r4, 0, 4, null);
        r12.a(1.0f);
        com.obric.common.oea.foundation.animation.a.b.a r13 = r14.a(r15, Float.valueOf(r10), r7, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(r12, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), Float.valueOf(r26)).a((q) ZeusTransformUtils.preCheckCast(new a(r24, r25, r22, r6, r7, r8, 0.0f, r23, r21, r11), q.class, "com.obric.aiagent.plugin"));
        com.obric.oui.animation.style.b.b(r21);
        return r13;
    L23:
        if (r23 == null) goto L26;
        r8 = r23.getAlpha();
        goto L26
    L5:
        r0 = r28.intValue();
        goto L6
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.a.b.a a(d r8, View r9, Window r10, View r11, boolean r12, boolean r13, float r14, float r15, Integer r16, int r17, Object r18) {
        Integer r1 = null;
        if ((r17 & 1) == 0) goto L5;
        Window r0 = null;
    L7:
        if ((r17 & 2) == 0) goto L9;
        View r2 = null;
    L10:
        boolean r4 = true;
        if ((r17 & 4) == 0) goto L13;
        boolean r3 = true;
    L15:
        if ((r17 & 8) != 0) goto L19;
        r4 = r13;
    L19:
        if ((r17 & 16) == 0) goto L21;
        float r5 = 0.6f;
    L23:
        if ((r17 & 32) == 0) goto L25;
        float r6 = 0.0f;
    L27:
        if ((r17 & 64) != 0) goto L31;
        r1 = r16;
    L31:
        return r8.a(r9, r0, r2, r3, r4, r5, r6, r1);
    L25:
        r6 = r15;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L10
    L5:
        r0 = r10;
        goto L7
    }

    public final com.obric.common.oea.foundation.animation.a.b.a a(View r18, Window r19, View r20, boolean r21, boolean r22, float r23, float r24, Integer r25) {
        o.e(r18, "<this>");
        if (r25 != null) goto L5;
        int r0 = Resources.getSystem().getDisplayMetrics().heightPixels;
    L6:
        r18.setAlpha(1.0f);
        float r5 = 0.0f;
        if (r22 == false) goto L14;
        if (r19 == null) goto L17;
        WindowManager.LayoutParams r6 = r19.getAttributes();
        if (r6 == null) goto L17;
        r5 = r6.dimAmount;
    L17:
        float r7 = r5;
        m<Float, Float> r1 = a(r18.getHeight() / r0, true);
        float r8 = ((Number) ZeusTransformUtils.preCheckCast(r1.c(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r9 = ((Number) ZeusTransformUtils.preCheckCast(r1.d(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        if (r21 == false) goto L26;
        if (r22 == false) goto L26;
        if (r19 == null) goto L26;
        r19.addFlags(2);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        a("SheetAnimStyle", o.a("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L26:
        float r2 = r18.getTranslationY();
        com.obric.common.oea.foundation.animation.a.b.a r11 = b(r18, ZeusTransformUtils.mapRes(R.id.o_dialog_anim_in, DbHelper.COL_ID, "o_dialog_anim_in"));
        com.obric.common.oea.foundation.animation.h.a.EnumC0885a r12 = com.obric.common.oea.foundation.animation.h.a.EnumC0885a.i;
        float r3 = r18.getTranslationY();
        com.obric.common.oea.foundation.animation.g.a.b r4 = com.obric.common.oea.foundation.animation.g.b.a(r8, r9, 0, 4, null);
        r4.a(1.0f);
        return r11.a(r12, Float.valueOf(r3), 0.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(r4, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), Float.valueOf(r24)).a((q) ZeusTransformUtils.preCheckCast(new b(r21, r22, r19, r2, 0.0f, r7, r23, r20), q.class, "com.obric.aiagent.plugin"));
    L14:
        if (r20 == null) goto L17;
        r5 = r20.getAlpha();
        goto L17
    L5:
        r0 = r25.intValue();
        goto L6
    }

    public final void a(View r4) {
        o.e(r4, "container");
        int r3 = g.a(r4, 10);
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == true) goto L5;
    L7:
        r4.setLayoutParams(r0);
        return;
    L5:
        if (((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).topMargin >= r3) goto L7;
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).topMargin = r3;
        goto L7
    }

    private final void a(View r2, float r3, float r4, float r5) {
        float r6 = r5 - r4;     // Catch: Exception -> L5
        r2.setAlpha(r4 + (r6 * n.a(r3, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a("SheetAnimStyle", o.a("updateDimViewWithAnim: ", e.getMessage()));
    }

    private final void a(Window r2, float r3, float r4, float r5) {
        float r6 = r5 - r4;     // Catch: Exception -> L5
        r2.setDimAmount(r4 + (r6 * n.a(r3, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a("SheetAnimStyle", o.a("updateWindowDimWithAnim: ", e.getMessage()));
    }

    private final m<Float, Float> a(float r6, boolean r7) {
        float r1 = 1.0f - com.obric.common.oea.foundation.animation.h.e.a.f32428a.a();
        if (r7 == false) goto L7;
        return new m(Float.valueOf(r1), Float.valueOf(a(com.obric.oui.d.b.a(r6, 0.3f, 0.6f, com.obric.common.oea.foundation.animation.h.e.c.f32442e.a() / 1000.0f, com.obric.common.oea.foundation.animation.h.e.c.g.a() / 1000.0f))));
    L7:
        return new m(Float.valueOf(r1), Float.valueOf(a(com.obric.oui.d.b.a(r6, 0.3f, 0.6f, com.obric.common.oea.foundation.animation.h.e.c.f32441d.a() / 1000.0f, com.obric.common.oea.foundation.animation.h.e.c.f.a() / 1000.0f))));
    }

    public final float a(float r3) {
        return (float) Math.pow(6.283185307179586d / ((double) r3), 2.0d);
    }

    private final <T extends View> com.obric.common.oea.foundation.animation.a.b.a b(T r3, int r4) {
        com.obric.oui.d.c r2 = com.obric.oui.d.c.f35012a;
        Object r5 = r3.getTag(r4);
        if (r5 != null) goto L6;
    L4:
        r5 = null;
    L7:
        com.obric.common.oea.foundation.animation.a.b.a r6 = (com.obric.common.oea.foundation.animation.a.b.a) ZeusTransformUtils.preCheckCast(r5, com.obric.common.oea.foundation.animation.a.b.a.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L11;
        com.obric.common.oea.foundation.animation.a.b.a r7 = new com.obric.common.oea.foundation.animation.a.b.a(r3);
        r3.setTag(r4, r7);
        return r7;
    L11:
        return r6;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.common.oea.foundation.animation.a.b.a.class) == false) goto L4;
        goto L4
    }

    public final <T extends View> void a(T r1, int r2) {
        o.e(r1, "<this>");
        r1.setTag(r2, null);
    }

    public static /* synthetic */ boolean a(d r0, View r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = 0.333333f;
    L6:
        return r0.a(r1, r2, r3);
    }

    public final boolean a(View r12, float r13, float r14) {
        o.e(r12, "view");
        if ((r12.getTranslationY() / r12.getHeight()) <= r14) goto L6;
        return true;
    L6:
        if ((a(this, r12.getTranslationY(), r13, 0.0d, 0.0d, 12, null) / r12.getHeight()) > r14) goto L10;
        return false;
    L10:
        return true;
    }

    public static /* synthetic */ float a(d r7, float r8, float r9, double r10, double r12, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = 0.5d;
    L5:
        double r3 = r10;
        if ((r14 & 8) == 0) goto L9;
        r12 = 0.1d;
    L9:
        return r7.a(r8, r9, r3, r12);
    }

    public final float a(float r3, float r4, double r5, double r7) {
        z.b r2 = new z.b();
        r2.f38500a = n.b(1.0E-7d, Math.abs(r7));
        return a(r2, n.b(1.0E-4d, r5) * (-4.2d), r3, r4);
    }

    private static final float a(z.b r6, double r7, float r9, float r10) {
        if (Math.abs(r10) > r6.f38500a) goto L5;
        return r9;
    L5:
        double r2 = r10;
        double r4 = 1000;
        double r0 = (Math.log(Math.abs(r6.f38500a / r2)) / r7) * r4;
        double r3 = r2 / r7;
        return (float) ((((double) r9) - r3) + (r3 * Math.exp((r7 * r0) / r4)));
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
