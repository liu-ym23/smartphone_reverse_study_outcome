package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.GroupLiveData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/GroupLiveData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IGroupLiveData;", "()V", "groupLiveMode", "", "getGroupLiveMode", "()I", "setGroupLiveMode", "(I)V", "isGroupLive", "setGroupLive", "isCurrentGroupLive", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
@ForMain
public final class GroupLiveData extends FlexModelBase<IGroupLiveData> implements IGroupLiveData, h {

    @SerializedName("group_live_mode")
    protected int groupLiveMode;

    @SerializedName("is_group_live")
    protected int isGroupLive;

    public GroupLiveData() {
        super(IGroupLiveData.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveDataEx
    public boolean isCurrentGroupLive() {
        if (isGroupLive() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData
    public int getGroupLiveMode() {
        return this.groupLiveMode;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData
    public int isGroupLive() {
        return this.isGroupLive;
    }

    public GroupLiveData(g r100) {
        super(IGroupLiveData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.isGroupLive = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.groupLiveMode = r100.i();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setGroupLive(int r100) {
        this.isGroupLive = r100;
    }

    public void setGroupLiveMode(int r100) {
        this.groupLiveMode = r100;
    }
}
