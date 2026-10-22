package com.bytedance.android.livesdk.arch.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
public interface ITbLifecycle {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/arch/lifecycle/ITbLifecycle$State;", "", "state", "", "isAtLeast", "Initialized", "Created", "Started", "Showed", "Hidden", "Destroyed", "toolbarservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State Created = null;
        public static final State Destroyed = null;
        public static final State Hidden = null;
        public static final State Initialized = null;
        public static final State Showed = null;
        public static final State Started = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f103809a = null;

        static {
            State r100 = new State("Initialized", 0);
            Initialized = r100;
            State r101 = new State("Created", 1);
            Created = r101;
            State r102 = new State("Started", 2);
            Started = r102;
            State r103 = new State("Showed", 3);
            Showed = r103;
            State r104 = new State("Hidden", 4);
            Hidden = r104;
            State r105 = new State("Destroyed", 5);
            Destroyed = r105;
            f103809a = new State[]{r100, r101, r102, r103, r104, r105};
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f103809a.clone();
        }

        public final boolean isAtLeast(State r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if (compareTo(r100) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    void a(State r100);
}
