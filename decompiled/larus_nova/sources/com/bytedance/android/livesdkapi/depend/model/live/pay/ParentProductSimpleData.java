package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ParentProductSimpleData;", "", "", "productId", "Ljava/lang/String;", "title", "subTitle", "Lpy/k;", "cover", "Lpy/k;", "", "status", "I", "", "viewRight", "J", "bindSubProductCount", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PurchaseSimpleData;", "data", "Ljava/util/List;", "subTitleTag", "currentShowNum", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParentProductSimpleData implements h {

    @SerializedName("bind_sub_product_count")
    public int bindSubProductCount;

    @SerializedName("cover")
    public k cover;

    @SerializedName("current_show_num")
    public int currentShowNum;

    @SerializedName("data")
    public List<PurchaseSimpleData> data;

    @SerializedName("product_id")
    public String productId;

    @SerializedName("status")
    public int status;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    public String subTitle;

    @SerializedName("sub_title_tag")
    public String subTitleTag;

    @SerializedName("title")
    public String title;

    @SerializedName("view_right")
    public long viewRight;

    public ParentProductSimpleData() {
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public ParentProductSimpleData(g r100) {
        this.data = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.currentShowNum = r100.i();
        goto L3
    L8:
        this.subTitleTag = am3.h.c(r100);
        goto L3
    L9:
        this.data.add(new PurchaseSimpleData(r100));
        goto L3
    L10:
        this.bindSubProductCount = r100.i();
        goto L3
    L11:
        this.viewRight = r100.j();
        goto L3
    L12:
        this.status = r100.i();
        goto L3
    L13:
        this.cover = f.a(r100, k.class);
        goto L3
    L14:
        this.subTitle = am3.h.c(r100);
        goto L3
    L15:
        this.title = am3.h.c(r100);
        goto L3
    L16:
        this.productId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
    }
}
