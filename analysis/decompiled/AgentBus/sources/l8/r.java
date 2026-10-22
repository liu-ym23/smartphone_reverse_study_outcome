package l8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class r extends w implements v8.e {

    /* renamed from: a, reason: collision with root package name */
    public final Constructor f5882a;

    public r(Constructor constructor) {
        q7.k.e(constructor, "member");
        this.f5882a = constructor;
    }

    @Override // l8.w
    public final Member b() {
        return this.f5882a;
    }

    @Override // v8.e
    public final ArrayList getTypeParameters() {
        TypeVariable[] typeParameters = this.f5882a.getTypeParameters();
        q7.k.d(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new c0(typeVariable));
        }
        return arrayList;
    }
}
