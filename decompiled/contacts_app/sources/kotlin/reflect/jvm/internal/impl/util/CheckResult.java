package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CheckResult {
    private final boolean isSuccess;

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class IllegalFunctionName extends CheckResult {
        public static final IllegalFunctionName INSTANCE = null;

        static {
            INSTANCE = new IllegalFunctionName();
        }

        private IllegalFunctionName() {
            super(false, null);
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class IllegalSignature extends CheckResult {
        private final String error;

        public IllegalSignature(String r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            super(false, null);
            this.error = r3;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class SuccessCheck extends CheckResult {
        public static final SuccessCheck INSTANCE = null;

        static {
            INSTANCE = new SuccessCheck();
        }

        private SuccessCheck() {
            super(true, null);
        }
    }

    public /* synthetic */ CheckResult(boolean r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private CheckResult(boolean r1) {
        this.isSuccess = r1;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }
}
