package com.bytedance.ai.resource;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1", f = "AIPackageManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.i<Boolean> $continuation;
    final /* synthetic */ List<String> $fileListToDelete;
    final /* synthetic */ Ref.BooleanRef $uninstallResult;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1(List<String> r100, kotlinx.coroutines.i<? super Boolean> r101, Ref.BooleanRef r102, Continuation<? super AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1> r103) {
        this.$fileListToDelete = r100;
        this.$continuation = r101;
        this.$uninstallResult = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1(this.$fileListToDelete, this.$continuation, this.$uninstallResult, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r100);
        List<String> r101 = this.$fileListToDelete;
        Ref.BooleanRef r102 = this.$uninstallResult;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        String r104 = (String) r103.next();
        boolean r105 = com.bytedance.ai.utils.f.delete(r104);
        com.bytedance.ai.utils.g.f37637a.i("AIPackageManager", "remove file----->" + r104 + " is removed: " + r105);
        if (r105 == true) goto L6;
        r102.element = r105;
        goto L6
    L11:
        if (this.$continuation.isCompleted() == true) goto L14;
        kotlinx.coroutines.i<Boolean> r106 = this.$continuation;
        Result.Companion r107 = Result.Companion;
        r106.resumeWith(Result.m9449constructorimpl(Boxing.boxBoolean(this.$uninstallResult.element)));
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
