package com.mdisdk.observer;

import D7.A;
import D7.q;
import D7.v;
import androidx.appfunctions.metadata.a;
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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0002$%BA\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014JH\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lcom/mdisdk/observer/ForegroundAppFilter;", "Lcom/mdisdk/observer/ObserverFilter;", "packageNames", "", "", "notifyOnAppChange", "", "notifyOnActivityChange", "notifyOnLeave", WindowStateInfo.KEY_DISPLAY_ID, "", AppAgent.CONSTRUCT, "(Ljava/util/Set;ZZZLjava/lang/Integer;)V", "getPackageNames", "()Ljava/util/Set;", "getNotifyOnAppChange", "()Z", "getNotifyOnActivityChange", "getNotifyOnLeave", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "accept", "info", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/Set;ZZZLjava/lang/Integer;)Lcom/mdisdk/observer/ForegroundAppFilter;", "equals", "other", "hashCode", "toString", "Builder", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ForegroundAppFilter implements ObserverFilter {
    private final Integer displayId;
    private final boolean notifyOnActivityChange;
    private final boolean notifyOnAppChange;
    private final boolean notifyOnLeave;
    private final Set<String> packageNames;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final ForegroundAppFilter ACCEPT_ALL = new ForegroundAppFilter(null, false, false, false, null, 31, null);
    public static final ForegroundAppFilter APP_CHANGE_ONLY = new ForegroundAppFilter(null, true, false, false, null, 25, null);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0010\"\u00020\u0006¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0019\u001a\u00020\u001aR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/mdisdk/observer/ForegroundAppFilter$Builder;", "", AppAgent.CONSTRUCT, "()V", "packageNames", "", "", "notifyOnAppChange", "", "notifyOnActivityChange", "notifyOnLeave", WindowStateInfo.KEY_DISPLAY_ID, "", "Ljava/lang/Integer;", "forPackage", "packages", "", "([Ljava/lang/String;)Lcom/mdisdk/observer/ForegroundAppFilter$Builder;", "forPackages", "", "onAppChange", "notify", "onActivityChange", "onLeave", "forDisplay", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/mdisdk/observer/ForegroundAppFilter;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private Integer displayId;
        private boolean notifyOnLeave;
        private Set<String> packageNames = new LinkedHashSet();
        private boolean notifyOnAppChange = true;
        private boolean notifyOnActivityChange = true;

        public final ForegroundAppFilter build() {
            return new ForegroundAppFilter(v.j1(this.packageNames), this.notifyOnAppChange, this.notifyOnActivityChange, this.notifyOnLeave, this.displayId);
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

        public final Builder onActivityChange(boolean notify) {
            this.notifyOnActivityChange = notify;
            return this;
        }

        public final Builder onAppChange(boolean notify) {
            this.notifyOnAppChange = notify;
            return this;
        }

        public final Builder onLeave(boolean notify) {
            this.notifyOnLeave = notify;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0007J!\u0010\t\u001a\u00020\u00052\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\fH\u0007¢\u0006\u0002\u0010\rJ\u0016\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/mdisdk/observer/ForegroundAppFilter$Companion;", "", AppAgent.CONSTRUCT, "()V", "ACCEPT_ALL", "Lcom/mdisdk/observer/ForegroundAppFilter;", "APP_CHANGE_ONLY", "builder", "Lcom/mdisdk/observer/ForegroundAppFilter$Builder;", "forPackages", "packages", "", "", "([Ljava/lang/String;)Lcom/mdisdk/observer/ForegroundAppFilter;", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Builder builder() {
            return new Builder();
        }

        public final ForegroundAppFilter forPackages(String... packages) {
            k.f(packages, "packages");
            return new ForegroundAppFilter(q.K0(packages), false, false, false, null, 30, null);
        }

        private Companion() {
        }

        public final ForegroundAppFilter forPackages(Collection<String> packages) {
            k.f(packages, "packages");
            return new ForegroundAppFilter(v.j1(packages), false, false, false, null, 30, null);
        }
    }

    public ForegroundAppFilter() {
        this(null, false, false, false, null, 31, null);
    }

    public static final Builder builder() {
        return INSTANCE.builder();
    }

    public static /* synthetic */ ForegroundAppFilter copy$default(ForegroundAppFilter foregroundAppFilter, Set set, boolean z10, boolean z11, boolean z12, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            set = foregroundAppFilter.packageNames;
        }
        if ((i & 2) != 0) {
            z10 = foregroundAppFilter.notifyOnAppChange;
        }
        if ((i & 4) != 0) {
            z11 = foregroundAppFilter.notifyOnActivityChange;
        }
        if ((i & 8) != 0) {
            z12 = foregroundAppFilter.notifyOnLeave;
        }
        if ((i & 16) != 0) {
            num = foregroundAppFilter.displayId;
        }
        Integer num2 = num;
        boolean z13 = z11;
        return foregroundAppFilter.copy(set, z10, z13, z12, num2);
    }

    public static final ForegroundAppFilter forPackages(Collection<String> collection) {
        return INSTANCE.forPackages(collection);
    }

    @Override // com.mdisdk.observer.ObserverFilter
    public boolean accept(Object info) {
        k.f(info, "info");
        if (!(info instanceof ForegroundAppInfo)) {
            return false;
        }
        if (this.displayId != null) {
            int displayId = ((ForegroundAppInfo) info).getDisplayId();
            Integer num = this.displayId;
            if (num == null || displayId != num.intValue()) {
                return false;
            }
        }
        if (!this.packageNames.isEmpty()) {
            ForegroundAppInfo foregroundAppInfo = (ForegroundAppInfo) info;
            boolean zContains = this.packageNames.contains(foregroundAppInfo.getPackageName());
            boolean z10 = this.notifyOnLeave && v.u0(this.packageNames, foregroundAppInfo.getPreviousPackageName());
            if (!zContains && !z10) {
                return false;
            }
        }
        ForegroundAppInfo foregroundAppInfo2 = (ForegroundAppInfo) info;
        if (!foregroundAppInfo2.isAppChanged() && foregroundAppInfo2.isActivityChanged()) {
            return this.notifyOnActivityChange;
        }
        return this.notifyOnAppChange;
    }

    public final Set<String> component1() {
        return this.packageNames;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getNotifyOnAppChange() {
        return this.notifyOnAppChange;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getNotifyOnActivityChange() {
        return this.notifyOnActivityChange;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getNotifyOnLeave() {
        return this.notifyOnLeave;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final ForegroundAppFilter copy(Set<String> packageNames, boolean notifyOnAppChange, boolean notifyOnActivityChange, boolean notifyOnLeave, Integer displayId) {
        k.f(packageNames, "packageNames");
        return new ForegroundAppFilter(packageNames, notifyOnAppChange, notifyOnActivityChange, notifyOnLeave, displayId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForegroundAppFilter)) {
            return false;
        }
        ForegroundAppFilter foregroundAppFilter = (ForegroundAppFilter) other;
        return k.b(this.packageNames, foregroundAppFilter.packageNames) && this.notifyOnAppChange == foregroundAppFilter.notifyOnAppChange && this.notifyOnActivityChange == foregroundAppFilter.notifyOnActivityChange && this.notifyOnLeave == foregroundAppFilter.notifyOnLeave && k.b(this.displayId, foregroundAppFilter.displayId);
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final boolean getNotifyOnActivityChange() {
        return this.notifyOnActivityChange;
    }

    public final boolean getNotifyOnAppChange() {
        return this.notifyOnAppChange;
    }

    public final boolean getNotifyOnLeave() {
        return this.notifyOnLeave;
    }

    public final Set<String> getPackageNames() {
        return this.packageNames;
    }

    public int hashCode() {
        int iD = a.d(a.d(a.d(this.packageNames.hashCode() * 31, 31, this.notifyOnAppChange), 31, this.notifyOnActivityChange), 31, this.notifyOnLeave);
        Integer num = this.displayId;
        return iD + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "ForegroundAppFilter(packageNames=" + this.packageNames + ", notifyOnAppChange=" + this.notifyOnAppChange + ", notifyOnActivityChange=" + this.notifyOnActivityChange + ", notifyOnLeave=" + this.notifyOnLeave + ", displayId=" + this.displayId + ')';
    }

    public ForegroundAppFilter(Set<String> packageNames, boolean z10, boolean z11, boolean z12, Integer num) {
        k.f(packageNames, "packageNames");
        this.packageNames = packageNames;
        this.notifyOnAppChange = z10;
        this.notifyOnActivityChange = z11;
        this.notifyOnLeave = z12;
        this.displayId = num;
    }

    public static final ForegroundAppFilter forPackages(String... strArr) {
        return INSTANCE.forPackages(strArr);
    }

    public ForegroundAppFilter(Set set, boolean z10, boolean z11, boolean z12, Integer num, int i, e eVar) {
        this((i & 1) != 0 ? EmptySet.f4895a : set, (i & 2) != 0 ? true : z10, (i & 4) != 0 ? true : z11, (i & 8) != 0 ? false : z12, (i & 16) != 0 ? null : num);
    }
}
