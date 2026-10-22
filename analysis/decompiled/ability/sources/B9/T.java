package B9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.SerializationException;

/* loaded from: classes4.dex */
public abstract class T {

    /* renamed from: a, reason: collision with root package name */
    public static final z9.g[] f230a = new z9.g[0];
    public static final x9.b[] b = new x9.b[0];

    public static final B a(String str, x9.b bVar) {
        return new B(str, new C(bVar));
    }

    public static final Set b(z9.g gVar) {
        kotlin.jvm.internal.k.f(gVar, "<this>");
        if (gVar instanceof InterfaceC0184k) {
            return ((InterfaceC0184k) gVar).a();
        }
        HashSet hashSet = new HashSet(gVar.d());
        int iD = gVar.d();
        for (int i = 0; i < iD; i++) {
            hashSet.add(gVar.e(i));
        }
        return hashSet;
    }

    public static final z9.g[] c(List list) {
        z9.g[] gVarArr;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            list = null;
        }
        return (list == null || (gVarArr = (z9.g[]) list.toArray(new z9.g[0])) == null) ? f230a : gVarArr;
    }

    public static final C0195w d(String str, Enum[] values) {
        kotlin.jvm.internal.k.f(values, "values");
        return new C0195w(str, values);
    }

    public static final int e(z9.g gVar, z9.g[] typeParams) {
        kotlin.jvm.internal.k.f(typeParams, "typeParams");
        int iHashCode = (gVar.h().hashCode() * 31) + Arrays.hashCode(typeParams);
        int iD = gVar.d();
        int i = 1;
        while (true) {
            int iHashCode2 = 0;
            if (!(iD > 0)) {
                break;
            }
            int i6 = iD - 1;
            int i10 = i * 31;
            String strH = gVar.g(gVar.d() - iD).h();
            if (strH != null) {
                iHashCode2 = strH.hashCode();
            }
            i = i10 + iHashCode2;
            iD = i6;
        }
        int iD2 = gVar.d();
        int iHashCode3 = 1;
        while (true) {
            if (!(iD2 > 0)) {
                return (((iHashCode * 31) + i) * 31) + iHashCode3;
            }
            int i11 = iD2 - 1;
            int i12 = iHashCode3 * 31;
            H4.o kind = gVar.g(gVar.d() - iD2).getKind();
            iHashCode3 = i12 + (kind != null ? kind.hashCode() : 0);
            iD2 = i11;
        }
    }

    public static final boolean f(Z7.d dVar) {
        kotlin.jvm.internal.k.f(dVar, "<this>");
        return M.a.Z(dVar).isInterface();
    }

    public static final void g(z9.g descriptor, int i, int i6) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i10 = (~i) & i6;
        for (int i11 = 0; i11 < 32; i11++) {
            if ((i10 & 1) != 0) {
                arrayList.add(descriptor.e(i11));
            }
            i10 >>>= 1;
        }
        String serialName = descriptor.h();
        kotlin.jvm.internal.k.f(serialName, "serialName");
        throw new MissingFieldException(arrayList, arrayList.size() == 1 ? androidx.appfunctions.metadata.a.p(new StringBuilder("Field '"), (String) arrayList.get(0), "' is required for type with serial name '", serialName, "', but it was missing") : "Fields " + arrayList + " are required for type with serial name '" + serialName + "', but they were missing", null);
    }

    public static final void h(String str, Z7.d baseClass) {
        String string;
        kotlin.jvm.internal.k.f(baseClass, "baseClass");
        String str2 = "in the polymorphic scope of '" + baseClass.m() + '\'';
        if (str == null) {
            string = androidx.compose.foundation.b.m('.', "Class discriminator was missing and no default serializers were registered ", str2);
        } else {
            StringBuilder sbW = B7.a.w("Serializer for subclass '", str, "' is not found ", str2, ".\nCheck if class with serial name '");
            androidx.constraintlayout.core.dsl.a.A(sbW, str, "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '", str, "' has to be '@Serializable', and the base class '");
            sbW.append(baseClass.m());
            sbW.append("' has to be sealed and '@Serializable'.");
            string = sbW.toString();
        }
        throw new SerializationException(string);
    }
}
