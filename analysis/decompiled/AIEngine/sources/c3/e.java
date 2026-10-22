package c3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface e {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f3283a;

        /* renamed from: b, reason: collision with root package name */
        public final String f3284b;

        public a(e eVar) {
            String strBuildMethodName = eVar.buildMethodName();
            String strWithPrefix = eVar.withPrefix();
            this.f3283a = strBuildMethodName;
            this.f3284b = strWithPrefix;
        }
    }

    String buildMethodName() default "build";

    String withPrefix() default "with";
}
