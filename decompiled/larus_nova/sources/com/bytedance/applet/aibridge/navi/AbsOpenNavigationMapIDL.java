package com.bytedance.applet.aibridge.navi;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.google.gson.JsonArray;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/AbsOpenNavigationMapIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/navi/AbsOpenNavigationMapIDL$OpenNavigationMapParam;", "Lcom/bytedance/applet/aibridge/navi/AbsOpenNavigationMapIDL$OpenNavigationMapResult;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "OpenNavigationMapParam", "OpenNavigationMapResult", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsOpenNavigationMapIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f191218a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "appName", required = false)
        String getAppName();

        @AIBridgeParamField(keyPath = "backupApp", required = false)
        String getBackupApp();

        @AIBridgeParamField(keyPath = "dPoiId", required = false)
        String getDPoiId();

        @AIBridgeParamField(keyPath = "dPoiIdType", required = false)
        String getDPoiIdType();

        @AIBridgeParamField(keyPath = com.bytedance.android.ec.core.event.a.KEY_DESTINATION, required = false)
        String getDestination();

        @AIBridgeParamField(keyPath = "dialogAppList", required = false)
        JsonArray getDialogAppList();

        @AIBridgeParamField(keyPath = "dlat", required = true)
        Double getDlat();

        @AIBridgeParamField(keyPath = "dlon", required = true)
        Double getDlon();

        @AIBridgeParamField(keyPath = "olat", required = false)
        Double getOlat();

        @AIBridgeParamField(keyPath = "olon", required = false)
        Double getOlon();

        @AIBridgeParamField(keyPath = PlayerResolution.SDKKEY.ORIGIN, required = false)
        String getOrigin();

        @AIBridgeParamField(keyPath = "routeMode", required = false)
        String getRouteMode();

        @AIBridgeParamField(keyPath = "routePreference", required = false)
        String getRoutePreference();

        @AIBridgeParamField(keyPath = "showDialog", required = false)
        Boolean getShowDialog();

        @AIBridgeParamField(keyPath = "startNaviDirectly", required = false)
        Boolean getStartNaviDirectly();

        @AIBridgeParamField(keyPath = "traceContext", required = false)
        yv3.b getTraceContext();

        @AIBridgeParamField(keyPath = "transitStrategy", required = false)
        Integer getTransitStrategy();

        @AIBridgeParamField(keyPath = "type", required = true)
        String getType();

        @AIBridgeParamField(keyPath = "waypoints", required = false)
        JsonArray getWaypoints();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "appName", required = false)
        void setAppName(String r100);

        @AIBridgeParamField(keyPath = "availableApps", required = true)
        void setAvailableApps(String r100);

        @AIBridgeParamField(keyPath = "isBackground", required = true)
        void setBackground(int r100);

        @AIBridgeParamField(keyPath = "result", required = true)
        void setResult(int r100);

        @AIBridgeParamField(keyPath = "selectedApp", required = false)
        void setSelectedApp(String r100);
    }

    public AbsOpenNavigationMapIDL() {
        this.f191218a = "doubao.openNavigationMap";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f191218a;
    }
}
