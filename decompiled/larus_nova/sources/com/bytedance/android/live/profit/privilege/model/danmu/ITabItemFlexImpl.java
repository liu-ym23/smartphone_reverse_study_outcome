package com.bytedance.android.live.profit.privilege.model.danmu;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.privilege.TabItem")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b2\u00103R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR+\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001b\u0010'\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u0004\u0018\u00010(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010+R/\u00101\u001a\u0004\u0018\u00010(2\b\u0010\u0017\u001a\u0004\u0018\u00010(8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010+\"\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/danmu/ITabItemFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/danmu/b;", "Lpy/k;", "img", "Lpy/k;", "getImg", "()Lpy/k;", "setImg", "(Lpy/k;)V", "landscapeImg", "getLandscapeImg", "setLandscapeImg", "entranceImg", "getEntranceImg", "setEntranceImg", "imgV2", "getImgV2", "setImgV2", "landscapeImgV2", "getLandscapeImgV2", "setLandscapeImgV2", "", "<set-?>", "status$delegate", "Ljava/lang/Object;", "getStatus", "()I", "setStatus", "(I)V", "status", "style$delegate", "getStyle", "setStyle", "style", "", "diamondCount$delegate", "getDiamondCount", "()J", "diamondCount", "", "toast$delegate", "getToast", "()Ljava/lang/String;", "toast", "commentToast$delegate", "getCommentToast", "setCommentToast", "(Ljava/lang/String;)V", "commentToast", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ITabItemFlexImpl extends FlexModelBase<b> implements b, h {

    @SerializedName("comment_toast")
    protected String _$$commentToast;

    @SerializedName("diamond_count")
    protected long _$$diamondCount;

    @SerializedName("status")
    protected int _$$status;

    @SerializedName("style")
    protected int _$$style;

    @SerializedName("toast")
    protected String _$$toast;

    @SerializedName("entrance_img")
    protected k entranceImg;

    @SerializedName("img")
    protected k img;

    @SerializedName("img_v2")
    protected k imgV2;

    @SerializedName("landscape_img")
    protected k landscapeImg;

    @SerializedName("landscape_img_v2")
    protected k landscapeImgV2;

    public ITabItemFlexImpl() {
        super(b.class);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public final String getCommentToast() {
        return this._$$commentToast;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public final long getDiamondCount() {
        return this._$$diamondCount;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public k getEntranceImg() {
        return this.entranceImg;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public k getImg() {
        return this.img;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public k getImgV2() {
        return this.imgV2;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public k getLandscapeImg() {
        return this.landscapeImg;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public k getLandscapeImgV2() {
        return this.landscapeImgV2;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public final int getStatus() {
        return this._$$status;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public final int getStyle() {
        return this._$$style;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public final String getToast() {
        return this._$$toast;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    public ITabItemFlexImpl(g r100) {
        super(b.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        this.landscapeImgV2 = f.a(r100, k.class);
        goto L3
    L9:
        this.imgV2 = f.a(r100, k.class);
        goto L3
    L10:
        this.entranceImg = f.a(r100, k.class);
        goto L3
    L11:
        this._$$commentToast = am3.h.c(r100);
        goto L3
    L12:
        this._$$toast = am3.h.c(r100);
        goto L3
    L13:
        this.landscapeImg = f.a(r100, k.class);
        goto L3
    L14:
        this.img = f.a(r100, k.class);
        goto L3
    L15:
        this._$$diamondCount = r100.j();
        goto L3
    L16:
        this._$$style = r100.i();
        goto L3
    L17:
        this._$$status = r100.i();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public final void setCommentToast(String r100) {
        this._$$commentToast = r100;
    }

    public void setEntranceImg(k r100) {
        this.entranceImg = r100;
    }

    public void setImg(k r100) {
        this.img = r100;
    }

    public void setImgV2(k r100) {
        this.imgV2 = r100;
    }

    public void setLandscapeImg(k r100) {
        this.landscapeImg = r100;
    }

    public void setLandscapeImgV2(k r100) {
        this.landscapeImgV2 = r100;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public final void setStatus(int r100) {
        this._$$status = r100;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.b
    public final void setStyle(int r100) {
        this._$$style = r100;
    }
}
