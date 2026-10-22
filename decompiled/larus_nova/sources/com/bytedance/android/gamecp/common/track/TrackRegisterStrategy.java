package com.bytedance.android.gamecp.common.track;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/common/track/TrackRegisterStrategy;", "", "", "getAutoReportStrategy", "", "", "getClickTempExtraAttrs", "getShowExtraAttrs", "getDurationTempExtraAttrs", "", "getViewAppearRectLimit", "Lyu/a;", "getGPTrackShowConfig", "", "enableViewEffectiveDetachCheck", "enablePageAutoRouteData", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class TrackRegisterStrategy {
    public TrackRegisterStrategy() {
    }

    public boolean enablePageAutoRouteData() {
        return false;
    }

    public boolean enableViewEffectiveDetachCheck() {
        return false;
    }

    public int getAutoReportStrategy() {
        return 0;
    }

    public yu.a getGPTrackShowConfig() {
        return null;
    }

    public float getViewAppearRectLimit() {
        return 0.5f;
    }

    public Map<String, Object> getClickTempExtraAttrs() {
        return new HashMap();
    }

    public Map<String, Object> getDurationTempExtraAttrs() {
        return new HashMap();
    }

    public Map<String, Object> getShowExtraAttrs() {
        return new HashMap();
    }
}
