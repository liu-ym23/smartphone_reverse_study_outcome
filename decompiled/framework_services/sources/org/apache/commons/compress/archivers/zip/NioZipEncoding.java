package org.apache.commons.compress.archivers.zip;

import android.hardware.tv.mediaquality.ParameterName;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: classes3.dex */
class NioZipEncoding implements ZipEncoding, CharsetAccessor {
    private static final char[] HEX_CHARS = null;
    private static final char REPLACEMENT = '?';
    private static final byte[] REPLACEMENT_BYTES = null;
    private static final String REPLACEMENT_STRING = null;
    private final Charset charset;
    private final boolean useReplacement;

    static {
        REPLACEMENT_BYTES = new byte[]{ParameterName.COLOR_TUNER_HUE_YELLOW};
        REPLACEMENT_STRING = String.valueOf(REPLACEMENT);
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    NioZipEncoding(Charset charset, boolean useReplacement) {
        this.charset = charset;
        this.useReplacement = useReplacement;
    }

    @Override // org.apache.commons.compress.archivers.zip.CharsetAccessor
    public Charset getCharset() {
        return this.charset;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public boolean canEncode(String name) {
        CharsetEncoder enc = newEncoder();
        return enc.canEncode(name);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public ByteBuffer encode(String name) {
        CharsetEncoder enc = newEncoder();
        CharBuffer cb = CharBuffer.wrap(name);
        CharBuffer tmp = null;
        ByteBuffer out = ByteBuffer.allocate(estimateInitialBufferSize(enc, cb.remaining()));
    L4:
        if (cb.remaining() <= 0) goto L33;
        CoderResult res = enc.encode(cb, out, false);
        if (res.isUnmappable() == true) goto L14;
        if (res.isMalformed() == true) goto L14;
        if (res.isOverflow() == false) goto L4;
        int increment = estimateIncrementalEncodingSize(enc, cb.remaining());
        out = ZipEncodingHelper.growBufferBy(out, increment);
    L14:
        int spaceForSurrogate = estimateIncrementalEncodingSize(enc, res.length() * 6);
        if (spaceForSurrogate <= out.remaining()) goto L25;
        int charCount = 0;
        int i = cb.position();
    L18:
        if (i >= cb.limit()) goto L24;
        if (enc.canEncode(cb.get(i)) == true) goto L22;
        int r10 = 6;
    L23:
        charCount = charCount + r10;
        i = i + 1;
        goto L18
    L22:
        r10 = 1;
        goto L23
    L24:
        int totalExtraSpace = estimateIncrementalEncodingSize(enc, charCount);
        out = ZipEncodingHelper.growBufferBy(out, totalExtraSpace - out.remaining());
    L25:
        if (tmp != null) goto L27;
        tmp = CharBuffer.allocate(6);
    L27:
        int i2 = 0;
    L29:
        if (i2 >= res.length()) goto L4;
        out = encodeFully(enc, encodeSurrogate(tmp, cb.get()), out);
        i2 = i2 + 1;
        goto L29
    L33:
        enc.encode(cb, out, true);
        out.limit(out.position());
        out.rewind();
        return out;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public String decode(byte[] data) throws IOException {
        return newDecoder().decode(ByteBuffer.wrap(data)).toString();
    }

    private static ByteBuffer encodeFully(CharsetEncoder enc, CharBuffer cb, ByteBuffer out) {
        ByteBuffer o = out;
    L4:
        if (cb.hasRemaining() == false) goto L9;
        CoderResult result = enc.encode(cb, o, false);
        if (result.isOverflow() == false) goto L4;
        int increment = estimateIncrementalEncodingSize(enc, cb.remaining());
        o = ZipEncodingHelper.growBufferBy(o, increment);
        goto L4
    L9:
        return o;
    }

    private static CharBuffer encodeSurrogate(CharBuffer cb, char c) {
        cb.position(0).limit(6);
        cb.put('%');
        cb.put('U');
        cb.put(HEX_CHARS[(c >> '\f') & 15]);
        cb.put(HEX_CHARS[(c >> '\b') & 15]);
        cb.put(HEX_CHARS[(c >> 4) & 15]);
        cb.put(HEX_CHARS[c & 15]);
        cb.flip();
        return cb;
    }

    private CharsetEncoder newEncoder() {
        if (this.useReplacement == false) goto L7;
        return this.charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith(REPLACEMENT_BYTES);
    L7:
        return this.charset.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
    }

    private CharsetDecoder newDecoder() {
        if (this.useReplacement == true) goto L7;
        return this.charset.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
    L7:
        return this.charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith(REPLACEMENT_STRING);
    }

    private static int estimateInitialBufferSize(CharsetEncoder enc, int charChount) {
        float first = enc.maxBytesPerChar();
        float rest = (charChount - 1) * enc.averageBytesPerChar();
        return (int) Math.ceil(first + rest);
    }

    private static int estimateIncrementalEncodingSize(CharsetEncoder enc, int charCount) {
        return (int) Math.ceil(charCount * enc.averageBytesPerChar());
    }
}
