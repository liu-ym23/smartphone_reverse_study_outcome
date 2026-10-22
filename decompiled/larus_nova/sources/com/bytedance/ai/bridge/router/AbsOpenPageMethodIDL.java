package com.bytedance.ai.bridge.router;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/router/AbsOpenPageMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/router/AbsOpenPageMethodIDL$OpenPageRequestModel;", "Lcom/bytedance/ai/bridge/router/AbsOpenPageMethodIDL$EmptyMessageModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "OpenPageRequestModel", "EmptyMessageModel", "OpenPageMode", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsOpenPageMethodIDL extends CoreAIBridgeMethod<b, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36092a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/router/AbsOpenPageMethodIDL$OpenPageMode;", "", "<init>", "(Ljava/lang/String;I)V", FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, "REPLACE", "NAVIGATE", "POP_TO", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum OpenPageMode extends Enum<OpenPageMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ OpenPageMode[] $VALUES = null;

        @SerializedName(MusicAppletPage.ROUTE_MODE_NAVIGATION)
        public static final OpenPageMode NAVIGATE = null;

        @SerializedName("pop_to")
        public static final OpenPageMode POP_TO = null;

        @SerializedName("push")
        public static final OpenPageMode PUSH = null;

        @SerializedName("replace")
        public static final OpenPageMode REPLACE = null;

        private static final /* synthetic */ OpenPageMode[] $values() {
            return new OpenPageMode[]{PUSH, REPLACE, NAVIGATE, POP_TO};
        }

        public static EnumEntries<OpenPageMode> getEntries() {
            return $ENTRIES;
        }

        static {
            PUSH = new OpenPageMode(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 0);
            REPLACE = new OpenPageMode("REPLACE", 1);
            NAVIGATE = new OpenPageMode("NAVIGATE", 2);
            POP_TO = new OpenPageMode("POP_TO", 3);
            OpenPageMode[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static OpenPageMode[] values() {
            return (OpenPageMode[]) $VALUES.clone();
        }

        public static OpenPageMode valueOf(String r100) {
            return (OpenPageMode) r27.a.a(OpenPageMode.class, r100);
        }

        private OpenPageMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @AIBridgeResultModel
    public interface a extends ResultModel {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = "mode", required = false)
        OpenPageMode getMode();

        @AIBridgeParamField(keyPath = "url", required = true)
        String getUrl();
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsOpenPageMethodIDL() {
        this.f36092a = "doubao.openPage";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f36092a;
    }
}
