package F8;

import D7.v;
import D7.w;
import D8.j;
import H4.o;
import H8.AbstractC0241b;
import H8.C0245f;
import H8.l;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final H8.h f596a;

    static {
        H8.h hVar = new H8.h();
        hVar.a(E8.c.f494a);
        hVar.a(E8.c.b);
        hVar.a(E8.c.c);
        hVar.a(E8.c.d);
        hVar.a(E8.c.e);
        hVar.a(E8.c.f);
        hVar.a(E8.c.g);
        hVar.a(E8.c.h);
        hVar.a(E8.c.i);
        hVar.a(E8.c.f495j);
        hVar.a(E8.c.k);
        hVar.a(E8.c.l);
        hVar.a(E8.c.m);
        hVar.a(E8.c.n);
        f596a = hVar;
    }

    public static e a(ProtoBuf$Constructor proto, D8.f nameResolver, j typeTable) {
        String strI0;
        k.f(proto, "proto");
        k.f(nameResolver, "nameResolver");
        k.f(typeTable, "typeTable");
        l constructorSignature = E8.c.f494a;
        k.e(constructorSignature, "constructorSignature");
        JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature = (JvmProtoBuf$JvmMethodSignature) D8.h.a(proto, constructorSignature);
        String string = (jvmProtoBuf$JvmMethodSignature == null || (jvmProtoBuf$JvmMethodSignature.b & 1) != 1) ? AppAgent.CONSTRUCT : nameResolver.getString(jvmProtoBuf$JvmMethodSignature.c);
        if (jvmProtoBuf$JvmMethodSignature == null || (jvmProtoBuf$JvmMethodSignature.b & 2) != 2) {
            List list = proto.e;
            k.e(list, "getValueParameterList(...)");
            List<ProtoBuf$ValueParameter> list2 = list;
            ArrayList arrayList = new ArrayList(w.c0(list2, 10));
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : list2) {
                k.c(protoBuf$ValueParameter);
                String strE = e(D8.i.e(protoBuf$ValueParameter, typeTable), nameResolver);
                if (strE == null) {
                    return null;
                }
                arrayList.add(strE);
            }
            strI0 = v.I0(arrayList, "", "(", ")V", null, 56);
        } else {
            strI0 = nameResolver.getString(jvmProtoBuf$JvmMethodSignature.d);
        }
        return new e(string, strI0);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v2 java.lang.String, still in use, count: 2, list:
          (r4v2 java.lang.String) from 0x0052: IF  (r4v2 java.lang.String) == (null java.lang.String)  -> B:23:0x0054 A[HIDDEN]
          (r4v2 java.lang.String) from 0x0055: PHI (r4v3 java.lang.String) = (r4v2 java.lang.String), (r4v5 java.lang.String) binds: [B:22:0x0052, B:20:0x0043] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:34)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public static F8.d b(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r4, D8.f r5, D8.j r6, boolean r7) {
        /*
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.k.f(r4, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.k.f(r5, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.k.f(r6, r0)
            H8.l r0 = E8.c.d
            java.lang.String r1 = "propertySignature"
            kotlin.jvm.internal.k.e(r0, r1)
            java.lang.Object r0 = D8.h.a(r4, r0)
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r0 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature) r0
            r1 = 0
            if (r0 != 0) goto L20
            goto L54
        L20:
            int r2 = r0.b
            r3 = 1
            r2 = r2 & r3
            if (r2 != r3) goto L29
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r0 = r0.c
            goto L2a
        L29:
            r0 = r1
        L2a:
            if (r0 != 0) goto L2f
            if (r7 == 0) goto L2f
            goto L54
        L2f:
            if (r0 == 0) goto L39
            int r7 = r0.b
            r7 = r7 & r3
            if (r7 != r3) goto L39
            int r7 = r0.c
            goto L3b
        L39:
            int r7 = r4.f
        L3b:
            if (r0 == 0) goto L4a
            int r2 = r0.b
            r3 = 2
            r2 = r2 & r3
            if (r2 != r3) goto L4a
            int r4 = r0.d
            java.lang.String r4 = r5.getString(r4)
            goto L55
        L4a:
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r4 = D8.i.d(r4, r6)
            java.lang.String r4 = e(r4, r5)
            if (r4 != 0) goto L55
        L54:
            return r1
        L55:
            F8.d r6 = new F8.d
            java.lang.String r5 = r5.getString(r7)
            r6.<init>(r5, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: F8.i.b(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, D8.f, D8.j, boolean):F8.d");
    }

    public static e c(ProtoBuf$Function proto, D8.f nameResolver, j typeTable) {
        String strQ;
        k.f(proto, "proto");
        k.f(nameResolver, "nameResolver");
        k.f(typeTable, "typeTable");
        l methodSignature = E8.c.b;
        k.e(methodSignature, "methodSignature");
        JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature = (JvmProtoBuf$JvmMethodSignature) D8.h.a(proto, methodSignature);
        int i = (jvmProtoBuf$JvmMethodSignature == null || (jvmProtoBuf$JvmMethodSignature.b & 1) != 1) ? proto.f : jvmProtoBuf$JvmMethodSignature.c;
        if (jvmProtoBuf$JvmMethodSignature == null || (jvmProtoBuf$JvmMethodSignature.b & 2) != 2) {
            List listO = o.O(D8.i.b(proto, typeTable));
            List list = proto.o;
            k.e(list, "getValueParameterList(...)");
            List<ProtoBuf$ValueParameter> list2 = list;
            ArrayList arrayList = new ArrayList(w.c0(list2, 10));
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : list2) {
                k.c(protoBuf$ValueParameter);
                arrayList.add(D8.i.e(protoBuf$ValueParameter, typeTable));
            }
            ArrayList arrayListQ0 = v.Q0(arrayList, listO);
            ArrayList arrayList2 = new ArrayList(w.c0(arrayListQ0, 10));
            Iterator it = arrayListQ0.iterator();
            while (it.hasNext()) {
                String strE = e((ProtoBuf$Type) it.next(), nameResolver);
                if (strE == null) {
                    return null;
                }
                arrayList2.add(strE);
            }
            String strE2 = e(D8.i.c(proto, typeTable), nameResolver);
            if (strE2 == null) {
                return null;
            }
            strQ = B7.a.q(new StringBuilder(), v.I0(arrayList2, "", "(", ")", null, 56), strE2);
        } else {
            strQ = nameResolver.getString(jvmProtoBuf$JvmMethodSignature.d);
        }
        return new e(nameResolver.getString(i), strQ);
    }

    public static final boolean d(ProtoBuf$Property proto) {
        k.f(proto, "proto");
        D8.b bVar = c.f590a;
        Object objI = proto.i(E8.c.e);
        k.e(objI, "getExtension(...)");
        return bVar.c(((Number) objI).intValue()).booleanValue();
    }

    public static String e(ProtoBuf$Type protoBuf$Type, D8.f fVar) {
        if ((protoBuf$Type.c & 16) == 16) {
            return b.b(fVar.b(protoBuf$Type.i));
        }
        return null;
    }

    public static final Pair f(String[] strArr, String[] strings) throws InvalidProtocolBufferException {
        k.f(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.a(strArr));
        g gVarG = g(byteArrayInputStream, strings);
        B8.a aVar = ProtoBuf$Class.f5019O;
        aVar.getClass();
        C0245f c0245f = new C0245f(byteArrayInputStream);
        AbstractC0241b abstractC0241b = (AbstractC0241b) aVar.a(c0245f, f596a);
        try {
            c0245f.a(0);
            if (abstractC0241b.isInitialized()) {
                return new Pair(gVarG, (ProtoBuf$Class) abstractC0241b);
            }
            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(new UninitializedMessageException().getMessage());
            invalidProtocolBufferException.f5100a = abstractC0241b;
            throw invalidProtocolBufferException;
        } catch (InvalidProtocolBufferException e) {
            e.f5100a = abstractC0241b;
            throw e;
        }
    }

    public static g g(ByteArrayInputStream byteArrayInputStream, String[] strings) {
        JvmProtoBuf$StringTableTypes jvmProtoBuf$StringTableTypes = (JvmProtoBuf$StringTableTypes) JvmProtoBuf$StringTableTypes.h.b(byteArrayInputStream, f596a);
        k.e(jvmProtoBuf$StringTableTypes, "parseDelimitedFrom(...)");
        k.f(strings, "strings");
        List list = jvmProtoBuf$StringTableTypes.c;
        Set setJ1 = list.isEmpty() ? EmptySet.f4895a : v.j1(list);
        List<JvmProtoBuf$StringTableTypes.Record> list2 = jvmProtoBuf$StringTableTypes.b;
        k.e(list2, "getRecordList(...)");
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(list2.size());
        for (JvmProtoBuf$StringTableTypes.Record record : list2) {
            int i = record.c;
            for (int i6 = 0; i6 < i; i6++) {
                arrayList.add(record);
            }
        }
        arrayList.trimToSize();
        return new g(strings, setJ1, arrayList);
    }

    public static final Pair h(String[] data, String[] strings) throws InvalidProtocolBufferException {
        k.f(data, "data");
        k.f(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.a(data));
        g gVarG = g(byteArrayInputStream, strings);
        B8.a aVar = ProtoBuf$Package.l;
        aVar.getClass();
        C0245f c0245f = new C0245f(byteArrayInputStream);
        AbstractC0241b abstractC0241b = (AbstractC0241b) aVar.a(c0245f, f596a);
        try {
            c0245f.a(0);
            if (abstractC0241b.isInitialized()) {
                return new Pair(gVarG, (ProtoBuf$Package) abstractC0241b);
            }
            InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(new UninitializedMessageException().getMessage());
            invalidProtocolBufferException.f5100a = abstractC0241b;
            throw invalidProtocolBufferException;
        } catch (InvalidProtocolBufferException e) {
            e.f5100a = abstractC0241b;
            throw e;
        }
    }
}
