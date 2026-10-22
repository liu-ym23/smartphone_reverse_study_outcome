package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsUplinkCommitGate {

    /* renamed from: sb, reason: collision with root package name */
    private final StringBuilder f7236sb = new StringBuilder();

    private final String cutAt(int i10) {
        if (i10 >= this.f7236sb.length()) {
            return takeAll();
        }
        String strSubstring = this.f7236sb.substring(0, i10);
        String strSubstring2 = this.f7236sb.substring(i10);
        this.f7236sb.setLength(0);
        this.f7236sb.append(strSubstring2);
        kotlin.jvm.internal.g.c(strSubstring);
        return strSubstring;
    }

    private final void dropLeadingNewlines() {
        int i10 = 0;
        while (i10 < this.f7236sb.length() && (this.f7236sb.charAt(i10) == '\n' || this.f7236sb.charAt(i10) == '\r')) {
            i10++;
        }
        if (i10 > 0) {
            this.f7236sb.delete(0, i10);
        }
    }

    private final int extendPastOpenParen(int i10) {
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            char cCharAt = this.f7236sb.charAt(i12);
            if (cCharAt == '(') {
                i11++;
            } else if (cCharAt == ')' && i11 > 0) {
                i11--;
            }
        }
        if (i11 <= 0) {
            return i10;
        }
        while (i10 < this.f7236sb.length() && i11 > 0) {
            char cCharAt2 = this.f7236sb.charAt(i10);
            if (cCharAt2 == '(') {
                i11++;
            } else if (cCharAt2 == ')') {
                i11--;
            }
            i10++;
        }
        return i10;
    }

    public final void append(String text) {
        kotlin.jvm.internal.g.f(text, "text");
        if (text.length() > 0) {
            this.f7236sb.append(text);
        }
    }

    public final int bufferedLength() {
        return this.f7236sb.length();
    }

    public final boolean hasBuffered() {
        return this.f7236sb.length() > 0;
    }

    public final String takeAll() {
        String string = this.f7236sb.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        this.f7236sb.setLength(0);
        return string;
    }

    public final String takeCommittable(int i10, int i11) {
        dropLeadingNewlines();
        if (this.f7236sb.length() == 0) {
            return null;
        }
        if (i10 <= 0) {
            return takeAll();
        }
        int iIndexOf = this.f7236sb.indexOf("\n");
        if (iIndexOf >= 0) {
            while (true) {
                iIndexOf++;
                if (iIndexOf >= this.f7236sb.length() || (this.f7236sb.charAt(iIndexOf) != '\n' && this.f7236sb.charAt(iIndexOf) != '\r')) {
                    break;
                }
            }
            return cutAt(extendPastOpenParen(iIndexOf));
        }
        if (this.f7236sb.length() < i10) {
            return null;
        }
        int i12 = i10 - 1;
        if (i12 < 0) {
            i12 = 0;
        }
        TtsWsModels ttsWsModels = TtsWsModels.INSTANCE;
        int iSentenceBreakEndAtOrAfter = ttsWsModels.sentenceBreakEndAtOrAfter(this.f7236sb, i12);
        if (iSentenceBreakEndAtOrAfter <= 0) {
            iSentenceBreakEndAtOrAfter = ttsWsModels.anyBreakEndAtOrAfter(this.f7236sb, i12, false);
        }
        if (iSentenceBreakEndAtOrAfter <= 0) {
            if (this.f7236sb.length() < i11) {
                return null;
            }
            iSentenceBreakEndAtOrAfter = this.f7236sb.length();
        }
        return cutAt(extendPastOpenParen(iSentenceBreakEndAtOrAfter));
    }
}
