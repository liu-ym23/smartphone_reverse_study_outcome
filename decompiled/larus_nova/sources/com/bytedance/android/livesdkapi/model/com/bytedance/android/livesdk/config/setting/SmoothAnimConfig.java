package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdk.config.vs0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/setting/SmoothAnimConfig;", "", "()V", "detailConfig", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/setting/SmoothAnimSetting;", "getDuration", "", "isCanSmoothEnterWhitAnim", "", SoloKtvContext.SOLO_PAGE_ENTRANCE, "", "isDelayShowRoom", "isEnable", "isInEntranceList", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SmoothAnimConfig {
    public static final SmoothAnimConfig INSTANCE = null;
    private static final SmoothAnimSetting detailConfig = null;

    private SmoothAnimConfig() {
    }

    static {
        INSTANCE = new SmoothAnimConfig();
        detailConfig = vs0.f121475a.getValue();
    }

    private final boolean isEnable() {
        return detailConfig.getEnable();
    }

    public final long getDuration() {
        Long r100 = detailConfig.getDuration();
        if (r100 != null) goto L7;
        return 450;
    L7:
        return r100.longValue();
    }

    public final boolean isDelayShowRoom() {
        if (isEnable() == true) goto L5;
    L7:
        return false;
    L5:
        if (detailConfig.isDelayShowRoom() == false) goto L7;
        return true;
    }

    private final boolean isInEntranceList(String r100) {
        if (detailConfig.getEntranceList().contains(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "h5_xtab_homepage") == true) goto L8;
        return false;
    }

    public final boolean isCanSmoothEnterWhitAnim(String r100) {
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        if (isEnable() == true) goto L5;
    L7:
        return false;
    L5:
        if (isInEntranceList(r100) == false) goto L7;
        return true;
    }
}
