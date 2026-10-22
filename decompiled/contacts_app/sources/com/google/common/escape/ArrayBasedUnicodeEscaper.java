package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final int safeMax;
    private final char safeMaxChar;
    private final int safeMin;
    private final char safeMinChar;

    protected abstract char[] escapeUnsafe(int r1);

    protected ArrayBasedUnicodeEscaper(Map<Character, String> r1, int r2, int r3, @Nullable String r4) {
        this(ArrayBasedEscaperMap.create(r1), r2, r3, r4);
    }

    protected ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap r1, int r2, int r3, @Nullable String r4) {
        Preconditions.checkNotNull(r1);
        char[][] r5 = r1.getReplacementArray();
        this.replacements = r5;
        this.replacementsLength = r5.length;
        if (r3 >= r2) goto L5;
        r3 = -1;
        r2 = Integer.MAX_VALUE;
    L5:
        this.safeMin = r2;
        this.safeMax = r3;
        if (r2 < 55296) goto L8;
        this.safeMinChar = CharCompanionObject.MAX_VALUE;
        this.safeMaxChar = 0;
        return;
    L8:
        this.safeMinChar = (char) r2;
        this.safeMaxChar = (char) Math.min(r3, 55295);
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public final String escape(String r4) {
        Preconditions.checkNotNull(r4);
        int r0 = 0;
    L4:
        if (r0 >= r4.length()) goto L17;
        char r1 = r4.charAt(r0);
        if (r1 >= this.replacementsLength) goto L10;
        if (this.replacements[r1] == null) goto L10;
    L16:
        return escapeSlow(r4, r0);
    L10:
        if (r1 > this.safeMaxChar) goto L16;
        if (r1 < this.safeMinChar) goto L16;
        r0 = r0 + 1;
        goto L4
    L17:
        return r4;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected final int nextEscapeIndex(CharSequence r3, int r4, int r5) {
    L2:
        if (r4 >= r5) goto L13;
        char r0 = r3.charAt(r4);
        if (r0 >= this.replacementsLength) goto L8;
        if (this.replacements[r0] != null) goto L13;
    L8:
        if (r0 > this.safeMaxChar) goto L13;
        if (r0 < this.safeMinChar) goto L13;
        r4 = r4 + 1;
    L13:
        return r4;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected final char[] escape(int r2) {
        if (r2 >= this.replacementsLength) goto L8;
        char[] r0 = this.replacements[r2];
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (r2 < this.safeMin) goto L14;
        if (r2 > this.safeMax) goto L14;
        return null;
    L14:
        return escapeUnsafe(r2);
    }
}
