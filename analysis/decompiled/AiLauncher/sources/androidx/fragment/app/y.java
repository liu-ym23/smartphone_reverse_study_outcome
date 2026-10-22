package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0013J'\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u0018J'\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u0018J/\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010\u0013J\u001d\u0010 \u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b \u0010\u0013J\u001d\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0013J\u001d\u0010!\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b!\u0010\u0013J%\u0010#\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b#\u0010\u0018J\u001d\u0010$\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b$\u0010\u0013J\u001d\u0010%\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b%\u0010\u0013J\u001d\u0010&\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b&\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010*¨\u0006,"}, d2 = {"Landroidx/fragment/app/y;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "Landroidx/fragment/app/FragmentManager$k;", "cb", "", "recursive", "LY8/t;", "o", "(Landroidx/fragment/app/FragmentManager$k;Z)V", "p", "(Landroidx/fragment/app/FragmentManager$k;)V", "Landroidx/fragment/app/Fragment;", "f", "onlyRecursive", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/fragment/app/Fragment;Z)V", Const.INTENT_KEY_PKGNAME, "Landroid/os/Bundle;", "savedInstanceState", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V", "c", Const.INTENT_KEY_APIKEY, "Landroid/view/View;", "v", "m", "(Landroidx/fragment/app/Fragment;Landroid/view/View;Landroid/os/Bundle;Z)V", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "l", "outState", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "n", Const.INTENT_KEY_UMID, "e", "Landroidx/fragment/app/FragmentManager;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/fragment/app/y$a;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "lifecycleCallbacks", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final FragmentManager fragmentManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CopyOnWriteArrayList<a> lifecycleCallbacks;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/fragment/app/y$a;", "", "Landroidx/fragment/app/FragmentManager$k;", "callback", "", "recursive", "<init>", "(Landroidx/fragment/app/FragmentManager$k;Z)V", Const.INTENT_KEY_APIKEY, "Landroidx/fragment/app/FragmentManager$k;", "()Landroidx/fragment/app/FragmentManager$k;", Const.INTENT_KEY_PKGNAME, "Z", "()Z", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final FragmentManager.k callback;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final boolean recursive;

        public a(FragmentManager.k callback, boolean z10) {
            kotlin.jvm.internal.p.i(callback, "callback");
            this.callback = callback;
            this.recursive = z10;
        }

        /* renamed from: a, reason: from getter */
        public final FragmentManager.k getCallback() {
            return this.callback;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getRecursive() {
            return this.recursive;
        }
    }

    public y(FragmentManager fragmentManager) {
        kotlin.jvm.internal.p.i(fragmentManager, "fragmentManager");
        this.fragmentManager = fragmentManager;
        this.lifecycleCallbacks = new CopyOnWriteArrayList<>();
    }

    public final void a(Fragment f10, Bundle savedInstanceState, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().a(f10, savedInstanceState, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().a(this.fragmentManager, f10, savedInstanceState);
            }
        }
    }

    public final void b(Fragment f10, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        Context context = this.fragmentManager.A0().getContext();
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().b(f10, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().b(this.fragmentManager, f10, context);
            }
        }
    }

    public final void c(Fragment f10, Bundle savedInstanceState, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().c(f10, savedInstanceState, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().c(this.fragmentManager, f10, savedInstanceState);
            }
        }
    }

    public final void d(Fragment f10, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().d(f10, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().d(this.fragmentManager, f10);
            }
        }
    }

    public final void e(Fragment f10, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().e(f10, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().e(this.fragmentManager, f10);
            }
        }
    }

    public final void f(Fragment f10, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().f(f10, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().f(this.fragmentManager, f10);
            }
        }
    }

    public final void g(Fragment f10, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        Context context = this.fragmentManager.A0().getContext();
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().g(f10, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().g(this.fragmentManager, f10, context);
            }
        }
    }

    public final void h(Fragment f10, Bundle savedInstanceState, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().h(f10, savedInstanceState, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().h(this.fragmentManager, f10, savedInstanceState);
            }
        }
    }

    public final void i(Fragment f10, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().i(f10, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().i(this.fragmentManager, f10);
            }
        }
    }

    public final void j(Fragment f10, Bundle outState, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        kotlin.jvm.internal.p.i(outState, "outState");
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().j(f10, outState, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().j(this.fragmentManager, f10, outState);
            }
        }
    }

    public final void k(Fragment f10, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().k(f10, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().k(this.fragmentManager, f10);
            }
        }
    }

    public final void l(Fragment f10, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().l(f10, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().l(this.fragmentManager, f10);
            }
        }
    }

    public final void m(Fragment f10, View v10, Bundle savedInstanceState, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        kotlin.jvm.internal.p.i(v10, "v");
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().m(f10, v10, savedInstanceState, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().m(this.fragmentManager, f10, v10, savedInstanceState);
            }
        }
    }

    public final void n(Fragment f10, boolean onlyRecursive) {
        kotlin.jvm.internal.p.i(f10, "f");
        Fragment fragmentD0 = this.fragmentManager.D0();
        if (fragmentD0 != null) {
            FragmentManager parentFragmentManager = fragmentD0.getParentFragmentManager();
            kotlin.jvm.internal.p.h(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.C0().n(f10, true);
        }
        Iterator<a> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!onlyRecursive || next.getRecursive()) {
                next.getCallback().n(this.fragmentManager, f10);
            }
        }
    }

    public final void o(FragmentManager.k cb2, boolean recursive) {
        kotlin.jvm.internal.p.i(cb2, "cb");
        this.lifecycleCallbacks.add(new a(cb2, recursive));
    }

    public final void p(FragmentManager.k cb2) {
        kotlin.jvm.internal.p.i(cb2, "cb");
        synchronized (this.lifecycleCallbacks) {
            try {
                int size = this.lifecycleCallbacks.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        break;
                    }
                    if (this.lifecycleCallbacks.get(i10).getCallback() == cb2) {
                        this.lifecycleCallbacks.remove(i10);
                        break;
                    }
                    i10++;
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
