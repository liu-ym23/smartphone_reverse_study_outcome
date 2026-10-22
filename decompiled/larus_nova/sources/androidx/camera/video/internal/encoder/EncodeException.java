package androidx.camera.video.internal.encoder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class EncodeException extends Exception {
    public static final int ERROR_CODEC = 1;
    public static final int ERROR_UNKNOWN = 0;
    private final int mErrorType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorType {
    }

    public int getErrorType() {
        return this.mErrorType;
    }

    public EncodeException(int r100, String r101, Throwable r102) {
        super(r101, r102);
        this.mErrorType = r100;
    }
}
