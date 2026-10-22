package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/location/AbsGetLocationMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/system/location/AbsGetLocationMethodIDL$GetLocationParamModel;", "Lcom/bytedance/ai/bridge/method/system/location/AbsGetLocationMethodIDL$GetLocationResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "altNames", "", "getAltNames", "()Ljava/util/List;", "GetLocationParamModel", "GetLocationResultModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetLocationMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f35983b;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "acceptLightLocation", required = false)
        Boolean getAcceptLightLocation();

        @AIBridgeParamField(keyPath = "extra", required = false)
        String getExtra();

        @AIBridgeParamField(keyPath = "maxCacheTimeMs", required = false)
        Long getMaxCacheTimeMs();

        @AIBridgeParamField(keyPath = "mode", required = false)
        Integer getMode();

        @AIBridgeParamField(keyPath = "source", required = false)
        String getSource();

        @AIBridgeParamField(keyPath = "timeoutMs", required = false)
        Long getTimeoutMs();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = LocationMonitorConst.ACCURACY, required = false)
        void setAccuracy(Float r100);

        @AIBridgeParamField(keyPath = "latitude", required = false)
        void setLatitude(Double r100);

        @AIBridgeParamField(keyPath = "isLightLocation", required = false)
        void setLightLocation(Boolean r100);

        @AIBridgeParamField(keyPath = "longitude", required = false)
        void setLongitude(Double r100);

        @AIBridgeParamField(keyPath = "speed", required = false)
        void setSpeed(Float r100);

        @AIBridgeParamField(keyPath = "timestamp", required = false)
        void setTimestamp(String r100);
    }

    public AbsGetLocationMethodIDL() {
        this.f35982a = "flow.getLocation";
        this.f35983b = CollectionsKt.listOf("doubao.getLocation");
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final List<String> getAltNames() {
        return this.f35983b;
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35982a;
    }
}
