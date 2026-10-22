package com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent;

import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ies.sve_core.p;
import com.google.gson.annotations.SerializedName;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/layoutcomponent/c;", "Lcom/bytedance/ies/sve_core/p;", "", "weight", FaceService.girlLabel, ce.f26391f, "()F", "l", "(F)V", "", "marginTop", "I", "f", "()I", ce.f26396k, "(I)V", "marginBottom", "c", "h", "marginLeft", "d", RXScreenCaptureService.KEY_INDEX, "marginRight", "e", ce.f26395j, "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements p {

    @SerializedName("margin_bottom")
    private int marginBottom;

    @SerializedName("margin_left")
    private int marginLeft;

    @SerializedName("margin_right")
    private int marginRight;

    @SerializedName("margin_top")
    private int marginTop;

    @SerializedName("weight")
    private float weight;

    public c() {
        this.weight = -1.0f;
        this.marginTop = -1;
        this.marginBottom = -1;
        this.marginLeft = -1;
        this.marginRight = -1;
    }

    public final int c() {
        return this.marginBottom;
    }

    public final int d() {
        return this.marginLeft;
    }

    public final int e() {
        return this.marginRight;
    }

    public final int f() {
        return this.marginTop;
    }

    public final float g() {
        return this.weight;
    }

    public final void h(int r100) {
        this.marginBottom = r100;
    }

    public final void i(int r100) {
        this.marginLeft = r100;
    }

    public final void j(int r100) {
        this.marginRight = r100;
    }

    public final void k(int r100) {
        this.marginTop = r100;
    }

    public final void l(float r100) {
        this.weight = r100;
    }
}
