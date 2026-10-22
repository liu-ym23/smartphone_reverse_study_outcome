package stepai.aios.guiagent.ability;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiagent/ability/CaptureScenario;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "MAIN_LOOP", "TAKEOVER", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CaptureScenario {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ CaptureScenario[] $VALUES;
    public static final CaptureScenario MAIN_LOOP = new CaptureScenario("MAIN_LOOP", 0);
    public static final CaptureScenario TAKEOVER = new CaptureScenario("TAKEOVER", 1);

    private static final /* synthetic */ CaptureScenario[] $values() {
        return new CaptureScenario[]{MAIN_LOOP, TAKEOVER};
    }

    static {
        CaptureScenario[] captureScenarioArr$values = $values();
        $VALUES = captureScenarioArr$values;
        $ENTRIES = kotlin.enums.a.a(captureScenarioArr$values);
    }

    private CaptureScenario(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static CaptureScenario valueOf(String str) {
        return (CaptureScenario) Enum.valueOf(CaptureScenario.class, str);
    }

    public static CaptureScenario[] values() {
        return (CaptureScenario[]) $VALUES.clone();
    }
}
