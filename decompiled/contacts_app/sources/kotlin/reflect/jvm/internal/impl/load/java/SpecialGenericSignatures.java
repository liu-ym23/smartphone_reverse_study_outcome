package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: compiled from: SpecialGenericSignatures.kt */
/* JADX INFO: loaded from: classes4.dex */
public class SpecialGenericSignatures {
    public static final Companion Companion = null;
    private static final List<String> ERASED_COLLECTION_PARAMETER_NAMES = null;
    private static final List<Companion.NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = null;
    private static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES = null;
    private static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES = null;
    private static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES = null;
    private static final Map<Companion.NameAndSignature, TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = null;
    private static final Map<Name, Name> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = null;
    private static final Map<Companion.NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = null;
    private static final List<Name> ORIGINAL_SHORT_NAMES = null;
    private static final Companion.NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE = null;
    private static final Map<String, TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP = null;
    private static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME = null;

    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
        public static final class NameAndSignature {
            private final Name name;
            private final String signature;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof NameAndSignature) == true) goto L8;
                return false;
            L8:
                NameAndSignature r6 = (NameAndSignature) r5;
                if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.signature, r6.signature) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.name.hashCode() * 31) + this.signature.hashCode();
            }

            public String toString() {
                return "NameAndSignature(name=" + this.name + ", signature=" + this.signature + ')';
            }

            public NameAndSignature(Name r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "name");
                Intrinsics.checkNotNullParameter(r3, "signature");
                this.name = r2;
                this.signature = r3;
            }

            public final Name getName() {
                return this.name;
            }

            public final String getSignature() {
                return this.signature;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ NameAndSignature access$method(Companion r0, String r1, String r2, String r3, String r4) {
            return r0.method(r1, r2, r3, r4);
        }

        public final SpecialSignatureInfo getSpecialSignatureInfo(String r2) {
            Intrinsics.checkNotNullParameter(r2, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(r2) == false) goto L7;
            return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
        L7:
            if (((TypeSafeBarrierDescription) MapsKt.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), r2)) != TypeSafeBarrierDescription.NULL) goto L10;
            return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
        L10:
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }

        private final NameAndSignature method(String r4, String r5, String r6, String r7) {
            Name r0 = Name.identifier(r5);
            Intrinsics.checkNotNullExpressionValue(r0, "identifier(name)");
            return new NameAndSignature(r0, SignatureBuildingComponents.INSTANCE.signature(r4, r5 + '(' + r6 + ')' + r7));
        }

        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return SpecialGenericSignatures.access$getERASED_COLLECTION_PARAMETER_SIGNATURES$cp();
        }

        public final Map<String, TypeSafeBarrierDescription> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SpecialGenericSignatures.access$getSIGNATURE_TO_DEFAULT_VALUES_MAP$cp();
        }

        public final Set<Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return SpecialGenericSignatures.access$getERASED_VALUE_PARAMETERS_SHORT_NAMES$cp();
        }

        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return SpecialGenericSignatures.access$getERASED_VALUE_PARAMETERS_SIGNATURES$cp();
        }

        public final NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return SpecialGenericSignatures.access$getREMOVE_AT_NAME_AND_SIGNATURE$cp();
        }

        public final Map<String, Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SpecialGenericSignatures.access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$cp();
        }

        public final List<Name> getORIGINAL_SHORT_NAMES() {
            return SpecialGenericSignatures.access$getORIGINAL_SHORT_NAMES$cp();
        }

        public final Map<Name, Name> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return SpecialGenericSignatures.access$getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP$cp();
        }

        public final Name getBuiltinFunctionNamesByJvmName(Name r2) {
            Intrinsics.checkNotNullParameter(r2, "name");
            return getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(r2);
        }

        public final boolean getSameAsRenamedInJvmBuiltin(Name r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            return getORIGINAL_SHORT_NAMES().contains(r2);
        }
    }

    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public static final enum SpecialSignatureInfo extends Enum<SpecialSignatureInfo> {
        private static final /* synthetic */ SpecialSignatureInfo[] $VALUES = null;
        public static final SpecialSignatureInfo OBJECT_PARAMETER_GENERIC = null;
        public static final SpecialSignatureInfo OBJECT_PARAMETER_NON_GENERIC = null;
        public static final SpecialSignatureInfo ONE_COLLECTION_PARAMETER = null;
        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        private static final /* synthetic */ SpecialSignatureInfo[] $values() {
            return new SpecialSignatureInfo[]{ONE_COLLECTION_PARAMETER, OBJECT_PARAMETER_NON_GENERIC, OBJECT_PARAMETER_GENERIC};
        }

        public static SpecialSignatureInfo valueOf(String r1) {
            return (SpecialSignatureInfo) Enum.valueOf(SpecialSignatureInfo.class, r1);
        }

        public static SpecialSignatureInfo[] values() {
            return (SpecialSignatureInfo[]) $VALUES.clone();
        }

        private SpecialSignatureInfo(String r1, int r2, String r3, boolean r4) {
            super(r1, r2);
            this.valueParametersSignature = r3;
            this.isObjectReplacedWithTypeParameter = r4;
        }

        static {
            ONE_COLLECTION_PARAMETER = new SpecialSignatureInfo("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
            OBJECT_PARAMETER_NON_GENERIC = new SpecialSignatureInfo("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
            OBJECT_PARAMETER_GENERIC = new SpecialSignatureInfo("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public static final enum TypeSafeBarrierDescription extends Enum<TypeSafeBarrierDescription> {
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES = null;
        public static final TypeSafeBarrierDescription FALSE = null;
        public static final TypeSafeBarrierDescription INDEX = null;
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = null;
        public static final TypeSafeBarrierDescription NULL = null;
        private final Object defaultValue;

        /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
        static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            MAP_GET_OR_DEFAULT(String r2, int r3) {
                DefaultConstructorMarker r0 = null;
                super(r2, r3, r0, r0);
            }
        }

        private static final /* synthetic */ TypeSafeBarrierDescription[] $values() {
            return new TypeSafeBarrierDescription[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        public /* synthetic */ TypeSafeBarrierDescription(String r1, int r2, Object r3, DefaultConstructorMarker r4) {
            this(r1, r2, r3);
        }

        public static TypeSafeBarrierDescription valueOf(String r1) {
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, r1);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }

        private TypeSafeBarrierDescription(String r1, int r2, Object r3) {
            super(r1, r2);
            this.defaultValue = r3;
        }

        static {
            NULL = new TypeSafeBarrierDescription("NULL", 0, null);
            INDEX = new TypeSafeBarrierDescription("INDEX", 1, -1);
            FALSE = new TypeSafeBarrierDescription("FALSE", 2, false);
            MAP_GET_OR_DEFAULT = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
            $VALUES = $values();
        }
    }

    public SpecialGenericSignatures() {
    }

    public static final /* synthetic */ List access$getERASED_COLLECTION_PARAMETER_SIGNATURES$cp() {
        return ERASED_COLLECTION_PARAMETER_SIGNATURES;
    }

    public static final /* synthetic */ Set access$getERASED_VALUE_PARAMETERS_SHORT_NAMES$cp() {
        return ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    }

    public static final /* synthetic */ Set access$getERASED_VALUE_PARAMETERS_SIGNATURES$cp() {
        return ERASED_VALUE_PARAMETERS_SIGNATURES;
    }

    public static final /* synthetic */ Map access$getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP$cp() {
        return JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
    }

    public static final /* synthetic */ List access$getORIGINAL_SHORT_NAMES$cp() {
        return ORIGINAL_SHORT_NAMES;
    }

    public static final /* synthetic */ Companion.NameAndSignature access$getREMOVE_AT_NAME_AND_SIGNATURE$cp() {
        return REMOVE_AT_NAME_AND_SIGNATURE;
    }

    public static final /* synthetic */ Map access$getSIGNATURE_TO_DEFAULT_VALUES_MAP$cp() {
        return SIGNATURE_TO_DEFAULT_VALUES_MAP;
    }

    public static final /* synthetic */ Map access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$cp() {
        return SIGNATURE_TO_JVM_REPRESENTATION_NAME;
    }

    static {
        Companion = new Companion(null);
        Set r0 = SetsKt.setOf(new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = (String) r2.next();
        Companion r5 = Companion;
        String r6 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(r6, "BOOLEAN.desc");
        r1.add(Companion.access$method(r5, "java/util/Collection", r3, "Ljava/util/Collection;", r6));
        goto L4
    L6:
        ArrayList r4 = r1;
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = r4;
        ArrayList r7 = r4;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        r8.add(((Companion.NameAndSignature) r9.next()).getSignature());
        goto L8
    L10:
        ERASED_COLLECTION_PARAMETER_SIGNATURES = r8;
        List<Companion.NameAndSignature> r10 = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        r11.add(((Companion.NameAndSignature) r12.next()).getName().asString());
        goto L12
    L14:
        ERASED_COLLECTION_PARAMETER_NAMES = r11;
        SignatureBuildingComponents r13 = SignatureBuildingComponents.INSTANCE;
        Companion r14 = Companion;
        String r15 = r13.javaUtil("Collection");
        String r16 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(r16, "BOOLEAN.desc");
        String r17 = r13.javaUtil("Collection");
        String r18 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(r18, "BOOLEAN.desc");
        String r19 = r13.javaUtil("Map");
        String r110 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(r110, "BOOLEAN.desc");
        String r111 = r13.javaUtil("Map");
        String r112 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(r112, "BOOLEAN.desc");
        String r113 = r13.javaUtil("Map");
        String r114 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(r114, "BOOLEAN.desc");
        String r20 = r13.javaUtil("List");
        String r115 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(r115, "INT.desc");
        String r21 = r13.javaUtil("List");
        String r22 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(r22, "INT.desc");
        Map<Companion.NameAndSignature, TypeSafeBarrierDescription> r23 = MapsKt.mapOf(new Pair[]{TuplesKt.to(Companion.access$method(r14, r15, "contains", "Ljava/lang/Object;", r16), TypeSafeBarrierDescription.FALSE), TuplesKt.to(Companion.access$method(r14, r17, "remove", "Ljava/lang/Object;", r18), TypeSafeBarrierDescription.FALSE), TuplesKt.to(Companion.access$method(r14, r19, "containsKey", "Ljava/lang/Object;", r110), TypeSafeBarrierDescription.FALSE), TuplesKt.to(Companion.access$method(r14, r111, "containsValue", "Ljava/lang/Object;", r112), TypeSafeBarrierDescription.FALSE), TuplesKt.to(Companion.access$method(r14, r113, "remove", "Ljava/lang/Object;Ljava/lang/Object;", r114), TypeSafeBarrierDescription.FALSE), TuplesKt.to(Companion.access$method(r14, r13.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), TuplesKt.to(Companion.access$method(r14, r13.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL), TuplesKt.to(Companion.access$method(r14, r13.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL), TuplesKt.to(Companion.access$method(r14, r20, "indexOf", "Ljava/lang/Object;", r115), TypeSafeBarrierDescription.INDEX), TuplesKt.to(Companion.access$method(r14, r21, "lastIndexOf", "Ljava/lang/Object;", r22), TypeSafeBarrierDescription.INDEX)});
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = r23;
        LinkedHashMap r24 = new LinkedHashMap(MapsKt.mapCapacity(r23.size()));
        Iterator<T> r25 = r23.entrySet().iterator();
    L16:
        if (r25.hasNext() == false) goto L18;
        Map.Entry r26 = (Map.Entry) r25.next();
        r24.put(((Companion.NameAndSignature) r26.getKey()).getSignature(), r26.getValue());
        goto L16
    L18:
        SIGNATURE_TO_DEFAULT_VALUES_MAP = r24;
        Set r27 = SetsKt.plus(GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r29 = r27.iterator();
    L20:
        if (r29.hasNext() == false) goto L22;
        r28.add(((Companion.NameAndSignature) r29.next()).getName());
        goto L20
    L22:
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = CollectionsKt.toSet(r28);
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r31 = r27.iterator();
    L24:
        if (r31.hasNext() == false) goto L26;
        r30.add(((Companion.NameAndSignature) r31.next()).getSignature());
        goto L24
    L26:
        ERASED_VALUE_PARAMETERS_SIGNATURES = CollectionsKt.toSet(r30);
        Companion r32 = Companion;
        String r33 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(r33, "INT.desc");
        Companion.NameAndSignature r34 = Companion.access$method(r32, "java/util/List", "removeAt", r33, "Ljava/lang/Object;");
        REMOVE_AT_NAME_AND_SIGNATURE = r34;
        SignatureBuildingComponents r35 = SignatureBuildingComponents.INSTANCE;
        String r36 = r35.javaLang("Number");
        String r116 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics.checkNotNullExpressionValue(r116, "BYTE.desc");
        String r37 = r35.javaLang("Number");
        String r38 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics.checkNotNullExpressionValue(r38, "SHORT.desc");
        String r39 = r35.javaLang("Number");
        String r40 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(r40, "INT.desc");
        String r41 = r35.javaLang("Number");
        String r42 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics.checkNotNullExpressionValue(r42, "LONG.desc");
        String r43 = r35.javaLang("Number");
        String r44 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics.checkNotNullExpressionValue(r44, "FLOAT.desc");
        String r45 = r35.javaLang("Number");
        String r46 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics.checkNotNullExpressionValue(r46, "DOUBLE.desc");
        String r47 = r35.javaLang("CharSequence");
        String r48 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(r48, "INT.desc");
        String r49 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics.checkNotNullExpressionValue(r49, "CHAR.desc");
        Map<Companion.NameAndSignature, Name> r50 = MapsKt.mapOf(new Pair[]{TuplesKt.to(Companion.access$method(r32, r36, "toByte", "", r116), Name.identifier("byteValue")), TuplesKt.to(Companion.access$method(r32, r37, "toShort", "", r38), Name.identifier("shortValue")), TuplesKt.to(Companion.access$method(r32, r39, "toInt", "", r40), Name.identifier("intValue")), TuplesKt.to(Companion.access$method(r32, r41, "toLong", "", r42), Name.identifier("longValue")), TuplesKt.to(Companion.access$method(r32, r43, "toFloat", "", r44), Name.identifier("floatValue")), TuplesKt.to(Companion.access$method(r32, r45, "toDouble", "", r46), Name.identifier("doubleValue")), TuplesKt.to(r34, Name.identifier("remove")), TuplesKt.to(Companion.access$method(r32, r47, "get", r48, r49), Name.identifier("charAt"))});
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = r50;
        LinkedHashMap r51 = new LinkedHashMap(MapsKt.mapCapacity(r50.size()));
        Iterator<T> r52 = r50.entrySet().iterator();
    L28:
        if (r52.hasNext() == false) goto L30;
        Map.Entry r53 = (Map.Entry) r52.next();
        r51.put(((Companion.NameAndSignature) r53.getKey()).getSignature(), r53.getValue());
        goto L28
    L30:
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = r51;
        Set<Companion.NameAndSignature> r54 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        ArrayList r55 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r54, 10));
        Iterator<T> r56 = r54.iterator();
    L32:
        if (r56.hasNext() == false) goto L34;
        r55.add(((Companion.NameAndSignature) r56.next()).getName());
        goto L32
    L34:
        ORIGINAL_SHORT_NAMES = r55;
        Set<Map.Entry<Companion.NameAndSignature, Name>> r57 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        ArrayList r58 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r57, 10));
        Iterator<T> r59 = r57.iterator();
    L36:
        if (r59.hasNext() == false) goto L38;
        Map.Entry r60 = (Map.Entry) r59.next();
        r58.add(new Pair(((Companion.NameAndSignature) r60.getKey()).getName(), r60.getValue()));
        goto L36
    L38:
        ArrayList r61 = r58;
        LinkedHashMap r62 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r61, 10)), 16));
        Iterator r63 = r61.iterator();
    L40:
        if (r63.hasNext() == false) goto L42;
        Pair r64 = (Pair) r63.next();
        r62.put((Name) r64.getSecond(), (Name) r64.getFirst());
        goto L40
    L42:
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = r62;
    }
}
