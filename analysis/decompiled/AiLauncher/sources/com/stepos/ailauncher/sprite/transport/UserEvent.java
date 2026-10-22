package com.stepos.ailauncher.sprite.transport;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/sprite/transport/UserEvent;", "", "", "code", "<init>", "(Ljava/lang/String;II)V", "I", "getCode", "()I", "Companion", Const.INTENT_KEY_APIKEY, "CLICK", "LONG_PRESS", "sprite-transport-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UserEvent {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ UserEvent[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int code;
    public static final UserEvent CLICK = new UserEvent("CLICK", 0, 0);
    public static final UserEvent LONG_PRESS = new UserEvent("LONG_PRESS", 1, 1);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/sprite/transport/UserEvent$a;", "", "<init>", "()V", "", "code", "Lcom/stepos/ailauncher/sprite/transport/UserEvent;", Const.INTENT_KEY_APIKEY, "(I)Lcom/stepos/ailauncher/sprite/transport/UserEvent;", "sprite-transport-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sprite.transport.UserEvent$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final UserEvent a(int code) {
            for (UserEvent userEvent : UserEvent.values()) {
                if (userEvent.getCode() == code) {
                    return userEvent;
                }
            }
            return null;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ UserEvent[] $values() {
        return new UserEvent[]{CLICK, LONG_PRESS};
    }

    static {
        UserEvent[] userEventArr$values = $values();
        $VALUES = userEventArr$values;
        $ENTRIES = kotlin.enums.a.a(userEventArr$values);
        INSTANCE = new Companion(null);
    }

    private UserEvent(String str, int i10, int i11) {
        this.code = i11;
    }

    public static InterfaceC4149a<UserEvent> getEntries() {
        return $ENTRIES;
    }

    public static UserEvent valueOf(String str) {
        return (UserEvent) Enum.valueOf(UserEvent.class, str);
    }

    public static UserEvent[] values() {
        return (UserEvent[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
