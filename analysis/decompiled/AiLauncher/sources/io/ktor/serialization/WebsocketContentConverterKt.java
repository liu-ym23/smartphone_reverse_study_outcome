package io.ktor.serialization;

import La.C0953c;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a2\u0010\u0007\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00028\u00002\f\b\u0002\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0086H¢\u0006\u0004\b\u0007\u0010\b\u001a2\u0010\n\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00062\f\b\u0002\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0086H¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/serialization/WebsocketContentConverter;", UxipConstants.f30680s, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/websocket/Frame;", "serialize", "(Lio/ktor/serialization/WebsocketContentConverter;Ljava/lang/Object;Ljava/nio/charset/Charset;Le9/c;)Ljava/lang/Object;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "deserialize", "(Lio/ktor/serialization/WebsocketContentConverter;Lio/ktor/websocket/Frame;Ljava/nio/charset/Charset;Le9/c;)Ljava/lang/Object;", "ktor-serialization"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebsocketContentConverterKt {
    public static final /* synthetic */ <T> Object deserialize(WebsocketContentConverter websocketContentConverter, Frame frame, Charset charset, InterfaceC4014c<? super T> interfaceC4014c) {
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        Object objDeserialize = websocketContentConverter.deserialize(charset, typeInfo, frame, interfaceC4014c);
        n.c(1);
        p.o(1, ExifInterface.GPS_DIRECTION_TRUE);
        return objDeserialize;
    }

    public static /* synthetic */ Object deserialize$default(WebsocketContentConverter websocketContentConverter, Frame frame, Charset charset, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = C0953c.UTF_8;
        }
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        Object objDeserialize = websocketContentConverter.deserialize(charset, typeInfo, frame, interfaceC4014c);
        n.c(1);
        p.o(1, ExifInterface.GPS_DIRECTION_TRUE);
        return objDeserialize;
    }

    public static final /* synthetic */ <T> Object serialize(WebsocketContentConverter websocketContentConverter, T t10, Charset charset, InterfaceC4014c<? super Frame> interfaceC4014c) {
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        Object objSerialize = websocketContentConverter.serialize(charset, typeInfo, t10, interfaceC4014c);
        n.c(1);
        return objSerialize;
    }

    public static /* synthetic */ Object serialize$default(WebsocketContentConverter websocketContentConverter, Object obj, Charset charset, InterfaceC4014c interfaceC4014c, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            charset = C0953c.UTF_8;
        }
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        Object objSerialize = websocketContentConverter.serialize(charset, typeInfo, obj, interfaceC4014c);
        n.c(1);
        return objSerialize;
    }
}
