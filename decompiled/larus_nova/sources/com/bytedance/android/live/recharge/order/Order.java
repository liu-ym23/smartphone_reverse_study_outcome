package com.bytedance.android.live.recharge.order;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
public interface Order {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0011\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/order/Order$State;", "", "", "isClosed", "()Z", "Open", "Accepted", "Successful", "Failed", "Canceled", "Transmitting", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum State extends Enum<State> {
        public static final State Accepted = null;
        public static final State Canceled = null;
        public static final State Failed = null;
        public static final State Open = null;
        public static final State Successful = null;
        public static final State Transmitting = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f90063a = null;

        static {
            State r100 = new State("Open", 0);
            Open = r100;
            State r101 = new State("Accepted", 1);
            Accepted = r101;
            State r102 = new State("Successful", 2);
            Successful = r102;
            State r103 = new State("Failed", 3);
            Failed = r103;
            State r104 = new State("Canceled", 4);
            Canceled = r104;
            State r105 = new State("Transmitting", 5);
            Transmitting = r105;
            f90063a = new State[]{r100, r101, r102, r103, r104, r105};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f90063a.clone();
        }

        public final boolean isClosed() {
            int r100 = com.bytedance.android.live.recharge.order.b.f90081a[ordinal()];
            if (r100 != 1) goto L5;
            return true;
        L5:
            if (r100 != 2) goto L7;
            return true;
        L7:
            if (r100 == 3) goto L12;
            return false;
        L12:
            return true;
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(Object r100);

        void b(Object r100);

        void c(Object r100);

        void cancel(Object r100);

        void d(Object r100);

        void e(e r100);

        f.b getOrder();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f90064a = null;

        public b() {
        }

        static {
            f90064a = new b();
        }
    }

    k a();

    com.bytedance.android.live.revenue.common.reactive.c getProgress();

    Object getResult();

    com.bytedance.android.live.revenue.common.reactive.c getState();

    com.bytedance.android.live.recharge.deal.f o();
}
