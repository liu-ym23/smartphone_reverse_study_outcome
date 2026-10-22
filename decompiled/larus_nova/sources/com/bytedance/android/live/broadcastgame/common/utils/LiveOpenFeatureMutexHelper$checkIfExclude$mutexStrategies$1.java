package com.bytedance.android.live.broadcastgame.common.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlin/Function0;", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.broadcastgame.common.utils.LiveOpenFeatureMutexHelper$checkIfExclude$mutexStrategies$1", f = "LiveOpenFeatureMutexHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LiveOpenFeatureMutexHelper$checkIfExclude$mutexStrategies$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Function0<? extends Boolean>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public LiveOpenFeatureMutexHelper$checkIfExclude$mutexStrategies$1(Continuation r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        LiveOpenFeatureMutexHelper$checkIfExclude$mutexStrategies$1 r102 = new LiveOpenFeatureMutexHelper$checkIfExclude$mutexStrategies$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Function0<? extends Boolean>> r100, Continuation<? super Unit> r101) {
        return ((LiveOpenFeatureMutexHelper$checkIfExclude$mutexStrategies$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        SequenceScope r101 = (SequenceScope) this.L$0;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
