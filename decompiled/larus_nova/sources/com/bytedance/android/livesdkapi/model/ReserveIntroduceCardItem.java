package com.bytedance.android.livesdkapi.model;

import am3.g;
import com.bytedance.android.livesdkapi.depend.IntroduceCardType;
import com.bytedance.android.livesdkapi.model.gamecp.AtmosphereContent;
import com.bytedance.android.livesdkapi.model.gamecp.FeatureContent;
import com.bytedance.android.livesdkapi.model.gamecp.GameIntroduceCardTag;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.gamecp.api.ReserveIntroduceItem")
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b]\u0010^R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000bR$\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R/\u0010)\u001a\u0004\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012R/\u0010-\u001a\u0004\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010&\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012R/\u00101\u001a\u0004\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010&\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R+\u00105\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010&\u001a\u0004\b3\u0010\u0010\"\u0004\b4\u0010\u0012R+\u00109\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010&\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0012R+\u0010@\u001a\u00020:2\u0006\u0010$\u001a\u00020:8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b;\u0010&\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R+\u0010G\u001a\u00020A2\u0006\u0010$\u001a\u00020A8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bB\u0010&\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR+\u0010K\u001a\u00020A2\u0006\u0010$\u001a\u00020A8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010&\u001a\u0004\bI\u0010D\"\u0004\bJ\u0010FR+\u0010O\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010&\u001a\u0004\bM\u0010\u0010\"\u0004\bN\u0010\u0012R+\u0010V\u001a\u00020P2\u0006\u0010$\u001a\u00020P8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010&\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR/\u0010\\\u001a\u0004\u0018\u00010:2\b\u0010$\u001a\u0004\u0018\u00010:8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bW\u0010&\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006_"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ReserveIntroduceCardItem;", "", "Lcom/bytedance/android/livesdkapi/depend/IntroduceCardType;", "cardType", "Lcom/bytedance/android/livesdkapi/depend/IntroduceCardType;", "getCardType", "()Lcom/bytedance/android/livesdkapi/depend/IntroduceCardType;", "setCardType", "(Lcom/bytedance/android/livesdkapi/depend/IntroduceCardType;)V", "", "developer", "Ljava/lang/String;", "permissionUrl", "privacyUrl", "version", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "", "gameTagNames", "Ljava/util/List;", "iosSalePoint", "smallIcon", "Lcom/bytedance/android/livesdkapi/model/GameImageBundler;", "gameIcon", "Lcom/bytedance/android/livesdkapi/model/GameImageBundler;", "Lcom/bytedance/android/livesdkapi/model/gamecp/AtmosphereContent;", "atmosphereContent", "Lcom/bytedance/android/livesdkapi/model/gamecp/AtmosphereContent;", "Lcom/bytedance/android/livesdkapi/model/gamecp/FeatureContent;", "featureContent", "Lcom/bytedance/android/livesdkapi/model/gamecp/FeatureContent;", "Lcom/bytedance/android/livesdkapi/model/gamecp/GameIntroduceCardTag;", "introduceCardTag", "Lcom/bytedance/android/livesdkapi/model/gamecp/GameIntroduceCardTag;", "<set-?>", "gameId$delegate", "Ljava/lang/Object;", "getGameId", "setGameId", "gameId", "gameName$delegate", "getGameName", "setGameName", "gameName", "gameImage$delegate", "getGameImage", "setGameImage", "gameImage", "reserveTodayNum$delegate", "getReserveTodayNum", "setReserveTodayNum", "reserveTodayNum", "reserveTotalNum$delegate", "getReserveTotalNum", "setReserveTotalNum", "reserveTotalNum", "", "introduceStartTime$delegate", "getIntroduceStartTime", "()J", "setIntroduceStartTime", "(J)V", "introduceStartTime", "", "introduceTimeLimit$delegate", "getIntroduceTimeLimit", "()I", "setIntroduceTimeLimit", "(I)V", "introduceTimeLimit", "reserveStatus$delegate", "getReserveStatus", "setReserveStatus", "reserveStatus", "gameBackgroundColor$delegate", "getGameBackgroundColor", "setGameBackgroundColor", "gameBackgroundColor", "", "hasPlatformGift$delegate", "getHasPlatformGift", "()Z", "setHasPlatformGift", "(Z)V", "hasPlatformGift", "supportPlatform$delegate", "getSupportPlatform", "()Ljava/lang/Long;", "setSupportPlatform", "(Ljava/lang/Long;)V", "supportPlatform", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReserveIntroduceCardItem implements h {

    @SerializedName("game_background_color")
    protected String _$$gameBackgroundColor;

    @SerializedName("game_id")
    protected String _$$gameId;

    @SerializedName("game_image")
    protected String _$$gameImage;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    protected String _$$gameName;

    @SerializedName("has_platform_gift")
    protected boolean _$$hasPlatformGift;

    @SerializedName("introduce_start_time")
    protected long _$$introduceStartTime;

    @SerializedName("introduce_time_limit")
    protected int _$$introduceTimeLimit;

    @SerializedName("reserve_status")
    protected int _$$reserveStatus;

    @SerializedName("reserve_today_num")
    protected String _$$reserveTodayNum;

    @SerializedName("reserve_total_num")
    protected String _$$reserveTotalNum;

    @SerializedName("support_platforms")
    protected Long _$$supportPlatform;

    @SerializedName("atmosphere_content")
    public AtmosphereContent atmosphereContent;
    private IntroduceCardType cardType;

    @SerializedName("company_name")
    public String developer;

    @SerializedName("featured_content")
    public FeatureContent featureContent;

    @SerializedName("game_icon")
    public GameImageBundler gameIcon;

    @SerializedName("game_tag_names")
    public List<String> gameTagNames;

    @SerializedName("tag")
    public GameIntroduceCardTag introduceCardTag;

    @SerializedName("ios_sale_point")
    public String iosSalePoint;

    @SerializedName("android_authorization_url")
    public String permissionUrl;

    @SerializedName("android_privacy_url")
    public String privacyUrl;

    @SerializedName("small_icon")
    public String smallIcon;
    private String version;

    public ReserveIntroduceCardItem() {
        this.cardType = IntroduceCardType.RESERVE;
        this._$$gameId = null;
        this._$$gameName = null;
        this._$$gameImage = null;
        this._$$reserveTodayNum = "0";
        this._$$reserveTotalNum = "0";
        this._$$introduceStartTime = 0;
        this._$$introduceTimeLimit = 0;
        this._$$reserveStatus = 0;
        this._$$gameBackgroundColor = "";
        this._$$hasPlatformGift = false;
        this._$$supportPlatform = 0L;
        this.gameTagNames = CollectionsKt.emptyList();
        this.iosSalePoint = "";
    }

    public final IntroduceCardType getCardType() {
        return this.cardType;
    }

    public final String getGameBackgroundColor() {
        return this._$$gameBackgroundColor;
    }

    public final String getGameId() {
        return this._$$gameId;
    }

    public final String getGameImage() {
        return this._$$gameImage;
    }

    public final String getGameName() {
        return this._$$gameName;
    }

    public final boolean getHasPlatformGift() {
        return this._$$hasPlatformGift;
    }

    public final long getIntroduceStartTime() {
        return this._$$introduceStartTime;
    }

    public final int getIntroduceTimeLimit() {
        return this._$$introduceTimeLimit;
    }

    public final int getReserveStatus() {
        return this._$$reserveStatus;
    }

    public final String getReserveTodayNum() {
        return this._$$reserveTodayNum;
    }

    public final String getReserveTotalNum() {
        return this._$$reserveTotalNum;
    }

    public final Long getSupportPlatform() {
        return this._$$supportPlatform;
    }

    public final String getVersion() {
        return this.version;
    }

    public ReserveIntroduceCardItem(g r100) {
        this.gameTagNames = new ArrayList();
        this.cardType = IntroduceCardType.RESERVE;
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L28;
        switch(r103) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L14;
            case 15: goto L6;
            case 16: goto L6;
            case 17: goto L6;
            case 18: goto L13;
            case 19: goto L12;
            case 20: goto L11;
            case 21: goto L10;
            case 22: goto L9;
            case 23: goto L8;
            case 24: goto L6;
            case 25: goto L7;
            default: goto L6;
        };
    L7:
        this.introduceCardTag = new GameIntroduceCardTag(r100);
        goto L3
    L8:
        this.featureContent = new FeatureContent(r100);
        goto L3
    L9:
        this.atmosphereContent = new AtmosphereContent(r100);
        goto L3
    L10:
        this.gameIcon = new GameImageBundler(r100);
        goto L3
    L11:
        this.smallIcon = am3.h.c(r100);
        goto L3
    L12:
        this._$$supportPlatform = Long.valueOf(r100.j());
        goto L3
    L13:
        this._$$hasPlatformGift = am3.h.a(r100);
        r102 = r102 | 8;
        goto L3
    L14:
        this.permissionUrl = am3.h.c(r100);
        goto L3
    L15:
        this.privacyUrl = am3.h.c(r100);
        goto L3
    L16:
        this.iosSalePoint = am3.h.c(r100);
        goto L3
    L17:
        this.developer = am3.h.c(r100);
        goto L3
    L18:
        this._$$gameBackgroundColor = am3.h.c(r100);
        goto L3
    L19:
        this.gameTagNames.add(am3.h.c(r100));
        goto L3
    L20:
        this._$$reserveStatus = r100.i();
        r102 = r102 | 4;
        goto L3
    L21:
        this._$$introduceTimeLimit = r100.i();
        r102 = r102 | 2;
        goto L3
    L22:
        this._$$introduceStartTime = r100.j();
        r102 = r102 | 1;
        goto L3
    L23:
        this._$$reserveTotalNum = am3.h.c(r100);
        goto L3
    L24:
        this._$$reserveTodayNum = am3.h.c(r100);
        goto L3
    L25:
        this._$$gameImage = am3.h.c(r100);
        goto L3
    L26:
        this._$$gameName = am3.h.c(r100);
        goto L3
    L27:
        this._$$gameId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L28:
        r100.d(r101);
        if (this._$$gameId != null) goto L32;
        this._$$gameId = null;
    L32:
        if (this._$$gameName != null) goto L35;
        this._$$gameName = null;
    L35:
        if (this._$$gameImage != null) goto L38;
        this._$$gameImage = null;
    L38:
        if (this._$$reserveTodayNum != null) goto L41;
        this._$$reserveTodayNum = "0";
    L41:
        if (this._$$reserveTotalNum != null) goto L44;
        this._$$reserveTotalNum = "0";
    L44:
        if ((r102 & 1) != 0) goto L47;
        this._$$introduceStartTime = 0;
    L47:
        if ((r102 & 2) != 0) goto L50;
        this._$$introduceTimeLimit = 0;
    L50:
        if ((r102 & 4) != 0) goto L53;
        this._$$reserveStatus = 0;
    L53:
        if (this._$$gameBackgroundColor != null) goto L56;
        this._$$gameBackgroundColor = "";
    L56:
        if ((r102 & 8) != 0) goto L59;
        this._$$hasPlatformGift = false;
    L59:
        if (this._$$supportPlatform != null) goto L62;
        this._$$supportPlatform = 0L;
    L62:
        if (this.gameTagNames.isEmpty() == false) goto L65;
        this.gameTagNames = CollectionsKt.emptyList();
    L65:
        if (this.iosSalePoint != null) goto L114;
        this.iosSalePoint = "";
        return;
    }

    public final void setCardType(IntroduceCardType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cardType = r100;
    }

    public final void setGameBackgroundColor(String r100) {
        this._$$gameBackgroundColor = r100;
    }

    public final void setGameId(String r100) {
        this._$$gameId = r100;
    }

    public final void setGameImage(String r100) {
        this._$$gameImage = r100;
    }

    public final void setGameName(String r100) {
        this._$$gameName = r100;
    }

    public final void setHasPlatformGift(boolean r100) {
        this._$$hasPlatformGift = r100;
    }

    public final void setIntroduceStartTime(long r100) {
        this._$$introduceStartTime = r100;
    }

    public final void setIntroduceTimeLimit(int r100) {
        this._$$introduceTimeLimit = r100;
    }

    public final void setReserveStatus(int r100) {
        this._$$reserveStatus = r100;
    }

    public final void setReserveTodayNum(String r100) {
        this._$$reserveTodayNum = r100;
    }

    public final void setReserveTotalNum(String r100) {
        this._$$reserveTotalNum = r100;
    }

    public final void setSupportPlatform(Long r100) {
        this._$$supportPlatform = r100;
    }

    public final void setVersion(String r100) {
        this.version = r100;
    }
}
