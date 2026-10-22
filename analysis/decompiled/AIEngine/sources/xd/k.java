package xd;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import xd.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@IgnoreJRERequirement
/* loaded from: classes.dex */
public final class k extends f.a {

    /* renamed from: a, reason: collision with root package name */
    public static final k f13814a = new k();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @IgnoreJRERequirement
    public static final class a<T> implements f<ad.t, Optional<T>> {

        /* renamed from: g, reason: collision with root package name */
        public final f<ad.t, T> f13815g;

        public a(f<ad.t, T> fVar) {
            this.f13815g = fVar;
        }

        @Override // xd.f
        public final Object a(ad.t tVar) {
            return Optional.ofNullable(this.f13815g.a(tVar));
        }
    }

    @Override // xd.f.a
    public final f<ad.t, ?> b(Type type, Annotation[] annotationArr, t tVar) {
        if (retrofit2.b.e(type) != Optional.class) {
            return null;
        }
        return new a(tVar.c(retrofit2.b.d(0, (ParameterizedType) type), annotationArr));
    }
}
