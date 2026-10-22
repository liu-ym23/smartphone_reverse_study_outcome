package yc;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import tb.AbstractC5529B;
import tb.AbstractC5531D;
import yc.h;

/* loaded from: classes5.dex */
public final class b extends h.a {

    public static final class a implements h<AbstractC5531D, AbstractC5531D> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f44309a = new a();

        @Override // yc.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC5531D convert(AbstractC5531D abstractC5531D) throws IOException {
            try {
                return A.a(abstractC5531D);
            } finally {
                abstractC5531D.close();
            }
        }
    }

    /* renamed from: yc.b$b, reason: collision with other inner class name */
    public static final class C0559b implements h<AbstractC5529B, AbstractC5529B> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0559b f44310a = new C0559b();

        @Override // yc.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC5529B convert(AbstractC5529B abstractC5529B) {
            return abstractC5529B;
        }
    }

    public static final class c implements h<AbstractC5531D, AbstractC5531D> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f44311a = new c();

        @Override // yc.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC5531D convert(AbstractC5531D abstractC5531D) {
            return abstractC5531D;
        }
    }

    public static final class d implements h<Object, String> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f44312a = new d();

        @Override // yc.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    public static final class e implements h<AbstractC5531D, Y8.t> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f44313a = new e();

        @Override // yc.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Y8.t convert(AbstractC5531D abstractC5531D) {
            abstractC5531D.close();
            return Y8.t.f7040a;
        }
    }

    public static final class f implements h<AbstractC5531D, Void> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f44314a = new f();

        @Override // yc.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void convert(AbstractC5531D abstractC5531D) {
            abstractC5531D.close();
            return null;
        }
    }

    @Override // yc.h.a
    public h<?, AbstractC5529B> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, w wVar) {
        if (AbstractC5529B.class.isAssignableFrom(A.h(type))) {
            return C0559b.f44310a;
        }
        return null;
    }

    @Override // yc.h.a
    public h<AbstractC5531D, ?> d(Type type, Annotation[] annotationArr, w wVar) {
        if (type == AbstractC5531D.class) {
            return A.l(annotationArr, Ac.w.class) ? c.f44311a : a.f44309a;
        }
        if (type == Void.class) {
            return f.f44314a;
        }
        if (A.m(type)) {
            return e.f44313a;
        }
        return null;
    }
}
