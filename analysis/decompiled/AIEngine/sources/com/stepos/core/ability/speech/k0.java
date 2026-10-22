package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.TtsPcmDownlinkBatcher;
import com.stepos.core.ability.speech.TtsStreamBinderCoordinator;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class k0 implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7303a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7304b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7305c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7306d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f7307e;

    public /* synthetic */ k0(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
        this.f7303a = i10;
        this.f7304b = obj;
        this.f7305c = obj2;
        this.f7306d = obj3;
        this.f7307e = obj4;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f7303a) {
            case 0:
                return TtsStreamBinderCoordinator.C03571.invokeSuspend$lambda$0((TtsStreamBinderCoordinator) this.f7304b, (TtsStreamBinderCoordinator.TtsCloudHolder) this.f7305c, (String) this.f7306d, (TtsPcmDownlinkBatcher.PcmBatch) this.f7307e);
            default:
                return Boolean.valueOf(AsrLocalChunkedInferencer.feedSegmentOnce$lambda$2(this.f7304b, (e7.a) this.f7305c, (c.a) this.f7306d, (AsrLocalChunkedInferencer$feedSegmentOnce$callback$1) this.f7307e));
        }
    }
}
