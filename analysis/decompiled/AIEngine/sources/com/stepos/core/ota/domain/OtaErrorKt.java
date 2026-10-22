package com.stepos.core.ota.domain;

import com.stepos.core.ota.domain.OtaError;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaErrorKt {
    public static final boolean requiresCleanRedownload(OtaError otaError) {
        g.f(otaError, "<this>");
        if ((otaError instanceof OtaError.Network) || (otaError instanceof OtaError.ManifestEmpty) || (otaError instanceof OtaError.Cancelled) || (otaError instanceof OtaError.Unknown) || (otaError instanceof OtaError.KeyUnavailable) || (otaError instanceof OtaError.CtaNotGranted)) {
            return false;
        }
        if ((otaError instanceof OtaError.IntegrityFailed) || (otaError instanceof OtaError.ExtractFailed) || (otaError instanceof OtaError.StorageFailed) || (otaError instanceof OtaError.EmptyPayload) || (otaError instanceof OtaError.ActivationFailed) || (otaError instanceof OtaError.InstallFailed) || (otaError instanceof OtaError.Timeout) || (otaError instanceof OtaError.DecryptFailed) || (otaError instanceof OtaError.PayloadMismatch)) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }
}
