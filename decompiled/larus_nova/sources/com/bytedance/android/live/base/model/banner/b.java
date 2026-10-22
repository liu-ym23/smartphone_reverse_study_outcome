package com.bytedance.android.live.base.model.banner;

import am3.g;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.feed.Banner")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\f\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R\"\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/base/model/banner/b;", "", "", "Lcom/bytedance/android/live/base/model/banner/a;", "_bannerList", "Ljava/util/List;", "b", "()Ljava/util/List;", "set_bannerList", "(Ljava/util/List;)V", "", "_total", "I", "get_total", "()I", "set_total", "(I)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "_background", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_background", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_background", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "_title", "Ljava/lang/String;", "get_title", "()Ljava/lang/String;", "set_title", "(Ljava/lang/String;)V", "_switchType", "get_switchType", "set_switchType", "_bannersType", "get_bannersType", "set_bannersType", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("background")
    protected ImageModel _background;

    @SerializedName(PromotionProductPrivilegesStruct.BANNERS)
    protected List<a> _bannerList;

    @SerializedName("banners_type")
    protected int _bannersType;

    @SerializedName("switch_type")
    protected int _switchType;

    @SerializedName("title")
    protected String _title;

    @SerializedName("total")
    protected int _total;

    public b() {
    }

    public final List<a> a() {
        return this._bannerList;
    }

    public final List<a> b() {
        return this._bannerList;
    }

    public b(g r100) {
        this._bannerList = new ArrayList();
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
        this._bannersType = (int) r100.j();
        goto L3
    L8:
        this._switchType = (int) r100.j();
        goto L3
    L9:
        this._title = am3.h.c(r100);
        goto L3
    L10:
        this._background = x.a(r100);
        goto L3
    L11:
        this._total = (int) r100.j();
        goto L3
    L12:
        this._bannerList.add(new a(r100));
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }
}
