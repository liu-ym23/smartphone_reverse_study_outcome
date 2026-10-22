package A;

import W.m;
import W.n;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.RenderNode;
import android.view.ViewTreeObserver;
import androidx.appcompat.app.C0186l;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.utils.Property;
import com.stepos.common.widget.EmptyView;
import h.RunnableC0583a;
import stepos.support.v7.app.F;
import stepos.support.v7.app.G;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes.dex */
public final class e implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f23a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f24b;

    public /* synthetic */ e(int i4, Object obj) {
        this.f23a = i4;
        this.f24b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        int i4 = this.f23a;
        int i5 = 0;
        Object obj = this.f24b;
        switch (i4) {
            case 0:
                ((CoordinatorLayout) obj).A(0);
                break;
            case 1:
                EmptyView emptyView = (EmptyView) obj;
                emptyView.f11609d.getViewTreeObserver().removeOnPreDrawListener(this);
                emptyView.f11609d.post(new RunnableC0583a(20, this));
                break;
            case 2:
                C0186l c0186l = ((r2.c) obj).f14080d;
                RenderNode renderNode = (RenderNode) c0186l.f2661c;
                if (renderNode != null) {
                    int i6 = c0186l.f2660b;
                    c0186l.f2660b = i6 + 1;
                    renderNode.setRotationX(i6);
                    break;
                }
                break;
            default:
                G g4 = (G) obj;
                g4.f14272c.getViewTreeObserver().removeOnPreDrawListener(this);
                AnimatorSet animatorSet = new AnimatorSet();
                PopupNestedScrollingLayout popupNestedScrollingLayout = g4.f14272c;
                popupNestedScrollingLayout.setTranslationY(popupNestedScrollingLayout.getCurrentScrollY() <= 0 ? popupNestedScrollingLayout.getUncollapsibleHeight() : popupNestedScrollingLayout.getMeasuredHeight());
                n nVar = new n();
                nVar.a(0.88f);
                nVar.b(340.0f);
                m mVar = g4.f14278i;
                mVar.f1974m = nVar;
                nVar.f1985i = Property.DEFAULT_FLOAT_VALUE;
                if (g4.a()) {
                    mVar.i();
                } else {
                    popupNestedScrollingLayout.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
                }
                ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(g4.f14270a, ViewTweenItem.ALPHA, 0, g4.f14271b);
                objectAnimatorOfInt.setInterpolator(G.f14269k);
                objectAnimatorOfInt.setDuration(100L);
                animatorSet.addListener(new F(g4, i5));
                animatorSet.playTogether(objectAnimatorOfInt);
                animatorSet.start();
                break;
        }
        return true;
    }
}
