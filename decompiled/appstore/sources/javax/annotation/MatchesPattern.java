package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

/* JADX INFO: loaded from: classes4.dex */
@TypeQualifier(applicableTo = String.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MatchesPattern {

    public static class Checker implements TypeQualifierValidator<MatchesPattern> {
        public Checker() {
        }

        @Override // javax.annotation.meta.TypeQualifierValidator
        public /* bridge */ /* synthetic */ When forConstantValue(Annotation r10, Object r11) {
            return forConstantValue((MatchesPattern) r10, r11);
        }

        public When forConstantValue(MatchesPattern r10, Object r11) {
            if (Pattern.compile(r10.value(), r10.flags()).matcher((String) r11).matches() == false) goto L7;
            return When.ALWAYS;
        L7:
            return When.NEVER;
        }
    }

    int flags() default 0;

    @RegEx
    String value();
}
