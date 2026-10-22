package r2;

import android.view.WindowInsets;
import java.util.HashMap;
import jb.v;
import n3.k0;
import n3.m1;
import u1.g0;
import u1.n1;
import v1.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10374c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ q f10375f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g0 f10376g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(q qVar, g0 g0Var, int i) {
        super(1);
        this.f10374c = i;
        this.f10375f = qVar;
        this.f10376g = g0Var;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        WindowInsets windowInsetsG;
        switch (this.f10374c) {
            case 0:
                n1 n1Var = (n1) obj;
                t tVar = n1Var instanceof t ? (t) n1Var : null;
                q qVar = this.f10375f;
                if (tVar != null) {
                    HashMap<h, g0> holderToLayoutNode = tVar.getAndroidViewsHandler$ui_release().getHolderToLayoutNode();
                    g0 g0Var = this.f10376g;
                    holderToLayoutNode.put(qVar, g0Var);
                    tVar.getAndroidViewsHandler$ui_release().addView(qVar);
                    tVar.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(g0Var, qVar);
                    qVar.setImportantForAccessibility(1);
                    k0.g(qVar, new com.google.android.material.appbar.d(tVar, g0Var, tVar));
                }
                if (qVar.getView().getParent() != qVar) {
                    qVar.addView(qVar.getView());
                }
                break;
            case 1:
                j.d(this.f10375f, this.f10376g);
                break;
            default:
                g0 g0Var2 = this.f10376g;
                q qVar2 = this.f10375f;
                j.d(qVar2, g0Var2);
                ((t) qVar2.f10389g).E = true;
                int[] iArr = qVar2.f10399r;
                int i = iArr[0];
                int i3 = iArr[1];
                qVar2.getView().getLocationOnScreen(iArr);
                long j10 = qVar2.f10400s;
                long jL = ((s1.q) obj).l();
                qVar2.f10400s = jL;
                m1 m1Var = qVar2.f10401t;
                if (m1Var != null && ((i != iArr[0] || i3 != iArr[1] || !o2.k.b(j10, jL)) && (windowInsetsG = qVar2.f(m1Var).g()) != null)) {
                    qVar2.getView().dispatchApplyWindowInsets(windowInsetsG);
                }
                break;
        }
        return v.f6774a;
    }
}
