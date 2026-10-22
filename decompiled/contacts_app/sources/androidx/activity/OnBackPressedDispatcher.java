package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003\u001e\u001f B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0010H\u0007J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0007J\b\u0010\u0019\u001a\u00020\tH\u0007J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000bH\u0007J\r\u0010\u001c\u001a\u00020\tH\u0001¢\u0006\u0002\b\u001dR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "", "fallbackOnBackPressed", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "backInvokedCallbackRegistered", "", "enabledChangedCallback", "Lkotlin/Function0;", "", "invokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "onBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackPressedCallbacks", "Lkotlin/collections/ArrayDeque;", "Landroidx/activity/OnBackPressedCallback;", "addCallback", "onBackPressedCallback", "owner", "Landroidx/lifecycle/LifecycleOwner;", "addCancellableCallback", "Landroidx/activity/Cancellable;", "addCancellableCallback$activity_release", "hasEnabledCallbacks", "onBackPressed", "setOnBackInvokedDispatcher", "invoker", "updateBackInvokedCallbackState", "updateBackInvokedCallbackState$activity_release", "Api33Impl", "LifecycleOnBackPressedCancellable", "OnBackPressedCancellable", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    private Function0<Unit> enabledChangedCallback;
    private final Runnable fallbackOnBackPressed;
    private OnBackInvokedDispatcher invokedDispatcher;
    private OnBackInvokedCallback onBackInvokedCallback;
    private final ArrayDeque<OnBackPressedCallback> onBackPressedCallbacks;

    /* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0007¨\u0006\u000e"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api33Impl;", "", "()V", "createOnBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackInvoked", "Lkotlin/Function0;", "", "registerOnBackInvokedCallback", "dispatcher", "priority", "", "callback", "unregisterOnBackInvokedCallback", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = null;

        public static /* synthetic */ void $r8$lambda$tzBBo0FLedRCWSI6_icF8qhF74s(Function0 r0) {
            createOnBackInvokedCallback$lambda$0(r0);
        }

        static {
            INSTANCE = new Api33Impl();
        }

        private Api33Impl() {
        }

        public final void registerOnBackInvokedCallback(Object r1, int r2, Object r3) {
            Intrinsics.checkNotNullParameter(r1, "dispatcher");
            Intrinsics.checkNotNullParameter(r3, "callback");
            ((OnBackInvokedDispatcher) r1).registerOnBackInvokedCallback(r2, (OnBackInvokedCallback) r3);
        }

        public final void unregisterOnBackInvokedCallback(Object r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "dispatcher");
            Intrinsics.checkNotNullParameter(r2, "callback");
            ((OnBackInvokedDispatcher) r1).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r2);
        }

        private static final void createOnBackInvokedCallback$lambda$0(Function0 r1) {
            Intrinsics.checkNotNullParameter(r1, "$onBackInvoked");
            r1.invoke();
        }

        public final OnBackInvokedCallback createOnBackInvokedCallback(final Function0<Unit> r1) {
            Intrinsics.checkNotNullParameter(r1, "onBackInvoked");
            return new OnBackPressedDispatcher$Api33Impl$$ExternalSyntheticLambda0(r1);
        }
    }

    /* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/activity/Cancellable;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/Lifecycle;Landroidx/activity/OnBackPressedCallback;)V", "currentCancellable", "cancel", "", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        private Cancellable currentCancellable;
        private final Lifecycle lifecycle;
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher r2, Lifecycle r3, OnBackPressedCallback r4) {
            Intrinsics.checkNotNullParameter(r3, "lifecycle");
            Intrinsics.checkNotNullParameter(r4, "onBackPressedCallback");
            this.this$0 = r2;
            this.lifecycle = r3;
            this.onBackPressedCallback = r4;
            r3.addObserver(this);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "event");
            if (r3 != Lifecycle.Event.ON_START) goto L6;
            this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
            return;
        L6:
            if (r3 != Lifecycle.Event.ON_STOP) goto L11;
            Cancellable r1 = this.currentCancellable;
            if (r1 == null) goto L15;
            r1.cancel();
            return;
        L15:
            return;
        L11:
            if (r3 != Lifecycle.Event.ON_DESTROY) goto L17;
            cancel();
            return;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            Cancellable r0 = this.currentCancellable;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            this.currentCancellable = null;
        }
    }

    /* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$OnBackPressedCancellable;", "Landroidx/activity/Cancellable;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/activity/OnBackPressedCallback;)V", "cancel", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(OnBackPressedDispatcher r2, OnBackPressedCallback r3) {
            Intrinsics.checkNotNullParameter(r3, "onBackPressedCallback");
            this.this$0 = r2;
            this.onBackPressedCallback = r3;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            OnBackPressedDispatcher.access$getOnBackPressedCallbacks$p(this.this$0).remove(this.onBackPressedCallback);
            this.onBackPressedCallback.removeCancellable(this);
            if (Build.VERSION.SDK_INT < 33) goto L6;
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release(null);
            this.this$0.updateBackInvokedCallbackState$activity_release();
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public OnBackPressedDispatcher(Runnable r2) {
        this.fallbackOnBackPressed = r2;
        this.onBackPressedCallbacks = new ArrayDeque();
        if (Build.VERSION.SDK_INT < 33) goto L6;
        this.enabledChangedCallback = new AnonymousClass1(this);
        this.onBackInvokedCallback = Api33Impl.INSTANCE.createOnBackInvokedCallback(new AnonymousClass2(this));
        return;
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public static final /* synthetic */ ArrayDeque access$getOnBackPressedCallbacks$p(OnBackPressedDispatcher r0) {
        return r0.onBackPressedCallbacks;
    }

    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher r2) {
        Intrinsics.checkNotNullParameter(r2, "invoker");
        this.invokedDispatcher = r2;
        updateBackInvokedCallbackState$activity_release();
    }

    public final void updateBackInvokedCallbackState$activity_release() {
        boolean r0 = hasEnabledCallbacks();
        OnBackInvokedDispatcher r1 = this.invokedDispatcher;
        OnBackInvokedCallback r2 = this.onBackInvokedCallback;
        if (r1 == null) goto L15;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r0 == true) goto L8;
    L10:
        if (r0 == false) goto L12;
        return;
    L12:
        if (this.backInvokedCallbackRegistered == false) goto L19;
        Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(r1, r2);
        this.backInvokedCallbackRegistered = false;
        return;
    L19:
        return;
    L8:
        if (this.backInvokedCallbackRegistered == true) goto L10;
        Api33Impl.INSTANCE.registerOnBackInvokedCallback(r1, 0, r2);
        this.backInvokedCallbackRegistered = true;
        return;
    }

    public final void addCallback(OnBackPressedCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "onBackPressedCallback");
        addCancellableCallback$activity_release(r2);
    }

    public final Cancellable addCancellableCallback$activity_release(OnBackPressedCallback r4) {
        Intrinsics.checkNotNullParameter(r4, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(r4);
        OnBackPressedCancellable r0 = new OnBackPressedCancellable(this, r4);
        r4.addCancellable(r0);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        updateBackInvokedCallbackState$activity_release();
        r4.setEnabledChangedCallback$activity_release(this.enabledChangedCallback);
    L5:
        return r0;
    }

    public final void addCallback(LifecycleOwner r3, OnBackPressedCallback r4) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "onBackPressedCallback");
        Lifecycle r5 = r3.getLifecycle();
        if (r5.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        r4.addCancellable(new LifecycleOnBackPressedCancellable(this, r5, r4));
        if (Build.VERSION.SDK_INT < 33) goto L9;
        updateBackInvokedCallbackState$activity_release();
        r4.setEnabledChangedCallback$activity_release(this.enabledChangedCallback);
        return;
    }

    public final boolean hasEnabledCallbacks() {
        ArrayDeque<OnBackPressedCallback> r2 = this.onBackPressedCallbacks;
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<OnBackPressedCallback> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L18;
        if (r3.next().isEnabled() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return false;
    }

    public final void onBackPressed() {
        ArrayDeque<OnBackPressedCallback> r0 = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        OnBackPressedCallback r2 = r1.previous();
        if (r2.isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r3 = r2;
        if (r3 == null) goto L13;
        r3.handleOnBackPressed();
        return;
    L13:
        Runnable r4 = this.fallbackOnBackPressed;
        if (r4 == null) goto L20;
        r4.run();
        return;
    L20:
        return;
    L8:
        r2 = null;
        goto L9
    }
}
