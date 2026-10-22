package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b;

import android.content.Context;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.g;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.o;
import d.l.n;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

/* JADX INFO: compiled from: TimeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final boolean a(TimeCondition r6, long r7) {
        o.e(r6, "timeCondition");
        DateTimeFormatter r0 = DateTimeFormatter.ofPattern("H:mm");
        LocalTime r1 = LocalTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r6.getStart(), CharSequence.class, "com.obric.aiagent.plugin"), r0);
        String r2 = r6.getEnd();
        if (r2 != null) goto L5;
        r2 = r6.getStart();
    L5:
        LocalTime r3 = LocalTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), r0);
        int r8 = r6.getInterval();
        LocalTime r9 = LocalTime.now().minusNanos(r7 * ((long) 1000000)).withSecond(0).withNano(0);
        if (r8 < 1800000) goto L18;
        if (o.a(r1, r3) == false) goto L18;
        if (r9.compareTo(r1) >= 0) goto L12;
        return false;
    L12:
        int r10 = r9.toSecondOfDay() - r1.toSecondOfDay();
        if (r10 >= 0) goto L15;
        return false;
    L15:
        if ((r10 % (r8 / 1000)) == 0) goto L30;
        return false;
    L30:
        return true;
    L18:
        if (o.a(r1, r3) == false) goto L21;
        return o.a(r9, r1);
    L21:
        if (r1.compareTo(r3) >= 0) goto L24;
        Comparable r11 = (Comparable) ZeusTransformUtils.preCheckCast(r1, Comparable.class, "com.obric.aiagent.plugin");
        o.a(r3);
        return n.a(r11, (Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.aiagent.plugin")).a((Comparable) ZeusTransformUtils.preCheckCast(r9, Comparable.class, "com.obric.aiagent.plugin"));
    L24:
        if (r1.compareTo(r3) > 0) goto L26;
        return false;
    L26:
        if (r9.compareTo(r1) >= 0) goto L30;
        if (r9.compareTo(r3) <= 0) goto L30;
        return false;
    }

    public static final boolean a(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        LocalDate r4 = LocalDate.parse((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return LocalDate.now().isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r4, ChronoLocalDate.class, "com.obric.aiagent.plugin"));
    }

    public static final boolean b(String r5) {
        if (r5 != null) goto L5;
    L20:
        return true;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L20;
        LocalDate r6 = LocalDate.parse((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));     // Catch: Exception -> L19
        LocalDate r3 = LocalDate.now();
        if (r3.isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r6, ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L15;
        return true;
    L15:
        if (r3.isEqual((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r6, ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    public static final boolean a(PeriodicPolicy r7) {
        o.e(r7, "policy");
        LocalDate r0 = LocalDate.now();
        String r1 = r7.getExpireDate();
        Boolean r3 = null;
        if (a(r1) == true) goto L7;
        r1 = null;
    L7:
        if (r1 == null) goto L9;
        return false;
    L9:
        String r2 = r7.getStartDate();
        if ((!b(r2)) == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L15;
        return false;
    L15:
        Boolean r4 = Boolean.valueOf(r7.isSingleTask());
        if (r4.booleanValue() == true) goto L19;
        r4 = null;
    L19:
        if (r4 == null) goto L22;
        r4.booleanValue();
        return true;
    L22:
        Boolean r5 = Boolean.valueOf(r7.getDaily());
        if (r5.booleanValue() == false) goto L25;
        r3 = r5;
    L25:
        if (r3 == null) goto L28;
        r3.booleanValue();
        return true;
    L28:
        int[] r6 = r7.getWeekly();
        if (r6 == null) goto L34;
        if (i.a(r6, r0.getDayOfWeek().getValue()) == false) goto L34;
        return true;
    L34:
        if (r7.getMonthly() != 0) goto L36;
    L38:
        String r8 = r7.getYearly();
        if (r8 == null) goto L46;
        MonthDay r9 = MonthDay.parse((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ofPattern("MM-dd"));     // Catch: Exception -> L61
        if (r0.getMonthValue() != r9.getMonthValue()) goto L46;
        if (r0.getDayOfMonth() != r9.getDayOfMonth()) goto L46;
        return true;
    L46:
        if (r7.getEveryOffDay() == false) goto L54;
        a r10 = a.f16880a;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r0);
        a.EnumC0344a r12 = r10.a(r11, r0);
        if (r12.a() == true) goto L50;
        return false;
    L50:
        if (r12 != a.EnumC0344a.f16885e) goto L52;
        return false;
    L52:
        return true;
    L54:
        if (r7.getEveryWorkDay() == false) goto L66;
        a r13 = a.f16880a;
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r0);
        a.EnumC0344a r15 = r13.a(r14, r0);
        if (r15.a() == false) goto L58;
        return false;
    L58:
        if (r15 != a.EnumC0344a.f16885e) goto L60;
        return false;
    L60:
        return true;
    L66:
        return false;
    L36:
        if (r0.getDayOfMonth() != r7.getMonthly()) goto L38;
        return true;
    }

    public static /* synthetic */ long a(TimeCondition r0, PeriodicPolicy r1, long r2, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r2 = 0;
    L6:
        return a(r0, r1, r2);
    }

    public static final long a(TimeCondition r1, PeriodicPolicy r2, long r3) {
        o.e(r1, "condition");
        o.e(r2, "policy");
        return g.f16734a.a(r1, r2, r3);
    }

    public static final long a() {
        return LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
