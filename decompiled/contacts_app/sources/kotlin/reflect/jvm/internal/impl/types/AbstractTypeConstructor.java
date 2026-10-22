package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: compiled from: AbstractTypeConstructor.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractTypeConstructor extends ClassifierBasedTypeConstructor {
    private final boolean shouldReportCyclicScopeWithCompanionWarning;
    private final NotNullLazyValue<Supertypes> supertypes;

    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    private final class ModuleViewTypeConstructor implements TypeConstructor {
        private final KotlinTypeRefiner kotlinTypeRefiner;
        private final Lazy refinedSupertypes$delegate;
        final /* synthetic */ AbstractTypeConstructor this$0;

        public static final /* synthetic */ KotlinTypeRefiner access$getKotlinTypeRefiner$p(ModuleViewTypeConstructor r0) {
            return r0.kotlinTypeRefiner;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getSupertypes */
        public /* bridge */ /* synthetic */ Collection mo2084getSupertypes() {
            return mo2084getSupertypes();
        }

        public ModuleViewTypeConstructor(final AbstractTypeConstructor r2, KotlinTypeRefiner r3) {
            Intrinsics.checkNotNullParameter(r3, "kotlinTypeRefiner");
            this.this$0 = r2;
            this.kotlinTypeRefiner = r3;
            this.refinedSupertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(this, r2));
        }

        private final List<KotlinType> getRefinedSupertypes() {
            return (List) this.refinedSupertypes$delegate.getValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> r1 = this.this$0.getParameters();
            Intrinsics.checkNotNullExpressionValue(r1, "this@AbstractTypeConstructor.parameters");
            return r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getSupertypes */
        public List<KotlinType> mo2084getSupertypes() {
            return getRefinedSupertypes();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.this$0.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo2083getDeclarationDescriptor() {
            return this.this$0.mo2083getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns r1 = this.this$0.getBuiltIns();
            Intrinsics.checkNotNullExpressionValue(r1, "this@AbstractTypeConstructor.builtIns");
            return r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner r2) {
            Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
            return this.this$0.refine(r2);
        }

        public boolean equals(Object r1) {
            return this.this$0.equals(r1);
        }

        public int hashCode() {
            return this.this$0.hashCode();
        }

        public String toString() {
            return this.this$0.toString();
        }
    }

    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    private static final class Supertypes {
        private final Collection<KotlinType> allSupertypes;
        private List<? extends KotlinType> supertypesWithoutCycles;

        /* JADX WARN: Multi-variable type inference failed */
        public Supertypes(Collection<? extends KotlinType> r2) {
            Intrinsics.checkNotNullParameter(r2, "allSupertypes");
            this.allSupertypes = r2;
            this.supertypesWithoutCycles = CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());
        }

        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(List<? extends KotlinType> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.supertypesWithoutCycles = r2;
        }
    }

    protected abstract Collection<KotlinType> computeSupertypes();

    protected KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    protected abstract SupertypeLoopChecker getSupertypeLoopChecker();

    protected List<KotlinType> processSupertypesWithoutCycles(List<KotlinType> r1) {
        Intrinsics.checkNotNullParameter(r1, "supertypes");
        return r1;
    }

    protected void reportScopesLoopError(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    protected void reportSupertypeLoopError(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    public AbstractTypeConstructor(StorageManager r4) {
        Intrinsics.checkNotNullParameter(r4, "storageManager");
        this.supertypes = r4.createLazyValueWithPostCompute(new AbstractTypeConstructor$supertypes$1(this), AbstractTypeConstructor$supertypes$2.INSTANCE, new AbstractTypeConstructor$supertypes$3(this));
    }

    public static final /* synthetic */ Collection access$computeNeighbours(AbstractTypeConstructor r0, TypeConstructor r1, boolean r2) {
        return r0.computeNeighbours(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public /* bridge */ /* synthetic */ Collection mo2084getSupertypes() {
        return mo2084getSupertypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public List<KotlinType> mo2084getSupertypes() {
        return this.supertypes.invoke().getSupertypesWithoutCycles();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, r2);
    }

    private final Collection<KotlinType> computeNeighbours(TypeConstructor r2, boolean r3) {
        if ((r2 instanceof AbstractTypeConstructor) == false) goto L5;
        AbstractTypeConstructor r1 = (AbstractTypeConstructor) r2;
    L6:
        if (r1 == null) goto L10;
        List r4 = CollectionsKt.plus(r1.supertypes.invoke().getAllSupertypes(), r1.getAdditionalNeighboursInSupertypeGraph(r3));
        if (r4 == null) goto L10;
        return r4;
    L10:
        Collection<KotlinType> r5 = r2.mo2084getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r5, "supertypes");
        return r5;
    L5:
        r1 = null;
        goto L6
    }

    protected boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean r1) {
        return CollectionsKt.emptyList();
    }
}
