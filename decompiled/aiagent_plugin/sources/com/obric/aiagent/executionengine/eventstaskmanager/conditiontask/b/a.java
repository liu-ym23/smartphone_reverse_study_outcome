package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

/* JADX INFO: compiled from: CalendarUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "CalendarUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16880a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CalendarUtils.kt */
    public static final enum EnumC0344a extends Enum<EnumC0344a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0344a f16881a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0344a f16882b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0344a f16883c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC0344a f16884d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final EnumC0344a f16885e = null;
        private static final /* synthetic */ EnumC0344a[] g = null;
        private static final /* synthetic */ d.d.a h = null;
        private final boolean f;

        private static final /* synthetic */ EnumC0344a[] b() {
            return new EnumC0344a[]{f16881a, f16882b, f16883c, f16884d, f16885e};
        }

        private EnumC0344a(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.f = r3;
        }

        public final boolean a() {
            return this.f;
        }

        static {
            f16881a = new EnumC0344a("WEEKDAY", 0, false);
            f16882b = new EnumC0344a("WEEKEND", 1, true);
            f16883c = new EnumC0344a("HOLIDAY", 2, true);
            f16884d = new EnumC0344a("HOLIDAY_WORKDAY", 3, false);
            f16885e = new EnumC0344a("UNKNOWN", 4, false);
            EnumC0344a[] r0 = b();
            g = r0;
            h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static EnumC0344a valueOf(String r2) {
            return (EnumC0344a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0344a.class, r2), EnumC0344a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0344a[] values() {
            return (EnumC0344a[]) ZeusTransformUtils.preCheckCast(g.clone(), EnumC0344a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: CalendarUtils.kt */
    private static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f16886a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f16887b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f16888c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f16889d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f16890e = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f16886a, f16887b, f16888c};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f16886a = new b("HOLIDAY", 0);
            f16887b = new b("NORMAL", 1);
            f16888c = new b("WORKDAY", 2);
            b[] r0 = a();
            f16889d = r0;
            f16890e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f16889d.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f16880a = new a();
    }

    private a() {
    }

    private final b b(Context r2, LocalDate r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (com.obric.event.task.base.conditiontask.holiday.c.b(r1) == false) goto L5;
        com.obric.event.task.base.conditiontask.holiday.c.d r4 = com.obric.event.task.base.conditiontask.holiday.c.a(r1, r3);
        if (r4 == null) goto L13;
        if (r4.getType() != com.obric.event.task.base.conditiontask.holiday.c.a.f32701b) goto L15;
        return b.f16886a;
    L15:
        return b.f16888c;
    L13:
        return b.f16887b;
    L5:
        return b.f16887b;
    }

    private final b c(Context r3, LocalDate r4) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public final EnumC0344a a(Context r3, LocalDate r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "date");
    L29:
        e = move-exception;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getDayType error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return EnumC0344a.f16885e;
    L4:
        if (a(r4) == true) goto L6;
        boolean r0 = true;
    L7:
        b r2 = c(r5, r4);     // Catch: Exception -> L29
        if (r0 == true) goto L10;
    L12:
        if (r0 == false) goto L14;
    L16:
        if (r0 == true) goto L18;
    L20:
        if (r0 == true) goto L25;
        if (r2 != b.f16886a) goto L25;
        return EnumC0344a.f16883c;
    L25:
        if (r2 != b.f16888c) goto L28;
        return EnumC0344a.f16884d;
    L28:
        return EnumC0344a.f16885e;
    L18:
        if (r2 != b.f16886a) goto L20;
        return EnumC0344a.f16883c;
    L14:
        if (r2 != b.f16887b) goto L16;
        return EnumC0344a.f16882b;
    L10:
        if (r2 != b.f16887b) goto L12;
        return EnumC0344a.f16881a;
    L6:
        r0 = false;
        goto L7
    }

    public final LocalDate a(Context r3, LocalDateTime r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "dateTime");
        return a(r5, r4, true);
    }

    public final LocalDate b(Context r3, LocalDateTime r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "dateTime");
        return a(r5, r4, false);
    }

    private final LocalDate a(Context r8, LocalDateTime r9, boolean r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        LocalDate r12 = LocalDate.of(r9.toLocalDate().getYear(), r9.toLocalDate().getMonthValue(), r9.toLocalDate().getDayOfMonth());
        int r2 = 0;
    L4:
        if (r2 >= 30) goto L21;
        r2 = r2 + 1;
        o.a(r12);     // Catch: Exception -> L19
        b r3 = b(r11, r12);     // Catch: Exception -> L19
        if (r3 != b.f16886a) goto L9;
    L14:
        boolean r4 = true;
    L15:
        if (r10 == r4) goto L16;
        r12 = r12.plusDays(1);     // Catch: Exception -> L19
        goto L4
    L16:
        return r12;
    L9:
        if (r3 != b.f16887b) goto L13;
        o.a(r12);     // Catch: Exception -> L19
        if (a(r12) == true) goto L14;
    L13:
        r4 = false;
    L19:
        e = move-exception;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "findNextDay error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L21:
        return null;
    }

    private final boolean a(LocalDate r2) {
        if (r2.getDayOfWeek() != DayOfWeek.SATURDAY) goto L5;
    L8:
        return true;
    L5:
        if (r2.getDayOfWeek() == DayOfWeek.SUNDAY) goto L8;
        return false;
    }
}
