package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
class ObjectCountLinkedHashMap<K> extends ObjectCountHashMap<K> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;

    @VisibleForTesting
    transient long[] links;

    public ObjectCountLinkedHashMap() {
        this(3);
    }

    public static <K> ObjectCountLinkedHashMap<K> create() {
        return new ObjectCountLinkedHashMap();
    }

    public static <K> ObjectCountLinkedHashMap<K> createWithExpectedSize(int r10) {
        return new ObjectCountLinkedHashMap(r10);
    }

    private int getPredecessor(int r10) {
        return (int) (this.links[r10] >>> 32);
    }

    private int getSuccessor(int r10) {
        return (int) this.links[r10];
    }

    private void setPredecessor(int r10, int r11) {
        long[] r12 = this.links;
        r12[r10] = (r12[r10] & 4294967295L) | (((long) r11) << 32);
    }

    private void setSucceeds(int r10, int r11) {
        if (r10 != (-2)) goto L5;
        this.firstEntry = r11;
    L6:
        if (r11 != (-2)) goto L8;
        this.lastEntry = r10;
        return;
    L8:
        setPredecessor(r11, r10);
        return;
    L5:
        setSuccessor(r10, r11);
        goto L6
    }

    private void setSuccessor(int r10, int r11) {
        long[] r12 = this.links;
        r12[r10] = (r12[r10] & (-4294967296L)) | (((long) r11) & 4294967295L);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public int firstIndex() {
        int r10 = this.firstEntry;
        if (r10 != (-2)) goto L6;
        return -1;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void init(int r10, float r11) {
        super.init(r10, r11);
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] r12 = new long[r10];
        this.links = r12;
        Arrays.fill(r12, -1);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void insertEntry(int r10, K r11, int r12, int r13) {
        super.insertEntry(r10, r11, r12, r13);
        setSucceeds(this.lastEntry, r10);
        setSucceeds(r10, -2);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void moveLastEntry(int r10) {
        int r11 = size() - 1;
        setSucceeds(getPredecessor(r10), getSuccessor(r10));
        if (r10 >= r11) goto L5;
        setSucceeds(getPredecessor(r11), r10);
        setSucceeds(r10, getSuccessor(r11));
    L5:
        super.moveLastEntry(r10);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public int nextIndex(int r10) {
        int r11 = getSuccessor(r10);
        if (r11 != (-2)) goto L6;
        return -1;
    L6:
        return r11;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public int nextIndexAfterRemove(int r10, int r11) {
        if (r10 == size()) goto L5;
        return r10;
    L5:
        return r11;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void resizeEntries(int r10) {
        super.resizeEntries(r10);
        long[] r11 = this.links;
        int r12 = r11.length;
        long[] r13 = Arrays.copyOf(r11, r10);
        this.links = r13;
        Arrays.fill(r13, r12, r10, -1);
    }

    public ObjectCountLinkedHashMap(int r10) {
        this(r10, 1.0f);
    }

    public ObjectCountLinkedHashMap(int r10, float r11) {
        super(r10, r11);
    }

    public ObjectCountLinkedHashMap(ObjectCountHashMap<K> r10) {
        init(r10.size(), 1.0f);
        int r11 = r10.firstIndex();
    L4:
        if (r11 == (-1)) goto L6;
        put(r10.getKey(r11), r10.getValue(r11));
        r11 = r10.nextIndex(r11);
        goto L4
    }
}
