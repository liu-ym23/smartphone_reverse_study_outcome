package io.ktor.utils.io;

import La.C0953c;
import com.stepos.ame.sdk.SkillStoreKt;
import fb.C4074a;
import fb.v;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\b\u0002\u0010\f\u001a\u00060\nj\u0002`\u000b¢\u0006\u0004\b\u0006\u0010\r\u001a\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0006\u0010\u0010¨\u0006\u0011"}, d2 = {"", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "offset", "length", "Lio/ktor/utils/io/ByteReadChannel;", "ByteReadChannel", "([BII)Lio/ktor/utils/io/ByteReadChannel;", "", "text", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lio/ktor/utils/io/ByteReadChannel;", "Lfb/v;", "source", "(Lfb/v;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteChannelCtorKt {
    public static final ByteReadChannel ByteReadChannel(byte[] content, int i10, int i11) {
        p.i(content, "content");
        C4074a c4074a = new C4074a();
        c4074a.write(content, i10, i11 + i10);
        return ByteReadChannel(c4074a);
    }

    public static /* synthetic */ ByteReadChannel ByteReadChannel$default(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return ByteReadChannel(bArr, i10, i11);
    }

    public static /* synthetic */ ByteReadChannel ByteReadChannel$default(String str, Charset charset, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = C0953c.UTF_8;
        }
        return ByteReadChannel(str, charset);
    }

    public static final ByteReadChannel ByteReadChannel(String text, Charset charset) {
        p.i(text, "text");
        p.i(charset, "charset");
        return ByteReadChannel$default(StringsKt.toByteArray(text, charset), 0, 0, 6, null);
    }

    public static final ByteReadChannel ByteReadChannel(v source) {
        p.i(source, "source");
        return new SourceByteReadChannel(source);
    }
}
