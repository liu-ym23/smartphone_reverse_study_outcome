package kotlinx.serialization.json.internal;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\u0012\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0011H\u0082\u0080\u0004J\n\u0010\u0017\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010\u0018\u001a\u00020\u0011H\u0096\u0080\u0004J\u0012\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0007H\u0082\u0080\u0004J\u001a\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0083\u0080\bR\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/serialization/json/internal/JsonToStringWriter;", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "<init>", "()V", "array", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "size", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeLong", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "value", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeChar", "char", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "write", "text", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeQuoted", "appendStringSlowPath", "firstEscapedChar", "currentSize", "string", "release", "toString", "ensureAdditionalCapacity", "expected", "ensureTotalCapacity", "oldSize", "additional", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonToStringWriter implements InternalJsonWriter {
    private char[] array = CharArrayPool.INSTANCE.take();
    private int size;

    private final void appendStringSlowPath(int firstEscapedChar, int currentSize, String string) {
        byte b9;
        int length = string.length();
        while (firstEscapedChar < length) {
            int iEnsureTotalCapacity = ensureTotalCapacity(currentSize, 2);
            char cCharAt = string.charAt(firstEscapedChar);
            if (cCharAt >= StringOpsKt.getESCAPE_MARKERS().length || (b9 = StringOpsKt.getESCAPE_MARKERS()[cCharAt]) == 0) {
                int i8 = iEnsureTotalCapacity + 1;
                this.array[iEnsureTotalCapacity] = cCharAt;
                currentSize = i8;
                firstEscapedChar++;
            } else {
                if (b9 == 1) {
                    String str = StringOpsKt.getESCAPE_STRINGS()[cCharAt];
                    p.b(str);
                    int iEnsureTotalCapacity2 = ensureTotalCapacity(iEnsureTotalCapacity, str.length());
                    str.getChars(0, str.length(), this.array, iEnsureTotalCapacity2);
                    int length2 = str.length() + iEnsureTotalCapacity2;
                    this.size = length2;
                    currentSize = length2;
                } else {
                    char[] cArr = this.array;
                    cArr[iEnsureTotalCapacity] = AbstractJsonLexerKt.STRING_ESC;
                    cArr[iEnsureTotalCapacity + 1] = (char) b9;
                    currentSize = iEnsureTotalCapacity + 2;
                    this.size = currentSize;
                }
                firstEscapedChar++;
            }
        }
        int iEnsureTotalCapacity3 = ensureTotalCapacity(currentSize, 1);
        this.array[iEnsureTotalCapacity3] = AbstractJsonLexerKt.STRING;
        this.size = iEnsureTotalCapacity3 + 1;
    }

    private final void ensureAdditionalCapacity(int expected) {
        ensureTotalCapacity(this.size, expected);
    }

    private final int ensureTotalCapacity(int oldSize, int additional) {
        int i8 = additional + oldSize;
        char[] cArr = this.array;
        if (cArr.length <= i8) {
            int i9 = oldSize * 2;
            if (i8 < i9) {
                i8 = i9;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i8);
            p.d(cArrCopyOf, "copyOf(...)");
            this.array = cArrCopyOf;
        }
        return oldSize;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void release() {
        CharArrayPool.INSTANCE.release(this.array);
    }

    public String toString() {
        return new String(this.array, 0, this.size);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void write(String text) {
        p.e(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        ensureAdditionalCapacity(length);
        text.getChars(0, text.length(), this.array, this.size);
        this.size += length;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeChar(char c3) {
        ensureAdditionalCapacity(1);
        char[] cArr = this.array;
        int i8 = this.size;
        this.size = i8 + 1;
        cArr[i8] = c3;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeLong(long value) {
        write(String.valueOf(value));
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeQuoted(String text) {
        p.e(text, "text");
        ensureAdditionalCapacity(text.length() + 2);
        char[] cArr = this.array;
        int i8 = this.size;
        int i9 = i8 + 1;
        cArr[i8] = AbstractJsonLexerKt.STRING;
        int length = text.length();
        text.getChars(0, length, cArr, i9);
        int i10 = length + i9;
        for (int i11 = i9; i11 < i10; i11++) {
            char c3 = cArr[i11];
            if (c3 < StringOpsKt.getESCAPE_MARKERS().length && StringOpsKt.getESCAPE_MARKERS()[c3] != 0) {
                appendStringSlowPath(i11 - i9, i11, text);
                return;
            }
        }
        cArr[i10] = AbstractJsonLexerKt.STRING;
        this.size = i10 + 1;
    }
}
