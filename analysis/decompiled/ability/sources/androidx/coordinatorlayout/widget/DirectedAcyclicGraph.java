package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public final class DirectedAcyclicGraph<T> {
    private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
    private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    private final ArrayList<T> mSortResult = new ArrayList<>();
    private final HashSet<T> mSortTmpMarked = new HashSet<>();

    private void dfs(T t9, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t9)) {
            return;
        }
        if (hashSet.contains(t9)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t9);
        ArrayList<T> arrayList2 = this.mGraph.get(t9);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                dfs(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t9);
        arrayList.add(t9);
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> arrayListAcquire = this.mListPool.acquire();
        return arrayListAcquire == null ? new ArrayList<>() : arrayListAcquire;
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(@NonNull T t9, @NonNull T t10) {
        if (!this.mGraph.containsKey(t9) || !this.mGraph.containsKey(t10)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> emptyList = this.mGraph.get(t9);
        if (emptyList == null) {
            emptyList = getEmptyList();
            this.mGraph.put(t9, emptyList);
        }
        emptyList.add(t10);
    }

    public void addNode(@NonNull T t9) {
        if (this.mGraph.containsKey(t9)) {
            return;
        }
        this.mGraph.put(t9, null);
    }

    public void clear() {
        int size = this.mGraph.getSize();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListValueAt = this.mGraph.valueAt(i);
            if (arrayListValueAt != null) {
                poolList(arrayListValueAt);
            }
        }
        this.mGraph.clear();
    }

    public boolean contains(@NonNull T t9) {
        return this.mGraph.containsKey(t9);
    }

    @Nullable
    public List<T> getIncomingEdges(@NonNull T t9) {
        ArrayList<T> incomingEdgesInternal = getIncomingEdgesInternal(t9);
        if (incomingEdgesInternal == null) {
            return null;
        }
        return new ArrayList(incomingEdgesInternal);
    }

    @Nullable
    public ArrayList<T> getIncomingEdgesInternal(@NonNull T t9) {
        return this.mGraph.get(t9);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t9) {
        int size = this.mGraph.getSize();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListValueAt = this.mGraph.valueAt(i);
            if (arrayListValueAt != null && arrayListValueAt.contains(t9)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.mGraph.keyAt(i));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.getSize();
        for (int i = 0; i < size; i++) {
            dfs(this.mGraph.keyAt(i), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T t9) {
        int size = this.mGraph.getSize();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListValueAt = this.mGraph.valueAt(i);
            if (arrayListValueAt != null && arrayListValueAt.contains(t9)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.mGraph.getSize();
    }
}
