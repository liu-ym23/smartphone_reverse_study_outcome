package stepai.aios.guiexecutor.api;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiFeature;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "ACCESSIBILITY_SERVICE", "ROOT_ACCESS", "GESTURE_RECORDING", "ELEMENT_INSPECTION", "SCREENSHOT_CAPTURE", "COORDINATE_MAPPING", "MULTI_TOUCH", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuiFeature {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ GuiFeature[] $VALUES;
    public static final GuiFeature ACCESSIBILITY_SERVICE = new GuiFeature("ACCESSIBILITY_SERVICE", 0);
    public static final GuiFeature ROOT_ACCESS = new GuiFeature("ROOT_ACCESS", 1);
    public static final GuiFeature GESTURE_RECORDING = new GuiFeature("GESTURE_RECORDING", 2);
    public static final GuiFeature ELEMENT_INSPECTION = new GuiFeature("ELEMENT_INSPECTION", 3);
    public static final GuiFeature SCREENSHOT_CAPTURE = new GuiFeature("SCREENSHOT_CAPTURE", 4);
    public static final GuiFeature COORDINATE_MAPPING = new GuiFeature("COORDINATE_MAPPING", 5);
    public static final GuiFeature MULTI_TOUCH = new GuiFeature("MULTI_TOUCH", 6);

    private static final /* synthetic */ GuiFeature[] $values() {
        return new GuiFeature[]{ACCESSIBILITY_SERVICE, ROOT_ACCESS, GESTURE_RECORDING, ELEMENT_INSPECTION, SCREENSHOT_CAPTURE, COORDINATE_MAPPING, MULTI_TOUCH};
    }

    static {
        GuiFeature[] guiFeatureArr$values = $values();
        $VALUES = guiFeatureArr$values;
        $ENTRIES = kotlin.enums.a.a(guiFeatureArr$values);
    }

    private GuiFeature(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static GuiFeature valueOf(String str) {
        return (GuiFeature) Enum.valueOf(GuiFeature.class, str);
    }

    public static GuiFeature[] values() {
        return (GuiFeature[]) $VALUES.clone();
    }
}
