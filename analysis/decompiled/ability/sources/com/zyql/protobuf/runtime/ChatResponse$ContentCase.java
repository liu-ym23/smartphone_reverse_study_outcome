package com.zyql.protobuf.runtime;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ChatResponse$ContentCase {

    /* renamed from: a, reason: collision with root package name */
    public static final ChatResponse$ContentCase f4275a;
    public static final ChatResponse$ContentCase b;
    public static final ChatResponse$ContentCase c;
    public static final /* synthetic */ ChatResponse$ContentCase[] d;

    static {
        ChatResponse$ContentCase chatResponse$ContentCase = new ChatResponse$ContentCase("ACK", 0);
        f4275a = chatResponse$ContentCase;
        ChatResponse$ContentCase chatResponse$ContentCase2 = new ChatResponse$ContentCase("TASK", 1);
        b = chatResponse$ContentCase2;
        ChatResponse$ContentCase chatResponse$ContentCase3 = new ChatResponse$ContentCase("CONTENT_NOT_SET", 2);
        c = chatResponse$ContentCase3;
        d = new ChatResponse$ContentCase[]{chatResponse$ContentCase, chatResponse$ContentCase2, chatResponse$ContentCase3};
    }

    public static ChatResponse$ContentCase valueOf(String str) {
        return (ChatResponse$ContentCase) Enum.valueOf(ChatResponse$ContentCase.class, str);
    }

    public static ChatResponse$ContentCase[] values() {
        return (ChatResponse$ContentCase[]) d.clone();
    }
}
