package com.bytedance.android.livesdk.provideservices;

import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.api.IWidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements IWidgetService {
    public a() {
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public final void aLogI(String r100, String r101) {
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public final boolean enableFrameLoad() {
        return false;
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public final float getFrameRatio() {
        return 0.0f;
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public final String getRoomScene(Widget r100) {
        return null;
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public final String getRoomScene(Map<String, Object> r100) {
        return null;
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public final String getUserType(boolean r100) {
        return null;
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public final boolean isNewPriority() {
        return false;
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public final void sendLog(String r100, Map<String, String> r101, Object... r102) {
    }

    @Override // com.bytedance.ies.sdk.widgets.api.IWidgetService
    public final Map<String, String> getLogCommonParams(Map<String, WidgetCostModule> r100) {
        return Collections.emptyMap();
    }
}
