package androidx.activity;

import V3.v;
import W3.C0395f;
import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.p;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.InterfaceC0537q;
import androidx.lifecycle.InterfaceC0539t;
import i4.InterfaceC0761a;
import i4.InterfaceC0772l;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f7387a;

    /* renamed from: b, reason: collision with root package name */
    private final D.a<Boolean> f7388b;

    /* renamed from: c, reason: collision with root package name */
    private final C0395f<o> f7389c;

    /* renamed from: d, reason: collision with root package name */
    private o f7390d;

    /* renamed from: e, reason: collision with root package name */
    private OnBackInvokedCallback f7391e;

    /* renamed from: f, reason: collision with root package name */
    private OnBackInvokedDispatcher f7392f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7393g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7394h;

    static final class a extends j4.l implements InterfaceC0772l<androidx.activity.b, v> {
        a() {
            super(1);
        }

        public final void b(androidx.activity.b bVar) {
            j4.k.g(bVar, "backEvent");
            p.this.m(bVar);
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ v invoke(androidx.activity.b bVar) {
            b(bVar);
            return v.f5542a;
        }
    }

    static final class b extends j4.l implements InterfaceC0772l<androidx.activity.b, v> {
        b() {
            super(1);
        }

        public final void b(androidx.activity.b bVar) {
            j4.k.g(bVar, "backEvent");
            p.this.l(bVar);
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ v invoke(androidx.activity.b bVar) {
            b(bVar);
            return v.f5542a;
        }
    }

    static final class c extends j4.l implements InterfaceC0761a<v> {
        c() {
            super(0);
        }

        @Override // i4.InterfaceC0761a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.f5542a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            p.this.k();
        }
    }

    static final class d extends j4.l implements InterfaceC0761a<v> {
        d() {
            super(0);
        }

        @Override // i4.InterfaceC0761a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.f5542a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            p.this.j();
        }
    }

    static final class e extends j4.l implements InterfaceC0761a<v> {
        e() {
            super(0);
        }

        @Override // i4.InterfaceC0761a
        public /* bridge */ /* synthetic */ v invoke() {
            invoke2();
            return v.f5542a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            p.this.k();
        }
    }

    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public static final f f7400a = new f();

        private f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(InterfaceC0761a interfaceC0761a) {
            j4.k.g(interfaceC0761a, "$onBackInvoked");
            interfaceC0761a.invoke();
        }

        public final OnBackInvokedCallback b(final InterfaceC0761a<v> interfaceC0761a) {
            j4.k.g(interfaceC0761a, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.q
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    p.f.c(interfaceC0761a);
                }
            };
        }

        public final void d(Object obj, int i5, Object obj2) {
            j4.k.g(obj, "dispatcher");
            j4.k.g(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i5, (OnBackInvokedCallback) obj2);
        }

        public final void e(Object obj, Object obj2) {
            j4.k.g(obj, "dispatcher");
            j4.k.g(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public static final g f7401a = new g();

        public static final class a implements OnBackAnimationCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ InterfaceC0772l<androidx.activity.b, v> f7402a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC0772l<androidx.activity.b, v> f7403b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ InterfaceC0761a<v> f7404c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ InterfaceC0761a<v> f7405d;

            /* JADX WARN: Multi-variable type inference failed */
            a(InterfaceC0772l<? super androidx.activity.b, v> interfaceC0772l, InterfaceC0772l<? super androidx.activity.b, v> interfaceC0772l2, InterfaceC0761a<v> interfaceC0761a, InterfaceC0761a<v> interfaceC0761a2) {
                this.f7402a = interfaceC0772l;
                this.f7403b = interfaceC0772l2;
                this.f7404c = interfaceC0761a;
                this.f7405d = interfaceC0761a2;
            }

            public void onBackCancelled() {
                this.f7405d.invoke();
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f7404c.invoke();
            }

            public void onBackProgressed(BackEvent backEvent) {
                j4.k.g(backEvent, "backEvent");
                this.f7403b.invoke(new androidx.activity.b(backEvent));
            }

            public void onBackStarted(BackEvent backEvent) {
                j4.k.g(backEvent, "backEvent");
                this.f7402a.invoke(new androidx.activity.b(backEvent));
            }
        }

        private g() {
        }

        public final OnBackInvokedCallback a(InterfaceC0772l<? super androidx.activity.b, v> interfaceC0772l, InterfaceC0772l<? super androidx.activity.b, v> interfaceC0772l2, InterfaceC0761a<v> interfaceC0761a, InterfaceC0761a<v> interfaceC0761a2) {
            j4.k.g(interfaceC0772l, "onBackStarted");
            j4.k.g(interfaceC0772l2, "onBackProgressed");
            j4.k.g(interfaceC0761a, "onBackInvoked");
            j4.k.g(interfaceC0761a2, "onBackCancelled");
            return new a(interfaceC0772l, interfaceC0772l2, interfaceC0761a, interfaceC0761a2);
        }
    }

    private final class h implements InterfaceC0537q, androidx.activity.c {

        /* renamed from: a, reason: collision with root package name */
        private final AbstractC0533m f7406a;

        /* renamed from: b, reason: collision with root package name */
        private final o f7407b;

        /* renamed from: c, reason: collision with root package name */
        private androidx.activity.c f7408c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ p f7409d;

        public h(p pVar, AbstractC0533m abstractC0533m, o oVar) {
            j4.k.g(abstractC0533m, "lifecycle");
            j4.k.g(oVar, "onBackPressedCallback");
            this.f7409d = pVar;
            this.f7406a = abstractC0533m;
            this.f7407b = oVar;
            abstractC0533m.a(this);
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f7406a.d(this);
            this.f7407b.i(this);
            androidx.activity.c cVar = this.f7408c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f7408c = null;
        }

        @Override // androidx.lifecycle.InterfaceC0537q
        public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
            j4.k.g(interfaceC0539t, "source");
            j4.k.g(aVar, "event");
            if (aVar == AbstractC0533m.a.ON_START) {
                this.f7408c = this.f7409d.i(this.f7407b);
                return;
            }
            if (aVar != AbstractC0533m.a.ON_STOP) {
                if (aVar == AbstractC0533m.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.f7408c;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }
    }

    private final class i implements androidx.activity.c {

        /* renamed from: a, reason: collision with root package name */
        private final o f7410a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f7411b;

        public i(p pVar, o oVar) {
            j4.k.g(oVar, "onBackPressedCallback");
            this.f7411b = pVar;
            this.f7410a = oVar;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f7411b.f7389c.remove(this.f7410a);
            if (j4.k.b(this.f7411b.f7390d, this.f7410a)) {
                this.f7410a.c();
                this.f7411b.f7390d = null;
            }
            this.f7410a.i(this);
            InterfaceC0761a<v> interfaceC0761aB = this.f7410a.b();
            if (interfaceC0761aB != null) {
                interfaceC0761aB.invoke();
            }
            this.f7410a.k(null);
        }
    }

    /* synthetic */ class j extends j4.j implements InterfaceC0761a<v> {
        j(Object obj) {
            super(0, obj, p.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // i4.InterfaceC0761a
        public /* bridge */ /* synthetic */ v invoke() {
            j();
            return v.f5542a;
        }

        public final void j() {
            ((p) this.f17818b).p();
        }
    }

    /* synthetic */ class k extends j4.j implements InterfaceC0761a<v> {
        k(Object obj) {
            super(0, obj, p.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // i4.InterfaceC0761a
        public /* bridge */ /* synthetic */ v invoke() {
            j();
            return v.f5542a;
        }

        public final void j() {
            ((p) this.f17818b).p();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        o oVarPrevious;
        C0395f<o> c0395f = this.f7389c;
        ListIterator<o> listIterator = c0395f.listIterator(c0395f.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                oVarPrevious = null;
                break;
            } else {
                oVarPrevious = listIterator.previous();
                if (oVarPrevious.g()) {
                    break;
                }
            }
        }
        o oVar = oVarPrevious;
        this.f7390d = null;
        if (oVar != null) {
            oVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(androidx.activity.b bVar) {
        o oVarPrevious;
        C0395f<o> c0395f = this.f7389c;
        ListIterator<o> listIterator = c0395f.listIterator(c0395f.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                oVarPrevious = null;
                break;
            } else {
                oVarPrevious = listIterator.previous();
                if (oVarPrevious.g()) {
                    break;
                }
            }
        }
        o oVar = oVarPrevious;
        if (oVar != null) {
            oVar.e(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(androidx.activity.b bVar) {
        o oVarPrevious;
        C0395f<o> c0395f = this.f7389c;
        ListIterator<o> listIterator = c0395f.listIterator(c0395f.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                oVarPrevious = null;
                break;
            } else {
                oVarPrevious = listIterator.previous();
                if (oVarPrevious.g()) {
                    break;
                }
            }
        }
        o oVar = oVarPrevious;
        this.f7390d = oVar;
        if (oVar != null) {
            oVar.f(bVar);
        }
    }

    private final void o(boolean z5) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f7392f;
        OnBackInvokedCallback onBackInvokedCallback = this.f7391e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z5 && !this.f7393g) {
            f.f7400a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f7393g = true;
        } else {
            if (z5 || !this.f7393g) {
                return;
            }
            f.f7400a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f7393g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        boolean z5 = this.f7394h;
        C0395f<o> c0395f = this.f7389c;
        boolean z6 = false;
        if (c0395f == null || !c0395f.isEmpty()) {
            Iterator<o> it = c0395f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().g()) {
                    z6 = true;
                    break;
                }
            }
        }
        this.f7394h = z6;
        if (z6 != z5) {
            D.a<Boolean> aVar = this.f7388b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z6));
            }
            o(z6);
        }
    }

    public final void h(InterfaceC0539t interfaceC0539t, o oVar) {
        j4.k.g(interfaceC0539t, "owner");
        j4.k.g(oVar, "onBackPressedCallback");
        AbstractC0533m lifecycle = interfaceC0539t.getLifecycle();
        if (lifecycle.b() == AbstractC0533m.b.DESTROYED) {
            return;
        }
        oVar.a(new h(this, lifecycle, oVar));
        p();
        oVar.k(new j(this));
    }

    public final androidx.activity.c i(o oVar) {
        j4.k.g(oVar, "onBackPressedCallback");
        this.f7389c.add(oVar);
        i iVar = new i(this, oVar);
        oVar.a(iVar);
        p();
        oVar.k(new k(this));
        return iVar;
    }

    public final void k() {
        o oVarPrevious;
        C0395f<o> c0395f = this.f7389c;
        ListIterator<o> listIterator = c0395f.listIterator(c0395f.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                oVarPrevious = null;
                break;
            } else {
                oVarPrevious = listIterator.previous();
                if (oVarPrevious.g()) {
                    break;
                }
            }
        }
        o oVar = oVarPrevious;
        this.f7390d = null;
        if (oVar != null) {
            oVar.d();
            return;
        }
        Runnable runnable = this.f7387a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void n(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        j4.k.g(onBackInvokedDispatcher, "invoker");
        this.f7392f = onBackInvokedDispatcher;
        o(this.f7394h);
    }

    public p(Runnable runnable, D.a<Boolean> aVar) {
        this.f7387a = runnable;
        this.f7388b = aVar;
        this.f7389c = new C0395f<>();
        this.f7391e = Build.VERSION.SDK_INT >= 34 ? g.f7401a.a(new a(), new b(), new c(), new d()) : f.f7400a.b(new e());
    }

    public /* synthetic */ p(Runnable runnable, int i5, j4.g gVar) {
        this((i5 & 1) != 0 ? null : runnable);
    }

    public p(Runnable runnable) {
        this(runnable, null);
    }
}
