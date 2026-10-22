package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.collections.MapsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: JavaNullabilityAnnotationSettings.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface NullabilityAnnotationStates<T> {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: JavaNullabilityAnnotationSettings.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final NullabilityAnnotationStates EMPTY = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            EMPTY = new NullabilityAnnotationStatesImpl(MapsKt.emptyMap());
        }

        public final NullabilityAnnotationStates getEMPTY() {
            return EMPTY;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    T get(FqName r1);
}
