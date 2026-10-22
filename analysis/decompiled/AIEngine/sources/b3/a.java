package b3;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final JavaType f3041a;

    public a(JavaType javaType) {
        this.f3041a = javaType;
    }

    public abstract JsonFormat.Value a();

    public abstract List<AnnotatedMethod> b();
}
