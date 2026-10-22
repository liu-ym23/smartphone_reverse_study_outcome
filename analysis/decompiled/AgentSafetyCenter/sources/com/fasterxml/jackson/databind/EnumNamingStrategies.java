package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.util.NamingStrategyImpls;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class EnumNamingStrategies {
    public static final EnumNamingStrategy LOWER_CAMEL_CASE = LowerCamelCaseStrategy.INSTANCE;
    public static final EnumNamingStrategy UPPER_CAMEL_CASE = UpperCamelCaseStrategy.INSTANCE;
    public static final EnumNamingStrategy SNAKE_CASE = SnakeCaseStrategy.INSTANCE;
    public static final EnumNamingStrategy UPPER_SNAKE_CASE = UpperSnakeCaseStrategy.INSTANCE;
    public static final EnumNamingStrategy LOWER_CASE = LowerCaseStrategy.INSTANCE;
    public static final EnumNamingStrategy KEBAB_CASE = KebabCaseStrategy.INSTANCE;
    public static final EnumNamingStrategy LOWER_DOT_CASE = LowerDotCaseStrategy.INSTANCE;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @Deprecated
    public static class CamelCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final CamelCaseStrategy INSTANCE = new CamelCaseStrategy();

        public CamelCaseStrategy() {
            super(NamingStrategyImpls.LOWER_CAMEL_CASE);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class DelegatingEnumNamingStrategy implements EnumNamingStrategy {
        private final NamingStrategyImpls strategy;

        public DelegatingEnumNamingStrategy(NamingStrategyImpls namingStrategyImpls) {
            this.strategy = namingStrategyImpls;
        }

        private static int nextIndexOfUnderscore(CharSequence charSequence, int i) {
            int length = charSequence.length();
            while (i < length) {
                if ('_' == charSequence.charAt(i)) {
                    return i;
                }
                i++;
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
            int i = 0;
            int iNextIndexOfUnderscore = -1;
            do {
                iNextIndexOfUnderscore = nextIndexOfUnderscore(str, iNextIndexOfUnderscore + 1);
                if (iNextIndexOfUnderscore != -1) {
                    if (i == 0) {
                        sb2 = new StringBuilder(str.length() + 4);
                        sb2.append(str.substring(i, iNextIndexOfUnderscore).toLowerCase(Locale.ROOT));
                    } else {
                        sb2.append(normalizeWord(str.substring(i, iNextIndexOfUnderscore)));
                    }
                    i = iNextIndexOfUnderscore + 1;
                }
            } while (iNextIndexOfUnderscore != -1);
            if (i == 0) {
                return str.toLowerCase(Locale.ROOT);
            }
            sb2.append(normalizeWord(str.substring(i)));
            return sb2.toString();
        }

        @Override // com.fasterxml.jackson.databind.EnumNamingStrategy
        public String convertEnumToExternalName(String str) {
            return this.strategy.translate(toBeanName(str));
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class KebabCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final KebabCaseStrategy INSTANCE = new KebabCaseStrategy();

        public KebabCaseStrategy() {
            super(NamingStrategyImpls.KEBAB_CASE);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class LowerCamelCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final LowerCamelCaseStrategy INSTANCE = new LowerCamelCaseStrategy();

        public LowerCamelCaseStrategy() {
            super(NamingStrategyImpls.LOWER_CAMEL_CASE);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class LowerCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final LowerCaseStrategy INSTANCE = new LowerCaseStrategy();

        public LowerCaseStrategy() {
            super(NamingStrategyImpls.LOWER_CASE);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class LowerDotCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final LowerDotCaseStrategy INSTANCE = new LowerDotCaseStrategy();

        public LowerDotCaseStrategy() {
            super(NamingStrategyImpls.LOWER_DOT_CASE);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class SnakeCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final SnakeCaseStrategy INSTANCE = new SnakeCaseStrategy();

        public SnakeCaseStrategy() {
            super(NamingStrategyImpls.SNAKE_CASE);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class UpperCamelCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final UpperCamelCaseStrategy INSTANCE = new UpperCamelCaseStrategy();

        public UpperCamelCaseStrategy() {
            super(NamingStrategyImpls.UPPER_CAMEL_CASE);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class UpperSnakeCaseStrategy extends DelegatingEnumNamingStrategy {
        public static final UpperSnakeCaseStrategy INSTANCE = new UpperSnakeCaseStrategy();

        public UpperSnakeCaseStrategy() {
            super(NamingStrategyImpls.UPPER_SNAKE_CASE);
        }
    }

    private EnumNamingStrategies() {
    }
}
