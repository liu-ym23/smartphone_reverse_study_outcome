package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public final class DirectedAcyclicGraph<T> {
    private final SimpleArrayMap<T, ArrayList<T>> mGraph;
    private final Pools.Pool<ArrayList<T>> mListPool;
    private final ArrayList<T> mSortResult;
    private final HashSet<T> mSortTmpMarked;

    private ArrayList<T> getEmptyList() {
        ArrayList<T> r100 = this.mListPool.acquire();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ArrayList();
    }

    public void clear() {
        int r100 = this.mGraph.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        ArrayList<T> r102 = this.mGraph.valueAt(r101);
        if (r102 == null) goto L7;
        poolList(r102);
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        this.mGraph.clear();
    }

    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int r100 = this.mGraph.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L6;
        dfs(this.mGraph.keyAt(r101), this.mSortResult, this.mSortTmpMarked);
        r101 = r101 + 1;
        goto L3
    L6:
        return this.mSortResult;
    }

    public int size() {
        return this.mGraph.size();
    }

    public DirectedAcyclicGraph() {
        this.mListPool = new Pools.SimplePool(10);
        this.mGraph = new SimpleArrayMap();
        this.mSortResult = new ArrayList();
        this.mSortTmpMarked = new HashSet();
    }

    private void poolList(ArrayList<T> r100) {
        r100.clear();
        this.mListPool.release(r100);
    }

    public void addNode(T r100) {
        if (this.mGraph.containsKey(r100) == true) goto L6;
        this.mGraph.put(r100, null);
        return;
    }

    public boolean contains(T r100) {
        return this.mGraph.containsKey(r100);
    }

    public List getIncomingEdges(T r100) {
        return this.mGraph.get(r100);
    }

    public List<T> getOutgoingEdges(T r100) {
        int r101 = this.mGraph.size();
        ArrayList r102 = null;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L12;
        ArrayList<T> r104 = this.mGraph.valueAt(r103);
        if (r104 == null) goto L11;
        if (r104.contains(r100) == false) goto L11;
        if (r102 != null) goto L10;
        r102 = new ArrayList();
    L10:
        r102.add(this.mGraph.keyAt(r103));
    L11:
        r103 = r103 + 1;
        goto L3
    L12:
        return r102;
    }

    public boolean hasOutgoingEdges(T r100) {
        int r101 = this.mGraph.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        ArrayList<T> r103 = this.mGraph.valueAt(r102);
        if (r103 == null) goto L10;
        if (r103.contains(r100) == false) goto L10;
        return true;
    L10:
        r102 = r102 + 1;
        goto L3
    L11:
        return false;
    }

    public void addEdge(T r100, T r101) {
        if (this.mGraph.containsKey(r100) == false) goto L12;
        if (this.mGraph.containsKey(r101) == false) goto L12;
        ArrayList<T> r102 = this.mGraph.get(r100);
        if (r102 != null) goto L9;
        r102 = getEmptyList();
        this.mGraph.put(r100, r102);
    L9:
        r102.add(r101);
        return;
    L12:
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void dfs(T r100, ArrayList<T> r101, HashSet<T> r102) {
        if (r101.contains(r100) == false) goto L6;
        return;
    L6:
        if (r102.contains(r100) == true) goto L15;
        r102.add(r100);
        ArrayList<T> r103 = this.mGraph.get(r100);
        if (r103 == null) goto L12;
        int r104 = r103.size();
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L12;
        dfs(ListProtector.get(r103, r105), r101, r102);
        r105 = r105 + 1;
    L12:
        r102.remove(r100);
        r101.add(r100);
        return;
    L15:
        throw new RuntimeException("This graph contains cyclic dependencies");
    }
}
