package Z8;

import D7.N;
import X8.K;
import h8.InterfaceC1527j;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f1619a = new i();
    public static final d b = d.f1616a;
    public static final a c;
    public static final g d;
    public static final g e;
    public static final Set f;

    static {
        ErrorEntity[] errorEntityArr = ErrorEntity.f5147a;
        c = new a(G8.f.g(String.format("<Error class: %s>", Arrays.copyOf(new Object[]{"unknown class"}, 1))));
        d = c(ErrorTypeKind.h, new String[0]);
        e = c(ErrorTypeKind.u, new String[0]);
        f = N.Q(new e());
    }

    public static final f a(ErrorScopeKind errorScopeKind, boolean z10, String... formatParams) {
        k.f(formatParams, "formatParams");
        if (!z10) {
            return new f(errorScopeKind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
        }
        String[] formatParams2 = (String[]) Arrays.copyOf(formatParams, formatParams.length);
        k.f(formatParams2, "formatParams");
        return new j(errorScopeKind, (String[]) Arrays.copyOf(formatParams2, formatParams2.length));
    }

    public static final f b(ErrorScopeKind errorScopeKind, String... strArr) {
        return a(errorScopeKind, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final g c(ErrorTypeKind kind, String... strArr) {
        k.f(kind, "kind");
        EmptyList arguments = EmptyList.f4893a;
        String[] formatParams = (String[]) Arrays.copyOf(strArr, strArr.length);
        k.f(arguments, "arguments");
        k.f(formatParams, "formatParams");
        return e(kind, arguments, d(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length)), (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static h d(ErrorTypeKind kind, String... formatParams) {
        k.f(kind, "kind");
        k.f(formatParams, "formatParams");
        return new h(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static g e(ErrorTypeKind kind, List arguments, K k, String... formatParams) {
        k.f(kind, "kind");
        k.f(arguments, "arguments");
        k.f(formatParams, "formatParams");
        return new g(k, b(ErrorScopeKind.e, k.toString()), kind, arguments, false, (String[]) Arrays.copyOf(formatParams, formatParams.length));
    }

    public static final boolean f(InterfaceC1527j interfaceC1527j) {
        if (interfaceC1527j != null) {
            return (interfaceC1527j instanceof a) || (interfaceC1527j.d() instanceof a) || interfaceC1527j == b;
        }
        return false;
    }
}
