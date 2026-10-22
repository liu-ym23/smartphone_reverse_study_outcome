package com.stepos.ailauncher.taskstore;

import La.H;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Xa.k;
import Xa.t;
import Xa.u;
import Z8.C1174w;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.M0;
import com.stepos.agentframework.chatcore.session.N;
import com.stepos.agentframework.chatcore.session.N0;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import com.stepos.ailauncher.taskstore.audio.AudioWaveformClient;
import com.stepos.ailauncher.taskstore.database.TaskStoreDatabase;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.livenotification.A;
import com.stepos.ailauncher.taskstore.livenotification.T;
import com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher;
import com.stepos.ailauncher.taskstore.livenotification.y;
import com.stepos.ailauncher.taskstore.provider.TaskCreatedSideEffects;
import com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Predicate;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import t6.C5516d;

@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005*\u0001[\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\tJ\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0003J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001d\u0010\u001cJ!\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b \u0010!J\u0015\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u001e\u0010)\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0080@¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0000¢\u0006\u0004\b+\u0010,J\u001e\u0010.\u001a\u00020\u00042\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060&H\u0080@¢\u0006\u0004\b.\u0010*J\u001d\u00100\u001a\u00020\u00042\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0000¢\u0006\u0004\b0\u00101J\u001d\u00102\u001a\u00020\u00042\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0000¢\u0006\u0004\b2\u00101J\u001d\u00104\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0000¢\u0006\u0004\b4\u00101J\u001d\u00105\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060/H\u0000¢\u0006\u0004\b5\u00101J\u0017\u00106\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0004\b6\u0010\rJ\u0019\u00108\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b8\u0010\rJ\u0017\u0010:\u001a\u00020\u000b2\u0006\u00109\u001a\u00020'H\u0000¢\u0006\u0004\b:\u0010;J\u0018\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b=\u0010>J\u0018\u0010@\u001a\u00020?2\u0006\u00109\u001a\u00020'H\u0086@¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0010H\u0000¢\u0006\u0004\bB\u0010\u0012R\u0018\u0010C\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\"0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00060G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010IR \u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020L0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR \u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020L0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010NR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00060S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00060V8\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020L8\u0002X\u0082T¢\u0006\u0006\n\u0004\b^\u0010.¨\u0006_"}, d2 = {"Lcom/stepos/ailauncher/taskstore/TaskStoreModule;", "", "<init>", "()V", "LY8/t;", "u", "", "uid", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)V", "taskId", "", "x", "(Ljava/lang/String;)Z", "key", "v", "Landroid/content/Context;", "M", "()Landroid/content/Context;", "k", "()Ljava/lang/String;", "N", "context", "q", "(Landroid/content/Context;)V", "l", "Lcom/stepos/ailauncher/taskstore/repository/a;", "n", "()Lcom/stepos/ailauncher/taskstore/repository/a;", "o", "api", "detail", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/taskstore/i;", "observer", "K", "(Lcom/stepos/ailauncher/taskstore/i;)V", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "cards", "H", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "I", "(Ljava/util/List;)V", "taskIds", "J", "", "G", "(Ljava/util/Collection;)V", "Q", "sessionKeys", "D", "P", "y", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "w", "card", "z", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Z", "sessionId", "O", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/taskstore/repository/b;", "p", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Le9/c;)Ljava/lang/Object;", "L", "appContext", "Landroid/content/Context;", "repository", "Lcom/stepos/ailauncher/taskstore/repository/a;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "writeObservers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "failOpenLoggedApis", "Ljava/util/concurrent/ConcurrentHashMap;", "", "recentlyDeletedTaskIds", "Ljava/util/concurrent/ConcurrentHashMap;", "recentlyDeletedSessionKeys", "LUa/M;", "moduleScope", "LUa/M;", "LXa/k;", "_currentUid", "LXa/k;", "LXa/t;", "currentUidFlow", "LXa/t;", "m", "()LXa/t;", "com/stepos/ailauncher/taskstore/TaskStoreModule$a", "accountCallback", "Lcom/stepos/ailauncher/taskstore/TaskStoreModule$a;", "DELETION_TOMBSTONE_TTL_MS", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskStoreModule {
    private static final long DELETION_TOMBSTONE_TTL_MS = 300000;
    private static final k<String> _currentUid;
    private static final a accountCallback;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context appContext;
    private static final t<String> currentUidFlow;
    private static volatile com.stepos.ailauncher.taskstore.repository.a repository;
    public static final TaskStoreModule INSTANCE = new TaskStoreModule();
    private static final CopyOnWriteArraySet<i> writeObservers = new CopyOnWriteArraySet<>();
    private static final CopyOnWriteArraySet<String> failOpenLoggedApis = new CopyOnWriteArraySet<>();
    private static final ConcurrentHashMap<String, Long> recentlyDeletedTaskIds = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Long> recentlyDeletedSessionKeys = new ConcurrentHashMap<>();
    private static final M moduleScope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/TaskStoreModule$a", "Lcom/stepos/ailauncher/foundation/account/i;", "Lcom/stepos/ailauncher/foundation/account/a;", "accountInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/account/a;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements com.stepos.ailauncher.foundation.account.i {
        @Override // com.stepos.ailauncher.foundation.account.i
        public void a(AccountInfo accountInfo) {
            String accountId = accountInfo != null ? accountInfo.getAccountId() : null;
            if (accountId == null) {
                accountId = "";
            }
            TaskStoreModule taskStoreModule = TaskStoreModule.INSTANCE;
            taskStoreModule.N(accountId);
            if (accountId.length() > 0) {
                taskStoreModule.j(accountId);
                return;
            }
            Context context = TaskStoreModule.appContext;
            if (context != null) {
                A.INSTANCE.b(context);
            }
        }
    }

    static {
        k<String> kVarA = u.a("");
        _currentUid = kVarA;
        currentUidFlow = Xa.d.c(kVarA);
        accountCallback = new a();
    }

    public static final boolean B(long j10, Map.Entry it) {
        p.i(it, "it");
        Object value = it.getValue();
        p.h(value, "<get-value>(...)");
        return j10 - ((Number) value).longValue() > 300000;
    }

    public static final boolean C(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public static final boolean E(long j10, Map.Entry it) {
        p.i(it, "it");
        Object value = it.getValue();
        p.h(value, "<get-value>(...)");
        return j10 - ((Number) value).longValue() > 300000;
    }

    public static final boolean F(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public static final void r(String from, String to) {
        p.i(from, "from");
        p.i(to, "to");
        C1060i.d(moduleScope, null, null, new TaskStoreModule$init$1$4$1(from, to, null), 3, null);
    }

    public static final void s(String sessionId) {
        p.i(sessionId, "sessionId");
        C1060i.d(moduleScope, null, null, new TaskStoreModule$init$1$5$1(sessionId, null), 3, null);
    }

    public static final void t(Collection sessionIds) {
        p.i(sessionIds, "sessionIds");
        C1060i.d(moduleScope, null, null, new TaskStoreModule$init$1$6$1(sessionIds, null), 3, null);
    }

    public final void A(String api, String detail) {
        p.i(api, "api");
        p.i(detail, "detail");
        if (failOpenLoggedApis.add(api)) {
            C4148a.h("TaskStoreModule", api + ": " + detail, false, 4, null);
        }
    }

    public final void D(Collection<String> sessionKeys) {
        p.i(sessionKeys, "sessionKeys");
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Set<Map.Entry<String, Long>> setEntrySet = recentlyDeletedSessionKeys.entrySet();
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TaskStoreModule.B(jCurrentTimeMillis, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() { // from class: com.stepos.ailauncher.taskstore.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return TaskStoreModule.C(interfaceC5074l, obj);
            }
        });
        Collection<String> collection = sessionKeys;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            recentlyDeletedSessionKeys.put((String) it2.next(), Long.valueOf(jCurrentTimeMillis));
        }
    }

    public final void G(Collection<String> taskIds) {
        p.i(taskIds, "taskIds");
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Set<Map.Entry<String, Long>> setEntrySet = recentlyDeletedTaskIds.entrySet();
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TaskStoreModule.E(jCurrentTimeMillis, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() { // from class: com.stepos.ailauncher.taskstore.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return TaskStoreModule.F(interfaceC5074l, obj);
            }
        });
        ArrayList arrayList = new ArrayList();
        for (Object obj : taskIds) {
            if (!H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            recentlyDeletedTaskIds.put((String) it.next(), Long.valueOf(jCurrentTimeMillis));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x009b -> B:30:0x009d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H(java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoCard> r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.stepos.ailauncher.taskstore.TaskStoreModule$notifyCardsSaved$1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.ailauncher.taskstore.TaskStoreModule$notifyCardsSaved$1 r0 = (com.stepos.ailauncher.taskstore.TaskStoreModule$notifyCardsSaved$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.TaskStoreModule$notifyCardsSaved$1 r0 = new com.stepos.ailauncher.taskstore.TaskStoreModule$notifyCardsSaved$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r12 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L4b
            if (r1 != r2) goto L43
            int r11 = r0.I$0
            java.lang.Object r1 = r0.L$5
            com.stepos.ailauncher.taskstore.TaskStoreModule r1 = (com.stepos.ailauncher.taskstore.TaskStoreModule) r1
            java.lang.Object r1 = r0.L$4
            com.stepos.ailauncher.taskstore.i r1 = (com.stepos.ailauncher.taskstore.i) r1
            java.lang.Object r1 = r0.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r4 = r0.L$1
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L40
            goto L9d
        L40:
            r10 = move-exception
            goto Laa
        L43:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L4b:
            kotlin.C4849c.b(r10)
            boolean r10 = r11.isEmpty()
            if (r10 == 0) goto L57
            Y8.t r10 = Y8.t.f7040a
            return r10
        L57:
            java.util.concurrent.CopyOnWriteArraySet<com.stepos.ailauncher.taskstore.i> r10 = com.stepos.ailauncher.taskstore.TaskStoreModule.writeObservers
            java.util.Iterator r1 = r10.iterator()
            r4 = r10
            r10 = r3
        L5f:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto Lb4
            java.lang.Object r5 = r1.next()
            r6 = r5
            com.stepos.ailauncher.taskstore.i r6 = (com.stepos.ailauncher.taskstore.i) r6
            com.stepos.ailauncher.taskstore.TaskStoreModule r7 = com.stepos.ailauncher.taskstore.TaskStoreModule.INSTANCE
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> La5
            r0.L$0 = r11     // Catch: java.lang.Throwable -> La5
            java.lang.Object r8 = g9.h.a(r4)     // Catch: java.lang.Throwable -> La5
            r0.L$1 = r8     // Catch: java.lang.Throwable -> La5
            r0.L$2 = r1     // Catch: java.lang.Throwable -> La5
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Throwable -> La5
            r0.L$3 = r5     // Catch: java.lang.Throwable -> La5
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> La5
            r0.L$4 = r5     // Catch: java.lang.Throwable -> La5
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> La5
            r0.L$5 = r5     // Catch: java.lang.Throwable -> La5
            r0.I$0 = r10     // Catch: java.lang.Throwable -> La5
            r0.I$1 = r3     // Catch: java.lang.Throwable -> La5
            r0.I$2 = r3     // Catch: java.lang.Throwable -> La5
            r0.label = r2     // Catch: java.lang.Throwable -> La5
            java.lang.Object r5 = r6.b(r11, r0)     // Catch: java.lang.Throwable -> La5
            if (r5 != r12) goto L9b
            return r12
        L9b:
            r5 = r11
            r11 = r10
        L9d:
            Y8.t r10 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L40
            kotlin.Result.b(r10)     // Catch: java.lang.Throwable -> L40
        La2:
            r10 = r11
            r11 = r5
            goto L5f
        La5:
            r5 = move-exception
            r9 = r11
            r11 = r10
            r10 = r5
            r5 = r9
        Laa:
            kotlin.Result$a r6 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.C4849c.a(r10)
            kotlin.Result.b(r10)
            goto La2
        Lb4:
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.TaskStoreModule.H(java.util.List, e9.c):java.lang.Object");
    }

    public final void I(List<TaskInfoCard> cards) {
        p.i(cards, "cards");
        if (cards.isEmpty()) {
            return;
        }
        C1060i.d(moduleScope, null, null, new TaskStoreModule$notifyCardsSavedAsync$1(cards, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00d0 -> B:36:0x00d2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(java.util.List<java.lang.String> r12, e9.InterfaceC4014c<? super Y8.t> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.TaskStoreModule.J(java.util.List, e9.c):java.lang.Object");
    }

    public final void K(i observer) {
        p.i(observer, "observer");
        writeObservers.add(observer);
    }

    public final Context L() {
        return M();
    }

    public final Context M() {
        Context context = appContext;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("请先在 Application.onCreate 中调用 TaskStoreModule.init(context)");
    }

    public final void N(String uid) {
        p.i(uid, "uid");
        k<String> kVar = _currentUid;
        if (p.d(kVar.getValue(), uid)) {
            return;
        }
        C4148a.k("TaskStoreModule", "currentUid changed: '" + ((Object) kVar.getValue()) + "' -> '" + uid + "'", false, 4, null);
        kVar.setValue(uid);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e2, code lost:
    
        if (p(r1, r2) == r3) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00e2 -> B:30:0x00e5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O(java.lang.String r17, e9.InterfaceC4014c<? super Y8.t> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.TaskStoreModule.O(java.lang.String, e9.c):java.lang.Object");
    }

    public final void P(Collection<String> sessionKeys) {
        p.i(sessionKeys, "sessionKeys");
        Collection<String> collection = sessionKeys;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(H.D1((String) it.next()).toString());
        }
        ConcurrentHashMap<String, Long> concurrentHashMap = recentlyDeletedSessionKeys;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            concurrentHashMap.remove((String) it2.next());
        }
    }

    public final void Q(Collection<String> taskIds) {
        p.i(taskIds, "taskIds");
        ConcurrentHashMap<String, Long> concurrentHashMap = recentlyDeletedTaskIds;
        Iterator<T> it = taskIds.iterator();
        while (it.hasNext()) {
            concurrentHashMap.remove((String) it.next());
        }
    }

    public final void j(String uid) {
        C1060i.d(moduleScope, null, null, new TaskStoreModule$claimOrphans$1(uid, null), 3, null);
    }

    public final String k() {
        return _currentUid.getValue();
    }

    public final void l() {
        Object objB;
        if (_currentUid.getValue().length() > 0) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(com.stepos.ailauncher.foundation.account.f.INSTANCE.k());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            return;
        }
        N(str);
        j(str);
    }

    public final t<String> m() {
        return currentUidFlow;
    }

    public final com.stepos.ailauncher.taskstore.repository.a n() {
        com.stepos.ailauncher.taskstore.repository.a taskInfoCardRepositoryImpl;
        TaskStoreDatabase.Companion lVar = TaskStoreDatabase.INSTANCE;
        if (lVar.i()) {
            throw new IllegalStateException("task store unavailable (disk)");
        }
        Context contextM = M();
        com.stepos.ailauncher.taskstore.repository.a aVar = repository;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            taskInfoCardRepositoryImpl = repository;
            if (taskInfoCardRepositoryImpl == null) {
                TaskStoreDatabase taskStoreDatabaseB = lVar.b(contextM);
                taskInfoCardRepositoryImpl = new TaskInfoCardRepositoryImpl(taskStoreDatabaseB.m0(), taskStoreDatabaseB.n0(), taskStoreDatabaseB.o0(), taskStoreDatabaseB.k0());
                repository = taskInfoCardRepositoryImpl;
            }
        }
        return taskInfoCardRepositoryImpl;
    }

    public final com.stepos.ailauncher.taskstore.repository.a o() {
        Object objB;
        if (TaskStoreDatabase.INSTANCE.i()) {
            A("getRepositoryOrNull", "store already unavailable");
            return null;
        }
        failOpenLoggedApis.clear();
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(n());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("TaskStoreModule", "getRepository failed", thE, false, 8, null);
        }
        return (com.stepos.ailauncher.taskstore.repository.a) (Result.g(objB) ? null : objB);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0208 A[PHI: r2 r5 r9 r10 r14 r15
      0x0208: PHI (r2v12 com.stepos.ailauncher.taskstore.repository.b) = 
      (r2v9 com.stepos.ailauncher.taskstore.repository.b)
      (r2v9 com.stepos.ailauncher.taskstore.repository.b)
      (r2v9 com.stepos.ailauncher.taskstore.repository.b)
      (r2v9 com.stepos.ailauncher.taskstore.repository.b)
      (r2v14 com.stepos.ailauncher.taskstore.repository.b)
     binds: [B:67:0x0168, B:68:0x016a, B:70:0x0170, B:75:0x017e, B:89:0x0201] A[DONT_GENERATE, DONT_INLINE]
      0x0208: PHI (r5v10 com.stepos.ailauncher.taskstore.entity.TaskInfoCard) = 
      (r5v5 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r5v5 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r5v5 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r5v5 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r5v12 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
     binds: [B:67:0x0168, B:68:0x016a, B:70:0x0170, B:75:0x017e, B:89:0x0201] A[DONT_GENERATE, DONT_INLINE]
      0x0208: PHI (r9v8 com.stepos.ailauncher.taskstore.entity.TaskInfoCard) = 
      (r9v3 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r9v3 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r9v3 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r9v3 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r9v10 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
     binds: [B:67:0x0168, B:68:0x016a, B:70:0x0170, B:75:0x017e, B:89:0x0201] A[DONT_GENERATE, DONT_INLINE]
      0x0208: PHI (r10v5 int) = (r10v3 int), (r10v3 int), (r10v3 int), (r10v3 int), (r10v6 int) binds: [B:67:0x0168, B:68:0x016a, B:70:0x0170, B:75:0x017e, B:89:0x0201] A[DONT_GENERATE, DONT_INLINE]
      0x0208: PHI (r14v4 com.stepos.ailauncher.taskstore.entity.TaskInfoCard) = 
      (r14v1 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r14v1 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r14v1 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r14v1 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r14v7 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
     binds: [B:67:0x0168, B:68:0x016a, B:70:0x0170, B:75:0x017e, B:89:0x0201] A[DONT_GENERATE, DONT_INLINE]
      0x0208: PHI (r15v4 com.stepos.ailauncher.taskstore.repository.a) = 
      (r15v1 com.stepos.ailauncher.taskstore.repository.a)
      (r15v1 com.stepos.ailauncher.taskstore.repository.a)
      (r15v1 com.stepos.ailauncher.taskstore.repository.a)
      (r15v1 com.stepos.ailauncher.taskstore.repository.a)
      (r15v5 com.stepos.ailauncher.taskstore.repository.a)
     binds: [B:67:0x0168, B:68:0x016a, B:70:0x0170, B:75:0x017e, B:89:0x0201] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x020b  */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r27, e9.InterfaceC4014c<? super com.stepos.ailauncher.taskstore.repository.TaskInfoCardSaveResult> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 857
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.TaskStoreModule.p(com.stepos.ailauncher.taskstore.entity.TaskInfoCard, e9.c):java.lang.Object");
    }

    public final void q(Context context) {
        Object objB;
        p.i(context, "context");
        if (appContext != null) {
            return;
        }
        synchronized (this) {
            try {
                if (appContext != null) {
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                appContext = applicationContext;
                T t10 = T.INSTANCE;
                p.f(applicationContext);
                t10.y(applicationContext);
                y.INSTANCE.a(applicationContext);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    TaskLiveNotificationDispatcher.INSTANCE.f0(applicationContext);
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.t("TaskStoreModule", "LiveNotificationDispatcher.init failed", thE, false, 8, null);
                }
                AudioWaveformClient.INSTANCE.B(applicationContext);
                com.stepos.ailauncher.taskstore.audio.a.INSTANCE.c();
                TaskCreatedSideEffects.c(C5516d.INSTANCE);
                TaskStoreModule taskStoreModule = INSTANCE;
                taskStoreModule.u();
                C1060i.d(moduleScope, null, null, new TaskStoreModule$init$1$3(applicationContext, null), 3, null);
                M0.INSTANCE.d(taskStoreModule, new M0.a() { // from class: com.stepos.ailauncher.taskstore.b
                    @Override // com.stepos.agentframework.chatcore.session.M0.a
                    public final void a(String str, String str2) {
                        TaskStoreModule.r(str, str2);
                    }
                });
                N0.INSTANCE.b(taskStoreModule, new N0.a() { // from class: com.stepos.ailauncher.taskstore.c
                    @Override // com.stepos.agentframework.chatcore.session.N0.a
                    public final void a(String str) {
                        TaskStoreModule.s(str);
                    }
                });
                N.INSTANCE.b(taskStoreModule, new N.a() { // from class: com.stepos.ailauncher.taskstore.d
                    @Override // com.stepos.agentframework.chatcore.session.N.a
                    public final void a(Collection collection) {
                        TaskStoreModule.t(collection);
                    }
                });
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void u() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(com.stepos.ailauncher.foundation.account.f.INSTANCE.k());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("TaskStoreModule", "read account id failed during init", thE, false, 8, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            str = "";
        }
        _currentUid.setValue(str);
        com.stepos.ailauncher.foundation.account.f.INSTANCE.z(accountCallback);
        if (str.length() > 0) {
            j(str);
        }
        C4148a.k("TaskStoreModule", "account binding initialized, uid='" + str + "'", false, 4, null);
    }

    public final boolean v(String key) {
        ConcurrentHashMap<String, Long> concurrentHashMap = recentlyDeletedSessionKeys;
        Long l10 = concurrentHashMap.get(key);
        if (l10 != null) {
            if (System.currentTimeMillis() - l10.longValue() <= 300000) {
                return true;
            }
            concurrentHashMap.remove(key, l10);
        }
        return false;
    }

    public final boolean w(String sessionKey) {
        if (recentlyDeletedSessionKeys.isEmpty()) {
            return false;
        }
        String string = sessionKey != null ? H.D1(sessionKey).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return false;
        }
        if (v(string)) {
            return true;
        }
        String strF = M0.INSTANCE.f(string);
        return (strF == null || p.d(strF, string) || !v(strF)) ? false : true;
    }

    public final boolean x(String taskId) {
        ConcurrentHashMap<String, Long> concurrentHashMap = recentlyDeletedTaskIds;
        Long l10 = concurrentHashMap.get(taskId);
        if (l10 != null) {
            if (System.currentTimeMillis() - l10.longValue() <= 300000) {
                return true;
            }
            concurrentHashMap.remove(taskId, l10);
        }
        return false;
    }

    public final boolean y(String taskId) {
        p.i(taskId, "taskId");
        if (x(taskId)) {
            return true;
        }
        String strA = com.stepos.ailauncher.taskstore.a.INSTANCE.a(taskId);
        return (strA == null || p.d(strA, taskId) || !x(strA)) ? false : true;
    }

    public final boolean z(TaskInfoCard card) {
        p.i(card, "card");
        return y(card.getTaskId()) || w(card.getSessionKey()) || w(card.getRequestSessionKey());
    }
}
