package com.bytedance.android.livesdkapi.depend.model.live.linker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/InviteType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CROSS_ROOM_LINK", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum InviteType extends Enum<InviteType> {
    private static final /* synthetic */ InviteType[] $VALUES = null;
    public static final InviteType CROSS_ROOM_LINK = null;
    public static final Companion Companion = null;
    public static final InviteType UNKNOWN = null;
    private final int value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/InviteType$Companion;", "", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        InviteType r100 = new InviteType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        InviteType r101 = new InviteType("CROSS_ROOM_LINK", 1, 1);
        CROSS_ROOM_LINK = r101;
        $VALUES = new InviteType[]{r100, r101};
        Companion = new Companion(null);
    }

    public static InviteType valueOf(String r100) {
        return (InviteType) a.a(InviteType.class, r100);
    }

    public static InviteType[] values() {
        return (InviteType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private InviteType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
