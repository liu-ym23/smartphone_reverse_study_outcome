package com.bytedance.android.live.revenue.common;

import android.text.TextUtils;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l0 {
    static {
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "business");
        String r101 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        yz0.k r102 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r102 == null) goto L7;
        IRoom r103 = r102.getRoom();
        if (r103 == null) goto L7;
        String r104 = r103.getOwnerUserIdString();
    L9:
        if (TextUtils.equals(r101, r104) == false) goto L11;
        return false;
    L11:
        a50.a r105 = LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r105 != null) goto L14;
        return false;
    L14:
        switch(r100.hashCode()) {
            case -1482948886: goto L36;
            case -1354491421: goto L29;
            case 3625706: goto L26;
            case 95849015: goto L23;
            case 354670409: goto L20;
            case 498005562: goto L17;
            default: goto L53;
        };
    L53:
        return false;
    L17:
        if (r100.equals("taskCenter") == true) goto L41;
        return false;
    L41:
        return r105.n();
    L20:
        if (r100.equals("lottery") == true) goto L43;
        return false;
    L43:
        return r105.f();
    L23:
        if (r100.equals("dress") == true) goto L45;
        return false;
    L45:
        return r105.c();
    L26:
        if (r100.equals("vote") == true) goto L47;
        return false;
    L47:
        return r105.o();
    L29:
        if (r100.equals("luckybox") == true) goto L31;
        return false;
    L31:
        if (r105.g() == true) goto L33;
        return false;
    L33:
        if (b0.b().b0() != 0) goto L50;
        return true;
    L50:
        return false;
    L36:
        if (r100.equals("groupUser") == true) goto L38;
        return false;
    L38:
        return r105.d();
    L7:
        r104 = null;
        goto L9
    }
}
