package com.networknt.schema.regex;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class RegularExpressions {
    private static final Map<String, String> LONGFORM_CHARACTER_PROPERTIES;

    static {
        HashMap map = new HashMap();
        LONGFORM_CHARACTER_PROPERTIES = map;
        map.put("Letter", "L");
        map.put("Lowercase_Letter", "Ll");
        map.put("Uppercase_Letter", "Lu");
        map.put("Titlecase_Letter", "Lt");
        map.put("Cased_Letter", "L&");
        map.put("Modifier_Letter", "Lm");
        map.put("Other_Letter", "Lo");
        map.put("Mark", "M");
        map.put("Non_Spacing_Mark", "Mn");
        map.put("Spacing_Combining_Mark", "Mc");
        map.put("Enclosing_Mark", "Me");
        map.put("Separator", "Z");
        map.put("Space_Separator", "Zs");
        map.put("Line_Separator", "Zl");
        map.put("Paragraph_Separator", "Zp");
        map.put("Symbol", ExifInterface.LATITUDE_SOUTH);
        map.put("Math_Symbol", "Sm");
        map.put("Currency_Symbol", "Sc");
        map.put("Modifier_Symbol", "Sk");
        map.put("Other_Symbol", "So");
        map.put("Number", "N");
        map.put("Decimal_Digit_Number", "Nd");
        map.put("Letter_Number", "Nl");
        map.put("Other_Number", "No");
        map.put("Punctuation", "P");
        map.put("Dash_Punctuation", "Pd");
        map.put("Open_Punctuation", "Ps");
        map.put("Close_Punctuation", "Pe");
        map.put("Initial_Punctuation", "Pi");
        map.put("Final_Punctuation", "Pf");
        map.put("Connector_Punctuation", "Pc");
        map.put("Other_Punctuation", "Po");
        map.put("Other", "C");
        map.put("Control", "Cc");
        map.put("Format", "Cf");
        map.put("Private_Use", "Co");
        map.put("Surrogate", "Cs");
        map.put("Unassigned", "Cn");
        map.put("digit", "Nd");
    }

    private RegularExpressions() {
    }

    private static int findClosingBrace(String str, int i10) {
        int i11;
        while (i10 < str.length()) {
            if (str.charAt(i10) == '}') {
                return i10;
            }
            if (str.charAt(i10) == '\\' && (i11 = i10 + 1) < str.length()) {
                i10 = i11;
            }
            i10++;
        }
        return -1;
    }

    public static String replaceCharacterProperties(String str, Map<String, String> map) {
        int i10;
        int iFindClosingBrace;
        int i11;
        if (str.indexOf("\\p{") == -1) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (i12 < str.length()) {
            char cCharAt = str.charAt(i12);
            if (z10) {
                if (cCharAt == '\\' && (i11 = i12 + 1) < str.length() && str.charAt(i11) == 'E') {
                    sb2.append("\\E");
                    z10 = false;
                    i12 = i11;
                } else {
                    sb2.append(cCharAt);
                }
            } else if (!z11 && str.length() >= (i10 = i12 + 3) && str.startsWith("\\p{", i12) && (iFindClosingBrace = findClosingBrace(str, i10)) != -1) {
                sb2.append("\\p{");
                String strSubstring = str.substring(i10, iFindClosingBrace);
                String str2 = map.get(strSubstring);
                if (str2 == null) {
                    sb2.append(strSubstring);
                } else {
                    sb2.append(str2);
                }
                sb2.append("}");
                i12 = iFindClosingBrace;
            } else if (cCharAt == '\\') {
                sb2.append(cCharAt);
                int i13 = i12 + 1;
                if (i13 < str.length()) {
                    char cCharAt2 = str.charAt(i13);
                    sb2.append(cCharAt2);
                    if (cCharAt2 == 'Q') {
                        z10 = true;
                    }
                    i12 = i13;
                }
            } else if (cCharAt == '[') {
                sb2.append(cCharAt);
                z11 = true;
            } else if (cCharAt == ']') {
                sb2.append(cCharAt);
                z11 = false;
            } else {
                sb2.append(cCharAt);
            }
            i12++;
        }
        return sb2.toString();
    }

    public static String replaceDollarAnchors(String str) {
        int i10;
        if (str.indexOf(36) == -1) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (i11 < str.length()) {
            char cCharAt = str.charAt(i11);
            if (z10) {
                if (cCharAt == '\\' && (i10 = i11 + 1) < str.length() && str.charAt(i10) == 'E') {
                    sb2.append("\\E");
                    z10 = false;
                    i11 = i10;
                } else {
                    sb2.append(cCharAt);
                }
            } else if (cCharAt == '\\') {
                sb2.append(cCharAt);
                int i12 = i11 + 1;
                if (i12 < str.length()) {
                    char cCharAt2 = str.charAt(i12);
                    sb2.append(cCharAt2);
                    if (cCharAt2 == 'Q') {
                        z10 = true;
                    }
                    i11 = i12;
                }
            } else if (cCharAt == '[') {
                sb2.append(cCharAt);
                z11 = true;
            } else if (cCharAt == ']') {
                sb2.append(cCharAt);
                z11 = false;
            } else if (cCharAt != '$') {
                sb2.append(cCharAt);
            } else if (z11) {
                sb2.append(cCharAt);
            } else {
                sb2.append("\\z");
            }
            i11++;
        }
        return sb2.toString();
    }

    public static String replaceLongformCharacterProperties(String str) {
        return replaceCharacterProperties(str, LONGFORM_CHARACTER_PROPERTIES);
    }
}
