package com.mdisdk.observer;

import D7.A;
import D7.q;
import D7.v;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.mdisdk.capability.model.WindowStateInfo;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ:\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/mdisdk/observer/AppDiedFilter;", "Lcom/mdisdk/observer/ObserverFilter;", "packageNames", "", "", "uids", "", WindowStateInfo.KEY_DISPLAY_ID, AppAgent.CONSTRUCT, "(Ljava/util/Set;Ljava/util/Set;Ljava/lang/Integer;)V", "getPackageNames", "()Ljava/util/Set;", "getUids", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "accept", "", "info", "", "withDisplayId", "withDisplayId$mdisdk_release", "component1", "component2", "component3", "copy", "(Ljava/util/Set;Ljava/util/Set;Ljava/lang/Integer;)Lcom/mdisdk/observer/AppDiedFilter;", "equals", "other", "hashCode", "toString", "Builder", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppDiedFilter implements ObserverFilter {
    private final Integer displayId;
    private final Set<String> packageNames;
    private final Set<Integer> uids;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final AppDiedFilter ACCEPT_ALL = new AppDiedFilter(null, null, null, 7, null);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\r\"\u00020\u0006¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010J\u0012\u0010\u0011\u001a\u00020\u00002\n\u0010\u0012\u001a\u00020\u0013\"\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/mdisdk/observer/AppDiedFilter$Builder;", "", AppAgent.CONSTRUCT, "()V", "packageNames", "", "", "uids", "", WindowStateInfo.KEY_DISPLAY_ID, "Ljava/lang/Integer;", "forPackage", "packages", "", "([Ljava/lang/String;)Lcom/mdisdk/observer/AppDiedFilter$Builder;", "forPackages", "", "forUid", "uidList", "", "forDisplay", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/mdisdk/observer/AppDiedFilter;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private Integer displayId;
        private Set<String> packageNames = new LinkedHashSet();
        private Set<Integer> uids = new LinkedHashSet();

        public final AppDiedFilter build() {
            return new AppDiedFilter(v.j1(this.packageNames), v.j1(this.uids), this.displayId);
        }

        public final Builder forDisplay(int displayId) {
            this.displayId = Integer.valueOf(displayId);
            return this;
        }

        public final Builder forPackage(String... packages) {
            k.f(packages, "packages");
            A.g0(this.packageNames, packages);
            return this;
        }

        public final Builder forPackages(Collection<String> packages) {
            k.f(packages, "packages");
            this.packageNames.addAll(packages);
            return this;
        }

        public final Builder forUid(int... uidList) {
            k.f(uidList, "uidList");
            this.uids.addAll(q.H0(uidList));
            return this;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J!\u0010\b\u001a\u00020\u00052\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0007¢\u0006\u0002\u0010\fJ\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/mdisdk/observer/AppDiedFilter$Companion;", "", AppAgent.CONSTRUCT, "()V", "ACCEPT_ALL", "Lcom/mdisdk/observer/AppDiedFilter;", "builder", "Lcom/mdisdk/observer/AppDiedFilter$Builder;", "forPackages", "packages", "", "", "([Ljava/lang/String;)Lcom/mdisdk/observer/AppDiedFilter;", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Builder builder() {
            return new Builder();
        }

        public final AppDiedFilter forPackages(String... packages) {
            k.f(packages, "packages");
            return new AppDiedFilter(q.K0(packages), null, null, 6, null);
        }

        private Companion() {
        }

        public final AppDiedFilter forPackages(Collection<String> packages) {
            k.f(packages, "packages");
            return new AppDiedFilter(v.j1(packages), null, null, 6, null);
        }
    }

    public AppDiedFilter() {
        this(null, null, null, 7, null);
    }

    public static final Builder builder() {
        return INSTANCE.builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppDiedFilter copy$default(AppDiedFilter appDiedFilter, Set set, Set set2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            set = appDiedFilter.packageNames;
        }
        if ((i & 2) != 0) {
            set2 = appDiedFilter.uids;
        }
        if ((i & 4) != 0) {
            num = appDiedFilter.displayId;
        }
        return appDiedFilter.copy(set, set2, num);
    }

    public static final AppDiedFilter forPackages(Collection<String> collection) {
        return INSTANCE.forPackages(collection);
    }

    @Override // com.mdisdk.observer.ObserverFilter
    public boolean accept(Object info) {
        k.f(info, "info");
        if (!(info instanceof AppDiedInfo)) {
            return false;
        }
        if (this.displayId != null) {
            int displayId = ((AppDiedInfo) info).getDisplayId();
            Integer num = this.displayId;
            if (num == null || displayId != num.intValue()) {
                return false;
            }
        }
        if (this.packageNames.isEmpty() || this.packageNames.contains(((AppDiedInfo) info).getPackageName())) {
            return this.uids.isEmpty() || this.uids.contains(Integer.valueOf(((AppDiedInfo) info).getUid()));
        }
        return false;
    }

    public final Set<String> component1() {
        return this.packageNames;
    }

    public final Set<Integer> component2() {
        return this.uids;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final AppDiedFilter copy(Set<String> packageNames, Set<Integer> uids, Integer displayId) {
        k.f(packageNames, "packageNames");
        k.f(uids, "uids");
        return new AppDiedFilter(packageNames, uids, displayId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppDiedFilter)) {
            return false;
        }
        AppDiedFilter appDiedFilter = (AppDiedFilter) other;
        return k.b(this.packageNames, appDiedFilter.packageNames) && k.b(this.uids, appDiedFilter.uids) && k.b(this.displayId, appDiedFilter.displayId);
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final Set<String> getPackageNames() {
        return this.packageNames;
    }

    public final Set<Integer> getUids() {
        return this.uids;
    }

    public int hashCode() {
        int iHashCode = (this.uids.hashCode() + (this.packageNames.hashCode() * 31)) * 31;
        Integer num = this.displayId;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "AppDiedFilter(packageNames=" + this.packageNames + ", uids=" + this.uids + ", displayId=" + this.displayId + ')';
    }

    public final AppDiedFilter withDisplayId$mdisdk_release(int displayId) {
        return copy$default(this, null, null, Integer.valueOf(displayId), 3, null);
    }

    public AppDiedFilter(Set set, Set set2, Integer num, int i, e eVar) {
        this((i & 1) != 0 ? EmptySet.f4895a : set, (i & 2) != 0 ? EmptySet.f4895a : set2, (i & 4) != 0 ? null : num);
    }

    public static final AppDiedFilter forPackages(String... strArr) {
        return INSTANCE.forPackages(strArr);
    }

    public AppDiedFilter(Set<String> packageNames, Set<Integer> uids, Integer num) {
        k.f(packageNames, "packageNames");
        k.f(uids, "uids");
        this.packageNames = packageNames;
        this.uids = uids;
        this.displayId = num;
    }
}
