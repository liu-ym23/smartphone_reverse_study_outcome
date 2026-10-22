package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsUplinkParenBuffer {

    /* renamed from: sb, reason: collision with root package name */
    private final StringBuilder f7237sb = new StringBuilder();

    private final int firstUnclosedParenIndex() {
        int length = this.f7237sb.length();
        int i10 = 0;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            char cCharAt = this.f7237sb.charAt(i12);
            if (cCharAt == '(') {
                if (i10 == 0) {
                    i11 = i12;
                }
                i10++;
            } else if (cCharAt == ')' && i10 > 0 && i10 - 1 == 0) {
                i11 = -1;
            }
        }
        if (i10 > 0) {
            return i11;
        }
        return -1;
    }

    public final void append(String text) {
        kotlin.jvm.internal.g.f(text, "text");
        if (text.length() > 0) {
            this.f7237sb.append(text);
        }
    }

    public final boolean hasBuffered() {
        return this.f7237sb.length() > 0;
    }

    public final String takeAll() {
        String string = this.f7237sb.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        this.f7237sb.setLength(0);
        return string;
    }

    public final String takeEmittable() {
        int iFirstUnclosedParenIndex = firstUnclosedParenIndex();
        if (iFirstUnclosedParenIndex < 0) {
            return takeAll();
        }
        String strSubstring = this.f7237sb.substring(0, iFirstUnclosedParenIndex);
        String strSubstring2 = this.f7237sb.substring(iFirstUnclosedParenIndex);
        this.f7237sb.setLength(0);
        this.f7237sb.append(strSubstring2);
        kotlin.jvm.internal.g.c(strSubstring);
        return strSubstring;
    }
}
