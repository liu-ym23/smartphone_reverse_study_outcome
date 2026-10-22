package kotlinx.coroutines.channels;

import com.stepos.core.ability.speech.TtsCloudConfig;
import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BufferOverflow {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ BufferOverflow[] $VALUES;
    public static final BufferOverflow SUSPEND = new BufferOverflow(TtsCloudConfig.DEFAULT_STREAM_BACKPRESSURE_MODE, 0);
    public static final BufferOverflow DROP_OLDEST = new BufferOverflow("DROP_OLDEST", 1);
    public static final BufferOverflow DROP_LATEST = new BufferOverflow("DROP_LATEST", 2);

    private static final /* synthetic */ BufferOverflow[] $values() {
        return new BufferOverflow[]{SUSPEND, DROP_OLDEST, DROP_LATEST};
    }

    static {
        BufferOverflow[] bufferOverflowArr$values = $values();
        $VALUES = bufferOverflowArr$values;
        $ENTRIES = kotlin.enums.a.a(bufferOverflowArr$values);
    }

    private BufferOverflow(String str, int i10) {
    }

    public static BufferOverflow valueOf(String str) {
        return (BufferOverflow) Enum.valueOf(BufferOverflow.class, str);
    }

    public static BufferOverflow[] values() {
        return (BufferOverflow[]) $VALUES.clone();
    }
}
