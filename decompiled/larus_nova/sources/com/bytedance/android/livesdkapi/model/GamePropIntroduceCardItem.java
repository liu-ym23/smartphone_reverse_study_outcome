package com.bytedance.android.livesdkapi.model;

import am3.g;
import com.bytedance.android.livesdkapi.depend.IntroduceCardType;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.gamecp.api.AnchorIntroducePropItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/GamePropIntroduceCardItem;", "", "()V", "cardType", "Lcom/bytedance/android/livesdkapi/depend/IntroduceCardType;", "getCardType", "()Lcom/bytedance/android/livesdkapi/depend/IntroduceCardType;", "setCardType", "(Lcom/bytedance/android/livesdkapi/depend/IntroduceCardType;)V", "gameId", "", "gameImage", "gameName", "introduceStartTime", "", "introduceTimeLimit", "", "isPropExpGame", "", "marketPrice", "Ljava/lang/Long;", "propIcon", "propId", "propName", "propType", "sellingPrice", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamePropIntroduceCardItem implements h {
    private IntroduceCardType cardType;

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

    public GamePropIntroduceCardItem() {
        this.cardType = IntroduceCardType.PROP;
        this.propId = "";
        this.propType = 1L;
        this.marketPrice = -1L;
        this.sellingPrice = -1L;
        this.introduceStartTime = -1;
        this.introduceTimeLimit = -1;
    }

    public final IntroduceCardType getCardType() {
        return this.cardType;
    }

    public GamePropIntroduceCardItem(g r100) {
        this.cardType = IntroduceCardType.PROP;
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L19;
        switch(r103) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L6;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        this.isPropExpGame = am3.h.a(r100);
        goto L3
    L8:
        this.propType = Long.valueOf(r100.j());
        goto L3
    L9:
        this.introduceTimeLimit = r100.i();
        r102 = r102 | 2;
        goto L3
    L10:
        this.introduceStartTime = r100.j();
        r102 = r102 | 1;
        goto L3
    L11:
        this.sellingPrice = Long.valueOf(r100.j());
        goto L3
    L12:
        this.marketPrice = Long.valueOf(r100.j());
        goto L3
    L13:
        this.propId = am3.h.c(r100);
        goto L3
    L14:
        this.propName = am3.h.c(r100);
        goto L3
    L15:
        this.gameImage = am3.h.c(r100);
        goto L3
    L16:
        this.gameId = am3.h.c(r100);
        goto L3
    L17:
        this.gameName = am3.h.c(r100);
        goto L3
    L18:
        this.propIcon = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L19:
        r100.d(r101);
        if (this.propId != null) goto L23;
        this.propId = "";
    L23:
        if (this.propType != null) goto L26;
        this.propType = 1L;
    L26:
        if (this.marketPrice != null) goto L29;
        this.marketPrice = -1L;
    L29:
        if (this.sellingPrice != null) goto L32;
        this.sellingPrice = -1L;
    L32:
        if ((r102 & 1) != 0) goto L35;
        this.introduceStartTime = -1;
    L35:
        if ((r102 & 2) != 0) goto L66;
        this.introduceTimeLimit = -1;
        return;
    }

    public final void setCardType(IntroduceCardType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cardType = r100;
    }
}
