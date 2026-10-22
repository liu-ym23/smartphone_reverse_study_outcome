package m0;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import l0.m;
import o0.C0896i;
import o0.EnumC0889b;
import q0.c0;
import q0.f0;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: m0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public @interface InterfaceC0856d {
    boolean alphabetic() default true;

    boolean asm() default true;

    Class<? extends C0896i.c> autoTypeCheckHandler() default C0896i.c.class;

    Class<?> builder() default Void.class;

    Class<?> deserializer() default Void.class;

    String[] ignores() default {};

    String[] includes() default {};

    Class<?> mappingTo() default Void.class;

    m naming() default m.NeverUseThisValueExceptDefaultValue;

    String[] orders() default {};

    EnumC0889b[] parseFeatures() default {};

    Class<?>[] seeAlso() default {};

    boolean serializeEnumAsJavaBean() default false;

    Class<?> serializer() default Void.class;

    f0[] serialzeFeatures() default {};

    Class<? extends c0>[] serialzeFilters() default {};

    String typeKey() default "";

    String typeName() default "";
}
