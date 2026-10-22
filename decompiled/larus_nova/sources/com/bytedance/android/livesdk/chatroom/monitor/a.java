package com.bytedance.android.livesdk.chatroom.monitor;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f106995a = 0;

    @JvmStatic
    public static final e a() {
        if (LiveInfraSettingKeys.LIVE_ACTIVIY_TIME_MONITOR_SWITCH.getValue().booleanValue() == true) goto L5;
        return null;
    L5:
        return new e();
    }

    static {
    }
}
