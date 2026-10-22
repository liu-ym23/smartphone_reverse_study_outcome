package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058V@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058V@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSFreeViewRange;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSFreeViewRange;", "()V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSFreeViewRange extends FlexModelBase<IVSFreeViewRange> implements IVSFreeViewRange, h {

    @SerializedName("end_time")
    @IgnoreProtoDecode
    private long endTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    @IgnoreProtoDecode
    private long startTime;

    public VSFreeViewRange() {
        super(IVSFreeViewRange.class);
    }

    public VSFreeViewRange(g r100) {
        super(IVSFreeViewRange.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L6;
        am3.h.d(decodeExtensionFields(r102, r100), r100);
        goto L3
    L6:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSFreeViewRange
    public long getEndTime() {
        return this.endTime * ((long) 1000);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSFreeViewRange
    public long getStartTime() {
        return this.startTime * ((long) 1000);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSFreeViewRange
    public void setEndTime(long r100) {
        this.endTime = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSFreeViewRange
    public void setStartTime(long r100) {
        this.startTime = r100;
    }
}
