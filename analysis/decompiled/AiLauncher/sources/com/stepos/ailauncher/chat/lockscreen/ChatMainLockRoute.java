package com.stepos.ailauncher.chat.lockscreen;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/ChatMainLockRoute;", "", "<init>", "(Ljava/lang/String;I)V", "CONTINUE", "REDIRECT_TO_LOCK_SCREEN_CHAT", "LOCKED_FULL_CHAT", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatMainLockRoute {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ChatMainLockRoute[] $VALUES;
    public static final ChatMainLockRoute CONTINUE = new ChatMainLockRoute("CONTINUE", 0);
    public static final ChatMainLockRoute REDIRECT_TO_LOCK_SCREEN_CHAT = new ChatMainLockRoute("REDIRECT_TO_LOCK_SCREEN_CHAT", 1);
    public static final ChatMainLockRoute LOCKED_FULL_CHAT = new ChatMainLockRoute("LOCKED_FULL_CHAT", 2);

    private static final /* synthetic */ ChatMainLockRoute[] $values() {
        return new ChatMainLockRoute[]{CONTINUE, REDIRECT_TO_LOCK_SCREEN_CHAT, LOCKED_FULL_CHAT};
    }

    static {
        ChatMainLockRoute[] chatMainLockRouteArr$values = $values();
        $VALUES = chatMainLockRouteArr$values;
        $ENTRIES = kotlin.enums.a.a(chatMainLockRouteArr$values);
    }

    private ChatMainLockRoute(String str, int i10) {
    }

    public static InterfaceC4149a<ChatMainLockRoute> getEntries() {
        return $ENTRIES;
    }

    public static ChatMainLockRoute valueOf(String str) {
        return (ChatMainLockRoute) Enum.valueOf(ChatMainLockRoute.class, str);
    }

    public static ChatMainLockRoute[] values() {
        return (ChatMainLockRoute[]) $VALUES.clone();
    }
}
