package kotlinx.serialization.json.internal;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\u0012\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\u0012\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0015H\u0082\u0080\u0004J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0083\u0080\bJ\n\u0010\u001d\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u001e\u001a\u00020\rH\u0082\u0080\u0004J\u0012\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000bH\u0082\u0088\u0004J\u0012\u0010\u0013\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u000bH\u0082\u0088\u0004J\n\u0010\"\u001a\u00020\u000bH\u0082\u0088\u0004J\u001a\u0010#\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000bH\u0082\u0080\u0004J\u0012\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u000bH\u0082\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\tX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\u000bX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlinx/serialization/json/internal/JsonToJavaStreamWriter;", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "stream", "Ljava/io/OutputStream;", "<init>", "(Ljava/io/OutputStream;)V", "buffer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "charArray", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "indexInBuffer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeLong", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "value", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeChar", "char", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "write", "text", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeQuoted", "appendStringSlowPath", "currentSize", "string", "ensureTotalCapacity", "oldSize", "additional", "release", "flush", "ensure", "bytesCount", "byte", "rest", "writeUtf8", "count", "writeUtf8CodePoint", "codePoint", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonToJavaStreamWriter implements InternalJsonWriter {
    private final byte[] buffer;
    private char[] charArray;
    private int indexInBuffer;
    private final OutputStream stream;

    public JsonToJavaStreamWriter(OutputStream stream) {
        p.e(stream, "stream");
        this.stream = stream;
        this.buffer = ByteArrayPool.INSTANCE.take();
        this.charArray = CharArrayPool.INSTANCE.take();
    }

    private final void appendStringSlowPath(int currentSize, String string) throws IOException {
        byte b9;
        int length = string.length();
        for (int i8 = currentSize - 1; i8 < length; i8++) {
            int iEnsureTotalCapacity = ensureTotalCapacity(currentSize, 2);
            char cCharAt = string.charAt(i8);
            if (cCharAt >= StringOpsKt.getESCAPE_MARKERS().length || (b9 = StringOpsKt.getESCAPE_MARKERS()[cCharAt]) == 0) {
                int i9 = iEnsureTotalCapacity + 1;
                this.charArray[iEnsureTotalCapacity] = cCharAt;
                currentSize = i9;
            } else {
                if (b9 == 1) {
                    String str = StringOpsKt.getESCAPE_STRINGS()[cCharAt];
                    p.b(str);
                    int iEnsureTotalCapacity2 = ensureTotalCapacity(iEnsureTotalCapacity, str.length());
                    str.getChars(0, str.length(), this.charArray, iEnsureTotalCapacity2);
                    currentSize = str.length() + iEnsureTotalCapacity2;
                } else {
                    char[] cArr = this.charArray;
                    cArr[iEnsureTotalCapacity] = AbstractJsonLexerKt.STRING_ESC;
                    cArr[iEnsureTotalCapacity + 1] = (char) b9;
                    currentSize = iEnsureTotalCapacity + 2;
                }
            }
        }
        ensureTotalCapacity(currentSize, 1);
        char[] cArr2 = this.charArray;
        cArr2[currentSize] = AbstractJsonLexerKt.STRING;
        writeUtf8(cArr2, currentSize + 1);
        flush();
    }

    private final void ensure(int bytesCount) throws IOException {
        if (this.buffer.length - this.indexInBuffer < bytesCount) {
            flush();
        }
    }

    private final int ensureTotalCapacity(int oldSize, int additional) {
        int i8 = additional + oldSize;
        char[] cArr = this.charArray;
        if (cArr.length <= i8) {
            int i9 = oldSize * 2;
            if (i8 < i9) {
                i8 = i9;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i8);
            p.d(cArrCopyOf, "copyOf(...)");
            this.charArray = cArrCopyOf;
        }
        return oldSize;
    }

    private final void flush() throws IOException {
        this.stream.write(this.buffer, 0, this.indexInBuffer);
        this.indexInBuffer = 0;
    }

    private final int rest() {
        return this.buffer.length - this.indexInBuffer;
    }

    private final void writeUtf8(char[] string, int count) throws IOException {
        if (count < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        if (count > string.length) {
            StringBuilder sbS = b.s(count, "count > string.length: ", " > ");
            sbS.append(string.length);
            throw new IllegalArgumentException(sbS.toString().toString());
        }
        int i8 = 0;
        while (i8 < count) {
            char c3 = string[i8];
            if (c3 < 128) {
                if (this.buffer.length - this.indexInBuffer < 1) {
                    flush();
                }
                byte[] bArr = this.buffer;
                int i9 = this.indexInBuffer;
                int i10 = i9 + 1;
                this.indexInBuffer = i10;
                bArr[i9] = (byte) c3;
                i8++;
                int iMin = Math.min(count, (bArr.length - i10) + i8);
                while (i8 < iMin) {
                    char c8 = string[i8];
                    if (c8 < 128) {
                        byte[] bArr2 = this.buffer;
                        int i11 = this.indexInBuffer;
                        this.indexInBuffer = i11 + 1;
                        bArr2[i11] = (byte) c8;
                        i8++;
                    }
                }
            } else {
                if (c3 < 2048) {
                    if (this.buffer.length - this.indexInBuffer < 2) {
                        flush();
                    }
                    int i12 = (c3 >> 6) | BERTags.PRIVATE;
                    byte[] bArr3 = this.buffer;
                    int i13 = this.indexInBuffer;
                    int i14 = i13 + 1;
                    this.indexInBuffer = i14;
                    bArr3[i13] = (byte) i12;
                    this.indexInBuffer = i13 + 2;
                    bArr3[i14] = (byte) ((c3 & '?') | 128);
                } else if (c3 < 55296 || c3 > 57343) {
                    if (this.buffer.length - this.indexInBuffer < 3) {
                        flush();
                    }
                    int i15 = (c3 >> '\f') | BERTags.FLAGS;
                    byte[] bArr4 = this.buffer;
                    int i16 = this.indexInBuffer;
                    int i17 = i16 + 1;
                    this.indexInBuffer = i17;
                    bArr4[i16] = (byte) i15;
                    int i18 = i16 + 2;
                    this.indexInBuffer = i18;
                    bArr4[i17] = (byte) (((c3 >> 6) & 63) | 128);
                    this.indexInBuffer = i16 + 3;
                    bArr4[i18] = (byte) ((c3 & '?') | 128);
                } else {
                    int i19 = i8 + 1;
                    char c9 = i19 < count ? string[i19] : (char) 0;
                    if (c3 > 56319 || 56320 > c9 || c9 >= 57344) {
                        if (this.buffer.length - this.indexInBuffer < 1) {
                            flush();
                        }
                        byte[] bArr5 = this.buffer;
                        int i20 = this.indexInBuffer;
                        this.indexInBuffer = i20 + 1;
                        bArr5[i20] = (byte) 63;
                        i8 = i19;
                    } else {
                        int i21 = (((c3 & 1023) << 10) | (c9 & 1023)) + 65536;
                        if (this.buffer.length - this.indexInBuffer < 4) {
                            flush();
                        }
                        byte[] bArr6 = this.buffer;
                        int i22 = this.indexInBuffer;
                        int i23 = i22 + 1;
                        this.indexInBuffer = i23;
                        bArr6[i22] = (byte) ((i21 >> 18) | 240);
                        int i24 = i22 + 2;
                        this.indexInBuffer = i24;
                        bArr6[i23] = (byte) (((i21 >> 12) & 63) | 128);
                        int i25 = i22 + 3;
                        this.indexInBuffer = i25;
                        bArr6[i24] = (byte) (((i21 >> 6) & 63) | 128);
                        this.indexInBuffer = i22 + 4;
                        bArr6[i25] = (byte) ((i21 & 63) | 128);
                        i8 += 2;
                    }
                }
                i8++;
            }
        }
    }

    private final void writeUtf8CodePoint(int codePoint) throws IOException {
        if (codePoint < 128) {
            if (this.buffer.length - this.indexInBuffer < 1) {
                flush();
            }
            byte[] bArr = this.buffer;
            int i8 = this.indexInBuffer;
            this.indexInBuffer = i8 + 1;
            bArr[i8] = (byte) codePoint;
            return;
        }
        if (codePoint < 2048) {
            if (this.buffer.length - this.indexInBuffer < 2) {
                flush();
            }
            int i9 = (codePoint >> 6) | BERTags.PRIVATE;
            byte[] bArr2 = this.buffer;
            int i10 = this.indexInBuffer;
            int i11 = i10 + 1;
            this.indexInBuffer = i11;
            bArr2[i10] = (byte) i9;
            this.indexInBuffer = i10 + 2;
            bArr2[i11] = (byte) ((codePoint & 63) | 128);
            return;
        }
        if (55296 <= codePoint && codePoint < 57344) {
            if (this.buffer.length - this.indexInBuffer < 1) {
                flush();
            }
            byte[] bArr3 = this.buffer;
            int i12 = this.indexInBuffer;
            this.indexInBuffer = i12 + 1;
            bArr3[i12] = (byte) 63;
            return;
        }
        if (codePoint < 65536) {
            if (this.buffer.length - this.indexInBuffer < 3) {
                flush();
            }
            int i13 = (codePoint >> 12) | BERTags.FLAGS;
            byte[] bArr4 = this.buffer;
            int i14 = this.indexInBuffer;
            int i15 = i14 + 1;
            this.indexInBuffer = i15;
            bArr4[i14] = (byte) i13;
            int i16 = i14 + 2;
            this.indexInBuffer = i16;
            bArr4[i15] = (byte) (((codePoint >> 6) & 63) | 128);
            this.indexInBuffer = i14 + 3;
            bArr4[i16] = (byte) ((codePoint & 63) | 128);
            return;
        }
        if (codePoint > 1114111) {
            throw new JsonEncodingException(b.j(codePoint, "Unexpected code point: "));
        }
        if (this.buffer.length - this.indexInBuffer < 4) {
            flush();
        }
        byte[] bArr5 = this.buffer;
        int i17 = this.indexInBuffer;
        int i18 = i17 + 1;
        this.indexInBuffer = i18;
        bArr5[i17] = (byte) ((codePoint >> 18) | 240);
        int i19 = i17 + 2;
        this.indexInBuffer = i19;
        bArr5[i18] = (byte) (((codePoint >> 12) & 63) | 128);
        int i20 = i17 + 3;
        this.indexInBuffer = i20;
        bArr5[i19] = (byte) (((codePoint >> 6) & 63) | 128);
        this.indexInBuffer = i17 + 4;
        bArr5[i20] = (byte) ((codePoint & 63) | 128);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void release() throws IOException {
        flush();
        CharArrayPool.INSTANCE.release(this.charArray);
        ByteArrayPool.INSTANCE.release(this.buffer);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void write(String text) throws IOException {
        p.e(text, "text");
        int length = text.length();
        ensureTotalCapacity(0, length);
        text.getChars(0, length, this.charArray, 0);
        writeUtf8(this.charArray, length);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeChar(char c3) throws IOException {
        writeUtf8CodePoint(c3);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeLong(long value) throws IOException {
        write(String.valueOf(value));
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeQuoted(String text) throws IOException {
        p.e(text, "text");
        ensureTotalCapacity(0, text.length() + 2);
        char[] cArr = this.charArray;
        cArr[0] = AbstractJsonLexerKt.STRING;
        int length = text.length();
        text.getChars(0, length, cArr, 1);
        int i8 = length + 1;
        for (int i9 = 1; i9 < i8; i9++) {
            char c3 = cArr[i9];
            if (c3 < StringOpsKt.getESCAPE_MARKERS().length && StringOpsKt.getESCAPE_MARKERS()[c3] != 0) {
                appendStringSlowPath(i9, text);
                return;
            }
        }
        cArr[i8] = AbstractJsonLexerKt.STRING;
        writeUtf8(cArr, length + 2);
        flush();
    }

    private final void write(int i8) {
        byte[] bArr = this.buffer;
        int i9 = this.indexInBuffer;
        this.indexInBuffer = i9 + 1;
        bArr[i9] = (byte) i8;
    }
}
