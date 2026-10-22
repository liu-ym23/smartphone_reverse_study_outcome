package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: compiled from: KotlinTypeRefiner.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class KotlinTypeRefiner extends AbstractTypeRefiner {

    /* JADX INFO: compiled from: KotlinTypeRefiner.kt */
    public static final class Default extends KotlinTypeRefiner {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor findClassAcrossModuleDependencies(ClassId r1) {
            Intrinsics.checkNotNullParameter(r1, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForModule(ModuleDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForTypeConstructor(TypeConstructor r1) {
            Intrinsics.checkNotNullParameter(r1, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor refineDescriptor(DeclarationDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "descriptor");
            return null;
        }

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public /* bridge */ /* synthetic */ ClassifierDescriptor refineDescriptor(DeclarationDescriptor r1) {
            return refineDescriptor(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
        public /* bridge */ /* synthetic */ KotlinTypeMarker refineType(KotlinTypeMarker r1) {
            return refineType(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
        public KotlinType refineType(KotlinTypeMarker r1) {
            Intrinsics.checkNotNullParameter(r1, "type");
            return (KotlinType) r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public Collection<KotlinType> refineSupertypes(ClassDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "classDescriptor");
            Collection<KotlinType> r0 = r1.getTypeConstructor().mo2084getSupertypes();
            Intrinsics.checkNotNullExpressionValue(r0, "classDescriptor.typeConstructor.supertypes");
            return r0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor r1, Function0<? extends S> r2) {
            Intrinsics.checkNotNullParameter(r1, "classDescriptor");
            Intrinsics.checkNotNullParameter(r2, "compute");
            return r2.invoke();
        }
    }

    public abstract ClassDescriptor findClassAcrossModuleDependencies(ClassId r1);

    public abstract <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor r1, Function0<? extends S> r2);

    public abstract boolean isRefinementNeededForModule(ModuleDescriptor r1);

    public abstract boolean isRefinementNeededForTypeConstructor(TypeConstructor r1);

    public abstract ClassifierDescriptor refineDescriptor(DeclarationDescriptor r1);

    public abstract Collection<KotlinType> refineSupertypes(ClassDescriptor r1);

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
    public abstract KotlinType refineType(KotlinTypeMarker r1);

    public KotlinTypeRefiner() {
    }
}
