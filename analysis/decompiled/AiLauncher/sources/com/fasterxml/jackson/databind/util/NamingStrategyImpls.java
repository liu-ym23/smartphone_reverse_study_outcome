package com.fasterxml.jackson.databind.util;

/* loaded from: classes2.dex */
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
            StringBuilder sb2 = new StringBuilder(str);
            sb2.setCharAt(0, upperCase);
            return sb2.toString();
        }
    },
    SNAKE_CASE { // from class: com.fasterxml.jackson.databind.util.NamingStrategyImpls.3
        @Override // com.fasterxml.jackson.databind.util.NamingStrategyImpls
        public String translate(String str) {
            if (str == null) {
                return str;
            }
            int length = str.length();
            StringBuilder sb2 = new StringBuilder(length * 2);
            int i10 = 0;
            boolean z10 = false;
            for (int i11 = 0; i11 < length; i11++) {
                char cCharAt = str.charAt(i11);
                if (i11 > 0 || cCharAt != '_') {
                    if (Character.isUpperCase(cCharAt)) {
                        if (!z10 && i10 > 0 && sb2.charAt(i10 - 1) != '_') {
                            sb2.append('_');
                            i10++;
                        }
                        cCharAt = Character.toLowerCase(cCharAt);
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    sb2.append(cCharAt);
                    i10++;
                }
            }
            return i10 > 0 ? sb2.toString() : str;
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

    public static String translateLowerCaseWithSeparator(String str, char c10) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder((length >> 1) + length);
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            char lowerCase = Character.toLowerCase(cCharAt);
            if (lowerCase == cCharAt) {
                if (i10 > 1) {
                    sb2.insert(sb2.length() - 1, c10);
                }
                i10 = 0;
            } else {
                if (i10 == 0 && i11 > 0) {
                    sb2.append(c10);
                }
                i10++;
            }
            sb2.append(lowerCase);
        }
        return sb2.toString();
    }

    public abstract String translate(String str);
}
