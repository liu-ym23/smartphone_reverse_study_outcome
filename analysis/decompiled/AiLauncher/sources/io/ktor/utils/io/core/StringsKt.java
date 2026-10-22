package io.ktor.utils.io.core;

import La.C0953c;
import La.D;
import com.stepos.aiengine.args.SingleFileBundle;
import fb.C4074a;
import fb.s;
import fb.v;
import fb.x;
import fb.y;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.charsets.EncodingKt;
import java.io.EOFException;
import java.nio.charset.Charset;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\u0004*\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u000e\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u0010\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u0011\u001a)\u0010\u0013\u001a\u00020\u0000*\u00020\r2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\b\b\u0002\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a)\u0010\u0016\u001a\u00020\u0000*\u00020\r2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0015\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0016\u0010\u0014\u001a'\u0010\u0018\u001a\u00020\u0000*\u00020\r2\u0006\u0010\u0017\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a;\u0010 \u001a\u00020\u001f*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b \u0010!\u001a;\u0010 \u001a\u00020\u001f*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\"2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b \u0010#\u001a\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "", "toByteArray", "(Ljava/lang/String;Ljava/nio/charset/Charset;)[B", SingleFileBundle.KEY_BYTES, "", "offset", "length", "String", "([BIILjava/nio/charset/Charset;)Ljava/lang/String;", "Lfb/v;", "readBytes", "(Lfb/v;)[B", "count", "(Lfb/v;I)[B", "max", "readText", "(Lfb/v;Ljava/nio/charset/Charset;I)Ljava/lang/String;", "n", "readTextExact", "charactersCount", "readTextExactCharacters", "(Lfb/v;ILjava/nio/charset/Charset;)Ljava/lang/String;", "Lfb/s;", "", "text", "fromIndex", "toIndex", "LY8/t;", "writeText", "(Lfb/s;Ljava/lang/CharSequence;IILjava/nio/charset/Charset;)V", "", "(Lfb/s;[CIILjava/nio/charset/Charset;)V", "", "prematureEndOfStreamToReadChars", "(I)Ljava/lang/Void;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StringsKt {
    public static final String String(byte[] bytes, int i10, int i11, Charset charset) {
        p.i(bytes, "bytes");
        p.i(charset, "charset");
        if (p.d(charset, C0953c.UTF_8)) {
            return D.F(bytes, i10, i10 + i11, false, 4, null);
        }
        C4074a c4074a = new C4074a();
        BytePacketBuilderKt.writeFully(c4074a, bytes, i10, i11);
        return readText$default(c4074a, charset, 0, 2, null);
    }

    public static /* synthetic */ String String$default(byte[] bArr, int i10, int i11, Charset charset, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        if ((i12 & 8) != 0) {
            charset = C0953c.UTF_8;
        }
        return String(bArr, i10, i11, charset);
    }

    private static final Void prematureEndOfStreamToReadChars(int i10) throws EOFException {
        throw new EOFException("Not enough input bytes to read " + i10 + " characters.");
    }

    public static final byte[] readBytes(v vVar) {
        p.i(vVar, "<this>");
        return x.c(vVar);
    }

    public static final String readText(v vVar, Charset charset, int i10) {
        p.i(vVar, "<this>");
        p.i(charset, "charset");
        return p.d(charset, C0953c.UTF_8) ? i10 == Integer.MAX_VALUE ? y.c(vVar) : y.d(vVar, Math.min(vVar.getBufferField().n(), i10)) : EncodingKt.decode(charset.newDecoder(), vVar, i10);
    }

    public static /* synthetic */ String readText$default(v vVar, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = C0953c.UTF_8;
        }
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return readText(vVar, charset, i10);
    }

    public static final String readTextExact(v vVar, Charset charset, int i10) {
        p.i(vVar, "<this>");
        p.i(charset, "charset");
        return readTextExactCharacters(vVar, i10, charset);
    }

    public static /* synthetic */ String readTextExact$default(v vVar, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = C0953c.UTF_8;
        }
        return readTextExact(vVar, charset, i10);
    }

    public static final String readTextExactCharacters(v vVar, int i10, Charset charset) throws EOFException {
        p.i(vVar, "<this>");
        p.i(charset, "charset");
        String text = readText(vVar, charset, i10);
        if (text.length() >= i10) {
            return text;
        }
        prematureEndOfStreamToReadChars(i10);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ String readTextExactCharacters$default(v vVar, int i10, Charset charset, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            charset = C0953c.UTF_8;
        }
        return readTextExactCharacters(vVar, i10, charset);
    }

    public static final byte[] toByteArray(String str, Charset charset) {
        p.i(str, "<this>");
        p.i(charset, "charset");
        return p.d(charset, C0953c.UTF_8) ? D.I(str, 0, 0, true, 3, null) : CharsetJVMKt.encodeToByteArray(charset.newEncoder(), str, 0, str.length());
    }

    public static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = C0953c.UTF_8;
        }
        return toByteArray(str, charset);
    }

    public static final void writeText(s sVar, CharSequence text, int i10, int i11, Charset charset) {
        p.i(sVar, "<this>");
        p.i(text, "text");
        p.i(charset, "charset");
        if (charset == C0953c.UTF_8) {
            y.e(sVar, text.toString(), i10, i11);
        } else {
            EncodingKt.encodeToImpl(charset.newEncoder(), sVar, text, i10, i11);
        }
    }

    public static /* synthetic */ void writeText$default(s sVar, CharSequence charSequence, int i10, int i11, Charset charset, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        if ((i12 & 8) != 0) {
            charset = C0953c.UTF_8;
        }
        writeText(sVar, charSequence, i10, i11, charset);
    }

    public static final byte[] readBytes(v vVar, int i10) {
        p.i(vVar, "<this>");
        return x.d(vVar, i10);
    }

    public static final void writeText(s sVar, char[] text, int i10, int i11, Charset charset) {
        p.i(sVar, "<this>");
        p.i(text, "text");
        p.i(charset, "charset");
        if (charset == C0953c.UTF_8) {
            y.e(sVar, D.C(text, i10, i10 + i11), 0, i11 - i10);
        } else {
            EncodingKt.encode(charset.newEncoder(), text, i10, i11, sVar);
        }
    }

    public static /* synthetic */ void writeText$default(s sVar, char[] cArr, int i10, int i11, Charset charset, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = cArr.length;
        }
        if ((i12 & 8) != 0) {
            charset = C0953c.UTF_8;
        }
        writeText(sVar, cArr, i10, i11, charset);
    }
}
