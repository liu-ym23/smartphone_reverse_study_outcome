package com.stepos.taskrobot.llmapi.stepfun;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001#B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ9\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\rJ\u0015\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001dR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR*\u0010!\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u000e\u0012\f0 R\b\u0012\u0004\u0012\u00028\u00000\u00000\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/EndedTaskCache;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "ttlMs", "", "cap", "Lkotlin/Function0;", "now", AppAgent.CONSTRUCT, "(JILS7/a;)V", "LC7/r;", "evictOldest", "()V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "message", "callback", "put", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Lcom/stepos/taskrobot/llmapi/stepfun/EndedTaskSnapshot;", "peek", "(Ljava/lang/String;)Lcom/stepos/taskrobot/llmapi/stepfun/EndedTaskSnapshot;", "clear", "remove", "(Ljava/lang/String;)V", "J", "I", "LS7/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/taskrobot/llmapi/stepfun/EndedTaskCache$Entry;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Entry", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EndedTaskCache<T> {
    private final int cap;
    private final ConcurrentHashMap<String, EndedTaskCache<T>.Entry> map;
    private final S7.a now;
    private final long ttlMs;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.EndedTaskCache$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements S7.a {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        @Override // S7.a
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/EndedTaskCache$Entry;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "message", "callback", "timestamp", "", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/llmapi/stepfun/EndedTaskCache;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;J)V", "getTaskName", "()Ljava/lang/String;", "getAction", "getMessage", "getCallback", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTimestamp", "()J", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class Entry {
        private final String action;
        private final T callback;
        private final String message;
        private final String taskName;
        final /* synthetic */ EndedTaskCache<T> this$0;
        private final long timestamp;

        public Entry(EndedTaskCache endedTaskCache, String taskName, String action, String str, T t9, long j5) {
            kotlin.jvm.internal.k.f(taskName, "taskName");
            kotlin.jvm.internal.k.f(action, "action");
            this.this$0 = endedTaskCache;
            this.taskName = taskName;
            this.action = action;
            this.message = str;
            this.callback = t9;
            this.timestamp = j5;
        }

        public final String getAction() {
            return this.action;
        }

        public final T getCallback() {
            return this.callback;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTaskName() {
            return this.taskName;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    public EndedTaskCache(long j5, int i, S7.a now) {
        kotlin.jvm.internal.k.f(now, "now");
        this.ttlMs = j5;
        this.cap = i;
        this.now = now;
        this.map = new ConcurrentHashMap<>();
    }

    private final void evictOldest() {
        T t9;
        Set<Map.Entry<String, EndedTaskCache<T>.Entry>> setEntrySet = this.map.entrySet();
        kotlin.jvm.internal.k.e(setEntrySet, "<get-entries>(...)");
        Iterator<T> it = setEntrySet.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                long timestamp = ((Entry) ((Map.Entry) next).getValue()).getTimestamp();
                do {
                    T next2 = it.next();
                    long timestamp2 = ((Entry) ((Map.Entry) next2).getValue()).getTimestamp();
                    if (timestamp > timestamp2) {
                        next = next2;
                        timestamp = timestamp2;
                    }
                } while (it.hasNext());
            }
            t9 = next;
        } else {
            t9 = null;
        }
        Map.Entry entry = (Map.Entry) t9;
        if (entry != null) {
            this.map.remove(entry.getKey());
        }
    }

    public final void clear() {
        this.map.clear();
    }

    public final EndedTaskSnapshot<T> peek(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        EndedTaskCache<T>.Entry entry = this.map.get(taskId);
        if (entry == null) {
            return null;
        }
        if (((Number) this.now.invoke()).longValue() - entry.getTimestamp() <= this.ttlMs) {
            return new EndedTaskSnapshot<>(entry.getTaskName(), entry.getAction(), entry.getMessage(), entry.getCallback());
        }
        this.map.remove(taskId);
        return null;
    }

    public final void put(String taskId, String taskName, String action, String message, T callback) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(action, "action");
        this.map.put(taskId, new Entry(this, taskName, action, message, callback, ((Number) this.now.invoke()).longValue()));
        while (this.map.size() > this.cap) {
            evictOldest();
        }
    }

    public final void remove(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        this.map.remove(taskId);
    }

    public /* synthetic */ EndedTaskCache(long j5, int i, S7.a aVar, int i6, kotlin.jvm.internal.e eVar) {
        this(j5, i, (i6 & 4) != 0 ? AnonymousClass1.INSTANCE : aVar);
    }
}
