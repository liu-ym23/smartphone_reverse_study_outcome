package com.obric.oui.dialog.a;

import android.content.Context;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.h.b.z;
import d.k;
import d.l.n;
import d.m;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: DialogAnimStyle.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "DialogAnimStyle";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35019a = null;

    /* JADX INFO: renamed from: com.obric.oui.dialog.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DialogAnimStyle.kt */
    public static final enum EnumC0948a extends Enum<EnumC0948a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0948a f35020a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0948a f35021b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0948a f35022c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ EnumC0948a[] f35023e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f35024d;

        private static final /* synthetic */ EnumC0948a[] b() {
            return new EnumC0948a[]{f35020a, f35021b, f35022c};
        }

        public static EnumC0948a valueOf(String r2) {
            return (EnumC0948a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0948a.class, r2), EnumC0948a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0948a[] values() {
            return (EnumC0948a[]) ZeusTransformUtils.preCheckCast(f35023e.clone(), EnumC0948a[].class, "com.obric.aiagent.plugin");
        }

        private EnumC0948a(String r1, int r2, float r3) {
            super(r1, r2);
            this.f35024d = r3;
        }

        public final float a() {
            return this.f35024d;
        }

        static {
            f35020a = new EnumC0948a("SMALL", 0, 0.4f);
            f35021b = new EnumC0948a("MEDIUM", 1, 0.8f);
            f35022c = new EnumC0948a("LARGE", 2, 1.0f);
            f35023e = b();
        }
    }

    /* JADX INFO: compiled from: DialogAnimStyle.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35025a = null;

        static {
            int[] r0 = new int[EnumC0948a.values().length];
            r0[EnumC0948a.f35020a.ordinal()] = 1;
            r0[EnumC0948a.f35021b.ordinal()] = 2;
            r0[EnumC0948a.f35022c.ordinal()] = 3;
            f35025a = r0;
        }
    }

    /* JADX INFO: compiled from: DialogAnimStyle.kt */
    static final class c extends p implements d.h.a.b<com.obric.oui.animation.a.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f35026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f35027b;

        c(float r1, float r2) {
            this.f35026a = r1;
            this.f35027b = r2;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.a r3) {
            a((com.obric.oui.animation.a.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.a r2) {
            o.e(r2, "$this$translationY");
            r2.c(this.f35026a);
            r2.e(this.f35027b);
        }
    }

    /* JADX INFO: compiled from: DialogAnimStyle.kt */
    static final class d extends p implements d.h.a.b<com.obric.oui.animation.a.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f35028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f35029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f35030c;

        d(float r1, float r2, int r3) {
            this.f35028a = r1;
            this.f35029b = r2;
            this.f35030c = r3;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.a r3) {
            a((com.obric.oui.animation.a.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.a r2) {
            o.e(r2, "$this$translationY");
            r2.c(this.f35028a);
            r2.e(this.f35029b);
            r2.a(this.f35030c);
        }
    }

    static {
        f35019a = new a();
    }

    /* JADX INFO: renamed from: lambda$RCZm4p7fpCojtxr67eS-QPOxrik, reason: not valid java name */
    public static /* synthetic */ void m1000lambda$RCZm4p7fpCojtxr67eSQPOxrik(Window r0, float r1, float r2, float r3, com.obric.oui.animation.engine.b r4, float r5, float r6) {
        a(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void lambda$WvMn_haC7u3koHwjcF5sp3JrkSU(Window r0, float r1, float r2, float r3, float r4, z.a r5, com.obric.oui.animation.a.b r6, com.obric.oui.animation.engine.b r7, float r8, float r9) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    private a() {
    }

    public static /* synthetic */ com.obric.oui.animation.a.b a(a r6, View r7, Window r8, boolean r9, float r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r8 = null;
    L5:
        Window r2 = r8;
        if ((r12 & 2) == 0) goto L8;
        boolean r3 = true;
    L10:
        if ((r12 & 4) == 0) goto L12;
        r10 = 0.6f;
    L12:
        float r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        boolean r5 = true;
    L17:
        return r6.a(r7, r2, r3, r4, r5);
    L15:
        r5 = r11;
        goto L17
    L8:
        r3 = r9;
        goto L10
    }

    public final com.obric.oui.animation.a.b<View> a(View r7, final Window r8, boolean r9, final float r10, boolean r11) {
        o.e(r7, "<this>");
        Size r0 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        int r2 = r7.getHeight();
        ViewGroup.LayoutParams r3 = r7.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == true) goto L5;
        r3 = null;
    L5:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L8;
        int r5 = r4.bottomMargin;
    L9:
        int r6 = (r2 + r5) + g.a(r7, 24);
        r7.setAlpha(1.0f);
        m<Float, Float> r12 = a(r11, a(r7, r0.getHeight()), true);
        float r1 = ((Number) ZeusTransformUtils.preCheckCast(r12.c(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r13 = ((Number) ZeusTransformUtils.preCheckCast(r12.d(), Number.class, "com.obric.aiagent.plugin")).floatValue();
        com.obric.oui.animation.a.b r14 = b(r7, ZeusTransformUtils.mapRes(R.id.o_dialog_anim_in, DbHelper.COL_ID, "o_dialog_anim_in"));
        d.h.a.b<? super com.obric.oui.animation.a.a, x> r15 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r1, r13, r6), d.h.a.b.class, "com.obric.aiagent.plugin");
        final float r16 = 0.0f;
        com.obric.oui.animation.a.b<View> r17 = r14.a(0.0f, r15);
        if (r8 == null) goto L17;
        if (r9 == false) goto L17;
        r8.addFlags(2);     // Catch: Exception -> L15
        final float r18 = r6;
        r17.a(new $$Lambda$a$RCZm4p7fpCojtxr67eSQPOxrik(r8, r18, r16, r10));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        a(TAG, o.a("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L17:
        return r17;
    L8:
        r5 = 0;
        goto L9
    }

    private static final void a(Window r0, float r1, float r2, float r3, com.obric.oui.animation.engine.b r4, float r5, float r6) {
        f35019a.a(r0, com.obric.oui.d.b.a(r5, r1, r2), 0.0f, r3);
    }

    public static /* synthetic */ com.obric.oui.animation.a.b a(a r1, View r2, Window r3, boolean r4, boolean r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = true;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r5 = true;
    L12:
        return r1.a(r2, r3, r4, r5);
    }

    public final com.obric.oui.animation.a.b<View> a(View r11, final Window r12, boolean r13, boolean r14) {
        o.e(r11, "<this>");
        Size r1 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        int r4 = r11.getHeight();
        ViewGroup.LayoutParams r5 = r11.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.MarginLayoutParams.class) == true) goto L5;
        r5 = null;
    L5:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L8;
        int r7 = r6.bottomMargin;
    L9:
        int r8 = r4 + r7;
        int r9 = g.a(r11, 24) + r8;
        m<Float, Float> r2 = a(r14, a(r11, r1.getHeight()), false);
        final com.obric.oui.animation.a.b<View> r10 = b(r11, ZeusTransformUtils.mapRes(R.id.o_dialog_anim_out, DbHelper.COL_ID, "o_dialog_anim_out")).a(r9, (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(((Number) ZeusTransformUtils.preCheckCast(r2.c(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r2.d(), Number.class, "com.obric.aiagent.plugin")).floatValue()), d.h.a.b.class, "com.obric.aiagent.plugin"));
        if (r12 == null) goto L17;
        if (r13 == false) goto L17;
        r12.addFlags(2);     // Catch: Exception -> L15
        final float r3 = 0.0f;
        final float r15 = r8;
        final float r16 = r12.getAttributes().dimAmount;     // Catch: Exception -> L15
        final float r17 = 0.0f;
        final z.a r18 = new z.a();     // Catch: Exception -> L15
        r10.a(new $$Lambda$a$WvMn_haC7u3koHwjcF5sp3JrkSU(r12, r3, r15, r16, r17, r18, r10));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        a(TAG, o.a("dialogBottomHide, can't show dim anim: ", e.getMessage()));
    L17:
        com.obric.oui.animation.style.b.b(r11);
        return r10;
    L8:
        r7 = 0;
        goto L9
    }

    private static final void a(Window r0, float r1, float r2, float r3, float r4, z.a r5, com.obric.oui.animation.a.b r6, com.obric.oui.animation.engine.b r7, float r8, float r9) {
        o.e(r5, "$isEnd");
        o.e(r6, "$this_apply");
        f35019a.a(r0, com.obric.oui.d.b.a(r8, r1, r2), r3, r4);
        if (r5.f38499a == false) goto L5;
        return;
    L5:
        if (r8 < r2) goto L9;
        r5.f38499a = true;
        r6.d();
        return;
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

    private final void a(Window r2, float r3, float r4, float r5) {
        float r6 = r5 - r4;     // Catch: Exception -> L5
        r2.setDimAmount(r4 + (r6 * n.a(r3, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a(TAG, o.a("updateWindowDimWithAnim: ", e.getMessage()));
    }

    private final EnumC0948a a(View r1, int r2) {
        if (r2 <= 0) goto L4;
        float r0 = r1.getHeight() / r2;
        if (r0 >= EnumC0948a.f35020a.a()) goto L9;
        return EnumC0948a.f35020a;
    L9:
        if (r0 >= EnumC0948a.f35021b.a()) goto L12;
        return EnumC0948a.f35021b;
    L12:
        return EnumC0948a.f35022c;
    L4:
        return EnumC0948a.f35021b;
    }

    private final m<Float, Float> a(boolean r4, EnumC0948a r5, boolean r6) {
        Float r3 = Float.valueOf(1.0f);
        if (r4 == true) goto L7;
        return new m(r3, Float.valueOf(480.0f));
    L7:
        if (r6 == false) goto L18;
        int r7 = b.f35025a[r5.ordinal()];
        if (r7 == 1) goto L31;
        if (r7 == 2) goto L30;
        if (r7 != 3) goto L15;
        return new m(r3, Float.valueOf(247.0f));
    L15:
        throw new k();
    L30:
        return new m(Float.valueOf(0.85f), Float.valueOf(247.0f));
    L31:
        return new m(Float.valueOf(0.85f), Float.valueOf(439.0f));
    L18:
        int r8 = b.f35025a[r5.ordinal()];
        if (r8 == 1) goto L28;
        if (r8 == 2) goto L33;
        if (r8 != 3) goto L25;
        return new m(r3, Float.valueOf(322.0f));
    L25:
        throw new k();
    L33:
        return new m(Float.valueOf(0.85f), Float.valueOf(322.0f));
    L28:
        return new m(Float.valueOf(0.85f), Float.valueOf(632.0f));
    }

    private final <T extends View> com.obric.oui.animation.a.b<T> b(T r3, int r4) {
        com.obric.oui.d.c r2 = com.obric.oui.d.c.f35012a;
        Object r5 = r3.getTag(r4);
        if (r5 != null) goto L6;
    L4:
        r5 = null;
    L7:
        com.obric.oui.animation.a.b<T> r6 = (com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L11;
        com.obric.oui.animation.a.b<T> r7 = new com.obric.oui.animation.a.b(r3);
        r3.setTag(r4, r7);
        return r7;
    L11:
        return r6;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.animation.a.b.class) == false) goto L4;
        goto L4
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
