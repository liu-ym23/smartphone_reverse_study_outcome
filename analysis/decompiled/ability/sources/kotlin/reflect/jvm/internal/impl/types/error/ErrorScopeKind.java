package kotlin.reflect.jvm.internal.impl.types.error;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class ErrorScopeKind {
    public static final ErrorScopeKind b;
    public static final ErrorScopeKind c;
    public static final ErrorScopeKind d;
    public static final ErrorScopeKind e;
    public static final ErrorScopeKind f;
    public static final /* synthetic */ ErrorScopeKind[] g;

    /* renamed from: a, reason: collision with root package name */
    public final String f5148a;

    static {
        ErrorScopeKind errorScopeKind = new ErrorScopeKind("CAPTURED_TYPE_SCOPE", 0, "No member resolution should be done on captured type, it used only during constraint system resolution");
        b = errorScopeKind;
        ErrorScopeKind errorScopeKind2 = new ErrorScopeKind("INTEGER_LITERAL_TYPE_SCOPE", 1, "Scope for integer literal type (%s)");
        c = errorScopeKind2;
        ErrorScopeKind errorScopeKind3 = new ErrorScopeKind("ERASED_RECEIVER_TYPE_SCOPE", 2, "Error scope for erased receiver type");
        ErrorScopeKind errorScopeKind4 = new ErrorScopeKind("SCOPE_FOR_ABBREVIATION_TYPE", 3, "Scope for abbreviation %s");
        d = errorScopeKind4;
        ErrorScopeKind errorScopeKind5 = new ErrorScopeKind("STUB_TYPE_SCOPE", 4, "Scope for stub type %s");
        ErrorScopeKind errorScopeKind6 = new ErrorScopeKind("NON_CLASSIFIER_SUPER_TYPE_SCOPE", 5, "A scope for common supertype which is not a normal classifier");
        ErrorScopeKind errorScopeKind7 = new ErrorScopeKind("ERROR_TYPE_SCOPE", 6, "Scope for error type %s");
        e = errorScopeKind7;
        ErrorScopeKind errorScopeKind8 = new ErrorScopeKind("UNSUPPORTED_TYPE_SCOPE", 7, "Scope for unsupported type %s");
        ErrorScopeKind errorScopeKind9 = new ErrorScopeKind("SCOPE_FOR_ERROR_CLASS", 8, "Error scope for class %s with arguments: %s");
        f = errorScopeKind9;
        ErrorScopeKind[] errorScopeKindArr = {errorScopeKind, errorScopeKind2, errorScopeKind3, errorScopeKind4, errorScopeKind5, errorScopeKind6, errorScopeKind7, errorScopeKind8, errorScopeKind9, new ErrorScopeKind("SCOPE_FOR_ERROR_RESOLUTION_CANDIDATE", 9, "Error resolution candidate for call %s")};
        g = errorScopeKindArr;
        a.a(errorScopeKindArr);
    }

    public ErrorScopeKind(String str, int i, String str2) {
        this.f5148a = str2;
    }

    public static ErrorScopeKind valueOf(String str) {
        return (ErrorScopeKind) Enum.valueOf(ErrorScopeKind.class, str);
    }

    public static ErrorScopeKind[] values() {
        return (ErrorScopeKind[]) g.clone();
    }
}
