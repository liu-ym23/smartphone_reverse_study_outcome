package com.stepos.common;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/common/ChatContentType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "IMAGE", "AUDIO", "VIDEO", "FILE", "AUDIO_STREAM", "BYTES", "FOLDER", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatContentType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ChatContentType[] $VALUES;
    public static final ChatContentType TEXT = new ChatContentType("TEXT", 0);
    public static final ChatContentType IMAGE = new ChatContentType("IMAGE", 1);
    public static final ChatContentType AUDIO = new ChatContentType("AUDIO", 2);
    public static final ChatContentType VIDEO = new ChatContentType("VIDEO", 3);
    public static final ChatContentType FILE = new ChatContentType("FILE", 4);
    public static final ChatContentType AUDIO_STREAM = new ChatContentType("AUDIO_STREAM", 5);
    public static final ChatContentType BYTES = new ChatContentType("BYTES", 6);
    public static final ChatContentType FOLDER = new ChatContentType("FOLDER", 7);

    private static final /* synthetic */ ChatContentType[] $values() {
        return new ChatContentType[]{TEXT, IMAGE, AUDIO, VIDEO, FILE, AUDIO_STREAM, BYTES, FOLDER};
    }

    static {
        ChatContentType[] chatContentTypeArr$values = $values();
        $VALUES = chatContentTypeArr$values;
        $ENTRIES = a.a(chatContentTypeArr$values);
    }

    private ChatContentType(String str, int i10) {
    }

    public static InterfaceC4149a<ChatContentType> getEntries() {
        return $ENTRIES;
    }

    public static ChatContentType valueOf(String str) {
        return (ChatContentType) Enum.valueOf(ChatContentType.class, str);
    }

    public static ChatContentType[] values() {
        return (ChatContentType[]) $VALUES.clone();
    }
}
