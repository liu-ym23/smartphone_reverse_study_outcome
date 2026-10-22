package com.obric.capabilitykit.entity.enums;

import com.GlobalProxyLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "", "(Ljava/lang/String;I)V", "INCOMING_CALL_ANSWERED", "INCOMING_CALL_MISSED", "OUTGOING_CALL_ANSWERED", "OUTGOING_CALL_MISSED", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum CallTypeEnum extends Enum<CallTypeEnum> {
    private static final /* synthetic */ CallTypeEnum[] $VALUES = null;
    public static final Companion Companion = null;
    public static final CallTypeEnum INCOMING_CALL_ANSWERED = null;
    public static final CallTypeEnum INCOMING_CALL_MISSED = null;
    public static final CallTypeEnum OUTGOING_CALL_ANSWERED = null;
    public static final CallTypeEnum OUTGOING_CALL_MISSED = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/CallTypeEnum$Companion;", "", "()V", "from", "Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "name", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final CallTypeEnum from(String r3) {
            CallTypeEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = CallTypeEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + Reflection.getOrCreateKotlinClass(CallTypeEnum.class).getSimpleName() + ' ');
        L9:
            return r2;
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
        Companion = new Companion(null);
    }

    private CallTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static CallTypeEnum valueOf(String r1) {
        return (CallTypeEnum) Enum.valueOf(CallTypeEnum.class, r1);
    }

    public static CallTypeEnum[] values() {
        return (CallTypeEnum[]) $VALUES.clone();
    }
}
