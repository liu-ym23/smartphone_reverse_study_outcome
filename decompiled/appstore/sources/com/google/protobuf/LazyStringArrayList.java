package com.google.protobuf;

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

    public static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        private final LazyStringArrayList list;

        public ByteArrayListView(LazyStringArrayList r10) {
            this.list = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int r10, Object r11) {
            add(r10, (byte[]) r11);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int r10) {
            return remove(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
            return set(r10, (byte[]) r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        public void add(int r10, byte[] r11) {
            LazyStringArrayList.access$200(this.list, r10, r11);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] get(int r10) {
            return this.list.getByteArray(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] remove(int r10) {
            String r11 = this.list.remove(r10);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$100(r11);
        }

        public byte[] set(int r10, byte[] r11) {
            Object r12 = LazyStringArrayList.access$000(this.list, r10, r11);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$100(r12);
        }
    }

    public static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        private final LazyStringArrayList list;

        public ByteStringListView(LazyStringArrayList r10) {
            this.list = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ void add(int r10, Object r11) {
            add(r10, (ByteString) r11);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object remove(int r10) {
            return remove(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
            return set(r10, (ByteString) r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.list.size();
        }

        public void add(int r10, ByteString r11) {
            LazyStringArrayList.access$500(this.list, r10, r11);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString get(int r10) {
            return this.list.getByteString(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString remove(int r10) {
            String r11 = this.list.remove(r10);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$400(r11);
        }

        public ByteString set(int r10, ByteString r11) {
            Object r12 = LazyStringArrayList.access$300(this.list, r10, r11);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.access$400(r12);
        }
    }

    static {
        LazyStringArrayList r10 = new LazyStringArrayList();
        EMPTY_LIST = r10;
        r10.makeImmutable();
        EMPTY = r10;
    }

    public LazyStringArrayList() {
        this(10);
    }

    public static /* synthetic */ Object access$000(LazyStringArrayList r10, int r11, byte[] r12) {
        return r10.setAndReturn(r11, r12);
    }

    public static /* synthetic */ byte[] access$100(Object r10) {
        return asByteArray(r10);
    }

    public static /* synthetic */ void access$200(LazyStringArrayList r10, int r11, byte[] r12) {
        r10.add(r11, r12);
    }

    public static /* synthetic */ Object access$300(LazyStringArrayList r10, int r11, ByteString r12) {
        return r10.setAndReturn(r11, r12);
    }

    public static /* synthetic */ ByteString access$400(Object r10) {
        return asByteString(r10);
    }

    public static /* synthetic */ void access$500(LazyStringArrayList r10, int r11, ByteString r12) {
        r10.add(r11, r12);
    }

    private static byte[] asByteArray(Object r10) {
        if ((r10 instanceof byte[]) == false) goto L7;
        return (byte[]) r10;
    L7:
        if ((r10 instanceof String) == false) goto L11;
        return Internal.toByteArray((String) r10);
    L11:
        return ((ByteString) r10).toByteArray();
    }

    private static ByteString asByteString(Object r10) {
        if ((r10 instanceof ByteString) == false) goto L7;
        return (ByteString) r10;
    L7:
        if ((r10 instanceof String) == false) goto L11;
        return ByteString.copyFromUtf8((String) r10);
    L11:
        return ByteString.copyFrom((byte[]) r10);
    }

    private static String asString(Object r10) {
        if ((r10 instanceof String) == false) goto L7;
        return (String) r10;
    L7:
        if ((r10 instanceof ByteString) == false) goto L11;
        return ((ByteString) r10).toStringUtf8();
    L11:
        return Internal.toStringUtf8((byte[]) r10);
    }

    public static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    private Object setAndReturn(int r10, ByteString r11) {
        ensureIsMutable();
        return this.list.set(r10, r11);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r10, Object r11) {
        add(r10, (String) r11);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> r10) {
        return addAll(size(), r10);
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> r10) {
        ensureIsMutable();
        boolean r11 = this.list.addAll(r10);
        ((AbstractList) this).modCount++;
        return r11;
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> r10) {
        ensureIsMutable();
        boolean r11 = this.list.addAll(r10);
        ((AbstractList) this).modCount++;
        return r11;
    }

    @Override // com.google.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this);
    }

    @Override // com.google.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ensureIsMutable();
        this.list.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object r10) {
        return super.equals(r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return get(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int r10) {
        Object r11 = this.list.get(r10);
        byte[] r12 = asByteArray(r11);
        if (r12 == r11) goto L5;
        this.list.set(r10, r12);
    L5:
        return r12;
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int r10) {
        Object r11 = this.list.get(r10);
        ByteString r12 = asByteString(r11);
        if (r12 == r11) goto L5;
        this.list.set(r10, r12);
    L5:
        return r12;
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int r10) {
        return this.list.get(r10);
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override // com.google.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        if (isModifiable() == true) goto L5;
        return this;
    L5:
        return new UnmodifiableLazyStringList(this);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.protobuf.AbstractProtobufList, com.google.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList r10) {
        ensureIsMutable();
        Iterator<?> r11 = r10.getUnderlyingElements().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Object r12 = r11.next();
        if ((r12 instanceof byte[]) == true) goto L7;
        this.list.add(r12);
        goto L4
    L7:
        byte[] r13 = (byte[]) r12;
        this.list.add(Arrays.copyOf(r13, r13.length));
        goto L4
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int r10) {
        return mutableCopyWithCapacity(r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r10) {
        return remove(r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection r10) {
        return super.removeAll(r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection r10) {
        return super.retainAll(r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
        return set(r10, (String) r11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    public LazyStringArrayList(int r10) {
        this(new ArrayList(r10));
    }

    public void add(int r10, String r11) {
        ensureIsMutable();
        this.list.add(r10, r11);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int r10, Collection<? extends String> r11) {
        ensureIsMutable();
        if ((r11 instanceof LazyStringList) == false) goto L5;
        r11 = ((LazyStringList) r11).getUnderlyingElements();
    L5:
        boolean r12 = this.list.addAll(r10, r11);
        ((AbstractList) this).modCount++;
        return r12;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int r10) {
        Object r11 = this.list.get(r10);
        if ((r11 instanceof String) == false) goto L7;
        return (String) r11;
    L7:
        if ((r11 instanceof ByteString) == false) goto L12;
        ByteString r12 = (ByteString) r11;
        String r13 = r12.toStringUtf8();
        if (r12.isValidUtf8() == false) goto L11;
        this.list.set(r10, r13);
    L11:
        return r13;
    L12:
        byte[] r14 = (byte[]) r11;
        String r15 = Internal.toStringUtf8(r14);
        if (Internal.isValidUtf8(r14) == false) goto L15;
        this.list.set(r10, r15);
    L15:
        return r15;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public LazyStringArrayList mutableCopyWithCapacity(int r10) {
        if (r10 < size()) goto L7;
        ArrayList r11 = new ArrayList(r10);
        r11.addAll(this.list);
        return new LazyStringArrayList(r11);
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object r10) {
        return super.remove(r10);
    }

    public String set(int r10, String r11) {
        ensureIsMutable();
        return asString(this.list.set(r10, r11));
    }

    public LazyStringArrayList(LazyStringList r10) {
        this.list = new ArrayList(r10.size());
        addAll(r10);
    }

    private Object setAndReturn(int r10, byte[] r11) {
        ensureIsMutable();
        return this.list.set(r10, r11);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String remove(int r10) {
        ensureIsMutable();
        Object r11 = this.list.remove(r10);
        ((AbstractList) this).modCount++;
        return asString(r11);
    }

    private void add(int r10, ByteString r11) {
        ensureIsMutable();
        this.list.add(r10, r11);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r10, ByteString r11) {
        setAndReturn(r10, r11);
    }

    public LazyStringArrayList(List<String> r10) {
        this(new ArrayList(r10));
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int r10, byte[] r11) {
        setAndReturn(r10, r11);
    }

    private LazyStringArrayList(ArrayList<Object> r10) {
        this.list = r10;
    }

    private void add(int r10, byte[] r11) {
        ensureIsMutable();
        this.list.add(r10, r11);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString r10) {
        ensureIsMutable();
        this.list.add(r10);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] r10) {
        ensureIsMutable();
        this.list.add(r10);
        ((AbstractList) this).modCount++;
    }
}
