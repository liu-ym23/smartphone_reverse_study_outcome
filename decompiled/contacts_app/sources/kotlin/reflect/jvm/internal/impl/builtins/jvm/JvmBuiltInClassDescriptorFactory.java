package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private static final ClassId CLONEABLE_CLASS_ID = null;
    private static final Name CLONEABLE_NAME = null;
    public static final Companion Companion = null;
    private static final FqName KOTLIN_FQ_NAME = null;
    private final NotNullLazyValue cloneable$delegate;
    private final Function1<ModuleDescriptor, DeclarationDescriptor> computeContainingDeclaration;
    private final ModuleDescriptor moduleDescriptor;

    /* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final ClassId getCLONEABLE_CLASS_ID() {
            return JvmBuiltInClassDescriptorFactory.access$getCLONEABLE_CLASS_ID$cp();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(final StorageManager r2, ModuleDescriptor r3, Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> r4) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r4, "computeContainingDeclaration");
        this.moduleDescriptor = r3;
        this.computeContainingDeclaration = r4;
        this.cloneable$delegate = r2.createLazyValue(new JvmBuiltInClassDescriptorFactory$cloneable$2(this, r2));
    }

    public static final /* synthetic */ ClassId access$getCLONEABLE_CLASS_ID$cp() {
        return CLONEABLE_CLASS_ID;
    }

    public static final /* synthetic */ Name access$getCLONEABLE_NAME$cp() {
        return CLONEABLE_NAME;
    }

    public static final /* synthetic */ Function1 access$getComputeContainingDeclaration$p(JvmBuiltInClassDescriptorFactory r0) {
        return r0.computeContainingDeclaration;
    }

    public static final /* synthetic */ FqName access$getKOTLIN_FQ_NAME$cp() {
        return KOTLIN_FQ_NAME;
    }

    public static final /* synthetic */ ModuleDescriptor access$getModuleDescriptor$p(JvmBuiltInClassDescriptorFactory r0) {
        return r0.moduleDescriptor;
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager r1, ModuleDescriptor r2, AnonymousClass1 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = AnonymousClass1.INSTANCE;
    L5:
        this(r1, r2, r3);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
        Companion = new Companion(null);
        KOTLIN_FQ_NAME = StandardNames.BUILT_INS_PACKAGE_FQ_NAME;
        Name r0 = StandardNames.FqNames.cloneable.shortName();
        Intrinsics.checkNotNullExpressionValue(r0, "cloneable.shortName()");
        CLONEABLE_NAME = r0;
        ClassId r1 = ClassId.topLevel(StandardNames.FqNames.cloneable.toSafe());
        Intrinsics.checkNotNullExpressionValue(r1, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        CLONEABLE_CLASS_ID = r1;
    }

    private final ClassDescriptorImpl getCloneable() {
        return (ClassDescriptorImpl) StorageKt.getValue(this.cloneable$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName r1, Name r2) {
        Intrinsics.checkNotNullParameter(r1, "packageFqName");
        Intrinsics.checkNotNullParameter(r2, "name");
        if (Intrinsics.areEqual(r2, CLONEABLE_NAME) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r1, KOTLIN_FQ_NAME) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId r2) {
        Intrinsics.checkNotNullParameter(r2, "classId");
        if (Intrinsics.areEqual(r2, CLONEABLE_CLASS_ID) == true) goto L7;
        return null;
    L7:
        return getCloneable();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "packageFqName");
        if (Intrinsics.areEqual(r2, KOTLIN_FQ_NAME) == false) goto L6;
        return SetsKt.setOf(getCloneable());
    L6:
        return SetsKt.emptySet();
    }
}
