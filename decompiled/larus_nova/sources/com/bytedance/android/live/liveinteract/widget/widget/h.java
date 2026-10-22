package com.bytedance.android.live.liveinteract.widget.widget;

import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f81066a = null;

    static {
        int[] r100 = new int[ILinkmicAudienceSetting.LinkmicSettingStatus.values().length];
        f81066a = r100;
        r100[ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.ordinal()] = 1;
        r100[ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_DELEGATED_TO_EVERYONE.ordinal()] = 2;
        r100[ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.ordinal()] = 3;
    }
}
