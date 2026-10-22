package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006!"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/c5;", "", "", "schema", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "gameId", "c", "setGameId", "", "enterFrom", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setEnterFrom", "(Ljava/lang/Integer;)V", "scene", "e", "setScene", "contentId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setContentId", "isAnchor", "f", "setAnchor", "promoterId", "d", "setPromoterId", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c5 {

    @SerializedName("contentId")
    private String contentId;

    @SerializedName("enterFrom")
    private Integer enterFrom;

    @SerializedName("gameId")
    private String gameId;

    @SerializedName("isAnchor")
    private Integer isAnchor;

    @SerializedName("promoterId")
    private String promoterId;

    @SerializedName("scene")
    private Integer scene;

    @SerializedName("schema")
    private String schema;

    public c5() {
    }

    public final String a() {
        return this.contentId;
    }

    public final Integer b() {
        return this.enterFrom;
    }

    public final String c() {
        return this.gameId;
    }

    public final String d() {
        return this.promoterId;
    }

    public final Integer e() {
        return this.scene;
    }

    public final Integer f() {
        return this.isAnchor;
    }
}
