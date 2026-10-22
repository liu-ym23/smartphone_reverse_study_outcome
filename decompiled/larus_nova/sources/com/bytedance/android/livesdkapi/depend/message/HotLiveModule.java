package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.HotLiveModule")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/HotLiveModule;", "", "()V", "deleteList", "", "", "moduleId", "", "moduleVersion", "updateList", "Lcom/bytedance/android/livesdkapi/depend/message/HotVideoCard;", "updateType", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HotLiveModule implements h {

    @SerializedName("delete_list")
    public List<String> deleteList;

    @SerializedName("module_id")
    public long moduleId;

    @SerializedName("module_version")
    public long moduleVersion;

    @SerializedName("update_list")
    public List<HotVideoCard> updateList;

    @SerializedName(HiAnalyticsConstant.BI_KEY_UPDATE_TYPE)
    public int updateType;

    public HotLiveModule() {
    }

    public HotLiveModule(g r100) {
        this.updateList = new ArrayList();
        this.deleteList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        if (r102 != 1) goto L8;
        this.moduleId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.moduleVersion = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.updateType = r100.i();
        goto L3
    L12:
        if (r102 == 4) goto L17;
        if (r102 != 5) goto L15;
        List r103 = this.deleteList;
        Object r104 = am3.h.c(r100);
    L18:
        r103.add(r104);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L17:
        r103 = this.updateList;
        r104 = new HotVideoCard(r100);
        goto L18
    L22:
        r100.d(r101);
    }
}
