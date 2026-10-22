package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DescriptorKindExclude {

    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class NonExtensions extends DescriptorKindExclude {
        public static final NonExtensions INSTANCE = null;
        private static final int fullyExcludedDescriptorKinds = 0;

        private NonExtensions() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude
        public int getFullyExcludedDescriptorKinds() {
            return fullyExcludedDescriptorKinds;
        }

        static {
            INSTANCE = new NonExtensions();
            fullyExcludedDescriptorKinds = DescriptorKindFilter.Companion.getALL_KINDS_MASK() & (~(DescriptorKindFilter.Companion.getFUNCTIONS_MASK() | DescriptorKindFilter.Companion.getVARIABLES_MASK()));
        }
    }

    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class TopLevelPackages extends DescriptorKindExclude {
        public static final TopLevelPackages INSTANCE = null;

        static {
            INSTANCE = new TopLevelPackages();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude
        public int getFullyExcludedDescriptorKinds() {
            return 0;
        }

        private TopLevelPackages() {
        }
    }

    public abstract int getFullyExcludedDescriptorKinds();

    public DescriptorKindExclude() {
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
