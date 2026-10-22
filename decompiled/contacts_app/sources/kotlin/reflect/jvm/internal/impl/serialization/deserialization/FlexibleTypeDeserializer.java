package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: compiled from: FlexibleTypeDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface FlexibleTypeDeserializer {

    /* JADX INFO: compiled from: FlexibleTypeDeserializer.kt */
    public static final class ThrowException implements FlexibleTypeDeserializer {
        public static final ThrowException INSTANCE = null;

        static {
            INSTANCE = new ThrowException();
        }

        private ThrowException() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
        public KotlinType create(ProtoBuf.Type r1, String r2, SimpleType r3, SimpleType r4) {
            Intrinsics.checkNotNullParameter(r1, "proto");
            Intrinsics.checkNotNullParameter(r2, "flexibleId");
            Intrinsics.checkNotNullParameter(r3, "lowerBound");
            Intrinsics.checkNotNullParameter(r4, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    KotlinType create(ProtoBuf.Type r1, String r2, SimpleType r3, SimpleType r4);
}
