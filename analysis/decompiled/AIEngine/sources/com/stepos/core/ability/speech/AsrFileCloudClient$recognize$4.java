package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.AsrFileCloudClient;
import com.stepos.core.common.cloud.CloudSessionCorrelationState;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrFileCloudClient$recognize$4", f = "AsrFileCloudClient.kt", l = {67, 72}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AsrFileCloudClient$recognize$4 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super Result<? extends AsrFileCloudClient.RecognizeOutcome>>, Object> {
    final /* synthetic */ String $inferId;
    final /* synthetic */ zb.a<lb.n> $onFirstResponse;
    final /* synthetic */ zb.l<CloudSessionCorrelationState, lb.n> $onTaskSubmitted;
    final /* synthetic */ Long $pollMsOverride;
    final /* synthetic */ AsrFileRequest $request;
    final /* synthetic */ String $traceId;
    Object L$0;
    int label;
    final /* synthetic */ AsrFileCloudClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AsrFileCloudClient$recognize$4(AsrFileCloudClient asrFileCloudClient, AsrFileRequest asrFileRequest, String str, String str2, zb.l<? super CloudSessionCorrelationState, lb.n> lVar, Long l10, zb.a<lb.n> aVar, qb.b<? super AsrFileCloudClient$recognize$4> bVar) {
        super(2, bVar);
        this.this$0 = asrFileCloudClient;
        this.$request = asrFileRequest;
        this.$inferId = str;
        this.$traceId = str2;
        this.$onTaskSubmitted = lVar;
        this.$pollMsOverride = l10;
        this.$onFirstResponse = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        return new AsrFileCloudClient$recognize$4(this.this$0, this.$request, this.$inferId, this.$traceId, this.$onTaskSubmitted, this.$pollMsOverride, this.$onFirstResponse, bVar);
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, qb.b<? super Result<? extends AsrFileCloudClient.RecognizeOutcome>> bVar) {
        return invoke2(coroutineScope, (qb.b<? super Result<AsrFileCloudClient.RecognizeOutcome>>) bVar);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:(1:52)|(1:(1:(7:6|7|8|34|(2:36|37)|43|44)(2:11|12))(1:13))(5:15|48|16|(1:18)|32)|19|(1:21)|22|23|(1:25)(1:27)|28|29|50|30|(5:33|34|(0)|43|44)|32) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ca, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c1 A[Catch: Exception -> 0x00ca, CancellationException -> 0x00fe, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ca, blocks: (B:34:0x00bd, B:36:0x00c1, B:30:0x00b5), top: B:50:0x00b5 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrFileCloudClient$recognize$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, qb.b<? super Result<AsrFileCloudClient.RecognizeOutcome>> bVar) {
        return ((AsrFileCloudClient$recognize$4) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
