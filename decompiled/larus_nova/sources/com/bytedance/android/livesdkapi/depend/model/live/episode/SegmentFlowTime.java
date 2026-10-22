package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/SegmentFlowTime;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ISegmentFlowTime;", "()V", "endOffset", "", "getEndOffset", "()J", "setEndOffset", "(J)V", "startOffset", "getStartOffset", "setStartOffset", "startOffsetFlowTime", "getStartOffsetFlowTime", "setStartOffsetFlowTime", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SegmentFlowTime extends FlexModelBase<ISegmentFlowTime> implements ISegmentFlowTime, h {

    @SerializedName(DbJsonConstants.DBJSON_KEY_END_OFFSET)
    protected long endOffset;

    @SerializedName(DbJsonConstants.DBJSON_KEY_START_OFFSET)
    protected long startOffset;

    @SerializedName("start_offset_flow_time")
    protected long startOffsetFlowTime;

    public SegmentFlowTime() {
        super(ISegmentFlowTime.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ISegmentFlowTime
    public long getEndOffset() {
        return this.endOffset;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ISegmentFlowTime
    public long getStartOffset() {
        return this.startOffset;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ISegmentFlowTime
    public long getStartOffsetFlowTime() {
        return this.startOffsetFlowTime;
    }

    public SegmentFlowTime(g r100) {
        super(ISegmentFlowTime.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.startOffset = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.endOffset = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.startOffsetFlowTime = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ISegmentFlowTime
    public void setEndOffset(long r100) {
        this.endOffset = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ISegmentFlowTime
    public void setStartOffset(long r100) {
        this.startOffset = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ISegmentFlowTime
    public void setStartOffsetFlowTime(long r100) {
        this.startOffsetFlowTime = r100;
    }
}
