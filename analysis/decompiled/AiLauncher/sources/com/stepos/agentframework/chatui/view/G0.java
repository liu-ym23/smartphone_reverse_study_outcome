package com.stepos.agentframework.chatui.view;

import Z8.C1172u;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.stepos.agentframework.R$color;
import com.stepos.agentframework.R$drawable;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatui.DisplayTool;
import com.stepos.agentframework.chatui.r2;
import com.stepos.agentframework.util.C2155d;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 z2\u00020\u0001:\u0001{B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0017\u0010\bJ\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0006¢\u0006\u0004\b \u0010\bJ\u0015\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\r¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\r¢\u0006\u0004\b)\u0010'R\"\u0010*\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010E\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u00102\u001a\u0004\bF\u00104\"\u0004\bG\u00106R\"\u0010H\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u00102\u001a\u0004\bI\u00104\"\u0004\bJ\u00106R\"\u0010K\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u00102\u001a\u0004\bL\u00104\"\u0004\bM\u00106R\"\u0010N\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u00102\u001a\u0004\bO\u00104\"\u0004\bP\u00106R6\u0010R\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010X\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010'R\"\u0010]\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010\u001fR$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010$R0\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010oR$\u0010r\u001a\u00020\r2\u0006\u0010q\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\br\u0010Y\u001a\u0004\bs\u0010[R\u0014\u0010t\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010YR\u0018\u0010v\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010x\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010y¨\u0006|"}, d2 = {"Lcom/stepos/agentframework/chatui/view/G0;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LY8/t;", "l", "()V", "k", "u", "", "text", "", "isParam", "o", "(Ljava/lang/String;Z)V", "p", "m", "finished", "setFinishedOverride", "(Ljava/lang/Boolean;)V", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/view/View;", "changedView", "", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "onWindowVisibilityChanged", "(I)V", "s", "Lcom/stepos/agentframework/chatui/P1;", "tool", "v", "(Lcom/stepos/agentframework/chatui/P1;)V", "flat", "setFlatMode", "(Z)V", "isFromClick", "t", "llMcpTitle", "Landroid/widget/LinearLayout;", "getLlMcpTitle", "()Landroid/widget/LinearLayout;", "setLlMcpTitle", "(Landroid/widget/LinearLayout;)V", "Landroid/widget/TextView;", "tvMcpTitle", "Landroid/widget/TextView;", "getTvMcpTitle", "()Landroid/widget/TextView;", "setTvMcpTitle", "(Landroid/widget/TextView;)V", "Landroid/widget/ImageView;", "ivToolExpand", "Landroid/widget/ImageView;", "getIvToolExpand", "()Landroid/widget/ImageView;", "setIvToolExpand", "(Landroid/widget/ImageView;)V", "Landroid/view/ViewGroup;", "detailLayout", "Landroid/view/ViewGroup;", "getDetailLayout", "()Landroid/view/ViewGroup;", "setDetailLayout", "(Landroid/view/ViewGroup;)V", "toolParamsTitle", "getToolParamsTitle", "setToolParamsTitle", "toolParams", "getToolParams", "setToolParams", "toolResultTitle", "getToolResultTitle", "setToolResultTitle", "toolResult", "getToolResult", "setToolResult", "Lkotlin/Function2;", "onLikeClickedListener", "Lp9/p;", "getOnLikeClickedListener", "()Lp9/p;", "setOnLikeClickedListener", "(Lp9/p;)V", "withToolActionLayout", "Z", "getWithToolActionLayout", "()Z", "setWithToolActionLayout", "receiveTextColor", "I", "getReceiveTextColor", "()I", "setReceiveTextColor", "Lcom/stepos/agentframework/chatui/P1;", "getTool", "()Lcom/stepos/agentframework/chatui/P1;", "setTool", "Lkotlin/Function1;", "onExpansionClick", "Lp9/l;", "getOnExpansionClick", "()Lp9/l;", "setOnExpansionClick", "(Lp9/l;)V", "Landroid/view/GestureDetector;", "gestureDetectorParam", "Landroid/view/GestureDetector;", "gestureDetectorResult", UxipConstants.f30680s, "flatMode", "getFlatMode", "expandDisabled", "Lcom/stepos/agentframework/chatui/view/u0;", "titleShimmer", "Lcom/stepos/agentframework/chatui/view/u0;", "finishedOverride", "Ljava/lang/Boolean;", "Companion", "c", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes2.dex */
public final class G0 extends LinearLayout {
    public static final boolean DETAIL_EXPANDABLE = false;
    private ViewGroup detailLayout;
    private final boolean expandDisabled;
    private Boolean finishedOverride;
    private boolean flatMode;
    private final GestureDetector gestureDetectorParam;
    private final GestureDetector gestureDetectorResult;
    private ImageView ivToolExpand;
    private LinearLayout llMcpTitle;
    private InterfaceC5074l<? super Boolean, Y8.t> onExpansionClick;
    private p9.p<? super String, ? super Integer, Y8.t> onLikeClickedListener;
    private int receiveTextColor;
    private u0 titleShimmer;
    private DisplayTool tool;
    private TextView toolParams;
    private TextView toolParamsTitle;
    private TextView toolResult;
    private TextView toolResultTitle;
    private TextView tvMcpTitle;
    private boolean withToolActionLayout;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatui/view/G0$a", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e10) throws Resources.NotFoundException {
            kotlin.jvm.internal.p.i(e10, "e");
            G0 g02 = G0.this;
            g02.o(g02.getToolParams().getText().toString(), true);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatui/view/G0$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e10) throws Resources.NotFoundException {
            kotlin.jvm.internal.p.i(e10, "e");
            G0 g02 = G0.this;
            g02.o(g02.getToolResult().getText().toString(), false);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatui/view/G0$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            G0.this.getDetailLayout().setVisibility(8);
            G0.this.getDetailLayout().getLayoutParams().height = -2;
            G0.this.getDetailLayout().setAlpha(1.0f);
            G0.this.getDetailLayout().requestLayout();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G0(Context context) {
        super(context, null);
        kotlin.jvm.internal.p.i(context, "context");
        this.receiveTextColor = -1;
        this.expandDisabled = true;
        B4.a aVarB = B4.a.b(LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.p.h(aVarB, "inflate(...)");
        LinearLayout llMcpTitle = aVarB.llMcpTitle;
        kotlin.jvm.internal.p.h(llMcpTitle, "llMcpTitle");
        this.llMcpTitle = llMcpTitle;
        TextView tvMcpTitle = aVarB.tvMcpTitle;
        kotlin.jvm.internal.p.h(tvMcpTitle, "tvMcpTitle");
        this.tvMcpTitle = tvMcpTitle;
        ImageView ivToolExpand = aVarB.ivToolExpand;
        kotlin.jvm.internal.p.h(ivToolExpand, "ivToolExpand");
        this.ivToolExpand = ivToolExpand;
        LinearLayout toolDetailLayout = aVarB.toolDetailLayout;
        kotlin.jvm.internal.p.h(toolDetailLayout, "toolDetailLayout");
        this.detailLayout = toolDetailLayout;
        TextView toolParamsTitle = aVarB.toolParamsTitle;
        kotlin.jvm.internal.p.h(toolParamsTitle, "toolParamsTitle");
        this.toolParamsTitle = toolParamsTitle;
        TextView toolParams = aVarB.toolParams;
        kotlin.jvm.internal.p.h(toolParams, "toolParams");
        this.toolParams = toolParams;
        TextView toolResultTitle = aVarB.toolResultTitle;
        kotlin.jvm.internal.p.h(toolResultTitle, "toolResultTitle");
        this.toolResultTitle = toolResultTitle;
        TextView toolResult = aVarB.toolResult;
        kotlin.jvm.internal.p.h(toolResult, "toolResult");
        this.toolResult = toolResult;
        this.titleShimmer = new u0(C1172u.e(this.tvMcpTitle));
        this.ivToolExpand.setVisibility(8);
        this.detailLayout.setVisibility(8);
        this.llMcpTitle.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.D0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                G0.g(this.f23087a, view);
            }
        });
        t(false);
        this.gestureDetectorParam = new GestureDetector(context, new a());
        this.gestureDetectorResult = new GestureDetector(context, new b());
        this.toolParams.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.agentframework.chatui.view.E0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return G0.h(this.f23089a, view, motionEvent);
            }
        });
        this.toolResult.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.agentframework.chatui.view.F0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return G0.i(this.f23090a, view, motionEvent);
            }
        });
        l();
    }

    public static final void g(G0 g02, View view) {
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l;
        if (g02.expandDisabled) {
            return;
        }
        DisplayTool displayTool = g02.tool;
        if (displayTool != null) {
            kotlin.jvm.internal.p.f(displayTool != null ? Boolean.valueOf(displayTool.getIsExpand()) : null);
            displayTool.r(!r1.booleanValue());
        }
        DisplayTool displayTool2 = g02.tool;
        if (displayTool2 != null && (interfaceC5074l = g02.onExpansionClick) != null) {
            interfaceC5074l.invoke(Boolean.valueOf(displayTool2.getIsExpand()));
        }
        g02.t(true);
    }

    public static final boolean h(G0 g02, View view, MotionEvent motionEvent) {
        g02.gestureDetectorParam.onTouchEvent(motionEvent);
        return true;
    }

    public static final boolean i(G0 g02, View view, MotionEvent motionEvent) {
        g02.gestureDetectorResult.onTouchEvent(motionEvent);
        return true;
    }

    public static final void n(G0 g02, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.p.i(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        g02.detailLayout.getLayoutParams().height = ((Integer) animatedValue).intValue();
        g02.detailLayout.requestLayout();
    }

    public static final void q(final G0 g02) {
        g02.detailLayout.measure(View.MeasureSpec.makeMeasureSpec(g02.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        ValueAnimator duration = ValueAnimator.ofInt(0, g02.detailLayout.getMeasuredHeight()).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.agentframework.chatui.view.C0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                G0.r(this.f23085a, valueAnimator);
            }
        });
        g02.detailLayout.setAlpha(0.0f);
        g02.detailLayout.animate().alpha(1.0f).setDuration(300L).start();
        duration.start();
    }

    public static final void r(G0 g02, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.p.i(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        g02.detailLayout.getLayoutParams().height = ((Integer) animatedValue).intValue();
        g02.detailLayout.requestLayout();
    }

    public final ViewGroup getDetailLayout() {
        return this.detailLayout;
    }

    public final boolean getFlatMode() {
        return this.flatMode;
    }

    public final ImageView getIvToolExpand() {
        return this.ivToolExpand;
    }

    public final LinearLayout getLlMcpTitle() {
        return this.llMcpTitle;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnExpansionClick() {
        return this.onExpansionClick;
    }

    public final p9.p<String, Integer, Y8.t> getOnLikeClickedListener() {
        return this.onLikeClickedListener;
    }

    public final int getReceiveTextColor() {
        return this.receiveTextColor;
    }

    public final DisplayTool getTool() {
        return this.tool;
    }

    public final TextView getToolParams() {
        return this.toolParams;
    }

    public final TextView getToolParamsTitle() {
        return this.toolParamsTitle;
    }

    public final TextView getToolResult() {
        return this.toolResult;
    }

    public final TextView getToolResultTitle() {
        return this.toolResultTitle;
    }

    public final TextView getTvMcpTitle() {
        return this.tvMcpTitle;
    }

    public final boolean getWithToolActionLayout() {
        return this.withToolActionLayout;
    }

    public final void k() throws Exception {
        DisplayTool displayTool = this.tool;
        if (displayTool != null) {
            String strC = r2.INSTANCE.c(displayTool.getName(), displayTool.getDisplayName(), displayTool.getParameter());
            if (strC == null) {
                return;
            }
            Boolean bool = this.finishedOverride;
            this.tvMcpTitle.setText(H0.INSTANCE.b(strC, bool != null ? bool.booleanValue() : displayTool.getIsFinished()));
        }
        u();
    }

    public final void l() {
        int iC = androidx.core.content.a.c(getContext(), R$color.chat_tool_text);
        this.tvMcpTitle.setTextColor(androidx.core.content.a.c(getContext(), R$color.chat_tool_call_text));
        this.toolParamsTitle.setTextColor(iC);
        this.toolParams.setTextColor(iC);
        this.toolResultTitle.setTextColor(iC);
        this.toolResult.setTextColor(iC);
    }

    public final void m() {
        if (this.detailLayout.getVisibility() == 0) {
            ValueAnimator duration = ValueAnimator.ofInt(this.detailLayout.getMeasuredHeight(), 0).setDuration(300L);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.agentframework.chatui.view.B0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    G0.n(this.f23083a, valueAnimator);
                }
            });
            this.detailLayout.animate().alpha(0.0f).setDuration(300L).start();
            duration.addListener(new d());
            duration.start();
        }
    }

    public final void o(String text, boolean isParam) throws Resources.NotFoundException {
        if (text.length() <= 0) {
            Toast toastMakeText = Toast.makeText(getContext(), R$string.chat_nothing_to_copy, 0);
            toastMakeText.setGravity(17, 0, 0);
            toastMakeText.show();
            return;
        }
        C2155d c2155d = C2155d.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        C2155d.b(c2155d, context, text, null, 4, null);
        String string = isParam ? getContext().getString(R$string.chat_copied_tool_params) : getContext().getString(R$string.chat_copied_tool_result);
        kotlin.jvm.internal.p.f(string);
        Toast toastMakeText2 = Toast.makeText(getContext(), string, 0);
        toastMakeText2.setGravity(17, 0, 0);
        toastMakeText2.show();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() throws Exception {
        super.onAttachedToWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() throws Exception {
        u0 u0Var = this.titleShimmer;
        if (u0Var != null) {
            u0Var.g();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) throws Exception {
        kotlin.jvm.internal.p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        u();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) throws Exception {
        super.onWindowVisibilityChanged(visibility);
        u();
    }

    public final void p() {
        if (this.detailLayout.getVisibility() == 8) {
            this.detailLayout.setVisibility(0);
            this.detailLayout.getLayoutParams().height = 0;
            this.detailLayout.requestLayout();
            post(new Runnable() { // from class: com.stepos.agentframework.chatui.view.A0
                @Override // java.lang.Runnable
                public final void run() {
                    G0.q(this.f23081a);
                }
            });
        }
    }

    public final void s() throws Exception {
        k();
    }

    public final void setDetailLayout(ViewGroup viewGroup) {
        kotlin.jvm.internal.p.i(viewGroup, "<set-?>");
        this.detailLayout = viewGroup;
    }

    public final void setFinishedOverride(Boolean finished) throws Exception {
        this.finishedOverride = finished;
        k();
    }

    public final void setFlatMode(boolean flat) throws Exception {
        if (this.flatMode == flat) {
            return;
        }
        this.flatMode = flat;
        u();
        if (!flat) {
            this.llMcpTitle.setVisibility(0);
            t(false);
            return;
        }
        this.llMcpTitle.setVisibility(8);
        if (this.expandDisabled) {
            this.detailLayout.setVisibility(8);
            return;
        }
        this.detailLayout.setVisibility(0);
        this.detailLayout.getLayoutParams().height = -2;
        this.detailLayout.setAlpha(1.0f);
        this.detailLayout.requestLayout();
    }

    public final void setIvToolExpand(ImageView imageView) {
        kotlin.jvm.internal.p.i(imageView, "<set-?>");
        this.ivToolExpand = imageView;
    }

    public final void setLlMcpTitle(LinearLayout linearLayout) {
        kotlin.jvm.internal.p.i(linearLayout, "<set-?>");
        this.llMcpTitle = linearLayout;
    }

    public final void setOnExpansionClick(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onExpansionClick = interfaceC5074l;
    }

    public final void setOnLikeClickedListener(p9.p<? super String, ? super Integer, Y8.t> pVar) {
        this.onLikeClickedListener = pVar;
    }

    public final void setReceiveTextColor(int i10) {
        this.receiveTextColor = i10;
    }

    public final void setTool(DisplayTool displayTool) {
        this.tool = displayTool;
    }

    public final void setToolParams(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.toolParams = textView;
    }

    public final void setToolParamsTitle(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.toolParamsTitle = textView;
    }

    public final void setToolResult(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.toolResult = textView;
    }

    public final void setToolResultTitle(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.toolResultTitle = textView;
    }

    public final void setTvMcpTitle(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.tvMcpTitle = textView;
    }

    public final void setWithToolActionLayout(boolean z10) {
        this.withToolActionLayout = z10;
    }

    public final void t(boolean isFromClick) {
        if (this.expandDisabled) {
            this.ivToolExpand.setVisibility(8);
            this.detailLayout.setVisibility(8);
            return;
        }
        if (this.flatMode) {
            this.detailLayout.setVisibility(0);
            return;
        }
        DisplayTool displayTool = this.tool;
        if (displayTool != null) {
            if (!displayTool.getIsExpand()) {
                this.ivToolExpand.setImageResource(R$drawable.ic_mcp_collapsed);
                m();
                return;
            }
            this.ivToolExpand.setImageResource(R$drawable.ic_mcp_expanded);
            if (isFromClick) {
                p();
            } else {
                this.detailLayout.setVisibility(0);
            }
        }
    }

    public final void u() throws Exception {
        u0 u0Var = this.titleShimmer;
        if (u0Var == null) {
            return;
        }
        if (this.tool != null) {
            if ((!(this.finishedOverride != null ? r2.booleanValue() : r1.getIsFinished())) && !this.flatMode && isAttachedToWindow() && isShown() && getWindowVisibility() == 0) {
                u0Var.e();
                return;
            }
        }
        u0Var.g();
    }

    public final void v(DisplayTool tool) throws Exception {
        kotlin.jvm.internal.p.i(tool, "tool");
        boolean zD = kotlin.jvm.internal.p.d(this.tool, tool);
        this.tool = tool;
        if (zD) {
            return;
        }
        k();
        this.toolParams.setText(tool.getParameter());
        this.toolResult.setText(tool.getResult());
        t(false);
    }
}
