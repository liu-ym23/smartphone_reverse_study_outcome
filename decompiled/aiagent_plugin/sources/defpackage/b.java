package defpackage;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.eventkit.task.api.IEventTaskListenerApi;
import com.obric.eventkit.task.api.IEventTaskRecordApi;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.br;

/* JADX INFO: compiled from: TaskDaoImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.obric.autogui.database.a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f3016a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bp f3017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final am f3018c;

    /* JADX INFO: compiled from: TaskDaoImpl.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskDaoImpl.kt */
    @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {143}, d = "invokeSuspend", e = "EventTaskDaoImpl$deleteByEventTaskIds$1")
    static final class C0080b extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f3020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f3021c;

        /* JADX INFO: renamed from: b$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: TaskDaoImpl.kt */
        @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {ApWakeEvent.OTHER_START}, d = "invokeSuspend", e = "EventTaskDaoImpl$deleteByEventTaskIds$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super Integer>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f3022a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f3023b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f3024c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ List<String> f3025d;

            AnonymousClass1(List<String> r3, d.c.d<? super AnonymousClass1> r4) {
                List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f3025d = r5;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super Integer> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f3025d, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0069 -> B:16:0x006c). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0079 -> B:18:0x007a). Please report as a decompilation issue!!! */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r9) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f3024c;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                int r2 = this.f3023b;
                Iterator<String> r5 = (Iterator) ZeusTransformUtils.preCheckCast(this.f3022a, Iterator.class, "com.obric.aiagent.plugin");
                o.a(r9);
            L16:
                int r10 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue();
            L18:
                r2 = r2 + r10;
            L10:
                if (r5.hasNext() == false) goto L20;
                String r11 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
                IEventTaskRecordApi r6 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
                if (r6 == null) goto L17;
                d.c.d<? super Integer> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f3022a = r5;
                this.f3023b = r2;
                this.f3024c = 1;
                r9 = r6.removeExecutionRecordsByTaskId(r11, r7);
                if (r9 != r0) goto L16;
                return r0;
            L17:
                r10 = 0;
                goto L18
            L20:
                return d.c.b.a.b.a(r2);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r9);
                r5 = this.f3025d.iterator();
                r2 = 0;
                goto L10
            }
        }

        C0080b(b r3, List<String> r4, d.c.d<? super C0080b> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3020b = r3;
            this.f3021c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((C0080b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0080b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0080b(this.f3020b, this.f3021c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f3019a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            au r12 = kotlinx.coroutines.i.b(b.a(this.f3020b), null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f3021c, null), m.class, "com.obric.aiagent.plugin"), 3, null);
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3019a = 1;
            r11 = r12.a(r2);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskDaoImpl.kt */
    @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {127}, d = "invokeSuspend", e = "EventTaskDaoImpl$deleteByTaskIds$1")
    static final class c extends l implements m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f3027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long[] f3028c;

        /* JADX INFO: renamed from: b$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: TaskDaoImpl.kt */
        @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {126}, d = "invokeSuspend", e = "EventTaskDaoImpl$deleteByTaskIds$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super Integer>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f3029a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long[] f3030b;

            AnonymousClass1(long[] r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f3030b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super Integer> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f3030b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f3029a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L13:
                int r5 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue();
            L16:
                return d.c.b.a.b.a(r5);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                IEventTaskRecordApi r7 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
                if (r7 == null) goto L14;
                long[] r2 = this.f3030b;
                d.c.d<? super Integer> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f3029a = 1;
                r6 = r7.removeExecutionRecordsById(r2, r4);
                if (r6 != r0) goto L13;
                return r0;
            L14:
                r5 = 0;
                goto L16
            }
        }

        c(b r3, long[] r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3027b = r3;
            this.f3028c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f3027b, this.f3028c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f3026a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            au r12 = kotlinx.coroutines.i.b(b.a(this.f3027b), null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f3028c, null), m.class, "com.obric.aiagent.plugin"), 3, null);
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3026a = 1;
            r11 = r12.a(r2);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskDaoImpl.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {65}, d = "invokeSuspend", e = "EventTaskDaoImpl$getAllTasksFlow$1")
    static final class d extends l implements m<q<? super x>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f3032b;

        d(d.c.d<? super d> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: lambda$Ag2nIlnT2WS9PxzKAj0IsQm1C-k, reason: not valid java name */
        public static /* synthetic */ x m14lambda$Ag2nIlnT2WS9PxzKAj0IsQm1Ck(com.obric.eventkit.task.api.a r0) {
            return a(r0);
        }

        /* JADX INFO: renamed from: lambda$gU7Nz3oLHecKMsjHnjMsp-4WAAg, reason: not valid java name */
        public static /* synthetic */ void m15lambda$gU7Nz3oLHecKMsjHnjMsp4WAAg(q r0, int r1) {
            a(r0, r1);
        }

        public final Object a(q<? super x> r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d r4 = new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            r4.f3032b = r2;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(q<? super x> r3, d.c.d<? super x> r4) {
            return a((q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f3031a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            final q r8 = (q) ZeusTransformUtils.preCheckCast(this.f3032b, q.class, "com.obric.aiagent.plugin");
            final com.obric.eventkit.task.api.a r2 = new $$Lambda$b$d$gU7Nz3oLHecKMsjHnjMsp4WAAg(r8);
            IEventTaskListenerApi r4 = (IEventTaskListenerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskListenerApi.class), IEventTaskListenerApi.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L11;
            r4.registerEventTaskChangeListener(r2);
        L11:
            r8.a_(x.f38692a);
            d.h.a.a r5 = new $$Lambda$b$d$Ag2nIlnT2WS9PxzKAj0IsQm1Ck(r2);
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3031a = 1;
            if (kotlinx.coroutines.a.o.a(r8, r5, r3) != r0) goto L15;
            return r0;
        }

        private static final void a(q r2, int r3) {
            q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.aiagent.plugin");
            if (r3 != 7) goto L6;
            r4.a_(x.f38692a);
            return;
        }

        private static final x a(com.obric.eventkit.task.api.a r3) {
            com.obric.eventkit.task.api.a r4 = (com.obric.eventkit.task.api.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.eventkit.task.api.a.class, "com.obric.aiagent.plugin");
            IEventTaskListenerApi r0 = (IEventTaskListenerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskListenerApi.class), IEventTaskListenerApi.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L6;
            r0.unregisterEventTaskChangeListener(r4);
        L6:
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: TaskDaoImpl.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {75, 78}, d = "invokeSuspend", e = "EventTaskDaoImpl$getAllTasksFlow$2")
    static final class e extends l implements m<x, d.c.d<? super List<? extends com.obric.autogui.database.entity.a>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3036d;

        e(int r3, int r4, String r5, d.c.d<? super e> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3034b = r3;
            this.f3035c = r4;
            this.f3036d = r5;
            super(2, r7);
        }

        public final Object a(x r3, d.c.d<? super List<com.obric.autogui.database.entity.a>> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f3034b, this.f3035c, this.f3036d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(x r3, d.c.d<? super List<? extends com.obric.autogui.database.entity.a>> r4) {
            return a((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f3033a;
            List r2 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r8);
        L23:
            r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        L24:
            if (r2 != null) goto L26;
            r2 = p.b();
        L26:
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r10 = r7.iterator();
        L28:
            if (r10.hasNext() == false) goto L31;
            r9.add(com.obric.autogui.database.d.a((EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r10.next(), EventTaskExecutionRecord.class, "com.obric.aiagent.plugin")));
            goto L28
        L31:
            return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r8);
        L17:
            r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
            goto L24
        L10:
            o.a(r8);
            Loog.INSTANCE.d("EventTaskDaoImpl", "getAllTasksFlow " + this.f3034b + ' ' + this.f3035c);
            if (this.f3036d == null) goto L18;
            IEventTaskRecordApi r11 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L24;
            String r3 = this.f3036d;
            int r4 = this.f3034b;
            int r5 = this.f3035c;
            d.c.d<? super List<EventTaskExecutionRecord>> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3033a = 1;
            r8 = r11.getExecutionRecordsByTaskId(r3, r4, r5, r6);
            if (r8 != r0) goto L17;
            return r0;
        L18:
            IEventTaskRecordApi r12 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L24;
            int r13 = this.f3034b;
            int r14 = this.f3035c;
            d.c.d<? super List<EventTaskExecutionRecord>> r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3033a = 2;
            r8 = r12.getExecutionRecords(r13, r14, r15);
            if (r8 != r0) goto L23;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskDaoImpl.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {84}, d = "invokeSuspend", e = "EventTaskDaoImpl$getAllTasksFlow$3")
    static final class f extends l implements d.h.a.q<kotlinx.coroutines.b.i<? super List<? extends com.obric.autogui.database.entity.a>>, Throwable, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f3038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f3039c;

        f(d.c.d<? super f> r3) {
            super(3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.b.i<? super List<com.obric.autogui.database.entity.a>> r2, Throwable r3, d.c.d<? super x> r4) {
            kotlinx.coroutines.b.i r1 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            f r5 = new f((d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            r5.f3039c = r1;
            r5.f3038b = r3;
            return r5.invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(kotlinx.coroutines.b.i<? super List<? extends com.obric.autogui.database.entity.a>> r3, Throwable r4, d.c.d<? super x> r5) {
            return a((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f3037a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            kotlinx.coroutines.b.i r9 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(this.f3039c, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(this.f3038b, Throwable.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.e("EventTaskDaoImpl", "getAllTasksFlow: " + r2.getMessage(), r2);
            List r3 = p.b();
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3039c = null;
            this.f3037a = 1;
            if (r9.emit(r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskDaoImpl.kt */
    /* JADX INFO: loaded from: classes3.dex */
    @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {95}, d = "invokeSuspend", e = "EventTaskDaoImpl$getTaskById$1")
    static final class g extends l implements m<am, d.c.d<? super com.obric.autogui.database.entity.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f3041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f3042c;

        /* JADX INFO: renamed from: b$g$1, reason: invalid class name */
        /* JADX INFO: compiled from: TaskDaoImpl.kt */
        @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {94}, d = "invokeSuspend", e = "EventTaskDaoImpl$getTaskById$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super com.obric.autogui.database.entity.a>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f3043a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f3044b;

            AnonymousClass1(long r3, d.c.d<? super AnonymousClass1> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f3044b = r3;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super com.obric.autogui.database.entity.a> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f3044b, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.database.entity.a> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f3043a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r7);
            L13:
                EventTaskExecutionRecord r6 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r7, EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");
                if (r6 != null) goto L18;
            L16:
                return null;
            L18:
                return com.obric.autogui.database.d.a(r6);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r7);
                IEventTaskRecordApi r8 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
                if (r8 == null) goto L16;
                long r4 = this.f3044b;
                d.c.d<? super EventTaskExecutionRecord> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f3043a = 1;
                r7 = r8.getExecutionRecordById(r4, r2);
                if (r7 != r0) goto L13;
                return r0;
            }
        }

        g(b r3, long r4, d.c.d<? super g> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3041b = r3;
            this.f3042c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.database.entity.a> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f3041b, this.f3042c, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.database.entity.a> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f3040a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            au r12 = kotlinx.coroutines.i.b(b.a(this.f3041b), null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f3042c, null), m.class, "com.obric.aiagent.plugin"), 3, null);
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3040a = 1;
            r11 = r12.a(r2);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskDaoImpl.kt */
    /* JADX INFO: loaded from: classes4.dex */
    @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {44}, d = "invokeSuspend", e = "EventTaskDaoImpl$insertTask$1")
    static final class h extends l implements m<am, d.c.d<? super Long>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f3046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.database.entity.a f3047c;

        /* JADX INFO: renamed from: b$h$1, reason: invalid class name */
        /* JADX INFO: compiled from: TaskDaoImpl.kt */
        @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {42}, d = "invokeSuspend", e = "EventTaskDaoImpl$insertTask$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super Long>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f3048a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.database.entity.a f3049b;

            AnonymousClass1(com.obric.autogui.database.entity.a r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f3049b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super Long> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f3049b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super Long> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f3048a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L13:
                List r5 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
                if (r5 == null) goto L18;
                EventTaskExecutionRecord r7 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(p.l(r5), EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");
                if (r7 == null) goto L18;
                long r8 = r7.getId();
            L20:
                return d.c.b.a.b.a(r8);
            L18:
                r8 = -1;
                goto L20
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                IEventTaskRecordApi r9 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
                if (r9 == null) goto L18;
                List<EventTaskExecutionRecord> r2 = p.a(com.obric.autogui.database.d.a(this.f3049b));
                d.c.d<? super List<EventTaskExecutionRecord>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f3048a = 1;
                r6 = r9.addExecutionRecords(r2, r4);
                if (r6 != r0) goto L13;
                return r0;
            }
        }

        h(b r3, com.obric.autogui.database.entity.a r4, d.c.d<? super h> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3046b = r3;
            this.f3047c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Long> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f3046b, this.f3047c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Long> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f3045a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            au r12 = kotlinx.coroutines.i.b(b.a(this.f3046b), null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f3047c, null), m.class, "com.obric.aiagent.plugin"), 3, null);
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3045a = 1;
            r11 = r12.a(r2);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskDaoImpl.kt */
    /* JADX INFO: loaded from: classes4.dex */
    @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {105}, d = "invokeSuspend", e = "EventTaskDaoImpl$updateTask$1")
    static final class i extends l implements m<am, d.c.d<? super EventTaskExecutionRecord>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f3051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.database.entity.a f3052c;

        /* JADX INFO: renamed from: b$i$1, reason: invalid class name */
        /* JADX INFO: compiled from: TaskDaoImpl.kt */
        @d.c.b.a.f(b = "TaskDaoImpl.kt", c = {104}, d = "invokeSuspend", e = "EventTaskDaoImpl$updateTask$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super EventTaskExecutionRecord>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f3053a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.database.entity.a f3054b;

            AnonymousClass1(com.obric.autogui.database.entity.a r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f3054b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super EventTaskExecutionRecord> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f3054b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTaskExecutionRecord> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f3053a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L16:
                return (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r6, EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                IEventTaskRecordApi r7 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
                if (r7 == null) goto L14;
                EventTaskExecutionRecord r2 = com.obric.autogui.database.d.a(this.f3054b);
                d.c.d<? super EventTaskExecutionRecord> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f3053a = 1;
                r6 = r7.updateExecutionRecord(r2, r4);
                if (r6 != r0) goto L16;
                return r0;
            L14:
                return null;
            }
        }

        i(b r3, com.obric.autogui.database.entity.a r4, d.c.d<? super i> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3051b = r3;
            this.f3052c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super EventTaskExecutionRecord> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f3051b, this.f3052c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTaskExecutionRecord> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f3050a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            au r12 = kotlinx.coroutines.i.b(b.a(this.f3051b), null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f3052c, null), m.class, "com.obric.aiagent.plugin"), 3, null);
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f3050a = 1;
            r11 = r12.a(r2);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    static {
        f3016a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$-e-fHw5jGXUUcrj-Q1Z0OGtUhJ8, reason: not valid java name */
    public static /* synthetic */ Thread m13lambda$efHw5jGXUUcrjQ1Z0OGtUhJ8(Runnable r0) {
        return a(r0);
    }

    public b() {
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$b$efHw5jGXUUcrjQ1Z0OGtUhJ8.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor(...)");
        bp r1 = br.a(r0);
        this.f3017b = r1;
        this.f3018c = an.a((d.c.g) ZeusTransformUtils.preCheckCast(r1, d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ am a(b r0) {
        return r0.f3018c;
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "event-task-operation-thread");
    }

    @Override // com.obric.autogui.database.a.e
    public long a(com.obric.autogui.database.entity.a r5) {
        d.h.b.o.e(r5, "task");
        Loog.INSTANCE.d("EventTaskDaoImpl", "insert Task: " + r5.a());
        return ((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new h(this, r5, null), m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).longValue();
    }

    @Override // com.obric.autogui.database.a.e
    public kotlinx.coroutines.b.h<List<com.obric.autogui.database.entity.a>> a(int r4, int r5, String r6) {
        return j.b(j.a(j.a(j.b(j.a(j.c((m) ZeusTransformUtils.preCheckCast(new d(null), m.class, "com.obric.aiagent.plugin"))), (m) ZeusTransformUtils.preCheckCast(new e(r5, r4, r6, null), m.class, "com.obric.aiagent.plugin")), (d.h.a.q) ZeusTransformUtils.preCheckCast(new f(null), d.h.a.q.class, "com.obric.aiagent.plugin")), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    }

    @Override // com.obric.autogui.database.a.e
    public com.obric.autogui.database.entity.a a(long r3) {
        return (com.obric.autogui.database.entity.a) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new g(this, r3, null), m.class, "com.obric.aiagent.plugin"), 1, null), com.obric.autogui.database.entity.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.database.a.e
    public void b(com.obric.autogui.database.entity.a r5) {
        d.h.b.o.e(r5, "task");
        Loog.INSTANCE.d("EventTaskDaoImpl", "updateTask: " + r5.a());
        kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new i(this, r5, null), m.class, "com.obric.aiagent.plugin"), 1, null);
    }

    @Override // com.obric.autogui.database.a.e
    public int a(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "taskIds");
        Loog.INSTANCE.d("EventTaskDaoImpl", "deleteByTaskIds: " + r6);
        if (r6.isEmpty() == false) goto L7;
        return 0;
    L7:
        return ((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new c(this, p.f((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")), null), m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    @Override // com.obric.autogui.database.a.e
    public int b(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d("EventTaskDaoImpl", "deleteByEventTaskIds: " + r6);
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return 0;
    L12:
        return ((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new C0080b(this, r6, null), m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
