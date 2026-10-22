package com.bytedance.android.live.revlink.impl.settings.live.model;

import com.bytedance.revenue.platform.api.core.c;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import w41.e;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b#\u0010$R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001a\u0010\u001e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000bR\u001a\u0010 \u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000bR\u001a\u0010\"\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevlinkAudioAbnormalCheckOptConfigSerializableObjectImpl;", "Lw41/e;", "", "enable", "Z", "getEnable", "()Z", "", "abnormalAudioReviewCheckWindow", "I", "O", "()I", "abnormalAudioReviewThreshold", "L", "diagnosisLoopCallbackTime", "E5", "diagnosisDuration", "N6", "", "", "noVolumeStrList", "Ljava/util/List;", "R", "()Ljava/util/List;", "volumeLowStrList", "r", "excludeStrList", "P", "experienceAbnormalReasonEnable", "getExperienceAbnormalReasonEnable", "toastGapDuration", "getToastGapDuration", "sameToastGapDuration", "getSameToastGapDuration", "activeDetectAbnormalReasonEnable", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevlinkAudioAbnormalCheckOptConfigSerializableObjectImpl implements e {

    @SerializedName("abnormal_audio_review_check_window")
    private final int abnormalAudioReviewCheckWindow;

    @SerializedName("abnormal_audio_review_threshold")
    private final int abnormalAudioReviewThreshold;

    @SerializedName("active_detect_abnormal_reason_enable")
    private final boolean activeDetectAbnormalReasonEnable;

    @SerializedName("diagnosis_duration")
    private final int diagnosisDuration;

    @SerializedName("diagnosis_loop_callback_time")
    private final int diagnosisLoopCallbackTime;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("exclude_str_list")
    private final List<String> excludeStrList;

    @SerializedName("experience_abnormal_reason_enable")
    private final boolean experienceAbnormalReasonEnable;

    @SerializedName("no_volume_str_list")
    private final List<String> noVolumeStrList;

    @SerializedName("same_toast_gap_duration")
    private final int sameToastGapDuration;

    @SerializedName("toast_gap_duration")
    private final int toastGapDuration;

    @SerializedName("volume_low_str_list")
    private final List<String> volumeLowStrList;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevlinkAudioAbnormalCheckOptConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevlinkAudioAbnormalCheckOptConfigSerializableObjectImpl.class);
        }
    }

    public RevlinkAudioAbnormalCheckOptConfigSerializableObjectImpl() {
        this.enable = false;
        this.abnormalAudioReviewCheckWindow = 5;
        this.abnormalAudioReviewThreshold = 1;
        this.diagnosisLoopCallbackTime = 2;
        this.diagnosisDuration = 6;
        this.noVolumeStrList = c.a(new String[]{"没声音", "听不见", "听不到", "没有声音", "没声", "没有游戏音", "没有游戏声", "没人声", "对面听不到", "没有人声"});
        this.volumeLowStrList = c.a(new String[]{"听不清", "听不太清", "声太小", "声音太小", "声非常小", "声音非常小", "声音小", "声小", "声音特别小", "声特别小"});
        this.excludeStrList = c.a(new String[]{"没有声音的烟火", "空谷回声", "没声没息", "没声卡", "好声音小", "小声", "声音小点", "小点声", "卡麦酱", "没杂音", "没有杂音", "装听不见", "装听不到", "解决的声音问题", "解决声音问题", "吐字不清晰", "退出重进", "对上", "没延迟", "没有延迟", "口号", "不串音", "串音符"});
        this.experienceAbnormalReasonEnable = false;
        this.toastGapDuration = 60;
        this.sameToastGapDuration = 120;
        this.activeDetectAbnormalReasonEnable = false;
    }

    @Override // w41.e
    public final int E5() {
        return this.diagnosisLoopCallbackTime;
    }

    @Override // w41.e
    public final boolean I() {
        return this.activeDetectAbnormalReasonEnable;
    }

    @Override // w41.e
    public final int L() {
        return this.abnormalAudioReviewThreshold;
    }

    @Override // w41.e
    public final int N6() {
        return this.diagnosisDuration;
    }

    @Override // w41.e
    public final int O() {
        return this.abnormalAudioReviewCheckWindow;
    }

    @Override // w41.e
    public final List<String> P() {
        return this.excludeStrList;
    }

    @Override // w41.e
    public final List<String> R() {
        return this.noVolumeStrList;
    }

    @Override // w41.e
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // w41.e
    public final List<String> r() {
        return this.volumeLowStrList;
    }
}
