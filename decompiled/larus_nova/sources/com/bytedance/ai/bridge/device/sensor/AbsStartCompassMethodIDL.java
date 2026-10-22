package com.bytedance.ai.bridge.device.sensor;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/device/sensor/AbsStartCompassMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartCompassMethodIDL$SensorStartParamModel;", "Lcom/bytedance/ai/bridge/device/sensor/AbsStartCompassMethodIDL$EmptyMessageModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "SensorStartParamModel", "EmptyMessageModel", "SensorInterval", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsStartCompassMethodIDL extends CoreAIBridgeMethod<b, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35287a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/device/sensor/AbsStartCompassMethodIDL$SensorInterval;", "", "<init>", "(Ljava/lang/String;I)V", "GAME", "UI", EffectConstants.NORMAL, "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SensorInterval extends Enum<SensorInterval> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ SensorInterval[] $VALUES = null;

        @SerializedName("game")
        public static final SensorInterval GAME = null;

        @SerializedName("normal")
        public static final SensorInterval NORMAL = null;

        @SerializedName("ui")
        public static final SensorInterval UI = null;

        private static final /* synthetic */ SensorInterval[] $values() {
            return new SensorInterval[]{GAME, UI, NORMAL};
        }

        public static EnumEntries<SensorInterval> getEntries() {
            return $ENTRIES;
        }

        static {
            GAME = new SensorInterval("GAME", 0);
            UI = new SensorInterval("UI", 1);
            NORMAL = new SensorInterval(EffectConstants.NORMAL, 2);
            SensorInterval[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static SensorInterval[] values() {
            return (SensorInterval[]) $VALUES.clone();
        }

        public static SensorInterval valueOf(String r100) {
            return (SensorInterval) r27.a.a(SensorInterval.class, r100);
        }

        private SensorInterval(String r100, int r101) {
            super(r100, r101);
        }
    }

    @AIBridgeResultModel
    public interface a extends ResultModel {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = VideoThumbInfo.KEY_INTERVAL, required = false)
        SensorInterval getInterval();
    }

    public AbsStartCompassMethodIDL() {
        this.f35287a = "doubao.startCompass";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35287a;
    }
}
