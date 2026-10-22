package androidx.activity;

import Y8.t;
import Z8.C1165m;
import android.view.InterfaceC1395m;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import b.AbstractC1417G;
import b.C1423c;
import b.InterfaceC1424d;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0004.+&(B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0015\b\u0017\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u0017\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0003¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0003¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\fH\u0003¢\u0006\u0004\b%\u0010\u001bR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00109¨\u0006="}, d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "", "Ljava/lang/Runnable;", "fallbackOnBackPressed", "LB0/a;", "", "onHasEnabledCallbacksChanged", "<init>", "(Ljava/lang/Runnable;LB0/a;)V", "(Ljava/lang/Runnable;)V", "Landroid/window/OnBackInvokedDispatcher;", "invoker", "LY8/t;", "t", "(Landroid/window/OnBackInvokedDispatcher;)V", "Lb/G;", "onBackPressedCallback", "n", "(Lb/G;)V", "Lb/d;", "o", "(Lb/G;)Lb/d;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "m", "(Landroidx/lifecycle/LifecycleOwner;Lb/G;)V", "q", "()V", "shouldBeRegistered", "u", "(Z)V", "v", "Lb/c;", "backEvent", "s", "(Lb/c;)V", "r", "p", Const.INTENT_KEY_APIKEY, "Ljava/lang/Runnable;", Const.INTENT_KEY_PKGNAME, "LB0/a;", "LZ8/m;", "c", "LZ8/m;", "onBackPressedCallbacks", Const.INTENT_KEY_UMID, "Lb/G;", "inProgressCallback", "Landroid/window/OnBackInvokedCallback;", "e", "Landroid/window/OnBackInvokedCallback;", "onBackInvokedCallback", "f", "Landroid/window/OnBackInvokedDispatcher;", "invokedDispatcher", Const.INTENT_KEY_BACKGROUND_COMMAND, "Z", "backInvokedCallbackRegistered", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "hasEnabledCallbacks", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Runnable fallbackOnBackPressed;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final B0.a<Boolean> onHasEnabledCallbacksChanged;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C1165m<AbstractC1417G> onBackPressedCallbacks;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public AbstractC1417G inProgressCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public OnBackInvokedCallback onBackInvokedCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public OnBackInvokedDispatcher invokedDispatcher;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean backInvokedCallbackRegistered;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean hasEnabledCallbacks;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$a;", "", "<init>", "()V", "dispatcher", "", "priority", "callback", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;ILjava/lang/Object;)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Ljava/lang/Object;)V", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f8198a = new a();

        public final void a(Object dispatcher, int priority, Object callback) {
            p.i(dispatcher, "dispatcher");
            p.i(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(priority, (OnBackInvokedCallback) callback);
        }

        public final void b(Object dispatcher, Object callback) {
            p.i(dispatcher, "dispatcher");
            p.i(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\r\u001a\u00020\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$b;", "", "<init>", "()V", "Lkotlin/Function1;", "Lb/c;", "LY8/t;", "onBackStarted", "onBackProgressed", "Lkotlin/Function0;", "onBackInvoked", "onBackCancelled", "Landroid/window/OnBackInvokedCallback;", Const.INTENT_KEY_APIKEY, "(Lp9/l;Lp9/l;Lp9/a;Lp9/a;)Landroid/window/OnBackInvokedCallback;", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f8199a = new b();

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"androidx/activity/OnBackPressedDispatcher$b$a", "Landroid/window/OnBackAnimationCallback;", "Landroid/window/BackEvent;", "backEvent", "LY8/t;", "onBackStarted", "(Landroid/window/BackEvent;)V", "onBackProgressed", "onBackInvoked", "()V", "onBackCancelled", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements OnBackAnimationCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InterfaceC5074l<C1423c, t> f8200a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InterfaceC5074l<C1423c, t> f8201b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ InterfaceC5063a<t> f8202c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ InterfaceC5063a<t> f8203d;

            /* JADX WARN: Multi-variable type inference failed */
            public a(InterfaceC5074l<? super C1423c, t> interfaceC5074l, InterfaceC5074l<? super C1423c, t> interfaceC5074l2, InterfaceC5063a<t> interfaceC5063a, InterfaceC5063a<t> interfaceC5063a2) {
                this.f8200a = interfaceC5074l;
                this.f8201b = interfaceC5074l2;
                this.f8202c = interfaceC5063a;
                this.f8203d = interfaceC5063a2;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                this.f8203d.invoke();
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f8202c.invoke();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                p.i(backEvent, "backEvent");
                this.f8201b.invoke(new C1423c(backEvent));
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                p.i(backEvent, "backEvent");
                this.f8200a.invoke(new C1423c(backEvent));
            }
        }

        public final OnBackInvokedCallback a(InterfaceC5074l<? super C1423c, t> onBackStarted, InterfaceC5074l<? super C1423c, t> onBackProgressed, InterfaceC5063a<t> onBackInvoked, InterfaceC5063a<t> onBackCancelled) {
            p.i(onBackStarted, "onBackStarted");
            p.i(onBackProgressed, "onBackProgressed");
            p.i(onBackInvoked, "onBackInvoked");
            p.i(onBackCancelled, "onBackCancelled");
            return new a(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$c;", "Landroidx/lifecycle/m;", "Lb/d;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lb/G;", "onBackPressedCallback", "<init>", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/Lifecycle;Lb/G;)V", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "LY8/t;", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "cancel", "()V", Const.INTENT_KEY_APIKEY, "Landroidx/lifecycle/Lifecycle;", Const.INTENT_KEY_PKGNAME, "Lb/G;", "c", "Lb/d;", "currentCancellable", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class c implements InterfaceC1395m, InterfaceC1424d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Lifecycle lifecycle;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final AbstractC1417G onBackPressedCallback;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public InterfaceC1424d currentCancellable;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f8207d;

        public c(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, AbstractC1417G onBackPressedCallback) {
            p.i(lifecycle, "lifecycle");
            p.i(onBackPressedCallback, "onBackPressedCallback");
            this.f8207d = onBackPressedDispatcher;
            this.lifecycle = lifecycle;
            this.onBackPressedCallback = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // b.InterfaceC1424d
        public void cancel() {
            this.lifecycle.d(this);
            this.onBackPressedCallback.removeCancellable(this);
            InterfaceC1424d interfaceC1424d = this.currentCancellable;
            if (interfaceC1424d != null) {
                interfaceC1424d.cancel();
            }
            this.currentCancellable = null;
        }

        @Override // android.view.InterfaceC1395m
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            p.i(source, "source");
            p.i(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.currentCancellable = this.f8207d.o(this.onBackPressedCallback);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                InterfaceC1424d interfaceC1424d = this.currentCancellable;
                if (interfaceC1424d != null) {
                    interfaceC1424d.cancel();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$d;", "Lb/d;", "Lb/G;", "onBackPressedCallback", "<init>", "(Landroidx/activity/OnBackPressedDispatcher;Lb/G;)V", "LY8/t;", "cancel", "()V", Const.INTENT_KEY_APIKEY, "Lb/G;", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class d implements InterfaceC1424d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final AbstractC1417G onBackPressedCallback;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f8209b;

        public d(OnBackPressedDispatcher onBackPressedDispatcher, AbstractC1417G onBackPressedCallback) {
            p.i(onBackPressedCallback, "onBackPressedCallback");
            this.f8209b = onBackPressedDispatcher;
            this.onBackPressedCallback = onBackPressedCallback;
        }

        @Override // b.InterfaceC1424d
        public void cancel() {
            this.f8209b.onBackPressedCallbacks.remove(this.onBackPressedCallback);
            if (p.d(this.f8209b.inProgressCallback, this.onBackPressedCallback)) {
                this.onBackPressedCallback.handleOnBackCancelled();
                this.f8209b.inProgressCallback = null;
            }
            this.onBackPressedCallback.removeCancellable(this);
            InterfaceC5063a<t> enabledChangedCallback$activity_release = this.onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final t e(OnBackPressedDispatcher onBackPressedDispatcher, C1423c backEvent) {
        p.i(backEvent, "backEvent");
        onBackPressedDispatcher.s(backEvent);
        return t.f7040a;
    }

    public static final t f(OnBackPressedDispatcher onBackPressedDispatcher, C1423c backEvent) {
        p.i(backEvent, "backEvent");
        onBackPressedDispatcher.r(backEvent);
        return t.f7040a;
    }

    public static final t g(OnBackPressedDispatcher onBackPressedDispatcher) {
        onBackPressedDispatcher.q();
        return t.f7040a;
    }

    public static final t h(OnBackPressedDispatcher onBackPressedDispatcher) {
        onBackPressedDispatcher.p();
        return t.f7040a;
    }

    public final void m(LifecycleOwner owner, AbstractC1417G onBackPressedCallback) {
        p.i(owner, "owner");
        p.i(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new c(this, lifecycle, onBackPressedCallback));
        v();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCallback$1(this));
    }

    public final void n(AbstractC1417G onBackPressedCallback) {
        p.i(onBackPressedCallback, "onBackPressedCallback");
        o(onBackPressedCallback);
    }

    public final InterfaceC1424d o(AbstractC1417G onBackPressedCallback) {
        p.i(onBackPressedCallback, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(onBackPressedCallback);
        d dVar = new d(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(dVar);
        v();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return dVar;
    }

    public final void p() {
        AbstractC1417G abstractC1417GPrevious;
        AbstractC1417G abstractC1417G = this.inProgressCallback;
        if (abstractC1417G == null) {
            C1165m<AbstractC1417G> c1165m = this.onBackPressedCallbacks;
            ListIterator<AbstractC1417G> listIterator = c1165m.listIterator(c1165m.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    abstractC1417GPrevious = null;
                    break;
                } else {
                    abstractC1417GPrevious = listIterator.previous();
                    if (abstractC1417GPrevious.getIsEnabled()) {
                        break;
                    }
                }
            }
            abstractC1417G = abstractC1417GPrevious;
        }
        this.inProgressCallback = null;
        if (abstractC1417G != null) {
            abstractC1417G.handleOnBackCancelled();
        }
    }

    public final void q() {
        AbstractC1417G abstractC1417GPrevious;
        AbstractC1417G abstractC1417G = this.inProgressCallback;
        if (abstractC1417G == null) {
            C1165m<AbstractC1417G> c1165m = this.onBackPressedCallbacks;
            ListIterator<AbstractC1417G> listIterator = c1165m.listIterator(c1165m.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    abstractC1417GPrevious = null;
                    break;
                } else {
                    abstractC1417GPrevious = listIterator.previous();
                    if (abstractC1417GPrevious.getIsEnabled()) {
                        break;
                    }
                }
            }
            abstractC1417G = abstractC1417GPrevious;
        }
        this.inProgressCallback = null;
        if (abstractC1417G != null) {
            abstractC1417G.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.fallbackOnBackPressed;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void r(C1423c backEvent) {
        AbstractC1417G abstractC1417GPrevious;
        AbstractC1417G abstractC1417G = this.inProgressCallback;
        if (abstractC1417G == null) {
            C1165m<AbstractC1417G> c1165m = this.onBackPressedCallbacks;
            ListIterator<AbstractC1417G> listIterator = c1165m.listIterator(c1165m.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    abstractC1417GPrevious = null;
                    break;
                } else {
                    abstractC1417GPrevious = listIterator.previous();
                    if (abstractC1417GPrevious.getIsEnabled()) {
                        break;
                    }
                }
            }
            abstractC1417G = abstractC1417GPrevious;
        }
        if (abstractC1417G != null) {
            abstractC1417G.handleOnBackProgressed(backEvent);
        }
    }

    public final void s(C1423c backEvent) {
        AbstractC1417G abstractC1417GPrevious;
        C1165m<AbstractC1417G> c1165m = this.onBackPressedCallbacks;
        ListIterator<AbstractC1417G> listIterator = c1165m.listIterator(c1165m.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                abstractC1417GPrevious = null;
                break;
            } else {
                abstractC1417GPrevious = listIterator.previous();
                if (abstractC1417GPrevious.getIsEnabled()) {
                    break;
                }
            }
        }
        AbstractC1417G abstractC1417G = abstractC1417GPrevious;
        if (this.inProgressCallback != null) {
            p();
        }
        this.inProgressCallback = abstractC1417G;
        if (abstractC1417G != null) {
            abstractC1417G.handleOnBackStarted(backEvent);
        }
    }

    public final void t(OnBackInvokedDispatcher invoker) {
        p.i(invoker, "invoker");
        this.invokedDispatcher = invoker;
        u(this.hasEnabledCallbacks);
    }

    public final void u(boolean shouldBeRegistered) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.invokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback = this.onBackInvokedCallback;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (shouldBeRegistered && !this.backInvokedCallbackRegistered) {
            a.f8198a.a(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.backInvokedCallbackRegistered = true;
        } else {
            if (shouldBeRegistered || !this.backInvokedCallbackRegistered) {
                return;
            }
            a.f8198a.b(onBackInvokedDispatcher, onBackInvokedCallback);
            this.backInvokedCallbackRegistered = false;
        }
    }

    public final void v() {
        boolean z10 = this.hasEnabledCallbacks;
        C1165m<AbstractC1417G> c1165m = this.onBackPressedCallbacks;
        boolean z11 = false;
        if (c1165m == null || !c1165m.isEmpty()) {
            Iterator<AbstractC1417G> it = c1165m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getIsEnabled()) {
                    z11 = true;
                    break;
                }
            }
        }
        this.hasEnabledCallbacks = z11;
        if (z11 != z10) {
            B0.a<Boolean> aVar = this.onHasEnabledCallbacksChanged;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z11));
            }
            u(z11);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable, B0.a<Boolean> aVar) {
        this.fallbackOnBackPressed = runnable;
        this.onHasEnabledCallbacksChanged = aVar;
        this.onBackPressedCallbacks = new C1165m<>();
        this.onBackInvokedCallback = b.f8199a.a(new InterfaceC5074l() { // from class: b.H
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return OnBackPressedDispatcher.e(this.f15174a, (C1423c) obj);
            }
        }, new InterfaceC5074l() { // from class: b.I
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return OnBackPressedDispatcher.f(this.f15175a, (C1423c) obj);
            }
        }, new InterfaceC5063a() { // from class: b.J
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OnBackPressedDispatcher.g(this.f15176a);
            }
        }, new InterfaceC5063a() { // from class: b.K
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return OnBackPressedDispatcher.h(this.f15177a);
            }
        });
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }
}
