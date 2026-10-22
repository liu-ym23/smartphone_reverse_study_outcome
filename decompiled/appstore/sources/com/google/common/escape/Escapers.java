package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public final class Escapers {
    private static final Escaper NULL_ESCAPER = null;

    @Beta
    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        private String unsafeReplacement;

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        public static /* synthetic */ String access$100(Builder r10) {
            return r10.unsafeReplacement;
        }

        @CanIgnoreReturnValue
        public Builder addEscape(char r10, String r11) {
            Preconditions.checkNotNull(r11);
            this.replacementMap.put(Character.valueOf(r10), r11);
            return this;
        }

        public Escaper build() {
            final Map<Character, String> r10 = this.replacementMap;
            final char r11 = this.safeMin;
            final char r12 = this.safeMax;
            return new AnonymousClass1(this, r10, r11, r12);
        }

        @CanIgnoreReturnValue
        public Builder setSafeRange(char r10, char r11) {
            this.safeMin = r10;
            this.safeMax = r11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUnsafeReplacement(@NullableDecl String r10) {
            this.unsafeReplacement = r10;
            return this;
        }

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = 0;
            this.safeMax = 65535;
            this.unsafeReplacement = null;
        }
    }

    static {
        NULL_ESCAPER = new AnonymousClass1();
    }

    private Escapers() {
    }

    public static UnicodeEscaper asUnicodeEscaper(Escaper r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof UnicodeEscaper) == false) goto L7;
        return (UnicodeEscaper) r10;
    L7:
        if ((r10 instanceof CharEscaper) == false) goto L11;
        return wrap((CharEscaper) r10);
    L11:
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + r10.getClass().getName());
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static String computeReplacement(CharEscaper r10, char r11) {
        return stringOrNull(r10.escape(r11));
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    private static String stringOrNull(char[] r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return new String(r10);
    }

    private static UnicodeEscaper wrap(final CharEscaper r10) {
        return new AnonymousClass2(r10);
    }

    public static String computeReplacement(UnicodeEscaper r10, int r11) {
        return stringOrNull(r10.escape(r11));
    }
}
