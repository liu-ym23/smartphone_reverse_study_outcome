package androidx.appcompat.widget;

import K.InterfaceC0084p;
import android.view.MenuItem;
import java.util.Iterator;
import k.C0661o;
import k.InterfaceC0659m;

/* loaded from: classes.dex */
public final class a1 implements InterfaceC0224s, InterfaceC0659m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Toolbar f3052a;

    public /* synthetic */ a1(Toolbar toolbar) {
        this.f3052a = toolbar;
    }

    @Override // k.InterfaceC0659m
    public final boolean i(C0661o c0661o, MenuItem menuItem) {
        this.f3052a.getClass();
        return false;
    }

    @Override // k.InterfaceC0659m
    public final void n(C0661o c0661o) {
        Toolbar toolbar = this.f3052a;
        C0217o c0217o = toolbar.f2984a.f2791t;
        if (c0217o == null || !c0217o.i()) {
            Iterator it = toolbar.f2973G.f991b.iterator();
            while (it.hasNext()) {
                ((androidx.fragment.app.S) ((InterfaceC0084p) it.next())).f3641a.s(c0661o);
            }
        }
    }
}
