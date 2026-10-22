package com.stepos.core.ability.speech;

import java.util.Map;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7276a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7277b;

    public /* synthetic */ g(Object obj, int i10) {
        this.f7276a = i10;
        this.f7277b = obj;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        int i10 = this.f7276a;
        Object obj2 = this.f7277b;
        switch (i10) {
            case 0:
                return AsrFileCloudClient.submitTask_BWLJW6A$lambda$2((Ref$ObjectRef) obj2, (Map) obj);
            default:
                return TtsCloudWsSession.awaitSentencePipelineBefore$lambda$24((TtsCloudWsSession) obj2, ((Integer) obj).intValue());
        }
    }
}
