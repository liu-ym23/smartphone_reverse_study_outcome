package com.bytedance.android.live.broadcast.api.model.component;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.CreateModeComponent")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/component/b;", "", "Lcom/bytedance/android/live/broadcast/api/model/component/BaseComponentModel;", "base", "Lcom/bytedance/android/live/broadcast/api/model/component/BaseComponentModel;", "", "Lcom/bytedance/android/live/broadcast/api/model/component/c;", "tabList", "Ljava/util/List;", "", "selectTab", "Ljava/lang/Integer;", "getSelectTab", "()Ljava/lang/Integer;", "setSelectTab", "(Ljava/lang/Integer;)V", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("base")
    public BaseComponentModel base;

    @SerializedName("select_tab")
    protected Integer selectTab;

    @SerializedName("tab_config")
    public List<c> tabList;

    public b() {
    }

    public b(g r100) {
        this.tabList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.base = new BaseComponentModel(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.tabList.add(new c(r100));
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.selectTab = Integer.valueOf(r100.i());
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
