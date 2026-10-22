package kotlin.reflect.jvm.internal.impl.builtins.functions;

import h9.InterfaceC4149a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class FunctionClassKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ FunctionClassKind[] $VALUES;
    public static final a Companion;
    public static final FunctionClassKind Function = new FunctionClassKind("Function", 0);
    public static final FunctionClassKind SuspendFunction = new FunctionClassKind("SuspendFunction", 1);
    public static final FunctionClassKind KFunction = new FunctionClassKind("KFunction", 2);
    public static final FunctionClassKind KSuspendFunction = new FunctionClassKind("KSuspendFunction", 3);
    public static final FunctionClassKind UNKNOWN = new FunctionClassKind("UNKNOWN", 4);

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public final FunctionClassKind a(e functionTypeKind) {
            p.i(functionTypeKind, "functionTypeKind");
            return p.d(functionTypeKind, e.a.f34968f) ? FunctionClassKind.Function : p.d(functionTypeKind, e.d.f34971f) ? FunctionClassKind.SuspendFunction : p.d(functionTypeKind, e.b.f34969f) ? FunctionClassKind.KFunction : p.d(functionTypeKind, e.c.f34970f) ? FunctionClassKind.KSuspendFunction : FunctionClassKind.UNKNOWN;
        }

        public a() {
        }
    }

    private static final /* synthetic */ FunctionClassKind[] $values() {
        return new FunctionClassKind[]{Function, SuspendFunction, KFunction, KSuspendFunction, UNKNOWN};
    }

    static {
        FunctionClassKind[] functionClassKindArr$values = $values();
        $VALUES = functionClassKindArr$values;
        $ENTRIES = kotlin.enums.a.a(functionClassKindArr$values);
        Companion = new a(null);
    }

    private FunctionClassKind(String str, int i10) {
    }

    public static FunctionClassKind valueOf(String str) {
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, str);
    }

    public static FunctionClassKind[] values() {
        return (FunctionClassKind[]) $VALUES.clone();
    }
}
