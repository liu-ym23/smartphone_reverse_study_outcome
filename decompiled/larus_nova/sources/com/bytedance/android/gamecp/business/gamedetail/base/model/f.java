package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.EntryLimit")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/f;", "", "", "entryLimitDes", "Ljava/lang/String;", "", "Lcom/bytedance/android/gamecp/business/gamedetail/component/fansgroup/g;", "entryLimits", "Ljava/util/List;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements vh7.h {

    @SerializedName("entry_limit_show")
    public String entryLimitDes;

    @SerializedName("entry_limit_detail")
    public List<com.bytedance.android.gamecp.business.gamedetail.component.fansgroup.g> entryLimits;

    public f() {
        this.entryLimitDes = "";
        this.entryLimits = new ArrayList();
    }

    public f(am3.g r100) {
        this.entryLimits = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.entryLimitDes = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.entryLimits.add(new com.bytedance.android.gamecp.business.gamedetail.component.fansgroup.g(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.entryLimitDes != null) goto L16;
        this.entryLimitDes = "";
    L16:
        if (this.entryLimits.isEmpty() == false) goto L28;
        this.entryLimits = new ArrayList();
        return;
    }
}
