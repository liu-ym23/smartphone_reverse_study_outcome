package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ItemInfo;", "", "()V", "itemId", "", "itemIdStr", "", "lastest", "", "playCounts", "tagType", "title", "total", "viewRight", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemInfo implements h {

    @SerializedName("item_id")
    public long itemId;

    @SerializedName("item_id_str")
    public String itemIdStr;

    @SerializedName("lastest")
    public int lastest;

    @SerializedName("play_counts")
    public String playCounts;

    @SerializedName(a.KEY_TAG_TYPE)
    public String tagType;

    @SerializedName("title")
    public String title;

    @SerializedName("total")
    public int total;

    @SerializedName("view_right")
    public long viewRight;

    public ItemInfo() {
    }

    public ItemInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.itemIdStr = am3.h.c(r100);
        goto L3
    L8:
        this.viewRight = r100.j();
        goto L3
    L9:
        this.playCounts = am3.h.c(r100);
        goto L3
    L10:
        this.total = r100.i();
        goto L3
    L11:
        this.lastest = r100.i();
        goto L3
    L12:
        this.tagType = am3.h.c(r100);
        goto L3
    L13:
        this.title = am3.h.c(r100);
        goto L3
    L14:
        this.itemId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
