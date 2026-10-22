package io.reactivex.subjects;

import androidx.appcompat.widget.p;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.NotificationLite;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mf.f;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ReplaySubject extends a {

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        public Node(T r10) {
            this.value = r10;
        }
    }

    public interface ReplayBuffer<T> {
        void add(T r10);

        void addFinal(Object r10);

        boolean compareAndSet(Object r10, Object r11);

        Object get();

        @Nullable
        T getValue();

        T[] getValues(T[] r10);

        void replay(ReplayDisposable<T> r10);

        int size();

        void trimHead();
    }

    public static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Observer<? super T> downstream;
        Object index;
        final ReplaySubject state;

        public ReplayDisposable(Observer<? super T> r10, ReplaySubject r11) {
            this.downstream = r10;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            throw null;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile TimedNode<Object> head;
        final long maxAge;
        final int maxSize;
        final f scheduler;
        int size;
        TimedNode<Object> tail;
        final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int r10, long r11, TimeUnit r12, f r13) {
            this.maxSize = io.reactivex.internal.functions.a.c(r10, "maxSize");
            this.maxAge = io.reactivex.internal.functions.a.d(r11, "maxAge");
            this.unit = (TimeUnit) io.reactivex.internal.functions.a.b(r12, "unit is null");
            p.a(io.reactivex.internal.functions.a.b(r13, "scheduler is null"));
            TimedNode<Object> r14 = new TimedNode(null, 0);
            this.tail = r14;
            this.head = r14;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T r10) {
            throw null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object r10) {
            TimedNode<Object> r11 = new TimedNode(r10, Long.MAX_VALUE);
            TimedNode<Object> r12 = this.tail;
            this.tail = r11;
            this.size++;
            r12.lazySet(r11);
            trimFinal();
            this.done = true;
        }

        public TimedNode<Object> getHead() {
            throw null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        @Nullable
        public T getValue() {
            TimedNode<T> r10 = this.head;
        L3:
            r10 = r10.get();
            r10.getClass();
            goto L3
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] r10) {
            TimedNode<T> r11 = getHead();
            int r12 = size(r11);
            int r13 = 0;
            if (r12 != 0) goto L8;
            if (r10.length == 0) goto L15;
            r10[0] = null;
        L15:
            return r10;
        L8:
            if (r10.length >= r12) goto L10;
            r10 = (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), r12));
        L10:
            if (r13 == r12) goto L13;
            r11 = r11.get();
            T[] r14 = r10;
            r14[r13] = r11.value;
            r13 = r13 + 1;
            goto L10
        L13:
            if (r10.length <= r12) goto L15;
            r10[r12] = null;
            goto L15
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> r10) {
            if (r10.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super T> r11 = r10.downstream;
            TimedNode<Object> r12 = (TimedNode) r10.index;
            if (r12 != null) goto L8;
            r12 = getHead();
        L8:
            int r13 = 1;
        L10:
            if (r10.cancelled == true) goto L11;
        L14:
            if (r10.cancelled == true) goto L15;
            TimedNode<T> r14 = r12.get();
            if (r14 == null) goto L20;
            T r15 = r14.value;
            if (this.done == false) goto L35;
            if (r14.get() != null) goto L35;
            if (NotificationLite.isComplete(r15) == false) goto L32;
            r11.onComplete();
        L33:
            r10.index = null;
            r10.cancelled = true;
            return;
        L32:
            r11.onError(NotificationLite.getError(r15));
        L35:
            r11.onNext(r15);
            r12 = r14;
            goto L14
        L20:
            if (r12.get() != null) goto L10;
            r10.index = r12;
            r13 = r10.addAndGet(-r13);
            if (r13 != 0) goto L10;
            return;
        L15:
            r10.index = null;
            return;
        L11:
            r10.index = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            return size(getHead());
        }

        public void trim() {
            int r10 = this.size;
            if (r10 <= this.maxSize) goto L6;
            this.size = r10 - 1;
            this.head = this.head.get();
        L6:
            throw null;
        }

        public void trimFinal() {
            throw null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            TimedNode<Object> r10 = this.head;
            if (r10.value == null) goto L6;
            TimedNode<Object> r11 = new TimedNode(null, 0);
            r11.lazySet(r10.get());
            this.head = r11;
            return;
        }

        public int size(TimedNode<Object> r10) {
            int r11 = 0;
        L4:
            if (r11 == Integer.MAX_VALUE) goto L17;
            TimedNode<T> r12 = r10.get();
            if (r12 == null) goto L7;
            r11 = r11 + 1;
            r10 = r12;
            goto L4
        L7:
            Object r13 = r10.value;
            if (NotificationLite.isComplete(r13) == true) goto L16;
            if (NotificationLite.isError(r13) == true) goto L16;
            return r11;
        L16:
            return r11 - 1;
        L17:
            return r11;
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile Node<Object> head;
        final int maxSize;
        int size;
        Node<Object> tail;

        public SizeBoundReplayBuffer(int r10) {
            this.maxSize = io.reactivex.internal.functions.a.c(r10, "maxSize");
            Node<Object> r11 = new Node(null);
            this.tail = r11;
            this.head = r11;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T r10) {
            Node<Object> r11 = new Node(r10);
            Node<Object> r12 = this.tail;
            this.tail = r11;
            this.size++;
            r12.set(r11);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object r10) {
            Node<Object> r11 = new Node(r10);
            Node<Object> r12 = this.tail;
            this.tail = r11;
            this.size++;
            r12.lazySet(r11);
            trimHead();
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        @Nullable
        public T getValue() {
            Node<Object> r10 = this.head;
            Node<Object> r11 = null;
        L3:
            Node<T> r12 = r10.get();
            if (r12 == null) goto L5;
            r11 = r10;
            r10 = r12;
            goto L3
        L5:
            T r13 = (T) r10.value;
            if (r13 != null) goto L9;
            return null;
        L9:
            if (NotificationLite.isComplete(r13) == true) goto L15;
            if (NotificationLite.isError(r13) == true) goto L15;
            return r13;
        L15:
            return (T) r11.value;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] r10) {
            Node<T> r11 = this.head;
            int r12 = size();
            int r13 = 0;
            if (r12 != 0) goto L8;
            if (r10.length == 0) goto L15;
            r10[0] = null;
        L15:
            return r10;
        L8:
            if (r10.length >= r12) goto L10;
            r10 = (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), r12));
        L10:
            if (r13 == r12) goto L13;
            r11 = r11.get();
            T[] r14 = r10;
            r14[r13] = r11.value;
            r13 = r13 + 1;
            goto L10
        L13:
            if (r10.length <= r12) goto L15;
            r10[r12] = null;
            goto L15
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> r10) {
            if (r10.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super T> r11 = r10.downstream;
            Node<Object> r12 = (Node) r10.index;
            if (r12 != null) goto L8;
            r12 = this.head;
        L8:
            int r13 = 1;
        L10:
            if (r10.cancelled == true) goto L11;
            Node<T> r14 = r12.get();
            if (r14 == null) goto L16;
            T r15 = r14.value;
            if (this.done == true) goto L24;
        L31:
            r11.onNext(r15);
            r12 = r14;
            goto L10
        L24:
            if (r14.get() != null) goto L31;
            if (NotificationLite.isComplete(r15) == false) goto L28;
            r11.onComplete();
        L29:
            r10.index = null;
            r10.cancelled = true;
            return;
        L28:
            r11.onError(NotificationLite.getError(r15));
            goto L29
        L16:
            if (r12.get() != null) goto L10;
            r10.index = r12;
            r13 = r10.addAndGet(-r13);
            if (r13 != 0) goto L10;
            return;
        L11:
            r10.index = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            Node<Object> r10 = this.head;
            int r11 = 0;
        L4:
            if (r11 == Integer.MAX_VALUE) goto L17;
            Node<T> r12 = r10.get();
            if (r12 == null) goto L7;
            r11 = r11 + 1;
            r10 = r12;
            goto L4
        L7:
            Object r13 = r10.value;
            if (NotificationLite.isComplete(r13) == true) goto L16;
            if (NotificationLite.isError(r13) == true) goto L16;
            return r11;
        L16:
            return r11 - 1;
        L17:
            return r11;
        }

        public void trim() {
            int r10 = this.size;
            if (r10 <= this.maxSize) goto L6;
            this.size = r10 - 1;
            this.head = this.head.get();
            return;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            Node<Object> r10 = this.head;
            if (r10.value == null) goto L6;
            Node<Object> r11 = new Node(null);
            r11.lazySet(r10.get());
            this.head = r11;
            return;
        }
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        public TimedNode(T r10, long r11) {
            this.value = r10;
            this.time = r11;
        }
    }

    public static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        public UnboundedReplayBuffer(int r10) {
            this.buffer = new ArrayList(io.reactivex.internal.functions.a.c(r10, "capacityHint"));
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T r10) {
            this.buffer.add(r10);
            this.size++;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object r10) {
            this.buffer.add(r10);
            trimHead();
            this.size++;
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        @Nullable
        public T getValue() {
            int r10 = this.size;
            if (r10 == 0) goto L15;
            List<Object> r11 = this.buffer;
            T r12 = (T) r11.get(r10 - 1);
            if (NotificationLite.isComplete(r12) == true) goto L11;
            if (NotificationLite.isError(r12) == true) goto L11;
            return r12;
        L11:
            if (r10 != 1) goto L14;
            return null;
        L14:
            return (T) r11.get(r10 - 2);
        L15:
            return null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] r10) {
            int r11 = this.size;
            int r12 = 0;
            if (r11 == 0) goto L5;
            List<Object> r13 = this.buffer;
            Object r14 = r13.get(r11 - 1);
            if (NotificationLite.isComplete(r14) == false) goto L11;
        L12:
            r11 = r11 - 1;
            if (r11 == 0) goto L15;
        L19:
            if (r10.length >= r11) goto L21;
            r10 = (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), r11));
        L21:
            if (r12 >= r11) goto L24;
            r10[r12] = r13.get(r12);
            r12 = r12 + 1;
            goto L21
        L24:
            if (r10.length <= r11) goto L26;
            r10[r11] = null;
        L26:
            return r10;
        L15:
            if (r10.length == 0) goto L17;
            r10[0] = null;
        L17:
            return r10;
        L11:
            if (NotificationLite.isError(r14) == false) goto L19;
        L5:
            if (r10.length == 0) goto L7;
            r10[0] = null;
        L7:
            return r10;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> r10) {
            if (r10.getAndIncrement() == 0) goto L5;
            return;
        L5:
            List<Object> r11 = this.buffer;
            Observer<? super T> r12 = r10.downstream;
            Integer r13 = (Integer) r10.index;
            if (r13 == null) goto L9;
            int r14 = r13.intValue();
        L8:
            int r15 = 1;
        L11:
            if (r10.cancelled == true) goto L12;
            int r16 = this.size;
        L15:
            if (r16 == r14) goto L34;
            if (r10.cancelled == true) goto L18;
            Object r17 = r11.get(r14);
            if (this.done == false) goto L32;
            int r18 = r14 + 1;
            if (r18 != r16) goto L32;
            r16 = this.size;
            if (r18 != r16) goto L32;
            if (NotificationLite.isComplete(r17) == false) goto L29;
            r12.onComplete();
        L30:
            r10.index = null;
            r10.cancelled = true;
            return;
        L29:
            r12.onError(NotificationLite.getError(r17));
        L32:
            r12.onNext(r17);
            r14 = r14 + 1;
            goto L15
        L18:
            r10.index = null;
            return;
        L34:
            if (r14 != this.size) goto L11;
            r10.index = Integer.valueOf(r14);
            r15 = r10.addAndGet(-r15);
            if (r15 != 0) goto L11;
            return;
        L12:
            r10.index = null;
            return;
        L9:
            r14 = 0;
            r10.index = 0;
            goto L8
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            int r10 = this.size;
            if (r10 == 0) goto L11;
            int r11 = r10 - 1;
            Object r12 = this.buffer.get(r11);
            if (NotificationLite.isComplete(r12) == false) goto L7;
        L10:
            return r11;
        L7:
            if (NotificationLite.isError(r12) == true) goto L10;
            return r10;
        L11:
            return 0;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
        }
    }
}
