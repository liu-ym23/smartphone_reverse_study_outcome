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
@ProtoMessage("webcast.data.RelevantRecommendation.WhiteCategoryInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/WhiteCategoryInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IWhiteCategoryInfo;", "()V", "firstLevelTagId", "", "getFirstLevelTagId", "()Ljava/lang/Long;", "setFirstLevelTagId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WhiteCategoryInfo extends FlexModelBase<IWhiteCategoryInfo> implements IWhiteCategoryInfo, h {

    @SerializedName("first_level_tag_id")
    protected Long firstLevelTagId;

    public WhiteCategoryInfo() {
        super(IWhiteCategoryInfo.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IWhiteCategoryInfo
    public Long getFirstLevelTagId() {
        return this.firstLevelTagId;
    }

    public WhiteCategoryInfo(g r100) {
        super(IWhiteCategoryInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.firstLevelTagId = Long.valueOf(r100.j());
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setFirstLevelTagId(Long r100) {
        this.firstLevelTagId = r100;
    }
}
