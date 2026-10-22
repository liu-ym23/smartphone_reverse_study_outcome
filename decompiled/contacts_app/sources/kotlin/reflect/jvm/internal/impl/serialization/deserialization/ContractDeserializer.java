package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;

/* JADX INFO: compiled from: ContractDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ContractDeserializer {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: ContractDeserializer.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final ContractDeserializer DEFAULT = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            DEFAULT = new ContractDeserializer$Companion$DEFAULT$1();
        }

        public final ContractDeserializer getDEFAULT() {
            return DEFAULT;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction(ProtoBuf.Function r1, FunctionDescriptor r2, TypeTable r3, TypeDeserializer r4);
}
