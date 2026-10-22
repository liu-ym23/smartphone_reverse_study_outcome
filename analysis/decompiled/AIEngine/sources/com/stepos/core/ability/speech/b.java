package com.stepos.core.ability.speech;

import android.os.SystemClock;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7245a;

    public /* synthetic */ b(int i10) {
        this.f7245a = i10;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f7245a) {
            case 0:
                return AsrAbility.vadGate_delegate$lambda$9();
            case 1:
                return AsrRealtimeAbility.createCloudWsSession$lambda$0();
            case 2:
                return Boolean.valueOf(CloudNetworkWatcher.awaitHasInternet$lambda$6());
            case 3:
                return Boolean.valueOf(SpeechCloudOrchestrator._init_$lambda$0());
            case 4:
                return Long.valueOf(SystemClock.elapsedRealtime());
            default:
                return TtsStreamAbility.createCloudWsSession$lambda$2();
        }
    }
}
