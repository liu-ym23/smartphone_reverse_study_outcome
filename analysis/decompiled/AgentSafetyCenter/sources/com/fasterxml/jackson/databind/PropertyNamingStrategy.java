package com.fasterxml.jackson.databind;

import androidx.activity.b;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import java.io.Serializable;
import java.util.logging.Logger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class PropertyNamingStrategy implements Serializable {
    private static final long serialVersionUID = 2;

    @Deprecated
    public static final PropertyNamingStrategy LOWER_CAMEL_CASE = new PropertyNamingStrategy();

    @Deprecated
    public static final PropertyNamingStrategy UPPER_CAMEL_CASE = new UpperCamelCaseStrategy(false);

    @Deprecated
    public static final PropertyNamingStrategy SNAKE_CASE = new SnakeCaseStrategy(false);

    @Deprecated
    public static final PropertyNamingStrategy LOWER_CASE = new LowerCaseStrategy(false);

    @Deprecated
    public static final PropertyNamingStrategy KEBAB_CASE = new KebabCaseStrategy(false);

    @Deprecated
    public static final PropertyNamingStrategy LOWER_DOT_CASE = new LowerDotCaseStrategy(false);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @Deprecated
    public static class KebabCaseStrategy extends PropertyNamingStrategyBase {
        public KebabCaseStrategy() {
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public String translate(String str) {
            return PropertyNamingStrategyBase.translateLowerCaseWithSeparator(str, '-');
        }

        public KebabCaseStrategy(boolean z10) {
            super(z10);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @Deprecated
    public static class LowerCaseStrategy extends PropertyNamingStrategyBase {
        public LowerCaseStrategy() {
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public String translate(String str) {
            return str.toLowerCase();
        }

        public LowerCaseStrategy(boolean z10) {
            super(z10);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @Deprecated
    public static class LowerDotCaseStrategy extends PropertyNamingStrategyBase {
        public LowerDotCaseStrategy() {
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public String translate(String str) {
            return PropertyNamingStrategyBase.translateLowerCaseWithSeparator(str, '.');
        }

        public LowerDotCaseStrategy(boolean z10) {
            super(z10);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @Deprecated
    public static class SnakeCaseStrategy extends PropertyNamingStrategyBase {
        public SnakeCaseStrategy() {
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
        public String translate(String str) {
            if (str == null) {
                return str;
            }
            int length = str.length();
            StringBuilder sb2 = new StringBuilder(length * 2);
            int i = 0;
            boolean z10 = false;
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = str.charAt(i3);
                if (i3 > 0 || cCharAt != '_') {
                    if (Character.isUpperCase(cCharAt)) {
                        if (!z10 && i > 0 && sb2.charAt(i - 1) != '_') {
                            sb2.append('_');
                            i++;
                        }
                        cCharAt = Character.toLowerCase(cCharAt);
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    sb2.append(cCharAt);
                    i++;
                }
            }
            return i > 0 ? sb2.toString() : str;
        }

        public SnakeCaseStrategy(boolean z10) {
            super(z10);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @Deprecated
    public static class UpperCamelCaseStrategy extends PropertyNamingStrategyBase {
        public UpperCamelCaseStrategy() {
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase
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

        public UpperCamelCaseStrategy(boolean z10) {
            super(z10);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @Deprecated
    public static abstract class PropertyNamingStrategyBase extends PropertyNamingStrategy {
        public PropertyNamingStrategyBase(boolean z10) {
            if (z10) {
                String simpleName = getClass().getSimpleName();
                Logger.getLogger(getClass().getName()).warning(b.k("PropertyNamingStrategy.", simpleName, " is used but it has been deprecated due to risk of deadlock. Consider using PropertyNamingStrategies.", simpleName, " instead. See https://github.com/FasterXML/jackson-databind/issues/2715 for more details."));
            }
        }

        public static String translateLowerCaseWithSeparator(String str, char c9) {
            int length;
            if (str == null || (length = str.length()) == 0) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder((length >> 1) + length);
            int i = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = str.charAt(i3);
                char lowerCase = Character.toLowerCase(cCharAt);
                if (lowerCase == cCharAt) {
                    if (i > 1) {
                        sb2.insert(sb2.length() - 1, c9);
                    }
                    i = 0;
                } else {
                    if (i == 0 && i3 > 0) {
                        sb2.append(c9);
                    }
                    i++;
                }
                sb2.append(lowerCase);
            }
            return sb2.toString();
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public String nameForConstructorParameter(MapperConfig<?> mapperConfig, AnnotatedParameter annotatedParameter, String str) {
            return translate(str);
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public String nameForField(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, String str) {
            return translate(str);
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public String nameForGetterMethod(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
            return translate(str);
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public String nameForSetterMethod(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
            return translate(str);
        }

        public abstract String translate(String str);

        public PropertyNamingStrategyBase() {
            this(true);
        }
    }

    public String nameForConstructorParameter(MapperConfig<?> mapperConfig, AnnotatedParameter annotatedParameter, String str) {
        return str;
    }

    public String nameForField(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, String str) {
        return str;
    }

    public String nameForGetterMethod(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
        return str;
    }

    public String nameForSetterMethod(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
        return str;
    }
}
