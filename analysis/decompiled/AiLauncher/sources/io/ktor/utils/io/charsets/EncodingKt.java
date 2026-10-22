package io.ktor.utils.io.charsets;

import fb.C4074a;
import fb.s;
import fb.v;
import io.ktor.utils.io.core.internal.CharArraySequence;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u001a1\u0010\b\u001a\u00020\u0007*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\b\u001a\u00020\r*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\u000e\u001a'\u0010\u0013\u001a\u00020\u0012*\u00060\u000fj\u0002`\u00102\u0006\u0010\u0003\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014\u001a7\u0010\u0015\u001a\u00020\u0004*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a7\u0010\u0018\u001a\u00020\r*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "", "input", "", "fromIndex", "toIndex", "Lfb/v;", "encode", "(Ljava/nio/charset/CharsetEncoder;Ljava/lang/CharSequence;II)Lfb/v;", "", "Lfb/s;", "dst", "LY8/t;", "(Ljava/nio/charset/CharsetEncoder;[CIILfb/s;)V", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "max", "", "decode", "(Ljava/nio/charset/CharsetDecoder;Lfb/v;I)Ljava/lang/String;", "encodeArrayImpl", "(Ljava/nio/charset/CharsetEncoder;[CIILfb/s;)I", "destination", "encodeToImpl", "(Ljava/nio/charset/CharsetEncoder;Lfb/s;Ljava/lang/CharSequence;II)V", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EncodingKt {
    public static final String decode(CharsetDecoder charsetDecoder, v input, int i10) {
        p.i(charsetDecoder, "<this>");
        p.i(input, "input");
        StringBuilder sb2 = new StringBuilder((int) Math.min(i10, input.getBufferField().n()));
        CharsetJVMKt.decode(charsetDecoder, input, sb2, i10);
        return sb2.toString();
    }

    public static /* synthetic */ String decode$default(CharsetDecoder charsetDecoder, v vVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return decode(charsetDecoder, vVar, i10);
    }

    public static final void encode(CharsetEncoder charsetEncoder, char[] input, int i10, int i11, s dst) {
        p.i(charsetEncoder, "<this>");
        p.i(input, "input");
        p.i(dst, "dst");
        encodeArrayImpl(charsetEncoder, input, i10, i11, dst);
    }

    public static /* synthetic */ v encode$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        return encode(charsetEncoder, charSequence, i10, i11);
    }

    public static final int encodeArrayImpl(CharsetEncoder charsetEncoder, char[] input, int i10, int i11, s dst) {
        p.i(charsetEncoder, "<this>");
        p.i(input, "input");
        p.i(dst, "dst");
        int i12 = i11 - i10;
        return CharsetJVMKt.encodeImpl(charsetEncoder, new CharArraySequence(input, i10, i12), 0, i12, dst);
    }

    public static final void encodeToImpl(CharsetEncoder charsetEncoder, s destination, CharSequence input, int i10, int i11) {
        p.i(charsetEncoder, "<this>");
        p.i(destination, "destination");
        p.i(input, "input");
        if (i10 >= i11) {
            return;
        }
        do {
            int iEncodeImpl = CharsetJVMKt.encodeImpl(charsetEncoder, input, i10, i11, destination);
            if (iEncodeImpl < 0) {
                throw new IllegalStateException("Check failed.");
            }
            i10 += iEncodeImpl;
        } while (i10 < i11);
    }

    public static final v encode(CharsetEncoder charsetEncoder, CharSequence input, int i10, int i11) {
        p.i(charsetEncoder, "<this>");
        p.i(input, "input");
        C4074a c4074a = new C4074a();
        encodeToImpl(charsetEncoder, c4074a, input, i10, i11);
        return c4074a;
    }
}
