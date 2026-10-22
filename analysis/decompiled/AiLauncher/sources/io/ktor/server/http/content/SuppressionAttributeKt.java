package io.ktor.server.http.content;

import io.ktor.server.application.ApplicationCall;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\"&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\" \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u001b\u0010\u000f\u001a\u00020\u0006*\u00020\u00008F¢\u0006\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0012\u001a\u00020\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lio/ktor/server/application/ApplicationCall;", "LY8/t;", "suppressCompression", "(Lio/ktor/server/application/ApplicationCall;)V", "suppressDecompression", "Lio/ktor/util/AttributeKey;", "", "SuppressionAttribute", "Lio/ktor/util/AttributeKey;", "getSuppressionAttribute", "()Lio/ktor/util/AttributeKey;", "getSuppressionAttribute$annotations", "()V", "DecompressionSuppressionAttribute", "getDecompressionSuppressionAttribute", "isCompressionSuppressed", "(Lio/ktor/server/application/ApplicationCall;)Z", "isCompressionSuppressed$annotations", "isDecompressionSuppressed", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SuppressionAttributeKt {
    private static final AttributeKey<Boolean> DecompressionSuppressionAttribute;
    private static final AttributeKey<Boolean> SuppressionAttribute;

    static {
        InterfaceC5755n interfaceC5755nM;
        Class cls = Boolean.TYPE;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Boolean.class);
        InterfaceC5755n interfaceC5755nM2 = null;
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(cls);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        SuppressionAttribute = new AttributeKey<>("preventCompression", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        InterfaceC5745d interfaceC5745dB2 = kotlin.jvm.internal.t.b(Boolean.class);
        try {
            interfaceC5755nM2 = kotlin.jvm.internal.t.m(cls);
        } catch (Throwable unused2) {
        }
        DecompressionSuppressionAttribute = new AttributeKey<>("preventDecompression", new TypeInfo(interfaceC5745dB2, interfaceC5755nM2));
    }

    public static final AttributeKey<Boolean> getDecompressionSuppressionAttribute() {
        return DecompressionSuppressionAttribute;
    }

    public static final AttributeKey<Boolean> getSuppressionAttribute() {
        return SuppressionAttribute;
    }

    public static /* synthetic */ void getSuppressionAttribute$annotations() {
    }

    public static final boolean isCompressionSuppressed(ApplicationCall applicationCall) {
        kotlin.jvm.internal.p.i(applicationCall, "<this>");
        return applicationCall.getAttributes().contains(SuppressionAttribute);
    }

    public static /* synthetic */ void isCompressionSuppressed$annotations(ApplicationCall applicationCall) {
    }

    public static final boolean isDecompressionSuppressed(ApplicationCall applicationCall) {
        kotlin.jvm.internal.p.i(applicationCall, "<this>");
        return applicationCall.getAttributes().contains(DecompressionSuppressionAttribute);
    }

    public static final void suppressCompression(ApplicationCall applicationCall) {
        kotlin.jvm.internal.p.i(applicationCall, "<this>");
        applicationCall.getAttributes().put(SuppressionAttribute, Boolean.TRUE);
    }

    public static final void suppressDecompression(ApplicationCall applicationCall) {
        kotlin.jvm.internal.p.i(applicationCall, "<this>");
        applicationCall.getAttributes().put(DecompressionSuppressionAttribute, Boolean.TRUE);
    }
}
