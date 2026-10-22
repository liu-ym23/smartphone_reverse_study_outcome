package com.obric.capabilitykit.entity;

/* JADX INFO: loaded from: classes4.dex */
public final class ResultCode {
    public static final int ERROR_CREDENTIAL_ENCRYPTED_STORAGE_LOCKED = 305;
    public static final int ERROR_DONATE_TEMPORARY_FAILED = 303;
    public static final int ERROR_EMPTY_ENTITY = 301;
    public static final int ERROR_MEMORY_SERVICE_DISABLED = 306;
    public static final int ERROR_MULTI_DETAIL = 304;
    public static final int ERROR_PERMISSION_DENIED = 111;
    public static final int ERROR_UNSUPPORTED_ENTITY = 302;
    public static final ResultCode INSTANCE = null;
    public static final int INTERNAL_ERROR = 501;
    public static final int OK = 0;

    static {
        INSTANCE = new ResultCode();
    }

    private ResultCode() {
    }
}
