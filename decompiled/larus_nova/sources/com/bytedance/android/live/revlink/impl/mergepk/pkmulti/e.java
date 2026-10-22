package com.bytedance.android.live.revlink.impl.mergepk.pkmulti;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.v2;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public static final boolean a(IBattleConfigSetting r100) {
        if (r100 == null) goto L13;
        v2 r101 = r100.getSelfSettingRate();
        if (r101 == null) goto L14;
        long r102 = 99;
        long r103 = r101.getPkValueType();
        if (1 <= r103) goto L10;
        return false;
    L10:
        if (r102 < r103) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L13:
        return false;
    }
}
