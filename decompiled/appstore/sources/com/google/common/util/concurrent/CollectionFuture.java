package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    public abstract class CollectionFutureRunningState extends AggregateFuture<V, C>.RunningState {
        final /* synthetic */ CollectionFuture this$0;
        private List<Optional<V>> values;

        public CollectionFutureRunningState(CollectionFuture r10, ImmutableCollection<? extends ListenableFuture<? extends V>> r11, boolean r12) {
            this.this$0 = r10;
            super(r10, r11, r12, true);
            if (r11.isEmpty() == false) goto L5;
            List<Optional<V>> r13 = ImmutableList.of();
        L6:
            this.values = r13;
            int r14 = 0;
        L8:
            if (r14 >= r11.size()) goto L10;
            this.values.add(null);
            r14 = r14 + 1;
            goto L8
        L10:
            return;
        L5:
            r13 = Lists.newArrayListWithCapacity(r11.size());
            goto L6
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public final void collectOneValue(boolean r10, int r11, @NullableDecl V r12) {
            List<Optional<V>> r13 = this.values;
            if (r13 == null) goto L5;
            r13.set(r11, Optional.fromNullable(r12));
            return;
        L5:
            if (r10 == false) goto L7;
        L10:
            boolean r14 = true;
        L11:
            Preconditions.checkState(r14, "Future was done before all dependencies completed");
            return;
        L7:
            if (this.this$0.isCancelled() == true) goto L10;
            r14 = false;
            goto L11
        }

        public abstract C combine(List<Optional<V>> r10);

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public final void handleAllCompleted() {
            List<Optional<V>> r10 = this.values;
            if (r10 == null) goto L5;
            this.this$0.set(combine(r10));
            return;
        L5:
            Preconditions.checkState(this.this$0.isDone());
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void releaseResourcesAfterFailure() {
            super.releaseResourcesAfterFailure();
            this.values = null;
        }
    }

    public static final class ListFuture<V> extends CollectionFuture<V, List<V>> {

        public final class ListFutureRunningState extends CollectionFuture<V, List<V>>.CollectionFutureRunningState {
            final /* synthetic */ ListFuture this$0;

            public ListFutureRunningState(ListFuture r10, ImmutableCollection<? extends ListenableFuture<? extends V>> r11, boolean r12) {
                this.this$0 = r10;
                super(r10, r11, r12);
            }

            @Override // com.google.common.util.concurrent.CollectionFuture.CollectionFutureRunningState
            public /* bridge */ /* synthetic */ Object combine(List r10) {
                return combine(r10);
            }

            @Override // com.google.common.util.concurrent.CollectionFuture.CollectionFutureRunningState
            public List<V> combine(List<Optional<V>> r10) {
                ArrayList r11 = Lists.newArrayListWithCapacity(r10.size());
                Iterator<Optional<V>> r12 = r10.iterator();
            L4:
                if (r12.hasNext() == false) goto L11;
                Optional<V> r13 = r12.next();
                if (r13 == null) goto L8;
                V r14 = r13.orNull();
            L9:
                r11.add(r14);
                goto L4
            L8:
                r14 = null;
                goto L9
            L11:
                return Collections.unmodifiableList(r11);
            }
        }

        public ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> r10, boolean r11) {
            init(new ListFutureRunningState(this, r10, r11));
        }
    }

    public CollectionFuture() {
    }
}
