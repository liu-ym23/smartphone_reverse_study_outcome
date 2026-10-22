package com.stepos.core.ota.domain.port;

import java.io.IOException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PayloadDecryptException extends IOException {
    public /* synthetic */ PayloadDecryptException(String str, Throwable th, int i10, e eVar) {
        this(str, (i10 & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayloadDecryptException(String message, Throwable th) {
        super(message, th);
        g.f(message, "message");
    }
}
