package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.util.NamingStrategyImpls;
import java.util.Locale;

/* loaded from: classes2.dex */
public class EnumNamingStrategies {
    public static final EnumNamingStrategy LOWER_CAMEL_CASE = LowerCamelCaseStrategy.INSTANCE;
    public static final EnumNamingStrategy UPPER_CAMEL_CASE = UpperCamelCaseStrategy.INSTANCE;
    public static final EnumNamingStrategy SNAKE_CASE = SnakeCaseStrategy.INSTANCE;
    public static final EnumNamingStrategy UPPER_SNAKE_CASE = UpperSnakeCaseStrategy.INSTANCE;
    public static final EnumNamingStrategy LOWER_CASE = LowerCaseStrategy.INSTANCE;
    public static final EnumNamingStrategy KEBAB_CASE = KebabCaseStrategy.INSTANCE;
    public static final EnumNamingStrategy LOWER_DOT_CASE = LowerDotCaseStrategy.INSTANCE;

    @Deprecated
    public static class CamelCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final CamelCaseStrategy INSTANCE = new CamelCaseStrategy();

        public CamelCaseStrategy() {
            super(NamingStrategyImpls.LOWER_CAMEL_CASE);
        }
    }

    public static abstract class DelegatingEnumNamingStrategy implements EnumNamingStrategy {
        private final NamingStrategyImpls strategy;

        public DelegatingEnumNamingStrategy(NamingStrategyImpls namingStrategyImpls) {
            this.strategy = namingStrategyImpls;
        }

        private static int nextIndexOfUnderscore(CharSequence charSequence, int i10) {
            int length = charSequence.length();
            while (i10 < length) {
                if ('_' == charSequence.charAt(i10)) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }

        private static String normalizeWord(String str) {
            if (str.length() == 0) {
                return str;
            }
            return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
        }

        public static String toBeanName(String str) {
            StringBuilder sb2 = null;
            if (str == null) {
                return null;
            }
            int i10 = 0;
            int iNextIndexOfUnderscore = -1;
            do {
                iNextIndexOfUnderscore = nextIndexOfUnderscore(str, iNextIndexOfUnderscore + 1);
                if (iNextIndexOfUnderscore != -1) {
                    if (i10 == 0) {
                        sb2 = new StringBuilder(str.length() + 4);
                        sb2.append(str.substring(i10, iNextIndexOfUnderscore).toLowerCase(Locale.ROOT));
                    } else {
                        sb2.append(normalizeWord(str.substring(i10, iNextIndexOfUnderscore)));
                    }
                    i10 = iNextIndexOfUnderscore + 1;
                }
            } while (iNextIndexOfUnderscore != -1);
            if (i10 == 0) {
                return str.toLowerCase(Locale.ROOT);
            }
            sb2.append(normalizeWord(str.substring(i10)));
            return sb2.toString();
        }

        @Override // com.fasterxml.jackson.databind.EnumNamingStrategy
        public String convertEnumToExternalName(String str) {
            return this.strategy.translate(toBeanName(str));
        }
    }

    public static class KebabCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final KebabCaseStrategy INSTANCE = new KebabCaseStrategy();

        public KebabCaseStrategy() {
            super(NamingStrategyImpls.KEBAB_CASE);
        }
    }

    public static class LowerCamelCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final LowerCamelCaseStrategy INSTANCE = new LowerCamelCaseStrategy();

        public LowerCamelCaseStrategy() {
            super(NamingStrategyImpls.LOWER_CAMEL_CASE);
        }
    }

    public static class LowerCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final LowerCaseStrategy INSTANCE = new LowerCaseStrategy();

        public LowerCaseStrategy() {
            super(NamingStrategyImpls.LOWER_CASE);
        }
    }

    public static class LowerDotCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final LowerDotCaseStrategy INSTANCE = new LowerDotCaseStrategy();

        public LowerDotCaseStrategy() {
            super(NamingStrategyImpls.LOWER_DOT_CASE);
        }
    }

    public static class SnakeCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final SnakeCaseStrategy INSTANCE = new SnakeCaseStrategy();

        public SnakeCaseStrategy() {
            super(NamingStrategyImpls.SNAKE_CASE);
        }
    }

    public static class UpperCamelCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final UpperCamelCaseStrategy INSTANCE = new UpperCamelCaseStrategy();

        public UpperCamelCaseStrategy() {
            super(NamingStrategyImpls.UPPER_CAMEL_CASE);
        }
    }

    public static class UpperSnakeCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final UpperSnakeCaseStrategy INSTANCE = new UpperSnakeCaseStrategy();

        public UpperSnakeCaseStrategy() {
            super(NamingStrategyImpls.UPPER_SNAKE_CASE);
        }
    }

    private EnumNamingStrategies() {
    }
}
