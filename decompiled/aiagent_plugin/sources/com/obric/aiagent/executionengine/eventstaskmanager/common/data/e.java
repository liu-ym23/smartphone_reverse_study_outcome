package com.obric.aiagent.executionengine.eventstaskmanager.common.data;

import android.app.Application;
import android.content.Context;
import com.bytedance.keva.Keva;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.OldTimerTaskDatabase;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.o;
import d.x;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: TaskDBManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f16691a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f16692b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f16693c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f16694d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<String, TaskDatabase> f16695e = null;
    private static final ConcurrentHashMap<String, OldTimerTaskDatabase> f = null;
    private static final Keva g = null;
    private static boolean h;

    /* JADX INFO: compiled from: TaskDBManager.kt */
    @d.c.b.a.f(b = "TaskDBManager.kt", c = {258}, d = "closeAllDatabases", e = "com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDBManager")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f16697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16698c;

        a(e r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16697b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16696a = r3;
            this.f16698c |= Integer.MIN_VALUE;
            return this.f16697b.b((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskDBManager.kt */
    @d.c.b.a.f(b = "TaskDBManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDBManager$closeAllDatabases$2")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16699a;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f16699a != 0) goto L15;
            o.a(r4);
            Collection r3 = e.e().values();
            d.h.b.o.c(r3, "<get-values>(...)");
            Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L6:
            if (r5.hasNext() == false) goto L8;
            ((TaskDatabase) ZeusTransformUtils.preCheckCast(r5.next(), TaskDatabase.class, "com.obric.aiagent.plugin")).g();
            goto L6
        L8:
            e.e().clear();
            Collection r6 = e.f().values();
            d.h.b.o.c(r6, "<get-values>(...)");
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L10:
            if (r7.hasNext() == false) goto L12;
            ((OldTimerTaskDatabase) ZeusTransformUtils.preCheckCast(r7.next(), OldTimerTaskDatabase.class, "com.obric.aiagent.plugin")).g();
            goto L10
        L12:
            e.f().clear();
            return x.f38692a;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: TaskDBManager.kt */
    @d.c.b.a.f(b = "TaskDBManager.kt", c = {272}, d = "getConditionTaskDao", e = "com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDBManager")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f16701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16702c;

        c(e r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16701b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16700a = r3;
            this.f16702c |= Integer.MIN_VALUE;
            return this.f16701b.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskDBManager.kt */
    @d.c.b.a.f(b = "TaskDBManager.kt", c = {98}, d = "getConditionTaskDatabase", e = "com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDBManager")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f16705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16706d;

        d(e r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16705c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16704b = r3;
            this.f16706d |= Integer.MIN_VALUE;
            return this.f16705c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.common.data.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskDBManager.kt */
    @d.c.b.a.f(b = "TaskDBManager.kt", c = {280}, d = "getConditionTaskRecordDao", e = "com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDBManager")
    static final class C0341e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f16708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16709c;

        C0341e(e r3, d.c.d<? super C0341e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16708b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16707a = r3;
            this.f16709c |= Integer.MIN_VALUE;
            return this.f16708b.d((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskDBManager.kt */
    @d.c.b.a.f(b = "TaskDBManager.kt", c = {123}, d = "getCurrentUid", e = "com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDBManager")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f16711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16712c;

        f(e r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16711b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16710a = r3;
            this.f16712c |= Integer.MIN_VALUE;
            return e.a(this.f16711b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskDBManager.kt */
    @d.c.b.a.f(b = "TaskDBManager.kt", c = {312}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDBManager$getCurrentUid$uid$1")
    static final class g extends l implements m<am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16713a;

        /* JADX INFO: compiled from: TaskDBManager.kt */
        static final class a implements d.h.a.b<Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f16714a;

            a(AtomicBoolean r1) {
                this.f16714a = r1;
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(Throwable r3) {
                com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d(e.d(), "getCurrentUid wait cancelled");
                this.f16714a.compareAndSet(false, true);
            }
        }

        /* JADX INFO: compiled from: TaskDBManager.kt */
        static final class b<S> implements com.obric.aiagent.ipc.utils.i.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.h.a.a<x> f16715a;

            b(d.h.a.a<x> r3) {
                this.f16715a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            }

            @Override // com.obric.aiagent.ipc.utils.i.b
            public /* synthetic */ void onRegister(Object r3) {
                a((IFlowAppIntentIDL) ZeusTransformUtils.preCheckCast(r3, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin"));
            }

            public final void a(IFlowAppIntentIDL r3) {
                d.h.b.o.e((IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin"), "it");
                com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(e.d(), "getCurrentUid onIPCRegister callback");
                this.f16715a.invoke();
            }
        }

        /* JADX INFO: compiled from: TaskDBManager.kt */
        static final class c implements d.h.a.a<x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f16716a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n<String> f16717b;

            c(AtomicBoolean r3, n<? super String> r4) {
                n<String> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
                this.f16716a = r3;
                this.f16717b = r5;
            }

            @Override // d.h.a.a
            public /* synthetic */ x invoke() {
                return a();
            }

            public final x a() {
                String r0 = e.a(e.f16691a);
                if (r0 == null) goto L8;
                AtomicBoolean r1 = this.f16716a;
                n<String> r4 = this.f16717b;
                if (r1.compareAndSet(false, true) == false) goto L10;
                com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(e.d(), "getCurrentUid resumed after ipc register");
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
                d.n.a r2 = d.n.f38560a;
                r5.resumeWith(d.n.f(r0));
            L10:
                return x.f38692a;
            L8:
                return null;
            }
        }

        g(d.c.d<? super g> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super String> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super String> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16713a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r9);
        L13:
            return r9;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r9);
            this.f16713a = 1;
            kotlinx.coroutines.o r3 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r3.e();
            n r10 = (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin");
            AtomicBoolean r4 = new AtomicBoolean(false);
            r10.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r4), d.h.a.b.class, "com.obric.aiagent.plugin"));
            d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r4, r10), d.h.a.a.class, "com.obric.aiagent.plugin");
            r.a(aa.b(IFlowAppIntentIDL.class), false, true, (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.preCheckCast(new b(r11), com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin"));
            r11.invoke();
            r9 = r3.h();
            if (r9 != d.c.a.b.a()) goto L11;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L11:
            if (r9 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskDBManager.kt */
    @d.c.b.a.f(b = "TaskDBManager.kt", c = {296}, d = "getExecutionDetailRecordDao", e = "com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDBManager")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f16719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16720c;

        h(e r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16719b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16718a = r3;
            this.f16720c |= Integer.MIN_VALUE;
            return this.f16719b.h((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskDBManager.kt */
    @d.c.b.a.f(b = "TaskDBManager.kt", c = {292}, d = "getExecutionRecordDao", e = "com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDBManager")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f16722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16723c;

        i(e r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16722b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16721a = r3;
            this.f16723c |= Integer.MIN_VALUE;
            return this.f16722b.g((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskDBManager.kt */
    @d.c.b.a.f(b = "TaskDBManager.kt", c = {284}, d = "getShortcutTaskDao", e = "com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDBManager")
    static final class j extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f16725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16726c;

        j(e r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16725b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16724a = r3;
            this.f16726c |= Integer.MIN_VALUE;
            return this.f16725b.e((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskDBManager.kt */
    @d.c.b.a.f(b = "TaskDBManager.kt", c = {288}, d = "getShortcutTaskRecordDao", e = "com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDBManager")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f16728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16729c;

        k(e r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16728b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16727a = r3;
            this.f16729c |= Integer.MIN_VALUE;
            return this.f16728b.f((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private e() {
    }

    public static final /* synthetic */ Object a(e r2, d.c.d r3) {
        return r2.i((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(e r0) {
        return r0.g();
    }

    public static final /* synthetic */ String d() {
        return TAG;
    }

    public static final /* synthetic */ ConcurrentHashMap e() {
        return f16695e;
    }

    public static final /* synthetic */ ConcurrentHashMap f() {
        return f;
    }

    static {
        f16691a = new e();
        TAG = "MultiAccountDBManager";
        f16692b = "repo_db_migration";
        f16693c = "condition_task_db_rename";
        f16694d = "timer_task_db_rename";
        f16695e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = Keva.getRepo("repo_db_migration", 0);
    }

    private final void a(Context r9, String r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        Keva r11 = g;
        String r0 = f16693c;
        if (r11.getBoolean(r0, false) == false) goto L6;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(TAG, "migrateConditionTaskDB has rename");
        return;
    L6:
        com.obric.aiagent.executionengine.eventstaskmanager.b.a r1 = com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a;
        String r2 = TAG;
        r1.b(r2, "migrateConditionTaskDB uid = " + r10);
        String r3 = TaskDatabase.f16687e.a();
        File r4 = r8.getDatabasePath(r3);
        String r12 = TaskDatabase.f16687e.a(r10);
        File r5 = r8.getDatabasePath(r12);
        if (r4.exists() == true) goto L10;
        r11.storeBoolean(r0, true);
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(r2, "migrateConditionTaskDB old db not exist");
        return;
    L10:
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(r2, "migrateConditionTaskDB dbRenameResult = " + r4.renameTo(r5) + ", walRenameResult = " + r8.getDatabasePath(r3 + "-wal").renameTo(r8.getDatabasePath(r12 + "-wal")) + ", shmRenameResult = " + r8.getDatabasePath(r3 + "-shm").renameTo(r8.getDatabasePath(r12 + "-shm")));
        r11.storeBoolean(r0, true);
    }

    public final Object a(d.c.d<? super TaskDatabase> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.aiagent.plugin");
        if ((r0.f16706d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16706d -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f16704b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16706d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        e this = (e) ZeusTransformUtils.preCheckCast(r0.f16703a, e.class, "com.obric.aiagent.plugin");
        o.a(r8);
    L17:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r4 = false;
        if (r1 != null) goto L20;
    L23:
        boolean r5 = true;
    L24:
        if (r5 == true) goto L31;
        if (d.h.b.o.a(r9, "0") == true) goto L31;
        return this.c(r9);
    L31:
        if (h == true) goto L45;
        IFlowAppIntentIDL r10 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r10 == null) goto L36;
        String r11 = r10.getUserId();
        if (r11 == null) goto L36;
    L37:
        com.obric.event.task.base.report.e r12 = com.obric.event.task.base.report.e.f32759a;
        IFlowAppIntentIDL r13 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r13 == null) goto L40;
        boolean r14 = r13.isLogin();
    L42:
        if (r.a(aa.b(IFlowAppIntentIDL.class)) != null) goto L44;
        r4 = true;
    L44:
        r12.a(r11, r14, r4);
        h = true;
        goto L45
    L40:
        r14 = false;
    L36:
        r11 = "";
    L45:
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d(TAG, "getConditionTaskDatabase userId is empty or 0");
        return null;
    L20:
        if (r1.length() == 0) goto L23;
        r5 = false;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r8);
        r0.f16703a = this;
        r0.f16706d = 1;
        r8 = i(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new d(this, r7);
        goto L8
    }

    private final Object i(d.c.d<? super String> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.aiagent.plugin");
        if ((r0.f16712c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16712c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f16710a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16712c;
        String r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r10);
    L24:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L30;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a r11 = com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a;
        String r1 = TAG;
        StringBuilder r5 = new StringBuilder().append("getCurrentUid timeout, uid=");
        IFlowAppIntentIDL r6 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r6 == null) goto L29;
        r4 = r6.getUserId();
    L29:
        r11.d(r1, r5.append(r4).toString());
    L30:
        return r7;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r10);
        String r12 = g();
        if (r12 == null) goto L17;
        return r12;
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.b.a r13 = com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a;
        String r14 = TAG;
        StringBuilder r15 = new StringBuilder().append("getCurrentUid empty, wait ipc register, ipcNull=");
        if (r.a(aa.b(IFlowAppIntentIDL.class)) != null) goto L20;
        boolean r16 = true;
    L21:
        r13.b(r14, r15.append(r16).toString());
        m r17 = (m) ZeusTransformUtils.preCheckCast(new g(null), m.class, "com.obric.aiagent.plugin");
        r0.f16712c = 1;
        r10 = dg.b(10000, r17, r0);
        if (r10 != r2) goto L24;
        return r2;
    L20:
        r16 = false;
    L7:
        r0 = new f(this, r9);
        goto L8
    }

    private final String g() {
        IFlowAppIntentIDL r3 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r3 == null) goto L13;
        String r4 = r3.getUserId();
        if (r4 != null) goto L7;
        return null;
    L7:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        return null;
    L12:
        return r4;
    L9:
        r1 = false;
        goto L10
    L13:
        return null;
    }

    private final TaskDatabase c(String r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L14:
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d(TAG, "getConditionTaskDatabaseWithUid userId is empty");
        return null;
    L8:
        if (d.h.b.o.a("0", r4) == true) goto L14;
        a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
        ConcurrentHashMap<String, TaskDatabase> r3 = f16695e;
        TaskDatabase r1 = (TaskDatabase) ZeusTransformUtils.preCheckCast(r3.get(r4), TaskDatabase.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L16;
        TaskDatabase r2 = TaskDatabase.f16687e.b(r4);
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin")).put(r4, r2);
        return r2;
    L16:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    private final void b(Context r9, String r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        Keva r11 = g;
        String r0 = f16694d;
        if (r11.getBoolean(r0, false) == false) goto L6;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(TAG, "migrateOldTimerTaskDB has rename");
        return;
    L6:
        com.obric.aiagent.executionengine.eventstaskmanager.b.a r1 = com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a;
        String r2 = TAG;
        r1.b(r2, "migrateOldTimerTaskDB uid = " + r10);
        String r3 = OldTimerTaskDatabase.f17859e.a();
        File r4 = r8.getDatabasePath(r3);
        String r12 = OldTimerTaskDatabase.f17859e.a(r10);
        File r5 = r8.getDatabasePath(r12);
        if (r4.exists() == true) goto L10;
        r11.storeBoolean(r0, true);
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(r2, "migrateOldTimerTaskDB old db not exist");
        return;
    L10:
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(r2, "migrateOldTimerTaskDB dbRenameResult = " + r4.renameTo(r5) + ", walRenameResult = " + r8.getDatabasePath(r3 + "-wal").renameTo(r8.getDatabasePath(r12 + "-wal")) + ", shmRenameResult = " + r8.getDatabasePath(r3 + "-shm").renameTo(r8.getDatabasePath(r12 + "-shm")));
        r11.storeBoolean(r0, true);
    }

    public final OldTimerTaskDatabase a() {
        IFlowAppIntentIDL r0 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r0 == null) goto L6;
        String r1 = r0.getUserId();
        if (r1 == null) goto L6;
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d(TAG, "getOldTimerTaskDatabase userId is empty");
        return null;
    L13:
        if (d.h.b.o.a("0", r1) == true) goto L17;
        return d(r1);
    L10:
        r2 = false;
    L6:
        r1 = "";
        goto L8
    }

    private final OldTimerTaskDatabase d(String r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L14:
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.d(TAG, "getOldTimerTaskDatabase userId is empty");
        return null;
    L8:
        if (d.h.b.o.a("0", r4) == true) goto L14;
        b((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
        ConcurrentHashMap<String, OldTimerTaskDatabase> r3 = f;
        OldTimerTaskDatabase r1 = (OldTimerTaskDatabase) ZeusTransformUtils.preCheckCast(r3.get(r4), OldTimerTaskDatabase.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L16;
        OldTimerTaskDatabase r2 = OldTimerTaskDatabase.f17859e.b(r4);
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin")).put(r4, r2);
        return r2;
    L16:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public final Object b(d.c.d<? super x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
        if ((r0.f16698c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16698c -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.f16696a;
        Object r8 = d.c.a.b.a();
        int r2 = r0.f16698c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r5);
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(TAG, "closeAllDatabases finish");
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r5);
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(TAG, "closeAllDatabases");
        d.c.g r9 = (d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.common.a.f16677a.a(), d.c.g.class, "com.obric.aiagent.plugin");
        m r1 = (m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin");
        r0.f16698c = 1;
        if (kotlinx.coroutines.i.a(r9, r1, r0) != r8) goto L17;
        return r8;
    L7:
        r0 = new a(this, r7);
        goto L8
    }

    public final Object c(d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
        if ((r0.f16702c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16702c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f16700a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16702c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r8);
    L17:
        TaskDatabase r5 = (TaskDatabase) ZeusTransformUtils.preCheckCast(r8, TaskDatabase.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L22;
        return null;
    L22:
        return r5.o();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r8);
        r0.f16702c = 1;
        r8 = a(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new c(this, r7);
        goto L8
    }

    public final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a a(String r2) {
        d.h.b.o.e(r2, "uid");
        TaskDatabase r1 = c(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.o();
    }

    public final Object d(d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, C0341e.class) == false) goto L7;
        C0341e r0 = (C0341e) ZeusTransformUtils.preCheckCast(r7, C0341e.class, "com.obric.aiagent.plugin");
        if ((r0.f16709c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16709c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f16707a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16709c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r8);
    L17:
        TaskDatabase r5 = (TaskDatabase) ZeusTransformUtils.preCheckCast(r8, TaskDatabase.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L22;
        return null;
    L22:
        return r5.p();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r8);
        r0.f16709c = 1;
        r8 = a(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new C0341e(this, r7);
        goto L8
    }

    public final Object e(d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, j.class) == false) goto L7;
        j r0 = (j) ZeusTransformUtils.preCheckCast(r7, j.class, "com.obric.aiagent.plugin");
        if ((r0.f16726c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16726c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f16724a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16726c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r8);
    L17:
        TaskDatabase r5 = (TaskDatabase) ZeusTransformUtils.preCheckCast(r8, TaskDatabase.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L22;
        return null;
    L22:
        return r5.q();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r8);
        r0.f16726c = 1;
        r8 = a(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new j(this, r7);
        goto L8
    }

    public final Object f(d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, k.class) == false) goto L7;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.aiagent.plugin");
        if ((r0.f16729c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16729c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f16727a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16729c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r8);
    L17:
        TaskDatabase r5 = (TaskDatabase) ZeusTransformUtils.preCheckCast(r8, TaskDatabase.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L22;
        return null;
    L22:
        return r5.r();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r8);
        r0.f16729c = 1;
        r8 = a(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new k(this, r7);
        goto L8
    }

    public final Object g(d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, i.class) == false) goto L7;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r7, i.class, "com.obric.aiagent.plugin");
        if ((r0.f16723c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16723c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f16721a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16723c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r8);
    L17:
        TaskDatabase r5 = (TaskDatabase) ZeusTransformUtils.preCheckCast(r8, TaskDatabase.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L22;
        return null;
    L22:
        return r5.s();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r8);
        r0.f16723c = 1;
        r8 = a(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new i(this, r7);
        goto L8
    }

    public final Object h(d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.aiagent.plugin");
        if ((r0.f16720c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16720c -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f16718a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16720c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o.a(r8);
    L17:
        TaskDatabase r5 = (TaskDatabase) ZeusTransformUtils.preCheckCast(r8, TaskDatabase.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L22;
        return null;
    L22:
        return r5.t();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r8);
        r0.f16720c = 1;
        r8 = a(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new h(this, r7);
        goto L8
    }

    public final com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a b() {
        OldTimerTaskDatabase r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.o();
    }

    public final com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a b(String r2) {
        d.h.b.o.e(r2, "uid");
        OldTimerTaskDatabase r1 = d(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.o();
    }

    public final com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.d c() {
        OldTimerTaskDatabase r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.p();
    }
}
