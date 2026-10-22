package com.fasterxml.jackson.dataformat.yaml.util;

import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class StringQuotingChecker implements Serializable {
    private static final Set<String> RESERVED_KEYWORDS = new HashSet(Arrays.asList("false", "False", "FALSE", "n", "N", "no", "No", "NO", "null", "Null", "NULL", "on", "On", "ON", "off", "Off", "OFF", "true", "True", "TRUE", "y", "Y", "yes", "Yes", "YES"));
    private static final long serialVersionUID = 1;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    public boolean _isReservedKeyword(int i, String str) {
        if (i != 70 && i != 84 && i != 89 && i != 102 && i != 116 && i != 121) {
            if (i == 126) {
                return true;
            }
            if (i != 78 && i != 79 && i != 110 && i != 111) {
                return false;
            }
        }
        return RESERVED_KEYWORDS.contains(str);
    }

    public boolean _looksLikeYAMLNumber(int i, String str) {
        switch (i) {
            case 43:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH /* 53 */:
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

    public boolean followedOnlyByBlank(String str, int i) {
        if (i == str.length() - 1) {
            return true;
        }
        return isBlank(str.charAt(i + 1));
    }

    public boolean isBlank(char c9) {
        return ' ' == c9 || '\t' == c9;
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
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) < ' ') {
                return true;
            }
        }
        return false;
    }

    public abstract boolean needToQuoteName(String str);

    public abstract boolean needToQuoteValue(String str);

    public boolean precededOnlyByBlank(String str, int i) {
        if (i == 0) {
            return true;
        }
        return isBlank(str.charAt(i - 1));
    }

    public boolean valueHasQuotableChar(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '#') {
                if (cCharAt != ',') {
                    if (cCharAt != ':') {
                        if (cCharAt == '[' || cCharAt == ']' || cCharAt == '{' || cCharAt == '}') {
                        }
                    } else if (followedOnlyByBlank(str, i)) {
                    }
                }
                return true;
            }
            if (precededOnlyByBlank(str, i)) {
                return true;
            }
        }
        return false;
    }
}
