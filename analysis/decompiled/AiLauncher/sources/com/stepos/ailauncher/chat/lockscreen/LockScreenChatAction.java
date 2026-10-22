package com.stepos.ailauncher.chat.lockscreen;

import com.stepos.ailauncher.chat.api.SafetyDecision;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN_DRAWER", "OPEN_SESSION_LIST", SafetyDecision.NEW_CHAT, "CHANGE_SESSION", "SHOW_MORE_PANEL", "PICK_CAMERA", "PICK_CAMERA_FROM_MORE", "PICK_ALBUM", "PICK_FILE", "OPEN_TASK_DETAIL", "RESTORE_LAST_SESSION", "CIRCLE_SELECT", "ASK_SCREEN", "OPEN_ARTIFACTS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LockScreenChatAction {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ LockScreenChatAction[] $VALUES;
    public static final LockScreenChatAction OPEN_DRAWER = new LockScreenChatAction("OPEN_DRAWER", 0);
    public static final LockScreenChatAction OPEN_SESSION_LIST = new LockScreenChatAction("OPEN_SESSION_LIST", 1);
    public static final LockScreenChatAction NEW_CHAT = new LockScreenChatAction(SafetyDecision.NEW_CHAT, 2);
    public static final LockScreenChatAction CHANGE_SESSION = new LockScreenChatAction("CHANGE_SESSION", 3);
    public static final LockScreenChatAction SHOW_MORE_PANEL = new LockScreenChatAction("SHOW_MORE_PANEL", 4);
    public static final LockScreenChatAction PICK_CAMERA = new LockScreenChatAction("PICK_CAMERA", 5);
    public static final LockScreenChatAction PICK_CAMERA_FROM_MORE = new LockScreenChatAction("PICK_CAMERA_FROM_MORE", 6);
    public static final LockScreenChatAction PICK_ALBUM = new LockScreenChatAction("PICK_ALBUM", 7);
    public static final LockScreenChatAction PICK_FILE = new LockScreenChatAction("PICK_FILE", 8);
    public static final LockScreenChatAction OPEN_TASK_DETAIL = new LockScreenChatAction("OPEN_TASK_DETAIL", 9);
    public static final LockScreenChatAction RESTORE_LAST_SESSION = new LockScreenChatAction("RESTORE_LAST_SESSION", 10);
    public static final LockScreenChatAction CIRCLE_SELECT = new LockScreenChatAction("CIRCLE_SELECT", 11);
    public static final LockScreenChatAction ASK_SCREEN = new LockScreenChatAction("ASK_SCREEN", 12);
    public static final LockScreenChatAction OPEN_ARTIFACTS = new LockScreenChatAction("OPEN_ARTIFACTS", 13);

    private static final /* synthetic */ LockScreenChatAction[] $values() {
        return new LockScreenChatAction[]{OPEN_DRAWER, OPEN_SESSION_LIST, NEW_CHAT, CHANGE_SESSION, SHOW_MORE_PANEL, PICK_CAMERA, PICK_CAMERA_FROM_MORE, PICK_ALBUM, PICK_FILE, OPEN_TASK_DETAIL, RESTORE_LAST_SESSION, CIRCLE_SELECT, ASK_SCREEN, OPEN_ARTIFACTS};
    }

    static {
        LockScreenChatAction[] lockScreenChatActionArr$values = $values();
        $VALUES = lockScreenChatActionArr$values;
        $ENTRIES = kotlin.enums.a.a(lockScreenChatActionArr$values);
    }

    private LockScreenChatAction(String str, int i10) {
    }

    public static InterfaceC4149a<LockScreenChatAction> getEntries() {
        return $ENTRIES;
    }

    public static LockScreenChatAction valueOf(String str) {
        return (LockScreenChatAction) Enum.valueOf(LockScreenChatAction.class, str);
    }

    public static LockScreenChatAction[] values() {
        return (LockScreenChatAction[]) $VALUES.clone();
    }
}
