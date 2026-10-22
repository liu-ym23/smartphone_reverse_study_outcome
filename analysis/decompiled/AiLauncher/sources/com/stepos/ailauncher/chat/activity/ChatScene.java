package com.stepos.ailauncher.chat.activity;

import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8F¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000bj\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/ChatScene;", "", "", "wireValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getWireValue", "()Ljava/lang/String;", "", "isStandaloneTask", "()Z", "isStandaloneTask$annotations", "()V", "isHomeOverlay", "isHomeFollowing", "isLockScreen", "Companion", Const.INTENT_KEY_APIKEY, "DESKTOP", "HOME_OVERLAY", "HOME_RESIDENT", "BOARD", "TRANSIENT", "LOCK_SCREEN", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatScene {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ChatScene[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String wireValue;
    public static final ChatScene DESKTOP = new ChatScene("DESKTOP", 0, "desktop");
    public static final ChatScene HOME_OVERLAY = new ChatScene("HOME_OVERLAY", 1, "home_overlay");
    public static final ChatScene HOME_RESIDENT = new ChatScene("HOME_RESIDENT", 2, "home_resident");
    public static final ChatScene BOARD = new ChatScene("BOARD", 3, "board");
    public static final ChatScene TRANSIENT = new ChatScene("TRANSIENT", 4, "transient");
    public static final ChatScene LOCK_SCREEN = new ChatScene("LOCK_SCREEN", 5, com.stepos.ailauncher.chat.trace.h.STATE_LOCK_SCREEN);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/ChatScene$a;", "", "<init>", "()V", "", "wire", "Lcom/stepos/ailauncher/chat/activity/ChatScene;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/ailauncher/chat/activity/ChatScene;", "Landroid/content/Intent;", "intent", Const.INTENT_KEY_APIKEY, "(Landroid/content/Intent;)Lcom/stepos/ailauncher/chat/activity/ChatScene;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.activity.ChatScene$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ChatScene a(Intent intent) {
            return b(intent != null ? intent.getStringExtra("com.stepos.ailauncher.chat.sheet.SCENE") : null);
        }

        public final ChatScene b(String wire) {
            ChatScene next;
            Iterator<ChatScene> it = ChatScene.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (kotlin.jvm.internal.p.d(next.getWireValue(), wire)) {
                    break;
                }
            }
            ChatScene chatScene = next;
            return chatScene == null ? ChatScene.DESKTOP : chatScene;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ ChatScene[] $values() {
        return new ChatScene[]{DESKTOP, HOME_OVERLAY, HOME_RESIDENT, BOARD, TRANSIENT, LOCK_SCREEN};
    }

    static {
        ChatScene[] chatSceneArr$values = $values();
        $VALUES = chatSceneArr$values;
        $ENTRIES = kotlin.enums.a.a(chatSceneArr$values);
        INSTANCE = new Companion(null);
    }

    private ChatScene(String str, int i10, String str2) {
        this.wireValue = str2;
    }

    public static InterfaceC4149a<ChatScene> getEntries() {
        return $ENTRIES;
    }

    public static /* synthetic */ void isStandaloneTask$annotations() {
    }

    public static ChatScene valueOf(String str) {
        return (ChatScene) Enum.valueOf(ChatScene.class, str);
    }

    public static ChatScene[] values() {
        return (ChatScene[]) $VALUES.clone();
    }

    public final String getWireValue() {
        return this.wireValue;
    }

    public final boolean isHomeFollowing() {
        return this == HOME_OVERLAY || this == HOME_RESIDENT;
    }

    public final boolean isHomeOverlay() {
        return this == HOME_OVERLAY;
    }

    public final boolean isLockScreen() {
        return this == LOCK_SCREEN;
    }

    public final boolean isStandaloneTask() {
        return this == BOARD || this == TRANSIENT || this == LOCK_SCREEN;
    }
}
