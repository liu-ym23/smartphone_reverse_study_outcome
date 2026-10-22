package com.obric.capabilitykit.entity.enums;

import com.GlobalProxyLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;", "", "(Ljava/lang/String;I)V", "CALENDAR", "TODO", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum CalendarTypeEnum extends Enum<CalendarTypeEnum> {
    private static final /* synthetic */ CalendarTypeEnum[] $VALUES = null;
    public static final CalendarTypeEnum CALENDAR = null;
    public static final Companion Companion = null;
    public static final CalendarTypeEnum TODO = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum$Companion;", "", "()V", "from", "Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;", "name", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final CalendarTypeEnum from(String r3) {
            CalendarTypeEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = CalendarTypeEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + Reflection.getOrCreateKotlinClass(CalendarTypeEnum.class).getSimpleName() + ' ');
        L9:
            return r2;
        }
    }

    private static final /* synthetic */ CalendarTypeEnum[] $values() {
        return new CalendarTypeEnum[]{CALENDAR, TODO};
    }

    static {
        CALENDAR = new CalendarTypeEnum("CALENDAR", 0);
        TODO = new CalendarTypeEnum("TODO", 1);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private CalendarTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static CalendarTypeEnum valueOf(String r1) {
        return (CalendarTypeEnum) Enum.valueOf(CalendarTypeEnum.class, r1);
    }

    public static CalendarTypeEnum[] values() {
        return (CalendarTypeEnum[]) $VALUES.clone();
    }
}
