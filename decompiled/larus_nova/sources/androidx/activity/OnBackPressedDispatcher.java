package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0004)*+,B\u0013\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\fH\u0007J\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\fH\u0001¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\u0014H\u0007J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\n\u001a\u00020\u0007H\u0007J\b\u0010 \u001a\u00020\u0014H\u0003J\b\u0010!\u001a\u00020\u0014H\u0007J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000eH\u0007J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0007H\u0003J\b\u0010(\u001a\u00020\u0014H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "", "fallbackOnBackPressed", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "onHasEnabledCallbacksChanged", "Landroidx/core/util/Consumer;", "", "(Ljava/lang/Runnable;Landroidx/core/util/Consumer;)V", "backInvokedCallbackRegistered", "hasEnabledCallbacks", "inProgressCallback", "Landroidx/activity/OnBackPressedCallback;", "invokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "onBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackPressedCallbacks", "Lkotlin/collections/ArrayDeque;", "addCallback", "", "onBackPressedCallback", "owner", "Landroidx/lifecycle/LifecycleOwner;", "addCancellableCallback", "Landroidx/activity/Cancellable;", "addCancellableCallback$activity_release", "dispatchOnBackCancelled", "dispatchOnBackProgressed", "backEvent", "Landroidx/activity/BackEventCompat;", "dispatchOnBackStarted", "onBackCancelled", "onBackPressed", "onBackProgressed", "onBackStarted", "setOnBackInvokedDispatcher", "invoker", "updateBackInvokedCallbackState", "shouldBeRegistered", "updateEnabledCallbacks", "Api33Impl", "Api34Impl", "LifecycleOnBackPressedCancellable", "OnBackPressedCancellable", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    private OnBackPressedCallback inProgressCallback;
    private OnBackInvokedDispatcher invokedDispatcher;
    private OnBackInvokedCallback onBackInvokedCallback;
    private final ArrayDeque<OnBackPressedCallback> onBackPressedCallbacks;
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0007¨\u0006\u000e"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api33Impl;", "", "()V", "createOnBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackInvoked", "Lkotlin/Function0;", "", "registerOnBackInvokedCallback", "dispatcher", "priority", "", "callback", "unregisterOnBackInvokedCallback", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = null;

        static {
            INSTANCE = new Api33Impl();
        }

        private Api33Impl() {
        }

        public static /* synthetic */ void a(Function0 r100) {
            createOnBackInvokedCallback$lambda$0(r100);
        }

        private static final void createOnBackInvokedCallback$lambda$0(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "$onBackInvoked");
            r100.invoke();
        }

        public final OnBackInvokedCallback createOnBackInvokedCallback(final Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "onBackInvoked");
            return new h(r100);
        }

        public final void unregisterOnBackInvokedCallback(Object r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "dispatcher");
            Intrinsics.checkNotNullParameter(r101, "callback");
            ((OnBackInvokedDispatcher) r100).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r101);
        }

        public final void registerOnBackInvokedCallback(Object r100, int r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, "dispatcher");
            Intrinsics.checkNotNullParameter(r102, "callback");
            ((OnBackInvokedDispatcher) r100).registerOnBackInvokedCallback(r101, (OnBackInvokedCallback) r102);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jj\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0007¨\u0006\u0010"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api34Impl;", "", "()V", "createOnBackAnimationCallback", "Landroid/window/OnBackInvokedCallback;", "onBackStarted", "Lkotlin/Function1;", "Landroidx/activity/BackEventCompat;", "Lkotlin/ParameterName;", "name", "backEvent", "", "onBackProgressed", "onBackInvoked", "Lkotlin/Function0;", "onBackCancelled", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = null;

        static {
            INSTANCE = new Api34Impl();
        }

        private Api34Impl() {
        }

        public final OnBackInvokedCallback createOnBackAnimationCallback(final Function1<? super BackEventCompat, Unit> r100, final Function1<? super BackEventCompat, Unit> r101, final Function0<Unit> r102, final Function0<Unit> r103) {
            Intrinsics.checkNotNullParameter(r100, "onBackStarted");
            Intrinsics.checkNotNullParameter(r101, "onBackProgressed");
            Intrinsics.checkNotNullParameter(r102, "onBackInvoked");
            Intrinsics.checkNotNullParameter(r103, "onBackCancelled");
            return new OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/activity/Cancellable;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/Lifecycle;Landroidx/activity/OnBackPressedCallback;)V", "currentCancellable", "cancel", "", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        private Cancellable currentCancellable;
        private final Lifecycle lifecycle;
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            Cancellable r100 = this.currentCancellable;
            if (r100 == null) goto L5;
            r100.cancel();
        L5:
            this.currentCancellable = null;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "event");
            if (r101 != Lifecycle.Event.ON_START) goto L6;
            this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
            return;
        L6:
            if (r101 != Lifecycle.Event.ON_STOP) goto L11;
            Cancellable r102 = this.currentCancellable;
            if (r102 == null) goto L15;
            r102.cancel();
            return;
        L15:
            return;
        L11:
            if (r101 != Lifecycle.Event.ON_DESTROY) goto L17;
            cancel();
            return;
        }

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher r100, Lifecycle r101, OnBackPressedCallback r102) {
            Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
            Intrinsics.checkNotNullParameter(r102, "onBackPressedCallback");
            this.this$0 = r100;
            this.lifecycle = r101;
            this.onBackPressedCallback = r102;
            r101.addObserver(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$OnBackPressedCancellable;", "Landroidx/activity/Cancellable;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/activity/OnBackPressedCallback;)V", "cancel", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        @Override // androidx.activity.Cancellable
        public void cancel() {
            OnBackPressedDispatcher.access$getOnBackPressedCallbacks$p(this.this$0).remove(this.onBackPressedCallback);
            if (Intrinsics.areEqual(OnBackPressedDispatcher.access$getInProgressCallback$p(this.this$0), this.onBackPressedCallback) == false) goto L5;
            this.onBackPressedCallback.handleOnBackCancelled();
            OnBackPressedDispatcher.access$setInProgressCallback$p(this.this$0, null);
        L5:
            this.onBackPressedCallback.removeCancellable(this);
            Function0<Unit> r100 = this.onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (r100 == null) goto L8;
            r100.invoke();
        L8:
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release(null);
        }

        public OnBackPressedCancellable(OnBackPressedDispatcher r100, OnBackPressedCallback r101) {
            Intrinsics.checkNotNullParameter(r101, "onBackPressedCallback");
            this.this$0 = r100;
            this.onBackPressedCallback = r101;
        }
    }

    /* JADX INFO: renamed from: androidx.activity.OnBackPressedDispatcher$addCallback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class C85111 extends FunctionReferenceImpl implements Function0<Unit> {
        public C85111(Object r100) {
            super(0, r100, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            OnBackPressedDispatcher.access$updateEnabledCallbacks((OnBackPressedDispatcher) this.receiver);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void onBackCancelled() {
        ArrayDeque<OnBackPressedCallback> r100 = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> r101 = r100.listIterator(r100.size());
    L4:
        if (r101.hasPrevious() == false) goto L8;
        OnBackPressedCallback r102 = r101.previous();
        if (r102.isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r103 = r102;
        this.inProgressCallback = null;
        if (r103 == null) goto L16;
        r103.handleOnBackCancelled();
        return;
    L16:
        return;
    L8:
        r102 = null;
        goto L9
    }

    private final void updateEnabledCallbacks() {
        boolean r100 = this.hasEnabledCallbacks;
        ArrayDeque<OnBackPressedCallback> r101 = this.onBackPressedCallbacks;
        boolean r102 = false;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<OnBackPressedCallback> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        if (r103.next().isEnabled() == false) goto L9;
        r102 = true;
    L13:
        this.hasEnabledCallbacks = r102;
        if (r102 == r100) goto L25;
        Consumer<Boolean> r104 = this.onHasEnabledCallbacksChanged;
        if (r104 == null) goto L19;
        r104.accept(Boolean.valueOf(r102));
    L19:
        if (Build.VERSION.SDK_INT < 33) goto L26;
        updateBackInvokedCallbackState(r102);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }

    public final void onBackPressed() {
        ArrayDeque<OnBackPressedCallback> r100 = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> r101 = r100.listIterator(r100.size());
    L4:
        if (r101.hasPrevious() == false) goto L8;
        OnBackPressedCallback r102 = r101.previous();
        if (r102.isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r103 = r102;
        this.inProgressCallback = null;
        if (r103 == null) goto L13;
        r103.handleOnBackPressed();
        return;
    L13:
        Runnable r104 = this.fallbackOnBackPressed;
        if (r104 == null) goto L20;
        r104.run();
        return;
    L20:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final void dispatchOnBackCancelled() {
        onBackCancelled();
    }

    public final boolean hasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    public OnBackPressedDispatcher(Runnable r100) {
        this(r100, null);
    }

    public static final /* synthetic */ OnBackPressedCallback access$getInProgressCallback$p(OnBackPressedDispatcher r100) {
        return r100.inProgressCallback;
    }

    public static final /* synthetic */ ArrayDeque access$getOnBackPressedCallbacks$p(OnBackPressedDispatcher r100) {
        return r100.onBackPressedCallbacks;
    }

    public static final /* synthetic */ void access$onBackCancelled(OnBackPressedDispatcher r100) {
        r100.onBackCancelled();
    }

    public static final /* synthetic */ void access$updateEnabledCallbacks(OnBackPressedDispatcher r100) {
        r100.updateEnabledCallbacks();
    }

    private final void onBackProgressed(BackEventCompat r100) {
        ArrayDeque<OnBackPressedCallback> r101 = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L8;
        OnBackPressedCallback r103 = r102.previous();
        if (r103.isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r104 = r103;
        if (r104 == null) goto L16;
        r104.handleOnBackProgressed(r100);
        return;
    L16:
        return;
    L8:
        r103 = null;
        goto L9
    }

    private final void onBackStarted(BackEventCompat r100) {
        ArrayDeque<OnBackPressedCallback> r101 = this.onBackPressedCallbacks;
        ListIterator<OnBackPressedCallback> r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L8;
        OnBackPressedCallback r103 = r102.previous();
        if (r103.isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r104 = r103;
        this.inProgressCallback = r104;
        if (r104 == null) goto L16;
        r104.handleOnBackStarted(r100);
        return;
    L16:
        return;
    L8:
        r103 = null;
        goto L9
    }

    private final void updateBackInvokedCallbackState(boolean r100) {
        OnBackInvokedDispatcher r101 = this.invokedDispatcher;
        OnBackInvokedCallback r102 = this.onBackInvokedCallback;
        if (r101 == null) goto L15;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r100 == true) goto L8;
    L10:
        if (r100 == false) goto L12;
        return;
    L12:
        if (this.backInvokedCallbackRegistered == false) goto L19;
        Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(r101, r102);
        this.backInvokedCallbackRegistered = false;
        return;
    L19:
        return;
    L8:
        if (this.backInvokedCallbackRegistered == true) goto L10;
        Api33Impl.INSTANCE.registerOnBackInvokedCallback(r101, 0, r102);
        this.backInvokedCallbackRegistered = true;
        return;
    }

    public final void addCallback(OnBackPressedCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "onBackPressedCallback");
        addCancellableCallback$activity_release(r100);
    }

    public final Cancellable addCancellableCallback$activity_release(OnBackPressedCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(r100);
        OnBackPressedCancellable r101 = new OnBackPressedCancellable(this, r100);
        r100.addCancellable(r101);
        updateEnabledCallbacks();
        r100.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return r101;
    }

    public final void dispatchOnBackProgressed(BackEventCompat r100) {
        Intrinsics.checkNotNullParameter(r100, "backEvent");
        onBackProgressed(r100);
    }

    public final void dispatchOnBackStarted(BackEventCompat r100) {
        Intrinsics.checkNotNullParameter(r100, "backEvent");
        onBackStarted(r100);
    }

    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "invoker");
        this.invokedDispatcher = r100;
        updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }

    public OnBackPressedDispatcher(Runnable r100, Consumer<Boolean> r101) {
        this.fallbackOnBackPressed = r100;
        this.onHasEnabledCallbacksChanged = r101;
        this.onBackPressedCallbacks = new ArrayDeque();
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 33) goto L5;
        return;
    L5:
        if (r102 < 34) goto L7;
        OnBackInvokedCallback r103 = Api34Impl.INSTANCE.createOnBackAnimationCallback(new AnonymousClass1(this), new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass4(this));
    L8:
        this.onBackInvokedCallback = r103;
        return;
    L7:
        r103 = Api33Impl.INSTANCE.createOnBackInvokedCallback(new AnonymousClass5(this));
        goto L8
    }

    public static final /* synthetic */ void access$onBackProgressed(OnBackPressedDispatcher r100, BackEventCompat r101) {
        r100.onBackProgressed(r101);
    }

    public static final /* synthetic */ void access$onBackStarted(OnBackPressedDispatcher r100, BackEventCompat r101) {
        r100.onBackStarted(r101);
    }

    public static final /* synthetic */ void access$setInProgressCallback$p(OnBackPressedDispatcher r100, OnBackPressedCallback r101) {
        r100.inProgressCallback = r101;
    }

    public final void addCallback(LifecycleOwner r100, OnBackPressedCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "onBackPressedCallback");
        Lifecycle r102 = r100.getLifecycle();
        if (r102.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        r101.addCancellable(new LifecycleOnBackPressedCancellable(this, r102, r101));
        updateEnabledCallbacks();
        r101.setEnabledChangedCallback$activity_release(new C85111(this));
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
