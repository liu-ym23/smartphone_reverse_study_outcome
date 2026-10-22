package com.obric.autoaction.app.launcherpage.condition.a;

import android.content.Context;
import android.text.Spanned;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ChargingBatteryCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ConnectBluetoothCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ConnectWifiCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.DayTimeCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.DayTimeRangeCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.DayTimeRepeatCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.EnterLocationCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ExitLocationCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.GroupInfo;
import com.obric.autoaction.app.launcherpage.condition.config.condition.LowStorageCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.NoChargeBatteryCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ReceiveSmsCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ui.RoundBackgroundSpan;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.eventkit.task.model.BatteryCondition;
import com.obric.eventkit.task.model.BluetoothCondition;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.SmsCondition;
import com.obric.eventkit.task.model.StorageCondition;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.WifiCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.a.m;
import d.h.b.o;
import d.l.n;
import d.o.k;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ConditionUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final k f22920a = null;

    public static final int a(int r0, int r1) {
        return (((r0 * 60) + r1) * 1000) * 60;
    }

    /* JADX INFO: renamed from: lambda$AKTJOdLd0YB--sa7or4nxZ3VGXw, reason: not valid java name */
    public static /* synthetic */ CharSequence m445lambda$AKTJOdLd0YBsa7or4nxZ3VGXw(Context r0, AutoCondition r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$MOP1UXGHipWQ377igk2KGGE9gco(ArrayList r0, GroupInfo r1, List r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$dMuoEyoQwc1B-qxlCS8l1P--L0A, reason: not valid java name */
    public static /* synthetic */ void m446lambda$dMuoEyoQwc1BqxlCS8l1PL0A(m r0, Object r1, Object r2) {
        a(r0, r1, r2);
    }

    public static final ConditionGroup a(List<? extends AutoCondition> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "<this>");
        final ArrayList r0 = new ArrayList();
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r3 = r10.next();
        GroupInfo r4 = ((AutoCondition) ZeusTransformUtils.preCheckCast(r3, AutoCondition.class, "com.obric.aiagent.plugin")).getGroupInfo();
        Object r5 = r2.get(r4);
        if (r5 != null) goto L8;
        r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r2.put(r4, r5);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin")).add(r3);
        goto L4
    L9:
        final m r11 = new $$Lambda$a$MOP1UXGHipWQ377igk2KGGE9gco(r0);
        r2.forEach(new $$Lambda$a$dMuoEyoQwc1BqxlCS8l1PL0A(r11));
        return new ConditionGroup("and", r0);
    }

    private static final void a(m r2, Object r3, Object r4) {
        ((m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin")).invoke(r3, r4);
    }

    private static final x a(ArrayList r3, GroupInfo r4, List r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<unused var>");
        o.e(r6, "autoConditions");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r0 = r7.next();
        if (((AutoCondition) ZeusTransformUtils.preCheckCast(r0, AutoCondition.class, "com.obric.aiagent.plugin")).isPrimary() == false) goto L4;
    L9:
        AutoCondition r8 = (AutoCondition) ZeusTransformUtils.preCheckCast(r0, AutoCondition.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L12;
        Condition r9 = r8.buildCondition();
        if (r9 == null) goto L16;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L19:
        if (r10.hasNext() == false) goto L26;
        AutoCondition r1 = (AutoCondition) ZeusTransformUtils.preCheckCast(r10.next(), AutoCondition.class, "com.obric.aiagent.plugin");
        if (r1.isPrimary() == true) goto L19;
        Condition r2 = r1.configCondition(r9);
        if (r2 == null) goto L19;
        r9 = r2;
        goto L19
    L26:
        r3.add(r9);
        return x.f38692a;
    L16:
        return x.f38692a;
    L12:
        return x.f38692a;
    L8:
        r0 = null;
        goto L9
    }

    private static final List<AutoCondition> a(Condition r9) {
        Condition r10 = (Condition) ZeusTransformUtils.wrapperContextForParams(r9, Condition.class, "com.obric.aiagent.plugin");
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, TimeCondition.class) == false) goto L10;
        DayTimeRepeatCondition r2 = new DayTimeRepeatCondition(((TimeCondition) ZeusTransformUtils.preCheckCast(r10, TimeCondition.class, "com.obric.aiagent.plugin")).getInterval());
        if (r2.getInterval() < 1800000) goto L7;
        boolean r5 = true;
    L8:
        r2.setActive(r5);
        r0.add(r2);
        goto L10
    L7:
        r5 = false;
    L10:
        if (ZeusTransformUtils.instanceOf(r10, LocationCondition.class) == false) goto L25;
        int r6 = 3;
        if (o.a(((LocationCondition) ZeusTransformUtils.preCheckCast(r10, LocationCondition.class, "com.obric.aiagent.plugin")).getMode(), "place_alias") == false) goto L20;
        if (o.a(((LocationCondition) ZeusTransformUtils.preCheckCast(r10, LocationCondition.class, "com.obric.aiagent.plugin")).getAddrType(), "home") == false) goto L17;
        r6 = 0;
        goto L20
    L17:
        if (o.a(((LocationCondition) ZeusTransformUtils.preCheckCast(r10, LocationCondition.class, "com.obric.aiagent.plugin")).getAddrType(), "company") == false) goto L20;
        r6 = 1;
    L20:
        if (o.a(((LocationCondition) ZeusTransformUtils.preCheckCast(r10, LocationCondition.class, "com.obric.aiagent.plugin")).getType(), "inside") == false) goto L22;
        AutoCondition r8 = new EnterLocationCondition(((LocationCondition) ZeusTransformUtils.preCheckCast(r10, LocationCondition.class, "com.obric.aiagent.plugin")).getAddrName(), Integer.valueOf(r6), ((LocationCondition) ZeusTransformUtils.preCheckCast(r10, LocationCondition.class, "com.obric.aiagent.plugin")).getLongitude(), ((LocationCondition) ZeusTransformUtils.preCheckCast(r10, LocationCondition.class, "com.obric.aiagent.plugin")).getLatitude());
        r8.setActive(true);
    L23:
        AutoCondition r11 = (AutoCondition) ZeusTransformUtils.preCheckCast(r8, AutoCondition.class, "com.obric.aiagent.plugin");
    L55:
        if (r11 != null) goto L57;
        return null;
    L57:
        List<AutoCondition> r12 = p.c(new AutoCondition[]{r11});
        r12.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"));
        return r12;
    L22:
        r8 = new ExitLocationCondition(((LocationCondition) ZeusTransformUtils.preCheckCast(r10, LocationCondition.class, "com.obric.aiagent.plugin")).getAddrName(), Integer.valueOf(r6), ((LocationCondition) ZeusTransformUtils.preCheckCast(r10, LocationCondition.class, "com.obric.aiagent.plugin")).getLongitude(), ((LocationCondition) ZeusTransformUtils.preCheckCast(r10, LocationCondition.class, "com.obric.aiagent.plugin")).getLatitude());
        r8.setActive(true);
        goto L23
    L25:
        if (ZeusTransformUtils.instanceOf(r10, TimeCondition.class) == false) goto L37;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(((TimeCondition) ZeusTransformUtils.preCheckCast(r10, TimeCondition.class, "com.obric.aiagent.plugin")).getEnd(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L29;
    L32:
        boolean r4 = true;
    L33:
        if (r4 == false) goto L35;
        DayTimeCondition r7 = new DayTimeCondition(((TimeCondition) ZeusTransformUtils.preCheckCast(r10, TimeCondition.class, "com.obric.aiagent.plugin")).getStart());
        r7.setActive(true);
        r11 = (AutoCondition) ZeusTransformUtils.preCheckCast(r7, AutoCondition.class, "com.obric.aiagent.plugin");
        goto L55
    L35:
        DayTimeRangeCondition r13 = new DayTimeRangeCondition(((TimeCondition) ZeusTransformUtils.preCheckCast(r10, TimeCondition.class, "com.obric.aiagent.plugin")).getStart(), ((TimeCondition) ZeusTransformUtils.preCheckCast(r10, TimeCondition.class, "com.obric.aiagent.plugin")).getEnd());
        r13.setActive(true);
        r11 = (AutoCondition) ZeusTransformUtils.preCheckCast(r13, AutoCondition.class, "com.obric.aiagent.plugin");
        goto L55
    L29:
        if (r3.length() == 0) goto L32;
        r4 = false;
        goto L33
    L37:
        if (ZeusTransformUtils.instanceOf(r10, BatteryCondition.class) == false) goto L43;
        if (((BatteryCondition) ZeusTransformUtils.preCheckCast(r10, BatteryCondition.class, "com.obric.aiagent.plugin")).isCharging() == false) goto L41;
        ChargingBatteryCondition r14 = new ChargingBatteryCondition(Integer.valueOf((int) ((BatteryCondition) ZeusTransformUtils.preCheckCast(r10, BatteryCondition.class, "com.obric.aiagent.plugin")).getPercent()));
        r14.setActive(true);
        r11 = (AutoCondition) ZeusTransformUtils.preCheckCast(r14, AutoCondition.class, "com.obric.aiagent.plugin");
        goto L55
    L41:
        NoChargeBatteryCondition r15 = new NoChargeBatteryCondition(Integer.valueOf((int) ((BatteryCondition) ZeusTransformUtils.preCheckCast(r10, BatteryCondition.class, "com.obric.aiagent.plugin")).getPercent()));
        r15.setActive(true);
        r11 = (AutoCondition) ZeusTransformUtils.preCheckCast(r15, AutoCondition.class, "com.obric.aiagent.plugin");
        goto L55
    L43:
        if (ZeusTransformUtils.instanceOf(r10, BluetoothCondition.class) == false) goto L46;
        ConnectBluetoothCondition r16 = new ConnectBluetoothCondition(((BluetoothCondition) ZeusTransformUtils.preCheckCast(r10, BluetoothCondition.class, "com.obric.aiagent.plugin")).getName(), ((BluetoothCondition) ZeusTransformUtils.preCheckCast(r10, BluetoothCondition.class, "com.obric.aiagent.plugin")).getAddress());
        r16.setActive(true);
        r11 = (AutoCondition) ZeusTransformUtils.preCheckCast(r16, AutoCondition.class, "com.obric.aiagent.plugin");
        goto L55
    L46:
        if (ZeusTransformUtils.instanceOf(r10, WifiCondition.class) == false) goto L49;
        ConnectWifiCondition r17 = new ConnectWifiCondition(((WifiCondition) ZeusTransformUtils.preCheckCast(r10, WifiCondition.class, "com.obric.aiagent.plugin")).getSsid(), ((WifiCondition) ZeusTransformUtils.preCheckCast(r10, WifiCondition.class, "com.obric.aiagent.plugin")).getBssid());
        r17.setActive(true);
        r11 = (AutoCondition) ZeusTransformUtils.preCheckCast(r17, AutoCondition.class, "com.obric.aiagent.plugin");
        goto L55
    L49:
        if (ZeusTransformUtils.instanceOf(r10, StorageCondition.class) == false) goto L52;
        LowStorageCondition r18 = new LowStorageCondition(Integer.valueOf((int) ((StorageCondition) ZeusTransformUtils.preCheckCast(r10, StorageCondition.class, "com.obric.aiagent.plugin")).getPercent()));
        r18.setActive(true);
        r11 = (AutoCondition) ZeusTransformUtils.preCheckCast(r18, AutoCondition.class, "com.obric.aiagent.plugin");
        goto L55
    L52:
        if (ZeusTransformUtils.instanceOf(r10, SmsCondition.class) == false) goto L54;
        ReceiveSmsCondition r19 = new ReceiveSmsCondition(((SmsCondition) ZeusTransformUtils.preCheckCast(r10, SmsCondition.class, "com.obric.aiagent.plugin")).getCategoryType());
        r19.setActive(true);
        r11 = (AutoCondition) ZeusTransformUtils.preCheckCast(r19, AutoCondition.class, "com.obric.aiagent.plugin");
        goto L55
    L54:
        r11 = null;
        goto L55
    }

    public static final String a(PeriodicPolicy r14) {
        o.e(r14, "<this>");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r14.isSingleTask() == false) goto L6;
        String r15 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_single, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_single"));
        o.c(r15, "getString(...)");
        return r15;
    L6:
        if (r14.getDaily() == false) goto L8;
        String r16 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_daily_repeat, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_daily_repeat"));
        o.c(r16, "getString(...)");
        return r16;
    L8:
        int[] r2 = r14.getWeekly();
        if (r2 != null) goto L11;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == false) goto L38;
        int[] r1 = r14.getWeekly();
        if (r1 == null) goto L22;
        int r4 = r1.length;
    L23:
        if (r4 != 1) goto L33;
        int r5 = ZeusTransformUtils.mapRes(R.string.condition_period_weekly_one_repeat, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_weekly_one_repeat");
        Object[] r6 = new Object[1];
        int[] r17 = r14.getWeekly();
        if (r17 == null) goto L29;
        Integer r18 = i.b(r17);
        if (r18 == null) goto L29;
        String r19 = f.a(r18.intValue());
    L30:
        if (r19 != null) goto L32;
        r19 = "";
    L32:
        r6[0] = r19;
        String r110 = r0.getString(r5, r6);
        o.a(r110);
        return r110;
    L29:
        r19 = null;
        goto L30
    L33:
        int r7 = ZeusTransformUtils.mapRes(R.string.condition_period_weekly_n_repeat, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_weekly_n_repeat");
        Object[] r8 = new Object[1];
        int[] r111 = r14.getWeekly();
        if (r111 == null) goto L36;
        int r112 = r111.length;
    L37:
        r8[0] = Integer.valueOf(r112);
        String r113 = r0.getString(r7, r8);
        o.a(r113);
        return r113;
    L36:
        r112 = 0;
        goto L37
    L22:
        r4 = 0;
        goto L23
    L38:
        int r9 = r14.getMonthly();
        if (1 <= r9) goto L41;
    L43:
        boolean r10 = false;
    L44:
        if (r10 == false) goto L46;
        String r114 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_monthly_repeat, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_monthly_repeat"), new Object[]{Integer.valueOf(r14.getMonthly())});
        o.c(r114, "getString(...)");
        return r114;
    L46:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.getYearly(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L49;
    L52:
        boolean r12 = true;
    L54:
        if (r12 == true) goto L64;
        String r115 = r14.getYearly();
        o.a(r115);
        List r116 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);
        if (r116.size() != 2) goto L62;
        Integer r13 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r116.get(0), String.class, "com.obric.aiagent.plugin"));
        Integer r117 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r116.get(1), String.class, "com.obric.aiagent.plugin"));
        if (r13 == null) goto L61;
        if (r117 == null) goto L61;
        String r118 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_yearly_repeat, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_yearly_repeat"), new Object[]{r13, r117});
        o.a(r118);
        return r118;
    L61:
        String r119 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_none, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_none"));
        o.c(r119, "getString(...)");
        return r119;
    L62:
        String r120 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_none, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_none"));
        o.c(r120, "getString(...)");
        return r120;
    L64:
        if (r14.getEveryOffDay() == false) goto L67;
        String r121 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_off_day_repeat, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_off_day_repeat"));
        o.a(r121);
        return r121;
    L67:
        if (r14.getEveryWorkDay() == false) goto L69;
        String r122 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_work_day_repeat, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_work_day_repeat"));
        o.a(r122);
        return r122;
    L69:
        String r123 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_none, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_none"));
        o.c(r123, "getString(...)");
        return r123;
    L49:
        if (d.o.o.d(r11) == true) goto L52;
        r12 = false;
        goto L54
    L41:
        if (r9 >= 32) goto L43;
        r10 = true;
        goto L44
    L11:
        if (r2.length != 0) goto L13;
        boolean r20 = true;
    L15:
        if ((!r20) != true) goto L17;
        r3 = true;
        goto L18
    L13:
        r20 = false;
        goto L15
    }

    public static final String b(PeriodicPolicy r14) {
        o.e(r14, "<this>");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r14.isSingleTask() == false) goto L6;
        String r15 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_single, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_single"));
        o.c(r15, "getString(...)");
        return r15;
    L6:
        if (r14.getDaily() == false) goto L8;
        String r16 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_event_every_day, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_every_day"));
        o.c(r16, "getString(...)");
        return r16;
    L8:
        int[] r2 = r14.getWeekly();
        if (r2 != null) goto L11;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == false) goto L38;
        int[] r1 = r14.getWeekly();
        if (r1 == null) goto L22;
        int r4 = r1.length;
    L23:
        if (r4 != 1) goto L33;
        int r5 = ZeusTransformUtils.mapRes(R.string.condition_period_weekly_one, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_weekly_one");
        Object[] r6 = new Object[1];
        int[] r17 = r14.getWeekly();
        if (r17 == null) goto L29;
        Integer r18 = i.b(r17);
        if (r18 == null) goto L29;
        String r19 = f.a(r18.intValue());
    L30:
        if (r19 != null) goto L32;
        r19 = "";
    L32:
        r6[0] = r19;
        String r110 = r0.getString(r5, r6);
        o.a(r110);
        return r110;
    L29:
        r19 = null;
        goto L30
    L33:
        int r7 = ZeusTransformUtils.mapRes(R.string.condition_period_weekly_n, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_weekly_n");
        Object[] r8 = new Object[1];
        int[] r111 = r14.getWeekly();
        if (r111 == null) goto L36;
        int r112 = r111.length;
    L37:
        r8[0] = Integer.valueOf(r112);
        String r113 = r0.getString(r7, r8);
        o.a(r113);
        return r113;
    L36:
        r112 = 0;
        goto L37
    L22:
        r4 = 0;
        goto L23
    L38:
        int r9 = r14.getMonthly();
        if (1 <= r9) goto L41;
    L43:
        boolean r10 = false;
    L44:
        if (r10 == false) goto L46;
        String r114 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_monthly, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_monthly"), new Object[]{Integer.valueOf(r14.getMonthly())});
        o.c(r114, "getString(...)");
        return r114;
    L46:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.getYearly(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L49;
    L52:
        boolean r12 = true;
    L54:
        if (r12 == true) goto L64;
        String r115 = r14.getYearly();
        o.a(r115);
        List r116 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"-"}, false, 0, 6, null);
        if (r116.size() != 2) goto L62;
        Integer r13 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r116.get(0), String.class, "com.obric.aiagent.plugin"));
        Integer r117 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r116.get(1), String.class, "com.obric.aiagent.plugin"));
        if (r13 == null) goto L61;
        if (r117 == null) goto L61;
        String r118 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_yearly, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_yearly"), new Object[]{r13, r117});
        o.a(r118);
        return r118;
    L61:
        String r119 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_none, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_none"));
        o.c(r119, "getString(...)");
        return r119;
    L62:
        String r120 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_none, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_none"));
        o.c(r120, "getString(...)");
        return r120;
    L64:
        if (r14.getEveryOffDay() == false) goto L67;
        String r121 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_off_day_repeat, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_off_day_repeat"));
        o.a(r121);
        return r121;
    L67:
        if (r14.getEveryWorkDay() == false) goto L69;
        String r122 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_work_day_repeat, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_work_day_repeat"));
        o.a(r122);
        return r122;
    L69:
        String r123 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_period_none, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_period_none"));
        o.c(r123, "getString(...)");
        return r123;
    L49:
        if (d.o.o.d(r11) == true) goto L52;
        r12 = false;
        goto L54
    L41:
        if (r9 >= 32) goto L43;
        r10 = true;
        goto L44
    L11:
        if (r2.length != 0) goto L13;
        boolean r20 = true;
    L15:
        if ((!r20) != true) goto L17;
        r3 = true;
        goto L18
    L13:
        r20 = false;
        goto L15
    }

    public static final List<AutoCondition> a(ConditionGroup r4) {
        o.e(r4, "<this>");
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.getConditions(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        List<AutoCondition> r1 = a((Condition) ZeusTransformUtils.preCheckCast(r5.next(), Condition.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L4;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin"));
        goto L4
    L9:
        return new com.obric.autoaction.app.launcherpage.condition.config.condition.a(r0).a();
    }

    static {
        f22920a = new k("\\s+");
    }

    public static final String a(List<? extends AutoCondition> r12, Context r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        final Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        o.e(r14, "<this>");
        o.e(r15, "context");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L8;
        Object r2 = r17.next();
        if (((AutoCondition) ZeusTransformUtils.preCheckCast(r2, AutoCondition.class, "com.obric.aiagent.plugin")).getActive() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        String r1 = p.a((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, new $$Lambda$a$AKTJOdLd0YBsa7or4nxZ3VGXw(r15), 30, null);
        if (r18.size() == 1) goto L11;
    L15:
        r1 = r1 + r15.getString(ZeusTransformUtils.mapRes(R.string.condition_suffix_when, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_suffix_when"));
    L17:
        return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(f22920a.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), " "), CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L11:
        if (ZeusTransformUtils.instanceOf(p.l(r18), DayTimeCondition.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(p.l(r18), DayTimeRangeCondition.class) == false) goto L15;
        goto L15
    }

    private static final CharSequence a(Context r2, AutoCondition r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(a(r3.getDisplayText(r4, 2)), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private static final String a(CharSequence r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Spanned.class) == false) goto L5;
        int r4 = 0;
        RoundBackgroundSpan[] r0 = (RoundBackgroundSpan[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r11, Spanned.class, "com.obric.aiagent.plugin")).getSpans(0, r11.length(), RoundBackgroundSpan.class), RoundBackgroundSpan[].class, "com.obric.aiagent.plugin");
        o.a(r0);
        if (r0.length != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        boolean[] r3 = new boolean[r11.length() + 1];
        int r5 = r0.length;
        int r6 = 0;
    L14:
        if (r6 >= r5) goto L16;
        RoundBackgroundSpan r7 = r0[r6];
        r3[n.a(((Spanned) ZeusTransformUtils.preCheckCast(r11, Spanned.class, "com.obric.aiagent.plugin")).getSpanStart(r7), 0, r11.length())] = true;
        r3[n.a(((Spanned) ZeusTransformUtils.preCheckCast(r11, Spanned.class, "com.obric.aiagent.plugin")).getSpanEnd(r7), 0, r11.length())] = true;
        r6 = r6 + 1;
        goto L14
    L16:
        StringBuilder r1 = new StringBuilder(r11.length() + (r0.length * 2));
        int r8 = r11.length();
    L18:
        if (r4 >= r8) goto L24;
        if (r3[r4] == false) goto L22;
        r1.append(' ');
    L22:
        r1.append(r11.charAt(r4));
        r4 = r4 + 1;
        goto L18
    L24:
        if (r3[r11.length()] == false) goto L26;
        r1.append(' ');
    L26:
        String r12 = r1.toString();
        o.c(r12, "toString(...)");
        return r12;
    L12:
        return r11.toString();
    L9:
        r2 = false;
        goto L10
    L5:
        return r11.toString();
    }

    public static final int a(int r1) {
        return (r1 / 60000) / 60;
    }

    public static final int b(int r1) {
        return (r1 / 60000) % 60;
    }

    public static final com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a c(PeriodicPolicy r5) {
        o.e(r5, "<this>");
        if (r5.getDaily() == true) goto L38;
        int[] r0 = r5.getWeekly();
        boolean r1 = false;
        if (r0 != null) goto L8;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L18;
        return com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22916b;
    L18:
        if (r5.getMonthly() > 0) goto L40;
        String r3 = r5.getYearly();
        if (r3 != null) goto L23;
    L28:
        if (r1 == false) goto L31;
        return com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22918d;
    L31:
        if (r5.getEveryOffDay() == false) goto L34;
        return com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22919e;
    L34:
        if (r5.getEveryWorkDay() == false) goto L37;
        return com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f;
    L37:
        return com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.g;
    L23:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L25;
        boolean r4 = true;
    L26:
        if (r4 != true) goto L28;
        r1 = true;
        goto L28
    L25:
        r4 = false;
        goto L26
    L40:
        return com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22917c;
    L8:
        if (r0.length != 0) goto L10;
        boolean r6 = true;
    L12:
        if ((!r6) != true) goto L14;
        r2 = true;
        goto L15
    L10:
        r6 = false;
        goto L12
    L38:
        return com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a.f22915a;
    }

    public static /* synthetic */ String a(c r1, Integer r2, int r3, Object r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r1, c.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = null;
    L6:
        return a(r5, r2);
    }

    public static final String a(c r8, Integer r9) {
        c r10 = (c) ZeusTransformUtils.wrapperContextForParams(r8, c.class, "com.obric.aiagent.plugin");
        o.e(r10, "<this>");
        if (ZeusTransformUtils.instanceOf(r10, h.class) == false) goto L6;
        String r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_week_prefix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_week_prefix"), new Object[]{((h) ZeusTransformUtils.preCheckCast(r10, h.class, "com.obric.aiagent.plugin")).b()});
        o.c(r11, "getString(...)");
        return r11;
    L6:
        if (ZeusTransformUtils.instanceOf(r10, b.class) == false) goto L35;
        if (r9 == null) goto L30;
        if (r9.intValue() != 2) goto L16;
        if (((b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin")).a() > 28) goto L14;
    L13:
        boolean r12 = true;
    L26:
        if (r12 == true) goto L40;
        String r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_day_of_month_with_optional, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_day_of_month_with_optional"), new Object[]{((b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin")).b()});
    L32:
        o.a(r13);
        return r13;
    L40:
        return ((b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin")).b();
    L14:
        r12 = false;
        goto L26
    L16:
        if (r9.intValue() == 4) goto L24;
        if (r9.intValue() == 6) goto L24;
        if (r9.intValue() == 9) goto L24;
        if (r9.intValue() != 11) goto L13;
    L24:
        if (((b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin")).a() > 30) goto L14;
    L30:
        if (((b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin")).a() <= 28) goto L42;
        r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_day_of_month_with_optional, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_day_of_month_with_optional"), new Object[]{((b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin")).b()});
        goto L32
    L42:
        return ((b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin")).b();
    L35:
        if (ZeusTransformUtils.instanceOf(r10, d.class) == true) goto L43;
        return "";
    L43:
        return ((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.aiagent.plugin")).b();
    }
}
