package com.networknt.schema.utils;

import java.net.IDN;
import java.text.Normalizer;
import java.text.ParseException;
import java.util.BitSet;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.IntPredicate;

/* loaded from: classes2.dex */
public class RFC5892 {
    private static final String ACE_PREFIX = "xn--";
    private static final int ACE_PREFIX_LENGTH = 4;
    private static final BiPredicate<String, Integer> ALLOWED_CHARACTER;
    private static final int GREEK_LOWER_NUMERAL_SIGN = 885;
    private static final int HEBREW_GERESH = 1523;
    private static final int HEBREW_GERSHAYIM = 1524;
    private static final BiPredicate<String, Integer> IDNA_RULES;
    private static final int KATAKANA_MIDDLE_DOT = 12539;
    private static String LABEL_SEPARATOR_REGEX = null;
    private static final BiPredicate<String, Integer> LTR;
    private static final int MIDDLE_DOT = 183;
    private static final BiPredicate<String, Integer> RTL;
    private static final BiPredicate<String, Integer> RULE_ARABIC_INDIC_DIGITS_RULE;
    private static final BiPredicate<String, Integer> RULE_EXTENDED_ARABIC_INDIC_DIGITS_RULE;
    private static final BiPredicate<String, Integer> RULE_GREEK_LOWER_NUMERAL_SIGN;
    private static final BiPredicate<String, Integer> RULE_HEBREW_GERESH_GERSHAYIM;
    private static final BiPredicate<String, Integer> RULE_KATAKANA_MIDDLE_DOT;
    private static final BiPredicate<String, Integer> RULE_MIDDLE_DOT;
    private static final BiPredicate<String, Integer> RULE_ZERO_WIDTH_JOINER;
    private static final BiPredicate<String, Integer> RULE_ZERO_WIDTH_NON_JOINER;
    private static final int VIRAMA = 2381;
    private static final int ZERO_WIDTH_JOINER = 8205;
    private static final int ZERO_WIDTH_NON_JOINER = 8204;
    private static final BitSet CONTEXTJ = new BitSet(1114112);
    private static final BitSet CONTEXTO = new BitSet(1114112);
    private static final BitSet DISALLOWED = new BitSet(1114112);
    private static final BitSet UNASSIGNED = new BitSet(1114112);

