package com.obric.autoaction.app.launcherpage.module;

import android.app.Activity;
import android.content.Context;
import android.util.EventsUtils;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.IAutoActionSessionManager;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskResult;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimerTask;
import com.obric.eventkit.task.model.TimerTaskResult;
import com.obric.eventkit.task.model.TimerTaskV2;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.z;
import d.o;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.bd;
import org.json.JSONObject;

/* JADX INFO: compiled from: TaskManagementViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends aj {
    private static final String TAG = "TaskManagementViewModel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w<com.obric.autoaction.app.launcherpage.module.a> f24141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ab<com.obric.autoaction.app.launcherpage.module.a> f24142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.module.datasource.a f24143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.module.datasource.b f24144e;

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {96}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$deleteConditionTaskTriggerRecords$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f24146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Long> f24147c;

        b(d r3, List<Long> r4, d.c.d<? super b> r5) {
            List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24146b = r3;
            this.f24147c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f24146b, this.f24147c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24145a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            com.obric.autoaction.app.launcherpage.module.datasource.b r7 = d.b(this.f24146b);
            List<Long> r2 = this.f24147c;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24145a = 1;
            if (r7.c(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {104, 106}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$deleteEventTaskExecutionRecord$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f24149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24150c;

        c(d r3, String r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24149b = r3;
            this.f24150c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f24149b, this.f24150c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24148a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r7);
        L17:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r7);
        L13:
            com.obric.autoaction.app.launcherpage.module.datasource.b r8 = d.b(this.f24149b);
            String r2 = this.f24150c;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24148a = 2;
            if (r8.a(r2, r3) != r0) goto L17;
            return r0;
        L10:
            o.a(r7);
            com.obric.autoaction.app.launcherpage.module.datasource.a r9 = d.a(this.f24149b);
            List<String> r4 = p.a(this.f24150c);
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24148a = 1;
            if (r9.b(r4, r5) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.module.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {68}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$deleteTask$1")
    static final class C0553d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f24152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f24153c;

        C0553d(d r3, long r4, d.c.d<? super C0553d> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24152b = r3;
            this.f24153c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0553d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0553d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0553d(this.f24152b, this.f24153c, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24151a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            com.obric.autoaction.app.launcherpage.module.datasource.a r7 = d.a(this.f24152b);
            List<Long> r2 = p.a(d.c.b.a.b.a(this.f24153c));
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24151a = 1;
            if (r7.a(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {78, 79}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$deleteTimerTask$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f24155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24156c;

        e(d r3, String r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24155b = r3;
            this.f24156c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f24155b, this.f24156c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24154a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r7);
        L16:
            IAutoActionSessionManager.IMPL.removeSessionByTimerTaskId(this.f24156c);
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r7);
        L13:
            com.obric.autoaction.app.launcherpage.module.datasource.a r8 = d.a(this.f24155b);
            List<String> r2 = p.a(this.f24156c);
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24154a = 2;
            if (r8.b(r2, r3) != r0) goto L16;
            return r0;
        L10:
            o.a(r7);
            com.obric.autoaction.app.launcherpage.module.datasource.b r9 = d.b(this.f24155b);
            List<String> r4 = p.a(this.f24156c);
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24154a = 1;
            if (r9.a(r4, r5) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {EventsUtils.FEAT_TYPE_PROC_FREQUENT_RESTART}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$deleteTimerTaskTriggerRecords$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f24158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Integer> f24159c;

        f(d r3, List<Integer> r4, d.c.d<? super f> r5) {
            List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24158b = r3;
            this.f24159c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f24158b, this.f24159c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24157a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            com.obric.autoaction.app.launcherpage.module.datasource.b r7 = d.b(this.f24158b);
            List<Integer> r2 = this.f24159c;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24157a = 1;
            if (r7.b(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {133}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$onJumpToConditionDetailPage$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.f f24162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f24163d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f24164e;

        g(String r3, com.obric.autoaction.app.launcherpage.module.datasource.f r4, Activity r5, String r6, d.c.d<? super g> r7) {
            Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24161b = r3;
            this.f24162c = r4;
            this.f24163d = ZeusTransformUtils.wrapperContext2Activity(r8, "com.obric.aiagent.plugin");
            this.f24164e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f24161b, this.f24162c, this.f24163d, this.f24164e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24160a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L13:
            EventTaskResult r12 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r11, EventTaskResult.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L20;
            List<EventTask> r2 = r12.getData();
            if (r2 == null) goto L20;
            EventTask r3 = (EventTask) ZeusTransformUtils.preCheckCast(p.l(r2), EventTask.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L20;
            String r4 = r3.getId();
        L22:
            if (com.obric.autoaction.app.launcherpage.detail.base.e.a(r12) == false) goto L26;
            if (r4 == null) goto L26;
            AOUserInterfaceTools.showAppToast$default(AOUserInterfaceTools.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.condition_event_update_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_update_toast"), false, 4, null);
            String r13 = r4;
        L27:
            com.obric.autoaction.app.launcherpage.detail.condition.a.a(com.obric.autoaction.app.launcherpage.detail.condition.a.f23400a, (Context) ZeusTransformUtils.preCheckCast(this.f24163d, Context.class, "com.obric.aiagent.plugin"), this.f24164e, r13, null, 8, null);
            return x.f38692a;
        L26:
            return x.f38692a;
        L20:
            r4 = null;
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            r13 = this.f24161b;
            if (ZeusTransformUtils.instanceOf(this.f24162c, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L27;
            com.obric.autoaction.app.launcherpage.condition.a.g r14 = com.obric.autoaction.app.launcherpage.condition.a.g.f22923a;
            com.obric.autoaction.app.launcherpage.module.datasource.f.c r5 = (com.obric.autoaction.app.launcherpage.module.datasource.f.c) ZeusTransformUtils.preCheckCast(this.f24162c, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class, "com.obric.aiagent.plugin");
            d.c.d<? super EventTaskResult> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24160a = 1;
            r11 = r14.a(r5, r6);
            if (r11 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {484}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$requestCloseConfirmation$2$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f24166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.module.a f24167c;

        h(d r3, com.obric.autoaction.app.launcherpage.module.a r4, d.c.d<? super h> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24166b = r3;
            this.f24167c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f24166b, this.f24167c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24165a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            w r7 = d.c(this.f24166b);
            com.obric.autoaction.app.launcherpage.module.a r2 = this.f24167c;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24165a = 1;
            if (r7.emit(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    static final class i implements d.h.a.b<Boolean, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n<d.m<String, Boolean>> f24168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24169b;

        i(kotlinx.coroutines.n<? super d.m<String, Boolean>> r3, String r4) {
            this.f24168a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            this.f24169b = r4;
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Boolean r3) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return x.f38692a;
        }

        public final void a(boolean r4) {
            d.c.d r0 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f24168a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r1 = d.n.f38560a;
            r0.resumeWith(d.n.f(s.a(this.f24169b, Boolean.valueOf(r4))));
        }
    }

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {113}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$skipTimerTask$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f24171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f24173d;

        j(d r3, String r4, long r5, d.c.d<? super j> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24171b = r3;
            this.f24172c = r4;
            this.f24173d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f24171b, this.f24172c, this.f24173d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24170a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.autoaction.app.launcherpage.module.datasource.b r8 = d.b(this.f24171b);
            String r2 = this.f24172c;
            List<Long> r3 = p.a(d.c.b.a.b.a(this.f24173d));
            d.c.d<? super TimerTaskResult> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24170a = 1;
            if (r8.a(r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {235, 299}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$switchConditionTaskEnableStatus$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f24175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f24176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24177d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f24178e;
        final /* synthetic */ String f;

        /* JADX INFO: compiled from: TaskManagementViewModel.kt */
        @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {241}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$switchConditionTaskEnableStatus$1$updateResult$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<ConditionTask, d.c.d<? super ConditionTask>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24179a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z.f<Integer> f24180b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f24181c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f24182d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ z.f<String> f24183e;
            final /* synthetic */ z.f<Integer> f;
            private /* synthetic */ Object g;

            a(z.f<Integer> r3, d r4, String r5, z.f<String> r6, z.f<Integer> r7, d.c.d<? super a> r8) {
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24180b = r3;
                this.f24181c = r4;
                this.f24182d = r5;
                this.f24183e = r6;
                this.f = r7;
                super(2, r9);
            }

            public final Object a(ConditionTask r3, d.c.d<? super ConditionTask> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
                a r12 = new a(this.f24180b, this.f24181c, this.f24182d, this.f24183e, this.f, r8);
                r12.g = r10;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(ConditionTask r3, d.c.d<? super ConditionTask> r4) {
                return a((ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Type inference failed for: r10v0 */
            /* JADX WARN: Type inference failed for: r10v1, types: [T, java.lang.Integer, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r10v2 */
            /* JADX WARN: Type inference failed for: r7v9, types: [T, java.lang.String] */
            /* JADX WARN: Type inference failed for: r8v0, types: [T, java.lang.Integer] */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r24) {
                Object r1 = d.c.a.b.a();
                int r2 = this.f24179a;
                int r3 = 2;
                if (r2 == 0) goto L8;
                if (r2 != 1) goto L7;
                ConditionTask r4 = (ConditionTask) ZeusTransformUtils.preCheckCast(this.g, ConditionTask.class, "com.obric.aiagent.plugin");
                o.a(r24);
                Object r7 = r24;
            L17:
                d.m r5 = (d.m) ZeusTransformUtils.preCheckCast(r7, d.m.class, "com.obric.aiagent.plugin");
                ?? r8 = (String) ZeusTransformUtils.preCheckCast(r5.c(), String.class, "com.obric.aiagent.plugin");
                boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r5.d(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
                this.f24183e.f38504a = r8;
                if (r6 == true) goto L21;
                r3 = 0;
            L21:
                ConditionTask r9 = r4;
                ?? r10 = d.c.b.a.b.a(r3);
            L34:
                this.f.f38504a = r10;
                Integer r0 = r9.getEnableStatus();
                if (r0 != null) goto L38;
            L40:
                String r18 = r9.getPeriodicPolicy().getExpireDate();
            L42:
                if (d.h.b.o.a(r9.getEnableStatus(), r10) == false) goto L45;
                return null;
            L45:
                return ConditionTask.copy$default(r9, null, null, null, r10, null, null, null, null, PeriodicPolicy.copy$default(r9.getPeriodicPolicy(), false, null, 0, null, false, false, r18, false, null, 447, null), null, 0, 1783, null);
            L38:
                if (r0.intValue() != 1) goto L40;
                r18 = null;
                goto L42
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r24);
                ConditionTask r11 = (ConditionTask) ZeusTransformUtils.preCheckCast(this.g, ConditionTask.class, "com.obric.aiagent.plugin");
                this.f24180b.f38504a = r11.getEnableStatus();
                Integer r12 = r11.getEnableStatus();
                if (r12 != null) goto L12;
            L22:
                if (r12 != null) goto L25;
            L28:
                if (r12 != null) goto L31;
            L33:
                Integer r13 = r11.getEnableStatus();
            L27:
                r10 = r13;
                r9 = r11;
                goto L34
            L31:
                if (r12.intValue() != 1) goto L33;
                r13 = d.c.b.a.b.a(0);
                goto L27
            L25:
                if (r12.intValue() != 2) goto L28;
                r13 = d.c.b.a.b.a(0);
                goto L27
            L12:
                if (r12.intValue() != 0) goto L22;
                d r14 = this.f24181c;
                String r15 = this.f24182d;
                d.c.d r16 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.g = r11;
                this.f24179a = 1;
                r7 = d.a(r14, r15, r16);
                if (r7 != r1) goto L16;
                return r1;
            L16:
                r4 = r11;
                goto L17
            }
        }

        k(d r3, String r4, d.c.d<? super k> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24178e = r3;
            this.f = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f24178e, this.f, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r19) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f24177d;
            boolean r4 = true;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            o.a(r19);
        L57:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            z.f r3 = (z.f) ZeusTransformUtils.preCheckCast(this.f24176c, z.f.class, "com.obric.aiagent.plugin");
            z.f r6 = (z.f) ZeusTransformUtils.preCheckCast(this.f24175b, z.f.class, "com.obric.aiagent.plugin");
            z.f r7 = (z.f) ZeusTransformUtils.preCheckCast(this.f24174a, z.f.class, "com.obric.aiagent.plugin");
            o.a(r19);
            Object r5 = r19;
        L13:
            ConditionTaskResult r8 = (ConditionTaskResult) ZeusTransformUtils.preCheckCast(r5, ConditionTaskResult.class, "com.obric.aiagent.plugin");
            Loog r9 = Loog.INSTANCE;
            StringBuilder r10 = new StringBuilder().append("switchConditionTaskEnableStatus timerTaskId=").append(this.f).append(", oldStatus=").append(r6.f38504a).append(", newStatus=").append(r3.f38504a).append(", resultCode=");
            if (r8 == null) goto L16;
            Integer r11 = d.c.b.a.b.a(r8.getCode());
        L17:
            r9.i(d.TAG, r10.append(r11).toString());
            if (r8 == null) goto L57;
            if (r8.getCode() != 0) goto L57;
            List<ConditionTask> r12 = r8.getData();
            if (r12 == null) goto L24;
            ConditionTask r13 = (ConditionTask) ZeusTransformUtils.preCheckCast(p.l(r12), ConditionTask.class, "com.obric.aiagent.plugin");
        L25:
            if (r13 == null) goto L27;
            com.obric.event.task.base.report.o.a(com.obric.event.task.base.report.o.f32870a, r13, "update", "gui", null, null, 24, null);
        L27:
            com.obric.event.task.base.report.l r14 = com.obric.event.task.base.report.l.f32861a;
            if (r13 == null) goto L35;
            Integer r15 = r13.getEnableStatus();
            if (r15 == null) goto L35;
            if (r15.intValue() != 0) goto L35;
            boolean r16 = true;
        L36:
            if (r13 == null) goto L38;
            Integer r17 = d.c.b.a.b.a(r13.getTaskMode());
        L39:
            r14.a(r16, r17);
            List<ConditionTask> r18 = r8.getData();
            if (r18 == null) goto L49;
            ConditionTask r20 = (ConditionTask) ZeusTransformUtils.preCheckCast(p.l(r18), ConditionTask.class, "com.obric.aiagent.plugin");
            if (r20 == null) goto L49;
            Integer r21 = r20.getEnableStatus();
            if (r21 == null) goto L49;
            if (r21.intValue() != 2) goto L49;
        L50:
            if (r4 == false) goto L57;
            IAutoActionSessionManager.IMPL.removeSessionByTimerTaskId(this.f);
            if (r7.f38504a == 0) goto L57;
            IAutoActionAgentApi.IMPL r22 = IAutoActionAgentApi.IMPL;
            String r23 = (String) ZeusTransformUtils.preCheckCast(r7.f38504a, String.class, "com.obric.aiagent.plugin");
            d.c.d<? super com.obric.autogui.common.e> r24 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24174a = null;
            this.f24175b = null;
            this.f24176c = null;
            this.f24177d = 2;
            if (r22.userTerminateQuery(r23, r24) != r1) goto L57;
            return r1;
        L49:
            r4 = false;
            goto L50
        L38:
            r17 = null;
        L35:
            r16 = false;
            goto L36
        L24:
            r13 = null;
            goto L25
        L16:
            r11 = null;
            goto L17
        L10:
            o.a(r19);
            r7 = new z.f();
            r6 = new z.f();
            r3 = new z.f();
            d r110 = this.f24178e;
            String r111 = this.f;
            d.h.a.m<? super ConditionTask, ? super d.c.d<? super ConditionTask>, ? extends Object> r25 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r6, this.f24178e, this.f, r7, r3, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d<? super ConditionTaskResult> r26 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24174a = r7;
            this.f24175b = r6;
            this.f24176c = r3;
            this.f24177d = 1;
            r5 = r110.a(r111, r25, r26);
            if (r5 != r1) goto L13;
            return r1;
        }
    }

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$switchEventTaskEnableStatus$1")
    static final class l extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f24185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24186c;

        l(d r3, String r4, d.c.d<? super l> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24185b = r3;
            this.f24186c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f24185b, this.f24186c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f24184a != 0) goto L27;
            o.a(r5);
            List r6 = (List) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.module.datasource.h.f24228a.a().c(), List.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L25;
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
            String r0 = this.f24186c;
            Iterator r8 = r7.iterator();
        L8:
            if (r8.hasNext() == false) goto L12;
            Object r2 = r8.next();
            if (d.h.b.o.a(((com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r2, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin")).a().getId(), r0) == false) goto L8;
        L13:
            com.obric.autoaction.app.launcherpage.module.datasource.f r9 = (com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r2, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L25;
            if (ZeusTransformUtils.instanceOf(r9, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L20;
            this.f24185b.g(this.f24186c);
        L23:
            return x.f38692a;
        L20:
            if (ZeusTransformUtils.instanceOf(r9, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L23;
            this.f24185b.f(this.f24186c);
            goto L23
        L12:
            r2 = null;
        L25:
            return x.f38692a;
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {182, 221}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$switchTimerTaskEnableStatus$1")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f24188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f24189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f24191e;
        final /* synthetic */ String f;

        /* JADX INFO: compiled from: TaskManagementViewModel.kt */
        @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {188}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$switchTimerTaskEnableStatus$1$updateResult$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<TimerTaskV2, d.c.d<? super TimerTaskV2>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f24192a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z.f<Integer> f24193b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d f24194c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f24195d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ z.f<String> f24196e;
            final /* synthetic */ z.f<Integer> f;
            private /* synthetic */ Object g;

            a(z.f<Integer> r3, d r4, String r5, z.f<String> r6, z.f<Integer> r7, d.c.d<? super a> r8) {
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                this.f24193b = r3;
                this.f24194c = r4;
                this.f24195d = r5;
                this.f24196e = r6;
                this.f = r7;
                super(2, r9);
            }

            public final Object a(TimerTaskV2 r3, d.c.d<? super TimerTaskV2> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
                a r12 = new a(this.f24193b, this.f24194c, this.f24195d, this.f24196e, this.f, r8);
                r12.g = r10;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(TimerTaskV2 r3, d.c.d<? super TimerTaskV2> r4) {
                return a((TimerTaskV2) ZeusTransformUtils.preCheckCast(r3, TimerTaskV2.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.String] */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.Integer] */
            /* JADX WARN: Type inference failed for: r5v3 */
            /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.Integer] */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r14) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f24192a;
                int r2 = 0;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                TimerTaskV2 r3 = (TimerTaskV2) ZeusTransformUtils.preCheckCast(this.g, TimerTaskV2.class, "com.obric.aiagent.plugin");
                o.a(r14);
            L17:
                d.m r15 = (d.m) ZeusTransformUtils.preCheckCast(r14, d.m.class, "com.obric.aiagent.plugin");
                ?? r4 = (String) ZeusTransformUtils.preCheckCast(r15.c(), String.class, "com.obric.aiagent.plugin");
                boolean r16 = ((Boolean) ZeusTransformUtils.preCheckCast(r15.d(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
                this.f24196e.f38504a = r4;
                if (r16 == false) goto L20;
                r2 = 2;
            L20:
                ?? r5 = d.c.b.a.b.a(r2);
                TimerTaskV2 r6 = r3;
            L28:
                this.f.f38504a = r5;
                return TimerTaskV2.copy$default(r6, null, null, null, r5, null, null, null, null, null, 503, null);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r14);
                TimerTaskV2 r17 = (TimerTaskV2) ZeusTransformUtils.preCheckCast(this.g, TimerTaskV2.class, "com.obric.aiagent.plugin");
                this.f24193b.f38504a = r17.getEnableStatus();
                Integer r7 = r17.getEnableStatus();
                if (r7 != null) goto L12;
            L21:
                if (r7 != null) goto L24;
            L26:
                Integer r8 = r17.getEnableStatus();
            L27:
                r6 = r17;
                r5 = r8;
                goto L28
            L24:
                if (r7.intValue() != 2) goto L26;
                r8 = d.c.b.a.b.a(0);
                goto L27
            L12:
                if (r7.intValue() != 0) goto L21;
                d r9 = this.f24194c;
                String r10 = this.f24195d;
                d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.g = r17;
                this.f24192a = 1;
                Object r12 = d.a(r9, r10, r11);
                if (r12 != r0) goto L16;
                return r0;
            L16:
                r3 = r17;
                r14 = r12;
                goto L17
            }
        }

        m(d r3, String r4, d.c.d<? super m> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24191e = r3;
            this.f = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f24191e, this.f, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r19) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f24190d;
            boolean r4 = true;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            o.a(r19);
        L50:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            z.f r3 = (z.f) ZeusTransformUtils.preCheckCast(this.f24189c, z.f.class, "com.obric.aiagent.plugin");
            z.f r6 = (z.f) ZeusTransformUtils.preCheckCast(this.f24188b, z.f.class, "com.obric.aiagent.plugin");
            z.f r7 = (z.f) ZeusTransformUtils.preCheckCast(this.f24187a, z.f.class, "com.obric.aiagent.plugin");
            o.a(r19);
            Object r5 = r19;
        L13:
            TimerTaskResult r8 = (TimerTaskResult) ZeusTransformUtils.preCheckCast(r5, TimerTaskResult.class, "com.obric.aiagent.plugin");
            Loog r9 = Loog.INSTANCE;
            StringBuilder r10 = new StringBuilder().append("switchTimerTaskEnableStatus timerTaskId=").append(this.f).append(", oldStatus=").append(r6.f38504a).append(", newStatus=").append(r3.f38504a).append(", resultCode=");
            if (r8 == null) goto L16;
            Integer r11 = d.c.b.a.b.a(r8.getCode());
        L17:
            r9.i(d.TAG, r10.append(r11).toString());
            if (r8 == null) goto L50;
            if (r8.getCode() != 0) goto L50;
            com.obric.event.task.base.report.l r12 = com.obric.event.task.base.report.l.f32861a;
            List<TimerTask> r13 = r8.getData();
            if (r13 == null) goto L31;
            TimerTask r14 = (TimerTask) ZeusTransformUtils.preCheckCast(p.l(r13), TimerTask.class, "com.obric.aiagent.plugin");
            if (r14 == null) goto L31;
            Integer r15 = r14.getEnableStatus();
            if (r15 == null) goto L31;
            if (r15.intValue() != 0) goto L31;
            boolean r16 = true;
        L32:
            r12.a(r16, d.c.b.a.b.a(0));
            List<TimerTask> r17 = r8.getData();
            if (r17 == null) goto L42;
            TimerTask r18 = (TimerTask) ZeusTransformUtils.preCheckCast(p.l(r17), TimerTask.class, "com.obric.aiagent.plugin");
            if (r18 == null) goto L42;
            Integer r20 = r18.getEnableStatus();
            if (r20 == null) goto L42;
            if (r20.intValue() != 2) goto L42;
        L43:
            if (r4 == false) goto L50;
            IAutoActionSessionManager.IMPL.removeSessionByTimerTaskId(this.f);
            if (r7.f38504a == 0) goto L50;
            IAutoActionAgentApi.IMPL r21 = IAutoActionAgentApi.IMPL;
            String r22 = (String) ZeusTransformUtils.preCheckCast(r7.f38504a, String.class, "com.obric.aiagent.plugin");
            d.c.d<? super com.obric.autogui.common.e> r23 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24187a = null;
            this.f24188b = null;
            this.f24189c = null;
            this.f24190d = 2;
            if (r21.userTerminateQuery(r22, r23) != r1) goto L50;
            return r1;
        L42:
            r4 = false;
        L31:
            r16 = false;
            goto L32
        L16:
            r11 = null;
            goto L17
        L10:
            o.a(r19);
            r7 = new z.f();
            r6 = new z.f();
            r3 = new z.f();
            com.obric.autoaction.app.launcherpage.module.datasource.b r110 = d.b(this.f24191e);
            String r111 = this.f;
            d.h.a.m<? super TimerTaskV2, ? super d.c.d<? super TimerTaskV2>, ? extends Object> r24 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r6, this.f24191e, this.f, r7, r3, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d<? super TimerTaskResult> r25 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24187a = r7;
            this.f24188b = r6;
            this.f24189c = r3;
            this.f24190d = 1;
            r5 = r110.a(r111, r24, r25);
            if (r5 != r1) goto L13;
            return r1;
        }
    }

    /* JADX INFO: compiled from: TaskManagementViewModel.kt */
    @d.c.b.a.f(b = "TaskManagementViewModel.kt", c = {379, 379, 381}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.TaskManagementViewModel$updateConditionTask$4")
    static final class n extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ConditionTaskResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.m<ConditionTask, d.c.d<? super ConditionTask>, Object> f24199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f24200d;

        n(String r3, d.h.a.m<? super ConditionTask, ? super d.c.d<? super ConditionTask>, ? extends Object> r4, d r5, d.c.d<? super n> r6) {
            d.h.a.m<ConditionTask, d.c.d<? super ConditionTask>, Object> r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24198b = r3;
            this.f24199c = r7;
            this.f24200d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super ConditionTaskResult> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f24198b, this.f24199c, this.f24200d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ConditionTaskResult> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r19) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f24197a;
            ConditionTaskResult r6 = null;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L9;
            o.a(r19);
            Object r3 = r19;
        L34:
            r6 = (ConditionTaskResult) ZeusTransformUtils.preCheckCast(r3, ConditionTaskResult.class, "com.obric.aiagent.plugin");
        L35:
            d.a(this.f24200d, r6, "switch_enable");
        L36:
            return r6;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            o.a(r19);
            Object r4 = r19;
        L22:
            ConditionTask r5 = (ConditionTask) ZeusTransformUtils.preCheckCast(r4, ConditionTask.class, "com.obric.aiagent.plugin");
        L24:
            if (r5 == null) goto L36;
            IEventTaskApi r8 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L35;
            String r9 = this.f24198b;
            List<ConditionTaskAction> r10 = r5.getActions();
            String r11 = r5.getName();
            ConditionGroup r12 = r5.getConditions();
            PeriodicPolicy r13 = r5.getPeriodicPolicy();
            TriggerControlPolicy r14 = r5.getTriggerControlPolicy();
            Integer r7 = r5.getEnableStatus();
            if (r7 == null) goto L30;
            int r15 = r7.intValue();
        L31:
            Map<String, String> r16 = r5.getExt();
            d.c.d<? super ConditionTaskResult> r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24197a = 3;
            r3 = r8.updateConditionTask(r9, r10, r11, r12, r13, r14, r15, r16, r17);
            if (r3 != r1) goto L34;
            return r1;
        L30:
            r15 = 0;
            goto L31
        L11:
            o.a(r19);
            Object r18 = r19;
        L17:
            ConditionTask r20 = (ConditionTask) ZeusTransformUtils.preCheckCast(r18, ConditionTask.class, "com.obric.aiagent.plugin");
            if (r20 == null) goto L23;
            d.h.a.m<ConditionTask, d.c.d<? super ConditionTask>, Object> r21 = this.f24199c;
            this.f24197a = 2;
            r4 = r21.invoke(r20, this);
            if (r4 != r1) goto L22;
            return r1;
        L23:
            r5 = null;
            goto L24
        L12:
            o.a(r19);
            IEventTaskApi r22 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r22 == null) goto L23;
            String r23 = this.f24198b;
            d.c.d<? super ConditionTask> r24 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24197a = 1;
            r18 = r22.getConditionTask(r23, r24);
            if (r18 != r1) goto L17;
            return r1;
        }
    }

    static {
        f24140a = new a(null);
    }

    public d() {
        w<com.obric.autoaction.app.launcherpage.module.a> r0 = ad.a(0, 0, null, 7, null);
        this.f24141b = r0;
        this.f24142c = kotlinx.coroutines.b.j.a(r0);
        this.f24143d = (com.obric.autoaction.app.launcherpage.module.datasource.a) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.datasource.e(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin"))), com.obric.autoaction.app.launcherpage.module.datasource.a.class, "com.obric.aiagent.plugin");
        this.f24144e = (com.obric.autoaction.app.launcherpage.module.datasource.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.datasource.i(), com.obric.autoaction.app.launcherpage.module.datasource.b.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.a a(d r0) {
        return r0.f24143d;
    }

    public static final /* synthetic */ Object a(d r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(d r0, ConditionTaskResult r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.b b(d r0) {
        return r0.f24144e;
    }

    public static final /* synthetic */ w c(d r0) {
        return r0.f24141b;
    }

    public final ab<com.obric.autoaction.app.launcherpage.module.a> b() {
        return this.f24142c;
    }

    public final void a(long r9) {
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0553d(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r9) {
        d.h.b.o.e(r9, "timerTaskId");
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(List<Integer> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "triggerIds");
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void b(List<Long> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "triggerIds");
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void c(String r9) {
        d.h.b.o.e(r9, "timerTaskId");
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r10, long r11) {
        d.h.b.o.e(r10, "timerTaskId");
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(this, r10, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void d(String r1) {
        d.h.b.o.e(r1, "sessionKey");
        IAutoActionSessionManager.IMPL.dequeueSession(r1);
    }

    public final void a(Activity r13, String r14, String r15, com.obric.autoaction.app.launcherpage.module.datasource.f r16) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r13, Activity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "activity");
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r15, r16, r5, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void e(String r9) {
        d.h.b.o.e(r9, "eventTaskId");
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void f(String r9) {
        d.h.b.o.e(r9, "timerTaskId");
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void g(String r9) {
        d.h.b.o.e(r9, "timerTaskId");
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(this, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final Object a(String r5, d.h.a.m<? super ConditionTask, ? super d.c.d<? super ConditionTask>, ? extends Object> r6, d.c.d<? super ConditionTaskResult> r7) {
        d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r5, r8, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r9);
    }

    private final void a(ConditionTaskResult r18, String r19) {
        if (r18 != null) goto L6;
        Loog.INSTANCE.d(TAG, "update/create condition task faield with null");
        IAutoActionTrackingApi r5 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r7 = new JSONObject();
        r7.put(MonitorConstants.CODE, -100);
        r7.put("msg", "error, result is null");
        r7.put(DBHelper.BATTERY_COL_SCENE, r19);
        x r0 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r5, "condition_task_update", r7, false, false, null, 28, null);
        return;
    L6:
        List<ConditionTask> r6 = r18.getData();
        String r8 = null;
        ConditionTask r9 = null;
        r8 = null;
        if (r6 == null) goto L9;
        ConditionTask r10 = (ConditionTask) ZeusTransformUtils.preCheckCast(p.l(r6), ConditionTask.class, "com.obric.aiagent.plugin");
    L10:
        IAutoActionTrackingApi r11 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r12 = new JSONObject();
        r12.put(DBHelper.BATTERY_COL_SCENE, r19);
        r12.put(MonitorConstants.CODE, r18.getCode());
        r12.put("msg", r18.getMsg());
        String r1 = "";
        if (r10 == null) goto L14;
        String r2 = com.obric.event.task.base.report.d.f32758a.c(r10);
        if (r2 == null) goto L14;
    L15:
        r12.put("periodic", r2);
        if (r10 == null) goto L19;
        String r3 = com.obric.event.task.base.report.d.f32758a.b(r10);
        if (r3 == null) goto L19;
    L20:
        r12.put("location_condition", r3);
        if (r10 == null) goto L26;
        String r4 = com.obric.event.task.base.report.d.f32758a.a(r10);
        if (r4 == null) goto L26;
        r1 = r4;
    L26:
        r12.put("time_condition", r1);
        if (r10 == null) goto L33;
        ConditionGroup r13 = r10.getConditions();
        if (r13 == null) goto L33;
        ArrayList<Condition> r14 = r13.getConditions();
        if (r14 == null) goto L33;
        int r15 = r14.size();
    L34:
        r12.put("condition_count", r15);
        boolean r16 = false;
        if (r10 == null) goto L42;
        Integer r17 = r10.getEnableStatus();
        if (r17 == null) goto L42;
        if (r17.intValue() != 0) goto L42;
        r16 = true;
    L42:
        r12.put("enable", r16);
        x r20 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r11, "condition_task_update", r12, false, false, null, 28, null);
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L48;
        Loog r21 = Loog.INSTANCE;
        StringBuilder r22 = new StringBuilder().append("update/create condition task finish ").append(r18.getCode()).append(' ').append(r18.getMsg()).append(" \n ");
        List<ConditionTask> r23 = r18.getData();
        if (r23 == null) goto L47;
        r9 = (ConditionTask) ZeusTransformUtils.preCheckCast(p.l(r23), ConditionTask.class, "com.obric.aiagent.plugin");
    L47:
        r21.d(TAG, r22.append(r9).toString());
        return;
    L48:
        Loog r24 = Loog.INSTANCE;
        StringBuilder r25 = new StringBuilder().append("update/create condition task finish ").append(r18.getCode()).append(' ').append(r18.getMsg()).append(' ');
        List<ConditionTask> r26 = r18.getData();
        if (r26 == null) goto L53;
        ConditionTask r27 = (ConditionTask) ZeusTransformUtils.preCheckCast(p.l(r26), ConditionTask.class, "com.obric.aiagent.plugin");
        if (r27 == null) goto L53;
        r8 = r27.getId();
    L53:
        r24.d(TAG, r25.append(r8).toString());
        return;
    L33:
        r15 = -1;
    L19:
        r3 = "";
    L14:
        r2 = "";
        goto L15
    L9:
        r10 = null;
        goto L10
    }

    private final Object a(String r13, d.c.d<? super d.m<String, Boolean>> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        String r0 = IAutoActionAgentApi.IMPL.getOnGoingSessionKey();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == true) goto L12;
        IAutoActionAgentEventListener.SessionInfo r4 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(IAutoActionAgentApi.IMPL.getOngoingSessionInfo().a(), IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L18;
        AutoOperateTask r5 = r4.getTask();
        if (r5 == null) goto L18;
        String r6 = r5.getTimerTaskId();
    L20:
        if (d.h.b.o.a(r6, r13) == false) goto L26;
        kotlinx.coroutines.o r7 = new kotlinx.coroutines.o(d.c.a.b.a(r15), 1);
        r7.e();
        kotlinx.coroutines.i.a(ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, new com.obric.autoaction.app.launcherpage.module.a(r13, (d.h.a.b) ZeusTransformUtils.preCheckCast(new i((kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin"), r0), d.h.a.b.class, "com.obric.aiagent.plugin")), null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        Object r12 = r7.h();
        if (r12 != d.c.a.b.a()) goto L24;
        d.c.b.a.h.c(r15);
    L24:
        return r12;
    L26:
        return s.a(null, d.c.b.a.b.a(true));
    L18:
        r6 = null;
        goto L20
    L12:
        return s.a(null, d.c.b.a.b.a(true));
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L10
    }
}
