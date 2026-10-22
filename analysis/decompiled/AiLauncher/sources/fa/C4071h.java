package fa;

import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import ea.C4018b;
import ea.InterfaceC4020d;
import fa.AbstractC4067d;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* renamed from: fa.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4071h {

    /* renamed from: a, reason: collision with root package name */
    public static final C4071h f32594a = new C4071h();

    /* renamed from: b, reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.protobuf.d f32595b;

    static {
        kotlin.reflect.jvm.internal.impl.protobuf.d dVarD = kotlin.reflect.jvm.internal.impl.protobuf.d.d();
        JvmProtoBuf.a(dVarD);
        p.h(dVarD, "apply(...)");
        f32595b = dVarD;
    }

    public static /* synthetic */ AbstractC4067d.a d(C4071h c4071h, ProtoBuf$Property protoBuf$Property, InterfaceC4020d interfaceC4020d, ea.h hVar, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        return c4071h.c(protoBuf$Property, interfaceC4020d, hVar, z10);
    }

    public static final boolean f(ProtoBuf$Property proto) {
        p.i(proto, "proto");
        C4018b.C0396b c0396bA = C4066c.f32577a.a();
        Object objS = proto.s(JvmProtoBuf.f35742e);
        p.h(objS, "getExtension(...)");
        Boolean boolD = c0396bA.d(((Number) objS).intValue());
        p.h(boolD, "get(...)");
        return boolD.booleanValue();
    }

    public static final Pair<C4068e, ProtoBuf$Class> h(byte[] bytes, String[] strings) {
        p.i(bytes, "bytes");
        p.i(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new Pair<>(f32594a.k(byteArrayInputStream, strings), ProtoBuf$Class.s1(byteArrayInputStream, f32595b));
    }

    public static final Pair<C4068e, ProtoBuf$Class> i(String[] data, String[] strings) {
        p.i(data, "data");
        p.i(strings, "strings");
        byte[] bArrE = C4064a.e(data);
        p.h(bArrE, "decodeBytes(...)");
        return h(bArrE, strings);
    }

    public static final Pair<C4068e, ProtoBuf$Function> j(String[] data, String[] strings) {
        p.i(data, "data");
        p.i(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(C4064a.e(data));
        return new Pair<>(f32594a.k(byteArrayInputStream, strings), ProtoBuf$Function.X0(byteArrayInputStream, f32595b));
    }

    public static final Pair<C4068e, ProtoBuf$Package> l(byte[] bytes, String[] strings) {
        p.i(bytes, "bytes");
        p.i(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new Pair<>(f32594a.k(byteArrayInputStream, strings), ProtoBuf$Package.d0(byteArrayInputStream, f32595b));
    }

    public static final Pair<C4068e, ProtoBuf$Package> m(String[] data, String[] strings) {
        p.i(data, "data");
        p.i(strings, "strings");
        byte[] bArrE = C4064a.e(data);
        p.h(bArrE, "decodeBytes(...)");
        return l(bArrE, strings);
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.d a() {
        return f32595b;
    }

    public final AbstractC4067d.b b(ProtoBuf$Constructor proto, InterfaceC4020d nameResolver, ea.h typeTable) {
        String strA0;
        p.i(proto, "proto");
        p.i(nameResolver, "nameResolver");
        p.i(typeTable, "typeTable");
        GeneratedMessageLite.e<ProtoBuf$Constructor, JvmProtoBuf.JvmMethodSignature> constructorSignature = JvmProtoBuf.f35738a;
        p.h(constructorSignature, "constructorSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ea.f.a(proto, constructorSignature);
        String string = (jvmMethodSignature == null || !jvmMethodSignature.x()) ? "<init>" : nameResolver.getString(jvmMethodSignature.v());
        if (jvmMethodSignature == null || !jvmMethodSignature.w()) {
            List<ProtoBuf$ValueParameter> listV = proto.V();
            p.h(listV, "getValueParameterList(...)");
            List<ProtoBuf$ValueParameter> list = listV;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : list) {
                C4071h c4071h = f32594a;
                p.f(protoBuf$ValueParameter);
                String strG = c4071h.g(ea.g.r(protoBuf$ValueParameter, typeTable), nameResolver);
                if (strG == null) {
                    return null;
                }
                arrayList.add(strG);
            }
            strA0 = F.A0(arrayList, "", "(", ")V", 0, null, null, 56, null);
        } else {
            strA0 = nameResolver.getString(jvmMethodSignature.u());
        }
        return new AbstractC4067d.b(string, strA0);
    }

    public final AbstractC4067d.a c(ProtoBuf$Property proto, InterfaceC4020d nameResolver, ea.h typeTable, boolean z10) {
        String strG;
        p.i(proto, "proto");
        p.i(nameResolver, "nameResolver");
        p.i(typeTable, "typeTable");
        GeneratedMessageLite.e<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f35741d;
        p.h(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ea.f.a(proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        JvmProtoBuf.JvmFieldSignature jvmFieldSignatureY = jvmPropertySignature.E() ? jvmPropertySignature.y() : null;
        if (jvmFieldSignatureY == null && z10) {
            return null;
        }
        int iM0 = (jvmFieldSignatureY == null || !jvmFieldSignatureY.x()) ? proto.M0() : jvmFieldSignatureY.v();
        if (jvmFieldSignatureY == null || !jvmFieldSignatureY.w()) {
            strG = g(ea.g.o(proto, typeTable), nameResolver);
            if (strG == null) {
                return null;
            }
        } else {
            strG = nameResolver.getString(jvmFieldSignatureY.u());
        }
        return new AbstractC4067d.a(nameResolver.getString(iM0), strG);
    }

    public final AbstractC4067d.b e(ProtoBuf$Function proto, InterfaceC4020d nameResolver, ea.h typeTable) {
        String string;
        p.i(proto, "proto");
        p.i(nameResolver, "nameResolver");
        p.i(typeTable, "typeTable");
        GeneratedMessageLite.e<ProtoBuf$Function, JvmProtoBuf.JvmMethodSignature> methodSignature = JvmProtoBuf.f35739b;
        p.h(methodSignature, "methodSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ea.f.a(proto, methodSignature);
        int iW0 = (jvmMethodSignature == null || !jvmMethodSignature.x()) ? proto.w0() : jvmMethodSignature.v();
        if (jvmMethodSignature == null || !jvmMethodSignature.w()) {
            List listQ = C1173v.q(ea.g.l(proto, typeTable));
            List<ProtoBuf$ValueParameter> listI0 = proto.I0();
            p.h(listI0, "getValueParameterList(...)");
            List<ProtoBuf$ValueParameter> list = listI0;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : list) {
                p.f(protoBuf$ValueParameter);
                arrayList.add(ea.g.r(protoBuf$ValueParameter, typeTable));
            }
            List listS0 = F.S0(listQ, arrayList);
            ArrayList arrayList2 = new ArrayList(C1174w.x(listS0, 10));
            Iterator it = listS0.iterator();
            while (it.hasNext()) {
                String strG = f32594a.g((ProtoBuf$Type) it.next(), nameResolver);
                if (strG == null) {
                    return null;
                }
                arrayList2.add(strG);
            }
            String strG2 = g(ea.g.n(proto, typeTable), nameResolver);
            if (strG2 == null) {
                return null;
            }
            string = F.A0(arrayList2, "", "(", ")", 0, null, null, 56, null) + strG2;
        } else {
            string = nameResolver.getString(jvmMethodSignature.u());
        }
        return new AbstractC4067d.b(nameResolver.getString(iW0), string);
    }

    public final String g(ProtoBuf$Type protoBuf$Type, InterfaceC4020d interfaceC4020d) {
        if (protoBuf$Type.l0()) {
            return C4065b.b(interfaceC4020d.b(protoBuf$Type.W()));
        }
        return null;
    }

    public final C4068e k(InputStream inputStream, String[] strArr) throws IOException {
        JvmProtoBuf.StringTableTypes stringTableTypesC = JvmProtoBuf.StringTableTypes.C(inputStream, f32595b);
        p.h(stringTableTypesC, "parseDelimitedFrom(...)");
        return new C4068e(stringTableTypesC, strArr);
    }
}
