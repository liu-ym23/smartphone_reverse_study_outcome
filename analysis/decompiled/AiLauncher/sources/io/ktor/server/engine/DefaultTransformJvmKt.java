package io.ktor.server.engine;

import Ua.Y;
import e9.InterfaceC4014c;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.cio.CIOMultipartDataBase;
import io.ktor.http.cio.internals.UnsupportedMediaTypeExceptionCIO;
import io.ktor.http.content.MultiPartData;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.application.PipelineCallKt;
import io.ktor.server.plugins.UnsupportedMediaTypeException;
import io.ktor.server.request.ApplicationReceiveFunctionsKt;
import io.ktor.server.request.ApplicationRequestPropertiesKt;
import io.ktor.server.request.PipelineRequest;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import io.ktor.utils.io.streams.StreamsKt;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\t\u001a\u00020\b*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u0010\u001a\u00020\u000f*\u00020\u000b2\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/server/application/PipelineCall;", "query", "defaultPlatformTransformations", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "rc", "Lio/ktor/http/content/MultiPartData;", "multiPartData", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/utils/io/ByteReadChannel;)Lio/ktor/http/content/MultiPartData;", "Lfb/v;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "", "readTextWithCustomCharset", "(Lfb/v;Ljava/nio/charset/Charset;)Ljava/lang/String;", "channel", "Ljava/io/InputStream;", "receiveGuardedInputStream", "(Lio/ktor/utils/io/ByteReadChannel;)Ljava/io/InputStream;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultTransformJvmKt {
    public static final Object defaultPlatformTransformations(PipelineContext<Object, PipelineCall> pipelineContext, Object obj, InterfaceC4014c<Object> interfaceC4014c) {
        ByteReadChannel byteReadChannel = obj instanceof ByteReadChannel ? (ByteReadChannel) obj : null;
        if (byteReadChannel == null) {
            return null;
        }
        InterfaceC5745d<?> type = PipelineCallKt.getReceiveType(pipelineContext.getContext()).getType();
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(InputStream.class))) {
            return receiveGuardedInputStream(byteReadChannel);
        }
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(MultiPartData.class))) {
            return multiPartData(pipelineContext, byteReadChannel);
        }
        return null;
    }

    public static final MultiPartData multiPartData(PipelineContext<?, PipelineCall> pipelineContext, ByteReadChannel rc2) {
        kotlin.jvm.internal.p.i(pipelineContext, "<this>");
        kotlin.jvm.internal.p.i(rc2, "rc");
        PipelineRequest request = pipelineContext.getContext().getRequest();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        String strHeader = ApplicationRequestPropertiesKt.header(request, httpHeaders.getContentType());
        if (strHeader == null) {
            throw new UnsupportedMediaTypeException(null);
        }
        String strHeader2 = ApplicationRequestPropertiesKt.header(pipelineContext.getContext().getRequest(), httpHeaders.getContentLength());
        try {
            return new CIOMultipartDataBase(pipelineContext.getCoroutineContext().plus(Y.d()), rc2, strHeader, strHeader2 != null ? Long.valueOf(Long.parseLong(strHeader2)) : null, ApplicationReceiveFunctionsKt.getFormFieldLimit(pipelineContext.getContext()));
        } catch (UnsupportedMediaTypeExceptionCIO unused) {
            throw new UnsupportedMediaTypeException(ContentType.INSTANCE.parse(strHeader));
        }
    }

    public static final String readTextWithCustomCharset(fb.v vVar, Charset charset) {
        kotlin.jvm.internal.p.i(vVar, "<this>");
        kotlin.jvm.internal.p.i(charset, "charset");
        return l9.m.e(new InputStreamReader(StreamsKt.inputStream(vVar), charset));
    }

    private static final InputStream receiveGuardedInputStream(ByteReadChannel byteReadChannel) {
        return BlockingKt.toInputStream$default(byteReadChannel, null, 1, null);
    }
}
