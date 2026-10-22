package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam;
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
import kotlinx.coroutines.CoroutineScope;
import vg3.m0;
import vg3.x;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/x;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.PdpCommonService$onAttach$2", f = "PdpCommonService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdpCommonService$onAttach$2 extends SuspendLambda implements Function3<CoroutineScope, x, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PdpCommonService this$0;

    public static final class a implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpCommonService$onAttach$2 f182025a;

        public a(PdpCommonService$onAttach$2 r100) {
            this.f182025a = r100;
        }

        @Override // vg3.m0
        public final void a(PdpPackRequestParam r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            r100.updateShopRecommendTabIndex(this.f182025a.this$0.f182021j);
        }
    }

    public PdpCommonService$onAttach$2(PdpCommonService r100, Continuation r101) {
        this.this$0 = r100;
        super(3, r101);
    }

    public final Continuation<Unit> create(CoroutineScope r100, x r101, Continuation<? super Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$create");
        Intrinsics.checkNotNullParameter(r101, "it");
        Intrinsics.checkNotNullParameter(r102, "continuation");
        PdpCommonService$onAttach$2 r103 = new PdpCommonService$onAttach$2(this.this$0, r102);
        r103.L$0 = r101;
        return r103;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope r100, x r101, Continuation<? super Unit> r102) {
        return ((PdpCommonService$onAttach$2) create(r100, r101, r102)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        ((x) this.L$0).w1(new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
