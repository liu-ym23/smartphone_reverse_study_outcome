package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.apm.impl.protector.RunnableProtector;
import gd0.v;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m.a f77932a;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f77933a;

        public a(f r100) {
            this.f77933a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Object r100) {
            ALogger.i("AdventureLinkService", "leaveMultiLinkRoom, linkPlayerState onChanged: " + ((Integer) r100));
            if (hd0.c.f().h() == true) goto L6;
            ALogger.i("AdventureLinkService", "leaveMultiLinkRoom success");
            MainThreadPostUtils.c(new e(this), ((Number) vm2.d.f555934p7.getValue(null, vm2.d.f555776a[428(0x1ac, float:6.0E-43)])).longValue());
            hd0.c.f().e(g.f77941h);
            g.f77941h = null;
            return;
        }
    }

    public f(m.a r100) {
        this.f77932a = r100;
    }

    public final void a() {
        boolean r100 = hd0.c.f().h();
        StringBuilder r101 = new StringBuilder("leaveMultiLinkRoom, isGuest: ");
        r101.append(r100);
        r101.append(", rtcRoomId: ");
        com.bytedance.live.datacontext.m<IRoom> r102 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r102 == null) goto L7;
        IRoom r103 = r102.getValue();
        if (r103 == null) goto L7;
        Long r104 = Long.valueOf(r103.getRoomId());
    L8:
        r101.append(r104);
        ALogger.i("AdventureLinkService", r101.toString());
        if (r100 == false) goto L20;
        String r105 = ei0.a.f472759a;
        JSONObject r106 = new JSONObject();
        r106.put("adventure_call_user_type", ei0.a.f472759a);
        int r107 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.AdventureCall, "adventure_call_leave_multi_link", 0, null, r106, 88);
        StringCompanionObject r108 = StringCompanionObject.INSTANCE;
        ALogger.d("AdventureFullLinkMonitor", String.format("leaveMultiLink, extra: %s", Arrays.copyOf(new Object[]{r106}, 1)));
        g.f77941h = new a(this);
        hd0.c.f().c(g.f77941h);
        int r109 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (v.a(r109, 32) == false) goto L16;
        rj0.l.f537955n2.getClass();
        rj0.l r110 = rj0.l.a.a();
        if (r110 == null) goto L24;
        rj0.l.b.d(r110, 204, false, false, 8);
        return;
    L24:
        return;
    L16:
        if (v.a(r109, 8) == false) goto L26;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r111 = IVoiceChatGuestService.a.a();
        if (r111 == null) goto L27;
        IVoiceChatGuestService.b.b(r111, 204, false, false, false, 16);
        return;
    L27:
        return;
    L26:
        return;
    L20:
        m.a r112 = this.f77932a;
        if (r112 == null) goto L29;
        r112.a();
        return;
    L29:
        return;
    L7:
        r104 = null;
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
