package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MenuHostHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f2675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f2676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f2677c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f2678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LifecycleEventObserver f2679b;

        public a(Lifecycle r10, LifecycleEventObserver r11) {
            this.f2678a = r10;
            this.f2679b = r11;
            r10.a(r11);
        }

        public void a() {
            this.f2678a.d(this.f2679b);
            this.f2679b = null;
        }
    }

    public MenuHostHelper(Runnable r10) {
        this.f2676b = new CopyOnWriteArrayList();
        this.f2677c = new HashMap();
        this.f2675a = r10;
    }

    public static /* synthetic */ void a(MenuHostHelper r10, Lifecycle.State r11, MenuProvider r12, LifecycleOwner r13, Lifecycle.Event r14) {
        r10.g(r11, r12, r13, r14);
    }

    public static /* synthetic */ void b(MenuHostHelper r10, MenuProvider r11, LifecycleOwner r12, Lifecycle.Event r13) {
        r10.f(r11, r12, r13);
    }

    public void c(MenuProvider r10) {
        this.f2676b.add(r10);
        this.f2675a.run();
    }

    public void d(final MenuProvider r10, LifecycleOwner r11) {
        c(r10);
        Lifecycle r12 = r11.getLifecycle();
        a r13 = (a) this.f2677c.remove(r10);
        if (r13 == null) goto L5;
        r13.a();
    L5:
        LifecycleEventObserver r14 = new g(this, r10);
        this.f2677c.put(r10, new a(r12, r14));
    }

    public void e(final MenuProvider r10, LifecycleOwner r11, final Lifecycle.State r12) {
        Lifecycle r13 = r11.getLifecycle();
        a r14 = (a) this.f2677c.remove(r10);
        if (r14 == null) goto L5;
        r14.a();
    L5:
        LifecycleEventObserver r15 = new f(this, r12, r10);
        this.f2677c.put(r10, new a(r13, r15));
    }

    public final /* synthetic */ void f(MenuProvider r10, LifecycleOwner r11, Lifecycle.Event r12) {
        if (r12 != Lifecycle.Event.ON_DESTROY) goto L6;
        l(r10);
        return;
    }

    public final /* synthetic */ void g(Lifecycle.State r10, MenuProvider r11, LifecycleOwner r12, Lifecycle.Event r13) {
        if (r13 != Lifecycle.Event.upTo(r10)) goto L6;
        c(r11);
        return;
    L6:
        if (r13 != Lifecycle.Event.ON_DESTROY) goto L9;
        l(r11);
        return;
    L9:
        if (r13 != Lifecycle.Event.downFrom(r10)) goto L14;
        this.f2676b.remove(r11);
        this.f2675a.run();
        return;
    }

    public void h(Menu r10, MenuInflater r11) {
        Iterator r12 = this.f2676b.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((MenuProvider) r12.next()).onCreateMenu(r10, r11);
        goto L4
    }

    public void i(Menu r10) {
        Iterator r11 = this.f2676b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((MenuProvider) r11.next()).onMenuClosed(r10);
        goto L4
    }

    public boolean j(MenuItem r10) {
        Iterator r11 = this.f2676b.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (((MenuProvider) r11.next()).onMenuItemSelected(r10) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void k(Menu r10) {
        Iterator r11 = this.f2676b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((MenuProvider) r11.next()).onPrepareMenu(r10);
        goto L4
    }

    public void l(MenuProvider r10) {
        this.f2676b.remove(r10);
        a r11 = (a) this.f2677c.remove(r10);
        if (r11 == null) goto L5;
        r11.a();
    L5:
        this.f2675a.run();
    }
}
