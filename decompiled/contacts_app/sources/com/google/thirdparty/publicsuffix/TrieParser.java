package com.google.thirdparty.publicsuffix;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class TrieParser {
    private static final Joiner PREFIX_JOINER = null;

    TrieParser() {
    }

    static {
        PREFIX_JOINER = Joiner.on("");
    }

    static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence r5) {
        ImmutableMap.Builder r0 = ImmutableMap.builder();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r2 = r2 + doParseTrieToBuilder(Lists.newLinkedList(), r5.subSequence(r2, r1), r0);
        goto L3
    L6:
        return r0.build();
    }

    private static int doParseTrieToBuilder(List<CharSequence> r9, CharSequence r10, ImmutableMap.Builder<String, PublicSuffixType> r11) {
        int r0 = r10.length();
        int r2 = 0;
        char r3 = 0;
    L4:
        if (r2 >= r0) goto L13;
        r3 = r10.charAt(r2);
        if (r3 == '&') goto L13;
        if (r3 == '?') goto L13;
        if (r3 == '!') goto L13;
        if (r3 == ':') goto L13;
        if (r3 == ',') goto L13;
        r2 = r2 + 1;
    L13:
        r9.add(0, reverse(r10.subSequence(0, r2)));
        if (r3 == '!') goto L18;
        if (r3 == '?') goto L18;
        if (r3 == ':') goto L18;
        if (r3 == ',') goto L18;
    L21:
        int r4 = r2 + 1;
        if (r3 == '?') goto L30;
        if (r3 == ',') goto L30;
    L24:
        if (r4 >= r0) goto L30;
        r4 = r4 + doParseTrieToBuilder(r9, r10.subSequence(r4, r0), r11);
        if (r10.charAt(r4) == '?') goto L29;
        if (r10.charAt(r4) != ',') goto L24;
    L29:
        r4 = r4 + 1;
    L30:
        r9.remove(0);
        return r4;
    L18:
        String r5 = PREFIX_JOINER.join(r9);
        if (r5.length() <= 0) goto L21;
        r11.put(r5, PublicSuffixType.fromCode(r3));
        goto L21
    }

    private static CharSequence reverse(CharSequence r7) {
        int r0 = r7.length();
        int r1 = 1;
        if (r0 > 1) goto L5;
        return r7;
    L5:
        char[] r2 = new char[r0];
        int r3 = r0 - 1;
        r2[0] = r7.charAt(r3);
    L6:
        if (r1 >= r0) goto L12;
        char r4 = r7.charAt(r3 - r1);
        r2[r1] = r4;
        int r5 = r1 - 1;
        if (Character.isSurrogatePair(r4, r2[r5]) == false) goto L10;
        swap(r2, r5, r1);
    L10:
        r1 = r1 + 1;
        goto L6
    L12:
        return new String(r2);
    }

    private static void swap(char[] r2, int r3, int r4) {
        char r0 = r2[r3];
        r2[r3] = r2[r4];
        r2[r4] = r0;
    }
}
