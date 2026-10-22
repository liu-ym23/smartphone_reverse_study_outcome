package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Combined;", "", "()V", "bindSubTicketList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/BindSubProductData;", "parentTicketPanelData", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ParentProductSimpleData;", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Combined implements h {

    @SerializedName("bind_sub_ticket_list")
    public List<BindSubProductData> bindSubTicketList;

    @SerializedName("parent_ticket_panel_data")
    public ParentProductSimpleData parentTicketPanelData;

    public Combined() {
    }

    public Combined(g r100) {
        this.bindSubTicketList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.bindSubTicketList.add(new BindSubProductData(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.parentTicketPanelData = new ParentProductSimpleData(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
