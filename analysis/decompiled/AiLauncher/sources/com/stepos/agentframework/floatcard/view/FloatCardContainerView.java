package com.stepos.agentframework.floatcard.view;

import E4.FloatCardContent;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.R$dimen;
import com.stepos.agentframework.floatcard.R$id;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001b\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0017¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J'\u0010$\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0017H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010+\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\fH\u0002¢\u0006\u0004\b+\u0010,J\u0011\u0010-\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0004\b-\u0010.J\u0011\u00100\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010=¨\u0006?"}, d2 = {"Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LE4/p;", "card", "", "playEnterAnim", "LY8/t;", "p", "(LE4/p;Z)V", "", "cardId", "LE4/c;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "r", "(Ljava/lang/String;LE4/c;)V", "Lkotlin/Function0;", "onEnd", "f", "(Ljava/lang/String;Lp9/a;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_UMID, "()LE4/p;", "e", "()Ljava/lang/String;", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "l", "(LE4/p;Lp9/a;)V", "m", "(Landroid/view/MotionEvent;)V", "Landroidx/viewpager2/widget/ViewPager2;", "outer", "disallow", "o", "(Landroidx/viewpager2/widget/ViewPager2;Z)V", Const.INTENT_KEY_PKGNAME, "()Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/recyclerview/widget/RecyclerView;", "n", "()Landroidx/recyclerview/widget/RecyclerView;", "c", "()I", UxipConstants.f30680s, "k", "(I)I", "currentCard", "LE4/p;", "pagerTouchSlop", "I", "", "pagerDownX", "F", "pagerDownY", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FloatCardContainerView extends FrameLayout {
    private E4.p currentCard;
    private float pagerDownX;
    private float pagerDownY;
    private final int pagerTouchSlop;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatCardContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(FloatCardContainerView floatCardContainerView, String str, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            interfaceC5063a = null;
        }
        floatCardContainerView.f(str, interfaceC5063a);
    }

    public static final void h(FloatCardContainerView floatCardContainerView, E4.p pVar, InterfaceC5063a interfaceC5063a) {
        floatCardContainerView.l(pVar, interfaceC5063a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(FloatCardContainerView floatCardContainerView, String str, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            interfaceC5063a = null;
        }
        floatCardContainerView.i(str, interfaceC5063a);
    }

    public static /* synthetic */ void q(FloatCardContainerView floatCardContainerView, E4.p pVar, boolean z10, int i10, Object obj) throws Resources.NotFoundException {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        floatCardContainerView.p(pVar, z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x000d, code lost:
    
        r2 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.viewpager2.widget.ViewPager2 b() {
        /*
            r2 = this;
            android.view.ViewParent r2 = r2.getParent()
            boolean r0 = r2 instanceof android.view.View
            r1 = 0
            if (r0 == 0) goto Lc
            android.view.View r2 = (android.view.View) r2
            goto Ld
        Lc:
            r2 = r1
        Ld:
            if (r2 == 0) goto L1e
            boolean r0 = r2 instanceof androidx.viewpager2.widget.ViewPager2
            if (r0 != 0) goto L1e
            android.view.ViewParent r2 = r2.getParent()
            boolean r0 = r2 instanceof android.view.View
            if (r0 == 0) goto Lc
            android.view.View r2 = (android.view.View) r2
            goto Ld
        L1e:
            boolean r0 = r2 instanceof androidx.viewpager2.widget.ViewPager2
            if (r0 == 0) goto L25
            androidx.viewpager2.widget.ViewPager2 r2 = (androidx.viewpager2.widget.ViewPager2) r2
            return r2
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.floatcard.view.FloatCardContainerView.b():androidx.viewpager2.widget.ViewPager2");
    }

    public final int c() {
        return getResources().getDimensionPixelSize(R$dimen.float_card_margin_bottom);
    }

    /* renamed from: d, reason: from getter */
    public final E4.p getCurrentCard() {
        return this.currentCard;
    }

    public final String e() {
        E4.p pVar = this.currentCard;
        if (pVar != null) {
            return pVar.getCardId();
        }
        return null;
    }

    public final void f(String cardId, final InterfaceC5063a<Y8.t> onEnd) {
        final E4.p pVar = this.currentCard;
        if (pVar == null) {
            if (onEnd != null) {
                onEnd.invoke();
            }
        } else if (cardId == null || kotlin.jvm.internal.p.d(pVar.getCardId(), cardId)) {
            pVar.getView().animate().cancel();
            pVar.getView().animate().alpha(0.0f).translationY(k(32)).setDuration(220L).withEndAction(new Runnable() { // from class: com.stepos.agentframework.floatcard.view.s
                @Override // java.lang.Runnable
                public final void run() {
                    FloatCardContainerView.h(this.f23294a, pVar, onEnd);
                }
            }).start();
        } else if (onEnd != null) {
            onEnd.invoke();
        }
    }

    public final void i(String cardId, InterfaceC5063a<Y8.t> onEnd) {
        E4.p pVar = this.currentCard;
        if (pVar == null) {
            if (onEnd != null) {
                onEnd.invoke();
            }
        } else if (cardId == null || kotlin.jvm.internal.p.d(pVar.getCardId(), cardId)) {
            pVar.getView().animate().cancel();
            l(pVar, onEnd);
        } else if (onEnd != null) {
            onEnd.invoke();
        }
    }

    public final int k(int value) {
        return (int) ((value * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void l(E4.p card, InterfaceC5063a<Y8.t> onEnd) {
        if (this.currentCard == card) {
            removeAllViews();
            card.destroy();
            this.currentCard = null;
            setVisibility(8);
            setClickable(false);
        } else {
            ViewParent parent = card.getView().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(card.getView());
            }
            card.destroy();
        }
        if (onEnd != null) {
            onEnd.invoke();
        }
    }

    public final void m(MotionEvent ev) {
        RecyclerView recyclerViewN;
        ViewPager2 viewPager2B = b();
        if (viewPager2B == null || (recyclerViewN = n()) == null) {
            return;
        }
        boolean z10 = viewPager2B.getOrientation() == 0;
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            this.pagerDownX = ev.getX();
            this.pagerDownY = ev.getY();
            o(viewPager2B, true);
            return;
        }
        if (actionMasked != 2) {
            return;
        }
        float x10 = ev.getX() - this.pagerDownX;
        float y10 = ev.getY() - this.pagerDownY;
        float fAbs = Math.abs(x10) * (z10 ? 0.5f : 1.0f);
        float fAbs2 = Math.abs(y10) * (z10 ? 1.0f : 0.5f);
        int i10 = this.pagerTouchSlop;
        if (fAbs > i10 || fAbs2 > i10) {
            if (z10 == (fAbs2 > fAbs)) {
                o(viewPager2B, false);
                return;
            }
            if (!z10) {
                x10 = y10;
            }
            int i11 = (int) (-Math.signum(x10));
            o(viewPager2B, z10 ? recyclerViewN.canScrollHorizontally(i11) : recyclerViewN.canScrollVertically(i11));
        }
    }

    public final RecyclerView n() {
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R$id.view_pager);
        View childAt = viewPager2 != null ? viewPager2.getChildAt(0) : null;
        if (childAt instanceof RecyclerView) {
            return (RecyclerView) childAt;
        }
        return null;
    }

    public final void o(ViewPager2 outer, boolean disallow) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallow);
        }
        View childAt = outer.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            recyclerView.requestDisallowInterceptTouchEvent(disallow);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        m(ev);
        return super.onInterceptTouchEvent(ev);
    }

    public final void p(E4.p card, boolean playEnterAnim) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(card, "card");
        E4.p pVar = this.currentCard;
        if (!kotlin.jvm.internal.p.d(pVar != null ? pVar.getCardId() : null, card.getCardId())) {
            removeAllViews();
            E4.p pVar2 = this.currentCard;
            if (pVar2 != null) {
                pVar2.destroy();
            }
        }
        this.currentCard = card;
        if (card.getView().getParent() != this) {
            ViewParent parent = card.getView().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(card.getView());
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.float_card_margin_horizontal);
            View view = card.getView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.rightMargin = dimensionPixelSize;
            layoutParams.bottomMargin = c();
            Y8.t tVar = Y8.t.f7040a;
            addView(view, layoutParams);
        }
        setVisibility(0);
        setClickable(true);
        if (playEnterAnim) {
            card.getView().setAlpha(0.0f);
            card.getView().setTranslationY(k(32));
            card.getView().animate().alpha(1.0f).translationY(0.0f).setDuration(220L).start();
        }
    }

    public final void r(String cardId, FloatCardContent content) {
        kotlin.jvm.internal.p.i(cardId, "cardId");
        kotlin.jvm.internal.p.i(content, "content");
        E4.p pVar = this.currentCard;
        if (pVar != null) {
            if (!kotlin.jvm.internal.p.d(pVar.getCardId(), cardId)) {
                pVar = null;
            }
            if (pVar != null) {
                pVar.e(content);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatCardContainerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.pagerTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setVisibility(8);
        setClickable(false);
        setClipChildren(false);
        setClipToPadding(false);
    }

    public /* synthetic */ FloatCardContainerView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
