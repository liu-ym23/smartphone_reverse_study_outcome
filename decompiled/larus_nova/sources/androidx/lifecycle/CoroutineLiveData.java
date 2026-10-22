package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BT\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00127\u0010\u0007\u001a3\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\bj\b\u0012\u0004\u0012\u00028\u0000`\u000e¢\u0006\u0002\b\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0080@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u000bH\u0014J\b\u0010\u001f\u001a\u00020\u000bH\u0014R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", "", "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/lifecycle/Block;", "<init>", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "emitSource$lifecycle_livedata_release", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSource", "clearSource$lifecycle_livedata_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActive", "onInactive", "lifecycle-livedata_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    public static /* synthetic */ Unit a(CoroutineLiveData r100) {
        return _init_$lambda$0(r100);
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        BlockRunner<T> r100 = this.blockRunner;
        if (r100 == null) goto L6;
        r100.maybeRun();
        return;
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        BlockRunner<T> r100 = this.blockRunner;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    private static final Unit _init_$lambda$0(CoroutineLiveData r100) {
        r100.blockRunner = null;
        return Unit.INSTANCE;
    }

    public final Object clearSource$lifecycle_livedata_release(Continuation<? super Unit> r100) {
        if ((r100 instanceof CoroutineLiveData$clearSource$1) == false) goto L7;
        CoroutineLiveData$clearSource$1 r101 = (CoroutineLiveData$clearSource$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L19:
        this.emittedSource = null;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        EmittedSource r106 = this.emittedSource;
        if (r106 == null) goto L19;
        r101.label = 1;
        if (r106.disposeNow(r101) != r104) goto L19;
        return r104;
    L7:
        r101 = new CoroutineLiveData$clearSource$1(this, r100);
        goto L8
    }

    public final Object emitSource$lifecycle_livedata_release(LiveData<T> r100, Continuation<? super m0> r101) {
        if ((r101 instanceof CoroutineLiveData$emitSource$1) == false) goto L7;
        CoroutineLiveData$emitSource$1 r102 = (CoroutineLiveData$emitSource$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L22:
        EmittedSource r107 = (EmittedSource) r104;
        this.emittedSource = r107;
        return r107;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (LiveData) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L19:
        r102.L$0 = null;
        r102.label = 2;
        r104 = CoroutineLiveDataKt.addDisposableSource(this, r100, r102);
        if (r104 != r105) goto L22;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        if (clearSource$lifecycle_livedata_release(r102) != r105) goto L19;
        return r105;
    L7:
        r102 = new CoroutineLiveData$emitSource$1(this, r101);
        goto L8
    }

    public CoroutineLiveData(CoroutineContext r100, long r101, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "block");
        CompletableJob r102 = SupervisorKt.SupervisorJob((Job) r100.get(Job.Key));
        this.blockRunner = new BlockRunner(this, r110, r101, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(r100).plus(r102)), new c(this));
    }

    public /* synthetic */ CoroutineLiveData(CoroutineContext r100, long r101, Function2 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = 5000;
    L8:
        this(r100, r101, r102);
    }
}
