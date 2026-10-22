package aa;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.provider.Settings;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.stepos.common.widget.EmptyView;
import java.lang.invoke.VarHandle;
import stepos.support.v7.app.v;
import stepos.support.v7.app.w;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f331c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f332f;

    public l(androidx.coordinatorlayout.widget.a aVar) {
        this.f331c = 1;
        this.f332f = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() throws Settings.SettingNotFoundException {
        float f5;
        int i = 0;
        switch (this.f331c) {
            case 0:
                n nVar = (n) this.f332f;
                View view = (View) nVar.f335f.get();
                if (view != null && view.getViewTreeObserver().isAlive()) {
                    view.getViewTreeObserver().removeOnPreDrawListener(this);
                    nVar.f340l = null;
                    nVar.f339k = false;
                    o oVar = nVar.f336g;
                    if (oVar != null) {
                        nVar.d(td.h.k(oVar));
                        break;
                    }
                } else {
                    nVar.b();
                    break;
                }
                break;
            case 1:
                ((androidx.coordinatorlayout.widget.a) this.f332f).A(0);
                break;
            case 2:
                TextView textView = ((EmptyView) this.f332f).f2589h;
                textView.getViewTreeObserver().removeOnPreDrawListener(this);
                androidx.fragment.app.r rVar = new androidx.fragment.app.r(2);
                rVar.f1301f = this;
                VarHandle.storeStoreFence();
                textView.post(rVar);
                break;
            default:
                w wVar = (w) this.f332f;
                wVar.f12512c.getViewTreeObserver().removeOnPreDrawListener(this);
                z3.g gVar = wVar.f12516g;
                AnimatorSet animatorSet = new AnimatorSet();
                PopupNestedScrollingLayout popupNestedScrollingLayout = wVar.f12512c;
                popupNestedScrollingLayout.setTranslationY(popupNestedScrollingLayout.getCurrentScrollY() <= 0 ? popupNestedScrollingLayout.getUncollapsibleHeight() : popupNestedScrollingLayout.getMeasuredHeight());
                z3.h hVar = new z3.h();
                hVar.a(0.88f);
                hVar.b(340.0f);
                gVar.f16369k = hVar;
                hVar.i = 0.0f;
                try {
                    f5 = Settings.Global.getFloat(wVar.f12513d.getContentResolver(), "transition_animation_scale");
                } catch (Exception unused) {
                    f5 = 1.0f;
                }
                if (f5 != 0.0f) {
                    gVar.g();
                } else {
                    popupNestedScrollingLayout.setTranslationY(0.0f);
                }
                ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(wVar.f12510a, "alpha", 0, wVar.f12511b);
                objectAnimatorOfInt.setInterpolator(w.i);
                objectAnimatorOfInt.setDuration(100L);
                animatorSet.addListener(new v(wVar, i));
                animatorSet.playTogether(objectAnimatorOfInt);
                animatorSet.start();
                break;
        }
        return true;
    }

    public /* synthetic */ l(int i) {
        this.f331c = i;
    }
}
