package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes17.dex */
public class Utf8Old extends Utf8 {
    private static final ThreadLocal<Cache> CACHE = null;

    public static class Cache {
        final CharsetDecoder decoder;
        final CharsetEncoder encoder;
        CharSequence lastInput;
        ByteBuffer lastOutput;

        public Cache() {
            this.lastInput = null;
            this.lastOutput = null;
            this.encoder = StandardCharsets.UTF_8.newEncoder();
            this.decoder = StandardCharsets.UTF_8.newDecoder();
        }
    }

    public static /* synthetic */ Cache a() {
        return lambda$static$0();
    }

    static {
        CACHE = ThreadLocal.withInitial(new a());
    }

    private static /* synthetic */ Cache lambda$static$0() {
        return new Cache();
    }

    public Utf8Old() {
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence r100) {
        Cache r101 = CACHE.get();
        int r102 = (int) (r100.length() * r101.encoder.maxBytesPerChar());
        ByteBuffer r103 = r101.lastOutput;
        if (r103 != null) goto L5;
    L6:
        r101.lastOutput = ByteBuffer.allocate(Math.max(128, r102));
    L7:
        r101.lastOutput.clear();
        r101.lastInput = r100;
        if ((r100 instanceof CharBuffer) == false) goto L10;
        CharBuffer r104 = (CharBuffer) r100;
    L11:
        CoderResult r105 = r101.encoder.encode(r104, r101.lastOutput, true);
        if (r105.isError() == true) goto L20;
    L18:
        r101.lastOutput.flip();
        return r101.lastOutput.remaining();
    L20:
        r105.throwException();     // Catch: CharacterCodingException -> L15
    L15:
        e = move-exception;
        throw new IllegalArgumentException("bad character encoding", e);
    L10:
        r104 = CharBuffer.wrap(r100);
        goto L11
    L5:
        if (r103.capacity() >= r102) goto L7;
        goto L6
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence r100, ByteBuffer r101) {
        Cache r102 = CACHE.get();
        if (r102.lastInput == r100) goto L5;
        encodedLength(r100);
    L5:
        r101.put(r102.lastOutput);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer r100, int r101, int r102) {
        CharsetDecoder r103 = CACHE.get().decoder;
        r103.reset();
        ByteBuffer r104 = r100.duplicate();
        r104.position(r101);
        r104.limit(r101 + r102);
        return r103.decode(r104).toString();
    L5:
        e = move-exception;
        throw new IllegalArgumentException("Bad encoding", e);
    }
}
