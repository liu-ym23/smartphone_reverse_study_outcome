package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
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

        public void add(V r10) {
            if (this.values != null) goto L5;
            this.values = new ArrayList();
        L5:
            this.values.add(r10);
        }

        @Nullable
        public V removeLast() {
            int r10 = size();
            if (r10 > 0) goto L7;
            return null;
        L7:
            return this.values.remove(r10 - 1);
        }

        public int size() {
            List<V> r10 = this.values;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.size();
        }

        public LinkedEntry(K r10) {
            this.prev = this;
            this.next = this;
            this.key = r10;
        }
    }

    public GroupedLinkedMap() {
        this.head = new LinkedEntry();
        this.keyToEntry = new HashMap();
    }

    private void makeHead(LinkedEntry<K, V> r10) {
        removeEntry(r10);
        LinkedEntry<K, V> r11 = this.head;
        r10.prev = r11;
        r10.next = r11.next;
        updateEntry(r10);
    }

    private void makeTail(LinkedEntry<K, V> r10) {
        removeEntry(r10);
        LinkedEntry<K, V> r11 = this.head;
        r10.prev = r11.prev;
        r10.next = r11;
        updateEntry(r10);
    }

    private static <K, V> void removeEntry(LinkedEntry<K, V> r10) {
        LinkedEntry<K, V> r11 = r10.prev;
        r11.next = r10.next;
        r10.next.prev = r11;
    }

    private static <K, V> void updateEntry(LinkedEntry<K, V> r10) {
        r10.next.prev = r10;
        r10.prev.next = r10;
    }

    @Nullable
    public V get(K r10) {
        LinkedEntry<K, V> r11 = this.keyToEntry.get(r10);
        if (r11 != null) goto L5;
        r11 = new LinkedEntry(r10);
        this.keyToEntry.put(r10, r11);
    L6:
        makeHead(r11);
        return r11.removeLast();
    L5:
        r10.offer();
        goto L6
    }

    public void put(K r10, V r11) {
        LinkedEntry<K, V> r12 = this.keyToEntry.get(r10);
        if (r12 != null) goto L5;
        r12 = new LinkedEntry(r10);
        makeTail(r12);
        this.keyToEntry.put(r10, r12);
    L6:
        r12.add(r11);
        return;
    L5:
        r10.offer();
        goto L6
    }

    @Nullable
    public V removeLast() {
        LinkedEntry r10 = this.head.prev;
    L4:
        if (r10.equals(this.head) == true) goto L9;
        V r11 = (V) r10.removeLast();
        if (r11 != null) goto L7;
        removeEntry(r10);
        this.keyToEntry.remove(r10.key);
        ((Poolable) r10.key).offer();
        r10 = r10.prev;
        goto L4
    L7:
        return r11;
    L9:
        return null;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder("GroupedLinkedMap( ");
        LinkedEntry r11 = this.head.next;
        boolean r12 = false;
    L4:
        if (r11.equals(this.head) == true) goto L6;
        r10.append('{');
        r10.append(r11.key);
        r10.append(':');
        r10.append(r11.size());
        r10.append("}, ");
        r11 = r11.next;
        r12 = true;
        goto L4
    L6:
        if (r12 == false) goto L8;
        r10.delete(r10.length() - 2, r10.length());
    L8:
        r10.append(" )");
        return r10.toString();
    }
}
