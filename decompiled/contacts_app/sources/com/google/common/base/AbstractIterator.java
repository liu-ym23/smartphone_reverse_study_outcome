package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractIterator<T> implements Iterator<T> {
    private T next;
    private State state;

    /* JADX INFO: renamed from: com.google.common.base.AbstractIterator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$base$AbstractIterator$State = null;

        static {
            int[] r0 = new int[State.values().length];
            $SwitchMap$com$google$common$base$AbstractIterator$State = r0;
            r0[State.DONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$common$base$AbstractIterator$State[State.READY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DONE = null;
        public static final State FAILED = null;
        public static final State NOT_READY = null;
        public static final State READY = null;

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            State r0 = new State("READY", 0);
            READY = r0;
            State r1 = new State("NOT_READY", 1);
            NOT_READY = r1;
            State r3 = new State("DONE", 2);
            DONE = r3;
            State r5 = new State("FAILED", 3);
            FAILED = r5;
            $VALUES = new State[]{r0, r1, r3, r5};
        }
    }

    protected abstract T computeNext();

    protected AbstractIterator() {
        this.state = State.NOT_READY;
    }

    protected final T endOfData() {
        this.state = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.state == State.FAILED) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        int r1 = AnonymousClass1.$SwitchMap$com$google$common$base$AbstractIterator$State[this.state.ordinal()];
        if (r1 != 1) goto L9;
        return false;
    L9:
        if (r1 != 2) goto L11;
        return true;
    L11:
        return tryToComputeNext();
    L5:
        r0 = false;
        goto L6
    }

    private boolean tryToComputeNext() {
        this.state = State.FAILED;
        this.next = computeNext();
        if (this.state == State.DONE) goto L6;
        this.state = State.READY;
        return true;
    L6:
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext() == false) goto L7;
        this.state = State.NOT_READY;
        T r0 = this.next;
        this.next = null;
        return r0;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
