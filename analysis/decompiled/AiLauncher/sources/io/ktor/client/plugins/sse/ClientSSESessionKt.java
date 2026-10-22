package io.ktor.client.plugins.sse;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.sse.TypedServerSentEvent;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a,\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/plugins/sse/SSESessionWithDeserialization;", "", "data", "deserialize", "(Lio/ktor/client/plugins/sse/SSESessionWithDeserialization;Ljava/lang/String;)Ljava/lang/Object;", "Lio/ktor/sse/TypedServerSentEvent;", "event", "(Lio/ktor/client/plugins/sse/SSESessionWithDeserialization;Lio/ktor/sse/TypedServerSentEvent;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClientSSESessionKt {
    public static final /* synthetic */ <T> T deserialize(SSESessionWithDeserialization sSESessionWithDeserialization, String str) {
        kotlin.jvm.internal.p.i(sSESessionWithDeserialization, "<this>");
        if (str == null) {
            return null;
        }
        p9.p<TypeInfo, String, Object> deserializer = sSESessionWithDeserialization.getDeserializer();
        kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
        try {
            kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        T t10 = (T) deserializer.invoke(new TypeInfo(interfaceC5745dB, null), str);
        kotlin.jvm.internal.p.o(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t10;
    }

    public static final /* synthetic */ <T> T deserialize(SSESessionWithDeserialization sSESessionWithDeserialization, TypedServerSentEvent<String> event) {
        kotlin.jvm.internal.p.i(sSESessionWithDeserialization, "<this>");
        kotlin.jvm.internal.p.i(event, "event");
        String data = event.getData();
        if (data == null) {
            return null;
        }
        p9.p<TypeInfo, String, Object> deserializer = sSESessionWithDeserialization.getDeserializer();
        kotlin.jvm.internal.p.o(4, "T?");
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
        try {
            kotlin.jvm.internal.p.o(6, "T?");
        } catch (Throwable unused) {
        }
        T t10 = (T) deserializer.invoke(new TypeInfo(interfaceC5745dB, null), data);
        kotlin.jvm.internal.p.o(2, "T?");
        return t10;
    }
}
