package kotlinx.coroutines.flow;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", "", "(Ljava/lang/String;I)V", "START", "STOP", "STOP_AND_RESET_REPLAY_CACHE", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum SharingCommand extends Enum<SharingCommand> {
    private static final /* synthetic */ SharingCommand[] $VALUES = null;
    public static final SharingCommand START = null;
    public static final SharingCommand STOP = null;
    public static final SharingCommand STOP_AND_RESET_REPLAY_CACHE = null;

    private static final /* synthetic */ SharingCommand[] $values() {
        return new SharingCommand[]{START, STOP, STOP_AND_RESET_REPLAY_CACHE};
    }

    static {
        START = new SharingCommand("START", 0);
        STOP = new SharingCommand("STOP", 1);
        STOP_AND_RESET_REPLAY_CACHE = new SharingCommand("STOP_AND_RESET_REPLAY_CACHE", 2);
        $VALUES = $values();
    }

    private SharingCommand(String r10, int r11) {
        super(r10, r11);
    }

    public static SharingCommand valueOf(String r10) {
        return (SharingCommand) Enum.valueOf(SharingCommand.class, r10);
    }

    public static SharingCommand[] values() {
        return (SharingCommand[]) $VALUES.clone();
    }
}
