package com.google.i18n.phonenumbers.internal;

import com.google.i18n.phonenumbers.Phonemetadata;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class RegexBasedMatcher implements MatcherApi {
    private final RegexCache regexCache;

    public static MatcherApi create() {
        return new RegexBasedMatcher();
    }

    private RegexBasedMatcher() {
        this.regexCache = new RegexCache(100);
    }

    @Override // com.google.i18n.phonenumbers.internal.MatcherApi
    public boolean matchNationalNumber(CharSequence r2, Phonemetadata.PhoneNumberDesc r3, boolean r4) {
        String r5 = r3.getNationalNumberPattern();
        if (r5.length() != 0) goto L7;
        return false;
    L7:
        return match(r2, this.regexCache.getPatternForRegex(r5), r4);
    }

    private static boolean match(CharSequence r0, Pattern r1, boolean r2) {
        Matcher r3 = r1.matcher(r0);
        if (r3.lookingAt() == true) goto L7;
        return false;
    L7:
        if (r3.matches() == false) goto L10;
        return true;
    L10:
        return r2;
    }
}
