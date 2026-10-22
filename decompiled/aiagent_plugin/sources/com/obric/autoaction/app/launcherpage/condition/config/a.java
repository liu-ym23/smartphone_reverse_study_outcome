package com.obric.autoaction.app.launcherpage.condition.config;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import androidx.lifecycle.v;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.autoaction.app.launcherpage.condition.config.a.c;
import com.obric.autoaction.app.launcherpage.condition.config.a.e;
import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ChargingBatteryCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ConnectBluetoothCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ConnectWifiCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.DayTimeRepeatCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.GroupInfo;
import com.obric.autoaction.app.launcherpage.condition.config.condition.LowStorageCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.NoChargeBatteryCondition;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ReceiveSmsCondition;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.eventkit.ITaskManagerApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ConditionConfigViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v<List<h>> f22936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.condition.config.condition.a f22937b;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.config.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConditionConfigViewModel.kt */
    @f(b = "ConditionConfigViewModel.kt", c = {132}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.config.ConditionConfigViewModel$updateCondition$1")
    static final class C0494a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f22939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f22940c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f22941d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f22942e;
        final /* synthetic */ Class<? extends AutoCondition> f;

        C0494a(a r3, Activity r4, View r5, Class<? extends AutoCondition> r6, d<? super C0494a> r7) {
            Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
            d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            this.f22940c = r3;
            this.f22941d = ZeusTransformUtils.wrapperContext2Activity(r8, "com.obric.aiagent.plugin");
            this.f22942e = r5;
            this.f = r6;
            super(2, r9);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((C0494a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0494a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r8, d<?> r9) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0494a(this.f22940c, this.f22941d, this.f22942e, this.f, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22939b;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            AutoCondition r2 = (AutoCondition) ZeusTransformUtils.preCheckCast(this.f22938a, AutoCondition.class, "com.obric.aiagent.plugin");
            o.a(r7);
        L24:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L37;
            r2.setActive(true);
            if (r2.isPrimary() == false) goto L37;
            Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f22940c.c(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L29:
            if (r8.hasNext() == false) goto L37;
            AutoCondition r3 = (AutoCondition) ZeusTransformUtils.preCheckCast(r8.next(), AutoCondition.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(r3.getGroupInfo(), r2.getGroupInfo()) == false) goto L29;
            if (r3.isPrimary() == false) goto L29;
            if (d.h.b.o.a(r3, r2) == true) goto L29;
            r3.setActive(false);
        L37:
            this.f22940c.a((Context) ZeusTransformUtils.preCheckCast(this.f22941d, Context.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(this.f22940c.c(), Iterable.class, "com.obric.aiagent.plugin");
            Class<? extends AutoCondition> r4 = this.f;
            Iterator r10 = r9.iterator();
        L10:
            if (r10.hasNext() == false) goto L14;
            Object r5 = r10.next();
            if (d.h.b.o.a(((AutoCondition) ZeusTransformUtils.preCheckCast(r5, AutoCondition.class, "com.obric.aiagent.plugin")).getClass(), r4) == false) goto L10;
        L15:
            AutoCondition r11 = (AutoCondition) ZeusTransformUtils.preCheckCast(r5, AutoCondition.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L18;
            Context r6 = (Context) ZeusTransformUtils.preCheckCast(this.f22941d, Context.class, "com.obric.aiagent.plugin");
            View r12 = this.f22942e;
            d<? super Boolean> r13 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f22938a = r11;
            this.f22939b = 1;
            Object r14 = r11.updateCondition(r6, r12, r13);
            if (r14 != r0) goto L22;
            return r0;
        L22:
            r2 = r11;
            r7 = r14;
            goto L24
        L18:
            return x.f38692a;
        L14:
            r5 = null;
            goto L15
        }
    }

    public static /* synthetic */ CharSequence lambda$aMwowZdZaLw1FVtDiup1ilWCJJc(AutoCondition r0, Context r1, int r2) {
        return b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$qKHtTsU-rQuJOburLDjE6Xys0NY, reason: not valid java name */
    public static /* synthetic */ CharSequence m448lambda$qKHtTsUrQuJOburLDjE6Xys0NY(AutoCondition r0, Context r1, int r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$uLJZu-_nKsvryT_4akXPaq9IFZc, reason: not valid java name */
    public static /* synthetic */ boolean m449lambda$uLJZu_nKsvryT_4akXPaq9IFZc(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$yXF8HhfWI7VV5xZseBWePsFIM8E(AutoCondition r0) {
        return a(r0);
    }

    public a() {
        this.f22936a = new v(p.b());
        this.f22937b = new com.obric.autoaction.app.launcherpage.condition.config.condition.a();
    }

    public final v<List<h>> b() {
        return this.f22936a;
    }

    public final List<AutoCondition> c() {
        return this.f22937b.a();
    }

    private static final boolean a(d.h.a.b r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private final void b(List<? extends AutoCondition> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<AutoCondition> r2 = c();
        final $$Lambda$a$yXF8HhfWI7VV5xZseBWePsFIM8E r5 = $$Lambda$a$yXF8HhfWI7VV5xZseBWePsFIM8E.INSTANCE;
        r2.removeIf(new $$Lambda$a$uLJZu_nKsvryT_4akXPaq9IFZc(r5));
    }

    private static final boolean a(AutoCondition r2) {
        d.h.b.o.e(r2, "it");
        if (d.h.b.o.a(r2.getClass(), DayTimeRepeatCondition.class) == false) goto L5;
    L18:
        return true;
    L5:
        if (d.h.b.o.a(r2.getClass(), ChargingBatteryCondition.class) == true) goto L18;
        if (d.h.b.o.a(r2.getClass(), NoChargeBatteryCondition.class) == true) goto L18;
        if (d.h.b.o.a(r2.getClass(), ConnectBluetoothCondition.class) == true) goto L18;
        if (d.h.b.o.a(r2.getClass(), ConnectWifiCondition.class) == true) goto L18;
        if (d.h.b.o.a(r2.getClass(), LowStorageCondition.class) == true) goto L18;
        if (d.h.b.o.a(r2.getClass(), ReceiveSmsCondition.class) == true) goto L18;
        return false;
    }

    private final boolean c(List<? extends AutoCondition> r6) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L30;
        AutoCondition r8 = (AutoCondition) ZeusTransformUtils.preCheckCast(r7.next(), AutoCondition.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r8.getClass(), DayTimeRepeatCondition.class) == false) goto L15;
        if (r8.getActive() == false) goto L15;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == false) goto L9;
        return true;
    L15:
        if (d.h.b.o.a(r8.getClass(), ChargingBatteryCondition.class) == true) goto L28;
        if (d.h.b.o.a(r8.getClass(), NoChargeBatteryCondition.class) == true) goto L28;
        if (d.h.b.o.a(r8.getClass(), ConnectBluetoothCondition.class) == true) goto L28;
        if (d.h.b.o.a(r8.getClass(), ConnectWifiCondition.class) == true) goto L28;
        if (d.h.b.o.a(r8.getClass(), LowStorageCondition.class) == true) goto L28;
        if (d.h.b.o.a(r8.getClass(), ReceiveSmsCondition.class) == true) goto L28;
        r9 = false;
    L30:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final void d(List<? extends AutoCondition> r4) {
        List<? extends AutoCondition> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        ITaskManagerApi r0 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        String r1 = r0.getConditionTaskV2();
    L7:
        if (d.h.b.o.a(r1, "true") == false) goto L9;
        return;
    L9:
        if (c(r5) == true) goto L13;
        b(r5);
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void a(List<? extends AutoCondition> r8) {
        List<? extends AutoCondition> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "conditions");
        d(r9);
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L15;
        AutoCondition r0 = (AutoCondition) ZeusTransformUtils.preCheckCast(r10.next(), AutoCondition.class, "com.obric.aiagent.plugin");
        int r3 = 0;
        Iterator<AutoCondition> r2 = c().iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        if (d.h.b.o.a(((AutoCondition) ZeusTransformUtils.preCheckCast(r2.next(), AutoCondition.class, "com.obric.aiagent.plugin")).getClass(), r0.getClass()) == true) goto L13;
        r3 = r3 + 1;
    L13:
        if (r3 == (-1)) goto L4;
        List<AutoCondition> r4 = c();
        r0.initAutoConditionContext(this.f22937b);
        x r5 = x.f38692a;
        r4.set(r3, r0);
        goto L4
    L12:
        r3 = -1;
        goto L13
    }

    public final void a(Context r15) {
        final Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r16, "context");
        List<h> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(c(), Iterable.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Object r5 = r4.next();
        GroupInfo r6 = ((AutoCondition) ZeusTransformUtils.preCheckCast(r5, AutoCondition.class, "com.obric.aiagent.plugin")).getGroupInfo();
        Object r7 = r3.get(r6);
        if (r7 != null) goto L8;
        r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r3.put(r6, r7);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin")).add(r5);
        goto L4
    L9:
        Iterator r8 = r3.entrySet().iterator();
    L11:
        if (r8.hasNext() == false) goto L48;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        GroupInfo r10 = (GroupInfo) ZeusTransformUtils.preCheckCast(r9.getKey(), GroupInfo.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r13.iterator();
    L14:
        if (r17.hasNext() == false) goto L18;
        Object r18 = r17.next();
        if (((AutoCondition) ZeusTransformUtils.preCheckCast(r18, AutoCondition.class, "com.obric.aiagent.plugin")).isPrimary() == false) goto L14;
        r14.add(r18);
        goto L14
    L18:
        List r19 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r22 = r20.iterator();
    L20:
        if (r22.hasNext() == false) goto L24;
        Object r23 = r22.next();
        if (((AutoCondition) ZeusTransformUtils.preCheckCast(r23, AutoCondition.class, "com.obric.aiagent.plugin")).isPrimary() == true) goto L20;
        r21.add(r23);
        goto L20
    L24:
        List r24 = (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin");
        Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin");
        boolean r26 = false;
        if (ZeusTransformUtils.instanceOf(r25, Collection.class) == true) goto L27;
    L29:
        Iterator r27 = r25.iterator();
    L31:
        if (r27.hasNext() == false) goto L35;
        if (((AutoCondition) ZeusTransformUtils.preCheckCast(r27.next(), AutoCondition.class, "com.obric.aiagent.plugin")).getActive() == false) goto L31;
        r26 = true;
    L35:
        r0.add(new com.obric.autoaction.app.launcherpage.condition.config.a.b(r26, r10));
        Iterator r28 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L37:
        if (r28.hasNext() == false) goto L43;
        final AutoCondition r29 = (AutoCondition) ZeusTransformUtils.preCheckCast(r28.next(), AutoCondition.class, "com.obric.aiagent.plugin");
        if (r26 == false) goto L42;
        if (r29.getActive() == false) goto L37;
    L42:
        r12.add(new c(r29.getClass(), r29.getDisplayText(r16, 1), r29.getActive(), new $$Lambda$a$qKHtTsUrQuJOburLDjE6Xys0NY(r29, r16)));
        goto L37
    L43:
        Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L45:
        if (r30.hasNext() == false) goto L47;
        final AutoCondition r31 = (AutoCondition) ZeusTransformUtils.preCheckCast(r30.next(), AutoCondition.class, "com.obric.aiagent.plugin");
        r12.add(new c(r31.getClass(), r31.getDisplayText(r16, 1), r31.getActive(), new $$Lambda$a$aMwowZdZaLw1FVtDiup1ilWCJJc(r31, r16)));
        goto L45
    L47:
        r0.add(new e(r12));
        goto L11
    L27:
        if (((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L29;
    L48:
        this.f22936a.b(r0);
    }

    private static final CharSequence a(AutoCondition r2, Context r3, int r4) {
        return r2.getDisplayEllipsizeText((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    private static final CharSequence b(AutoCondition r2, Context r3, int r4) {
        return r2.getDisplayEllipsizeText((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public final void a(Class<? extends AutoCondition> r12, Activity r13, View r14) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r13, Activity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, DbHelper.COL_ID);
        d.h.b.o.e(r4, "activity");
        d.h.b.o.e(r14, "anchorView");
        i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), (g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new C0494a(this, r4, r14, r12, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void a(Class<? extends AutoCondition> r7, Activity r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, DbHelper.COL_ID);
        d.h.b.o.e(r9, "activity");
        Iterator<AutoCondition> r0 = c().iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (d.h.b.o.a(((AutoCondition) ZeusTransformUtils.preCheckCast(r0.next(), AutoCondition.class, "com.obric.aiagent.plugin")).getClass(), r7) == true) goto L10;
        r2 = r2 + 1;
    L10:
        if (r2 != (-1)) goto L12;
        return;
    L12:
        List<AutoCondition> r1 = c();
        AutoCondition r10 = r7.newInstance();
        ((AutoCondition) ZeusTransformUtils.preCheckCast(r10, AutoCondition.class, "com.obric.aiagent.plugin")).initAutoConditionContext(this.f22937b);
        x r3 = x.f38692a;
        d.h.b.o.c(r10, "apply(...)");
        r1.set(r2, r10);
        a((Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        r2 = -1;
        goto L10
    }
}
