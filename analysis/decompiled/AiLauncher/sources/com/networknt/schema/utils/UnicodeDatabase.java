package com.networknt.schema.utils;

import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.BitSet;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class UnicodeDatabase {
    private static final BitSet ARABIC_INDIC_DIGITS;
    private static final BitSet EXTENDED_ARABIC_INDIC_DIGITS;
    private static final BitSet GREEK_CHARACTERS;
    private static final BitSet HEBREW_CHARACTERS;
    private static final BitSet JOIN_TYPE_CAUSING;
    private static final BitSet JOIN_TYPE_DUAL;
    private static final BitSet JOIN_TYPE_LEFT;
    private static final BitSet JOIN_TYPE_RIGHT;
    private static final BitSet JOIN_TYPE_TRANSPARENT;
    private static final BitSet KATAKANA_CHARACTERS;

    static {
        BitSet bitSet = new BitSet(69632);
        ARABIC_INDIC_DIGITS = bitSet;
        BitSet bitSet2 = new BitSet(69632);
        EXTENDED_ARABIC_INDIC_DIGITS = bitSet2;
        BitSet bitSet3 = new BitSet(com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
        GREEK_CHARACTERS = bitSet3;
        BitSet bitSet4 = new BitSet(1536);
        HEBREW_CHARACTERS = bitSet4;
        BitSet bitSet5 = new BitSet(208896);
        KATAKANA_CHARACTERS = bitSet5;
        JOIN_TYPE_CAUSING = new BitSet(1114112);
        JOIN_TYPE_DUAL = new BitSet(1114112);
        JOIN_TYPE_LEFT = new BitSet(1114112);
        JOIN_TYPE_RIGHT = new BitSet(1114112);
        JOIN_TYPE_TRANSPARENT = new BitSet(1114112);
        bitSet.set(1632, 1642);
        bitSet2.set(1776, 1786);
        bitSet3.set(880, 1024);
        bitSet3.set(7936, com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
        bitSet4.set(1424, 1536);
        bitSet5.set(11904, 12032);
        bitSet5.set(12032, 12256);
        bitSet5.set(12288, 12352);
        bitSet5.set(12352, 12448);
        bitSet5.set(12448, 12544);
        bitSet5.set(13312, 19904);
        bitSet5.set(19968, 40960);
        bitSet5.set(63744, 64256);
        bitSet5.set(94176, 94208);
        bitSet5.set(SQLiteDatabase.OPEN_SHAREDCACHE, 173792);
        bitSet5.set(173824, 177984);
        bitSet5.set(177984, 178208);
        bitSet5.set(178208, 183984);
        bitSet5.set(183984, 191472);
        bitSet5.set(194560, 195104);
        bitSet5.set(196608, 201552);
        bitSet5.set(201552, 205744);
    }

    public static /* synthetic */ BitSet a(String str) {
        str.getClass();
        switch (str) {
            case "C":
                return JOIN_TYPE_CAUSING;
            case "D":
                return JOIN_TYPE_DUAL;
            case "L":
                return JOIN_TYPE_LEFT;
            case "R":
                return JOIN_TYPE_RIGHT;
            case "T":
                return JOIN_TYPE_TRANSPARENT;
            default:
                return null;
        }
    }

    public static boolean isArabicIndicDigit(int i10) {
        return ARABIC_INDIC_DIGITS.get(i10);
    }

    public static boolean isExtendedArabicIndicDigit(int i10) {
        return EXTENDED_ARABIC_INDIC_DIGITS.get(i10);
    }

    public static boolean isGreek(int i10) {
        return GREEK_CHARACTERS.get(i10);
    }

    public static boolean isHebrew(int i10) {
        return HEBREW_CHARACTERS.get(i10);
    }

    public static boolean isJoinTypeCausing(int i10) {
        BitSet bitSet = JOIN_TYPE_CAUSING;
        if (bitSet.isEmpty()) {
            loadJoiningTypes();
        }
        return bitSet.get(i10);
    }

    public static boolean isJoinTypeDual(int i10) {
        BitSet bitSet = JOIN_TYPE_DUAL;
        if (bitSet.isEmpty()) {
            loadJoiningTypes();
        }
        return bitSet.get(i10);
    }

    public static boolean isJoinTypeLeft(int i10) {
        BitSet bitSet = JOIN_TYPE_LEFT;
        if (bitSet.isEmpty()) {
            loadJoiningTypes();
        }
        return bitSet.get(i10);
    }

    public static boolean isJoinTypeRight(int i10) {
        BitSet bitSet = JOIN_TYPE_RIGHT;
        if (bitSet.isEmpty()) {
            loadJoiningTypes();
        }
        return bitSet.get(i10);
    }

    public static boolean isJoinTypeTransparent(int i10) {
        BitSet bitSet = JOIN_TYPE_TRANSPARENT;
        if (bitSet.isEmpty()) {
            loadJoiningTypes();
        }
        return bitSet.get(i10);
    }

    public static boolean isKatakana(int i10) {
        return KATAKANA_CHARACTERS.get(i10);
    }

    private static synchronized void loadJoiningTypes() {
        if (JOIN_TYPE_DUAL.isEmpty()) {
            UCDLoader.loadMapping("/ucd/extracted/DerivedJoiningType.txt", new Function() { // from class: com.networknt.schema.utils.q
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return UnicodeDatabase.a((String) obj);
                }
            });
        }
    }
}
