package com.bytedance.android.gamecp.common.model.banner;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.gamecp.host_api.model.ImageModelLive;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.api.feed.Banner")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\f\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R\"\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010¨\u0006'"}, d2 = {"Lcom/bytedance/android/gamecp/common/model/banner/b;", "", "", "Lcom/bytedance/android/gamecp/common/model/banner/a;", "bannerList", "Ljava/util/List;", "getBannerList", "()Ljava/util/List;", "setBannerList", "(Ljava/util/List;)V", "", "total", "I", "getTotal", "()I", "setTotal", "(I)V", "Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;", "background", "Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;", "getBackground", "()Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;", "setBackground", "(Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "switchType", "getSwitchType", "setSwitchType", "bannersType", "getBannersType", "setBannersType", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("background")
    protected ImageModelLive background;

    @SerializedName(PromotionProductPrivilegesStruct.BANNERS)
    protected List<a> bannerList;

    @SerializedName("banners_type")
    protected int bannersType;

    @SerializedName("switch_type")
    protected int switchType;

    @SerializedName("title")
    protected String title;

    @SerializedName("total")
    protected int total;

    public b() {
    }

    public b(g r100) {
        this.bannerList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.bannersType = (int) r100.j();
        goto L3
    L8:
        this.switchType = (int) r100.j();
        goto L3
    L9:
        this.title = am3.h.c(r100);
        goto L3
    L10:
        this.background = new ImageModelLive(r100);
        goto L3
    L11:
        this.total = (int) r100.j();
        goto L3
    L12:
        this.bannerList.add(new a(r100));
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }
}
