package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: compiled from: SupertypeLoopChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface SupertypeLoopChecker {

    /* JADX INFO: compiled from: SupertypeLoopChecker.kt */
    public static final class EMPTY implements SupertypeLoopChecker {
        public static final EMPTY INSTANCE = null;

        static {
            INSTANCE = new EMPTY();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker
        public Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor r1, Collection<? extends KotlinType> r2, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> r3, Function1<? super KotlinType, Unit> r4) {
            Intrinsics.checkNotNullParameter(r1, "currentTypeConstructor");
            Intrinsics.checkNotNullParameter(r2, "superTypes");
            Intrinsics.checkNotNullParameter(r3, "neighbors");
            Intrinsics.checkNotNullParameter(r4, "reportLoop");
            return r2;
        }

        private EMPTY() {
        }
    }

    Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor r1, Collection<? extends KotlinType> r2, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> r3, Function1<? super KotlinType, Unit> r4);
}
