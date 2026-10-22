package com.obric.livecard.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;

/* JADX INFO: compiled from: LiveCardType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum LiveCardType extends Enum<LiveCardType> {
    private static final /* synthetic */ LiveCardType[] $VALUES = null;
    public static final LiveCardType ALARM = null;
    public static final LiveCardType ASSISTANT = null;
    public static final LiveCardType AUTO_DISMISS = null;
    public static final LiveCardType BATTERY = null;
    public static final LiveCardType CALL = null;
    public static final LiveCardType COUNT_DOWN = null;
    public static final Companion Companion = null;
    public static final LiveCardType LOCK = null;
    public static final LiveCardType MEMORY_DATA = null;
    public static final LiveCardType MUSIC = null;
    public static final LiveCardType MUTE = null;
    public static final LiveCardType OAUTO = null;
    public static final LiveCardType RING_DOWN = null;
    public static final LiveCardType SCREEN_CAP = null;
    public static final LiveCardType SOUND_RECORD = null;
    public static final LiveCardType STOP_WATCH = null;
    public static final LiveCardType TRANSFER_DATA = null;
    public static final LiveCardType VIBRATE = null;

    /* JADX INFO: compiled from: LiveCardType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final LiveCardType fromString(String r2) {
            o.e(r2, "value");
            n.a r1 = n.f38560a;     // Catch: Throwable -> L5
            Object r3 = n.f(LiveCardType.valueOf(r2));     // Catch: Throwable -> L5
        L8:
            if (n.b(r3) == false) goto L11;
            r3 = null;
        L11:
            return (LiveCardType) ZeusTransformUtils.preCheckCast(r3, LiveCardType.class, "com.obric.aiagent.plugin");
        L5:
            th = move-exception;
            n.a r4 = n.f38560a;
            r3 = n.f(d.o.a(th));
            goto L8
        }
    }

    private static final /* synthetic */ LiveCardType[] $values() {
        return new LiveCardType[]{CALL, ASSISTANT, OAUTO, MEMORY_DATA, SCREEN_CAP, BATTERY, VIBRATE, RING_DOWN, MUTE, AUTO_DISMISS, SOUND_RECORD, TRANSFER_DATA, ALARM, COUNT_DOWN, STOP_WATCH, MUSIC, LOCK};
    }

    public static LiveCardType valueOf(String r2) {
        return (LiveCardType) ZeusTransformUtils.preCheckCast(Enum.valueOf(LiveCardType.class, r2), LiveCardType.class, "com.obric.aiagent.plugin");
    }

    public static LiveCardType[] values() {
        return (LiveCardType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LiveCardType[].class, "com.obric.aiagent.plugin");
    }

    private LiveCardType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        CALL = new LiveCardType("CALL", 0);
        ASSISTANT = new LiveCardType("ASSISTANT", 1);
        OAUTO = new LiveCardType("OAUTO", 2);
        MEMORY_DATA = new LiveCardType("MEMORY_DATA", 3);
        SCREEN_CAP = new LiveCardType("SCREEN_CAP", 4);
        BATTERY = new LiveCardType("BATTERY", 5);
        VIBRATE = new LiveCardType("VIBRATE", 6);
        RING_DOWN = new LiveCardType("RING_DOWN", 7);
        MUTE = new LiveCardType("MUTE", 8);
        AUTO_DISMISS = new LiveCardType("AUTO_DISMISS", 9);
        SOUND_RECORD = new LiveCardType("SOUND_RECORD", 10);
        TRANSFER_DATA = new LiveCardType("TRANSFER_DATA", 11);
        ALARM = new LiveCardType("ALARM", 12);
        COUNT_DOWN = new LiveCardType("COUNT_DOWN", 13);
        STOP_WATCH = new LiveCardType("STOP_WATCH", 14);
        MUSIC = new LiveCardType("MUSIC", 15);
        LOCK = new LiveCardType("LOCK", 16);
        $VALUES = $values();
        Companion = new Companion(null);
    }
}
