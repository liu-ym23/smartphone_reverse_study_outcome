package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.compose.runtime.i;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j0;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import b.p;
import b.r;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.jvm.internal.g;
import mb.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f200a;

    /* renamed from: b, reason: collision with root package name */
    public final k<p> f201b;

    /* renamed from: c, reason: collision with root package name */
    public p f202c;

    /* renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f203d;

    /* renamed from: e, reason: collision with root package name */
    public OnBackInvokedDispatcher f204e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f205f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f206g;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class a implements o, b.b {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f207a;

        /* renamed from: b, reason: collision with root package name */
        public final p f208b;

        /* renamed from: c, reason: collision with root package name */
        public b f209c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f210d;

        public a(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, p onBackPressedCallback) {
            g.f(onBackPressedCallback, "onBackPressedCallback");
            this.f210d = onBackPressedDispatcher;
            this.f207a = lifecycle;
            this.f208b = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.o
        public final void a(q qVar, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                p onBackPressedCallback = this.f208b;
                g.f(onBackPressedCallback, "onBackPressedCallback");
                OnBackPressedDispatcher onBackPressedDispatcher = this.f210d;
                onBackPressedDispatcher.f201b.addLast(onBackPressedCallback);
                b bVar = new b(onBackPressedDispatcher, onBackPressedCallback);
                onBackPressedCallback.f3027b.add(bVar);
                onBackPressedDispatcher.e();
                onBackPressedCallback.f3028c = new OnBackPressedDispatcher$addCancellableCallback$1(0, onBackPressedDispatcher, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
                this.f209c = bVar;
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                b bVar2 = this.f209c;
                if (bVar2 != null) {
                    bVar2.cancel();
                }
            }
        }

        @Override // b.b
        public final void cancel() {
            this.f207a.c(this);
            this.f208b.f3027b.remove(this);
            b bVar = this.f209c;
            if (bVar != null) {
                bVar.cancel();
            }
            this.f209c = null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class b implements b.b {

        /* renamed from: a, reason: collision with root package name */
        public final p f211a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f212b;

        public b(OnBackPressedDispatcher onBackPressedDispatcher, p onBackPressedCallback) {
            g.f(onBackPressedCallback, "onBackPressedCallback");
            this.f212b = onBackPressedDispatcher;
            this.f211a = onBackPressedCallback;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.jvm.internal.FunctionReferenceImpl, zb.a] */
        @Override // b.b
        public final void cancel() {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f212b;
            k<p> kVar = onBackPressedDispatcher.f201b;
            p pVar = this.f211a;
            kVar.remove(pVar);
            if (g.b(onBackPressedDispatcher.f202c, pVar)) {
                pVar.getClass();
                onBackPressedDispatcher.f202c = null;
            }
            pVar.f3027b.remove(this);
            ?? r42 = pVar.f3028c;
            if (r42 != 0) {
                r42.invoke();
            }
            pVar.f3028c = null;
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f200a = runnable;
        this.f201b = new k<>();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            this.f203d = i10 >= 34 ? new r(new i(this, 2), new androidx.compose.runtime.g(this, 3), new b.q(this, 0), new j0(this, 1)) : new androidx.appcompat.app.p(new b.q(this, 1), 2);
        }
    }

    public final void a(q owner, p onBackPressedCallback) {
        g.f(owner, "owner");
        g.f(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.f2214a) {
            return;
        }
        onBackPressedCallback.f3027b.add(new a(this, lifecycle, onBackPressedCallback));
        e();
        onBackPressedCallback.f3028c = new OnBackPressedDispatcher$addCallback$1(0, this, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    public final void b() {
        p pVarPrevious;
        if (this.f202c == null) {
            k<p> kVar = this.f201b;
            ListIterator<p> listIterator = kVar.listIterator(kVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    pVarPrevious = null;
                    break;
                } else {
                    pVarPrevious = listIterator.previous();
                    if (pVarPrevious.f3026a) {
                        break;
                    }
                }
            }
        }
        this.f202c = null;
    }

    public final void c() {
        p pVarPrevious;
        p pVar = this.f202c;
        if (pVar == null) {
            k<p> kVar = this.f201b;
            ListIterator<p> listIterator = kVar.listIterator(kVar.a());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    pVarPrevious = null;
                    break;
                } else {
                    pVarPrevious = listIterator.previous();
                    if (pVarPrevious.f3026a) {
                        break;
                    }
                }
            }
            pVar = pVarPrevious;
        }
        this.f202c = null;
        if (pVar != null) {
            pVar.d();
            return;
        }
        Runnable runnable = this.f200a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void d(boolean z) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f204e;
        if (onBackInvokedDispatcher == null || (onBackInvokedCallback = this.f203d) == null) {
            return;
        }
        if (z && !this.f205f) {
            onBackInvokedDispatcher.registerOnBackInvokedCallback(0, onBackInvokedCallback);
            this.f205f = true;
        } else {
            if (z || !this.f205f) {
                return;
            }
            onBackInvokedDispatcher.unregisterOnBackInvokedCallback(onBackInvokedCallback);
            this.f205f = false;
        }
    }

    public final void e() {
        boolean z = this.f206g;
        boolean z3 = false;
        k<p> kVar = this.f201b;
        if (kVar == null || !kVar.isEmpty()) {
            Iterator<p> it = kVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f3026a) {
                    z3 = true;
                    break;
                }
            }
        }
        this.f206g = z3;
        if (z3 == z || Build.VERSION.SDK_INT < 33) {
            return;
        }
        d(z3);
    }

    public OnBackPressedDispatcher() {
        this(null);
    }
}
