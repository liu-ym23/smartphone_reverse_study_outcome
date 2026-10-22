package com.obric.aiagent.executionengine.scheduler.impl.c;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: EventManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.obric.aiagent.executionengine.scheduler.impl.c.c {
    private static final String TAG = "EventManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18362a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.scheduler.impl.c.d f18363b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final androidx.b.a<Long, C0381b> f18364c = null;

    /* JADX INFO: compiled from: EventManager.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.executionengine.scheduler.api.b f18365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JsonObject f18366b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f18365a == r6.f18365a) goto L12;
            return false;
        L12:
            if (o.a(this.f18366b, r6.f18366b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f18365a.hashCode() * 31;
            JsonObject r1 = this.f18366b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "EventInfo(type=" + this.f18365a + ", params=" + this.f18366b + ')';
        }

        public a(com.obric.aiagent.executionengine.scheduler.api.b r2, JsonObject r3) {
            o.e(r2, "type");
            this.f18365a = r2;
            this.f18366b = r3;
        }

        public final com.obric.aiagent.executionengine.scheduler.api.b getType() {
            return this.f18365a;
        }

        public final JsonObject a() {
            return this.f18366b;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EventManager.kt */
    public static final class C0381b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f18367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<Integer> f18368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private androidx.b.a<Long, a> f18369c;

        public C0381b() {
            this(0, null, null, 7, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0381b.class) == true) goto L8;
            return false;
        L8:
            C0381b r6 = (C0381b) ZeusTransformUtils.preCheckCast(r5, C0381b.class, "com.obric.aiagent.plugin");
            if (this.f18367a == r6.f18367a) goto L12;
            return false;
        L12:
            if (o.a(this.f18368b, r6.f18368b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f18369c, r6.f18369c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f18367a) * 31) + this.f18368b.hashCode()) * 31) + this.f18369c.hashCode();
        }

        public String toString() {
            return "EventsContraints(eventCounts=" + this.f18367a + ", constraintList=" + this.f18368b + ", eventInfoMap=" + this.f18369c + ')';
        }

        public C0381b(int r2, ArrayList<Integer> r3, androidx.b.a<Long, a> r4) {
            o.e(r3, "constraintList");
            o.e(r4, "eventInfoMap");
            this.f18367a = r2;
            this.f18368b = r3;
            this.f18369c = r4;
        }

        public final int a() {
            return this.f18367a;
        }

        public final void a(int r1) {
            this.f18367a = r1;
        }

        public /* synthetic */ C0381b(int r1, ArrayList r2, androidx.b.a r3, int r4, h r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = 0;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = new ArrayList();
        L9:
            if ((r4 & 4) == 0) goto L11;
            r3 = new androidx.b.a();
        L11:
            this(r1, r2, r3);
        }

        public final ArrayList<Integer> b() {
            return this.f18368b;
        }

        public final androidx.b.a<Long, a> c() {
            return this.f18369c;
        }
    }

    /* JADX INFO: compiled from: EventManager.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18370a = null;

        static {
            int[] r0 = new int[com.obric.aiagent.executionengine.scheduler.api.b.values().length];
            r0[com.obric.aiagent.executionengine.scheduler.api.b.f17955b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[com.obric.aiagent.executionengine.scheduler.api.b.f17956c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[com.obric.aiagent.executionengine.scheduler.api.b.f17957d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f18370a = r0;
        }
    }

    /* JADX INFO: compiled from: EventManager.kt */
    @f(b = "EventManager.kt", c = {78}, d = "mockJobIfLastEventInAJob", e = "com.obric.aiagent.executionengine.scheduler.impl.event.EventManager")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18374d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f18375e;
        final /* synthetic */ b f;
        int g;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18375e = r3;
            this.g |= Integer.MIN_VALUE;
            return b.a(this.f, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventManager.kt */
    @f(b = "EventManager.kt", c = {49}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.event.EventManager$registerEvent$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.executionengine.scheduler.api.b f18377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.executionengine.scheduler.api.a f18378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsonObject f18379d;

        e(com.obric.aiagent.executionengine.scheduler.api.b r3, com.obric.aiagent.executionengine.scheduler.api.a r4, JsonObject r5, d.c.d<? super e> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18377b = r3;
            this.f18378c = r4;
            this.f18379d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f18377b, this.f18378c, this.f18379d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18376a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            b r9 = b.f18362a;
            com.obric.aiagent.executionengine.scheduler.api.b r2 = this.f18377b;
            com.obric.aiagent.executionengine.scheduler.api.a r3 = this.f18378c;
            JsonObject r4 = this.f18379d;
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18376a = 1;
            if (b.a(r9, r2, r3, r4, r5) != r0) goto L12;
            return r0;
        }
    }

    private b() {
    }

    public static final /* synthetic */ Object a(b r2, com.obric.aiagent.executionengine.scheduler.api.b r3, com.obric.aiagent.executionengine.scheduler.api.a r4, JsonObject r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        b r0 = new b();
        f18362a = r0;
        f18363b = new com.obric.aiagent.executionengine.scheduler.impl.c.d((com.obric.aiagent.executionengine.scheduler.impl.c.c) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.executionengine.scheduler.impl.c.c.class, "com.obric.aiagent.plugin"));
        f18364c = new androidx.b.a();
    }

    public final synchronized boolean a(com.obric.aiagent.executionengine.scheduler.api.b r10, com.obric.aiagent.executionengine.scheduler.api.a r11) {
        monitor-enter(this);
        o.e(r10, "type");     // Catch: Throwable -> L17
        o.e(r11, "eventInfo");     // Catch: Throwable -> L17
        JsonObject r0 = new JsonObject();     // Catch: Throwable -> L17
        int r1 = c.f18370a[r10.ordinal()];     // Catch: Throwable -> L17
        if (r1 != 1) goto L6;
        r0.addProperty("time", (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.aiagent.executionengine.scheduler.api.c) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.executionengine.scheduler.api.c.class, "com.obric.aiagent.plugin")).e()), Number.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L17
    L14:
        i.a(com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new e(r10, r11, r0, null), m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    L6:
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L14;
        Logger.INSTANCE.e(TAG, "unsupported type!");     // Catch: Throwable -> L17
        monitor-exit(this);
        return false;
    L17:
        th = move-exception;
        throw th;
    }

    private final Object a(com.obric.aiagent.executionengine.scheduler.api.b r23, com.obric.aiagent.executionengine.scheduler.api.a r24, JsonObject r25, d.c.d<? super x> r26) {
        b r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L7;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if ((r4.g & Integer.MIN_VALUE) == 0) goto L7;
        r4.g -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f18375e;
        Object r5 = d.c.a.b.a();
        int r6 = r4.g;
        String r7 = ", todoActions=";
        String r8 = TAG;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        ArrayList<Integer> r1 = (ArrayList) ZeusTransformUtils.preCheckCast(r4.f18374d, ArrayList.class, "com.obric.aiagent.plugin");
        C0381b r9 = (C0381b) ZeusTransformUtils.preCheckCast(r4.f18373c, C0381b.class, "com.obric.aiagent.plugin");
        JsonArray r10 = (JsonArray) ZeusTransformUtils.preCheckCast(r4.f18372b, JsonArray.class, "com.obric.aiagent.plugin");
        b r11 = (b) ZeusTransformUtils.preCheckCast(r4.f18371a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        C0381b r12 = r9;
        r7 = ", todoActions=";
        r8 = TAG;
        ArrayList<Integer> r13 = r1;
        r0 = r11;
    L28:
        long r14 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r14 == (-1)) goto L37;
        Logger.INSTANCE.i(r8, "append a new job: jobId=" + r14 + r7 + r10 + ", constraintList=" + r13);
        Iterator<a> r15 = r12.c().values().iterator();
    L32:
        if (r15.hasNext() == false) goto L37;
        a r16 = (a) ZeusTransformUtils.preCheckCast(r15.next(), a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.scheduler.impl.c.a r17 = r0.a(r16.getType());
        if (r17 == null) goto L32;
        r17.a(r14, r16.a());
    L37:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        JsonArray r18 = r24.a();
        if (r18 == null) goto L17;
        long r19 = r24.b();
        long r110 = r24.c();
        int r111 = r24.d();
        Logger.INSTANCE.i(TAG, "mockJobIfLastEventInAJob: originalJobId=" + r19 + ", todoActions=" + r18 + ", eventId=" + r110 + ", eventCounts=" + r111 + ", type=" + r23);
        androidx.b.a<Long, C0381b> r20 = f18364c;
        if (r20.containsKey(d.c.b.a.b.a(r19)) == true) goto L22;
        ((Map) ZeusTransformUtils.preCheckCast(r20, Map.class, "com.obric.aiagent.plugin")).put(d.c.b.a.b.a(r19), new C0381b(r111, null, null, 6, null));
    L22:
        r12 = (C0381b) ZeusTransformUtils.preCheckCast(r20.get(d.c.b.a.b.a(r19)), C0381b.class, "com.obric.aiagent.plugin");
        Long r21 = d.c.b.a.b.a(r110);
        o.a(r12);
        ((Map) ZeusTransformUtils.preCheckCast(r12.c(), Map.class, "com.obric.aiagent.plugin")).put(r21, new a(r23, r25));
        r12.b().add(d.c.b.a.b.a(b(r23)));
        r12.a(r12.a() - 1);
        if (r12.a() != 0) goto L37;
        r13 = r12.b();
        com.obric.aiagent.executionengine.scheduler.impl.job.d r22 = com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a;
        List<Integer> r27 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");
        r4.f18371a = r0;
        r4.f18372b = r18;
        r4.f18373c = r12;
        r4.f18374d = r13;
        r4.g = 1;
        Object r28 = r22.a(r18, r27, r4);
        if (r28 != r5) goto L27;
        return r5;
    L27:
        r10 = r18;
        r3 = r28;
        goto L28
    L17:
        return x.f38692a;
    L7:
        r4 = new d(r0, r2);
        goto L8
    }

    private final com.obric.aiagent.executionengine.scheduler.impl.c.a a(com.obric.aiagent.executionengine.scheduler.api.b r2) {
        if (c.f18370a[r2.ordinal()] == 1) goto L7;
        return null;
    L7:
        return (com.obric.aiagent.executionengine.scheduler.impl.c.a) ZeusTransformUtils.preCheckCast(f18363b, com.obric.aiagent.executionengine.scheduler.impl.c.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.c.c
    public synchronized void a(com.obric.aiagent.executionengine.scheduler.api.b r5, long r6) {
        monitor-enter(this);
        o.e(r5, "type");     // Catch: Throwable -> L6
        Logger.INSTANCE.i(TAG, "onEvent: jobId=" + r6 + ", type=" + r5);     // Catch: Throwable -> L6
        com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.a(r6, b(r5));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final int b(com.obric.aiagent.executionengine.scheduler.api.b r1) {
        int r0 = c.f18370a[r1.ordinal()];
        int r2 = 1;
        if (r0 == 1) goto L12;
        r2 = 2;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L10;
        return 0;
    L10:
        return 4;
    L12:
        return r2;
    }
}
