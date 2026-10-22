package com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask;

import com.obric.agent.IAgentService;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.autoaction.app.launcherpage.api.IAutoTaskApi;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.obric.eventkit.task.model.ShortcutTaskRecord;
import com.obric.eventkit.task.model.ShortcutTaskSpec;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;

/* JADX INFO: compiled from: ShortcutTaskManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "ShortcutTaskManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17459a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b f17460b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.a f17461c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final am f17462d = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {101}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$addShortcutTask$task$1")
    static final class C0360a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ShortcutTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ShortcutTaskSpec f17465c;

        C0360a(String r3, ShortcutTaskSpec r4, d.c.d<? super C0360a> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17464b = r3;
            this.f17465c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ShortcutTask> r4) {
            return ((C0360a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0360a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0360a(this.f17464b, this.f17465c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ShortcutTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17463a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r8 = a.a();
            String r2 = this.f17464b;
            ShortcutTaskSpec r3 = this.f17465c;
            d.c.d<? super ShortcutTask> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17463a = 1;
            r7 = r8.a(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {242}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$getAllShortcutTaskRecords$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ShortcutTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f17468c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f17469d;

        b(String r3, long r4, long r6, d.c.d<? super b> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17467b = r3;
            this.f17468c = r4;
            this.f17469d = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTaskRecord>> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f17467b, this.f17468c, this.f17469d, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTaskRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17466a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.a r2 = a.b();
            String r11 = this.f17467b;
            long r3 = this.f17468c;
            long r5 = this.f17469d;
            d.c.d<? super List<ShortcutTaskRecord>> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17466a = 1;
            r10 = r2.a(r11, r3, r5, r7);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {69}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$getKnowledgeSessionIdNotNullShortcutTasks$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ShortcutTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17471b;

        c(String r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17471b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTask>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f17471b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17470a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r7 = a.a();
            String r2 = this.f17471b;
            d.c.d<? super List<ShortcutTask>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17470a = 1;
            r6 = r7.c(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {86}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$getShortInstructNotNullShortcutTasks$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ShortcutTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17473b;

        d(String r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17473b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTask>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f17473b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17472a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r7 = a.a();
            String r2 = this.f17473b;
            d.c.d<? super List<ShortcutTask>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17472a = 1;
            r6 = r7.e(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {230}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$getShortTaskRecordsByTaskId$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ShortcutTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f17476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f17477d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f17478e;

        e(String r3, long r4, long r6, String r8, d.c.d<? super e> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17475b = r3;
            this.f17476c = r4;
            this.f17477d = r6;
            this.f17478e = r8;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTaskRecord>> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f17475b, this.f17476c, this.f17477d, this.f17478e, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTaskRecord>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17474a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.a r2 = a.b();
            String r12 = this.f17475b;
            long r3 = this.f17476c;
            long r5 = this.f17477d;
            String r7 = this.f17478e;
            d.c.d<? super List<ShortcutTaskRecord>> r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17474a = 1;
            r11 = r2.a(r12, r3, r5, r7, r8);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {40}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$getShortcutTask$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ShortcutTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17480b;

        f(String r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17480b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super ShortcutTask> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f17480b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ShortcutTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17479a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r7 = a.a();
            String r2 = this.f17480b;
            d.c.d<? super ShortcutTask> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17479a = 1;
            r6 = r7.a(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {57}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$getShortcutTasksPaged$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ShortcutTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f17483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17484d;

        g(String r3, int r4, int r5, d.c.d<? super g> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17482b = r3;
            this.f17483c = r4;
            this.f17484d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTask>> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f17482b, this.f17483c, this.f17484d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17481a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r9 = a.a();
            String r2 = this.f17482b;
            int r3 = this.f17483c;
            int r4 = this.f17484d;
            d.c.d<? super List<ShortcutTask>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17481a = 1;
            r8 = r9.a(r2, r3, r4, r5);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {77}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$getTemplateIdNotNullShortcutTasks$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ShortcutTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17486b;

        h(String r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17486b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTask>> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f17486b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17485a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r7 = a.a();
            String r2 = this.f17486b;
            d.c.d<? super List<ShortcutTask>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17485a = 1;
            r6 = r7.d(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {262}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$removeAllShortcutTaskRecords$result$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17488b;

        i(String r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17488b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f17488b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17487a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.a r7 = a.b();
            String r2 = this.f17488b;
            d.c.d<? super Integer> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17487a = 1;
            r6 = r7.a(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {147}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$removeShortcutTask$1$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShortcutTask f17490b;

        j(ShortcutTask r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17490b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f17490b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17489a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L14:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.a r7 = a.b();
            String r2 = this.f17490b.getId();
            if (r2 != null) goto L11;
            r2 = "";
        L11:
            d.c.d<? super Integer> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17489a = 1;
            r6 = r7.b(r2, r3);
            if (r6 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {150}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$removeShortcutTask$1$2")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShortcutTask f17492b;

        k(ShortcutTask r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17492b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f17492b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17491a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            IAutoTaskApi r7 = (IAutoTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoTaskApi.class), IAutoTaskApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            EventTask r2 = (EventTask) ZeusTransformUtils.preCheckCast(this.f17492b, EventTask.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17491a = 1;
            if (r7.onTaskDelete(r2, r3) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {144}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$removeShortcutTask$deletedTask$1")
    static final class l extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ShortcutTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String[] f17495c;

        l(String r3, String[] r4, d.c.d<? super l> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17494b = r3;
            this.f17495c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTask>> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f17494b, this.f17495c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17493a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r8 = a.a();
            String r2 = this.f17494b;
            String[] r3 = this.f17495c;
            d.c.d<? super List<ShortcutTask>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17493a = 1;
            r7 = r8.a(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$removeShortcutTaskRecordsById$result$1")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long[] f17498c;

        m(String r3, long[] r4, d.c.d<? super m> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17497b = r3;
            this.f17498c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f17497b, this.f17498c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17496a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.a r8 = a.b();
            String r2 = this.f17497b;
            long[] r3 = this.f17498c;
            d.c.d<? super Integer> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17496a = 1;
            r7 = r8.a(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {213, 214}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$scheduleShortcutTask$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f17500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17501c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17502d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f17503e;
        final /* synthetic */ String f;

        /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.a$n$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ShortcutTaskManager.kt */
        @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {199}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$scheduleShortcutTask$1$task$1")
        static final class C0361a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ShortcutTask>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f17504a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f17505b;

            C0361a(String r3, d.c.d<? super C0361a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f17505b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super ShortcutTask> r4) {
                return ((C0361a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0361a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0361a(this.f17505b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super ShortcutTask> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f17504a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L11:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r7 = a.a();
                String r2 = this.f17505b;
                d.c.d<? super ShortcutTask> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f17504a = 1;
                r6 = r7.a(r2, r3);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        n(String r3, String r4, long r5, String r7, d.c.d<? super n> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17501c = r3;
            this.f17502d = r4;
            this.f17503e = r5;
            this.f = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f17501c, this.f17502d, this.f17503e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r17) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f17500b;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            String r0 = (String) ZeusTransformUtils.preCheckCast(this.f17499a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r17);
        L32:
            com.obric.aiagent.executionengine.eventstaskmanager.b r3 = com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a;
            if (r0 != null) goto L35;
            r0 = "";
        L35:
            r3.a(r0, 6);
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ShortcutTask r4 = (ShortcutTask) ZeusTransformUtils.preCheckCast(this.f17499a, ShortcutTask.class, "com.obric.aiagent.plugin");
            d.o.a(r17);
            Object r5 = r17;
        L28:
            String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.a r7 = a.b();
            String r8 = r4.getId();
            long r9 = System.currentTimeMillis();
            long r12 = System.currentTimeMillis() - this.f17503e;
            d.c.d<? super x> r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17499a = r6;
            this.f17500b = 2;
            if (r7.a(r8, r9, r6, 0, r12, r14) != r1) goto L31;
            return r1;
        L31:
            r0 = r6;
            goto L32
        L10:
            d.o.a(r17);
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(a.TAG, "scheduleShortcutTask " + this.f17501c + ' ' + this.f17502d);
            String r10 = this.f17501c;
            if (r10 != null) goto L13;
        L37:
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(a.TAG, "scheduleShortcutTask no permission");
            return x.f38692a;
        L13:
            if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r10) == false) goto L37;
            r4 = (ShortcutTask) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0361a(this.f17502d, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), ShortcutTask.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L19;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(a.TAG, "scheduleShortcutTask task not found");
            return x.f38692a;
        L19:
            com.obric.event.task.base.report.i.f32779a.a(r4.getId(), 3, null);
            Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r4.getActions(), Iterable.class, "com.obric.aiagent.plugin");
            String r13 = this.f;
            Iterator r15 = r11.iterator();
        L21:
            if (r15.hasNext() == false) goto L25;
            ShortcutTaskAction r16 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(r15.next(), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(a.TAG, "schedule task " + r4.getId() + ' ' + r16.getIntent());
            IAgentService r18 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
            if (r18 == null) goto L21;
            r18.scheduleShortcutTask(r4, r16.getIntent(), r16.getParams(), r13);
            goto L21
        L25:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r19 = a.a();
            String r20 = r4.getId();
            d.c.d<? super String> r21 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17499a = r4;
            this.f17500b = 1;
            r5 = r19.b(r20, r21);
            if (r5 != r1) goto L28;
            return r1;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {181}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$updateShortcutDisplayOrder$updatedCount$1")
    static final class o extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f17508c;

        o(String r3, List<String> r4, d.c.d<? super o> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17507b = r3;
            this.f17508c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f17507b, this.f17508c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17506a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r8 = a.a();
            String r2 = this.f17507b;
            List<String> r3 = this.f17508c;
            d.c.d<? super Integer> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17506a = 1;
            r7 = r8.a(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {123}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$updateShortcutTask$1$newTask$1")
    static final class p extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ShortcutTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ShortcutTaskSpec f17511c;

        p(String r3, ShortcutTaskSpec r4, d.c.d<? super p> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17510b = r3;
            this.f17511c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ShortcutTask> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new p(this.f17510b, this.f17511c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ShortcutTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17509a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r8 = a.a();
            String r2 = this.f17510b;
            ShortcutTaskSpec r3 = this.f17511c;
            d.c.d<? super ShortcutTask> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17509a = 1;
            r7 = r8.b(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {IdlErrors.E_RejectInferDeviceOverheat}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$updateShortcutTask$1$sourceFrom$1")
    static final class q extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShortcutTask f17513b;

        q(ShortcutTask r3, d.c.d<? super q> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17513b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super String> r4) {
            return ((q) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new q(this.f17513b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super String> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17512a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r7 = a.a();
            String r2 = this.f17513b.getId();
            d.c.d<? super String> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17512a = 1;
            r6 = r7.b(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskManager.kt */
    @d.c.b.a.f(b = "ShortcutTaskManager.kt", c = {115}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.ShortcutTaskManager$updateShortcutTask$1$task$1")
    static final class r extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ShortcutTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17515b;

        r(String r3, d.c.d<? super r> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17515b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super ShortcutTask> r4) {
            return ((r) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new r(this.f17515b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ShortcutTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17514a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b r7 = a.a();
            String r2 = this.f17515b;
            d.c.d<? super ShortcutTask> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17514a = 1;
            r6 = r7.a(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    private a() {
    }

    public static final /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b a() {
        return f17460b;
    }

    public static final /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.a b() {
        return f17461c;
    }

    static {
        f17459a = new a();
        f17460b = new com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b();
        f17461c = new com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.a();
        f17462d = an.a((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.common.a.f16677a.b(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public final boolean a(String r4) {
        d.h.b.o.e(r4, DBDefinition.TASK_ID);
        return d.o.o.b(r4, "st_", false, 2, null);
    }

    public final ShortcutTask a(String r3, String r4) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getShortcutTask " + r3 + ' ' + r4);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == true) goto L8;
        return null;
    L8:
        return (ShortcutTask) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), ShortcutTask.class, "com.obric.aiagent.plugin");
    }

    public final List<ShortcutTask> a(String r3, int r4, int r5) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getShortcutTasksPaged " + r3);
        if (r3 != null) goto L5;
    L9:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "getShortcutTasksPaged pkgName check error");
        return d.a.p.b();
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == false) goto L9;
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r3, r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    }

    public final Object a(String r2, Map<String, String> r3, d.c.d<? super Boolean> r4) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super Boolean> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return f17460b.a(r2, r1, r5);
    }

    public final List<ShortcutTask> b(String r3) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getKnowledgeSessionIdNotNullShortcutTasks " + r3);
        if (r3 == null) goto L10;
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == false) goto L10;
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    L10:
        return d.a.p.b();
    }

    public final List<ShortcutTask> c(String r3) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getTemplateIdNotNullShortcutTasks " + r3);
        if (r3 == null) goto L10;
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == false) goto L10;
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    L10:
        return d.a.p.b();
    }

    public final List<ShortcutTask> d(String r3) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getShortInstructNotNullShortcutTasks " + r3);
        if (r3 != null) goto L5;
    L9:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "getShortInstructNotNullShortcutTasks pkcName check error");
        return d.a.p.b();
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == false) goto L9;
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    }

    public final Object a(d.c.d<? super List<ShortcutTask>> r2) {
        d.c.d<? super List<ShortcutTask>> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return f17460b.a(r1);
    }

    public final EventTaskResult a(String r11, ShortcutTaskSpec r12) {
        d.h.b.o.e(r12, "spec");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "addShortcutTask " + r11 + ' ' + r12);
        if (r11 != null) goto L7;
        return a(this, "addShortcutTask", -201, "Package name is null", null, 8, null);
    L7:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r11) == false) goto L9;
        ShortcutTask r13 = (ShortcutTask) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0360a(r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), ShortcutTask.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r11, 5);
        return a("addShortcutTask", 0, "add shortcut task success", d.a.p.a(r13));
    L9:
        return a(this, "addShortcutTask", -100, "Permission denied", null, 8, null);
    }

    public final EventTaskResult a(String r11, String r12, ShortcutTaskSpec r13) {
        d.h.b.o.e(r13, "spec");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "updateShortcutTask " + r11 + ' ' + r12);
        if (r11 != null) goto L7;
        return a(this, "updateShortcutTask", -201, "Package name is null", null, 8, null);
    L7:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r11) == false) goto L9;
        ShortcutTask r10 = (ShortcutTask) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new r(r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), ShortcutTask.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L15;
        return a(f17459a, "updateShortcutTask", -300, "task not found", null, 8, null);
    L15:
        if (d.h.b.o.a((String) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new q(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), String.class, "com.obric.aiagent.plugin"), r11) == false) goto L17;
    L20:
        ShortcutTask r14 = (ShortcutTask) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new p(r12, r13, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), ShortcutTask.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L24;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r11, 5);
        return f17459a.a("updateShortcutTask", 0, "update shortcut task success", d.a.p.a(r14));
    L24:
        return a(f17459a, "updateShortcutTask", -999, "update shortcut task failed", null, 8, null);
    L17:
        if (d.h.b.o.a(r11, IAppContext.Companion.getPackageName()) == true) goto L20;
        return a(f17459a, "updateShortcutTask", -100, "not allowed to update task", null, 8, null);
    L9:
        return a(this, "updateShortcutTask", -100, "Permission denied", null, 8, null);
    }

    public final EventTaskResult a(String r16, String[] r17) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b r11 = com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a;
        StringBuilder r12 = new StringBuilder().append("removeShortcutTask ").append(r16).append(' ');
        if (r17 == null) goto L5;
        String r1 = d.a.i.a(r17, (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L6:
        r11.b(TAG, r12.append(r1).toString());
        if (r16 != null) goto L11;
        return a(this, "removeShortcutTask", -201, "Package name is null", null, 8, null);
    L11:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r16) == false) goto L13;
        if (r17 == null) goto L33;
        if (r17.length != 0) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == true) goto L33;
        List<ShortcutTask> r3 = (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(r16, r17, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r5 = 0;
    L23:
        if (r4.hasNext() == false) goto L26;
        ShortcutTask r6 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r4.next(), ShortcutTask.class, "com.obric.aiagent.plugin");
        r5 = r5 + ((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
        kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
        goto L23
    L26:
        if ((true ^ ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L28;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r16, 5);
    L28:
        if (r5 <= 0) goto L31;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r16, 6);
    L31:
        return a("removeShortcutTask", 0, "remove shortcut task success", r3);
    L18:
        r2 = false;
    L33:
        return a(this, "removeShortcutTask", -300, "taskIds is null or empty", null, 8, null);
    L13:
        return a(this, "removeShortcutTask", -100, "Permission denied", null, 8, null);
    L5:
        r1 = null;
        goto L6
    }

    public final EventTaskResult a(String r13, List<String> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L5;
        r15 = d.a.p.b();
    L5:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L7:
        if (r17.hasNext() == false) goto L11;
        Object r2 = r17.next();
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L7;
        r0.add(r2);
        goto L7
    L11:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "updateShortcutDisplayOrder start package=" + r13 + ", count=" + r18.size() + ", first=" + ((String) ZeusTransformUtils.preCheckCast(d.a.p.l(r18), String.class, "com.obric.aiagent.plugin")) + ", last=" + ((String) ZeusTransformUtils.preCheckCast(d.a.p.n(r18), String.class, "com.obric.aiagent.plugin")));
        if (r13 != null) goto L16;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "updateShortcutDisplayOrder failed: packageName is null");
        return a(this, "updateShortcutDisplayOrder", -201, "Package name is null", null, 8, null);
    L16:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r13) == true) goto L20;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "updateShortcutDisplayOrder failed: permission denied package=" + r13);
        return a(this, "updateShortcutDisplayOrder", -100, "Permission denied", null, 8, null);
    L20:
        if (r18.isEmpty() == false) goto L23;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "updateShortcutDisplayOrder failed: orderedTaskIds is empty");
        return a(this, "updateShortcutDisplayOrder", -300, "orderedTaskIds is empty", null, 8, null);
    L23:
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(r13, r18, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r1 == d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).size()) goto L27;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "updateShortcutDisplayOrder partial update request=" + d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).size() + ", updated=" + r1);
        return a(this, "updateShortcutDisplayOrder", -999, "update shortcut display order failed", null, 8, null);
    L27:
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r13, 5);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "updateShortcutDisplayOrder success package=" + r13 + ", updated=" + r1);
        return a(this, "updateShortcutDisplayOrder", 0, "update shortcut display order success", null, 8, null);
    }

    public final void a(String r12, String r13, String r14) {
        long r3 = System.currentTimeMillis();
        kotlinx.coroutines.i.a(f17462d, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r12, r13, r3, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final List<ShortcutTaskRecord> a(String r10, long r11, long r13, String r15) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getShortTaskRecordsByTaskId " + r10 + ' ' + r11 + ' ' + r13 + ' ' + r15);
        if (r10 != null) goto L5;
        return null;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r10) == false) goto L11;
        if (r15 != null) goto L9;
        return null;
    L9:
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r10, r11, r13, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    L11:
        return null;
    }

    public final List<ShortcutTaskRecord> a(String r9, long r10, long r12) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getAllShortcutTaskRecords " + r9 + ' ' + r10 + ' ' + r12);
        if (r9 != null) goto L5;
        return null;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r9) == true) goto L8;
        return null;
    L8:
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r9, r10, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    }

    public final int a(String r14, long[] r15) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b r13 = com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a;
        StringBuilder r0 = new StringBuilder().append("removeShortcutTaskRecordsById ").append(r14).append(' ');
        if (r15 == null) goto L5;
        String r3 = d.a.i.a(r15, (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L6:
        r13.b(TAG, r0.append(r3).toString());
        int r16 = 0;
        if (r14 != null) goto L9;
    L20:
        return r16;
    L9:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r14) == false) goto L20;
        if (r15 == null) goto L20;
        if (r15.length != 0) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == true) goto L20;
        r16 = ((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r14, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r16 <= 0) goto L20;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r14, 6);
        goto L20
    L14:
        r1 = false;
        goto L15
    L5:
        r3 = null;
        goto L6
    }

    public final int e(String r4) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "removeAllShortcutTaskRecords " + r4);
        if (r4 != null) goto L5;
        return 0;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r4) == false) goto L13;
        int r3 = ((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r3 <= 0) goto L10;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r4, 6);
    L10:
        return r3;
    L13:
        return 0;
    }

    static /* synthetic */ EventTaskResult a(a r1, String r2, int r3, String r4, List r5, int r6, Object r7) {
        List<ShortcutTask> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r8 = null;
    L6:
        return r1.a(r2, r3, r4, r8);
    }

    private final EventTaskResult a(String r8, int r9, String r10, List<ShortcutTask> r11) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a(TAG, "getResult " + r8 + " code = " + r9 + ", msg = " + r10);
        return new EventTaskResult(r9, r10, r3, null, 8, null);
    }
}
