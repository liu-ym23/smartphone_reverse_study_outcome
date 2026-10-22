package com.bytedance.android.live.recharge.nopassword;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.w;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.recharge.util.SendGiftNoBalanceScene;
import com.bytedance.android.live.recharge.utils.t;
import com.bytedance.android.live.revenue.common.s;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class g {
    public static final boolean b() {
        int r100 = w.f66424a;
        if (v.a() == true) goto L5;
    L7:
        p11.h r101 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getPkService();
        if (r101.d() == RevPkState.PK) goto L10;
    L12:
        return false;
    L10:
        if (r101.isInBreakThrough() == true) goto L12;
        return true;
    L5:
        if (((Boolean) t.f90517n.getValue(null, t.f90504a[12])).booleanValue() == false) goto L7;
        return true;
    }

    public static final boolean a(com.bytedance.android.live.recharge.model.d r100) {
        if (r100 == null) goto L11;
        com.bytedance.android.live.recharge.model.b r101 = r100.f90021j;
        if (r101 == null) goto L11;
        com.bytedance.android.live.recharge.model.a r102 = r101.f90009g;
        if (r102 == null) goto L11;
        s r103 = r102.f90000a;
        KProperty r104 = com.bytedance.android.live.recharge.model.a.f89999d[0];
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "thisRef");
        Intrinsics.checkNotNullParameter(r104, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Object r105 = r102.get(r103.f90992a);
        if (r105 != null) goto L10;
        r105 = r103.f90993b.invoke();
    L10:
        String r106 = (String) r105;
    L13:
        return Intrinsics.areEqual(r106, SendGiftNoBalanceScene.FANS_CLUB_LIGHT_BOARD.getSceneName());
    L11:
        r106 = null;
        goto L13
    }

    public static final boolean c(com.bytedance.android.live.recharge.model.d r100) {
        if (r100 == null) goto L4;
        String r101 = r100.f90013b;
    L6:
        return Intrinsics.areEqual(r101, NoPasswordScene.SCENE_FANS_CLUB_JOIN.getValue());
    L4:
        r101 = null;
        goto L6
    }
}
