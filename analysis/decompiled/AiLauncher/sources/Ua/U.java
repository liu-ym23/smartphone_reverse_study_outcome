package Ua;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.time.DurationUnit;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\u0007\u0010\u0004\u001a\u0013\u0010\b\u001a\u00020\u0000*\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\t\"\u0018\u0010\u000e\u001a\u00020\u000b*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"", "timeMillis", "LY8/t;", Const.INTENT_KEY_APIKEY, "(JLe9/c;)Ljava/lang/Object;", "Lkotlin/time/a;", "duration", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "(J)J", "Lkotlin/coroutines/d;", "LUa/T;", "c", "(Lkotlin/coroutines/d;)LUa/T;", "delay", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class U {
    public static final Object a(long j10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        if (j10 <= 0) {
            return Y8.t.f7040a;
        }
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        if (j10 < Long.MAX_VALUE) {
            c(cVar.getContext()).v0(j10, cVar);
        }
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC == C4063a.g() ? objC : Y8.t.f7040a;
    }

    public static final Object b(long j10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objA = a(d(j10), interfaceC4014c);
        return objA == C4063a.g() ? objA : Y8.t.f7040a;
    }

    public static final T c(kotlin.coroutines.d dVar) {
        d.b bVar = dVar.get(kotlin.coroutines.c.INSTANCE);
        T t10 = bVar instanceof T ? (T) bVar : null;
        return t10 == null ? P.a() : t10;
    }

    public static final long d(long j10) {
        boolean zG = kotlin.time.a.G(j10);
        if (zG) {
            return kotlin.time.a.s(kotlin.time.a.H(j10, kotlin.time.b.t(999999L, DurationUnit.NANOSECONDS)));
        }
        if (zG) {
            throw new NoWhenBranchMatchedException();
        }
        return 0L;
    }
}
