package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR*\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\b¨\u0006."}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/a3;", "", "", "gameId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "gameName", "d", "setGameName", "", "scene", "Ljava/lang/Integer;", ce.f26395j, "()Ljava/lang/Integer;", "setScene", "(Ljava/lang/Integer;)V", "promoterId", ce.f26391f, "setPromoterId", "contentId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setContentId", "contentIdStr", "b", "setContentIdStr", "reserve_type", "h", "setReserve_type", "reserve_version_num", RXScreenCaptureService.KEY_INDEX, "setReserve_version_num", "", "game_package_names", "Ljava/util/List;", "e", "()Ljava/util/List;", "setGame_package_names", "(Ljava/util/List;)V", "planId", "f", "setPlanId", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a3 {

    @SerializedName("contentId")
    private Integer contentId;

    @SerializedName("contentIdStr")
    private String contentIdStr;

    @SerializedName("gameId")
    private String gameId;

    @SerializedName("gameName")
    private String gameName;

    @SerializedName("game_package_names")
    private List<String> game_package_names;

    @SerializedName("planId")
    private String planId;

    @SerializedName("promoterId")
    private String promoterId;

    @SerializedName("reserve_type")
    private Integer reserve_type;

    @SerializedName("reserve_version_num")
    private String reserve_version_num;

    @SerializedName("scene")
    private Integer scene;

    public a3() {
    }

    public final Integer a() {
        return this.contentId;
    }

    public final String b() {
        return this.contentIdStr;
    }

    public final String c() {
        return this.gameId;
    }

    public final String d() {
        return this.gameName;
    }

    public final List<String> e() {
        return this.game_package_names;
    }

    public final String f() {
        return this.planId;
    }

    public final String g() {
        return this.promoterId;
    }

    public final Integer h() {
        return this.reserve_type;
    }

    public final String i() {
        return this.reserve_version_num;
    }

    public final Integer j() {
        return this.scene;
    }
}
