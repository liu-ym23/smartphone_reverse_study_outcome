package com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b;

import com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDatabase;
import com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.bean.ShortcutTaskBean;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.obric.eventkit.task.model.ShortcutTaskSpec;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;

/* JADX INFO: compiled from: ShortcutTaskRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "ShortcutTaskRepo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17565a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f17566b;

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {48}, d = "addShortcutTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo")
    static final class C0363b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f17569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f17570d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17571e;

        C0363b(b r3, d.c.d<? super C0363b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17570d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17569c = r3;
            this.f17571e |= Integer.MIN_VALUE;
            return this.f17570d.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {48}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$addShortcutTask$2$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ShortcutTaskBean f17574c;

        c(b r3, ShortcutTaskBean r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17573b = r3;
            this.f17574c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f17573b, this.f17574c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17572a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            r6.insert(this.f17574c);
            return x.f38692a;
        L14:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f17573b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17572a = 1;
            r5 = b.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {86}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$getEnableShortInstructTasks$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ShortcutTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17576b;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17576b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTask>> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f17576b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17575a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ShortcutTaskBean> r7 = r6.a();
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            b r4 = this.f17576b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(b.a(r4, (ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r9.next(), ShortcutTaskBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r10 = this.f17576b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17575a = 1;
            r5 = b.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {74}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$getKnowledgeSessionIdNotNullTasks$2")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ShortcutTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17579c;

        e(b r3, String r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17578b = r3;
            this.f17579c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTask>> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f17578b, this.f17579c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17577a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ShortcutTaskBean> r7 = r6.b(this.f17579c);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            b r4 = this.f17578b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(b.a(r4, (ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r9.next(), ShortcutTaskBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r10 = this.f17578b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17577a = 1;
            r5 = b.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {82}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$getShortInstructNotNullTasks$2")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ShortcutTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17582c;

        f(b r3, String r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17581b = r3;
            this.f17582c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTask>> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f17581b, this.f17582c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17580a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ShortcutTaskBean> r7 = r6.d(this.f17582c);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            b r4 = this.f17581b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(b.a(r4, (ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r9.next(), ShortcutTaskBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r10 = this.f17581b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17580a = 1;
            r5 = b.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {54}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$getTaskById$2$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ShortcutTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17585c;

        g(b r3, String r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17584b = r3;
            this.f17585c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ShortcutTask> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f17584b, this.f17585c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ShortcutTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17583a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L16;
            ShortcutTaskBean r7 = r6.a(this.f17585c);
            if (r7 == null) goto L16;
            return b.a(this.f17584b, r7);
        L16:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r8 = this.f17584b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17583a = 1;
            r5 = b.a(r8, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {62}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$getTaskSourceFrom$2$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17588c;

        h(b r3, String r4, d.c.d<? super h> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17587b = r3;
            this.f17588c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super String> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f17587b, this.f17588c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super String> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17586a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L16;
            ShortcutTaskBean r4 = r6.a(this.f17588c);
            if (r4 == null) goto L16;
            return r4.getSourceFrom();
        L16:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f17587b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17586a = 1;
            r5 = b.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {70}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$getTasksByPackageNamePaged$2")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ShortcutTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f17592d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f17593e;

        i(b r3, String r4, int r5, int r6, d.c.d<? super i> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17590b = r3;
            this.f17591c = r4;
            this.f17592d = r5;
            this.f17593e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTask>> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f17590b, this.f17591c, this.f17592d, this.f17593e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17589a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ShortcutTaskBean> r7 = r6.a(this.f17591c, this.f17592d, this.f17593e);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            b r4 = this.f17590b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(b.a(r4, (ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r9.next(), ShortcutTaskBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r10 = this.f17590b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17589a = 1;
            r5 = b.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {78}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$getTemplateIdNotNotNullTasks$2")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends ShortcutTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17596c;

        j(b r3, String r4, d.c.d<? super j> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17595b = r3;
            this.f17596c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<ShortcutTask>> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f17595b, this.f17596c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends ShortcutTask>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17594a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            List<ShortcutTaskBean> r7 = r6.c(this.f17596c);
            if (r7 == null) goto L20;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
            b r4 = this.f17595b;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L23;
            r2.add(b.a(r4, (ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r9.next(), ShortcutTaskBean.class, "com.obric.aiagent.plugin")));
            goto L17
        L23:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L20:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r10 = this.f17595b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17594a = 1;
            r5 = b.a(r10, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {167, 172}, d = "removeTasks", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f17600d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f17601e;
        int f;
        int g;
        /* synthetic */ Object h;
        final /* synthetic */ b i;
        int j;

        k(b r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return this.i.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {167}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$removeTasks$2$bean$1")
    static final class l extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ShortcutTaskBean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17604c;

        l(b r3, String r4, d.c.d<? super l> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17603b = r3;
            this.f17604c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ShortcutTaskBean> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f17603b, this.f17604c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ShortcutTaskBean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17602a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L16;
            return null;
        L16:
            return r6.a(this.f17604c);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f17603b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17602a = 1;
            r5 = b.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {172}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$removeTasks$2$result$1")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ShortcutTaskBean f17607c;

        m(b r3, ShortcutTaskBean r4, d.c.d<? super m> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17606b = r3;
            this.f17607c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f17606b, this.f17607c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17605a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.delete(this.f17607c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f17606b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17605a = 1;
            r5 = b.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {91}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$updateDisplayOrders$2")
    static final class n extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<String> f17609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17610c;

        n(List<String> r3, String r4, d.c.d<? super n> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17609b = r6;
            this.f17610c = r4;
            super(2, r7);
        }

        public static /* synthetic */ void lambda$6QMKgNyZm9mHQOAvUOonQ1tJ1XA(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r0, String r1, List r2, z.d r3) {
            a(r0, r1, r2, r3);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f17609b, this.f17610c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17608a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            TaskDatabase r7 = (TaskDatabase) ZeusTransformUtils.preCheckCast(r6, TaskDatabase.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            final com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r2 = r7.q();
            final List r3 = d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(this.f17609b, Iterable.class, "com.obric.aiagent.plugin"));
            final z.d r4 = new z.d();
            final String r5 = this.f17610c;
            r7.a(new $$Lambda$b$n$6QMKgNyZm9mHQOAvUOonQ1tJ1XA(r2, r5, r3, r4));
            ILogDepend.Companion.i(b.TAG, "updateDisplayOrders result package=" + this.f17610c + ", request=" + r3.size() + ", updated=" + r4.f38502a);
            return d.c.b.a.b.a(r4.f38502a);
        L14:
            return d.c.b.a.b.a(0);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.common.data.e r8 = com.obric.aiagent.executionengine.eventstaskmanager.common.data.e.f16691a;
            d.c.d<? super TaskDatabase> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17608a = 1;
            r6 = r8.a(r9);
            if (r6 != r0) goto L11;
            return r0;
        }

        private static final void a(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r7, String r8, List r9, z.d r10) {
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r11 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
            List<Long> r0 = r11.a(r8, r12);
            ILogDepend.Companion.i(b.TAG, "updateDisplayOrders package=" + r8 + ", request=" + r12.size() + ", slots=" + r0.size() + ", first=" + ((String) ZeusTransformUtils.preCheckCast(d.a.p.l(r12), String.class, "com.obric.aiagent.plugin")) + "->" + d.a.p.l(r0) + ", last=" + ((String) ZeusTransformUtils.preCheckCast(d.a.p.n(r12), String.class, "com.obric.aiagent.plugin")) + "->" + d.a.p.n(r0));
            Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.c((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            d.m r1 = (d.m) ZeusTransformUtils.preCheckCast(r13.next(), d.m.class, "com.obric.aiagent.plugin");
            r10.f38502a += r11.a(r8, (String) ZeusTransformUtils.preCheckCast(r1.c(), String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r1.d(), Number.class, "com.obric.aiagent.plugin")).longValue());
            goto L4
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {116}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$updateExt$2")
    static final class o extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17613c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f17614d;

        o(b r3, String r4, Map<String, String> r5, d.c.d<? super o> r6) {
            Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17612b = r3;
            this.f17613c = r4;
            this.f17614d = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f17612b, this.f17613c, this.f17614d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17611a;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            ShortcutTaskBean r2 = r6.a(this.f17613c);
            if (r2 == null) goto L18;
            r2.setExt(this.f17614d);
            if (r6.update(r2) > 0) goto L24;
            r3 = false;
        L24:
            return d.c.b.a.b.a(r3);
        L18:
            return d.c.b.a.b.a(false);
        L14:
            return d.c.b.a.b.a(false);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f17612b;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17611a = 1;
            r5 = b.a(r7, r4);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {125, AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT}, d = "updateTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo")
    static final class p extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f17617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f17618d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17619e;

        p(b r3, d.c.d<? super p> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17618d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17617c = r3;
            this.f17619e |= Integer.MIN_VALUE;
            return this.f17618d.b(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$updateTask$2$9")
    static final class q extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ShortcutTaskBean f17622c;

        q(b r3, ShortcutTaskBean r4, d.c.d<? super q> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17621b = r3;
            this.f17622c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((q) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new q(this.f17621b, this.f17622c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17620a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L14;
            int r4 = r6.update(this.f17622c);
        L16:
            return d.c.b.a.b.a(r4);
        L14:
            r4 = 0;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f17621b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17620a = 1;
            r5 = b.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskRepo.kt */
    @d.c.b.a.f(b = "ShortcutTaskRepo.kt", c = {125}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.repo.ShortcutTaskRepo$updateTask$2$bean$1$1")
    static final class r extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ShortcutTaskBean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f17624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17625c;

        r(b r3, String r4, d.c.d<? super r> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17624b = r3;
            this.f17625c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super ShortcutTaskBean> r4) {
            return ((r) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new r(this.f17624b, this.f17625c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ShortcutTaskBean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17623a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L16;
            return null;
        L16:
            return r6.a(this.f17625c);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r7 = this.f17624b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17623a = 1;
            r5 = b.a(r7, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        f17565a = new a(null);
    }

    public b() {
        this.f17566b = an.a((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.common.a.f16677a.a(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ShortcutTask a(b r0, ShortcutTaskBean r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(b r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Object b(d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a> r2) {
        d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.eventstaskmanager.common.data.e.f16691a.e(r1);
    }

    public final Object a(String r32, ShortcutTaskSpec r33, d.c.d<? super ShortcutTask> r34) {
        b r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r34, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, C0363b.class) == false) goto L7;
        C0363b r3 = (C0363b) ZeusTransformUtils.preCheckCast(r1, C0363b.class, "com.obric.aiagent.plugin");
        if ((r3.f17571e & Integer.MIN_VALUE) == 0) goto L7;
        r3.f17571e -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f17569c;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f17571e;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ShortcutTaskBean r6 = (ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r3.f17568b, ShortcutTaskBean.class, "com.obric.aiagent.plugin");
        b r7 = (b) ZeusTransformUtils.preCheckCast(r3.f17567a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        ShortcutTaskBean r8 = r6;
        r0 = r7;
    L28:
        return r0.a(r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        long r14 = System.currentTimeMillis();
        String r9 = "st_" + r14;
        List<ShortcutTaskAction> r10 = r33.getActions();
        if (r10 != null) goto L17;
        r10 = d.a.p.b();
    L17:
        List<ShortcutTaskAction> r11 = r10;
        String r12 = r33.getName();
        Integer r13 = r33.getTaskMode();
        boolean r15 = false;
        if (r13 == null) goto L20;
        int r16 = r13.intValue();
    L21:
        TaskKnowledge r17 = r33.getTaskKnowledge();
        String r18 = r33.getTemplateId();
        String r19 = r33.getShortInstruct();
        Boolean r110 = r33.isShortInstructEnable();
        if (r110 == null) goto L24;
        r15 = r110.booleanValue();
    L24:
        r8 = new ShortcutTaskBean(r9, r11, r12, r16, r17, r18, r19, r15, r32, 0, 0, r14, r14, r33.getExt(), r33.getOmniModel());
        au r20 = kotlinx.coroutines.i.b(r0.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r0, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r3.f17567a = r0;
        r3.f17568b = r8;
        r3.f17571e = 1;
        if (r20.a(r3) != r4) goto L28;
        return r4;
    L20:
        r16 = 0;
    L7:
        r3 = new C0363b(r0, r1);
        goto L8
    }

    public final Object a(String r9, d.c.d<? super ShortcutTask> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L9;
        Object r8 = kotlinx.coroutines.i.b(this.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
        if (r8 != d.c.a.b.a()) goto L8;
        return r8;
    L8:
        return (ShortcutTask) ZeusTransformUtils.preCheckCast(r8, ShortcutTask.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    public final Object b(String r9, d.c.d<? super String> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L9;
        Object r8 = kotlinx.coroutines.i.b(this.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
        if (r8 != d.c.a.b.a()) goto L8;
        return r8;
    L8:
        return (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    public final Object a(String r10, int r11, int r12, d.c.d<? super List<ShortcutTask>> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(this, r10, r11, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r14);
    }

    public final Object c(String r9, d.c.d<? super List<ShortcutTask>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    public final Object d(String r9, d.c.d<? super List<ShortcutTask>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    public final Object e(String r9, d.c.d<? super List<ShortcutTask>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r11);
    }

    public final Object a(d.c.d<? super List<ShortcutTask>> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r10);
    }

    public final Object a(String r9, List<String> r10, d.c.d<? super Integer> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r12, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r13);
    }

    public final Object a(String r9, Map<String, String> r10, d.c.d<? super Boolean> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.b(this.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(this, r9, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null).a(r13);
    }

    public final Object b(String r19, ShortcutTaskSpec r20, d.c.d<? super ShortcutTask> r21) {
        b r0 = this;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, p.class) == false) goto L7;
        p r5 = (p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.aiagent.plugin");
        if ((r5.f17619e & Integer.MIN_VALUE) == 0) goto L7;
        r5.f17619e -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f17617c;
        Object r6 = d.c.a.b.a();
        int r7 = r5.f17619e;
        boolean r9 = true;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        ShortcutTaskBean r1 = (ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r5.f17616b, ShortcutTaskBean.class, "com.obric.aiagent.plugin");
        b r2 = (b) ZeusTransformUtils.preCheckCast(r5.f17615a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
    L65:
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L67;
        return null;
    L67:
        return r2.a(r1);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ShortcutTaskSpec r8 = (ShortcutTaskSpec) ZeusTransformUtils.preCheckCast(r5.f17616b, ShortcutTaskSpec.class, "com.obric.aiagent.plugin");
        b r10 = (b) ZeusTransformUtils.preCheckCast(r5.f17615a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        ShortcutTaskSpec r11 = r8;
        r0 = r10;
    L21:
        ShortcutTaskBean r12 = (ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r4, ShortcutTaskBean.class, "com.obric.aiagent.plugin");
    L23:
        if (r12 != null) goto L25;
        return null;
    L25:
        List<ShortcutTaskAction> r13 = r11.getActions();
        if (r13 == null) goto L28;
        r12.setActions(r13);
    L28:
        String r14 = r11.getName();
        if (r14 == null) goto L31;
        r12.setName(r14);
    L31:
        Integer r15 = r11.getTaskMode();
        if (r15 == null) goto L34;
        r12.setTaskMode(((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue());
    L34:
        TaskKnowledge r16 = r11.getTaskKnowledge();
        if (r16 == null) goto L37;
        r12.setTaskKnowledge(r16);
    L37:
        Boolean r17 = r11.isShortInstructEnable();
        if (r17 == null) goto L40;
        r12.setShortInstructEnable(r17.booleanValue());
    L40:
        String r18 = r11.getShortInstruct();
        if (r18 == null) goto L43;
        r12.setShortInstruct(r18);
    L43:
        Integer r22 = r11.getEnableStatus();
        if (r22 == null) goto L55;
        if (((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.aiagent.plugin")).intValue() >= 0) goto L49;
        r9 = false;
    L49:
        if (r9 == true) goto L52;
        r22 = null;
    L52:
        if (r22 == null) goto L55;
        r12.setEnableStatus(((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.aiagent.plugin")).intValue());
    L55:
        if (r11.getExt() == null) goto L58;
        r12.setExt(r11.getExt());
    L58:
        if (r11.getOmniModel() == null) goto L60;
        r12.setOmniModel(r11.getOmniModel());
    L60:
        au r23 = kotlinx.coroutines.i.b(r0.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new q(r0, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r5.f17615a = r0;
        r5.f17616b = r12;
        r5.f17619e = 2;
        r4 = r23.a(r5);
        if (r4 != r6) goto L63;
        return r6;
    L63:
        ShortcutTaskBean r110 = r12;
        r2 = r0;
        r1 = r110;
        goto L65
    L16:
        d.o.a(r4);
        if (r19 == null) goto L22;
        au r24 = kotlinx.coroutines.i.b(r0.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new r(r0, r19, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r5.f17615a = r0;
        r11 = r20;
        r5.f17616b = r11;
        r5.f17619e = 1;
        r4 = r24.a(r5);
        if (r4 != r6) goto L21;
        return r6;
    L22:
        r11 = r20;
        r12 = null;
    L7:
        r5 = new p(r0, r3);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x012d -> B:38:0x01ac). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0168 -> B:13:0x007c). Please report as a decompilation issue!!! */
    public final Object a(String r33, String[] r34, d.c.d<? super List<ShortcutTask>> r35) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r35, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, k.class) == false) goto L7;
        k r3 = (k) ZeusTransformUtils.preCheckCast(r1, k.class, "com.obric.aiagent.plugin");
        if ((r3.j & Integer.MIN_VALUE) == 0) goto L7;
        r3.j -= Integer.MIN_VALUE;
        b r4 = this;
    L8:
        Object r2 = r3.h;
        Object r5 = d.c.a.b.a();
        int r6 = r3.j;
        if (r6 == 0) goto L17;
        if (r6 == 1) goto L16;
        if (r6 != 2) goto L15;
        int r7 = r3.g;
        int r8 = r3.f;
        ShortcutTaskBean r10 = (ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r3.f17601e, ShortcutTaskBean.class, "com.obric.aiagent.plugin");
        String[] r11 = (String[]) ZeusTransformUtils.preCheckCast(r3.f17600d, String[].class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.preCheckCast(r3.f17599c, List.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r3.f17598b, String.class, "com.obric.aiagent.plugin");
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.f17597a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L13:
        String[] r30 = r11;
        List r15 = r12;
        String r31 = r13;
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L36;
        List r9 = r15;
        r9.add(r0.a(ShortcutTaskBean.copy$default(r10, null, null, null, 0, null, null, null, false, null, 0, 3, 0, 0, null, null, 31743, null)));
    L37:
        int r14 = r7;
        Object r16 = r5;
        List r17 = r9;
        r4 = r0;
        k r18 = r3;
        String r19 = r31;
    L38:
        int r20 = r8 + 1;
        String[] r21 = r30;
    L18:
        if (r20 >= r14) goto L39;
        au r22 = kotlinx.coroutines.i.b(r4.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(r4, r21[r20], null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r18.f17597a = r4;
        r18.f17598b = r19;
        r18.f17599c = r17;
        r18.f17600d = r21;
        r18.f17601e = null;
        r18.f = r20;
        r18.g = r14;
        r18.j = 1;
        Object r23 = r22.a(r18);
        if (r23 != r16) goto L22;
        return r16;
    L22:
        r13 = r19;
        r12 = r17;
        r0 = r4;
        r2 = r23;
        r7 = r14;
        r11 = r21;
        r8 = r20;
        r3 = r18;
        r5 = r16;
    L23:
        r10 = (ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r2, ShortcutTaskBean.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L26;
        String r24 = r10.getSourceFrom();
    L28:
        if (d.h.b.o.a(r24, r13) == true) goto L30;
        r16 = r5;
        r30 = r11;
        r17 = r12;
        r18 = r3;
        r14 = r7;
        r4 = r0;
        r19 = r13;
        goto L38
    L30:
        au r25 = kotlinx.coroutines.i.b(r0.f17566b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r0, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r3.f17597a = r0;
        r3.f17598b = r13;
        r3.f17599c = r12;
        r3.f17600d = r11;
        r3.f17601e = r10;
        r3.f = r8;
        r3.g = r7;
        r3.j = 2;
        r2 = r25.a(r3);
        if (r2 != r5) goto L13;
        return r5;
    L26:
        r24 = null;
        goto L28
    L39:
        return r17;
    L36:
        r9 = r15;
        goto L37
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r7 = r3.g;
        r8 = r3.f;
        String[] r110 = (String[]) ZeusTransformUtils.preCheckCast(r3.f17600d, String[].class, "com.obric.aiagent.plugin");
        List r111 = (List) ZeusTransformUtils.preCheckCast(r3.f17599c, List.class, "com.obric.aiagent.plugin");
        String r112 = (String) ZeusTransformUtils.preCheckCast(r3.f17598b, String.class, "com.obric.aiagent.plugin");
        r0 = (b) ZeusTransformUtils.preCheckCast(r3.f17597a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        r13 = r112;
        r12 = r111;
        r11 = r110;
        goto L23
    L17:
        d.o.a(r2);
        List r26 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r21 = r34;
        r14 = r21.length;
        r16 = r5;
        r18 = r3;
        r20 = 0;
        r17 = r26;
        r19 = r33;
    L7:
        r4 = this;
        r3 = new k(r4, r1);
        goto L8
    }

    private final ShortcutTask a(ShortcutTaskBean r11) {
        ShortcutTask r10 = new ShortcutTask(r11.getTaskId(), r11.getName(), Integer.valueOf(r11.getTaskStatus()), Integer.valueOf(r11.getEnableStatus()), Long.valueOf(r11.getCreateTime()), r11.getExt(), r11.getShortInstruct(), r11.isShortInstructEnable(), r11.getActions());
        r10.setTaskMode(1);
        r10.setTaskKnowledge(r11.getTaskKnowledge());
        r10.setTemplateId(r11.getTemplateId());
        r10.setOmniModel(r11.getOmniModel());
        return r10;
    }
}
