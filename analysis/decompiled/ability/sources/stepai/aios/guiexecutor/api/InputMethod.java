package stepai.aios.guiexecutor.api;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lstepai/aios/guiexecutor/api/InputMethod;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "ACCESSIBILITY", "IME", "CLIPBOARD", "DIRECT", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InputMethod {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ InputMethod[] $VALUES;
    public static final InputMethod ACCESSIBILITY = new InputMethod("ACCESSIBILITY", 0);
    public static final InputMethod IME = new InputMethod("IME", 1);
    public static final InputMethod CLIPBOARD = new InputMethod("CLIPBOARD", 2);
    public static final InputMethod DIRECT = new InputMethod("DIRECT", 3);

    private static final /* synthetic */ InputMethod[] $values() {
        return new InputMethod[]{ACCESSIBILITY, IME, CLIPBOARD, DIRECT};
    }

    static {
        InputMethod[] inputMethodArr$values = $values();
        $VALUES = inputMethodArr$values;
        $ENTRIES = kotlin.enums.a.a(inputMethodArr$values);
    }

    private InputMethod(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static InputMethod valueOf(String str) {
        return (InputMethod) Enum.valueOf(InputMethod.class, str);
    }

    public static InputMethod[] values() {
        return (InputMethod[]) $VALUES.clone();
    }
}
