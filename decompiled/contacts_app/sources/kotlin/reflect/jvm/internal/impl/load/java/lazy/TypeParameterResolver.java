package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* JADX INFO: compiled from: resolvers.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface TypeParameterResolver {

    /* JADX INFO: compiled from: resolvers.kt */
    public static final class EMPTY implements TypeParameterResolver {
        public static final EMPTY INSTANCE = null;

        static {
            INSTANCE = new EMPTY();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
        public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter r1) {
            Intrinsics.checkNotNullParameter(r1, "javaTypeParameter");
            return null;
        }

        private EMPTY() {
        }
    }

    TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter r1);
}
