package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7313a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AsrPcmDumpSink f7314b;

    public /* synthetic */ m(AsrPcmDumpSink asrPcmDumpSink, int i10) {
        this.f7313a = i10;
        this.f7314b = asrPcmDumpSink;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7313a;
        AsrPcmDumpSink asrPcmDumpSink = this.f7314b;
        switch (i10) {
            case 0:
                return AsrPcmDumpSink.executor_delegate$lambda$3(asrPcmDumpSink);
            default:
                return AsrPcmDumpSink.closeAll$lambda$9(asrPcmDumpSink);
        }
    }
}
