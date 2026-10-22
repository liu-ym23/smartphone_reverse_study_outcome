package com.zyql.common.utils.update;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/zyql/common/utils/update/UpdateConfig;", "", "checkUpdateUrl", "", InjectExperienceResult.REASON_TIMEOUT, "", "downloadDirName", "wifiOnly", "", "showProgress", AppAgent.CONSTRUCT, "(Ljava/lang/String;JLjava/lang/String;ZZ)V", "getCheckUpdateUrl", "()Ljava/lang/String;", "getTimeout", "()J", "getDownloadDirName", "getWifiOnly", "()Z", "getShowProgress", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UpdateConfig {
    private final String checkUpdateUrl;
    private final String downloadDirName;
    private final boolean showProgress;
    private final long timeout;
    private final boolean wifiOnly;

    public UpdateConfig() {
        this(null, 0L, null, false, false, 31, null);
    }

    public static /* synthetic */ UpdateConfig copy$default(UpdateConfig updateConfig, String str, long j5, String str2, boolean z10, boolean z11, int i, Object obj) {
        if ((i & 1) != 0) {
            str = updateConfig.checkUpdateUrl;
        }
        if ((i & 2) != 0) {
            j5 = updateConfig.timeout;
        }
        if ((i & 4) != 0) {
            str2 = updateConfig.downloadDirName;
        }
        if ((i & 8) != 0) {
            z10 = updateConfig.wifiOnly;
        }
        if ((i & 16) != 0) {
            z11 = updateConfig.showProgress;
        }
        boolean z12 = z11;
        String str3 = str2;
        return updateConfig.copy(str, j5, str3, z10, z12);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCheckUpdateUrl() {
        return this.checkUpdateUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDownloadDirName() {
        return this.downloadDirName;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getWifiOnly() {
        return this.wifiOnly;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getShowProgress() {
        return this.showProgress;
    }

    public final UpdateConfig copy(String checkUpdateUrl, long timeout, String downloadDirName, boolean wifiOnly, boolean showProgress) {
        k.f(checkUpdateUrl, "checkUpdateUrl");
        k.f(downloadDirName, "downloadDirName");
        return new UpdateConfig(checkUpdateUrl, timeout, downloadDirName, wifiOnly, showProgress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateConfig)) {
            return false;
        }
        UpdateConfig updateConfig = (UpdateConfig) other;
        return k.b(this.checkUpdateUrl, updateConfig.checkUpdateUrl) && this.timeout == updateConfig.timeout && k.b(this.downloadDirName, updateConfig.downloadDirName) && this.wifiOnly == updateConfig.wifiOnly && this.showProgress == updateConfig.showProgress;
    }

    public final String getCheckUpdateUrl() {
        return this.checkUpdateUrl;
    }

    public final String getDownloadDirName() {
        return this.downloadDirName;
    }

    public final boolean getShowProgress() {
        return this.showProgress;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final boolean getWifiOnly() {
        return this.wifiOnly;
    }

    public int hashCode() {
        return Boolean.hashCode(this.showProgress) + androidx.appfunctions.metadata.a.d(B7.a.c(androidx.appfunctions.metadata.a.c(this.checkUpdateUrl.hashCode() * 31, 31, this.timeout), 31, this.downloadDirName), 31, this.wifiOnly);
    }

    public String toString() {
        return "UpdateConfig(checkUpdateUrl=" + this.checkUpdateUrl + ", timeout=" + this.timeout + ", downloadDirName=" + this.downloadDirName + ", wifiOnly=" + this.wifiOnly + ", showProgress=" + this.showProgress + ")";
    }

    public UpdateConfig(String checkUpdateUrl, long j5, String downloadDirName, boolean z10, boolean z11) {
        k.f(checkUpdateUrl, "checkUpdateUrl");
        k.f(downloadDirName, "downloadDirName");
        this.checkUpdateUrl = checkUpdateUrl;
        this.timeout = j5;
        this.downloadDirName = downloadDirName;
        this.wifiOnly = z10;
        this.showProgress = z11;
    }

    public /* synthetic */ UpdateConfig(String str, long j5, String str2, boolean z10, boolean z11, int i, e eVar) {
        this((i & 1) != 0 ? "https://avcs-api-test.zyql.com/api/version/check" : str, (i & 2) != 0 ? 30000L : j5, (i & 4) != 0 ? "update" : str2, (i & 8) != 0 ? false : z10, (i & 16) != 0 ? true : z11);
    }
}
