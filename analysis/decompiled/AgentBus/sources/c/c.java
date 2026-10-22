package c;

import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.t;
import androidx.lifecycle.v;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements t {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ o f1669f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i f1670g;

    public /* synthetic */ c(o oVar, i iVar) {
        this.f1669f = oVar;
        this.f1670g = iVar;
    }

    @Override // androidx.lifecycle.t
    public final void b(v vVar, androidx.lifecycle.p pVar) {
        c7.o oVar = this.f1669f.f1712b;
        if (pVar == androidx.lifecycle.p.ON_CREATE) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = this.f1670g.getOnBackInvokedDispatcher();
            q7.k.d(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            ((n) oVar.getValue()).f1710c.x(new d3.l(onBackInvokedDispatcher, 0), 1);
            ((n) oVar.getValue()).f1710c.x(new d3.l(onBackInvokedDispatcher, 1000000), 0);
        }
    }
}
