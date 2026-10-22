package stepai.aios.guiexecutor.api;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lstepai/aios/guiexecutor/api/ScrollDirection;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "UP", "DOWN", "LEFT", "RIGHT", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ScrollDirection {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ScrollDirection[] $VALUES;
    public static final ScrollDirection UP = new ScrollDirection("UP", 0);
    public static final ScrollDirection DOWN = new ScrollDirection("DOWN", 1);
    public static final ScrollDirection LEFT = new ScrollDirection("LEFT", 2);
    public static final ScrollDirection RIGHT = new ScrollDirection("RIGHT", 3);

    private static final /* synthetic */ ScrollDirection[] $values() {
        return new ScrollDirection[]{UP, DOWN, LEFT, RIGHT};
    }

    static {
        ScrollDirection[] scrollDirectionArr$values = $values();
        $VALUES = scrollDirectionArr$values;
        $ENTRIES = kotlin.enums.a.a(scrollDirectionArr$values);
    }

    private ScrollDirection(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static ScrollDirection valueOf(String str) {
        return (ScrollDirection) Enum.valueOf(ScrollDirection.class, str);
    }

    public static ScrollDirection[] values() {
        return (ScrollDirection[]) $VALUES.clone();
    }
}
