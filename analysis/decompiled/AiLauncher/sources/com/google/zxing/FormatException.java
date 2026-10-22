package com.google.zxing;

/* loaded from: classes2.dex */
public final class FormatException extends ReaderException {

    /* renamed from: c, reason: collision with root package name */
    public static final FormatException f21810c;

    static {
        FormatException formatException = new FormatException();
        f21810c = formatException;
        formatException.setStackTrace(ReaderException.f21812b);
    }

    private FormatException() {
    }

    public static FormatException a() {
        return ReaderException.f21811a ? new FormatException() : f21810c;
    }
}
