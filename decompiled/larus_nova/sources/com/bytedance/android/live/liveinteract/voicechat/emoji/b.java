package com.bytedance.android.live.liveinteract.voicechat.emoji;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f80166a = 0;

    static {
    }

    public static void a(boolean r100, int r101) {
        if (r100 == false) goto L5;
        ALogger.e("interact_emoji", "stop self emoji of fromPos " + r101);
    L7:
        if (hd0.c.f().g() == false) goto L9;
        return;
    L9:
        int r102 = x.f77572a;
        LinkedHashMap r103 = new LinkedHashMap();
        if (r100 == false) goto L12;
        String r104 = "from_seat";
    L13:
        r103.put("seat_type", r104);
        r103.put(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, Integer.valueOf(r101));
        x.v0("stop_seat_emoji", r103);
        return;
    L12:
        r104 = "to_seat";
        goto L13
    L5:
        ALogger.e("interact_emoji", "stop self emoji of toPos " + r101);
        goto L7
    }
}
