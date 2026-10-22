package com.bytedance.android.live.ai.api.anchor.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes45.dex */
public class RecognizeException extends Exception {
    private int code;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RecognizeExceptionCode {
        public static final int CODE_ENGINE_ERROR = 1;
        public static final int CODE_PARSE_RESULT_FAILED = 2;
        public static final int CODE_UNKNOWN = 0;
    }

    public int getCode() {
        return this.code;
    }

    public RecognizeException(int r100, String r101) {
        this(r100, r101, null);
    }

    public RecognizeException(int r100, String r101, Throwable r102) {
        super(r101, r102);
        this.code = r100;
    }
}
