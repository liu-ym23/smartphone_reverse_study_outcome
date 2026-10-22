package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public abstract class ArrayBasedCharEscaper extends CharEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final char safeMax;
    private final char safeMin;

    public ArrayBasedCharEscaper(Map<Character, String> r10, char r11, char r12) {
        this(ArrayBasedEscaperMap.create(r10), r11, r12);
    }

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final String escape(String r10) {
        Preconditions.checkNotNull(r10);
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L17;
        char r12 = r10.charAt(r11);
        if (r12 >= this.replacementsLength) goto L10;
        if (this.replacements[r12] == null) goto L10;
    L16:
        return escapeSlow(r10, r11);
    L10:
        if (r12 > this.safeMax) goto L16;
        if (r12 < this.safeMin) goto L16;
        r11 = r11 + 1;
        goto L4
    L17:
        return r10;
    }

    public abstract char[] escapeUnsafe(char r10);

    public ArrayBasedCharEscaper(ArrayBasedEscaperMap r10, char r11, char r12) {
        Preconditions.checkNotNull(r10);
        char[][] r13 = r10.getReplacementArray();
        this.replacements = r13;
        this.replacementsLength = r13.length;
        if (r12 >= r11) goto L5;
        r12 = 0;
        r11 = 65535;
    L5:
        this.safeMin = r11;
        this.safeMax = r12;
    }

    @Override // com.google.common.escape.CharEscaper
    public final char[] escape(char r10) {
        if (r10 >= this.replacementsLength) goto L8;
        char[] r11 = this.replacements[r10];
        if (r11 == null) goto L8;
        return r11;
    L8:
        if (r10 < this.safeMin) goto L14;
        if (r10 > this.safeMax) goto L14;
        return null;
    L14:
        return escapeUnsafe(r10);
    }
}
