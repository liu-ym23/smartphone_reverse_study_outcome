package com.obric.oui.lisitem;

import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bg.h;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.layout.OUIFrameLayout;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public class OCardListItemPositionHelper {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f15129h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f15130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GradientDrawable f15131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f15135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public jb.d f15136g;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f15129h = new a(null);
    }

    public OCardListItemPositionHelper(FrameLayout r10, boolean r11, int r12, int r13) {
        q.g(r10, "cardContainer");
        this.f15130a = r10;
        this.f15131b = new GradientDrawable();
        this.f15132c = true;
        this.f15134e = -1;
        this.f15135f = new float[8];
        this.f15133d = r12;
        m(this, r11, r13, false, 4, null);
    }

    public static final /* synthetic */ GradientDrawable a(OCardListItemPositionHelper r10) {
        return r10.f15131b;
    }

    public static final /* synthetic */ float[] b(OCardListItemPositionHelper r10) {
        return r10.f15135f;
    }

    public static final /* synthetic */ boolean c(OCardListItemPositionHelper r10) {
        return r10.f15132c;
    }

    public static final /* synthetic */ int d(OCardListItemPositionHelper r10, int r11, int r12, float r13) {
        return r10.j(r11, r12, r13);
    }

    public static final /* synthetic */ float[] e(OCardListItemPositionHelper r10, float[] r11, float[] r12, float r13) {
        return r10.k(r11, r12, r13);
    }

    public static final /* synthetic */ void f(OCardListItemPositionHelper r10, float[] r11) {
        r10.f15135f = r11;
    }

    public static final /* synthetic */ void g(OCardListItemPositionHelper r10, jb.d r11) {
        r10.f15136g = r11;
    }

    public static /* synthetic */ void m(OCardListItemPositionHelper r10, boolean r11, int r12, boolean r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L6;
        r13 = false;
    L6:
        r10.l(r11, r12, r13);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetCardContainerIfNeed");
    }

    public final void h(final float[] r12, final float[] r13, final int r14, final int r15, final int r16, final int r17) {
        this.f15136g = com.obric.common.oea.foundation.animation.builder.d.a.e(new com.obric.common.oea.foundation.animation.builder.d.a(), 0.0f, 1.0f, kb.a.d(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 8, null).g(new OCardListItemPositionHelper$animatePositionChange$1(this, r12, r13, r14, r16, r15, r17)).f(new OCardListItemPositionHelper$animatePositionChange$2(this, r13, r16, r17)).c().a();
    }

    public final FrameLayout i() {
        return this.f15130a;
    }

    public final int j(int r10, int r11, float r12) {
        return yf.b.b(r10 + ((r11 - r10) * h.j(r12, 0.0f, 1.0f)));
    }

    public final float[] k(float[] r10, float[] r11, float r12) {
        float r13 = h.j(r12, 0.0f, 1.0f);
        int r14 = r10.length;
        float[] r15 = new float[r14];
        int r16 = 0;
    L3:
        if (r16 >= r14) goto L5;
        float r17 = r10[r16];
        r15[r16] = r17 + ((r11[r16] - r17) * r13);
        r16 = r16 + 1;
        goto L3
    L5:
        return r15;
    }

    public final void l(boolean r24, int r25, boolean r26) {
        if (this.f15132c == r24) goto L5;
    L7:
        jb.d r10 = this.f15136g;
        if (r10 == null) goto L11;
        jb.d.c(r10, false, 1, null);
    L11:
        if (r26 == true) goto L13;
    L17:
        boolean r11 = false;
    L18:
        float[] r12 = this.f15135f;
        float[] r13 = Arrays.copyOf(r12, r12.length);
        q.f(r13, "copyOf(this, size)");
        int r14 = this.f15130a.getPaddingTop();
        int r15 = this.f15130a.getPaddingBottom();
        this.f15132c = r24;
        this.f15134e = r25;
        float[] r16 = new float[8];
        if (r24 == false) goto L34;
        float r17 = f.u(this.f15130a, 20);
        this.f15131b.setColor(this.f15133d);
        int r18 = this.f15134e;
        if (r18 == 1) goto L27;
        if (r18 == 2) goto L26;
        if (r18 == 3) goto L25;
        r16 = new float[]{r17, r17, r17, r17, r17, r17, r17, r17};
    L28:
        if (r11 == false) goto L30;
        float[] r19 = Arrays.copyOf(r13, r13.length);
        q.f(r19, "copyOf(this, size)");
    L31:
        this.f15135f = r19;
        this.f15131b.setCornerRadii(r19);
        this.f15130a.setBackground(this.f15131b);
        FrameLayout r20 = this.f15130a;
        if ((r20 instanceof OUIFrameLayout) == false) goto L35;
        ((OUIFrameLayout) r20).setShadowCornerRadius((int) r17);
    L35:
        int r21 = f.r(this.f15130a, 12);
        int r22 = f.r(this.f15130a, 8);
        int r110 = f.r(this.f15130a, 8);
        int r111 = f.r(this.f15130a, 8);
        int r23 = f.r(this.f15130a, 2);
        int r112 = f.r(this.f15130a, 2);
        int r27 = f.r(this.f15130a, 2);
        int r28 = f.r(this.f15130a, 2);
        int r113 = f.r(this.f15130a, 8);
        int r29 = f.r(this.f15130a, 2);
        int r30 = f.r(this.f15130a, 8);
        int r31 = f.r(this.f15130a, 8);
        int r32 = f.r(this.f15130a, 2);
        ViewGroup.LayoutParams r33 = this.f15130a.getLayoutParams();
        if ((r33 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        ViewGroup.MarginLayoutParams r34 = (ViewGroup.MarginLayoutParams) r33;
    L39:
        if (r34 == null) goto L50;
        if (this.f15132c == false) goto L44;
        int r35 = r21;
    L45:
        r34.setMarginStart(r35);
        if (this.f15132c == false) goto L48;
        r22 = r21;
    L48:
        r34.setMarginEnd(r22);
        goto L50
    L44:
        r35 = r22;
    L50:
        if (this.f15132c == false) goto L52;
        this.f15130a.setClipChildren(true);
        this.f15130a.setClipToPadding(true);
        int r36 = 0;
    L54:
        if (this.f15132c == true) goto L57;
        r110 = r36;
    L57:
        this.f15130a.getPaddingTop();
        this.f15130a.getPaddingBottom();
        int r37 = this.f15134e;
        if (r37 == 1) goto L78;
        if (r37 != 2) goto L62;
        r113 = r27;
        int r38 = r112;
    L82:
        if (r11 == false) goto L84;
        h(r13, r16, r14, r15, r38, r113);
    L85:
        this.f15130a.requestLayout();
        return;
    L84:
        this.f15130a.setPadding(r110, r38, r110, r113);
        goto L85
    L62:
        if (r37 == 3) goto L72;
        boolean r39 = this.f15132c;
        if (r39 == false) goto L66;
        r38 = r30;
    L67:
        if (r39 == false) goto L69;
        int r40 = r31;
    L70:
        r113 = r40;
        goto L82
    L69:
        r40 = r32;
        goto L70
    L66:
        r38 = r36;
        goto L67
    L72:
        if (this.f15132c == true) goto L75;
        r113 = r29;
    L75:
        r38 = r28;
        goto L82
    L78:
        if (this.f15132c == false) goto L80;
        r38 = r111;
    L81:
        r113 = r23;
        goto L82
    L80:
        r38 = r36;
        goto L81
    L52:
        r36 = 0;
        this.f15130a.setClipChildren(false);
        this.f15130a.setClipToPadding(false);
        goto L54
    L38:
        r34 = null;
        goto L39
    L30:
        r19 = Arrays.copyOf(r16, r16.length);
        q.f(r19, "copyOf(this, size)");
        goto L31
    L25:
        r16 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r17, r17, r17, r17};
        goto L28
    L26:
        r16 = new float[8];
        goto L28
    L27:
        r16 = new float[]{r17, r17, r17, r17, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L28
    L34:
        float[] r41 = Arrays.copyOf(r16, 8);
        q.f(r41, "copyOf(this, size)");
        this.f15135f = r41;
        this.f15130a.setBackground(null);
        goto L35
    L13:
        if (this.f15132c != r24) goto L17;
        if (this.f15134e == (-1)) goto L17;
        r11 = true;
        goto L18
    L5:
        if (this.f15134e != r25) goto L7;
    }

    public final void n(int r10) {
        this.f15133d = r10;
        m(this, this.f15132c, this.f15134e, false, 4, null);
    }

    public final void o(int r10, boolean r11) {
        l(this.f15132c, r10, r11);
    }

    public final void p(boolean r10) {
        m(this, r10, this.f15134e, false, 4, null);
    }
}
