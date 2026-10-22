package com.obric.autoaction.app.launcherpage.module.view;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: CardStrokeBlinkHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24286a = null;

    static {
        f24286a = new a();
    }

    public static /* synthetic */ void lambda$lGe6AL8gCvPsxaF_R6R7achFFkc(GradientBorderDrawable r0, ValueAnimator r1) {
        a(r0, r1);
    }

    private a() {
    }

    public final void a(String r6, View r7) {
        o.e(r6, DbHelper.COL_ID);
        o.e(r7, "targetView");
        Object r1 = r7.getTag(ZeusTransformUtils.mapRes(R.id.tag_blink_animator, DbHelper.COL_ID, "tag_blink_animator"));
        if (ZeusTransformUtils.instanceOf(r1, ValueAnimator.class) == false) goto L5;
        ValueAnimator r2 = (ValueAnimator) ZeusTransformUtils.preCheckCast(r1, ValueAnimator.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.isRunning() == false) goto L21;
        Object r0 = r7.getTag(ZeusTransformUtils.mapRes(R.id.tag_blink_animator_owner, DbHelper.COL_ID, "tag_blink_animator_owner"));
        if (r0 == null) goto L12;
        String r3 = r0.toString();
    L14:
        if (o.a(r6, r3) == true) goto L22;
        Loog.INSTANCE.d("CardStrokeBlinkHelper", "stopBlinkStroke: " + r6);
        r2.cancel();
        if (ZeusTransformUtils.instanceOf(r7.getForeground(), GradientBorderDrawable.class) == false) goto L18;
        r7.setForeground(null);
    L18:
        a(r7, null, null);
        return;
    L22:
        return;
    L12:
        r3 = null;
        goto L14
    L21:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static /* synthetic */ void a(a r12, String r13, View r14, List r15, float r16, float r17, int r18, int r19, Object r20) {
        List<Integer> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        if ((r19 & 4) == 0) goto L5;
        r0 = p.b(new Integer[]{Integer.valueOf(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_ai_a_color2_2, "color", "oui_ai_a_color2_2"))), Integer.valueOf(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_ai_a_color3_2, "color", "oui_ai_a_color3_2")))});
    L5:
        List<Integer> r8 = r0;
        if ((r19 & 8) == 0) goto L8;
        float r9 = TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics());
    L10:
        if ((r19 & 16) == 0) goto L12;
        float r10 = TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics());
    L14:
        if ((r19 & 32) == 0) goto L16;
        int r11 = 1;
    L17:
        r12.a(r13, r14, r8, r9, r10, r11);
        return;
    L16:
        r11 = r18;
        goto L17
    L12:
        r10 = r17;
        goto L14
    L8:
        r9 = r16;
        goto L10
    }

    public final void a(String r4, final View r5, List<Integer> r6, float r7, float r8, int r9) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r4, DbHelper.COL_ID);
        o.e(r5, "targetView");
        o.e(r3, "strokeColor");
        final GradientBorderDrawable r10 = new GradientBorderDrawable(p.e((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")), r7, r8);
        r5.setForeground((Drawable) ZeusTransformUtils.preCheckCast(r10, Drawable.class, "com.obric.aiagent.plugin"));
        PathInterpolator r11 = new PathInterpolator(0.645f, 0.045f, 0.355f, 1.0f);
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f, 0.0f});
        r12.setDuration(1000);
        r12.setRepeatCount(r9);
        r12.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r11, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r12.addUpdateListener(new $$Lambda$a$lGe6AL8gCvPsxaF_R6R7achFFkc(r10));
        r12.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new CardStrokeBlinkHelper$startBlinkStroke$1$2(r5), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        f24286a.a(r5, r12, r4);
        r12.start();
    }

    private static final void a(GradientBorderDrawable r2, ValueAnimator r3) {
        o.e(r3, "animation");
        Object r4 = r3.getAnimatedValue();
        o.a(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.setAlpha((int) (((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue() * 255));
    }

    public final void a(View r3, ValueAnimator r4, String r5) {
        o.e(r3, "<this>");
        r3.setTag(ZeusTransformUtils.mapRes(R.id.tag_blink_animator, DbHelper.COL_ID, "tag_blink_animator"), r4);
        r3.setTag(ZeusTransformUtils.mapRes(R.id.tag_blink_animator_owner, DbHelper.COL_ID, "tag_blink_animator_owner"), r5);
    }
}
