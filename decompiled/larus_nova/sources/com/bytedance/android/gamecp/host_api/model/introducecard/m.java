package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.AnchorIntroducePropItem")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/m;", "", "", "propIcon", "Ljava/lang/String;", "gameName", "gameId", "gameImage", "propName", "propId", "", "propType", "Ljava/lang/Long;", "marketPrice", "sellingPrice", "introduceStartTime", "J", "", "introduceTimeLimit", "I", "", "isPropExpGame", "Z", "smallIcon", "_stockNum", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m implements vh7.h {

    @SerializedName("stock_num")
    protected Long _stockNum;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("game_image")
    public String gameImage;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName("introduce_start_time")
    public long introduceStartTime;

    @SerializedName("introduce_time_limit")
    public int introduceTimeLimit;

    @SerializedName("is_prop_exp_game")
    public boolean isPropExpGame;

    @SerializedName("market_price")
    public Long marketPrice;

    @SerializedName("prop_icon")
    public String propIcon;

    @SerializedName("prop_id")
    public String propId;

    @SerializedName("prop_name")
    public String propName;

    @SerializedName("prop_type")
    public Long propType;

    @SerializedName("selling_price")
    public Long sellingPrice;

    @SerializedName("small_icon")
    public String smallIcon;

    public m() {
        IntroduceCardType r100 = IntroduceCardType.GAME;
        this.propId = "";
        this.propType = 1L;
        this.marketPrice = -1L;
        this.sellingPrice = -1L;
        this.introduceStartTime = -1;
        this.introduceTimeLimit = -1;
    }

    public m(am3.g r100) {
        IntroduceCardType r101 = IntroduceCardType.GAME;
        long r102 = r100.c();
        int r103 = 0;
    L3:
        int r104 = r100.f();
        if (r104 == (-1)) goto L21;
        switch(r104) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L6;
            case 13: goto L9;
            case 14: goto L8;
            case 15: goto L6;
            case 16: goto L7;
            default: goto L6;
        };
    L7:
        this._stockNum = Long.valueOf(r100.j());
        goto L3
    L8:
        this.smallIcon = am3.h.c(r100);
        goto L3
    L9:
        this.isPropExpGame = am3.h.a(r100);
        goto L3
    L10:
        this.propType = Long.valueOf(r100.j());
        goto L3
    L11:
        this.introduceTimeLimit = r100.i();
        r103 = r103 | 2;
        goto L3
    L12:
        this.introduceStartTime = r100.j();
        r103 = r103 | 1;
        goto L3
    L13:
        this.sellingPrice = Long.valueOf(r100.j());
        goto L3
    L14:
        this.marketPrice = Long.valueOf(r100.j());
        goto L3
    L15:
        this.propId = am3.h.c(r100);
        goto L3
    L16:
        this.propName = am3.h.c(r100);
        goto L3
    L17:
        this.gameImage = am3.h.c(r100);
        goto L3
    L18:
        this.gameId = am3.h.c(r100);
        goto L3
    L19:
        this.gameName = am3.h.c(r100);
        goto L3
    L20:
        this.propIcon = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r102);
        if (this.propId != null) goto L25;
        this.propId = "";
    L25:
        if (this.propType != null) goto L28;
        this.propType = 1L;
    L28:
        if (this.marketPrice != null) goto L31;
        this.marketPrice = -1L;
    L31:
        if (this.sellingPrice != null) goto L34;
        this.sellingPrice = -1L;
    L34:
        if ((r103 & 1) != 0) goto L37;
        this.introduceStartTime = -1;
    L37:
        if ((r103 & 2) != 0) goto L72;
        this.introduceTimeLimit = -1;
        return;
    }
}
