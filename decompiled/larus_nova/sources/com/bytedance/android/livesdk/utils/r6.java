package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;

/* JADX INFO: loaded from: classes11.dex */
public final class r6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159155a = 0;

    public static final class a {
        public static boolean a() {
            if (LiveInfraSettingKeys.LIVE_VERTICAL_FASTGIFT_OFFLINE.getValue().booleanValue() == true) goto L5;
        L7:
            return false;
        L5:
            if (LiveInfraSettingKeys.LIVE_REGULAR_FASTGIFT_OFFLINE.getValue().booleanValue() == false) goto L7;
            return true;
        }

        public static boolean b() {
            return LiveInfraSettingKeys.LIVE_REGULAR_FASTGIFT_OFFLINE.getValue().booleanValue();
        }

        public static boolean c() {
            return LiveInfraSettingKeys.LIVE_VERTICAL_FASTGIFT_OFFLINE.getValue().booleanValue();
        }
    }

    static {
    }
}
