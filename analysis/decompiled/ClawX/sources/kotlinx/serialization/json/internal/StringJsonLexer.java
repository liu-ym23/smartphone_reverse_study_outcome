package kotlinx.serialization.json.internal;

import a6.w;
import a8.b;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p5.l;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010\u000b\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\tH\u0096\u0080\u0004J\u0012\u0010\u000b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0003H\u0096\u0080\u0004J5\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00100\u0017H\u0096\u0080\u0004J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000eH\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0094\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/json/internal/StringJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", ExtensionCallContract.SOURCE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "prefetchOrEof", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "position", "consumeNextToken", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "canConsumeValue", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "skipWhitespaces", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "expected", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "consumeKeyString", "consumeStringChunked", "isLenient", "consumeChunk", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "stringChunk", "peekLeadingMatchingValue", "keyToMatch", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public class StringJsonLexer extends AbstractJsonLexer {
    private final String source;

    public StringJsonLexer(String source) {
        p.e(source, "source");
        this.source = source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        int i8 = this.currentPosition;
        if (i8 == -1) {
            return false;
        }
        String source = getSource();
        while (i8 < source.length()) {
            char cCharAt = source.charAt(i8);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = i8;
                return isValidValueStart(cCharAt);
            }
            i8++;
        }
        this.currentPosition = i8;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String consumeKeyString() {
        consumeNextToken(AbstractJsonLexerKt.STRING);
        int i8 = this.currentPosition;
        int iQ1 = n.q1(getSource(), AbstractJsonLexerKt.STRING, i8, 4);
        if (iQ1 == -1) {
            consumeStringLenient();
            String str = AbstractJsonLexerKt.tokenDescription((byte) 1);
            int i9 = this.currentPosition;
            AbstractJsonLexer.fail$default(this, b.q("Expected ", str, ", but had '", (i9 == getSource().length() || i9 < 0) ? "EOF" : String.valueOf(getSource().charAt(i9)), "' instead"), i9, null, 4, null);
            throw new w();
        }
        for (int i10 = i8; i10 < iQ1; i10++) {
            if (getSource().charAt(i10) == '\\') {
                return consumeString(getSource(), this.currentPosition, i10);
            }
        }
        this.currentPosition = iQ1 + 1;
        String strSubstring = getSource().substring(i8, iQ1);
        p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        String source = getSource();
        int i8 = this.currentPosition;
        while (i8 != -1 && i8 < source.length()) {
            int i9 = i8 + 1;
            char cCharAt = source.charAt(i8);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = i9;
                return AbstractJsonLexerKt.charToTokenClass(cCharAt);
            }
            i8 = i9;
        }
        this.currentPosition = source.length();
        return (byte) 10;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeStringChunked(boolean z, l consumeChunk) {
        p.e(consumeChunk, "consumeChunk");
        String strConsumeStringLenient = z ? consumeStringLenient() : consumeString();
        p.e(strConsumeStringLenient, "<this>");
        h.f(ReaderJsonLexerKt.BATCH_SIZE, ReaderJsonLexerKt.BATCH_SIZE);
        int length = strConsumeStringLenient.length();
        int i8 = 0;
        ArrayList arrayList = new ArrayList((length / ReaderJsonLexerKt.BATCH_SIZE) + (length % ReaderJsonLexerKt.BATCH_SIZE == 0 ? 0 : 1));
        int i9 = 0;
        while (i9 >= 0 && i9 < length) {
            int i10 = i9 + ReaderJsonLexerKt.BATCH_SIZE;
            CharSequence it = strConsumeStringLenient.subSequence(i9, (i10 < 0 || i10 > length) ? length : i10);
            p.e(it, "it");
            arrayList.add(it.toString());
            i9 = i10;
        }
        int size = arrayList.size();
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            consumeChunk.invoke(obj);
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String peekLeadingMatchingValue(String keyToMatch, boolean isLenient) {
        p.e(keyToMatch, "keyToMatch");
        int i8 = this.currentPosition;
        try {
            if (consumeNextToken() == 6 && p.a(peekString(isLenient), keyToMatch)) {
                discardPeeked();
                if (consumeNextToken() == 5) {
                    return peekString(isLenient);
                }
            }
            return null;
        } finally {
            this.currentPosition = i8;
            discardPeeked();
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int prefetchOrEof(int position) {
        if (position < getSource().length()) {
            return position;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int skipWhitespaces() {
        char cCharAt;
        int i8 = this.currentPosition;
        if (i8 == -1) {
            return i8;
        }
        String source = getSource();
        while (i8 < source.length() && ((cCharAt = source.charAt(i8)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i8++;
        }
        this.currentPosition = i8;
        return i8;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public String getSource() {
        return this.source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeNextToken(char expected) {
        if (this.currentPosition == -1) {
            unexpectedToken(expected);
        }
        String source = getSource();
        int i8 = this.currentPosition;
        while (i8 < source.length()) {
            int i9 = i8 + 1;
            char cCharAt = source.charAt(i8);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = i9;
                if (cCharAt == expected) {
                    return;
                } else {
                    unexpectedToken(expected);
                }
            }
            i8 = i9;
        }
        this.currentPosition = -1;
        unexpectedToken(expected);
    }
}
