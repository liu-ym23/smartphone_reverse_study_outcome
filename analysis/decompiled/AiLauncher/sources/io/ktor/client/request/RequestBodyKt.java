package io.ktor.client.request;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a$\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\t\" \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/request/HttpRequestBuilder;", "body", "LY8/t;", "setBody", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Object;)V", "", "Lio/ktor/util/reflect/TypeInfo;", "bodyType", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;)V", "Lio/ktor/util/AttributeKey;", "BodyTypeAttributeKey", "Lio/ktor/util/AttributeKey;", "getBodyTypeAttributeKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RequestBodyKt {
    private static final AttributeKey<TypeInfo> BodyTypeAttributeKey;

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(TypeInfo.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(TypeInfo.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        BodyTypeAttributeKey = new AttributeKey<>("BodyTypeAttributeKey", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    public static final AttributeKey<TypeInfo> getBodyTypeAttributeKey() {
        return BodyTypeAttributeKey;
    }

    public static final /* synthetic */ <T> void setBody(HttpRequestBuilder httpRequestBuilder, T t10) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        if (t10 == null) {
            httpRequestBuilder.setBody(NullBody.INSTANCE);
            kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
            InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
            try {
                kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
            } catch (Throwable unused) {
            }
            httpRequestBuilder.setBodyType(new TypeInfo(interfaceC5745dB, null));
            return;
        }
        if (t10 instanceof OutgoingContent) {
            httpRequestBuilder.setBody(t10);
            httpRequestBuilder.setBodyType(null);
            return;
        }
        httpRequestBuilder.setBody(t10);
        kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB2 = kotlin.jvm.internal.t.b(Object.class);
        try {
            kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused2) {
        }
        httpRequestBuilder.setBodyType(new TypeInfo(interfaceC5745dB2, null));
    }

    public static final void setBody(HttpRequestBuilder httpRequestBuilder, Object obj, TypeInfo bodyType) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        kotlin.jvm.internal.p.i(bodyType, "bodyType");
        if (obj == null) {
            obj = NullBody.INSTANCE;
        }
        httpRequestBuilder.setBody(obj);
        httpRequestBuilder.setBodyType(bodyType);
    }
}
