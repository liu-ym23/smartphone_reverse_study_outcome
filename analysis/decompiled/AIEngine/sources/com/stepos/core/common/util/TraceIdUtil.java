package com.stepos.core.common.util;

import gc.o;
import java.util.UUID;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TraceIdUtil {
    public static final TraceIdUtil INSTANCE = new TraceIdUtil();

    private TraceIdUtil() {
    }

    public final String newTraceId() {
        String string = UUID.randomUUID().toString();
        g.e(string, "toString(...)");
        return o.i0(string, "-", "");
    }
}
