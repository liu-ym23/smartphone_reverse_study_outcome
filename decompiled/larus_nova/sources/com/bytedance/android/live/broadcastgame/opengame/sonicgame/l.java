package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.scoreboard.EventName;
import com.bytedance.android.live.profit.scoreboard.o;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l implements com.bytedance.android.live.profit.scoreboard.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f61073a;

    public l(k r100) {
        this.f61073a = r100;
    }

    public final void b(CompositeDisposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        RxUtilKt.c(r100, this.f61073a.f61069b);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.d
    public final void a(EventName r100, o r110) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r110, "message");
        int r101 = q.f60744a;
        boolean r102 = true;
        q.f("OpenAPI", new Object[]{"on score counting event message = " + r110});
        int r103 = j.f61067a[r100.ordinal()];
        if (r103 != 1) goto L5;
        MainThreadPostUtils.d(this.f61073a.f61070c);
        k.a(this.f61073a, 1, r110);
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r104 = AudienceGameContext.a.a();
        if (r104 == null) goto L36;
        m<Boolean> r105 = r104.getDisableEntrance();
        if (r105 == null) goto L36;
        Boolean r106 = r105.getValue();
        if (r106 == null) goto L36;
        boolean r107 = r106.booleanValue();
    L37:
        if (r107 == false) goto L40;
        q.f("OpenAPI", new Object[]{"ON_ROUND_MESSAGE_START abort by EnterRoomMessageReceiver.disableEntrance"});
        return;
    L40:
        boolean r108 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.scoreboard.h) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class)).k2(this.f61073a.f61071d.f60809m.f61083i);
        return;
    L36:
        r107 = false;
        goto L37
    L5:
        if (r103 == 2) goto L11;
        if (r103 == 3) goto L9;
        System.out.println();
        return;
    L9:
        k.a(this.f61073a, 3, r110);
        return;
    L11:
        if (r110.b() != (-1)) goto L14;
        return;
    L14:
        if (this.f61073a.f61071d.f60811o == true) goto L16;
    L28:
        k.a(this.f61073a, 2, r110);
        return;
    L16:
        if ((!r110.c().isEmpty()) == false) goto L25;
        Iterator<com.bytedance.android.live.profit.scoreboard.m> r109 = r110.c().iterator();
    L19:
        if (r109.hasNext() == false) goto L25;
        com.bytedance.android.live.profit.scoreboard.m r111 = r109.next();
        if (r111.a() == true) goto L19;
        if (CastLongProtector.parseLong(r111.b()) != this.f61073a.f61071d.f60809m.f61075a) goto L19;
    L26:
        if (r102 == false) goto L28;
        MainThreadPostUtils.c(this.f61073a.f61070c, ((long) r110.b()) * 1000);
    L25:
        r102 = false;
        goto L26
    }
}
