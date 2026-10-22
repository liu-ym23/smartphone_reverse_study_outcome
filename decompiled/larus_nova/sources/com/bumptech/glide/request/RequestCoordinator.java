package com.bumptech.glide.request;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public interface RequestCoordinator {

    public static final enum RequestState extends Enum<RequestState> {
        private static final /* synthetic */ RequestState[] $VALUES = null;
        public static final RequestState CLEARED = null;
        public static final RequestState FAILED = null;
        public static final RequestState PAUSED = null;
        public static final RequestState RUNNING = null;
        public static final RequestState SUCCESS = null;
        private final boolean isComplete;

        static {
            RequestState r100 = new RequestState("RUNNING", 0, false);
            RUNNING = r100;
            RequestState r101 = new RequestState("PAUSED", 1, false);
            PAUSED = r101;
            RequestState r102 = new RequestState("CLEARED", 2, false);
            CLEARED = r102;
            RequestState r103 = new RequestState("SUCCESS", 3, true);
            SUCCESS = r103;
            RequestState r104 = new RequestState("FAILED", 4, true);
            FAILED = r104;
            $VALUES = new RequestState[]{r100, r101, r102, r103, r104};
        }

        public static RequestState[] values() {
            return (RequestState[]) $VALUES.clone();
        }

        public boolean isComplete() {
            return this.isComplete;
        }

        public static RequestState valueOf(String r100) {
            return (RequestState) a.a(RequestState.class, r100);
        }

        private RequestState(String r100, int r101, boolean r102) {
            super(r100, r101);
            this.isComplete = r102;
        }
    }

    boolean canNotifyCleared(Request r100);

    boolean canNotifyStatusChanged(Request r100);

    boolean canSetImage(Request r100);

    RequestCoordinator getRoot();

    boolean isAnyResourceSet();

    void onRequestFailed(Request r100);

    void onRequestSuccess(Request r100);
}
