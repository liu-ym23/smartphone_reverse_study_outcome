package com.stepos.motionkit;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/motionkit/PlayMode;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "LOOP", "ONCE", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlayMode {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ PlayMode[] $VALUES;
    public static final PlayMode LOOP = new PlayMode("LOOP", 0);
    public static final PlayMode ONCE = new PlayMode("ONCE", 1);

    private static final /* synthetic */ PlayMode[] $values() {
        return new PlayMode[]{LOOP, ONCE};
    }

    static {
        PlayMode[] playModeArr$values = $values();
        $VALUES = playModeArr$values;
        $ENTRIES = kotlin.enums.a.a(playModeArr$values);
    }

    private PlayMode(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static PlayMode valueOf(String str) {
        return (PlayMode) Enum.valueOf(PlayMode.class, str);
    }

    public static PlayMode[] values() {
        return (PlayMode[]) $VALUES.clone();
    }
}
