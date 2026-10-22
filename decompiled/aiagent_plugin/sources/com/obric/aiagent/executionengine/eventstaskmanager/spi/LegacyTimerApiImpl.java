package com.obric.aiagent.executionengine.eventstaskmanager.spi;

import com.obric.eventkit.task.api.ILegacyTimerApi;
import com.obric.eventkit.task.model.TimerTask;
import com.obric.eventkit.task.model.TimerTaskRecord;
import com.obric.eventkit.task.model.TimerTaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LegacyTimerApiImpl implements ILegacyTimerApi {
    public static final a Companion = null;
    private static final String TAG = "LegacyTimerApiImpl";
    private final ConcurrentHashMap<com.obric.eventkit.task.api.a, CopyOnWriteArrayList<com.obric.eventkit.task.api.a>> listenerWrappers;

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$addTimerTask$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super TimerTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17800c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TimerTask f17801d;

        b(LegacyTimerApiImpl r3, TimerTask r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17800c = r3;
            this.f17801d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super TimerTaskResult> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f17800c, this.f17801d, r6);
            r0.f17799b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super TimerTaskResult> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17798a != 0) goto L10;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17799b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            return (TimerTaskResult) ZeusTransformUtils.preCheckCast(LegacyTimerApiImpl.access$disabled(this.f17800c, "addTimerTask"), TimerTaskResult.class, "com.obric.aiagent.plugin");
        L8:
            return com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a(this.f17801d, r4);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$getAllTimerTaskRecords$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<TimerTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f17805d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f17806e;

        c(LegacyTimerApiImpl r3, long r4, long r6, d.c.d<? super c> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17804c = r3;
            this.f17805d = r4;
            this.f17806e = r6;
            super(2, r9);
        }

        public final Object a(String r3, d.c.d<? super List<TimerTaskRecord>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            c r12 = new c(this.f17804c, this.f17805d, this.f17806e, r8);
            r12.f17803b = r10;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<TimerTaskRecord>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f17802a != 0) goto L10;
            d.o.a(r9);
            String r10 = (String) ZeusTransformUtils.preCheckCast(this.f17803b, String.class, "com.obric.aiagent.plugin");
            String r7 = LegacyTimerApiImpl.access$enabledPackageOrNull(this.f17804c, "getAllTimerTaskRecords", r10);
            if (r7 == null) goto L7;
            long r3 = this.f17805d;
            long r5 = this.f17806e;
            return com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a(r3, r5, r7);
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$getAllTimerTasks$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<TimerTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17809c;

        d(LegacyTimerApiImpl r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17809c = r3;
            super(2, r5);
        }

        public final Object a(String r3, d.c.d<? super List<TimerTask>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f17809c, r5);
            r0.f17808b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<TimerTask>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17807a != 0) goto L10;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17808b, String.class, "com.obric.aiagent.plugin");
            String r2 = LegacyTimerApiImpl.access$enabledPackageOrNull(this.f17809c, "getAllTimerTasks", r4);
            if (r2 != null) goto L11;
            return null;
        L11:
            return com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a(r2);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$getNextScheduleTimestamp$2")
    static final class e extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Long>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f17812c;

        e(int r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17812c = r3;
            super(2, r5);
        }

        public final Object a(String r3, d.c.d<? super Long> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            e r0 = new e(this.f17812c, r5);
            r0.f17811b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Long> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f17810a != 0) goto L18;
            d.o.a(r4);
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f17811b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L8;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(LegacyTimerApiImpl.TAG, "getNextScheduleTimestamp not enable");
            return d.c.b.a.b.a(0);
        L8:
            long r0 = -1;
            if (r5 == null) goto L11;
            Long r3 = com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.b(this.f17812c, r5);
            if (r3 == null) goto L16;
            r0 = r3.longValue();
        L16:
            return d.c.b.a.b.a(r0);
        L11:
            return d.c.b.a.b.a(-1);
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$getTimerTaskByTaskId$2")
    static final class f extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super TimerTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17816d;

        f(LegacyTimerApiImpl r3, int r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17815c = r3;
            this.f17816d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super TimerTask> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            f r0 = new f(this.f17815c, this.f17816d, r6);
            r0.f17814b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super TimerTask> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17813a != 0) goto L10;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17814b, String.class, "com.obric.aiagent.plugin");
            String r5 = LegacyTimerApiImpl.access$enabledPackageOrNull(this.f17815c, "getTimerTaskByTaskId", r4);
            if (r5 == null) goto L7;
            int r2 = this.f17816d;
            return com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a(r2, r5);
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$getTimerTaskRecordsByTaskId$2")
    static final class g extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<TimerTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17819c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17820d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f17821e;
        final /* synthetic */ long f;

        g(LegacyTimerApiImpl r3, int r4, long r5, long r7, d.c.d<? super g> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17819c = r3;
            this.f17820d = r4;
            this.f17821e = r5;
            this.f = r7;
            super(2, r10);
        }

        public final Object a(String r3, d.c.d<? super List<TimerTaskRecord>> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            g r13 = new g(this.f17819c, this.f17820d, this.f17821e, this.f, r9);
            r13.f17818b = r11;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r13, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<TimerTaskRecord>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f17817a != 0) goto L10;
            d.o.a(r10);
            String r11 = (String) ZeusTransformUtils.preCheckCast(this.f17818b, String.class, "com.obric.aiagent.plugin");
            String r8 = LegacyTimerApiImpl.access$enabledPackageOrNull(this.f17819c, "getTimerTaskRecordsByTaskId", r11);
            if (r8 == null) goto L7;
            int r3 = this.f17820d;
            long r4 = this.f17821e;
            long r6 = this.f;
            return com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a(r3, r4, r6, r8);
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$getTimerTasks$2")
    static final class h extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super List<? extends TimerTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map<Object, Object> f17825d;

        h(LegacyTimerApiImpl r3, Map<Object, ? extends Object> r4, d.c.d<? super h> r5) {
            Map<Object, Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17824c = r3;
            this.f17825d = r6;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super List<TimerTask>> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            h r0 = new h(this.f17824c, this.f17825d, r6);
            r0.f17823b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super List<? extends TimerTask>> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17822a != 0) goto L11;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17823b, String.class, "com.obric.aiagent.plugin");
            String r5 = LegacyTimerApiImpl.access$enabledPackageOrNull(this.f17824c, "getTimerTasks", r4);
            if (r5 != null) goto L9;
            return d.a.p.b();
        L9:
            return com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a(ao.e(this.f17825d), r5);
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$registerTimerTaskChangeListener$2")
    static final class i extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17828c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.eventkit.task.api.a f17829d;

        i(LegacyTimerApiImpl r3, com.obric.eventkit.task.api.a r4, d.c.d<? super i> r5) {
            com.obric.eventkit.task.api.a r6 = (com.obric.eventkit.task.api.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.eventkit.task.api.a.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17828c = r3;
            this.f17829d = r6;
            super(2, r7);
        }

        public static /* synthetic */ void lambda$8FBkawos4EID8RIo3tzRuqDo9lE(com.obric.eventkit.task.api.a r0, int r1) {
            a(r0, r1);
        }

        public final Object a(String r3, d.c.d<? super x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            i r0 = new i(this.f17828c, this.f17829d, r6);
            r0.f17827b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super x> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f17826a != 0) goto L17;
            d.o.a(r5);
            String r6 = (String) ZeusTransformUtils.preCheckCast(this.f17827b, String.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L7;
            final com.obric.eventkit.task.api.a r0 = this.f17829d;
            com.obric.eventkit.task.api.a r2 = new $$Lambda$LegacyTimerApiImpl$i$8FBkawos4EID8RIo3tzRuqDo9lE(r0);
            ConcurrentMap r1 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(LegacyTimerApiImpl.access$getListenerWrappers$p(this.f17828c), ConcurrentMap.class, "com.obric.aiagent.plugin");
            com.obric.eventkit.task.api.a r4 = this.f17829d;
            Object r3 = r1.get(r4);
            if (r3 != null) goto L14;
            r3 = new CopyOnWriteArrayList();
            Object r7 = r1.putIfAbsent(r4, r3);
            if (r7 == null) goto L14;
            r3 = r7;
        L14:
            ((CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r3, CopyOnWriteArrayList.class, "com.obric.aiagent.plugin")).add(r2);
            com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r6, r2);
            return x.f38692a;
        L7:
            return x.f38692a;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final void a(com.obric.eventkit.task.api.a r2, int r3) {
            com.obric.eventkit.task.api.a r4 = (com.obric.eventkit.task.api.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.eventkit.task.api.a.class, "com.obric.aiagent.plugin");
            if (r3 != 1) goto L5;
        L7:
            r4.onChanged(r3);
            return;
        L5:
            if (r3 == 2) goto L7;
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$removeAllTimerTaskRecords$2")
    static final class j extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17832c;

        j(LegacyTimerApiImpl r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17832c = r3;
            super(2, r5);
        }

        public final Object a(String r3, d.c.d<? super Integer> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            j r0 = new j(this.f17832c, r5);
            r0.f17831b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Integer> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17830a != 0) goto L11;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17831b, String.class, "com.obric.aiagent.plugin");
            String r2 = LegacyTimerApiImpl.access$enabledPackageOrNull(this.f17832c, "removeAllTimerTaskRecords", r4);
            if (r2 != null) goto L9;
            return d.c.b.a.b.a(0);
        L9:
            return d.c.b.a.b.a(com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.b(r2));
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$removeTimerTask$2")
    static final class k extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super TimerTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17835c;

        k(LegacyTimerApiImpl r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17835c = r3;
            super(2, r5);
        }

        public final Object a(String r3, d.c.d<? super TimerTaskResult> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            k r0 = new k(this.f17835c, r5);
            r0.f17834b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super TimerTaskResult> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17833a != 0) goto L8;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17834b, String.class, "com.obric.aiagent.plugin");
            if (LegacyTimerApiImpl.access$enabledPackageOrNull(this.f17835c, "removeTimerTask", r4) == null) goto L6;
        L6:
            return null;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$removeTimerTaskRecordsById$2")
    static final class l extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int[] f17838c;

        l(int[] r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17838c = r3;
            super(2, r5);
        }

        public final Object a(String r3, d.c.d<? super Integer> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            l r0 = new l(this.f17838c, r5);
            r0.f17837b = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super Integer> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17836a != 0) goto L17;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17837b, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L7;
        L14:
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(LegacyTimerApiImpl.TAG, "removeTimerTaskRecordsById not enable or ids is null");
            return d.c.b.a.b.a(0);
        L7:
            if (this.f17838c == null) goto L14;
            if (r4 != null) goto L13;
            return d.c.b.a.b.a(0);
        L13:
            return d.c.b.a.b.a(com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.b(d.a.i.f(this.f17838c), r4));
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$removeTimerTasksByTaskId$2")
    static final class m extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super TimerTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<Integer> f17842d;

        m(LegacyTimerApiImpl r3, List<Integer> r4, d.c.d<? super m> r5) {
            List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17841c = r3;
            this.f17842d = r6;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super TimerTaskResult> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            m r0 = new m(this.f17841c, this.f17842d, r6);
            r0.f17840b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super TimerTaskResult> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17839a != 0) goto L10;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17840b, String.class, "com.obric.aiagent.plugin");
            String r5 = LegacyTimerApiImpl.access$enabledPackageOrNull(this.f17841c, "removeTimerTasksByTaskId", r4);
            if (r5 == null) goto L7;
            List<Integer> r2 = this.f17842d;
            return com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a(r2, r5);
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$skipTimerTasksByTaskId$2")
    static final class n extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super TimerTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17845c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17846d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long[] f17847e;

        n(LegacyTimerApiImpl r3, int r4, long[] r5, d.c.d<? super n> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17845c = r3;
            this.f17846d = r4;
            this.f17847e = r5;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super TimerTaskResult> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            n r0 = new n(this.f17845c, this.f17846d, this.f17847e, r7);
            r0.f17844b = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super TimerTaskResult> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17843a != 0) goto L10;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17844b, String.class, "com.obric.aiagent.plugin");
            String r5 = LegacyTimerApiImpl.access$enabledPackageOrNull(this.f17845c, "skipTimerTasksByTaskId", r4);
            if (r5 == null) goto L7;
            int r0 = this.f17846d;
            long[] r2 = this.f17847e;
            return com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.a(d.a.p.a(d.c.b.a.b.a(r0)), d.a.i.b(r2), r5);
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$unregisterTimerTaskChangeListener$2")
    static final class o extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.eventkit.task.api.a f17851d;

        o(LegacyTimerApiImpl r3, com.obric.eventkit.task.api.a r4, d.c.d<? super o> r5) {
            com.obric.eventkit.task.api.a r6 = (com.obric.eventkit.task.api.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.eventkit.task.api.a.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17850c = r3;
            this.f17851d = r6;
            super(2, r7);
        }

        public final Object a(String r3, d.c.d<? super x> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            o r0 = new o(this.f17850c, this.f17851d, r6);
            r0.f17849b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super x> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f17848a != 0) goto L21;
            d.o.a(r5);
            String r6 = (String) ZeusTransformUtils.preCheckCast(this.f17849b, String.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L7;
            CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(LegacyTimerApiImpl.access$getListenerWrappers$p(this.f17850c).get(this.f17851d), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L11;
            com.obric.eventkit.task.api.a r1 = (com.obric.eventkit.task.api.a) ZeusTransformUtils.preCheckCast(d.a.p.l((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin")), com.obric.eventkit.task.api.a.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L16;
            r0.remove(r1);
            com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.b(r6, r1);
        L16:
            if (r0.isEmpty() == false) goto L19;
            LegacyTimerApiImpl.access$getListenerWrappers$p(this.f17850c).remove(this.f17851d, r0);
        L19:
            return x.f38692a;
        L11:
            return x.f38692a;
        L7:
            return x.f38692a;
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: LegacyTimerApiImpl.kt */
    @d.c.b.a.f(b = "LegacyTimerApiImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.spi.LegacyTimerApiImpl$updateTimerTask$2")
    static final class p extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super TimerTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LegacyTimerApiImpl f17854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TimerTask f17855d;

        p(LegacyTimerApiImpl r3, TimerTask r4, d.c.d<? super p> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17854c = r3;
            this.f17855d = r4;
            super(2, r6);
        }

        public final Object a(String r3, d.c.d<? super TimerTaskResult> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            p r0 = new p(this.f17854c, this.f17855d, r6);
            r0.f17853b = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(String r3, d.c.d<? super TimerTaskResult> r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f17852a != 0) goto L10;
            d.o.a(r3);
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f17853b, String.class, "com.obric.aiagent.plugin");
            String r5 = LegacyTimerApiImpl.access$enabledPackageOrNull(this.f17854c, "updateTimerTask", r4);
            if (r5 == null) goto L7;
            TimerTask r2 = this.f17855d;
            return com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a.b(r2, r5);
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public LegacyTimerApiImpl() {
        this.listenerWrappers = new ConcurrentHashMap();
    }

    public static final /* synthetic */ Object access$disabled(LegacyTimerApiImpl r0, String r1) {
        return r0.disabled(r1);
    }

    public static final /* synthetic */ String access$enabledPackageOrNull(LegacyTimerApiImpl r0, String r1, String r2) {
        return r0.enabledPackageOrNull(r1, r2);
    }

    public static final /* synthetic */ ConcurrentHashMap access$getListenerWrappers$p(LegacyTimerApiImpl r0) {
        return r0.listenerWrappers;
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object addTimerTask(TimerTask r4, d.c.d<? super TimerTaskResult> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object updateTimerTask(TimerTask r4, d.c.d<? super TimerTaskResult> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new p(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object removeTimerTasksByTaskId(List<Integer> r4, d.c.d<? super TimerTaskResult> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new m(this, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object removeTimerTask(Map<Object, ? extends Object> r3, d.c.d<? super TimerTaskResult> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new k(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object skipTimerTasksByTaskId(int r4, long[] r5, d.c.d<? super TimerTaskResult> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new n(this, r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object getTimerTaskByTaskId(int r4, d.c.d<? super TimerTask> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object getTimerTasks(Map<Object, ? extends Object> r4, d.c.d<? super List<TimerTask>> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object getAllTimerTasks(d.c.d<? super List<TimerTask>> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object getNextScheduleTimestamp(int r3, d.c.d<? super Long> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r2);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object getAllTimerTaskRecords(long r10, long r12, d.c.d<? super List<TimerTaskRecord>> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r10, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r15);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object getTimerTaskRecordsByTaskId(long r12, long r14, int r16, d.c.d<? super List<TimerTaskRecord>> r17) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, r16, r12, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r0);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object removeTimerTaskRecordsById(int[] r3, d.c.d<? super Integer> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new l(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r2);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object removeAllTimerTaskRecords(d.c.d<? super Integer> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new j(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object registerTimerTaskChangeListener(com.obric.eventkit.task.api.a r4, d.c.d<? super x> r5) {
        com.obric.eventkit.task.api.a r6 = (com.obric.eventkit.task.api.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.eventkit.task.api.a.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r3 = com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new i(this, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
        if (r3 != d.c.a.b.a()) goto L6;
        return r3;
    L6:
        return x.f38692a;
    }

    @Override // com.obric.eventkit.task.api.ILegacyTimerApi
    public Object unregisterTimerTaskChangeListener(com.obric.eventkit.task.api.a r4, d.c.d<? super x> r5) {
        com.obric.eventkit.task.api.a r6 = (com.obric.eventkit.task.api.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.eventkit.task.api.a.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r3 = com.obric.aiagent.executionengine.eventstaskmanager.spi.a.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new o(this, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
        if (r3 != d.c.a.b.a()) goto L6;
        return r3;
    L6:
        return x.f38692a;
    }

    private final String enabledPackageOrNull(String r1, String r2) {
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.d.f16682a.a() == true) goto L6;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, r1 + " not enable");
        return null;
    L6:
        return r2;
    }

    private final <T> T disabled(String r2) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, r2 + " not enable");
        return null;
    }
}
