package com.bytedance.android.shopping.anchorv4.components.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import b73.b;
import b73.c;
import b73.d;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv4.containers.page.PageLifeCycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/components/base/ComponentContainer;", "Landroidx/lifecycle/LifecycleObserver;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentContainer implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Class<? extends Object>, c> f166073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f166074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PageLifeCycleOwner f166075c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentContainer f166076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f166077b;

        public a(ComponentContainer r100, c r101) {
            this.f166076a = r100;
            this.f166077b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f166076a.d(this.f166077b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ComponentContainer(PageLifeCycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        this.f166075c = r100;
        this.f166073a = new LinkedHashMap();
    }

    public final synchronized <T> T a(Class<T> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "clazz");     // Catch: Throwable -> L8
        T r101 = (T) b(this.f166073a.get(r100));
        if ((r101 instanceof Object) == true) goto L6;
        r101 = null;
    L6:
        monitor-exit(this);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    public final Object b(c r100) {
        if (r100 == null) goto L5;
        Object r101 = r100.f17935c;
    L6:
        if (r101 != null) goto L29;
        monitor-enter(this);
        if (r100 != null) goto L32;
    L23:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(this);
    L26:
        th = move-exception;
        throw th;
    L32:
        if (r100.f17936d.f17932a == 2) goto L23;
        if (r100.f17935c != null) goto L23;
        if (r100.f17933a == true) goto L23;
        Object r103 = r100.f17937e.invoke();     // Catch: Throwable -> L26
        if (r103 != null) goto L18;
        d r104 = null;
    L19:
        if (r104 == null) goto L21;
        r104.x(this);     // Catch: Throwable -> L26
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L22:
        r100.f17935c = r104;     // Catch: Throwable -> L26
        r100.f17933a = true;     // Catch: Throwable -> L26
        d(r100);     // Catch: Throwable -> L26
        goto L23
    L21:
        r104 = null;
        goto L22
    L18:
        r104 = (d) r103;     // Catch: Throwable -> L26
    L29:
        if (r100 != null) goto L31;
        return null;
    L31:
        return r100.f17935c;
    L5:
        r101 = null;
        goto L6
    }

    public final void d(c r100) {
        Object r101 = r100.f17935c;
        if ((r101 instanceof d) == true) goto L5;
        r101 = null;
    L5:
        d r102 = (d) r101;
        if (r102 != null) goto L8;
        return;
    L8:
        Lazy r103 = UIUtils.f45548a;
        if (UIUtils.d() == true) goto L13;
        UIUtils.c().post(new a(this, r100));
        return;
    L13:
        if (this.f166074b == false) goto L16;
        r100.f17934b = true;
        return;
    L16:
        boolean r104 = false;
        if (this.f166075c.f166266a.getCurrentState() != Lifecycle.State.DESTROYED) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L23;
        r102.onCreate();
        r102.onDestroy();
    L39:
        r100.f17934b = true;
        return;
    L23:
        if (this.f166075c.f166266a.getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L25;
        boolean r106 = true;
    L26:
        if (r106 == false) goto L29;
        r102.onCreate();
    L29:
        if (this.f166075c.f166266a.getCurrentState().compareTo(Lifecycle.State.STARTED) < 0) goto L31;
        boolean r107 = true;
    L32:
        if (r107 == false) goto L35;
        r102.onStart();
    L35:
        if (this.f166075c.f166266a.getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L37;
        r104 = true;
    L37:
        if (r104 == false) goto L39;
        r102.onResume();
        goto L39
    L31:
        r107 = false;
        goto L32
    L25:
        r106 = false;
        goto L26
    L19:
        r105 = false;
        goto L20
    }

    public final <T> void c(Class<T> r100, b r101, Function0<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "creator");
        c r103 = new c(r101, r102);
        this.f166073a.put(r100, r103);
        if (r103.f17936d.f17932a != 0) goto L6;
        a(r100);
        return;
    }
}
