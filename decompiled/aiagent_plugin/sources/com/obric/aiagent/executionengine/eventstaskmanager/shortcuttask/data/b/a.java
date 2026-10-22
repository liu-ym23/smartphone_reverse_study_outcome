package com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b;

import com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.bean.ShortcutTaskRecordBean;
import com.obric.event.task.base.report.j;
import com.obric.eventkit.task.model.ShortcutTaskRecord;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;

/* JADX INFO: compiled from: ShortcutTaskRecordRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final am f17541a;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShortcutTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRecordRepo.kt", c = {26}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRecordRepo$addShortcutTaskRecord$2")
    static final class C0362a extends l implements m<am, d.c.d<? super Long>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f17543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ShortcutTaskRecordBean f17544c;

        C0362a(a r3, ShortcutTaskRecordBean r4, d.c.d<? super C0362a> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17543b = r3;
            this.f17544c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Long> r4) {
            return ((C0362a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0362a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0362a(this.f17543b, this.f17544c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Long> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17542a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L16;
            return null;
        L16:
            return d.c.b.a.b.a(r6.insert(this.f17544c));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            a r7 = this.f17543b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17542a = 1;
            r5 = a.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRecordRepo.kt", c = {51}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRecordRepo$getRecordsByPackageName$2")
    static final class b extends l implements m<am, d.c.d<? super List<? extends ShortcutTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f17546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f17547c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f17548d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f17549e;

        b(a r3, long r4, long r6, String r8, d.c.d<? super b> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17546b = r3;
            this.f17547c = r4;
            this.f17548d = r6;
            this.f17549e = r8;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTaskRecord>> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f17546b, this.f17547c, this.f17548d, this.f17549e, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTaskRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17545a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r4 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L20;
            List<ShortcutTaskRecordBean> r12 = r4.a(this.f17547c, this.f17548d, this.f17549e);
            if (r12 == null) goto L20;
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
            a r10 = this.f17546b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r13, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r14 = r13.iterator();
        L17:
            if (r14.hasNext() == false) goto L23;
            r2.add(a.a(r10, (ShortcutTaskRecordBean) ZeusTransformUtils.preCheckCast(r14.next(), ShortcutTaskRecordBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            a r15 = this.f17546b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17545a = 1;
            r11 = a.a(r15, r3);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRecordRepo.kt", c = {36}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRecordRepo$getRecordsByTaskIdAndPackageName$2")
    static final class c extends l implements m<am, d.c.d<? super List<? extends ShortcutTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f17551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f17553d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f17554e;
        final /* synthetic */ String f;

        c(a r3, String r4, long r5, long r7, String r9, d.c.d<? super c> r10) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17551b = r3;
            this.f17552c = r4;
            this.f17553d = r5;
            this.f17554e = r7;
            this.f = r9;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTaskRecord>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f17551b, this.f17552c, this.f17553d, this.f17554e, this.f, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTaskRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17550a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r12);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r4 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L20;
            List<ShortcutTaskRecordBean> r13 = r4.a(this.f17552c, this.f17553d, this.f17554e, this.f);
            if (r13 == null) goto L20;
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
            a r11 = this.f17551b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r15 = r14.iterator();
        L17:
            if (r15.hasNext() == false) goto L23;
            r2.add(a.a(r11, (ShortcutTaskRecordBean) ZeusTransformUtils.preCheckCast(r15.next(), ShortcutTaskRecordBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r12);
            a r16 = this.f17551b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17550a = 1;
            r12 = a.a(r16, r3);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRecordRepo.kt", c = {67}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRecordRepo$removeAllRecords$2")
    static final class d extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f17556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17557c;

        d(a r3, String r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17556b = r3;
            this.f17557c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f17556b, this.f17557c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17555a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.a(this.f17557c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            a r7 = this.f17556b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17555a = 1;
            r5 = a.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRecordRepo.kt", c = {63}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRecordRepo$removeRecordsById$2")
    static final class e extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f17559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long[] f17560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17561d;

        e(a r3, long[] r4, String r5, d.c.d<? super e> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17559b = r3;
            this.f17560c = r4;
            this.f17561d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f17559b, this.f17560c, this.f17561d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17558a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.a(i.b(this.f17560c), this.f17561d);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            a r7 = this.f17559b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17558a = 1;
            r5 = a.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRecordRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRecordRepo.kt", c = {71}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRecordRepo$removeRecordsByTaskId$2")
    static final class f extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f17563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17564c;

        f(a r3, String r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17563b = r3;
            this.f17564c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f17563b, this.f17564c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17562a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.b(this.f17564c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            a r7 = this.f17563b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17562a = 1;
            r5 = a.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public a() {
        this.f17541a = an.a((g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.common.a.f16677a.a(), g.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ShortcutTaskRecord a(a r0, ShortcutTaskRecordBean r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(a r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Object a(d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d> r2) {
        d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.common.data.e.f16691a.f(r1);
    }

    public final Object a(String r17, long r18, String r20, int r21, long r22, d.c.d<? super x> r24) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L5;
        j.f32784a.a(r18, r20, r21, 3, r22);
        ShortcutTaskRecordBean r15 = new ShortcutTaskRecordBean(r17, r18, r20, r21, 0, 0, 48, null);
        Object r0 = kotlinx.coroutines.i.b(this.f17541a, null, null, (m) ZeusTransformUtils.preCheckCast(new C0362a(this, r15, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r1);
        if (r0 != d.c.a.b.a()) goto L10;
        return r0;
    L10:
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    public final Object a(String r14, long r15, long r17, String r19, d.c.d<? super List<ShortcutTaskRecord>> r20) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17541a, null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, r19, r15, r17, r14, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r0);
    }

    public final Object a(String r13, long r14, long r16, d.c.d<? super List<ShortcutTaskRecord>> r18) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17541a, null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, r14, r16, r13, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r0);
    }

    public final Object a(String r9, long[] r10, d.c.d<? super Integer> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17541a, null, null, (m) ZeusTransformUtils.preCheckCast(new e(this, r10, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r12);
    }

    public final Object a(String r9, d.c.d<? super Integer> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17541a, null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    public final Object b(String r9, d.c.d<? super Integer> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17541a, null, null, (m) ZeusTransformUtils.preCheckCast(new f(this, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    private final ShortcutTaskRecord a(ShortcutTaskRecordBean r9) {
        return new ShortcutTaskRecord(r9.getId(), r9.getTaskId(), r9.getTriggerTime(), r9.getSourceFrom(), r9.getResult());
    }
}
