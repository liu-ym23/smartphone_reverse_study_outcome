package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

/* JADX INFO: loaded from: classes4.dex */
@TypeQualifier(applicableTo = Number.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Nonnegative {

    public static class Checker implements TypeQualifierValidator<Nonnegative> {
        public Checker() {
        }

        @Override // javax.annotation.meta.TypeQualifierValidator
        public /* bridge */ /* synthetic */ When forConstantValue(Annotation r10, Object r11) {
            return forConstantValue((Nonnegative) r10, r11);
        }

        public When forConstantValue(Nonnegative r10, Object r11) {
            if ((r11 instanceof Number) == false) goto L5;
            Number r12 = (Number) r11;
            if ((r12 instanceof Long) == false) goto L12;
            if (r12.longValue() < 0) goto L24;
        L26:
            return When.ALWAYS;
        L24:
            return When.NEVER;
        L12:
            if ((r12 instanceof Double) == false) goto L17;
            if (r12.doubleValue() >= 0.0d) goto L26;
        L17:
            if ((r12 instanceof Float) == false) goto L22;
            if (r12.floatValue() >= 0.0f) goto L26;
        L22:
            if (r12.intValue() >= 0) goto L26;
        L5:
            return When.NEVER;
        }
    }

    When when() default When.ALWAYS;
}
