package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import kotlinx.coroutines.channels.Channel;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final int safeMax;
    private final char safeMaxChar;
    private final int safeMin;
    private final char safeMinChar;

    public ArrayBasedUnicodeEscaper(Map<Character, String> r10, int r11, int r12, @NullableDecl String r13) {
        this(ArrayBasedEscaperMap.create(r10), r11, r12, r13);
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
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
        if (r12 > this.safeMaxChar) goto L16;
        if (r12 < this.safeMinChar) goto L16;
        r11 = r11 + 1;
        goto L4
    L17:
        return r10;
    }

    public abstract char[] escapeUnsafe(int r10);

    @Override // com.google.common.escape.UnicodeEscaper
    public final int nextEscapeIndex(CharSequence r10, int r11, int r12) {
    L2:
        if (r11 >= r12) goto L13;
        char r13 = r10.charAt(r11);
        if (r13 >= this.replacementsLength) goto L8;
        if (this.replacements[r13] != null) goto L13;
    L8:
        if (r13 > this.safeMaxChar) goto L13;
        if (r13 < this.safeMinChar) goto L13;
        r11 = r11 + 1;
    L13:
        return r11;
    }

    public ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap r10, int r11, int r12, @NullableDecl String r13) {
        Preconditions.checkNotNull(r10);
        char[][] r14 = r10.getReplacementArray();
        this.replacements = r14;
        this.replacementsLength = r14.length;
        if (r12 >= r11) goto L5;
        r12 = -1;
        r11 = Channel.UNLIMITED;
    L5:
        this.safeMin = r11;
        this.safeMax = r12;
        if (r11 < 55296) goto L8;
        this.safeMinChar = 65535;
        this.safeMaxChar = 0;
        return;
    L8:
        this.safeMinChar = (char) r11;
        this.safeMaxChar = (char) Math.min(r12, 55295);
    }

    @Override // com.google.common.escape.UnicodeEscaper
    public final char[] escape(int r10) {
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
