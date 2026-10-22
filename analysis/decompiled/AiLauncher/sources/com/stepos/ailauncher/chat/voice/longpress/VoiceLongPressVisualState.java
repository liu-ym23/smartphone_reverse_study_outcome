package com.stepos.ailauncher.chat.voice.longpress;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/VoiceLongPressVisualState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ENTERING", "LISTENING", "RELEASE_GRACE", "FINALIZING", "EXITING", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceLongPressVisualState {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ VoiceLongPressVisualState[] $VALUES;
    public static final VoiceLongPressVisualState IDLE = new VoiceLongPressVisualState("IDLE", 0);
    public static final VoiceLongPressVisualState ENTERING = new VoiceLongPressVisualState("ENTERING", 1);
    public static final VoiceLongPressVisualState LISTENING = new VoiceLongPressVisualState("LISTENING", 2);
    public static final VoiceLongPressVisualState RELEASE_GRACE = new VoiceLongPressVisualState("RELEASE_GRACE", 3);
    public static final VoiceLongPressVisualState FINALIZING = new VoiceLongPressVisualState("FINALIZING", 4);
    public static final VoiceLongPressVisualState EXITING = new VoiceLongPressVisualState("EXITING", 5);

    private static final /* synthetic */ VoiceLongPressVisualState[] $values() {
        return new VoiceLongPressVisualState[]{IDLE, ENTERING, LISTENING, RELEASE_GRACE, FINALIZING, EXITING};
    }

    static {
        VoiceLongPressVisualState[] voiceLongPressVisualStateArr$values = $values();
        $VALUES = voiceLongPressVisualStateArr$values;
        $ENTRIES = kotlin.enums.a.a(voiceLongPressVisualStateArr$values);
    }

    private VoiceLongPressVisualState(String str, int i10) {
    }

    public static InterfaceC4149a<VoiceLongPressVisualState> getEntries() {
        return $ENTRIES;
    }

    public static VoiceLongPressVisualState valueOf(String str) {
        return (VoiceLongPressVisualState) Enum.valueOf(VoiceLongPressVisualState.class, str);
    }

    public static VoiceLongPressVisualState[] values() {
        return (VoiceLongPressVisualState[]) $VALUES.clone();
    }
}
