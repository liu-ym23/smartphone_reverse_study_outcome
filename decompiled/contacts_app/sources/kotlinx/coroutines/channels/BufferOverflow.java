package kotlinx.coroutines.channels;

import kotlin.Metadata;

/* JADX INFO: compiled from: BufferOverflow.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/channels/BufferOverflow;", "", "(Ljava/lang/String;I)V", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum BufferOverflow extends Enum<BufferOverflow> {
    private static final /* synthetic */ BufferOverflow[] $VALUES = null;
    public static final BufferOverflow DROP_LATEST = null;
    public static final BufferOverflow DROP_OLDEST = null;
    public static final BufferOverflow SUSPEND = null;

    private static final /* synthetic */ BufferOverflow[] $values() {
        return new BufferOverflow[]{SUSPEND, DROP_OLDEST, DROP_LATEST};
    }

    public static BufferOverflow valueOf(String r1) {
        return (BufferOverflow) Enum.valueOf(BufferOverflow.class, r1);
    }

    public static BufferOverflow[] values() {
        return (BufferOverflow[]) $VALUES.clone();
    }

    private BufferOverflow(String r1, int r2) {
        super(r1, r2);
    }

    static {
        SUSPEND = new BufferOverflow("SUSPEND", 0);
        DROP_OLDEST = new BufferOverflow("DROP_OLDEST", 1);
        DROP_LATEST = new BufferOverflow("DROP_LATEST", 2);
        $VALUES = $values();
    }
}
