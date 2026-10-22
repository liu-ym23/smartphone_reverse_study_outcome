package com.google.common.net;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class InternetDomainName {
    private static final CharMatcher DASH_MATCHER = null;
    private static final CharMatcher DOTS_MATCHER = null;
    private static final Joiner DOT_JOINER = null;
    private static final String DOT_REGEX = "\\.";
    private static final Splitter DOT_SPLITTER = null;
    private static final int MAX_DOMAIN_PART_LENGTH = 63;
    private static final int MAX_LENGTH = 253;
    private static final int MAX_PARTS = 127;
    private static final int NO_PUBLIC_SUFFIX_FOUND = -1;
    private static final CharMatcher PART_CHAR_MATCHER = null;
    private final String name;
    private final ImmutableList<String> parts;
    private final int publicSuffixIndex;

    static {
        DOTS_MATCHER = CharMatcher.anyOf(".。．｡");
        DOT_SPLITTER = Splitter.on('.');
        DOT_JOINER = Joiner.on('.');
        CharMatcher r0 = CharMatcher.anyOf("-_");
        DASH_MATCHER = r0;
        PART_CHAR_MATCHER = CharMatcher.JAVA_LETTER_OR_DIGIT.or(r0);
    }

    InternetDomainName(String r7) {
        String r8 = Ascii.toLowerCase(DOTS_MATCHER.replaceFrom(r7, '.'));
        if (r8.endsWith(LibrarianImpl.Constants.DOT) == false) goto L6;
        r8 = r8.substring(0, r8.length() - 1);
    L6:
        if (r8.length() > MAX_LENGTH) goto L8;
        boolean r0 = true;
    L9:
        Preconditions.checkArgument(r0, "Domain name too long: '%s':", new Object[]{r8});
        this.name = r8;
        ImmutableList<String> r1 = ImmutableList.copyOf(DOT_SPLITTER.split(r8));
        this.parts = r1;
        if (r1.size() > 127) goto L12;
        boolean r3 = true;
    L13:
        Preconditions.checkArgument(r3, "Domain has too many parts: '%s'", new Object[]{r8});
        Preconditions.checkArgument(validateSyntax(r1), "Not a valid domain name: '%s'", new Object[]{r8});
        this.publicSuffixIndex = findPublicSuffix();
        return;
    L12:
        r3 = false;
        goto L13
    L8:
        r0 = false;
        goto L9
    }

    private int findPublicSuffix() {
        int r0 = this.parts.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        String r2 = DOT_JOINER.join(this.parts.subList(r1, r0));
        if (PublicSuffixPatterns.EXACT.containsKey(r2) == true) goto L6;
        if (PublicSuffixPatterns.EXCLUDED.containsKey(r2) == true) goto L10;
        if (matchesWildcardPublicSuffix(r2) == true) goto L13;
        r1 = r1 + 1;
        goto L3
    L13:
        return r1;
    L10:
        return r1 + 1;
    L6:
        return r1;
    L15:
        return -1;
    }

    public static InternetDomainName from(String r1) {
        return new InternetDomainName((String) Preconditions.checkNotNull(r1));
    }

    private static boolean validateSyntax(List<String> r5) {
        int r0 = r5.size() - 1;
        if (validatePart(r5.get(r0), true) == true) goto L5;
        return false;
    L5:
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (validatePart(r5.get(r2), false) == false) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    private static boolean validatePart(String r4, boolean r5) {
        if (r4.length() >= 1) goto L5;
    L20:
        return false;
    L5:
        if (r4.length() > 63) goto L20;
        String r0 = CharMatcher.ASCII.retainFrom(r4);
        if (PART_CHAR_MATCHER.matchesAllOf(r0) == true) goto L10;
        return false;
    L10:
        CharMatcher r1 = DASH_MATCHER;
        if (r1.matches(r4.charAt(0)) == true) goto L20;
        if (r1.matches(r4.charAt(r4.length() - 1)) == true) goto L20;
        if (r5 == true) goto L17;
    L19:
        return true;
    L17:
        if (CharMatcher.DIGIT.matches(r4.charAt(0)) == false) goto L19;
        return false;
    }

    public ImmutableList<String> parts() {
        return this.parts;
    }

    public boolean isPublicSuffix() {
        if (this.publicSuffixIndex != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasPublicSuffix() {
        if (this.publicSuffixIndex == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public InternetDomainName publicSuffix() {
        if (hasPublicSuffix() == true) goto L7;
        return null;
    L7:
        return ancestor(this.publicSuffixIndex);
    }

    public boolean isUnderPublicSuffix() {
        if (this.publicSuffixIndex <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isTopPrivateDomain() {
        if (this.publicSuffixIndex == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public InternetDomainName topPrivateDomain() {
        if (isTopPrivateDomain() == false) goto L5;
        return this;
    L5:
        Preconditions.checkState(isUnderPublicSuffix(), "Not under a public suffix: %s", new Object[]{this.name});
        return ancestor(this.publicSuffixIndex - 1);
    }

    public boolean hasParent() {
        if (this.parts.size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public InternetDomainName parent() {
        Preconditions.checkState(hasParent(), "Domain '%s' has no parent", new Object[]{this.name});
        return ancestor(1);
    }

    private InternetDomainName ancestor(int r3) {
        Joiner r0 = DOT_JOINER;
        ImmutableList<String> r2 = this.parts;
        return from(r0.join(r2.subList(r3, r2.size())));
    }

    public InternetDomainName child(String r2) {
        return from(((String) Preconditions.checkNotNull(r2)) + LibrarianImpl.Constants.DOT + this.name);
    }

    public static boolean isValid(String r0) {
        from(r0);     // Catch: IllegalArgumentException -> L5
        return true;
    L5:
        return false;
    }

    private static boolean matchesWildcardPublicSuffix(String r2) {
        String[] r3 = r2.split(DOT_REGEX, 2);
        if (r3.length == 2) goto L5;
    L7:
        return false;
    L5:
        if (PublicSuffixPatterns.UNDER.containsKey(r3[1]) == false) goto L7;
        return true;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(@Nullable Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof InternetDomainName) == true) goto L8;
        return false;
    L8:
        return this.name.equals(((InternetDomainName) r2).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}
