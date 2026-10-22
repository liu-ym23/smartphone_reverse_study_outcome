package io.ktor.serialization;

import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096@¢\u0006\u0004\b\t\u0010\nJ.\u0010\f\u001a\u0004\u0018\u00010\u00012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bH¦@¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lio/ktor/serialization/WebsocketContentConverter;", "", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", UxipConstants.f30680s, "Lio/ktor/websocket/Frame;", "serialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/websocket/Frame;Le9/c;)Ljava/lang/Object;", "frame", "", "isApplicable", "(Lio/ktor/websocket/Frame;)Z", "ktor-serialization"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface WebsocketContentConverter {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object serialize(WebsocketContentConverter websocketContentConverter, Charset charset, TypeInfo typeInfo, Object obj, InterfaceC4014c<? super Frame> interfaceC4014c) {
            return WebsocketContentConverter.super.serialize(charset, typeInfo, obj, interfaceC4014c);
        }
    }

    static /* synthetic */ Object serialize$suspendImpl(WebsocketContentConverter websocketContentConverter, Charset charset, TypeInfo typeInfo, Object obj, InterfaceC4014c<? super Frame> interfaceC4014c) {
        p.f(obj);
        return websocketContentConverter.serialize(charset, typeInfo, obj, interfaceC4014c);
    }

    Object deserialize(Charset charset, TypeInfo typeInfo, Frame frame, InterfaceC4014c<Object> interfaceC4014c);

    boolean isApplicable(Frame frame);

    default Object serialize(Charset charset, TypeInfo typeInfo, Object obj, InterfaceC4014c<? super Frame> interfaceC4014c) {
        return serialize$suspendImpl(this, charset, typeInfo, obj, interfaceC4014c);
    }
}
