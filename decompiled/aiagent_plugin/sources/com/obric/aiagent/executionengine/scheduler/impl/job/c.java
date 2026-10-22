package com.obric.aiagent.executionengine.scheduler.impl.job;

import android.app.Application;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.obric.aiagent.executionengine.capabilitymanager.api.publish.IRegistrationManagerApi;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.AppAction;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.coroutines.am;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: BaseJob.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.obric.aiagent.executionengine.scheduler.impl.a.e.b {
    private static final String TAG = "BaseJob";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18462a = null;
    private static final String[] u = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, JsonObject> f18464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f18465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f18466e;
    private final CopyOnWriteArrayList<b> f;
    private final ConcurrentHashMap.KeySetView<String, Boolean> g;
    private final IMAppAction h;
    private final ConcurrentHashMap<String, kotlinx.coroutines.a.d<IMAppAction>> i;
    private final ConcurrentHashMap<String, kotlinx.coroutines.a.d<C0383c>> j;
    private d k;
    private long l;
    private long m;
    private long n;
    private final com.obric.aiagent.executionengine.scheduler.impl.a.c<com.obric.aiagent.executionengine.scheduler.impl.a.e> o;
    private final ArrayList<IMAppAction> p;
    private final ConcurrentHashMap<Long, com.obric.aiagent.executionengine.scheduler.impl.a.e> q;
    private d.h.a.a<x> r;
    private int s;
    private String t;

    /* JADX INFO: compiled from: BaseJob.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: BaseJob.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppAction f18467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C0383c f18468b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f18467a, r6.f18467a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f18468b, r6.f18468b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f18467a.hashCode() * 31) + this.f18468b.hashCode();
        }

        public String toString() {
            return "IntentExecutionRecordInternal(request=" + this.f18467a + ", result=" + this.f18468b + ')';
        }

        public b(AppAction r2, C0383c r3) {
            o.e(r2, Ext.KEY_REQUEST);
            o.e(r3, "result");
            this.f18467a = r2;
            this.f18468b = r3;
        }

        public final AppAction a() {
            return this.f18467a;
        }

        public final C0383c b() {
            return this.f18468b;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.job.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseJob.kt */
    public static final class C0383c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntentResult<?> f18469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IMAppAction f18470b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0383c.class) == true) goto L8;
            return false;
        L8:
            C0383c r6 = (C0383c) ZeusTransformUtils.preCheckCast(r5, C0383c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f18469a, r6.f18469a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f18470b, r6.f18470b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            IntentResult<?> r0 = this.f18469a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f18470b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "IntentResultWrapper(intentResult=" + this.f18469a + ", oldResult=" + this.f18470b + ')';
        }

        public C0383c(IntentResult<?> r2, IMAppAction r3) {
            o.e(r3, "oldResult");
            this.f18469a = r2;
            this.f18470b = r3;
        }

        public final IntentResult<?> a() {
            return this.f18469a;
        }

        public final IMAppAction b() {
            return this.f18470b;
        }
    }

    /* JADX INFO: compiled from: BaseJob.kt */
    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f18471a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f18472b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f18473c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f18474d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d[] f18475e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ d[] b() {
            return new d[]{f18471a, f18472b, f18473c, f18474d};
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f18471a = new d("INIT", 0);
            f18472b = new d("PREPARED", 1);
            f18473c = new d("SCHEDULED", 2);
            f18474d = new d("FINISHED", 3);
            d[] r0 = b();
            f18475e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public final d a() {
            d[] r0 = values();
            return r0[(ordinal() + 1) % r0.length];
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f18475e.clone(), d[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: BaseJob.kt */
    @d.c.b.a.f(b = "BaseJob.kt", c = {112}, d = "doJob", e = "com.obric.aiagent.executionengine.scheduler.impl.job.BaseJob")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f18477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f18478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18479d;

        e(c r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18478c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18477b = r3;
            this.f18479d |= Integer.MIN_VALUE;
            return this.f18478c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: BaseJob.kt */
    @d.c.b.a.f(b = "BaseJob.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.job.BaseJob$onStateChanged$1")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f18481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.executionengine.scheduler.impl.a.e f18482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.executionengine.scheduler.impl.a.e.a f18483d;

        f(c r3, com.obric.aiagent.executionengine.scheduler.impl.a.e r4, com.obric.aiagent.executionengine.scheduler.impl.a.e.a r5, d.c.d<? super f> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18481b = r3;
            this.f18482c = r4;
            this.f18483d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f18481b, this.f18482c, this.f18483d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f18480a != 0) goto L30;
            d.o.a(r6);
            com.obric.aiagent.executionengine.scheduler.impl.a.e r7 = (com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(c.a(this.f18481b).get(d.c.b.a.b.a(this.f18482c.k())), com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L7;
            String r8 = r7.e();
        L8:
            ISecureLogDepend.Companion.i(c.TAG, "onStateChanged: action=" + this.f18482c + ", operationId=" + r8 + ", newState=" + this.f18483d);
            if (this.f18483d != com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18067d) goto L11;
        L12:
            IMAppAction r9 = this.f18482c.l();
            if (r9 == null) goto L15;
            c r0 = this.f18481b;
            c.c(r0).add(r9);
            c.a(r0, r9);
        L15:
            boolean r10 = true;
            Iterator r1 = c.a(this.f18481b).values().iterator();
        L17:
            if (r1.hasNext() == false) goto L23;
            Object r3 = r1.next();
            o.c(r3, "next(...)");
            com.obric.aiagent.executionengine.scheduler.impl.a.e.a r4 = ((com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin")).g();
            if (r4 == com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18067d) goto L17;
            if (r4 == com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18068e) goto L17;
            r10 = false;
        L23:
            if (r10 == false) goto L28;
            ILogDepend.Companion.d(c.TAG, "actions in a job are done!");
            d.h.a.a r5 = c.b(this.f18481b);
            if (r5 == null) goto L28;
            r5.invoke();
        L28:
            return x.f38692a;
        L11:
            if (this.f18483d != com.obric.aiagent.executionengine.scheduler.impl.a.e.a.f18068e) goto L28;
        L7:
            r8 = null;
            goto L8
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: BaseJob.kt */
    @d.c.b.a.f(b = "BaseJob.kt", c = {147, 504}, d = "scheduleActions", e = "com.obric.aiagent.executionengine.scheduler.impl.job.BaseJob")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f18485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f18486c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18487d;

        g(c r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18486c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18485b = r3;
            this.f18487d |= Integer.MIN_VALUE;
            return c.a(this.f18486c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: BaseJob.kt */
    static final class h implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<x> f18488a;

        h(n<? super x> r3) {
            this.f18488a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            if (this.f18488a.a() == false) goto L6;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f18488a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r0 = d.n.f38560a;
            r2.resumeWith(d.n.f(x.f38692a));
            return;
        }
    }

    public c(IMAppAction r3, boolean r4, Map<String, JsonObject> r5, int r6, String r7) {
        Map<String, JsonObject> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "action");
        o.e(r8, "outputOwnerMap");
        this.f18463b = r4;
        this.f18464c = r8;
        this.f18465d = r6;
        this.f18466e = r7;
        this.f = new CopyOnWriteArrayList();
        this.g = ConcurrentHashMap.newKeySet();
        this.i = new ConcurrentHashMap();
        this.j = new ConcurrentHashMap();
        this.k = d.f18471a;
        this.n = hashCode() & Integer.MAX_VALUE;
        this.o = new com.obric.aiagent.executionengine.scheduler.impl.a.c();
        this.p = new ArrayList();
        this.q = new ConcurrentHashMap();
        this.h = r3;
        Long r9 = r3.getMessageId();
        o.a(r9);
        this.l = r9.longValue();
        Long r10 = r3.getQuestionId();
        o.a(r10);
        this.m = r10.longValue();
        this.k = this.k.a();
    }

    public /* synthetic */ c(IMAppAction r7, boolean r8, Map r9, int r10, String r11, int r12, d.h.b.h r13) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        if ((r12 & 2) == 0) goto L5;
        r8 = true;
    L5:
        boolean r2 = r8;
        if ((r12 & 8) == 0) goto L8;
        r10 = 3;
    L8:
        int r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        r11 = null;
    L11:
        this(r7, r2, r3, r4, r11);
    }

    public static final /* synthetic */ Object a(c r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ConcurrentHashMap a(c r0) {
        return r0.q;
    }

    public static final /* synthetic */ void a(c r0, IMAppAction r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(c r2, d.h.a.a r3) {
        r2.r = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ d.h.a.a b(c r0) {
        return r0.r;
    }

    public static final /* synthetic */ ArrayList c(c r0) {
        return r0.p;
    }

    public final void a(String r1) {
        this.f18466e = r1;
    }

    static {
        f18462a = new a(null);
        u = new String[]{"nlgForPCSearch"};
    }

    public final CopyOnWriteArrayList<b> a() {
        return this.f;
    }

    public final IMAppAction b() {
        return this.h;
    }

    public final long c() {
        return this.l;
    }

    public final long d() {
        return this.m;
    }

    public final long e() {
        return this.n;
    }

    public final void b(String r1) {
        this.t = r1;
    }

    public final String f() {
        return this.t;
    }

    public final d g() {
        return this.k;
    }

    public final boolean c(String r5) {
        if (r5 == null) goto L13;
        boolean r1 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
    L8:
        r1 = false;
    L9:
        if (r1 == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L13;
    L15:
        return this.g.add(this.n + ':' + r5);
    L6:
        if (o.a(r5, "null") == true) goto L8;
    L13:
        r5 = "missing";
        goto L15
    }

    public final Object a(d.c.d<? super IMAppAction> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r12, e.class, "com.obric.aiagent.plugin");
        if ((r0.f18479d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18479d -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f18477b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f18479d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        c this = (c) ZeusTransformUtils.preCheckCast(r0.f18476a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L17:
        IMAppAction r14 = (IMAppAction) ZeusTransformUtils.preCheckCast(r13, IMAppAction.class, "com.obric.aiagent.plugin");
        this.k = this.k.a();
        if (this.f18465d < 3) goto L20;
        JobResult r1 = this.a((List) ZeusTransformUtils.preCheckCast(this.f, List.class, "com.obric.aiagent.plugin"), r14);
    L21:
        com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.a(this.h, r14, this.f18463b, this.n, r1, this.f18466e);
        Collection<com.obric.aiagent.executionengine.scheduler.impl.a.e> r4 = this.q.values();
        o.c(r4, "<get-values>(...)");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L23:
        if (r5.hasNext() == false) goto L25;
        ((com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin")).b((com.obric.aiagent.executionengine.scheduler.impl.a.e.b) ZeusTransformUtils.preCheckCast(this, com.obric.aiagent.executionengine.scheduler.impl.a.e.b.class, "com.obric.aiagent.plugin"));
        goto L23
    L25:
        return r14;
    L20:
        r1 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        this.k = this.k.a();
        r0.f18476a = this;
        r0.f18479d = 1;
        r13 = b(r0);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new e(this, r12);
        goto L8
    }

    public final Object a(IMAppAction r5, d.c.d<? super x> r6) {
        d.c.d<? super x> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "receiveActionResultFromClient " + r5);
        kotlinx.coroutines.a.d r4 = (kotlinx.coroutines.a.d) ZeusTransformUtils.preCheckCast(this.i.get(String.valueOf(r5.getActionId())), kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        Object r8 = r4.a(r5, r7);
        if (r8 != d.c.a.b.a()) goto L8;
        return r8;
    L8:
        return x.f38692a;
    L10:
        return x.f38692a;
    }

    public final Object a(IntentResult<?> r5, IMAppAction r6, d.c.d<? super x> r7) {
        d.c.d<? super x> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion.i(TAG, "dispatchIntentResultFromClient " + r5);
        kotlinx.coroutines.a.d r4 = (kotlinx.coroutines.a.d) ZeusTransformUtils.preCheckCast(this.j.get(String.valueOf(r6.getActionId())), kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        Object r9 = r4.a(new C0383c(r5, r6), r8);
        if (r9 != d.c.a.b.a()) goto L8;
        return r9;
    L8:
        return x.f38692a;
    L10:
        return x.f38692a;
    }

    private final Object b(d.c.d<? super IMAppAction> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, g.class) == false) goto L7;
        g r1 = (g) ZeusTransformUtils.preCheckCast(r10, g.class, "com.obric.aiagent.plugin");
        if ((r1.f18487d & Integer.MIN_VALUE) == 0) goto L7;
        r1.f18487d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r1.f18485b;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f18487d;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        c this = (c) ZeusTransformUtils.preCheckCast(r1.f18484a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L26:
        ILogDepend.Companion.i(TAG, "scheduleActions end");
    L27:
        ILogDepend.Companion.d(TAG, "****** actions' execute results ******");
        ILogDepend.Companion.d(TAG, "actionId   packageName   operationId   state");
        Collection<com.obric.aiagent.executionengine.scheduler.impl.a.e> r12 = this.q.values();
        o.c(r12, "<get-values>(...)");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L29:
        if (r13.hasNext() == false) goto L31;
        com.obric.aiagent.executionengine.scheduler.impl.a.e r0 = (com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.d(TAG, r0.k() + ' ' + r0.d() + ' ' + r0.e() + ' ' + r0.g());
        goto L29
    L31:
        ILogDepend.Companion.d(TAG, "******************");
        return this.a((List) ZeusTransformUtils.preCheckCast(this.p, List.class, "com.obric.aiagent.plugin"));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        this = (c) ZeusTransformUtils.preCheckCast(r1.f18484a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L20:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L27;
        ILogDepend.Companion.i(TAG, "scheduleActions start");
        r1.f18484a = this;
        r1.f18487d = 2;
        kotlinx.coroutines.o r2 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r1, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r2.e();
        a(this, (d.h.a.a) ZeusTransformUtils.preCheckCast(new h((n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.aiagent.plugin")), d.h.a.a.class, "com.obric.aiagent.plugin"));
        Object r14 = r2.h();
        if (r14 != d.c.a.b.a()) goto L24;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r1, d.c.d.class, "com.obric.aiagent.plugin"));
    L24:
        if (r14 != r3) goto L26;
        return r3;
    L16:
        d.o.a(r11);
        com.obric.aiagent.executionengine.scheduler.impl.a.h r15 = com.obric.aiagent.executionengine.scheduler.impl.a.h.f18120a;
        com.obric.aiagent.executionengine.scheduler.impl.a.c<com.obric.aiagent.executionengine.scheduler.impl.a.e> r5 = this.o;
        r1.f18484a = this;
        r1.f18487d = 1;
        r11 = r15.a(r5, r1);
        if (r11 != r3) goto L20;
        return r3;
    L7:
        r1 = new g(this, r10);
        goto L8
    }

    private final IMAppAction a(List<IMAppAction> r24) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        IMAppAction r3 = IMAppAction.copy$default((IMAppAction) ZeusTransformUtils.preCheckCast(p.k(r1), IMAppAction.class, "com.obric.aiagent.plugin"), 0, null, null, 0, null, null, null, null, 0, 0, 0, null, 4095, null);
        r3.setReplyId(this.l);
        r3.setMessageId(Long.valueOf(this.l));
        r3.setQuestionId(Long.valueOf(this.m));
        int r0 = ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).size();
        int r4 = 0;
        int r7 = 0;
        String r8 = "";
        int r5 = 0;
    L3:
        String r6 = null;
        if (r4 >= r0) goto L29;
        IMAppAction r9 = (IMAppAction) ZeusTransformUtils.preCheckCast(r1.get(r4), IMAppAction.class, "com.obric.aiagent.plugin");
        FeedbackResult r10 = (FeedbackResult) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.utils.e.a().fromJson(r9.getContent(), FeedbackResult.class), FeedbackResult.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L27;
        String r11 = r10.getMsg();
        IMAppActionExt r12 = r9.getExt();
        if (r12 == null) goto L11;
        r6 = (String) ZeusTransformUtils.preCheckCast(r12.get("_action_customized_result_string"), String.class, "com.obric.aiagent.plugin");
    L11:
        if (r6 == null) goto L14;
        r11 = r6;
    L14:
        if (com.obric.aiagent.executionengine.utils.c.a(r11) == false) goto L17;
        r8 = r8 + r11;
    L17:
        if (r1.size() > 1) goto L19;
    L23:
        int r13 = r10.getCode();
        if (r13 == 0) goto L26;
        r7 = r13;
    L26:
        r5 = r5 | r10.getUiType();
        goto L27
    L19:
        if (r4 >= (r1.size() - 1)) goto L23;
        if (com.obric.aiagent.executionengine.utils.c.a(r11) == false) goto L23;
        r8 = r8 + '\n';
    L27:
        r4 = r4 + 1;
        goto L3
    L29:
        if ((4194304 & r5) == 0) goto L31;
        ILogDepend.Companion.d(TAG, "summaryResult: uiTypeTotal contains FLAG_NO_FEEDBACK (" + Integer.toBinaryString(r5) + "); removing FLAG_MSG");
        r5 = r5 & (-2);
    L31:
        IMAppActionExt r2 = r3.getExt();
        if (r2 != null) goto L35;
        r2 = new IMAppActionExt();
        r3.setExt(r2);
    L35:
        if (r2.containsKey("app_cost") == true) goto L48;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r14.iterator();
    L38:
        if (r16.hasNext() == false) goto L47;
        IMAppActionExt r17 = ((IMAppAction) ZeusTransformUtils.preCheckCast(r16.next(), IMAppAction.class, "com.obric.aiagent.plugin")).getExt();
        if (r17 == null) goto L44;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.get("app_cost"), String.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L44;
        Long r19 = Long.valueOf(Long.parseLong(r18));
    L45:
        if (r19 == null) goto L38;
        r15.add(r19);
    L44:
        r19 = null;
        goto L45
    L47:
        long r110 = p.C((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")).put("app_cost", String.valueOf(r110));
        ILogDepend.Companion.i(TAG, "summaryResult: allActionCost=" + r110);
    L48:
        String r20 = new Gson().toJson(new FeedbackResult(r7, r8, null, r5, null, false, 52, null));
        r3.setContent(r20);
        ISecureLogDepend.Companion.i(TAG, "summaryResult: " + r20 + "; uiTypeTotal=" + Integer.toBinaryString(r5));
        return r3;
    }

    private final JobResult a(List<b> r23, IMAppAction r24) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
        boolean r6 = false;
        boolean r9 = false;
    L3:
        Object r7 = null;
        boolean r8 = true;
        if (r5.hasNext() == false) goto L18;
        b r10 = (b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin");
        IntentResult<?> r15 = r10.b().a();
        if (r15 != null) goto L9;
    L16:
        if (r7 == null) goto L3;
        r4.add(r7);
        goto L3
    L9:
        if (r15.getRet() != 0) goto L12;
        r8 = false;
    L12:
        r9 = r9 | r8;
        String r12 = r10.a().getAction();
        String r13 = r10.a().getPackageName();
        String r11 = r10.a().getImplClassName();
        if (r11 != null) goto L15;
        r11 = "";
    L15:
        r7 = new IntentExecutionRecord(r12, r13, r11, r15, false);
        goto L16
    L18:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        if (r14.isEmpty() == false) goto L43;
        ILogDepend.Companion.e(TAG, "no IntentResult found for summaryIntents; execRecord = " + r0 + "; resulting IntentExecutionRecord may be incomplete!");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L23
        Object r2 = d.n.f((FeedbackResult) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.utils.e.a().fromJson(r24.getContent(), FeedbackResult.class), FeedbackResult.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
    L26:
        if (d.n.b(r2) == true) goto L29;
        r7 = r2;
    L29:
        FeedbackResult r16 = (FeedbackResult) ZeusTransformUtils.preCheckCast(r7, FeedbackResult.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L32;
        int r17 = r16.getCode();
    L33:
        if (r16 == null) goto L36;
        String r18 = r16.getMsg();
        if (r18 == null) goto L36;
    L37:
        long r19 = this.m;
        if (r17 == 0) goto L41;
        r6 = true;
    L41:
        return new JobResult(r19, r6, r18, p.a(new IntentExecutionRecord("", "", "", new IntentResult(r17, null, null, r18, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null), false)));
    L36:
        r18 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_failed"));
        o.c(r18, "getString(...)");
        goto L37
    L32:
        r17 = 1;
    L23:
        th = move-exception;
        d.n.a r20 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L26
    L43:
        if (r14.size() != 1) goto L46;
        String r21 = a((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(p.k(r14), IntentExecutionRecord.class, "com.obric.aiagent.plugin"));
    L52:
        return new JobResult(this.m, r9, r21, r14);
    L46:
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r22, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r26 = r22.iterator();
    L48:
        if (r26.hasNext() == false) goto L50;
        IntentExecutionRecord r27 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r26.next(), IntentExecutionRecord.class, "com.obric.aiagent.plugin");
        r25.add(r27.getIntentName() + ": " + a(r27));
        goto L48
    L50:
        r21 = p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
        goto L52
    }

    private static final String a(IntentExecutionRecord r4) {
        if (r4.getResult().getRet() != 0) goto L8;
        String r5 = r4.getResult().getDetails();
        if (r5 != null) goto L12;
        String r6 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_success"));
        o.c(r6, "getString(...)");
        return r6;
    L12:
        return r5;
    L8:
        String r7 = r4.getResult().getDetails();
        if (r7 != null) goto L13;
        String r8 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_failed"));
        o.c(r8, "getString(...)");
        return r8;
    L13:
        return r7;
    }

    private final void a(IMAppAction r6) {
        if (r6.getContent() == null) goto L11;
        FeedbackResult r5 = (FeedbackResult) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.utils.e.a().fromJson(r6.getContent(), FeedbackResult.class), FeedbackResult.class, "com.obric.aiagent.plugin");
        String r7 = r5.getMsg();
        int r1 = r5.getCode();
        boolean r8 = r5.getShouldNotify();
        ISecureLogDepend.Companion.i(TAG, "notifyResult: code=" + r1 + ", msg=" + r7 + ", shouldNotify=" + r8);
        if (r8 == true) goto L7;
        return;
    L7:
        IRegistrationManagerApi r9 = (IRegistrationManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IRegistrationManagerApi.class), IRegistrationManagerApi.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L12;
        r9.notifyResult(r1, r7);
        return;
    L12:
        return;
    }

    public final kotlinx.coroutines.a.d<IMAppAction> a(long r4) {
        ILogDepend.Companion.d(TAG, "addActionCallback, actionId=" + r4);
        kotlinx.coroutines.a.d<IMAppAction> r0 = kotlinx.coroutines.a.g.a(0, null, null, 7, null);
        ((Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.aiagent.plugin")).put(String.valueOf(r4), r0);
        return r0;
    }

    public final kotlinx.coroutines.a.d<C0383c> b(long r4) {
        ILogDepend.Companion.d(TAG, "addIntentCallback, actionId=" + r4);
        kotlinx.coroutines.a.d<C0383c> r0 = kotlinx.coroutines.a.g.a(0, null, null, 7, null);
        ((Map) ZeusTransformUtils.preCheckCast(this.j, Map.class, "com.obric.aiagent.plugin")).put(String.valueOf(r4), r0);
        return r0;
    }

    public final void c(long r4) {
        ILogDepend.Companion.d(TAG, "removeActionCallback, actionId=" + r4);
        this.i.remove(String.valueOf(r4));
    }

    public final void d(long r4) {
        ILogDepend.Companion.d(TAG, "removeIntentCallback, actionId=" + r4);
        this.j.remove(String.valueOf(r4));
    }

    public final boolean h() {
        if (this.s != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void a(int r2) {
        if ((this.s & r2) != r2) goto L6;
        this.s = 0;
        return;
    }

    public final void b(int r2) {
        this.s = r2 | this.s;
    }

    public final void a(com.obric.aiagent.executionengine.scheduler.impl.a.e r6) {
        o.e(r6, "action");
        this.o.a(r6);
        ((Map) ZeusTransformUtils.preCheckCast(this.q, Map.class, "com.obric.aiagent.plugin")).put(Long.valueOf(r6.k()), r6);
        r6.a((com.obric.aiagent.executionengine.scheduler.impl.a.e.b) ZeusTransformUtils.preCheckCast(this, com.obric.aiagent.executionengine.scheduler.impl.a.e.b.class, "com.obric.aiagent.plugin"));
    }

    public final void a(com.obric.aiagent.executionengine.scheduler.impl.a.e r2, com.obric.aiagent.executionengine.scheduler.impl.a.e r3) {
        o.e(r2, "node");
        o.e(r3, "incomingEdge");
        this.o.a(r2, r3);
    }

    public final com.obric.aiagent.executionengine.scheduler.impl.a.c<com.obric.aiagent.executionengine.scheduler.impl.a.e> i() {
        return this.o;
    }

    public final ConcurrentMap<Long, com.obric.aiagent.executionengine.scheduler.impl.a.e> j() {
        return (ConcurrentMap) ZeusTransformUtils.preCheckCast(this.q, ConcurrentMap.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.a.e.b
    public void a(com.obric.aiagent.executionengine.scheduler.impl.a.e r8, com.obric.aiagent.executionengine.scheduler.impl.a.e.a r9) {
        o.e(r8, "action");
        o.e(r9, "newState");
        kotlinx.coroutines.i.a(com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.c(), null, null, (m) ZeusTransformUtils.preCheckCast(new f(this, r8, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public String toString() {
        return "BaseJob(" + Integer.toHexString(hashCode()) + ", jobId=" + this.n + ", requiredConstraints=" + this.s + ", state=" + this.k + ')';
    }

    public final List<String> k() {
        String[] r0 = u;
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L15;
        String r5 = r0[r4];
        IMAppActionExt r6 = this.h.getExt();
        String r7 = null;
        if (r6 == null) goto L7;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.get(r5), String.class, "com.obric.aiagent.plugin");
    L9:
        if (com.obric.aiagent.executionengine.utils.c.a(r8) == false) goto L11;
        r7 = r8;
    L11:
        if (r7 == null) goto L13;
        r1.add(r7);
    L13:
        r4 = r4 + 1;
        goto L3
    L7:
        r8 = null;
        goto L9
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    }

    public final void l() {
        Iterator<com.obric.aiagent.executionengine.scheduler.impl.a.e> r0 = this.q.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.obric.aiagent.executionengine.scheduler.impl.a.e r1 = r0.next();
        o.c(r1, "next(...)");
        b((com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    private final void b(com.obric.aiagent.executionengine.scheduler.impl.a.e r3) {
        Bundle r2 = new Bundle();
        r2.putString("intentName", r3.e());
        r2.putString("packageName", r3.d());
        r2.putBoolean("isIntent", r3.c());
        ILogDepend.Companion.i(TAG, "notifyActionDetails (Bundled); bundledResult=" + r2);
        IRegistrationManagerApi r4 = (IRegistrationManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IRegistrationManagerApi.class), IRegistrationManagerApi.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        r4.notifyResultBundled(r2);
        return;
    }
}
