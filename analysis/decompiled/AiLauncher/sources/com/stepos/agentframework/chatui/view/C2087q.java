package com.stepos.agentframework.chatui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.uikit.AIMDTextView;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013H\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\u0015\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010$R\u0014\u0010&\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010'R\u0014\u0010/\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010'R$\u00100\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0012R*\u00104\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/stepos/agentframework/chatui/view/q;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "durationMs", "", "stoppedByUser", "LY8/t;", "r", "(Ljava/lang/Long;Z)V", "Landroid/view/View;", "view", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/View;)V", "n", "()Z", "", "Lcom/stepos/agentframework/chatui/view/ToolExecuteGroupView;", "t", "()Ljava/util/List;", "Lcom/stepos/agentframework/uikit/AIMDTextView;", "s", "expanded", "p", "(Z)V", "", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)I", "animate", "q", "(ZZ)V", "k", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "headerLayout", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", "titleText", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "expandIcon", "Landroid/widget/ImageView;", "cardLayout", "container", "isExpand", "Z", "o", "Lkotlin/Function0;", "onHeaderClick", "Lp9/a;", "getOnHeaderClick", "()Lp9/a;", "setOnHeaderClick", "(Lp9/a;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* renamed from: com.stepos.agentframework.chatui.view.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2087q extends LinearLayout {
    private final LinearLayout cardLayout;
    private final LinearLayout container;
    private final ImageView expandIcon;
    private final LinearLayout headerLayout;
    private boolean isExpand;
    private InterfaceC5063a<Y8.t> onHeaderClick;
    private final TextView titleText;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatui/view/q$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.view.q$a */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            C2087q.this.cardLayout.setVisibility(8);
            C2087q.this.cardLayout.getLayoutParams().height = -2;
            C2087q.this.cardLayout.setAlpha(1.0f);
            C2087q.this.cardLayout.requestLayout();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatui/view/q$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.view.q$b */
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            C2087q.this.cardLayout.getLayoutParams().height = -2;
            C2087q.this.cardLayout.requestLayout();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2087q(Context context) {
        super(context, null);
        kotlin.jvm.internal.p.i(context, "context");
        setOrientation(1);
        View viewInflate = View.inflate(context, R$layout.item_message_cot_fold, this);
        View viewFindViewById = viewInflate.findViewById(R$id.ll_cot_fold_header);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById;
        this.headerLayout = linearLayout;
        View viewFindViewById2 = viewInflate.findViewById(R$id.tv_cot_fold_title);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.titleText = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R$id.iv_cot_fold_expand);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.expandIcon = (ImageView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R$id.ll_cot_fold_card);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        this.cardLayout = (LinearLayout) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R$id.ll_cot_fold_container);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        this.container = (LinearLayout) viewFindViewById5;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2087q.e(this.f23134a, view);
            }
        });
        q(false, false);
    }

    public static final void e(C2087q c2087q, View view) {
        if (c2087q.n()) {
            InterfaceC5063a<Y8.t> interfaceC5063a = c2087q.onHeaderClick;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
            c2087q.q(!c2087q.isExpand, true);
        }
    }

    public static final void i(C2087q c2087q, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.p.i(valueAnimator, "valueAnimator");
        ViewGroup.LayoutParams layoutParams = c2087q.cardLayout.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        c2087q.cardLayout.requestLayout();
    }

    public static final void l(final C2087q c2087q) {
        c2087q.cardLayout.measure(View.MeasureSpec.makeMeasureSpec(c2087q.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        ValueAnimator duration = ValueAnimator.ofInt(0, c2087q.cardLayout.getMeasuredHeight()).setDuration(250L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.agentframework.chatui.view.o
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C2087q.m(this.f23133a, valueAnimator);
            }
        });
        duration.addListener(c2087q.new b());
        c2087q.cardLayout.setAlpha(0.0f);
        c2087q.cardLayout.animate().alpha(1.0f).setDuration(250L).start();
        duration.start();
    }

    public static final void m(C2087q c2087q, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.p.i(valueAnimator, "valueAnimator");
        ViewGroup.LayoutParams layoutParams = c2087q.cardLayout.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        c2087q.cardLayout.requestLayout();
    }

    public final void g(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        int iJ = this.container.getChildCount() == 0 ? 0 : j(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, iJ, 0, 0);
        view.setLayoutParams(layoutParams);
        this.container.addView(view);
    }

    public final InterfaceC5063a<Y8.t> getOnHeaderClick() {
        return this.onHeaderClick;
    }

    public final void h() {
        if (this.cardLayout.getVisibility() == 0) {
            ValueAnimator duration = ValueAnimator.ofInt(this.cardLayout.getMeasuredHeight(), 0).setDuration(250L);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.agentframework.chatui.view.m
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    C2087q.i(this.f23129a, valueAnimator);
                }
            });
            this.cardLayout.animate().alpha(0.0f).setDuration(250L).start();
            duration.addListener(new a());
            duration.start();
        }
    }

    public final int j(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    public final void k() {
        if (this.cardLayout.getVisibility() == 8) {
            this.cardLayout.setVisibility(0);
            this.cardLayout.getLayoutParams().height = 0;
            this.cardLayout.requestLayout();
            post(new Runnable() { // from class: com.stepos.agentframework.chatui.view.n
                @Override // java.lang.Runnable
                public final void run() {
                    C2087q.l(this.f23131a);
                }
            });
        }
    }

    public final boolean n() {
        return this.container.getChildCount() > 0;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getIsExpand() {
        return this.isExpand;
    }

    public final void p(boolean expanded) {
        q(expanded && n(), false);
    }

    public final void q(boolean expanded, boolean animate) {
        this.isExpand = expanded;
        float f10 = expanded ? 90.0f : 0.0f;
        if (!animate) {
            this.expandIcon.animate().cancel();
            this.expandIcon.setRotation(f10);
            this.cardLayout.setVisibility(expanded ? 0 : 8);
        } else {
            this.expandIcon.animate().rotation(f10).setDuration(250L).start();
            if (expanded) {
                k();
            } else {
                h();
            }
        }
    }

    public final void r(Long durationMs, boolean stoppedByUser) {
        String strA = durationMs != null ? C2082l.a(durationMs.longValue()) : null;
        this.titleText.setText((!stoppedByUser || strA == null) ? stoppedByUser ? getContext().getString(R$string.chat_cot_paused) : strA != null ? getContext().getString(R$string.chat_cot_completed_duration, strA) : getContext().getString(R$string.chat_cot_completed) : getContext().getString(R$string.chat_cot_paused_duration, strA));
    }

    public final List<AIMDTextView> s() {
        C5680i c5680iS = C5685n.s(0, this.container.getChildCount());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = c5680iS.iterator();
        while (it.hasNext()) {
            View childAt = this.container.getChildAt(((Z8.M) it).nextInt());
            AIMDTextView aIMDTextView = childAt instanceof AIMDTextView ? (AIMDTextView) childAt : null;
            if (aIMDTextView != null) {
                arrayList.add(aIMDTextView);
            }
        }
        return arrayList;
    }

    public final void setOnHeaderClick(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onHeaderClick = interfaceC5063a;
    }

    public final List<ToolExecuteGroupView> t() {
        C5680i c5680iS = C5685n.s(0, this.container.getChildCount());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = c5680iS.iterator();
        while (it.hasNext()) {
            View childAt = this.container.getChildAt(((Z8.M) it).nextInt());
            ToolExecuteGroupView toolExecuteGroupView = childAt instanceof ToolExecuteGroupView ? (ToolExecuteGroupView) childAt : null;
            if (toolExecuteGroupView != null) {
                arrayList.add(toolExecuteGroupView);
            }
        }
        return arrayList;
    }
}
