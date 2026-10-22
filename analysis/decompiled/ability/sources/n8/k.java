package n8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import x8.InterfaceC2122e;

/* loaded from: classes4.dex */
public final class k extends p implements InterfaceC2122e {

    /* renamed from: a, reason: collision with root package name */
    public final Constructor f5360a;

    public k(Constructor member) {
        kotlin.jvm.internal.k.f(member, "member");
        this.f5360a = member;
    }

    @Override // n8.p
    public final Member b() {
        return this.f5360a;
    }

    @Override // x8.InterfaceC2122e
    public final ArrayList getTypeParameters() {
        TypeVariable[] typeParameters = this.f5360a.getTypeParameters();
        kotlin.jvm.internal.k.e(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new v(typeVariable));
        }
        return arrayList;
    }
}
