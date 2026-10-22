package com.stepos.core.ability.speech;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;
import v6.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrSseAbility$streamSessions$2$1", f = "AsrSseAbility.kt", l = {97}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AsrSseAbility$streamSessions$2$1 extends SuspendLambda implements zb.w<String, byte[], Integer, Integer, Long, Long, Object, String, qb.b<? super Flow<? extends Result<? extends d.q>>>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ int I$1;
    /* synthetic */ long J$0;
    /* synthetic */ long J$1;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    int label;
    final /* synthetic */ AsrSseAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsrSseAbility$streamSessions$2$1(AsrSseAbility asrSseAbility, qb.b<? super AsrSseAbility$streamSessions$2$1> bVar) {
        super(9, bVar);
        this.this$0 = asrSseAbility;
    }

    @Override // zb.w
    public /* bridge */ /* synthetic */ Object invoke(String str, byte[] bArr, Integer num, Integer num2, Long l10, Long l11, Object obj, String str2, qb.b<? super Flow<? extends Result<? extends d.q>>> bVar) {
        return invoke(str, bArr, num.intValue(), num2.intValue(), l10.longValue(), l11.longValue(), obj, str2, (qb.b<? super Flow<Result<d.q>>>) bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        kotlin.c.b(obj);
        String str = (String) this.L$0;
        byte[] bArr = (byte[]) this.L$1;
        int i11 = this.I$0;
        int i12 = this.I$1;
        long j10 = this.J$0;
        long j11 = this.J$1;
        Object obj2 = this.L$2;
        String str2 = (String) this.L$3;
        AsrSseAbility asrSseAbility = this.this$0;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 1;
        Object objTranscribeStreamPcm = asrSseAbility.transcribeStreamPcm(str, bArr, i11, i12, j10, j11, obj2, str2, this);
        return objTranscribeStreamPcm == coroutineSingletons ? coroutineSingletons : objTranscribeStreamPcm;
    }

    public final Object invoke(String str, byte[] bArr, int i10, int i11, long j10, long j11, Object obj, String str2, qb.b<? super Flow<Result<d.q>>> bVar) {
        AsrSseAbility$streamSessions$2$1 asrSseAbility$streamSessions$2$1 = new AsrSseAbility$streamSessions$2$1(this.this$0, bVar);
        asrSseAbility$streamSessions$2$1.L$0 = str;
        asrSseAbility$streamSessions$2$1.L$1 = bArr;
        asrSseAbility$streamSessions$2$1.I$0 = i10;
        asrSseAbility$streamSessions$2$1.I$1 = i11;
        asrSseAbility$streamSessions$2$1.J$0 = j10;
        asrSseAbility$streamSessions$2$1.J$1 = j11;
        asrSseAbility$streamSessions$2$1.L$2 = obj;
        asrSseAbility$streamSessions$2$1.L$3 = str2;
        return asrSseAbility$streamSessions$2$1.invokeSuspend(lb.n.f10413a);
    }
}
