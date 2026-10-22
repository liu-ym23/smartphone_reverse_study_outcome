package io.ktor.utils.io.charsets;

import La.C0953c;
import fb.C4077d;
import fb.s;
import fb.v;
import fb.y;
import gb.b;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a!\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\t\u001a\u00020\b*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n\u001a1\u0010\u0013\u001a\u00020\u0012*\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014\u001a/\u0010\u0015\u001a\u00020\u0012*\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0014\u001a7\u0010\u0018\u001a\u00020\u000f*\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a3\u0010\u001a\u001a\u00020\u0012*\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u001a\u0010\u0014\u001a1\u0010!\u001a\u00020\u000f*\u00060\u001bj\u0002`\u001c2\u0006\u0010\u000e\u001a\u00020\u001d2\n\u0010\u0017\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010 \u001a\u00020\u000f¢\u0006\u0004\b!\u0010\"\"\u0019\u0010\u0003\u001a\u00020\u0002*\u00060\u0004j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u001d\u0010'\u001a\u00060\u0004j\u0002`\u0005*\u00060\u000bj\u0002`\f8F¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u001d\u0010'\u001a\u00060\u0004j\u0002`\u0005*\u00060\u001bj\u0002`\u001c8F¢\u0006\u0006\u001a\u0004\b%\u0010(*\n\u0010)\"\u00020\u00042\u00020\u0004*\n\u0010*\"\u00020\u000b2\u00020\u000b*\n\u0010+\"\u00020\u001b2\u00020\u001b*\n\u0010,\"\u00020\u00002\u00020\u0000¨\u0006-"}, d2 = {"LLa/c;", "Lio/ktor/utils/io/charsets/Charsets;", "", "name", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "forName", "(LLa/c;Ljava/lang/String;)Ljava/nio/charset/Charset;", "", "isSupported", "(LLa/c;Ljava/lang/String;)Z", "Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "", "input", "", "fromIndex", "toIndex", "", "encodeToByteArray", "(Ljava/nio/charset/CharsetEncoder;Ljava/lang/CharSequence;II)[B", "encodeToByteArraySlow", "Lfb/s;", "dst", "encodeImpl", "(Ljava/nio/charset/CharsetEncoder;Ljava/lang/CharSequence;IILfb/s;)I", "encodeToByteArrayImpl", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "Lfb/v;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "max", "decode", "(Ljava/nio/charset/CharsetDecoder;Lfb/v;Ljava/lang/Appendable;I)I", "getName", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "getCharset", "(Ljava/nio/charset/CharsetEncoder;)Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "(Ljava/nio/charset/CharsetDecoder;)Ljava/nio/charset/Charset;", "Charset", "CharsetEncoder", "CharsetDecoder", "Charsets", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CharsetJVMKt {
    public static /* synthetic */ void Charset$annotations() {
    }

    public static final int decode(CharsetDecoder charsetDecoder, v input, Appendable dst, int i10) {
        p.i(charsetDecoder, "<this>");
        p.i(input, "input");
        p.i(dst, "dst");
        if (p.d(getCharset(charsetDecoder), C0953c.UTF_8)) {
            String strC = y.c(input);
            dst.append(strC);
            return strC.length();
        }
        long remaining = ByteReadPacketKt.getRemaining(input);
        dst.append(b.a(C4077d.a(input), getCharset(charsetDecoder)));
        return (int) remaining;
    }

    public static final int encodeImpl(CharsetEncoder charsetEncoder, CharSequence input, int i10, int i11, s dst) {
        p.i(charsetEncoder, "<this>");
        p.i(input, "input");
        p.i(dst, "dst");
        byte[] bArrEncodeToByteArray = encodeToByteArray(charsetEncoder, input, i10, i11);
        s.y0(dst, bArrEncodeToByteArray, 0, 0, 6, null);
        return bArrEncodeToByteArray.length;
    }

    public static final byte[] encodeToByteArray(CharsetEncoder charsetEncoder, CharSequence input, int i10, int i11) {
        p.i(charsetEncoder, "<this>");
        p.i(input, "input");
        if (!(input instanceof String)) {
            return encodeToByteArraySlow(charsetEncoder, input, i10, i11);
        }
        if (i10 == 0) {
            String str = (String) input;
            if (i11 == str.length()) {
                byte[] bytes = str.getBytes(charsetEncoder.charset());
                p.h(bytes, "getBytes(...)");
                return bytes;
            }
        }
        String strSubstring = ((String) input).substring(i10, i11);
        p.h(strSubstring, "substring(...)");
        p.g(strSubstring, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes2 = strSubstring.getBytes(charsetEncoder.charset());
        p.h(bytes2, "getBytes(...)");
        return bytes2;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        return encodeToByteArray(charsetEncoder, charSequence, i10, i11);
    }

    public static final byte[] encodeToByteArrayImpl(CharsetEncoder charsetEncoder, CharSequence input, int i10, int i11) {
        p.i(charsetEncoder, "<this>");
        p.i(input, "input");
        throw new IllegalStateException("Not needed on jvm");
    }

    public static /* synthetic */ byte[] encodeToByteArrayImpl$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        return encodeToByteArrayImpl(charsetEncoder, charSequence, i10, i11);
    }

    private static final byte[] encodeToByteArraySlow(CharsetEncoder charsetEncoder, CharSequence charSequence, int i10, int i11) throws CharacterCodingException {
        ByteBuffer byteBufferEncode = charsetEncoder.encode(CharBuffer.wrap(charSequence, i10, i11));
        byte[] bArr = null;
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            byte[] bArrArray = byteBufferEncode.array();
            if (bArrArray.length == byteBufferEncode.remaining()) {
                bArr = bArrArray;
            }
        }
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr2);
        return bArr2;
    }

    public static final Charset forName(C0953c c0953c, String name) {
        p.i(c0953c, "<this>");
        p.i(name, "name");
        Charset charsetForName = Charset.forName(name);
        p.h(charsetForName, "forName(...)");
        return charsetForName;
    }

    public static final Charset getCharset(CharsetEncoder charsetEncoder) {
        p.i(charsetEncoder, "<this>");
        Charset charset = charsetEncoder.charset();
        p.h(charset, "charset(...)");
        return charset;
    }

    public static final String getName(Charset charset) {
        p.i(charset, "<this>");
        String strName = charset.name();
        p.h(strName, "name(...)");
        return strName;
    }

    public static final boolean isSupported(C0953c c0953c, String name) {
        p.i(c0953c, "<this>");
        p.i(name, "name");
        return Charset.isSupported(name);
    }

    public static final Charset getCharset(CharsetDecoder charsetDecoder) {
        p.i(charsetDecoder, "<this>");
        Charset charset = charsetDecoder.charset();
        p.f(charset);
        return charset;
    }
}
