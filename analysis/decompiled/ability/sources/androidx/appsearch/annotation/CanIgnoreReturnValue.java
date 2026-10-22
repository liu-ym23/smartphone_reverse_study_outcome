package androidx.appsearch.annotation;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.CLASS)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public @interface CanIgnoreReturnValue {
}
