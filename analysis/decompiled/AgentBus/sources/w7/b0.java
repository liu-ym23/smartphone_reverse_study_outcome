package w7;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z7.n1;
import z7.q1;

/* loaded from: classes.dex */
public final class b0 implements TypeVariable, Type {

    /* renamed from: f, reason: collision with root package name */
    public final v f10863f;

    public b0(v vVar) {
        this.f10863f = vVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TypeVariable) || !getName().equals(((TypeVariable) obj).getName())) {
            return false;
        }
        getGenericDeclaration();
        throw null;
    }

    @Override // java.lang.reflect.TypeVariable
    public final Type[] getBounds() {
        q1 q1Var = ((n1) this.f10863f).f11922g;
        t tVar = n1.f11920i[0];
        Object objC = q1Var.c();
        q7.k.d(objC, "<get-upperBounds>(...)");
        List list = (List) objC;
        ArrayList arrayList = new ArrayList(d7.t.A0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(e0.j((u) it.next(), true));
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    public final GenericDeclaration getGenericDeclaration() {
        throw new c7.i(a1.a.w("An operation is not implemented: ", "getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f10863f), 0);
    }

    @Override // java.lang.reflect.TypeVariable
    public final String getName() {
        return ((n1) this.f10863f).b();
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        return getName();
    }

    public final int hashCode() {
        getName();
        getGenericDeclaration();
        throw null;
    }

    public final String toString() {
        return getName();
    }
}
