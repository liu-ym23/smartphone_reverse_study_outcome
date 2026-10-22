package kotlinx.serialization.json.internal;

import a6.w;
import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0010\u0018\u00002\u00020\u0001B\u001b\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0082\u0080\u0004J\u0012\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\u0012\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004J\n\u0010\u001d\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u001e\u001a\u00020\u0015H\u0096\u0080\u0004J\n\u0010\u001f\u001a\u00020 H\u0096\u0080\u0004J\u001a\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\rH\u0096\u0080\u0004J\u001a\u0010$\u001a\u00020 2\u0006\u0010#\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0096\u0080\u0004J\u001a\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\rH\u0094\u0080\u0004J\u001c\u0010)\u001a\u0004\u0018\u00010 2\u0006\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\u0013H\u0096\u0080\u0004J\n\u0010,\u001a\u00020\u0015H\u0086\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u00020\r8\u0004@\u0004X\u0085\u008e\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000e\u001a\u00020\u000fX\u0094\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006-"}, d2 = {"Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "reader", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "buffer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonReader;[C)V", "getReader", "()Lkotlinx/serialization/json/internal/InternalJsonReader;", "getBuffer", "()[C", "threshold", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ExtensionCallContract.SOURCE, "Lkotlinx/serialization/json/internal/ArrayAsSequence;", "getSource", "()Lkotlinx/serialization/json/internal/ArrayAsSequence;", "canConsumeValue", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "preload", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "unprocessedCount", "prefetchOrEof", "position", "consumeNextToken", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "expected", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "skipWhitespaces", "ensureHaveChars", "consumeKeyString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "indexOf", "char", "startPos", "substring", "endPos", "appendRange", "fromIndex", "toIndex", "peekLeadingMatchingValue", "keyToMatch", "isLenient", "release", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public class ReaderJsonLexer extends AbstractJsonLexer {
    private final char[] buffer;
    private final InternalJsonReader reader;
    private final ArrayAsSequence source;
    protected int threshold;

    public ReaderJsonLexer(InternalJsonReader reader, char[] buffer) {
        p.e(reader, "reader");
        p.e(buffer, "buffer");
        this.reader = reader;
        this.buffer = buffer;
        this.threshold = 128;
        this.source = new ArrayAsSequence(buffer);
        preload(0);
    }

    private final void preload(int unprocessedCount) {
        char[] buffer = getSource().getBuffer();
        if (unprocessedCount != 0) {
            int i8 = this.currentPosition;
            p.e(buffer, "<this>");
            System.arraycopy(buffer, i8, buffer, 0, (i8 + unprocessedCount) - i8);
        }
        int length = getSource().length();
        while (true) {
            if (unprocessedCount == length) {
                break;
            }
            int i9 = this.reader.read(buffer, unprocessedCount, length - unprocessedCount);
            if (i9 == -1) {
                getSource().trim(unprocessedCount);
                this.threshold = -1;
                break;
            }
            unprocessedCount += i9;
        }
        this.currentPosition = 0;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void appendRange(int fromIndex, int toIndex) {
        getEscapedString().append(getSource().getBuffer(), fromIndex, toIndex - fromIndex);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        ensureHaveChars();
        int i8 = this.currentPosition;
        while (true) {
            int iPrefetchOrEof = prefetchOrEof(i8);
            if (iPrefetchOrEof == -1) {
                this.currentPosition = iPrefetchOrEof;
                return false;
            }
            char cCharAt = getSource().charAt(iPrefetchOrEof);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = iPrefetchOrEof;
                return isValidValueStart(cCharAt);
            }
            i8 = iPrefetchOrEof + 1;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String consumeKeyString() {
        consumeNextToken(AbstractJsonLexerKt.STRING);
        int i8 = this.currentPosition;
        int iIndexOf = indexOf(AbstractJsonLexerKt.STRING, i8);
        if (iIndexOf != -1) {
            for (int i9 = i8; i9 < iIndexOf; i9++) {
                if (getSource().charAt(i9) == '\\') {
                    return consumeString(getSource(), this.currentPosition, i9);
                }
            }
            this.currentPosition = iIndexOf + 1;
            return substring(i8, iIndexOf);
        }
        int iPrefetchOrEof = prefetchOrEof(i8);
        if (iPrefetchOrEof != -1) {
            return consumeString(getSource(), this.currentPosition, iPrefetchOrEof);
        }
        String str = AbstractJsonLexerKt.tokenDescription((byte) 1);
        int i10 = this.currentPosition;
        int i11 = i10 - 1;
        AbstractJsonLexer.fail$default(this, b.q("Expected ", str, ", but had '", (i10 == getSource().length() || i11 < 0) ? "EOF" : String.valueOf(getSource().charAt(i11)), "' instead"), i11, null, 4, null);
        throw new w();
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int i8 = this.currentPosition;
        while (true) {
            int iPrefetchOrEof = prefetchOrEof(i8);
            if (iPrefetchOrEof == -1) {
                this.currentPosition = iPrefetchOrEof;
                return (byte) 10;
            }
            int i9 = iPrefetchOrEof + 1;
            byte bCharToTokenClass = AbstractJsonLexerKt.charToTokenClass(source.charAt(iPrefetchOrEof));
            if (bCharToTokenClass != 3) {
                this.currentPosition = i9;
                return bCharToTokenClass;
            }
            i8 = i9;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void ensureHaveChars() {
        int length = getSource().length() - this.currentPosition;
        if (length > this.threshold) {
            return;
        }
        preload(length);
    }

    public final char[] getBuffer() {
        return this.buffer;
    }

    public final InternalJsonReader getReader() {
        return this.reader;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int indexOf(char c3, int startPos) {
        ArrayAsSequence source = getSource();
        int length = source.length();
        while (startPos < length) {
            if (source.charAt(startPos) == c3) {
                return startPos;
            }
            startPos++;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String peekLeadingMatchingValue(String keyToMatch, boolean isLenient) {
        p.e(keyToMatch, "keyToMatch");
        return null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int prefetchOrEof(int position) {
        if (position < getSource().length()) {
            return position;
        }
        this.currentPosition = position;
        ensureHaveChars();
        return (this.currentPosition != 0 || getSource().length() == 0) ? -1 : 0;
    }

    public final void release() {
        CharArrayPoolBatchSize.INSTANCE.release(this.buffer);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int skipWhitespaces() {
        int iPrefetchOrEof;
        char cCharAt;
        int i8 = this.currentPosition;
        while (true) {
            iPrefetchOrEof = prefetchOrEof(i8);
            if (iPrefetchOrEof == -1 || !((cCharAt = getSource().charAt(iPrefetchOrEof)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
                break;
            }
            i8 = iPrefetchOrEof + 1;
        }
        this.currentPosition = iPrefetchOrEof;
        return iPrefetchOrEof;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String substring(int startPos, int endPos) {
        return getSource().substring(startPos, endPos);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public ArrayAsSequence getSource() {
        return this.source;
    }

    public /* synthetic */ ReaderJsonLexer(InternalJsonReader internalJsonReader, char[] cArr, int i8, i iVar) {
        this(internalJsonReader, (i8 & 2) != 0 ? CharArrayPoolBatchSize.INSTANCE.take() : cArr);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeNextToken(char expected) {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int i8 = this.currentPosition;
        while (true) {
            int iPrefetchOrEof = prefetchOrEof(i8);
            if (iPrefetchOrEof != -1) {
                int i9 = iPrefetchOrEof + 1;
                char cCharAt = source.charAt(iPrefetchOrEof);
                if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                    this.currentPosition = i9;
                    if (cCharAt == expected) {
                        return;
                    } else {
                        unexpectedToken(expected);
                    }
                }
                i8 = i9;
            } else {
                this.currentPosition = iPrefetchOrEof;
                unexpectedToken(expected);
                return;
            }
        }
    }
}
