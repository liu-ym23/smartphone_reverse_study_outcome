package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ValueParameterCountCheck implements Check {
    private final String description;

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class AtLeast extends ValueParameterCountCheck {
        private final int n;

        public AtLeast(int r3) {
            StringBuilder r0 = new StringBuilder("must have at least ").append(r3).append(" value parameter");
            if (r3 <= 1) goto L5;
            String r1 = "s";
        L6:
            super(r0.append(r1).toString(), null);
            this.n = r3;
            return;
        L5:
            r1 = "";
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r2) {
            Intrinsics.checkNotNullParameter(r2, "functionDescriptor");
            if (r2.getValueParameters().size() < this.n) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class Equals extends ValueParameterCountCheck {
        private final int n;

        public Equals(int r3) {
            super("must have exactly " + r3 + " value parameters", null);
            this.n = r3;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r2) {
            Intrinsics.checkNotNullParameter(r2, "functionDescriptor");
            if (r2.getValueParameters().size() != this.n) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class NoValueParameters extends ValueParameterCountCheck {
        public static final NoValueParameters INSTANCE = null;

        static {
            INSTANCE = new NoValueParameters();
        }

        private NoValueParameters() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "functionDescriptor");
            return r1.getValueParameters().isEmpty();
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class SingleValueParameter extends ValueParameterCountCheck {
        public static final SingleValueParameter INSTANCE = null;

        static {
            INSTANCE = new SingleValueParameter();
        }

        private SingleValueParameter() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "functionDescriptor");
            if (r1.getValueParameters().size() == 1) goto L7;
            return false;
        L7:
            return true;
        }
    }

    public /* synthetic */ ValueParameterCountCheck(String r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private ValueParameterCountCheck(String r1) {
        this.description = r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor r1) {
        return Check.DefaultImpls.invoke(this, r1);
    }
}
