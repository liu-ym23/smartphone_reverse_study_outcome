package stepai.aios.guiexecutor.api;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lstepai/aios/guiexecutor/api/TargetType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "COORDINATE", "ELEMENT", "SCREEN", "BOUNDS", "CURRENT_FOCUS", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TargetType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ TargetType[] $VALUES;
    public static final TargetType COORDINATE = new TargetType("COORDINATE", 0);
    public static final TargetType ELEMENT = new TargetType("ELEMENT", 1);
    public static final TargetType SCREEN = new TargetType("SCREEN", 2);
    public static final TargetType BOUNDS = new TargetType("BOUNDS", 3);
    public static final TargetType CURRENT_FOCUS = new TargetType("CURRENT_FOCUS", 4);

    private static final /* synthetic */ TargetType[] $values() {
        return new TargetType[]{COORDINATE, ELEMENT, SCREEN, BOUNDS, CURRENT_FOCUS};
    }

    static {
        TargetType[] targetTypeArr$values = $values();
        $VALUES = targetTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(targetTypeArr$values);
    }

    private TargetType(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static TargetType valueOf(String str) {
        return (TargetType) Enum.valueOf(TargetType.class, str);
    }

    public static TargetType[] values() {
        return (TargetType[]) $VALUES.clone();
    }
}
