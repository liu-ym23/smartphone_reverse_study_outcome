package androidx.databinding;

import android.os.Build;
import android.os.Handler;
import android.view.Choreographer;
import android.view.View;
import androidx.appcompat.widget.p;
import androidx.databinding.library.R$id;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewDataBinding extends androidx.databinding.a implements ViewBinding {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f2879j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f2880k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CreateWeakListener f2881l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final CreateWeakListener f2882m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final CreateWeakListener f2883n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final CreateWeakListener f2884o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final androidx.databinding.c.a f2885p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReferenceQueue f2886q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final View.OnAttachStateChangeListener f2887r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f2888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f2890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Choreographer f2891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Choreographer.FrameCallback f2892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f2893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewDataBinding f2894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LifecycleOwner f2895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2896i;

    public interface CreateWeakListener {
        i create(ViewDataBinding r10, int r11);
    }

    public interface ObservableReference<T> {
        void addListener(T r10);

        i getListener();

        void removeListener(T r10);

        void setLifecycleOwner(LifecycleOwner r10);
    }

    public static class a implements CreateWeakListener {
        public a() {
        }

        @Override // androidx.databinding.ViewDataBinding.CreateWeakListener
        public i create(ViewDataBinding r10, int r11) {
            return new k(r10, r11).getListener();
        }
    }

    public static class b implements CreateWeakListener {
        public b() {
        }

        @Override // androidx.databinding.ViewDataBinding.CreateWeakListener
        public i create(ViewDataBinding r10, int r11) {
            return new h(r10, r11).getListener();
        }
    }

    public static class c implements CreateWeakListener {
        public c() {
        }

        @Override // androidx.databinding.ViewDataBinding.CreateWeakListener
        public i create(ViewDataBinding r10, int r11) {
            return new j(r10, r11).getListener();
        }
    }

    public static class d implements CreateWeakListener {
        public d() {
        }

        @Override // androidx.databinding.ViewDataBinding.CreateWeakListener
        public i create(ViewDataBinding r10, int r11) {
            return new g(r10, r11).getListener();
        }
    }

    public static class e extends androidx.databinding.c.a {
        public e() {
        }

        @Override // androidx.databinding.c.a
        public /* bridge */ /* synthetic */ void a(Object r10, Object r11, int r12, Object r13) {
            p.a(r10);
            b(null, (ViewDataBinding) r11, r12, (Void) r13);
        }

        public void b(androidx.databinding.g r10, ViewDataBinding r11, int r12, Void r13) {
            if (r12 != 1) goto L5;
            throw null;
        L5:
            if (r12 != 2) goto L7;
            throw null;
        L7:
            if (r12 == 3) goto L9;
            return;
        L9:
            throw null;
        }
    }

    public static class f implements View.OnAttachStateChangeListener {
        public f() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            ViewDataBinding.a(ViewDataBinding.d(r10)).run();
            r10.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
        }
    }

    public static class g implements Observer, ObservableReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f2897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LifecycleOwner f2898b;

        public g(ViewDataBinding r10, int r11) {
            this.f2897a = new i(r10, r11, this);
        }

        public void a(LiveData r10) {
            LifecycleOwner r11 = this.f2898b;
            if (r11 == null) goto L6;
            r10.i(r11, this);
            return;
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public /* bridge */ /* synthetic */ void addListener(Object r10) {
            a((LiveData) r10);
        }

        public void b(LiveData r10) {
            r10.n(this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public i getListener() {
            return this.f2897a;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Object r10) {
            ViewDataBinding r11 = this.f2897a.a();
            if (r11 == null) goto L6;
            i r12 = this.f2897a;
            ViewDataBinding.c(r11, r12.f2901b, r12.b(), 0);
            return;
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public /* bridge */ /* synthetic */ void removeListener(Object r10) {
            b((LiveData) r10);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner r10) {
            LiveData r11 = (LiveData) this.f2897a.b();
            if (r11 != null) goto L5;
        L9:
            this.f2898b = r10;
            return;
        L5:
            if (this.f2898b == null) goto L7;
            r11.n(this);
        L7:
            if (r10 == null) goto L9;
            r11.i(r10, this);
            goto L9
        }
    }

    public static class h extends ObservableList.a implements ObservableReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f2899a;

        public h(ViewDataBinding r10, int r11) {
            this.f2899a = new i(r10, r11, this);
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList r10) {
            ViewDataBinding r11 = this.f2899a.a();
            if (r11 != null) goto L5;
            return;
        L5:
            ObservableList r12 = (ObservableList) this.f2899a.b();
            if (r12 == r10) goto L8;
            return;
        L8:
            ViewDataBinding.c(r11, this.f2899a.f2901b, r12, 0);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public /* bridge */ /* synthetic */ void addListener(Object r10) {
            f((ObservableList) r10);
        }

        @Override // androidx.databinding.ObservableList.a
        public void b(ObservableList r10, int r11, int r12) {
            a(r10);
        }

        @Override // androidx.databinding.ObservableList.a
        public void c(ObservableList r10, int r11, int r12) {
            a(r10);
        }

        @Override // androidx.databinding.ObservableList.a
        public void d(ObservableList r10, int r11, int r12, int r13) {
            a(r10);
        }

        @Override // androidx.databinding.ObservableList.a
        public void e(ObservableList r10, int r11, int r12) {
            a(r10);
        }

        public void f(ObservableList r10) {
            r10.addOnListChangedCallback(this);
        }

        public void g(ObservableList r10) {
            r10.removeOnListChangedCallback(this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public i getListener() {
            return this.f2899a;
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public /* bridge */ /* synthetic */ void removeListener(Object r10) {
            g((ObservableList) r10);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner r10) {
        }
    }

    public static class i extends WeakReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ObservableReference f2900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f2902c;

        public i(ViewDataBinding r10, int r11, ObservableReference r12) {
            super(r10, ViewDataBinding.b());
            this.f2901b = r11;
            this.f2900a = r12;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewDataBinding a() {
            ViewDataBinding r10 = (ViewDataBinding) get();
            if (r10 != null) goto L5;
            c();
        L5:
            return r10;
        }

        public Object b() {
            return this.f2902c;
        }

        public boolean c() {
            Object r10 = this.f2902c;
            if (r10 == null) goto L5;
            this.f2900a.removeListener(r10);
            boolean r11 = true;
        L6:
            this.f2902c = null;
            return r11;
        L5:
            r11 = false;
            goto L6
        }
    }

    public static class j extends ObservableMap.a implements ObservableReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f2903a;

        public j(ViewDataBinding r10, int r11) {
            this.f2903a = new i(r10, r11, this);
        }

        public void a(ObservableMap r10) {
            r10.addOnMapChangedCallback(this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public /* bridge */ /* synthetic */ void addListener(Object r10) {
            a((ObservableMap) r10);
        }

        public void b(ObservableMap r10) {
            r10.removeOnMapChangedCallback(this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public i getListener() {
            return this.f2903a;
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public /* bridge */ /* synthetic */ void removeListener(Object r10) {
            b((ObservableMap) r10);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner r10) {
        }
    }

    public static class k extends Observable.a implements ObservableReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f2904a;

        public k(ViewDataBinding r10, int r11) {
            this.f2904a = new i(r10, r11, this);
        }

        @Override // androidx.databinding.Observable.a
        public void a(Observable r10, int r11) {
            ViewDataBinding r12 = this.f2904a.a();
            if (r12 != null) goto L6;
            return;
        L6:
            if (((Observable) this.f2904a.b()) == r10) goto L8;
            return;
        L8:
            ViewDataBinding.c(r12, this.f2904a.f2901b, r10, r11);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public /* bridge */ /* synthetic */ void addListener(Object r10) {
            b((Observable) r10);
        }

        public void b(Observable r10) {
            r10.addOnPropertyChangedCallback(this);
        }

        public void c(Observable r10) {
            r10.removeOnPropertyChangedCallback(this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public i getListener() {
            return this.f2904a;
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public /* bridge */ /* synthetic */ void removeListener(Object r10) {
            c((Observable) r10);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner r10) {
        }
    }

    static {
        f2879j = Build.VERSION.SDK_INT;
        f2880k = true;
        f2881l = new a();
        f2882m = new b();
        f2883n = new c();
        f2884o = new d();
        f2885p = new e();
        f2886q = new ReferenceQueue();
        f2887r = new f();
    }

    public static /* synthetic */ Runnable a(ViewDataBinding r10) {
        return r10.f2888a;
    }

    public static /* synthetic */ ReferenceQueue b() {
        return f2886q;
    }

    public static /* synthetic */ void c(ViewDataBinding r10, int r11, Object r12, int r13) {
        r10.e(r11, r12, r13);
    }

    public static ViewDataBinding d(View r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        return (ViewDataBinding) r10.getTag(R$id.dataBinding);
    }

    public final void e(int r10, Object r11, int r12) {
        if (this.f2896i == false) goto L6;
        return;
    L6:
        if (f(r10, r11, r12) == false) goto L9;
        g();
        return;
    }

    public abstract boolean f(int r10, Object r11, int r12);

    public void g() {
        ViewDataBinding r10 = this.f2894g;
        if (r10 == null) goto L5;
        r10.g();
        return;
    L5:
        LifecycleOwner r11 = this.f2895h;
        if (r11 != null) goto L8;
    L10:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L12:
        if (this.f2889b == false) goto L17;
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L17:
        this.f2889b = true;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        if (f2880k == false) goto L22;
        this.f2891d.postFrameCallback(this.f2892e);
        return;
    L22:
        this.f2893f.post(this.f2888a);
        return;
    L8:
        if (r11.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED) == true) goto L10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f2890c;
    }
}
