package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class Utf8Old extends Utf8 {
    private static final ThreadLocal<Cache> CACHE = null;

    private static class Cache {
        final CharsetDecoder decoder;
        final CharsetEncoder encoder;
        CharSequence lastInput;
        ByteBuffer lastOutput;

        Cache() {
            this.lastInput = null;
            this.lastOutput = null;
            this.encoder = StandardCharsets.UTF_8.newEncoder();
            this.decoder = StandardCharsets.UTF_8.newDecoder();
        }
    }

    public Utf8Old() {
    }

    static {
        CACHE = ThreadLocal.withInitial(new Utf8Old$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ Cache lambda$static$0() {
        return new Cache();
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence r4) {
        Cache r3 = CACHE.get();
        int r0 = (int) (r4.length() * r3.encoder.maxBytesPerChar());
        if (r3.lastOutput != null) goto L5;
    L6:
        r3.lastOutput = ByteBuffer.allocate(Math.max(128, r0));
    L7:
        r3.lastOutput.clear();
        r3.lastInput = r4;
        if ((r4 instanceof CharBuffer) == false) goto L10;
        CharBuffer r5 = (CharBuffer) r4;
    L11:
        CoderResult r6 = r3.encoder.encode(r5, r3.lastOutput, true);
        if (r6.isError() == true) goto L20;
    L18:
        r3.lastOutput.flip();
        return r3.lastOutput.remaining();
    L20:
        r6.throwException();     // Catch: CharacterCodingException -> L15
    L15:
        e = move-exception;
        throw new IllegalArgumentException("bad character encoding", e);
    L10:
        r5 = CharBuffer.wrap(r4);
        goto L11
    L5:
        if (r3.lastOutput.capacity() >= r0) goto L7;
        goto L6
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence r3, ByteBuffer r4) {
        Cache r0 = CACHE.get();
        if (r0.lastInput == r3) goto L5;
        encodedLength(r3);
    L5:
        r4.put(r0.lastOutput);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer r1, int r2, int r3) {
        CharsetDecoder r0 = CACHE.get().decoder;
        r0.reset();
        ByteBuffer r4 = r1.duplicate();
        r4.position(r2);
        r4.limit(r2 + r3);
        return r0.decode(r4).toString();
    L5:
        e = move-exception;
        throw new IllegalArgumentException("Bad encoding", e);
    }
}
