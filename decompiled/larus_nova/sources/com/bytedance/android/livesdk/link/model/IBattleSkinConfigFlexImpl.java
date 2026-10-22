package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleSkinConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0017\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b5\u00106R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001b\u0010\u0012\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001b\u0010\u001b\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u001b\u0010\u001e\u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u001fR/\u0010'\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R/\u0010+\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R/\u00100\u001a\u0004\u0018\u00010\r2\b\u0010!\u001a\u0004\u0018\u00010\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u000f\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010/R/\u00104\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u000f\u001a\u0004\b2\u0010$\"\u0004\b3\u0010&¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleSkinConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/x2;", "Lpy/k;", "roomBgTopImage", "Lpy/k;", "getRoomBgTopImage", "()Lpy/k;", "setRoomBgTopImage", "(Lpy/k;)V", "roomBgBottomImage", "getRoomBgBottomImage", "setRoomBgBottomImage", "", "startAnimationUrl$delegate", "Ljava/lang/Object;", "getStartAnimationUrl", "()Ljava/lang/String;", "startAnimationUrl", "winAnimationUrl$delegate", "getWinAnimationUrl", "winAnimationUrl", "loseAnimationUrl$delegate", "getLoseAnimationUrl", "loseAnimationUrl", "drawAnimationUrl$delegate", "getDrawAnimationUrl", "drawAnimationUrl", "", "isShowEnterUserInfo$delegate", "isShowEnterUserInfo", "()Z", "", "<set-?>", "enterUserInfoPosition$delegate", "getEnterUserInfoPosition", "()Ljava/lang/Long;", "setEnterUserInfoPosition", "(Ljava/lang/Long;)V", "enterUserInfoPosition", "enterShowTimeMs$delegate", "getEnterShowTimeMs", "setEnterShowTimeMs", "enterShowTimeMs", "sponsorAnimationUrl$delegate", "getSponsorAnimationUrl", "setSponsorAnimationUrl", "(Ljava/lang/String;)V", "sponsorAnimationUrl", "sponsorAnimationShowTimeMs$delegate", "getSponsorAnimationShowTimeMs", "setSponsorAnimationShowTimeMs", "sponsorAnimationShowTimeMs", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleSkinConfigFlexImpl extends FlexModelBase<x2> implements x2, vh7.h {

    @SerializedName("draw_animation_url")
    protected String _$$drawAnimationUrl;

    @SerializedName("enter_show_time_ms")
    protected Long _$$enterShowTimeMs;

    @SerializedName("enter_user_info_position")
    protected Long _$$enterUserInfoPosition;

    @SerializedName("is_show_enter_user_info")
    protected boolean _$$isShowEnterUserInfo;

    @SerializedName("lose_animation_url")
    protected String _$$loseAnimationUrl;

    @SerializedName("sponsor_animation_show_time_ms")
    protected Long _$$sponsorAnimationShowTimeMs;

    @SerializedName("sponsor_animation_url")
    protected String _$$sponsorAnimationUrl;

    @SerializedName("start_animation_url")
    protected String _$$startAnimationUrl;

    @SerializedName("win_animation_url")
    protected String _$$winAnimationUrl;

    @SerializedName("room_bg_bottom_image")
    protected py.k roomBgBottomImage;

    @SerializedName("room_bg_top_image")
    protected py.k roomBgTopImage;

    public IBattleSkinConfigFlexImpl() {
        super(x2.class);
        this._$$startAnimationUrl = "";
        this._$$winAnimationUrl = "";
        this._$$loseAnimationUrl = "";
        this._$$drawAnimationUrl = "";
        this._$$isShowEnterUserInfo = false;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final String getDrawAnimationUrl() {
        return this._$$drawAnimationUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final Long getEnterShowTimeMs() {
        return this._$$enterShowTimeMs;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final Long getEnterUserInfoPosition() {
        return this._$$enterUserInfoPosition;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final String getLoseAnimationUrl() {
        return this._$$loseAnimationUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public py.k getRoomBgBottomImage() {
        return this.roomBgBottomImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public py.k getRoomBgTopImage() {
        return this.roomBgTopImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final Long getSponsorAnimationShowTimeMs() {
        return this._$$sponsorAnimationShowTimeMs;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final String getSponsorAnimationUrl() {
        return this._$$sponsorAnimationUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final String getStartAnimationUrl() {
        return this._$$startAnimationUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final String getWinAnimationUrl() {
        return this._$$winAnimationUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final boolean isShowEnterUserInfo() {
        return this._$$isShowEnterUserInfo;
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object, py.k] */
    public IBattleSkinConfigFlexImpl(am3.g r100) {
        super(x2.class);
        setThreadSafe(false);
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L19;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L7;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        this._$$sponsorAnimationShowTimeMs = Long.valueOf(r100.j());
        goto L3
    L9:
        this._$$sponsorAnimationUrl = am3.h.c(r100);
        goto L3
    L10:
        this._$$enterShowTimeMs = Long.valueOf(r100.j());
        goto L3
    L11:
        this._$$enterUserInfoPosition = Long.valueOf(r100.j());
        goto L3
    L12:
        this.roomBgBottomImage = vh7.f.a(r100, py.k.class);
        goto L3
    L13:
        this.roomBgTopImage = vh7.f.a(r100, py.k.class);
        goto L3
    L14:
        this._$$isShowEnterUserInfo = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L15:
        this._$$drawAnimationUrl = am3.h.c(r100);
        goto L3
    L16:
        this._$$loseAnimationUrl = am3.h.c(r100);
        goto L3
    L17:
        this._$$winAnimationUrl = am3.h.c(r100);
        goto L3
    L18:
        this._$$startAnimationUrl = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L19:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$startAnimationUrl != null) goto L23;
        this._$$startAnimationUrl = "";
    L23:
        if (this._$$winAnimationUrl != null) goto L26;
        this._$$winAnimationUrl = "";
    L26:
        if (this._$$loseAnimationUrl != null) goto L29;
        this._$$loseAnimationUrl = "";
    L29:
        if (this._$$drawAnimationUrl != null) goto L32;
        this._$$drawAnimationUrl = "";
    L32:
        if ((true & r102) == true) goto L61;
        this._$$isShowEnterUserInfo = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final void setEnterShowTimeMs(Long r100) {
        this._$$enterShowTimeMs = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final void setEnterUserInfoPosition(Long r100) {
        this._$$enterUserInfoPosition = r100;
    }

    public void setRoomBgBottomImage(py.k r100) {
        this.roomBgBottomImage = r100;
    }

    public void setRoomBgTopImage(py.k r100) {
        this.roomBgTopImage = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final void setSponsorAnimationShowTimeMs(Long r100) {
        this._$$sponsorAnimationShowTimeMs = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.x2
    public final void setSponsorAnimationUrl(String r100) {
        this._$$sponsorAnimationUrl = r100;
    }
}
