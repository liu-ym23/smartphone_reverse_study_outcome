package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import wy.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/RoomBattleMatchEntranceStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CLOSE", "RESERVATION", "MATCHING", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RoomBattleMatchEntranceStatus extends Enum<RoomBattleMatchEntranceStatus> {
    private static final /* synthetic */ RoomBattleMatchEntranceStatus[] $VALUES = null;
    public static final RoomBattleMatchEntranceStatus CLOSE = null;
    public static final Companion Companion = null;
    public static final RoomBattleMatchEntranceStatus MATCHING = null;
    public static final RoomBattleMatchEntranceStatus RESERVATION = null;
    public static final RoomBattleMatchEntranceStatus UNKNOWN = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/RoomBattleMatchEntranceStatus$Companion;", "", "()V", "fromValue", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/RoomBattleMatchEntranceStatus;", "value", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final RoomBattleMatchEntranceStatus fromValue(int r100) {
            RoomBattleMatchEntranceStatus[] r101 = RoomBattleMatchEntranceStatus.values();
            int r102 = r101.length;
            int r103 = 0;
        L4:
            if (r103 >= r102) goto L12;
            RoomBattleMatchEntranceStatus r104 = r101[r103];
            if (r100 != r104.getValue()) goto L8;
            boolean r105 = true;
        L9:
            if (r105 == true) goto L13;
            r103 = r103 + 1;
        L13:
            if (r104 != null) goto L18;
            LocalTestManager.a(new Class[]{a.class});
            return RoomBattleMatchEntranceStatus.UNKNOWN;
        L18:
            return r104;
        L8:
            r105 = false;
            goto L9
        L12:
            r104 = null;
            goto L13
        }
    }

    static {
        RoomBattleMatchEntranceStatus r100 = new RoomBattleMatchEntranceStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        RoomBattleMatchEntranceStatus r101 = new RoomBattleMatchEntranceStatus("CLOSE", 1, 1);
        CLOSE = r101;
        RoomBattleMatchEntranceStatus r102 = new RoomBattleMatchEntranceStatus("RESERVATION", 2, 2);
        RESERVATION = r102;
        RoomBattleMatchEntranceStatus r103 = new RoomBattleMatchEntranceStatus("MATCHING", 3, 3);
        MATCHING = r103;
        $VALUES = new RoomBattleMatchEntranceStatus[]{r100, r101, r102, r103};
        Companion = new Companion(null);
    }

    public static RoomBattleMatchEntranceStatus valueOf(String r100) {
        return (RoomBattleMatchEntranceStatus) r27.a.a(RoomBattleMatchEntranceStatus.class, r100);
    }

    public static RoomBattleMatchEntranceStatus[] values() {
        return (RoomBattleMatchEntranceStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private RoomBattleMatchEntranceStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
