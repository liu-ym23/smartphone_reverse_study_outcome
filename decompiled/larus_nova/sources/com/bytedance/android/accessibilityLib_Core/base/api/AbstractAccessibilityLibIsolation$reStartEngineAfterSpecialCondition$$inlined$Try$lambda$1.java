package com.bytedance.android.accessibilityLib_Core.base.api;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.tool.b;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/accessibilityLib_Core/base/api/AbstractAccessibilityLibIsolation$reStartEngineAfterSpecialCondition$1$1"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.base.api.AbstractAccessibilityLibIsolation$reStartEngineAfterSpecialCondition$1$1", f = "AbstractAccessibilityLibIsolation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AbstractAccessibilityLibIsolation$reStartEngineAfterSpecialCondition$$inlined$Try$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AbstractAccessibilityLibIsolation.ReStartAccessibilityEngineCondition $condition$inlined;
    int label;
    final /* synthetic */ AbstractAccessibilityLibIsolation this$0;

    public AbstractAccessibilityLibIsolation$reStartEngineAfterSpecialCondition$$inlined$Try$lambda$1(Continuation r100, AbstractAccessibilityLibIsolation r101, AbstractAccessibilityLibIsolation.ReStartAccessibilityEngineCondition r102) {
        this.this$0 = r101;
        this.$condition$inlined = r102;
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AbstractAccessibilityLibIsolation$reStartEngineAfterSpecialCondition$$inlined$Try$lambda$1(r101, this.this$0, this.$condition$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AbstractAccessibilityLibIsolation$reStartEngineAfterSpecialCondition$$inlined$Try$lambda$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        if (("reStartEngineAfterSpecialCondition " + this.$condition$inlined) == null) goto L7;
        Context r101 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L7:
        AbstractAccessibilityLibIsolation r102 = this.this$0;
        Context r103 = com.bytedance.android.accessibilityLib_Core.helper.a.a();
        r102.getClass();
        boolean r104 = b.a(r103);
        boolean r105 = this.this$0.f();
        AbstractAccessibilityLibIsolation r106 = this.this$0;
        r106.f38117c = r104;
        if (r105 == true) goto L12;
        if (r104 == false) goto L12;
        r106.l();
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
