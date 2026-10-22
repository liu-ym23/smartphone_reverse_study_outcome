package H1;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Method from annotation default annotation not found: alphabetic */
/* JADX WARN: Method from annotation default annotation not found: asm */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface c {
    String[] ignores() default {};

    Class<?> mappingTo() default Void.class;

    String[] orders() default {};

    Feature[] parseFeatures() default {};

    Class<?>[] seeAlso() default {};

    SerializerFeature[] serialzeFeatures() default {};

    String typeKey() default "";

    String typeName() default "";
}
