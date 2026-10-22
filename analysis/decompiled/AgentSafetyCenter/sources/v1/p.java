package v1;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14521c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ t f14522f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(t tVar, int i) {
        super(1);
        this.f14521c = i;
        this.f14522f = tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xb.l
    public final Object invoke(Object obj) {
        b1.c cVarA;
        int i = this.f14521c;
        t tVar = this.f14522f;
        char c9 = 1;
        switch (i) {
            case 0:
                KeyEvent keyEvent = ((m1.b) obj).f8187a;
                long jB = id.k.b(keyEvent.getKeyCode());
                if (m1.a.a(jB, m1.a.f8173c)) {
                    cVarA = b1.c.a(2);
                } else if (m1.a.a(jB, m1.a.f8174d)) {
                    cVarA = b1.c.a(1);
                } else if (m1.a.a(jB, m1.a.f8179j)) {
                    cVarA = b1.c.a(keyEvent.isShiftPressed() ? 2 : 1);
                } else {
                    cVarA = m1.a.a(jB, m1.a.f8178h) ? b1.c.a(4) : m1.a.a(jB, m1.a.f8177g) ? b1.c.a(3) : (m1.a.a(jB, m1.a.f8175e) || m1.a.a(jB, m1.a.f8182m)) ? b1.c.a(5) : (m1.a.a(jB, m1.a.f8176f) || m1.a.a(jB, m1.a.f8183n)) ? b1.c.a(6) : (m1.a.a(jB, m1.a.i) || m1.a.a(jB, m1.a.f8180k) || m1.a.a(jB, m1.a.f8184o)) ? b1.c.a(7) : (m1.a.a(jB, m1.a.f8172b) || m1.a.a(jB, m1.a.f8181l)) ? b1.c.a(8) : null;
                }
                if (cVarA != null) {
                    int i3 = cVarA.f1810a;
                    if (id.c.t(keyEvent) == 2) {
                        Integer numC = b1.e.C(i3);
                        c1.c embeddedViewFocusRect = tVar.getEmbeddedViewFocusRect();
                        Boolean boolE = ((b1.i) tVar.getFocusOwner()).e(i3, embeddedViewFocusRect, new o(cVarA, c9 == true ? 1 : 0));
                        if (boolE != null ? boolE.booleanValue() : true) {
                            return Boolean.TRUE;
                        }
                        int i10 = 0;
                        if ((i3 == 1 || i3 == 2) != true) {
                            return Boolean.FALSE;
                        }
                        if (numC != null) {
                            int iIntValue = numC.intValue();
                            Object obj2 = f1.f14416f.get();
                            obj2.getClass();
                            f1 f1Var = (f1) obj2;
                            View viewB = tVar;
                            while (true) {
                                if (viewB != null) {
                                    View rootView = tVar.getRootView();
                                    rootView.getClass();
                                    viewB = f1Var.b(iIntValue, viewB, (ViewGroup) rootView);
                                    if (viewB != null) {
                                        if (!viewB.equals(tVar)) {
                                            for (ViewParent parent = viewB.getParent(); parent != null; parent = parent.getParent()) {
                                                if (parent == tVar) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    viewB = null;
                                }
                            }
                            if (yb.k.a(viewB, tVar)) {
                                viewB = null;
                            }
                            if (viewB != null) {
                                Rect rect = embeddedViewFocusRect != null ? new Rect((int) embeddedViewFocusRect.f2167a, (int) embeddedViewFocusRect.f2168b, (int) embeddedViewFocusRect.f2169c, (int) embeddedViewFocusRect.f2170d) : null;
                                if (rect == null) {
                                    od.f.e("Invalid rect");
                                    return null;
                                }
                                View rootView2 = tVar.getRootView();
                                rootView2.getClass();
                                ViewGroup viewGroup = (ViewGroup) rootView2;
                                viewGroup.offsetDescendantRectToMyCoords(tVar, rect);
                                viewGroup.offsetRectIntoDescendantCoords(viewB, rect);
                                if (b1.e.y(viewB, numC, rect)) {
                                    return Boolean.TRUE;
                                }
                            }
                        }
                        if (!((b1.i) tVar.getFocusOwner()).b(i3, false, false)) {
                            return Boolean.TRUE;
                        }
                        Boolean boolE2 = ((b1.i) tVar.getFocusOwner()).e(i3, null, new o(cVarA, i10));
                        return Boolean.valueOf(boolE2 != null ? boolE2.booleanValue() : true);
                    }
                }
                return Boolean.FALSE;
            default:
                xb.a aVar = (xb.a) obj;
                Handler handler = tVar.getHandler();
                if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
                    aVar.invoke();
                } else {
                    Handler handler2 = tVar.getHandler();
                    if (handler2 != null) {
                        r2.b bVar = new r2.b(1);
                        bVar.f10369f = aVar;
                        VarHandle.storeStoreFence();
                        handler2.post(bVar);
                    }
                }
                return jb.v.f6774a;
        }
    }
}
