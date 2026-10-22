package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Consumer f135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kotlin.collections.i f136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnBackInvokedCallback f138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OnBackInvokedDispatcher f139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f141h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f142a = null;

        static {
            f142a = new a();
        }

        public a() {
        }

        public static /* synthetic */ void a(Function0 r10) {
            c(r10);
        }

        public static final void c(Function0 r10) {
            kotlin.jvm.internal.q.g(r10, "$onBackInvoked");
            r10.invoke();
        }

        @DoNotInline
        @NotNull
        public final OnBackInvokedCallback b(@NotNull final Function0<Unit> r10) {
            kotlin.jvm.internal.q.g(r10, "onBackInvoked");
            return new m(r10);
        }

        @DoNotInline
        public final void d(@NotNull Object r10, int r11, @NotNull Object r12) {
            kotlin.jvm.internal.q.g(r10, "dispatcher");
            kotlin.jvm.internal.q.g(r12, "callback");
            ((OnBackInvokedDispatcher) r10).registerOnBackInvokedCallback(r11, (OnBackInvokedCallback) r12);
        }

        @DoNotInline
        public final void e(@NotNull Object r10, @NotNull Object r11) {
            kotlin.jvm.internal.q.g(r10, "dispatcher");
            kotlin.jvm.internal.q.g(r11, "callback");
            ((OnBackInvokedDispatcher) r10).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r11);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f143a = null;

        public static final class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1 f144a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1 f145b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function0 f146c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function0 f147d;

            public a(Function1 r10, Function1 r11, Function0 r12, Function0 r13) {
                this.f144a = r10;
                this.f145b = r11;
                this.f146c = r12;
                this.f147d = r13;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                this.f147d.invoke();
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f146c.invoke();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(@NotNull BackEvent r10) {
                kotlin.jvm.internal.q.g(r10, "backEvent");
                this.f145b.invoke(new BackEventCompat(r10));
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(@NotNull BackEvent r10) {
                kotlin.jvm.internal.q.g(r10, "backEvent");
                this.f144a.invoke(new BackEventCompat(r10));
            }
        }

        static {
            f143a = new b();
        }

        public b() {
        }

        @DoNotInline
        @NotNull
        public final OnBackInvokedCallback a(@NotNull Function1<? super BackEventCompat, Unit> r10, @NotNull Function1<? super BackEventCompat, Unit> r11, @NotNull Function0<Unit> r12, @NotNull Function0<Unit> r13) {
            kotlin.jvm.internal.q.g(r10, "onBackStarted");
            kotlin.jvm.internal.q.g(r11, "onBackProgressed");
            kotlin.jvm.internal.q.g(r12, "onBackInvoked");
            kotlin.jvm.internal.q.g(r13, "onBackCancelled");
            return new a(r10, r11, r12, r13);
        }
    }

    public final class c implements LifecycleEventObserver, Cancellable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l f149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Cancellable f150c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f151d;

        public c(OnBackPressedDispatcher r10, Lifecycle r11, l r12) {
            kotlin.jvm.internal.q.g(r11, "lifecycle");
            kotlin.jvm.internal.q.g(r12, "onBackPressedCallback");
            this.f151d = r10;
            this.f148a = r11;
            this.f149b = r12;
            r11.a(this);
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.f148a.d(this);
            this.f149b.g(this);
            Cancellable r10 = this.f150c;
            if (r10 == null) goto L5;
            r10.cancel();
        L5:
            this.f150c = null;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            kotlin.jvm.internal.q.g(r10, "source");
            kotlin.jvm.internal.q.g(r11, "event");
            if (r11 != Lifecycle.Event.ON_START) goto L6;
            this.f150c = this.f151d.i(this.f149b);
            return;
        L6:
            if (r11 != Lifecycle.Event.ON_STOP) goto L11;
            Cancellable r12 = this.f150c;
            if (r12 == null) goto L15;
            r12.cancel();
            return;
        L15:
            return;
        L11:
            if (r11 != Lifecycle.Event.ON_DESTROY) goto L17;
            cancel();
            return;
        }
    }

    public final class d implements Cancellable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f153b;

        public d(OnBackPressedDispatcher r10, l r11) {
            kotlin.jvm.internal.q.g(r11, "onBackPressedCallback");
            this.f153b = r10;
            this.f152a = r11;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            OnBackPressedDispatcher.b(this.f153b).remove(this.f152a);
            if (kotlin.jvm.internal.q.b(OnBackPressedDispatcher.a(this.f153b), this.f152a) == false) goto L5;
            this.f152a.c();
            OnBackPressedDispatcher.f(this.f153b, null);
        L5:
            this.f152a.g(this);
            Function0 r10 = this.f152a.b();
            if (r10 == null) goto L8;
            r10.invoke();
        L8:
            this.f152a.i(null);
        }
    }

    public OnBackPressedDispatcher(Runnable r10, Consumer r11) {
        this.f134a = r10;
        this.f135b = r11;
        this.f136c = new kotlin.collections.i();
        int r12 = Build.VERSION.SDK_INT;
        if (r12 >= 33) goto L5;
        return;
    L5:
        if (r12 < 34) goto L7;
        OnBackInvokedCallback r13 = b.f143a.a(new AnonymousClass1(this), new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass4(this));
    L8:
        this.f138e = r13;
        return;
    L7:
        r13 = a.f142a.b(new AnonymousClass5(this));
        goto L8
    }

    public static final /* synthetic */ l a(OnBackPressedDispatcher r10) {
        return r10.f137d;
    }

    public static final /* synthetic */ kotlin.collections.i b(OnBackPressedDispatcher r10) {
        return r10.f136c;
    }

    public static final /* synthetic */ void c(OnBackPressedDispatcher r10) {
        r10.j();
    }

    public static final /* synthetic */ void d(OnBackPressedDispatcher r10, BackEventCompat r11) {
        r10.onBackProgressed(r11);
    }

    public static final /* synthetic */ void e(OnBackPressedDispatcher r10, BackEventCompat r11) {
        r10.onBackStarted(r11);
    }

    public static final /* synthetic */ void f(OnBackPressedDispatcher r10, l r11) {
        r10.f137d = r11;
    }

    public static final /* synthetic */ void g(OnBackPressedDispatcher r10) {
        r10.n();
    }

    @MainThread
    private final void onBackProgressed(BackEventCompat r10) {
        kotlin.collections.i r11 = this.f136c;
        ListIterator<E> r12 = r11.listIterator(r11.size());
    L4:
        if (r12.hasPrevious() == false) goto L8;
        Object r13 = r12.previous();
        if (((l) r13).e() == false) goto L4;
    L9:
        l r14 = (l) r13;
        if (r14 == null) goto L16;
        r14.handleOnBackProgressed(r10);
        return;
    L16:
        return;
    L8:
        r13 = null;
        goto L9
    }

    @MainThread
    private final void onBackStarted(BackEventCompat r10) {
        kotlin.collections.i r11 = this.f136c;
        ListIterator<E> r12 = r11.listIterator(r11.size());
    L4:
        if (r12.hasPrevious() == false) goto L8;
        Object r13 = r12.previous();
        if (((l) r13).e() == false) goto L4;
    L9:
        l r14 = (l) r13;
        this.f137d = r14;
        if (r14 == null) goto L16;
        r14.handleOnBackStarted(r10);
        return;
    L16:
        return;
    L8:
        r13 = null;
        goto L9
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackProgressed(@NotNull BackEventCompat r10) {
        kotlin.jvm.internal.q.g(r10, "backEvent");
        onBackProgressed(r10);
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackStarted(@NotNull BackEventCompat r10) {
        kotlin.jvm.internal.q.g(r10, "backEvent");
        onBackStarted(r10);
    }

    public final void h(LifecycleOwner r10, l r11) {
        kotlin.jvm.internal.q.g(r10, "owner");
        kotlin.jvm.internal.q.g(r11, "onBackPressedCallback");
        Lifecycle r12 = r10.getLifecycle();
        if (r12.b() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        r11.a(new c(this, r12, r11));
        n();
        r11.i(new OnBackPressedDispatcher$addCallback$1(this));
    }

    public final Cancellable i(l r10) {
        kotlin.jvm.internal.q.g(r10, "onBackPressedCallback");
        this.f136c.add(r10);
        d r11 = new d(this, r10);
        r10.a(r11);
        n();
        r10.i(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return r11;
    }

    public final void j() {
        kotlin.collections.i r10 = this.f136c;
        ListIterator<E> r11 = r10.listIterator(r10.size());
    L4:
        if (r11.hasPrevious() == false) goto L8;
        Object r12 = r11.previous();
        if (((l) r12).e() == false) goto L4;
    L9:
        l r13 = (l) r12;
        this.f137d = null;
        if (r13 == null) goto L16;
        r13.c();
        return;
    L16:
        return;
    L8:
        r12 = null;
        goto L9
    }

    public final void k() {
        kotlin.collections.i r10 = this.f136c;
        ListIterator<E> r11 = r10.listIterator(r10.size());
    L4:
        if (r11.hasPrevious() == false) goto L8;
        Object r12 = r11.previous();
        if (((l) r12).e() == false) goto L4;
    L9:
        l r13 = (l) r12;
        this.f137d = null;
        if (r13 == null) goto L13;
        r13.d();
        return;
    L13:
        Runnable r14 = this.f134a;
        if (r14 == null) goto L20;
        r14.run();
        return;
    L20:
        return;
    L8:
        r12 = null;
        goto L9
    }

    public final void l(OnBackInvokedDispatcher r10) {
        kotlin.jvm.internal.q.g(r10, "invoker");
        this.f139f = r10;
        m(this.f141h);
    }

    public final void m(boolean r10) {
        OnBackInvokedDispatcher r11 = this.f139f;
        OnBackInvokedCallback r12 = this.f138e;
        if (r11 == null) goto L15;
        if (r12 != null) goto L6;
        return;
    L6:
        if (r10 == true) goto L8;
    L10:
        if (r10 == false) goto L12;
        return;
    L12:
        if (this.f140g == false) goto L19;
        a.f142a.e(r11, r12);
        this.f140g = false;
        return;
    L19:
        return;
    L8:
        if (this.f140g == true) goto L10;
        a.f142a.d(r11, 0, r12);
        this.f140g = true;
        return;
    }

    public final void n() {
        boolean r10 = this.f141h;
        kotlin.collections.i r11 = this.f136c;
        boolean r12 = false;
        if (r11 != null) goto L5;
    L7:
        Iterator<E> r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L13;
        if (((l) r13.next()).e() == false) goto L9;
        r12 = true;
    L13:
        this.f141h = r12;
        if (r12 == r10) goto L25;
        Consumer r14 = this.f135b;
        if (r14 == null) goto L19;
        r14.accept(Boolean.valueOf(r12));
    L19:
        if (Build.VERSION.SDK_INT < 33) goto L26;
        m(r12);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (r11.isEmpty() == false) goto L7;
        goto L7
    }

    public OnBackPressedDispatcher(Runnable r10) {
        this(r10, null);
    }
}
