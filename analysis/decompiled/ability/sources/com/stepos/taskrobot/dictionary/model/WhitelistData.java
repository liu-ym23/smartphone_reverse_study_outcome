package com.stepos.taskrobot.dictionary.model;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/stepos/taskrobot/dictionary/model/WhitelistData;", "", "apps", "", "Lcom/stepos/taskrobot/dictionary/model/WhitelistApp;", "redirectGroups", "Lcom/stepos/taskrobot/dictionary/model/RedirectGroup;", AppAgent.CONSTRUCT, "(Ljava/util/List;Ljava/util/List;)V", "getApps", "()Ljava/util/List;", "getRedirectGroups", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WhitelistData {
    private final List<WhitelistApp> apps;
    private final List<RedirectGroup> redirectGroups;

    public WhitelistData() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WhitelistData copy$default(WhitelistData whitelistData, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = whitelistData.apps;
        }
        if ((i & 2) != 0) {
            list2 = whitelistData.redirectGroups;
        }
        return whitelistData.copy(list, list2);
    }

    public final List<WhitelistApp> component1() {
        return this.apps;
    }

    public final List<RedirectGroup> component2() {
        return this.redirectGroups;
    }

    public final WhitelistData copy(List<WhitelistApp> apps, List<RedirectGroup> redirectGroups) {
        k.f(apps, "apps");
        k.f(redirectGroups, "redirectGroups");
        return new WhitelistData(apps, redirectGroups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WhitelistData)) {
            return false;
        }
        WhitelistData whitelistData = (WhitelistData) other;
        return k.b(this.apps, whitelistData.apps) && k.b(this.redirectGroups, whitelistData.redirectGroups);
    }

    public final List<WhitelistApp> getApps() {
        return this.apps;
    }

    public final List<RedirectGroup> getRedirectGroups() {
        return this.redirectGroups;
    }

    public int hashCode() {
        return this.redirectGroups.hashCode() + (this.apps.hashCode() * 31);
    }

    public String toString() {
        return "WhitelistData(apps=" + this.apps + ", redirectGroups=" + this.redirectGroups + ")";
    }

    public WhitelistData(List list, List list2, int i, e eVar) {
        this((i & 1) != 0 ? EmptyList.f4893a : list, (i & 2) != 0 ? EmptyList.f4893a : list2);
    }

    public WhitelistData(List<WhitelistApp> apps, List<RedirectGroup> redirectGroups) {
        k.f(apps, "apps");
        k.f(redirectGroups, "redirectGroups");
        this.apps = apps;
        this.redirectGroups = redirectGroups;
    }
}
