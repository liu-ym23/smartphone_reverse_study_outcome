package com.obric.autoaction.app.launcherpage.module;

import android.content.Context;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.obric.autoaction.app.launcherpage.module.a.a.f;
import com.obric.autoaction.app.launcherpage.module.datasource.i;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.ITaskManagerApi;
import com.obric.eventkit.task.model.BatteryCondition;
import com.obric.eventkit.task.model.BluetoothCondition;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.eventkit.task.model.SmsCondition;
import com.obric.eventkit.task.model.StorageCondition;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.WifiCondition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.k;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.x;

/* JADX INFO: compiled from: RepeatTaskListViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends aj {
    private static final String TAG = "RepeatTaskManagementViewModel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24080a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<List<f>> f24081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.module.datasource.b f24082c;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: RepeatTaskListViewModel.kt */
    @d.c.b.a.f(b = "RepeatTaskListViewModel.kt", c = {45}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.RepeatTaskListViewModel$1")
    static final class AnonymousClass1 extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f24084b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.b$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: RepeatTaskListViewModel.kt */
        @d.c.b.a.f(b = "RepeatTaskListViewModel.kt", c = {75}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.RepeatTaskListViewModel$1$1")
        static final class C05441 extends l implements m<List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f>, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24085a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f24086b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f24087c;

            C05441(b r3, d.c.d<? super C05441> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24087c = r3;
                super(2, r5);
            }

            public final Object a(List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f> r3, d.c.d<? super d.x> r4) {
                return ((C05441) ZeusTransformUtils.preCheckCast(create((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C05441.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                C05441 r0 = new C05441(this.f24087c, r5);
                r0.f24086b = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(List<? extends com.obric.autoaction.app.launcherpage.module.datasource.f> r3, d.c.d<? super d.x> r4) {
                return a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r12) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f24085a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r12);
            L86:
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r12);
                List r13 = (List) ZeusTransformUtils.preCheckCast(this.f24086b, List.class, "com.obric.aiagent.plugin");
                com.obric.event.task.base.report.l r4 = com.obric.event.task.base.report.l.f32861a;
                String r10 = null;
                if (r13 == null) goto L15;
                Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
                Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r6, 10)), Collection.class, "com.obric.aiagent.plugin");
                Iterator r8 = r6.iterator();
            L12:
                if (r8.hasNext() == false) goto L14;
                r7.add(((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin")).a());
                goto L12
            L14:
                List r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
            L16:
                com.obric.event.task.base.report.l.a(r4, null, r9, null, 4, null);
                Loog r5 = Loog.INSTANCE;
                StringBuilder r11 = new StringBuilder().append("collectOrderCondition");
                if (r13 == null) goto L23;
                Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
                Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
                Iterator r15 = r14.iterator();
            L20:
                if (r15.hasNext() == false) goto L22;
                r2.add(((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin")).a().getId());
                goto L20
            L22:
                List r3 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
            L24:
                r5.i(b.TAG, r11.append(r3).toString());
                int r16 = 0;
                if (r13 == null) goto L57;
                Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
                Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
                Iterator r19 = r17.iterator();
            L28:
                if (r19.hasNext() == false) goto L40;
                Object r20 = r19.next();
                com.obric.autoaction.app.launcherpage.module.datasource.f r21 = (com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r20, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin");
                Integer r22 = r21.a().getEnableStatus();
                if (r22 == null) goto L35;
                if (r22.intValue() != 3) goto L35;
            L37:
                boolean r23 = false;
            L38:
                if (r23 == false) goto L28;
                r18.add(r20);
            L35:
                if (r21.a().getId() == null) goto L37;
                r23 = true;
                goto L38
            L40:
                Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
                b r24 = this.f24087c;
                Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
                Iterator r111 = r110.iterator();
            L42:
                if (r111.hasNext() == false) goto L56;
                com.obric.autoaction.app.launcherpage.module.datasource.f r26 = (com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r111.next(), com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r26, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L47;
                com.obric.autoaction.app.launcherpage.module.a.a.b r27 = b.a(r24, ((com.obric.autoaction.app.launcherpage.module.datasource.f.a) ZeusTransformUtils.preCheckCast(r26, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class, "com.obric.aiagent.plugin")).b());
            L52:
                if (r27 == null) goto L42;
                r25.add(r27);
                goto L42
            L47:
                if (ZeusTransformUtils.instanceOf(r26, com.obric.autoaction.app.launcherpage.module.datasource.f.b.class) == false) goto L50;
            L48:
                r27 = null;
                goto L52
            L50:
                if (ZeusTransformUtils.instanceOf(r26, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == true) goto L48;
                throw new k();
            L56:
                List<f> r112 = (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin");
            L58:
                Loog r28 = Loog.INSTANCE;
                StringBuilder r29 = new StringBuilder().append("emit condition render order size=");
                if (r112 == null) goto L61;
                r16 = r112.size();
            L61:
                StringBuilder r30 = r29.append(r16).append(", first=");
                if (r112 == null) goto L64;
                com.obric.autoaction.app.launcherpage.module.a.a.b r31 = (com.obric.autoaction.app.launcherpage.module.a.a.b) ZeusTransformUtils.preCheckCast(p.l(r112), com.obric.autoaction.app.launcherpage.module.a.a.b.class, "com.obric.aiagent.plugin");
            L66:
                if (ZeusTransformUtils.instanceOf(r31, com.obric.autoaction.app.launcherpage.module.a.a.b.class) == true) goto L69;
                r31 = null;
            L69:
                if (r31 == null) goto L71;
                String r32 = r31.a();
            L72:
                StringBuilder r33 = r30.append(r32).append(", last=");
                if (r112 == null) goto L75;
                com.obric.autoaction.app.launcherpage.module.a.a.b r34 = (com.obric.autoaction.app.launcherpage.module.a.a.b) ZeusTransformUtils.preCheckCast(p.n(r112), com.obric.autoaction.app.launcherpage.module.a.a.b.class, "com.obric.aiagent.plugin");
            L77:
                if (ZeusTransformUtils.instanceOf(r34, com.obric.autoaction.app.launcherpage.module.a.a.b.class) == true) goto L80;
                r34 = null;
            L80:
                if (r34 == null) goto L82;
                r10 = r34.a();
            L82:
                r28.i(b.TAG, r33.append(r10).toString());
                x<List<f>> r35 = this.f24087c.b();
                d.c.d<? super d.x> r36 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24085a = 1;
                if (r35.emit(r112, r36) != r0) goto L86;
                return r0;
            L75:
                r34 = null;
                goto L77
            L71:
                r32 = null;
                goto L72
            L64:
                r31 = null;
                goto L66
            L57:
                r112 = null;
                goto L58
            L23:
                r3 = null;
                goto L24
            L15:
                r9 = null;
                goto L16
            }
        }

        AnonymousClass1(b r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24084b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f24084b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24083a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            h r8 = (h) ZeusTransformUtils.preCheckCast(b.a(this.f24084b).a(), h.class, "com.obric.aiagent.plugin");
            m r2 = (m) ZeusTransformUtils.preCheckCast(new C05441(this.f24084b, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24083a = 1;
            if (j.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: RepeatTaskListViewModel.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f24080a = new a(null);
    }

    public b() {
        this.f24081b = kotlinx.coroutines.b.am.a(null);
        com.obric.autoaction.app.launcherpage.module.datasource.b r1 = (com.obric.autoaction.app.launcherpage.module.datasource.b) ZeusTransformUtils.preCheckCast(new i(), com.obric.autoaction.app.launcherpage.module.datasource.b.class, "com.obric.aiagent.plugin");
        this.f24082c = r1;
        r1.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")));
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.a.a.b a(b r0, ConditionTask r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.b a(b r0) {
        return r0.f24082c;
    }

    public final x<List<f>> b() {
        return this.f24081b;
    }

    private final com.obric.autoaction.app.launcherpage.module.a.a.b a(ConditionTask r22) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r22.getConditions().getConditions(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L3:
        SystemAutoActionParams r4 = null;
        com.obric.autoaction.app.launcherpage.module.a.a.b.a r5 = null;
        if (r2.hasNext() == false) goto L32;
        Condition r3 = (Condition) ZeusTransformUtils.preCheckCast(r2.next(), Condition.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, LocationCondition.class) == false) goto L9;
        r5 = com.obric.autoaction.app.launcherpage.module.a.a.b.a.f24002b;
    L28:
        if (r5 == null) goto L3;
        r1.add(r5);
        goto L3
    L9:
        if (ZeusTransformUtils.instanceOf(r3, TimeCondition.class) == false) goto L12;
        r5 = com.obric.autoaction.app.launcherpage.module.a.a.b.a.f24001a;
        goto L28
    L12:
        if (ZeusTransformUtils.instanceOf(r3, BatteryCondition.class) == false) goto L15;
        r5 = com.obric.autoaction.app.launcherpage.module.a.a.b.a.f24003c;
        goto L28
    L15:
        if (ZeusTransformUtils.instanceOf(r3, BluetoothCondition.class) == false) goto L18;
        r5 = com.obric.autoaction.app.launcherpage.module.a.a.b.a.f24004d;
        goto L28
    L18:
        if (ZeusTransformUtils.instanceOf(r3, WifiCondition.class) == false) goto L21;
        r5 = com.obric.autoaction.app.launcherpage.module.a.a.b.a.f24005e;
        goto L28
    L21:
        if (ZeusTransformUtils.instanceOf(r3, StorageCondition.class) == false) goto L24;
        r5 = com.obric.autoaction.app.launcherpage.module.a.a.b.a.f;
        goto L28
    L24:
        if (ZeusTransformUtils.instanceOf(r3, SmsCondition.class) == false) goto L27;
        r5 = com.obric.autoaction.app.launcherpage.module.a.a.b.a.g;
        goto L28
    L27:
        if (ZeusTransformUtils.instanceOf(r3, ConditionGroup.class) == true) goto L28;
        throw new k();
    L32:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        String r6 = com.obric.autoaction.app.launcherpage.condition.a.a.a(com.obric.autoaction.app.launcherpage.condition.a.a.a(r22.getConditions()), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        ConditionTaskAction r7 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(p.l(r22.getActions()), ConditionTaskAction.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L35;
        IntentParams r8 = r7.getParams();
    L37:
        if (ZeusTransformUtils.instanceOf(r8, SystemAutoActionParams.class) == false) goto L40;
        r4 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r8, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L40:
        if (r4 == null) goto L45;
        String r9 = r4.getInstruction();
        if (r9 == null) goto L45;
        String r11 = r9;
    L46:
        String r12 = r22.getId();
        if (r12 != null) goto L49;
        String r13 = "";
    L50:
        String r14 = r6 + r11;
        String r15 = String.valueOf(r6);
        Integer r16 = r22.getEnableStatus();
        if (r16 == null) goto L53;
        int r17 = r16.intValue();
    L54:
        int r18 = r17;
        List r19 = p.b();
        Long r20 = r22.getCreateTime();
        if (r20 == null) goto L57;
        long r21 = r20.longValue();
    L58:
        long r110 = r21;
        return new com.obric.autoaction.app.launcherpage.module.a.a.b(r13, com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a(r22.getId()), r14, r15, r10, r11, r18, 0, r19, com.obric.autoaction.app.launcherpage.condition.a.a.b(r22.getPeriodicPolicy()), r110, null, 2048, null);
    L57:
        r21 = 0;
        goto L58
    L53:
        r17 = 1;
        goto L54
    L49:
        r13 = r12;
    L45:
        r11 = "";
        goto L46
    L35:
        r8 = null;
        goto L37
    }

    public final Object a(List<String> r4, d.c.d<? super Boolean> r5) {
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "update condition order request count=" + r3.size() + ", first=" + ((String) ZeusTransformUtils.preCheckCast(p.l(r3), String.class, "com.obric.aiagent.plugin")) + ", last=" + ((String) ZeusTransformUtils.preCheckCast(p.n(r3), String.class, "com.obric.aiagent.plugin")));
        ITaskManagerApi r7 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        boolean r8 = true;
        if (r7 != null) goto L5;
    L7:
        r8 = false;
    L8:
        Loog.INSTANCE.i(TAG, "update condition order result success=" + r8);
        return d.c.b.a.b.a(r8);
    L5:
        if (r7.updateEventTaskDisplayOrder(2, r3) != true) goto L7;
        goto L7
    }

    public final void c() {
        Loog.INSTANCE.i(TAG, "refresh condition order list");
        com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.d();
    }
}
