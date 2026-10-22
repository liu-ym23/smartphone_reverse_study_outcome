package com.fasterxml.jackson.databind.util;

/* loaded from: classes3.dex */
public enum NamingStrategyImpls {
    LOWER_CAMEL_CASE { // from class: com.fasterxml.jackson.databind.util.NamingStrategyImpls.1
        @Override // com.fasterxml.jackson.databind.util.NamingStrategyImpls
        public String translate(String str) {
            return str;
        }
    },
    UPPER_CAMEL_CASE { // from class: com.fasterxml.jackson.databind.util.NamingStrategyImpls.2
        @Override // com.fasterxml.jackson.databind.util.NamingStrategyImpls
        public String translate(String str) {
            char cCharAt;
            char upperCase;
            if (str == null || str.isEmpty() || cCharAt == (upperCase = Character.toUpperCase((cCharAt = str.charAt(0))))) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            sb.setCharAt(0, upperCase);
            return sb.toString();
        }
    },
    SNAKE_CASE { // from class: com.fasterxml.jackson.databind.util.NamingStrategyImpls.3
        @Override // com.fasterxml.jackson.databind.util.NamingStrategyImpls
        public String translate(String str) {
            if (str == null) {
                return str;
            }
            int length = str.length();
            StringBuilder sb = new StringBuilder(length * 2);
            int i = 0;
            boolean z10 = false;
            for (int i6 = 0; i6 < length; i6++) {
                char cCharAt = str.charAt(i6);
                if (i6 > 0 || cCharAt != '_') {
                    if (Character.isUpperCase(cCharAt)) {
                        if (!z10 && i > 0 && sb.charAt(i - 1) != '_') {
                            sb.append('_');
                            i++;
                        }
                        cCharAt = Character.toLowerCase(cCharAt);
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    sb.append(cCharAt);
                    i++;
                }
            }
            return i > 0 ? sb.toString() : str;
        }
    },
    UPPER_SNAKE_CASE { // from class: com.fasterxml.jackson.databind.util.NamingStrategyImpls.4
        @Override // com.fasterxml.jackson.databind.util.NamingStrategyImpls
        public String translate(String str) {
            String strTranslate = NamingStrategyImpls.SNAKE_CASE.translate(str);
            if (strTranslate == null) {
                return null;
            }
            return strTranslate.toUpperCase();
        }
    },
    LOWER_CASE { // from class: com.fasterxml.jackson.databind.util.NamingStrategyImpls.5
        @Override // com.fasterxml.jackson.databind.util.NamingStrategyImpls
        public String translate(String str) {
            return (str == null || str.isEmpty()) ? str : str.toLowerCase();
        }
    },
    KEBAB_CASE { // from class: com.fasterxml.jackson.databind.util.NamingStrategyImpls.6
        @Override // com.fasterxml.jackson.databind.util.NamingStrategyImpls
        public String translate(String str) {
            return NamingStrategyImpls.translateLowerCaseWithSeparator(str, '-');
        }
    },
    LOWER_DOT_CASE { // from class: com.fasterxml.jackson.databind.util.NamingStrategyImpls.7
        @Override // com.fasterxml.jackson.databind.util.NamingStrategyImpls
        public String translate(String str) {
            return NamingStrategyImpls.translateLowerCaseWithSeparator(str, '.');
        }
    };

    public static String translateLowerCaseWithSeparator(String str, char c) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder((length >> 1) + length);
        int i = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = str.charAt(i6);
            char lowerCase = Character.toLowerCase(cCharAt);
            if (lowerCase == cCharAt) {
                if (i > 1) {
                    sb.insert(sb.length() - 1, c);
                }
                i = 0;
            } else {
                if (i == 0 && i6 > 0) {
                    sb.append(c);
                }
                i++;
            }
            sb.append(lowerCase);
        }
        return sb.toString();
    }

    public abstract String translate(String str);
}
