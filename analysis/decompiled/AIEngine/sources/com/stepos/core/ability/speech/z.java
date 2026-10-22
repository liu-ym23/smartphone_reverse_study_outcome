package com.stepos.core.ability.speech;

import com.stepos.core.ota.deepbinder.OtaInteractiveDownloadFlow;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class z implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7361a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7362b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7363c;

    public /* synthetic */ z(int i10, String str, String str2) {
        this.f7361a = i10;
        this.f7362b = str;
        this.f7363c = str2;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f7361a) {
            case 0:
                return TtsPcmDumpSink.feedText$lambda$7(this.f7362b, this.f7363c);
            default:
                return OtaInteractiveDownloadFlow.requestStartUpdate$lambda$7(this.f7362b, this.f7363c);
        }
    }
}
