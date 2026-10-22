package com.obric.autoaction.app.launcherpage.detail.base.b;

import androidx.lifecycle.aj;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.detail.base.i;
import com.obric.autoaction.app.launcherpage.detail.base.k;
import com.obric.autoaction.app.launcherpage.detail.shortcut.data.DetailParams;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AssistRemoteCardUIParams;
import com.obric.eventkit.task.api.IEventTaskListenerApi;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.EventTaskSpec;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.a.q;
import d.o;
import java.util.List;
import kotlinx.coroutines.a.g;
import kotlinx.coroutines.a.s;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.x;

/* JADX INFO: compiled from: BaseDetailViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T extends EventTask, S extends EventTaskSpec> extends aj implements com.obric.autoaction.app.launcherpage.detail.base.b.d {
    private static final String TAG = "BaseDetailViewModel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0508a f23256a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.detail.base.a.b<T, S> f23257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.detail.base.a.a f23258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlinx.coroutines.a.d<i> f23259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h<i> f23260e;
    private final kotlinx.coroutines.a.d<com.obric.autoaction.app.launcherpage.detail.base.c> f;
    private final h<com.obric.autoaction.app.launcherpage.detail.base.c> g;
    private final x<Boolean> h;
    private final ak<Boolean> i;
    private String j;
    private String k;
    private com.obric.autoaction.app.launcherpage.detail.base.b.c l;
    private T m;
    private EventTask n;
    private T o;
    private String p;
    private String q;
    private final com.obric.eventkit.task.api.a r;
    private final boolean s;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.base.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseDetailViewModel.kt */
    public static final class C0508a {
        public /* synthetic */ C0508a(d.h.b.h r1) {
            this();
        }

        private C0508a() {
        }
    }

    /* JADX INFO: compiled from: BaseDetailViewModel.kt */
    @d.c.b.a.f(b = "BaseDetailViewModel.kt", c = {135, 144, 153}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.base.viewmodel.BaseDetailViewModel$init$1")
    static final class b extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a<T, S> f23262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f23263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ DetailParams f23264d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f23265e;

        b(a<T, S> r3, String r4, DetailParams r5, String r6, d.c.d<? super b> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23262b = r3;
            this.f23263c = r4;
            this.f23264d = r5;
            this.f23265e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23262b, this.f23263c, this.f23264d, this.f23265e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23261a;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            o.a(r8);
        L34:
            this.f23262b.a((i) ZeusTransformUtils.preCheckCast(new k.a(this.f23263c, this.f23262b.k()), i.class, "com.obric.aiagent.plugin"));
            a.a(this.f23262b);
            IEventTaskListenerApi r9 = (IEventTaskListenerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskListenerApi.class), IEventTaskListenerApi.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L37;
            r9.unregisterEventTaskChangeListener(a.b(this.f23262b));
        L37:
            IEventTaskListenerApi r10 = (IEventTaskListenerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskListenerApi.class), IEventTaskListenerApi.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L40;
            r10.registerEventTaskChangeListener(a.b(this.f23262b));
        L40:
            a.c(this.f23262b);
        L42:
            return d.x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            o.a(r8);
        L27:
            EventTask r11 = (EventTask) ZeusTransformUtils.preCheckCast(r8, EventTask.class, "com.obric.aiagent.plugin");
            if (r11 != null) goto L31;
            Loog.INSTANCE.e(a.TAG, "init failed, taskId: " + this.f23263c + " is unavailable");
            this.f23262b.a((com.obric.autoaction.app.launcherpage.detail.base.c) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.c.b("任务不存在或类型错误", false, 2, null), com.obric.autoaction.app.launcherpage.detail.base.c.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        L31:
            this.f23262b.b(r11);
            a<T, S> r2 = this.f23262b;
            r2.c(r2.d(r11));
            a<T, S> r3 = this.f23262b;
            r3.d(r3.e(r11));
            a<T, S> r4 = this.f23262b;
            d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23261a = 3;
            if (r4.a(r11, r5) != r0) goto L34;
            return r0;
        L11:
            o.a(r8);
        L23:
            EventTask r12 = (EventTask) ZeusTransformUtils.preCheckCast(r8, EventTask.class, "com.obric.aiagent.plugin");
            this.f23262b.b(r12);
            a<T, S> r6 = this.f23262b;
            r6.c(r6.d(r12));
            this.f23262b.d("");
            this.f23262b.a((i) ZeusTransformUtils.preCheckCast(new k.a("", this.f23262b.k()), i.class, "com.obric.aiagent.plugin"));
            a.a(this.f23262b);
            goto L42
        L12:
            o.a(r8);
            this.f23262b.a(this.f23263c);
            CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f23263c, CharSequence.class, "com.obric.aiagent.plugin");
            if (r13 != null) goto L15;
        L18:
            boolean r14 = true;
        L19:
            if (r14 == false) goto L24;
            a<T, S> r15 = this.f23262b;
            EventTask r7 = this.f23264d.getInitEventTask();
            String r16 = this.f23265e;
            d.c.d<? super T> r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23261a = 1;
            r8 = r15.a(r7, r16, r17);
            if (r8 != r0) goto L23;
            return r0;
        L24:
            com.obric.autoaction.app.launcherpage.detail.base.a.b<T, S> r18 = this.f23262b.b();
            String r19 = this.f23263c;
            d.c.d<? super T> r20 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23261a = 2;
            r8 = r18.a(r19, r20);
            if (r8 != r0) goto L27;
            return r0;
        L15:
            if (r13.length() == 0) goto L18;
            r14 = false;
            goto L19
        }
    }

    /* JADX INFO: compiled from: BaseDetailViewModel.kt */
    @d.c.b.a.f(b = "BaseDetailViewModel.kt", c = {201}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.base.viewmodel.BaseDetailViewModel$reduce$1")
    static final class c extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a<T, S> f23267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ T f23268c;

        c(a<T, S> r3, T r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23267b = r3;
            this.f23268c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23267b, this.f23268c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23266a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.autoaction.app.launcherpage.detail.base.a.b<T, S> r8 = this.f23267b.b();
            String r2 = this.f23267b.h();
            T r3 = this.f23268c;
            d.c.d<? super d.x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23266a = 1;
            if (r8.a(r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: BaseDetailViewModel.kt */
    static final class d<T> implements kotlinx.coroutines.b.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<T, S> f23269a;

        d(a<T, S> r1) {
            this.f23269a = r1;
        }

        @Override // kotlinx.coroutines.b.i
        public /* synthetic */ Object emit(Object r3, d.c.d r4) {
            d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return a((EventTaskResult) ZeusTransformUtils.preCheckCast(r3, EventTaskResult.class, "com.obric.aiagent.plugin"), r5);
        }

        public final Object a(EventTaskResult r6, d.c.d<? super d.x> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            Integer r0 = null;
            if (com.obric.autoaction.app.launcherpage.detail.base.e.a(r6) == false) goto L12;
            a<T, S> r9 = this.f23269a;
            String r2 = r9.h();
            if (r6 == null) goto L11;
            List<EventTask> r3 = r6.getData();
            if (r3 == null) goto L11;
            EventTask r1 = (EventTask) ZeusTransformUtils.preCheckCast(p.l(r3), EventTask.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L11;
            r0 = d.c.b.a.b.a(r1.getTaskMode());
        L11:
            r9.a(r2, r0);
            this.f23269a.a(r6);
        L14:
            return d.x.f38692a;
        L12:
            Loog.INSTANCE.e(a.TAG, "delete task failed, taskId: " + this.f23269a.h() + ", result: " + r6);
            this.f23269a.a((com.obric.autoaction.app.launcherpage.detail.base.c) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.c.b(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.condition_event_delete_fail_retry, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_delete_fail_retry"), null, 1, null), false, 2, null), com.obric.autoaction.app.launcherpage.detail.base.c.class, "com.obric.aiagent.plugin"));
            goto L14
        }
    }

    /* JADX INFO: compiled from: BaseDetailViewModel.kt */
    @d.c.b.a.f(b = "BaseDetailViewModel.kt", c = {222}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.base.viewmodel.BaseDetailViewModel$refreshHistoryCount$1")
    static final class e extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a<T, S> f23271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f23272c;

        e(a<T, S> r3, String r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23271b = r3;
            this.f23272c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f23271b, this.f23272c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23270a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L14;
            r6 = "";
        L14:
            a.a(this.f23271b, r6);
            this.f23271b.a((i) ZeusTransformUtils.preCheckCast(new k.b(r6), i.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            h<String> r7 = this.f23271b.b().a(this.f23272c);
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23270a = 1;
            r5 = j.c(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: BaseDetailViewModel.kt */
    @d.c.b.a.f(b = "BaseDetailViewModel.kt", c = {245}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.base.viewmodel.BaseDetailViewModel$saveDraft$1")
    static final class f extends l implements m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a<T, S> f23274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ T f23275c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f23276d;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.base.b.a$f$1, reason: invalid class name */
        /* JADX INFO: compiled from: BaseDetailViewModel.kt */
        @d.c.b.a.f(b = "BaseDetailViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.base.viewmodel.BaseDetailViewModel$saveDraft$1$2")
        static final class AnonymousClass1 extends l implements q<kotlinx.coroutines.b.i<? super EventTaskResult>, Throwable, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23277a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f23278b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a<T, S> f23279c;

            AnonymousClass1(a<T, S> r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23279c = r3;
                super(3, r5);
            }

            public final Object a(kotlinx.coroutines.b.i<? super EventTaskResult> r3, Throwable r4, d.c.d<? super d.x> r5) {
                kotlinx.coroutines.b.i r6 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r8 = new AnonymousClass1(this.f23279c, r7);
                r8.f23278b = r4;
                return r8.invokeSuspend(d.x.f38692a);
            }

            @Override // d.h.a.q
            public /* synthetic */ Object invoke(kotlinx.coroutines.b.i<? super EventTaskResult> r3, Throwable r4, d.c.d<? super d.x> r5) {
                return a((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f23277a != 0) goto L7;
                o.a(r3);
                Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(this.f23278b, Throwable.class, "com.obric.aiagent.plugin");
                a.a(this.f23279c, r4);
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        f(a<T, S> r3, T r4, boolean r5, d.c.d<? super f> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23274b = r3;
            this.f23275c = r4;
            this.f23276d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f23274b, this.f23275c, this.f23276d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23273a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r12);
        L11:
            String r13 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L15;
            this.f23274b.a((com.obric.autoaction.app.launcherpage.detail.base.c) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.c.b(r13, false, 2, null), com.obric.autoaction.app.launcherpage.detail.base.c.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        L15:
            CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f23274b.h(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r14 != null) goto L18;
        L21:
            final boolean r7 = true;
        L22:
            EventTaskSpec r15 = this.f23274b.a(this.f23275c, r7);
            final long r8 = System.currentTimeMillis();
            if (r7 == false) goto L25;
            h<EventTaskResult> r16 = this.f23274b.b().a(r15, this.f23274b.n(), this.f23274b.i());
        L29:
            h r17 = j.a(r16, (q) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f23274b, null), q.class, "com.obric.aiagent.plugin"));
            am r2 = androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this.f23274b, aj.class, "com.obric.aiagent.plugin"));
            final a<T, S> r5 = this.f23274b;
            final T r6 = this.f23275c;
            final boolean r10 = this.f23276d;
            com.obric.autoaction.app.launcherpage.utils.c.a(r17, r2, (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r5, r6, r7, r8, r10), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        L25:
            com.obric.autoaction.app.launcherpage.detail.base.a.b<T, S> r3 = this.f23274b.b();
            String r4 = this.f23274b.h();
            if (r4 != null) goto L28;
            r4 = "";
        L28:
            r16 = r3.update(r4, r15, this.f23274b.n(), this.f23274b.j());
            goto L29
        L18:
            if (r14.length() == 0) goto L21;
            r7 = false;
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r12);
            a<T, S> r18 = this.f23274b;
            T r9 = this.f23275c;
            d.c.d<? super String> r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23273a = 1;
            r12 = r18.b(r9, r11);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    static {
        f23256a = new C0508a(null);
    }

    static /* synthetic */ <T extends EventTask, S extends EventTaskSpec> Object b(a<T, S> r0, T r1, d.c.d<? super String> r2) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return null;
    }

    /* JADX INFO: renamed from: lambda$PyMPpdU5k3kVX-SpLYCNMpMIQ9s, reason: not valid java name */
    public static /* synthetic */ String m468lambda$PyMPpdU5k3kVXSpLYCNMpMIQ9s(EventTaskResult r0) {
        return c(r0);
    }

    public static /* synthetic */ String lambda$h5APFKpLWu9egH0KssEG9YVkp58() {
        return w();
    }

    /* JADX INFO: renamed from: lambda$iyzuAkUa-eaD9PdMtDCNKJrX7Xg, reason: not valid java name */
    public static /* synthetic */ String m469lambda$iyzuAkUaeaD9PdMtDCNKJrX7Xg() {
        return x();
    }

    /* JADX INFO: renamed from: lambda$oDvKo_f2vznJjcWTrvsr-SSwTxI, reason: not valid java name */
    public static /* synthetic */ String m470lambda$oDvKo_f2vznJjcWTrvsrSSwTxI(EventTaskResult r0) {
        return b(r0);
    }

    public static /* synthetic */ void lambda$pJWkNdK6K6ql8Unm6Cnscv8Xlg4(a r0, int r1) {
        a(r0, r1);
    }

    private static final String w() {
        return "closePage";
    }

    private static final String x() {
        return "closePage";
    }

    public abstract T a(com.obric.autoaction.app.launcherpage.detail.base.h r1, T r2);

    public abstract S a(T r1, boolean r2);

    public Object a(T r3, d.c.d<? super d.x> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public abstract Object a(EventTask r1, String r2, d.c.d<? super T> r3);

    public void a(AssistRemoteCardUIParams r1) {
    }

    public abstract void a(T r1, T r2, boolean r3, int r4, String r5, long r6);

    public void a(T r1, boolean r2, EventTaskResult r3) {
    }

    public abstract void a(String r1, Integer r2);

    public boolean a(T r1) {
        d.h.b.o.e(r1, "draft");
        return true;
    }

    public abstract boolean a(T r1, T r2);

    public Object b(T r3, d.c.d<? super String> r4) {
        return b(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public abstract T d(T r1);

    public abstract String e(T r1);

    public void f(T r1) {
        d.h.b.o.e(r1, "draft");
    }

    public static final /* synthetic */ void a(a r0) {
        r0.u();
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.q = r1;
    }

    public static final /* synthetic */ void a(a r0, Throwable r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ com.obric.eventkit.task.api.a b(a r0) {
        return r0.r;
    }

    public static final /* synthetic */ void c(a r0) {
        r0.v();
    }

    public boolean t() {
        return com.obric.autoaction.app.launcherpage.detail.base.b.d.a.a(this);
    }

    public final com.obric.autoaction.app.launcherpage.detail.base.a.b<T, S> b() {
        return this.f23257b;
    }

    public final com.obric.autoaction.app.launcherpage.detail.base.a.a c() {
        return this.f23258c;
    }

    public a(com.obric.autoaction.app.launcherpage.detail.base.a.b<T, S> r5, com.obric.autoaction.app.launcherpage.detail.base.a.a r6) {
        com.obric.autoaction.app.launcherpage.detail.base.a.b<T, S> r7 = (com.obric.autoaction.app.launcherpage.detail.base.a.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.autoaction.app.launcherpage.detail.base.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "repository");
        d.h.b.o.e(r6, "reporter");
        this.f23257b = r7;
        this.f23258c = r6;
        kotlinx.coroutines.a.d<i> r2 = g.a(-2, null, null, 6, null);
        this.f23259d = r2;
        this.f23260e = j.a((s) ZeusTransformUtils.preCheckCast(r2, s.class, "com.obric.aiagent.plugin"));
        kotlinx.coroutines.a.d<com.obric.autoaction.app.launcherpage.detail.base.c> r8 = g.a(-2, null, null, 6, null);
        this.f = r8;
        this.g = j.a((s) ZeusTransformUtils.preCheckCast(r8, s.class, "com.obric.aiagent.plugin"));
        x<Boolean> r9 = kotlinx.coroutines.b.am.a(false);
        this.h = r9;
        this.i = j.a(r9);
        this.l = com.obric.autoaction.app.launcherpage.detail.base.b.c.f23286b;
        this.p = "";
        this.r = new $$Lambda$a$pJWkNdK6K6ql8Unm6Cnscv8Xlg4(this);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.d
    public h<i> e() {
        return this.f23260e;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.d
    public h<com.obric.autoaction.app.launcherpage.detail.base.c> f() {
        return this.g;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.d
    public ak<Boolean> g() {
        return this.i;
    }

    private final void u() {
        x<Boolean> r0 = this.h;
        T r1 = this.m;
        if (r1 == null) goto L5;
        boolean r2 = a(r1);
    L6:
        r0.b(Boolean.valueOf(r2));
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void a(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "state");
        this.f23259d.a_(r4);
    }

    public final void a(com.obric.autoaction.app.launcherpage.detail.base.c r3) {
        com.obric.autoaction.app.launcherpage.detail.base.c r4 = (com.obric.autoaction.app.launcherpage.detail.base.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.detail.base.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "effect");
        this.f.a_(r4);
    }

    public final String h() {
        return this.j;
    }

    public final void a(String r1) {
        this.j = r1;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.d
    public String i() {
        return this.k;
    }

    public void c(String r1) {
        this.k = r1;
    }

    public boolean j() {
        if (this.l != com.obric.autoaction.app.launcherpage.detail.base.b.c.f23287c) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(T r1) {
        this.m = r1;
    }

    public final T k() {
        return this.m;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.d
    public EventTask l() {
        return this.m;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.d
    public EventTask m() {
        return this.n;
    }

    public final void c(T r1) {
        this.o = r1;
    }

    public final void d(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.p = r2;
    }

    public final String n() {
        return this.p;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.d
    public String o() {
        return this.q;
    }

    private static final void a(a r1, int r2) {
        if (r2 != 7) goto L6;
        r1.v();
        return;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.d
    public void a(DetailParams r14, com.obric.autoaction.app.launcherpage.detail.base.b.c r15) {
        d.h.b.o.e(r14, "params");
        d.h.b.o.e(r15, "mode");
        Loog.INSTANCE.i(TAG, "init");
        String r2 = r14.getTaskId();
        String r4 = r14.getEnterFrom();
        c(r4);
        this.l = r15;
        this.n = r14.getInitEventTask();
        a(r14.getDoubaoCardUIParams());
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, r2, r14, r4, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.d
    public void a(EventTask r2, String r3) {
        d.h.b.o.e(r2, "task");
        if (r2 != 0) goto L5;
        return;
    L5:
        c(r3);
        this.j = r2.getId();
        this.m = r2;
        this.o = (T) d(r2);
        this.p = e(r2);
        a((i) ZeusTransformUtils.preCheckCast(k.c.f23399a, i.class, "com.obric.aiagent.plugin"));
        u();
    }

    public final boolean p() {
        if (this.l != com.obric.autoaction.app.launcherpage.detail.base.b.c.f23286b) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.d
    public void a(com.obric.autoaction.app.launcherpage.detail.base.h r9) {
        com.obric.autoaction.app.launcherpage.detail.base.h r10 = (com.obric.autoaction.app.launcherpage.detail.base.h) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.autoaction.app.launcherpage.detail.base.h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "action");
        T r0 = this.m;
        if (r0 == null) goto L11;
        T r1 = (T) a(r10, r0);
        if (r1 == null) goto L11;
        this.m = r1;
        u();
        if (p() == false) goto L26;
        a(false);
        return;
    L26:
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.app.launcherpage.detail.base.j.b.class) == false) goto L14;
        a(((com.obric.autoaction.app.launcherpage.detail.base.j.b) ZeusTransformUtils.preCheckCast(r10, com.obric.autoaction.app.launcherpage.detail.base.j.b.class, "com.obric.aiagent.plugin")).a());
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.app.launcherpage.detail.base.j.c.class) == false) goto L20;
        T r11 = this.m;
        if (r11 != null) goto L18;
        return;
    L18:
        f(r11);
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.autoaction.app.launcherpage.detail.base.j.a.class) == false) goto L29;
        com.obric.autoaction.app.launcherpage.detail.base.a.b<T, S> r12 = this.f23257b;
        String r2 = this.j;
        if (r2 != null) goto L24;
        r2 = "";
    L24:
        com.obric.autoaction.app.launcherpage.utils.c.a(r12.delete(r2), androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new d(this), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void v() {
        String r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L7;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L17;
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new e(this, r0, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L17:
        return;
    L7:
        r1 = false;
        goto L9
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.d
    public boolean q() {
        T r0 = this.o;
        if (r0 == null) goto L5;
        T r2 = this.m;
        if (r2 != null) goto L12;
        return false;
    L12:
        return a(r0, r2);
    L5:
        if (this.m == null) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.b.d
    public boolean r() {
        T r0 = this.m;
        if (r0 != null) goto L7;
        return false;
    L7:
        return !d.h.b.o.a(this.p, e(r0));
    }

    private final void a(boolean r11) {
        T r0 = this.m;
        if (r0 != null) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).a((com.obric.autoaction.app.launcherpage.detail.base.c) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.c.b("", false, 2, null), com.obric.autoaction.app.launcherpage.detail.base.c.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new f(this, r0, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void a(Throwable r5) {
        Loog.INSTANCE.e(TAG, "save task failed: " + r5.getMessage(), r5);
        a((com.obric.autoaction.app.launcherpage.detail.base.c) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.c.b("", false, 2, null), com.obric.autoaction.app.launcherpage.detail.base.c.class, "com.obric.aiagent.plugin"));
    }

    private static final String b(EventTaskResult r2) {
        return "closePage: result=" + r2;
    }

    public final void a(final EventTaskResult r7) {
        Loog.INSTANCE.dp(TAG, new $$Lambda$a$oDvKo_f2vznJjcWTrvsrSSwTxI(r7), $$Lambda$a$h5APFKpLWu9egH0KssEG9YVkp58.INSTANCE);
        if (com.obric.autoaction.app.launcherpage.detail.base.e.a(r7) == false) goto L5;
        a((com.obric.autoaction.app.launcherpage.detail.base.c) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.c.a(r7), com.obric.autoaction.app.launcherpage.detail.base.c.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        Loog.INSTANCE.ep(TAG, new $$Lambda$a$PyMPpdU5k3kVXSpLYCNMpMIQ9s(r7), $$Lambda$a$iyzuAkUaeaD9PdMtDCNKJrX7Xg.INSTANCE);
        Integer[] r0 = {-100, -101, -102};
        if (r7 == null) goto L8;
        Integer r5 = Integer.valueOf(r7.getCode());
    L9:
        boolean r1 = d.a.i.b(r0, r5);
        String r6 = "";
        if (r1 == false) goto L17;
        if (r7 == null) goto L13;
        String r8 = r7.getMsg();
    L14:
        if (r8 == null) goto L17;
        r6 = r8;
        goto L17
    L13:
        r8 = null;
    L17:
        a((com.obric.autoaction.app.launcherpage.detail.base.c) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.c.b(r6, false, 2, null), com.obric.autoaction.app.launcherpage.detail.base.c.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        r5 = null;
        goto L9
    }

    private static final String c(EventTaskResult r2) {
        StringBuilder r0 = new StringBuilder().append("closePage: result=").append(r2).append(", msg = ");
        if (r2 == null) goto L5;
        String r3 = r2.getMsg();
    L7:
        return r0.append(r3).toString();
    L5:
        r3 = null;
        goto L7
    }

    @Override // androidx.lifecycle.aj
    public void a() {
        IEventTaskListenerApi r0 = (IEventTaskListenerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskListenerApi.class), IEventTaskListenerApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.unregisterEventTaskChangeListener(this.r);
    L5:
        super.a();
    }

    public boolean s() {
        return this.s;
    }

    static /* synthetic */ <T extends EventTask, S extends EventTaskSpec> Object a(a<T, S> r0, T r1, d.c.d<? super d.x> r2) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return d.x.f38692a;
    }
}
