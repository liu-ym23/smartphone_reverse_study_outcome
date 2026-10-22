package okhttp3.internal.http2;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class StreamResetException extends IOException {
    public final ErrorCode errorCode;

    public StreamResetException(ErrorCode r10) {
        super("stream was reset: " + r10);
        this.errorCode = r10;
    }
}
