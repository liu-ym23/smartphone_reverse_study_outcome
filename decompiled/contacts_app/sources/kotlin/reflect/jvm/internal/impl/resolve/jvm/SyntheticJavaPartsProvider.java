package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: SyntheticJavaPartsProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface SyntheticJavaPartsProvider {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: SyntheticJavaPartsProvider.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final CompositeSyntheticJavaPartsProvider EMPTY = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            EMPTY = new CompositeSyntheticJavaPartsProvider(CollectionsKt.emptyList());
        }

        public final CompositeSyntheticJavaPartsProvider getEMPTY() {
            return EMPTY;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void generateConstructors(ClassDescriptor r1, List<ClassConstructorDescriptor> r2);

    void generateMethods(ClassDescriptor r1, Name r2, Collection<SimpleFunctionDescriptor> r3);

    void generateStaticFunctions(ClassDescriptor r1, Name r2, Collection<SimpleFunctionDescriptor> r3);

    List<Name> getMethodNames(ClassDescriptor r1);

    List<Name> getStaticFunctionNames(ClassDescriptor r1);
}
