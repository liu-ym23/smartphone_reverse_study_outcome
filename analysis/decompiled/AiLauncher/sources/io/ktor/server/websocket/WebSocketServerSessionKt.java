package io.ktor.server.websocket;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.http.ContentType;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketConverterNotFoundException;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.ApplicationPluginKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.WebSocketSession;
import io.ktor.websocket.serialization.WebsocketChannelSerializationKt;
import kotlin.Metadata;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a&\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a$\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\u0006\u0010\t\u001a\"\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\n\u001a\u00028\u0000\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\u0000H\u0086H¢\u0006\u0004\b\n\u0010\f\u001a\u001b\u0010\u0010\u001a\u00020\u0000*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0010\u001a\u00020\u0013*\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0014\"\u0015\u0010\u0018\u001a\u00020\u0015*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lio/ktor/server/websocket/WebSocketServerSession;", "", "data", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "LY8/t;", "sendSerialized", "(Lio/ktor/server/websocket/WebSocketServerSession;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "(Lio/ktor/server/websocket/WebSocketServerSession;Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "receiveDeserialized", "(Lio/ktor/server/websocket/WebSocketServerSession;Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", "(Lio/ktor/server/websocket/WebSocketServerSession;Le9/c;)Ljava/lang/Object;", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/server/application/ApplicationCall;", "call", "toServerSession", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/server/application/ApplicationCall;)Lio/ktor/server/websocket/WebSocketServerSession;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/server/websocket/DefaultWebSocketServerSession;", "(Lio/ktor/websocket/DefaultWebSocketSession;Lio/ktor/server/application/ApplicationCall;)Lio/ktor/server/websocket/DefaultWebSocketServerSession;", "Lio/ktor/server/application/Application;", "getApplication", "(Lio/ktor/server/websocket/WebSocketServerSession;)Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "Lio/ktor/serialization/WebsocketContentConverter;", "getConverter", "(Lio/ktor/server/websocket/WebSocketServerSession;)Lio/ktor/serialization/WebsocketContentConverter;", "converter", "ktor-server-websockets"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebSocketServerSessionKt {
    public static final Application getApplication(WebSocketServerSession webSocketServerSession) {
        p.i(webSocketServerSession, "<this>");
        return webSocketServerSession.getCall().getApplication();
    }

    public static final WebsocketContentConverter getConverter(WebSocketServerSession webSocketServerSession) {
        p.i(webSocketServerSession, "<this>");
        return ((WebSockets) ApplicationPluginKt.plugin(getApplication(webSocketServerSession), WebSockets.INSTANCE)).getContentConverter();
    }

    public static final <T> Object receiveDeserialized(WebSocketServerSession webSocketServerSession, TypeInfo typeInfo, InterfaceC4014c<? super T> interfaceC4014c) throws Throwable {
        WebsocketContentConverter converter = getConverter(webSocketServerSession);
        if (converter == null) {
            throw new WebsocketConverterNotFoundException("No converter was found for websocket", null, 2, null);
        }
        Object objReceiveDeserializedBase = WebsocketChannelSerializationKt.receiveDeserializedBase(webSocketServerSession, typeInfo, converter, ContentConverterKt.suitableCharset$default(webSocketServerSession.getCall().getRequest().getHeaders(), null, 1, null), interfaceC4014c);
        C4063a.g();
        return objReceiveDeserializedBase;
    }

    public static final Object sendSerialized(WebSocketServerSession webSocketServerSession, Object obj, TypeInfo typeInfo, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        WebsocketContentConverter converter = getConverter(webSocketServerSession);
        if (converter == null) {
            throw new WebsocketConverterNotFoundException("No converter was found for websocket", null, 2, null);
        }
        Object objSendSerializedBase = WebsocketChannelSerializationKt.sendSerializedBase(webSocketServerSession, obj, typeInfo, converter, ContentConverterKt.suitableCharset$default(webSocketServerSession.getCall().getRequest().getHeaders(), null, 1, null), interfaceC4014c);
        return objSendSerializedBase == C4063a.g() ? objSendSerializedBase : t.f7040a;
    }

    public static final WebSocketServerSession toServerSession(WebSocketSession webSocketSession, ApplicationCall call) {
        p.i(webSocketSession, "<this>");
        p.i(call, "call");
        return new DelegatedWebSocketServerSession(call, webSocketSession);
    }

    public static final DefaultWebSocketServerSession toServerSession(DefaultWebSocketSession defaultWebSocketSession, ApplicationCall call) {
        p.i(defaultWebSocketSession, "<this>");
        p.i(call, "call");
        return new DelegatedDefaultWebSocketServerSession(call, defaultWebSocketSession);
    }

    public static final /* synthetic */ <T> Object receiveDeserialized(WebSocketServerSession webSocketServerSession, InterfaceC4014c<? super T> interfaceC4014c) throws Throwable {
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        Object objReceiveDeserialized = receiveDeserialized(webSocketServerSession, typeInfo, interfaceC4014c);
        n.c(1);
        return objReceiveDeserialized;
    }

    public static final /* synthetic */ <T> Object sendSerialized(WebSocketServerSession webSocketServerSession, T t10, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        sendSerialized(webSocketServerSession, t10, typeInfo, interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }
}
