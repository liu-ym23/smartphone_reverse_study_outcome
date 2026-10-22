package com.obric.oui.dialog.anim;

import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import bg.h;
import com.obric.common.oui.R$id;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.animation.engine.DynamicAnimation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.q;
import tc.f;
import td.c;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogAnimStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DialogAnimStyle f14342a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/anim/DialogAnimStyle$HeightLevel;", "", "maxRatio", "", "(Ljava/lang/String;IF)V", "getMaxRatio", "()F", "SMALL", "MEDIUM", "LARGE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum HeightLevel extends Enum<HeightLevel> {
        private static final /* synthetic */ HeightLevel[] $VALUES = null;
        public static final HeightLevel LARGE = null;
        public static final HeightLevel MEDIUM = null;
        public static final HeightLevel SMALL = null;
        private final float maxRatio;

        private static final /* synthetic */ HeightLevel[] $values() {
            return new HeightLevel[]{SMALL, MEDIUM, LARGE};
        }

        static {
            SMALL = new HeightLevel("SMALL", 0, 0.4f);
            MEDIUM = new HeightLevel("MEDIUM", 1, 0.8f);
            LARGE = new HeightLevel("LARGE", 2, 1.0f);
            $VALUES = $values();
        }

        private HeightLevel(String r10, int r11, float r12) {
            super(r10, r11);
            this.maxRatio = r12;
        }

        public static HeightLevel valueOf(String r10) {
            return (HeightLevel) Enum.valueOf(HeightLevel.class, r10);
        }

        public static HeightLevel[] values() {
            return (HeightLevel[]) $VALUES.clone();
        }

        public final float getMaxRatio() {
            return this.maxRatio;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14343a = null;

        static {
            int[] r10 = new int[HeightLevel.values().length];
            r10[HeightLevel.SMALL.ordinal()] = 1;
            r10[HeightLevel.MEDIUM.ordinal()] = 2;
            r10[HeightLevel.LARGE.ordinal()] = 3;
            f14343a = r10;
        }
    }

    static {
        f14342a = new DialogAnimStyle();
    }

    public DialogAnimStyle() {
    }

    public static /* synthetic */ void a(Window r10, float r11, float r12, float r13, DynamicAnimation r14, float r15, float r16) {
        k(r10, r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ void b(Window r10, float r11, float r12, float r13, float r14, Ref$BooleanRef r15, ViewPropertySpringAnimator r16, DynamicAnimation r17, float r18, float r19) {
        h(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ ViewPropertySpringAnimator g(DialogAnimStyle r10, View r11, Window r12, boolean r13, boolean r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r12 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r13 = true;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r14 = true;
    L12:
        return r10.f(r11, r12, r13, r14);
    }

    public static final void h(Window r10, float r11, float r12, float r13, float r14, Ref$BooleanRef r15, ViewPropertySpringAnimator r16, DynamicAnimation r17, float r18, float r19) {
        q.g(r15, "$isEnd");
        q.g(r16, "$this_apply");
        f14342a.m(r10, td.b.b(r18, r11, r12), r13, r14);
        if (r15.element == false) goto L5;
        return;
    L5:
        if (r18 < r12) goto L9;
        r15.element = true;
        r16.p();
        return;
    }

    public static /* synthetic */ ViewPropertySpringAnimator j(DialogAnimStyle r10, View r11, Window r12, boolean r13, float r14, boolean r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        r12 = null;
    L5:
        Window r18 = r12;
        if ((r16 & 2) == 0) goto L8;
        boolean r19 = true;
    L10:
        if ((r16 & 4) == 0) goto L12;
        r14 = 0.6f;
    L12:
        float r20 = r14;
        if ((r16 & 8) == 0) goto L15;
        boolean r21 = true;
    L17:
        return r10.i(r11, r18, r19, r20, r21);
    L15:
        r21 = r15;
        goto L17
    L8:
        r19 = r13;
        goto L10
    }

    public static final void k(Window r10, float r11, float r12, float r13, DynamicAnimation r14, float r15, float r16) {
        f14342a.m(r10, td.b.b(r15, r11, r12), 0.0f, r13);
    }

    public final void c(View r10) {
        q.g(r10, "container");
        int r11 = f.r(r10, 10);
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13.topMargin >= r11) goto L7;
        r13.topMargin = r11;
    L7:
        r10.setLayoutParams(r12);
    }

    public final HeightLevel d(View r10, int r11) {
        if (r11 <= 0) goto L4;
        float r12 = r10.getHeight() / r11;
        HeightLevel r13 = HeightLevel.SMALL;
        if (r12 < r13.getMaxRatio()) goto L13;
        HeightLevel r14 = HeightLevel.MEDIUM;
        if (r12 >= r14.getMaxRatio()) goto L12;
        return r14;
    L12:
        return HeightLevel.LARGE;
    L13:
        return r13;
    L4:
        return HeightLevel.MEDIUM;
    }

    public final Pair e(boolean r10, HeightLevel r11, boolean r12) {
        Float r13 = Float.valueOf(1.0f);
        if (r10 == true) goto L7;
        return new Pair(r13, Float.valueOf(480.0f));
    L7:
        if (r12 == false) goto L18;
        int r14 = a.f14343a[r11.ordinal()];
        if (r14 == 1) goto L31;
        if (r14 == 2) goto L30;
        if (r14 != 3) goto L15;
        return new Pair(r13, Float.valueOf(247.0f));
    L15:
        throw new NoWhenBranchMatchedException();
    L30:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(247.0f));
    L31:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(439.0f));
    L18:
        int r15 = a.f14343a[r11.ordinal()];
        if (r15 == 1) goto L28;
        if (r15 == 2) goto L33;
        if (r15 != 3) goto L25;
        return new Pair(r13, Float.valueOf(322.0f));
    L25:
        throw new NoWhenBranchMatchedException();
    L33:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(322.0f));
    L28:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(632.0f));
    }

    public final ViewPropertySpringAnimator f(View r11, final Window r12, boolean r13, boolean r14) {
        q.g(r11, "<this>");
        Size r10 = wd.a.c(r11.getContext());
        int r15 = r11.getHeight();
        ViewGroup.LayoutParams r16 = r11.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r16 = null;
    L5:
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        if (r17 == null) goto L8;
        int r18 = r17.bottomMargin;
    L9:
        int r19 = r15 + r18;
        int r20 = f.r(r11, 24) + r19;
        Pair r21 = e(r14, d(r11, r10.getHeight()), false);
        final float r22 = ((Number) r21.component1()).floatValue();
        final float r23 = ((Number) r21.component2()).floatValue();
        final ViewPropertySpringAnimator r24 = l(r11, R$id.o_dialog_anim_out).r(r20, new DialogAnimStyle$dialogBottomHide$spring$1(r22, r23));
        if (r12 == null) goto L17;
        if (r13 == false) goto L17;
        r12.addFlags(2);     // Catch: Exception -> L15
        final float r25 = r19;
        final float r26 = r12.getAttributes().dimAmount;     // Catch: Exception -> L15
        final Ref$BooleanRef r27 = new Ref$BooleanRef();     // Catch: Exception -> L15
        final float r28 = 0.0f;
        final float r29 = 0.0f;
        r24.setUpdateListener(new com.obric.oui.dialog.anim.a(r12, r28, r25, r26, r29, r27, r24));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.w("DialogAnimStyle", q.p("dialogBottomHide, can't show dim anim: ", e.getMessage()));
    L17:
        com.obric.oui.animation.style.a.b(r11);
        return r24;
    L8:
        r18 = 0;
        goto L9
    }

    public final ViewPropertySpringAnimator i(View r10, final Window r11, boolean r12, final float r13, boolean r14) {
        q.g(r10, "<this>");
        Size r15 = wd.a.c(r10.getContext());
        int r16 = r10.getHeight();
        ViewGroup.LayoutParams r17 = r10.getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r17 = null;
    L5:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        if (r18 == null) goto L8;
        int r19 = r18.bottomMargin;
    L9:
        final int r20 = (r16 + r19) + f.r(r10, 24);
        r10.setAlpha(1.0f);
        Pair r21 = e(r14, d(r10, r15.getHeight()), true);
        final float r22 = ((Number) r21.component1()).floatValue();
        final float r23 = ((Number) r21.component2()).floatValue();
        ViewPropertySpringAnimator r24 = l(r10, R$id.o_dialog_anim_in);
        Function1<com.obric.oui.animation.easy.a, Unit> r25 = new DialogAnimStyle$dialogBottomShow$1(r22, r23, r20);
        final float r26 = 0.0f;
        ViewPropertySpringAnimator r27 = r24.r(0.0f, r25);
        if (r11 == null) goto L17;
        if (r12 == false) goto L17;
        r11.addFlags(2);     // Catch: Exception -> L15
        final float r28 = r20;
        r27.setUpdateListener(new b(r11, r28, r26, r13));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.w("DialogAnimStyle", q.p("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L17:
        return r27;
    L8:
        r19 = 0;
        goto L9
    }

    public final ViewPropertySpringAnimator l(View r10, int r11) {
        c r12 = c.f24796a;
        Object r13 = r10.getTag(r11);
        if (r13 != null) goto L6;
    L4:
        r13 = null;
    L7:
        ViewPropertySpringAnimator r14 = (ViewPropertySpringAnimator) r13;
        if (r14 != null) goto L11;
        ViewPropertySpringAnimator r15 = new ViewPropertySpringAnimator(r10);
        r10.setTag(r11, r15);
        return r15;
    L11:
        return r14;
    L6:
        if ((r13 instanceof ViewPropertySpringAnimator) == false) goto L4;
        goto L4
    }

    public final void m(Window r10, float r11, float r12, float r13) {
        float r14 = r13 - r12;     // Catch: Exception -> L5
        r10.setDimAmount(r12 + (r14 * h.j(r11, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("DialogAnimStyle", q.p("updateWindowDimWithAnim: ", e.getMessage()));
    }
}
