package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.v2;

/* JADX INFO: loaded from: classes47.dex */
public final class a0 {
    public static final int a(IBaseBattleSetting r100) {
        if (r100 == null) goto L8;
        IBattleConfigSetting r101 = r100.getBattleConfigSetting();
        if (r101 == null) goto L8;
        v2 r102 = r101.getSelfSettingRate();
        if (r102 == null) goto L8;
        return (int) r102.getPkVIPRate();
    L8:
        return 0;
    }
}
