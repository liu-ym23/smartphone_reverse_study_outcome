package com.obric.oui.lisitem;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.common.oea.foundation.animation.h.e;
import com.obric.common.oea.foundation.animation.manager.d;
import com.obric.oui.common.util.g;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.x;
import java.util.Arrays;

/* JADX INFO: compiled from: OCardListItemPositionHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35416a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FrameLayout f35417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GradientDrawable f35418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f35419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f35420e;
    private int f;
    private float[] g;
    private d h;

    /* JADX INFO: compiled from: OCardListItemPositionHelper.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.lisitem.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OCardListItemPositionHelper.kt */
    static final class C0958b extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f35421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float[] f35422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float[] f35423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f35424d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f35425e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;

        C0958b(b r1, float[] r2, float[] r3, int r4, int r5, int r6, int r7) {
            this.f35421a = r1;
            this.f35422b = r2;
            this.f35423c = r3;
            this.f35424d = r4;
            this.f35425e = r5;
            this.f = r6;
            this.g = r7;
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
            float r8 = ((Float) ZeusTransformUtils.preCheckCast(r6, Float.class, "com.obric.aiagent.plugin")).floatValue();
            b r9 = this.f35421a;
            b.a(r9, b.a(r9, this.f35422b, this.f35423c, r8));
            if (b.a(this.f35421a) == false) goto L6;
            b.b(this.f35421a).setCornerRadii(b.c(this.f35421a));
        L6:
            if (b.a(this.f35421a) == false) goto L8;
            int r10 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35421a.a(), View.class, "com.obric.aiagent.plugin"), 8);
        L9:
            this.f35421a.a().setPadding(r10, b.a(this.f35421a, this.f35424d, this.f35425e, r8), r10, b.a(this.f35421a, this.f, this.g, r8));
            this.f35421a.a().requestLayout();
            return;
        L8:
            r10 = 0;
            goto L9
        }
    }

    /* JADX INFO: compiled from: OCardListItemPositionHelper.kt */
    static final class c extends p implements m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f35426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float[] f35427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f35428c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f35429d;

        c(b r1, float[] r2, int r3, int r4) {
            this.f35426a = r1;
            this.f35427b = r2;
            this.f35428c = r3;
            this.f35429d = r4;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r3, Throwable r4) {
            if (r3 == false) goto L11;
            b r5 = this.f35426a;
            float[] r6 = this.f35427b;
            float[] r7 = Arrays.copyOf(r6, r6.length);
            o.c(r7, "copyOf(this, size)");
            b.a(r5, r7);
            if (b.a(this.f35426a) == false) goto L7;
            b.b(this.f35426a).setCornerRadii(b.c(this.f35426a));
        L7:
            if (b.a(this.f35426a) == false) goto L9;
            int r8 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35426a.a(), View.class, "com.obric.aiagent.plugin"), 8);
        L10:
            this.f35426a.a().setPadding(r8, this.f35428c, r8, this.f35429d);
            this.f35426a.a().requestLayout();
            goto L11
        L9:
            r8 = 0;
        L11:
            b.a(this.f35426a, null);
        }
    }

    static {
        f35416a = new a(null);
    }

    public b(FrameLayout r7, boolean r8, int r9, int r10) {
        o.e(r7, "cardContainer");
        this.f35417b = r7;
        this.f35418c = new GradientDrawable();
        this.f35419d = true;
        this.f = -1;
        this.g = new float[8];
        this.f35420e = r9;
        a(this, r8, r10, false, 4, null);
    }

    public static final /* synthetic */ int a(b r0, int r1, int r2, float r3) {
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ void a(b r0, d r1) {
        r0.h = r1;
    }

    public static final /* synthetic */ void a(b r0, float[] r1) {
        r0.g = r1;
    }

    public static final /* synthetic */ boolean a(b r0) {
        return r0.f35419d;
    }

    public static final /* synthetic */ float[] a(b r0, float[] r1, float[] r2, float r3) {
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ GradientDrawable b(b r0) {
        return r0.f35418c;
    }

    public static final /* synthetic */ float[] c(b r0) {
        return r0.g;
    }

    public final FrameLayout a() {
        return this.f35417b;
    }

    public final void a(int r7) {
        this.f35420e = r7;
        a(this, this.f35419d, this.f, false, 4, null);
    }

    public final void a(boolean r7) {
        a(this, r7, this.f, false, 4, null);
    }

    public final void a(int r2, boolean r3) {
        a(this.f35419d, r2, r3);
    }

    static /* synthetic */ void a(b r0, boolean r1, int r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        r0.a(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetCardContainerIfNeed");
    }

    private final void a(boolean r25, int r26, boolean r27) {
        if (this.f35419d == r25) goto L5;
    L7:
        d r2 = this.h;
        if (r2 == null) goto L11;
        d.a(r2, false, 1, null);
    L11:
        if (r27 == true) goto L13;
    L17:
        boolean r3 = false;
    L18:
        float[] r6 = this.g;
        float[] r7 = Arrays.copyOf(r6, r6.length);
        o.c(r7, "copyOf(this, size)");
        int r9 = this.f35417b.getPaddingTop();
        int r10 = this.f35417b.getPaddingBottom();
        this.f35419d = r25;
        this.f = r26;
        float[] r11 = new float[8];
        if (r25 == false) goto L34;
        float r0 = g.b((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 20);
        this.f35418c.setColor(this.f35420e);
        int r12 = this.f;
        if (r12 == 1) goto L27;
        if (r12 == 2) goto L26;
        if (r12 == 3) goto L25;
        r11 = new float[]{r0, r0, r0, r0, r0, r0, r0, r0};
    L28:
        if (r3 == false) goto L30;
        float[] r15 = Arrays.copyOf(r7, r7.length);
        o.c(r15, "copyOf(this, size)");
    L31:
        this.g = r15;
        this.f35418c.setCornerRadii(r15);
        this.f35417b.setBackground((Drawable) ZeusTransformUtils.preCheckCast(this.f35418c, Drawable.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.instanceOf(this.f35417b, OUIFrameLayout.class) == false) goto L35;
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(this.f35417b, OUIFrameLayout.class, "com.obric.aiagent.plugin")).setShadowCornerRadius((int) r0);
    L35:
        int r1 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 12);
        int r8 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 8);
        int r13 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 8);
        int r4 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 8);
        int r5 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 2);
        int r14 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 2);
        int r16 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 2);
        int r17 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 2);
        int r18 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 8);
        int r19 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 2);
        int r20 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 8);
        int r21 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 8);
        int r22 = g.a((View) ZeusTransformUtils.preCheckCast(this.f35417b, View.class, "com.obric.aiagent.plugin"), 2);
        ViewGroup.LayoutParams r110 = this.f35417b.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r110, ViewGroup.MarginLayoutParams.class) == false) goto L38;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r110, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L39:
        if (r23 == null) goto L50;
        if (this.f35419d == false) goto L44;
        int r111 = r1;
    L45:
        r23.setMarginStart(r111);
        if (this.f35419d == false) goto L48;
        r8 = r1;
    L48:
        r23.setMarginEnd(r8);
        goto L50
    L44:
        r111 = r8;
    L50:
        if (this.f35419d == false) goto L52;
        this.f35417b.setClipChildren(true);
        this.f35417b.setClipToPadding(true);
        int r24 = 0;
    L54:
        if (this.f35419d == true) goto L57;
        r13 = r24;
    L57:
        this.f35417b.getPaddingTop();
        this.f35417b.getPaddingBottom();
        int r28 = this.f;
        if (r28 == 1) goto L78;
        if (r28 != 2) goto L62;
        int r29 = r16;
        int r30 = r14;
    L82:
        if (r3 == false) goto L84;
        a(r7, r11, r9, r10, r30, r29);
    L85:
        this.f35417b.requestLayout();
        return;
    L84:
        this.f35417b.setPadding(r13, r30, r13, r29);
        goto L85
    L62:
        if (r28 == 3) goto L72;
        boolean r31 = this.f35419d;
        if (r31 == false) goto L66;
        r30 = r20;
    L67:
        if (r31 == false) goto L69;
        int r32 = r21;
    L70:
        r29 = r32;
        goto L82
    L69:
        r32 = r22;
        goto L70
    L66:
        r30 = r24;
        goto L67
    L72:
        if (this.f35419d == false) goto L74;
        int r33 = r18;
    L75:
        r29 = r33;
        r30 = r17;
        goto L82
    L74:
        r33 = r19;
        goto L75
    L78:
        if (this.f35419d == true) goto L81;
        r4 = r24;
    L81:
        r29 = r5;
        r30 = r4;
        goto L82
    L52:
        r24 = 0;
        this.f35417b.setClipChildren(false);
        this.f35417b.setClipToPadding(false);
        goto L54
    L38:
        r23 = null;
        goto L39
    L30:
        r15 = Arrays.copyOf(r11, r11.length);
        o.c(r15, "copyOf(this, size)");
        goto L31
    L25:
        r11 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r0, r0, r0, r0};
        goto L28
    L26:
        r11 = new float[8];
        goto L28
    L27:
        r11 = new float[]{r0, r0, r0, r0, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L28
    L34:
        float[] r34 = Arrays.copyOf(r11, 8);
        o.c(r34, "copyOf(this, size)");
        this.g = r34;
        this.f35417b.setBackground(null);
        goto L35
    L13:
        if (this.f35419d != r25) goto L17;
        if (this.f == (-1)) goto L17;
        r3 = true;
        goto L18
    L5:
        if (this.f != r26) goto L7;
    }

    private final void a(float[] r13, float[] r14, int r15, int r16, int r17, int r18) {
        this.h = com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a(), 0.0f, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.a.f32428a, e.c.f, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a((q) ZeusTransformUtils.preCheckCast(new C0958b(this, r13, r14, r15, r17, r16, r18), q.class, "com.obric.aiagent.plugin")).a((m) ZeusTransformUtils.preCheckCast(new c(this, r14, r17, r18), m.class, "com.obric.aiagent.plugin")).a().a();
    }

    private final float[] a(float[] r6, float[] r7, float r8) {
        float r5 = n.a(r8, 0.0f, 1.0f);
        int r9 = r6.length;
        float[] r0 = new float[r9];
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L5;
        r0[r1] = r6[r1] + ((r7[r1] - r6[r1]) * r5);
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private final int a(int r2, int r3, float r4) {
        return d.i.a.a(r2 + ((r3 - r2) * n.a(r4, 0.0f, 1.0f)));
    }
}
