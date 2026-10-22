package com.stepos.aiengine.flow;

import com.stepos.core.download.ModelFlowMeta;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/stepos/aiengine/flow/ModelFlowError;", "", "<init>", "()V", "CTA_DENIED", "", "USER_CANCELED_DOWNLOAD", "USER_CANCELED_CELLULAR", "USER_CANCELED_UPDATE", "USER_CANCELED_WIFI_GUIDE", "USER_WIFI_AUTO_ONLY", "USER_CANCELED_SERVICE_GUIDE", ModelFlowMeta.PLAN_NO_NETWORK, "ALREADY_UP_TO_DATE", "MODEL_NOT_INSTALLED", "TASK_ALREADY_ACTIVE", "MODEL_NOT_AVAILABLE", "LOW_BATTERY", "INSUFFICIENT_MEMORY", "SERVICE_DISABLED", "DOWNLOAD_ENQUEUE_FAILED", "DOWNLOAD_ERROR", "INSTALL_ERROR", "DOWNLOAD_SCHEDULED", "NEED_DOWNLOAD_SUPPRESSED", "SERVICE_ENABLE_GUIDED", "SERVICE_UNAVAILABLE", "CONFIRM_UI_UNAVAILABLE", "isUserCanceled", "", "code", "isDeferred", "isRetryable", "isHandledBySdk", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ModelFlowError {
    public static final int ALREADY_UP_TO_DATE = 5003;
    public static final int CONFIRM_UI_UNAVAILABLE = 5902;
    public static final int CTA_DENIED = 4001;
    public static final int DOWNLOAD_ENQUEUE_FAILED = 5101;
    public static final int DOWNLOAD_ERROR = 5102;
    public static final int DOWNLOAD_SCHEDULED = 6001;
    public static final int INSTALL_ERROR = 5103;
    public static final ModelFlowError INSTANCE = new ModelFlowError();
    public static final int INSUFFICIENT_MEMORY = 5021;
    public static final int LOW_BATTERY = 5020;
    public static final int MODEL_NOT_AVAILABLE = 5006;
    public static final int MODEL_NOT_INSTALLED = 5004;
    public static final int NEED_DOWNLOAD_SUPPRESSED = 6002;
    public static final int NO_NETWORK = 5001;
    public static final int SERVICE_DISABLED = 5022;
    public static final int SERVICE_ENABLE_GUIDED = 6003;
    public static final int SERVICE_UNAVAILABLE = 5901;
    public static final int TASK_ALREADY_ACTIVE = 5005;
    public static final int USER_CANCELED_CELLULAR = 4003;
    public static final int USER_CANCELED_DOWNLOAD = 4002;
    public static final int USER_CANCELED_SERVICE_GUIDE = 4007;
    public static final int USER_CANCELED_UPDATE = 4004;
    public static final int USER_CANCELED_WIFI_GUIDE = 4005;
    public static final int USER_WIFI_AUTO_ONLY = 4006;

    public final boolean isDeferred(int code) {
        return 6001 <= code && code < 6100;
    }

    public final boolean isHandledBySdk(int code) {
        return isUserCanceled(code) || isDeferred(code) || code == 5020 || code == 5021 || code == 5022;
    }

    public final boolean isRetryable(int code) {
        if (code == 5001 || code == 5005 || code == 5020 || code == 5021 || code == 5901 || code == 5902) {
            return true;
        }
        switch (code) {
            case DOWNLOAD_ENQUEUE_FAILED /* 5101 */:
            case DOWNLOAD_ERROR /* 5102 */:
            case INSTALL_ERROR /* 5103 */:
                return true;
            default:
                return false;
        }
    }

    public final boolean isUserCanceled(int code) {
        return 4001 <= code && code < 4100;
    }
}
