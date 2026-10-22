package com.stepos.core.ota.data;

import com.stepos.core.ota.domain.OtaState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadStateKt {
    public static final int toDownloadStateCode(OtaState otaState) {
        g.f(otaState, "<this>");
        if (otaState instanceof OtaState.Idle) {
            return 0;
        }
        if ((otaState instanceof OtaState.Queued) || (otaState instanceof OtaState.Checking)) {
            return 1;
        }
        if (otaState instanceof OtaState.Downloading) {
            return 2;
        }
        if ((otaState instanceof OtaState.Verifying) || (otaState instanceof OtaState.Installing) || (otaState instanceof OtaState.Activating)) {
            return 5;
        }
        if (otaState instanceof OtaState.Installed) {
            return 6;
        }
        if (otaState instanceof OtaState.Paused) {
            return 4;
        }
        if (otaState instanceof OtaState.Failed) {
            return 3;
        }
        if (otaState instanceof OtaState.Removed) {
            return 7;
        }
        throw new NoWhenBranchMatchedException();
    }
}
