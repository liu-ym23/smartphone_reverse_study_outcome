package stepai.android.llm.base;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lstepai/android/llm/base/ParameterType;", "", "value", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OBJECT", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ParameterType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ParameterType[] $VALUES;
    public static final ParameterType OBJECT = new ParameterType("OBJECT", 0, "object");
    private final String value;

    private static final /* synthetic */ ParameterType[] $values() {
        return new ParameterType[]{OBJECT};
    }

    static {
        ParameterType[] parameterTypeArr$values = $values();
        $VALUES = parameterTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(parameterTypeArr$values);
    }

    private ParameterType(String str, int i, String str2) {
        this.value = str2;
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static ParameterType valueOf(String str) {
        return (ParameterType) Enum.valueOf(ParameterType.class, str);
    }

    public static ParameterType[] values() {
        return (ParameterType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
