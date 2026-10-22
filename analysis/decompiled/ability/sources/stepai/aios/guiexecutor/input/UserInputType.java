package stepai.aios.guiexecutor.input;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lstepai/aios/guiexecutor/input/UserInputType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "TEXT", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserInputType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ UserInputType[] $VALUES;
    public static final UserInputType TEXT = new UserInputType("TEXT", 0);

    private static final /* synthetic */ UserInputType[] $values() {
        return new UserInputType[]{TEXT};
    }

    static {
        UserInputType[] userInputTypeArr$values = $values();
        $VALUES = userInputTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(userInputTypeArr$values);
    }

    private UserInputType(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static UserInputType valueOf(String str) {
        return (UserInputType) Enum.valueOf(UserInputType.class, str);
    }

    public static UserInputType[] values() {
        return (UserInputType[]) $VALUES.clone();
    }
}
