package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final enum CalendarTypeEnum extends Enum<CalendarTypeEnum> {
    private static final /* synthetic */ CalendarTypeEnum[] $VALUES = null;
    public static final CalendarTypeEnum CALENDAR = null;
    public static final a Companion = null;
    public static final CalendarTypeEnum TODO = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public final CalendarTypeEnum a(String r3) {
            CalendarTypeEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = CalendarTypeEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            a("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + aa.b(CalendarTypeEnum.class).b() + ' ');
        L9:
            return (CalendarTypeEnum) ZeusTransformUtils.preCheckCast(r2, CalendarTypeEnum.class, "com.obric.aiagent.plugin");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    private static final /* synthetic */ CalendarTypeEnum[] $values() {
        return new CalendarTypeEnum[]{CALENDAR, TODO};
    }

    static {
        CALENDAR = new CalendarTypeEnum("CALENDAR", 0);
        TODO = new CalendarTypeEnum("TODO", 1);
        $VALUES = $values();
        Companion = new a(null);
    }

    private CalendarTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static CalendarTypeEnum valueOf(String r2) {
        return (CalendarTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(CalendarTypeEnum.class, r2), CalendarTypeEnum.class, "com.obric.aiagent.plugin");
    }

    public static CalendarTypeEnum[] values() {
        return (CalendarTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CalendarTypeEnum[].class, "com.obric.aiagent.plugin");
    }
}
