package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void a(String r100, HashMap<String, String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "logMap");
        Intrinsics.checkNotNullParameter(r102, "eventPage");
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r102);
        if (Intrinsics.areEqual(r102, "live_take_page") == false) goto L5;
        r101.put("anchor_id", ((IUserService) jc1.k.n(IUserService.class)).user().n());
        r101.put("room_id", "");
        u.l().sendLog(r100, r101, new Object[0]);
        return;
    L5:
        u.l().sendLog(r100, r101, new Object[]{Room.class});
    }
}
