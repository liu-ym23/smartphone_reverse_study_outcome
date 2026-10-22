package com.bytedance.android.shopping.prepurchase.arch.container.component;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/ability/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/shopping/prepurchase/arch/container/state/h;", "STATE", "STORE", "Lkotlinx/coroutines/CoroutineScope;", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent$whenAbilityAvailable$1", f = "AbsComponent.kt", i = {}, l = {132, 132}, m = "invokeSuspend", n = {}, s = {})
public final class AbsComponent$whenAbilityAvailable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3 $block;
    final /* synthetic */ Class $service;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AbsComponent this$0;

    public AbsComponent$whenAbilityAvailable$1(AbsComponent r100, Function3 r101, Class r102, Continuation r103) {
        this.this$0 = r100;
        this.$block = r101;
        this.$service = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        AbsComponent$whenAbilityAvailable$1 r102 = new AbsComponent$whenAbilityAvailable$1(this.this$0, this.$block, this.$service, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AbsComponent$whenAbilityAvailable$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r103 = (CoroutineScope) this.L$1;
        Function3 r104 = (Function3) this.L$0;
        ResultKt.throwOnFailure(r100);
    L14:
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (r104.invoke(r103, r100, this) != r101) goto L18;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        r103 = (CoroutineScope) this.L$0;
        Function3 r105 = this.$block;
        j r106 = this.this$0.R1();
        Class r107 = this.$service;
        this.L$0 = r105;
        this.L$1 = r103;
        this.label = 1;
        Object r108 = r106.e(r107, this);
        if (r108 != r101) goto L13;
        return r101;
    L13:
        r104 = r105;
        r100 = r108;
        goto L14
    }
}
