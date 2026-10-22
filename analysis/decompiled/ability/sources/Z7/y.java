package Z7;

import b8.m0;
import b8.p0;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NotImplementedError;

/* loaded from: classes3.dex */
public final class y implements TypeVariable, Type {

    /* renamed from: a, reason: collision with root package name */
    public final v f1613a;

    public y(v typeParameter) {
        kotlin.jvm.internal.k.f(typeParameter, "typeParameter");
        this.f1613a = typeParameter;
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
        p0 p0Var = ((m0) this.f1613a).b;
        t tVar = m0.d[0];
        Object objInvoke = p0Var.invoke();
        kotlin.jvm.internal.k.e(objInvoke, "getValue(...)");
        List list = (List) objInvoke;
        ArrayList arrayList = new ArrayList(D7.w.c0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.b.b((u) it.next(), true));
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    public final GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError(B7.a.k("An operation is not implemented: ", "getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f1613a));
    }

    @Override // java.lang.reflect.TypeVariable
    public final String getName() {
        return ((m0) this.f1613a).a();
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
