package com.stepos.agentbus.generated;

import D7.w;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentbus/generated/TaskStatus;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "CREATED", "PENDING", "PLANNING", "RUNNING", "PAUSED", "IN_PROGRESS", "WAITING", "COMPLETED", "FAILED", "SKIPPED", "CANCELLED", "wire", "", "getWire", "()Ljava/lang/String;", "Companion", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskStatus {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ TaskStatus[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Map<String, TaskStatus> WIRE_MAP;
    public static final TaskStatus CREATED = new TaskStatus("CREATED", 0);
    public static final TaskStatus PENDING = new TaskStatus("PENDING", 1);
    public static final TaskStatus PLANNING = new TaskStatus("PLANNING", 2);
    public static final TaskStatus RUNNING = new TaskStatus("RUNNING", 3);
    public static final TaskStatus PAUSED = new TaskStatus("PAUSED", 4);
    public static final TaskStatus IN_PROGRESS = new TaskStatus("IN_PROGRESS", 5);
    public static final TaskStatus WAITING = new TaskStatus("WAITING", 6);
    public static final TaskStatus COMPLETED = new TaskStatus("COMPLETED", 7);
    public static final TaskStatus FAILED = new TaskStatus("FAILED", 8);
    public static final TaskStatus SKIPPED = new TaskStatus("SKIPPED", 9);
    public static final TaskStatus CANCELLED = new TaskStatus("CANCELLED", 10);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/agentbus/generated/TaskStatus$Companion;", "", AppAgent.CONSTRUCT, "()V", "WIRE_MAP", "", "", "Lcom/stepos/agentbus/generated/TaskStatus;", "fromWire", "value", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final TaskStatus fromWire(String value) {
            k.f(value, "value");
            Map map = TaskStatus.WIRE_MAP;
            String lowerCase = value.toLowerCase(Locale.ROOT);
            k.e(lowerCase, "toLowerCase(...)");
            TaskStatus taskStatus = (TaskStatus) map.get(lowerCase);
            return taskStatus == null ? TaskStatus.CREATED : taskStatus;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ TaskStatus[] $values() {
        return new TaskStatus[]{CREATED, PENDING, PLANNING, RUNNING, PAUSED, IN_PROGRESS, WAITING, COMPLETED, FAILED, SKIPPED, CANCELLED};
    }

    static {
        TaskStatus[] taskStatusArr$values = $values();
        $VALUES = taskStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(taskStatusArr$values);
        INSTANCE = new Companion(null);
        K7.a entries = getEntries();
        int iP = kotlin.collections.a.P(w.c0(entries, 10));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP < 16 ? 16 : iP);
        for (Object obj : entries) {
            String lowerCase = ((TaskStatus) obj).name().toLowerCase(Locale.ROOT);
            k.e(lowerCase, "toLowerCase(...)");
            linkedHashMap.put(lowerCase, obj);
        }
        WIRE_MAP = linkedHashMap;
    }

    private TaskStatus(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static TaskStatus valueOf(String str) {
        return (TaskStatus) Enum.valueOf(TaskStatus.class, str);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) $VALUES.clone();
    }

    public final String getWire() {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
