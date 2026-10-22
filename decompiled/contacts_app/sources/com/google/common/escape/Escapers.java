package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public final class Escapers {
    private static final Escaper NULL_ESCAPER = null;

    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        private String unsafeReplacement;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ String access$100(Builder r0) {
            return r0.unsafeReplacement;
        }

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = 0;
            this.safeMax = CharCompanionObject.MAX_VALUE;
            this.unsafeReplacement = null;
        }

        public Builder setSafeRange(char r1, char r2) {
            this.safeMin = r1;
            this.safeMax = r2;
            return this;
        }

        public Builder setUnsafeReplacement(@Nullable String r1) {
            this.unsafeReplacement = r1;
            return this;
        }

        public Builder addEscape(char r2, String r3) {
            Preconditions.checkNotNull(r3);
            this.replacementMap.put(Character.valueOf(r2), r3);
            return this;
        }

        public Escaper build() {
            final Map<Character, String> r1 = this.replacementMap;
            final char r2 = this.safeMin;
            final char r3 = this.safeMax;
            return new AnonymousClass1(this, r1, r2, r3);
        }
    }

    private Escapers() {
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    static {
        NULL_ESCAPER = new AnonymousClass1();
    }

    public static Builder builder() {
        return new Builder(null);
    }

    static UnicodeEscaper asUnicodeEscaper(Escaper r3) {
        Preconditions.checkNotNull(r3);
        if ((r3 instanceof UnicodeEscaper) == false) goto L7;
        return (UnicodeEscaper) r3;
    L7:
        if ((r3 instanceof CharEscaper) == false) goto L11;
        return wrap((CharEscaper) r3);
    L11:
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + r3.getClass().getName());
    }

    public static String computeReplacement(CharEscaper r0, char r1) {
        return stringOrNull(r0.escape(r1));
    }

    public static String computeReplacement(UnicodeEscaper r0, int r1) {
        return stringOrNull(r0.escape(r1));
    }

    private static String stringOrNull(char[] r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return new String(r1);
    }

    private static UnicodeEscaper wrap(final CharEscaper r1) {
        return new AnonymousClass2(r1);
    }
}
