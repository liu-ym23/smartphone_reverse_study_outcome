package com.stepos.taskrobot.dictionary.model;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/stepos/taskrobot/dictionary/model/WhitelistApp;", "", "appName", "", "packageName", "enabled", "", "recommendations", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getAppName", "()Ljava/lang/String;", "getPackageName", "getEnabled", "()Z", "getRecommendations", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WhitelistApp {
    private final String appName;
    private final boolean enabled;
    private final String packageName;
    private final List<String> recommendations;

    public WhitelistApp() {
        this(null, null, false, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WhitelistApp copy$default(WhitelistApp whitelistApp, String str, String str2, boolean z10, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = whitelistApp.appName;
        }
        if ((i & 2) != 0) {
            str2 = whitelistApp.packageName;
        }
        if ((i & 4) != 0) {
            z10 = whitelistApp.enabled;
        }
        if ((i & 8) != 0) {
            list = whitelistApp.recommendations;
        }
        return whitelistApp.copy(str, str2, z10, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> component4() {
        return this.recommendations;
    }

    public final WhitelistApp copy(String appName, String packageName, boolean enabled, List<String> recommendations) {
        k.f(appName, "appName");
        k.f(packageName, "packageName");
        k.f(recommendations, "recommendations");
        return new WhitelistApp(appName, packageName, enabled, recommendations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WhitelistApp)) {
            return false;
        }
        WhitelistApp whitelistApp = (WhitelistApp) other;
        return k.b(this.appName, whitelistApp.appName) && k.b(this.packageName, whitelistApp.packageName) && this.enabled == whitelistApp.enabled && k.b(this.recommendations, whitelistApp.recommendations);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final List<String> getRecommendations() {
        return this.recommendations;
    }

    public int hashCode() {
        return this.recommendations.hashCode() + a.d(B7.a.c(this.appName.hashCode() * 31, 31, this.packageName), 31, this.enabled);
    }

    public String toString() {
        String str = this.appName;
        String str2 = this.packageName;
        boolean z10 = this.enabled;
        List<String> list = this.recommendations;
        StringBuilder sbW = B7.a.w("WhitelistApp(appName=", str, ", packageName=", str2, ", enabled=");
        sbW.append(z10);
        sbW.append(", recommendations=");
        sbW.append(list);
        sbW.append(")");
        return sbW.toString();
    }

    public WhitelistApp(String appName, String packageName, boolean z10, List<String> recommendations) {
        k.f(appName, "appName");
        k.f(packageName, "packageName");
        k.f(recommendations, "recommendations");
        this.appName = appName;
        this.packageName = packageName;
        this.enabled = z10;
        this.recommendations = recommendations;
    }

    public WhitelistApp(String str, String str2, boolean z10, List list, int i, e eVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z10, (i & 8) != 0 ? EmptyList.f4893a : list);
    }
}
