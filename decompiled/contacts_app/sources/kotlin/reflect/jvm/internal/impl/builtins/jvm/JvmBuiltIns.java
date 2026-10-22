package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: compiled from: JvmBuiltIns.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmBuiltIns extends KotlinBuiltIns {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue customizer$delegate;
    private final Kind kind;
    private Function0<Settings> settingsComputation;

    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind FALLBACK = null;
        public static final Kind FROM_CLASS_LOADER = null;
        public static final Kind FROM_DEPENDENCIES = null;

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{FROM_DEPENDENCIES, FROM_CLASS_LOADER, FALLBACK};
        }

        public static Kind valueOf(String r1) {
            return (Kind) Enum.valueOf(Kind.class, r1);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        private Kind(String r1, int r2) {
            super(r1, r2);
        }

        static {
            FROM_DEPENDENCIES = new Kind("FROM_DEPENDENCIES", 0);
            FROM_CLASS_LOADER = new Kind("FROM_CLASS_LOADER", 1);
            FALLBACK = new Kind("FALLBACK", 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public static final class Settings {
        private final boolean isAdditionalBuiltInsFeatureSupported;
        private final ModuleDescriptor ownerModuleDescriptor;

        public Settings(ModuleDescriptor r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "ownerModuleDescriptor");
            this.ownerModuleDescriptor = r2;
            this.isAdditionalBuiltInsFeatureSupported = r3;
        }

        public final ModuleDescriptor getOwnerModuleDescriptor() {
            return this.ownerModuleDescriptor;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.isAdditionalBuiltInsFeatureSupported;
        }
    }

    /* JADX INFO: compiled from: JvmBuiltIns.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Kind.values().length];
            r0[Kind.FROM_DEPENDENCIES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Kind.FROM_CLASS_LOADER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Kind.FALLBACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public JvmBuiltIns(final StorageManager r2, Kind r3) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "kind");
        super(r2);
        this.kind = r3;
        this.customizer$delegate = r2.createLazyValue(new JvmBuiltIns$customizer$2(this, r2));
        int r4 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r4 != 2) goto L5;
        createBuiltInsModule(false);
        return;
    L5:
        if (r4 != 3) goto L11;
        createBuiltInsModule(true);
        return;
    }

    public static final /* synthetic */ Function0 access$getSettingsComputation$p(JvmBuiltIns r0) {
        return r0.settingsComputation;
    }

    public static final /* synthetic */ void access$setSettingsComputation$p(JvmBuiltIns r0, Function0 r1) {
        r0.settingsComputation = r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public /* bridge */ /* synthetic */ Iterable getClassDescriptorFactories() {
        return getClassDescriptorFactories();
    }

    public final void setPostponedSettingsComputation(Function0<Settings> r2) {
        Intrinsics.checkNotNullParameter(r2, "computation");
        this.settingsComputation = r2;
    }

    public final void initialize(final ModuleDescriptor r2, final boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "moduleDescriptor");
        setPostponedSettingsComputation(new AnonymousClass1(r2, r3));
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    }

    public final JvmBuiltInsCustomizer getCustomizer() {
        return (JvmBuiltInsCustomizer) StorageKt.getValue(this.customizer$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getCustomizer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    protected AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return getCustomizer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    protected List<ClassDescriptorFactory> getClassDescriptorFactories() {
        Iterable<ClassDescriptorFactory> r0 = super.getClassDescriptorFactories();
        Intrinsics.checkNotNullExpressionValue(r0, "super.getClassDescriptorFactories()");
        StorageManager r3 = getStorageManager();
        Intrinsics.checkNotNullExpressionValue(r3, "storageManager");
        ModuleDescriptorImpl r8 = getBuiltInsModule();
        Intrinsics.checkNotNullExpressionValue(r8, "builtInsModule");
        return CollectionsKt.plus(r0, new JvmBuiltInClassDescriptorFactory(r3, r8, null, 4, null));
    }
}
