package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.amap.api.col.s.ce;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/l3;", "", "", "unifiedGameId", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setUnifiedGameId", "(Ljava/lang/String;)V", "promoterId", "b", "setPromoterId", "scene", "e", "setScene", "actionString", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setActionString", "roomId", "d", "setRoomId", "", "isAds", "Ljava/lang/Integer;", ce.f26391f, "()Ljava/lang/Integer;", "setAds", "(Ljava/lang/Integer;)V", "requestId", "c", "setRequestId", "isPromotionGame", "h", "setPromotionGame", "Lcom/google/gson/JsonObject;", "extra", "Lcom/google/gson/JsonObject;", "getExtra", "()Lcom/google/gson/JsonObject;", "setExtra", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l3 {

    @SerializedName("actionString")
    private String actionString;

    @SerializedName("extra")
    private JsonObject extra;

    @SerializedName("isAds")
    private Integer isAds;

    @SerializedName("isPromotionGame")
    private Integer isPromotionGame;

    @SerializedName("promoterId")
    private String promoterId;

    @SerializedName("requestId")
    private String requestId;

    @SerializedName("roomId")
    private String roomId;

    @SerializedName("scene")
    private String scene;

    @SerializedName("unifiedGameId")
    private String unifiedGameId;

    public l3() {
    }

    public final String a() {
        return this.actionString;
    }

    public final String b() {
        return this.promoterId;
    }

    public final String c() {
        return this.requestId;
    }

    public final String d() {
        return this.roomId;
    }

    public final String e() {
        return this.scene;
    }

    public final String f() {
        return this.unifiedGameId;
    }

    public final Integer g() {
        return this.isAds;
    }

    public final Integer h() {
        return this.isPromotionGame;
    }
}
