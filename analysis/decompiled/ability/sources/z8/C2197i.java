package z8;

import com.fasterxml.jackson.core.JsonPointer;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import m8.C1682b;
import n8.AbstractC1744c;

/* renamed from: z8.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2197i implements V8.j {

    /* renamed from: a, reason: collision with root package name */
    public final O8.b f6985a;
    public final O8.b b;
    public final C1682b c;

    public C2197i(C1682b kotlinClass, ProtoBuf$Package packageProto, F8.g nameResolver, DeserializedContainerAbiStability deserializedContainerAbiStability) {
        kotlin.jvm.internal.k.f(kotlinClass, "kotlinClass");
        kotlin.jvm.internal.k.f(packageProto, "packageProto");
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        O8.b bVar = new O8.b(O8.b.e(AbstractC1744c.a(kotlinClass.f5307a)));
        A8.a aVar = kotlinClass.b;
        O8.b bVarC = null;
        String str = ((KotlinClassHeader$Kind) aVar.c) != KotlinClassHeader$Kind.i ? null : (String) aVar.h;
        if (str != null && str.length() > 0) {
            bVarC = O8.b.c(str);
        }
        this.f6985a = bVar;
        this.b = bVarC;
        this.c = kotlinClass;
        H8.l packageModuleName = E8.c.m;
        kotlin.jvm.internal.k.e(packageModuleName, "packageModuleName");
        Integer num = (Integer) D8.h.a(packageProto, packageModuleName);
        if (num != null) {
            nameResolver.getString(num.intValue());
        }
    }

    public final G8.b a() {
        G8.c cVar;
        O8.b bVar = this.f6985a;
        String str = bVar.f1042a;
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf == -1) {
            cVar = G8.c.c;
            if (cVar == null) {
                O8.b.a(9);
                throw null;
            }
        } else {
            cVar = new G8.c(str.substring(0, iLastIndexOf).replace(JsonPointer.SEPARATOR, '.'));
        }
        String strD = bVar.d();
        kotlin.jvm.internal.k.e(strD, "getInternalName(...)");
        return new G8.b(cVar, G8.f.e(j9.m.I0(JsonPointer.SEPARATOR, strD, strD)));
    }

    @Override // V8.j
    public final String f() {
        return "Class '" + a().a().b() + '\'';
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        com.stepos.statsrpk.service.c.q(sb, C2197i.class, ": ");
        sb.append(this.f6985a);
        return sb.toString();
    }
}
