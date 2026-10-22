package h3;

import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.beans.ConstructorProperties;
import java.beans.Transient;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class d extends c {
    @Override // h3.c
    public final PropertyName a(AnnotatedParameter annotatedParameter) {
        ConstructorProperties constructorPropertiesC;
        AnnotatedWithParams annotatedWithParams = annotatedParameter.f4129c;
        if (annotatedWithParams == null || (constructorPropertiesC = annotatedWithParams.c(ConstructorProperties.class)) == null) {
            return null;
        }
        String[] strArrValue = constructorPropertiesC.value();
        int i10 = annotatedParameter.f4131e;
        if (i10 < strArrValue.length) {
            return PropertyName.a(strArrValue[i10]);
        }
        return null;
    }

    @Override // h3.c
    public final Boolean b(AnnotatedMember annotatedMember) {
        Transient transientC = annotatedMember.c(Transient.class);
        if (transientC != null) {
            return Boolean.valueOf(transientC.value());
        }
        return null;
    }

    @Override // h3.c
    public final Boolean c(i3.a aVar) {
        if (aVar.c(ConstructorProperties.class) != null) {
            return Boolean.TRUE;
        }
        return null;
    }
}
