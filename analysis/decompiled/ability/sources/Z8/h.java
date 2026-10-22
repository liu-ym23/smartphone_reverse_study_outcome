package Z8;

import X8.K;
import h8.InterfaceC1524g;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes4.dex */
public final class h implements K {

    /* renamed from: a, reason: collision with root package name */
    public final ErrorTypeKind f1618a;
    public final String[] b;
    public final String c;

    public h(ErrorTypeKind kind, String... formatParams) {
        k.f(kind, "kind");
        k.f(formatParams, "formatParams");
        this.f1618a = kind;
        this.b = formatParams;
        ErrorEntity[] errorEntityArr = ErrorEntity.f5147a;
        String str = kind.f5163a;
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        this.c = String.format("[Error type: %s]", Arrays.copyOf(new Object[]{String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length))}, 1));
    }

    @Override // X8.K
    public final e8.i c() {
        return (e8.e) e8.e.f.getF4884a();
    }

    @Override // X8.K
    public final InterfaceC1524g d() {
        i.f1619a.getClass();
        return i.c;
    }

    @Override // X8.K
    public final Collection e() {
        return EmptyList.f4893a;
    }

    @Override // X8.K
    public final boolean f() {
        return false;
    }

    @Override // X8.K
    public final List getParameters() {
        return EmptyList.f4893a;
    }

    public final String toString() {
        return this.c;
    }
}
