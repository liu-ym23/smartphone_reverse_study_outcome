package r2;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import jb.v;
import v1.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10429c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ o f10430f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(o oVar, int i) {
        super(1);
        this.f10429c = i;
        this.f10430f = oVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f10429c) {
            case 0:
                b1.a aVar = (b1.a) obj;
                o oVar = this.f10430f;
                View viewC = j.c(oVar);
                if (!viewC.isFocused() && !viewC.hasFocus()) {
                    if (!b1.e.y(viewC, b1.e.C(aVar.f1804a), j.b(((t) u1.f.v(oVar)).getFocusOwner(), u1.f.w(oVar), viewC))) {
                        aVar.f1805b = true;
                    }
                }
                break;
            default:
                b1.a aVar2 = (b1.a) obj;
                o oVar2 = this.f10430f;
                View viewC2 = j.c(oVar2);
                if (viewC2.hasFocus()) {
                    b1.h focusOwner = ((t) u1.f.v(oVar2)).getFocusOwner();
                    View viewW = u1.f.w(oVar2);
                    if (!(viewC2 instanceof ViewGroup)) {
                        if (!viewW.requestFocus()) {
                            od.f.e("host view did not take focus");
                            break;
                        }
                    } else {
                        Rect rectB = j.b(focusOwner, viewW, viewC2);
                        Integer numC = b1.e.C(aVar2.f1804a);
                        int iIntValue = numC != null ? numC.intValue() : 130;
                        FocusFinder focusFinder = FocusFinder.getInstance();
                        View view = oVar2.f10431s;
                        View viewFindNextFocus = view != null ? focusFinder.findNextFocus((ViewGroup) viewW, view, iIntValue) : focusFinder.findNextFocusFromRect((ViewGroup) viewW, rectB, iIntValue);
                        if (viewFindNextFocus != null && j.a(viewC2, viewFindNextFocus)) {
                            viewFindNextFocus.requestFocus(iIntValue, rectB);
                            aVar2.f1805b = true;
                        } else if (!viewW.requestFocus()) {
                            od.f.e("host view did not take focus");
                            break;
                        }
                    }
                }
                break;
        }
        return v.f6774a;
    }
}
