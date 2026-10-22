package com.bytedance.applet.aibridge.share;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/share/AbsShowSharePanelMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/share/AbsShowSharePanelMethodIDL$ShowSharePanelMethodParamModel;", "Lcom/bytedance/applet/aibridge/share/AbsShowSharePanelMethodIDL$ShowSharePanelMethodResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "ShowSharePanelMethodParamModel", "ShowSharePanelMethodResultModel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsShowSharePanelMethodIDL extends CoreAIBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f191417a;

    public static final class a {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = "episode_id", required = false)
        String getEpisodeId();

        @AIBridgeParamField(keyPath = "scene", required = false)
        String getScene();

        @AIBridgeParamField(keyPath = com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, required = false)
        String getShareContent();

        @AIBridgeParamField(keyPath = "share_cover_url", required = false)
        String getShareCoverUrl();

        @AIBridgeParamField(keyPath = "share_link_url", required = false)
        String getShareLinkUrl();

        @AIBridgeParamField(keyPath = "share_title", required = false)
        String getShareTitle();

        @AIBridgeParamField(keyPath = "track_info", required = false)
        JSONObject getTrackInfo();
    }

    @AIBridgeResultModel
    public interface c extends ResultModel {
        @AIBridgeParamField(keyPath = "code", required = true)
        void setCode(int r100);

        @AIBridgeParamField(keyPath = "error_msg", required = false)
        void setErrorMsg(String r100);
    }

    static {
    }

    public AbsShowSharePanelMethodIDL() {
        this.f191417a = "flow.showSharePanel";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f191417a;
    }
}
