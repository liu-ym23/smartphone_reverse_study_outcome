package io.ktor.util.cio;

import La.C0953c;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "Ljava/io/BufferedWriter;", "bufferedWriter", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/charset/Charset;)Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "writer", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/charset/Charset;)Ljava/io/Writer;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OutputStreamAdaptersKt {
    public static final BufferedWriter bufferedWriter(ByteWriteChannel byteWriteChannel, Charset charset) {
        p.i(byteWriteChannel, "<this>");
        p.i(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(BlockingKt.toOutputStream(byteWriteChannel), charset), com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
    }

    public static /* synthetic */ BufferedWriter bufferedWriter$default(ByteWriteChannel byteWriteChannel, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = C0953c.UTF_8;
        }
        return bufferedWriter(byteWriteChannel, charset);
    }

    public static final Writer writer(ByteWriteChannel byteWriteChannel, Charset charset) {
        p.i(byteWriteChannel, "<this>");
        p.i(charset, "charset");
        return new OutputStreamWriter(BlockingKt.toOutputStream(byteWriteChannel), charset);
    }

    public static /* synthetic */ Writer writer$default(ByteWriteChannel byteWriteChannel, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = C0953c.UTF_8;
        }
        return writer(byteWriteChannel, charset);
    }
}
