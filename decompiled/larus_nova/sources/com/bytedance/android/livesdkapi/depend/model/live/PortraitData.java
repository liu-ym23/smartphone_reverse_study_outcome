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
@ProtoMessage("webcast.data.PreviewExposeData.PortraitData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016X\u0097D¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0016X\u0097D¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PortraitData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPortraitData;", "()V", "exhibitionPaid", "", "getExhibitionPaid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "pkPaid", "getPkPaid", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PortraitData extends FlexModelBase<IPortraitData> implements IPortraitData, h {

    @SerializedName("exhibition_paid")
    protected Long exhibitionPaid;

    @SerializedName("pk_paid")
    protected Long pkPaid;

    public PortraitData() {
        super(IPortraitData.class);
        this.pkPaid = 0L;
        this.exhibitionPaid = 0L;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPortraitData
    public Long getExhibitionPaid() {
        return this.exhibitionPaid;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPortraitData
    public Long getPkPaid() {
        return this.pkPaid;
    }

    public PortraitData(g r100) {
        super(IPortraitData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.pkPaid = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.exhibitionPaid = Long.valueOf(r100.j());
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this.pkPaid != null) goto L16;
        this.pkPaid = 0L;
    L16:
        if (this.exhibitionPaid != null) goto L28;
        this.exhibitionPaid = 0L;
        return;
    }
}
