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
import vg3.i0;
import vg3.n0;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/i0;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.LegacyComponent$onAttach$3", f = "LegacyComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LegacyComponent$onAttach$3 extends SuspendLambda implements Function3<CoroutineScope, i0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $currentIndex;
    final /* synthetic */ Ref.IntRef $currentOffset;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.a this$0;

    public static final class a<T> implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LegacyComponent$onAttach$3 f181470a;

        public a(LegacyComponent$onAttach$3 r100) {
            this.f181470a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r100) {
            n0 r101 = (n0) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            LegacyComponent$onAttach$3 r102 = this.f181470a;
            Ref.IntRef r103 = r102.$currentIndex;
            r103.element = r101.f554689a;
            int r104 = r102.$currentOffset.element;
            throw null;
        }
    }

    public LegacyComponent$onAttach$3(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.a r100, Ref.IntRef r101, Ref.IntRef r102, Continuation r103) {
        this.$currentIndex = r101;
        this.$currentOffset = r102;
        super(3, r103);
    }

    public final Continuation<Unit> create(CoroutineScope r100, i0 r101, Continuation<? super Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$create");
        Intrinsics.checkNotNullParameter(r101, "it");
        Intrinsics.checkNotNullParameter(r102, "continuation");
        LegacyComponent$onAttach$3 r103 = new LegacyComponent$onAttach$3(null, this.$currentIndex, this.$currentOffset, r102);
        r103.L$0 = r101;
        return r103;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope r100, i0 r101, Continuation<? super Unit> r102) {
        return ((LegacyComponent$onAttach$3) create(r100, r101, r102)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((i0) this.L$0).q1(), null, new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
