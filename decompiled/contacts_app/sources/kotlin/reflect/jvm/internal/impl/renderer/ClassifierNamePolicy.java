package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* JADX INFO: compiled from: ClassifierNamePolicy.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ClassifierNamePolicy {

    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class FULLY_QUALIFIED implements ClassifierNamePolicy {
        public static final FULLY_QUALIFIED INSTANCE = null;

        static {
            INSTANCE = new FULLY_QUALIFIED();
        }

        private FULLY_QUALIFIED() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r1, DescriptorRenderer r2) {
            Intrinsics.checkNotNullParameter(r1, "classifier");
            Intrinsics.checkNotNullParameter(r2, "renderer");
            if ((r1 instanceof TypeParameterDescriptor) == false) goto L6;
            Name r0 = ((TypeParameterDescriptor) r1).getName();
            Intrinsics.checkNotNullExpressionValue(r0, "classifier.name");
            return r2.renderName(r0, false);
        L6:
            FqNameUnsafe r3 = DescriptorUtils.getFqName(r1);
            Intrinsics.checkNotNullExpressionValue(r3, "getFqName(classifier)");
            return r2.renderFqName(r3);
        }
    }

    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class SHORT implements ClassifierNamePolicy {
        public static final SHORT INSTANCE = null;

        static {
            INSTANCE = new SHORT();
        }

        private SHORT() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r1, DescriptorRenderer r2) {
            Intrinsics.checkNotNullParameter(r1, "classifier");
            Intrinsics.checkNotNullParameter(r2, "renderer");
            if ((r1 instanceof TypeParameterDescriptor) == false) goto L6;
            Name r0 = ((TypeParameterDescriptor) r1).getName();
            Intrinsics.checkNotNullExpressionValue(r0, "classifier.name");
            return r2.renderName(r0, false);
        L6:
            ArrayList r3 = new ArrayList();
            ClassifierDescriptor r4 = r1;
        L7:
            r3.add(r4.getName());
            r4 = r4.getContainingDeclaration();
            if ((r4 instanceof ClassDescriptor) == true) goto L7;
            return RenderingUtilsKt.renderFqName(CollectionsKt.asReversedMutable(r3));
        }
    }

    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class SOURCE_CODE_QUALIFIED implements ClassifierNamePolicy {
        public static final SOURCE_CODE_QUALIFIED INSTANCE = null;

        static {
            INSTANCE = new SOURCE_CODE_QUALIFIED();
        }

        private SOURCE_CODE_QUALIFIED() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r2, DescriptorRenderer r3) {
            Intrinsics.checkNotNullParameter(r2, "classifier");
            Intrinsics.checkNotNullParameter(r3, "renderer");
            return qualifiedNameForSourceCode(r2);
        }

        private final String qualifiedNameForSourceCode(ClassifierDescriptor r3) {
            Name r0 = r3.getName();
            Intrinsics.checkNotNullExpressionValue(r0, "descriptor.name");
            String r1 = RenderingUtilsKt.render(r0);
            if ((r3 instanceof TypeParameterDescriptor) == false) goto L5;
            return r1;
        L5:
            DeclarationDescriptor r4 = r3.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(r4, "descriptor.containingDeclaration");
            String r2 = qualifierName(r4);
            if (r2 != null) goto L8;
            return r1;
        L8:
            if (Intrinsics.areEqual(r2, "") == false) goto L10;
            return r1;
        L10:
            return r2 + '.' + r1;
        }

        private final String qualifierName(DeclarationDescriptor r2) {
            if ((r2 instanceof ClassDescriptor) == false) goto L6;
            return qualifiedNameForSourceCode((ClassifierDescriptor) r2);
        L6:
            if ((r2 instanceof PackageFragmentDescriptor) == false) goto L8;
            FqNameUnsafe r1 = ((PackageFragmentDescriptor) r2).getFqName().toUnsafe();
            Intrinsics.checkNotNullExpressionValue(r1, "descriptor.fqName.toUnsafe()");
            return RenderingUtilsKt.render(r1);
        L8:
            return null;
        }
    }

    String renderClassifier(ClassifierDescriptor r1, DescriptorRenderer r2);
}
