package n3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final SerializationConfig f10614a;

    /* renamed from: b, reason: collision with root package name */
    public final i3.d f10615b;

    /* renamed from: c, reason: collision with root package name */
    public final AnnotationIntrospector f10616c;

    /* renamed from: d, reason: collision with root package name */
    public Object f10617d;

    /* renamed from: e, reason: collision with root package name */
    public final JsonInclude.Value f10618e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f10619f;

    public d(SerializationConfig serializationConfig, i3.d dVar) {
        this.f10614a = serializationConfig;
        this.f10615b = dVar;
        JsonInclude.Value value = JsonInclude.Value.f3469e;
        AnnotationIntrospector annotationIntrospector = dVar.f9498d;
        JsonInclude.Value valueA = annotationIntrospector != null ? value.a(annotationIntrospector.J(dVar.f9499e)) : value;
        serializationConfig.e(dVar.f3041a.f3690a).getClass();
        JsonInclude.Value valueA2 = valueA.a(value);
        JsonInclude.Value value2 = serializationConfig.f3835j.f3810a;
        this.f10618e = value2 == null ? valueA2 : value2.a(valueA2);
        this.f10619f = valueA2.f3470a == JsonInclude.Include.f3467d;
        this.f10616c = serializationConfig.d();
    }

    public final JavaType a(AnnotatedMember annotatedMember, boolean z, JavaType javaType) {
        SerializationConfig serializationConfig = this.f10614a;
        AnnotationIntrospector annotationIntrospector = this.f10616c;
        JavaType javaTypeP0 = annotationIntrospector.p0(serializationConfig, annotatedMember, javaType);
        if (javaTypeP0 != javaType) {
            Class<?> cls = javaTypeP0.f3690a;
            Class<?> cls2 = javaType.f3690a;
            if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + annotatedMember.d() + "': class " + cls.getName() + " not a super-type of (declared) class " + cls2.getName());
            }
            javaType = javaTypeP0;
            z = true;
        }
        JsonSerialize.Typing typingT = annotationIntrospector.T(annotatedMember);
        if (typingT != null && typingT != JsonSerialize.Typing.f3786c) {
            z = typingT == JsonSerialize.Typing.f3785b;
        }
        if (z) {
            return javaType.K();
        }
        return null;
    }
}
