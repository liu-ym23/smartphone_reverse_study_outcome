package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final enum MessageStatusTypeEnum extends Enum<MessageStatusTypeEnum> {
    private static final /* synthetic */ MessageStatusTypeEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final MessageStatusTypeEnum DRAFT = null;
    public static final MessageStatusTypeEnum INBOX = null;
    public static final MessageStatusTypeEnum OUTBOX = null;
    public static final MessageStatusTypeEnum SENDING = null;
    public static final MessageStatusTypeEnum SEND_FAILED = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public final MessageStatusTypeEnum a(String r3) {
            MessageStatusTypeEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = MessageStatusTypeEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            a("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + aa.b(MessageStatusTypeEnum.class).b() + ' ');
        L9:
            return (MessageStatusTypeEnum) ZeusTransformUtils.preCheckCast(r2, MessageStatusTypeEnum.class, "com.obric.aiagent.plugin");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
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

    private MessageStatusTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static MessageStatusTypeEnum valueOf(String r2) {
        return (MessageStatusTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(MessageStatusTypeEnum.class, r2), MessageStatusTypeEnum.class, "com.obric.aiagent.plugin");
    }

    public static MessageStatusTypeEnum[] values() {
        return (MessageStatusTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MessageStatusTypeEnum[].class, "com.obric.aiagent.plugin");
    }
}
