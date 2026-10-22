package com.stepos.config.dag.cloud;

/* loaded from: classes.dex */
public enum CloudConfigResult {
    SUCCESS(0),
    FILE_NOT_EXIST(1),
    FILE_PATH_ERROR(2),
    FILE_INCOMPLETE(3),
    FILE_IO_ERROR(4),
    VERSION_DOWNGRADE(5),
    PERMISSION_ERROR(6),
    KEY_NOT_DEFINE(7),
    INNER_ERROR(8),
    VALUE_EMPTY(9),
    VALUE_FORMAT_ERROR(10),
    UNKNOWN(99);

    private final int code;

    CloudConfigResult(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static CloudConfigResult fromCode(int code) {
        for (CloudConfigResult r : values()) {
            if (r.code == code) {
                return r;
            }
        }
        return UNKNOWN;
    }
}
