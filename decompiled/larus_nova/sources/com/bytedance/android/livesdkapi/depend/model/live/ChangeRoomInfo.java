package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@IgnoreProtoFieldCheck
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ChangeRoomInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IChangeRoomInfo;", "()V", "beforeAnchorId", "", "getBeforeAnchorId", "()J", "setBeforeAnchorId", "(J)V", "beforeRoomId", "getBeforeRoomId", "setBeforeRoomId", "changeRoomReason", "", "getChangeRoomReason", "()I", "setChangeRoomReason", "(I)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeRoomInfo extends FlexModelBase<IChangeRoomInfo> implements IChangeRoomInfo, h {

    @SerializedName("before_anchor_id")
    protected long beforeAnchorId;

    @SerializedName("before_room_id")
    protected long beforeRoomId;

    @SerializedName("has_change_room")
    protected int changeRoomReason;

    public ChangeRoomInfo() {
        super(IChangeRoomInfo.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IChangeRoomInfo
    public long getBeforeAnchorId() {
        return this.beforeAnchorId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IChangeRoomInfo
    public long getBeforeRoomId() {
        return this.beforeRoomId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IChangeRoomInfo
    public int getChangeRoomReason() {
        return this.changeRoomReason;
    }

    public ChangeRoomInfo(g r100) {
        super(IChangeRoomInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.changeRoomReason = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.beforeRoomId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.beforeAnchorId = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IChangeRoomInfo
    public void setBeforeAnchorId(long r100) {
        this.beforeAnchorId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IChangeRoomInfo
    public void setBeforeRoomId(long r100) {
        this.beforeRoomId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IChangeRoomInfo
    public void setChangeRoomReason(int r100) {
        this.changeRoomReason = r100;
    }
}
