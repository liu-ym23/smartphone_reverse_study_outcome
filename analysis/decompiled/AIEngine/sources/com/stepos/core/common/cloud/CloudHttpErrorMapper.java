package com.stepos.core.common.cloud;

import com.stepos.core.ability.speech.AsrCloudWsSession;
import com.stepos.core.error.AIEngineError;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudHttpErrorMapper {
    public static final CloudHttpErrorMapper INSTANCE = new CloudHttpErrorMapper();

    private CloudHttpErrorMapper() {
    }

    public final boolean isAuthFailure(Integer num) {
        if (num != null && num.intValue() == 401) {
            return true;
        }
        return num != null && num.intValue() == 403;
    }

    public final boolean shouldInvalidateUserToken(Integer num) {
        return num != null && num.intValue() == 401;
    }

    public final int toErrorCode(Integer num) {
        int iIntValue;
        if (num != null && num.intValue() == 400) {
            return AIEngineError.CLOUD_INVALID_REQUEST;
        }
        if (num != null && num.intValue() == 401) {
            return AIEngineError.CLOUD_AUTH_FAILED;
        }
        if (num != null && num.intValue() == 403) {
            return AIEngineError.CLOUD_AUTH_FAILED;
        }
        if (num != null && num.intValue() == 402) {
            return AIEngineError.CLOUD_INSUFFICIENT_BALANCE;
        }
        if (num != null && num.intValue() == 404) {
            return AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED;
        }
        if (num != null && num.intValue() == 429) {
            return AIEngineError.CLOUD_QUOTA_EXCEEDED;
        }
        if (num != null && num.intValue() == 451) {
            return AIEngineError.CLOUD_RISK_BLOCKED;
        }
        dc.e eVar = new dc.e(AsrCloudWsSession.SILENCE_TAIL_MARGIN_MS, 499, 1);
        if (num != null && 400 <= (iIntValue = num.intValue()) && iIntValue <= eVar.f8452b) {
            return AIEngineError.CLOUD_INVALID_REQUEST;
        }
        new dc.e(500, 599, 1);
        return AIEngineError.CLOUD_SERVER_ERROR;
    }
}
