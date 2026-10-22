package com.stepos.ailauncher.network.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@JsonAdapter(DictionaryRequestTypeAdapter.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/network/model/DictionaryRequest;", "", "pkgName", "", "appVersion", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPkgName", "()Ljava/lang/String;", "getAppVersion", "getKey", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DictionaryRequest {

    @SerializedName("appVersion")
    private final String appVersion;

    @SerializedName("key")
    private final String key;

    @SerializedName("pkgName")
    private final String pkgName;

    public DictionaryRequest(String pkgName, String str, String key) {
        p.i(pkgName, "pkgName");
        p.i(key, "key");
        this.pkgName = pkgName;
        this.appVersion = str;
        this.key = key;
    }

    public static /* synthetic */ DictionaryRequest copy$default(DictionaryRequest dictionaryRequest, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = dictionaryRequest.pkgName;
        }
        if ((i10 & 2) != 0) {
            str2 = dictionaryRequest.appVersion;
        }
        if ((i10 & 4) != 0) {
            str3 = dictionaryRequest.key;
        }
        return dictionaryRequest.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPkgName() {
        return this.pkgName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component3, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final DictionaryRequest copy(String pkgName, String appVersion, String key) {
        p.i(pkgName, "pkgName");
        p.i(key, "key");
        return new DictionaryRequest(pkgName, appVersion, key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DictionaryRequest)) {
            return false;
        }
        DictionaryRequest dictionaryRequest = (DictionaryRequest) other;
        return p.d(this.pkgName, dictionaryRequest.pkgName) && p.d(this.appVersion, dictionaryRequest.appVersion) && p.d(this.key, dictionaryRequest.key);
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public int hashCode() {
        int iHashCode = this.pkgName.hashCode() * 31;
        String str = this.appVersion;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.key.hashCode();
    }

    public String toString() {
        return "DictionaryRequest(pkgName=" + this.pkgName + ", appVersion=" + this.appVersion + ", key=" + this.key + ")";
    }
}
