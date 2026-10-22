package com.android.server.wm.utils;

import android.annotation.IntRange;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.AnnotationValidations;
import com.obric.cae.libs.nfc.CaeNfcTransitRecord;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public class StateMachine {
    private static final String TAG = "StateMachine";
    private final Queue<Command> mCommands;
    private int mLastRequestedState;
    private int mState;
    private final SparseArray<Handler> mStateHandlers;
    private final IntArray mTmp;

    protected static class Command {
        static final int COMMIT = 1;
        static final int ENTER = 2;
        static final int EXIT = 3;
        final int mState;
        final int mType;

        private Command(int type, int state) {
            this.mType = type;
            AnnotationValidations.validate(IntRange.class, null, state, "from", 0);
            this.mState = state;
        }

        static Command newCommit(int state) {
            return new Command(1, state);
        }

        static Command newEnter(int state) {
            return new Command(2, state);
        }

        static Command newExit(int state) {
            return new Command(3, state);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Command{ type: ");
            switch(this.mType) {
                case 1: goto L7;
                case 2: goto L6;
                case 3: goto L5;
                default: goto L4;
            };
        L4:
            sb.append("UNKNOWN(");
            sb.append(this.mType);
            sb.append(")");
        L8:
            sb.append(" state: ");
            sb.append(Integer.toHexString(this.mState));
            sb.append(" }");
            return sb.toString();
        L5:
            sb.append(CaeNfcTransitRecord.EVENT_TYPE_EXIT);
            goto L8
        L6:
            sb.append("enter");
            goto L8
        L7:
            sb.append("commit");
            goto L8
        }
    }

    public interface Handler {
        default void enter() {
        }

        default void exit() {
        }

        default boolean handle(int event, Object param) {
            return false;
        }
    }

    public StateMachine() {
        this(0);
    }

    public StateMachine(int initialState) {
        this.mTmp = new IntArray();
        this.mStateHandlers = new SparseArray();
        this.mCommands = new ArrayDeque();
        this.mState = initialState;
        AnnotationValidations.validate(IntRange.class, null, initialState, "from", 0);
        this.mLastRequestedState = initialState;
    }

    public int getState() {
        return this.mLastRequestedState;
    }

    protected int getCurrentState() {
        return this.mState;
    }

    protected Command[] getCommands() {
        Command[] commands = new Command[this.mCommands.size()];
        this.mCommands.toArray(commands);
        return commands;
    }

    public Handler addStateHandler(int state, Handler handler) {
        Handler handlerOld = this.mStateHandlers.get(state);
        this.mStateHandlers.put(state, handler);
        return handlerOld;
    }

    public void handle(int event, Object param) {
        int state = this.mState;
    L3:
        Handler h = this.mStateHandlers.get(state);
        if (h != null) goto L6;
    L7:
        if (state == 0) goto L12;
        state = state >> 4;
        goto L3
    L12:
        return;
    L6:
        if (h.handle(event, param) == false) goto L7;
    }

    protected void enter(int state) {
        AnnotationValidations.validate(IntRange.class, null, state, "from", 0);
        Handler h = this.mStateHandlers.get(state);
        if (h == null) goto L6;
        h.enter();
        return;
    }

    protected void exit(int state) {
        AnnotationValidations.validate(IntRange.class, null, state, "from", 0);
        Handler h = this.mStateHandlers.get(state);
        if (h == null) goto L6;
        h.exit();
        return;
    }

    public static boolean isIn(int subState, int superState) {
    L2:
        if (subState <= superState) goto L4;
        subState = subState >> 4;
        goto L2
    L4:
        if (subState != superState) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean isIn(int state) {
        return isIn(this.mLastRequestedState, state);
    }

    public void transit(int newState) {
        AnnotationValidations.validate(IntRange.class, null, newState, "from", 0);
        this.mCommands.add(Command.newCommit(newState));
        if (this.mLastRequestedState != newState) goto L5;
        this.mCommands.add(Command.newExit(newState));
        this.mCommands.add(Command.newEnter(newState));
    L16:
        this.mLastRequestedState = newState;
    L18:
        if (this.mCommands.isEmpty() == true) goto L26;
        Command cmd = this.mCommands.remove();
        switch(cmd.mType) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            default: goto L21;
        };
    L22:
        exit(cmd.mState);
        goto L18
    L23:
        enter(cmd.mState);
        goto L18
    L24:
        this.mState = cmd.mState;
        goto L18
    L21:
        Slog.e(TAG, "Unknown command type: " + cmd.mType);
        goto L18
    L26:
        return;
    L5:
        int s = this.mLastRequestedState;
    L7:
        if (isIn(newState, s) == true) goto L9;
        this.mCommands.add(Command.newExit(s));
        s = s >> 4;
        goto L7
    L9:
        this.mTmp.clear();
        int s2 = newState;
    L11:
        if (isIn(this.mLastRequestedState, s2) == true) goto L13;
        this.mTmp.add(s2);
        s2 = s2 >> 4;
        goto L11
    L13:
        int i = this.mTmp.size() - 1;
    L14:
        if (i < 0) goto L16;
        this.mCommands.add(Command.newEnter(this.mTmp.get(i)));
        i = i - 1;
        goto L14
    }
}
