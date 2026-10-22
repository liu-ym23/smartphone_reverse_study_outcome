package com.bytedance.android.gamecp.common.collection;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
public class ObservableList<E> implements List<E>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Function2<DataChangeType, E, Unit>> f56509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<? extends E> f56510b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/common/collection/ObservableList$DataChangeType;", "", "ADD", "REMOVE", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DataChangeType extends Enum<DataChangeType> {
        public static final DataChangeType ADD = null;
        public static final DataChangeType REMOVE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataChangeType[] f56511a = null;

        static {
            DataChangeType r100 = new DataChangeType("ADD", 0);
            ADD = r100;
            DataChangeType r101 = new DataChangeType("REMOVE", 1);
            REMOVE = r101;
            f56511a = new DataChangeType[]{r100, r101};
        }

        public static DataChangeType valueOf(String r100) {
            return (DataChangeType) a.a(DataChangeType.class, r100);
        }

        public static DataChangeType[] values() {
            return (DataChangeType[]) f56511a.clone();
        }

        public DataChangeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<E> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return ((cu.a) this).f465407c.size();
    }

    @Override // java.util.List
    public final void sort(Comparator<? super E> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    public ObservableList(List<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f56510b = r100;
        this.f56509a = new LinkedHashSet();
    }
}
