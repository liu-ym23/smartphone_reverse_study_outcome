package com.bytedance.ai.resource;

import java.util.Iterator;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$cleanPackagesToDelete$4", f = "AIPackageManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIPackageManager$cleanPackagesToDelete$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $fileListToDelete;
    int label;

    public AIPackageManager$cleanPackagesToDelete$4(List<String> r100, Continuation<? super AIPackageManager$cleanPackagesToDelete$4> r101) {
        this.$fileListToDelete = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AIPackageManager$cleanPackagesToDelete$4(this.$fileListToDelete, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AIPackageManager$cleanPackagesToDelete$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        Iterator<T> r101 = this.$fileListToDelete.iterator();
    L6:
        if (r101.hasNext() == false) goto L9;
        String r102 = (String) r101.next();
        boolean r103 = com.bytedance.ai.utils.f.delete(r102);
        com.bytedance.ai.utils.g.f37637a.d("AIPackageManager", r102 + " is removed: " + r103);
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
