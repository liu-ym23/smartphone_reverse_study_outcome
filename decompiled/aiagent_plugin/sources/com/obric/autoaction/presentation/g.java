package com.obric.autoaction.presentation;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.presentation.view.PlayerBubble;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SurfaceCardActivityConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    /* JADX INFO: renamed from: lambda$ZlN7_nTT6Oz6-Iwv-H8R6trgXws, reason: not valid java name */
    public static /* synthetic */ void m621lambda$ZlN7_nTT6Oz6IwvH8R6trgXws(SurfaceCardActivity r0) {
        a(r0);
    }

    public static final void a(SurfaceCardActivity r11, Configuration r12) {
        final SurfaceCardActivity r13 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r11, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        o.e(r13, "<this>");
        o.e(r12, "newConfig");
        ViewGroup.LayoutParams r0 = r13.getBinding().x.getLayoutParams();
        o.a(r0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r3 = r13.getBinding().n.getLayoutParams();
        o.a(r3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        boolean r4 = true;
        if (r12.orientation != 2) goto L11;
        r1.gravity = 8388693;
        r1.width = ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_card_width_landscape, "dimen", "auto_ai_card_width_landscape"));
        r2.gravity = 8388693;
        r2.rightMargin = (r1.width / 2) - (r13.getBinding().n.getWidth() / 2);
        OUIFrameLayout r14 = r13.getBinding().n;
        o.c(r14, "closeButtonContainer");
        if (((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.aiagent.plugin")).getVisibility() == 0) goto L8;
        r4 = false;
    L8:
        if (r4 == false) goto L10;
        r1.bottomMargin = ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_card_margin_bottom_show_close, "dimen", "auto_ai_card_margin_bottom_show_close"));
    L18:
        r13.getBinding().x.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r13.getBinding().n.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r13.getBinding().q.post(new $$Lambda$g$ZlN7_nTT6Oz6IwvH8R6trgXws(r13));
        return;
    L10:
        r1.bottomMargin = -ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.auto_ai_card_margin_bottom_landscape, "dimen", "auto_ai_card_margin_bottom_landscape"));
        goto L18
    L11:
        r1.gravity = 81;
        r1.width = -1;
        r2.rightMargin = 0;
        OUIFrameLayout r5 = r13.getBinding().n;
        o.c(r5, "closeButtonContainer");
        if (((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin")).getVisibility() == 0) goto L15;
        r4 = false;
    L15:
        if (r4 == true) goto L17;
        r1.bottomMargin = 0;
    L17:
        r2.gravity = 81;
        goto L18
    }

    private static final void a(SurfaceCardActivity r3) {
        SurfaceCardActivity r4 = (SurfaceCardActivity) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceCardActivity.class, "com.obric.aiagent.plugin");
        PlayerBubble r0 = r4.getBinding().q;
        o.c(r0, "floatingIconLayout");
        com.obric.autoaction.e.a.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), r4.getBinding().q.isSnappedToRight());
    }
}
