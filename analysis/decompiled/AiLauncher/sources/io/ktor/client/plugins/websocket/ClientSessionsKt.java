package io.ktor.client.plugins.websocket;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketConverterNotFoundException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.serialization.WebsocketChannelSerializationKt;
import kotlin.Metadata;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a&\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a$\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\u0006\u0010\t\u001a\"\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\n\u001a\u00028\u0000\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\u0000H\u0086H¢\u0006\u0004\b\n\u0010\f\"\u0017\u0010\u0010\u001a\u0004\u0018\u00010\r*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "", "data", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "LY8/t;", "sendSerialized", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "receiveDeserialized", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;Le9/c;)Ljava/lang/Object;", "Lio/ktor/serialization/WebsocketContentConverter;", "getConverter", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;)Lio/ktor/serialization/WebsocketContentConverter;", "converter", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClientSessionsKt {
    public static final WebsocketContentConverter getConverter(DefaultClientWebSocketSession defaultClientWebSocketSession) {
        kotlin.jvm.internal.p.i(defaultClientWebSocketSession, "<this>");
        WebSockets webSockets = (WebSockets) HttpClientPluginKt.pluginOrNull(defaultClientWebSocketSession.getCall().getClient(), WebSockets.INSTANCE);
        if (webSockets != null) {
            return webSockets.getContentConverter();
        }
        return null;
    }

    public static final <T> Object receiveDeserialized(DefaultClientWebSocketSession defaultClientWebSocketSession, TypeInfo typeInfo, InterfaceC4014c<? super T> interfaceC4014c) throws Throwable {
        WebsocketContentConverter converter = getConverter(defaultClientWebSocketSession);
        if (converter == null) {
            throw new WebsocketConverterNotFoundException("No converter was found for websocket", null, 2, null);
        }
        Object objReceiveDeserializedBase = WebsocketChannelSerializationKt.receiveDeserializedBase(defaultClientWebSocketSession, typeInfo, converter, ContentConverterKt.suitableCharset$default(defaultClientWebSocketSession.getCall().getRequest().getHeaders(), null, 1, null), interfaceC4014c);
        C4063a.g();
        return objReceiveDeserializedBase;
    }

    public static final Object sendSerialized(DefaultClientWebSocketSession defaultClientWebSocketSession, Object obj, TypeInfo typeInfo, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        WebsocketContentConverter converter = getConverter(defaultClientWebSocketSession);
        if (converter == null) {
            throw new WebsocketConverterNotFoundException("No converter was found for websocket", null, 2, null);
        }
        Object objSendSerializedBase = WebsocketChannelSerializationKt.sendSerializedBase(defaultClientWebSocketSession, obj, typeInfo, converter, ContentConverterKt.suitableCharset$default(defaultClientWebSocketSession.getCall().getRequest().getHeaders(), null, 1, null), interfaceC4014c);
        return objSendSerializedBase == C4063a.g() ? objSendSerializedBase : t.f7040a;
    }

    public static final /* synthetic */ <T> Object receiveDeserialized(DefaultClientWebSocketSession defaultClientWebSocketSession, InterfaceC4014c<? super T> interfaceC4014c) throws Throwable {
        kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
        try {
            kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        kotlin.jvm.internal.n.c(0);
        Object objReceiveDeserialized = receiveDeserialized(defaultClientWebSocketSession, typeInfo, interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objReceiveDeserialized;
    }

    public static final /* synthetic */ <T> Object sendSerialized(DefaultClientWebSocketSession defaultClientWebSocketSession, T t10, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
        try {
            kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        kotlin.jvm.internal.n.c(0);
        sendSerialized(defaultClientWebSocketSession, t10, typeInfo, interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return t.f7040a;
    }
}