    static {
        BiPredicate<String, Integer> biPredicate = new BiPredicate() { // from class: com.networknt.schema.utils.h
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return RFC5892.testArabicIndicDigit((String) obj, ((Integer) obj2).intValue());
            }
        };
        RULE_ARABIC_INDIC_DIGITS_RULE = biPredicate;
        BiPredicate<String, Integer> biPredicate2 = new BiPredicate() { // from class: com.networknt.schema.utils.j
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return RFC5892.testExtendedArabicIndicDigit((String) obj, ((Integer) obj2).intValue());
            }
        };
        RULE_EXTENDED_ARABIC_INDIC_DIGITS_RULE = biPredicate2;
        BiPredicate<String, Integer> biPredicate3 = new BiPredicate() { // from class: com.networknt.schema.utils.k
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return RFC5892.testGreekLowerNumeralSign((String) obj, ((Integer) obj2).intValue());
            }
        };
        RULE_GREEK_LOWER_NUMERAL_SIGN = biPredicate3;
        BiPredicate<String, Integer> biPredicate4 = new BiPredicate() { // from class: com.networknt.schema.utils.l
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return RFC5892.testHebrewPuncuation((String) obj, ((Integer) obj2).intValue());
            }
        };
        RULE_HEBREW_GERESH_GERSHAYIM = biPredicate4;
        BiPredicate<String, Integer> biPredicate5 = new BiPredicate() { // from class: com.networknt.schema.utils.m
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return RFC5892.testKatakanaMiddleDot((String) obj, ((Integer) obj2).intValue());
            }
        };
        RULE_KATAKANA_MIDDLE_DOT = biPredicate5;
        BiPredicate<String, Integer> biPredicate6 = new BiPredicate() { // from class: com.networknt.schema.utils.n
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return RFC5892.testeMiddleDotRule((String) obj, ((Integer) obj2).intValue());
            }
        };
        RULE_MIDDLE_DOT = biPredicate6;
        BiPredicate<String, Integer> biPredicate7 = new BiPredicate() { // from class: com.networknt.schema.utils.o
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return RFC5892.testZeroWidthJoiner((String) obj, ((Integer) obj2).intValue());
            }
        };
        RULE_ZERO_WIDTH_JOINER = biPredicate7;
        BiPredicate<String, Integer> biPredicate8 = new BiPredicate() { // from class: com.networknt.schema.utils.c
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return RFC5892.testZeroWidthNonJoiner((String) obj, ((Integer) obj2).intValue());
            }
        };
        RULE_ZERO_WIDTH_NON_JOINER = biPredicate8;
        BiPredicate<String, Integer> biPredicate9 = new BiPredicate() { // from class: com.networknt.schema.utils.d
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return RFC5892.testAllowedCharacter((String) obj, ((Integer) obj2).intValue());
            }
        };
        ALLOWED_CHARACTER = biPredicate9;
        LTR = new BiPredicate() { // from class: com.networknt.schema.utils.e
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return RFC5892.testLTR((String) obj, ((Integer) obj2).intValue());
            }
        };
        RTL = new BiPredicate() { // from class: com.networknt.schema.utils.i
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return RFC5892.testRTL((String) obj, ((Integer) obj2).intValue());
            }
        };
        IDNA_RULES = biPredicate9.and(biPredicate).and(biPredicate2).and(biPredicate3).and(biPredicate4).and(biPredicate5).and(biPredicate6).and(biPredicate7).and(biPredicate8);
        LABEL_SEPARATOR_REGEX = "[\\.\\u3002\\uff0e\\uff61]";
    }

    public static /* synthetic */ BitSet f(String str) {
        str.getClass();
        switch (str) {
            case "DISALLOWED":
                return DISALLOWED;
            case "CONTEXTJ":
                return CONTEXTJ;
            case "CONTEXTO":
                return CONTEXTO;
            case "UNASSIGNED":
                return UNASSIGNED;
            default:
                return null;
        }
    }

    private static boolean isACE(String str) {
        int i10 = ACE_PREFIX_LENGTH;
        return i10 <= str.length() && ACE_PREFIX.equalsIgnoreCase(str.substring(0, i10));
    }

    private static boolean isCombiningMark(int i10) {
        int type = Character.getType(i10);
        return type == 6 || type == 7 || type == 8;
    }

    private static boolean isContextJ(int i10) {
        BitSet bitSet = CONTEXTJ;
        if (bitSet.isEmpty()) {
            loadDerivedProperties();
        }
        return bitSet.get(i10);
    }

    private static boolean isContextO(int i10) {
        BitSet bitSet = CONTEXTO;
        if (bitSet.isEmpty()) {
            loadDerivedProperties();
        }
        return bitSet.get(i10);
    }

    private static boolean isDisallowed(int i10) {
        BitSet bitSet = DISALLOWED;
        if (bitSet.isEmpty()) {
            loadDerivedProperties();
        }
        return bitSet.get(i10);
    }

    private static boolean isUnassigned(int i10) {
        BitSet bitSet = UNASSIGNED;
        if (bitSet.isEmpty()) {
            loadDerivedProperties();
        }
        return bitSet.get(i10);
    }

    public static boolean isValid(String str) {
        BiPredicate<String, Integer> biPredicateAnd;
        if ("".equals(str)) {
            return false;
        }
        if (str.length() == 1 && str.matches(LABEL_SEPARATOR_REGEX)) {
            return false;
        }
        for (String str2 : str.split(LABEL_SEPARATOR_REGEX)) {
            if (!str2.isEmpty()) {
                if (isACE(str2)) {
                    String unicode = IDN.toUnicode(str2, 2);
                    if (unicode.equalsIgnoreCase(str2)) {
                        return false;
                    }
                    str2 = unicode;
                }
                int length = str2.length();
                if (Normalizer.isNormalized(str2, Normalizer.Form.NFC) && '-' != str2.charAt(0) && 45 != str2.codePointBefore(length)) {
                    if ((4 <= length && 45 == str2.codePointAt(2) && 45 == str2.codePointAt(3)) || isCombiningMark(str2.codePointAt(0))) {
                        return false;
                    }
                    byte directionality = Character.getDirectionality(str2.codePointAt(0));
                    if (directionality == 0) {
                        biPredicateAnd = IDNA_RULES.and(LTR);
                    } else if (directionality == 1 || directionality == 2) {
                        biPredicateAnd = IDNA_RULES.and(RTL);
                    } else {
                        if (directionality != 3 && directionality != 13) {
                            return false;
                        }
                        biPredicateAnd = IDNA_RULES;
                    }
                    for (int i10 = 0; i10 < length; i10++) {
                        if (!biPredicateAnd.test(str2, Integer.valueOf(i10))) {
                            return false;
                        }
                    }
                    try {
                        if (63 < IDN.toASCII(str2, 2).length()) {
                            return false;
                        }
                    } catch (IllegalArgumentException e10) {
                        Throwable cause = e10.getCause();
                        if (cause instanceof ParseException) {
                            return cause.getMessage().startsWith("The input does not conform to the rules for BiDi code points");
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private static synchronized void loadDerivedProperties() {
        if (DISALLOWED.isEmpty()) {
            UCDLoader.loadMapping("/ucd/RFC5892-appendix-B.txt", new Function() { // from class: com.networknt.schema.utils.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return RFC5892.f((String) obj);
                }
            });
            BitSet bitSet = CONTEXTJ;
            bitSet.clear(ZERO_WIDTH_JOINER);
            bitSet.clear(ZERO_WIDTH_NON_JOINER);
            BitSet bitSet2 = CONTEXTO;
            bitSet2.clear(1632, 1642);
            bitSet2.clear(1776, 1786);
            bitSet2.clear(GREEK_LOWER_NUMERAL_SIGN);
            bitSet2.clear(HEBREW_GERESH);
            bitSet2.clear(HEBREW_GERSHAYIM);
            bitSet2.clear(KATAKANA_MIDDLE_DOT);
            bitSet2.clear(MIDDLE_DOT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean testAllowedCharacter(String str, int i10) {
        int iCodePointAt = str.codePointAt(i10);
        return (isDisallowed(iCodePointAt) || isUnassigned(iCodePointAt) || isContextJ(iCodePointAt) || isContextO(iCodePointAt)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean testArabicIndicDigit(String str, int i10) {
        if (UnicodeDatabase.isArabicIndicDigit(str.codePointAt(i10))) {
            return !str.codePoints().anyMatch(new IntPredicate() { // from class: com.networknt.schema.utils.f
                @Override // java.util.function.IntPredicate
                public final boolean test(int i11) {
                    return UnicodeDatabase.isExtendedArabicIndicDigit(i11);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean testExtendedArabicIndicDigit(String str, int i10) {
        if (UnicodeDatabase.isExtendedArabicIndicDigit(str.codePointAt(i10))) {
            return !str.codePoints().anyMatch(new IntPredicate() { // from class: com.networknt.schema.utils.g
                @Override // java.util.function.IntPredicate
                public final boolean test(int i11) {
                    return UnicodeDatabase.isArabicIndicDigit(i11);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean testGreekLowerNumeralSign(String str, int i10) {
        if (GREEK_LOWER_NUMERAL_SIGN != str.codePointAt(i10)) {
            return true;
        }
        int i11 = i10 + 1;
        if (str.length() == i11) {
            return false;
        }
        return UnicodeDatabase.isGreek(str.codePointAt(i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean testHebrewPuncuation(String str, int i10) {
        int iCodePointAt = str.codePointAt(i10);
        if (HEBREW_GERESH != iCodePointAt && HEBREW_GERSHAYIM != iCodePointAt) {
            return true;
        }
        if (i10 == 0) {
            return false;
        }
        return UnicodeDatabase.isHebrew(str.codePointAt(i10 - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean testKatakanaMiddleDot(String str, int i10) {
        if (KATAKANA_MIDDLE_DOT != str.codePointAt(i10)) {
            return true;
        }
        int i11 = i10 + 1;
        if (str.length() == i11) {
            return false;
        }
        return UnicodeDatabase.isKatakana(str.codePointAt(i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean testLTR(String str, int i10) {
        byte directionality = Character.getDirectionality(str.codePointAt(i10));
        return directionality == 0 || directionality == 13 || directionality == 3 || directionality == 4 || directionality == 5 || directionality == 7 || directionality == 8 || directionality == 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean testRTL(String str, int i10) {
        byte directionality = Character.getDirectionality(str.codePointAt(i10));
        if (directionality == 13) {
            return true;
        }
        switch (directionality) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean testZeroWidthJoiner(String str, int i10) {
        if (ZERO_WIDTH_JOINER == str.codePointAt(i10)) {
            return i10 != 0 && VIRAMA == str.codePointAt(i10 - 1);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean testZeroWidthNonJoiner(String str, int i10) {
        int i11;
        int length;
        if (ZERO_WIDTH_NON_JOINER == str.codePointAt(i10)) {
            if (i10 == 0) {
                return false;
            }
            if (VIRAMA == str.codePointBefore(i10)) {
                return true;
            }
            int i12 = i10;
            while (i12 > 0 && UnicodeDatabase.isJoinTypeTransparent(str.codePointBefore(i12))) {
                i12--;
            }
            if (i12 == 0) {
                return false;
            }
            int iCodePointBefore = str.codePointBefore(i12);
            if ((!UnicodeDatabase.isJoinTypeLeft(iCodePointBefore) && !UnicodeDatabase.isJoinTypeDual(iCodePointBefore)) || (length = str.length()) == (i11 = i10 + 1)) {
                return false;
            }
            while (i11 < length && UnicodeDatabase.isJoinTypeTransparent(str.codePointAt(i11))) {
                i11++;
            }
            if (length == i11) {
                return false;
            }
            int iCodePointAt = str.codePointAt(i11);
            if (!UnicodeDatabase.isJoinTypeRight(iCodePointAt) && !UnicodeDatabase.isJoinTypeDual(iCodePointAt)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean testeMiddleDotRule(String str, int i10) {
        int i11;
        if (MIDDLE_DOT != str.codePointAt(i10)) {
            return true;
        }
        if (i10 == 0 || str.length() == (i11 = i10 + 1)) {
            return false;
        }
        return 108 == str.codePointAt(i10 - 1) && 108 == str.codePointAt(i11);
    }
}
