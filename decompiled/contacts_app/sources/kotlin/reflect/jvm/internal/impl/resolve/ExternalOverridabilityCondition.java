package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* JADX INFO: loaded from: classes4.dex */
public interface ExternalOverridabilityCondition {

    public static final enum Contract extends Enum<Contract> {
        private static final /* synthetic */ Contract[] $VALUES = null;
        public static final Contract BOTH = null;
        public static final Contract CONFLICTS_ONLY = null;
        public static final Contract SUCCESS_ONLY = null;

        private Contract(String r1, int r2) {
            super(r1, r2);
        }

        public static Contract valueOf(String r1) {
            return (Contract) Enum.valueOf(Contract.class, r1);
        }

        public static Contract[] values() {
            return (Contract[]) $VALUES.clone();
        }

        static {
            Contract r0 = new Contract("CONFLICTS_ONLY", 0);
            CONFLICTS_ONLY = r0;
            Contract r1 = new Contract("SUCCESS_ONLY", 1);
            SUCCESS_ONLY = r1;
            Contract r3 = new Contract("BOTH", 2);
            BOTH = r3;
            $VALUES = new Contract[]{r0, r1, r3};
        }
    }

    public static final enum Result extends Enum<Result> {
        private static final /* synthetic */ Result[] $VALUES = null;
        public static final Result CONFLICT = null;
        public static final Result INCOMPATIBLE = null;
        public static final Result OVERRIDABLE = null;
        public static final Result UNKNOWN = null;

        private Result(String r1, int r2) {
            super(r1, r2);
        }

        public static Result valueOf(String r1) {
            return (Result) Enum.valueOf(Result.class, r1);
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }

        static {
            Result r0 = new Result("OVERRIDABLE", 0);
            OVERRIDABLE = r0;
            Result r1 = new Result("CONFLICT", 1);
            CONFLICT = r1;
            Result r3 = new Result("INCOMPATIBLE", 2);
            INCOMPATIBLE = r3;
            Result r5 = new Result("UNKNOWN", 3);
            UNKNOWN = r5;
            $VALUES = new Result[]{r0, r1, r3, r5};
        }
    }

    Contract getContract();

    Result isOverridable(CallableDescriptor r1, CallableDescriptor r2, ClassDescriptor r3);
}
