package com.bytedance.android.btm.api;

import com.bytedance.android.btm.api.model.m;
import com.bytedance.android.btm.api.model.o;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
public interface BtmPageLifecycle {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/btm/api/BtmPageLifecycle$State;", "", "state", "", "isAtLeast", "INITIALIZED", "CREATED", "RESUMED", "PAUSED", "DESTROYED", "btm-api_cnRelease"}, k = 1, mv = {1, 4, 0})
    public static final enum State extends Enum<State> {
        public static final State CREATED = null;
        public static final State DESTROYED = null;
        public static final State INITIALIZED = null;
        public static final State PAUSED = null;
        public static final State RESUMED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f41959a = null;

        static {
            State r100 = new State("INITIALIZED", 0);
            INITIALIZED = r100;
            State r101 = new State("CREATED", 1);
            CREATED = r101;
            State r102 = new State("RESUMED", 2);
            RESUMED = r102;
            State r103 = new State("PAUSED", 3);
            PAUSED = r103;
            State r104 = new State("DESTROYED", 4);
            DESTROYED = r104;
            f41959a = new State[]{r100, r101, r102, r103, r104};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f41959a.clone();
        }

        public boolean isAtLeast(State r100) {
            if (compareTo(r100) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static /* synthetic */ void a(BtmPageLifecycle r100, Object r101, Boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L5;
            r102 = null;
        L5:
            r100.e(r101, r102, null);
        }
    }

    void a(Object r100);

    @Deprecated(message = "use onPageShow/onPageHide instead")
    void b(Object r100, boolean r101);

    void c(Object r100, State r101);

    boolean d(Object r100, boolean r101);

    void e(Object r100, Boolean r101, m r102);

    State f(Object r100);

    void g(Object r100, Boolean r101, o r102);
}
