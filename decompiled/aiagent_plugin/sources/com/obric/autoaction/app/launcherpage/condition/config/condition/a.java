package com.obric.autoaction.app.launcherpage.condition.config.condition;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.s;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AutoConditionContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<AutoCondition> f22995a;

    public final List<AutoCondition> a() {
        return this.f22995a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        int r4 = 1;
        int r6 = 3;
        List<AutoCondition> r1 = p.c(new AutoCondition[]{new DayTimeCondition(null, r4, 0 == true ? 1 : 0), new DayTimeRangeCondition(0 == true ? 1 : 0, 0 == true ? 1 : 0, r6, 0 == true ? 1 : 0), new DayTimeRepeatCondition(0, r4, 0 == true ? 1 : 0), new EnterLocationCondition(null, null, null, null, 15, null), new ExitLocationCondition(null, null, null, null, 15, null), new ChargingBatteryCondition(0 == true ? 1 : 0, r4, 0 == true ? 1 : 0), new NoChargeBatteryCondition(0 == true ? 1 : 0, r4, 0 == true ? 1 : 0), new ConnectBluetoothCondition(0 == true ? 1 : 0, 0 == true ? 1 : 0, r6, 0 == true ? 1 : 0), new ConnectWifiCondition(0 == true ? 1 : 0, 0 == true ? 1 : 0, r6, 0 == true ? 1 : 0), new LowStorageCondition(0 == true ? 1 : 0, r4, 0 == true ? 1 : 0), new ReceiveSmsCondition(0 == true ? 1 : 0, r4, 0 == true ? 1 : 0)});
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((AutoCondition) ZeusTransformUtils.preCheckCast(r2.next(), AutoCondition.class, "com.obric.aiagent.plugin")).initAutoConditionContext(this);
        goto L4
    L6:
        this.f22995a = r1;
    }

    public a(List<AutoCondition> r5) {
        List<AutoCondition> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "list");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((AutoCondition) ZeusTransformUtils.preCheckCast(r0.next(), AutoCondition.class, "com.obric.aiagent.plugin")).initAutoConditionContext(this);
        goto L4
    L6:
        this.f22995a = r6;
    }

    public final d.m<com.obric.oui.picker.reels.a.c.b, com.obric.oui.picker.reels.a.c.b> b() {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f22995a, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r0 = r5.next();
        if (ZeusTransformUtils.instanceOf((AutoCondition) ZeusTransformUtils.preCheckCast(r0, AutoCondition.class, "com.obric.aiagent.plugin"), DayTimeRangeCondition.class) == false) goto L4;
    L10:
        if (ZeusTransformUtils.instanceOf(r0, DayTimeRangeCondition.class) == false) goto L12;
        DayTimeRangeCondition r6 = (DayTimeRangeCondition) ZeusTransformUtils.preCheckCast(r0, DayTimeRangeCondition.class, "com.obric.aiagent.plugin");
    L13:
        if (r6 != null) goto L17;
        return s.a(null, null);
    L17:
        return s.a(m.a(r6.getStartTime()), m.a(r6.getEndTime()));
    L12:
        r6 = null;
        goto L13
    L8:
        r0 = null;
        goto L10
    }
}
