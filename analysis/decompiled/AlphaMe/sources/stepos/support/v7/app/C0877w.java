package stepos.support.v7.app;

import K.InterfaceC0088u;
import K.q0;
import K.z0;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.InterfaceC0212l0;
import androidx.appcompat.widget.InterfaceC0231v0;

/* renamed from: stepos.support.v7.app.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0877w implements L3.i, InterfaceC0088u, InterfaceC0231v0, InterfaceC0212l0, L3.v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14592a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0880z f14593b;

    public /* synthetic */ C0877w(AbstractC0880z abstractC0880z, int i4) {
        this.f14592a = i4;
        this.f14593b = abstractC0880z;
    }

    @Override // androidx.appcompat.widget.InterfaceC0231v0
    public final void a(Rect rect) {
        rect.top = AbstractC0880z.o(this.f14593b, rect.top);
    }

    @Override // L3.i
    public final boolean b(L3.k kVar, MenuItem menuItem) {
        AbstractC0880z abstractC0880z = this.f14593b;
        InterfaceC0867l interfaceC0867l = abstractC0880z.f14513e;
        if (interfaceC0867l == null || abstractC0880z.f14523o || !(menuItem instanceof L3.g)) {
            return false;
        }
        return interfaceC0867l.onBottomItemSelected((L3.g) menuItem);
    }

    @Override // L3.i
    public final void c(L3.k kVar) {
    }

    @Override // L3.v
    public final void d(L3.k kVar, boolean z4) {
        C0879y c0879y;
        int i4 = this.f14592a;
        AbstractC0880z abstractC0880z = this.f14593b;
        switch (i4) {
            case 4:
                abstractC0880z.q(kVar);
                break;
            default:
                L3.k kVarK = kVar.k();
                int i5 = 0;
                boolean z5 = kVarK != kVar;
                if (z5) {
                    kVar = kVarK;
                }
                C0879y[] c0879yArr = abstractC0880z.f14617F;
                int length = c0879yArr != null ? c0879yArr.length : 0;
                while (true) {
                    if (i5 >= length) {
                        c0879y = null;
                    } else {
                        c0879y = c0879yArr[i5];
                        if (c0879y == null || c0879y.f14602h != kVar) {
                            i5++;
                        }
                    }
                }
                if (c0879y != null) {
                    if (!z5) {
                        abstractC0880z.r(c0879y, z4);
                        break;
                    } else {
                        abstractC0880z.p(c0879y.f14595a, c0879y, kVarK);
                        abstractC0880z.r(c0879y, true);
                        break;
                    }
                }
                break;
        }
    }

    @Override // K.InterfaceC0088u
    public final z0 e(View view, z0 z0Var) {
        int iD = z0Var.d();
        int iO = AbstractC0880z.o(this.f14593b, iD);
        if (iD != iO) {
            int iB = z0Var.b();
            int iC = z0Var.c();
            int iA = z0Var.a();
            q0 q0Var = new q0(z0Var);
            q0Var.e(D.c.b(iB, iO, iC, iA));
            z0Var = q0Var.b();
        }
        return K.S.e(view, z0Var);
    }

    @Override // L3.v
    public final boolean g(L3.k kVar) {
        Window.Callback callback;
        int i4 = this.f14592a;
        AbstractC0880z abstractC0880z = this.f14593b;
        switch (i4) {
            case 4:
                Window.Callback callback2 = abstractC0880z.f14510b.getCallback();
                if (callback2 != null) {
                    callback2.onMenuOpened(108, kVar);
                    break;
                }
                break;
            default:
                if (kVar == null && abstractC0880z.f14516h && (callback = abstractC0880z.f14510b.getCallback()) != null && !abstractC0880z.f14523o) {
                    callback.onMenuOpened(108, kVar);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // androidx.appcompat.widget.InterfaceC0212l0
    public final void onDetachedFromWindow() {
        AbstractC0880z abstractC0880z = this.f14593b;
        stepos.support.v7.widget.C c4 = abstractC0880z.f14628q;
        if (c4 != null) {
            c4.l();
        }
        if (abstractC0880z.f14633v != null) {
            abstractC0880z.f14510b.getDecorView().removeCallbacks(abstractC0880z.f14634w);
            if (abstractC0880z.f14633v.isShowing()) {
                try {
                    abstractC0880z.f14633v.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            abstractC0880z.f14633v = null;
        }
        abstractC0880z.s();
        L3.k kVar = abstractC0880z.u(0).f14602h;
        if (kVar != null) {
            kVar.c(true);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0877w(AbstractC0880z abstractC0880z, int i4, int i5) {
        this(abstractC0880z, 4);
        this.f14592a = i4;
        int i6 = 5;
        if (i4 != 5) {
        } else {
            this(abstractC0880z, i6);
        }
    }
}
