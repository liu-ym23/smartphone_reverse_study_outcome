package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract enum CaseFormat extends Enum<CaseFormat> {
    private static final /* synthetic */ CaseFormat[] $VALUES = null;
    public static final CaseFormat LOWER_CAMEL = null;
    public static final CaseFormat LOWER_HYPHEN = null;
    public static final CaseFormat LOWER_UNDERSCORE = null;
    public static final CaseFormat UPPER_CAMEL = null;
    public static final CaseFormat UPPER_UNDERSCORE = null;
    private final CharMatcher wordBoundary;
    private final String wordSeparator;

    public static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        public StringConverter(CaseFormat r10, CaseFormat r11) {
            this.sourceFormat = (CaseFormat) Preconditions.checkNotNull(r10);
            this.targetFormat = (CaseFormat) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doBackward(String r10) {
            return doBackward2(r10);
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doForward(String r10) {
            return doForward2(r10);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof StringConverter) == false) goto L10;
            StringConverter r11 = (StringConverter) r10;
            if (this.sourceFormat.equals(r11.sourceFormat) == true) goto L7;
            return false;
        L7:
            if (this.targetFormat.equals(r11.targetFormat) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r10 = this.sourceFormat.hashCode();
            return this.targetFormat.hashCode() ^ r10;
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + ")";
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(String r10) {
            return this.targetFormat.to(this.sourceFormat, r10);
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public String doForward2(String r10) {
            return this.sourceFormat.to(this.targetFormat, r10);
        }
    }

    static {
        final CharMatcher r10 = CharMatcher.is('-');
        final String r11 = "-";
        final String r12 = "LOWER_HYPHEN";
        final int r13 = 0;
        CaseFormat r14 = new AnonymousClass1(r12, r13, r10, r11);
        LOWER_HYPHEN = r14;
        final CharMatcher r15 = CharMatcher.is('_');
        final String r16 = "LOWER_UNDERSCORE";
        final int r17 = 1;
        final String r18 = "_";
        CaseFormat r19 = new AnonymousClass2(r16, r17, r15, r18);
        LOWER_UNDERSCORE = r19;
        final CharMatcher r20 = CharMatcher.inRange('A', 'Z');
        final String r110 = "LOWER_CAMEL";
        final int r111 = 2;
        final String r112 = "";
        CaseFormat r21 = new AnonymousClass3(r110, r111, r20, r112);
        LOWER_CAMEL = r21;
        final int r113 = 3;
        final CharMatcher r22 = CharMatcher.inRange('A', 'Z');
        final String r23 = "UPPER_CAMEL";
        CaseFormat r24 = new AnonymousClass4(r23, r113, r22, r112);
        UPPER_CAMEL = r24;
        final int r25 = 4;
        final CharMatcher r26 = CharMatcher.is('_');
        final String r114 = "UPPER_UNDERSCORE";
        CaseFormat r27 = new AnonymousClass5(r114, r25, r26, r18);
        UPPER_UNDERSCORE = r27;
        $VALUES = new CaseFormat[]{r14, r19, r21, r24, r27};
    }

    public /* synthetic */ CaseFormat(String r10, int r11, CharMatcher r12, String r13, AnonymousClass1 r14) {
        this(r10, r11, r12, r13);
    }

    public static /* synthetic */ String access$100(String r10) {
        return firstCharOnlyToUpper(r10);
    }

    private static String firstCharOnlyToUpper(String r10) {
        if (r10.isEmpty() == false) goto L6;
        return r10;
    L6:
        return Ascii.toUpperCase(r10.charAt(0)) + Ascii.toLowerCase(r10.substring(1));
    }

    public static CaseFormat valueOf(String r10) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, r10);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) $VALUES.clone();
    }

    public String convert(CaseFormat r10, String r11) {
        StringBuilder r12 = null;
        int r13 = 0;
        int r14 = -1;
    L3:
        r14 = this.wordBoundary.indexIn(r11, r14 + 1);
        if (r14 == (-1)) goto L9;
        if (r13 != 0) goto L7;
        r12 = new StringBuilder(r11.length() + (this.wordSeparator.length() * 4));
        r12.append(r10.normalizeFirstWord(r11.substring(r13, r14)));
    L8:
        r12.append(r10.wordSeparator);
        r13 = this.wordSeparator.length() + r14;
        goto L3
    L7:
        r12.append(r10.normalizeWord(r11.substring(r13, r14)));
        goto L8
    L9:
        if (r13 == 0) goto L16;
        r12.append(r10.normalizeWord(r11.substring(r13)));
        return r12.toString();
    L16:
        return r10.normalizeFirstWord(r11);
    }

    public Converter<String, String> converterTo(CaseFormat r10) {
        return new StringConverter(this, r10);
    }

    public String normalizeFirstWord(String r10) {
        return normalizeWord(r10);
    }

    public abstract String normalizeWord(String r10);

    public final String to(CaseFormat r10, String r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if (r10 != this) goto L6;
        return r11;
    L6:
        return convert(r10, r11);
    }

    private CaseFormat(String r10, int r11, CharMatcher r12, String r13) {
        super(r10, r11);
        this.wordBoundary = r12;
        this.wordSeparator = r13;
    }
}
