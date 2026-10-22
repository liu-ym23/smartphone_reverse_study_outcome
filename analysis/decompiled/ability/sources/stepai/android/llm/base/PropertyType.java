package stepai.android.llm.base;

import K7.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lstepai/android/llm/base/PropertyType;", "", "value", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "STRING", "NUMBER", "INTEGER", "BOOLEAN", "ARRAY", "OBJECT", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PropertyType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ PropertyType[] $VALUES;
    private final String value;
    public static final PropertyType STRING = new PropertyType("STRING", 0, TypedValues.Custom.S_STRING);
    public static final PropertyType NUMBER = new PropertyType("NUMBER", 1, "number");
    public static final PropertyType INTEGER = new PropertyType("INTEGER", 2, TypedValues.Custom.S_INT);
    public static final PropertyType BOOLEAN = new PropertyType("BOOLEAN", 3, TypedValues.Custom.S_BOOLEAN);
    public static final PropertyType ARRAY = new PropertyType("ARRAY", 4, "array");
    public static final PropertyType OBJECT = new PropertyType("OBJECT", 5, "object");

    private static final /* synthetic */ PropertyType[] $values() {
        return new PropertyType[]{STRING, NUMBER, INTEGER, BOOLEAN, ARRAY, OBJECT};
    }

    static {
        PropertyType[] propertyTypeArr$values = $values();
        $VALUES = propertyTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(propertyTypeArr$values);
    }

    private PropertyType(String str, int i, String str2) {
        this.value = str2;
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static PropertyType valueOf(String str) {
        return (PropertyType) Enum.valueOf(PropertyType.class, str);
    }

    public static PropertyType[] values() {
        return (PropertyType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
