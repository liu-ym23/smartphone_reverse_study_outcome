package com.bytedance.ai.bridge.openApp;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppRequestModel;", "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "OpenAppRequestModel", "OpenAppResultModel", "OpenAppStatus", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsOpenAppMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36053a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DEEP_LINK", "MARKET", "BROWSER", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum OpenAppStatus extends Enum<OpenAppStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ OpenAppStatus[] $VALUES = null;

        @SerializedName("browser")
        public static final OpenAppStatus BROWSER = null;

        @SerializedName(ComplianceResult.JsonKey.MARKET_DEEP_LINK)
        public static final OpenAppStatus DEEP_LINK = null;

        @SerializedName("market")
        public static final OpenAppStatus MARKET = null;

        private static final /* synthetic */ OpenAppStatus[] $values() {
            return new OpenAppStatus[]{DEEP_LINK, MARKET, BROWSER};
        }

        public static EnumEntries<OpenAppStatus> getEntries() {
            return $ENTRIES;
        }

        static {
            DEEP_LINK = new OpenAppStatus("DEEP_LINK", 0);
            MARKET = new OpenAppStatus("MARKET", 1);
            BROWSER = new OpenAppStatus("BROWSER", 2);
            OpenAppStatus[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static OpenAppStatus[] values() {
            return (OpenAppStatus[]) $VALUES.clone();
        }

        public static OpenAppStatus valueOf(String r100) {
            return (OpenAppStatus) r27.a.a(OpenAppStatus.class, r100);
        }

        private OpenAppStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "fallbackUrl", required = false)
        String getFallbackUrl();

        @AIBridgeParamField(keyPath = "targetPackage", required = false)
        String getTargetPackage();

        @AIBridgeParamField(keyPath = "uri", required = true)
        String getUri();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "message", required = false)
        void setMessage(String r100);

        @AIBridgeParamField(keyPath = "status", required = true)
        void setStatus(OpenAppStatus r100);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsOpenAppMethodIDL() {
        this.f36053a = "applet.openApp";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f36053a;
    }
}
