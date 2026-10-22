package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/k3;", "", "", "gameId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "gameName", "d", "setGameName", "promoterId", "f", "setPromoterId", "roomId", "h", "setRoomId", "videoId", ce.f26395j, "setVideoId", "scene", RXScreenCaptureService.KEY_INDEX, "setScene", "promoteInstanceId", "e", "setPromoteInstanceId", "reportParams", ce.f26391f, "setReportParams", "componentTypeString", "b", "setComponentTypeString", "", "componentAction", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setComponentAction", "(Ljava/lang/Integer;)V", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k3 {

    @SerializedName("componentAction")
    private Integer componentAction;

    @SerializedName("componentTypeString")
    private String componentTypeString;

    @SerializedName("gameId")
    private String gameId;

    @SerializedName("gameName")
    private String gameName;

    @SerializedName("promoteInstanceId")
    private String promoteInstanceId;

    @SerializedName("promoterId")
    private String promoterId;

    @SerializedName("reportParams")
    private String reportParams;

    @SerializedName("roomId")
    private String roomId;

    @SerializedName("scene")
    private String scene;

    @SerializedName("videoId")
    private String videoId;

    public k3() {
    }

    public final Integer a() {
        return this.componentAction;
    }

    public final String b() {
        return this.componentTypeString;
    }

    public final String c() {
        return this.gameId;
    }

    public final String d() {
        return this.gameName;
    }

    public final String e() {
        return this.promoteInstanceId;
    }

    public final String f() {
        return this.promoterId;
    }

    public final String g() {
        return this.reportParams;
    }

    public final String h() {
        return this.roomId;
    }

    public final String i() {
        return this.scene;
    }

    public final String j() {
        return this.videoId;
    }
}
