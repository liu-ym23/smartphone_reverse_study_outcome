package q3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o extends i3.e {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f11574j = 0;

    /* renamed from: b, reason: collision with root package name */
    public final AnnotationIntrospector f11575b;

    /* renamed from: c, reason: collision with root package name */
    public final AnnotatedMember f11576c;

    /* renamed from: d, reason: collision with root package name */
    public final PropertyMetadata f11577d;

    /* renamed from: e, reason: collision with root package name */
    public final PropertyName f11578e;
    public final JsonInclude.Value h;

    public o(AnnotationIntrospector annotationIntrospector, AnnotatedMember annotatedMember, PropertyName propertyName, PropertyMetadata propertyMetadata, JsonInclude.Value value) {
        this.f11575b = annotationIntrospector;
        this.f11576c = annotatedMember;
        this.f11578e = propertyName;
        this.f11577d = propertyMetadata == null ? PropertyMetadata.f3743l : propertyMetadata;
        this.h = value;
    }

    public static o C(MapperConfig mapperConfig, VirtualAnnotatedMember virtualAnnotatedMember, PropertyName propertyName, PropertyMetadata propertyMetadata, JsonInclude.Include include) {
        JsonInclude.Value value;
        JsonInclude.Include include2;
        if (include == null || include == (include2 = JsonInclude.Include.f3468e)) {
            value = i3.e.f9503a;
        } else {
            JsonInclude.Value value2 = JsonInclude.Value.f3469e;
            value = include != include2 ? new JsonInclude.Value(include, null, null, null) : JsonInclude.Value.f3469e;
        }
        return new o(mapperConfig.d(), virtualAnnotatedMember, propertyName, propertyMetadata, value);
    }

    @Override // i3.e
    public final boolean A() {
        return false;
    }

    @Override // i3.e
    public final PropertyName b() {
        return this.f11578e;
    }

    @Override // i3.e
    public final PropertyMetadata c() {
        return this.f11577d;
    }

    @Override // q3.k
    public final String getName() {
        return this.f11578e.f3755a;
    }

    @Override // i3.e
    public final JsonInclude.Value i() {
        return this.h;
    }

    @Override // i3.e
    public final AnnotatedParameter n() {
        AnnotatedMember annotatedMember = this.f11576c;
        if (annotatedMember instanceof AnnotatedParameter) {
            return (AnnotatedParameter) annotatedMember;
        }
        return null;
    }

    @Override // i3.e
    public final Iterator<AnnotatedParameter> o() {
        AnnotatedParameter annotatedParameterN = n();
        return annotatedParameterN == null ? com.fasterxml.jackson.databind.util.a.f4531c : Collections.singleton(annotatedParameterN).iterator();
    }

    @Override // i3.e
    public final AnnotatedField p() {
        AnnotatedMember annotatedMember = this.f11576c;
        if (annotatedMember instanceof AnnotatedField) {
            return (AnnotatedField) annotatedMember;
        }
        return null;
    }

    @Override // i3.e
    public final AnnotatedMethod q() {
        AnnotatedMember annotatedMember = this.f11576c;
        if ((annotatedMember instanceof AnnotatedMethod) && ((AnnotatedMethod) annotatedMember).v().length == 0) {
            return (AnnotatedMethod) annotatedMember;
        }
        return null;
    }

    @Override // i3.e
    public final JavaType r() {
        AnnotatedMember annotatedMember = this.f11576c;
        return annotatedMember == null ? TypeFactory.n() : annotatedMember.f();
    }

    @Override // i3.e
    public final Class<?> s() {
        AnnotatedMember annotatedMember = this.f11576c;
        return annotatedMember == null ? Object.class : annotatedMember.e();
    }

    @Override // i3.e
    public final AnnotatedMethod t() {
        AnnotatedMember annotatedMember = this.f11576c;
        if ((annotatedMember instanceof AnnotatedMethod) && ((AnnotatedMethod) annotatedMember).v().length == 1) {
            return (AnnotatedMethod) annotatedMember;
        }
        return null;
    }

    @Override // i3.e
    public final PropertyName u() {
        AnnotationIntrospector annotationIntrospector = this.f11575b;
        if (annotationIntrospector != null && this.f11576c != null) {
            annotationIntrospector.getClass();
        }
        return null;
    }

    @Override // i3.e
    public final boolean v() {
        return this.f11576c instanceof AnnotatedParameter;
    }

    @Override // i3.e
    public final boolean w() {
        return this.f11576c instanceof AnnotatedField;
    }

    @Override // i3.e
    public final boolean x(PropertyName propertyName) {
        return this.f11578e.equals(propertyName);
    }

    @Override // i3.e
    public final boolean y() {
        return t() != null;
    }

    @Override // i3.e
    public final boolean z() {
        return false;
    }
}
