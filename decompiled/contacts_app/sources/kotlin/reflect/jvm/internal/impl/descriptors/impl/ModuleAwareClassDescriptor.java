package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ModuleAwareClassDescriptor implements ClassDescriptor {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final MemberScope getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(ClassDescriptor r1, KotlinTypeRefiner r2) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
            if ((r1 instanceof ModuleAwareClassDescriptor) == false) goto L5;
            ModuleAwareClassDescriptor r0 = (ModuleAwareClassDescriptor) r1;
        L6:
            if (r0 == null) goto L9;
            MemberScope r3 = r0.getUnsubstitutedMemberScope(r2);
            if (r3 == null) goto L9;
            return r3;
        L9:
            MemberScope r4 = r1.getUnsubstitutedMemberScope();
            Intrinsics.checkNotNullExpressionValue(r4, "this.unsubstitutedMemberScope");
            return r4;
        L5:
            r0 = null;
            goto L6
        }

        public final MemberScope getRefinedMemberScopeIfPossible$descriptors(ClassDescriptor r1, TypeSubstitution r2, KotlinTypeRefiner r3) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            Intrinsics.checkNotNullParameter(r2, "typeSubstitution");
            Intrinsics.checkNotNullParameter(r3, "kotlinTypeRefiner");
            if ((r1 instanceof ModuleAwareClassDescriptor) == false) goto L5;
            ModuleAwareClassDescriptor r0 = (ModuleAwareClassDescriptor) r1;
        L6:
            if (r0 == null) goto L9;
            MemberScope r4 = r0.getMemberScope(r2, r3);
            if (r4 == null) goto L9;
            return r4;
        L9:
            MemberScope r5 = r1.getMemberScope(r2);
            Intrinsics.checkNotNullExpressionValue(r5, "this.getMemberScope(\n   …ubstitution\n            )");
            return r5;
        L5:
            r0 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    protected abstract MemberScope getMemberScope(TypeSubstitution r1, KotlinTypeRefiner r2);

    protected abstract MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r1);

    public ModuleAwareClassDescriptor() {
    }
}
