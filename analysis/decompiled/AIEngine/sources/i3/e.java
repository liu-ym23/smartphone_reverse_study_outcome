package i3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import java.util.Iterator;
import q3.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class e implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonInclude.Value f9503a = JsonInclude.Value.f3469e;

    public boolean A() {
        return z();
    }

    public boolean B() {
        return false;
    }

    public abstract PropertyName b();

    public abstract PropertyMetadata c();

    public boolean g() {
        AnnotatedMember annotatedMemberN = n();
        if (annotatedMemberN == null && (annotatedMemberN = t()) == null) {
            annotatedMemberN = p();
        }
        return annotatedMemberN != null;
    }

    public boolean h() {
        return m() != null;
    }

    public abstract JsonInclude.Value i();

    public h j() {
        return null;
    }

    public AnnotationIntrospector.ReferenceProperty k() {
        return null;
    }

    public Class<?>[] l() {
        return null;
    }

    public final AnnotatedMember m() {
        AnnotatedMethod annotatedMethodQ = q();
        return annotatedMethodQ == null ? p() : annotatedMethodQ;
    }

    public abstract AnnotatedParameter n();

    public Iterator<AnnotatedParameter> o() {
        return com.fasterxml.jackson.databind.util.a.f4531c;
    }

    public abstract AnnotatedField p();

    public abstract AnnotatedMethod q();

    public abstract JavaType r();

    public abstract Class<?> s();

    public abstract AnnotatedMethod t();

    public abstract PropertyName u();

    public abstract boolean v();

    public abstract boolean w();

    public boolean x(PropertyName propertyName) {
        return b().equals(propertyName);
    }

    public abstract boolean y();

    public abstract boolean z();
}
