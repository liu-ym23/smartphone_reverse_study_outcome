package stepai.aios.guiexecutor.api;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lstepai/aios/guiexecutor/api/GestureType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "SWIPE", "PINCH", "ROTATE", "DRAG", "FLING", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GestureType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ GestureType[] $VALUES;
    public static final GestureType SWIPE = new GestureType("SWIPE", 0);
    public static final GestureType PINCH = new GestureType("PINCH", 1);
    public static final GestureType ROTATE = new GestureType("ROTATE", 2);
    public static final GestureType DRAG = new GestureType("DRAG", 3);
    public static final GestureType FLING = new GestureType("FLING", 4);

    private static final /* synthetic */ GestureType[] $values() {
        return new GestureType[]{SWIPE, PINCH, ROTATE, DRAG, FLING};
    }

    static {
        GestureType[] gestureTypeArr$values = $values();
        $VALUES = gestureTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(gestureTypeArr$values);
    }

    private GestureType(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static GestureType valueOf(String str) {
        return (GestureType) Enum.valueOf(GestureType.class, str);
    }

    public static GestureType[] values() {
        return (GestureType[]) $VALUES.clone();
    }
}
