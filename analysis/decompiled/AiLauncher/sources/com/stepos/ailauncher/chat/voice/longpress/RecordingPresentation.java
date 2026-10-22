package com.stepos.ailauncher.chat.voice.longpress;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/RecordingPresentation;", "", "<init>", "(Ljava/lang/String;I)V", "INPUT_BAR", "FULL_SCREEN", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RecordingPresentation {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ RecordingPresentation[] $VALUES;
    public static final RecordingPresentation INPUT_BAR = new RecordingPresentation("INPUT_BAR", 0);
    public static final RecordingPresentation FULL_SCREEN = new RecordingPresentation("FULL_SCREEN", 1);

    private static final /* synthetic */ RecordingPresentation[] $values() {
        return new RecordingPresentation[]{INPUT_BAR, FULL_SCREEN};
    }

    static {
        RecordingPresentation[] recordingPresentationArr$values = $values();
        $VALUES = recordingPresentationArr$values;
        $ENTRIES = kotlin.enums.a.a(recordingPresentationArr$values);
    }

    private RecordingPresentation(String str, int i10) {
    }

    public static InterfaceC4149a<RecordingPresentation> getEntries() {
        return $ENTRIES;
    }

    public static RecordingPresentation valueOf(String str) {
        return (RecordingPresentation) Enum.valueOf(RecordingPresentation.class, str);
    }

    public static RecordingPresentation[] values() {
        return (RecordingPresentation[]) $VALUES.clone();
    }
}
