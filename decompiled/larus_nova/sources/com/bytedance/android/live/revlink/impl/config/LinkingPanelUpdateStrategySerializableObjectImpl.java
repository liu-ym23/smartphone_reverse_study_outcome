package com.bytedance.android.live.revlink.impl.config;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import r11.j;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LinkingPanelUpdateStrategySerializableObjectImpl;", "Lr11/j;", "", VideoThumbInfo.KEY_INTERVAL, "J", "getInterval", "()J", "", "count", "I", "getCount", "()I", "validInterval", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "validRecCount", "t", "", "enableRecOpt", "Z", "K2", "()Z", "enableOnCLick", "n6", "enable", "getEnable", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkingPanelUpdateStrategySerializableObjectImpl implements j {

    @SerializedName("count")
    private final int count;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_onclick")
    private final boolean enableOnCLick;

    @SerializedName("enable_rec_opt")
    private final boolean enableRecOpt;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final long interval;

    @SerializedName("valid_interval")
    private final long validInterval;

    @SerializedName("valid_rec_count")
    private final int validRecCount;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LinkingPanelUpdateStrategySerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LinkingPanelUpdateStrategySerializableObjectImpl.class);
        }
    }

    public LinkingPanelUpdateStrategySerializableObjectImpl() {
        this.interval = 15000;
        this.count = 3;
        this.validInterval = 15000;
        this.validRecCount = 15;
        this.enableRecOpt = false;
        this.enableOnCLick = false;
        this.enable = false;
    }

    @Override // r11.j
    public final boolean K2() {
        return this.enableRecOpt;
    }

    @Override // r11.j
    public final int getCount() {
        return this.count;
    }

    @Override // r11.j
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // r11.j
    public final long getInterval() {
        return this.interval;
    }

    @Override // r11.j
    public final boolean n6() {
        return this.enableOnCLick;
    }

    @Override // r11.j
    public final int t() {
        return this.validRecCount;
    }

    @Override // r11.j
    public final long z() {
        return this.validInterval;
    }
}
