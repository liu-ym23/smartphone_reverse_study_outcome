package com.bytedance.android.live.revlink.impl.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import r11.e;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LinkPerformanceSetting_ResidentConfigSerializableObjectImpl;", "Lr11/e$c;", "", VideoThumbInfo.KEY_INTERVAL, "J", "getInterval", "()J", "fpsSampleInterval", "O6", "", "sampleCount", "I", RXScreenCaptureService.KEY_INDEX, "()I", "dur", "p", "recoverDur", "y7", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkPerformanceSetting_ResidentConfigSerializableObjectImpl implements e.c {

    @SerializedName("duration")
    private final long dur;

    @SerializedName("sample_interval")
    private final long fpsSampleInterval;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final long interval;

    @SerializedName("recover_duration")
    private final long recoverDur;

    @SerializedName("sample_count")
    private final int sampleCount;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LinkPerformanceSetting_ResidentConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LinkPerformanceSetting_ResidentConfigSerializableObjectImpl.class);
        }
    }

    public LinkPerformanceSetting_ResidentConfigSerializableObjectImpl() {
        this.interval = 0;
        this.fpsSampleInterval = 0;
        this.sampleCount = 0;
        this.dur = 0;
        this.recoverDur = 0;
    }

    @Override // r11.e.c
    public final long O6() {
        return this.fpsSampleInterval;
    }

    @Override // r11.e.c
    public final long getInterval() {
        return this.interval;
    }

    @Override // r11.e.c
    public final int i() {
        return this.sampleCount;
    }

    @Override // r11.e.c
    public final long p() {
        return this.dur;
    }

    @Override // r11.e.c
    public final long y7() {
        return this.recoverDur;
    }
}
