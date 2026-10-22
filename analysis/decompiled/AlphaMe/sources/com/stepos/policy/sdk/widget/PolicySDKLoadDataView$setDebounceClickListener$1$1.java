package com.stepos.policy.sdk.widget;

import Z2.F;
import Z2.M;
import android.view.View;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.stepos.policy.sdk.widget.PolicySDKLoadDataView$setDebounceClickListener$1$1", f = "PolicySDKLoadDataView.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class PolicySDKLoadDataView$setDebounceClickListener$1$1 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $it;
    final /* synthetic */ View.OnClickListener $listener;
    final /* synthetic */ long $time;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView$setDebounceClickListener$1$1(long j4, View.OnClickListener onClickListener, View view, Continuation<? super PolicySDKLoadDataView$setDebounceClickListener$1$1> continuation) {
        super(2, continuation);
        this.$time = j4;
        this.$listener = onClickListener;
        this.$it = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PolicySDKLoadDataView$setDebounceClickListener$1$1(this.$time, this.$listener, this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            long j4 = this.$time;
            this.label = 1;
            if (M.a(j4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$listener.onClick(this.$it);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
        return ((PolicySDKLoadDataView$setDebounceClickListener$1$1) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
