package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
final class LongAddables {
    private static final Supplier<LongAddable> SUPPLIER = null;

    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.cache.LongAddable
        public void add(long r10) {
            getAndAdd(r10);
        }

        @Override // com.google.common.cache.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.LongAddable
        public long sum() {
            return get();
        }

        public /* synthetic */ PureJavaLongAddable(AnonymousClass1 r10) {
            this();
        }
    }

    static {
        new LongAdder();     // Catch: Throwable -> L4
        Supplier<LongAddable> r10 = new AnonymousClass1();     // Catch: Throwable -> L4
    L5:
        SUPPLIER = r10;
        return;
    L4:
        r10 = new AnonymousClass2();
        goto L5
    }

    public LongAddables() {
    }

    public static LongAddable create() {
        return SUPPLIER.get();
    }
}
