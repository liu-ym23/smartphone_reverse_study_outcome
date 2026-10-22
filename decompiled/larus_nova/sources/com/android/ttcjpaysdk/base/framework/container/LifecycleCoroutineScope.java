package com.android.ttcjpaysdk.base.framework.container;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0014B\u0019\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/LifecycleCoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "CJTag", "", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "registerLifecycleObserver", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifecycleCoroutineScope implements CoroutineScope, LifecycleEventObserver, ICJTag {
    public static final Companion Companion = null;
    private static final Lazy<ConcurrentHashMap<Lifecycle, LifecycleCoroutineScope>> lifecycleMap$delegate = null;
    private final CoroutineContext coroutineContext;
    private final Lifecycle lifecycle;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/LifecycleCoroutineScope$Companion;", "", "()V", "lifecycleMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroidx/lifecycle/Lifecycle;", "Lcom/android/ttcjpaysdk/base/framework/container/LifecycleCoroutineScope;", "getLifecycleMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "lifecycleMap$delegate", "Lkotlin/Lazy;", MonitorConstants.CONNECT_TYPE_GET, NewBroadcastMonitor.STAGE.LIFECYCLE, "release", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final ConcurrentHashMap<Lifecycle, LifecycleCoroutineScope> getLifecycleMap() {
            return (ConcurrentHashMap) LifecycleCoroutineScope.access$getLifecycleMap$delegate$cp().getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final LifecycleCoroutineScope get(Lifecycle r100) {
            Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
            ConcurrentHashMap<Lifecycle, LifecycleCoroutineScope> r101 = getLifecycleMap();
            LifecycleCoroutineScope r102 = r101.get(r100);
            if (r102 != null) goto L9;
            CoroutineContext r103 = null;
            r102 = new LifecycleCoroutineScope(r100, r103, 2, 0 == true ? 1 : 0);
            LifecycleCoroutineScope r104 = r101.putIfAbsent(r100, r102);
            if (r104 == null) goto L9;
            r102 = r104;
        L9:
            return r102;
        }

        public final void release(Lifecycle r100) {
            Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
            getLifecycleMap().remove(r100);
        }
    }

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.base.framework.container.LifecycleCoroutineScope$registerLifecycleObserver$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.android.ttcjpaysdk.base.framework.container.LifecycleCoroutineScope$registerLifecycleObserver$1", f = "CJPayStdPageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LifecycleCoroutineScope this$0;

        public AnonymousClass1(LifecycleCoroutineScope r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r100);
            CoroutineScope r101 = (CoroutineScope) this.L$0;
            if (LifecycleCoroutineScope.access$getLifecycle$p(this.this$0).getCurrentState().compareTo(Lifecycle.State.INITIALIZED) < 0) goto L7;
            LifecycleCoroutineScope.access$getLifecycle$p(this.this$0).addObserver(this.this$0);
        L9:
            return Unit.INSTANCE;
        L7:
            JobKt.cancel$default(r101.getCoroutineContext(), null, 1, null);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        return "LifecycleCoroutineScope";
    }

    static {
        Companion = new Companion(null);
        lifecycleMap$delegate = LazyKt.lazy(LifecycleCoroutineScope$Companion$lifecycleMap$2.INSTANCE);
    }

    private final void registerLifecycleObserver() {
        BuildersKt.launch$default(this, Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(this, null), 2, null);
    }

    public static final /* synthetic */ Lazy access$getLifecycleMap$delegate$cp() {
        return lifecycleMap$delegate;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public static final /* synthetic */ Lifecycle access$getLifecycle$p(LifecycleCoroutineScope r100) {
        return r100.lifecycle;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    private LifecycleCoroutineScope(Lifecycle r100, CoroutineContext r101) {
        this.lifecycle = r100;
        this.coroutineContext = r101;
        if (r100.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        JobKt.cancel$default(getCoroutineContext(), null, 1, null);
    L5:
        registerLifecycleObserver();
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (this.lifecycle.getCurrentState().compareTo(Lifecycle.State.DESTROYED) > 0) goto L6;
        this.lifecycle.removeObserver(this);
        JobKt.cancel$default(getCoroutineContext(), null, 1, null);
        Companion.release(this.lifecycle);
        return;
    }

    public /* synthetic */ LifecycleCoroutineScope(Lifecycle r100, CoroutineContext r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate());
    L5:
        this(r100, r101);
    }
}
