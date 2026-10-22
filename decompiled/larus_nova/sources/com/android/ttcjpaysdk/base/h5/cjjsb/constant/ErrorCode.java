package com.android.ttcjpaysdk.base.h5.cjjsb.constant;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/constant/ErrorCode;", "", "()V", ErrorCode.CLOSED, "", "EXPOSURE_LIBRA_EXPERIMENT", "FAIL", ErrorCode.INIT, "LIBRA_EXPERIMENT_KEY", "PROCESSING", ErrorCode.REEXCHANGE, ErrorCode.REVIEWING, "STATUS_ALREADY_ACTIVE", "SUCCESS", "TIMEOUT", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ErrorCode {
    public static final String CLOSED = "CLOSED";
    public static final String EXPOSURE_LIBRA_EXPERIMENT = "exposureLibraExperiment";
    public static final String FAIL = "FAIL";
    public static final String INIT = "INIT";
    public static final ErrorCode INSTANCE = null;
    public static final String LIBRA_EXPERIMENT_KEY = "libraExperimentKey";
    public static final String PROCESSING = "PROCESSING";
    public static final String REEXCHANGE = "REEXCHANGE";
    public static final String REVIEWING = "REVIEWING";
    public static final String STATUS_ALREADY_ACTIVE = "1";
    public static final String SUCCESS = "SUCCESS";
    public static final String TIMEOUT = "TIMEOUT";

    static {
        INSTANCE = new ErrorCode();
    }

    private ErrorCode() {
    }
}
