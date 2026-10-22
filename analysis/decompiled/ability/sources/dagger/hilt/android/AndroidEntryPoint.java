package dagger.hilt.android;

import dagger.hilt.GeneratesRootInput;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@GeneratesRootInput
/* loaded from: classes2.dex */
public @interface AndroidEntryPoint {
    Class<?> value() default Void.class;
}
