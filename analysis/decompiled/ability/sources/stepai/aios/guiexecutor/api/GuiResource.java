package stepai.aios.guiexecutor.api;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiResource;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "UI", "INPUT", "SCREENSHOT", "APP_SWITCH", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuiResource {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ GuiResource[] $VALUES;
    public static final GuiResource UI = new GuiResource("UI", 0);
    public static final GuiResource INPUT = new GuiResource("INPUT", 1);
    public static final GuiResource SCREENSHOT = new GuiResource("SCREENSHOT", 2);
    public static final GuiResource APP_SWITCH = new GuiResource("APP_SWITCH", 3);

    private static final /* synthetic */ GuiResource[] $values() {
        return new GuiResource[]{UI, INPUT, SCREENSHOT, APP_SWITCH};
    }

    static {
        GuiResource[] guiResourceArr$values = $values();
        $VALUES = guiResourceArr$values;
        $ENTRIES = kotlin.enums.a.a(guiResourceArr$values);
    }

    private GuiResource(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static GuiResource valueOf(String str) {
        return (GuiResource) Enum.valueOf(GuiResource.class, str);
    }

    public static GuiResource[] values() {
        return (GuiResource[]) $VALUES.clone();
    }
}
