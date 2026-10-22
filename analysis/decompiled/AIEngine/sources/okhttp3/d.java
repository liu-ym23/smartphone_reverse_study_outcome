package okhttp3;

import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.concurrent.TimeUnit;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.internal.connection.e f10963a;

    public d(dd.e taskRunner, ad.e eVar, int i10, int i11, int i12, int i13, int i14, boolean z, boolean z3, stepos.support.v7.app.palette.b bVar, int i15) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        taskRunner = (i15 & 8) != 0 ? dd.e.f8479l : taskRunner;
        ad.e connectionListener = (i15 & 16) != 0 ? ad.e.f75a : eVar;
        int i16 = (i15 & 32) != 0 ? 10000 : i10;
        int i17 = (i15 & 64) != 0 ? 10000 : i11;
        int i18 = (i15 & TraceIdKeys.MAX_LENGTH) != 0 ? 10000 : i12;
        int i19 = (i15 & 256) != 0 ? 10000 : i13;
        int i20 = (i15 & VadSessionManager.FRAME_BYTES) == 0 ? i14 : 10000;
        boolean z10 = (i15 & 1024) != 0 ? true : z;
        boolean z11 = (i15 & 2048) == 0 ? z3 : true;
        stepos.support.v7.app.palette.b bVar2 = (i15 & 4096) != 0 ? new stepos.support.v7.app.palette.b(6) : bVar;
        kotlin.jvm.internal.g.f(timeUnit, "timeUnit");
        kotlin.jvm.internal.g.f(taskRunner, "taskRunner");
        kotlin.jvm.internal.g.f(connectionListener, "connectionListener");
        final dd.e eVar2 = taskRunner;
        final int i21 = i16;
        final stepos.support.v7.app.palette.b bVar3 = bVar2;
        final int i22 = i20;
        final int i23 = i17;
        final int i24 = i18;
        final int i25 = i19;
        final boolean z12 = z10;
        final boolean z13 = z11;
        this.f10963a = new okhttp3.internal.connection.e(eVar2, 5, 5L, timeUnit, connectionListener, new q<okhttp3.internal.connection.e, a, ed.c, ed.e>() { // from class: okhttp3.ConnectionPool$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // zb.q
            public final ed.e invoke(okhttp3.internal.connection.e eVar3, a aVar, ed.c cVar) {
                okhttp3.internal.connection.e pool = eVar3;
                a address = aVar;
                ed.c user = cVar;
                kotlin.jvm.internal.g.f(pool, "pool");
                kotlin.jvm.internal.g.f(address, "address");
                kotlin.jvm.internal.g.f(user, "user");
                boolean z14 = z13;
                stepos.support.v7.app.palette.b bVar4 = bVar3;
                dd.e eVar4 = eVar2;
                return new okhttp3.internal.connection.b(new okhttp3.internal.connection.c(new okhttp3.internal.connection.f(eVar4, pool, i21, i23, i24, i25, i22, z12, z14, address, bVar4, user)), eVar4);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d() {
        this(dd.e.f8479l, ad.e.f75a, 0, 0, 0, 0, 0, false, false, null, 8160);
        TimeUnit timeUnit = TimeUnit.MINUTES;
        kotlin.jvm.internal.g.f(timeUnit, "timeUnit");
    }
}
