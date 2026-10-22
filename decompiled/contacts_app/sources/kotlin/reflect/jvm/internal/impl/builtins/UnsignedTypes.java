package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UnsignedTypes {
    public static final UnsignedTypes INSTANCE = null;
    private static final HashMap<ClassId, ClassId> arrayClassIdToUnsignedClassId = null;
    private static final Set<Name> arrayClassesShortNames = null;
    private static final Set<Name> unsignedArrayTypeNames = null;
    private static final HashMap<UnsignedArrayType, Name> unsignedArrayTypeToArrayCall = null;
    private static final HashMap<ClassId, ClassId> unsignedClassIdToArrayClassId = null;
    private static final Set<Name> unsignedTypeNames = null;

    private UnsignedTypes() {
    }

    static {
        INSTANCE = new UnsignedTypes();
        UnsignedType[] r0 = UnsignedType.values();
        ArrayList r1 = new ArrayList(r0.length);
        int r2 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r1.add(r0[r4].getTypeName());
        r4 = r4 + 1;
        goto L3
    L5:
        unsignedTypeNames = CollectionsKt.toSet(r1);
        UnsignedArrayType[] r5 = UnsignedArrayType.values();
        ArrayList r6 = new ArrayList(r5.length);
        int r7 = r5.length;
        int r8 = 0;
    L6:
        if (r8 >= r7) goto L8;
        r6.add(r5[r8].getTypeName());
        r8 = r8 + 1;
        goto L6
    L8:
        unsignedArrayTypeNames = CollectionsKt.toSet(r6);
        arrayClassIdToUnsignedClassId = new HashMap();
        unsignedClassIdToArrayClassId = new HashMap();
        unsignedArrayTypeToArrayCall = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(UnsignedArrayType.UBYTEARRAY, Name.identifier("ubyteArrayOf")), TuplesKt.to(UnsignedArrayType.USHORTARRAY, Name.identifier("ushortArrayOf")), TuplesKt.to(UnsignedArrayType.UINTARRAY, Name.identifier("uintArrayOf")), TuplesKt.to(UnsignedArrayType.ULONGARRAY, Name.identifier("ulongArrayOf"))});
        UnsignedType[] r9 = UnsignedType.values();
        LinkedHashSet r10 = new LinkedHashSet();
        int r11 = r9.length;
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L11;
        r10.add(r9[r12].getArrayClassId().getShortClassName());
        r12 = r12 + 1;
        goto L9
    L11:
        arrayClassesShortNames = r10;
        UnsignedType[] r13 = UnsignedType.values();
        int r14 = r13.length;
    L12:
        if (r3 >= r14) goto L14;
        UnsignedType r15 = r13[r3];
        arrayClassIdToUnsignedClassId.put(r15.getArrayClassId(), r15.getClassId());
        unsignedClassIdToArrayClassId.put(r15.getClassId(), r15.getArrayClassId());
        r3 = r3 + 1;
        goto L12
    }

    public final boolean isShortNameOfUnsignedArray(Name r1) {
        Intrinsics.checkNotNullParameter(r1, "name");
        return arrayClassesShortNames.contains(r1);
    }

    public final ClassId getUnsignedClassIdByArrayClassId(ClassId r1) {
        Intrinsics.checkNotNullParameter(r1, "arrayClassId");
        return arrayClassIdToUnsignedClassId.get(r1);
    }

    @JvmStatic
    public static final boolean isUnsignedType(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (TypeUtils.noExpectedType(r2) == false) goto L5;
        return false;
    L5:
        ClassifierDescriptor r3 = r2.getConstructor().mo2083getDeclarationDescriptor();
        if (r3 != null) goto L9;
        return false;
    L9:
        return INSTANCE.isUnsignedClass(r3);
    }

    public final boolean isUnsignedClass(DeclarationDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        DeclarationDescriptor r1 = r2.getContainingDeclaration();
        if ((r1 instanceof PackageFragmentDescriptor) == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r1).getFqName(), StandardNames.BUILT_INS_PACKAGE_FQ_NAME) == false) goto L9;
        if (unsignedTypeNames.contains(r2.getName()) == false) goto L9;
        return true;
    }
}
