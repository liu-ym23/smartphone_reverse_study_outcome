package com.bytedance.ai.resource.core.db;

import com.bytedance.ai.model.objects.AIPackage;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.db.AIPackageDao$queryOrActiveAIPackage$4", f = "AIPackageDao.kt", i = {}, l = {97, 108}, m = "invokeSuspend", n = {}, s = {})
public final class AIPackageDao$queryOrActiveAIPackage$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIPackage $finalPkg;
    final /* synthetic */ List<AIPackage> $inactivePkg;
    final /* synthetic */ AIPackage $installPkg;
    Object L$0;
    int label;
    final /* synthetic */ AIPackageDao this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AIPackageDao$queryOrActiveAIPackage$4(AIPackage r100, AIPackage r101, List<? extends AIPackage> r102, AIPackageDao r103, Continuation<? super AIPackageDao$queryOrActiveAIPackage$4> r104) {
        this.$installPkg = r100;
        this.$finalPkg = r101;
        this.$inactivePkg = r102;
        this.this$0 = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AIPackageDao$queryOrActiveAIPackage$4(this.$installPkg, this.$finalPkg, this.$inactivePkg, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AIPackageDao$queryOrActiveAIPackage$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        Iterator<AIPackage> r102 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r110);
    L24:
        if (r102.hasNext() == false) goto L34;
        AIPackage r103 = r102.next();
        if (Intrinsics.areEqual(this.$finalPkg, r103) == true) goto L24;
        if (Intrinsics.areEqual(r103.f36907n, this.$finalPkg.f36907n) == true) goto L24;
        AIPackageDao r104 = this.this$0;
        long r105 = r103.f36896c;
        String r106 = r103.a();
        String r107 = r103.f36895b;
        String r108 = r103.f36907n;
        this.L$0 = r102;
        this.label = 2;
        if (r104.a(r105, r106, r107, r108, this) != r100) goto L24;
        return r100;
    L34:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        AIPackage r109 = (AIPackage) this.L$0;
        ResultKt.throwOnFailure(r110);
    L21:
        r102 = this.$inactivePkg.iterator();
        goto L24
    L10:
        ResultKt.throwOnFailure(r110);
        AIPackage r111 = this.$installPkg;
        if (r111 == null) goto L13;
        String r112 = r111.f36907n;
    L15:
        if (Intrinsics.areEqual(r112, this.$finalPkg.f36907n) == true) goto L21;
        AIPackage r113 = this.$installPkg;
        if (r113 == null) goto L21;
        AIPackageDao r114 = this.this$0;
        long r115 = r113.f36896c;
        String r116 = r113.a();
        String r117 = r113.f36895b;
        String r118 = r113.f36907n;
        this.L$0 = r113;
        this.label = 1;
        if (r114.a(r115, r116, r117, r118, this) != r100) goto L21;
        return r100;
    L13:
        r112 = null;
        goto L15
    }
}
