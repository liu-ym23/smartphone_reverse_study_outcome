package kotlin.reflect.jvm.internal.impl.descriptors.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;

/* JADX INFO: compiled from: JavaVisibilities.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaVisibilities {
    public static final JavaVisibilities INSTANCE = null;

    /* JADX INFO: compiled from: JavaVisibilities.kt */
    public static final class PackageVisibility extends Visibility {
        public static final PackageVisibility INSTANCE = null;

        static {
            INSTANCE = new PackageVisibility();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "public/*package*/";
        }

        private PackageVisibility() {
            super("package", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Integer compareTo(Visibility r2) {
            Intrinsics.checkNotNullParameter(r2, "visibility");
            if (this != r2) goto L7;
            return 0;
        L7:
            if (Visibilities.INSTANCE.isPrivate(r2) == false) goto L11;
            return 1;
        L11:
            return -1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: JavaVisibilities.kt */
    public static final class ProtectedAndPackage extends Visibility {
        public static final ProtectedAndPackage INSTANCE = null;

        static {
            INSTANCE = new ProtectedAndPackage();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "protected/*protected and package*/";
        }

        private ProtectedAndPackage() {
            super("protected_and_package", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Integer compareTo(Visibility r2) {
            Intrinsics.checkNotNullParameter(r2, "visibility");
            if (Intrinsics.areEqual(this, r2) == false) goto L7;
            return 0;
        L7:
            if (r2 != Visibilities.Internal.INSTANCE) goto L11;
            return null;
        L11:
            if (Visibilities.INSTANCE.isPrivate(r2) == false) goto L13;
            int r1 = 1;
        L15:
            return Integer.valueOf(r1);
        L13:
            r1 = -1;
            goto L15
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: JavaVisibilities.kt */
    public static final class ProtectedStaticVisibility extends Visibility {
        public static final ProtectedStaticVisibility INSTANCE = null;

        static {
            INSTANCE = new ProtectedStaticVisibility();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "protected/*protected static*/";
        }

        private ProtectedStaticVisibility() {
            super("protected_static", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    static {
        INSTANCE = new JavaVisibilities();
    }

    private JavaVisibilities() {
    }
}
