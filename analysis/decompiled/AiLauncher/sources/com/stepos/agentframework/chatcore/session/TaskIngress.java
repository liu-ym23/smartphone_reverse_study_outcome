package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.BusPart;
import com.stepos.agentframework.adapter.netcore.BusQuestion;
import com.stepos.agentframework.adapter.netcore.BusTask;
import com.stepos.agentframework.adapter.netcore.BusTaskAnswer;
import com.stepos.agentframework.adapter.netcore.BusTaskProgress;
import com.stepos.agentframework.adapter.netcore.BusTaskStatus;
import com.stepos.agentframework.adapter.netcore.TaskEventPayload;
import com.stepos.agentframework.adapter.netcore.TaskEventType;
import com.stepos.agentframework.chatcore.session.O0;
import com.stepos.agentframework.chatcore.session.bean.AgentTaskEventType;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import h8.C4148a;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import u4.AgentTaskEvent;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001=B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u0013\u0010\u0016\u001a\u00020\u0011*\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0019\u001a\u00020\u0018*\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u0018*\u00020\u0011H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0013\u0010\u001c\u001a\u00020\u0018*\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010&R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00101R\u0014\u00103\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00101R\u0014\u00104\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00101R\u0014\u00105\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00101R\u0014\u00106\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00101R\u0014\u00107\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00101R\u0014\u00108\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00101R\u0014\u00109\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00101R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/TaskIngress;", "", "<init>", "()V", "LY8/t;", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", "p", "()Ljava/lang/String;", "Lcom/stepos/agentframework/adapter/netcore/C;", "payload", "m", "(Lcom/stepos/agentframework/adapter/netcore/C;)V", "o", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "taskId", "Lu4/h;", "event", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Lu4/h;)V", "l", "r", "(Lcom/stepos/agentframework/adapter/netcore/C;)Lu4/h;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lu4/h;)I", "n", "q", "TAG", "Ljava/lang/String;", "", "STATS_EVERY", "J", "SIG_CACHE_CAPACITY", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "attached", "Ljava/util/concurrent/atomic/AtomicBoolean;", "firstPayloadLogged", "drainScheduled", "Ljava/util/concurrent/ConcurrentHashMap;", AuthSessionDto.STATUS_PENDING, "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/agentframework/chatcore/session/TaskIngress$SignatureLruCache;", "lastAppliedSig", "Lcom/stepos/agentframework/chatcore/session/TaskIngress$SignatureLruCache;", "Ljava/util/concurrent/atomic/AtomicLong;", "received", "Ljava/util/concurrent/atomic/AtomicLong;", "pendingPuts", "skippedUnchanged", "applied", "dispatchedNoCard", "invalidFrames", "saveFailed", "busFallback", "attachRetries", "Lcom/stepos/agentframework/adapter/netcore/B;", "apiListener", "Lcom/stepos/agentframework/adapter/netcore/B;", "SignatureLruCache", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TaskIngress {
    private static final int SIG_CACHE_CAPACITY = 256;
    private static final long STATS_EVERY = 64;
    private static final String TAG = "TaskIngress";
    public static final TaskIngress INSTANCE = new TaskIngress();
    private static final AtomicBoolean attached = new AtomicBoolean(false);
    private static final AtomicBoolean firstPayloadLogged = new AtomicBoolean(false);
    private static final AtomicBoolean drainScheduled = new AtomicBoolean(false);
    private static final ConcurrentHashMap<String, AgentTaskEvent> pending = new ConcurrentHashMap<>();
    private static final SignatureLruCache lastAppliedSig = new SignatureLruCache(256);
    private static final AtomicLong received = new AtomicLong(0);
    private static final AtomicLong pendingPuts = new AtomicLong(0);
    private static final AtomicLong skippedUnchanged = new AtomicLong(0);
    private static final AtomicLong applied = new AtomicLong(0);
    private static final AtomicLong dispatchedNoCard = new AtomicLong(0);
    private static final AtomicLong invalidFrames = new AtomicLong(0);
    private static final AtomicLong saveFailed = new AtomicLong(0);
    private static final AtomicLong busFallback = new AtomicLong(0);
    private static final AtomicLong attachRetries = new AtomicLong(0);
    private static final com.stepos.agentframework.adapter.netcore.B apiListener = new com.stepos.agentframework.adapter.netcore.B() { // from class: com.stepos.agentframework.chatcore.session.Q0
        @Override // com.stepos.agentframework.adapter.netcore.B
        public final void a(TaskEventPayload taskEventPayload) {
            TaskIngress.f(taskEventPayload);
        }
    };

    @Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004*\u0001\u0011\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/TaskIngress$SignatureLruCache;", "", "", "capacity", "<init>", "(I)V", "", "key", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/Integer;", "sig", "LY8/t;", "c", "(Ljava/lang/String;I)V", Const.INTENT_KEY_UMID, "()I", "I", "com/stepos/agentframework/chatcore/session/TaskIngress$SignatureLruCache$map$1", C3081a.FOCUS_MAP_NAME, "Lcom/stepos/agentframework/chatcore/session/TaskIngress$SignatureLruCache$map$1;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SignatureLruCache {
        private final int capacity;
        private final TaskIngress$SignatureLruCache$map$1 map;

        public SignatureLruCache(int i10) {
            this.capacity = i10;
            this.map = new TaskIngress$SignatureLruCache$map$1(this, i10);
        }

        public final synchronized Integer b(String key) {
            kotlin.jvm.internal.p.i(key, "key");
            return (Integer) this.map.get(key);
        }

        public final synchronized void c(String key, int sig) {
            kotlin.jvm.internal.p.i(key, "key");
            this.map.put(key, Integer.valueOf(sig));
        }

        public final synchronized int d() {
            return this.map.size();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskEventType.values().length];
            try {
                iArr[TaskEventType.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskEventType.UPDATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TaskEventType.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TaskEventType.ANSWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void f(TaskEventPayload payload) {
        kotlin.jvm.internal.p.i(payload, "payload");
        INSTANCE.m(payload);
    }

    public final void g(String taskId, AgentTaskEvent event) {
        Object objB;
        int iJ = j(event);
        Integer numB = lastAppliedSig.b(taskId);
        if (numB != null && numB.intValue() == iJ) {
            skippedUnchanged.incrementAndGet();
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(V0.e(V0.INSTANCE, event, false, 2, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "store apply crashed taskId=" + taskId, thE, false, 8, null);
        }
        O0.e eVar = O0.e.INSTANCE;
        if (Result.g(objB)) {
            objB = eVar;
        }
        O0 o02 = (O0) objB;
        if (o02 instanceof O0.Applied) {
            applied.incrementAndGet();
        } else if (kotlin.jvm.internal.p.d(o02, O0.b.INSTANCE)) {
            dispatchedNoCard.incrementAndGet();
        } else if (kotlin.jvm.internal.p.d(o02, O0.d.INSTANCE)) {
            applied.incrementAndGet();
        } else if (kotlin.jvm.internal.p.d(o02, O0.c.INSTANCE)) {
            invalidFrames.incrementAndGet();
        } else {
            if (!kotlin.jvm.internal.p.d(o02, eVar)) {
                throw new NoWhenBranchMatchedException();
            }
            saveFailed.incrementAndGet();
        }
        if ((o02 instanceof O0.c) || (o02 instanceof O0.e)) {
            busFallback.incrementAndGet();
            P0.a(event.a(), event);
            C4148a.u(TAG, "TaskEventBus fallback taskId=" + taskId + " type=" + event.getEventType() + " reason=" + o02, false, 4, null);
        }
        if (kotlin.jvm.internal.p.d(o02, eVar)) {
            return;
        }
        lastAppliedSig.c(taskId, iJ);
    }

    public final void h() {
        while (true) {
            Set<String> setKeySet = pending.keySet();
            kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
            List<String> listM1 = Z8.F.m1(setKeySet);
            if (listM1.isEmpty()) {
                l();
                return;
            }
            for (String str : listM1) {
                AgentTaskEvent agentTaskEventRemove = pending.remove(str);
                if (agentTaskEventRemove != null) {
                    g(str, agentTaskEventRemove);
                }
            }
        }
    }

    public final void i() {
        AtomicBoolean atomicBoolean = attached;
        if (!atomicBoolean.get() && R0.a()) {
            synchronized (this) {
                try {
                    if (atomicBoolean.get()) {
                        return;
                    }
                    if (ApiManager.INSTANCE.l(ApiType.AGENTBUS, apiListener)) {
                        atomicBoolean.set(true);
                        C4148a.k(TAG, "attached single AGENTBUS TaskEventListener", false, 4, null);
                    } else {
                        C4148a.u(TAG, "attach failed: no AGENTBUS client yet, will retry (retries=" + attachRetries.incrementAndGet() + ")", false, 4, null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final int j(AgentTaskEvent agentTaskEvent) {
        String strA = agentTaskEvent.A();
        String strW = agentTaskEvent.w();
        BusTaskAnswer answer = agentTaskEvent.getAnswer();
        Integer numValueOf = null;
        Map<String, Object> mapC = answer != null ? answer.c() : null;
        List<BusQuestion> listL = agentTaskEvent.l();
        AgentTaskEventType eventType = agentTaskEvent.getEventType();
        Integer numE = agentTaskEvent.E();
        Integer numValueOf2 = Integer.valueOf(agentTaskEvent.z());
        Integer numValueOf3 = Integer.valueOf(agentTaskEvent.b());
        BusTaskStatus busTaskStatusS = agentTaskEvent.s();
        String strName = busTaskStatusS != null ? busTaskStatusS.name() : null;
        Long lD = agentTaskEvent.D();
        Long lE = agentTaskEvent.e();
        Integer numValueOf4 = strA != null ? Integer.valueOf(strA.length()) : null;
        Integer numValueOf5 = Integer.valueOf(strA != null ? strA.hashCode() : 0);
        Integer numValueOf6 = strW != null ? Integer.valueOf(strW.length()) : null;
        Integer numValueOf7 = Integer.valueOf(strW != null ? strW.hashCode() : 0);
        Integer numValueOf8 = mapC != null ? Integer.valueOf(mapC.size()) : null;
        Integer numValueOf9 = Integer.valueOf(mapC != null ? mapC.hashCode() : 0);
        Boolean boolValueOf = Boolean.valueOf(agentTaskEvent.j());
        BusTaskProgress busTaskProgressM = agentTaskEvent.m();
        Integer numValueOf10 = listL != null ? Integer.valueOf(listL.size()) : null;
        if (listL != null) {
            numValueOf = 0;
            for (BusQuestion busQuestion : listL) {
                numValueOf = Integer.valueOf((numValueOf.intValue() * 31) + busQuestion.getQuestion().hashCode() + busQuestion.c().size());
            }
        }
        return C1173v.p(eventType, numE, numValueOf2, numValueOf3, strName, lD, lE, numValueOf4, numValueOf5, numValueOf6, numValueOf7, numValueOf8, numValueOf9, boolValueOf, busTaskProgressM, numValueOf10, numValueOf, Integer.valueOf(n(agentTaskEvent)), Integer.valueOf(q(agentTaskEvent))).hashCode();
    }

    public final void k() {
        if (R0.a()) {
            i();
        } else {
            C4148a.k(TAG, "install skipped: feature disabled", false, 4, null);
        }
    }

    public final void l() {
        long j10 = received.get();
        if (j10 <= 0 || j10 % STATS_EVERY != 0) {
            return;
        }
        C4148a.k(TAG, p(), false, 4, null);
    }

    public final void m(TaskEventPayload payload) {
        received.incrementAndGet();
        if (firstPayloadLogged.compareAndSet(false, true)) {
            C4148a.k(TAG, "first task event received: type=" + payload.getEventType() + " taskId=" + payload.g() + " sessionKey=" + payload.getSessionKey(), false, 4, null);
        }
        AgentTaskEvent agentTaskEventR = r(payload);
        String string = La.H.D1(agentTaskEventR.y()).toString();
        if (string.length() == 0) {
            C4148a.u(TAG, "drop task event: empty taskId type=" + agentTaskEventR.getEventType(), false, 4, null);
            return;
        }
        int iJ = j(agentTaskEventR);
        Integer numB = lastAppliedSig.b(string);
        if (numB != null && numB.intValue() == iJ) {
            skippedUnchanged.incrementAndGet();
            l();
        } else {
            pending.put(string, agentTaskEventR);
            pendingPuts.incrementAndGet();
            o();
        }
    }

    public final int n(AgentTaskEvent agentTaskEvent) {
        List<BusPart> listO = agentTaskEvent.o();
        if (listO == null) {
            return 0;
        }
        int size = listO.size();
        for (BusPart busPart : listO) {
            int iOrdinal = ((size * 31) + busPart.getType().ordinal()) * 31;
            String status = busPart.getStatus();
            size = ((((iOrdinal + (status != null ? status.hashCode() : 0)) * 31) + busPart.getContent().length()) * 31) + busPart.getTaskVersion();
        }
        return size;
    }

    public final void o() {
        if (drainScheduled.compareAndSet(false, true)) {
            Function2.c(new TaskIngress$scheduleDrain$1(null));
        }
    }

    public final String p() {
        return "recv=" + received.get() + " pendingPuts=" + pendingPuts.get() + " skipUnchanged=" + skippedUnchanged.get() + " applied=" + applied.get() + " noCard=" + dispatchedNoCard.get() + " invalid=" + invalidFrames.get() + " saveFail=" + saveFailed.get() + " busFallback=" + busFallback.get() + " attachRetries=" + attachRetries.get() + " attached=" + attached.get() + " pendingSize=" + pending.size() + " lastSigs=" + lastAppliedSig.d();
    }

    public final int q(AgentTaskEvent agentTaskEvent) {
        List<BusTask> listU = agentTaskEvent.u();
        if (listU == null) {
            return 0;
        }
        int size = listU.size();
        for (BusTask busTask : listU) {
            size = (((((((size * 31) + busTask.getTaskId().hashCode()) * 31) + busTask.getStatus().ordinal()) * 31) + busTask.getTaskVersion()) * 31) + Long.hashCode(busTask.getUpdatedAt());
        }
        return size;
    }

    public final AgentTaskEvent r(TaskEventPayload taskEventPayload) {
        AgentTaskEventType agentTaskEventType;
        int i10 = a.$EnumSwitchMapping$0[taskEventPayload.getEventType().ordinal()];
        if (i10 == 1) {
            agentTaskEventType = AgentTaskEventType.CREATED;
        } else if (i10 == 2) {
            agentTaskEventType = AgentTaskEventType.UPDATED;
        } else if (i10 == 3) {
            agentTaskEventType = AgentTaskEventType.COMPLETED;
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            agentTaskEventType = AgentTaskEventType.ANSWER;
        }
        return new AgentTaskEvent(agentTaskEventType, taskEventPayload.getSeq(), taskEventPayload.getTs(), taskEventPayload.getSessionKey(), taskEventPayload.getTask(), taskEventPayload.getAnswer());
    }
}
