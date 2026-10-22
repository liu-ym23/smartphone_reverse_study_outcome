package com.bytedance.ai.resource;

import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.ai.resource.core.bean.OpenPlatformDebugSchemaData;
import kotlin.Lazy;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$getDebugSchema$2", f = "AIPackageManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIPackageManager$getDebugSchema$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $token;
    private /* synthetic */ Object L$0;
    int label;

    public AIPackageManager$getDebugSchema$2(String r100, Continuation<? super AIPackageManager$getDebugSchema$2> r101) {
        this.$token = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AIPackageManager$getDebugSchema$2 r102 = new AIPackageManager$getDebugSchema$2(this.$token, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((AIPackageManager$getDebugSchema$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Lazy r102 = o5.b.f522025a;
        String r103 = this.$token;
        Intrinsics.checkNotNullParameter(r103, "token");
        OpenPlatformBaseResponse<OpenPlatformDebugSchemaData> r104 = o5.b.a().getDebugSchema(r103);
        boolean r105 = false;
        if (r104.getCode() != 0) goto L7;
        boolean r106 = true;
    L9:
        if (r106 == false) goto L25;
        OpenPlatformDebugSchemaData r107 = r104.getData();
        com.bytedance.ai.utils.g r108 = com.bytedance.ai.utils.g.f37637a;
        r108.i("AIPackageManager", "Succeed to get debug schema : " + r107);
        if (r107 == null) goto L23;
        String r109 = r107.getUrl();
        if (r109 != null) goto L15;
    L16:
        r105 = true;
    L17:
        if (r105 == false) goto L19;
        r108.e("AIPackageManager", "debug schema is EMPTY， logId = " + r104.getLogId());
        String r110 = null;
    L20:
        if (r110 == null) goto L23;
        return r110;
    L19:
        r110 = r107.getUrl();
        goto L20
    L15:
        if (r109.length() != 0) goto L17;
    L23:
        r108.e("AIPackageManager", "Failed to get debug schema. data is NULL");
        return null;
    L25:
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "Failed to get debug schema : code = " + r104.getCode() + ", msg = " + r104.getMessage() + ", logId = " + r104.getLogId());
        return null;
    L7:
        r106 = false;
        goto L9
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
