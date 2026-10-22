package K;

import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: K.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0082n {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f990a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f991b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f992c = new HashMap();

    public C0082n(Runnable runnable) {
        this.f990a = runnable;
    }

    public final boolean a(MenuItem menuItem) {
        Iterator it = this.f991b.iterator();
        while (it.hasNext()) {
            if (((androidx.fragment.app.S) ((InterfaceC0084p) it.next())).f3641a.o(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void b(InterfaceC0084p interfaceC0084p) {
        this.f991b.remove(interfaceC0084p);
        C0081m c0081m = (C0081m) this.f992c.remove(interfaceC0084p);
        if (c0081m != null) {
            c0081m.f987a.b(c0081m.f988b);
            c0081m.f988b = null;
        }
        this.f990a.run();
    }
}
