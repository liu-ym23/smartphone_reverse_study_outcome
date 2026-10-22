package j1;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class u extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5336g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ y f5337h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(y yVar, int i2) {
        super(1);
        this.f5336g = i2;
        this.f5337h = yVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        s0.b bVar;
        boolean zRequestFocus;
        switch (this.f5336g) {
            case 0:
                KeyEvent keyEvent = ((a1.c) obj).f155a;
                long jA = ib.c.a(keyEvent.getKeyCode());
                if (a1.b.a(jA, a1.b.f140c)) {
                    bVar = new s0.b(2);
                } else if (a1.b.a(jA, a1.b.f141d)) {
                    bVar = new s0.b(1);
                } else if (a1.b.a(jA, a1.b.f147j)) {
                    bVar = new s0.b(keyEvent.isShiftPressed() ? 2 : 1);
                } else {
                    bVar = a1.b.a(jA, a1.b.f145h) ? new s0.b(4) : a1.b.a(jA, a1.b.f144g) ? new s0.b(3) : (a1.b.a(jA, a1.b.f142e) || a1.b.a(jA, a1.b.f150m)) ? new s0.b(5) : (a1.b.a(jA, a1.b.f143f) || a1.b.a(jA, a1.b.f151n)) ? new s0.b(6) : (a1.b.a(jA, a1.b.f146i) || a1.b.a(jA, a1.b.f148k) || a1.b.a(jA, a1.b.f152o)) ? new s0.b(7) : (a1.b.a(jA, a1.b.f139b) || a1.b.a(jA, a1.b.f149l)) ? new s0.b(8) : null;
                }
                if (bVar != null) {
                    int i2 = bVar.f9166a;
                    if (a.a.Q(keyEvent) == 2) {
                        Integer num = i2 == 5 ? 33 : i2 == 6 ? 130 : i2 == 3 ? 17 : i2 == 4 ? 66 : i2 == 1 ? 2 : i2 == 2 ? 1 : null;
                        y yVar = this.f5337h;
                        t0.c embeddedViewFocusRect = yVar.getEmbeddedViewFocusRect();
                        Boolean boolJ = ((m4.u0) yVar.getFocusOwner()).j(i2, embeddedViewFocusRect, new t(bVar, 1));
                        if (boolJ != null ? boolJ.booleanValue() : true) {
                            return Boolean.TRUE;
                        }
                        if (!(i2 == 1 || i2 == 2)) {
                            return Boolean.FALSE;
                        }
                        if (num != null) {
                            int iIntValue = num.intValue();
                            Object obj2 = l1.f5240f.get();
                            q7.k.b(obj2);
                            l1 l1Var = (l1) obj2;
                            View viewB = yVar;
                            while (true) {
                                if (viewB != null) {
                                    View rootView = yVar.getRootView();
                                    q7.k.c(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
                                    viewB = l1Var.b((ViewGroup) rootView, viewB, iIntValue);
                                    if (viewB != null) {
                                        if (!viewB.equals(yVar)) {
                                            for (ViewParent parent = viewB.getParent(); parent != null; parent = parent.getParent()) {
                                                if (parent == yVar) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    viewB = null;
                                }
                            }
                            if (q7.k.a(viewB, yVar)) {
                                viewB = null;
                            }
                            if (viewB != null) {
                                Rect rect = embeddedViewFocusRect != null ? new Rect((int) embeddedViewFocusRect.f9656a, (int) embeddedViewFocusRect.f9657b, (int) embeddedViewFocusRect.f9658c, (int) embeddedViewFocusRect.f9659d) : null;
                                if (rect == null) {
                                    throw new IllegalStateException("Invalid rect");
                                }
                                View rootView2 = yVar.getRootView();
                                q7.k.c(rootView2, "null cannot be cast to non-null type android.view.ViewGroup");
                                ViewGroup viewGroup = (ViewGroup) rootView2;
                                viewGroup.offsetDescendantRectToMyCoords(yVar, rect);
                                viewGroup.offsetRectIntoDescendantCoords(viewB, rect);
                                if (viewB instanceof ViewGroup) {
                                    ViewGroup viewGroup2 = (ViewGroup) viewB;
                                    if (viewGroup2.isFocused()) {
                                        zRequestFocus = true;
                                    } else if (viewGroup2.isFocusable() && !viewGroup2.hasFocus()) {
                                        zRequestFocus = viewGroup2.requestFocus(num.intValue(), rect);
                                    } else if (viewB instanceof y) {
                                        zRequestFocus = ((y) viewB).requestFocus(num.intValue(), rect);
                                    } else {
                                        View viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup2, rect, num.intValue());
                                        int iIntValue2 = num.intValue();
                                        zRequestFocus = viewFindNextFocusFromRect != null ? viewFindNextFocusFromRect.requestFocus(iIntValue2, rect) : viewGroup2.requestFocus(iIntValue2, rect);
                                    }
                                } else {
                                    zRequestFocus = viewB.requestFocus(num.intValue(), rect);
                                }
                                if (zRequestFocus) {
                                    return Boolean.TRUE;
                                }
                            }
                        }
                        if (!((m4.u0) yVar.getFocusOwner()).e(i2, false, false)) {
                            return Boolean.TRUE;
                        }
                        Boolean boolJ2 = ((m4.u0) yVar.getFocusOwner()).j(i2, null, new t(bVar, 0));
                        return Boolean.valueOf(boolJ2 != null ? boolJ2.booleanValue() : true);
                    }
                }
                return Boolean.FALSE;
            default:
                p7.a aVar = (p7.a) obj;
                y yVar2 = this.f5337h;
                Handler handler = yVar2.getHandler();
                if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
                    aVar.c();
                } else {
                    Handler handler2 = yVar2.getHandler();
                    if (handler2 != null) {
                        handler2.post(new x(aVar, 0));
                    }
                }
                return c7.r.f1986a;
        }
    }
}
