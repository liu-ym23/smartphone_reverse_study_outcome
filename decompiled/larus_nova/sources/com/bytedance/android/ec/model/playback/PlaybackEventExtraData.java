package com.bytedance.android.ec.model.playback;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0001$Bq\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001e¨\u0006%"}, d2 = {"Lcom/bytedance/android/ec/model/playback/PlaybackEventExtraData;", "Ljava/io/Serializable;", "", "userId", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "followStatus", "getFollowStatus", "setFollowStatus", "withSku", "getWithSku", "setWithSku", "commodityType", "getCommodityType", "setCommodityType", "fromLive", "getFromLive", "shareSearchPlayerId", "getShareSearchPlayerId", "setShareSearchPlayerId", "awemeId", "getAwemeId", "setAwemeId", "", "modelType", "Ljava/lang/Integer;", "getModelType", "()Ljava/lang/Integer;", "replayStartTime", "getReplayStartTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PlaybackEventExtraData implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private String awemeId;
    private String commodityType;
    private String followStatus;
    private final String fromLive;
    private final Integer modelType;
    private final Integer replayStartTime;
    private String shareSearchPlayerId;
    private String userId;
    private String withSku;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PlaybackEventExtraData() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public final String getAwemeId() {
        return this.awemeId;
    }

    public final String getCommodityType() {
        return this.commodityType;
    }

    public final String getFollowStatus() {
        return this.followStatus;
    }

    public final String getFromLive() {
        return this.fromLive;
    }

    public final Integer getModelType() {
        return this.modelType;
    }

    public final Integer getReplayStartTime() {
        return this.replayStartTime;
    }

    public final String getShareSearchPlayerId() {
        return this.shareSearchPlayerId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getWithSku() {
        return this.withSku;
    }

    public final void setAwemeId(String r100) {
        this.awemeId = r100;
    }

    public final void setCommodityType(String r100) {
        this.commodityType = r100;
    }

    public final void setFollowStatus(String r100) {
        this.followStatus = r100;
    }

    public final void setShareSearchPlayerId(String r100) {
        this.shareSearchPlayerId = r100;
    }

    public final void setUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userId = r100;
    }

    public final void setWithSku(String r100) {
        this.withSku = r100;
    }

    public PlaybackEventExtraData(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r107, Integer r110) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.userId = r100;
        this.followStatus = r101;
        this.withSku = r102;
        this.commodityType = r103;
        this.fromLive = r104;
        this.shareSearchPlayerId = r105;
        this.awemeId = r106;
        this.modelType = r107;
        this.replayStartTime = r110;
    }

    public /* synthetic */ PlaybackEventExtraData(String r110, String r111, String r112, String r113, String r114, String r115, String r116, Integer r117, Integer r118, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = "";
    L6:
        Integer r101 = null;
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) != 0) goto L35;
        r101 = r117;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Integer r108 = 0;
    L38:
        this(r100, r102, r103, r104, r105, r106, r107, r101, r108);
        return;
    L37:
        r108 = r118;
        goto L38
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
