package stepai.android.llm.base.twoway;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lstepai/android/llm/base/twoway/TwoWayServiceType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "ASR", "TTS", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TwoWayServiceType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ TwoWayServiceType[] $VALUES;
    public static final TwoWayServiceType ASR = new TwoWayServiceType("ASR", 0);
    public static final TwoWayServiceType TTS = new TwoWayServiceType("TTS", 1);

    private static final /* synthetic */ TwoWayServiceType[] $values() {
        return new TwoWayServiceType[]{ASR, TTS};
    }

    static {
        TwoWayServiceType[] twoWayServiceTypeArr$values = $values();
        $VALUES = twoWayServiceTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(twoWayServiceTypeArr$values);
    }

    private TwoWayServiceType(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static TwoWayServiceType valueOf(String str) {
        return (TwoWayServiceType) Enum.valueOf(TwoWayServiceType.class, str);
    }

    public static TwoWayServiceType[] values() {
        return (TwoWayServiceType[]) $VALUES.clone();
    }
}
