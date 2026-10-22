package com.bytedance.location.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
    public static final LazyStringList EMPTY = null;
    private static final LazyStringArrayList EMPTY_LIST = null;
    private final List<Object> list;

    private static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        private final LazyStringArrayList list;

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int r1, Object r2) {
            add(r1, (byte[]) r2);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int r1) {
            return remove(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r1, Object r2) {
            return set(r1, (byte[]) r2);
        }

        ByteArrayListView(LazyStringArrayList list) {
            this.list = list;
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] get(int index) {
            return this.list.getByteArray(index);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        public byte[] set(int index, byte[] s) {
            Object o = LazyStringArrayList.access$000(this.list, index, s);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$100(o);
        }

        public void add(int index, byte[] s) {
            LazyStringArrayList.access$200(this.list, index, s);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] remove(int index) {
            Object o = this.list.remove(index);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$100(o);
        }
    }

    private static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        private final LazyStringArrayList list;

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int r1, Object r2) {
            add(r1, (ByteString) r2);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int r1) {
            return remove(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r1, Object r2) {
            return set(r1, (ByteString) r2);
        }

        ByteStringListView(LazyStringArrayList list) {
            this.list = list;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString get(int index) {
            return this.list.getByteString(index);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        public ByteString set(int index, ByteString s) {
            Object o = LazyStringArrayList.access$300(this.list, index, s);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$400(o);
        }

        public void add(int index, ByteString s) {
            LazyStringArrayList.access$500(this.list, index, s);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString remove(int index) {
            Object o = this.list.remove(index);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$400(o);
        }
    }

    static /* synthetic */ Object access$000(LazyStringArrayList x0, int x1, byte[] x2) {
        return x0.setAndReturn(x1, x2);
    }

    static /* synthetic */ byte[] access$100(Object x0) {
        return asByteArray(x0);
    }

    static /* synthetic */ void access$200(LazyStringArrayList x0, int x1, byte[] x2) {
        x0.add(x1, x2);
    }

    static /* synthetic */ Object access$300(LazyStringArrayList x0, int x1, ByteString x2) {
        return x0.setAndReturn(x1, x2);
    }

    static /* synthetic */ ByteString access$400(Object x0) {
        return asByteString(x0);
    }

    static /* synthetic */ void access$500(LazyStringArrayList x0, int x1, ByteString x2) {
        x0.add(x1, x2);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r1, Object r2) {
        add(r1, (String) r2);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r1) {
        return super.add(r1);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, com.bytedance.location.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int r1) {
        return mutableCopyWithCapacity(r1);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r1) {
        return remove(r1);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object r1) {
        return super.remove(r1);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection r1) {
        return super.removeAll(r1);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection r1) {
        return super.retainAll(r1);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r1, Object r2) {
        return set(r1, (String) r2);
    }

    static {
        EMPTY_LIST = new LazyStringArrayList();
        EMPTY_LIST.makeImmutable();
        EMPTY = EMPTY_LIST;
    }

    static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    public LazyStringArrayList() {
        this(10);
    }

    public LazyStringArrayList(int initialCapacity) {
        this(new ArrayList(initialCapacity));
    }

    public LazyStringArrayList(LazyStringList from) {
        this.list = new ArrayList(from.size());
        addAll(from);
    }

    public LazyStringArrayList(List<String> from) {
        this(new ArrayList(from));
    }

    private LazyStringArrayList(ArrayList<Object> list) {
        this.list = list;
    }

    @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
    public LazyStringArrayList mutableCopyWithCapacity(int capacity) {
        if (capacity < size()) goto L7;
        ArrayList<Object> newList = new ArrayList(capacity);
        newList.addAll(this.list);
        return new LazyStringArrayList(newList);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int index) {
        Object o = this.list.get(index);
        if ((o instanceof String) == false) goto L7;
        return (String) o;
    L7:
        if ((o instanceof ByteString) == false) goto L12;
        ByteString bs = (ByteString) o;
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8() == false) goto L11;
        this.list.set(index, s);
    L11:
        return s;
    L12:
        byte[] ba = (byte[]) o;
        String s2 = Internal.toStringUtf8(ba);
        if (Internal.isValidUtf8(ba) == false) goto L15;
        this.list.set(index, s2);
    L15:
        return s2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    public String set(int index, String s) {
        ensureIsMutable();
        Object o = this.list.set(index, s);
        return asString(o);
    }

    public void add(int index, String element) {
        ensureIsMutable();
        this.list.add(index, element);
        ((AbstractList) this).modCount++;
    }

    private void add(int index, ByteString element) {
        ensureIsMutable();
        this.list.add(index, element);
        ((AbstractList) this).modCount++;
    }

    private void add(int index, byte[] element) {
        ensureIsMutable();
        this.list.add(index, element);
        ((AbstractList) this).modCount++;
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> c) {
        return addAll(size(), c);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends String> c) {
        ensureIsMutable();
        if ((c instanceof LazyStringList) == false) goto L5;
        Collection<? extends String> r0 = ((LazyStringList) c).getUnderlyingElements();
    L6:
        boolean ret = this.list.addAll(index, r0);
        ((AbstractList) this).modCount++;
        return ret;
    L5:
        r0 = c;
        goto L6
    }

    @Override // com.bytedance.location.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> values) {
        ensureIsMutable();
        boolean ret = this.list.addAll(values);
        ((AbstractList) this).modCount++;
        return ret;
    }

    @Override // com.bytedance.location.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> c) {
        ensureIsMutable();
        boolean ret = this.list.addAll(c);
        ((AbstractList) this).modCount++;
        return ret;
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String remove(int index) {
        ensureIsMutable();
        Object o = this.list.remove(index);
        ((AbstractList) this).modCount++;
        return asString(o);
    }

    @Override // com.bytedance.location.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ensureIsMutable();
        this.list.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.bytedance.location.protobuf.LazyStringList
    public void add(ByteString element) {
        ensureIsMutable();
        this.list.add(element);
        ((AbstractList) this).modCount++;
    }

    @Override // com.bytedance.location.protobuf.LazyStringList
    public void add(byte[] element) {
        ensureIsMutable();
        this.list.add(element);
        ((AbstractList) this).modCount++;
    }

    @Override // com.bytedance.location.protobuf.LazyStringList
    public Object getRaw(int index) {
        return this.list.get(index);
    }

    @Override // com.bytedance.location.protobuf.LazyStringList
    public ByteString getByteString(int index) {
        Object o = this.list.get(index);
        ByteString b = asByteString(o);
        if (b == o) goto L5;
        this.list.set(index, b);
    L5:
        return b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.location.protobuf.LazyStringList
    public byte[] getByteArray(int r4) {
        Object r0 = this.list.get(r4);
        byte[] r1 = asByteArray(r0);
        if (r1 == r0) goto L5;
        this.list.set(r4, r1);
    L5:
        return r1;
    }

    @Override // com.bytedance.location.protobuf.LazyStringList
    public void set(int index, ByteString s) {
        setAndReturn(index, s);
    }

    private Object setAndReturn(int index, ByteString s) {
        ensureIsMutable();
        return this.list.set(index, s);
    }

    @Override // com.bytedance.location.protobuf.LazyStringList
    public void set(int index, byte[] s) {
        setAndReturn(index, s);
    }

    private Object setAndReturn(int index, byte[] s) {
        ensureIsMutable();
        return this.list.set(index, s);
    }

    private static String asString(Object o) {
        if ((o instanceof String) == false) goto L7;
        return (String) o;
    L7:
        if ((o instanceof ByteString) == false) goto L11;
        return ((ByteString) o).toStringUtf8();
    L11:
        return Internal.toStringUtf8((byte[]) o);
    }

    private static ByteString asByteString(Object o) {
        if ((o instanceof ByteString) == false) goto L7;
        return (ByteString) o;
    L7:
        if ((o instanceof String) == false) goto L11;
        return ByteString.copyFromUtf8((String) o);
    L11:
        return ByteString.copyFrom((byte[]) o);
    }

    private static byte[] asByteArray(Object o) {
        if ((o instanceof byte[]) == false) goto L7;
        return (byte[]) o;
    L7:
        if ((o instanceof String) == false) goto L11;
        return Internal.toByteArray((String) o);
    L11:
        return ((ByteString) o).toByteArray();
    }

    @Override // com.bytedance.location.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override // com.bytedance.location.protobuf.LazyStringList
    public void mergeFrom(LazyStringList other) {
        ensureIsMutable();
        Iterator<?> r0 = other.getUnderlyingElements().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Object o = r0.next();
        if ((o instanceof byte[]) == true) goto L7;
        this.list.add(o);
        goto L4
    L7:
        byte[] b = (byte[]) o;
        this.list.add(Arrays.copyOf(b, b.length));
        goto L4
    }

    @Override // com.bytedance.location.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this);
    }

    @Override // com.bytedance.location.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this);
    }

    @Override // com.bytedance.location.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        if (isModifiable() == true) goto L5;
        return this;
    L5:
        return new UnmodifiableLazyStringList(this);
    }
}
