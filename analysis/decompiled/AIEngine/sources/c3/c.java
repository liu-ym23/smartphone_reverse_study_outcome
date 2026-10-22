package c3;

import b3.c;
import b3.g;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import q3.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface c {
    Class<?> as() default Void.class;

    Class<?> builder() default Void.class;

    Class<?> contentAs() default Void.class;

    Class<? extends q3.g> contentConverter() default g.a.class;

    Class<? extends b3.c> contentUsing() default c.a.class;

    Class<? extends q3.g> converter() default g.a.class;

    Class<?> keyAs() default Void.class;

    Class<? extends b3.g> keyUsing() default g.a.class;

    Class<? extends b3.c> using() default c.a.class;
}
