package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Modifier;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;

/* JADX INFO: compiled from: ReflectJavaModifierListOwner.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ReflectJavaModifierListOwner extends JavaModifierListOwner {

    /* JADX INFO: compiled from: ReflectJavaModifierListOwner.kt */
    public static final class DefaultImpls {
        public static boolean isAbstract(ReflectJavaModifierListOwner r0) {
            return Modifier.isAbstract(r0.getModifiers());
        }

        public static boolean isStatic(ReflectJavaModifierListOwner r0) {
            return Modifier.isStatic(r0.getModifiers());
        }

        public static boolean isFinal(ReflectJavaModifierListOwner r0) {
            return Modifier.isFinal(r0.getModifiers());
        }

        public static Visibility getVisibility(ReflectJavaModifierListOwner r1) {
            int r2 = r1.getModifiers();
            if (Modifier.isPublic(r2) == false) goto L6;
            return Visibilities.Public.INSTANCE;
        L6:
            if (Modifier.isPrivate(r2) == false) goto L9;
            return Visibilities.Private.INSTANCE;
        L9:
            if (Modifier.isProtected(r2) == false) goto L15;
            if (Modifier.isStatic(r2) == false) goto L19;
            return JavaVisibilities.ProtectedStaticVisibility.INSTANCE;
        L19:
            return JavaVisibilities.ProtectedAndPackage.INSTANCE;
        L15:
            return JavaVisibilities.PackageVisibility.INSTANCE;
        }
    }

    int getModifiers();
}
