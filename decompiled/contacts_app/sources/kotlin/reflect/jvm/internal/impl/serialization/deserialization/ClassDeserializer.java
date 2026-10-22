package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* JADX INFO: compiled from: ClassDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ClassDeserializer {
    private static final Set<ClassId> BLACK_LIST = null;
    public static final Companion Companion = null;
    private final Function1<ClassKey, ClassDescriptor> classes;
    private final DeserializationComponents components;

    /* JADX INFO: compiled from: ClassDeserializer.kt */
    private static final class ClassKey {
        private final ClassData classData;
        private final ClassId classId;

        public ClassKey(ClassId r2, ClassData r3) {
            Intrinsics.checkNotNullParameter(r2, "classId");
            this.classId = r2;
            this.classData = r3;
        }

        public final ClassData getClassData() {
            return this.classData;
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof ClassKey) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.classId, ((ClassKey) r2).classId) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.classId.hashCode();
        }
    }

    /* JADX INFO: compiled from: ClassDeserializer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.access$getBLACK_LIST$cp();
        }
    }

    public ClassDeserializer(DeserializationComponents r2) {
        Intrinsics.checkNotNullParameter(r2, "components");
        this.components = r2;
        this.classes = r2.getStorageManager().createMemoizedFunctionWithNullableValues(new ClassDeserializer$classes$1(this));
    }

    public static final /* synthetic */ ClassDescriptor access$createClass(ClassDeserializer r0, ClassKey r1) {
        return r0.createClass(r1);
    }

    public static final /* synthetic */ Set access$getBLACK_LIST$cp() {
        return BLACK_LIST;
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer r0, ClassId r1, ClassData r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.deserializeClass(r1, r2);
    }

    public final ClassDescriptor deserializeClass(ClassId r2, ClassData r3) {
        Intrinsics.checkNotNullParameter(r2, "classId");
        return this.classes.invoke(new ClassKey(r2, r3));
    }

    private final ClassDescriptor createClass(ClassKey r13) {
        ClassId r0 = r13.getClassId();
        Iterator<ClassDescriptorFactory> r1 = this.components.getFictitiousClassDescriptorFactories().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        ClassDescriptor r2 = r1.next().createClass(r0);
        if (r2 == null) goto L4;
        return r2;
    L9:
        if (BLACK_LIST.contains(r0) == false) goto L11;
        return null;
    L11:
        ClassData r14 = r13.getClassData();
        if (r14 != null) goto L16;
        r14 = this.components.getClassDataFinder().findClassData(r0);
        if (r14 != null) goto L16;
        return null;
    L16:
        NameResolver r3 = r14.component1();
        ProtoBuf.Class r10 = r14.component2();
        BinaryVersion r11 = r14.component3();
        SourceElement r15 = r14.component4();
        ClassId r4 = r0.getOuterClassId();
        if (r4 == null) goto L28;
        ClassDescriptor r12 = deserializeClass$default(this, r4, null, 2, null);
        if ((r12 instanceof DeserializedClassDescriptor) == false) goto L21;
        DeserializedClassDescriptor r16 = (DeserializedClassDescriptor) r12;
    L22:
        if (r16 != null) goto L24;
        return null;
    L24:
        Name r5 = r0.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(r5, "classId.shortClassName");
        if (r16.hasNestedClass$deserialization(r5) == true) goto L27;
        return null;
    L27:
        DeserializationContext r17 = r16.getC();
    L46:
        return new DeserializedClassDescriptor(r17, r10, r3, r11, r15);
    L21:
        r16 = null;
        goto L22
    L28:
        PackageFragmentProvider r6 = this.components.getPackageFragmentProvider();
        FqName r7 = r0.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r7, "classId.packageFqName");
        Iterator<T> r8 = PackageFragmentProviderKt.packageFragments(r6, r7).iterator();
    L30:
        if (r8.hasNext() == false) goto L40;
        Object r9 = r8.next();
        PackageFragmentDescriptor r18 = (PackageFragmentDescriptor) r9;
        if ((r18 instanceof DeserializedPackageFragment) == false) goto L37;
        Name r19 = r0.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(r19, "classId.shortClassName");
        if (((DeserializedPackageFragment) r18).hasTopLevelClass(r19) == true) goto L37;
        boolean r20 = false;
    L38:
        if (r20 == false) goto L30;
    L41:
        PackageFragmentDescriptor r21 = (PackageFragmentDescriptor) r9;
        if (r21 != null) goto L44;
        return null;
    L44:
        DeserializationComponents r22 = this.components;
        ProtoBuf.TypeTable r110 = r10.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(r110, "classProto.typeTable");
        TypeTable r23 = new TypeTable(r110);
        VersionRequirementTable.Companion r111 = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable r24 = r10.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(r24, "classProto.versionRequirementTable");
        r17 = r22.createContext(r21, r3, r23, r111.create(r24), r11, null);
    L37:
        r20 = true;
        goto L38
    L40:
        r9 = null;
        goto L41
    }

    static {
        Companion = new Companion(null);
        BLACK_LIST = SetsKt.setOf(ClassId.topLevel(StandardNames.FqNames.cloneable.toSafe()));
    }
}
