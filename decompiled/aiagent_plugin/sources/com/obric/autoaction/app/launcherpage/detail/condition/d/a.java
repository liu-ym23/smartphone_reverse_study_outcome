package com.obric.autoaction.app.launcherpage.detail.condition.d;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.detail.base.h;
import com.obric.autoaction.app.launcherpage.detail.base.j;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskSpec;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskSpec;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.memorydata.sdk.awareness.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ConditionEventViewModelV2.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autoaction.app.launcherpage.detail.base.b.a<ConditionTask, ConditionTaskSpec> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f23454b;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.condition.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConditionEventViewModelV2.kt */
    @f(b = "ConditionEventViewModelV2.kt", c = {51}, d = "createDraftForNew", e = "com.obric.autoaction.app.launcherpage.detail.condition.viewmodel.ConditionEventViewModelV2")
    static final class C0515a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f23456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f23457c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f23458d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f23459e;

        C0515a(a r3, d.c.d<? super C0515a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23458d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23457c = r3;
            this.f23459e |= Integer.MIN_VALUE;
            return this.f23458d.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionEventViewModelV2.kt */
    @f(b = "ConditionEventViewModelV2.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.condition.viewmodel.ConditionEventViewModelV2$findUnsetHomeCompanyAddrName$2")
    static final class b extends l implements m<am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionGroup f23461b;

        b(ConditionGroup r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23461b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super String> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23461b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super String> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f23460a != 0) goto L38;
            o.a(r6);
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f23461b.getConditions(), Iterable.class, "com.obric.aiagent.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r8 = r5.iterator();
        L6:
            if (r8.hasNext() == false) goto L10;
            Object r1 = r8.next();
            if (ZeusTransformUtils.instanceOf(r1, LocationCondition.class) == false) goto L6;
            r7.add(r1);
            goto L6
        L10:
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r11 = r9.iterator();
        L12:
            if (r11.hasNext() == false) goto L16;
            String r2 = ((LocationCondition) ZeusTransformUtils.preCheckCast(r11.next(), LocationCondition.class, "com.obric.aiagent.plugin")).getAddrType();
            if (r2 == null) goto L12;
            r10.add(r2);
            goto L12
        L16:
            Iterator r12 = p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L18:
            if (r12.hasNext() == false) goto L36;
            String r13 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(r13, "home") == false) goto L23;
            e r3 = e.f33824a;
        L26:
            if (r3 == null) goto L18;
            if (com.obric.memorydata.sdk.awareness.a.f33811a.a(r3).isSuccess() == true) goto L18;
            if (d.h.b.o.a(r13, "home") == false) goto L33;
            int r14 = ZeusTransformUtils.mapRes(R.string.condition_location_name_home, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_name_home");
        L35:
            return com.obric.autoaction.app.launcherpage.utils.p.a(r14, null, 1, null);
        L33:
            r14 = ZeusTransformUtils.mapRes(R.string.condition_location_name_company, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_name_company");
            goto L35
        L23:
            if (d.h.b.o.a(r13, "company") == false) goto L25;
            r3 = e.f33825b;
            goto L26
        L25:
            r3 = null;
            goto L26
        L36:
            return null;
        L38:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ConditionEventViewModelV2.kt */
    @f(b = "ConditionEventViewModelV2.kt", c = {185}, d = "refreshExceedLimit", e = "com.obric.autoaction.app.launcherpage.detail.condition.viewmodel.ConditionEventViewModelV2")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f23463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f23464c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f23465d;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23464c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23463b = r3;
            this.f23465d |= Integer.MIN_VALUE;
            return a.a(this.f23464c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionEventViewModelV2.kt */
    @f(b = "ConditionEventViewModelV2.kt", c = {97}, d = "validateBeforeSave", e = "com.obric.autoaction.app.launcherpage.detail.condition.viewmodel.ConditionEventViewModelV2")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f23466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f23467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f23468c;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23467b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23466a = r3;
            this.f23468c |= Integer.MIN_VALUE;
            return this.f23467b.b(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ Object a(a r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ EventTask a(h r3, EventTask r4) {
        return (EventTask) ZeusTransformUtils.preCheckCast(a((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin"), (ConditionTask) ZeusTransformUtils.preCheckCast(r4, ConditionTask.class, "com.obric.aiagent.plugin")), EventTask.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ EventTaskSpec a(EventTask r3, boolean r4) {
        return (EventTaskSpec) ZeusTransformUtils.preCheckCast(a((ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.aiagent.plugin"), r4), EventTaskSpec.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ Object a(EventTask r3, d.c.d r4) {
        d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return a((ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ void a(EventTask r11, EventTask r12, boolean r13, int r14, String r15, long r16) {
        a((ConditionTask) ZeusTransformUtils.preCheckCast(r11, ConditionTask.class, "com.obric.aiagent.plugin"), (ConditionTask) ZeusTransformUtils.preCheckCast(r12, ConditionTask.class, "com.obric.aiagent.plugin"), r13, r14, r15, r16);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ boolean a(EventTask r3) {
        return c((ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ boolean a(EventTask r3, EventTask r4) {
        return a((ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.aiagent.plugin"), (ConditionTask) ZeusTransformUtils.preCheckCast(r4, ConditionTask.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ Object b(EventTask r3, d.c.d r4) {
        d.c.d<? super String> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return b((ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ EventTask d(EventTask r3) {
        return (EventTask) ZeusTransformUtils.preCheckCast(a((ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.aiagent.plugin")), EventTask.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ String e(EventTask r3) {
        return b((ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public /* synthetic */ void f(EventTask r3) {
        d((ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ a(com.obric.autoaction.app.launcherpage.detail.base.a.b r3, com.obric.autoaction.app.launcherpage.detail.base.a.a r4, int r5, d.h.b.h r6) {
        com.obric.autoaction.app.launcherpage.detail.base.a.b r7 = (com.obric.autoaction.app.launcherpage.detail.base.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.detail.base.a.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        com.obric.autoaction.app.launcherpage.detail.base.a.c r1 = null;
        Object[] r2 = 0 == true ? 1 : 0;
        r7 = (com.obric.autoaction.app.launcherpage.detail.base.a.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.condition.c.a(r1, r2, 3, 0 == true ? 1 : 0), com.obric.autoaction.app.launcherpage.detail.base.a.b.class, "com.obric.aiagent.plugin");
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = new com.obric.autoaction.app.launcherpage.detail.base.a.a();
    L8:
        this(r7, r4);
    }

    public a(com.obric.autoaction.app.launcherpage.detail.base.a.b<ConditionTask, ConditionTaskSpec> r3, com.obric.autoaction.app.launcherpage.detail.base.a.a r4) {
        com.obric.autoaction.app.launcherpage.detail.base.a.b r5 = (com.obric.autoaction.app.launcherpage.detail.base.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.detail.base.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "repository");
        d.h.b.o.e(r4, "reporter");
        super(r5, r4);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public boolean t() {
        return this.f23454b;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public Object a(EventTask r6, String r7, d.c.d<? super ConditionTask> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C0515a.class) == false) goto L7;
        C0515a r0 = (C0515a) ZeusTransformUtils.preCheckCast(r9, C0515a.class, "com.obric.aiagent.plugin");
        if ((r0.f23459e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f23459e -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f23457c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f23459e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.f23456b, String.class, "com.obric.aiagent.plugin");
        r6 = (EventTask) ZeusTransformUtils.preCheckCast(r0.f23455a, EventTask.class, "com.obric.aiagent.plugin");
        o.a(r10);
    L17:
        String r11 = null;
        if (ZeusTransformUtils.instanceOf(r6, ConditionTask.class) == false) goto L20;
        ConditionTask r5 = (ConditionTask) ZeusTransformUtils.preCheckCast(r6, ConditionTask.class, "com.obric.aiagent.plugin");
    L21:
        if (r5 == null) goto L23;
        r11 = com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r5, r7);
    L23:
        if (r11 != null) goto L26;
        r11 = "";
    L26:
        return com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r11, r5);
    L20:
        r5 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r10);
        r0.f23455a = r6;
        r0.f23456b = r7;
        r0.f23459e = 1;
        if (a(r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new C0515a(this, r9);
        goto L8
    }

    public Object a(ConditionTask r2, d.c.d<? super x> r3) {
        Object r1 = a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        if (r1 != d.c.a.b.a()) goto L6;
        return r1;
    L6:
        return x.f38692a;
    }

    public ConditionTask a(ConditionTask r8) {
        d.h.b.o.e(r8, "task");
        return com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r8, null, null, null, null, 15, null);
    }

    public String b(ConditionTask r2) {
        d.h.b.o.e(r2, "task");
        return com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r2, null, 1, null);
    }

    public boolean c(ConditionTask r4) {
        d.h.b.o.e(r4, "draft");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r4, null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L5;
    L7:
        return false;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4.getConditions().getConditions(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L7;
        return true;
    }

    public ConditionTask a(h r17, ConditionTask r18) {
        h r0 = (h) ZeusTransformUtils.wrapperContextForParams(r17, h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "action");
        d.h.b.o.e(r18, "current");
        if (ZeusTransformUtils.instanceOf(r0, j.h.class) == false) goto L6;
        return com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r18, ((j.h) ZeusTransformUtils.preCheckCast(r0, j.h.class, "com.obric.aiagent.plugin")).a(), null, null, null, 14, null);
    L6:
        if (ZeusTransformUtils.instanceOf(r0, j.d.class) == false) goto L9;
        return com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r18, null, com.obric.autoaction.app.launcherpage.condition.a.a.a(((j.d) ZeusTransformUtils.preCheckCast(r0, j.d.class, "com.obric.aiagent.plugin")).a()), null, null, 13, null);
    L9:
        if (ZeusTransformUtils.instanceOf(r0, j.i.class) == false) goto L12;
        PeriodicPolicy r2 = r18.getPeriodicPolicy();
        PeriodicPolicy r4 = ((j.i) ZeusTransformUtils.preCheckCast(r0, j.i.class, "com.obric.aiagent.plugin")).a();
        String r13 = r2.getStartDate();
        return com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r18, null, null, PeriodicPolicy.copy$default(r4, false, null, 0, null, false, false, r2.getExpireDate(), false, r13, 191, null), null, 11, null);
    L12:
        if (ZeusTransformUtils.instanceOf(r0, j.e.class) == false) goto L15;
        PeriodicPolicy r5 = r18.getPeriodicPolicy();
        String r14 = ((j.e) ZeusTransformUtils.preCheckCast(r0, j.e.class, "com.obric.aiagent.plugin")).a();
        return com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r18, null, null, PeriodicPolicy.copy$default(r5, false, null, 0, null, false, false, ((j.e) ZeusTransformUtils.preCheckCast(r0, j.e.class, "com.obric.aiagent.plugin")).b(), false, r14, 191, null), null, 11, null);
    L15:
        if (ZeusTransformUtils.instanceOf(r0, j.f.class) == false) goto L18;
        return com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r18, null, null, null, ((j.f) ZeusTransformUtils.preCheckCast(r0, j.f.class, "com.obric.aiagent.plugin")).a(), 7, null);
    L18:
        if (ZeusTransformUtils.instanceOf(r0, j.g.class) == false) goto L20;
        ConditionTask r3 = com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r18, null, null, null, null, 15, null);
        r3.setOmniModel(((j.g) ZeusTransformUtils.preCheckCast(r0, j.g.class, "com.obric.aiagent.plugin")).a());
        return r3;
    L20:
        return null;
    }

    public Object b(ConditionTask r7, d.c.d<? super String> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
        if ((r0.f23468c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f23468c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f23466a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f23468c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r10);
    L40:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L43;
        return null;
    L43:
        return com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_location_home_company_unset_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_home_company_unset_toast"), new Object[]{r6});
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r10);
        String r11 = r7.getPeriodicPolicy().getExpireDate();
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == true) goto L29;
        if (r11 == null) goto L28;
        if (d.h.b.o.a(e(r11), d.c.b.a.b.a(true)) == false) goto L29;
        return "截止日期不能小于当前时间";
    L28:
        throw new IllegalArgumentException("Required value was null.".toString());
    L29:
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(h(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L32;
    L35:
        boolean r13 = true;
    L36:
        if (r13 == false) goto L44;
        ConditionGroup r14 = r7.getConditions();
        r0.f23468c = 1;
        r10 = a(r14, r0);
        if (r10 != r2) goto L40;
        return r2;
    L44:
        return null;
    L32:
        if (r12.length() == 0) goto L35;
        r13 = false;
        goto L36
    L17:
        if (r4.length() == 0) goto L20;
        r5 = false;
    L7:
        r0 = new d(this, r9);
        goto L8
    }

    private final Object a(ConditionGroup r4, d.c.d<? super String> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new b(r4, null), m.class, "com.obric.aiagent.plugin"), r3);
    }

    public ConditionTaskSpec a(ConditionTask r2, boolean r3) {
        d.h.b.o.e(r2, "draft");
        if (r3 == true) goto L5;
        Integer r1 = r2.getEnableStatus();
    L11:
        return com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r2, r1, null, 2, null);
    L5:
        if (t() == false) goto L7;
        int r4 = 2;
    L8:
        r1 = Integer.valueOf(r4);
        goto L11
    L7:
        r4 = 0;
        goto L8
    }

    public boolean a(ConditionTask r3, ConditionTask r4) {
        d.h.b.o.e(r3, "initial");
        d.h.b.o.e(r4, "current");
        if (d.h.b.o.a(com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r3, null, 1, null), com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r4, null, 1, null)) == true) goto L5;
        return true;
    L5:
        if (d.h.b.o.a(r3.getConditions(), r4.getConditions()) == true) goto L7;
        return true;
    L7:
        if (d.h.b.o.a(r3.getPeriodicPolicy(), r4.getPeriodicPolicy()) == true) goto L9;
        return true;
    L9:
        if (d.h.b.o.a(r3.getTriggerControlPolicy(), r4.getTriggerControlPolicy()) == true) goto L11;
        return true;
    L11:
        if (d.h.b.o.a(r3.getOmniModel(), r4.getOmniModel()) == false) goto L19;
        return false;
    L19:
        return true;
    }

    public void a(ConditionTask r13, ConditionTask r14, boolean r15, int r16, String r17, long r18) {
        d.h.b.o.e(r13, "current");
        if (r15 == false) goto L5;
        ConditionTask r2 = r14;
    L6:
        com.obric.autoaction.app.launcherpage.detail.base.a.a r1 = c();
        String r4 = i();
        EventTask r0 = m();
        if (r0 == null) goto L9;
        String r3 = r0.getTemplateId();
    L10:
        r1.a(r2, r15, r4, r16, r17, r18, r14, r3, u());
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = r13;
        goto L6
    }

    private final String u() {
        if (d.h.b.o.a(i(), "enter_from_discovery_add_instruct") == true) goto L5;
        return null;
    L5:
        EventTask r0 = m();
        if (ZeusTransformUtils.instanceOf(r0, ConditionTask.class) == false) goto L8;
        ConditionTask r1 = (ConditionTask) ZeusTransformUtils.preCheckCast(r0, ConditionTask.class, "com.obric.aiagent.plugin");
    L9:
        if (r1 != null) goto L11;
        return null;
    L11:
        String r4 = com.obric.autoaction.app.launcherpage.detail.condition.a.a.a(r1, i());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L17;
        return null;
    L17:
        return r4;
    L14:
        r2 = false;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.a
    public void a(String r1, Integer r2) {
        c().a(r1, r2);
    }

    public void d(ConditionTask r2) {
        d.h.b.o.e(r2, "draft");
        c().a(r2);
    }

    private final Object a(d.c.d<? super x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
        if ((r0.f23465d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f23465d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f23463b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f23465d;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a this = (a) ZeusTransformUtils.preCheckCast(r0.f23462a, a.class, "com.obric.aiagent.plugin");
        o.a(r8);
    L18:
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue() >= com.obric.autoaction.app.launcherpage.detail.condition.b.a()) goto L21;
        r4 = false;
    L21:
        this.f23454b = r4;
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r8);
        r0.f23462a = this;
        r0.f23465d = 1;
        r8 = com.obric.autoaction.app.launcherpage.detail.condition.b.a(r0);
        if (r8 != r2) goto L18;
        return r2;
    L7:
        r0 = new c(this, r7);
        goto L8
    }

    private final Boolean e(String r3) {
        return Boolean.valueOf(LocalDate.parse((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(LocalDate.now(), ChronoLocalDate.class, "com.obric.aiagent.plugin")));
    L5:
        return null;
    }
}
