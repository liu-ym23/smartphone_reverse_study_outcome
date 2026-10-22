package com.stepos.core.ota.push;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AutoUpdateEnvKt {
    public static final boolean isChargingState(int i10, int i11) {
        return i10 != 0 || i11 == 2 || i11 == 5;
    }
}
