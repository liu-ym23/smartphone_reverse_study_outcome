package m0;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import o0.EnumC0889b;
import q0.f0;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: m0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public @interface InterfaceC0854b {
    String[] alternateNames() default {};

    String defaultValue() default "";

    boolean deserialize() default true;

    Class<?> deserializeUsing() default Void.class;

    String format() default "";

    boolean jsonDirect() default false;

    String label() default "";

    String name() default "";

    int ordinal() default 0;

    EnumC0889b[] parseFeatures() default {};

    boolean serialize() default true;

    Class<?> serializeUsing() default Void.class;

    f0[] serialzeFeatures() default {};

    boolean unwrapped() default false;
}
