package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes4.dex */
final class FallbackBuiltIns extends KotlinBuiltIns {
    public static final Companion Companion = null;
    private static final KotlinBuiltIns Instance = null;

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final KotlinBuiltIns getInstance() {
            return FallbackBuiltIns.access$getInstance$cp();
        }
    }

    private FallbackBuiltIns() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        createBuiltInsModule(true);
    }

    public static final /* synthetic */ KotlinBuiltIns access$getInstance$cp() {
        return Instance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public /* bridge */ /* synthetic */ PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getPlatformDependentDeclarationFilter();
    }

    static {
        Companion = new Companion(null);
        Instance = new FallbackBuiltIns();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    protected PlatformDependentDeclarationFilter.All getPlatformDependentDeclarationFilter() {
        return PlatformDependentDeclarationFilter.All.INSTANCE;
    }
}
