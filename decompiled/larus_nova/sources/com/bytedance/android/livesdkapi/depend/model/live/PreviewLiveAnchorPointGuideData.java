package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PreviewExposeData.FeedLiveIdeaGuide")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewLiveAnchorPointGuideData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewAnchorPointGuideData;", "()V", "disappearTimeInterval", "", "getDisappearTimeInterval", "()Ljava/lang/Long;", "Ljava/lang/Long;", "isRecall", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "latestLiveRecord", "getLatestLiveRecord", "showTimeInterval", "getShowTimeInterval", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewLiveAnchorPointGuideData extends FlexModelBase<IPreviewAnchorPointGuideData> implements IPreviewAnchorPointGuideData, h {

    @SerializedName("disappear_time_interval")
    protected Long disappearTimeInterval;

    @SerializedName("is_recall")
    protected Boolean isRecall;

    @SerializedName("latest_live_record")
    protected Long latestLiveRecord;

    @SerializedName("show_time_interval")
    protected Long showTimeInterval;

    public PreviewLiveAnchorPointGuideData() {
        super(IPreviewAnchorPointGuideData.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewAnchorPointGuideData
    public Long getDisappearTimeInterval() {
        return this.disappearTimeInterval;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewAnchorPointGuideData
    public Long getLatestLiveRecord() {
        return this.latestLiveRecord;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewAnchorPointGuideData
    public Long getShowTimeInterval() {
        return this.showTimeInterval;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewAnchorPointGuideData
    public Boolean isRecall() {
        return this.isRecall;
    }

    public PreviewLiveAnchorPointGuideData(g r100) {
        super(IPreviewAnchorPointGuideData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.isRecall = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.latestLiveRecord = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.showTimeInterval = Long.valueOf(r100.j());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.disappearTimeInterval = Long.valueOf(r100.j());
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }
}
