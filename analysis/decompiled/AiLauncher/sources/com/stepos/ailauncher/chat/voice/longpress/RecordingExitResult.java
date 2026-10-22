package com.stepos.ailauncher.chat.voice.longpress;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/RecordingExitResult;", "", "<init>", "(Ljava/lang/String;I)V", "COMPLETED", "INTERRUPTED", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RecordingExitResult {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ RecordingExitResult[] $VALUES;
    public static final RecordingExitResult COMPLETED = new RecordingExitResult("COMPLETED", 0);
    public static final RecordingExitResult INTERRUPTED = new RecordingExitResult("INTERRUPTED", 1);

    private static final /* synthetic */ RecordingExitResult[] $values() {
        return new RecordingExitResult[]{COMPLETED, INTERRUPTED};
    }

    static {
        RecordingExitResult[] recordingExitResultArr$values = $values();
        $VALUES = recordingExitResultArr$values;
        $ENTRIES = kotlin.enums.a.a(recordingExitResultArr$values);
    }

    private RecordingExitResult(String str, int i10) {
    }

    public static InterfaceC4149a<RecordingExitResult> getEntries() {
        return $ENTRIES;
    }

    public static RecordingExitResult valueOf(String str) {
        return (RecordingExitResult) Enum.valueOf(RecordingExitResult.class, str);
    }

    public static RecordingExitResult[] values() {
        return (RecordingExitResult[]) $VALUES.clone();
    }
}
