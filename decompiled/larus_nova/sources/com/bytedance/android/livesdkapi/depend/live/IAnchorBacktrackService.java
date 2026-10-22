package com.bytedance.android.livesdkapi.depend.live;

import android.content.Context;
import com.ss.android.download.api.config.HttpMethod;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
public interface IAnchorBacktrackService {

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State BACKTRACK_DOING = null;
        public static final State BACKTRACK_DONE = null;
        public static final State DONE = null;
        public static final State DOWNLOAD = null;
        public static final State IDLE = null;
        public static final State SAVE_DRAFT = null;

        static {
            State r100 = new State("IDLE", 0);
            IDLE = r100;
            State r101 = new State("BACKTRACK_DOING", 1);
            BACKTRACK_DOING = r101;
            State r102 = new State("BACKTRACK_DONE", 2);
            BACKTRACK_DONE = r102;
            State r103 = new State(HttpMethod.DOWNLOAD, 3);
            DOWNLOAD = r103;
            State r104 = new State("SAVE_DRAFT", 4);
            SAVE_DRAFT = r104;
            State r105 = new State("DONE", 5);
            DONE = r105;
            $VALUES = new State[]{r100, r101, r102, r103, r104, r105};
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }
    }

    void discardBacktrack();

    long getDuration();

    String getM3u8Url();

    int getOperationProgress();

    int getProgress();

    State getState();

    void release();

    void startBacktrack();

    void startDownloadWithStorageControl(Context r100, String r101);

    void startSaveDraft(Context r100);
}
