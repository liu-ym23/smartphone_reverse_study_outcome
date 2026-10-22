package rx;

import rx.functions.Cancellable;

/* JADX INFO: loaded from: classes4.dex */
public interface Emitter<T> extends Observer<T> {

    public static final enum BackpressureMode extends Enum<BackpressureMode> {
        private static final /* synthetic */ BackpressureMode[] $VALUES = null;
        public static final BackpressureMode BUFFER = null;
        public static final BackpressureMode DROP = null;
        public static final BackpressureMode ERROR = null;
        public static final BackpressureMode LATEST = null;
        public static final BackpressureMode NONE = null;

        static {
            BackpressureMode r10 = new BackpressureMode("NONE", 0);
            NONE = r10;
            BackpressureMode r11 = new BackpressureMode("ERROR", 1);
            ERROR = r11;
            BackpressureMode r12 = new BackpressureMode("BUFFER", 2);
            BUFFER = r12;
            BackpressureMode r13 = new BackpressureMode("DROP", 3);
            DROP = r13;
            BackpressureMode r14 = new BackpressureMode("LATEST", 4);
            LATEST = r14;
            $VALUES = new BackpressureMode[]{r10, r11, r12, r13, r14};
        }

        private BackpressureMode(String r10, int r11) {
            super(r10, r11);
        }

        public static BackpressureMode valueOf(String r10) {
            return (BackpressureMode) Enum.valueOf(BackpressureMode.class, r10);
        }

        public static BackpressureMode[] values() {
            return (BackpressureMode[]) $VALUES.clone();
        }
    }

    long requested();

    void setCancellation(Cancellable r10);

    void setSubscription(Subscription r10);
}
