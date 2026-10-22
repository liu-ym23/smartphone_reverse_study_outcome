package com.obric.capabilitykit.common;

/* JADX INFO: loaded from: classes3.dex */
public final class StopReason {
    public static final String CLARIFY_TIMEOUT = "clarify_timeout";
    public static final Companion Companion = null;
    public static final String DIRECT_SEND_INTERRUPT = "direct_send_interrupt";
    public static final String SYSTEM_TERMINATE = "system_terminate";
    public static final String USER_STOP_COMPLEX_TASK = "user_stop_complex_task";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(d.h.b.h r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StopReason() {
    }
}
