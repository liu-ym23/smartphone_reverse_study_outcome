package io.ktor.http.cio;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import fb.s;
import fb.v;
import io.ktor.http.HttpMethod;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0019¢\u0006\u0004\b\u0017\u0010\u001aJ\u001d\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010\u0003J\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\t¢\u0006\u0004\b#\u0010\u0003R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lio/ktor/http/cio/RequestResponseBuilder;", "", "<init>", "()V", "", "version", "", "status", "statusText", "LY8/t;", "responseLine", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;)V", "Lio/ktor/http/HttpMethod;", "method", "uri", "requestLine", "(Lio/ktor/http/HttpMethod;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "line", "(Ljava/lang/CharSequence;)V", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "offset", "length", SingleFileBundle.KEY_BYTES, "([BII)V", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "name", UxipConstants.f30680s, "headerLine", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "emptyLine", "Lfb/v;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lfb/v;", "release", "Lfb/s;", "packet", "Lfb/s;", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RequestResponseBuilder {
    private final s packet = BytePacketBuilderKt.BytePacketBuilder();

    public static /* synthetic */ void bytes$default(RequestResponseBuilder requestResponseBuilder, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        requestResponseBuilder.bytes(bArr, i10, i11);
    }

    public final v build() {
        return BytePacketBuilderKt.build(this.packet);
    }

    public final void bytes(byte[] content, int offset, int length) {
        p.i(content, "content");
        BytePacketBuilderKt.writeFully(this.packet, content, offset, length);
    }

    public final void emptyLine() {
        this.packet.H0((byte) 13);
        this.packet.H0((byte) 10);
    }

    public final void headerLine(CharSequence name, CharSequence value) {
        p.i(name, "name");
        p.i(value, "value");
        BytePacketBuilderKt.append$default(this.packet, name, 0, 0, 6, null);
        BytePacketBuilderKt.append$default(this.packet, ": ", 0, 0, 6, null);
        BytePacketBuilderKt.append$default(this.packet, value, 0, 0, 6, null);
        this.packet.H0((byte) 13);
        this.packet.H0((byte) 10);
    }

    public final void line(CharSequence line) {
        p.i(line, "line");
        BytePacketBuilderKt.append$default(this.packet, line, 0, 0, 6, null);
        this.packet.H0((byte) 13);
        this.packet.H0((byte) 10);
    }

    public final void release() {
        this.packet.close();
    }

    public final void requestLine(HttpMethod method, CharSequence uri, CharSequence version) {
        p.i(method, "method");
        p.i(uri, "uri");
        p.i(version, "version");
        StringsKt.writeText$default(this.packet, method.getValue(), 0, 0, (Charset) null, 14, (Object) null);
        this.packet.H0((byte) 32);
        StringsKt.writeText$default(this.packet, uri, 0, 0, (Charset) null, 14, (Object) null);
        this.packet.H0((byte) 32);
        StringsKt.writeText$default(this.packet, version, 0, 0, (Charset) null, 14, (Object) null);
        this.packet.H0((byte) 13);
        this.packet.H0((byte) 10);
    }

    public final void responseLine(CharSequence version, int status, CharSequence statusText) {
        p.i(version, "version");
        p.i(statusText, "statusText");
        StringsKt.writeText$default(this.packet, version, 0, 0, (Charset) null, 14, (Object) null);
        this.packet.H0((byte) 32);
        StringsKt.writeText$default(this.packet, String.valueOf(status), 0, 0, (Charset) null, 14, (Object) null);
        this.packet.H0((byte) 32);
        StringsKt.writeText$default(this.packet, statusText, 0, 0, (Charset) null, 14, (Object) null);
        this.packet.H0((byte) 13);
        this.packet.H0((byte) 10);
    }

    public final void bytes(ByteBuffer content) {
        p.i(content, "content");
        BytePacketBuilderExtensions_jvmKt.writeFully(this.packet, content);
    }
}
