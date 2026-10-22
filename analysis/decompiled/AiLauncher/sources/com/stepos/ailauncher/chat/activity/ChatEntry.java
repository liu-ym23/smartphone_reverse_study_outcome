package com.stepos.ailauncher.chat.activity;

import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.fragment.AmooStoreFragment;
import com.stepos.core.ability.AbilityType;
import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/ChatEntry;", "", "", "wireValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getWireValue", "()Ljava/lang/String;", "Companion", Const.INTENT_KEY_APIKEY, "SESSION_CENTER", "CHAT", "SHEET_DEMO", "AMOO_STORE", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatEntry {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ChatEntry[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String wireValue;
    public static final ChatEntry SESSION_CENTER = new ChatEntry("SESSION_CENTER", 0, "session_center");
    public static final ChatEntry CHAT = new ChatEntry("CHAT", 1, AbilityType.CHAT);
    public static final ChatEntry SHEET_DEMO = new ChatEntry("SHEET_DEMO", 2, "sheet_demo");
    public static final ChatEntry AMOO_STORE = new ChatEntry("AMOO_STORE", 3, AmooStoreFragment.TAG);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/ChatEntry$a;", "", "<init>", "()V", "", "wire", "Lcom/stepos/ailauncher/chat/activity/ChatEntry;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/ailauncher/chat/activity/ChatEntry;", "Landroid/content/Intent;", "intent", Const.INTENT_KEY_APIKEY, "(Landroid/content/Intent;)Lcom/stepos/ailauncher/chat/activity/ChatEntry;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.activity.ChatEntry$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ChatEntry a(Intent intent) {
            return b(intent != null ? intent.getStringExtra("com.stepos.ailauncher.chat.sheet.ENTRY") : null);
        }

        public final ChatEntry b(String wire) {
            ChatEntry next;
            Iterator<ChatEntry> it = ChatEntry.getEntries().iterator();
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
            ChatEntry chatEntry = next;
            return chatEntry == null ? ChatEntry.SESSION_CENTER : chatEntry;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ ChatEntry[] $values() {
        return new ChatEntry[]{SESSION_CENTER, CHAT, SHEET_DEMO, AMOO_STORE};
    }

    static {
        ChatEntry[] chatEntryArr$values = $values();
        $VALUES = chatEntryArr$values;
        $ENTRIES = kotlin.enums.a.a(chatEntryArr$values);
        INSTANCE = new Companion(null);
    }

    private ChatEntry(String str, int i10, String str2) {
        this.wireValue = str2;
    }

    public static InterfaceC4149a<ChatEntry> getEntries() {
        return $ENTRIES;
    }

    public static ChatEntry valueOf(String str) {
        return (ChatEntry) Enum.valueOf(ChatEntry.class, str);
    }

    public static ChatEntry[] values() {
        return (ChatEntry[]) $VALUES.clone();
    }

    public final String getWireValue() {
        return this.wireValue;
    }
}
