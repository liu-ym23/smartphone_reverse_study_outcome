package com.obric.agent;

import android.content.Context;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.RCSearchParams;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;
import org.json.JSONObject;

/* JADX INFO: compiled from: RealTimeMemoryContextHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u {
    private static final String TAG = "RealTimeMemoryContextHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f15968a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f15969b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ai f15970c = null;

    /* JADX INFO: compiled from: RealTimeMemoryContextHelper.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15971a = null;

        static {
            f15971a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: RealTimeMemoryContextHelper.kt */
    @d.c.b.a.f(b = "RealTimeMemoryContextHelper.kt", c = {127, 128}, d = "appendToSession", e = "com.obric.agent.RealTimeMemoryContextHelper")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f15975d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f15976e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ u h;
        int i;

        b(u r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.g = r7;
            this.i |= Integer.MIN_VALUE;
            return this.h.a(null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: RealTimeMemoryContextHelper.kt */
    @d.c.b.a.f(b = "RealTimeMemoryContextHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.RealTimeMemoryContextHelper$appendToSession$alarmDeferred$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends AppEntity>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15978b;

        c(Context r3, d.c.d<? super c> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15978b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<? extends AppEntity>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f15978b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends AppEntity>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15977a != 0) goto L7;
            d.o.a(r3);
            return u.a(u.f15968a, this.f15978b, true, false);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: RealTimeMemoryContextHelper.kt */
    @d.c.b.a.f(b = "RealTimeMemoryContextHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.RealTimeMemoryContextHelper$appendToSession$recordingDeferred$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends AppEntity>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15980b;

        d(Context r3, d.c.d<? super d> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15980b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<? extends AppEntity>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f15980b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends AppEntity>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15979a != 0) goto L7;
            d.o.a(r3);
            return u.a(u.f15968a, this.f15980b, false, true);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: RealTimeMemoryContextHelper.kt */
    @d.c.b.a.f(b = "RealTimeMemoryContextHelper.kt", c = {39}, d = "awaitOrNull", e = "com.obric.agent.RealTimeMemoryContextHelper")
    static final class e<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f15981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f15982b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f15983c;

        e(u r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15982b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15981a = r3;
            this.f15983c |= Integer.MIN_VALUE;
            return u.a(this.f15982b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: RealTimeMemoryContextHelper.kt */
    @d.c.b.a.f(b = "RealTimeMemoryContextHelper.kt", c = {85, 93}, d = "awaitWithin", e = "com.obric.agent.RealTimeMemoryContextHelper")
    static final class f<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f15984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f15985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f15986c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f15987d;

        f(u r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15986c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            this.f15985b = r4;
            this.f15987d |= Integer.MIN_VALUE;
            return u.a(this.f15986c, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: RealTimeMemoryContextHelper.kt */
    @d.c.b.a.f(b = "RealTimeMemoryContextHelper.kt", c = {94}, d = "invokeSuspend", e = "com.obric.agent.RealTimeMemoryContextHelper$awaitWithin$result$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Object>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ au<T> f15989b;

        g(au<? extends T> r3, d.c.d<? super g> r4) {
            au<T> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15989b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<Object> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f15989b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Object> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15988a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            if (r6 == null) goto L13;
            return r6;
        L13:
            return a.f15971a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            u r7 = u.f15968a;
            au<T> r2 = this.f15989b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15988a = 1;
            r6 = u.a(r7, r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    private u() {
    }

    public static final /* synthetic */ Object a(u r2, au r3, long r4, d.c.d r6) {
        return r2.a((au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(u r2, au r3, d.c.d r4) {
        return r2.a((au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ List a(u r2, Context r3, boolean r4, boolean r5) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    static {
        f15968a = new u();
        f15969b = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        f15970c = bd.c().a(2);
    }

    private final <T> Object a(au<? extends T> r4, d.c.d<? super T> r5) {
        au r6 = (au) ZeusTransformUtils.wrapperContextForParams(r4, au.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.aiagent.plugin");
        if ((r0.f15983c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f15983c -= Integer.MIN_VALUE;
    L8:
        Object r3 = r0.f15981a;
        Object r8 = d.c.a.b.a();
        int r1 = r0.f15983c;
        if (r1 == 0) goto L19;
        if (r1 != 1) goto L18;
        d.o.a(r3);     // Catch: Throwable -> L13 CancellationException -> L15
    L26:
        return r3;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        d.o.a(r3);
        r0.f15983c = 1;     // Catch: Throwable -> L13 CancellationException -> L15
        r3 = r6.a(r0);     // Catch: Throwable -> L13 CancellationException -> L15
        if (r3 != r8) goto L26;
        return r8;
    L15:
        e = move-exception;
        throw e;
    L13:
        th = move-exception;
        ILogDepend.Companion.w(TAG, "awaitWithin deferred.await failed", th);
        return null;
    L7:
        r0 = new e(this, r7);
        goto L8
    }

    private final List<AppEntity> a(Context r7, boolean r8, boolean r9) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        JSONObject r10 = new JSONObject();
        r10.put("name", "assistantQuery");
        r10.put("ringAlarms", r8);
        r10.put("recordingAudios", r9);
        Integer r3 = null;
        IntentResult r11 = (IntentResult) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.a.f33793a.a(new RCSearchParams(r10.toString()), new DispatchContext(r6, Long.valueOf(UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE), null)).getData(), IntentResult.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L19;
        Object r12 = r11.getEntity();
        if ((r12 instanceof Object[]) == false) goto L7;
        Object[] r13 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
    L8:
        if (r13 == null) goto L19;
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        int r2 = r13.length;
    L10:
        if (r1 >= r2) goto L18;
        Object r4 = r13[r1];
        if (ZeusTransformUtils.instanceOf(r4, AppEntity.class) == false) goto L14;
        AppEntity r5 = (AppEntity) ZeusTransformUtils.preCheckCast(r4, AppEntity.class, "com.obric.aiagent.plugin");
    L15:
        if (r5 == null) goto L17;
        r14.add(r5);
    L17:
        r1 = r1 + 1;
        goto L10
    L14:
        r5 = null;
        goto L15
    L18:
        List<AppEntity> r15 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
    L20:
        ILogDepend.Companion r16 = ILogDepend.Companion;
        StringBuilder r17 = new StringBuilder().append("getRealTimeMemoryContext queryEntities ringAlarms=").append(r8).append(" recordingAudios=").append(r9).append(" size=");
        if (r15 == null) goto L23;
        r3 = Integer.valueOf(r15.size());
    L23:
        r16.i(TAG, r17.append(r3).toString());
        return r15;
    L7:
        r13 = null;
    L19:
        r15 = null;
        goto L20
    }

    private final <T> Object a(au<? extends T> r11, long r12, d.c.d<? super T> r14) {
        au<? extends T> r13 = (au) ZeusTransformUtils.wrapperContextForParams(r11, au.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r15, f.class, "com.obric.aiagent.plugin");
        if ((r0.f15987d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f15987d -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f15985b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f15987d;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        long r10 = r0.f15984a;
        d.o.a(r16);
    L30:
        if (r16 != null) goto L33;
        ILogDepend.Companion.i(TAG, "awaitWithin timeout discard (withTimeoutOrNull), remainingMs=" + r10);
        return null;
    L33:
        if (d.h.b.o.a(r16, a.f15971a) == false) goto L36;
        return null;
    L36:
        return r16;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d.o.a(r16);
    L21:
        return r16;
    L16:
        d.o.a(r16);
        long r17 = d.l.n.a((r12 - System.nanoTime()) / 1000000, 0);
        if (r13.i() == false) goto L23;
        r0.f15987d = 1;
        r16 = a(r13, r0);
        if (r16 != r2) goto L21;
        return r2;
    L23:
        if (r17 > 0) goto L26;
        ILogDepend.Companion.i(TAG, "awaitWithin timeout discard (remainingMs<=0)");
        return null;
    L26:
        d.h.a.m r18 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r13, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.f15984a = r17;
        r0.f15987d = 2;
        r16 = dg.b(r17, r18, r0);
        if (r16 != r2) goto L29;
        return r2;
    L29:
        r10 = r17;
    L7:
        r0 = new f(this, r15);
        goto L8
    }

    public static /* synthetic */ Object a(u r7, Context r8, JSONObject r9, long r10, d.c.d r12, int r13, Object r14) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r13 & 4) == 0) goto L6;
        r10 = 600;
    L6:
        return r7.a(r2, r9, r10, r6);
    }

    public final Object a(Context r27, JSONObject r28, long r29, d.c.d<? super d.x> r31) {
        u r0 = this;
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r27, Context.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L7;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if ((r6.i & Integer.MIN_VALUE) == 0) goto L7;
        r6.i -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.g;
        Object r8 = d.c.a.b.a();
        int r9 = r6.i;
        if (r9 == 0) goto L16;
        if (r9 == 1) goto L15;
        if (r9 != 2) goto L14;
        long r1 = r6.f15976e;
        long r2 = r6.f15975d;
        List r10 = (List) ZeusTransformUtils.preCheckCast(r6.f15973b, List.class, "com.obric.aiagent.plugin");
        JSONObject r11 = (JSONObject) ZeusTransformUtils.preCheckCast(r6.f15972a, JSONObject.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        long r19 = r2;
        JSONObject r12 = null;
    L27:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L30;
        r4 = d.a.p.b();
    L30:
        ILogDepend.Companion.i(TAG, "getRealTimeMemoryContext fetched alarmEntities=" + r10.size() + " recordingEntities=" + r4.size());
        List<? extends AppEntity> r13 = d.a.p.c((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L35;
        IEntityManager r14 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L35;
        r14.addEntities(r13);
    L35:
        JSONObject r15 = new JSONObject();
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L37:
        if (r18.hasNext() == false) goto L41;
        Object r20 = r18.next();
        if (ZeusTransformUtils.instanceOf(r20, AlarmEntity.class) == false) goto L37;
        r17.add(r20);
        goto L37
    L41:
        Object r110 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L45;
        r110 = r12;
    L45:
        if (r110 == null) goto L47;
        r15.put("ringingAlarm", EntityExtKt.a().toJson(r110));
    L47:
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r23 = r21.iterator();
    L49:
        if (r23.hasNext() == false) goto L53;
        Object r24 = r23.next();
        if (ZeusTransformUtils.instanceOf(r24, RecordingEntity.class) == false) goto L49;
        r22.add(r24);
        goto L49
    L53:
        Object r111 = (List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.aiagent.plugin");
        boolean r112 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r111, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L57;
        r111 = r12;
    L57:
        if (r111 == null) goto L60;
        r15.put("recordingAudio", EntityExtKt.a().toJson(r111));
    L60:
        if (r15.length() <= 0) goto L62;
        boolean r25 = true;
    L63:
        if (r25 == false) goto L65;
        r12 = r15;
    L65:
        long r26 = (System.nanoTime() - r1) / 1000000;
        if (r26 >= r19) goto L69;
        r112 = false;
    L69:
        ILogDepend.Companion.i(TAG, "getRealTimeMemoryContext end costMs=" + r26 + " timedOut=" + r112);
        com.obric.agent.trace.g.f15449a.a(r26, r19, r112, r10.size(), r4.size());
        if (r12 == null) goto L73;
        r11.put("o_realtime_context", r12.toString());
    L73:
        return d.x.f38692a;
    L62:
        r25 = false;
        goto L63
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r30 = r6.f;
        long r32 = r6.f15976e;
        long r113 = r6.f15975d;
        au r33 = (au) ZeusTransformUtils.preCheckCast(r6.f15974c, au.class, "com.obric.aiagent.plugin");
        JSONObject r114 = (JSONObject) ZeusTransformUtils.preCheckCast(r6.f15973b, JSONObject.class, "com.obric.aiagent.plugin");
        u r34 = (u) ZeusTransformUtils.preCheckCast(r6.f15972a, u.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        au r35 = r33;
        r0 = r34;
        long r36 = r30;
    L20:
        List r37 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
        if (r37 != null) goto L23;
        r37 = d.a.p.b();
    L23:
        r6.f15972a = r114;
        r6.f15973b = r37;
        r12 = null;
        r6.f15974c = null;
        r6.f15975d = r113;
        r6.f15976e = r32;
        r6.i = 2;
        Object r38 = r0.a(r35, r36, r6);
        if (r38 != r8) goto L26;
        return r8;
    L26:
        r10 = r37;
        r11 = r114;
        r19 = r113;
        r7 = r38;
        r1 = r32;
        goto L27
    L16:
        d.o.a(r7);
        long r39 = System.nanoTime();
        long r115 = r39 + (r29 * 1000000);
        ILogDepend.Companion.i(TAG, "getRealTimeMemoryContext start timeoutMs=" + r29);
        am r40 = f15969b;
        ai r116 = f15970c;
        au r117 = kotlinx.coroutines.i.b(r40, (d.c.g) ZeusTransformUtils.preCheckCast(r116, d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        au r41 = kotlinx.coroutines.i.b(r40, (d.c.g) ZeusTransformUtils.preCheckCast(r116, d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        r6.f15972a = r0;
        r6.f15973b = r28;
        r6.f15974c = r41;
        r6.f15975d = r29;
        r6.f15976e = r39;
        r6.f = r115;
        r6.i = 1;
        Object r118 = r0.a(r117, r115, r6);
        if (r118 != r8) goto L19;
        return r8;
    L19:
        r113 = r29;
        r35 = r41;
        r32 = r39;
        r36 = r115;
        r114 = r28;
        r7 = r118;
    L7:
        r6 = new b(r0, r5);
        goto L8
    }
}
