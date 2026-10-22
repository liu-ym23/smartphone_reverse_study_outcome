package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.MicroappSearchEntranceResponse.Data")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/d;", "", "", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/MiniAppEntranceCell;", "entranceList", "Ljava/util/List;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements h {

    @SerializedName("cells")
    public List<MiniAppEntranceCell> entranceList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.entranceList, ((d) r100).entranceList) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<MiniAppEntranceCell> r100 = this.entranceList;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "MiniAppSearchEntranceResponse(entranceList=" + this.entranceList + ")";
    }

    public d() {
        this.entranceList = null;
    }

    public d(g r100) {
        this.entranceList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.entranceList.add(new MiniAppEntranceCell(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.entranceList.isEmpty() == false) goto L19;
        this.entranceList = null;
        return;
    }
}
