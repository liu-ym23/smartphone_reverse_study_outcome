package fi.iki.elonen;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class NanoHTTPD$ResponseException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final NanoHTTPD$Response$Status f4453a;

    public NanoHTTPD$ResponseException(NanoHTTPD$Response$Status nanoHTTPD$Response$Status, String str) {
        super(str);
        this.f4453a = nanoHTTPD$Response$Status;
    }

    public final NanoHTTPD$Response$Status a() {
        return this.f4453a;
    }

    public NanoHTTPD$ResponseException(String str, IOException iOException) {
        super(str, iOException);
        this.f4453a = NanoHTTPD$Response$Status.INTERNAL_ERROR;
    }
}
