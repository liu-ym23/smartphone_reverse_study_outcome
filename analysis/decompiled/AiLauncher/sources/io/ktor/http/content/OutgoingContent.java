package io.ktor.http.content;

import Ua.C1073o0;
import Ua.M;
import Ua.Y;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5683l;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006!\"#$%&B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000f\u0082\u0001\u0006'()*+,¨\u0006-"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/AttributeKey;", "key", "getProperty", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", UxipConstants.f30680s, "LY8/t;", "setProperty", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/http/Headers;", "trailers", "()Lio/ktor/http/Headers;", "Lio/ktor/util/Attributes;", "extensionProperties", "Lio/ktor/util/Attributes;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "getHeaders", "headers", "NoContent", "ReadChannelContent", "WriteChannelContent", "ByteArrayContent", "ProtocolUpgrade", "ContentWrapper", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "Lio/ktor/http/content/OutgoingContent$ContentWrapper;", "Lio/ktor/http/content/OutgoingContent$NoContent;", "Lio/ktor/http/content/OutgoingContent$ProtocolUpgrade;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class OutgoingContent {
    private Attributes extensionProperties;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "", SingleFileBundle.KEY_BYTES, "()[B", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ByteArrayContent extends OutgoingContent {
        public ByteArrayContent() {
            super(null);
        }

        public abstract byte[] bytes();
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\t\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\u0006*\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H&¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lio/ktor/http/content/OutgoingContent$ContentWrapper;", "Lio/ktor/http/content/OutgoingContent;", "delegate", "<init>", "(Lio/ktor/http/content/OutgoingContent;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/AttributeKey;", "key", "getProperty", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", UxipConstants.f30680s, "LY8/t;", "setProperty", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "()Lio/ktor/http/content/OutgoingContent;", ChatTracker.CLICK_COPY, "(Lio/ktor/http/content/OutgoingContent;)Lio/ktor/http/content/OutgoingContent$ContentWrapper;", "Lio/ktor/http/content/OutgoingContent;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "headers", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ContentWrapper extends OutgoingContent {
        private final OutgoingContent delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContentWrapper(OutgoingContent delegate) {
            super(null);
            p.i(delegate, "delegate");
            this.delegate = delegate;
        }

        public abstract ContentWrapper copy(OutgoingContent delegate);

        /* renamed from: delegate, reason: from getter */
        public final OutgoingContent getDelegate() {
            return this.delegate;
        }

        @Override // io.ktor.http.content.OutgoingContent
        public Long getContentLength() {
            return this.delegate.getContentLength();
        }

        @Override // io.ktor.http.content.OutgoingContent
        public ContentType getContentType() {
            return this.delegate.getContentType();
        }

        @Override // io.ktor.http.content.OutgoingContent
        public Headers getHeaders() {
            return this.delegate.getHeaders();
        }

        @Override // io.ktor.http.content.OutgoingContent
        public <T> T getProperty(AttributeKey<T> key) {
            p.i(key, "key");
            return (T) this.delegate.getProperty(key);
        }

        @Override // io.ktor.http.content.OutgoingContent
        public HttpStatusCode getStatus() {
            return this.delegate.getStatus();
        }

        @Override // io.ktor.http.content.OutgoingContent
        public <T> void setProperty(AttributeKey<T> key, T value) {
            p.i(key, "key");
            this.delegate.setProperty(key, value);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/http/content/OutgoingContent$NoContent;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class NoContent extends OutgoingContent {
        public NoContent() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH¦@¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lio/ktor/http/content/OutgoingContent$ProtocolUpgrade;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "Lkotlin/coroutines/d;", "engineContext", "userContext", "Lkotlinx/coroutines/g;", "upgrade", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/d;Lkotlin/coroutines/d;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ProtocolUpgrade extends OutgoingContent {
        public ProtocolUpgrade() {
            super(null);
        }

        @Override // io.ktor.http.content.OutgoingContent
        public final HttpStatusCode getStatus() {
            return HttpStatusCode.INSTANCE.getSwitchingProtocols();
        }

        public abstract Object upgrade(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, kotlin.coroutines.d dVar, kotlin.coroutines.d dVar2, InterfaceC4014c<? super kotlinx.coroutines.g> interfaceC4014c);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "readFrom", "()Lio/ktor/utils/io/ByteReadChannel;", "Lv9/l;", "range", "(Lv9/l;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ReadChannelContent extends OutgoingContent {
        public ReadChannelContent() {
            super(null);
        }

        public abstract ByteReadChannel readFrom();

        public ByteReadChannel readFrom(C5683l range) {
            p.i(range, "range");
            return range.isEmpty() ? ByteReadChannel.INSTANCE.getEmpty() : ByteWriteChannelOperationsKt.writer((M) C1073o0.f6391a, (kotlin.coroutines.d) Y.d(), true, (p9.p<? super WriterScope, ? super InterfaceC4014c<? super t>, ? extends Object>) new OutgoingContent$ReadChannelContent$readFrom$1(this, range, null)).getChannel();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "LY8/t;", "writeTo", "(Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class WriteChannelContent extends OutgoingContent {
        public WriteChannelContent() {
            super(null);
        }

        public abstract Object writeTo(ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super t> interfaceC4014c);
    }

    public /* synthetic */ OutgoingContent(kotlin.jvm.internal.i iVar) {
        this();
    }

    public Long getContentLength() {
        return null;
    }

    public ContentType getContentType() {
        return null;
    }

    public Headers getHeaders() {
        return Headers.INSTANCE.getEmpty();
    }

    public <T> T getProperty(AttributeKey<T> key) {
        p.i(key, "key");
        Attributes attributes = this.extensionProperties;
        if (attributes != null) {
            return (T) attributes.getOrNull(key);
        }
        return null;
    }

    public HttpStatusCode getStatus() {
        return null;
    }

    public <T> void setProperty(AttributeKey<T> key, T value) {
        p.i(key, "key");
        if (value == null && this.extensionProperties == null) {
            return;
        }
        if (value == null) {
            Attributes attributes = this.extensionProperties;
            if (attributes != null) {
                attributes.remove(key);
                return;
            }
            return;
        }
        Attributes attributesAttributes$default = this.extensionProperties;
        if (attributesAttributes$default == null) {
            attributesAttributes$default = AttributesJvmKt.Attributes$default(false, 1, null);
        }
        this.extensionProperties = attributesAttributes$default;
        attributesAttributes$default.put(key, value);
    }

    public Headers trailers() {
        return null;
    }

    private OutgoingContent() {
    }
}
