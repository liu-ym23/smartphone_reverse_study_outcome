package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.IndustryCertificationRoom.RoomOwner")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\"R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\t¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/base/model/user/RoomOwner;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/f0;", "Lpy/k;", "title", "Lpy/k;", "getTitle", "()Lpy/k;", com.alipay.sdk.m.x.d.f25925o, "(Lpy/k;)V", "", "subTitle", "Ljava/lang/String;", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "leftColor", "getLeftColor", "setLeftColor", "rightColor", "getRightColor", "setRightColor", "", "type", "I", "getType", "()I", "setType", "(I)V", "brandCertImg", "getBrandCertImg", "setBrandCertImg", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomOwner extends FlexModelBase<f0> implements f0, vh7.h {

    @SerializedName("brand_store_title")
    protected py.k brandCertImg;

    @SerializedName("left_color")
    protected String leftColor;

    @SerializedName("right_color")
    protected String rightColor;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    protected String subTitle;

    @SerializedName("title")
    protected py.k title;

    @SerializedName("anchor_industry_type")
    protected int type;

    public RoomOwner() {
        super(f0.class);
    }

    public final py.k getBrandCertImg() {
        return this.brandCertImg;
    }

    public final String getLeftColor() {
        return this.leftColor;
    }

    public final String getRightColor() {
        return this.rightColor;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final py.k getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public RoomOwner(am3.g r100) {
        super(f0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.brandCertImg = vh7.f.a(r100, py.k.class);
        goto L3
    L9:
        this.type = r100.i();
        goto L3
    L10:
        this.rightColor = am3.h.c(r100);
        goto L3
    L11:
        this.leftColor = am3.h.c(r100);
        goto L3
    L12:
        this.subTitle = am3.h.c(r100);
        goto L3
    L13:
        this.title = vh7.f.a(r100, py.k.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setBrandCertImg(py.k r100) {
        this.brandCertImg = r100;
    }

    public final void setLeftColor(String r100) {
        this.leftColor = r100;
    }

    public final void setRightColor(String r100) {
        this.rightColor = r100;
    }

    public final void setSubTitle(String r100) {
        this.subTitle = r100;
    }

    public final void setTitle(py.k r100) {
        this.title = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }
}
