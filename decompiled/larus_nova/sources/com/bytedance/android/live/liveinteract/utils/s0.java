package com.bytedance.android.live.liveinteract.utils;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class s0 {

    public static final class a implements lm3.c.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f78827b;

        public a(Function0 r100) {
            this.f78827b = r100;
        }

        @Override // lm3.c.a
        public final void onAction(lm3.d r100) {
            this.f78827b.invoke();
        }
    }

    public static final void a(Context r100, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "onNext");
        IInteractService r101 = (IInteractService) jc1.k.f(IInteractService.class);
        String r102 = null;
        if (r101 == null) goto L7;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r103 = r101.getLinkUserInfoCenter();
        if (r103 == null) goto L7;
        Iterable r104 = r103.getOnlineUserList();
    L8:
        if (r104 == null) goto L17;
        Iterator r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L15;
        Object r106 = r105.next();
        if (com.bytedance.android.live.liveinteract.plantform.a.a((ILinkPlayerInfoBridge) r106) == false) goto L11;
    L16:
        ILinkPlayerInfoBridge r107 = (ILinkPlayerInfoBridge) r106;
    L19:
        if (r107 == null) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L24;
        r110.invoke();
        return;
    L24:
        if (((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().c() == false) goto L27;
        f2.b(R.string.ttlive_live_ai_guest_admin_toast, 0);
        return;
    L27:
        lm3.d.a r109 = new lm3.d.a(r100);
        r109.f509870a = r100.getString(R.string.ttlive_live_ai_guest_alert_title);
        r109.f509871b = r100.getString(R.string.ttlive_live_ai_guest_alert_text);
        lm3.c r111 = new lm3.c();
        r111.f509864b = r100.getString(R.string.ttlive_live_ai_guest_alert_cancel);
        r111.f509865c = lm3.c.a.f509867a;
        Unit r112 = Unit.INSTANCE;
        lm3.c r113 = new lm3.c();
        r113.f509864b = r100.getString(R.string.ttlive_live_ai_guest_alert_confirm);
        r113.f509865c = new a(r110);
        r109.f509874e = CollectionsKt.listOf(new lm3.c[]{r111, r113});
        r109.a();
        IInteractService r114 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r114 != null) goto L30;
        return;
    L30:
        if (r114.getTalkRoomLogUtils() == null) goto L45;
        if (r107 == null) goto L35;
        IBaseUser r115 = r107.getUser();
        if (r115 == null) goto L35;
        r102 = r115.getIdString();
    L35:
        Intrinsics.checkNotNullParameter("connection_tips", "popupType");
        if (r102 == null) goto L47;
        HashMap r116 = new HashMap();
        r116.put("popup_type", "connection_tips");
        r116.put("AI_guest_id", r102);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_AI_connection_invite_show", r116, new Object[]{am2.x.class, IRoom.class});
        return;
    L47:
        return;
    L45:
        return;
    L21:
        r108 = false;
        goto L22
    L15:
        r106 = null;
        goto L16
    L17:
        r107 = null;
    L7:
        r104 = null;
        goto L8
    }
}
