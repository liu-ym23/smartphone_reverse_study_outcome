package com.bytedance.android.live.revlink.impl.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import r11.s;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/PkTipStrategySerializableObjectImpl;", "Lr11/s;", "", "followShowInterval", "J", "Y0", "()J", "", VideoThumbInfo.KEY_INTERVAL, "I", "getInterval", "()I", "", "enable", "Z", "getEnable", "()Z", "", "followUpdateTip", "Ljava/lang/String;", "X2", "()Ljava/lang/String;", "restoreTip", "F2", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkTipStrategySerializableObjectImpl implements s {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("follow_show_interval")
    private final long followShowInterval;

    @SerializedName("follow_update_tip")
    private final String followUpdateTip;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final int interval;

    @SerializedName("restore_tip")
    private final String restoreTip;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/PkTipStrategySerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(PkTipStrategySerializableObjectImpl.class);
        }
    }

    public PkTipStrategySerializableObjectImpl() {
        this.followShowInterval = 10000;
        this.interval = BaseConstants.Time.DAY;
        this.enable = false;
        this.followUpdateTip = "";
        this.restoreTip = "";
    }

    @Override // r11.s
    public final String F2() {
        return this.restoreTip;
    }

    @Override // r11.s
    public final String X2() {
        return this.followUpdateTip;
    }

    @Override // r11.s
    public final long Y0() {
        return this.followShowInterval;
    }

    @Override // r11.s
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // r11.s
    public final int getInterval() {
        return this.interval;
    }
}
