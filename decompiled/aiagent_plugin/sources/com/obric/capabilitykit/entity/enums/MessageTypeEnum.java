package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final enum MessageTypeEnum extends Enum<MessageTypeEnum> {
    private static final /* synthetic */ MessageTypeEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final MessageTypeEnum VERIFICATION_CODE = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public final MessageTypeEnum a(String r3) {
            MessageTypeEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = MessageTypeEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            a("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + aa.b(MessageTypeEnum.class).b() + ' ');
        L9:
            return (MessageTypeEnum) ZeusTransformUtils.preCheckCast(r2, MessageTypeEnum.class, "com.obric.aiagent.plugin");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    private static final /* synthetic */ MessageTypeEnum[] $values() {
        return new MessageTypeEnum[]{VERIFICATION_CODE};
    }

    static {
        VERIFICATION_CODE = new MessageTypeEnum("VERIFICATION_CODE", 0);
        $VALUES = $values();
        Companion = new a(null);
    }

    private MessageTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static MessageTypeEnum valueOf(String r2) {
        return (MessageTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(MessageTypeEnum.class, r2), MessageTypeEnum.class, "com.obric.aiagent.plugin");
    }

    public static MessageTypeEnum[] values() {
        return (MessageTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MessageTypeEnum[].class, "com.obric.aiagent.plugin");
    }
}
