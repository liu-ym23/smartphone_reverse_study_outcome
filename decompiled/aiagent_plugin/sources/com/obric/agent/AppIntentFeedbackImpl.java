package com.obric.agent;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.funcall_api.bean.IntentAppAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AppIntentFeedbackImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppIntentFeedbackImpl implements IAppIntentFeedback {
    private final String TAG;
    private final Set<f> actionFinishedListeners;
    private final CopyOnWriteArraySet<com.obric.agent.b> actionProcessedResultListeners;
    private final Set<f> localActionFinishedListener;

    /* JADX INFO: compiled from: AppIntentFeedbackImpl.kt */
    @d.c.b.a.f(b = "AppIntentFeedbackImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AppIntentFeedbackImpl$addActionFinishedListener$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppIntentFeedbackImpl f14138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f14139c;

        a(AppIntentFeedbackImpl r3, f r4, d.c.d<? super a> r5) {
            f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14138b = r3;
            this.f14139c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f14138b, this.f14139c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f14137a != 0) goto L7;
            d.o.a(r2);
            AppIntentFeedbackImpl.access$getActionFinishedListeners$p(this.f14138b).add(this.f14139c);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AppIntentFeedbackImpl.kt */
    @d.c.b.a.f(b = "AppIntentFeedbackImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AppIntentFeedbackImpl$addLocalActionFinishedListener$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppIntentFeedbackImpl f14141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f14142c;

        b(AppIntentFeedbackImpl r3, f r4, d.c.d<? super b> r5) {
            f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14141b = r3;
            this.f14142c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f14141b, this.f14142c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f14140a != 0) goto L7;
            d.o.a(r2);
            AppIntentFeedbackImpl.access$getLocalActionFinishedListener$p(this.f14141b).add(this.f14142c);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AppIntentFeedbackImpl.kt */
    @d.c.b.a.f(b = "AppIntentFeedbackImpl.kt", c = {22, 25}, d = "invokeSuspend", e = "com.obric.agent.AppIntentFeedbackImpl$notifyActionFinished$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ IntentAppAction f14147e;
        final /* synthetic */ AppIntentFeedbackImpl f;
        final /* synthetic */ JobResult g;

        c(IntentAppAction r3, AppIntentFeedbackImpl r4, JobResult r5, d.c.d<? super c> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14147e = r3;
            this.f = r4;
            this.g = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f14147e, this.f, this.g, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14146d;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.f14145c, Iterator.class, "com.obric.aiagent.plugin");
            JobResult r3 = (JobResult) ZeusTransformUtils.preCheckCast(this.f14144b, JobResult.class, "com.obric.aiagent.plugin");
            IntentAppAction r5 = (IntentAppAction) ZeusTransformUtils.preCheckCast(this.f14143a, IntentAppAction.class, "com.obric.aiagent.plugin");
            d.o.a(r8);
        L24:
            if (r2.hasNext() == false) goto L29;
            f r9 = (f) ZeusTransformUtils.preCheckCast(r2.next(), f.class, "com.obric.aiagent.plugin");
            this.f14143a = r5;
            this.f14144b = r3;
            this.f14145c = r2;
            this.f14146d = 2;
            if (r9.a(r5, r3, this) != r0) goto L24;
            return r0;
        L29:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Iterator r4 = (Iterator) ZeusTransformUtils.preCheckCast(this.f14145c, Iterator.class, "com.obric.aiagent.plugin");
            JobResult r6 = (JobResult) ZeusTransformUtils.preCheckCast(this.f14144b, JobResult.class, "com.obric.aiagent.plugin");
            IntentAppAction r7 = (IntentAppAction) ZeusTransformUtils.preCheckCast(this.f14143a, IntentAppAction.class, "com.obric.aiagent.plugin");
            d.o.a(r8);
        L18:
            if (r4.hasNext() == false) goto L29;
            f r10 = (f) ZeusTransformUtils.preCheckCast(r4.next(), f.class, "com.obric.aiagent.plugin");
            this.f14143a = r7;
            this.f14144b = r6;
            this.f14145c = r4;
            this.f14146d = 1;
            if (r10.a(r7, r6, this) != r0) goto L18;
            return r0;
        L10:
            d.o.a(r8);
            ConcurrentHashMap<String, String> r11 = this.f14147e.getExt();
            if (r11 == null) goto L13;
            String r12 = (String) ZeusTransformUtils.preCheckCast(r11.get("to_server"), String.class, "com.obric.aiagent.plugin");
        L15:
            if (d.h.b.o.a(r12, "false") == false) goto L22;
            ILogDepend.Companion.i(AppIntentFeedbackImpl.access$getTAG$p(this.f), "notify Local Action Finished");
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(AppIntentFeedbackImpl.access$getLocalActionFinishedListener$p(this.f), Iterable.class, "com.obric.aiagent.plugin");
            IntentAppAction r14 = this.f14147e;
            r6 = this.g;
            r7 = r14;
            r4 = r13.iterator();
            goto L18
        L22:
            ILogDepend.Companion.i(AppIntentFeedbackImpl.access$getTAG$p(this.f), "notify Server Action Finished");
            Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(AppIntentFeedbackImpl.access$getActionFinishedListeners$p(this.f), Iterable.class, "com.obric.aiagent.plugin");
            IntentAppAction r16 = this.f14147e;
            r3 = this.g;
            r5 = r16;
            r2 = r15.iterator();
            goto L24
        L13:
            r12 = null;
            goto L15
        }
    }

    /* JADX INFO: compiled from: AppIntentFeedbackImpl.kt */
    @d.c.b.a.f(b = "AppIntentFeedbackImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AppIntentFeedbackImpl$notifyActionProcessedResult$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppIntentFeedbackImpl f14149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IntentAppAction f14150c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ IntentAppAction f14151d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f14152e;

        d(AppIntentFeedbackImpl r3, IntentAppAction r4, IntentAppAction r5, boolean r6, d.c.d<? super d> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14149b = r3;
            this.f14150c = r4;
            this.f14151d = r5;
            this.f14152e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f14149b, this.f14150c, this.f14151d, this.f14152e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f14148a != 0) goto L11;
            d.o.a(r6);
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(AppIntentFeedbackImpl.access$getActionProcessedResultListeners$p(this.f14149b), Iterable.class, "com.obric.aiagent.plugin");
            IntentAppAction r0 = this.f14150c;
            IntentAppAction r2 = this.f14151d;
            boolean r5 = this.f14152e;
            Iterator r8 = r7.iterator();
        L6:
            if (r8.hasNext() == false) goto L9;
            ((com.obric.agent.b) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.agent.b.class, "com.obric.aiagent.plugin")).a(r0, r2, r5);
            goto L6
        L9:
            return d.x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AppIntentFeedbackImpl.kt */
    @d.c.b.a.f(b = "AppIntentFeedbackImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.AppIntentFeedbackImpl$removeActionFinishedListener$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppIntentFeedbackImpl f14154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f14155c;

        e(AppIntentFeedbackImpl r3, f r4, d.c.d<? super e> r5) {
            f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14154b = r3;
            this.f14155c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f14154b, this.f14155c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f14153a != 0) goto L7;
            d.o.a(r2);
            AppIntentFeedbackImpl.access$getLocalActionFinishedListener$p(this.f14154b).remove(this.f14155c);
            AppIntentFeedbackImpl.access$getActionFinishedListeners$p(this.f14154b).remove(this.f14155c);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AppIntentFeedbackImpl() {
        this.TAG = "AppIntentFeedbackImpl";
        this.actionFinishedListeners = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        this.localActionFinishedListener = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        this.actionProcessedResultListeners = new CopyOnWriteArraySet();
    }

    public static final /* synthetic */ Set access$getActionFinishedListeners$p(AppIntentFeedbackImpl r0) {
        return r0.actionFinishedListeners;
    }

    public static final /* synthetic */ CopyOnWriteArraySet access$getActionProcessedResultListeners$p(AppIntentFeedbackImpl r0) {
        return r0.actionProcessedResultListeners;
    }

    public static final /* synthetic */ Set access$getLocalActionFinishedListener$p(AppIntentFeedbackImpl r0) {
        return r0.localActionFinishedListener;
    }

    public static final /* synthetic */ String access$getTAG$p(AppIntentFeedbackImpl r0) {
        return r0.TAG;
    }

    @Override // com.obric.agent.IAppIntentFeedback
    public void notifyActionFinished(IntentAppAction r8, JobResult r9) {
        d.h.b.o.e(r8, "action");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r8, this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAppIntentFeedback
    public void addActionFinishedListener(f r9) {
        f r10 = (f) ZeusTransformUtils.wrapperContextForParams(r9, f.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "listener");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAppIntentFeedback
    public void addLocalActionFinishedListener(f r9) {
        f r10 = (f) ZeusTransformUtils.wrapperContextForParams(r9, f.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "listener");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAppIntentFeedback
    public void removeActionFinishedListener(f r9) {
        f r10 = (f) ZeusTransformUtils.wrapperContextForParams(r9, f.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "listener");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.IAppIntentFeedback
    public void addActionProcessedResultListener(com.obric.agent.b r3) {
        com.obric.agent.b r4 = (com.obric.agent.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.agent.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        this.actionProcessedResultListeners.add(r4);
    }

    @Override // com.obric.agent.IAppIntentFeedback
    public void removeActionProcessedResultListener(com.obric.agent.b r3) {
        com.obric.agent.b r4 = (com.obric.agent.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.agent.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        this.actionProcessedResultListeners.remove(r4);
    }

    @Override // com.obric.agent.IAppIntentFeedback
    public void notifyActionProcessedResult(IntentAppAction r9, IntentAppAction r10, boolean r11) {
        d.h.b.o.e(r9, Ext.KEY_REQUEST);
        d.h.b.o.e(r10, "result");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r9, r10, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
