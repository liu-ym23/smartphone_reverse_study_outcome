package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.u;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "INBOX", "OUTBOX", "DRAFT", "SENDING", "SEND_FAILED", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum MessageStatusTypeEnum extends Enum<MessageStatusTypeEnum> {
    private static final /* synthetic */ MessageStatusTypeEnum[] $VALUES = null;

    @NotNull
    public static final a Companion = null;
    public static final MessageStatusTypeEnum DRAFT = null;
    public static final MessageStatusTypeEnum INBOX = null;
    public static final MessageStatusTypeEnum OUTBOX = null;
    public static final MessageStatusTypeEnum SENDING = null;
    public static final MessageStatusTypeEnum SEND_FAILED = null;

    public static final class a {
        public a() {
        }

        public final MessageStatusTypeEnum a(String r10) {
            if (r10 == null) goto L11;
            return MessageStatusTypeEnum.valueOf(r10);
        L7:
            Log.w("EntityEnum", "failed to create enum from name " + r10 + " for enum type " + u.b(MessageStatusTypeEnum.class).getSimpleName() + TokenParser.SP);
            return null;
        L11:
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    private static final /* synthetic */ MessageStatusTypeEnum[] $values() {
        return new MessageStatusTypeEnum[]{INBOX, OUTBOX, DRAFT, SENDING, SEND_FAILED};
    }

    static {
        INBOX = new MessageStatusTypeEnum("INBOX", 0);
        OUTBOX = new MessageStatusTypeEnum("OUTBOX", 1);
        DRAFT = new MessageStatusTypeEnum("DRAFT", 2);
        SENDING = new MessageStatusTypeEnum("SENDING", 3);
        SEND_FAILED = new MessageStatusTypeEnum("SEND_FAILED", 4);
        $VALUES = $values();
        Companion = new a(null);
    }

    private MessageStatusTypeEnum(String r10, int r11) {
        super(r10, r11);
    }

    public static MessageStatusTypeEnum valueOf(String r10) {
        return (MessageStatusTypeEnum) Enum.valueOf(MessageStatusTypeEnum.class, r10);
    }

    public static MessageStatusTypeEnum[] values() {
        return (MessageStatusTypeEnum[]) $VALUES.clone();
    }
}
