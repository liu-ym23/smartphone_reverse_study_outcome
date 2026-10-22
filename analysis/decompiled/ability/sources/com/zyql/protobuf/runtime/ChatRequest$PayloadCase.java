package com.zyql.protobuf.runtime;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ChatRequest$PayloadCase {

    /* renamed from: a, reason: collision with root package name */
    public static final ChatRequest$PayloadCase f4274a;
    public static final ChatRequest$PayloadCase b;
    public static final ChatRequest$PayloadCase c;
    public static final ChatRequest$PayloadCase d;
    public static final /* synthetic */ ChatRequest$PayloadCase[] e;

    static {
        ChatRequest$PayloadCase chatRequest$PayloadCase = new ChatRequest$PayloadCase("START_AGENT_REQUEST", 0);
        f4274a = chatRequest$PayloadCase;
        ChatRequest$PayloadCase chatRequest$PayloadCase2 = new ChatRequest$PayloadCase("SEND_INPUT_REQUEST", 1);
        b = chatRequest$PayloadCase2;
        ChatRequest$PayloadCase chatRequest$PayloadCase3 = new ChatRequest$PayloadCase("CANCEL_REQUEST", 2);
        c = chatRequest$PayloadCase3;
        ChatRequest$PayloadCase chatRequest$PayloadCase4 = new ChatRequest$PayloadCase("PAYLOAD_NOT_SET", 3);
        d = chatRequest$PayloadCase4;
        e = new ChatRequest$PayloadCase[]{chatRequest$PayloadCase, chatRequest$PayloadCase2, chatRequest$PayloadCase3, chatRequest$PayloadCase4};
    }

    public static ChatRequest$PayloadCase valueOf(String str) {
        return (ChatRequest$PayloadCase) Enum.valueOf(ChatRequest$PayloadCase.class, str);
    }

    public static ChatRequest$PayloadCase[] values() {
        return (ChatRequest$PayloadCase[]) e.clone();
    }
}
