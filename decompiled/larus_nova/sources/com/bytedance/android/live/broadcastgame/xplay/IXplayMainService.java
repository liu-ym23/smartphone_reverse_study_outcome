package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public interface IXplayMainService {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/IXplayMainService$State;", "", "state", "", "isAtLeast", "", "precedence", "I", "Uninitialized", "Preloading", "Preloaded", "StartingFailed", "Starting", "Started", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State Preloaded = null;
        public static final State Preloading = null;
        public static final State Started = null;
        public static final State Starting = null;
        public static final State StartingFailed = null;
        public static final State Uninitialized = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f61855a = null;
        private final int precedence;

        static {
            State r100 = new State("Uninitialized", 0, 0);
            Uninitialized = r100;
            State r101 = new State("Preloading", 1, 1);
            Preloading = r101;
            State r102 = new State("Preloaded", 2, 2);
            Preloaded = r102;
            State r103 = new State("StartingFailed", 3, 2);
            StartingFailed = r103;
            State r104 = new State("Starting", 4, 3);
            Starting = r104;
            State r105 = new State("Started", 5, 4);
            Started = r105;
            f61855a = new State[]{r100, r101, r102, r103, r104, r105};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f61855a.clone();
        }

        public final boolean isAtLeast(State r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (this.precedence < r100.precedence) goto L5;
            return true;
        L5:
            return false;
        }

        public State(String r100, int r101, int r102) {
            super(r100, r101);
            this.precedence = r102;
        }
    }

    void a();
}
