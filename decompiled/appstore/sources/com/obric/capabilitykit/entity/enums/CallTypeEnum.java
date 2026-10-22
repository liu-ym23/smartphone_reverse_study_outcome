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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "INCOMING_CALL_ANSWERED", "INCOMING_CALL_MISSED", "OUTGOING_CALL_ANSWERED", "OUTGOING_CALL_MISSED", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum CallTypeEnum extends Enum<CallTypeEnum> {
    private static final /* synthetic */ CallTypeEnum[] $VALUES = null;

    @NotNull
    public static final a Companion = null;
    public static final CallTypeEnum INCOMING_CALL_ANSWERED = null;
    public static final CallTypeEnum INCOMING_CALL_MISSED = null;
    public static final CallTypeEnum OUTGOING_CALL_ANSWERED = null;
    public static final CallTypeEnum OUTGOING_CALL_MISSED = null;

    public static final class a {
        public a() {
        }

        public final CallTypeEnum a(String r10) {
            if (r10 == null) goto L11;
            return CallTypeEnum.valueOf(r10);
        L7:
            Log.w("EntityEnum", "failed to create enum from name " + r10 + " for enum type " + u.b(CallTypeEnum.class).getSimpleName() + TokenParser.SP);
            return null;
        L11:
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    private static final /* synthetic */ CallTypeEnum[] $values() {
        return new CallTypeEnum[]{INCOMING_CALL_ANSWERED, INCOMING_CALL_MISSED, OUTGOING_CALL_ANSWERED, OUTGOING_CALL_MISSED};
    }

    static {
        INCOMING_CALL_ANSWERED = new CallTypeEnum("INCOMING_CALL_ANSWERED", 0);
        INCOMING_CALL_MISSED = new CallTypeEnum("INCOMING_CALL_MISSED", 1);
        OUTGOING_CALL_ANSWERED = new CallTypeEnum("OUTGOING_CALL_ANSWERED", 2);
        OUTGOING_CALL_MISSED = new CallTypeEnum("OUTGOING_CALL_MISSED", 3);
        $VALUES = $values();
        Companion = new a(null);
    }

    private CallTypeEnum(String r10, int r11) {
        super(r10, r11);
    }

    public static CallTypeEnum valueOf(String r10) {
        return (CallTypeEnum) Enum.valueOf(CallTypeEnum.class, r10);
    }

    public static CallTypeEnum[] values() {
        return (CallTypeEnum[]) $VALUES.clone();
    }
}
