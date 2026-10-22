package com.fasterxml.jackson.dataformat.yaml.util;

import W4.a;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class StringQuotingChecker implements Serializable {
    private static final Set<String> RESERVED_KEYWORDS = new HashSet(Arrays.asList("false", "False", "FALSE", "n", "N", "no", "No", "NO", "null", "Null", "NULL", a.ENABLE_ON, "On", "ON", a.ENABLE_OFF, "Off", "OFF", "true", "True", "TRUE", "y", "Y", "yes", "Yes", "YES"));
    private static final long serialVersionUID = 1;

    public static class Default extends StringQuotingChecker implements Serializable {
        private static final Default INSTANCE = new Default();
        private static final long serialVersionUID = 1;

        public static Default instance() {
            return INSTANCE;
        }

        @Override // com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker
        public boolean needToQuoteName(String str) {
            return isReservedKeyword(str) || looksLikeYAMLNumber(str) || nameHasQuotableChar(str);
        }

        @Override // com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker
        public boolean needToQuoteValue(String str) {
            return isReservedKeyword(str) || valueHasQuotableChar(str);
        }
    }

    public boolean _isReservedKeyword(int i10, String str) {
        if (i10 != 70 && i10 != 84 && i10 != 89 && i10 != 102 && i10 != 116 && i10 != 121) {
            if (i10 == 126) {
                return true;
            }
            if (i10 != 78 && i10 != 79 && i10 != 110 && i10 != 111) {
                return false;
            }
        }
        return RESERVED_KEYWORDS.contains(str);
    }

    public boolean _looksLikeYAMLNumber(int i10, String str) {
        switch (i10) {
            case 43:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                return true;
            case 44:
            case 47:
            default:
                return false;
        }
    }

    public boolean followedOnlyByBlank(String str, int i10) {
        if (i10 == str.length() - 1) {
            return true;
        }
        return isBlank(str.charAt(i10 + 1));
    }

    public boolean isBlank(char c10) {
        return ' ' == c10 || '\t' == c10;
    }

    public boolean isReservedKeyword(String str) {
        if (str.length() == 0) {
            return true;
        }
        return _isReservedKeyword(str.charAt(0), str);
    }

    public boolean looksLikeYAMLNumber(String str) {
        if (str.length() > 0) {
            return _looksLikeYAMLNumber(str.charAt(0), str);
        }
        return false;
    }

    public boolean nameHasQuotableChar(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (str.charAt(i10) < ' ') {
                return true;
            }
        }
        return false;
    }

    public abstract boolean needToQuoteName(String str);

    public abstract boolean needToQuoteValue(String str);

    public boolean precededOnlyByBlank(String str, int i10) {
        if (i10 == 0) {
            return true;
        }
        return isBlank(str.charAt(i10 - 1));
    }

    public boolean valueHasQuotableChar(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '#') {
                if (cCharAt != ',') {
                    if (cCharAt != ':') {
                        if (cCharAt == '[' || cCharAt == ']' || cCharAt == '{' || cCharAt == '}') {
                        }
                    } else if (followedOnlyByBlank(str, i10)) {
                    }
                }
                return true;
            }
            if (precededOnlyByBlank(str, i10)) {
                return true;
            }
        }
        return false;
    }
}
