package a8;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class w implements h {

    /* renamed from: a, reason: collision with root package name */
    public final Member f459a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f460b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f461c;

    /* renamed from: d, reason: collision with root package name */
    public final List f462d;

    public w(Member member, Type type, Class cls, Type[] typeArr) {
        List listW0;
        this.f459a = member;
        this.f460b = type;
        this.f461c = cls;
        if (cls != null) {
            ab.m mVar = new ab.m(2);
            mVar.a(cls);
            mVar.c(typeArr);
            ArrayList arrayList = mVar.f577f;
            listW0 = d7.s.u0(arrayList.toArray(new Type[arrayList.size()]));
        } else {
            listW0 = d7.n.w0(typeArr);
        }
        this.f462d = listW0;
    }

    public void a(Object[] objArr) {
        g.checkArguments(this, objArr);
    }

    public final void b(Object obj) {
        if (obj == null || !this.f459a.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    @Override // a8.h
    public final Type f() {
        return this.f460b;
    }

    @Override // a8.h
    public final List i() {
        return this.f462d;
    }

    @Override // a8.h
    public final Member j() {
        return this.f459a;
    }
}
