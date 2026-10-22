package com.mdisdk.observer;

import D7.A;
import D7.q;
import D7.v;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.observer.VisibleWindowInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0002+,Ba\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019Jh\u0010%\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Lcom/mdisdk/observer/VisibleWindowFilter;", "Lcom/mdisdk/observer/ObserverFilter;", "packageNames", "", "", "windowTypes", "", "changeTypes", "Lcom/mdisdk/observer/VisibleWindowInfo$ChangeType;", "applicationWindowsOnly", "", "focusChangeOnly", "includeOverlay", WindowStateInfo.KEY_DISPLAY_ID, AppAgent.CONSTRUCT, "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;ZZZLjava/lang/Integer;)V", "getPackageNames", "()Ljava/util/Set;", "getWindowTypes", "getChangeTypes", "getApplicationWindowsOnly", "()Z", "getFocusChangeOnly", "getIncludeOverlay", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "accept", "info", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;ZZZLjava/lang/Integer;)Lcom/mdisdk/observer/VisibleWindowFilter;", "equals", "other", "hashCode", "toString", "Builder", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VisibleWindowFilter implements ObserverFilter {
    private final boolean applicationWindowsOnly;
    private final Set<VisibleWindowInfo.ChangeType> changeTypes;
    private final Integer displayId;
    private final boolean focusChangeOnly;
    private final boolean includeOverlay;
    private final Set<String> packageNames;
    private final Set<Integer> windowTypes;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final VisibleWindowFilter ACCEPT_ALL = new VisibleWindowFilter(null, null, null, false, false, false, null, 127, null);
    public static final VisibleWindowFilter APPLICATION_ONLY = new VisibleWindowFilter(null, null, null, true, false, false, null, 87, null);
    public static final VisibleWindowFilter FOCUS_ONLY = new VisibleWindowFilter(null, null, null, false, true, false, null, 111, null);
    public static final VisibleWindowFilter ADD_REMOVE_ONLY = new VisibleWindowFilter(null, null, q.K0(new VisibleWindowInfo.ChangeType[]{VisibleWindowInfo.ChangeType.ADDED, VisibleWindowInfo.ChangeType.REMOVED}), false, false, false, null, 123, null);

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0013\"\u00020\u0006¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016J\u0012\u0010\u0017\u001a\u00020\u00002\n\u0010\u0018\u001a\u00020\u0019\"\u00020\bJ\u001f\u0010\u001a\u001a\u00020\u00002\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0013\"\u00020\n¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020 R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006!"}, d2 = {"Lcom/mdisdk/observer/VisibleWindowFilter$Builder;", "", AppAgent.CONSTRUCT, "()V", "packageNames", "", "", "windowTypes", "", "changeTypes", "Lcom/mdisdk/observer/VisibleWindowInfo$ChangeType;", "applicationWindowsOnly", "", "focusChangeOnly", "includeOverlay", WindowStateInfo.KEY_DISPLAY_ID, "Ljava/lang/Integer;", "forPackage", "packages", "", "([Ljava/lang/String;)Lcom/mdisdk/observer/VisibleWindowFilter$Builder;", "forPackages", "", "forWindowType", "types", "", "forChangeType", "([Lcom/mdisdk/observer/VisibleWindowInfo$ChangeType;)Lcom/mdisdk/observer/VisibleWindowFilter$Builder;", "only", "include", "forDisplay", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/mdisdk/observer/VisibleWindowFilter;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private boolean applicationWindowsOnly;
        private Integer displayId;
        private boolean focusChangeOnly;
        private Set<String> packageNames = new LinkedHashSet();
        private Set<Integer> windowTypes = new LinkedHashSet();
        private Set<VisibleWindowInfo.ChangeType> changeTypes = v.i1(VisibleWindowInfo.ChangeType.getEntries());
        private boolean includeOverlay = true;

        public static /* synthetic */ Builder applicationWindowsOnly$default(Builder builder, boolean z10, int i, Object obj) {
            if ((i & 1) != 0) {
                z10 = true;
            }
            return builder.applicationWindowsOnly(z10);
        }

        public static /* synthetic */ Builder focusChangeOnly$default(Builder builder, boolean z10, int i, Object obj) {
            if ((i & 1) != 0) {
                z10 = true;
            }
            return builder.focusChangeOnly(z10);
        }

        public final Builder applicationWindowsOnly(boolean only) {
            this.applicationWindowsOnly = only;
            return this;
        }

        public final VisibleWindowFilter build() {
            return new VisibleWindowFilter(v.j1(this.packageNames), v.j1(this.windowTypes), v.j1(this.changeTypes), this.applicationWindowsOnly, this.focusChangeOnly, this.includeOverlay, this.displayId);
        }

        public final Builder focusChangeOnly(boolean only) {
            this.focusChangeOnly = only;
            return this;
        }

        public final Builder forChangeType(VisibleWindowInfo.ChangeType... types) {
            k.f(types, "types");
            this.changeTypes.clear();
            A.g0(this.changeTypes, types);
            return this;
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

        public final Builder forWindowType(int... types) {
            k.f(types, "types");
            this.windowTypes.addAll(q.H0(types));
            return this;
        }

        public final Builder includeOverlay(boolean include) {
            this.includeOverlay = include;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0007J!\u0010\u000b\u001a\u00020\u00052\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/mdisdk/observer/VisibleWindowFilter$Companion;", "", AppAgent.CONSTRUCT, "()V", "ACCEPT_ALL", "Lcom/mdisdk/observer/VisibleWindowFilter;", "APPLICATION_ONLY", "FOCUS_ONLY", "ADD_REMOVE_ONLY", "builder", "Lcom/mdisdk/observer/VisibleWindowFilter$Builder;", "forPackages", "packages", "", "", "([Ljava/lang/String;)Lcom/mdisdk/observer/VisibleWindowFilter;", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Builder builder() {
            return new Builder();
        }

        public final VisibleWindowFilter forPackages(String... packages) {
            k.f(packages, "packages");
            return new VisibleWindowFilter(q.K0(packages), null, null, false, false, false, null, 126, null);
        }

        private Companion() {
        }

        public final VisibleWindowFilter forPackages(Collection<String> packages) {
            k.f(packages, "packages");
            return new VisibleWindowFilter(v.j1(packages), null, null, false, false, false, null, 126, null);
        }
    }

    public VisibleWindowFilter() {
        this(null, null, null, false, false, false, null, 127, null);
    }

    public static final Builder builder() {
        return INSTANCE.builder();
    }

    public static /* synthetic */ VisibleWindowFilter copy$default(VisibleWindowFilter visibleWindowFilter, Set set, Set set2, Set set3, boolean z10, boolean z11, boolean z12, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            set = visibleWindowFilter.packageNames;
        }
        if ((i & 2) != 0) {
            set2 = visibleWindowFilter.windowTypes;
        }
        if ((i & 4) != 0) {
            set3 = visibleWindowFilter.changeTypes;
        }
        if ((i & 8) != 0) {
            z10 = visibleWindowFilter.applicationWindowsOnly;
        }
        if ((i & 16) != 0) {
            z11 = visibleWindowFilter.focusChangeOnly;
        }
        if ((i & 32) != 0) {
            z12 = visibleWindowFilter.includeOverlay;
        }
        if ((i & 64) != 0) {
            num = visibleWindowFilter.displayId;
        }
        boolean z13 = z12;
        Integer num2 = num;
        boolean z14 = z11;
        Set set4 = set3;
        return visibleWindowFilter.copy(set, set2, set4, z10, z14, z13, num2);
    }

    public static final VisibleWindowFilter forPackages(Collection<String> collection) {
        return INSTANCE.forPackages(collection);
    }

    @Override // com.mdisdk.observer.ObserverFilter
    public boolean accept(Object info) {
        k.f(info, "info");
        if (!(info instanceof VisibleWindowInfo)) {
            return false;
        }
        if (this.displayId != null) {
            int displayId = ((VisibleWindowInfo) info).getDisplayId();
            Integer num = this.displayId;
            if (num == null || displayId != num.intValue()) {
                return false;
            }
        }
        VisibleWindowInfo visibleWindowInfo = (VisibleWindowInfo) info;
        if (!this.changeTypes.contains(visibleWindowInfo.getChangeType())) {
            return false;
        }
        WindowSnapshot changedWindow = visibleWindowInfo.getChangedWindow();
        if (changedWindow != null) {
            if (!this.packageNames.isEmpty() && !this.packageNames.contains(changedWindow.getPackageName())) {
                return false;
            }
            if (!this.windowTypes.isEmpty() && !this.windowTypes.contains(Integer.valueOf(changedWindow.getWindowType()))) {
                return false;
            }
            if (this.applicationWindowsOnly && !changedWindow.isApplicationWindow()) {
                return false;
            }
            if (!this.includeOverlay && changedWindow.isOverlayWindow()) {
                return false;
            }
        }
        if (!this.focusChangeOnly) {
            return true;
        }
        if (changedWindow != null && changedWindow.isFocused()) {
            return true;
        }
        List<WindowSnapshot> windows = visibleWindowInfo.getWindows();
        if (!(windows instanceof Collection) || !windows.isEmpty()) {
            Iterator<T> it = windows.iterator();
            while (it.hasNext()) {
                if (((WindowSnapshot) it.next()).isFocused()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Set<String> component1() {
        return this.packageNames;
    }

    public final Set<Integer> component2() {
        return this.windowTypes;
    }

    public final Set<VisibleWindowInfo.ChangeType> component3() {
        return this.changeTypes;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getApplicationWindowsOnly() {
        return this.applicationWindowsOnly;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getFocusChangeOnly() {
        return this.focusChangeOnly;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIncludeOverlay() {
        return this.includeOverlay;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final VisibleWindowFilter copy(Set<String> packageNames, Set<Integer> windowTypes, Set<? extends VisibleWindowInfo.ChangeType> changeTypes, boolean applicationWindowsOnly, boolean focusChangeOnly, boolean includeOverlay, Integer displayId) {
        k.f(packageNames, "packageNames");
        k.f(windowTypes, "windowTypes");
        k.f(changeTypes, "changeTypes");
        return new VisibleWindowFilter(packageNames, windowTypes, changeTypes, applicationWindowsOnly, focusChangeOnly, includeOverlay, displayId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VisibleWindowFilter)) {
            return false;
        }
        VisibleWindowFilter visibleWindowFilter = (VisibleWindowFilter) other;
        return k.b(this.packageNames, visibleWindowFilter.packageNames) && k.b(this.windowTypes, visibleWindowFilter.windowTypes) && k.b(this.changeTypes, visibleWindowFilter.changeTypes) && this.applicationWindowsOnly == visibleWindowFilter.applicationWindowsOnly && this.focusChangeOnly == visibleWindowFilter.focusChangeOnly && this.includeOverlay == visibleWindowFilter.includeOverlay && k.b(this.displayId, visibleWindowFilter.displayId);
    }

    public final boolean getApplicationWindowsOnly() {
        return this.applicationWindowsOnly;
    }

    public final Set<VisibleWindowInfo.ChangeType> getChangeTypes() {
        return this.changeTypes;
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final boolean getFocusChangeOnly() {
        return this.focusChangeOnly;
    }

    public final boolean getIncludeOverlay() {
        return this.includeOverlay;
    }

    public final Set<String> getPackageNames() {
        return this.packageNames;
    }

    public final Set<Integer> getWindowTypes() {
        return this.windowTypes;
    }

    public int hashCode() {
        int iD = a.d(a.d(a.d((this.changeTypes.hashCode() + ((this.windowTypes.hashCode() + (this.packageNames.hashCode() * 31)) * 31)) * 31, 31, this.applicationWindowsOnly), 31, this.focusChangeOnly), 31, this.includeOverlay);
        Integer num = this.displayId;
        return iD + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "VisibleWindowFilter(packageNames=" + this.packageNames + ", windowTypes=" + this.windowTypes + ", changeTypes=" + this.changeTypes + ", applicationWindowsOnly=" + this.applicationWindowsOnly + ", focusChangeOnly=" + this.focusChangeOnly + ", includeOverlay=" + this.includeOverlay + ", displayId=" + this.displayId + ')';
    }

    public VisibleWindowFilter(Set set, Set set2, Set set3, boolean z10, boolean z11, boolean z12, Integer num, int i, e eVar) {
        this((i & 1) != 0 ? EmptySet.f4895a : set, (i & 2) != 0 ? EmptySet.f4895a : set2, (i & 4) != 0 ? v.j1(VisibleWindowInfo.ChangeType.getEntries()) : set3, (i & 8) != 0 ? false : z10, (i & 16) != 0 ? false : z11, (i & 32) != 0 ? true : z12, (i & 64) != 0 ? null : num);
    }

    public static final VisibleWindowFilter forPackages(String... strArr) {
        return INSTANCE.forPackages(strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VisibleWindowFilter(Set<String> packageNames, Set<Integer> windowTypes, Set<? extends VisibleWindowInfo.ChangeType> changeTypes, boolean z10, boolean z11, boolean z12, Integer num) {
        k.f(packageNames, "packageNames");
        k.f(windowTypes, "windowTypes");
        k.f(changeTypes, "changeTypes");
        this.packageNames = packageNames;
        this.windowTypes = windowTypes;
        this.changeTypes = changeTypes;
        this.applicationWindowsOnly = z10;
        this.focusChangeOnly = z11;
        this.includeOverlay = z12;
        this.displayId = num;
    }
}
