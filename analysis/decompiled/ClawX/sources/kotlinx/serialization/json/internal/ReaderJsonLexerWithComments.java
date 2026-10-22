package kotlinx.serialization.json.internal;

import a6.w;
import b5.g;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\b\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u000eH\u0096\u0080\u0004J\u001e\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0082\u0080\u0004J\u0012\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0082\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0012H\u0096\u0080\u0004¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/json/internal/ReaderJsonLexerWithComments;", "Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "reader", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "buffer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonReader;[C)V", "consumeNextToken", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "expected", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "canConsumeValue", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "peekNextToken", "handleComment", "Lkotlin/Pair;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "position", "prefetchWithinThreshold", "skipWhitespaces", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ReaderJsonLexerWithComments extends ReaderJsonLexer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderJsonLexerWithComments(InternalJsonReader reader, char[] buffer) {
        super(reader, buffer);
        p.e(reader, "reader");
        p.e(buffer, "buffer");
    }

    private final g handleComment(int i8) {
        int iPrefetchOrEof = i8 + 2;
        char cCharAt = getSource().charAt(i8 + 1);
        if (cCharAt != '*') {
            if (cCharAt != '/') {
                return new g(Integer.valueOf(i8), Boolean.FALSE);
            }
            while (i8 != -1) {
                int iQ1 = n.q1(getSource(), '\n', iPrefetchOrEof, 4);
                if (iQ1 != -1) {
                    return new g(Integer.valueOf(iQ1 + 1), Boolean.TRUE);
                }
                iPrefetchOrEof = prefetchOrEof(getSource().length());
                i8 = iPrefetchOrEof;
            }
            return new g(-1, Boolean.TRUE);
        }
        boolean z = false;
        while (i8 != -1) {
            int iR1 = n.r1(getSource(), "*/", iPrefetchOrEof, false, 4);
            if (iR1 == -1) {
                if (getSource().charAt(getSource().length() - 1) == '*') {
                    iPrefetchOrEof = prefetchWithinThreshold(getSource().length() - 1);
                    if (z) {
                        break;
                    }
                    i8 = iPrefetchOrEof;
                    z = true;
                } else {
                    iPrefetchOrEof = prefetchOrEof(getSource().length());
                    i8 = iPrefetchOrEof;
                }
            } else {
                return new g(Integer.valueOf(iR1 + 2), Boolean.TRUE);
            }
        }
        this.currentPosition = getSource().length();
        AbstractJsonLexer.fail$default(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6, null);
        throw new w();
    }

    private final int prefetchWithinThreshold(int position) {
        if (getSource().length() - position > this.threshold) {
            return position;
        }
        this.currentPosition = position;
        ensureHaveChars();
        return (this.currentPosition != 0 || getSource().length() == 0) ? -1 : 0;
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        ensureHaveChars();
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces >= getSource().length() || iSkipWhitespaces == -1) {
            return false;
        }
        return isValidValueStart(getSource().charAt(iSkipWhitespaces));
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeNextToken(char expected) {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces >= source.length() || iSkipWhitespaces == -1) {
            this.currentPosition = -1;
            unexpectedToken(expected);
        }
        char cCharAt = source.charAt(iSkipWhitespaces);
        this.currentPosition = iSkipWhitespaces + 1;
        if (cCharAt == expected) {
            return;
        }
        unexpectedToken(expected);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte peekNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces >= source.length() || iSkipWhitespaces == -1) {
            return (byte) 10;
        }
        this.currentPosition = iSkipWhitespaces;
        return AbstractJsonLexerKt.charToTokenClass(source.charAt(iSkipWhitespaces));
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public int skipWhitespaces() {
        int iPrefetchOrEof;
        int i8 = this.currentPosition;
        while (true) {
            iPrefetchOrEof = prefetchOrEof(i8);
            if (iPrefetchOrEof == -1) {
                break;
            }
            char cCharAt = getSource().charAt(iPrefetchOrEof);
            if (cCharAt == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t') {
                i8 = iPrefetchOrEof + 1;
            } else {
                if (cCharAt != '/' || iPrefetchOrEof + 1 >= getSource().length()) {
                    break;
                }
                g gVarHandleComment = handleComment(iPrefetchOrEof);
                int iIntValue = ((Number) gVarHandleComment.f892a).intValue();
                if (!((Boolean) gVarHandleComment.f893b).booleanValue()) {
                    iPrefetchOrEof = iIntValue;
                    break;
                }
                i8 = iIntValue;
            }
        }
        this.currentPosition = iPrefetchOrEof;
        return iPrefetchOrEof;
    }

    @Override // kotlinx.serialization.json.internal.ReaderJsonLexer, kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        ensureHaveChars();
        ArrayAsSequence source = getSource();
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces >= source.length() || iSkipWhitespaces == -1) {
            return (byte) 10;
        }
        this.currentPosition = iSkipWhitespaces + 1;
        return AbstractJsonLexerKt.charToTokenClass(source.charAt(iSkipWhitespaces));
    }
}
