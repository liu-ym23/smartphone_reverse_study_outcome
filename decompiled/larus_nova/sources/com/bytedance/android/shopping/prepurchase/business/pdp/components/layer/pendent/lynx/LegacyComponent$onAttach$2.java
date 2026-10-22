package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx;

import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import vg3.d0;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/d0;", "ability", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.LegacyComponent$onAttach$2", f = "LegacyComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LegacyComponent$onAttach$2 extends SuspendLambda implements Function3<CoroutineScope, d0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $currentIndex;
    final /* synthetic */ Ref.IntRef $currentOffset;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.a this$0;

    public static final class a<T> implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LegacyComponent$onAttach$2 f181469a;

        public a(LegacyComponent$onAttach$2 r100) {
            this.f181469a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r100) {
            int r101 = ((Number) r100).intValue();
            LegacyComponent$onAttach$2 r102 = this.f181469a;
            r102.$currentOffset.element = r101;
            int r103 = r102.$currentIndex.element;
            throw null;
        }
    }

    public LegacyComponent$onAttach$2(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.a r100, Ref.IntRef r101, Ref.IntRef r102, Continuation r103) {
        this.$currentOffset = r101;
        this.$currentIndex = r102;
        super(3, r103);
    }

    public final Continuation<Unit> create(CoroutineScope r100, d0 r101, Continuation<? super Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$create");
        Intrinsics.checkNotNullParameter(r101, "ability");
        Intrinsics.checkNotNullParameter(r102, "continuation");
        LegacyComponent$onAttach$2 r103 = new LegacyComponent$onAttach$2(null, this.$currentOffset, this.$currentIndex, r102);
        r103.L$0 = r101;
        return r103;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope r100, d0 r101, Continuation<? super Unit> r102) {
        return ((LegacyComponent$onAttach$2) create(r100, r101, r102)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((d0) this.L$0).R(), null, new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
