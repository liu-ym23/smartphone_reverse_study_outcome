package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArrayMap.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ArrayMapImpl<T> extends ArrayMap<T> {
    public static final Companion Companion = null;
    private Object[] data;
    private int size;

    /* JADX INFO: compiled from: ArrayMap.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Object[] access$getData$p(ArrayMapImpl r0) {
        return r0.data;
    }

    private ArrayMapImpl(Object[] r2, int r3) {
        super(null);
        this.data = r2;
        this.size = r3;
    }

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return this.size;
    }

    private final void ensureCapacity(int r3) {
        Object[] r0 = this.data;
        if (r0.length > r3) goto L6;
        Object[] r4 = Arrays.copyOf(r0, r0.length * 2);
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");
        this.data = r4;
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int r2, T r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        ensureCapacity(r2);
        if (this.data[r2] != null) goto L5;
        this.size = getSize() + 1;
    L5:
        this.data[r2] = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public T get(int r1) {
        return (T) ArraysKt.getOrNull(this.data, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }
}
