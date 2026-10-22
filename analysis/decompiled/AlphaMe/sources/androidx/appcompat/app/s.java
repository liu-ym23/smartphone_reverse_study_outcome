package androidx.appcompat.app;

import K.InterfaceC0088u;
import K.S;
import K.e0;
import K.q0;
import K.z0;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.C0205i;
import androidx.appcompat.widget.C0217o;
import androidx.appcompat.widget.InterfaceC0212l0;
import androidx.appcompat.widget.InterfaceC0214m0;
import androidx.appcompat.widget.InterfaceC0231v0;
import androidx.appcompat.widget.g1;
import k.C0661o;
import k.InterfaceC0672z;

/* loaded from: classes.dex */
public final class s implements InterfaceC0088u, InterfaceC0231v0, InterfaceC0212l0, InterfaceC0672z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2678a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ F f2679b;

    public /* synthetic */ s(F f4, int i4) {
        this.f2678a = i4;
        this.f2679b = f4;
    }

    @Override // androidx.appcompat.widget.InterfaceC0231v0
    public final void a(Rect rect) {
        rect.top = this.f2679b.z(null, rect);
    }

    @Override // k.InterfaceC0672z
    public final void b(C0661o c0661o, boolean z4) {
        E e4;
        int i4 = this.f2678a;
        F f4 = this.f2679b;
        switch (i4) {
            case 3:
                f4.e(c0661o);
                break;
            default:
                C0661o c0661oK = c0661o.k();
                int i5 = 0;
                boolean z5 = c0661oK != c0661o;
                if (z5) {
                    c0661o = c0661oK;
                }
                E[] eArr = f4.f2490E;
                int length = eArr != null ? eArr.length : 0;
                while (true) {
                    if (i5 >= length) {
                        e4 = null;
                    } else {
                        e4 = eArr[i5];
                        if (e4 == null || e4.f2474h != c0661o) {
                            i5++;
                        }
                    }
                }
                if (e4 != null) {
                    if (!z5) {
                        f4.f(e4, z4);
                        break;
                    } else {
                        f4.d(e4.f2467a, e4, c0661oK);
                        f4.f(e4, true);
                        break;
                    }
                }
                break;
        }
    }

    @Override // K.InterfaceC0088u
    public final z0 e(View view, z0 z0Var) {
        int iD = z0Var.d();
        int iZ = this.f2679b.z(z0Var, null);
        if (iD != iZ) {
            int iB = z0Var.b();
            int iC = z0Var.c();
            int iA = z0Var.a();
            q0 q0Var = new q0(z0Var);
            q0Var.e(D.c.b(iB, iZ, iC, iA));
            z0Var = q0Var.b();
        }
        return S.e(view, z0Var);
    }

    @Override // k.InterfaceC0672z
    public final boolean f(C0661o c0661o) {
        Window.Callback callback;
        int i4 = this.f2678a;
        F f4 = this.f2679b;
        switch (i4) {
            case 3:
                Window.Callback callback2 = f4.f2513f.getCallback();
                if (callback2 != null) {
                    callback2.onMenuOpened(108, c0661o);
                    break;
                }
                break;
            default:
                if (c0661o == c0661o.k() && f4.f2532y && (callback = f4.f2513f.getCallback()) != null && !f4.f2495J) {
                    callback.onMenuOpened(108, c0661o);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // androidx.appcompat.widget.InterfaceC0212l0
    public final void onDetachedFromWindow() {
        C0217o c0217o;
        F f4 = this.f2679b;
        InterfaceC0214m0 interfaceC0214m0 = f4.f2517j;
        if (interfaceC0214m0 != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0214m0;
            actionBarOverlayLayout.f();
            ActionMenuView actionMenuView = ((g1) actionBarOverlayLayout.f2763e).f3087a.f2984a;
            if (actionMenuView != null && (c0217o = actionMenuView.f2791t) != null) {
                c0217o.g();
                C0205i c0205i = c0217o.f3145t;
                if (c0205i != null && c0205i.b()) {
                    c0205i.f13316j.dismiss();
                }
            }
        }
        if (f4.f2522o != null) {
            f4.f2513f.getDecorView().removeCallbacks(f4.f2523p);
            if (f4.f2522o.isShowing()) {
                try {
                    f4.f2522o.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            f4.f2522o = null;
        }
        e0 e0Var = f4.f2524q;
        if (e0Var != null) {
            e0Var.b();
        }
        C0661o c0661o = f4.o(0).f2474h;
        if (c0661o != null) {
            c0661o.c(true);
        }
    }
}
