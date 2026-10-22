package com.bytedance.ai.bridge.method.system;

import com.alipay.sdk.m.p.e;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.Location;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL$OpenMapAppParamModel;", "Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL$OpenMapAppResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "OpenMapAppParamModel", "OpenMapAppResultModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsOpenMapAppMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35934a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "from", required = false)
        Location getFrom();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = AppletNaviType.DRIVING, type = DefaultType.STRING), keyPath = e.f25671s, required = false)
        String getMethod();

        @AIBridgeParamField(keyPath = RemoteMessageConst.TO, required = true)
        Location getTo();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "mapsAvailable", required = true)
        void setMapsAvailable(List<String> r100);

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), keyPath = "openResult", required = true)
        void setOpenResult(boolean r100);

        @AIBridgeParamField(keyPath = "userAction", required = true)
        void setUserAction(String r100);
    }

    public AbsOpenMapAppMethodIDL() {
        this.f35934a = "applet.openMapApp";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35934a;
    }
}
