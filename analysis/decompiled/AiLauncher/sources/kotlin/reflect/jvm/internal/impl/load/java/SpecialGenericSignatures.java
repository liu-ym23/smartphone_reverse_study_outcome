package kotlin.reflect.jvm.internal.impl.load.java;

import Y8.j;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import Z8.Y;
import Z8.Z;
import androidx.exifinterface.media.ExifInterface;
import ba.x;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import ga.e;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import v9.C5685n;

/* loaded from: classes5.dex */
public class SpecialGenericSignatures {

    /* renamed from: a, reason: collision with root package name */
    public static final a f35098a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final List<a.C0438a> f35099b;

    /* renamed from: c, reason: collision with root package name */
    public static final List<String> f35100c;

    /* renamed from: d, reason: collision with root package name */
    public static final List<String> f35101d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map<a.C0438a, TypeSafeBarrierDescription> f35102e;

    /* renamed from: f, reason: collision with root package name */
    public static final Map<String, TypeSafeBarrierDescription> f35103f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set<e> f35104g;

    /* renamed from: h, reason: collision with root package name */
    public static final Set<String> f35105h;

    /* renamed from: i, reason: collision with root package name */
    public static final a.C0438a f35106i;

    /* renamed from: j, reason: collision with root package name */
    public static final Map<a.C0438a, e> f35107j;

    /* renamed from: k, reason: collision with root package name */
    public static final Map<String, e> f35108k;

    /* renamed from: l, reason: collision with root package name */
    public static final Set<String> f35109l;

    /* renamed from: m, reason: collision with root package name */
    public static final Set<e> f35110m;

