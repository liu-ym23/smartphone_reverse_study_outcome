package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f65586a = 0;

    static {
    }

    public static boolean a(boolean r100, boolean r101, boolean r102) {
        if (LiveInfraSettingKeys.LIVE_ENABLE_COMPONENTS_SCHEDUER_SYNC_LOAD.getValue().booleanValue() == false) goto L8;
        if (r100 == true) goto L8;
        if (r101 == false) goto L8;
        if (r102 == true) goto L8;
        return true;
    L8:
        return false;
    }
}
