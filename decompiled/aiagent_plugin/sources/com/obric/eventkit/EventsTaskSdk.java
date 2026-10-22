package com.obric.eventkit;

import android.app.Application;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.eventkit.apphost.AppHost;
import com.obric.eventkit.eventstaskmanager.ActiveAgentEvent;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import com.obric.eventkit.eventstaskmanager.ConditionGroup;
import com.obric.eventkit.eventstaskmanager.ConditionTask;
import com.obric.eventkit.eventstaskmanager.ConditionTaskAction;
import com.obric.eventkit.eventstaskmanager.ConditionTaskRecord;
import com.obric.eventkit.eventstaskmanager.ConditionTaskResult;
import com.obric.eventkit.eventstaskmanager.EventTask;
import com.obric.eventkit.eventstaskmanager.EventTaskExecutionDetailRecord;
import com.obric.eventkit.eventstaskmanager.EventTaskExecutionRecord;
import com.obric.eventkit.eventstaskmanager.EventTaskRecord;
import com.obric.eventkit.eventstaskmanager.EventTaskResult;
import com.obric.eventkit.eventstaskmanager.EventTaskSpec;
import com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener;
import com.obric.eventkit.eventstaskmanager.IAssistantSessionStateListener;
import com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener;
import com.obric.eventkit.eventstaskmanager.IEventBinderListener;
import com.obric.eventkit.eventstaskmanager.IEventTaskChangeListener;
import com.obric.eventkit.eventstaskmanager.IEventTaskScheduleListener;
import com.obric.eventkit.eventstaskmanager.ITimerTaskChangeListener;
import com.obric.eventkit.eventstaskmanager.PeriodicPolicy;
import com.obric.eventkit.eventstaskmanager.ShortcutTask;
import com.obric.eventkit.eventstaskmanager.StateInfo;
import com.obric.eventkit.eventstaskmanager.TaskKnowledge;
import com.obric.eventkit.eventstaskmanager.TimerTask;
import com.obric.eventkit.eventstaskmanager.TimerTaskRecord;
import com.obric.eventkit.eventstaskmanager.TimerTaskResult;
import com.obric.eventkit.eventstaskmanager.TriggerControlPolicy;
import com.obric.eventkit.logger.ILogger;
import com.obric.eventkit.logger.Logger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes4.dex */
public final class EventsTaskSdk {
    public static final EventsTaskSdk INSTANCE = null;
    private static final String TAG = "EventsTaskSdk";
    private static InitConfig _config;
    private static boolean apiInitialized;
    private static d.h.a.a<d.x> binderDiedCallback;
    private static final CopyOnWriteArraySet<d.h.a.a<d.x>> connectionListeners = null;
    private static CopyOnWriteArraySet<IEventBinderListener> mBinderDiedListener;
    private static boolean mPendingCallsExecuted;
    private static final List<a> mPendingCals = null;
    private static final kotlinx.coroutines.am scope = null;

    public static final class InitConfig {
        private final Application app;

        public InitConfig(Application r3) {
            Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "app");
            this.app = r4;
        }

        public static /* synthetic */ InitConfig copy$default(InitConfig r1, Application r2, int r3, Object r4) {
            Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
            if ((r3 & 1) == 0) goto L6;
            r5 = r1.app;
        L6:
            return r1.copy(r5);
        }

        public final Application component1() {
            return this.app;
        }

