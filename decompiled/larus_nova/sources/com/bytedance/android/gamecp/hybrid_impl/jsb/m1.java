package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\b¨\u0006("}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/m1;", "", "", "packageName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "schema", "f", "setSchema", "", "onlyCheck", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setOnlyCheck", "(Ljava/lang/Boolean;)V", "", "packageNameList", "Ljava/util/List;", "d", "()Ljava/util/List;", "setPackageNameList", "(Ljava/util/List;)V", "playType", "e", "setPlayType", "appId", "getAppId", "setAppId", "isAnchor", ce.f26391f, "setAnchor", "gameName", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setGameName", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m1 {

    @SerializedName("appId")
    private String appId;

    @SerializedName("gameName")
    private String gameName;

    @SerializedName("isAnchor")
    private Boolean isAnchor;

    @SerializedName("onlyCheck")
    private Boolean onlyCheck;

    @SerializedName("packageName")
    private String packageName;

    @SerializedName("packageNameList")
    private List<String> packageNameList;

    @SerializedName("playType")
    private String playType;

    @SerializedName("schema")
    private String schema;

    public m1() {
    }

    public final String a() {
        return this.gameName;
    }

    public final Boolean b() {
        return this.onlyCheck;
    }

    public final String c() {
        return this.packageName;
    }

    public final List<String> d() {
        return this.packageNameList;
    }

    public final String e() {
        return this.playType;
    }

    public final String f() {
        return this.schema;
    }

    public final Boolean g() {
        return this.isAnchor;
    }
}
