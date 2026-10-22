package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
class GroupedLinkedMap<K extends Poolable, V> {
    private final LinkedEntry<K, V> head;
    private final Map<K, LinkedEntry<K, V>> keyToEntry;

    public static class LinkedEntry<K, V> {
        final K key;
        LinkedEntry<K, V> next;
        LinkedEntry<K, V> prev;
        private List<V> values;

        public LinkedEntry() {
            this(null);
        }

        public int size() {
            List<V> r100 = this.values;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public V removeLast() {
            int r100 = size();
            if (r100 > 0) goto L7;
            return null;
        L7:
            return (V) ListProtector.remove(this.values, r100 - 1);
        }

        public LinkedEntry(K r100) {
            this.prev = this;
            this.next = this;
            this.key = r100;
        }

        public void add(V r100) {
            if (this.values != null) goto L5;
            this.values = new ArrayList();
        L5:
            this.values.add(r100);
        }
    }

    public V removeLast() {
        LinkedEntry r100 = this.head.prev;
    L4:
        if (r100.equals(this.head) == true) goto L9;
        V r101 = (V) r100.removeLast();
        if (r101 != null) goto L7;
        removeEntry(r100);
        this.keyToEntry.remove(r100.key);
        ((Poolable) r100.key).offer();
        r100 = r100.prev;
        goto L4
    L7:
        return r101;
    L9:
        return null;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("GroupedLinkedMap( ");
        LinkedEntry r101 = this.head.next;
        boolean r102 = false;
    L4:
        if (r101.equals(this.head) == true) goto L6;
        r100.append('{');
        r100.append(r101.key);
        r100.append(':');
        r100.append(r101.size());
        r100.append("}, ");
        r101 = r101.next;
        r102 = true;
        goto L4
    L6:
        if (r102 == false) goto L8;
        r100.delete(r100.length() - 2, r100.length());
    L8:
        r100.append(" )");
        return r100.toString();
    }

    public GroupedLinkedMap() {
        this.head = new LinkedEntry();
        this.keyToEntry = new HashMap();
    }

    private void makeHead(LinkedEntry<K, V> r100) {
        removeEntry(r100);
        LinkedEntry<K, V> r101 = this.head;
        r100.prev = r101;
        r100.next = r101.next;
        updateEntry(r100);
    }

    private void makeTail(LinkedEntry<K, V> r100) {
        removeEntry(r100);
        LinkedEntry<K, V> r101 = this.head;
        r100.prev = r101.prev;
        r100.next = r101;
        updateEntry(r100);
    }

    private static <K, V> void removeEntry(LinkedEntry<K, V> r100) {
        LinkedEntry<K, V> r101 = r100.prev;
        r101.next = r100.next;
        r100.next.prev = r101;
    }

    private static <K, V> void updateEntry(LinkedEntry<K, V> r100) {
        r100.next.prev = r100;
        r100.prev.next = r100;
    }

    public V get(K r100) {
        LinkedEntry<K, V> r101 = this.keyToEntry.get(r100);
        if (r101 != null) goto L5;
        r101 = new LinkedEntry(r100);
        this.keyToEntry.put(r100, r101);
    L6:
        makeHead(r101);
        return r101.removeLast();
    L5:
        r100.offer();
        goto L6
    }

    public void put(K r100, V r101) {
        LinkedEntry<K, V> r102 = this.keyToEntry.get(r100);
        if (r102 != null) goto L5;
        r102 = new LinkedEntry(r100);
        makeTail(r102);
        this.keyToEntry.put(r100, r102);
    L6:
        r102.add(r101);
        return;
    L5:
        r100.offer();
        goto L6
    }
}
