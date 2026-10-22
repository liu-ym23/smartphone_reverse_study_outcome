package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.IGetPreviewExitGuideResponse;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.room.GetPreviewExitGuideResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/GetPreviewExitGuideResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/IGetPreviewExitGuideResponse;", "()V", "guideList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewExitGuideData;", "getGuideList", "()Ljava/util/List;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetPreviewExitGuideResponse extends FlexModelBase<IGetPreviewExitGuideResponse> implements IGetPreviewExitGuideResponse, h {

    @SerializedName("guide_list")
    protected List<PreviewExitGuideData> guideList;

    public GetPreviewExitGuideResponse() {
        super(IGetPreviewExitGuideResponse.class);
    }

    public GetPreviewExitGuideResponse(g r100) {
        super(IGetPreviewExitGuideResponse.class);
        this.guideList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.guideList.add(new PreviewExitGuideData(r100));
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IGetPreviewExitGuideResponse
    public List<PreviewExitGuideData> getGuideList() {
        return this.guideList;
    }
}
