package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.gu;
import com.bytedance.android.livesdk.config.hu;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.EnterRoomFrameworkConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/setting/RoomContainerConfig;", "", "()V", "detailConfig", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/EnterRoomFrameworkConfig;", "enable", "", "enableNewActivity", "enableNewContainer", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomContainerConfig {
    public static final RoomContainerConfig INSTANCE = null;
    private static final EnterRoomFrameworkConfig detailConfig = null;
    private static final boolean enable = false;

    private RoomContainerConfig() {
    }

    static {
        INSTANCE = new RoomContainerConfig();
        detailConfig = gu.f120314a.getValue();
        enable = hu.f120404a.getValue().booleanValue();
    }

    public final boolean enableNewActivity() {
        if (enable == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        ALogger.i("RoomContainerConfig", "enableNewActivity: " + r100);
        return r100;
    L5:
        if (detailConfig.getUseNewActivity() == false) goto L7;
        r100 = true;
        goto L8
    }

    public final boolean enableNewContainer() {
        if (enable == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        ALogger.i("RoomContainerConfig", "enableNewContainer: " + r100);
        return r100;
    L5:
        if (detailConfig.getUseNewContainer() == false) goto L7;
        r100 = true;
        goto L8
    }
}
