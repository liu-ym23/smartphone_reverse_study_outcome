package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.utils.g;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 1}, l = {71, 73}, m = "updateAIPackage", n = {"info", "info"}, s = {"L$0", "L$0"})
final class AIPackageStorage$updateAIPackage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageStorage this$0;

    public AIPackageStorage$updateAIPackage$1(AIPackageStorage r100, Continuation<? super AIPackageStorage$updateAIPackage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ai.model.objects.AIPackage, com.bytedance.ai.resource.core.AIPackageStorage$updateAIPackage$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AIPackageStorage r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        ?? r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L20;
        boolean r106 = true;
        if (r105 != 1) goto L11;
        AIPackage r107 = (AIPackage) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L23
    L26:
        return Boxing.boxBoolean(r106);
    L11:
        if (r105 != 2) goto L16;
        AIPackage r108 = (AIPackage) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L23
        g.f37637a.d("AIPackageStorage", "packageName: " + r108.f36895b + ", appId: " + ((Applet) r108).K + " ===> end update database");     // Catch: Exception -> L23
        goto L26
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r104);
        g r109 = g.f37637a;     // Catch: Exception -> L23
        throw null;     // Catch: Exception -> L23
    L23:
        e = move-exception;
        g.f37637a.e("AIPackageStorage", "packageName: " + r103.f36895b + ", appId: " + r103.a() + " ===> update database error : " + ExceptionsKt.stackTraceToString(e));
        r106 = false;
        goto L26
    L5:
        r103 = new AIPackageStorage$updateAIPackage$1(r101, this);
        goto L6
    }
}
