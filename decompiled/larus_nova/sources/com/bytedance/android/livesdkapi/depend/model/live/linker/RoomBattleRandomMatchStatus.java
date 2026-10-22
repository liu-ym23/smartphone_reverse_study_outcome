package com.bytedance.android.livesdkapi.depend.model.live.linker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/RoomBattleRandomMatchStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "FIRST", "NO_EXPECTED_TIME_LEFT", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RoomBattleRandomMatchStatus extends Enum<RoomBattleRandomMatchStatus> {
    private static final /* synthetic */ RoomBattleRandomMatchStatus[] $VALUES = null;
    public static final Companion Companion = null;
    public static final RoomBattleRandomMatchStatus FIRST = null;
    public static final RoomBattleRandomMatchStatus NO_EXPECTED_TIME_LEFT = null;
    public static final RoomBattleRandomMatchStatus UNKNOWN = null;
    private final int value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/RoomBattleRandomMatchStatus$Companion;", "", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        RoomBattleRandomMatchStatus r100 = new RoomBattleRandomMatchStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        RoomBattleRandomMatchStatus r101 = new RoomBattleRandomMatchStatus("FIRST", 1, 1);
        FIRST = r101;
        RoomBattleRandomMatchStatus r102 = new RoomBattleRandomMatchStatus("NO_EXPECTED_TIME_LEFT", 2, 2);
        NO_EXPECTED_TIME_LEFT = r102;
        $VALUES = new RoomBattleRandomMatchStatus[]{r100, r101, r102};
        Companion = new Companion(null);
    }

    public static RoomBattleRandomMatchStatus valueOf(String r100) {
        return (RoomBattleRandomMatchStatus) a.a(RoomBattleRandomMatchStatus.class, r100);
    }

    public static RoomBattleRandomMatchStatus[] values() {
        return (RoomBattleRandomMatchStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private RoomBattleRandomMatchStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
