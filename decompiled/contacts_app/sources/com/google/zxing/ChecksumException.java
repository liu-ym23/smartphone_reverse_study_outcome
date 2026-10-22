package com.google.zxing;

/* JADX INFO: loaded from: classes.dex */
public final class ChecksumException extends ReaderException {
    private static final ChecksumException INSTANCE = null;

    static {
        ChecksumException r0 = new ChecksumException();
        INSTANCE = r0;
        r0.setStackTrace(NO_TRACE);
    }

    private ChecksumException() {
    }

    private ChecksumException(Throwable r1) {
        super(r1);
    }

    public static ChecksumException getChecksumInstance() {
        if (isStackTrace == false) goto L7;
        return new ChecksumException();
    L7:
        return INSTANCE;
    }

    public static ChecksumException getChecksumInstance(Throwable r1) {
        if (isStackTrace == false) goto L7;
        return new ChecksumException(r1);
    L7:
        return INSTANCE;
    }
}
