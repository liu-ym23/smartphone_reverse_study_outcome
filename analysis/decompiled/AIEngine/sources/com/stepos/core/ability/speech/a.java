package com.stepos.core.ability.speech;

import android.os.SystemClock;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7238a;

    public /* synthetic */ a(int i10) {
        this.f7238a = i10;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f7238a) {
            case 0:
                return AsrAbility.createCloudWsSession$lambda$10();
            case 1:
                return lb.n.f10413a;
            case 2:
                return AsrFileAbility.vadGate_delegate$lambda$8();
            case 3:
                return Boolean.valueOf(CloudNetworkWatcher.awaitValidated$lambda$5());
            case 4:
                return lb.n.f10413a;
            case 5:
                return TtsPcmDumpSink.closeAll$lambda$10();
            case 6:
                return TtsPcmDumpSink.executor_delegate$lambda$3();
            default:
                return Long.valueOf(SystemClock.elapsedRealtime());
        }
    }
}
