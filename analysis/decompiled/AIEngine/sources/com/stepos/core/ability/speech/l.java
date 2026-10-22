package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7308a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7309b;

    public /* synthetic */ l(String str, int i10) {
        this.f7308a = i10;
        this.f7309b = str;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7308a;
        String str = this.f7309b;
        switch (i10) {
            case 0:
                return AsrMultiFilesPipeline.drainCloudPending$lambda$2(str);
            default:
                return TtsPcmDumpSink.close$lambda$8(str);
        }
    }
}
