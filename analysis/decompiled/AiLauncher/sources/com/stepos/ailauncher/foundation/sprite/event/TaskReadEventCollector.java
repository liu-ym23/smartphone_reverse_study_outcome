package com.stepos.ailauncher.foundation.sprite.event;

import La.H;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.v;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventType;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001-B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0003J'\u0010\u0019\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/foundation/sprite/event/TaskReadEventCollector;", "Lcom/stepos/ailauncher/foundation/sprite/event/d;", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "task", "", "f", "(Lcom/stepos/ailauncher/foundation/task/entity/UiTask;)Z", "", "action", "sessionForeground", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/foundation/task/entity/UiTask;Ljava/lang/String;Z)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/String;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/foundation/task/entity/UiTask;)Ljava/util/List;", "c", Const.INTENT_KEY_UMID, "foregroundSessionId", "", "foregroundKeys", "e", "(Ljava/lang/String;Ljava/util/Set;)V", "key", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)Z", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/ailauncher/foundation/sprite/event/TaskReadEventCollector$a;", "unread", "Ljava/util/concurrent/ConcurrentHashMap;", "", "flushLock", "Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "observing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "LUa/M;", "scope", "LUa/M;", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskReadEventCollector extends d {
    private static final String TAG = "TaskReadEventCollector";
    public static final TaskReadEventCollector INSTANCE = new TaskReadEventCollector();
    private static final ConcurrentHashMap<String, UnreadEntry> unread = new ConcurrentHashMap<>();
    private static final Object flushLock = new Object();
    private static final AtomicBoolean observing = new AtomicBoolean(false);
    private static final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.c().getImmediate()));

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/foundation/sprite/event/TaskReadEventCollector$a;", "", "", "kind", "", "sessionKeys", "taskId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "getTaskId", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.sprite.event.TaskReadEventCollector$a, reason: from toString */
    public static final /* data */ class UnreadEntry {
        private final String kind;
        private final List<String> sessionKeys;
        private final String taskId;

        public UnreadEntry(String kind, List<String> sessionKeys, String taskId) {
            p.i(kind, "kind");
            p.i(sessionKeys, "sessionKeys");
            p.i(taskId, "taskId");
            this.kind = kind;
            this.sessionKeys = sessionKeys;
            this.taskId = taskId;
        }

        /* renamed from: a, reason: from getter */
        public final String getKind() {
            return this.kind;
        }

        public final List<String> b() {
            return this.sessionKeys;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnreadEntry)) {
                return false;
            }
            UnreadEntry unreadEntry = (UnreadEntry) other;
            return p.d(this.kind, unreadEntry.kind) && p.d(this.sessionKeys, unreadEntry.sessionKeys) && p.d(this.taskId, unreadEntry.taskId);
        }

        public int hashCode() {
            return (((this.kind.hashCode() * 31) + this.sessionKeys.hashCode()) * 31) + this.taskId.hashCode();
        }

        public String toString() {
            return "UnreadEntry(kind=" + this.kind + ", sessionKeys=" + this.sessionKeys + ", taskId=" + this.taskId + ")";
        }
    }

    public final void c() {
        if (observing.compareAndSet(false, true)) {
            C1060i.d(scope, null, null, new TaskReadEventCollector$ensureObserving$1(null), 3, null);
        }
    }

    public final void d() {
        v vVar = v.INSTANCE;
        if (vVar.k()) {
            e(vVar.i().getValue(), vVar.g().getValue());
        }
    }

    public final void e(String foregroundSessionId, Set<String> foregroundKeys) {
        synchronized (flushLock) {
            try {
                ConcurrentHashMap<String, UnreadEntry> concurrentHashMap = unread;
                if (concurrentHashMap.isEmpty()) {
                    return;
                }
                Set<Map.Entry<String, UnreadEntry>> setEntrySet = concurrentHashMap.entrySet();
                p.h(setEntrySet, "<get-entries>(...)");
                ArrayList<Map.Entry> arrayList = new ArrayList();
                for (Object obj : setEntrySet) {
                    Map.Entry entry = (Map.Entry) obj;
                    p.f(entry);
                    Object value = entry.getValue();
                    p.h(value, "component2(...)");
                    List<String> listB = ((UnreadEntry) value).b();
                    if (!(listB instanceof Collection) || !listB.isEmpty()) {
                        Iterator<T> it = listB.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (INSTANCE.h((String) it.next(), foregroundSessionId, foregroundKeys)) {
                                    arrayList.add(obj);
                                    break;
                                }
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (Map.Entry entry2 : arrayList) {
                    p.f(entry2);
                    Object key = entry2.getKey();
                    p.h(key, "component1(...)");
                    Object value2 = entry2.getValue();
                    p.h(value2, "component2(...)");
                    UnreadEntry unreadEntry = (UnreadEntry) value2;
                    unread.remove((String) key, unreadEntry);
                    linkedHashSet.add(unreadEntry.getKind());
                }
                List<String> listM1 = F.m1(linkedHashSet);
                t tVar = t.f7040a;
                for (String str : listM1) {
                    C4148a.k(TAG, "unread viewed kind=" + str, false, 4, null);
                    INSTANCE.a(new SpriteEvent(SpriteEventType.TASK_READ, str, System.currentTimeMillis(), Boolean.TRUE));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean f(UiTask task) {
        p.i(task, "task");
        v vVar = v.INSTANCE;
        if (vVar.k()) {
            return vVar.p(task.getRequestedSessionKey()) || vVar.p(task.getConversationId());
        }
        return false;
    }

    public final String g(String action) {
        switch (action.hashCode()) {
            case -1174157495:
                if (action.equals(SpriteEventAction.TASK_SUCCESS)) {
                    return SpriteEventAction.TASK_SUCCESS_READ;
                }
                return null;
            case -797531512:
                if (action.equals(SpriteEventAction.TASK_INTERRUPTED)) {
                    return SpriteEventAction.TASK_ERROR_READ;
                }
                return null;
            case -709077539:
                if (action.equals(SpriteEventAction.TASK_WAIT_SAFE)) {
                    return SpriteEventAction.TASK_WAIT_READ;
                }
                return null;
            case 180994031:
                if (action.equals(SpriteEventAction.TASK_WAIT)) {
                    return SpriteEventAction.TASK_WAIT_READ;
                }
                return null;
            case 1299739342:
                if (action.equals(SpriteEventAction.TASK_ERROR)) {
                    return SpriteEventAction.TASK_ERROR_READ;
                }
                return null;
            default:
                return null;
        }
    }

    public final boolean h(String key, String foregroundSessionId, Set<String> foregroundKeys) {
        if (H.x0(key)) {
            return false;
        }
        if (foregroundSessionId == null || H.x0(foregroundSessionId) || !p.d(key, foregroundSessionId)) {
            return foregroundKeys.contains(key);
        }
        return true;
    }

    public final void i(UiTask task, String action, boolean sessionForeground) {
        p.i(task, "task");
        p.i(action, "action");
        String strG = g(action);
        if (strG == null) {
            return;
        }
        if (sessionForeground) {
            unread.remove(task.getTaskId());
            return;
        }
        List<String> listJ = j(task);
        if (listJ.isEmpty()) {
            C4148a.u(TAG, "skip unread: no session key taskId=" + task.getTaskId() + " action=" + action, false, 4, null);
            return;
        }
        unread.put(task.getTaskId(), new UnreadEntry(strG, listJ, task.getTaskId()));
        C4148a.k(TAG, "unread mark kind=" + strG + " taskId=" + task.getTaskId() + " keys=" + listJ, false, 4, null);
        c();
        d();
    }

    public final List<String> j(UiTask task) {
        String requestedSessionKey = task.getRequestedSessionKey();
        String str = null;
        if (requestedSessionKey == null || H.x0(requestedSessionKey)) {
            requestedSessionKey = null;
        }
        String conversationId = task.getConversationId();
        if (conversationId != null && !H.x0(conversationId)) {
            str = conversationId;
        }
        return F.g0(C1173v.r(requestedSessionKey, str));
    }
}
