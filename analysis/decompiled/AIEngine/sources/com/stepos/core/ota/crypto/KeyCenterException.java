package com.stepos.core.ota.crypto;

import java.io.IOException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KeyCenterException extends IOException {
    public static final int CODE_NOT_REGISTERED = 404;
    public static final Companion Companion = new Companion(null);
    private final int code;
    private final int httpCode;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyCenterException(int i10, int i11, String message) {
        super(message);
        g.f(message, "message");
        this.code = i10;
        this.httpCode = i11;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getHttpCode() {
        return this.httpCode;
    }

    public final boolean isNotRegistered() {
        return this.code == 404 || this.httpCode == 404;
    }

    public final boolean isTransient() {
        int i10 = this.httpCode;
        return i10 == 429 || i10 >= 500;
    }
}
