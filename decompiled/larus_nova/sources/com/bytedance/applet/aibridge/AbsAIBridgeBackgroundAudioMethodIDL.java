package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/AbsAIBridgeBackgroundAudioMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeBackgroundAudioMethodIDL$BackgroundAudioParamModel;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeBackgroundAudioMethodIDL$BackgroundAudioResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "BackgroundAudioParamModel", "BackgroundAudioResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsAIBridgeBackgroundAudioMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f190842a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "action", required = false)
        String getAction();

        @AIBridgeParamField(keyPath = "position", required = false)
        Double getPosition();

        @AIBridgeParamField(keyPath = "state", required = false)
        JSONObject getState();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = IFlowAppIntentIDL.PARAM_APPLET_ID, required = false)
        void setAppletId(String r100);

        @AIBridgeParamField(keyPath = "buffered", required = false)
        void setBuffered(Double r100);

        @AIBridgeParamField(keyPath = "coverImgUrl", required = false)
        void setCoverImgUrl(String r100);

        @AIBridgeParamField(keyPath = "currentTime", required = false)
        void setCurrentTime(Double r100);

        @AIBridgeParamField(keyPath = "duration", required = false)
        void setDuration(Double r100);

        @AIBridgeParamField(keyPath = "epname", required = false)
        void setEpname(String r100);

        @AIBridgeParamField(keyPath = "errCode", required = false)
        void setErrCode(Integer r100);

        @AIBridgeParamField(keyPath = "errMsg", required = false)
        void setErrMsg(String r100);

        @AIBridgeParamField(keyPath = "paused", required = false)
        void setPaused(Boolean r100);

        @AIBridgeParamField(keyPath = "playbackRate", required = false)
        void setPlaybackRate(Double r100);

        @AIBridgeParamField(keyPath = "singer", required = false)
        void setSinger(String r100);

        @AIBridgeParamField(keyPath = "src", required = false)
        void setSrc(String r100);

        @AIBridgeParamField(keyPath = DyPayConstant.KEY_START_TIME, required = false)
        void setStartTime(Double r100);

        @AIBridgeParamField(keyPath = "title", required = false)
        void setTitle(String r100);

        @AIBridgeParamField(keyPath = NativeDownloadModel.JsonKey.WEB_URL, required = false)
        void setWebUrl(String r100);
    }

    public AbsAIBridgeBackgroundAudioMethodIDL() {
        this.f190842a = "doubao.getBackgroundAudioManager";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f190842a;
    }
}
