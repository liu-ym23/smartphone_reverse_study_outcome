package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/c;", "", "", "contentTitle", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setContentTitle", "(Ljava/lang/String;)V", "contentUrl", "c", "setContentUrl", "complianceData", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setComplianceData", "downloadUrl", "d", "setDownloadUrl", "pkgName", "f", "setPkgName", "name", "e", "setName", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("android_compliance_data")
    private String complianceData;

    @SerializedName("android_game_name")
    private String contentTitle;

    @SerializedName("android_orange_url")
    private String contentUrl;

    @SerializedName("android_download_url")
    private String downloadUrl;

    @SerializedName("android_name")
    private String name;

    @SerializedName("android_pkg_name")
    private String pkgName;

    public c() {
        this.contentTitle = "";
        this.contentUrl = "";
        this.complianceData = "";
        this.downloadUrl = "";
        this.pkgName = "";
        this.name = "";
    }

    public final String a() {
        return this.complianceData;
    }

    public final String b() {
        return this.contentTitle;
    }

    public final String c() {
        return this.contentUrl;
    }

    public final String d() {
        return this.downloadUrl;
    }

    public final String e() {
        return this.name;
    }

    public final String f() {
        return this.pkgName;
    }
}
