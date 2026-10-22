package com.bytedance.android.live.revlink.impl.config;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import r11.o;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/PkPanelFollowUpdateStrategySerializableObjectImpl;", "Lr11/o;", "", VideoThumbInfo.KEY_INTERVAL, "J", "getInterval", "()J", "delay", "getDelay", "", "count", "I", "getCount", "()I", "panelInterval", "q", "panelCount", "C", "validInterval", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkPanelFollowUpdateStrategySerializableObjectImpl implements o {

    @SerializedName("count")
    private final int count;

    @SerializedName("delay")
    private final long delay;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final long interval;

    @SerializedName("panel_count")
    private final int panelCount;

    @SerializedName("panel_interval")
    private final long panelInterval;

    @SerializedName("valid_interval")
    private final long validInterval;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/PkPanelFollowUpdateStrategySerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(PkPanelFollowUpdateStrategySerializableObjectImpl.class);
        }
    }

    public PkPanelFollowUpdateStrategySerializableObjectImpl() {
        this.interval = 15000;
        this.delay = 10000;
        this.count = 5;
        this.panelInterval = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
        this.panelCount = 5;
        this.validInterval = 12000;
    }

    @Override // r11.o
    public final int C() {
        return this.panelCount;
    }

    @Override // r11.o
    public final int getCount() {
        return this.count;
    }

    @Override // r11.o
    public final long getDelay() {
        return this.delay;
    }

    @Override // r11.o
    public final long getInterval() {
        return this.interval;
    }

    @Override // r11.o
    public final long q() {
        return this.panelInterval;
    }

    @Override // r11.o
    public final long z() {
        return this.validInterval;
    }
}
