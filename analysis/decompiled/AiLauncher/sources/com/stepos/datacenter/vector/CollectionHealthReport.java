package com.stepos.datacenter.vector;

import Z8.C1173v;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J/\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u000fHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/stepos/datacenter/vector/CollectionHealthReport;", "", "checked", "", "", "byCollection", "", "Lcom/stepos/datacenter/vector/CollectionHealth;", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getChecked", "()Ljava/util/List;", "getByCollection", "()Ljava/util/Map;", "unhealthyCount", "", "getUnhealthyCount", "()I", "totalQuarantinedFiles", "getTotalQuarantinedFiles", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CollectionHealthReport {
    private final Map<String, CollectionHealth> byCollection;
    private final List<String> checked;

    public CollectionHealthReport(List<String> checked, Map<String, CollectionHealth> byCollection) {
        p.i(checked, "checked");
        p.i(byCollection, "byCollection");
        this.checked = checked;
        this.byCollection = byCollection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CollectionHealthReport copy$default(CollectionHealthReport collectionHealthReport, List list, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = collectionHealthReport.checked;
        }
        if ((i10 & 2) != 0) {
            map = collectionHealthReport.byCollection;
        }
        return collectionHealthReport.copy(list, map);
    }

    public final List<String> component1() {
        return this.checked;
    }

    public final Map<String, CollectionHealth> component2() {
        return this.byCollection;
    }

    public final CollectionHealthReport copy(List<String> checked, Map<String, CollectionHealth> byCollection) {
        p.i(checked, "checked");
        p.i(byCollection, "byCollection");
        return new CollectionHealthReport(checked, byCollection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionHealthReport)) {
            return false;
        }
        CollectionHealthReport collectionHealthReport = (CollectionHealthReport) other;
        return p.d(this.checked, collectionHealthReport.checked) && p.d(this.byCollection, collectionHealthReport.byCollection);
    }

    public final Map<String, CollectionHealth> getByCollection() {
        return this.byCollection;
    }

    public final List<String> getChecked() {
        return this.checked;
    }

    public final int getTotalQuarantinedFiles() {
        Iterator<T> it = this.byCollection.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((CollectionHealth) it.next()).getQuarantinedSnapshotPaths().size();
        }
        return size;
    }

    public final int getUnhealthyCount() {
        Collection<CollectionHealth> collectionValues = this.byCollection.values();
        int i10 = 0;
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            return 0;
        }
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            if (((CollectionHealth) it.next()).getHasQuarantine() && (i10 = i10 + 1) < 0) {
                C1173v.v();
            }
        }
        return i10;
    }

    public int hashCode() {
        return (this.checked.hashCode() * 31) + this.byCollection.hashCode();
    }

    public String toString() {
        return "CollectionHealthReport(checked=" + this.checked + ", byCollection=" + this.byCollection + ")";
    }
}
