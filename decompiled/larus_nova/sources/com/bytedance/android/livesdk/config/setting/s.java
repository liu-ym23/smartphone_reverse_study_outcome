package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f121216a = 0;

    @JvmStatic
    public static final boolean b() {
        return LiveInfraSettingKeys.LIVE_NEW_COMMON_SLOT.getValue().booleanValue();
    }

    @JvmStatic
    public static final boolean a() {
        return !b();
    }

    static {
    }
}
