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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/MessageTypeEnum;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "VERIFICATION_CODE", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum MessageTypeEnum extends Enum<MessageTypeEnum> {
    private static final /* synthetic */ MessageTypeEnum[] $VALUES = null;

    @NotNull
    public static final a Companion = null;
    public static final MessageTypeEnum VERIFICATION_CODE = null;

    public static final class a {
        public a() {
        }

        public final MessageTypeEnum a(String r10) {
            if (r10 == null) goto L11;
            return MessageTypeEnum.valueOf(r10);
        L7:
            Log.w("EntityEnum", "failed to create enum from name " + r10 + " for enum type " + u.b(MessageTypeEnum.class).getSimpleName() + TokenParser.SP);
            return null;
        L11:
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
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

    private MessageTypeEnum(String r10, int r11) {
        super(r10, r11);
    }

    public static MessageTypeEnum valueOf(String r10) {
        return (MessageTypeEnum) Enum.valueOf(MessageTypeEnum.class, r10);
    }

    public static MessageTypeEnum[] values() {
        return (MessageTypeEnum[]) $VALUES.clone();
    }
}
