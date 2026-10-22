package io.ktor.server.http.content;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.StringValuesKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import v9.C5683l;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\fJ)\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000e*\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0015\u001a\u00020\u0014\"\b\b\u0000\u0010\u000e*\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0017R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lio/ktor/server/http/content/PreCompressedResponse;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "original", "", "encoding", "<init>", "(Lio/ktor/http/content/OutgoingContent$ReadChannelContent;Ljava/lang/String;)V", "Lio/ktor/utils/io/ByteReadChannel;", "readFrom", "()Lio/ktor/utils/io/ByteReadChannel;", "Lv9/l;", "range", "(Lv9/l;)Lio/ktor/utils/io/ByteReadChannel;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/AttributeKey;", "key", "getProperty", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", UxipConstants.f30680s, "LY8/t;", "setProperty", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Ljava/lang/String;", "Lio/ktor/http/Headers;", "headers$delegate", "LY8/h;", "getHeaders", "()Lio/ktor/http/Headers;", "headers", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PreCompressedResponse extends OutgoingContent.ReadChannelContent {
    private final String encoding;

    /* renamed from: headers$delegate, reason: from kotlin metadata */
    private final Y8.h headers;
    private final OutgoingContent.ReadChannelContent original;

    public PreCompressedResponse(OutgoingContent.ReadChannelContent original, String str) {
        kotlin.jvm.internal.p.i(original, "original");
        this.original = original;
        this.encoding = str;
        this.headers = C4848b.a(LazyThreadSafetyMode.NONE, new InterfaceC5063a() { // from class: io.ktor.server.http.content.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return PreCompressedResponse.headers_delegate$lambda$2(this.f33418a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Headers headers_delegate$lambda$2(PreCompressedResponse preCompressedResponse) {
        if (preCompressedResponse.encoding == null) {
            return preCompressedResponse.original.getHeaders();
        }
        Headers.Companion companion = Headers.INSTANCE;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        StringValuesKt.appendFiltered$default(headersBuilder, preCompressedResponse.original.getHeaders(), false, new p9.p() { // from class: io.ktor.server.http.content.n
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(PreCompressedResponse.headers_delegate$lambda$2$lambda$1$lambda$0((String) obj, (String) obj2));
            }
        }, 2, null);
        headersBuilder.append(HttpHeaders.INSTANCE.getContentEncoding(), preCompressedResponse.encoding);
        return headersBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean headers_delegate$lambda$2$lambda$1$lambda$0(String name, String str) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(str, "<unused var>");
        return !La.D.L(name, HttpHeaders.INSTANCE.getContentLength(), true);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return this.original.getContentLength();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.original.getContentType();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Headers getHeaders() {
        return (Headers) this.headers.getValue();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public <T> T getProperty(AttributeKey<T> key) {
        kotlin.jvm.internal.p.i(key, "key");
        return (T) this.original.getProperty(key);
    }

    @Override // io.ktor.http.content.OutgoingContent
    /* renamed from: getStatus */
    public HttpStatusCode getValue() {
        return this.original.getValue();
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel readFrom() {
        return this.original.readFrom();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public <T> void setProperty(AttributeKey<T> key, T value) {
        kotlin.jvm.internal.p.i(key, "key");
        this.original.setProperty(key, value);
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel readFrom(C5683l range) {
        kotlin.jvm.internal.p.i(range, "range");
        return this.original.readFrom(range);
    }
}
