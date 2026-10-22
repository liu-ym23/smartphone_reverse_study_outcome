package com.bytedance.android.livesdk.gift.platform.business.tray2.manager.dispatcher;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static final void b(List r100, NormalGiftMessage r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("sender_user_id", r101.getFromUserId());
        r102.put("send_time", Long.valueOf(r101.G));
        IBaseUser r103 = r101.f129775e;
        String r104 = "";
        if (r103 == null) goto L18;
        k r105 = r103.getAvatarThumbKt();
        if (r105 == null) goto L18;
        List<String> r106 = r105.getUrls();
        if (r106 == null) goto L18;
        if (r106.size() <= 0) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == true) goto L15;
        r106 = null;
    L15:
        if (r106 == null) goto L18;
        String r108 = (String) ListProtector.get(r106, 0);
        if (r108 == null) goto L18;
    L19:
        r102.put("sender_avatar", r108);
        IBaseUser r109 = r101.f129775e;
        if (r109 == null) goto L24;
        String r110 = r109.getNickName();
        if (r110 == null) goto L24;
        r104 = r110;
    L24:
        r102.put("sender_name", r104);
        ((ArrayList) r100).add(r102);
        return;
    L11:
        r107 = false;
    L18:
        r108 = "";
        goto L19
    }

    public static final void a(Map r100, long r101, int r102, long r103) {
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r101));
        r104.put("money", Integer.valueOf(r102));
        r100.put(String.valueOf(r103), r104);
    }
}