    /* renamed from: n, reason: collision with root package name */
    public static final Map<e, e> f35111n;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class SpecialSignatureInfo {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ SpecialSignatureInfo[] $VALUES;
        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;
        public static final SpecialSignatureInfo ONE_COLLECTION_PARAMETER = new SpecialSignatureInfo("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
        public static final SpecialSignatureInfo OBJECT_PARAMETER_NON_GENERIC = new SpecialSignatureInfo("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
        public static final SpecialSignatureInfo OBJECT_PARAMETER_GENERIC = new SpecialSignatureInfo("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);

        private static final /* synthetic */ SpecialSignatureInfo[] $values() {
            return new SpecialSignatureInfo[]{ONE_COLLECTION_PARAMETER, OBJECT_PARAMETER_NON_GENERIC, OBJECT_PARAMETER_GENERIC};
        }

        static {
            SpecialSignatureInfo[] specialSignatureInfoArr$values = $values();
            $VALUES = specialSignatureInfoArr$values;
            $ENTRIES = kotlin.enums.a.a(specialSignatureInfoArr$values);
        }

        private SpecialSignatureInfo(String str, int i10, String str2, boolean z10) {
            this.valueParametersSignature = str2;
            this.isObjectReplacedWithTypeParameter = z10;
        }

        public static SpecialSignatureInfo valueOf(String str) {
            return (SpecialSignatureInfo) Enum.valueOf(SpecialSignatureInfo.class, str);
        }

        public static SpecialSignatureInfo[] values() {
            return (SpecialSignatureInfo[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TypeSafeBarrierDescription {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES;
        private final Object defaultValue;
        public static final TypeSafeBarrierDescription NULL = new TypeSafeBarrierDescription("NULL", 0, null);
        public static final TypeSafeBarrierDescription INDEX = new TypeSafeBarrierDescription("INDEX", 1, -1);
        public static final TypeSafeBarrierDescription FALSE = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);

        public static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            /* JADX WARN: Illegal instructions before constructor call */
            public MAP_GET_OR_DEFAULT(String str, int i10) {
                i iVar = null;
                super(str, i10, iVar, iVar);
            }
        }

        private static final /* synthetic */ TypeSafeBarrierDescription[] $values() {
            return new TypeSafeBarrierDescription[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        static {
            TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArr$values = $values();
            $VALUES = typeSafeBarrierDescriptionArr$values;
            $ENTRIES = kotlin.enums.a.a(typeSafeBarrierDescriptionArr$values);
        }

        public /* synthetic */ TypeSafeBarrierDescription(String str, int i10, Object obj, i iVar) {
            this(str, i10, obj);
        }

        public static TypeSafeBarrierDescription valueOf(String str) {
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, str);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }

        private TypeSafeBarrierDescription(String str, int i10, Object obj) {
            this.defaultValue = obj;
        }
    }

    public static final class a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$a$a, reason: collision with other inner class name */
        public static final class C0438a {

            /* renamed from: a, reason: collision with root package name */
            public final String f35112a;

            /* renamed from: b, reason: collision with root package name */
            public final e f35113b;

            /* renamed from: c, reason: collision with root package name */
            public final String f35114c;

            /* renamed from: d, reason: collision with root package name */
            public final String f35115d;

            /* renamed from: e, reason: collision with root package name */
            public final String f35116e;

            public C0438a(String classInternalName, e name, String parameters, String returnType) {
                p.i(classInternalName, "classInternalName");
                p.i(name, "name");
                p.i(parameters, "parameters");
                p.i(returnType, "returnType");
                this.f35112a = classInternalName;
                this.f35113b = name;
                this.f35114c = parameters;
                this.f35115d = returnType;
                this.f35116e = x.f15368a.m(classInternalName, name + '(' + parameters + ')' + returnType);
            }

            public static /* synthetic */ C0438a b(C0438a c0438a, String str, e eVar, String str2, String str3, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = c0438a.f35112a;
                }
                if ((i10 & 2) != 0) {
                    eVar = c0438a.f35113b;
                }
                if ((i10 & 4) != 0) {
                    str2 = c0438a.f35114c;
                }
                if ((i10 & 8) != 0) {
                    str3 = c0438a.f35115d;
                }
                return c0438a.a(str, eVar, str2, str3);
            }

            public final C0438a a(String classInternalName, e name, String parameters, String returnType) {
                p.i(classInternalName, "classInternalName");
                p.i(name, "name");
                p.i(parameters, "parameters");
                p.i(returnType, "returnType");
                return new C0438a(classInternalName, name, parameters, returnType);
            }

            public final e c() {
                return this.f35113b;
            }

            public final String d() {
                return this.f35116e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0438a)) {
                    return false;
                }
                C0438a c0438a = (C0438a) obj;
                return p.d(this.f35112a, c0438a.f35112a) && p.d(this.f35113b, c0438a.f35113b) && p.d(this.f35114c, c0438a.f35114c) && p.d(this.f35115d, c0438a.f35115d);
            }

            public int hashCode() {
                return (((((this.f35112a.hashCode() * 31) + this.f35113b.hashCode()) * 31) + this.f35114c.hashCode()) * 31) + this.f35115d.hashCode();
            }

            public String toString() {
                return "NameAndSignature(classInternalName=" + this.f35112a + ", name=" + this.f35113b + ", parameters=" + this.f35114c + ", returnType=" + this.f35115d + ')';
            }
        }

        public /* synthetic */ a(i iVar) {
            this();
        }

        public final e b(e name) {
            p.i(name, "name");
            return f().get(name);
        }

        public final List<String> c() {
            return SpecialGenericSignatures.f35100c;
        }

        public final Set<e> d() {
            return SpecialGenericSignatures.f35104g;
        }

        public final Set<String> e() {
            return SpecialGenericSignatures.f35105h;
        }

        public final Map<e, e> f() {
            return SpecialGenericSignatures.f35111n;
        }

        public final Set<e> g() {
            return SpecialGenericSignatures.f35110m;
        }

        public final C0438a h() {
            return SpecialGenericSignatures.f35106i;
        }

        public final Map<String, TypeSafeBarrierDescription> i() {
            return SpecialGenericSignatures.f35103f;
        }

        public final Map<String, e> j() {
            return SpecialGenericSignatures.f35108k;
        }

        public final boolean k(e eVar) {
            p.i(eVar, "<this>");
            return g().contains(eVar);
        }

        public final SpecialSignatureInfo l(String builtinSignature) {
            p.i(builtinSignature, "builtinSignature");
            return c().contains(builtinSignature) ? SpecialSignatureInfo.ONE_COLLECTION_PARAMETER : ((TypeSafeBarrierDescription) kotlin.collections.a.j(i(), builtinSignature)) == TypeSafeBarrierDescription.NULL ? SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC : SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }

        public final C0438a m(String str, String str2, String str3, String str4) {
            e eVarJ = e.j(str2);
            p.h(eVarJ, "identifier(...)");
            return new C0438a(str, eVarJ, str3, str4);
        }

        public a() {
        }
    }

    static {
        Set<String> setJ = Y.j("containsAll", "removeAll", "retainAll");
        ArrayList arrayList = new ArrayList(C1174w.x(setJ, 10));
        for (String str : setJ) {
            a aVar = f35098a;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            p.h(desc, "getDesc(...)");
            arrayList.add(aVar.m("java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        f35099b = arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((a.C0438a) it.next()).d());
        }
        f35100c = arrayList3;
        List<a.C0438a> list = f35099b;
        ArrayList arrayList4 = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((a.C0438a) it2.next()).c().b());
        }
        f35101d = arrayList4;
        x xVar = x.f15368a;
        a aVar2 = f35098a;
        String strI = xVar.i(CoreUtil.STR_DEX_COLLECTION_NAME);
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String desc2 = jvmPrimitiveType.getDesc();
        p.h(desc2, "getDesc(...)");
        a.C0438a c0438aM = aVar2.m(strI, "contains", "Ljava/lang/Object;", desc2);
        TypeSafeBarrierDescription typeSafeBarrierDescription = TypeSafeBarrierDescription.FALSE;
        Pair pairA = j.a(c0438aM, typeSafeBarrierDescription);
        String strI2 = xVar.i(CoreUtil.STR_DEX_COLLECTION_NAME);
        String desc3 = jvmPrimitiveType.getDesc();
        p.h(desc3, "getDesc(...)");
        Pair pairA2 = j.a(aVar2.m(strI2, "remove", "Ljava/lang/Object;", desc3), typeSafeBarrierDescription);
        String strI3 = xVar.i("Map");
        String desc4 = jvmPrimitiveType.getDesc();
        p.h(desc4, "getDesc(...)");
        Pair pairA3 = j.a(aVar2.m(strI3, "containsKey", "Ljava/lang/Object;", desc4), typeSafeBarrierDescription);
        String strI4 = xVar.i("Map");
        String desc5 = jvmPrimitiveType.getDesc();
        p.h(desc5, "getDesc(...)");
        Pair pairA4 = j.a(aVar2.m(strI4, "containsValue", "Ljava/lang/Object;", desc5), typeSafeBarrierDescription);
        String strI5 = xVar.i("Map");
        String desc6 = jvmPrimitiveType.getDesc();
        p.h(desc6, "getDesc(...)");
        Pair pairA5 = j.a(aVar2.m(strI5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), typeSafeBarrierDescription);
        Pair pairA6 = j.a(aVar2.m(xVar.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT);
        a.C0438a c0438aM2 = aVar2.m(xVar.i("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription typeSafeBarrierDescription2 = TypeSafeBarrierDescription.NULL;
        Pair pairA7 = j.a(c0438aM2, typeSafeBarrierDescription2);
        Pair pairA8 = j.a(aVar2.m(xVar.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), typeSafeBarrierDescription2);
        String strI6 = xVar.i("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String desc7 = jvmPrimitiveType2.getDesc();
        p.h(desc7, "getDesc(...)");
        a.C0438a c0438aM3 = aVar2.m(strI6, "indexOf", "Ljava/lang/Object;", desc7);
        TypeSafeBarrierDescription typeSafeBarrierDescription3 = TypeSafeBarrierDescription.INDEX;
        Pair pairA9 = j.a(c0438aM3, typeSafeBarrierDescription3);
        String strI7 = xVar.i("List");
        String desc8 = jvmPrimitiveType2.getDesc();
        p.h(desc8, "getDesc(...)");
        Map<a.C0438a, TypeSafeBarrierDescription> mapM = kotlin.collections.a.m(pairA, pairA2, pairA3, pairA4, pairA5, pairA6, pairA7, pairA8, pairA9, j.a(aVar2.m(strI7, "lastIndexOf", "Ljava/lang/Object;", desc8), typeSafeBarrierDescription3));
        f35102e = mapM;
        LinkedHashMap linkedHashMap = new LinkedHashMap(Q.e(mapM.size()));
        Iterator<T> it3 = mapM.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap.put(((a.C0438a) entry.getKey()).d(), entry.getValue());
        }
        f35103f = linkedHashMap;
        Set setO = Z.o(f35102e.keySet(), f35099b);
        ArrayList arrayList5 = new ArrayList(C1174w.x(setO, 10));
        Iterator it4 = setO.iterator();
        while (it4.hasNext()) {
            arrayList5.add(((a.C0438a) it4.next()).c());
        }
        f35104g = F.r1(arrayList5);
        ArrayList arrayList6 = new ArrayList(C1174w.x(setO, 10));
        Iterator it5 = setO.iterator();
        while (it5.hasNext()) {
            arrayList6.add(((a.C0438a) it5.next()).d());
        }
        f35105h = F.r1(arrayList6);
        a aVar3 = f35098a;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String desc9 = jvmPrimitiveType3.getDesc();
        p.h(desc9, "getDesc(...)");
        a.C0438a c0438aM4 = aVar3.m("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        f35106i = c0438aM4;
        x xVar2 = x.f15368a;
        String strH = xVar2.h("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        p.h(desc10, "getDesc(...)");
        Pair pairA10 = j.a(aVar3.m(strH, "toByte", "", desc10), e.j("byteValue"));
        String strH2 = xVar2.h("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        p.h(desc11, "getDesc(...)");
        Pair pairA11 = j.a(aVar3.m(strH2, "toShort", "", desc11), e.j("shortValue"));
        String strH3 = xVar2.h("Number");
        String desc12 = jvmPrimitiveType3.getDesc();
        p.h(desc12, "getDesc(...)");
        Pair pairA12 = j.a(aVar3.m(strH3, "toInt", "", desc12), e.j("intValue"));
        String strH4 = xVar2.h("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        p.h(desc13, "getDesc(...)");
        Pair pairA13 = j.a(aVar3.m(strH4, "toLong", "", desc13), e.j("longValue"));
        String strH5 = xVar2.h("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        p.h(desc14, "getDesc(...)");
        Pair pairA14 = j.a(aVar3.m(strH5, "toFloat", "", desc14), e.j("floatValue"));
        String strH6 = xVar2.h("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        p.h(desc15, "getDesc(...)");
        Pair pairA15 = j.a(aVar3.m(strH6, "toDouble", "", desc15), e.j("doubleValue"));
        Pair pairA16 = j.a(c0438aM4, e.j("remove"));
        String strH7 = xVar2.h("CharSequence");
        String desc16 = jvmPrimitiveType3.getDesc();
        p.h(desc16, "getDesc(...)");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        p.h(desc17, "getDesc(...)");
        Map<a.C0438a, e> mapM2 = kotlin.collections.a.m(pairA10, pairA11, pairA12, pairA13, pairA14, pairA15, pairA16, j.a(aVar3.m(strH7, "get", desc16, desc17), e.j("charAt")), j.a(aVar3.m(xVar2.j("AtomicInteger"), "load", "", "I"), e.j("get")), j.a(aVar3.m(xVar2.j("AtomicInteger"), "store", "I", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), e.j("set")), j.a(aVar3.m(xVar2.j("AtomicInteger"), "exchange", "I", "I"), e.j("getAndSet")), j.a(aVar3.m(xVar2.j("AtomicInteger"), "fetchAndAdd", "I", "I"), e.j("getAndAdd")), j.a(aVar3.m(xVar2.j("AtomicInteger"), "addAndFetch", "I", "I"), e.j("addAndGet")), j.a(aVar3.m(xVar2.j("AtomicLong"), "load", "", "J"), e.j("get")), j.a(aVar3.m(xVar2.j("AtomicLong"), "store", "J", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), e.j("set")), j.a(aVar3.m(xVar2.j("AtomicLong"), "exchange", "J", "J"), e.j("getAndSet")), j.a(aVar3.m(xVar2.j("AtomicLong"), "fetchAndAdd", "J", "J"), e.j("getAndAdd")), j.a(aVar3.m(xVar2.j("AtomicLong"), "addAndFetch", "J", "J"), e.j("addAndGet")), j.a(aVar3.m(xVar2.j("AtomicBoolean"), "load", "", "Z"), e.j("get")), j.a(aVar3.m(xVar2.j("AtomicBoolean"), "store", "Z", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), e.j("set")), j.a(aVar3.m(xVar2.j("AtomicBoolean"), "exchange", "Z", "Z"), e.j("getAndSet")), j.a(aVar3.m(xVar2.j("AtomicReference"), "load", "", "Ljava/lang/Object;"), e.j("get")), j.a(aVar3.m(xVar2.j("AtomicReference"), "store", "Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), e.j("set")), j.a(aVar3.m(xVar2.j("AtomicReference"), "exchange", "Ljava/lang/Object;", "Ljava/lang/Object;"), e.j("getAndSet")), j.a(aVar3.m(xVar2.j("AtomicIntegerArray"), "loadAt", "I", "I"), e.j("get")), j.a(aVar3.m(xVar2.j("AtomicIntegerArray"), "storeAt", "II", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), e.j("set")), j.a(aVar3.m(xVar2.j("AtomicIntegerArray"), "exchangeAt", "II", "I"), e.j("getAndSet")), j.a(aVar3.m(xVar2.j("AtomicIntegerArray"), "compareAndSetAt", "III", "Z"), e.j("compareAndSet")), j.a(aVar3.m(xVar2.j("AtomicIntegerArray"), "fetchAndAddAt", "II", "I"), e.j("getAndAdd")), j.a(aVar3.m(xVar2.j("AtomicIntegerArray"), "addAndFetchAt", "II", "I"), e.j("addAndGet")), j.a(aVar3.m(xVar2.j("AtomicLongArray"), "loadAt", "I", "J"), e.j("get")), j.a(aVar3.m(xVar2.j("AtomicLongArray"), "storeAt", "IJ", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), e.j("set")), j.a(aVar3.m(xVar2.j("AtomicLongArray"), "exchangeAt", "IJ", "J"), e.j("getAndSet")), j.a(aVar3.m(xVar2.j("AtomicLongArray"), "compareAndSetAt", "IJJ", "Z"), e.j("compareAndSet")), j.a(aVar3.m(xVar2.j("AtomicLongArray"), "fetchAndAddAt", "IJ", "J"), e.j("getAndAdd")), j.a(aVar3.m(xVar2.j("AtomicLongArray"), "addAndFetchAt", "IJ", "J"), e.j("addAndGet")), j.a(aVar3.m(xVar2.j("AtomicReferenceArray"), "loadAt", "I", "Ljava/lang/Object;"), e.j("get")), j.a(aVar3.m(xVar2.j("AtomicReferenceArray"), "storeAt", "ILjava/lang/Object;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), e.j("set")), j.a(aVar3.m(xVar2.j("AtomicReferenceArray"), "exchangeAt", "ILjava/lang/Object;", "Ljava/lang/Object;"), e.j("getAndSet")), j.a(aVar3.m(xVar2.j("AtomicReferenceArray"), "compareAndSetAt", "ILjava/lang/Object;Ljava/lang/Object;", "Z"), e.j("compareAndSet")));
        f35107j = mapM2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(Q.e(mapM2.size()));
        Iterator<T> it6 = mapM2.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it6.next();
            linkedHashMap2.put(((a.C0438a) entry2.getKey()).d(), entry2.getValue());
        }
        f35108k = linkedHashMap2;
        Map<a.C0438a, e> map = f35107j;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<a.C0438a, e> entry3 : map.entrySet()) {
            linkedHashSet.add(a.C0438a.b(entry3.getKey(), null, entry3.getValue(), null, null, 13, null).d());
        }
        f35109l = linkedHashSet;
        Set<a.C0438a> setKeySet = f35107j.keySet();
        HashSet hashSet = new HashSet();
        Iterator<T> it7 = setKeySet.iterator();
        while (it7.hasNext()) {
            hashSet.add(((a.C0438a) it7.next()).c());
        }
        f35110m = hashSet;
        Set<Map.Entry<a.C0438a, e>> setEntrySet = f35107j.entrySet();
        ArrayList<Pair> arrayList7 = new ArrayList(C1174w.x(setEntrySet, 10));
        Iterator<T> it8 = setEntrySet.iterator();
        while (it8.hasNext()) {
            Map.Entry entry4 = (Map.Entry) it8.next();
            arrayList7.add(new Pair(((a.C0438a) entry4.getKey()).c(), entry4.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(arrayList7, 10)), 16));
        for (Pair pair : arrayList7) {
            linkedHashMap3.put((e) pair.f(), (e) pair.e());
        }
        f35111n = linkedHashMap3;
    }
}
