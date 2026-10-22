package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ReturnsCheck implements Check {
    private final String description;
    private final String name;
    private final Function1<KotlinBuiltIns, KotlinType> type;

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class ReturnsBoolean extends ReturnsCheck {
        public static final ReturnsBoolean INSTANCE = null;

        static {
            INSTANCE = new ReturnsBoolean();
        }

        private ReturnsBoolean() {
            String r2 = "Boolean";
            super(r2, AnonymousClass1.INSTANCE, null);
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class ReturnsInt extends ReturnsCheck {
        public static final ReturnsInt INSTANCE = null;

        static {
            INSTANCE = new ReturnsInt();
        }

        private ReturnsInt() {
            String r2 = "Int";
            super(r2, AnonymousClass1.INSTANCE, null);
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class ReturnsUnit extends ReturnsCheck {
        public static final ReturnsUnit INSTANCE = null;

        static {
            INSTANCE = new ReturnsUnit();
        }

        private ReturnsUnit() {
            String r2 = "Unit";
            super(r2, AnonymousClass1.INSTANCE, null);
        }
    }

    public /* synthetic */ ReturnsCheck(String r1, Function1 r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(String r2, Function1<? super KotlinBuiltIns, ? extends KotlinType> r3) {
        this.name = r2;
        this.type = r3;
        this.description = "must return " + r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor r1) {
        return Check.DefaultImpls.invoke(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "functionDescriptor");
        return Intrinsics.areEqual(r2.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(r2)));
    }
}
