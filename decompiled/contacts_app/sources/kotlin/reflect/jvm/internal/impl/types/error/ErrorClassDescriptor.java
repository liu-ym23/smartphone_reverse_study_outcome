package kotlin.reflect.jvm.internal.impl.types.error;

import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: compiled from: ErrorClassDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ErrorClassDescriptor extends ClassDescriptorImpl {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    public ErrorClassDescriptor(Name r15) {
        Intrinsics.checkNotNullParameter(r15, "name");
        super(ErrorUtils.INSTANCE.getErrorModule(), r15, Modality.OPEN, ClassKind.CLASS, CollectionsKt.emptyList(), SourceElement.NO_SOURCE, false, LockBasedStorageManager.NO_LOCKS);
        ClassConstructorDescriptorImpl r16 = ClassConstructorDescriptorImpl.create(this, Annotations.Companion.getEMPTY(), true, SourceElement.NO_SOURCE);
        r16.initialize(CollectionsKt.emptyList(), DescriptorVisibilities.INTERNAL);
        Intrinsics.checkNotNullExpressionValue(r16, "create(this, Annotations…          )\n            }");
        ErrorScopeKind r0 = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String r3 = r16.getName().toString();
        Intrinsics.checkNotNullExpressionValue(r3, "errorConstructor.name.toString()");
        ErrorScope r1 = ErrorUtils.createErrorScope(r0, new String[]{r3, ""});
        r16.setReturnType(new ErrorType(ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.ERROR_CLASS, new String[0]), r1, ErrorTypeKind.ERROR_CLASS, null, false, new String[0], 24, null));
        initialize(r1, SetsKt.setOf(r16), r16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor r2) {
        Intrinsics.checkNotNullParameter(r2, "substitutor");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution r3, KotlinTypeRefiner r4) {
        Intrinsics.checkNotNullParameter(r3, "typeSubstitution");
        Intrinsics.checkNotNullParameter(r4, "kotlinTypeRefiner");
        ErrorScopeKind r5 = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String r2 = getName().toString();
        Intrinsics.checkNotNullExpressionValue(r2, "name.toString()");
        return ErrorUtils.createErrorScope(r5, new String[]{r2, r3.toString()});
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl
    public String toString() {
        String r1 = getName().asString();
        Intrinsics.checkNotNullExpressionValue(r1, "name.asString()");
        return r1;
    }
}
