package kotlin.reflect;

import D7.w;
import Z7.A;
import Z7.C0290a;
import Z7.d;
import Z7.e;
import Z7.u;
import Z7.v;
import Z7.x;
import Z7.y;
import Z7.z;
import i9.i;
import j9.t;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public abstract class b {
    public static final String a(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            return cls.getName();
        }
        i iVarK0 = kotlin.sequences.a.k0(TypesJVMKt$typeToString$unwrap$1.f4934a, type);
        StringBuilder sb = new StringBuilder();
        Iterator it = iVarK0.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        sb.append(((Class) next).getName());
        sb.append(t.a0(kotlin.sequences.a.d0(iVarK0), "[]"));
        return sb.toString();
    }

    public static final Type b(u uVar, boolean z10) {
        e eVarA = uVar.a();
        if (eVarA instanceof v) {
            return new y((v) eVarA);
        }
        if (!(eVarA instanceof d)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + uVar);
        }
        d dVar = (d) eVarA;
        Class clsA0 = z10 ? M.a.a0(dVar) : M.a.Z(dVar);
        List listC = uVar.c();
        if (listC.isEmpty()) {
            return clsA0;
        }
        if (!clsA0.isArray()) {
            return c(clsA0, listC);
        }
        if (clsA0.getComponentType().isPrimitive()) {
            return clsA0;
        }
        x xVar = (x) D7.v.W0(listC);
        if (xVar == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + uVar);
        }
        KVariance kVariance = xVar.f1612a;
        u uVar2 = xVar.b;
        int i = kVariance == null ? -1 : z.f1614a[kVariance.ordinal()];
        if (i == -1 || i == 1) {
            return clsA0;
        }
        if (i != 2 && i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        k.c(uVar2);
        Type typeB = b(uVar2, false);
        return typeB instanceof Class ? clsA0 : new C0290a(typeB);
    }

    public static final a c(Class cls, List list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List list2 = list;
            ArrayList arrayList = new ArrayList(w.c0(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(d((x) it.next()));
            }
            return new a(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List list3 = list;
            ArrayList arrayList2 = new ArrayList(w.c0(list3, 10));
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(d((x) it2.next()));
            }
            return new a(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        a aVarC = c(declaringClass, list.subList(length, list.size()));
        List listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(w.c0(listSubList, 10));
        Iterator it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(d((x) it3.next()));
        }
        return new a(cls, aVarC, arrayList3);
    }

    public static final Type d(x xVar) {
        KVariance kVariance = xVar.f1612a;
        if (kVariance == null) {
            return A.c;
        }
        u uVar = xVar.b;
        k.c(uVar);
        int iOrdinal = kVariance.ordinal();
        if (iOrdinal == 0) {
            return b(uVar, true);
        }
        if (iOrdinal == 1) {
            return new A(null, b(uVar, true));
        }
        if (iOrdinal == 2) {
            return new A(b(uVar, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
