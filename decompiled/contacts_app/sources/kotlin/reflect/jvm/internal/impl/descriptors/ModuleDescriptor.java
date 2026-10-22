package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: ModuleDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ModuleDescriptor extends DeclarationDescriptor {

    /* JADX INFO: compiled from: ModuleDescriptor.kt */
    public static final class DefaultImpls {
        public static DeclarationDescriptor getContainingDeclaration(ModuleDescriptor r0) {
            return null;
        }

        public static <R, D> R accept(ModuleDescriptor r1, DeclarationDescriptorVisitor<R, D> r2, D r3) {
            Intrinsics.checkNotNullParameter(r2, "visitor");
            return r2.visitModuleDeclaration(r1, r3);
        }
    }

    KotlinBuiltIns getBuiltIns();

    <T> T getCapability(ModuleCapability<T> r1);

    List<ModuleDescriptor> getExpectedByModules();

    PackageViewDescriptor getPackage(FqName r1);

    Collection<FqName> getSubPackagesOf(FqName r1, Function1<? super Name, Boolean> r2);

    boolean shouldSeeInternalsOf(ModuleDescriptor r1);
}
