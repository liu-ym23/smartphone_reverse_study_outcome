package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.ReserveIntroduceItem")
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bJ\u0010KR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b6\u0010\u0004R\u0018\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b7\u0010\u0004R\u0018\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b8\u0010\u0004R\u001e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b<\u0010\u0004R\u0018\u0010=\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b=\u0010\u0004R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006L"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/v;", "", "", "gameId", "Ljava/lang/String;", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "gameName", "getGameName", "setGameName", "gameImage", "getGameImage", "setGameImage", "reserveTodayNum", "getReserveTodayNum", "setReserveTodayNum", "reserveTotalNum", "getReserveTotalNum", "setReserveTotalNum", "", "introduceStartTime", "J", "getIntroduceStartTime", "()J", "setIntroduceStartTime", "(J)V", "", "introduceTimeLimit", "I", "getIntroduceTimeLimit", "()I", "setIntroduceTimeLimit", "(I)V", "reserveStatus", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "gameBackgroundColor", "getGameBackgroundColor", "setGameBackgroundColor", "", "hasPlatformGift", "Z", "getHasPlatformGift", "()Z", "setHasPlatformGift", "(Z)V", "supportPlatform", "Ljava/lang/Long;", "getSupportPlatform", "()Ljava/lang/Long;", "setSupportPlatform", "(Ljava/lang/Long;)V", "developer", "permissionUrl", "privacyUrl", "", "gameTagNames", "Ljava/util/List;", "salePoint", "smallIcon", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "gameIcon", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/a;", "atmosphereContent", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/a;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/e;", "featureContent", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/e;", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/j;", "introduceCardTag", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/j;", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v implements vh7.h {

    @SerializedName("atmosphere_content")
    public a atmosphereContent;

    @SerializedName("company_name")
    public String developer;

    @SerializedName("featured_content")
    public e featureContent;

    @SerializedName("game_background_color")
    protected String gameBackgroundColor;

    @SerializedName("game_icon")
    public GameImageBundler gameIcon;

    @SerializedName("game_id")
    protected String gameId;

    @SerializedName("game_image")
    protected String gameImage;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    protected String gameName;

    @SerializedName("game_tag_names")
    public List<String> gameTagNames;

    @SerializedName("has_platform_gift")
    protected boolean hasPlatformGift;

    @SerializedName("tag")
    public j introduceCardTag;

    @SerializedName("introduce_start_time")
    protected long introduceStartTime;

    @SerializedName("introduce_time_limit")
    protected int introduceTimeLimit;

    @SerializedName("android_authorization_url")
    public String permissionUrl;

    @SerializedName("android_privacy_url")
    public String privacyUrl;

    @SerializedName("reserve_status")
    protected int reserveStatus;

    @SerializedName("reserve_today_num")
    protected String reserveTodayNum;

    @SerializedName("reserve_total_num")
    protected String reserveTotalNum;

    @SerializedName("ios_sale_point")
    public String salePoint;

    @SerializedName("small_icon")
    public String smallIcon;

    @SerializedName("support_platforms")
    protected Long supportPlatform;

    public v() {
        IntroduceCardType r100 = IntroduceCardType.GAME;
        this.reserveTodayNum = "0";
        this.reserveTotalNum = "0";
        this.gameBackgroundColor = "";
        this.supportPlatform = 0L;
        this.gameTagNames = CollectionsKt.emptyList();
        this.salePoint = "";
    }

    public final int a() {
        return this.reserveStatus;
    }

    public v(am3.g r100) {
        this.gameTagNames = new ArrayList();
        IntroduceCardType r101 = IntroduceCardType.GAME;
        long r102 = r100.c();
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
        this.introduceCardTag = new j(r100);
        goto L3
    L8:
        this.featureContent = new e(r100);
        goto L3
    L9:
        this.atmosphereContent = new a(r100);
        goto L3
    L10:
        this.gameIcon = new GameImageBundler(r100);
        goto L3
    L11:
        this.smallIcon = am3.h.c(r100);
        goto L3
    L12:
        this.supportPlatform = Long.valueOf(r100.j());
        goto L3
    L13:
        this.hasPlatformGift = am3.h.a(r100);
        goto L3
    L14:
        this.permissionUrl = am3.h.c(r100);
        goto L3
    L15:
        this.privacyUrl = am3.h.c(r100);
        goto L3
    L16:
        this.salePoint = am3.h.c(r100);
        goto L3
    L17:
        this.developer = am3.h.c(r100);
        goto L3
    L18:
        this.gameBackgroundColor = am3.h.c(r100);
        goto L3
    L19:
        this.gameTagNames.add(am3.h.c(r100));
        goto L3
    L20:
        this.reserveStatus = r100.i();
        goto L3
    L21:
        this.introduceTimeLimit = r100.i();
        goto L3
    L22:
        this.introduceStartTime = r100.j();
        goto L3
    L23:
        this.reserveTotalNum = am3.h.c(r100);
        goto L3
    L24:
        this.reserveTodayNum = am3.h.c(r100);
        goto L3
    L25:
        this.gameImage = am3.h.c(r100);
        goto L3
    L26:
        this.gameName = am3.h.c(r100);
        goto L3
    L27:
        this.gameId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L28:
        r100.d(r102);
        if (this.reserveTodayNum != null) goto L32;
        this.reserveTodayNum = "0";
    L32:
        if (this.reserveTotalNum != null) goto L35;
        this.reserveTotalNum = "0";
    L35:
        if (this.gameBackgroundColor != null) goto L38;
        this.gameBackgroundColor = "";
    L38:
        if (this.supportPlatform != null) goto L41;
        this.supportPlatform = 0L;
    L41:
        if (this.gameTagNames.isEmpty() == false) goto L44;
        this.gameTagNames = CollectionsKt.emptyList();
    L44:
        if (this.salePoint != null) goto L93;
        this.salePoint = "";
        return;
    }

    public final void b(int r100) {
        this.reserveStatus = r100;
    }
}
