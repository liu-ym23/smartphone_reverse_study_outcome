package kotlinx.serialization.json.internal;

import a6.w;
import a8.b;
import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import com.stepos.stepclaw.provider.contract.OperationResult;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m0.f;
import p5.l;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\b \u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r*\u00020\u000eH\u0084\u0088\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\rH\u0086\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH¦\u0080\u0004J\n\u0010\u0014\u001a\u00020\rH¦\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H¦\u0080\u0004J\n\u0010\u0017\u001a\u00020\rH\u0086\u0080\u0004J\u0012\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000eH\u0084\u0080\u0004J\n\u0010\u001a\u001a\u00020\u0010H\u0086\u0080\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016H\u0087\u0080\bJ\u0012\u0010\u0015\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u000eH¦\u0080\u0004J\u0012\u0010%\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u000eH\u0084\u0080\u0004J^\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00162\b\b\u0002\u0010)\u001a\u00020\r28\b\u0002\u0010*\u001a2\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u001c0+H\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b.J\n\u0010/\u001a\u00020\u0016H\u0096\u0080\u0004J\u0014\u00100\u001a\u00020\r2\b\b\u0002\u00101\u001a\u00020\rH\u0086\u0080\u0004J\n\u00102\u001a\u00020\tH¦\u0080\u0004J\u001c\u00103\u001a\u0004\u0018\u00010\u001c2\u0006\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\rH¦\u0080\u0004J\u0014\u00106\u001a\u0004\u0018\u00010\u001c2\u0006\u00105\u001a\u00020\rH\u0086\u0080\u0004J\n\u00107\u001a\u00020\u0010H\u0086\u0080\u0004J\u001a\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\tH\u0096\u0080\u0004J\u001a\u0010;\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010=\u001a\u00020\u001cH¦\u0080\u0004J\u001a\u0010>\u001a\u00020\r2\u0006\u00105\u001a\u00020\r2\u0006\u00109\u001a\u00020\u000eH\u0082\u0080\u0004J5\u0010?\u001a\u00020\u00102\u0006\u00105\u001a\u00020\r2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u00100AH\u0096\u0080\u0004JE\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\r2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u00100AH\u0082\u0080\u0004J\n\u0010G\u001a\u00020\u001cH\u0086\u0080\u0004J\"\u0010G\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\tH\u0085\u0080\u0004J\u001a\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\t2\u0006\u0010I\u001a\u00020\tH\u0082\u0080\u0004J\u001a\u0010L\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0082\u0080\u0004J\n\u0010M\u001a\u00020\u001cH\u0082\u0080\u0004J\n\u0010N\u001a\u00020\u001cH\u0086\u0080\u0004J\n\u0010O\u001a\u00020\rH\u0082\u0080\u0004J\n\u0010P\u001a\u00020\u001cH\u0086\u0080\u0004J\u001a\u0010Q\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\tH\u0094\u0080\u0004J\u0012\u0010R\u001a\u00020\t2\u0006\u0010H\u001a\u00020\tH\u0082\u0080\u0004J\u001a\u0010S\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\tH\u0082\u0080\u0004J2\u0010T\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0VH\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\bWJ\u001a\u0010X\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0082\u0080\u0004J\u0012\u0010Y\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020\rH\u0086\u0080\u0004J\n\u0010[\u001a\u00020\u001cH\u0096\u0080\u0004J\u0012\u0010\\\u001a\u00020\u00102\u0006\u0010]\u001a\u00020\u001cH\u0086\u0080\u0004J&\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010^\u001a\u00020\u001cH\u0086\u0080\u0004J\n\u0010_\u001a\u00020`H\u0086\u0080\u0004J\n\u0010a\u001a\u00020`H\u0086\u0080\u0004J\n\u0010b\u001a\u00020\rH\u0086\u0080\u0004J\n\u0010c\u001a\u00020\rH\u0086\u0080\u0004J\u0012\u0010b\u001a\u00020\r2\u0006\u0010d\u001a\u00020\tH\u0083\u0080\u0004J\u001a\u0010e\u001a\u00020\u00102\u0006\u0010f\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\tH\u0082\u0080\u0004J#\u0010g\u001a\u0002Hh\"\u0004\b\u0000\u0010h2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hh0VH\u0082\u0088\u0004¢\u0006\u0002\u0010jR\u0013\u0010\u0004\u001a\u00020\u0005X¤\u0084\b¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081\u008e\b¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001f\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fX\u0084\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006k"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", ExtensionCallContract.SOURCE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getSource", "()Ljava/lang/CharSequence;", "currentPosition", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "path", "Lkotlinx/serialization/json/internal/JsonPath;", "isWs", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "ensureHaveChars", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isNotEof", "prefetchOrEof", "position", "canConsumeValue", "consumeNextToken", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "tryConsumeComma", "isValidValueStart", "c", "expectEof", "peekedString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "escapedString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "expected", "unexpectedToken", "fail", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "expectedToken", "wasConsumed", OperationResult.EXTRA_MESSAGE, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "fail$kotlinx_serialization_json", "peekNextToken", "tryConsumeNull", "doConsume", "skipWhitespaces", "peekLeadingMatchingValue", "keyToMatch", "isLenient", "peekString", "discardPeeked", "indexOf", "char", "startPos", "substring", "endPos", "consumeKeyString", "insideString", "consumeStringChunked", "consumeChunk", "Lkotlin/Function1;", "stringChunk", "writeRange", "fromIndex", "toIndex", "currentChunkHasEscape", "consumeString", "startPosition", "current", "appendEscape", "lastPosition", "decodedString", "takePeeked", "consumeStringLenientNotNull", "wasUnquotedString", "consumeStringLenient", "appendRange", "appendEsc", "appendHex", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_json", "fromHexChar", "skipElement", "allowLenientStrings", "toString", "failOnUnknownKey", "key", "hint", "consumeNumericLiteral", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "consumeNumericLiteralFully", "consumeBoolean", "consumeBooleanLenient", "start", "consumeBooleanLiteral", "literalSuffix", "withPositionRollback", "T", "action", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AbstractJsonLexer {
    public int currentPosition;
    private String peekedString;
    public final JsonPath path = new JsonPath();
    private StringBuilder escapedString = new StringBuilder();

    private final int appendEsc(int startPosition) {
        int iPrefetchOrEof = prefetchOrEof(startPosition);
        if (iPrefetchOrEof == -1) {
            fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new w();
        }
        int i8 = iPrefetchOrEof + 1;
        char cCharAt = getSource().charAt(iPrefetchOrEof);
        if (cCharAt == 'u') {
            return appendHex(getSource(), i8);
        }
        char cEscapeToChar = AbstractJsonLexerKt.escapeToChar(cCharAt);
        if (cEscapeToChar != 0) {
            this.escapedString.append(cEscapeToChar);
            return i8;
        }
        fail$default(this, "Invalid escaped char '" + cCharAt + '\'', 0, null, 6, null);
        throw new w();
    }

    private final int appendEscape(int lastPosition, int current) {
        appendRange(lastPosition, current);
        return appendEsc(current + 1);
    }

    private final int appendHex(CharSequence source, int startPos) {
        int i8 = startPos + 4;
        if (i8 < source.length()) {
            this.escapedString.append((char) ((fromHexChar(source, startPos) << 12) + (fromHexChar(source, startPos + 1) << 8) + (fromHexChar(source, startPos + 2) << 4) + fromHexChar(source, startPos + 3)));
            return i8;
        }
        this.currentPosition = startPos;
        ensureHaveChars();
        if (this.currentPosition + 4 < source.length()) {
            return appendHex(source, this.currentPosition);
        }
        fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new w();
    }

    private final void consumeBooleanLiteral(String literalSuffix, int current) {
        if (getSource().length() - current < literalSuffix.length()) {
            fail$default(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new w();
        }
        int length = literalSuffix.length();
        for (int i8 = 0; i8 < length; i8++) {
            if (literalSuffix.charAt(i8) != (getSource().charAt(current + i8) | ' ')) {
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
                throw new w();
            }
        }
        this.currentPosition = literalSuffix.length() + current;
    }

    private static final double consumeNumericLiteral$calculateExponent(long j4, boolean z) {
        if (!z) {
            return Math.pow(10.0d, -j4);
        }
        if (z) {
            return Math.pow(10.0d, j4);
        }
        throw new w();
    }

    private final String decodedString(int lastPosition, int currentPosition) {
        appendRange(lastPosition, currentPosition);
        String string = this.escapedString.toString();
        p.d(string, "toString(...)");
        this.escapedString.setLength(0);
        return string;
    }

    public static /* synthetic */ Void fail$default(AbstractJsonLexer abstractJsonLexer, String str, int i8, String str2, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i9 & 2) != 0) {
            i8 = abstractJsonLexer.currentPosition;
        }
        if ((i9 & 4) != 0) {
            str2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        return abstractJsonLexer.fail(str, i8, str2);
    }

    public static Void fail$kotlinx_serialization_json$default(AbstractJsonLexer abstractJsonLexer, byte b9, boolean z, p5.p message, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i8 & 2) != 0) {
            z = true;
        }
        if ((i8 & 4) != 0) {
            message = new p5.p() { // from class: kotlinx.serialization.json.internal.AbstractJsonLexer.fail.1
                @Override // p5.p
                public final String invoke(String expected, String source) {
                    p.e(expected, "expected");
                    p.e(source, "source");
                    return "Expected " + expected + ", but had '" + source + "' instead";
                }
            };
        }
        p.e(message, "message");
        String str = AbstractJsonLexerKt.tokenDescription(b9);
        int i9 = z ? abstractJsonLexer.currentPosition - 1 : abstractJsonLexer.currentPosition;
        fail$default(abstractJsonLexer, (String) message.invoke(str, (abstractJsonLexer.currentPosition == abstractJsonLexer.getSource().length() || i9 < 0) ? "EOF" : String.valueOf(abstractJsonLexer.getSource().charAt(i9))), i9, null, 4, null);
        throw new w();
    }

    private final int fromHexChar(CharSequence source, int currentPosition) {
        char cCharAt = source.charAt(currentPosition);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        fail$default(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6, null);
        throw new w();
    }

    private final boolean insideString(boolean isLenient, char c3) {
        return isLenient ? AbstractJsonLexerKt.charToTokenClass(c3) == 0 : c3 != '\"';
    }

    public static void require$kotlinx_serialization_json$default(AbstractJsonLexer abstractJsonLexer, boolean z, int i8, p5.a message, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: require");
        }
        if ((i9 & 2) != 0) {
            i8 = abstractJsonLexer.currentPosition;
        }
        int i10 = i8;
        p.e(message, "message");
        if (z) {
            return;
        }
        fail$default(abstractJsonLexer, (String) message.invoke(), i10, null, 4, null);
        throw new w();
    }

    private final String takePeeked() {
        String str = this.peekedString;
        p.b(str);
        this.peekedString = null;
        return str;
    }

    public static /* synthetic */ boolean tryConsumeNull$default(AbstractJsonLexer abstractJsonLexer, boolean z, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if ((i8 & 1) != 0) {
            z = true;
        }
        return abstractJsonLexer.tryConsumeNull(z);
    }

    private final boolean wasUnquotedString() {
        return getSource().charAt(this.currentPosition - 1) != '\"';
    }

    private final <T> T withPositionRollback(p5.a aVar) {
        int i8 = this.currentPosition;
        try {
            return (T) aVar.invoke();
        } finally {
            this.currentPosition = i8;
        }
    }

    private final void writeRange(int i8, int i9, boolean z, l lVar) {
        if (z) {
            lVar.invoke(decodedString(i8, i9));
        } else {
            lVar.invoke(substring(i8, i9));
        }
    }

    public void appendRange(int fromIndex, int toIndex) {
        this.escapedString.append(getSource(), fromIndex, toIndex);
    }

    public abstract boolean canConsumeValue();

    public final boolean consumeBoolean() {
        return consumeBoolean(skipWhitespaces());
    }

    public final boolean consumeBooleanLenient() {
        boolean z;
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces == getSource().length()) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new w();
        }
        if (getSource().charAt(iSkipWhitespaces) == '\"') {
            iSkipWhitespaces++;
            z = true;
        } else {
            z = false;
        }
        boolean zConsumeBoolean = consumeBoolean(iSkipWhitespaces);
        if (!z) {
            return zConsumeBoolean;
        }
        if (this.currentPosition == getSource().length()) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new w();
        }
        if (getSource().charAt(this.currentPosition) == '\"') {
            this.currentPosition++;
            return zConsumeBoolean;
        }
        fail$default(this, "Expected closing quotation mark", 0, null, 6, null);
        throw new w();
    }

    public abstract String consumeKeyString();

    public abstract byte consumeNextToken();

    public final byte consumeNextToken(byte expected) {
        byte bConsumeNextToken = consumeNextToken();
        if (bConsumeNextToken == expected) {
            return bConsumeNextToken;
        }
        String str = AbstractJsonLexerKt.tokenDescription(expected);
        int i8 = this.currentPosition;
        int i9 = i8 - 1;
        fail$default(this, b.q("Expected ", str, ", but had '", (i8 == getSource().length() || i9 < 0) ? "EOF" : String.valueOf(getSource().charAt(i9)), "' instead"), i9, null, 4, null);
        throw new w();
    }

    public abstract void consumeNextToken(char expected);

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e8, code lost:
    
        fail$default(r18, "Expected numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01f8, code lost:
    
        throw new a6.w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0117, code lost:
    
        fail$default(r18, "Unexpected symbol '" + r15 + "' in numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0138, code lost:
    
        throw new a6.w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0139, code lost:
    
        if (r2 == r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013b, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x013d, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x013e, code lost:
    
        if (r1 == r2) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0140, code lost:
    
        if (r9 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0144, code lost:
    
        if (r1 == (r2 - 1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0146, code lost:
    
        if (r0 == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0148, code lost:
    
        if (r4 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0152, code lost:
    
        if (getSource().charAt(r2) != '\"') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0154, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0159, code lost:
    
        fail$default(r18, "Expected closing quotation mark", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0169, code lost:
    
        throw new a6.w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x016a, code lost:
    
        fail$default(r18, "EOF", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x017a, code lost:
    
        throw new a6.w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x017b, code lost:
    
        r18.currentPosition = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x017d, code lost:
    
        if (r8 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x017f, code lost:
    
        r1 = r10 * consumeNumericLiteral$calculateExponent(r12, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0189, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x018f, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0197, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0199, code lost:
    
        r10 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x019b, code lost:
    
        fail$default(r18, "Can't convert " + r1 + " to Long", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01ba, code lost:
    
        throw new a6.w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01bb, code lost:
    
        fail$default(r18, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cb, code lost:
    
        throw new a6.w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cc, code lost:
    
        if (r9 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ce, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d3, code lost:
    
        if (r10 == Long.MIN_VALUE) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01d6, code lost:
    
        return -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01d7, code lost:
    
        fail$default(r18, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e7, code lost:
    
        throw new a6.w();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long consumeNumericLiteral() {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonLexer.consumeNumericLiteral():long");
    }

    public final long consumeNumericLiteralFully() {
        long jConsumeNumericLiteral = consumeNumericLiteral();
        if (consumeNextToken() == 10) {
            return jConsumeNumericLiteral;
        }
        AbstractJsonLexerKt.tokenDescription((byte) 10);
        int i8 = this.currentPosition;
        int i9 = i8 - 1;
        fail$default(this, f.d("Expected input to contain a single valid number, but got '", (i8 == getSource().length() || i9 < 0) ? "EOF" : String.valueOf(getSource().charAt(i9)), "' after it"), i9, null, 4, null);
        throw new w();
    }

    public final String consumeString() {
        return this.peekedString != null ? takePeeked() : consumeKeyString();
    }

    public void consumeStringChunked(boolean z, l consumeChunk) {
        int i8;
        int iPrefetchOrEof;
        p.e(consumeChunk, "consumeChunk");
        byte bPeekNextToken = peekNextToken();
        if (!z || bPeekNextToken == 0) {
            if (!z) {
                consumeNextToken(AbstractJsonLexerKt.STRING);
            }
            int i9 = this.currentPosition;
            char cCharAt = getSource().charAt(i9);
            boolean z2 = false;
            int i10 = i9;
            while (this.insideString(z, cCharAt)) {
                if (z || cCharAt != '\\') {
                    int i11 = i10 + 1;
                    i8 = i9;
                    iPrefetchOrEof = i11;
                } else {
                    iPrefetchOrEof = this.prefetchOrEof(this.appendEscape(i9, i10));
                    z2 = true;
                    i8 = iPrefetchOrEof;
                }
                if (iPrefetchOrEof >= this.getSource().length()) {
                    this.writeRange(i8, iPrefetchOrEof, z2, consumeChunk);
                    int iPrefetchOrEof2 = this.prefetchOrEof(iPrefetchOrEof);
                    if (iPrefetchOrEof2 == -1) {
                        fail$default(this, "EOF", iPrefetchOrEof2, null, 4, null);
                        throw new w();
                    }
                    z2 = false;
                    i9 = iPrefetchOrEof2;
                    i10 = i9;
                } else {
                    int i12 = i8;
                    i10 = iPrefetchOrEof;
                    i9 = i12;
                }
                AbstractJsonLexer abstractJsonLexer = this;
                cCharAt = abstractJsonLexer.getSource().charAt(i10);
                this = abstractJsonLexer;
            }
            AbstractJsonLexer abstractJsonLexer2 = this;
            abstractJsonLexer2.writeRange(i9, i10, z2, consumeChunk);
            abstractJsonLexer2.currentPosition = i10;
            if (z) {
                return;
            }
            abstractJsonLexer2.consumeNextToken(AbstractJsonLexerKt.STRING);
        }
    }

    public final String consumeStringLenient() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces >= getSource().length() || iSkipWhitespaces == -1) {
            fail$default(this, "EOF", iSkipWhitespaces, null, 4, null);
            throw new w();
        }
        byte bCharToTokenClass = AbstractJsonLexerKt.charToTokenClass(getSource().charAt(iSkipWhitespaces));
        if (bCharToTokenClass == 1) {
            return consumeString();
        }
        if (bCharToTokenClass != 0) {
            fail$default(this, "Expected beginning of the string, but got " + getSource().charAt(iSkipWhitespaces), 0, null, 6, null);
            throw new w();
        }
        boolean z = false;
        while (AbstractJsonLexerKt.charToTokenClass(getSource().charAt(iSkipWhitespaces)) == 0) {
            iSkipWhitespaces++;
            if (iSkipWhitespaces >= getSource().length()) {
                appendRange(this.currentPosition, iSkipWhitespaces);
                int iPrefetchOrEof = prefetchOrEof(iSkipWhitespaces);
                if (iPrefetchOrEof == -1) {
                    this.currentPosition = iSkipWhitespaces;
                    return decodedString(0, 0);
                }
                iSkipWhitespaces = iPrefetchOrEof;
                z = true;
            }
        }
        String strSubstring = !z ? substring(this.currentPosition, iSkipWhitespaces) : decodedString(this.currentPosition, iSkipWhitespaces);
        this.currentPosition = iSkipWhitespaces;
        return strSubstring;
    }

    public final String consumeStringLenientNotNull() {
        String strConsumeStringLenient = consumeStringLenient();
        if (!p.a(strConsumeStringLenient, AbstractJsonLexerKt.NULL) || !wasUnquotedString()) {
            return strConsumeStringLenient;
        }
        fail$default(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new w();
    }

    public final void discardPeeked() {
        this.peekedString = null;
    }

    public final void expectEof() {
        if (consumeNextToken() == 10) {
            return;
        }
        fail$default(this, "Expected EOF after parsing, but had " + getSource().charAt(this.currentPosition - 1) + " instead", 0, null, 6, null);
        throw new w();
    }

    public final Void fail(String message, int position, String hint) {
        p.e(message, "message");
        p.e(hint, "hint");
        throw JsonExceptionsKt.JsonDecodingException(position, message + " at path: " + this.path.getPath() + (hint.length() == 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : "\n".concat(hint)), getSource());
    }

    public final Void fail$kotlinx_serialization_json(byte b9, boolean z, p5.p message) {
        p.e(message, "message");
        String str = AbstractJsonLexerKt.tokenDescription(b9);
        int i8 = z ? this.currentPosition - 1 : this.currentPosition;
        fail$default(this, (String) message.invoke(str, (this.currentPosition == getSource().length() || i8 < 0) ? "EOF" : String.valueOf(getSource().charAt(i8))), i8, null, 4, null);
        throw new w();
    }

    public final void failOnUnknownKey(String key) {
        p.e(key, "key");
        int iV1 = n.v1(6, substring(0, this.currentPosition), key);
        StringBuilder sbU = b.u("Encountered an unknown key '", iV1, key, "' at offset ", " at path: ");
        sbU.append(this.path.getPath());
        sbU.append("\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder or '@JsonIgnoreUnknownKeys' annotation to ignore unknown keys.\nJSON input: ");
        sbU.append((Object) JsonExceptionsKt.minify(getSource(), iV1));
        throw new JsonDecodingException(sbU.toString());
    }

    public final StringBuilder getEscapedString() {
        return this.escapedString;
    }

    public abstract CharSequence getSource();

    public int indexOf(char c3, int startPos) {
        return n.q1(getSource(), c3, startPos, 4);
    }

    public final boolean isNotEof() {
        return peekNextToken() != 10;
    }

    public final boolean isValidValueStart(char c3) {
        return (c3 == ',' || c3 == ':' || c3 == ']' || c3 == '}') ? false : true;
    }

    public final boolean isWs(char c3) {
        return c3 == ' ' || c3 == '\n' || c3 == '\r' || c3 == '\t';
    }

    public abstract String peekLeadingMatchingValue(String keyToMatch, boolean isLenient);

    public byte peekNextToken() {
        CharSequence source = getSource();
        int i8 = this.currentPosition;
        while (true) {
            int iPrefetchOrEof = prefetchOrEof(i8);
            if (iPrefetchOrEof == -1) {
                this.currentPosition = iPrefetchOrEof;
                return (byte) 10;
            }
            char cCharAt = source.charAt(iPrefetchOrEof);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.currentPosition = iPrefetchOrEof;
                return AbstractJsonLexerKt.charToTokenClass(cCharAt);
            }
            i8 = iPrefetchOrEof + 1;
        }
    }

    public final String peekString(boolean isLenient) {
        String strConsumeString;
        byte bPeekNextToken = peekNextToken();
        if (isLenient) {
            if (bPeekNextToken != 1 && bPeekNextToken != 0) {
                return null;
            }
            strConsumeString = consumeStringLenient();
        } else {
            if (bPeekNextToken != 1) {
                return null;
            }
            strConsumeString = consumeString();
        }
        this.peekedString = strConsumeString;
        return strConsumeString;
    }

    public abstract int prefetchOrEof(int position);

    public final void require$kotlinx_serialization_json(boolean z, int i8, p5.a message) {
        p.e(message, "message");
        if (z) {
            return;
        }
        fail$default(this, (String) message.invoke(), i8, null, 4, null);
        throw new w();
    }

    public final void setEscapedString(StringBuilder sb) {
        p.e(sb, "<set-?>");
        this.escapedString = sb;
    }

    public final void skipElement(boolean allowLenientStrings) {
        AbstractJsonLexer abstractJsonLexer;
        ArrayList arrayList = new ArrayList();
        byte bPeekNextToken = peekNextToken();
        if (bPeekNextToken != 8 && bPeekNextToken != 6) {
            consumeStringLenient();
            return;
        }
        while (true) {
            byte bPeekNextToken2 = this.peekNextToken();
            if (bPeekNextToken2 != 1) {
                if (bPeekNextToken2 == 8 || bPeekNextToken2 == 6) {
                    abstractJsonLexer = this;
                    arrayList.add(Byte.valueOf(bPeekNextToken2));
                } else {
                    if (bPeekNextToken2 == 9) {
                        if (((Number) m.B0(arrayList)).byteValue() != 8) {
                            throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found ] instead of } at path: " + this.path, this.getSource());
                        }
                        if (arrayList.isEmpty()) {
                            throw new NoSuchElementException("List is empty.");
                        }
                        arrayList.remove(c5.n.j0(arrayList));
                    } else if (bPeekNextToken2 == 7) {
                        if (((Number) m.B0(arrayList)).byteValue() != 6) {
                            throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found } instead of ] at path: " + this.path, this.getSource());
                        }
                        if (arrayList.isEmpty()) {
                            throw new NoSuchElementException("List is empty.");
                        }
                        arrayList.remove(c5.n.j0(arrayList));
                    } else if (bPeekNextToken2 == 10) {
                        fail$default(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                        throw new w();
                    }
                    abstractJsonLexer = this;
                }
                abstractJsonLexer.consumeNextToken();
                if (arrayList.size() == 0) {
                    return;
                } else {
                    this = abstractJsonLexer;
                }
            } else if (allowLenientStrings) {
                this.consumeStringLenient();
            } else {
                this.consumeKeyString();
            }
        }
    }

    public abstract int skipWhitespaces();

    public String substring(int startPos, int endPos) {
        return getSource().subSequence(startPos, endPos).toString();
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) getSource()) + "', currentPosition=" + this.currentPosition + ')';
    }

    public final boolean tryConsumeComma() {
        int iSkipWhitespaces = skipWhitespaces();
        CharSequence source = getSource();
        if (iSkipWhitespaces >= source.length() || iSkipWhitespaces == -1 || source.charAt(iSkipWhitespaces) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    public final boolean tryConsumeNull(boolean doConsume) {
        int iPrefetchOrEof = prefetchOrEof(skipWhitespaces());
        int length = getSource().length() - iPrefetchOrEof;
        if (length < 4 || iPrefetchOrEof == -1) {
            return false;
        }
        for (int i8 = 0; i8 < 4; i8++) {
            if (AbstractJsonLexerKt.NULL.charAt(i8) != getSource().charAt(iPrefetchOrEof + i8)) {
                return false;
            }
        }
        if (length > 4 && AbstractJsonLexerKt.charToTokenClass(getSource().charAt(iPrefetchOrEof + 4)) == 0) {
            return false;
        }
        if (!doConsume) {
            return true;
        }
        this.currentPosition = iPrefetchOrEof + 4;
        return true;
    }

    public final void unexpectedToken(char expected) {
        int i8 = this.currentPosition;
        if (i8 > 0 && expected == '\"') {
            try {
                this.currentPosition = i8 - 1;
                String strConsumeStringLenient = consumeStringLenient();
                this.currentPosition = i8;
                if (p.a(strConsumeStringLenient, AbstractJsonLexerKt.NULL)) {
                    fail("Expected string literal but 'null' literal was found", this.currentPosition - 1, AbstractJsonLexerKt.coerceInputValuesHint);
                    throw new w();
                }
            } catch (Throwable th) {
                this.currentPosition = i8;
                throw th;
            }
        }
        String str = AbstractJsonLexerKt.tokenDescription(AbstractJsonLexerKt.charToTokenClass(expected));
        int i9 = this.currentPosition;
        int i10 = i9 - 1;
        fail$default(this, b.q("Expected ", str, ", but had '", (i9 == getSource().length() || i10 < 0) ? "EOF" : String.valueOf(getSource().charAt(i10)), "' instead"), i10, null, 4, null);
        throw new w();
    }

    private final boolean consumeBoolean(int start) {
        int iPrefetchOrEof = prefetchOrEof(start);
        if (iPrefetchOrEof >= getSource().length() || iPrefetchOrEof == -1) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new w();
        }
        int i8 = iPrefetchOrEof + 1;
        int iCharAt = getSource().charAt(iPrefetchOrEof) | ' ';
        if (iCharAt == 102) {
            consumeBooleanLiteral("alse", i8);
            return false;
        }
        if (iCharAt == 116) {
            consumeBooleanLiteral("rue", i8);
            return true;
        }
        fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
        throw new w();
    }

    public final String consumeString(CharSequence source, int startPosition, int current) {
        String strDecodedString;
        AbstractJsonLexer abstractJsonLexer;
        p.e(source, "source");
        char cCharAt = source.charAt(current);
        boolean z = false;
        while (cCharAt != '\"') {
            if (cCharAt == '\\') {
                int iPrefetchOrEof = this.prefetchOrEof(this.appendEscape(startPosition, current));
                if (iPrefetchOrEof == -1) {
                    fail$default(this, "Unexpected EOF", iPrefetchOrEof, null, 4, null);
                    throw new w();
                }
                abstractJsonLexer = this;
                z = true;
                startPosition = iPrefetchOrEof;
                current = startPosition;
            } else {
                abstractJsonLexer = this;
                current++;
                if (current >= source.length()) {
                    abstractJsonLexer.appendRange(startPosition, current);
                    int iPrefetchOrEof2 = abstractJsonLexer.prefetchOrEof(current);
                    if (iPrefetchOrEof2 == -1) {
                        fail$default(abstractJsonLexer, "Unexpected EOF", iPrefetchOrEof2, null, 4, null);
                        throw new w();
                    }
                    startPosition = iPrefetchOrEof2;
                    current = startPosition;
                    z = true;
                } else {
                    continue;
                }
            }
            AbstractJsonLexer abstractJsonLexer2 = abstractJsonLexer;
            cCharAt = source.charAt(current);
            this = abstractJsonLexer2;
        }
        AbstractJsonLexer abstractJsonLexer3 = this;
        if (!z) {
            strDecodedString = abstractJsonLexer3.substring(startPosition, current);
        } else {
            strDecodedString = abstractJsonLexer3.decodedString(startPosition, current);
        }
        abstractJsonLexer3.currentPosition = current + 1;
        return strDecodedString;
    }

    public void ensureHaveChars() {
    }
}
