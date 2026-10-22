package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

/* JADX INFO: loaded from: classes4.dex */
@TypeQualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Nonnull {

    public static class Checker implements TypeQualifierValidator<Nonnull> {
        public Checker() {
        }

        @Override // javax.annotation.meta.TypeQualifierValidator
        public /* bridge */ /* synthetic */ When forConstantValue(Annotation r10, Object r11) {
            return forConstantValue((Nonnull) r10, r11);
        }

        public When forConstantValue(Nonnull r10, Object r11) {
            if (r11 != null) goto L6;
            return When.NEVER;
        L6:
            return When.ALWAYS;
        }
    }

    When when() default When.ALWAYS;
}
