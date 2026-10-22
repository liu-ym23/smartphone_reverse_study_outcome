package com.stepos.taskrobot.appwhitelist.model;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/model/AppEntry;", "", "appName", "", "enabled", "", "recommendations", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;ZLjava/util/List;)V", "getAppName", "()Ljava/lang/String;", "getEnabled", "()Z", "getRecommendations", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppEntry {
    private final String appName;
    private final boolean enabled;
    private final List<String> recommendations;

    public AppEntry(String appName, boolean z10, List<String> recommendations) {
        k.f(appName, "appName");
        k.f(recommendations, "recommendations");
        this.appName = appName;
        this.enabled = z10;
        this.recommendations = recommendations;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppEntry copy$default(AppEntry appEntry, String str, boolean z10, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appEntry.appName;
        }
        if ((i & 2) != 0) {
            z10 = appEntry.enabled;
        }
        if ((i & 4) != 0) {
            list = appEntry.recommendations;
        }
        return appEntry.copy(str, z10, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> component3() {
        return this.recommendations;
    }

    public final AppEntry copy(String appName, boolean enabled, List<String> recommendations) {
        k.f(appName, "appName");
        k.f(recommendations, "recommendations");
        return new AppEntry(appName, enabled, recommendations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppEntry)) {
            return false;
        }
        AppEntry appEntry = (AppEntry) other;
        return k.b(this.appName, appEntry.appName) && this.enabled == appEntry.enabled && k.b(this.recommendations, appEntry.recommendations);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> getRecommendations() {
        return this.recommendations;
    }

    public int hashCode() {
        return this.recommendations.hashCode() + a.d(this.appName.hashCode() * 31, 31, this.enabled);
    }

    public String toString() {
        String str = this.appName;
        boolean z10 = this.enabled;
        return a.q(androidx.constraintlayout.core.dsl.a.l("AppEntry(appName=", str, ", enabled=", ", recommendations=", z10), this.recommendations, ")");
    }
}
