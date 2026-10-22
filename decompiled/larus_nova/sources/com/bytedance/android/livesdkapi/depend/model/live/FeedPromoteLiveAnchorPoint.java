package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PreviewExposeData.FeedPromoteLiveAnchorPoint")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/FeedPromoteLiveAnchorPoint;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IFeedPromoteLiveAnchorPoint;", "()V", "disappearTimeInterval", "", "getDisappearTimeInterval", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "latestLiveRecord", "", "getLatestLiveRecord", "()Ljava/lang/String;", "recallType", "getRecallType", "showTimeInterval", "getShowTimeInterval", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedPromoteLiveAnchorPoint extends FlexModelBase<IFeedPromoteLiveAnchorPoint> implements IFeedPromoteLiveAnchorPoint, h {

    @SerializedName("disappear_time_interval")
    protected Integer disappearTimeInterval;

    @SerializedName("latest_live_record")
    protected String latestLiveRecord;

    @SerializedName(a.KEY_RECALL_TYPE)
    protected Integer recallType;

    @SerializedName("show_time_interval")
    protected Integer showTimeInterval;

    public FeedPromoteLiveAnchorPoint() {
        super(IFeedPromoteLiveAnchorPoint.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IFeedPromoteLiveAnchorPoint
    public Integer getDisappearTimeInterval() {
        return this.disappearTimeInterval;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IFeedPromoteLiveAnchorPoint
    public String getLatestLiveRecord() {
        return this.latestLiveRecord;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IFeedPromoteLiveAnchorPoint
    public Integer getRecallType() {
        return this.recallType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IFeedPromoteLiveAnchorPoint
    public Integer getShowTimeInterval() {
        return this.showTimeInterval;
    }

    public FeedPromoteLiveAnchorPoint(g r100) {
        super(IFeedPromoteLiveAnchorPoint.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.recallType = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.latestLiveRecord = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.showTimeInterval = Integer.valueOf(r100.i());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.disappearTimeInterval = Integer.valueOf(r100.i());
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }
}
