package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

/* JADX INFO: loaded from: classes3.dex */
@TypeQualifier(applicableTo = Number.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Nonnegative {

    public static class Checker implements TypeQualifierValidator<Nonnegative> {
        public Checker() {
        }

        @Override // javax.annotation.meta.TypeQualifierValidator
        public /* bridge */ /* synthetic */ When forConstantValue(Annotation r1, Object r2) {
            return forConstantValue((Nonnegative) r1, r2);
        }

        public When forConstantValue(Nonnegative annotation, Object v) {
            if ((v instanceof Number) == false) goto L5;
            Number value = (Number) v;
            boolean isNegative = false;
            if ((value instanceof Long) == false) goto L13;
            if (value.longValue() >= 0) goto L27;
            isNegative = true;
        L27:
            if (isNegative == false) goto L31;
            return When.NEVER;
        L31:
            return When.ALWAYS;
        L13:
            if ((value instanceof Double) == false) goto L19;
            if (value.doubleValue() >= 0.0d) goto L27;
            isNegative = true;
            goto L27
        L19:
            if ((value instanceof Float) == false) goto L25;
            if (value.floatValue() >= 0.0f) goto L27;
            isNegative = true;
            goto L27
        L25:
            if (value.intValue() >= 0) goto L27;
            isNegative = true;
            goto L27
        L5:
            return When.NEVER;
        }
    }

    When when() default When.ALWAYS;
}
