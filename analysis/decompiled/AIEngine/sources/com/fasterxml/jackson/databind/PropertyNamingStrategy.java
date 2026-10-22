package com.fasterxml.jackson.databind;

import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PropertyNamingStrategy implements Serializable {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @Deprecated
    public static class KebabCaseStrategy extends PropertyNamingStrategyBase {
        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public final String e(String str) {
            return PropertyNamingStrategyBase.f(str, '-');
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @Deprecated
    public static class LowerCaseStrategy extends PropertyNamingStrategyBase {
        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public final String e(String str) {
            return str.toLowerCase();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @Deprecated
    public static class LowerDotCaseStrategy extends PropertyNamingStrategyBase {
        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public final String e(String str) {
            return PropertyNamingStrategyBase.f(str, '.');
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @Deprecated
    public static abstract class PropertyNamingStrategyBase extends PropertyNamingStrategy {
        public static String f(String str, char c9) {
            int length;
            if (str == null || (length = str.length()) == 0) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder((length >> 1) + length);
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                char cCharAt = str.charAt(i11);
                char lowerCase = Character.toLowerCase(cCharAt);
                if (lowerCase == cCharAt) {
                    if (i10 > 1) {
                        sb2.insert(sb2.length() - 1, c9);
                    }
                    i10 = 0;
                } else {
                    if (i10 == 0 && i11 > 0) {
                        sb2.append(c9);
                    }
                    i10++;
                }
                sb2.append(lowerCase);
            }
            return sb2.toString();
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public final String a(String str) {
            return e(str);
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public final String b(String str) {
            return e(str);
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public final String c(String str) {
            return e(str);
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public final String d(String str) {
            return e(str);
        }

        public abstract String e(String str);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @Deprecated
    public static class SnakeCaseStrategy extends PropertyNamingStrategyBase {
        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public final String e(String str) {
            if (str == null) {
                return str;
            }
            int length = str.length();
            StringBuilder sb2 = new StringBuilder(length * 2);
            int i10 = 0;
            boolean z = false;
            for (int i11 = 0; i11 < length; i11++) {
                char cCharAt = str.charAt(i11);
                if (i11 > 0 || cCharAt != '_') {
                    if (Character.isUpperCase(cCharAt)) {
                        if (!z && i10 > 0 && sb2.charAt(i10 - 1) != '_') {
                            sb2.append('_');
                            i10++;
                        }
                        cCharAt = Character.toLowerCase(cCharAt);
                        z = true;
                    } else {
                        z = false;
                    }
                    sb2.append(cCharAt);
                    i10++;
                }
            }
            return i10 > 0 ? sb2.toString() : str;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @Deprecated
    public static class UpperCamelCaseStrategy extends PropertyNamingStrategyBase {
        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public final String e(String str) {
            char cCharAt;
            char upperCase;
            if (str == null || str.isEmpty() || cCharAt == (upperCase = Character.toUpperCase((cCharAt = str.charAt(0))))) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder(str);
            sb2.setCharAt(0, upperCase);
            return sb2.toString();
        }
    }

    static {
        new PropertyNamingStrategy();
        new UpperCamelCaseStrategy();
        new SnakeCaseStrategy();
        new LowerCaseStrategy();
        new KebabCaseStrategy();
        new LowerDotCaseStrategy();
    }

    public String a(String str) {
        return str;
    }

    public String b(String str) {
        return str;
    }

    public String c(String str) {
        return str;
    }

    public String d(String str) {
        return str;
    }
}
