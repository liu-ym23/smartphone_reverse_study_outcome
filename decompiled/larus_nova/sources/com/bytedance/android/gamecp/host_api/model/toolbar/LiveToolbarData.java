package com.bytedance.android.gamecp.host_api.model.toolbar;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.ToolBarData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/toolbar/LiveToolbarData;", "", "()V", "toolbarDataList", "", "Lcom/bytedance/android/gamecp/host_api/model/toolbar/ToolbarComponentData;", "getToolbarDataList", "()Ljava/util/List;", "setToolbarDataList", "(Ljava/util/List;)V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveToolbarData implements h {

    @SerializedName("entrance_list")
    protected List<ToolbarComponentData> toolbarDataList;

    public LiveToolbarData() {
    }

    public LiveToolbarData(g r100) {
        this.toolbarDataList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.toolbarDataList.add(new ToolbarComponentData(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final List<ToolbarComponentData> getToolbarDataList() {
        return this.toolbarDataList;
    }

    public final void setToolbarDataList(List<ToolbarComponentData> r100) {
        this.toolbarDataList = r100;
    }
}
