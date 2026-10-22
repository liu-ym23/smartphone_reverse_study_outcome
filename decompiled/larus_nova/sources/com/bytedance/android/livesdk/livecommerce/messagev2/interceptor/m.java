package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectInfo;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectPriority;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class m extends a {
    public m() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r100, boolean r101) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if ((r110 instanceof si2.x) == true) goto L6;
        return false;
    L6:
        Context r100 = getContext();
        si2.x r101 = (si2.x) r110;
        LiveRoomRedirectInfo.a r102 = LiveRoomRedirectInfo.f151920f;
        String r103 = r101.routeRule;
        r102.getClass();
        Map r104 = LiveRoomRedirectInfo.a.a(r103);
        if (r104 != null) goto L10;
        com.bytedance.android.livesdk.livecommerce.ability.f r105 = null;
    L9:
        com.bytedance.android.livesdk.livecommerce.ability.f r106 = r105;
        if (r100 == null) goto L20;
        if (r106 == null) goto L21;
        RoomContextController r107 = (RoomContextController) b(RoomContextController.class, r110);
        Lazy r111 = LiveDynamicContext.f147714c;
        com.bytedance.android.livesdk.livecommerce.ability.b.a.a(LiveDynamicContext.a.a().a(), r100, r106, r107, null, null, 24);
        return true;
    L21:
        return true;
    L20:
        return true;
    L10:
        sg2.b r108 = r101.getCommon();
        if (r108 == null) goto L13;
        long r109 = r108.f541772c;
    L14:
        String r112 = r101.routeRule;
        LiveRoomRedirectPriority r113 = LiveRoomRedirectPriority.LIVE_HIGH_HEAT_MESSAGE;
        r105 = new com.bytedance.android.livesdk.livecommerce.ability.f("LiveBase", "redirect_api_path", new LiveRoomRedirectInfo(r112, r104, r113, r109));
        goto L9
    L13:
        r109 = 0;
        goto L14
    }
}
