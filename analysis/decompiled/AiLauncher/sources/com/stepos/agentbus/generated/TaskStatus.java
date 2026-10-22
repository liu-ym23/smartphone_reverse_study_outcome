package com.stepos.agentbus.generated;

import Z8.C1174w;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5685n;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentbus/generated/TaskStatus;", "", "<init>", "(Ljava/lang/String;I)V", "", "getWire", "()Ljava/lang/String;", "wire", "Companion", Const.INTENT_KEY_APIKEY, "CREATED", "PENDING", "PLANNING", "RUNNING", "PAUSED", "IN_PROGRESS", "WAITING", "COMPLETED", "FAILED", "SKIPPED", "CANCELLED", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TaskStatus {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
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

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/agentbus/generated/TaskStatus$a;", "", "<init>", "()V", "", UxipConstants.f30680s, "Lcom/stepos/agentbus/generated/TaskStatus;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/agentbus/generated/TaskStatus;", "", "WIRE_MAP", "Ljava/util/Map;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.TaskStatus$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final TaskStatus a(String value) {
            p.i(value, "value");
            Map map = TaskStatus.WIRE_MAP;
            String lowerCase = value.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            TaskStatus taskStatus = (TaskStatus) map.get(lowerCase);
            return taskStatus == null ? TaskStatus.CREATED : taskStatus;
        }

        public Companion() {
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
        InterfaceC4149a<TaskStatus> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(entries, 10)), 16));
        for (TaskStatus taskStatus : entries) {
            String lowerCase = taskStatus.name().toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            linkedHashMap.put(lowerCase, taskStatus);
        }
        WIRE_MAP = linkedHashMap;
    }

    private TaskStatus(String str, int i10) {
    }

    public static InterfaceC4149a<TaskStatus> getEntries() {
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
        p.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
