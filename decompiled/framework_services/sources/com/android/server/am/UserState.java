package com.android.server.am;

import android.app.IStopUserCallback;
import android.os.Trace;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.ProgressReporter;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class UserState {
    public static final int STATE_BOOTING = 0;
    public static final int STATE_NONE = -1;
    public static final int STATE_RUNNING_LOCKED = 1;
    public static final int STATE_RUNNING_UNLOCKED = 3;
    public static final int STATE_RUNNING_UNLOCKING = 2;
    public static final int STATE_SHUTDOWN = 5;
    public static final int STATE_STOPPING = 4;
    private static final String TAG = "ActivityManager";
    public int lastState;
    public final UserHandle mHandle;
    public final ArrayList<KeyEvictedCallback> mKeyEvictedCallbacks;
    final ArrayMap<String, Long> mProviderLastReportedFg;
    public final ArrayList<IStopUserCallback> mStopCallbacks;
    public final ProgressReporter mUnlockProgress;
    public int state;
    public boolean switching;

    public interface KeyEvictedCallback {
        void keyEvicted(int r1);
    }

    public UserState(UserHandle handle) {
        this.mStopCallbacks = new ArrayList();
        this.mKeyEvictedCallbacks = new ArrayList();
        this.state = 0;
        this.lastState = 0;
        this.mProviderLastReportedFg = new ArrayMap();
        this.mHandle = handle;
        this.mUnlockProgress = new ProgressReporter(handle.getIdentifier());
    }

    public boolean setState(int oldState, int newState) {
        if (this.state != oldState) goto L6;
        setState(newState);
        return true;
    L6:
        Slog.w(TAG, "Expected user " + this.mHandle.getIdentifier() + " in state " + stateToString(oldState) + " but was in state " + stateToString(this.state));
        return false;
    }

    public void setState(int newState) {
        if (newState != this.state) goto L5;
        return;
    L5:
        int userId = this.mHandle.getIdentifier();
        if (this.state == 0) goto L9;
        Trace.asyncTraceEnd(64, stateToString(this.state) + " " + userId, userId);
    L9:
        if (newState == 5) goto L11;
        Trace.asyncTraceBegin(64, stateToString(newState) + " " + userId, userId);
    L11:
        Slog.i(TAG, "User " + userId + " state changed from " + stateToString(this.state) + " to " + stateToString(newState));
        EventLogTags.writeAmUserStateChanged(userId, newState);
        this.lastState = this.state;
        this.state = newState;
    }

    public static String stateToString(int state) {
        switch(state) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L4;
        };
    L5:
        return "SHUTDOWN";
    L7:
        return "STOPPING";
    L9:
        return "RUNNING_UNLOCKED";
    L11:
        return "RUNNING_UNLOCKING";
    L13:
        return "RUNNING_LOCKED";
    L15:
        return "BOOTING";
    L4:
        return Integer.toString(state);
    }

    public static int stateToProtoEnum(int state) {
        switch(state) {
            case 0: goto L14;
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L6;
            case 5: goto L4;
            default: goto L3;
        };
    L3:
        return state;
    L4:
        return 5;
    L6:
        return 4;
    L8:
        return 3;
    L10:
        return 2;
    L12:
        return 1;
    L14:
        return 0;
    }

    void dump(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("state=");
        pw.print(stateToString(this.state));
        if (this.switching == false) goto L5;
        pw.print(" SWITCHING");
    L5:
        pw.println();
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1159641169921L, stateToProtoEnum(this.state));
        proto.write(1133871366146L, this.switching);
        proto.end(token);
    }

    public String toString() {
        return "[UserState: id=" + this.mHandle.getIdentifier() + ", state=" + stateToString(this.state) + ", lastState=" + stateToString(this.lastState) + ", switching=" + this.switching + "]";
    }
}