        public final InitConfig copy(Application r2) {
            Application r1 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "app");
            return new InitConfig(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, InitConfig.class) == true) goto L8;
            return false;
        L8:
            InitConfig r6 = (InitConfig) ZeusTransformUtils.preCheckCast(r5, InitConfig.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.app, r6.app) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final Application getApp() {
            return this.app;
        }

        public int hashCode() {
            return this.app.hashCode();
        }

        public String toString() {
            return "InitConfig(app=" + this.app + ')';
        }
    }

    public interface a {
        void a();
    }

    public static final class aa extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Boolean> f33048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppEvent f33049b;

        public aa(d.c.d<? super Boolean> r3, AppEvent r4) {
            this.f33048a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33049b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33048a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).tryOpenMicToRecording(this.f33049b)));
            return d.x.f38692a;
        }
    }

    public static final class ab extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<? extends EventTaskRecord>> f33050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f33051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f33052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f33053d;

        public ab(d.c.d<? super List<? extends EventTaskRecord>> r3, long r4, long r6, int r8) {
            this.f33050a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33051b = r4;
            this.f33052c = r6;
            this.f33053d = r8;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getAllEventTaskRecords");
            this.f33050a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAllEventTaskRecords(this.f33051b, this.f33052c, this.f33053d)));
            return d.x.f38692a;
        }
    }

    public static final class ac extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAssistantTtsStateListener f33054a;

        public ac(IAssistantTtsStateListener r3) {
            this.f33054a = (IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "registerAssistantTtsPlayingState");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).registerAssistantTtsPlayingState(this.f33054a);
            return d.x.f38692a;
        }
    }

    public static final class ad extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<d.x> f33055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<ConditionTaskAction> f33057c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TaskKnowledge f33058d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f33059e;
        public final /* synthetic */ String f;

        public ad(d.c.d<? super d.x> r3, String r4, List<ConditionTaskAction> r5, TaskKnowledge r6, int r7, String r8) {
            d.c.d<d.x> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            List<ConditionTaskAction> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            this.f33055a = r9;
            this.f33056b = r4;
            this.f33057c = r10;
            this.f33058d = r6;
            this.f33059e = r7;
            this.f = r8;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "tryScheduleConditionTask");
            d.c.d<d.x> r0 = this.f33055a;
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).tryScheduleConditionTask(this.f33056b, this.f33057c, this.f33058d, this.f33059e, this.f);
            r0.resumeWith(d.n.f(d.x.f38692a));
            return d.x.f38692a;
        }
    }

    public static final class ae extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<? extends EventTask>> f33060a;

        public ae(d.c.d<? super List<? extends EventTask>> r3) {
            this.f33060a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getAllEventTasks");
            this.f33060a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAllEventTasks()));
            return d.x.f38692a;
        }
    }

    public static final class af extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IEventTaskChangeListener f33061a;

        public af(IEventTaskChangeListener r3) {
            this.f33061a = (IEventTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventTaskChangeListener.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "registerEventTaskChangeListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).registerEventTaskChangeListener(this.f33061a);
            return d.x.f38692a;
        }
    }

    public static final class ag extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAssistantSessionStateListener f33062a;

        public ag(IAssistantSessionStateListener r3) {
            this.f33062a = (IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "unRegisterAssistantSessionState");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).unRegisterAssistantSessionState(this.f33062a);
            return d.x.f38692a;
        }
    }

    public static final class ah extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<TimerTaskRecord>> f33063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f33064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f33065c;

        public ah(d.c.d<? super List<TimerTaskRecord>> r3, long r4, long r6) {
            this.f33063a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33064b = r4;
            this.f33065c = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33063a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAllTimerTaskRecords(this.f33064b, this.f33065c)));
            return d.x.f38692a;
        }
    }

    public static final class ai extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IEventTaskScheduleListener f33066a;

        public ai(IEventTaskScheduleListener r3) {
            this.f33066a = (IEventTaskScheduleListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventTaskScheduleListener.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "registerEventTaskScheduleListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).registerEventTaskScheduleListener(this.f33066a);
            return d.x.f38692a;
        }
    }

    public static final class aj extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAssistantTtsStateListener f33067a;

        public aj(IAssistantTtsStateListener r3) {
            this.f33067a = (IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "unRegisterAssistantTtsPlayingState");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).unRegisterAssistantTtsPlayingState(this.f33067a);
            return d.x.f38692a;
        }
    }

    public static final class ak extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<TimerTask>> f33068a;

        public ak(d.c.d<? super List<TimerTask>> r3) {
            this.f33068a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33068a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAllTimerTasks()));
            return d.x.f38692a;
        }
    }

    public static final class al extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ITimerTaskChangeListener f33069a;

        public al(ITimerTaskChangeListener r3) {
            this.f33069a = (ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "registerTimerTaskChangeListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).registerTimerTaskChangeListener(this.f33069a);
            return d.x.f38692a;
        }
    }

    public static final class am extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IEventTaskChangeListener f33070a;

        public am(IEventTaskChangeListener r3) {
            this.f33070a = (IEventTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventTaskChangeListener.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "unregisterEventTaskChangeListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).unregisterEventTaskChangeListener(this.f33070a);
            return d.x.f38692a;
        }
    }

    public static final class an extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33071a;

        public an(d.c.d<? super Integer> r3) {
            this.f33071a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33071a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAssistantSessionState()));
            return d.x.f38692a;
        }
    }

    public static final class ao extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33072a;

        public ao(d.c.d<? super Integer> r3) {
            this.f33072a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeAllConditionTaskRecords");
            this.f33072a.resumeWith(d.n.f(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeAllConditionTaskRecords())));
            return d.x.f38692a;
        }
    }

    public static final class ap extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IEventTaskScheduleListener f33073a;

        public ap(IEventTaskScheduleListener r3) {
            this.f33073a = (IEventTaskScheduleListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventTaskScheduleListener.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "unregisterEventTaskScheduleListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).unregisterEventTaskScheduleListener(this.f33073a);
            return d.x.f38692a;
        }
    }

    public static final class aq extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33074a;

        public aq(d.c.d<? super Integer> r3) {
            this.f33074a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33074a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAssistantTtsPlayingState()));
            return d.x.f38692a;
        }
    }

    public static final class ar extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f33076b;

        public ar(d.c.d<? super Integer> r3, int r4) {
            this.f33075a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33076b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeAllEventTaskRecords");
            this.f33075a.resumeWith(d.n.f(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeAllEventTaskRecords(this.f33076b))));
            return d.x.f38692a;
        }
    }

    public static final class as extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ITimerTaskChangeListener f33077a;

        public as(ITimerTaskChangeListener r3) {
            this.f33077a = (ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "unregisterTimerTaskChangeListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).unregisterTimerTaskChangeListener(this.f33077a);
            return d.x.f38692a;
        }
    }

    public static final class at extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<ConditionTask> f33078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33079b;

        public at(d.c.d<? super ConditionTask> r3, String r4) {
            this.f33078a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33079b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getConditionTask");
            this.f33078a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getConditionTask(this.f33079b)));
            return d.x.f38692a;
        }
    }

    public static final class au extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33080a;

        public au(d.c.d<? super Integer> r3) {
            this.f33080a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33080a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeAllTimeTaskRecords()));
            return d.x.f38692a;
        }
    }

    public static final class av extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<ConditionTaskResult> f33081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<ConditionTaskAction> f33083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f33084d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ConditionGroup f33085e;
        public final /* synthetic */ PeriodicPolicy f;
        public final /* synthetic */ TriggerControlPolicy g;
        public final /* synthetic */ int h;
        public final /* synthetic */ Map<String, String> i;

        public av(d.c.d<? super ConditionTaskResult> r3, String r4, List<ConditionTaskAction> r5, String r6, ConditionGroup r7, PeriodicPolicy r8, TriggerControlPolicy r9, int r10, Map<String, String> r11) {
            d.c.d<ConditionTaskResult> r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            List<ConditionTaskAction> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
            this.f33081a = r12;
            this.f33082b = r4;
            this.f33083c = r13;
            this.f33084d = r6;
            this.f33085e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r14;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "updateConditionTask");
            this.f33081a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateConditionTask(this.f33082b, this.f33083c, this.f33084d, this.f33085e, this.f, this.g, this.h, this.i)));
            return d.x.f38692a;
        }
    }

    public static final class aw extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<ConditionTaskRecord>> f33086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f33087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f33088c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f33089d;

        public aw(d.c.d<? super List<ConditionTaskRecord>> r3, long r4, long r6, String r8) {
            this.f33086a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33087b = r4;
            this.f33088c = r6;
            this.f33089d = r8;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getConditionTaskRecordsByTaskId");
            this.f33086a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getConditionTaskRecordsByTaskId(this.f33087b, this.f33088c, this.f33089d)));
            return d.x.f38692a;
        }
    }

    public static final class ax extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<ConditionTaskResult> f33090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String[] f33091b;

        public ax(d.c.d<? super ConditionTaskResult> r3, String[] r4) {
            this.f33090a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33091b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeConditionTask");
            this.f33090a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeConditionTask(this.f33091b)));
            return d.x.f38692a;
        }
    }

    public static final class ay extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<EventTaskResult> f33092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EventTaskSpec f33094c;

        public ay(d.c.d<? super EventTaskResult> r3, String r4, EventTaskSpec r5) {
            this.f33092a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33093b = r4;
            this.f33094c = r5;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "updateEventTask");
            this.f33092a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateEventTask(this.f33093b, this.f33094c)));
            return d.x.f38692a;
        }
    }

    public static final class az extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<EventTask> f33095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33096b;

        public az(d.c.d<? super EventTask> r3, String r4) {
            this.f33095a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33096b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTask");
            this.f33095a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTask(this.f33096b)));
            return d.x.f38692a;
        }
    }

    public static final class b extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<? extends EventTask>> f33097a;

        public b(d.c.d<? super List<? extends EventTask>> r3) {
            this.f33097a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getKnowledgeSessionIdNotNullEventTasks");
            this.f33097a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getKnowledgeSessionIdNotNullEventTasks()));
            return d.x.f38692a;
        }
    }

    public static final class ba extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f33099b;

        public ba(d.c.d<? super Integer> r3, long[] r4) {
            this.f33098a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33099b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeConditionTaskRecordsById");
            this.f33098a.resumeWith(d.n.f(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeConditionTaskRecordsById(this.f33099b))));
            return d.x.f38692a;
        }
    }

    public static final class bb extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<EventTaskExecutionDetailRecord> f33100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EventTaskExecutionDetailRecord f33101b;

        public bb(d.c.d<? super EventTaskExecutionDetailRecord> r3, EventTaskExecutionDetailRecord r4) {
            this.f33100a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33101b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "updateEventTaskExecutionDetailRecord");
            this.f33100a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateEventTaskExecutionDetailRecord(this.f33101b)));
            return d.x.f38692a;
        }
    }

    public static final class bc extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<EventTaskExecutionDetailRecord> f33102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f33103b;

        public bc(d.c.d<? super EventTaskExecutionDetailRecord> r3, long r4) {
            this.f33102a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33103b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskExecutionDetailRecordById");
            this.f33102a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionDetailRecordById(this.f33103b)));
            return d.x.f38692a;
        }
    }

    public static final class bd extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<EventTaskResult> f33104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String[] f33105b;

        public bd(d.c.d<? super EventTaskResult> r3, String[] r4) {
            this.f33104a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33105b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeEventTask");
            this.f33104a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeEventTask(this.f33105b)));
            return d.x.f38692a;
        }
    }

    public static final class be extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<EventTaskExecutionDetailRecord> f33107b;

        public be(d.c.d<? super Integer> r3, List<EventTaskExecutionDetailRecord> r4) {
            d.c.d<Integer> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f33106a = r5;
            this.f33107b = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "updateEventTaskExecutionDetailRecords");
            this.f33106a.resumeWith(d.n.f(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateEventTaskExecutionDetailRecords(this.f33107b))));
            return d.x.f38692a;
        }
    }

    public static final class bf extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<EventTaskExecutionDetailRecord>> f33108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f33109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f33110c;

        public bf(d.c.d<? super List<EventTaskExecutionDetailRecord>> r3, int r4, int r5) {
            this.f33108a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33109b = r4;
            this.f33110c = r5;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskExecutionDetailRecords");
            this.f33108a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionDetailRecords(this.f33109b, this.f33110c)));
            return d.x.f38692a;
        }
    }

    public static final class bg extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f33112b;

        public bg(d.c.d<? super Integer> r3, long[] r4) {
            this.f33111a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33112b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeEventTaskExecutionDetailRecordsById");
            this.f33111a.resumeWith(d.n.f(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeEventTaskExecutionDetailRecordsById(this.f33112b))));
            return d.x.f38692a;
        }
    }

    public static final class bh extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<EventTaskExecutionRecord> f33113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EventTaskExecutionRecord f33114b;

        public bh(d.c.d<? super EventTaskExecutionRecord> r3, EventTaskExecutionRecord r4) {
            this.f33113a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33114b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "updateEventTaskExecutionRecord");
            this.f33113a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateEventTaskExecutionRecord(this.f33114b)));
            return d.x.f38692a;
        }
    }

    public static final class bi extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<EventTaskExecutionDetailRecord>> f33115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f33117c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f33118d;

        public bi(d.c.d<? super List<EventTaskExecutionDetailRecord>> r3, String r4, int r5, int r6) {
            this.f33115a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33116b = r4;
            this.f33117c = r5;
            this.f33118d = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskExecutionDetailRecordsByTaskId");
            this.f33115a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionDetailRecordsByTaskId(this.f33116b, this.f33117c, this.f33118d)));
            return d.x.f38692a;
        }
    }

    public static final class bj extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33120b;

        public bj(d.c.d<? super Integer> r3, String r4) {
            this.f33119a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33120b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeEventTaskExecutionDetailRecordsByTaskId");
            this.f33119a.resumeWith(d.n.f(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeEventTaskExecutionDetailRecordsByTaskId(this.f33120b))));
            return d.x.f38692a;
        }
    }

    public static final class bk extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<EventTaskExecutionRecord> f33122b;

        public bk(d.c.d<? super Integer> r3, List<EventTaskExecutionRecord> r4) {
            d.c.d<Integer> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            List<EventTaskExecutionRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f33121a = r5;
            this.f33122b = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "updateEventTaskExecutionRecords");
            this.f33121a.resumeWith(d.n.f(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateEventTaskExecutionRecords(this.f33122b))));
            return d.x.f38692a;
        }
    }

    public static final class bl extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<EventTaskExecutionRecord> f33123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f33124b;

        public bl(d.c.d<? super EventTaskExecutionRecord> r3, long r4) {
            this.f33123a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33124b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskExecutionRecordById");
            this.f33123a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionRecordById(this.f33124b)));
            return d.x.f38692a;
        }
    }

    public static final class bm extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f33126b;

        public bm(d.c.d<? super Integer> r3, long[] r4) {
            this.f33125a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33126b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeEventTaskExecutionRecordsById");
            this.f33125a.resumeWith(d.n.f(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeEventTaskExecutionRecordsById(this.f33126b))));
            return d.x.f38692a;
        }
    }

    public static final class bn extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<TimerTaskResult> f33127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TimerTask f33128b;

        public bn(d.c.d<? super TimerTaskResult> r3, TimerTask r4) {
            this.f33127a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33128b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33127a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).updateTimerTask(this.f33128b)));
            return d.x.f38692a;
        }
    }

    public static final class bo extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<EventTaskExecutionRecord>> f33129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f33130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f33131c;

        public bo(d.c.d<? super List<EventTaskExecutionRecord>> r3, int r4, int r5) {
            this.f33129a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33130b = r4;
            this.f33131c = r5;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskExecutionRecords");
            this.f33129a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionRecords(this.f33130b, this.f33131c)));
            return d.x.f38692a;
        }
    }

    public static final class bp extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33133b;

        public bp(d.c.d<? super Integer> r3, String r4) {
            this.f33132a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33133b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeEventTaskExecutionRecordsByTaskId");
            this.f33132a.resumeWith(d.n.f(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeEventTaskExecutionRecordsByTaskId(this.f33133b))));
            return d.x.f38692a;
        }
    }

    public static final class bq extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<EventTaskExecutionRecord>> f33134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f33136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f33137d;

        public bq(d.c.d<? super List<EventTaskExecutionRecord>> r3, String r4, int r5, int r6) {
            this.f33134a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33135b = r4;
            this.f33136c = r5;
            this.f33137d = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskExecutionRecordsByTaskId");
            this.f33134a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionRecordsByTaskId(this.f33135b, this.f33136c, this.f33137d)));
            return d.x.f38692a;
        }
    }

    public static final class br extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f33139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long[] f33140c;

        public br(d.c.d<? super Integer> r3, int r4, long[] r5) {
            this.f33138a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33139b = r4;
            this.f33140c = r5;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "removeEventTaskRecordsById");
            this.f33138a.resumeWith(d.n.f(Integer.valueOf(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeEventTaskRecordsById(this.f33139b, this.f33140c))));
            return d.x.f38692a;
        }
    }

    public static final class bs extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<? extends EventTaskRecord>> f33141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f33142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f33143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f33144d;

        public bs(d.c.d<? super List<? extends EventTaskRecord>> r3, long r4, long r6, String r8) {
            this.f33141a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33142b = r4;
            this.f33143c = r6;
            this.f33144d = r8;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTaskRecordsByTaskId");
            this.f33141a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskRecordsByTaskId(this.f33142b, this.f33143c, this.f33144d)));
            return d.x.f38692a;
        }
    }

    public static final class bt extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<TimerTaskResult> f33145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f33146b;

        public bt(d.c.d<? super TimerTaskResult> r3, Map<String, ? extends Object> r4) {
            d.c.d<TimerTaskResult> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            Map<String, Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            this.f33145a = r5;
            this.f33146b = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33145a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeTimerTask(this.f33146b)));
            return d.x.f38692a;
        }
    }

    public static final class bu extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<? extends EventTask>> f33147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f33148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f33149c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f33150d;

        public bu(d.c.d<? super List<? extends EventTask>> r3, int r4, int r5, int r6) {
            this.f33147a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33148b = r4;
            this.f33149c = r5;
            this.f33150d = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getEventTasksByType");
            this.f33147a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTasksByType(this.f33148b, this.f33149c, this.f33150d)));
            return d.x.f38692a;
        }
    }

    public static final class bv extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Integer> f33151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<Integer> f33152b;

        public bv(d.c.d<? super Integer> r3, List<Integer> r4) {
            d.c.d<Integer> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f33151a = r5;
            this.f33152b = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33151a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeTimerTaskRecordsById(this.f33152b)));
            return d.x.f38692a;
        }
    }

    public static final class c extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<TimerTaskResult> f33153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<String> f33154b;

        public c(d.c.d<? super TimerTaskResult> r3, List<String> r4) {
            d.c.d<TimerTaskResult> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f33153a = r5;
            this.f33154b = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33153a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).removeTimerTasksByTaskId(this.f33154b)));
            return d.x.f38692a;
        }
    }

    public static final class d extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<ConditionTaskResult> f33155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<ConditionTaskAction> f33156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f33157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ConditionGroup f33158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PeriodicPolicy f33159e;
        public final /* synthetic */ TriggerControlPolicy f;
        public final /* synthetic */ Map<String, String> g;

        public d(d.c.d<? super ConditionTaskResult> r3, List<ConditionTaskAction> r4, String r5, ConditionGroup r6, PeriodicPolicy r7, TriggerControlPolicy r8, Map<String, String> r9) {
            d.c.d<ConditionTaskResult> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            List<ConditionTaskAction> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
            this.f33155a = r10;
            this.f33156b = r11;
            this.f33157c = r5;
            this.f33158d = r6;
            this.f33159e = r7;
            this.f = r8;
            this.g = r12;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "addConditionTask");
            this.f33155a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).addConditionTask(this.f33156b, this.f33157c, this.f33158d, this.f33159e, this.f, this.g)));
            return d.x.f38692a;
        }
    }

    public static final class e extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Long> f33160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33161b;

        public e(d.c.d<? super Long> r3, String r4) {
            this.f33160a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33161b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33160a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getNextScheduleTimeStamp(this.f33161b)));
            return d.x.f38692a;
        }
    }

    public static final class f extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f33164c;

        public f(String r3, String r4, Map<String, String> r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            this.f33162a = r3;
            this.f33163b = r4;
            this.f33164c = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "requestSendMessage");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).requestSendMessage(this.f33162a, this.f33163b, this.f33164c);
            return d.x.f38692a;
        }
    }

    public static final class g extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<EventTaskResult> f33165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EventTaskSpec f33166b;

        public g(d.c.d<? super EventTaskResult> r3, EventTaskSpec r4) {
            this.f33165a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33166b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "addEventTask");
            this.f33165a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).addEventTask(this.f33166b)));
            return d.x.f38692a;
        }
    }

    public static final class h extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<ShortcutTask>> f33167a;

        public h(d.c.d<? super List<ShortcutTask>> r3) {
            this.f33167a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getShortInstructNotNullShortcutTasks");
            this.f33167a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getShortInstructNotNullShortcutTasks()));
            return d.x.f38692a;
        }
    }

    public static final class i extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33169b;

        public i(String r1, String r2) {
            this.f33168a = r1;
            this.f33169b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "scheduleShortcutTask");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).scheduleShortcutTask(this.f33168a, this.f33169b);
            return d.x.f38692a;
        }
    }

    public static final class j extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<EventTaskExecutionDetailRecord>> f33170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<EventTaskExecutionDetailRecord> f33171b;

        public j(d.c.d<? super List<EventTaskExecutionDetailRecord>> r3, List<EventTaskExecutionDetailRecord> r4) {
            d.c.d<List<EventTaskExecutionDetailRecord>> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f33170a = r5;
            this.f33171b = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "addEventTaskExecutionDetailRecords");
            this.f33170a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).addEventTaskExecutionDetailRecords(this.f33171b)));
            return d.x.f38692a;
        }
    }

    public static final class k extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<? extends EventTask>> f33172a;

        public k(d.c.d<? super List<? extends EventTask>> r3) {
            this.f33172a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getTemplateIdNotNullEventTasks");
            this.f33172a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getTemplateIdNotNullEventTasks()));
            return d.x.f38692a;
        }
    }

    public static final class l extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAssistantInteractionListener f33173a;

        public l(IAssistantInteractionListener r3) {
            this.f33173a = (IAssistantInteractionListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantInteractionListener.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "setAssistantInteractionListener");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).setAssistantInteractionListener(this.f33173a);
            return d.x.f38692a;
        }
    }

    public static final class m extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<EventTaskExecutionRecord>> f33174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<EventTaskExecutionRecord> f33175b;

        public m(d.c.d<? super List<EventTaskExecutionRecord>> r3, List<EventTaskExecutionRecord> r4) {
            d.c.d<List<EventTaskExecutionRecord>> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            List<EventTaskExecutionRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f33174a = r5;
            this.f33175b = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "addEventTaskExecutionRecords");
            this.f33174a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).addEventTaskExecutionRecords(this.f33175b)));
            return d.x.f38692a;
        }
    }

    public static final class n extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<TimerTask> f33176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33177b;

        public n(d.c.d<? super TimerTask> r3, String r4) {
            this.f33176a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33177b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33176a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getTimerTaskByTaskId(this.f33177b)));
            return d.x.f38692a;
        }
    }

    public static final class o extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33178a;

        public o(String r1) {
            this.f33178a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "skipConditionTaskSchedule");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).skipConditionTaskSchedule(this.f33178a);
            return d.x.f38692a;
        }
    }

    public static final class p extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<TimerTaskResult> f33179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TimerTask f33180b;

        public p(d.c.d<? super TimerTaskResult> r3, TimerTask r4) {
            this.f33179a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33180b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33179a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).addTimerTask(this.f33180b)));
            return d.x.f38692a;
        }
    }

    public static final class q extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<TimerTaskRecord>> f33181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f33182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f33183c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f33184d;

        public q(d.c.d<? super List<TimerTaskRecord>> r3, long r4, long r6, String r8) {
            this.f33181a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33182b = r4;
            this.f33183c = r6;
            this.f33184d = r8;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33181a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getTimerTaskRecordsByTaskId(this.f33182b, this.f33183c, this.f33184d)));
            return d.x.f38692a;
        }
    }

    public static final class r extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<TimerTaskResult> f33185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f33186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<Long> f33187c;

        public r(d.c.d<? super TimerTaskResult> r3, String r4, List<Long> r5) {
            d.c.d<TimerTaskResult> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            List<Long> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            this.f33185a = r6;
            this.f33186b = r4;
            this.f33187c = r7;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33185a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).skipTimerTasksByTaskId(this.f33186b, this.f33187c)));
            return d.x.f38692a;
        }
    }

    public static final class s implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.h.a.a<d.x> f33188a;

        public s(d.h.a.a<d.x> r3) {
            this.f33188a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.EventsTaskSdk.a
        public void a() {
            this.f33188a.invoke();
        }
    }

    public static final class t extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f33189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StateInfo f33190b;

        public t(boolean r1, StateInfo r2) {
            this.f33189a = r1;
            this.f33190b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "notifyAssistantState");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).notifyAssistantState(this.f33189a, this.f33190b);
            return d.x.f38692a;
        }
    }

    public static final class u extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Boolean> f33191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActiveAgentEvent f33192b;

        public u(d.c.d<? super Boolean> r3, ActiveAgentEvent r4) {
            this.f33191a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33192b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33191a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).tryActiveAgent(this.f33192b)));
            return d.x.f38692a;
        }
    }

    public static final class v extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f33193a = null;

        static {
            f33193a = new v();
        }

        public v() {
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "closeAssistantInputPanel");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).closeAssistantInputPanel();
            return d.x.f38692a;
        }
    }

    public static final class w extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StateInfo f33194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f33195b;

        public w(StateInfo r1, boolean r2) {
            this.f33194a = r1;
            this.f33195b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "openAssistantInputPanel");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).openAssistantInputPanel(this.f33194a, this.f33195b);
            return d.x.f38692a;
        }
    }

    public static final class x extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Boolean> f33196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppEvent f33197b;

        public x(d.c.d<? super Boolean> r3, AppEvent r4) {
            this.f33196a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33197b = r4;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            this.f33196a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).tryInterruptAssistant(this.f33197b)));
            return d.x.f38692a;
        }
    }

    public static final class y extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<List<ConditionTaskRecord>> f33198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f33199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f33200c;

        public y(d.c.d<? super List<ConditionTaskRecord>> r3, long r4, long r6) {
            this.f33198a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33199b = r4;
            this.f33200c = r6;
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "getAllConditionTaskRecords");
            this.f33198a.resumeWith(d.n.f(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getAllConditionTaskRecords(this.f33199b, this.f33200c)));
            return d.x.f38692a;
        }
    }

    public static final class z extends d.h.b.p implements d.h.a.a<d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAssistantSessionStateListener f33201a;

        public z(IAssistantSessionStateListener r3) {
            this.f33201a = (IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public d.x invoke() {
            Logger.INSTANCE.i(EventsTaskSdk.TAG, "registerAssistantSessionState");
            EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).registerAssistantSessionState(this.f33201a);
            return d.x.f38692a;
        }
    }

    static {
        INSTANCE = new EventsTaskSdk();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$EventsTaskSdk$9ctp7AYvB6rUnMBomunVZKyWU.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor …nts-task-schedule\")\n    }");
        scope = kotlinx.coroutines.an.a(kotlinx.coroutines.br.a(r0));
        mPendingCals = new ArrayList();
        connectionListeners = new CopyOnWriteArraySet();
        mBinderDiedListener = new CopyOnWriteArraySet();
    }

    private EventsTaskSdk() {
    }

    public static final /* synthetic */ IEventProxy access$getApi(EventsTaskSdk r0) {
        return r0.getApi();
    }

    public static /* synthetic */ Object addConditionTask$default(EventsTaskSdk r10, List r11, String r12, ConditionGroup r13, PeriodicPolicy r14, TriggerControlPolicy r15, Map r16, d.c.d r17, int r18, Object r19) {
        List<ConditionTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super ConditionTaskResult> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r18 & 32) == 0) goto L6;
        r0 = null;
    L6:
        return r10.addConditionTask(r3, r12, r13, r14, r15, r0, r9);
    }

    public static final void addConnectionListener(d.h.a.a<d.x> r2) {
        d.h.a.a<d.x> r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "listener");
        connectionListeners.add(r3);
    }

    private static final void addEventBinderListener$lambda$26(IEventBinderListener r2) {
        IEventBinderListener r3 = (IEventBinderListener) ZeusTransformUtils.wrapperContextForParams(r2, IEventBinderListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "$bl");
        mBinderDiedListener.remove(r3);
    }

    private final void addPendingCall(a r4) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        Logger r5 = Logger.INSTANCE;
        r5.d(TAG, "addPendingCall");
        List<a> r0 = mPendingCals;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mPendingCallsExecuted == false) goto L7;
        r5.w(TAG, "in addPendingCall: pending-calls have all been executed; this call shall be execute RIGHT AWAY.");     // Catch: Throwable -> L10
        r3.a();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);
        return;
    L7:
        r0.add(r3);     // Catch: Throwable -> L10
        goto L8
    }

    private final void callOrAddPendingCall(d.h.a.a<d.x> r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(getApi(), EmptyEventProxy.INSTANCE) == true) goto L5;
        r4.invoke();
        return;
    L5:
        addPendingCall(new s(r4));
    }

    private final void execPendingCalls() {
        Logger.INSTANCE.d(TAG, "execPendingCalls");
        List<a> r5 = mPendingCals;
        monitor-enter(r5);
        Iterator<T> r0 = r5.iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        Logger.INSTANCE.d(TAG, "exec foreach call");     // Catch: Throwable -> L11
        r1.a();     // Catch: Throwable -> L11
        goto L6
    L8:
        mPendingCals.clear();     // Catch: Throwable -> L11
        mPendingCallsExecuted = true;     // Catch: Throwable -> L11
        monitor-exit(r5);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private final IEventProxy getApi() {
        return EventServiceConnection.INSTANCE.getApi$eventstaskkit_release();
    }

    private final InitConfig getConfig() {
        InitConfig r1 = _config;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new RuntimeException("you need to invoke EventsTaskSdk.init!");
    }

    public static final void init(InitConfig r5) {
        d.h.b.o.e(r5, "config");
        _config = r5;
        Logger.INSTANCE.i(TAG, "EventsTaskSdk init");
        AppHost.Companion.setAppHost(new b.a.a.a.c((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApp(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")));
        com.obric.eventkit.eventstaskmanager.a.f33211a.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApp(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: lambda$9ctp7AYvB6rUnMBomunVZKy--WU, reason: not valid java name */
    public static /* synthetic */ Thread m944lambda$9ctp7AYvB6rUnMBomunVZKyWU(Runnable r0) {
        return scope$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$XJQPqB-ZuroYG7RJCi7p1noaiwI, reason: not valid java name */
    public static /* synthetic */ void m945lambda$XJQPqBZuroYG7RJCi7p1noaiwI(IEventBinderListener r0) {
        addEventBinderListener$lambda$26(r0);
    }

    public static final void removeConnectionListener(d.h.a.a<d.x> r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "listener");
        connectionListeners.remove(r3);
    }

    public static /* synthetic */ void scheduleShortcutTask$default(EventsTaskSdk r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.scheduleShortcutTask(r1, r2);
    }

    private static final Thread scope$lambda$0(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "events-task-schedule");
    }

    public static final void setLogger(ILogger r2) {
        ILogger r3 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "logger");
        Logger r0 = Logger.INSTANCE;
        r0.setLogger(r3);
        r0.i(TAG, "EventsTaskSdk setLogger");
    }

    public static /* synthetic */ Object tryScheduleConditionTask$default(EventsTaskSdk r9, String r10, List r11, TaskKnowledge r12, int r13, String r14, d.c.d r15, int r16, Object r17) {
        List<ConditionTaskAction> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r16 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        return r9.tryScheduleConditionTask(r10, r4, r12, r13, r7, r8);
    L5:
        r7 = r14;
        goto L7
    }

    public static /* synthetic */ Object updateConditionTask$default(EventsTaskSdk r10, String r11, List r12, String r13, ConditionGroup r14, PeriodicPolicy r15, TriggerControlPolicy r16, int r17, Map r18, d.c.d r19, int r20, Object r21) {
        List<ConditionTaskAction> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super ConditionTaskResult> r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        Map<String, String> r5 = null;
        if ((r20 & 2) == 0) goto L6;
        r1 = null;
    L6:
        if ((r20 & 4) == 0) goto L8;
        String r4 = null;
    L10:
        if ((r20 & 8) == 0) goto L12;
        ConditionGroup r6 = null;
    L14:
        if ((r20 & 16) == 0) goto L16;
        PeriodicPolicy r7 = null;
    L18:
        if ((r20 & 32) == 0) goto L20;
        TriggerControlPolicy r8 = null;
    L22:
        if ((r20 & 64) == 0) goto L24;
        int r9 = -1;
    L26:
        if ((r20 & 128) != 0) goto L30;
        r5 = r3;
    L30:
        return r10.updateConditionTask(r11, r1, r4, r6, r7, r8, r9, r5, r2);
    L24:
        r9 = r17;
        goto L26
    L20:
        r8 = r16;
        goto L22
    L16:
        r7 = r15;
        goto L18
    L12:
        r6 = r14;
        goto L14
    L8:
        r4 = r13;
        goto L10
    }

    public final Object addConditionTask(List<ConditionTaskAction> r13, String r14, ConditionGroup r15, PeriodicPolicy r16, TriggerControlPolicy r17, Map<String, String> r18, d.c.d<? super ConditionTaskResult> r19) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r1 = new d.c.i(d.c.a.b.a(r0));
        INSTANCE.callOrAddPendingCall(new d(r1, r4, r14, r15, r16, r17, r9));
        Object r2 = r1.a();
        if (r2 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r0);
    L5:
        return r2;
    }

    public final void addEventBinderListener(IEventBinderListener r3) {
        final IEventBinderListener r2 = (IEventBinderListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventBinderListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "bl");
        r2.asBinder().linkToDeath(new $$Lambda$EventsTaskSdk$XJQPqBZuroYG7RJCi7p1noaiwI(r2), 0);
        mBinderDiedListener.add(r2);
    }

    public final Object addEventTask(EventTaskSpec r3, d.c.d<? super EventTaskResult> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new g(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r3, d.c.d<? super List<EventTaskExecutionDetailRecord>> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r5));
        INSTANCE.callOrAddPendingCall(new j(r6, r2));
        Object r7 = r6.a();
        if (r7 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r5);
    L5:
        return r7;
    }

    public final Object addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r3, d.c.d<? super List<EventTaskExecutionRecord>> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r5));
        INSTANCE.callOrAddPendingCall(new m(r6, r2));
        Object r7 = r6.a();
        if (r7 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r5);
    L5:
        return r7;
    }

    public final Object addTimerTask(TimerTask r3, d.c.d<? super TimerTaskResult> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new p(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final void binderDied$eventstaskkit_release() {
        Logger.INSTANCE.i(TAG, "binderDied");
        apiInitialized = false;
        setPendingCallsExecuted$eventstaskkit_release(false);
        d.h.a.a<d.x> r3 = binderDiedCallback;
        if (r3 == null) goto L5;
        r3.invoke();
    L5:
        Iterator<T> r4 = mBinderDiedListener.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        ((IEventBinderListener) ZeusTransformUtils.preCheckCast(r4.next(), IEventBinderListener.class, "com.obric.aiagent.plugin")).onBinderDied();
        goto L7
    }

    public final void closeAssistantInputPanel() {
        callOrAddPendingCall(v.f33193a);
    }

    public final Object getAllConditionTaskRecords(long r9, long r11, d.c.d<? super List<ConditionTaskRecord>> r13) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r14 = new d.c.i(d.c.a.b.a(r8));
        INSTANCE.callOrAddPendingCall(new y(r14, r9, r11));
        Object r10 = r14.a();
        if (r10 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r8);
    L5:
        return r10;
    }

    public final Object getAllEventTaskRecords(long r10, long r12, int r14, d.c.d<? super List<? extends EventTaskRecord>> r15) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r16 = new d.c.i(d.c.a.b.a(r9));
        INSTANCE.callOrAddPendingCall(new ab(r16, r10, r12, r14));
        Object r11 = r16.a();
        if (r11 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r9);
    L5:
        return r11;
    }

    public final Object getAllEventTasks(d.c.d<? super List<? extends EventTask>> r3) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r4 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new ae(r4));
        Object r5 = r4.a();
        if (r5 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r5;
    }

    public final Object getAllTimerTaskRecords(long r9, long r11, d.c.d<? super List<TimerTaskRecord>> r13) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r14 = new d.c.i(d.c.a.b.a(r8));
        INSTANCE.callOrAddPendingCall(new ah(r14, r9, r11));
        Object r10 = r14.a();
        if (r10 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r8);
    L5:
        return r10;
    }

    public final Object getAllTimerTasks(d.c.d<? super List<TimerTask>> r3) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r4 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new ak(r4));
        Object r5 = r4.a();
        if (r5 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r5;
    }

    public final boolean getApiInitialized$eventstaskkit_release() {
        return apiInitialized;
    }

    public final Object getAssistantSessionState(d.c.d<? super Integer> r3) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r4 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new an(r4));
        Object r5 = r4.a();
        if (r5 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r5;
    }

    public final Object getAssistantTtsPlayingState(d.c.d<? super Integer> r3) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r4 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new aq(r4));
        Object r5 = r4.a();
        if (r5 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r5;
    }

    public final Object getConditionTask(String r3, d.c.d<? super ConditionTask> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new at(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object getConditionTaskRecordsByTaskId(long r10, long r12, String r14, d.c.d<? super List<ConditionTaskRecord>> r15) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r16 = new d.c.i(d.c.a.b.a(r9));
        INSTANCE.callOrAddPendingCall(new aw(r16, r10, r12, r14));
        Object r11 = r16.a();
        if (r11 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r9);
    L5:
        return r11;
    }

    public final Object getEventTask(String r3, d.c.d<? super EventTask> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new az(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object getEventTaskExecutionDetailRecordById(long r3, d.c.d<? super EventTaskExecutionDetailRecord> r5) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bc(r6, r3));
        Object r4 = r6.a();
        if (r4 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r4;
    }

    public final Object getEventTaskExecutionDetailRecords(int r3, int r4, d.c.d<? super List<EventTaskExecutionDetailRecord>> r5) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bf(r6, r3, r4));
        Object r7 = r6.a();
        if (r7 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r7;
    }

    public final Object getEventTaskExecutionDetailRecordsByTaskId(String r3, int r4, int r5, d.c.d<? super List<EventTaskExecutionDetailRecord>> r6) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r7 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bi(r7, r3, r4, r5));
        Object r8 = r7.a();
        if (r8 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r8;
    }

    public final Object getEventTaskExecutionRecordById(long r3, d.c.d<? super EventTaskExecutionRecord> r5) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bl(r6, r3));
        Object r4 = r6.a();
        if (r4 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r4;
    }

    public final Object getEventTaskExecutionRecords(int r3, int r4, d.c.d<? super List<EventTaskExecutionRecord>> r5) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bo(r6, r3, r4));
        Object r7 = r6.a();
        if (r7 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r7;
    }

    public final Object getEventTaskExecutionRecordsByTaskId(String r3, int r4, int r5, d.c.d<? super List<EventTaskExecutionRecord>> r6) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r7 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bq(r7, r3, r4, r5));
        Object r8 = r7.a();
        if (r8 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r8;
    }

    public final Object getEventTaskRecordsByTaskId(long r10, long r12, String r14, d.c.d<? super List<? extends EventTaskRecord>> r15) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r16 = new d.c.i(d.c.a.b.a(r9));
        INSTANCE.callOrAddPendingCall(new bs(r16, r10, r12, r14));
        Object r11 = r16.a();
        if (r11 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r9);
    L5:
        return r11;
    }

    public final Object getEventTasksByType(int r3, int r4, int r5, d.c.d<? super List<? extends EventTask>> r6) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r7 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bu(r7, r3, r4, r5));
        Object r8 = r7.a();
        if (r8 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r8;
    }

    public final Object getKnowledgeSessionIdNotNullEventTasks(d.c.d<? super List<? extends EventTask>> r3) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r4 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new b(r4));
        Object r5 = r4.a();
        if (r5 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r5;
    }

    public final Object getNextScheduleTimeStamp(String r3, d.c.d<? super Long> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new e(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object getShortInstructNotNullShortcutTasks(d.c.d<? super List<ShortcutTask>> r3) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r4 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new h(r4));
        Object r5 = r4.a();
        if (r5 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r5;
    }

    public final Object getTemplateIdNotNullEventTasks(d.c.d<? super List<? extends EventTask>> r3) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r4 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new k(r4));
        Object r5 = r4.a();
        if (r5 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r5;
    }

    public final Object getTimerTaskByTaskId(String r3, d.c.d<? super TimerTask> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new n(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object getTimerTaskRecordsByTaskId(long r10, long r12, String r14, d.c.d<? super List<TimerTaskRecord>> r15) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r16 = new d.c.i(d.c.a.b.a(r9));
        INSTANCE.callOrAddPendingCall(new q(r16, r10, r12, r14));
        Object r11 = r16.a();
        if (r11 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r9);
    L5:
        return r11;
    }

    public final void notifyAssistantState(boolean r2, StateInfo r3) {
        d.h.b.o.e(r3, "stateInfo");
        callOrAddPendingCall(new t(r2, r3));
    }

    public final void onApiInitComplete$eventstaskkit_release() {
        apiInitialized = true;
        execPendingCalls();
    }

    public final void onConnectionClosed$eventstaskkit_release() {
        Iterator<T> r4 = connectionListeners.iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        ((d.h.a.a) ZeusTransformUtils.preCheckCast(r4.next(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();     // Catch: Throwable -> L8
        Object r0 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r1 = d.n.c(r0);
        if (r1 == null) goto L4;
        Logger.INSTANCE.e(TAG, "connectionListener throw exception: " + d.a.a(r1));
    L8:
        th = move-exception;
        r0 = d.n.f(d.o.a(th));
        goto L10
    }

    public final void onServiceDisconnected$eventstaskkit_release() {
        Logger.INSTANCE.i(TAG, "onServiceDisconnected");
        apiInitialized = false;
    }

    public final void openAssistantInputPanel(StateInfo r2, boolean r3) {
        d.h.b.o.e(r2, "stateInfo");
        callOrAddPendingCall(new w(r2, r3));
    }

    public final void registerAssistantSessionState(IAssistantSessionStateListener r3) {
        IAssistantSessionStateListener r4 = (IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        callOrAddPendingCall(new z(r4));
    }

    public final void registerAssistantTtsPlayingState(IAssistantTtsStateListener r3) {
        IAssistantTtsStateListener r4 = (IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        callOrAddPendingCall(new ac(r4));
    }

    public final void registerEventTaskChangeListener(IEventTaskChangeListener r3) {
        IEventTaskChangeListener r4 = (IEventTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventTaskChangeListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        callOrAddPendingCall(new af(r4));
    }

    public final void registerEventTaskScheduleListener(IEventTaskScheduleListener r3) {
        IEventTaskScheduleListener r4 = (IEventTaskScheduleListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventTaskScheduleListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        callOrAddPendingCall(new ai(r4));
    }

    public final void registerTimerTaskChangeListener(ITimerTaskChangeListener r3) {
        ITimerTaskChangeListener r4 = (ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        callOrAddPendingCall(new al(r4));
    }

    public final Object removeAllConditionTaskRecords(d.c.d<? super Integer> r3) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r4 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new ao(r4));
        Object r5 = r4.a();
        if (r5 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r5;
    }

    public final Object removeAllEventTaskRecords(int r3, d.c.d<? super Integer> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new ar(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object removeAllTimeTaskRecords(d.c.d<? super Integer> r3) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r4 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new au(r4));
        Object r5 = r4.a();
        if (r5 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r5;
    }

    public final Object removeConditionTask(String[] r3, d.c.d<? super ConditionTaskResult> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new ax(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object removeConditionTaskRecordsById(long[] r3, d.c.d<? super Integer> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new ba(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object removeEventTask(String[] r3, d.c.d<? super EventTaskResult> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bd(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object removeEventTaskExecutionDetailRecordsById(long[] r3, d.c.d<? super Integer> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bg(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object removeEventTaskExecutionDetailRecordsByTaskId(String r3, d.c.d<? super Integer> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bj(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object removeEventTaskExecutionRecordsById(long[] r3, d.c.d<? super Integer> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bm(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object removeEventTaskExecutionRecordsByTaskId(String r3, d.c.d<? super Integer> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bp(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object removeEventTaskRecordsById(int r3, long[] r4, d.c.d<? super Integer> r5) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new br(r6, r3, r4));
        Object r7 = r6.a();
        if (r7 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r7;
    }

    public final Object removeTimerTask(Map<String, ? extends Object> r3, d.c.d<? super TimerTaskResult> r4) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r5));
        INSTANCE.callOrAddPendingCall(new bt(r6, r2));
        Object r7 = r6.a();
        if (r7 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r5);
    L5:
        return r7;
    }

    public final Object removeTimerTaskRecordsById(List<Integer> r3, d.c.d<? super Integer> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r5));
        INSTANCE.callOrAddPendingCall(new bv(r6, r2));
        Object r7 = r6.a();
        if (r7 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r5);
    L5:
        return r7;
    }

    public final Object removeTimerTasksByTaskId(List<String> r3, d.c.d<? super TimerTaskResult> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r5));
        INSTANCE.callOrAddPendingCall(new c(r6, r2));
        Object r7 = r6.a();
        if (r7 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r5);
    L5:
        return r7;
    }

    public final void requestSendMessage(String r3, String r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "content");
        d.h.b.o.e(r4, DBHelper.BATTERY_COL_SCENE);
        callOrAddPendingCall(new f(r3, r4, r6));
    }

    public final void scheduleShortcutTask(String r2, String r3) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        callOrAddPendingCall(new i(r2, r3));
    }

    public final void setApiInitialized$eventstaskkit_release(boolean r1) {
        apiInitialized = r1;
    }

    public final void setAssistantInteractionListener(IAssistantInteractionListener r3) {
        IAssistantInteractionListener r4 = (IAssistantInteractionListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantInteractionListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        callOrAddPendingCall(new l(r4));
    }

    public final void setBinderDiedCallback(d.h.a.a<d.x> r2) {
        d.h.a.a<d.x> r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "func");
        binderDiedCallback = r1;
    }

    public final void setPendingCallsExecuted$eventstaskkit_release(boolean r1) {
        List<a> r0 = mPendingCals;
        monitor-enter(r0);
        mPendingCallsExecuted = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void skipConditionTaskSchedule(String r2) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        callOrAddPendingCall(new o(r2));
    }

    public final Object skipTimerTasksByTaskId(String r3, List<Long> r4, d.c.d<? super TimerTaskResult> r5) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r7 = new d.c.i(d.c.a.b.a(r6));
        INSTANCE.callOrAddPendingCall(new r(r7, r3, r2));
        Object r8 = r7.a();
        if (r8 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r6);
    L5:
        return r8;
    }

    public final Object tryActiveAgent(ActiveAgentEvent r3, d.c.d<? super Boolean> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new u(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object tryInterruptAssistant(AppEvent r3, d.c.d<? super Boolean> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new x(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object tryOpenMicToRecording(AppEvent r3, d.c.d<? super Boolean> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new aa(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object tryScheduleConditionTask(String r9, List<ConditionTaskAction> r10, TaskKnowledge r11, int r12, String r13, d.c.d<? super d.x> r14) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r15 = new d.c.i(d.c.a.b.a(r8));
        INSTANCE.callOrAddPendingCall(new ad(r15, r9, r4, r11, r12, r13));
        Object r16 = r15.a();
        if (r16 != d.c.a.b.a()) goto L6;
        d.c.b.a.h.c(r8);
    L6:
        if (r16 != d.c.a.b.a()) goto L9;
        return r16;
    L9:
        return d.x.f38692a;
    }

    public final void unRegisterAssistantSessionState(IAssistantSessionStateListener r3) {
        IAssistantSessionStateListener r4 = (IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        callOrAddPendingCall(new ag(r4));
    }

    public final void unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener r3) {
        IAssistantTtsStateListener r4 = (IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        callOrAddPendingCall(new aj(r4));
    }

    public final void unregisterEventTaskChangeListener(IEventTaskChangeListener r3) {
        IEventTaskChangeListener r4 = (IEventTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventTaskChangeListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        callOrAddPendingCall(new am(r4));
    }

    public final void unregisterEventTaskScheduleListener(IEventTaskScheduleListener r3) {
        IEventTaskScheduleListener r4 = (IEventTaskScheduleListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventTaskScheduleListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        callOrAddPendingCall(new ap(r4));
    }

    public final void unregisterTimerTaskChangeListener(ITimerTaskChangeListener r3) {
        ITimerTaskChangeListener r4 = (ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        callOrAddPendingCall(new as(r4));
    }

    public final Object updateConditionTask(String r15, List<ConditionTaskAction> r16, String r17, ConditionGroup r18, PeriodicPolicy r19, TriggerControlPolicy r20, int r21, Map<String, String> r22, d.c.d<? super ConditionTaskResult> r23) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r1 = new d.c.i(d.c.a.b.a(r0));
        INSTANCE.callOrAddPendingCall(new av(r1, r15, r5, r17, r18, r19, r20, r21, r11));
        Object r2 = r1.a();
        if (r2 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r0);
    L5:
        return r2;
    }

    public final Object updateEventTask(String r3, EventTaskSpec r4, d.c.d<? super EventTaskResult> r5) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new ay(r6, r3, r4));
        Object r7 = r6.a();
        if (r7 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r7;
    }

    public final Object updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r3, d.c.d<? super EventTaskExecutionDetailRecord> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bb(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r3, d.c.d<? super Integer> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r5));
        INSTANCE.callOrAddPendingCall(new be(r6, r2));
        Object r7 = r6.a();
        if (r7 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r5);
    L5:
        return r7;
    }

    public final Object updateEventTaskExecutionRecord(EventTaskExecutionRecord r3, d.c.d<? super EventTaskExecutionRecord> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bh(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }

    public final Object updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r3, d.c.d<? super Integer> r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r6 = new d.c.i(d.c.a.b.a(r5));
        INSTANCE.callOrAddPendingCall(new bk(r6, r2));
        Object r7 = r6.a();
        if (r7 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r5);
    L5:
        return r7;
    }

    public final Object updateTimerTask(TimerTask r3, d.c.d<? super TimerTaskResult> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r5 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new bn(r5, r3));
        Object r6 = r5.a();
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r6;
    }
}
