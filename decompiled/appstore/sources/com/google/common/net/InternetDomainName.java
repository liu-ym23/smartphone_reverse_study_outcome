package com.google.common.net;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.Immutable;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.List;
import l9.a;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@Beta
@GwtCompatible
public final class InternetDomainName {
    private static final CharMatcher DASH_MATCHER = null;
    private static final CharMatcher DOTS_MATCHER = null;
    private static final Joiner DOT_JOINER = null;
    private static final Splitter DOT_SPLITTER = null;
    private static final int MAX_DOMAIN_PART_LENGTH = 63;
    private static final int MAX_LENGTH = 253;
    private static final int MAX_PARTS = 127;
    private static final int NO_SUFFIX_FOUND = -1;
    private static final CharMatcher PART_CHAR_MATCHER = null;
    private final String name;
    private final ImmutableList<String> parts;
    private final int publicSuffixIndex;
    private final int registrySuffixIndex;

    static {
        DOTS_MATCHER = CharMatcher.anyOf(".。．｡");
        DOT_SPLITTER = Splitter.on('.');
        DOT_JOINER = Joiner.on('.');
        CharMatcher r10 = CharMatcher.anyOf("-_");
        DASH_MATCHER = r10;
        PART_CHAR_MATCHER = CharMatcher.javaLetterOrDigit().or(r10);
    }

    public InternetDomainName(String r10) {
        String r11 = Ascii.toLowerCase(DOTS_MATCHER.replaceFrom(r10, '.'));
        boolean r12 = true;
        if (r11.endsWith(LibrarianImpl.Constants.DOT) == false) goto L6;
        r11 = r11.substring(0, r11.length() - 1);
    L6:
        if (r11.length() > MAX_LENGTH) goto L8;
        boolean r13 = true;
    L9:
        Preconditions.checkArgument(r13, "Domain name too long: '%s':", r11);
        this.name = r11;
        ImmutableList<String> r14 = ImmutableList.copyOf(DOT_SPLITTER.split(r11));
        this.parts = r14;
        if (r14.size() <= MAX_PARTS) goto L13;
        r12 = false;
    L13:
        Preconditions.checkArgument(r12, "Domain has too many parts: '%s'", r11);
        Preconditions.checkArgument(validateSyntax(r14), "Not a valid domain name: '%s'", r11);
        this.publicSuffixIndex = findSuffixOfType(Optional.absent());
        this.registrySuffixIndex = findSuffixOfType(Optional.of(PublicSuffixType.REGISTRY));
        return;
    L8:
        r13 = false;
        goto L9
    }

    private InternetDomainName ancestor(int r10) {
        Joiner r11 = DOT_JOINER;
        ImmutableList<String> r12 = this.parts;
        return from(r11.join(r12.subList(r10, r12.size())));
    }

    private int findSuffixOfType(Optional<PublicSuffixType> r10) {
        int r11 = this.parts.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L15;
        String r13 = DOT_JOINER.join(this.parts.subList(r12, r11));
        if (matchesType(r10, Optional.fromNullable(a.f21922a.get(r13))) == true) goto L6;
        if (a.f21924c.containsKey(r13) == true) goto L10;
        if (matchesWildcardSuffixType(r10, r13) == true) goto L13;
        r12 = r12 + 1;
        goto L3
    L13:
        return r12;
    L10:
        return r12 + 1;
    L6:
        return r12;
    L15:
        return -1;
    }

    public static InternetDomainName from(String r10) {
        return new InternetDomainName((String) Preconditions.checkNotNull(r10));
    }

    public static boolean isValid(String r10) {
        from(r10);     // Catch: IllegalArgumentException -> L5
        return true;
    L5:
        return false;
    }

    private static boolean matchesType(Optional<PublicSuffixType> r10, Optional<PublicSuffixType> r11) {
        if (r10.isPresent() == false) goto L6;
        return r10.equals(r11);
    L6:
        return r11.isPresent();
    }

    private static boolean matchesWildcardSuffixType(Optional<PublicSuffixType> r10, String r11) {
        List<String> r12 = DOT_SPLITTER.limit(2).splitToList(r11);
        if (r12.size() == 2) goto L5;
    L7:
        return false;
    L5:
        if (matchesType(r10, Optional.fromNullable(a.f21923b.get(r12.get(1)))) == false) goto L7;
        return true;
    }

    private static boolean validatePart(String r10, boolean r11) {
        if (r10.length() >= 1) goto L5;
    L20:
        return false;
    L5:
        if (r10.length() > 63) goto L20;
        String r12 = CharMatcher.ascii().retainFrom(r10);
        if (PART_CHAR_MATCHER.matchesAllOf(r12) == true) goto L10;
        return false;
    L10:
        CharMatcher r13 = DASH_MATCHER;
        if (r13.matches(r10.charAt(0)) == true) goto L20;
        if (r13.matches(r10.charAt(r10.length() - 1)) == true) goto L20;
        if (r11 == true) goto L17;
    L19:
        return true;
    L17:
        if (CharMatcher.digit().matches(r10.charAt(0)) == false) goto L19;
        return false;
    }

    private static boolean validateSyntax(List<String> r10) {
        int r11 = r10.size() - 1;
        if (validatePart(r10.get(r11), true) == true) goto L5;
        return false;
    L5:
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        if (validatePart(r10.get(r12), false) == false) goto L9;
        r12 = r12 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public InternetDomainName child(String r10) {
        return from(((String) Preconditions.checkNotNull(r10)) + LibrarianImpl.Constants.DOT + this.name);
    }

    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof InternetDomainName) == true) goto L8;
        return false;
    L8:
        return this.name.equals(((InternetDomainName) r10).name);
    }

    public boolean hasParent() {
        if (this.parts.size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasPublicSuffix() {
        if (this.publicSuffixIndex == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasRegistrySuffix() {
        if (this.registrySuffixIndex == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean isPublicSuffix() {
        if (this.publicSuffixIndex != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRegistrySuffix() {
        if (this.registrySuffixIndex != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isTopDomainUnderRegistrySuffix() {
        if (this.registrySuffixIndex == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isTopPrivateDomain() {
        if (this.publicSuffixIndex == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isUnderPublicSuffix() {
        if (this.publicSuffixIndex <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUnderRegistrySuffix() {
        if (this.registrySuffixIndex <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public InternetDomainName parent() {
        Preconditions.checkState(hasParent(), "Domain '%s' has no parent", this.name);
        return ancestor(1);
    }

    public ImmutableList<String> parts() {
        return this.parts;
    }

    public InternetDomainName publicSuffix() {
        if (hasPublicSuffix() == true) goto L7;
        return null;
    L7:
        return ancestor(this.publicSuffixIndex);
    }

    public InternetDomainName registrySuffix() {
        if (hasRegistrySuffix() == true) goto L7;
        return null;
    L7:
        return ancestor(this.registrySuffixIndex);
    }

    public String toString() {
        return this.name;
    }

    public InternetDomainName topDomainUnderRegistrySuffix() {
        if (isTopDomainUnderRegistrySuffix() == false) goto L5;
        return this;
    L5:
        Preconditions.checkState(isUnderRegistrySuffix(), "Not under a registry suffix: %s", this.name);
        return ancestor(this.registrySuffixIndex - 1);
    }

    public InternetDomainName topPrivateDomain() {
        if (isTopPrivateDomain() == false) goto L5;
        return this;
    L5:
        Preconditions.checkState(isUnderPublicSuffix(), "Not under a public suffix: %s", this.name);
        return ancestor(this.publicSuffixIndex - 1);
    }
}
