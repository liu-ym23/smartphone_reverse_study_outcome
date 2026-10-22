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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentbus/generated/TaskType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "IMAGE", "TEXT", "AUTOMATION", "PRESENTATION", "TABLE", "DOCUMENT", "CODE", "SCHEDULE", "VIDEO", "AUDIO", "OTHER", "wire", "", "getWire", "()Ljava/lang/String;", "Companion", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskType {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ TaskType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Map<String, TaskType> WIRE_MAP;
    public static final TaskType IMAGE = new TaskType("IMAGE", 0);
    public static final TaskType TEXT = new TaskType("TEXT", 1);
    public static final TaskType AUTOMATION = new TaskType("AUTOMATION", 2);
    public static final TaskType PRESENTATION = new TaskType("PRESENTATION", 3);
    public static final TaskType TABLE = new TaskType("TABLE", 4);
    public static final TaskType DOCUMENT = new TaskType("DOCUMENT", 5);
    public static final TaskType CODE = new TaskType("CODE", 6);
    public static final TaskType SCHEDULE = new TaskType("SCHEDULE", 7);
    public static final TaskType VIDEO = new TaskType("VIDEO", 8);
    public static final TaskType AUDIO = new TaskType("AUDIO", 9);
    public static final TaskType OTHER = new TaskType("OTHER", 10);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/agentbus/generated/TaskType$Companion;", "", AppAgent.CONSTRUCT, "()V", "WIRE_MAP", "", "", "Lcom/stepos/agentbus/generated/TaskType;", "fromWire", "value", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final TaskType fromWire(String value) {
            k.f(value, "value");
            Map map = TaskType.WIRE_MAP;
            String lowerCase = value.toLowerCase(Locale.ROOT);
            k.e(lowerCase, "toLowerCase(...)");
            TaskType taskType = (TaskType) map.get(lowerCase);
            return taskType == null ? TaskType.OTHER : taskType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ TaskType[] $values() {
        return new TaskType[]{IMAGE, TEXT, AUTOMATION, PRESENTATION, TABLE, DOCUMENT, CODE, SCHEDULE, VIDEO, AUDIO, OTHER};
    }

    static {
        TaskType[] taskTypeArr$values = $values();
        $VALUES = taskTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(taskTypeArr$values);
        INSTANCE = new Companion(null);
        K7.a entries = getEntries();
        int iP = kotlin.collections.a.P(w.c0(entries, 10));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP < 16 ? 16 : iP);
        for (Object obj : entries) {
            String lowerCase = ((TaskType) obj).name().toLowerCase(Locale.ROOT);
            k.e(lowerCase, "toLowerCase(...)");
            linkedHashMap.put(lowerCase, obj);
        }
        WIRE_MAP = linkedHashMap;
    }

    private TaskType(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static TaskType valueOf(String str) {
        return (TaskType) Enum.valueOf(TaskType.class, str);
    }

    public static TaskType[] values() {
        return (TaskType[]) $VALUES.clone();
    }

    public final String getWire() {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
