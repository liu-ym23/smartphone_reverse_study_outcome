package com.bytedance.android.live.profit.fansclub.backend;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.fansclub.GetFansclubHomepageResult.Data.GroupLiveInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/backend/IGroupLiveInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/fansclub/backend/IGroupLiveInfo;", "", "selectAnchorId$delegate", "Ljava/lang/Object;", "getSelectAnchorId", "()Ljava/lang/String;", "selectAnchorId", "", "isManualSelect$delegate", "isManualSelect", "()Z", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IGroupLiveInfoFlexImpl extends FlexModelBase<IGroupLiveInfo> implements IGroupLiveInfo, h {

    @SerializedName("is_manual_select")
    protected boolean _$$isManualSelect;

    @SerializedName("select_anchor_id")
    protected String _$$selectAnchorId;

    public IGroupLiveInfoFlexImpl() {
        super(IGroupLiveInfo.class);
        this._$$selectAnchorId = "";
        this._$$isManualSelect = false;
    }

    public IGroupLiveInfoFlexImpl(g r100) {
        super(IGroupLiveInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$selectAnchorId = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 3) goto L9;
        this._$$isManualSelect = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L9:
        am3.h.d(r104, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$selectAnchorId != null) goto L16;
        this._$$selectAnchorId = "";
    L16:
        if ((r102 & true) == true) goto L28;
        this._$$isManualSelect = false;
        return;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGroupLiveInfo
    public final String getSelectAnchorId() {
        return this._$$selectAnchorId;
    }

    @Override // com.bytedance.android.live.profit.fansclub.backend.IGroupLiveInfo
    public final boolean isManualSelect() {
        return this._$$isManualSelect;
    }
}
