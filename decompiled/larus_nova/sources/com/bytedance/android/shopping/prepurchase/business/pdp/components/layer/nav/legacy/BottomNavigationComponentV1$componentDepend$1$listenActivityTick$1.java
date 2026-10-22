package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.ec.core.utils.l1;
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

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/h;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.BottomNavigationComponentV1$componentDepend$1$listenActivityTick$1", f = "BottomNavigationComponentV1.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BottomNavigationComponentV1$componentDepend$1$listenActivityTick$1 extends SuspendLambda implements Function3<CoroutineScope, vg3.h, Continuation<? super Unit>, Object> {
    final /* synthetic */ l1.a $tickWatch;
    private /* synthetic */ Object L$0;
    int label;

    public BottomNavigationComponentV1$componentDepend$1$listenActivityTick$1(l1.a r100, Continuation r101) {
        this.$tickWatch = r100;
        super(3, r101);
    }

    public final Continuation<Unit> create(CoroutineScope r100, vg3.h r101, Continuation<? super Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$create");
        Intrinsics.checkNotNullParameter(r101, "it");
        Intrinsics.checkNotNullParameter(r102, "continuation");
        BottomNavigationComponentV1$componentDepend$1$listenActivityTick$1 r103 = new BottomNavigationComponentV1$componentDepend$1$listenActivityTick$1(this.$tickWatch, r102);
        r103.L$0 = r101;
        return r103;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope r100, vg3.h r101, Continuation<? super Unit> r102) {
        return ((BottomNavigationComponentV1$componentDepend$1$listenActivityTick$1) create(r100, r101, r102)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        ((vg3.h) this.L$0).A(this.$tickWatch);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
