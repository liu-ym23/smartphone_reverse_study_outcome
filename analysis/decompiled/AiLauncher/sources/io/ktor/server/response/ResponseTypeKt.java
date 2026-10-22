package io.ktor.server.response;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003\",\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00018F@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lio/ktor/util/AttributeKey;", "Lio/ktor/util/reflect/TypeInfo;", "ResponseTypeAttributeKey", "Lio/ktor/util/AttributeKey;", "Lio/ktor/server/response/ApplicationResponse;", UxipConstants.f30680s, "getResponseType", "(Lio/ktor/server/response/ApplicationResponse;)Lio/ktor/util/reflect/TypeInfo;", "setResponseType", "(Lio/ktor/server/response/ApplicationResponse;Lio/ktor/util/reflect/TypeInfo;)V", "responseType", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResponseTypeKt {
    private static final AttributeKey<TypeInfo> ResponseTypeAttributeKey;

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = t.b(TypeInfo.class);
        try {
            interfaceC5755nM = t.m(TypeInfo.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        ResponseTypeAttributeKey = new AttributeKey<>("ResponseTypeAttributeKey", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    public static final TypeInfo getResponseType(ApplicationResponse applicationResponse) {
        p.i(applicationResponse, "<this>");
        return (TypeInfo) applicationResponse.getCall().getAttributes().getOrNull(ResponseTypeAttributeKey);
    }

    @InternalAPI
    public static final void setResponseType(ApplicationResponse applicationResponse, TypeInfo typeInfo) {
        p.i(applicationResponse, "<this>");
        if (typeInfo != null) {
            applicationResponse.getCall().getAttributes().put(ResponseTypeAttributeKey, typeInfo);
        } else {
            applicationResponse.getCall().getAttributes().remove(ResponseTypeAttributeKey);
        }
    }
}
