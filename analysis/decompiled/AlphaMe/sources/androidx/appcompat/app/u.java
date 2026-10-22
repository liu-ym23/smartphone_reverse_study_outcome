package androidx.appcompat.app;

import K.S;
import K.e0;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.stepos.alphame.utils.Property;
import j.AbstractC0624c;
import j.InterfaceC0623b;
import java.util.WeakHashMap;
import k.C0661o;

/* loaded from: classes.dex */
public final class u implements InterfaceC0623b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0623b f2682a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ F f2683b;

    public u(F f4, j.g gVar) {
        this.f2683b = f4;
        this.f2682a = gVar;
    }

    @Override // j.InterfaceC0623b
    public final boolean a(AbstractC0624c abstractC0624c, MenuItem menuItem) {
        return this.f2682a.a(abstractC0624c, menuItem);
    }

    @Override // j.InterfaceC0623b
    public final boolean c(AbstractC0624c abstractC0624c, C0661o c0661o) {
        return this.f2682a.c(abstractC0624c, c0661o);
    }

    @Override // j.InterfaceC0623b
    public final void f(AbstractC0624c abstractC0624c) {
        this.f2682a.f(abstractC0624c);
        F f4 = this.f2683b;
        if (f4.f2522o != null) {
            f4.f2513f.getDecorView().removeCallbacks(f4.f2523p);
        }
        if (f4.f2521n != null) {
            e0 e0Var = f4.f2524q;
            if (e0Var != null) {
                e0Var.b();
            }
            e0 e0VarA = S.a(f4.f2521n);
            e0VarA.a(Property.DEFAULT_FLOAT_VALUE);
            f4.f2524q = e0VarA;
            e0VarA.e(new t(2, this));
        }
        f4.f2520m = null;
        ViewGroup viewGroup = f4.f2527t;
        WeakHashMap weakHashMap = S.f939a;
        K.H.c(viewGroup);
        f4.y();
    }

    @Override // j.InterfaceC0623b
    public final boolean g(AbstractC0624c abstractC0624c, C0661o c0661o) {
        ViewGroup viewGroup = this.f2683b.f2527t;
        WeakHashMap weakHashMap = S.f939a;
        K.H.c(viewGroup);
        return this.f2682a.g(abstractC0624c, c0661o);
    }
}
