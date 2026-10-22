package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ToolBarExclusionComponent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u0014\u0010\u0014\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u0014\u0010\u0016\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\nR\u0014\u0010\u0018\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ToolBarExclusionComponent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/k5;", "", "isAnchor", "", "getOpType", DBDefinition.ID, "J", "get_id", "()J", "set_id", "(J)V", "_anchorOpType", "get_anchorOpType", "set_anchorOpType", "_audienceOpType", "get_audienceOpType", "set_audienceOpType", "getId", "id", "getAnchorOpType", "anchorOpType", "getAudienceOpType", "audienceOpType", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolBarExclusionComponent extends FlexModelBase<com.bytedance.android.live.base.model.message.k5> implements com.bytedance.android.live.base.model.message.k5, vh7.h {

    @SerializedName("op_type_anchor")
    protected long _anchorOpType;

    @SerializedName("op_type_audience")
    protected long _audienceOpType;

    @SerializedName("component_type")
    protected long _id;

    public ToolBarExclusionComponent() {
        super(com.bytedance.android.live.base.model.message.k5.class);
    }

    @Override // com.bytedance.android.live.base.model.message.k5
    public long getAnchorOpType() {
        return this._anchorOpType;
    }

    @Override // com.bytedance.android.live.base.model.message.k5
    public long getAudienceOpType() {
        return this._audienceOpType;
    }

    @Override // com.bytedance.android.live.base.model.message.k5
    public long getId() {
        return this._id;
    }

    public final long get_anchorOpType() {
        return this._anchorOpType;
    }

    public final long get_audienceOpType() {
        return this._audienceOpType;
    }

    public final long get_id() {
        return this._id;
    }

    public ToolBarExclusionComponent(am3.g r100) {
        super(com.bytedance.android.live.base.model.message.k5.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._id = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._anchorOpType = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._audienceOpType = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.k5
    public long getOpType(boolean r100) {
        if (r100 == false) goto L5;
        return getAnchorOpType();
    L5:
        return getAudienceOpType();
    }

    public final void set_anchorOpType(long r100) {
        this._anchorOpType = r100;
    }

    public final void set_audienceOpType(long r100) {
        this._audienceOpType = r100;
    }

    public final void set_id(long r100) {
        this._id = r100;
    }
}
