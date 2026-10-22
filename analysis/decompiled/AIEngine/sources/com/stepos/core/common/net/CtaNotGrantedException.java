package com.stepos.core.common.net;

import java.io.IOException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CtaNotGrantedException extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CtaNotGrantedException(String message) {
        super(message);
        g.f(message, "message");
    }
}
