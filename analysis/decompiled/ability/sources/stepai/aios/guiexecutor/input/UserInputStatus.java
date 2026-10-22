package stepai.aios.guiexecutor.input;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lstepai/aios/guiexecutor/input/UserInputStatus;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "SUCCESS", "TIMEOUT", "CANCELLED", "ERROR", "VALIDATION_FAILED", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserInputStatus {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ UserInputStatus[] $VALUES;
    public static final UserInputStatus SUCCESS = new UserInputStatus("SUCCESS", 0);
    public static final UserInputStatus TIMEOUT = new UserInputStatus("TIMEOUT", 1);
    public static final UserInputStatus CANCELLED = new UserInputStatus("CANCELLED", 2);
    public static final UserInputStatus ERROR = new UserInputStatus("ERROR", 3);
    public static final UserInputStatus VALIDATION_FAILED = new UserInputStatus("VALIDATION_FAILED", 4);

    private static final /* synthetic */ UserInputStatus[] $values() {
        return new UserInputStatus[]{SUCCESS, TIMEOUT, CANCELLED, ERROR, VALIDATION_FAILED};
    }

    static {
        UserInputStatus[] userInputStatusArr$values = $values();
        $VALUES = userInputStatusArr$values;
        $ENTRIES = kotlin.enums.a.a(userInputStatusArr$values);
    }

    private UserInputStatus(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static UserInputStatus valueOf(String str) {
        return (UserInputStatus) Enum.valueOf(UserInputStatus.class, str);
    }

    public static UserInputStatus[] values() {
        return (UserInputStatus[]) $VALUES.clone();
    }
}
