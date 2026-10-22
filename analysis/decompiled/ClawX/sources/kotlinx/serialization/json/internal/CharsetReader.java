package kotlinx.serialization.json.internal;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0086\u0080\u0004J\"\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0082\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0011H\u0082\u0080\u0004J\n\u0010\u0018\u001a\u00020\u0011H\u0082\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0086\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\tX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\u000bX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\f\u001a\u00020\rX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000e\u001a\u00020\u000fX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/serialization/json/internal/CharsetReader;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "<init>", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V", "decoder", "Ljava/nio/charset/CharsetDecoder;", "byteBuffer", "Ljava/nio/ByteBuffer;", "hasLeftoverPotentiallySurrogateChar", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "leftoverChar", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "read", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "array", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "offset", "length", "doRead", "fillByteBuffer", "oneShotReadSlowPath", "release", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CharsetReader {
    private final ByteBuffer byteBuffer;
    private final Charset charset;
    private final CharsetDecoder decoder;
    private boolean hasLeftoverPotentiallySurrogateChar;
    private final InputStream inputStream;
    private char leftoverChar;

    public CharsetReader(InputStream inputStream, Charset charset) {
        p.e(inputStream, "inputStream");
        p.e(charset, "charset");
        this.inputStream = inputStream;
        this.charset = charset;
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetDecoder charsetDecoderOnUnmappableCharacter = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        p.d(charsetDecoderOnUnmappableCharacter, "onUnmappableCharacter(...)");
        this.decoder = charsetDecoderOnUnmappableCharacter;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(ByteArrayPool8k.INSTANCE.take());
        p.d(byteBufferWrap, "wrap(...)");
        this.byteBuffer = byteBufferWrap;
        byteBufferWrap.flip();
    }

    private final int doRead(char[] array, int offset, int length) throws CharacterCodingException {
        CharBuffer charBufferWrap = CharBuffer.wrap(array, offset, length);
        if (charBufferWrap.position() != 0) {
            charBufferWrap = charBufferWrap.slice();
        }
        boolean z = false;
        while (true) {
            CoderResult coderResultDecode = this.decoder.decode(this.byteBuffer, charBufferWrap, z);
            if (coderResultDecode.isUnderflow()) {
                if (!z && charBufferWrap.hasRemaining()) {
                    if (fillByteBuffer() < 0) {
                        if (charBufferWrap.position() == 0 && !this.byteBuffer.hasRemaining()) {
                            z = true;
                            break;
                        }
                        this.decoder.reset();
                        z = true;
                    } else {
                        continue;
                    }
                } else {
                    break;
                }
            } else {
                if (coderResultDecode.isOverflow()) {
                    charBufferWrap.position();
                    break;
                }
                coderResultDecode.throwException();
            }
        }
        if (z) {
            this.decoder.reset();
        }
        if (charBufferWrap.position() == 0) {
            return -1;
        }
        return charBufferWrap.position();
    }

    private final int fillByteBuffer() {
        this.byteBuffer.compact();
        try {
            int iLimit = this.byteBuffer.limit();
            int iPosition = this.byteBuffer.position();
            int i8 = this.inputStream.read(this.byteBuffer.array(), this.byteBuffer.arrayOffset() + iPosition, iPosition <= iLimit ? iLimit - iPosition : 0);
            if (i8 < 0) {
                return i8;
            }
            ByteBuffer byteBuffer = this.byteBuffer;
            p.c(byteBuffer, "null cannot be cast to non-null type java.nio.Buffer");
            byteBuffer.position(iPosition + i8);
            this.byteBuffer.flip();
            return this.byteBuffer.remaining();
        } finally {
            this.byteBuffer.flip();
        }
    }

    private final int oneShotReadSlowPath() {
        if (this.hasLeftoverPotentiallySurrogateChar) {
            this.hasLeftoverPotentiallySurrogateChar = false;
            return this.leftoverChar;
        }
        char[] cArr = new char[2];
        int i8 = read(cArr, 0, 2);
        if (i8 == -1) {
            return -1;
        }
        if (i8 == 1) {
            return cArr[0];
        }
        if (i8 == 2) {
            this.leftoverChar = cArr[1];
            this.hasLeftoverPotentiallySurrogateChar = true;
            return cArr[0];
        }
        throw new IllegalStateException(("Unreachable state: " + i8).toString());
    }

    public final int read(char[] array, int offset, int length) {
        p.e(array, "array");
        int i8 = 0;
        if (length == 0) {
            return 0;
        }
        if (offset < 0 || offset >= array.length || length < 0 || offset + length > array.length) {
            StringBuilder sbT = b.t("Unexpected arguments: ", offset, ", ", length, ", ");
            sbT.append(array.length);
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        if (this.hasLeftoverPotentiallySurrogateChar) {
            array[offset] = this.leftoverChar;
            offset++;
            length--;
            this.hasLeftoverPotentiallySurrogateChar = false;
            if (length == 0) {
                return 1;
            }
            i8 = 1;
        }
        if (length != 1) {
            return doRead(array, offset, length) + i8;
        }
        int iOneShotReadSlowPath = oneShotReadSlowPath();
        if (iOneShotReadSlowPath != -1) {
            array[offset] = (char) iOneShotReadSlowPath;
            return i8 + 1;
        }
        if (i8 == 0) {
            return -1;
        }
        return i8;
    }

    public final void release() {
        ByteArrayPool8k byteArrayPool8k = ByteArrayPool8k.INSTANCE;
        byte[] bArrArray = this.byteBuffer.array();
        p.d(bArrArray, "array(...)");
        byteArrayPool8k.release(bArrArray);
    }
}
