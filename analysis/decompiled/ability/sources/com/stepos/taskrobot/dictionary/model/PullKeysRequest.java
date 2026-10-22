package com.stepos.taskrobot.dictionary.model;

import B7.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/stepos/taskrobot/dictionary/model/PullKeysRequest;", "", "pkgName", "", "appVersion", "type", "pageIndex", "", "pageSize", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getPkgName", "()Ljava/lang/String;", "getAppVersion", "getType", "getPageIndex", "()I", "getPageSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PullKeysRequest {

    @SerializedName("appVersion")
    private final String appVersion;

    @SerializedName("pageIndex")
    private final int pageIndex;

    @SerializedName("pageSize")
    private final int pageSize;

    @SerializedName("pkgName")
    private final String pkgName;

    @SerializedName("type")
    private final String type;

    public PullKeysRequest(String pkgName, String appVersion, String str, int i, int i6) {
        k.f(pkgName, "pkgName");
        k.f(appVersion, "appVersion");
        this.pkgName = pkgName;
        this.appVersion = appVersion;
        this.type = str;
        this.pageIndex = i;
        this.pageSize = i6;
    }

    public static /* synthetic */ PullKeysRequest copy$default(PullKeysRequest pullKeysRequest, String str, String str2, String str3, int i, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = pullKeysRequest.pkgName;
        }
        if ((i10 & 2) != 0) {
            str2 = pullKeysRequest.appVersion;
        }
        if ((i10 & 4) != 0) {
            str3 = pullKeysRequest.type;
        }
        if ((i10 & 8) != 0) {
            i = pullKeysRequest.pageIndex;
        }
        if ((i10 & 16) != 0) {
            i6 = pullKeysRequest.pageSize;
        }
        int i11 = i6;
        String str4 = str3;
        return pullKeysRequest.copy(str, str2, str4, i, i11);
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
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    public final PullKeysRequest copy(String pkgName, String appVersion, String type, int pageIndex, int pageSize) {
        k.f(pkgName, "pkgName");
        k.f(appVersion, "appVersion");
        return new PullKeysRequest(pkgName, appVersion, type, pageIndex, pageSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PullKeysRequest)) {
            return false;
        }
        PullKeysRequest pullKeysRequest = (PullKeysRequest) other;
        return k.b(this.pkgName, pullKeysRequest.pkgName) && k.b(this.appVersion, pullKeysRequest.appVersion) && k.b(this.type, pullKeysRequest.type) && this.pageIndex == pullKeysRequest.pageIndex && this.pageSize == pullKeysRequest.pageSize;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iC = a.c(this.pkgName.hashCode() * 31, 31, this.appVersion);
        String str = this.type;
        return Integer.hashCode(this.pageSize) + androidx.constraintlayout.core.dsl.a.a(this.pageIndex, (iC + (str == null ? 0 : str.hashCode())) * 31, 31);
    }

    public String toString() {
        String str = this.pkgName;
        String str2 = this.appVersion;
        String str3 = this.type;
        int i = this.pageIndex;
        int i6 = this.pageSize;
        StringBuilder sbW = a.w("PullKeysRequest(pkgName=", str, ", appVersion=", str2, ", type=");
        b.B(sbW, str3, ", pageIndex=", i, ", pageSize=");
        return androidx.appfunctions.metadata.a.o(sbW, ")", i6);
    }

    public /* synthetic */ PullKeysRequest(String str, String str2, String str3, int i, int i6, int i10, e eVar) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? 1 : i, (i10 & 16) != 0 ? 50 : i6);
    }
}
