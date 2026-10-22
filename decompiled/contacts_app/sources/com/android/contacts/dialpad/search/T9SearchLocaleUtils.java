package com.android.contacts.dialpad.search;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class T9SearchLocaleUtils {
    private static final Set<Character.UnicodeBlock> CJ_BLOCKS = null;

    public T9SearchLocaleUtils() {
    }

    static {
        HashSet r0 = new HashSet();
        r0.add(Character.UnicodeBlock.HIRAGANA);
        r0.add(Character.UnicodeBlock.KATAKANA);
        r0.add(Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
        r0.add(Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
        r0.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
        r0.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
        r0.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
        r0.add(Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
        r0.add(Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
        r0.add(Character.UnicodeBlock.CJK_COMPATIBILITY);
        r0.add(Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS);
        r0.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
        r0.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
        CJ_BLOCKS = Collections.unmodifiableSet(r0);
    }

    public static boolean isChinese(char r1) {
        Character.UnicodeBlock r2 = Character.UnicodeBlock.of(r1);
        if (r2 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L5;
        return true;
    L5:
        if (r2 != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L7;
        return true;
    L7:
        if (r2 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L9;
        return true;
    L9:
        if (r2 != Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L11;
        return true;
    L11:
        if (r2 != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L13;
        return true;
    L13:
        if (r2 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L23;
        return false;
    L23:
        return true;
    }

    public static boolean isKorean(char r1) {
        Character.UnicodeBlock r2 = Character.UnicodeBlock.of(r1);
        if (r2 != Character.UnicodeBlock.HANGUL_SYLLABLES) goto L5;
        return true;
    L5:
        if (r2 != Character.UnicodeBlock.HANGUL_JAMO) goto L7;
        return true;
    L7:
        if (r2 == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO) goto L14;
        return false;
    L14:
        return true;
    }

    public static boolean isJapanesePhonetic(char r1) {
        Character.UnicodeBlock r2 = Character.UnicodeBlock.of(r1);
        if (r2 != Character.UnicodeBlock.KATAKANA) goto L5;
        return true;
    L5:
        if (r2 != Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS) goto L7;
        return true;
    L7:
        if (r2 != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L9;
        return true;
    L9:
        if (r2 == Character.UnicodeBlock.HIRAGANA) goto L17;
        return false;
    L17:
        return true;
    }

    public static boolean isChineseOrJapaneseName(String r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        int r1 = r6.length();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        int r3 = Character.codePointAt(r6, r2);
        if (Character.isLetter(r3) == false) goto L12;
        if (CJ_BLOCKS.contains(Character.UnicodeBlock.of(r3)) == true) goto L12;
        return false;
    L12:
        r2 = r2 + Character.charCount(r3);
        goto L6
    L13:
        return true;
    }
}
