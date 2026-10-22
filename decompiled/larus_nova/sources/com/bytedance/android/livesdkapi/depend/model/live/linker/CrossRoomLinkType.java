package com.bytedance.android.livesdkapi.depend.model.live.linker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/CrossRoomLinkType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "TWO_ROOM", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CrossRoomLinkType extends Enum<CrossRoomLinkType> {
    private static final /* synthetic */ CrossRoomLinkType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final CrossRoomLinkType TWO_ROOM = null;
    public static final CrossRoomLinkType UNKNOWN = null;
    private final int value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/CrossRoomLinkType$Companion;", "", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        CrossRoomLinkType r100 = new CrossRoomLinkType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        CrossRoomLinkType r101 = new CrossRoomLinkType("TWO_ROOM", 1, 1);
        TWO_ROOM = r101;
        $VALUES = new CrossRoomLinkType[]{r100, r101};
        Companion = new Companion(null);
    }

    public static CrossRoomLinkType valueOf(String r100) {
        return (CrossRoomLinkType) a.a(CrossRoomLinkType.class, r100);
    }

    public static CrossRoomLinkType[] values() {
        return (CrossRoomLinkType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private CrossRoomLinkType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
