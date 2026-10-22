package yc;

import android.annotation.TargetApi;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import tb.AbstractC5531D;
import yc.h;

@TargetApi(24)
@IgnoreJRERequirement
/* loaded from: classes5.dex */
public final class p extends h.a {

    @IgnoreJRERequirement
    public static final class a<T> implements h<AbstractC5531D, Optional<T>> {

        /* renamed from: a, reason: collision with root package name */
        public final h<AbstractC5531D, T> f44366a;

        public a(h<AbstractC5531D, T> hVar) {
            this.f44366a = hVar;
        }

        @Override // yc.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Optional<T> convert(AbstractC5531D abstractC5531D) throws IOException {
            return Optional.ofNullable(this.f44366a.convert(abstractC5531D));
        }
    }

    @Override // yc.h.a
    public h<AbstractC5531D, ?> d(Type type, Annotation[] annotationArr, w wVar) {
        if (h.a.b(type) != Optional.class) {
            return null;
        }
        return new a(wVar.j(h.a.a(0, (ParameterizedType) type), annotationArr));
    }
}
