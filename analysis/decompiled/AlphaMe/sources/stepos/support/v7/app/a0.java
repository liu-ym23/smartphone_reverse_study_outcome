package stepos.support.v7.app;

import android.view.MenuItem;
import java.security.InvalidParameterException;
import stepos.support.v7.widget.t0;

/* loaded from: classes2.dex */
public final class a0 implements t0, InterfaceC0856a, L3.i, L3.v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f14434a;

    public /* synthetic */ a0(c0 c0Var) {
        this.f14434a = c0Var;
    }

    @Override // stepos.support.v7.app.InterfaceC0856a
    public final void a(int i4, y.g gVar) {
        this.f14434a.getClass();
        if (i4 != 0 && i4 != 1) {
            throw new InvalidParameterException();
        }
    }

    @Override // L3.i
    public final boolean b(L3.k kVar, MenuItem menuItem) {
        return false;
    }

    @Override // L3.i
    public final void c(L3.k kVar) {
        c0 c0Var = this.f14434a;
        if (c0Var.f14440c != null) {
            if (c0Var.f14438a.f15201a.n()) {
                c0Var.f14440c.onPanelClosed(108, kVar);
            } else if (c0Var.f14440c.onPreparePanel(0, null, kVar)) {
                c0Var.f14440c.onMenuOpened(108, kVar);
            }
        }
    }

    @Override // L3.v
    public final void d(L3.k kVar, boolean z4) {
        b0 b0Var = this.f14434a.f14440c;
        if (b0Var != null) {
            b0Var.onPanelClosed(0, kVar);
        }
    }

    @Override // L3.v
    public final boolean g(L3.k kVar) {
        b0 b0Var;
        if (kVar != null || (b0Var = this.f14434a.f14440c) == null) {
            return true;
        }
        b0Var.onMenuOpened(0, kVar);
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(c0 c0Var, int i4) {
        this(c0Var);
        if (i4 != 3) {
        } else {
            this(c0Var);
        }
    }
}
