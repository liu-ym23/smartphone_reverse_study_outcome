package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.crash.dumper.Scraps;
import com.obric.agent.IAgentService;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.c;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.d;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.e;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.time.AlarmReceiver;
import com.obric.aiagent.ipc.IAgentIpcManager;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.api.IAutoTaskApi;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.capabilitykit.entity.EntityContentProvider;
import com.obric.capabilitykit.entity.ResultCode;
import com.obric.eventkit.ITaskManagerApi;
import com.obric.eventkit.task.api.IEventTaskRecordApi;
import com.obric.eventkit.task.model.BatteryCondition;
import com.obric.eventkit.task.model.BluetoothCondition;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskRecord;
import com.obric.eventkit.task.model.ConditionTaskResult;
import com.obric.eventkit.task.model.ConditionTaskSpec;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.SmsCondition;
import com.obric.eventkit.task.model.StorageCondition;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.obric.eventkit.task.model.WifiCondition;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.ce;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: ConditionTaskManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "ConditionTaskManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.am f16742b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b f16743c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.a f16744d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a f16745e = null;
    private static final HashMap<d.m.c<? extends Condition>, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<? extends Condition>> f = null;
    private static final ConcurrentHashMap<String, kotlinx.coroutines.a.d<d.x>> g = null;
    private static final AtomicBoolean h = null;
    private static final kotlinx.coroutines.w<d.x> i = null;
    private static String j;
    private static volatile ca k;

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f16746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConditionTask f16747b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f16746a, r6.f16746a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f16747b, r6.f16747b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f16746a.hashCode() * 31) + this.f16747b.hashCode();
        }

        public String toString() {
            return "TriggerTaskContext(userId=" + this.f16746a + ", task=" + this.f16747b + ')';
        }

        public a(String r2, ConditionTask r3) {
            d.h.b.o.e(r2, "userId");
            d.h.b.o.e(r3, "task");
            this.f16746a = r2;
            this.f16747b = r3;
        }

        public final String a() {
            return this.f16746a;
        }

        public final ConditionTask b() {
            return this.f16747b;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {533}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$removeConditionTask$1$1")
    static final class aa extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionTask f16749b;

        aa(ConditionTask r3, d.c.d<? super aa> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16749b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Integer> r4) {
            return ((aa) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aa.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new aa(this.f16749b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Integer> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16748a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L14:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.a r7 = b.e();
            String r2 = this.f16749b.getId();
            if (r2 != null) goto L11;
            r2 = "";
        L11:
            d.c.d<? super Integer> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16748a = 1;
            r6 = r7.c(r2, r3);
            if (r6 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {536}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$removeConditionTask$1$2")
    static final class ab extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionTask f16751b;

        ab(ConditionTask r3, d.c.d<? super ab> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16751b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((ab) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ab.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ab(this.f16751b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16750a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L14:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            IAutoTaskApi r7 = (IAutoTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoTaskApi.class), IAutoTaskApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            EventTask r2 = (EventTask) ZeusTransformUtils.preCheckCast(this.f16751b, EventTask.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16750a = 1;
            if (r7.onTaskDelete(r2, r3) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {530}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$removeConditionTask$deletedTask$1")
    static final class ac extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super List<? extends ConditionTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String[] f16754c;

        ac(String r3, String[] r4, d.c.d<? super ac> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16753b = r3;
            this.f16754c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super List<ConditionTask>> r4) {
            return ((ac) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ac.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ac(this.f16753b, this.f16754c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super List<? extends ConditionTask>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16752a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r8 = b.d();
            String r2 = this.f16753b;
            String[] r3 = this.f16754c;
            d.c.d<? super List<ConditionTask>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16752a = 1;
            r7 = r8.a(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {649}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$removeConditionTaskRecordsById$result$1")
    static final class ad extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long[] f16757c;

        ad(String r3, long[] r4, d.c.d<? super ad> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16756b = r3;
            this.f16757c = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Integer> r4) {
            return ((ad) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ad.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ad(this.f16756b, this.f16757c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Integer> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16755a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.a r8 = b.e();
            String r2 = this.f16756b;
            long[] r3 = this.f16757c;
            d.c.d<? super Integer> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16755a = 1;
            r7 = r8.a(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ThreadUtils.kt */
    public static final class ae implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16758a;

        public ae(String r1) {
            this.f16758a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r1 = b.f16741a;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L9
            ITaskManagerApi r3 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            if (r3 == null) goto L6;
            r3.init((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
            d.x r0 = d.x.f38692a;     // Catch: Throwable -> L9
        L7:
            Object r4 = d.n.f(r0);     // Catch: Throwable -> L9
        L11:
            Throwable r5 = d.n.c(r4);
            if (r5 == null) goto L17;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "requestInitIfNeeded " + this.f16758a + " failed", r5);
            return;
        L17:
            return;
        L6:
            r0 = null;
        L9:
            th = move-exception;
            d.n.a r6 = d.n.f38560a;
            r4 = d.n.f(d.o.a(th));
            goto L11
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {244}, d = "retryUserId", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager")
    static final class af extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f16760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16761c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16762d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f16763e;
        final /* synthetic */ b f;
        int g;

        af(b r3, d.c.d<? super af> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16763e = r3;
            this.g |= Integer.MIN_VALUE;
            return b.a(this.f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {1005, 1024, DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED, 1267, DownloadErrorCode.ERROR_MALFORMED_URL, DownloadErrorCode.ERROR_STREAM_RESET, DownloadErrorCode.ERROR_TTNET_DOWNLOAD_API_NULL}, d = "scheduleTaskIfReady", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager")
    static final class ag extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f16767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f16768e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ b h;
        int i;

        ag(b r3, d.c.d<? super ag> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return b.a(this.h, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$scheduleTaskIfReady$result$1$1")
    static final class ah extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16769a;

        ah(d.c.d<? super ah> r3) {
            super(1, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(d.c.d<? super Boolean> r3) {
            return ((ah) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), ah.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ah((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r1) {
            d.c.a.b.a();
            if (this.f16769a != 0) goto L7;
            d.o.a(r1);
            return d.c.b.a.b.a(true);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$scheduleTaskIfReady$result$1$2")
    static final class ai extends d.c.b.a.l implements d.h.a.m<d.x, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16770a;

        ai(d.c.d<? super ai> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(d.x r3, d.c.d<? super Boolean> r4) {
            return ((ai) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ai.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ai((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(d.x r3, d.c.d<? super Boolean> r4) {
            return a((d.x) ZeusTransformUtils.preCheckCast(r3, d.x.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r1) {
            d.c.a.b.a();
            if (this.f16770a != 0) goto L7;
            d.o.a(r1);
            return d.c.b.a.b.a(false);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {1120}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$skipTaskSchedule$sourceFrom$1")
    static final class aj extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16772b;

        aj(String r3, d.c.d<? super aj> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16772b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super String> r4) {
            return ((aj) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aj.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new aj(this.f16772b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super String> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16771a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r7 = b.d();
            String r2 = this.f16772b;
            d.c.d<? super String> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16771a = 1;
            r6 = r7.c(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {1139}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$tryScheduleConditionTask$task$1")
    static final class ak extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super ConditionTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16774b;

        ak(String r3, d.c.d<? super ak> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16774b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super ConditionTask> r4) {
            return ((ak) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ak.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ak(this.f16774b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super ConditionTask> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16773a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r7 = b.d();
            String r2 = this.f16774b;
            d.c.d<? super ConditionTask> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16773a = 1;
            r6 = r7.a(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {281, 285}, d = "unregisterAllTasks", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager")
    static final class al extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16777c;

        al(b r3, d.c.d<? super al> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16776b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16775a = r3;
            this.f16777c |= Integer.MIN_VALUE;
            return this.f16776b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {283}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$unregisterAllTasks$2")
    static final class am extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16778a;

        am(d.c.d<? super am> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((am) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new am((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16778a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            b r5 = b.f16741a;
            b.m("");
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            b r7 = b.f16741a;
            String r2 = b.c();
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16778a = 1;
            if (b.a(r7, r2, r3) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {1216}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$unregisterConditionTask$1")
    static final class an extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16781c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ConditionTask f16782d;

        an(ConditionTask r3, d.c.d<? super an> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16782d = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((an) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), an.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new an(this.f16782d, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16781c;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.f16780b, Iterator.class, "com.obric.aiagent.plugin");
            ConditionTask r4 = (ConditionTask) ZeusTransformUtils.preCheckCast(this.f16779a, ConditionTask.class, "com.obric.aiagent.plugin");
            d.o.a(r9);
        L17:
            if (r2.hasNext() == false) goto L24;
            Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            d.m.c r5 = (d.m.c) ZeusTransformUtils.preCheckCast(r10.getKey(), d.m.c.class, "com.obric.aiagent.plugin");
            List r11 = (List) ZeusTransformUtils.preCheckCast(r10.getValue(), List.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e r6 = b.a(b.f16741a, r5);
            if (r6 == null) goto L17;
            this.f16779a = r4;
            this.f16780b = r2;
            this.f16781c = 1;
            if (r6.b(r4, r11, this) != r0) goto L17;
            return r0;
        L24:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r9);
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "unregisterConditionTask " + this.f16782d.getId());
            Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(d.a(this.f16782d.getConditions()), Iterable.class, "com.obric.aiagent.plugin");
            Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            Iterator r13 = r12.iterator();
        L10:
            if (r13.hasNext() == false) goto L15;
            Object r7 = r13.next();
            d.m.c r8 = d.h.b.aa.b(((Condition) ZeusTransformUtils.preCheckCast(r7, Condition.class, "com.obric.aiagent.plugin")).getClass());
            Object r14 = r3.get(r8);
            if (r14 != null) goto L14;
            r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            r3.put(r8, r14);
        L14:
            ((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin")).add(r7);
            goto L10
        L15:
            ConditionTask r15 = this.f16782d;
            r2 = r3.entrySet().iterator();
            r4 = r15;
            goto L17
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {ResultCode.ERROR_MULTI_DETAIL}, d = "unregisterTasks", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager")
    static final class ao extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16785c;

        ao(b r3, d.c.d<? super ao> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16784b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16783a = r3;
            this.f16785c |= Integer.MIN_VALUE;
            return b.a(this.f16784b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {567}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$updateConditionDisplayOrder$updatedCount$1")
    static final class ap extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f16788c;

        ap(String r3, List<String> r4, d.c.d<? super ap> r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16787b = r3;
            this.f16788c = r6;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Integer> r4) {
            return ((ap) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ap.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ap(this.f16787b, this.f16788c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Integer> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16786a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r8 = b.d();
            String r2 = this.f16787b;
            List<String> r3 = this.f16788c;
            d.c.d<? super Integer> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16786a = 1;
            r7 = r8.a(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {482}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$updateConditionTask$newTask$1")
    static final class aq extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super ConditionTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<ConditionTaskAction> f16791c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16792d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ConditionGroup f16793e;
        final /* synthetic */ PeriodicPolicy f;
        final /* synthetic */ TriggerControlPolicy g;
        final /* synthetic */ int h;
        final /* synthetic */ Map<String, String> i;
        final /* synthetic */ int j;
        final /* synthetic */ TaskKnowledge k;
        final /* synthetic */ String l;
        final /* synthetic */ String m;

        aq(String r3, List<ConditionTaskAction> r4, String r5, ConditionGroup r6, PeriodicPolicy r7, TriggerControlPolicy r8, int r9, Map<String, String> r10, int r11, TaskKnowledge r12, String r13, String r14, d.c.d<? super aq> r15) {
            List<ConditionTaskAction> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            Map<String, String> r17 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
            d.c.d r18 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16790b = r3;
            this.f16791c = r16;
            this.f16792d = r5;
            this.f16793e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r17;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
            super(2, r18);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super ConditionTask> r4) {
            return ((aq) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aq.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r18, d.c.d<?> r19) {
            d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new aq(this.f16790b, this.f16791c, this.f16792d, this.f16793e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, r16), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super ConditionTask> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f16789a;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            d.o.a(r18);
            return r18;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r18);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r3 = b.d();
            String r4 = this.f16790b;
            List<ConditionTaskAction> r5 = this.f16791c;
            String r6 = this.f16792d;
            ConditionGroup r7 = this.f16793e;
            PeriodicPolicy r8 = this.f;
            TriggerControlPolicy r9 = this.g;
            int r10 = this.h;
            Map<String, String> r11 = this.i;
            int r12 = this.j;
            TaskKnowledge r13 = this.k;
            String r14 = this.l;
            String r15 = this.m;
            d.c.d<? super ConditionTask> r16 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16789a = 1;
            Object r0 = r3.a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
            if (r0 != r1) goto L12;
            return r1;
        L12:
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {473}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$updateConditionTask$sourceFrom$1")
    static final class ar extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionTask f16795b;

        ar(ConditionTask r3, d.c.d<? super ar> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16795b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super String> r4) {
            return ((ar) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ar.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ar(this.f16795b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super String> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16794a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r7 = b.d();
            String r2 = this.f16795b.getId();
            d.c.d<? super String> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16794a = 1;
            r6 = r7.c(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {469}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$updateConditionTask$task$1")
    static final class as extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super ConditionTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16797b;

        as(String r3, d.c.d<? super as> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16797b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super ConditionTask> r4) {
            return ((as) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), as.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new as(this.f16797b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super ConditionTask> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16796a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r7 = b.d();
            String r2 = this.f16797b;
            d.c.d<? super ConditionTask> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16796a = 1;
            r6 = r7.a(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {392}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$addConditionTask$task$1")
    static final class C0343b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super ConditionTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<ConditionTaskAction> f16800c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16801d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ConditionGroup f16802e;
        final /* synthetic */ PeriodicPolicy f;
        final /* synthetic */ TriggerControlPolicy g;
        final /* synthetic */ Map<String, String> h;
        final /* synthetic */ Integer i;
        final /* synthetic */ int j;
        final /* synthetic */ TaskKnowledge k;
        final /* synthetic */ String l;
        final /* synthetic */ String m;

        C0343b(String r3, List<ConditionTaskAction> r4, String r5, ConditionGroup r6, PeriodicPolicy r7, TriggerControlPolicy r8, Map<String, String> r9, Integer r10, int r11, TaskKnowledge r12, String r13, String r14, d.c.d<? super C0343b> r15) {
            List<ConditionTaskAction> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            Map<String, String> r17 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
            d.c.d r18 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16799b = r3;
            this.f16800c = r16;
            this.f16801d = r5;
            this.f16802e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r17;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
            super(2, r18);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super ConditionTask> r4) {
            return ((C0343b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0343b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r18, d.c.d<?> r19) {
            d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0343b(this.f16799b, this.f16800c, this.f16801d, this.f16802e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, r16), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super ConditionTask> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f16798a;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            d.o.a(r18);
            return r18;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r18);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r3 = b.d();
            String r4 = this.f16799b;
            List<ConditionTaskAction> r5 = this.f16800c;
            String r6 = this.f16801d;
            ConditionGroup r7 = this.f16802e;
            PeriodicPolicy r8 = this.f;
            TriggerControlPolicy r9 = this.g;
            Map<String, String> r10 = this.h;
            int r11 = this.i.intValue();
            Integer r12 = d.c.b.a.b.a(this.j);
            TaskKnowledge r13 = this.k;
            String r14 = this.l;
            String r15 = this.m;
            d.c.d<? super ConditionTask> r16 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16798a = 1;
            Object r0 = r3.a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
            if (r0 != r1) goto L12;
            return r1;
        L12:
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {841, 844, 849}, d = "awaitTriggeredTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16805c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f16806d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f16807e;
        int f;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16807e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16806d = r3;
            this.f |= Integer.MIN_VALUE;
            return b.a(this.f16807e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {670, 671, 677, 681, 684}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$checkConditionTask$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16810c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16811d;

        d(d.c.d<? super d> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01da -> B:64:0x01dd). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r28) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f16811d;
            boolean r8 = true;
            if (r2 == 0) goto L16;
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L14;
            if (r2 == 3) goto L13;
            if (r2 == 4) goto L12;
            if (r2 != 5) goto L11;
            Object r3 = this.f16810c;
            Iterator r4 = (Iterator) ZeusTransformUtils.preCheckCast(this.f16809b, Iterator.class, "com.obric.aiagent.plugin");
            Map r5 = (Map) ZeusTransformUtils.preCheckCast(this.f16808a, Map.class, "com.obric.aiagent.plugin");
            d.o.a(r28);
            Object r6 = r28;
        L64:
            String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
            Object r9 = r5.get(r7);
            if (r9 != null) goto L67;
            r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            r5.put(r7, r9);
        L67:
            ((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin")).add(r3);
        L60:
            if (r4.hasNext() == false) goto L68;
            r3 = r4.next();
            ConditionTask r10 = (ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r11 = b.d();
            String r12 = r10.getId();
            this.f16808a = r5;
            this.f16809b = r4;
            this.f16810c = r3;
            this.f16811d = 5;
            r6 = r11.c(r12, this);
            if (r6 != r1) goto L64;
            return r1;
        L68:
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.k((Iterable) ZeusTransformUtils.preCheckCast(r5.keySet(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L70:
            if (r0.hasNext() == false) goto L72;
            String r13 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r13, 3);
        L72:
            b.a(b.f16741a);
            return d.x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            Iterator r14 = (Iterator) ZeusTransformUtils.preCheckCast(this.f16809b, Iterator.class, "com.obric.aiagent.plugin");
            List r15 = (List) ZeusTransformUtils.preCheckCast(this.f16808a, List.class, "com.obric.aiagent.plugin");
            d.o.a(r28);
        L46:
            if (r14.hasNext() == false) goto L50;
            ConditionTask r16 = (ConditionTask) ZeusTransformUtils.preCheckCast(r14.next(), ConditionTask.class, "com.obric.aiagent.plugin");
            b.a(b.f16741a, r16);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r17 = b.d();
            String r18 = r16.getId();
            this.f16808a = r15;
            this.f16809b = r14;
            this.f16811d = 4;
            if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b.a(r17, r18, null, null, null, null, null, 1, null, 0, null, null, null, this, 4030, null) != r1) goto L46;
            return r1;
        L50:
            List r19 = r15;
        L51:
            Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin");
            if (r20 != null) goto L54;
        L57:
            if (r8 == true) goto L72;
            Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin");
            Map r22 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            r5 = r22;
            r4 = r21.iterator();
            goto L60
        L54:
            if (r20.isEmpty() == true) goto L57;
            r8 = false;
            goto L57
        L13:
            d.o.a(r28);
            Object r23 = r28;
        L33:
            List r24 = (List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.aiagent.plugin");
            if (r24 == null) goto L42;
            Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.aiagent.plugin");
            Collection r26 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r27 = r25.iterator();
        L37:
            if (r27.hasNext() == false) goto L41;
            Object r29 = r27.next();
            if (f.a(((ConditionTask) ZeusTransformUtils.preCheckCast(r29, ConditionTask.class, "com.obric.aiagent.plugin")).getPeriodicPolicy().getExpireDate()) == false) goto L37;
            r26.add(r29);
            goto L37
        L41:
            r19 = (List) ZeusTransformUtils.preCheckCast(r26, List.class, "com.obric.aiagent.plugin");
        L43:
            if (r19 == null) goto L51;
            Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            r15 = r19;
            r14 = r30;
            goto L46
        L42:
            r19 = null;
            goto L43
        L14:
            d.o.a(r28);
            Object r31 = r28;
        L26:
            String r32 = (String) ZeusTransformUtils.preCheckCast(r31, String.class, "com.obric.aiagent.plugin");
            if (r32 != null) goto L30;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(b.TAG, "checkConditionTask account database timeout");
            return d.x.f38692a;
        L30:
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "checkConditionTask");
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r33 = b.d();
            d.c.d<? super List<ConditionTask>> r34 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16811d = 3;
            r23 = r33.b(r32, r34);
            if (r23 != r1) goto L33;
            return r1;
        L15:
            d.o.a(r28);
            Object r35 = r28;
        L20:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r35, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L22;
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a r36 = b.f();
            d.c.d<? super String> r110 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16811d = 2;
            r31 = r36.a(OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, r110);
            if (r31 != r1) goto L26;
            return r1;
        L22:
            return d.x.f38692a;
        L16:
            d.o.a(r28);
            b r37 = b.f16741a;
            d.c.d r111 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16811d = 1;
            r35 = b.b(r37, "checkConditionTask", r111);
            if (r35 != r1) goto L20;
            return r1;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {828}, d = "ensureInitialized", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f16814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16815d;

        e(b r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16814c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16813b = r3;
            this.f16815d |= Integer.MIN_VALUE;
            return b.b(this.f16814c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {829}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$ensureInitialized$ready$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16816a;

        f(d.c.d<? super f> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Boolean> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Boolean> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16816a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return d.c.b.a.b.a(true);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            kotlinx.coroutines.w r6 = b.g();
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16816a = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {641}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$getAllConditionTaskRecords$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super List<? extends ConditionTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f16819c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f16820d;

        g(String r3, long r4, long r6, d.c.d<? super g> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16818b = r3;
            this.f16819c = r4;
            this.f16820d = r6;
            super(2, r9);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super List<ConditionTaskRecord>> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f16818b, this.f16819c, this.f16820d, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super List<? extends ConditionTaskRecord>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16817a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.a r2 = b.e();
            String r11 = this.f16818b;
            long r3 = this.f16819c;
            long r5 = this.f16820d;
            d.c.d<? super List<ConditionTaskRecord>> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16817a = 1;
            r10 = r2.a(r11, r3, r5, r7);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {582}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$getConditionTask$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super ConditionTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16822b;

        h(String r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16822b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super ConditionTask> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f16822b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super ConditionTask> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16821a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r7 = b.d();
            String r2 = this.f16822b;
            d.c.d<? super ConditionTask> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16821a = 1;
            r6 = r7.a(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {629}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$getConditionTaskRecordsByTaskId$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super List<? extends ConditionTaskRecord>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16824b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f16825c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f16826d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f16827e;

        i(String r3, long r4, long r6, String r8, d.c.d<? super i> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16824b = r3;
            this.f16825c = r4;
            this.f16826d = r6;
            this.f16827e = r8;
            super(2, r10);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super List<ConditionTaskRecord>> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f16824b, this.f16825c, this.f16826d, this.f16827e, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super List<? extends ConditionTaskRecord>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16823a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.a r2 = b.e();
            String r12 = this.f16824b;
            long r3 = this.f16825c;
            long r5 = this.f16826d;
            String r7 = this.f16827e;
            d.c.d<? super List<ConditionTaskRecord>> r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16823a = 1;
            r11 = r2.a(r12, r3, r5, r7, r8);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {590}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$getConditionTasks$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super List<? extends ConditionTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16829b;

        j(String r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16829b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super List<ConditionTask>> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f16829b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super List<? extends ConditionTask>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16828a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r7 = b.d();
            String r2 = this.f16829b;
            d.c.d<? super List<ConditionTask>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16828a = 1;
            r6 = r7.d(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {599}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$getConditionTasksPaged$result$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super List<? extends ConditionTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f16832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f16833d;

        k(String r3, int r4, int r5, d.c.d<? super k> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16831b = r3;
            this.f16832c = r4;
            this.f16833d = r5;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super List<ConditionTask>> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f16831b, this.f16832c, this.f16833d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super List<? extends ConditionTask>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16830a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r9 = b.d();
            String r2 = this.f16831b;
            int r3 = this.f16832c;
            int r4 = this.f16833d;
            d.c.d<? super List<ConditionTask>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16830a = 1;
            r8 = r9.a(r2, r3, r4, r5);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {608}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$getKnowledgeSessionIdNotNullConditionTasks$1")
    static final class l extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super List<? extends ConditionTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16835b;

        l(String r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16835b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super List<ConditionTask>> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f16835b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super List<? extends ConditionTask>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16834a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r7 = b.d();
            String r2 = this.f16835b;
            d.c.d<? super List<ConditionTask>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16834a = 1;
            r6 = r7.e(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {DownloadErrorCode.ERROR_BIZ_INTERCEPTOR}, d = "getLastTriggerTime", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager")
    static final class m extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f16837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16838c;

        m(b r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16837b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16836a = r3;
            this.f16838c |= Integer.MIN_VALUE;
            return b.c(this.f16837b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {616}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$getTemplateIdNotNullConditionTasks$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super List<? extends ConditionTask>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16840b;

        n(String r3, d.c.d<? super n> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16840b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super List<ConditionTask>> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f16840b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super List<? extends ConditionTask>> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16839a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r7 = b.d();
            String r2 = this.f16840b;
            d.c.d<? super List<ConditionTask>> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16839a = 1;
            r6 = r7.f(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {945, 952}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$onBatteryTriggerEvent$1")
    static final class o extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16842b;

        o(String r3, d.c.d<? super o> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16842b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f16842b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16841a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r8);
        L26:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
        L13:
            a r9 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L28;
            ConditionTask r10 = r9.b();
            if (r10 == null) goto L28;
            if (f.a(r10.getPeriodicPolicy()) == true) goto L22;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onBatteryTriggerEvent " + r10.getId() + " not in periodic policy");
            return d.x.f38692a;
        L22:
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onBatteryTriggerEvent " + r10.getId());
            b r2 = b.f16741a;
            com.obric.event.task.base.report.e.a r3 = com.obric.event.task.base.report.e.a.f32764e;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16841a = 2;
            if (b.a(r2, r10, r3, r4) != r0) goto L26;
            return r0;
        L28:
            return d.x.f38692a;
        L10:
            d.o.a(r8);
            b r11 = b.f16741a;
            String r5 = this.f16842b;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16841a = 1;
            r8 = b.a(r11, r5, "onBatteryTriggerEvent", r6);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {958, 965}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$onBluetoothTriggerEvent$1")
    static final class p extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16844b;

        p(String r3, d.c.d<? super p> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16844b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new p(this.f16844b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16843a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r8);
        L26:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
        L13:
            a r9 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L28;
            ConditionTask r10 = r9.b();
            if (r10 == null) goto L28;
            if (f.a(r10.getPeriodicPolicy()) == true) goto L22;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onBluetoothTriggerEvent " + r10.getId() + " not in periodic policy");
            return d.x.f38692a;
        L22:
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onBluetoothTriggerEvent " + r10.getId());
            b r2 = b.f16741a;
            com.obric.event.task.base.report.e.a r3 = com.obric.event.task.base.report.e.a.f32763d;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16843a = 2;
            if (b.a(r2, r10, r3, r4) != r0) goto L26;
            return r0;
        L28:
            return d.x.f38692a;
        L10:
            d.o.a(r8);
            b r11 = b.f16741a;
            String r5 = this.f16844b;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16843a = 1;
            r8 = b.a(r11, r5, "onBluetoothTriggerEvent", r6);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {903, 912}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$onLocationTriggerEvent$1")
    static final class q extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f16848d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f16849e;
        int f;
        final /* synthetic */ String g;

        q(String r3, d.c.d<? super q> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((q) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new q(this.g, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [T, com.obric.event.task.base.report.e$b] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r17) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            long r3 = this.f16849e;
            d.h.b.z.f r4 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(this.f16848d, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            d.h.b.z.f r7 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(this.f16847c, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            String r8 = (String) ZeusTransformUtils.preCheckCast(this.f16846b, String.class, "com.obric.aiagent.plugin");
            ConditionTask r0 = (ConditionTask) ZeusTransformUtils.preCheckCast(this.f16845a, ConditionTask.class, "com.obric.aiagent.plugin");
            d.o.a(r17);
            long r9 = r3;
            ConditionTask r5 = r0;
            T r6 = r17;
        L29:
            r4.f38504a = r6;
        L30:
            String r10 = r8;
            long r14 = r9;
            Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(d.c(r5.getConditions(), d.h.b.aa.b(LocationCondition.class)), Iterable.class, "com.obric.aiagent.plugin");
            Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r13 = r11.iterator();
        L32:
            if (r13.hasNext() == false) goto L42;
            Object r15 = r13.next();
            LocationCondition r16 = (LocationCondition) ZeusTransformUtils.preCheckCast(r15, LocationCondition.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e r18 = b.a(b.f16741a, d.h.b.aa.b(LocationCondition.class));
            boolean r19 = false;
            if (r18 == null) goto L40;
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a r20 = r18.a(r5, (Condition) ZeusTransformUtils.preCheckCast(r16, Condition.class, "com.obric.aiagent.plugin"));
            if (r20 == null) goto L40;
            if (r20.a() != true) goto L40;
            r19 = true;
        L40:
            if (r19 == false) goto L32;
            r12.add(r15);
            goto L32
        L42:
            Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L44:
            if (r21.hasNext() == false) goto L49;
            LocationCondition r110 = (LocationCondition) ZeusTransformUtils.preCheckCast(r21.next(), LocationCondition.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "location monitor trigger taskId=" + r10 + " result=" + ((com.obric.event.task.base.report.e.b) ZeusTransformUtils.preCheckCast(r7.f38504a, com.obric.event.task.base.report.e.b.class, "com.obric.aiagent.plugin")).a());
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.h r22 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.h.f17121a.a();
            if (r22 == null) goto L44;
            r22.a(r10, r110, r14, ((com.obric.event.task.base.report.e.b) ZeusTransformUtils.preCheckCast(r7.f38504a, com.obric.event.task.base.report.e.b.class, "com.obric.aiagent.plugin")).a());
            goto L44
        L49:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r17);
            Object r23 = r17;
        L13:
            a r24 = (a) ZeusTransformUtils.preCheckCast(r23, a.class, "com.obric.aiagent.plugin");
            if (r24 == null) goto L51;
            r5 = r24.b();
            if (r5 == null) goto L51;
            r8 = r5.getId();
            if (r8 == null) goto L21;
            r9 = System.currentTimeMillis();
            r7 = new d.h.b.z.f();
            r7.f38504a = com.obric.event.task.base.report.e.b.f32765a;
            if (f.a(r5.getPeriodicPolicy()) == true) goto L25;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onLocationTriggerEvent " + r8 + " not in periodic policy");
            goto L30
        L25:
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onLocationTriggerEvent " + r8);
            b r111 = b.f16741a;
            com.obric.event.task.base.report.e.a r112 = com.obric.event.task.base.report.e.a.f32761b;
            d.c.d r113 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16845a = r5;
            this.f16846b = r8;
            this.f16847c = r7;
            this.f16848d = r7;
            this.f16849e = r9;
            this.f = 2;
            Object r25 = b.a(r111, r5, r112, r113);
            if (r25 != r1) goto L28;
            return r1;
        L28:
            r4 = r7;
            r6 = r25;
            goto L29
        L21:
            return d.x.f38692a;
        L51:
            return d.x.f38692a;
        L10:
            d.o.a(r17);
            b r26 = b.f16741a;
            String r27 = this.g;
            d.c.d r28 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = 1;
            r23 = b.a(r26, r27, "onLocationTriggerEvent", r28);
            if (r23 != r1) goto L13;
            return r1;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {984, 991}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$onSmsTriggerEvent$1")
    static final class r extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16851b;

        r(String r3, d.c.d<? super r> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16851b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((r) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new r(this.f16851b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16850a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r8);
        L26:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
        L13:
            a r9 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L28;
            ConditionTask r10 = r9.b();
            if (r10 == null) goto L28;
            if (f.a(r10.getPeriodicPolicy()) == true) goto L22;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onSmsTriggerEvent " + r10.getId() + " not in periodic policy");
            return d.x.f38692a;
        L22:
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onSmsTriggerEvent " + r10.getId());
            b r2 = b.f16741a;
            com.obric.event.task.base.report.e.a r3 = com.obric.event.task.base.report.e.a.g;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16850a = 2;
            if (b.a(r2, r10, r3, r4) != r0) goto L26;
            return r0;
        L28:
            return d.x.f38692a;
        L10:
            d.o.a(r8);
            b r11 = b.f16741a;
            String r5 = this.f16851b;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16850a = 1;
            r8 = b.a(r11, r5, "onSmsTriggerEvent", r6);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {971, 978}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$onStorageTriggerEvent$1")
    static final class s extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16853b;

        s(String r3, d.c.d<? super s> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16853b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((s) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), s.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new s(this.f16853b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16852a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r8);
        L26:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
        L13:
            a r9 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L28;
            ConditionTask r10 = r9.b();
            if (r10 == null) goto L28;
            if (f.a(r10.getPeriodicPolicy()) == true) goto L22;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onStorageTriggerEvent " + r10.getId() + " not in periodic policy");
            return d.x.f38692a;
        L22:
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onStorageTriggerEvent " + r10.getId());
            b r2 = b.f16741a;
            com.obric.event.task.base.report.e.a r3 = com.obric.event.task.base.report.e.a.f;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16852a = 2;
            if (b.a(r2, r10, r3, r4) != r0) goto L26;
            return r0;
        L28:
            return d.x.f38692a;
        L10:
            d.o.a(r8);
            b r11 = b.f16741a;
            String r5 = this.f16853b;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16852a = 1;
            r8 = b.a(r11, r5, "onStorageTriggerEvent", r6);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {889, 892, 893, 896}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$onTimeTriggerEvent$1")
    static final class t extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16856c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16857d;

        t(String r3, d.c.d<? super t> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16857d = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((t) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new t(this.f16857d, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16856c;
            boolean r6 = true;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            d.o.a(r12);
        L43:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r11 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        L45:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ConditionTask r2 = (ConditionTask) ZeusTransformUtils.preCheckCast(this.f16854a, ConditionTask.class, "com.obric.aiagent.plugin");
            d.o.a(r12);
        L28:
            ConditionTask r13 = (ConditionTask) ZeusTransformUtils.preCheckCast(r12, ConditionTask.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L36;
            Integer r14 = r13.getEnableStatus();
            if (r14 == null) goto L36;
            if (r14.intValue() != 0) goto L36;
        L37:
            if (r6 == false) goto L45;
            List r15 = d.c(r2.getConditions(), d.h.b.aa.b(TimeCondition.class));
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e r4 = b.a(b.f16741a, d.h.b.aa.b(TimeCondition.class));
            if (r4 == null) goto L45;
            d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16854a = null;
            this.f16856c = 4;
            r12 = r4.a(r2, r15, r5);
            if (r12 != r0) goto L43;
            return r0;
        L36:
            r6 = false;
            goto L37
        L12:
            r2 = (ConditionTask) ZeusTransformUtils.preCheckCast(this.f16855b, ConditionTask.class, "com.obric.aiagent.plugin");
            a r7 = (a) ZeusTransformUtils.preCheckCast(this.f16854a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r12);
        L25:
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r16 = b.d();
            String r8 = r2.getId();
            String r9 = r7.a();
            d.c.d<? super ConditionTask> r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16854a = r2;
            this.f16855b = null;
            this.f16856c = 3;
            r12 = r16.a(r8, r9, r10);
            if (r12 != r0) goto L28;
            return r0;
        L13:
            d.o.a(r12);
        L17:
            a r17 = (a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L20;
            r2 = r17.b();
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onTimeTriggerEvent " + r2.getId());
            b r18 = b.f16741a;
            com.obric.event.task.base.report.e.a r19 = com.obric.event.task.base.report.e.a.f32760a;
            d.c.d r110 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16854a = r17;
            this.f16855b = r2;
            this.f16856c = 2;
            if (b.a(r18, r2, r19, r110) != r0) goto L24;
            return r0;
        L24:
            r7 = r17;
            goto L25
        L20:
            return d.x.f38692a;
        L14:
            d.o.a(r12);
            b r111 = b.f16741a;
            String r3 = this.f16857d;
            d.c.d r20 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16856c = 1;
            r12 = b.a(r111, r3, "onTimeTriggerEvent", r20);
            if (r12 != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {932, 939}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$onWifiTriggerEvent$1")
    static final class u extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16859b;

        u(String r3, d.c.d<? super u> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16859b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((u) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), u.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new u(this.f16859b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16858a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r8);
        L26:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r8);
        L13:
            a r9 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L28;
            ConditionTask r10 = r9.b();
            if (r10 == null) goto L28;
            if (f.a(r10.getPeriodicPolicy()) == true) goto L22;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onWifiTriggerEvent " + r10.getId() + " not in periodic policy");
            return d.x.f38692a;
        L22:
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "onWifiTriggerEvent " + r10.getId());
            b r2 = b.f16741a;
            com.obric.event.task.base.report.e.a r3 = com.obric.event.task.base.report.e.a.f32762c;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16858a = 2;
            if (b.a(r2, r10, r3, r4) != r0) goto L26;
            return r0;
        L28:
            return d.x.f38692a;
        L10:
            d.o.a(r8);
            b r11 = b.f16741a;
            String r5 = this.f16859b;
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16858a = 1;
            r8 = b.a(r11, r5, "onWifiTriggerEvent", r6);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {1105, 1109}, d = "realScheduleTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager")
    static final class v extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16861b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16862c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f16863d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f16864e;
        int f;

        v(b r3, d.c.d<? super v> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16864e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16863d = r3;
            this.f |= Integer.MIN_VALUE;
            return b.a(this.f16864e, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {190, 217, 221, 232}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$registerAllTasks$1$1")
    static final class w extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IFlowAppIntentIDL f16866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f16867c;

        w(IFlowAppIntentIDL r3, d.c.d<? super w> r4) {
            IFlowAppIntentIDL r5 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16866b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((w) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), w.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            w r0 = new w(this.f16866b, r5);
            r0.f16867c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16865a;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            d.o.a(r13);
        L86:
            com.obric.event.task.base.report.i.a(com.obric.event.task.base.report.i.f32779a, null, null, 3, null);
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r13);
        L73:
            List r14 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");
            b.f().a(b.c());
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "registerAllTasks account database ready, uid = " + b.c());
            com.obric.event.task.base.report.i.f32779a.a("register_task");
            if (r14 == null) goto L80;
            Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r15, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r16 = r15.iterator();
        L77:
            if (r16.hasNext() == false) goto L79;
            r2.add(b.a(b.f16741a, (ConditionTask) ZeusTransformUtils.preCheckCast(r16.next(), ConditionTask.class, "com.obric.aiagent.plugin"), "init"));
            goto L77
        L79:
            List r17 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        L81:
            if (r17 != null) goto L83;
            r17 = d.a.p.b();
        L83:
            b.a(b.f16741a);
            Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16865a = 4;
            if (kotlinx.coroutines.f.b(r18, r3) != r0) goto L86;
            return r0;
        L80:
            r17 = null;
            goto L81
        L12:
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f16867c, String.class, "com.obric.aiagent.plugin");
            d.o.a(r13);
        L67:
            b r19 = b.f16741a;
            if (r4 != null) goto L70;
            r4 = "";
        L70:
            b.m(r4);
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "registerAllTasks uidWithRegisterTask = " + b.c());
            com.obric.event.task.base.report.i.f32779a.a("get_task");
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r110 = b.d();
            String r5 = b.c();
            d.c.d<? super List<ConditionTask>> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16867c = null;
            this.f16865a = 3;
            r13 = r110.b(r5, r6);
            if (r13 != r0) goto L73;
            return r0;
        L13:
            kotlinx.coroutines.am r7 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f16867c, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            d.o.a(r13);
        L44:
            r4 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin");
        L46:
            if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.f16730a.a(r4) == true) goto L49;
            com.obric.event.task.base.report.i.f32779a.b("user_id_empty");
            com.obric.event.task.base.report.i.a(com.obric.event.task.base.report.i.f32779a, "userId is empty", null, 2, null);
            com.obric.event.task.base.report.e.f32759a.a(b.TAG, "retryUserId still empty after 3 retries");
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(b.TAG, "registerAllTasks skip, userId still empty after 3 retries");
            return d.x.f38692a;
        L49:
            com.obric.event.task.base.report.i.f32779a.a("register_precheck");
            IFlowAppIntentIDL r111 = this.f16866b;
            d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L52
            Object r112 = d.n.f(d.c.b.a.b.a(r111.isEnterpriseAccount()));     // Catch: Throwable -> L52
        L54:
            Throwable r10 = d.n.c(r112);
            if (r10 == null) goto L58;
            b.a(b.f16741a, "isEnterpriseAccount", r10);
        L58:
            if (d.n.b(r112) == false) goto L61;
            r112 = null;
        L61:
            if (d.h.b.o.a((Boolean) ZeusTransformUtils.preCheckCast(r112, Boolean.class, "com.obric.aiagent.plugin"), d.c.b.a.b.a(true)) == false) goto L64;
            com.obric.event.task.base.report.i.f32779a.b("enterprise_account");
            com.obric.event.task.base.report.i.a(com.obric.event.task.base.report.i.f32779a, "current is enterprise account", null, 2, null);
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "registerAllTasks skip current isEnterpriseAccount");
            return d.x.f38692a;
        L64:
            b r113 = b.f16741a;
            String r8 = b.c();
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16867c = r4;
            this.f16865a = 2;
            if (b.a(r113, r8, r11) != r0) goto L67;
            return r0;
        L52:
            th = move-exception;
            d.n.a r12 = d.n.f38560a;
            r112 = d.n.f(d.o.a(th));
            goto L54
        L14:
            d.o.a(r13);
            kotlinx.coroutines.am r114 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f16867c, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            com.obric.event.task.base.report.i.f32779a.a("get_user_id");
            IFlowAppIntentIDL r20 = this.f16866b;
            d.n.a r21 = d.n.f38560a;     // Catch: Throwable -> L17
            Object r22 = d.n.f(d.c.b.a.b.a(r20.isLogin()));     // Catch: Throwable -> L17
        L19:
            Throwable r23 = d.n.c(r22);
            if (r23 == null) goto L23;
            b.a(b.f16741a, "isLogin", r23);
        L23:
            if (d.n.b(r22) == false) goto L26;
            r22 = null;
        L26:
            if (d.h.b.o.a((Boolean) ZeusTransformUtils.preCheckCast(r22, Boolean.class, "com.obric.aiagent.plugin"), d.c.b.a.b.a(false)) == false) goto L28;
            com.obric.event.task.base.report.i.f32779a.a("user is not logged in", d.c.b.a.b.a(-4));
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "registerAllTasks skip, user is not logged in");
        L28:
            IFlowAppIntentIDL r24 = this.f16866b;
            d.n.a r25 = d.n.f38560a;     // Catch: Throwable -> L31
            Object r26 = d.n.f(r24.getUserId());     // Catch: Throwable -> L31
        L33:
            Throwable r27 = d.n.c(r26);
            if (r27 == null) goto L37;
            b.a(b.f16741a, "getUserId", r27);
        L37:
            if (d.n.b(r26) == false) goto L39;
            r26 = null;
        L39:
            r4 = (String) ZeusTransformUtils.preCheckCast(r26, String.class, "com.obric.aiagent.plugin");
            if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.f16730a.a(r4) == true) goto L46;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(b.TAG, "registerAllTasks userId empty, start retry");
            b r28 = b.f16741a;
            IFlowAppIntentIDL r29 = this.f16866b;
            d.c.d r115 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16867c = r114;
            this.f16865a = 1;
            r13 = b.a(r28, r29, r115);
            if (r13 != r0) goto L44;
            return r0;
        L31:
            th = move-exception;
            d.n.a r30 = d.n.f38560a;
            r26 = d.n.f(d.o.a(th));
        L17:
            th = move-exception;
            d.n.a r31 = d.n.f38560a;
            r22 = d.n.f(d.o.a(th));
            goto L19
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {1165}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$registerConditionTask$1")
    static final class x extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f16870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16871d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ConditionTask f16872e;
        final /* synthetic */ String f;

        x(ConditionTask r3, String r4, d.c.d<? super x> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16872e = r3;
            this.f = r4;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((x) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), x.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new x(this.f16872e, this.f, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16871d;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.f16870c, Iterator.class, "com.obric.aiagent.plugin");
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f16869b, String.class, "com.obric.aiagent.plugin");
            ConditionTask r5 = (ConditionTask) ZeusTransformUtils.preCheckCast(this.f16868a, ConditionTask.class, "com.obric.aiagent.plugin");
            d.o.a(r12);
            ConditionTask r13 = r5;
        L17:
            if (r2.hasNext() == false) goto L22;
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            d.m.c r7 = (d.m.c) ZeusTransformUtils.preCheckCast(r6.getKey(), d.m.c.class, "com.obric.aiagent.plugin");
            List r8 = (List) ZeusTransformUtils.preCheckCast(r6.getValue(), List.class, "com.obric.aiagent.plugin");
            b r9 = b.f16741a;
            this.f16868a = r13;
            this.f16869b = r4;
            this.f16870c = r2;
            this.f16871d = 1;
            if (b.a(r9, r13, r7, r8, r4, this) != r0) goto L17;
            return r0;
        L22:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(b.TAG, "registerConditionTask " + this.f16872e.getId());
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(d.a(this.f16872e.getConditions()), Iterable.class, "com.obric.aiagent.plugin");
            Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            Iterator r15 = r14.iterator();
        L10:
            if (r15.hasNext() == false) goto L15;
            Object r10 = r15.next();
            d.m.c r11 = d.h.b.aa.b(((Condition) ZeusTransformUtils.preCheckCast(r10, Condition.class, "com.obric.aiagent.plugin")).getClass());
            Object r16 = r3.get(r11);
            if (r16 != null) goto L14;
            r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            r3.put(r11, r16);
        L14:
            ((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin")).add(r10);
            goto L10
        L15:
            r13 = this.f16872e;
            r4 = this.f;
            r2 = r3.entrySet().iterator();
            goto L17
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {1179}, d = "registerSingleConditionTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager")
    static final class y extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f16874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f16875c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f16876d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f16877e;

        y(b r3, d.c.d<? super y> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16876d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f16875c = r7;
            this.f16877e |= Integer.MIN_VALUE;
            return b.a(this.f16876d, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ConditionTaskManager.kt */
    @d.c.b.a.f(b = "ConditionTaskManager.kt", c = {661}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.ConditionTaskManager$removeAllConditionTaskRecords$result$1")
    static final class z extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16879b;

        z(String r3, d.c.d<? super z> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16879b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super Integer> r4) {
            return ((z) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), z.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new z(this.f16879b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super Integer> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16878a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.a r7 = b.e();
            String r2 = this.f16879b;
            d.c.d<? super Integer> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16878a = 1;
            r6 = r7.b(r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ void lambda$WXk6dLu4G2H17wUotdSjLaV2Kq8(IFlowAppIntentIDL r0) {
        a(r0);
    }

    public static /* synthetic */ d.x lambda$ctvReZ76T4TffL_oak5Vj1dV37A(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g.a r0, Bundle r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$gGaT5kE7xDl-0TdTN6gB2jWbupw, reason: not valid java name */
    public static /* synthetic */ d.x m165lambda$gGaT5kE7xDl0TdTN6gB2jWbupw(String r0, d.h.a.a r1, boolean r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ d.x lambda$pyoADpeEWfV4CLP8WQAKRQP9J9s(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g.a r0) {
        return a(r0);
    }

    private b() {
    }

    public static final /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e a(b r2, d.m.c r3) {
        return r2.a((d.m.c) ZeusTransformUtils.wrapperContextForParams(r3, d.m.c.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, IFlowAppIntentIDL r3, d.c.d r4) {
        return r2.a((IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, ConditionTask r3, com.obric.event.task.base.report.e.a r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r8, ConditionTask r9, d.m.c r10, List r11, String r12, d.c.d r13) {
        return r8.a(r9, (d.m.c) ZeusTransformUtils.wrapperContextForParams(r10, d.m.c.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, ConditionTask r3, String r4, String r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, String r3, String r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ca a(b r0, ConditionTask r1, String r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(b r0) {
        r0.h();
    }

    public static final /* synthetic */ void a(b r0, ConditionTask r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(b r0, String r1, Throwable r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ Object b(b r2, String r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object c(b r2, String r3, d.c.d r4) {
        return r2.c(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String c() {
        return j;
    }

    public static final /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b d() {
        return f16743c;
    }

    public static final /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.a e() {
        return f16744d;
    }

    public static final /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a f() {
        return f16745e;
    }

    public static final /* synthetic */ kotlinx.coroutines.w g() {
        return i;
    }

    public static final /* synthetic */ void m(String r0) {
        j = r0;
    }

    static {
        f16741a = new b();
        f16742b = kotlinx.coroutines.an.a((d.c.g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.eventstaskmanager.common.a.f16677a.b(), d.c.g.class, "com.obric.aiagent.plugin"));
        f16743c = new com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b();
        f16744d = new com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.a();
        f16745e = new com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a();
        HashMap<d.m.c<? extends Condition>, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<? extends Condition>> r0 = new HashMap();
        r0.put(d.h.b.aa.b(TimeCondition.class), new com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.time.a());
        r0.put(d.h.b.aa.b(LocationCondition.class), new com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a());
        r0.put(d.h.b.aa.b(ConditionGroup.class), new com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.b((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")));
        r0.put(d.h.b.aa.b(BatteryCondition.class), new com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.a());
        r0.put(d.h.b.aa.b(BluetoothCondition.class), new com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.b.a());
        r0.put(d.h.b.aa.b(WifiCondition.class), new com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a());
        r0.put(d.h.b.aa.b(StorageCondition.class), new com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e.a());
        r0.put(d.h.b.aa.b(SmsCondition.class), new com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.a());
        f = r0;
        g = new ConcurrentHashMap();
        h = new AtomicBoolean(false);
        i = kotlinx.coroutines.y.a(null, 1, null);
        j = "";
    }

    public final void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        if (h.compareAndSet(false, true) == true) goto L6;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "init already done, skip");
        return;
    L6:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "init start");
        com.obric.event.task.base.report.i.f32779a.a();
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a.a(r5);
        com.obric.event.task.base.report.i.f32779a.a("ipc_callback_wait");
        a();
        i.a(d.x.f38692a);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "init done, initReady completed");
    }

    public final void a() {
        f16745e.a();
        com.obric.aiagent.assistant.idl.r.a(d.h.b.aa.b(IFlowAppIntentIDL.class), false, false, $$Lambda$b$WXk6dLu4G2H17wUotdSjLaV2Kq8.INSTANCE, 3, null);
    }

    private static final void a(IFlowAppIntentIDL r10) {
        IFlowAppIntentIDL r11 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r10, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "ipc");
        f16745e.a();
        ca r0 = k;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        k = kotlinx.coroutines.i.a(f16742b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new w(r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007c -> B:55:0x007d). Please report as a decompilation issue!!! */
    private final Object a(IFlowAppIntentIDL r11, d.c.d<? super String> r12) {
        IFlowAppIntentIDL r13 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r11, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, af.class) == false) goto L7;
        af r0 = (af) ZeusTransformUtils.preCheckCast(r14, af.class, "com.obric.aiagent.plugin");
        if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
        r0.g -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f16763e;
        Object r15 = d.c.a.b.a();
        int r2 = r0.g;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        int r16 = r0.f16762d;
        int r3 = r0.f16761c;
        int r5 = r0.f16760b;
        IFlowAppIntentIDL r6 = (IFlowAppIntentIDL) ZeusTransformUtils.preCheckCast(r0.f16759a, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        d.o.a(r10);
        IFlowAppIntentIDL r17 = r6;
    L55:
        d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L22
        Object r8 = d.n.f(r17.getUserId());     // Catch: Throwable -> L22
    L24:
        Throwable r9 = d.n.c(r8);
        if (r9 == null) goto L28;
        f16741a.a("retryGetUserId", r9);
    L28:
        if (d.n.b(r8) == false) goto L30;
        r8 = null;
    L30:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
        if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.f16730a.a(r18) == true) goto L48;
        d.n.a r19 = d.n.f38560a;     // Catch: Throwable -> L38
        IFlowAppIntentIDL r20 = com.obric.aiagent.assistant.idl.r.a(d.h.b.aa.b(IFlowAppIntentIDL.class));     // Catch: Throwable -> L38
        if (r20 == null) goto L35;
        String r21 = r20.getUserId();     // Catch: Throwable -> L38
    L36:
        Object r22 = d.n.f(r21);     // Catch: Throwable -> L38
    L40:
        Throwable r23 = d.n.c(r22);
        if (r23 == null) goto L44;
        f16741a.a("retryGetCurrentUserId", r23);
    L44:
        if (d.n.b(r22) == false) goto L46;
        r22 = null;
    L46:
        r18 = (String) ZeusTransformUtils.preCheckCast(r22, String.class, "com.obric.aiagent.plugin");
        goto L48
    L35:
        r21 = null;
    L38:
        th = move-exception;
        d.n.a r24 = d.n.f38560a;
        r22 = d.n.f(d.o.a(th));
    L48:
        if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.f16730a.a(r18) == false) goto L51;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "retryUserId success after " + (r16 + 1) + " retries");
        return r18;
    L51:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "retryUserId still empty, attempt=" + (r16 + 1) + "/3");
        r16 = r3 + 1;
    L15:
        if (r16 >= r5) goto L52;
        r0.f16759a = r17;
        r0.f16760b = r5;
        r0.f16761c = r16;
        r0.f16762d = r16;
        r0.g = 1;
        if (ax.a(EntityContentProvider.g, r0) != r15) goto L19;
        return r15;
    L19:
        r3 = r16;
        goto L55
    L52:
        return null;
    L22:
        th = move-exception;
        d.n.a r25 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        r5 = 3;
        r17 = r13;
        r16 = 0;
    L7:
        r0 = new af(this, r14);
        goto L8
    }

    private final void a(String r3, Throwable r4) {
        com.obric.event.task.base.report.i.f32779a.a("IFlowAppIntentIDL." + r3 + " failed", -6);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "registerAllTasks IPC call failed: " + r3, r4);
    }

    public final Object a(d.c.d<? super d.x> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, al.class) == false) goto L7;
        al r0 = (al) ZeusTransformUtils.preCheckCast(r12, al.class, "com.obric.aiagent.plugin");
        if ((r0.f16777c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16777c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f16775a;
        Object r13 = d.c.a.b.a();
        int r2 = r0.f16777c;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        d.o.a(r10);
    L25:
        return d.x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d.o.a(r10);
    L21:
        ca r14 = kotlinx.coroutines.i.a(f16742b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new am(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        r0.f16777c = 2;
        if (r14.b(r0) != r13) goto L25;
        return r13;
    L16:
        d.o.a(r10);
        f16745e.a();
        ca r15 = k;
        if (r15 == null) goto L21;
        r0.f16777c = 1;
        if (ce.a(r15, r0) != r13) goto L21;
        return r13;
    L7:
        r0 = new al(this, r12);
        goto L8
    }

    private final Object a(String r7, d.c.d<? super d.x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, ao.class) == false) goto L7;
        ao r0 = (ao) ZeusTransformUtils.preCheckCast(r9, ao.class, "com.obric.aiagent.plugin");
        if ((r0.f16785c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16785c -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f16783a;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f16785c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r6);
    L25:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L32;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L29:
        if (r12.hasNext() == false) goto L32;
        f16741a.a((ConditionTask) ZeusTransformUtils.preCheckCast(r12.next(), ConditionTask.class, "com.obric.aiagent.plugin"));
    L32:
        return d.x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L17;
        boolean r13 = true;
    L19:
        if (r13 == false) goto L22;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "unregisterTasks skip, uid is empty");
        return d.x.f38692a;
    L22:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "unregisterTasks, uid = " + r7);
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r14 = f16743c;
        r0.f16785c = 1;
        r6 = r14.b(r7, r0);
        if (r6 != r10) goto L25;
        return r10;
    L17:
        r13 = false;
    L7:
        r0 = new ao(this, r9);
        goto L8
    }

    public final Object a(String r2, Map<String, String> r3, d.c.d<? super Boolean> r4) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super Boolean> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return f16743c.a(r2, r1, r5);
    }

    public final EventTaskResult a(String r14, ConditionTaskSpec r15) {
        d.h.b.o.e(r15, "spec");
        b r0 = f16741a;
        List<ConditionTaskAction> r2 = r15.getActions();
        String r3 = r15.getName();
        ConditionGroup r4 = r15.getConditions();
        PeriodicPolicy r5 = r15.getPeriodicPolicy();
        TriggerControlPolicy r6 = r15.getTriggerControlPolicy();
        Map<String, String> r7 = r15.getExt();
        Integer r13 = r15.getEnableStatus();
        if (r13 == null) goto L5;
        int r16 = r13.intValue();
    L6:
        Integer r8 = Integer.valueOf(r16);
        Integer r17 = r15.getTaskMode();
        if (r17 == null) goto L9;
        int r9 = r17.intValue();
    L10:
        ConditionTaskResult r18 = r0.a(r14, r2, r3, r4, r5, r6, r7, r8, r9, r15.getTaskKnowledge(), r15.getTemplateId(), r15.getOmniModel());
        return new EventTaskResult(r18.getCode(), r18.getMsg(), r18.getData(), null, 8, null);
    L9:
        r9 = 0;
        goto L10
    L5:
        r16 = 0;
        goto L6
    }

    public static /* synthetic */ ConditionTaskResult a(b r16, String r17, List r18, String r19, ConditionGroup r20, PeriodicPolicy r21, TriggerControlPolicy r22, Map r23, Integer r24, int r25, TaskKnowledge r26, String r27, String r28, int r29, Object r30) {
        List<ConditionTaskAction> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        if ((r29 & 128) == 0) goto L5;
        Integer r11 = 0;
    L7:
        if ((r29 & 256) == 0) goto L9;
        int r12 = 0;
    L11:
        if ((r29 & 512) == 0) goto L13;
        TaskKnowledge r13 = null;
    L15:
        if ((r29 & 1024) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r29 & 2048) == 0) goto L21;
        String r15 = null;
    L23:
        return r16.a(r17, r5, r19, r20, r21, r22, r10, r11, r12, r13, r14, r15);
    L21:
        r15 = r28;
        goto L23
    L17:
        r14 = r27;
        goto L19
    L13:
        r13 = r26;
        goto L15
    L9:
        r12 = r25;
        goto L11
    L5:
        r11 = r24;
        goto L7
    }

    public final ConditionTaskResult a(String r19, List<ConditionTaskAction> r20, String r21, ConditionGroup r22, PeriodicPolicy r23, TriggerControlPolicy r24, Map<String, String> r25, Integer r26, int r27, TaskKnowledge r28, String r29, String r30) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "addConditionTask " + r19 + ' ' + r21 + ' ' + r23);
        if (r19 != null) goto L7;
        return a(this, "addConditionTask", -201, "Package name is null", null, 8, null);
    L7:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r19) == false) goto L9;
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == true) goto L78;
        if (r22 == null) goto L78;
        if (r23 == null) goto L78;
        if (r24 == null) goto L78;
        if (a(r23) == true) goto L25;
        List<Condition> r4 = d.a(r22);
        if (r4.isEmpty() == true) goto L29;
        if (r26 != null) goto L33;
    L34:
        if (r26 == null) goto L39;
        if (r26.intValue() != 1) goto L39;
    L45:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L48;
    L50:
        Iterator r6 = r5.iterator();
    L52:
        if (r6.hasNext() == false) goto L49;
        Condition r7 = (Condition) ZeusTransformUtils.preCheckCast(r6.next(), Condition.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, TimeCondition.class) == true) goto L56;
    L60:
        boolean r9 = false;
    L61:
        if (r9 == false) goto L52;
        boolean r10 = true;
    L63:
        if (r10 == true) goto L65;
        ConditionTask r11 = (ConditionTask) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0343b(r19, r3, r21, r22, r23, r24, r8, r26, r27, r28, r29, r30, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), ConditionTask.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L69;
        if (r26 != null) goto L73;
    L75:
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r19, 3);
        return a("addConditionTask", 0, "add event task success", d.a.p.a(r11));
    L73:
        if (r26.intValue() != 0) goto L75;
        a(r11, "add");
        goto L75
    L69:
        return a(this, "addConditionTask", -999, "add event task failed", null, 8, null);
    L65:
        return a(this, "addConditionTask", -300, "interval can not be less than 30 minutes", null, 8, null);
    L56:
        if (((TimeCondition) ZeusTransformUtils.preCheckCast(r7, TimeCondition.class, "com.obric.aiagent.plugin")).getInterval() == 0) goto L60;
        if (((TimeCondition) ZeusTransformUtils.preCheckCast(r7, TimeCondition.class, "com.obric.aiagent.plugin")).getInterval() >= 1800000) goto L60;
        r9 = true;
    L49:
        r10 = false;
        goto L63
    L48:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L50;
    L39:
        if (r26 == null) goto L44;
        if (r26.intValue() == 2) goto L45;
    L44:
        return a(this, "addConditionTask", -300, "enable status is not valid", null, 8, null);
    L33:
        if (r26.intValue() == 0) goto L45;
    L29:
        return a(this, "addConditionTask", -300, "conditions is not valid", null, 8, null);
    L25:
        return a(this, "addConditionTask", -300, "periodicPolicy is not valid", null, 8, null);
    L78:
        return a(this, "addConditionTask", -300, "actions or conditions or periodicPolicy or triggerControlPolicy is null", null, 8, null);
    L13:
        if (r1.isEmpty() == true) goto L16;
        r2 = false;
        goto L17
    L9:
        return a(this, "addConditionTask", -100, "Permission denied", null, 8, null);
    }

    public final EventTaskResult a(String r16, String r17, ConditionTaskSpec r18) {
        d.h.b.o.e(r18, "spec");
        b r0 = f16741a;
        List<ConditionTaskAction> r4 = r18.getActions();
        String r5 = r18.getName();
        ConditionGroup r6 = r18.getConditions();
        PeriodicPolicy r7 = r18.getPeriodicPolicy();
        TriggerControlPolicy r8 = r18.getTriggerControlPolicy();
        Integer r9 = r18.getEnableStatus();
        Map<String, String> r10 = r18.getExt();
        Integer r2 = r18.getTaskMode();
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L6:
        ConditionTaskResult r1 = r0.a(r16, r17, r4, r5, r6, r7, r8, r9, r10, r3, r18.getTaskKnowledge(), r18.getTemplateId(), r18.getOmniModel());
        return new EventTaskResult(r1.getCode(), r1.getMsg(), r1.getData(), null, 8, null);
    L5:
        r3 = -1;
        goto L6
    }

    public static /* synthetic */ ConditionTaskResult a(b r17, String r18, String r19, List r20, String r21, ConditionGroup r22, PeriodicPolicy r23, TriggerControlPolicy r24, Integer r25, Map r26, int r27, TaskKnowledge r28, String r29, String r30, int r31, Object r32) {
        List<ConditionTaskAction> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r26, Map.class, "com.obric.aiagent.plugin");
        if ((r31 & 512) == 0) goto L5;
        int r13 = -1;
    L7:
        if ((r31 & 1024) == 0) goto L9;
        TaskKnowledge r14 = null;
    L11:
        if ((r31 & 2048) == 0) goto L13;
        String r15 = null;
    L15:
        if ((r31 & 4096) == 0) goto L17;
        String r16 = null;
    L19:
        return r17.a(r18, r19, r6, r21, r22, r23, r24, r25, r12, r13, r14, r15, r16);
    L17:
        r16 = r30;
        goto L19
    L13:
        r15 = r29;
        goto L15
    L9:
        r14 = r28;
        goto L11
    L5:
        r13 = r27;
        goto L7
    }

    public final ConditionTaskResult a(String r19, String r20, List<ConditionTaskAction> r21, String r22, ConditionGroup r23, PeriodicPolicy r24, TriggerControlPolicy r25, Integer r26, Map<String, String> r27, int r28, TaskKnowledge r29, String r30, String r31) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r27, Map.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "updateConditionTask " + r19 + ' ' + r20);
        if (r19 != null) goto L7;
        return a(this, "updateConditionTask", -201, "Package name is null", null, 8, null);
    L7:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r19) == true) goto L11;
        return a(this, "updateConditionTask", -100, "Permission denied", null, 8, null);
    L11:
        if (r26 != null) goto L14;
    L15:
        if (r26 == null) goto L20;
        if (r26.intValue() != 1) goto L20;
    L25:
        int r2 = r26.intValue();
    L26:
        int r9 = r2;
        ConditionTask r11 = (ConditionTask) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new as(r20, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), ConditionTask.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L31;
        return a(this, "updateConditionTask", -300, "task not found", null, 8, null);
    L31:
        if (d.h.b.o.a((String) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ar(r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), String.class, "com.obric.aiagent.plugin"), r19) == false) goto L33;
        if (r24 != null) goto L36;
    L39:
        ConditionTask r0 = (ConditionTask) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new aq(r20, r4, r22, r23, r24, r25, r9, r10, r28, r29, r30, r31, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), ConditionTask.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L77;
        Integer r3 = r11.getEnableStatus();
        if (r3 != null) goto L45;
    L52:
        b r5 = this;
        Integer r6 = r11.getEnableStatus();
        if (r6 != null) goto L56;
    L57:
        Integer r7 = r0.getEnableStatus();
        if (r7 != null) goto L61;
    L63:
        Integer r8 = r0.getEnableStatus();
        if (r8 != null) goto L67;
    L75:
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r19, 3);
        return r5.a("updateConditionTask", 0, "update event task success", d.a.p.a(r0));
    L67:
        if (r8.intValue() != 0) goto L75;
        if (d.h.b.o.a(r11.getConditions(), r0.getConditions()) == true) goto L71;
    L74:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "task updated and conditions or periodicPolicy changed, unregister and register task");
        r5.a(r11);
        r5.a(r0, "update");
        goto L75
    L71:
        if (d.a(r0.getConditions(), d.h.b.aa.b(TimeCondition.class)) == false) goto L75;
        if (d.h.b.o.a(r11.getPeriodicPolicy(), r0.getPeriodicPolicy()) == true) goto L75;
    L61:
        if (r7.intValue() != 0) goto L63;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "task updated and is enabled, register task");
        r5.a(r0, "update");
        goto L75
    L56:
        if (r6.intValue() == 0) goto L63;
    L45:
        if (r3.intValue() != 0) goto L52;
        Integer r12 = r0.getEnableStatus();
        if (r12 != null) goto L50;
    L51:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "task updated and is not enabled, unregister task");
        r5 = this;
        r5.a(r11);
        goto L75
    L50:
        if (r12.intValue() == 0) goto L52;
    L77:
        return a(this, "updateConditionTask", -999, "update event task failed", null, 8, null);
    L36:
        if (a(r24) == false) goto L39;
        return a(this, "updateConditionTask", -300, "periodicPolicy is not valid", null, 8, null);
    L33:
        return a(this, "updateConditionTask", -100, "not allowed to update task", null, 8, null);
    L20:
        if (r26 != null) goto L23;
    L24:
        r2 = -1;
        goto L26
    L23:
        if (r26.intValue() == 2) goto L25;
    L14:
        if (r26.intValue() == 0) goto L25;
        goto L15
    }

    public final ConditionTaskResult a(String r16, String[] r17) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b r11 = com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a;
        StringBuilder r12 = new StringBuilder().append("removeConditionTask ").append(r16).append(' ');
        if (r17 == null) goto L5;
        String r1 = d.a.i.a(r17, (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L6:
        r11.b(TAG, r12.append(r1).toString());
        if (r16 != null) goto L11;
        return a(this, "removeConditionTask", -201, "Package name is null", null, 8, null);
    L11:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r16) == false) goto L13;
        if (r17 == null) goto L33;
        if (r17.length != 0) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == true) goto L33;
        List<ConditionTask> r3 = (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ac(r16, r17, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r5 = 0;
    L23:
        if (r4.hasNext() == false) goto L26;
        ConditionTask r6 = (ConditionTask) ZeusTransformUtils.preCheckCast(r4.next(), ConditionTask.class, "com.obric.aiagent.plugin");
        r5 = r5 + ((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new aa(r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
        f16741a.a(r6);
        kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ab(r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
        goto L23
    L26:
        if ((true ^ ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L28;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r16, 3);
    L28:
        if (r5 <= 0) goto L31;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r16, 4);
    L31:
        return a("removeConditionTask", 0, "remove event task success", r3);
    L18:
        r2 = false;
    L33:
        return a(this, "removeConditionTask", -300, "taskIds is null or empty", null, 8, null);
    L13:
        return a(this, "removeConditionTask", -100, "Permission denied", null, 8, null);
    L5:
        r1 = null;
        goto L6
    }

    public final ConditionTaskResult a(String r13, List<String> r14) {
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
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "updateConditionDisplayOrder start package=" + r13 + ", count=" + r18.size() + ", first=" + ((String) ZeusTransformUtils.preCheckCast(d.a.p.l(r18), String.class, "com.obric.aiagent.plugin")) + ", last=" + ((String) ZeusTransformUtils.preCheckCast(d.a.p.n(r18), String.class, "com.obric.aiagent.plugin")));
        if (r13 != null) goto L16;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "updateConditionDisplayOrder failed: packageName is null");
        return a(this, "updateConditionDisplayOrder", -201, "Package name is null", null, 8, null);
    L16:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r13) == true) goto L20;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "updateConditionDisplayOrder failed: permission denied package=" + r13);
        return a(this, "updateConditionDisplayOrder", -100, "Permission denied", null, 8, null);
    L20:
        if (r18.isEmpty() == false) goto L23;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "updateConditionDisplayOrder failed: orderedTaskIds is empty");
        return a(this, "updateConditionDisplayOrder", -300, "orderedTaskIds is empty", null, 8, null);
    L23:
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ap(r13, r18, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r1 == d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).size()) goto L27;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "updateConditionDisplayOrder partial update request=" + d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).size() + ", updated=" + r1);
        return a(this, "updateConditionDisplayOrder", -999, "update condition display order failed", null, 8, null);
    L27:
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r13, 3);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "updateConditionDisplayOrder success package=" + r13 + ", updated=" + r1);
        return a(this, "updateConditionDisplayOrder", 0, "update condition display order success", null, 8, null);
    }

    public final ConditionTask a(String r3, String r4) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getConditionTask " + r3 + ' ' + r4);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == true) goto L8;
        return null;
    L8:
        return (ConditionTask) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), ConditionTask.class, "com.obric.aiagent.plugin");
    }

    public final List<ConditionTask> a(String r3) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getConditionTasks " + r3);
        if (r3 == null) goto L10;
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == false) goto L10;
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    L10:
        return d.a.p.b();
    }

    public final List<ConditionTask> a(String r3, int r4, int r5) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getConditionTasksPaged " + r3 + ", offset=" + r4 + ", size=" + r5);
        if (r3 != null) goto L5;
    L9:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "getConditionTasksPaged pkgName check error");
        return d.a.p.b();
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == false) goto L9;
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r3, r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    }

    public final List<ConditionTask> b(String r3) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getKnowledgeSessionIdNotNullConditionTasks " + r3);
        if (r3 == null) goto L10;
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == false) goto L10;
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    L10:
        return d.a.p.b();
    }

    public final List<ConditionTask> c(String r3) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getTemplateIdNotNullConditionTasks " + r3);
        if (r3 == null) goto L10;
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r3) == false) goto L10;
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    L10:
        return d.a.p.b();
    }

    public final List<ConditionTaskRecord> a(String r10, long r11, long r13, String r15) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getConditionTaskRecordsByTaskId " + r10 + ' ' + r11 + ' ' + r13 + ' ' + r15);
        if (r10 != null) goto L5;
        return null;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r10) == false) goto L11;
        if (r15 != null) goto L9;
        return null;
    L9:
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r10, r11, r13, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    L11:
        return null;
    }

    public final List<ConditionTaskRecord> a(String r9, long r10, long r12) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "getAllConditionTaskRecords " + r9 + ' ' + r10 + ' ' + r12);
        if (r9 != null) goto L5;
        return null;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r9) == true) goto L8;
        return null;
    L8:
        return (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r9, r10, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
    }

    public final int a(String r14, long[] r15) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b r13 = com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a;
        StringBuilder r0 = new StringBuilder().append("removeConditionTaskRecordsById ").append(r14).append(' ');
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
        r16 = ((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ad(r14, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r16 <= 0) goto L20;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r14, 4);
        goto L20
    L14:
        r1 = false;
        goto L15
    L5:
        r3 = null;
        goto L6
    }

    public final int d(String r4) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "removeAllConditionTaskRecords " + r4);
        if (r4 != null) goto L5;
        return 0;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r4) == false) goto L13;
        int r3 = ((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new z(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r3 <= 0) goto L10;
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r4, 4);
    L10:
        return r3;
    L13:
        return 0;
    }

    public final void b() {
        kotlinx.coroutines.i.a(f16742b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void h() {
        Application r6 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        Intent r1 = AlarmReceiver.f17276a.a((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.aiagent.plugin"));
        PendingIntent r2 = PendingIntent.getBroadcast((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.aiagent.plugin"), 0, r1, 167772160);
        Object r7 = r6.getSystemService("alarm");
        d.h.b.o.a(r7, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager r8 = (AlarmManager) ZeusTransformUtils.preCheckCast(r7, AlarmManager.class, "com.obric.aiagent.plugin");
        r8.setExactAndAllowWhileIdle(0, f.a(), r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "setupTaskCheck exception", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final boolean a(PeriodicPolicy r1) {
        if (f.a(r1.getExpireDate()) == false) goto L5;
    L8:
        return true;
    L5:
        if (c.a(r1) == e.i) goto L8;
        return false;
    }

    public final void a(String r5, String r6, Object r7, Bundle r8) {
        d.h.b.o.e(r5, "subscriptionId");
        d.h.b.o.e(r6, "featureName");
        final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g.a r0 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g.f17272a.a(r5);
        if (r0 != null) goto L6;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "ignore persistent feature callback, invalid subscriptionId=" + r5);
        return;
    L6:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "onPersistentAwarenessFeatureChanged subscription=" + r0 + " feature=" + r6 + " newValue=" + r7 + " extras=" + r8);
        a("feature:" + r0.a(), new $$Lambda$b$pyoADpeEWfV4CLP8WQAKRQP9J9s(r0));
    }

    private static final d.x a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g.a r3) {
        String r0 = r3.a();
        int r1 = r0.hashCode();
        if (r1 == (-1884274053)) goto L17;
        if (r1 == (-331239923)) goto L14;
        if (r1 == 3649301) goto L10;
    L18:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "ignore persistent feature callback, kind=" + r3.a());
    L21:
        return d.x.f38692a;
    L10:
        if (r0.equals("wifi") == false) goto L18;
        f16741a.g(r3.b());
        goto L21
    L14:
        if (r0.equals(Scraps.BATTERY) == false) goto L18;
        f16741a.h(r3.b());
        goto L21
    L17:
        if (r0.equals(Scraps.STORAGE) == false) goto L18;
        f16741a.j(r3.b());
        goto L21
    }

    public final void a(String r5, String r6, final Bundle r7) {
        d.h.b.o.e(r5, "subscriptionId");
        d.h.b.o.e(r6, "eventName");
        final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g.a r0 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g.f17272a.a(r5);
        if (r0 != null) goto L6;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "ignore persistent context callback, invalid subscriptionId=" + r5);
        return;
    L6:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "onPersistentAwarenessContextChanged subscription=" + r0 + " event=" + r6 + " extras=" + r7);
        a("context:" + r0.a(), new $$Lambda$b$ctvReZ76T4TffL_oak5Vj1dV37A(r0, r7));
    }

    private static final d.x a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g.a r4, Bundle r5) {
        String r0 = r4.a();
        switch(r0.hashCode()) {
            case 114009: goto L18;
            case 136151037: goto L14;
            case 1607121098: goto L10;
            case 1968882350: goto L6;
            default: goto L24;
        };
    L24:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "ignore persistent context callback, kind=" + r4.a());
    L26:
        return d.x.f38692a;
    L6:
        if (r0.equals("bluetooth") == false) goto L24;
        f16741a.i(r4.b());
        goto L26
    L10:
        if (r0.equals("location_geofence") == false) goto L24;
        f16741a.f(r4.b());
        goto L26
    L14:
        if (r0.equals("location_place") == false) goto L24;
        f16741a.f(r4.b());
        goto L26
    L18:
        if (r0.equals("sms") == false) goto L24;
        b r1 = f16741a;
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.a r2 = r1.i();
        if (r2 == null) goto L23;
        r2.a(r4.b(), r4.c(), r5);
    L23:
        r1.k(r4.b());
        goto L26
    }

    public final void a(final String r3, d.h.a.a<d.x> r4) {
        final d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, DBHelper.BATTERY_COL_SCENE);
        d.h.b.o.e(r2, "action");
        IAgentIpcManager r5 = IAgentIpcManager.Companion.a();
        if (r5 != null) goto L6;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "runAfterMainProcessReady " + r3 + " ipcManager null, run directly");
        r2.invoke();
        return;
    L6:
        r5.checkIpcReady(new $$Lambda$b$gGaT5kE7xDl0TdTN6gB2jWbupw(r3, r2));
    }

    private static final d.x a(String r3, d.h.a.a r4, boolean r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "runAfterMainProcessReady " + r3 + " ipcReady=" + r5);
        if (r5 == false) goto L6;
        r6.invoke();
    L6:
        return d.x.f38692a;
    }

    private final Object b(String r8, d.c.d<? super Boolean> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r10, e.class, "com.obric.aiagent.plugin");
        if ((r0.f16815d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16815d -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f16813b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16815d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (String) ZeusTransformUtils.preCheckCast(r0.f16812a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L21:
        Boolean r7 = (Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L24;
        boolean r12 = r7.booleanValue();
    L26:
        if (r12 == true) goto L28;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "ensureInitialized " + r8 + " timeout, drop event");
    L30:
        return d.c.b.a.b.a(r12);
    L28:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "ensureInitialized " + r8 + " ready");
        goto L30
    L24:
        r12 = false;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        if (i.i() == true) goto L17;
        n(r8);
        d.h.a.m r13 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.f16812a = r8;
        r0.f16815d = 1;
        r11 = dg.b(OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, r13, r0);
        if (r11 != r2) goto L21;
        return r2;
    L17:
        return d.c.b.a.b.a(true);
    L7:
        r0 = new e(this, r10);
        goto L8
    }

    private final Object a(String r17, String r18, d.c.d<? super a> r19) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L7;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f16806d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        if (r6 == 0) goto L19;
        if (r6 == 1) goto L18;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r4.f16805c, String.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.f16804b, String.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.f16803a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L37:
        ConditionTask r8 = (ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L42;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "awaitTriggeredTask " + r1 + " task not found, taskId=" + r7 + ", userId=" + r0);
        return null;
    L42:
        return new a(r0, r8);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.f16804b, String.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.f16803a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L17:
        String r15 = r10;
        r1 = r9;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L33;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "awaitTriggeredTask " + r1 + " account database timeout, taskId=" + r15);
        return null;
    L33:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r12 = f16743c;
        r4.f16803a = r15;
        r4.f16804b = r1;
        r4.f16805c = r11;
        r4.f = 3;
        Object r13 = r12.a(r15, r11, r4);
        if (r13 != r5) goto L36;
        return r5;
    L36:
        r7 = r15;
        r0 = r11;
        r3 = r13;
        goto L37
    L18:
        r9 = (String) ZeusTransformUtils.preCheckCast(r4.f16804b, String.class, "com.obric.aiagent.plugin");
        r10 = (String) ZeusTransformUtils.preCheckCast(r4.f16803a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L24:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L26;
        return null;
    L26:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a r14 = f16745e;
        r4.f16803a = r10;
        r4.f16804b = r9;
        r4.f = 2;
        r3 = r14.a(OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, r4);
        if (r3 != r5) goto L17;
        return r5;
    L19:
        d.o.a(r3);
        r4.f16803a = r17;
        r4.f16804b = r18;
        r4.f = 1;
        Object r16 = b(r18, r4);
        if (r16 != r5) goto L22;
        return r5;
    L22:
        r3 = r16;
        r9 = r18;
        r10 = r17;
    L7:
        r4 = new c(this, r2);
        goto L8
    }

    private final void n(String r3) {
        if (h.get() == false) goto L5;
        return;
    L5:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "requestInitIfNeeded " + r3 + ", init not started, request TaskManagerImpl.init");
        com.obric.aiagent.product.a.e.f18781a.b((Runnable) ZeusTransformUtils.preCheckCast(new ae(r3), Runnable.class, "com.obric.aiagent.plugin"));
    }

    public final void e(String r7) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        kotlinx.coroutines.i.a(f16742b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new t(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void f(String r7) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        kotlinx.coroutines.i.a(f16742b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new q(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void g(String r7) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        kotlinx.coroutines.i.a(f16742b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new u(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void h(String r7) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        kotlinx.coroutines.i.a(f16742b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void i(String r7) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        kotlinx.coroutines.i.a(f16742b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new p(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void j(String r7) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        kotlinx.coroutines.i.a(f16742b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new s(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void k(String r7) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        kotlinx.coroutines.i.a(f16742b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new r(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final boolean l(String r4) {
        d.h.b.o.e(r4, DBDefinition.TASK_ID);
        return d.o.o.b(r4, "ct_", false, 2, null);
    }

    private final Object a(ConditionTask r37, com.obric.event.task.base.report.e.a r38, d.c.d<? super com.obric.event.task.base.report.e.b> r39) {
        b r0 = this;
        ConditionTask r1 = r37;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r39, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ag.class) == false) goto L7;
        ag r5 = (ag) ZeusTransformUtils.preCheckCast(r3, ag.class, "com.obric.aiagent.plugin");
        if ((r5.i & Integer.MIN_VALUE) == 0) goto L7;
        r5.i -= Integer.MIN_VALUE;
    L8:
        ag r14 = r5;
        Object r4 = r14.g;
        Object r6 = d.c.a.b.a();
        String r8 = "task ";
        switch(r14.i) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        d.o.a(r4);
    L116:
        return com.obric.event.task.base.report.e.b.f32766b;
    L13:
        long r2 = r14.f16768e;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r14.f16766c, String.class, "com.obric.aiagent.plugin");
        com.obric.event.task.base.report.e.a r9 = (com.obric.event.task.base.report.e.a) ZeusTransformUtils.preCheckCast(r14.f16765b, com.obric.event.task.base.report.e.a.class, "com.obric.aiagent.plugin");
        ConditionTask r10 = (ConditionTask) ZeusTransformUtils.preCheckCast(r14.f16764a, ConditionTask.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        long r11 = r2;
        com.obric.event.task.base.report.e.a r12 = r9;
    L107:
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r7, 4);
        com.obric.event.task.base.report.e.f32759a.a(r12, r10, com.obric.event.task.base.report.e.b.f, r11);
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(g, Map.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.a.d r15 = (kotlinx.coroutines.a.d) ZeusTransformUtils.preCheckCast(d.h.b.ae.j(r13).remove(r10.getId()), kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L111;
        d.c.b.a.b.a(kotlinx.coroutines.a.t.a.a((kotlinx.coroutines.a.t) ZeusTransformUtils.preCheckCast(r15, kotlinx.coroutines.a.t.class, "com.obric.aiagent.plugin"), null, 1, null));
    L111:
        return com.obric.event.task.base.report.e.b.f;
    L14:
        ConditionTask r16 = (ConditionTask) ZeusTransformUtils.preCheckCast(r14.f16764a, ConditionTask.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
    L98:
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(g, Map.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.a.d r18 = (kotlinx.coroutines.a.d) ZeusTransformUtils.preCheckCast(d.h.b.ae.j(r17).remove(r16.getId()), kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L102;
        d.c.b.a.b.a(kotlinx.coroutines.a.t.a.a((kotlinx.coroutines.a.t) ZeusTransformUtils.preCheckCast(r18, kotlinx.coroutines.a.t.class, "com.obric.aiagent.plugin"), null, 1, null));
    L102:
        return com.obric.event.task.base.report.e.b.f32766b;
    L15:
        long r19 = r14.f;
        long r110 = r14.f16768e;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r14.f16767d, String.class, "com.obric.aiagent.plugin");
        com.obric.event.task.base.report.e.a r21 = (com.obric.event.task.base.report.e.a) ZeusTransformUtils.preCheckCast(r14.f16766c, com.obric.event.task.base.report.e.a.class, "com.obric.aiagent.plugin");
        ConditionTask r111 = (ConditionTask) ZeusTransformUtils.preCheckCast(r14.f16765b, ConditionTask.class, "com.obric.aiagent.plugin");
        b r22 = (b) ZeusTransformUtils.preCheckCast(r14.f16764a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        com.obric.event.task.base.report.e.a r112 = r21;
        String r113 = "task ";
        String r114 = TAG;
        ConditionTask r115 = r111;
        Object r23 = r4;
        b r24 = r22;
        r7 = r20;
    L93:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r23, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L103;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(r114, r113 + r115.getId() + " scheduling");
        com.obric.event.task.base.report.e.f32759a.a(r112, r115, com.obric.event.task.base.report.e.b.f32766b, r19);
        String r25 = r112.a();
        r14.f16764a = r115;
        r14.f16765b = null;
        r14.f16766c = null;
        r14.f16767d = null;
        r14.i = 5;
        if (r24.a(r115, r7, r25, r14) != r6) goto L97;
        return r6;
    L97:
        r16 = r115;
        goto L98
    L103:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(r114, new StringBuilder().append(r113).append(r115.getId()).append(" skipped").toString());
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.a r26 = f16744d;
        String r27 = r115.getId();
        long r28 = System.currentTimeMillis();
        long r116 = SystemClock.elapsedRealtime() - r110;
        r14.f16764a = r115;
        r14.f16765b = r112;
        r14.f16766c = r7;
        r14.f16767d = null;
        r14.f16768e = r19;
        r14.i = 6;
        ConditionTask r29 = r115;
        if (r26.a(r27, r28, r7, 3, r116, r14) != r6) goto L106;
        return r6;
    L106:
        r11 = r19;
        r10 = r29;
        r12 = r112;
        goto L107
    L16:
        long r30 = r14.f16768e;
        String r31 = (String) ZeusTransformUtils.preCheckCast(r14.f16766c, String.class, "com.obric.aiagent.plugin");
        com.obric.event.task.base.report.e.a r32 = (com.obric.event.task.base.report.e.a) ZeusTransformUtils.preCheckCast(r14.f16765b, com.obric.event.task.base.report.e.a.class, "com.obric.aiagent.plugin");
        ConditionTask r33 = (ConditionTask) ZeusTransformUtils.preCheckCast(r14.f16764a, ConditionTask.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
    L73:
        List r34 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        long r35 = r30;
        String r36 = r31;
    L75:
        com.obric.event.task.base.report.e.f32759a.a(r32, r33, com.obric.event.task.base.report.e.b.f32769e, r35);
        com.obric.aiagent.executionengine.eventstaskmanager.b r40 = com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a;
        if (r36 != null) goto L78;
        r36 = "";
    L78:
        r40.a(r36, 4);
        return com.obric.event.task.base.report.e.b.f32769e;
    L17:
        long r41 = r14.f;
        long r42 = r14.f16768e;
        com.obric.event.task.base.report.e.a r117 = (com.obric.event.task.base.report.e.a) ZeusTransformUtils.preCheckCast(r14.f16766c, com.obric.event.task.base.report.e.a.class, "com.obric.aiagent.plugin");
        ConditionTask r118 = (ConditionTask) ZeusTransformUtils.preCheckCast(r14.f16765b, ConditionTask.class, "com.obric.aiagent.plugin");
        b r43 = (b) ZeusTransformUtils.preCheckCast(r14.f16764a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        long r119 = r41;
        long r44 = r42;
        r8 = "task ";
        r33 = r118;
    L52:
        r36 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(d.c(r33.getConditions(), d.h.b.aa.b(LocationCondition.class)), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L55;
    L80:
        if (r36 == null) goto L112;
        String r120 = r8;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, r120 + r33.getId() + " waiting 5 seconds");
        com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a.a(r36, (EventTask) ZeusTransformUtils.preCheckCast(r33, EventTask.class, "com.obric.aiagent.plugin"));
        ConcurrentMap r45 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(g, ConcurrentMap.class, "com.obric.aiagent.plugin");
        String r46 = r33.getId();
        Object r121 = r45.get(r46);
        if (r121 != null) goto L87;
        r114 = TAG;
        r113 = r120;
        r121 = kotlinx.coroutines.a.g.a(-1, null, null, 6, null);
        Object r47 = r45.putIfAbsent(r46, r121);
        if (r47 == null) goto L88;
        r121 = r47;
    L88:
        kotlinx.coroutines.a.d r48 = (kotlinx.coroutines.a.d) ZeusTransformUtils.preCheckCast(r121, kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.e.i r49 = new kotlinx.coroutines.e.i(r14.getContext());
        kotlinx.coroutines.e.c r50 = (kotlinx.coroutines.e.c) ZeusTransformUtils.preCheckCast(r49, kotlinx.coroutines.e.c.class, "com.obric.aiagent.plugin");
        long r210 = r119;
        kotlinx.coroutines.e.b.a(r50, 0, (d.h.a.b) ZeusTransformUtils.preCheckCast(new ah(null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r50.a(r48.f(), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ai(null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        r14.f16764a = r43;
        r14.f16765b = r33;
        r14.f16766c = r117;
        r14.f16767d = r36;
        r14.f16768e = r44;
        r14.f = r210;
        r14.i = 4;
        r23 = r49.a(r14);
        if (r23 != r6) goto L91;
        return r6;
    L91:
        r112 = r117;
        r110 = r44;
        r19 = r210;
        r115 = r33;
        r24 = r43;
        r7 = r36;
        goto L93
    L87:
        r114 = TAG;
        r113 = r120;
        goto L88
    L112:
        com.obric.event.task.base.report.e.f32759a.a(r117, r33, com.obric.event.task.base.report.e.b.f32766b, r119);
        String r51 = r117.a();
        r14.f16764a = null;
        r14.f16765b = null;
        r14.f16766c = null;
        r14.i = 7;
        if (r43.a(r33, r36, r51, r14) != r6) goto L116;
        return r6;
    L55:
        if (c.a() == true) goto L80;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "location permission not granted " + r33.getId());
        IEventTaskRecordApi r52 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
        if (r52 == null) goto L74;
        int r211 = r33.getTaskMode();
        String r212 = r33.getId();
        ConditionTaskAction r53 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(d.a.p.l(r33.getActions()), ConditionTaskAction.class, "com.obric.aiagent.plugin");
        if (r53 == null) goto L61;
        IntentParams r54 = r53.getParams();
    L63:
        if (ZeusTransformUtils.instanceOf(r54, SystemAutoActionParams.class) == false) goto L65;
        SystemAutoActionParams r55 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r54, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L66:
        if (r55 == null) goto L68;
        String r213 = r55.getInstruction();
    L69:
        List<EventTaskExecutionRecord> r56 = d.a.p.a(new EventTaskExecutionRecord(0, 2, r211, r212, r213, System.currentTimeMillis(), SystemClock.elapsedRealtime() - r44, 2, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_condition_task_error_no_location_permission, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_condition_task_error_no_location_permission")), null, null, DownloadErrorCode.ERROR_ANOTHER_TASK_EXIST, null));
        r14.f16764a = r33;
        r14.f16765b = r117;
        r14.f16766c = r36;
        r14.f16768e = r119;
        r14.i = 3;
        Object r57 = r52.addExecutionRecords(r56, r14);
        if (r57 != r6) goto L72;
        return r6;
    L72:
        r31 = r36;
        r32 = r117;
        r4 = r57;
        r30 = r119;
        goto L73
    L68:
        r213 = null;
        goto L69
    L65:
        r55 = null;
        goto L66
    L61:
        r54 = null;
        goto L63
    L74:
        r32 = r117;
        r35 = r119;
        goto L75
    L18:
        long r58 = r14.f16768e;
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a r59 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a) ZeusTransformUtils.preCheckCast(r14.f16767d, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.class, "com.obric.aiagent.plugin");
        com.obric.event.task.base.report.e.a r60 = (com.obric.event.task.base.report.e.a) ZeusTransformUtils.preCheckCast(r14.f16766c, com.obric.event.task.base.report.e.a.class, "com.obric.aiagent.plugin");
        ConditionTask r122 = (ConditionTask) ZeusTransformUtils.preCheckCast(r14.f16765b, ConditionTask.class, "com.obric.aiagent.plugin");
        b r61 = (b) ZeusTransformUtils.preCheckCast(r14.f16764a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        r0 = r61;
        r1 = r122;
        r117 = r60;
        Object r62 = r4;
        long r63 = r58;
    L26:
        r119 = ((Number) ZeusTransformUtils.preCheckCast(r62, Number.class, "com.obric.aiagent.plugin")).longValue();
        TriggerControlPolicy r64 = r1.getTriggerControlPolicy();
        if (r64 == null) goto L29;
        Long r65 = r64.getMinTriggerInterval();
    L30:
        TriggerControlPolicy r123 = r1.getTriggerControlPolicy();
        boolean r124 = false;
        if (r123 == null) goto L33;
        boolean r66 = d.h.b.o.a(r123.getEnable(), d.c.b.a.b.a(true));
    L34:
        if (r66 == false) goto L40;
        if (r65 == null) goto L40;
        if ((System.currentTimeMillis() - r119) >= r65.longValue()) goto L40;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "scheduleTaskIfReady trigger too frequently " + r1.getId() + ' ' + r65 + ' ' + (System.currentTimeMillis() - r119));
        com.obric.event.task.base.report.e.f32759a.a(r117, r1, com.obric.event.task.base.report.e.b.g, r119);
        return com.obric.event.task.base.report.e.b.g;
    L40:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "scheduleTaskIfReady " + r59);
        if (r59 != null) goto L43;
    L45:
        if (r124 == false) goto L48;
        com.obric.event.task.base.report.e.b r67 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.b.a(r59);
        com.obric.event.task.base.report.e.f32759a.a(r117, r1, r67, r119);
        return r67;
    L48:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r68 = f16743c;
        String r69 = r1.getId();
        r14.f16764a = r0;
        r14.f16765b = r1;
        r14.f16766c = r117;
        r14.f16767d = null;
        r14.f16768e = r63;
        r14.f = r119;
        r14.i = 2;
        Object r70 = r68.c(r69, r14);
        if (r70 != r6) goto L51;
        return r6;
    L51:
        long r310 = r63;
        r43 = r0;
        r4 = r70;
        r33 = r1;
        r44 = r310;
        goto L52
    L43:
        if (r59.a() == true) goto L45;
        r124 = true;
        goto L45
    L33:
        r66 = false;
        goto L34
    L29:
        r65 = null;
        goto L30
    L19:
        d.o.a(r4);
        r63 = SystemClock.elapsedRealtime();
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<Condition> r71 = r0.a(d.h.b.aa.b(ConditionGroup.class));
        if (r71 == null) goto L22;
        r59 = r71.a(r1, (Condition) ZeusTransformUtils.preCheckCast(r37.getConditions(), Condition.class, "com.obric.aiagent.plugin"));
    L23:
        String r72 = r37.getId();
        r14.f16764a = r0;
        r14.f16765b = r1;
        r117 = r38;
        r14.f16766c = r117;
        r14.f16767d = r59;
        r14.f16768e = r63;
        r14.i = 1;
        r62 = r0.c(r72, r14);
        if (r62 != r6) goto L26;
        return r6;
    L22:
        r59 = null;
        goto L23
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r5 = new ag(r0, r3);
        goto L8
    }

    private final Object c(String r7, d.c.d<? super Long> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, m.class) == false) goto L7;
        m r0 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.aiagent.plugin");
        if ((r0.f16838c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16838c -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f16836a;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f16838c;
        long r3 = -1;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r6);
    L21:
        Long r11 = (Long) ZeusTransformUtils.preCheckCast(r6, Long.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L25;
        r3 = r11.longValue();
    L25:
        return d.c.b.a.b.a(r3);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        if (r7 == null) goto L17;
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.a r12 = f16744d;
        r0.f16838c = 1;
        r6 = r12.a(r7, r0);
        if (r6 != r10) goto L21;
        return r10;
    L17:
        return d.c.b.a.b.a(-1);
    L7:
        r0 = new m(this, r9);
        goto L8
    }

    private final Object a(ConditionTask r24, String r25, String r26, d.c.d<? super d.x> r27) {
        b r0 = this;
        ConditionTask r1 = r24;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, v.class) == false) goto L7;
        v r5 = (v) ZeusTransformUtils.preCheckCast(r3, v.class, "com.obric.aiagent.plugin");
        if ((r5.f & Integer.MIN_VALUE) == 0) goto L7;
        r5.f -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f16863d;
        Object r15 = d.c.a.b.a();
        int r6 = r5.f;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r5.f16862c, String.class, "com.obric.aiagent.plugin");
        r1 = (ConditionTask) ZeusTransformUtils.preCheckCast(r5.f16861b, ConditionTask.class, "com.obric.aiagent.plugin");
        b r7 = (b) ZeusTransformUtils.preCheckCast(r5.f16860a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
    L37:
        r7.a(r1);
        com.obric.aiagent.executionengine.eventstaskmanager.b r8 = com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a;
        if (r2 != null) goto L40;
        r2 = "";
    L40:
        r8.a(r2, 3);
    L42:
        return d.x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.f16862c, String.class, "com.obric.aiagent.plugin");
        r1 = (ConditionTask) ZeusTransformUtils.preCheckCast(r5.f16861b, ConditionTask.class, "com.obric.aiagent.plugin");
        b r10 = (b) ZeusTransformUtils.preCheckCast(r5.f16860a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        String r11 = r9;
        r0 = r10;
    L27:
        com.obric.aiagent.executionengine.eventstaskmanager.b r12 = com.obric.aiagent.executionengine.eventstaskmanager.b.f16672a;
        if (r11 != null) goto L30;
        String r13 = "";
    L31:
        r12.a(r13, 4);
        if (r1.getPeriodicPolicy().isSingleTask() == false) goto L42;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, r1.getId() + " is single task, unregister after scheduled");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b r14 = f16743c;
        String r16 = r1.getId();
        r5.f16860a = r0;
        r5.f16861b = r1;
        r5.f16862c = r11;
        r5.f = 2;
        if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.b.a(r14, r16, null, null, null, null, null, 1, null, 0, null, null, null, r5, 4030, null) != r15) goto L36;
        return r15;
    L36:
        r7 = r0;
        r2 = r11;
        goto L37
    L30:
        r13 = r11;
        goto L31
    L16:
        d.o.a(r4);
        long r17 = SystemClock.elapsedRealtime();
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r24.getActions(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r18.hasNext() == false) goto L23;
        ConditionTaskAction r19 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(r18.next(), ConditionTaskAction.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "schedule task " + r24.getId() + ' ' + r19.getIntent());
        com.obric.event.task.base.report.i.f32779a.a(r24.getId(), 2, r26);
        IAgentService r20 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L21;
        r20.scheduleConditionTask(r1, r19.getIntent(), r19.getParams());
        goto L18
    L21:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "scheduleConditionTask agentService is null");
        com.obric.event.task.base.report.e.f32759a.a(TAG, "scheduleConditionTask agentService is null");
        com.obric.event.task.base.report.i.f32779a.b(r24.getId(), -2, "agentService is null");
        goto L18
    L23:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.b.a r21 = f16744d;
        String r22 = r24.getId();
        long r23 = System.currentTimeMillis();
        long r28 = SystemClock.elapsedRealtime() - r17;
        r5.f16860a = r0;
        r5.f16861b = r1;
        r5.f16862c = r25;
        r5.f = 1;
        if (r21.a(r22, r23, r25, 0, r28, r5) != r15) goto L26;
        return r15;
    L26:
        r11 = r25;
    L7:
        r5 = new v(r0, r3);
        goto L8
    }

    public final void b(String r4, String r5) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "skipConditionTaskSchedule " + r5);
        if (r4 != null) goto L5;
        return;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r4) == true) goto L8;
        return;
    L8:
        if (d.h.b.o.a(r4, (String) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new aj(r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), String.class, "com.obric.aiagent.plugin")) == false) goto L15;
        if (r5 == null) goto L16;
        kotlinx.coroutines.a.d r3 = (kotlinx.coroutines.a.d) ZeusTransformUtils.preCheckCast(g.get(r5), kotlinx.coroutines.a.d.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L17;
        kotlinx.coroutines.a.h.i(r3.a_(d.x.f38692a));
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void a(String r9, String r10, List<ConditionTaskAction> r11, TaskKnowledge r12, int r13, String r14) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "actions");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "tryScheduleConditionTask " + r10);
        if (r9 != null) goto L5;
        return;
    L5:
        if (com.obric.aiagent.executionengine.eventstaskmanager.common.c.a(r9) == false) goto L23;
        com.obric.event.task.base.report.i.f32779a.a(r10, 2, null);
        ConditionTask r15 = (ConditionTask) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ak(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), ConditionTask.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L11;
        com.obric.event.task.base.report.i.f32779a.b(r10, -2, "condition task not found");
        return;
    L11:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r16.hasNext() == false) goto L24;
        ConditionTaskAction r17 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(r16.next(), ConditionTaskAction.class, "com.obric.aiagent.plugin");
        IAgentService r1 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L13;
        r1.tryScheduleConditionTask(r15, r17.getIntent(), r17.getParams(), r12, r13, r14);
        goto L13
    L24:
        return;
    }

    private final ca a(ConditionTask r7, String r8) {
        return kotlinx.coroutines.i.a(f16742b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new x(r7, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Object a(ConditionTask r10, d.m.c<? extends Condition> r11, List<? extends Condition> r12, String r13, d.c.d<? super d.x> r14) {
        d.m.c<? extends Condition> r15 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r11, d.m.c.class, "com.obric.aiagent.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        d.c.d r17 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, y.class) == false) goto L7;
        y r0 = (y) ZeusTransformUtils.preCheckCast(r17, y.class, "com.obric.aiagent.plugin");
        if ((r0.f16877e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16877e -= Integer.MIN_VALUE;
    L8:
        Object r18 = r0.f16875c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16877e;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r0.f16874b, String.class, "com.obric.aiagent.plugin");
        r10 = (ConditionTask) ZeusTransformUtils.preCheckCast(r0.f16873a, ConditionTask.class, "com.obric.aiagent.plugin");
        d.o.a(r18);     // Catch: Throwable -> L14
    L25:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r19 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r18, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
    L27:
        if (r19 != null) goto L30;
        com.obric.event.task.base.report.i.a(com.obric.event.task.base.report.i.f32779a, r10.getId(), r9, -2, ' ' + r9 + " condition handler not found", 0, 16, null);     // Catch: Throwable -> L14
        return d.x.f38692a;
    L30:
        com.obric.event.task.base.report.i.f32779a.a(r10.getId(), r9, r19.a(), r19.b(), r19.c());     // Catch: Throwable -> L14
    L37:
        return d.x.f38692a;
    L14:
        th = th;
        String r4 = r9;
    L34:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "registerConditionTask exception " + r10.getId(), th);
        com.obric.event.task.base.report.i.f32779a.a(r10.getId(), r4, -3, th.getMessage(), 0);
        if (IAppContext.Companion.isTestChannel() == false) goto L37;
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r18);
        String r110 = b(r15);
        com.obric.event.task.base.report.i.f32779a.a(r10.getId(), r110, r13);
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<Condition> r20 = a(r15);     // Catch: Throwable -> L32
        if (r20 == null) goto L26;
        r0.f16873a = r10;     // Catch: Throwable -> L32
        r0.f16874b = r110;     // Catch: Throwable -> L32
        r0.f16877e = 1;     // Catch: Throwable -> L32
        Object r21 = r20.a(r10, r16, r0);     // Catch: Throwable -> L32
        if (r21 != r2) goto L24;
        return r2;
    L24:
        r18 = r21;
        r9 = r110;
        goto L25
    L26:
        r19 = null;
        r9 = r110;
    L32:
        th = th;
        r4 = r110;
    L7:
        r0 = new y(this, r17);
        goto L8
    }

    private final void a(ConditionTask r7) {
        kotlinx.coroutines.i.a(f16742b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new an(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<Condition> a(d.m.c<? extends Condition> r2) {
        d.m.c r1 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<? extends Condition> r3 = f.get(r1);
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e.class) == true) goto L7;
        return null;
    L7:
        return (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.a i() {
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<? extends Condition> r2 = f.get(d.h.b.aa.b(SmsCondition.class));
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.a.class) == true) goto L7;
        return null;
    L7:
        return (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.a) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.a.class, "com.obric.aiagent.plugin");
    }

    private final String b(d.m.c<? extends Condition> r2) {
        d.m.c r1 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r1, d.h.b.aa.b(TimeCondition.class)) == false) goto L6;
        return com.obric.event.task.base.report.e.a.f32760a.a();
    L6:
        if (d.h.b.o.a(r1, d.h.b.aa.b(LocationCondition.class)) == false) goto L9;
        return com.obric.event.task.base.report.e.a.f32761b.a();
    L9:
        if (d.h.b.o.a(r1, d.h.b.aa.b(WifiCondition.class)) == false) goto L12;
        return com.obric.event.task.base.report.e.a.f32762c.a();
    L12:
        if (d.h.b.o.a(r1, d.h.b.aa.b(BluetoothCondition.class)) == false) goto L15;
        return com.obric.event.task.base.report.e.a.f32763d.a();
    L15:
        if (d.h.b.o.a(r1, d.h.b.aa.b(BatteryCondition.class)) == false) goto L18;
        return com.obric.event.task.base.report.e.a.f32764e.a();
    L18:
        if (d.h.b.o.a(r1, d.h.b.aa.b(StorageCondition.class)) == false) goto L21;
        return com.obric.event.task.base.report.e.a.f.a();
    L21:
        if (d.h.b.o.a(r1, d.h.b.aa.b(SmsCondition.class)) == true) goto L33;
        String r3 = r1.b();
        if (r3 != null) goto L34;
        return "";
    L34:
        return r3;
    L33:
        return com.obric.event.task.base.report.e.a.g.a();
    }

    static /* synthetic */ ConditionTaskResult a(b r1, String r2, int r3, String r4, List r5, int r6, Object r7) {
        List<ConditionTask> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r8 = null;
    L6:
        return r1.a(r2, r3, r4, r8);
    }

    private final ConditionTaskResult a(String r3, int r4, String r5, List<ConditionTask> r6) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a(TAG, "getResult " + r3 + " code = " + r4 + ", msg = " + r5);
        return new ConditionTaskResult(r4, r5, r2);
    }
}
