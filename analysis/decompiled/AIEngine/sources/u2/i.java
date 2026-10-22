package u2;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface i {
    Class<? extends ObjectIdGenerator<?>> generator();

    String property() default "@id";

    Class<? extends com.fasterxml.jackson.annotation.a> resolver() default com.fasterxml.jackson.annotation.b.class;

    Class<?> scope() default Object.class;
}
