package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\nR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\nR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\nR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\nR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\nR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveUIBaseConfig;", "", "", "paidLiveType", "I", "Lpy/k;", "paidLiveIcon", "Lpy/k;", "", "paidLiveIconTitle", "Ljava/lang/String;", "", "duration", "J", "noRightEndTitle", "noRightEndSubTitle", "hasRightEndTitle", "hasRightEndSubTitle", "paidConversionJumpUrl", "panelSixJumpUrl", "feedPagePurchaseBtnWord", "purchaseBtnWord", "imShareTopTitle", "imShareBottomTitle", "searchCardTopTitle", "panelFeedJumpUrl", "panelImCardJumpUrl", "panelInRoomCardJumpUrl", "panelSearchCardJumpUrl", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidLiveUIBaseConfig implements h {

    @SerializedName("duration")
    public long duration;

    @SerializedName("feed_page_purchase_btn_word")
    public String feedPagePurchaseBtnWord;

    @SerializedName("has_right_end_sub_title")
    public String hasRightEndSubTitle;

    @SerializedName("has_right_end_title")
    public String hasRightEndTitle;

    @SerializedName("im_share_bottom_title")
    public String imShareBottomTitle;

    @SerializedName("im_share_top_title")
    public String imShareTopTitle;

    @SerializedName("no_right_end_sub_title")
    public String noRightEndSubTitle;

    @SerializedName("no_right_end_title")
    public String noRightEndTitle;

    @SerializedName("paid_conversion_jump_url")
    public String paidConversionJumpUrl;

    @SerializedName("paid_live_icon")
    public k paidLiveIcon;

    @SerializedName("paid_live_icon_title")
    public String paidLiveIconTitle;

    @SerializedName(PaidReplayConstants.KEY_PRIVILEGE_TYPE)
    public int paidLiveType;

    @SerializedName("panel_feed_jump_url")
    public String panelFeedJumpUrl;

    @SerializedName("panel_im_card_jump_url")
    public String panelImCardJumpUrl;

    @SerializedName("panel_in_room_jump_url")
    public String panelInRoomCardJumpUrl;

    @SerializedName("panel_search_card_jump_url")
    public String panelSearchCardJumpUrl;

    @SerializedName("panel_six_jump_url")
    public String panelSixJumpUrl;

    @SerializedName("purchase_btn_word")
    public String purchaseBtnWord;

    @SerializedName("search_card_top_title")
    public String searchCardTopTitle;

    public PaidLiveUIBaseConfig() {
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public PaidLiveUIBaseConfig(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L26;
        switch(r102) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L8;
            case 19: goto L7;
            default: goto L6;
        };
    L7:
        this.panelSearchCardJumpUrl = am3.h.c(r100);
        goto L3
    L8:
        this.panelInRoomCardJumpUrl = am3.h.c(r100);
        goto L3
    L9:
        this.panelImCardJumpUrl = am3.h.c(r100);
        goto L3
    L10:
        this.panelFeedJumpUrl = am3.h.c(r100);
        goto L3
    L11:
        this.searchCardTopTitle = am3.h.c(r100);
        goto L3
    L12:
        this.imShareBottomTitle = am3.h.c(r100);
        goto L3
    L13:
        this.imShareTopTitle = am3.h.c(r100);
        goto L3
    L14:
        this.purchaseBtnWord = am3.h.c(r100);
        goto L3
    L15:
        this.feedPagePurchaseBtnWord = am3.h.c(r100);
        goto L3
    L16:
        this.panelSixJumpUrl = am3.h.c(r100);
        goto L3
    L17:
        this.paidConversionJumpUrl = am3.h.c(r100);
        goto L3
    L18:
        this.hasRightEndSubTitle = am3.h.c(r100);
        goto L3
    L19:
        this.hasRightEndTitle = am3.h.c(r100);
        goto L3
    L20:
        this.noRightEndSubTitle = am3.h.c(r100);
        goto L3
    L21:
        this.noRightEndTitle = am3.h.c(r100);
        goto L3
    L22:
        this.duration = r100.j();
        goto L3
    L23:
        this.paidLiveIconTitle = am3.h.c(r100);
        goto L3
    L24:
        this.paidLiveIcon = f.a(r100, k.class);
        goto L3
    L25:
        this.paidLiveType = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L26:
        r100.d(r101);
    }
}
