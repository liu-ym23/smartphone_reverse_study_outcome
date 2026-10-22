package com.android.server.dreams;

import com.android.internal.logging.UiEventLogger;
import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes2.dex */
public interface DreamUiEventLogger {

    public static final enum DreamUiEventEnum extends Enum<DreamUiEventEnum> implements UiEventLogger.UiEventEnum {
        private static final /* synthetic */ DreamUiEventEnum[] $VALUES = null;
        public static final DreamUiEventEnum DREAM_START = null;
        public static final DreamUiEventEnum DREAM_STOP = null;
        private final int mId;

        private static /* synthetic */ DreamUiEventEnum[] $values() {
            return new DreamUiEventEnum[]{DREAM_START, DREAM_STOP};
        }

        public static DreamUiEventEnum valueOf(String name) {
            return (DreamUiEventEnum) Enum.valueOf(DreamUiEventEnum.class, name);
        }

        public static DreamUiEventEnum[] values() {
            return (DreamUiEventEnum[]) $VALUES.clone();
        }

        static {
            DREAM_START = new DreamUiEventEnum("DREAM_START", 0, 577);
            DREAM_STOP = new DreamUiEventEnum("DREAM_STOP", 1, FrameworkStatsLog.HOTWORD_AUDIO_EGRESS_EVENT_REPORTED);
            $VALUES = $values();
        }

        private DreamUiEventEnum(String r1, int r2, int id) {
            super(r1, r2);
            this.mId = id;
        }

        public int getId() {
            return this.mId;
        }
    }

    void log(UiEventLogger.UiEventEnum r1, String r2);
}
