package android.view;

import C7.r;
import D7.p;
import S7.a;
import android.os.Build;
import android.view.Lifecycle;
import android.view.LifecycleEventObserver;
import android.view.LifecycleOwner;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Consumer;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u00049:;<B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0015\b\u0017\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u001c\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b'\u0010\u0013J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b(\u0010\u0013J\u000f\u0010)\u001a\u00020\u000bH\u0007¢\u0006\u0004\b)\u0010\u000fJ\u000f\u0010*\u001a\u00020\u000bH\u0007¢\u0006\u0004\b*\u0010\u000fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010+R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010,R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u00108¨\u0006="}, d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "", "Ljava/lang/Runnable;", "fallbackOnBackPressed", "Landroidx/core/util/Consumer;", "", "onHasEnabledCallbacksChanged", AppAgent.CONSTRUCT, "(Ljava/lang/Runnable;Landroidx/core/util/Consumer;)V", "(Ljava/lang/Runnable;)V", "shouldBeRegistered", "LC7/r;", "updateBackInvokedCallbackState", "(Z)V", "updateEnabledCallbacks", "()V", "Landroidx/activity/BackEventCompat;", "backEvent", "onBackStarted", "(Landroidx/activity/BackEventCompat;)V", "onBackProgressed", "onBackCancelled", "Landroid/window/OnBackInvokedDispatcher;", "invoker", "setOnBackInvokedDispatcher", "(Landroid/window/OnBackInvokedDispatcher;)V", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "addCallback", "(Landroidx/activity/OnBackPressedCallback;)V", "Landroidx/activity/Cancellable;", "addCancellableCallback$activity_release", "(Landroidx/activity/OnBackPressedCallback;)Landroidx/activity/Cancellable;", "addCancellableCallback", "Landroidx/lifecycle/LifecycleOwner;", "owner", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/activity/OnBackPressedCallback;)V", "hasEnabledCallbacks", "()Z", "dispatchOnBackStarted", "dispatchOnBackProgressed", "onBackPressed", "dispatchOnBackCancelled", "Ljava/lang/Runnable;", "Landroidx/core/util/Consumer;", "LD7/p;", "onBackPressedCallbacks", "LD7/p;", "inProgressCallback", "Landroidx/activity/OnBackPressedCallback;", "Landroid/window/OnBackInvokedCallback;", "onBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "invokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "backInvokedCallbackRegistered", "Z", "OnBackPressedCancellable", "LifecycleOnBackPressedCancellable", "Api33Impl", "Api34Impl", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    private OnBackPressedCallback inProgressCallback;
    private OnBackInvokedDispatcher invokedDispatcher;
    private OnBackInvokedCallback onBackInvokedCallback;
    private final p onBackPressedCallbacks;
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    @RequiresApi(33)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api33Impl;", "", AppAgent.CONSTRUCT, "()V", "dispatcher", "", "priority", "callback", "LC7/r;", "registerOnBackInvokedCallback", "(Ljava/lang/Object;ILjava/lang/Object;)V", "unregisterOnBackInvokedCallback", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/Function0;", "onBackInvoked", "Landroid/window/OnBackInvokedCallback;", "createOnBackInvokedCallback", "(LS7/a;)Landroid/window/OnBackInvokedCallback;", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        public final OnBackInvokedCallback createOnBackInvokedCallback(final a onBackInvoked) {
            k.f(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.l
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    onBackInvoked.invoke();
                }
            };
        }

        public final void registerOnBackInvokedCallback(Object dispatcher, int priority, Object callback) {
            k.f(dispatcher, "dispatcher");
            k.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(priority, (OnBackInvokedCallback) callback);
        }

        public final void unregisterOnBackInvokedCallback(Object dispatcher, Object callback) {
            k.f(dispatcher, "dispatcher");
            k.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    @RequiresApi(34)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\r\u001a\u00020\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api34Impl;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function1;", "Landroidx/activity/BackEventCompat;", "LC7/r;", "onBackStarted", "onBackProgressed", "Lkotlin/Function0;", "onBackInvoked", "onBackCancelled", "Landroid/window/OnBackInvokedCallback;", "createOnBackAnimationCallback", "(LS7/k;LS7/k;LS7/a;LS7/a;)Landroid/window/OnBackInvokedCallback;", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        public final OnBackInvokedCallback createOnBackAnimationCallback(final S7.k onBackStarted, final S7.k onBackProgressed, final a onBackInvoked, final a onBackCancelled) {
            k.f(onBackStarted, "onBackStarted");
            k.f(onBackProgressed, "onBackProgressed");
            k.f(onBackInvoked, "onBackInvoked");
            k.f(onBackCancelled, "onBackCancelled");
            return new OnBackAnimationCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1
                public void onBackCancelled() {
                    onBackCancelled.invoke();
                }

                @Override // android.window.OnBackInvokedCallback
                public void onBackInvoked() {
                    onBackInvoked.invoke();
                }

                public void onBackProgressed(BackEvent backEvent) {
                    k.f(backEvent, "backEvent");
                    onBackProgressed.invoke(new BackEventCompat(backEvent));
                }

                public void onBackStarted(BackEvent backEvent) {
                    k.f(backEvent, "backEvent");
                    onBackStarted.invoke(new BackEventCompat(backEvent));
                }
            };
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/activity/Cancellable;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", AppAgent.CONSTRUCT, "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/Lifecycle;Landroidx/activity/OnBackPressedCallback;)V", "Landroidx/lifecycle/LifecycleOwner;", AgentBusWakeContract.EXTRA_SOURCE, "Landroidx/lifecycle/Lifecycle$Event;", NotificationCompat.CATEGORY_EVENT, "LC7/r;", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "cancel", "()V", "Landroidx/lifecycle/Lifecycle;", "Landroidx/activity/OnBackPressedCallback;", "currentCancellable", "Landroidx/activity/Cancellable;", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        private Cancellable currentCancellable;
        private final Lifecycle lifecycle;
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            k.f(lifecycle, "lifecycle");
            k.f(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.lifecycle = lifecycle;
            this.onBackPressedCallback = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // android.view.Cancellable
        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            Cancellable cancellable = this.currentCancellable;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.currentCancellable = null;
        }

        @Override // android.view.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            k.f(source, "source");
            k.f(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                Cancellable cancellable = this.currentCancellable;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\t¨\u0006\n"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$OnBackPressedCancellable;", "Landroidx/activity/Cancellable;", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", AppAgent.CONSTRUCT, "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/activity/OnBackPressedCallback;)V", "LC7/r;", "cancel", "()V", "Landroidx/activity/OnBackPressedCallback;", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
            k.f(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.onBackPressedCallback = onBackPressedCallback;
        }

        @Override // android.view.Cancellable
        public void cancel() {
            this.this$0.onBackPressedCallbacks.remove(this.onBackPressedCallback);
            if (k.b(this.this$0.inProgressCallback, this.onBackPressedCallback)) {
                this.onBackPressedCallback.handleOnBackCancelled();
                this.this$0.inProgressCallback = null;
            }
            this.onBackPressedCallback.removeCancellable(this);
            a enabledChangedCallback = this.onBackPressedCallback.getEnabledChangedCallback();
            if (enabledChangedCallback != null) {
                enabledChangedCallback.invoke();
            }
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release(null);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.activity.OnBackPressedDispatcher$addCallback$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements a {
        public AnonymousClass1(Object obj) {
            super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // S7.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m3invoke();
            return r.f317a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m3invoke() {
            ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r _init_$lambda$1(OnBackPressedDispatcher onBackPressedDispatcher, BackEventCompat backEvent) {
        k.f(backEvent, "backEvent");
        onBackPressedDispatcher.onBackStarted(backEvent);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r _init_$lambda$2(OnBackPressedDispatcher onBackPressedDispatcher, BackEventCompat backEvent) {
        k.f(backEvent, "backEvent");
        onBackPressedDispatcher.onBackProgressed(backEvent);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r _init_$lambda$3(OnBackPressedDispatcher onBackPressedDispatcher) {
        onBackPressedDispatcher.onBackPressed();
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r _init_$lambda$4(OnBackPressedDispatcher onBackPressedDispatcher) {
        onBackPressedDispatcher.onBackCancelled();
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r _init_$lambda$5(OnBackPressedDispatcher onBackPressedDispatcher) {
        onBackPressedDispatcher.onBackPressed();
        return r.f317a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    @MainThread
    private final void onBackCancelled() {
        OnBackPressedCallback onBackPressedCallbackPrevious;
        OnBackPressedCallback onBackPressedCallback = this.inProgressCallback;
        if (onBackPressedCallback == null) {
            p pVar = this.onBackPressedCallbacks;
            ListIterator listIterator = pVar.listIterator(pVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallbackPrevious = 0;
                    break;
                } else {
                    onBackPressedCallbackPrevious = listIterator.previous();
                    if (((OnBackPressedCallback) onBackPressedCallbackPrevious).getIsEnabled()) {
                        break;
                    }
                }
            }
            onBackPressedCallback = onBackPressedCallbackPrevious;
        }
        this.inProgressCallback = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackCancelled();
        }
    }

    @MainThread
    private final void onBackProgressed(BackEventCompat backEvent) {
        Object objPrevious;
        OnBackPressedCallback onBackPressedCallback = this.inProgressCallback;
        if (onBackPressedCallback == null) {
            p pVar = this.onBackPressedCallbacks;
            ListIterator<E> listIterator = pVar.listIterator(pVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((OnBackPressedCallback) objPrevious).getIsEnabled()) {
                        break;
                    }
                }
            }
            onBackPressedCallback = (OnBackPressedCallback) objPrevious;
        }
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackProgressed(backEvent);
        }
    }

    @MainThread
    private final void onBackStarted(BackEventCompat backEvent) {
        Object objPrevious;
        p pVar = this.onBackPressedCallbacks;
        ListIterator<E> listIterator = pVar.listIterator(pVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((OnBackPressedCallback) objPrevious).getIsEnabled()) {
                    break;
                }
            }
        }
        OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback) objPrevious;
        if (this.inProgressCallback != null) {
            onBackCancelled();
        }
        this.inProgressCallback = onBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackStarted(backEvent);
        }
    }

    @RequiresApi(33)
    private final void updateBackInvokedCallbackState(boolean shouldBeRegistered) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.invokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback = this.onBackInvokedCallback;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (shouldBeRegistered && !this.backInvokedCallbackRegistered) {
            Api33Impl.INSTANCE.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.backInvokedCallbackRegistered = true;
        } else {
            if (shouldBeRegistered || !this.backInvokedCallbackRegistered) {
                return;
            }
            Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
            this.backInvokedCallbackRegistered = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEnabledCallbacks() {
        boolean z10 = this.hasEnabledCallbacks;
        p pVar = this.onBackPressedCallbacks;
        boolean z11 = false;
        if (pVar == null || !pVar.isEmpty()) {
            Iterator it = pVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((OnBackPressedCallback) it.next()).getIsEnabled()) {
                    z11 = true;
                    break;
                }
            }
        }
        this.hasEnabledCallbacks = z11;
        if (z11 != z10) {
            Consumer<Boolean> consumer = this.onHasEnabledCallbacksChanged;
            if (consumer != null) {
                consumer.accept(Boolean.valueOf(z11));
            }
            updateBackInvokedCallbackState(z11);
        }
    }

    @MainThread
    public final void addCallback(OnBackPressedCallback onBackPressedCallback) {
        k.f(onBackPressedCallback, "onBackPressedCallback");
        addCancellableCallback$activity_release(onBackPressedCallback);
    }

    @MainThread
    public final Cancellable addCancellableCallback$activity_release(OnBackPressedCallback onBackPressedCallback) {
        k.f(onBackPressedCallback, "onBackPressedCallback");
        this.onBackPressedCallbacks.addLast(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return onBackPressedCancellable;
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackCancelled() {
        onBackCancelled();
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackProgressed(BackEventCompat backEvent) {
        k.f(backEvent, "backEvent");
        onBackProgressed(backEvent);
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackStarted(BackEventCompat backEvent) {
        k.f(backEvent, "backEvent");
        onBackStarted(backEvent);
    }

    @MainThread
    /* renamed from: hasEnabledCallbacks, reason: from getter */
    public final boolean getHasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    @MainThread
    public final void onBackPressed() {
        OnBackPressedCallback onBackPressedCallbackPrevious;
        OnBackPressedCallback onBackPressedCallback = this.inProgressCallback;
        if (onBackPressedCallback == null) {
            p pVar = this.onBackPressedCallbacks;
            ListIterator listIterator = pVar.listIterator(pVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallbackPrevious = 0;
                    break;
                } else {
                    onBackPressedCallbackPrevious = listIterator.previous();
                    if (((OnBackPressedCallback) onBackPressedCallbackPrevious).getIsEnabled()) {
                        break;
                    }
                }
            }
            onBackPressedCallback = onBackPressedCallbackPrevious;
        }
        this.inProgressCallback = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.fallbackOnBackPressed;
        if (runnable != null) {
            runnable.run();
        }
    }

    @RequiresApi(33)
    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher invoker) {
        k.f(invoker, "invoker");
        this.invokedDispatcher = invoker;
        updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }

    public OnBackPressedDispatcher(Runnable runnable, Consumer<Boolean> consumer) {
        OnBackInvokedCallback onBackInvokedCallbackCreateOnBackInvokedCallback;
        this.fallbackOnBackPressed = runnable;
        this.onHasEnabledCallbacksChanged = consumer;
        this.onBackPressedCallbacks = new p();
        if (Build.VERSION.SDK_INT >= 34) {
            final int i = 0;
            final int i6 = 1;
            final int i10 = 0;
            final int i11 = 1;
            onBackInvokedCallbackCreateOnBackInvokedCallback = Api34Impl.INSTANCE.createOnBackAnimationCallback(new S7.k(this) { // from class: androidx.activity.j
                public final /* synthetic */ OnBackPressedDispatcher b;

                {
                    this.b = this;
                }

                @Override // S7.k
                public final Object invoke(Object obj) {
                    int i12 = i;
                    OnBackPressedDispatcher onBackPressedDispatcher = this.b;
                    BackEventCompat backEventCompat = (BackEventCompat) obj;
                    switch (i12) {
                        case 0:
                            return OnBackPressedDispatcher._init_$lambda$1(onBackPressedDispatcher, backEventCompat);
                        default:
                            return OnBackPressedDispatcher._init_$lambda$2(onBackPressedDispatcher, backEventCompat);
                    }
                }
            }, new S7.k(this) { // from class: androidx.activity.j
                public final /* synthetic */ OnBackPressedDispatcher b;

                {
                    this.b = this;
                }

                @Override // S7.k
                public final Object invoke(Object obj) {
                    int i12 = i6;
                    OnBackPressedDispatcher onBackPressedDispatcher = this.b;
                    BackEventCompat backEventCompat = (BackEventCompat) obj;
                    switch (i12) {
                        case 0:
                            return OnBackPressedDispatcher._init_$lambda$1(onBackPressedDispatcher, backEventCompat);
                        default:
                            return OnBackPressedDispatcher._init_$lambda$2(onBackPressedDispatcher, backEventCompat);
                    }
                }
            }, new a(this) { // from class: androidx.activity.k
                public final /* synthetic */ OnBackPressedDispatcher b;

                {
                    this.b = this;
                }

                @Override // S7.a
                public final Object invoke() {
                    int i12 = i10;
                    OnBackPressedDispatcher onBackPressedDispatcher = this.b;
                    switch (i12) {
                        case 0:
                            return OnBackPressedDispatcher._init_$lambda$3(onBackPressedDispatcher);
                        case 1:
                            return OnBackPressedDispatcher._init_$lambda$4(onBackPressedDispatcher);
                        default:
                            return OnBackPressedDispatcher._init_$lambda$5(onBackPressedDispatcher);
                    }
                }
            }, new a(this) { // from class: androidx.activity.k
                public final /* synthetic */ OnBackPressedDispatcher b;

                {
                    this.b = this;
                }

                @Override // S7.a
                public final Object invoke() {
                    int i12 = i11;
                    OnBackPressedDispatcher onBackPressedDispatcher = this.b;
                    switch (i12) {
                        case 0:
                            return OnBackPressedDispatcher._init_$lambda$3(onBackPressedDispatcher);
                        case 1:
                            return OnBackPressedDispatcher._init_$lambda$4(onBackPressedDispatcher);
                        default:
                            return OnBackPressedDispatcher._init_$lambda$5(onBackPressedDispatcher);
                    }
                }
            });
        } else {
            final int i12 = 2;
            onBackInvokedCallbackCreateOnBackInvokedCallback = Api33Impl.INSTANCE.createOnBackInvokedCallback(new a(this) { // from class: androidx.activity.k
                public final /* synthetic */ OnBackPressedDispatcher b;

                {
                    this.b = this;
                }

                @Override // S7.a
                public final Object invoke() {
                    int i122 = i12;
                    OnBackPressedDispatcher onBackPressedDispatcher = this.b;
                    switch (i122) {
                        case 0:
                            return OnBackPressedDispatcher._init_$lambda$3(onBackPressedDispatcher);
                        case 1:
                            return OnBackPressedDispatcher._init_$lambda$4(onBackPressedDispatcher);
                        default:
                            return OnBackPressedDispatcher._init_$lambda$5(onBackPressedDispatcher);
                    }
                }
            });
        }
        this.onBackInvokedCallback = onBackInvokedCallbackCreateOnBackInvokedCallback;
    }

    @MainThread
    public final void addCallback(LifecycleOwner owner, OnBackPressedCallback onBackPressedCallback) {
        k.f(owner, "owner");
        k.f(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
        updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new AnonymousClass1(this));
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i, e eVar) {
        this((i & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }
}
