package androidx.room;

import D7.N;
import androidx.room.InvalidationTracker;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0011\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0000¢\u0006\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/room/ObserverWrapper;", "", "Landroidx/room/InvalidationTracker$Observer;", "observer", "", "tableIds", "", "", "tableNames", AppAgent.CONSTRUCT, "(Landroidx/room/InvalidationTracker$Observer;[I[Ljava/lang/String;)V", "", "", "invalidatedTablesIds", "LC7/r;", "notifyByTableIds$room_runtime", "(Ljava/util/Set;)V", "notifyByTableIds", "invalidatedTablesNames", "notifyByTableNames$room_runtime", "notifyByTableNames", "Landroidx/room/InvalidationTracker$Observer;", "getObserver$room_runtime", "()Landroidx/room/InvalidationTracker$Observer;", "[I", "getTableIds$room_runtime", "()[I", "[Ljava/lang/String;", "singleTableSet", "Ljava/util/Set;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ObserverWrapper {
    private final InvalidationTracker.Observer observer;
    private final Set<String> singleTableSet;
    private final int[] tableIds;
    private final String[] tableNames;

    public ObserverWrapper(InvalidationTracker.Observer observer, int[] tableIds, String[] tableNames) {
        k.f(observer, "observer");
        k.f(tableIds, "tableIds");
        k.f(tableNames, "tableNames");
        this.observer = observer;
        this.tableIds = tableIds;
        this.tableNames = tableNames;
        if (tableIds.length != tableNames.length) {
            throw new IllegalStateException("Check failed.");
        }
        this.singleTableSet = !(tableNames.length == 0) ? N.Q(tableNames[0]) : EmptySet.f4895a;
    }

    /* renamed from: getObserver$room_runtime, reason: from getter */
    public final InvalidationTracker.Observer getObserver() {
        return this.observer;
    }

    /* renamed from: getTableIds$room_runtime, reason: from getter */
    public final int[] getTableIds() {
        return this.tableIds;
    }

    public final void notifyByTableIds$room_runtime(Set<Integer> invalidatedTablesIds) {
        Set<String> setM;
        k.f(invalidatedTablesIds, "invalidatedTablesIds");
        int[] iArr = this.tableIds;
        int length = iArr.length;
        if (length != 0) {
            int i = 0;
            if (length != 1) {
                SetBuilder setBuilder = new SetBuilder();
                int[] iArr2 = this.tableIds;
                int length2 = iArr2.length;
                int i6 = 0;
                while (i < length2) {
                    int i10 = i6 + 1;
                    if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i]))) {
                        setBuilder.add(this.tableNames[i6]);
                    }
                    i++;
                    i6 = i10;
                }
                setM = N.m(setBuilder);
            } else {
                setM = invalidatedTablesIds.contains(Integer.valueOf(iArr[0])) ? this.singleTableSet : EmptySet.f4895a;
            }
        } else {
            setM = EmptySet.f4895a;
        }
        if (setM.isEmpty()) {
            return;
        }
        this.observer.onInvalidated(setM);
    }

    public final void notifyByTableNames$room_runtime(Set<String> invalidatedTablesNames) {
        Set<String> setM;
        k.f(invalidatedTablesNames, "invalidatedTablesNames");
        int length = this.tableNames.length;
        if (length == 0) {
            setM = EmptySet.f4895a;
        } else if (length != 1) {
            SetBuilder setBuilder = new SetBuilder();
            for (String str : invalidatedTablesNames) {
                String[] strArr = this.tableNames;
                int length2 = strArr.length;
                int i = 0;
                while (true) {
                    if (i < length2) {
                        String str2 = strArr[i];
                        if (t.X(str2, str)) {
                            setBuilder.add(str2);
                            break;
                        }
                        i++;
                    }
                }
            }
            setM = N.m(setBuilder);
        } else {
            Set<String> set = invalidatedTablesNames;
            if ((set instanceof Collection) && set.isEmpty()) {
                setM = EmptySet.f4895a;
            } else {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    if (t.X((String) it.next(), this.tableNames[0])) {
                        setM = this.singleTableSet;
                        break;
                    }
                }
                setM = EmptySet.f4895a;
            }
        }
        if (setM.isEmpty()) {
            return;
        }
        this.observer.onInvalidated(setM);
    }
}
