package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {

    @NullableDecl
    private T next;
    private State state;

    /* JADX INFO: renamed from: com.google.common.collect.AbstractIterator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$AbstractIterator$State = null;

        static {
            int[] r10 = new int[State.values().length];
            $SwitchMap$com$google$common$collect$AbstractIterator$State = r10;
            r10[State.DONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$common$collect$AbstractIterator$State[State.READY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DONE = null;
        public static final State FAILED = null;
        public static final State NOT_READY = null;
        public static final State READY = null;

        static {
            State r10 = new State("READY", 0);
            READY = r10;
            State r11 = new State("NOT_READY", 1);
            NOT_READY = r11;
            State r12 = new State("DONE", 2);
            DONE = r12;
            State r13 = new State("FAILED", 3);
            FAILED = r13;
            $VALUES = new State[]{r10, r11, r12, r13};
        }

        private State(String r10, int r11) {
            super(r10, r11);
        }

        public static State valueOf(String r10) {
            return (State) Enum.valueOf(State.class, r10);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    public AbstractIterator() {
        this.state = State.NOT_READY;
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

    public abstract T computeNext();

    @CanIgnoreReturnValue
    public final T endOfData() {
        this.state = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final boolean hasNext() {
        if (this.state == State.FAILED) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkState(r10);
        int r11 = AnonymousClass1.$SwitchMap$com$google$common$collect$AbstractIterator$State[this.state.ordinal()];
        if (r11 != 1) goto L9;
        return false;
    L9:
        if (r11 != 2) goto L11;
        return true;
    L11:
        return tryToComputeNext();
    L5:
        r10 = false;
        goto L6
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final T next() {
        if (hasNext() == false) goto L7;
        this.state = State.NOT_READY;
        T r10 = this.next;
        this.next = null;
        return r10;
    L7:
        throw new NoSuchElementException();
    }

    public final T peek() {
        if (hasNext() == false) goto L7;
        return this.next;
    L7:
        throw new NoSuchElementException();
    }
}
