package i3;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {
    public abstract AnnotatedElement b();

    public abstract <A extends Annotation> A c(Class<A> cls);

    public abstract String d();

    public abstract Class<?> e();

    public abstract boolean equals(Object obj);

    public abstract JavaType f();

    public abstract int hashCode();

    public abstract String toString();
}
