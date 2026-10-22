package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.enums.a;
import s2.C1912a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class FunctionClassKind {

    /* renamed from: a, reason: collision with root package name */
    public static final C1912a f4946a;
    public static final /* synthetic */ FunctionClassKind[] b;

    static {
        FunctionClassKind[] functionClassKindArr = {new FunctionClassKind("Function", 0), new FunctionClassKind("SuspendFunction", 1), new FunctionClassKind("KFunction", 2), new FunctionClassKind("KSuspendFunction", 3), new FunctionClassKind("UNKNOWN", 4)};
        b = functionClassKindArr;
        a.a(functionClassKindArr);
        f4946a = new C1912a();
    }

    public static FunctionClassKind valueOf(String str) {
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, str);
    }

    public static FunctionClassKind[] values() {
        return (FunctionClassKind[]) b.clone();
    }
}
