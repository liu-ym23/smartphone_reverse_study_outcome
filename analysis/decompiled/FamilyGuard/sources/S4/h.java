package S4;

import R4.c;
import R4.t;
import R4.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import x3.AbstractC1286b;
import x3.j;
import x3.m;
import x3.p;
import x3.q;

/* loaded from: classes.dex */
public final class h extends c.a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final p f5282a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5283b;

    private h(@Nullable p pVar, boolean z5) {
        this.f5282a = pVar;
        this.f5283b = z5;
    }

    public static h d() {
        return new h(null, false);
    }

    @Override // R4.c.a
    @Nullable
    public R4.c<?, ?> a(Type type, Annotation[] annotationArr, u uVar) {
        Type typeB;
        boolean z5;
        boolean z6;
        Class<?> clsC = c.a.c(type);
        if (clsC == AbstractC1286b.class) {
            return new g(Void.class, this.f5282a, this.f5283b, false, true, false, false, false, true);
        }
        boolean z7 = clsC == x3.f.class;
        boolean z8 = clsC == q.class;
        boolean z9 = clsC == j.class;
        if (clsC != m.class && !z7 && !z8 && !z9) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z7 ? !z8 ? z9 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type typeB2 = c.a.b(0, (ParameterizedType) type);
        Class<?> clsC2 = c.a.c(typeB2);
        if (clsC2 == t.class) {
            if (!(typeB2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            typeB = c.a.b(0, (ParameterizedType) typeB2);
            z6 = false;
            z5 = false;
        } else if (clsC2 != e.class) {
            typeB = typeB2;
            z5 = true;
            z6 = false;
        } else {
            if (!(typeB2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            typeB = c.a.b(0, (ParameterizedType) typeB2);
            z6 = true;
            z5 = false;
        }
        return new g(typeB, this.f5282a, this.f5283b, z6, z5, z7, z8, z9, false);
    }
}
