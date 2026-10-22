package com.bytedance.location.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE = null;
    private static final ListFieldSchema LITE_INSTANCE = null;

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.ListFieldSchema$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ListFieldSchemaFull extends ListFieldSchema {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = null;

        private ListFieldSchemaFull() {
            super(null);
        }

        /* synthetic */ ListFieldSchemaFull(AnonymousClass1 x0) {
            this();
        }

        static {
            UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();
        }

        @Override // com.bytedance.location.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object message, long offset) {
            return mutableListAt(message, offset, 10);
        }

        @Override // com.bytedance.location.protobuf.ListFieldSchema
        void makeImmutableListAt(Object message, long offset) {
            List<?> list = (List) UnsafeUtil.getObject(message, offset);
            if ((list instanceof LazyStringList) == false) goto L6;
            Object immutable = ((LazyStringList) list).getUnmodifiableView();
        L17:
            UnsafeUtil.putObject(message, offset, immutable);
            return;
        L6:
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass()) == false) goto L9;
            return;
        L9:
            if ((list instanceof PrimitiveNonBoxingCollection) == true) goto L11;
        L16:
            immutable = Collections.unmodifiableList(list);
            goto L17
        L11:
            if ((list instanceof Internal.ProtobufList) == false) goto L16;
            if (((Internal.ProtobufList) list).isModifiable() == false) goto L19;
            ((Internal.ProtobufList) list).makeImmutable();
            return;
        }

        private static <L> List<L> mutableListAt(Object message, long offset, int additionalCapacity) {
            List<L> list = getList(message, offset);
            if (list.isEmpty() == false) goto L15;
            if ((list instanceof LazyStringList) == false) goto L8;
            List<L> list2 = new LazyStringArrayList(additionalCapacity);
        L13:
            UnsafeUtil.putObject(message, offset, list2);
            return list2;
        L8:
            if ((list instanceof PrimitiveNonBoxingCollection) == true) goto L10;
        L12:
            list2 = new ArrayList(additionalCapacity);
            goto L13
        L10:
            if ((list instanceof Internal.ProtobufList) == false) goto L12;
            list2 = ((Internal.ProtobufList) list).mutableCopyWithCapacity(additionalCapacity);
            goto L13
        L15:
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass()) == false) goto L18;
            ArrayList<L> newList = new ArrayList(list.size() + additionalCapacity);
            newList.addAll(list);
            UnsafeUtil.putObject(message, offset, newList);
            return newList;
        L18:
            if ((list instanceof UnmodifiableLazyStringList) == false) goto L22;
            LazyStringArrayList newList2 = new LazyStringArrayList(list.size() + additionalCapacity);
            newList2.addAll((UnmodifiableLazyStringList) list);
            UnsafeUtil.putObject(message, offset, newList2);
            return newList2;
        L22:
            if ((list instanceof PrimitiveNonBoxingCollection) == true) goto L24;
            return list;
        L24:
            if ((list instanceof Internal.ProtobufList) == true) goto L26;
            return list;
        L26:
            if (((Internal.ProtobufList) list).isModifiable() == true) goto L31;
            List<L> list3 = ((Internal.ProtobufList) list).mutableCopyWithCapacity(list.size() + additionalCapacity);
            UnsafeUtil.putObject(message, offset, list3);
            return list3;
        L31:
            return list;
        }

        @Override // com.bytedance.location.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object msg, Object otherMsg, long offset) {
            List<E> other = getList(otherMsg, offset);
            List<E> mine = mutableListAt(msg, offset, other.size());
            int size = mine.size();
            int otherSize = other.size();
            if (size <= 0) goto L6;
            if (otherSize <= 0) goto L6;
            mine.addAll(other);
        L6:
            if (size <= 0) goto L8;
            List<E> merged = mine;
        L9:
            UnsafeUtil.putObject(msg, offset, merged);
            return;
        L8:
            merged = other;
            goto L9
        }

        static <E> List<E> getList(Object message, long offset) {
            return (List) UnsafeUtil.getObject(message, offset);
        }
    }

    private static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super(null);
        }

        /* synthetic */ ListFieldSchemaLite(AnonymousClass1 x0) {
            this();
        }

        @Override // com.bytedance.location.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object message, long offset) {
            Internal.ProtobufList<L> list = getProtobufList(message, offset);
            if (list.isModifiable() == true) goto L10;
            int size = list.size();
            if (size != 0) goto L7;
            int r2 = 10;
        L8:
            Internal.ProtobufList<L> list2 = list.mutableCopyWithCapacity(r2);
            UnsafeUtil.putObject(message, offset, list2);
            return list2;
        L7:
            r2 = size * 2;
            goto L8
        L10:
            return list;
        }

        @Override // com.bytedance.location.protobuf.ListFieldSchema
        void makeImmutableListAt(Object message, long offset) {
            Internal.ProtobufList<?> list = getProtobufList(message, offset);
            list.makeImmutable();
        }

        @Override // com.bytedance.location.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object msg, Object otherMsg, long offset) {
            Internal.ProtobufList<E> mine = getProtobufList(msg, offset);
            Internal.ProtobufList<E> other = getProtobufList(otherMsg, offset);
            int size = mine.size();
            int otherSize = other.size();
            if (size <= 0) goto L9;
            if (otherSize <= 0) goto L9;
            if (mine.isModifiable() == true) goto L8;
            mine = mine.mutableCopyWithCapacity(size + otherSize);
        L8:
            mine.addAll(other);
        L9:
            if (size <= 0) goto L11;
            Internal.ProtobufList<E> merged = mine;
        L12:
            UnsafeUtil.putObject(msg, offset, merged);
            return;
        L11:
            merged = other;
            goto L12
        }

        static <E> Internal.ProtobufList<E> getProtobufList(Object message, long offset) {
            return (Internal.ProtobufList) UnsafeUtil.getObject(message, offset);
        }
    }

    abstract void makeImmutableListAt(Object r1, long r2);

    abstract <L> void mergeListsAt(Object r1, Object r2, long r3);

    abstract <L> List<L> mutableListAt(Object r1, long r2);

    /* synthetic */ ListFieldSchema(AnonymousClass1 x0) {
        this();
    }

    private ListFieldSchema() {
    }

    static {
        AnonymousClass1 r1 = null;
        FULL_INSTANCE = new ListFieldSchemaFull(r1);
        LITE_INSTANCE = new ListFieldSchemaLite(r1);
    }

    static ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    static ListFieldSchema lite() {
        return LITE_INSTANCE;
    }
}
