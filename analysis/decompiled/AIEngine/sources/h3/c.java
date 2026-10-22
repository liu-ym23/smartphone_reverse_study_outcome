package h3;

import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f9292a;

    static {
        c cVar;
        try {
            cVar = (c) com.fasterxml.jackson.databind.util.a.h(d.class, false);
        } catch (Throwable unused) {
            cVar = null;
        }
        f9292a = cVar;
    }

    public abstract PropertyName a(AnnotatedParameter annotatedParameter);

    public abstract Boolean b(AnnotatedMember annotatedMember);

    public abstract Boolean c(i3.a aVar);
}
