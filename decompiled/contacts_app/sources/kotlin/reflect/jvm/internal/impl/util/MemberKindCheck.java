package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MemberKindCheck implements Check {
    private final String description;

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class Member extends MemberKindCheck {
        public static final Member INSTANCE = null;

        static {
            INSTANCE = new Member();
        }

        private Member() {
            super("must be a member function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "functionDescriptor");
            if (r1.getDispatchReceiverParameter() == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class MemberOrExtension extends MemberKindCheck {
        public static final MemberOrExtension INSTANCE = null;

        static {
            INSTANCE = new MemberOrExtension();
        }

        private MemberOrExtension() {
            super("must be a member or an extension function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.Check
        public boolean check(FunctionDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "functionDescriptor");
            if (r1.getDispatchReceiverParameter() == null) goto L5;
        L8:
            return true;
        L5:
            if (r1.getExtensionReceiverParameter() != null) goto L8;
            return false;
        }
    }

    public /* synthetic */ MemberKindCheck(String r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private MemberKindCheck(String r1) {
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
