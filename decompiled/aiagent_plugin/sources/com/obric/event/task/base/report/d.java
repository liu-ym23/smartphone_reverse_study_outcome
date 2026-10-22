package com.obric.event.task.base.report;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.eventkit.task.model.BatteryCondition;
import com.obric.eventkit.task.model.BluetoothCondition;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.SmsCondition;
import com.obric.eventkit.task.model.StorageCondition;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.WifiCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ConditionTaskLogUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f32758a = null;

    static {
        f32758a = new d();
    }

    private d() {
    }

    public final String a(ConditionTask r3) {
        d.h.b.o.e(r3, "<this>");
        return a((List) ZeusTransformUtils.preCheckCast(r3.getConditions().getConditions(), List.class, "com.obric.aiagent.plugin"));
    }

    public final String a(List<? extends Condition> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        TimeCondition r6 = null;
        if (r4 == null) goto L12;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Object r1 = r7.next();
        if (ZeusTransformUtils.instanceOf((Condition) ZeusTransformUtils.preCheckCast(r1, Condition.class, "com.obric.aiagent.plugin"), TimeCondition.class) == false) goto L6;
    L11:
        Condition r8 = (Condition) ZeusTransformUtils.preCheckCast(r1, Condition.class, "com.obric.aiagent.plugin");
    L14:
        if (ZeusTransformUtils.instanceOf(r8, TimeCondition.class) == false) goto L16;
        r6 = (TimeCondition) ZeusTransformUtils.preCheckCast(r8, TimeCondition.class, "com.obric.aiagent.plugin");
    L16:
        if (r6 != null) goto L19;
        return "not_set";
    L19:
        if (((TimeCondition) ZeusTransformUtils.preCheckCast(r8, TimeCondition.class, "com.obric.aiagent.plugin")).getEnd() == null) goto L24;
        if (((TimeCondition) ZeusTransformUtils.preCheckCast(r8, TimeCondition.class, "com.obric.aiagent.plugin")).getInterval() <= 0) goto L24;
        return "time_range_with_repeat";
    L24:
        if (((TimeCondition) ZeusTransformUtils.preCheckCast(r8, TimeCondition.class, "com.obric.aiagent.plugin")).getEnd() == null) goto L27;
        return "time_range";
    L27:
        if (((TimeCondition) ZeusTransformUtils.preCheckCast(r8, TimeCondition.class, "com.obric.aiagent.plugin")).getInterval() <= 0) goto L29;
        return "time_point_with_repeat";
    L29:
        return "time_point";
    L10:
        r1 = null;
        goto L11
    L12:
        r8 = null;
        goto L14
    }

    public final String b(ConditionTask r3) {
        d.h.b.o.e(r3, "<this>");
        return b((List) ZeusTransformUtils.preCheckCast(r3.getConditions().getConditions(), List.class, "com.obric.aiagent.plugin"));
    }

    public final String b(List<? extends Condition> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        LocationCondition r6 = null;
        if (r4 == null) goto L12;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Object r1 = r7.next();
        if (ZeusTransformUtils.instanceOf((Condition) ZeusTransformUtils.preCheckCast(r1, Condition.class, "com.obric.aiagent.plugin"), LocationCondition.class) == false) goto L6;
    L11:
        Condition r8 = (Condition) ZeusTransformUtils.preCheckCast(r1, Condition.class, "com.obric.aiagent.plugin");
    L14:
        if (ZeusTransformUtils.instanceOf(r8, LocationCondition.class) == false) goto L16;
        r6 = (LocationCondition) ZeusTransformUtils.preCheckCast(r8, LocationCondition.class, "com.obric.aiagent.plugin");
    L16:
        if (r6 != null) goto L19;
        return "not_set";
    L19:
        if (d.h.b.o.a(((LocationCondition) ZeusTransformUtils.preCheckCast(r8, LocationCondition.class, "com.obric.aiagent.plugin")).getType(), "inside") == false) goto L21;
        String r9 = "in_";
    L23:
        if (d.h.b.o.a(((LocationCondition) ZeusTransformUtils.preCheckCast(r8, LocationCondition.class, "com.obric.aiagent.plugin")).getMode(), "geo_radius") == false) goto L26;
        r9 = r9 + "geo";
    L26:
        if (d.h.b.o.a(((LocationCondition) ZeusTransformUtils.preCheckCast(r8, LocationCondition.class, "com.obric.aiagent.plugin")).getMode(), "place_alias") == false) goto L34;
        if (d.h.b.o.a(((LocationCondition) ZeusTransformUtils.preCheckCast(r8, LocationCondition.class, "com.obric.aiagent.plugin")).getAddrType(), "home") == false) goto L31;
        return r9 + "home";
    L31:
        if (d.h.b.o.a(((LocationCondition) ZeusTransformUtils.preCheckCast(r8, LocationCondition.class, "com.obric.aiagent.plugin")).getAddrType(), "company") == false) goto L34;
        return r9 + "company";
    L34:
        return r9;
    L21:
        r9 = "out_";
        goto L23
    L10:
        r1 = null;
        goto L11
    L12:
        r8 = null;
        goto L14
    }

    public final String c(ConditionTask r2) {
        d.h.b.o.e(r2, "<this>");
        return a(r2.getPeriodicPolicy());
    }

    public final String a(PeriodicPolicy r12) {
        if (r12 != null) goto L6;
        return "null";
    L6:
        if (r12.getDaily() == false) goto L9;
        return "daily";
    L9:
        int[] r11 = r12.getWeekly();
        String r0 = null;
        if (r11 == null) goto L23;
        if (r11.length != 0) goto L14;
        boolean r3 = true;
    L16:
        if ((!r3) == true) goto L19;
        r11 = null;
    L19:
        if (r11 == null) goto L23;
        return "weekly_" + d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.i.c(r11), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("_", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L14:
        r3 = false;
    L23:
        if (r12.getMonthly() > 0) goto L25;
        String r13 = r12.getYearly();
        if (r13 == null) goto L35;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L31;
        r0 = r13;
    L31:
        if (r0 == null) goto L35;
        return "yearly_" + r0;
    L35:
        if (r12.getEveryWorkDay() == false) goto L39;
        return "everyWorkDay";
    L39:
        if (r12.getEveryOffDay() == false) goto L42;
        return "everyOffDay";
    L42:
        return "not_set";
    L25:
        return "monthly_" + r12.getMonthly();
    }

    public final String c(List<? extends Condition> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        SmsCondition r6 = null;
        if (r4 == null) goto L12;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Object r1 = r7.next();
        if (ZeusTransformUtils.instanceOf((Condition) ZeusTransformUtils.preCheckCast(r1, Condition.class, "com.obric.aiagent.plugin"), SmsCondition.class) == false) goto L6;
    L11:
        Condition r8 = (Condition) ZeusTransformUtils.preCheckCast(r1, Condition.class, "com.obric.aiagent.plugin");
    L13:
        if (r8 != null) goto L17;
        return "not_set";
    L17:
        if (ZeusTransformUtils.instanceOf(r8, SmsCondition.class) == false) goto L19;
        r6 = (SmsCondition) ZeusTransformUtils.preCheckCast(r8, SmsCondition.class, "com.obric.aiagent.plugin");
    L19:
        if (r6 == null) goto L22;
        String r9 = r6.getCategoryType();
        if (r9 == null) goto L22;
        return r9;
    L22:
        return WsConstants.KEY_CONNECTION_ERROR;
    L10:
        r1 = null;
        goto L11
    L12:
        r8 = null;
        goto L13
    }

    public final String d(List<? extends Condition> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        BatteryCondition r6 = null;
        if (r4 == null) goto L12;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Object r1 = r7.next();
        if (ZeusTransformUtils.instanceOf((Condition) ZeusTransformUtils.preCheckCast(r1, Condition.class, "com.obric.aiagent.plugin"), BatteryCondition.class) == false) goto L6;
    L11:
        Condition r8 = (Condition) ZeusTransformUtils.preCheckCast(r1, Condition.class, "com.obric.aiagent.plugin");
    L13:
        if (r8 != null) goto L17;
        return "not_set";
    L17:
        if (ZeusTransformUtils.instanceOf(r8, BatteryCondition.class) == false) goto L19;
        r6 = (BatteryCondition) ZeusTransformUtils.preCheckCast(r8, BatteryCondition.class, "com.obric.aiagent.plugin");
    L19:
        if (r6 == null) goto L22;
        String r9 = Boolean.valueOf(r6.isCharging()).toString();
        if (r9 == null) goto L22;
        return r9;
    L22:
        return WsConstants.KEY_CONNECTION_ERROR;
    L10:
        r1 = null;
        goto L11
    L12:
        r8 = null;
        goto L13
    }

    public final String e(List<? extends Condition> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Object r6 = null;
        if (r4 == null) goto L11;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Object r1 = r7.next();
        if (ZeusTransformUtils.instanceOf((Condition) ZeusTransformUtils.preCheckCast(r1, Condition.class, "com.obric.aiagent.plugin"), WifiCondition.class) == false) goto L6;
        r6 = r1;
    L10:
        r6 = (Condition) ZeusTransformUtils.preCheckCast(r6, Condition.class, "com.obric.aiagent.plugin");
    L11:
        if (r6 != null) goto L15;
        return "not_set";
    L15:
        if (ZeusTransformUtils.instanceOf(r6, WifiCondition.class) == false) goto L17;
        return "1";
    L17:
        return "0";
    }

    public final String f(List<? extends Condition> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Object r6 = null;
        if (r4 == null) goto L11;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Object r1 = r7.next();
        if (ZeusTransformUtils.instanceOf((Condition) ZeusTransformUtils.preCheckCast(r1, Condition.class, "com.obric.aiagent.plugin"), BluetoothCondition.class) == false) goto L6;
        r6 = r1;
    L10:
        r6 = (Condition) ZeusTransformUtils.preCheckCast(r6, Condition.class, "com.obric.aiagent.plugin");
    L11:
        if (r6 != null) goto L15;
        return "not_set";
    L15:
        if (ZeusTransformUtils.instanceOf(r6, BluetoothCondition.class) == false) goto L17;
        return "1";
    L17:
        return "0";
    }

    public final String g(List<? extends Condition> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Object r6 = null;
        if (r4 == null) goto L11;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Object r1 = r7.next();
        if (ZeusTransformUtils.instanceOf((Condition) ZeusTransformUtils.preCheckCast(r1, Condition.class, "com.obric.aiagent.plugin"), StorageCondition.class) == false) goto L6;
        r6 = r1;
    L10:
        r6 = (Condition) ZeusTransformUtils.preCheckCast(r6, Condition.class, "com.obric.aiagent.plugin");
    L11:
        if (r6 != null) goto L15;
        return "not_set";
    L15:
        if (ZeusTransformUtils.instanceOf(r6, StorageCondition.class) == false) goto L17;
        return "1";
    L17:
        return "0";
    }
}
