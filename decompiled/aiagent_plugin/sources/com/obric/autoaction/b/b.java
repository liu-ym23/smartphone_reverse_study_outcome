package com.obric.autoaction.b;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.presentation.view.GradientTextView;
import com.obric.autoaction.presentation.view.LockableScrollView;
import com.obric.autoaction.presentation.view.NoTransparentRegionRoot;
import com.obric.autoaction.presentation.view.PlayerBubble;
import com.obric.autoaction.presentation.view.TouchAwareConstraintLayout;
import com.obric.design.edgeglow.AiScreenEdgeEffectView;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActivitySurfaceCardBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements androidx.viewbinding.a {
    public final LinearLayout A;
    public final TextView B;
    public final ImageView C;
    public final TextView D;
    public final LockableScrollView E;
    public final GradientTextView F;
    public final LockableScrollView G;
    public final OButton H;
    public final FrameLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final OButton f24588J;
    private final NoTransparentRegionRoot K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f24589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Barrier f24590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OButton f24591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OTextView f24592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OTextView f24593e;
    public final OButton f;
    public final OButton g;
    public final OButton h;
    public final OButton i;
    public final OButton j;
    public final ConstraintLayout k;
    public final TouchAwareConstraintLayout l;
    public final OButton m;
    public final OUIFrameLayout n;
    public final AiScreenEdgeEffectView o;
    public final OButton p;
    public final PlayerBubble q;
    public final ViewStub r;
    public final ConstraintLayout s;
    public final LinearLayout t;
    public final OButton u;
    public final OButton v;
    public final ODownloadProgressView w;
    public final LinearLayout x;
    public final SurfaceView y;
    public final ImageView z;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private b(NoTransparentRegionRoot r3, LinearLayout r4, Barrier r5, OButton r6, OTextView r7, OTextView r8, OButton r9, OButton r10, OButton r11, OButton r12, OButton r13, ConstraintLayout r14, TouchAwareConstraintLayout r15, OButton r16, OUIFrameLayout r17, AiScreenEdgeEffectView r18, OButton r19, PlayerBubble r20, ViewStub r21, ConstraintLayout r22, LinearLayout r23, OButton r24, OButton r25, ODownloadProgressView r26, LinearLayout r27, SurfaceView r28, ImageView r29, LinearLayout r30, TextView r31, ImageView r32, TextView r33, LockableScrollView r34, GradientTextView r35, LockableScrollView r36, OButton r37, FrameLayout r38, OButton r39) {
        this.K = r3;
        this.f24589a = r4;
        this.f24590b = r5;
        this.f24591c = r6;
        this.f24592d = r7;
        this.f24593e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r20;
        this.r = r21;
        this.s = r22;
        this.t = r23;
        this.u = r24;
        this.v = r25;
        this.w = r26;
        this.x = r27;
        this.y = r28;
        this.z = r29;
        this.A = r30;
        this.B = r31;
        this.C = r32;
        this.D = r33;
        this.E = r34;
        this.F = r35;
        this.G = r36;
        this.H = r37;
        this.I = r38;
        this.f24588J = r39;
    }

    public NoTransparentRegionRoot b() {
        return this.K;
    }

    public static b a(LayoutInflater r2) {
        return a(r2, null, false);
    }

    public static b a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_surface_card, "layout", "activity_surface_card"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static b a(View r44) {
        int r1 = ZeusTransformUtils.mapRes(R.id.action_btn_group, DbHelper.COL_ID, "action_btn_group");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.addingBarrier, DbHelper.COL_ID, "addingBarrier");
        Barrier r9 = (Barrier) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), Barrier.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.assistClarfiyBtn, DbHelper.COL_ID, "assistClarfiyBtn");
        OButton r10 = (OButton) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.bg_content, DbHelper.COL_ID, "bg_content");
        OTextView r11 = (OTextView) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OTextView.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.bg_title, DbHelper.COL_ID, "bg_title");
        OTextView r12 = (OTextView) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OTextView.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.btnAdding, DbHelper.COL_ID, "btnAdding");
        OButton r13 = (OButton) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.btnCheckAll, DbHelper.COL_ID, "btnCheckAll");
        OButton r14 = (OButton) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_clarify_adding, DbHelper.COL_ID, "btn_clarify_adding");
        OButton r15 = (OButton) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.btnFeedback, DbHelper.COL_ID, "btnFeedback");
        OButton r16 = (OButton) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.btnStop, DbHelper.COL_ID, "btnStop");
        OButton r17 = (OButton) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.cardContentGroup, DbHelper.COL_ID, "cardContentGroup");
        ConstraintLayout r18 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), ConstraintLayout.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.cardLayout, DbHelper.COL_ID, "cardLayout");
        TouchAwareConstraintLayout r19 = (TouchAwareConstraintLayout) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), TouchAwareConstraintLayout.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.closeButton, DbHelper.COL_ID, "closeButton");
        OButton r20 = (OButton) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.closeButtonContainer, DbHelper.COL_ID, "closeButtonContainer");
        OUIFrameLayout r21 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OUIFrameLayout.class, "com.obric.aiagent.plugin");
        if (r21 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.effect, DbHelper.COL_ID, "effect");
        AiScreenEdgeEffectView r22 = (AiScreenEdgeEffectView) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), AiScreenEdgeEffectView.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.exitCallUserButton, DbHelper.COL_ID, "exitCallUserButton");
        OButton r23 = (OButton) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.floating_icon_layout, DbHelper.COL_ID, "floating_icon_layout");
        PlayerBubble r24 = (PlayerBubble) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), PlayerBubble.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.inputContent, DbHelper.COL_ID, "inputContent");
        ViewStub r25 = (ViewStub) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), ViewStub.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.iv_center_icon, DbHelper.COL_ID, "iv_center_icon");
        ConstraintLayout r26 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), ConstraintLayout.class, "com.obric.aiagent.plugin");
        if (r26 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.loadingLayout, DbHelper.COL_ID, "loadingLayout");
        LinearLayout r27 = (LinearLayout) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r27 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.option1, DbHelper.COL_ID, "option1");
        OButton r28 = (OButton) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r28 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.option2, DbHelper.COL_ID, "option2");
        OButton r29 = (OButton) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r29 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.progress_view_processing_3, DbHelper.COL_ID, "progress_view_processing_3");
        ODownloadProgressView r30 = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), ODownloadProgressView.class, "com.obric.aiagent.plugin");
        if (r30 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.shadowLayout, DbHelper.COL_ID, "shadowLayout");
        LinearLayout r31 = (LinearLayout) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r31 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.surfaceView, DbHelper.COL_ID, "surfaceView");
        SurfaceView r32 = (SurfaceView) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), SurfaceView.class, "com.obric.aiagent.plugin");
        if (r32 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.top_icon, DbHelper.COL_ID, "top_icon");
        ImageView r33 = (ImageView) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), ImageView.class, "com.obric.aiagent.plugin");
        if (r33 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.top_icon_group, DbHelper.COL_ID, "top_icon_group");
        LinearLayout r34 = (LinearLayout) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r34 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.top_text, DbHelper.COL_ID, "top_text");
        TextView r35 = (TextView) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), TextView.class, "com.obric.aiagent.plugin");
        if (r35 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.trackIcon, DbHelper.COL_ID, "trackIcon");
        ImageView r36 = (ImageView) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), ImageView.class, "com.obric.aiagent.plugin");
        if (r36 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.tvCardContent, DbHelper.COL_ID, "tvCardContent");
        TextView r37 = (TextView) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), TextView.class, "com.obric.aiagent.plugin");
        if (r37 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.tvCardContentContainer, DbHelper.COL_ID, "tvCardContentContainer");
        LockableScrollView r38 = (LockableScrollView) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), LockableScrollView.class, "com.obric.aiagent.plugin");
        if (r38 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.tvCardTitle, DbHelper.COL_ID, "tvCardTitle");
        GradientTextView r39 = (GradientTextView) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), GradientTextView.class, "com.obric.aiagent.plugin");
        if (r39 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.tvCardTitleContainer, DbHelper.COL_ID, "tvCardTitleContainer");
        LockableScrollView r40 = (LockableScrollView) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), LockableScrollView.class, "com.obric.aiagent.plugin");
        if (r40 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.userExecuteButton, DbHelper.COL_ID, "userExecuteButton");
        OButton r41 = (OButton) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r41 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.userOperation, DbHelper.COL_ID, "userOperation");
        FrameLayout r42 = (FrameLayout) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r42 == null) goto L77;
        r1 = ZeusTransformUtils.mapRes(R.id.userTakeOver, DbHelper.COL_ID, "userTakeOver");
        OButton r43 = (OButton) ZeusTransformUtils.preCheckCast(r44.findViewById(r1), OButton.class, "com.obric.aiagent.plugin");
        if (r43 == null) goto L77;
        return new b((NoTransparentRegionRoot) ZeusTransformUtils.preCheckCast(r44, NoTransparentRegionRoot.class, "com.obric.aiagent.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43);
    L77:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r44, "com.obric.aiagent.plugin").getResourceName(r1)));
    }
}
