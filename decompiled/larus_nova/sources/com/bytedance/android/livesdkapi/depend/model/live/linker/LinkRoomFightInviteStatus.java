package com.bytedance.android.livesdkapi.depend.model.live.linker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightInviteStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ACCEPTABLE", "INVITING", "MATCHING", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkRoomFightInviteStatus extends Enum<LinkRoomFightInviteStatus> {
    private static final /* synthetic */ LinkRoomFightInviteStatus[] $VALUES = null;
    public static final LinkRoomFightInviteStatus ACCEPTABLE = null;
    public static final Companion Companion = null;
    public static final LinkRoomFightInviteStatus INVITING = null;
    public static final LinkRoomFightInviteStatus MATCHING = null;
    public static final LinkRoomFightInviteStatus UNKNOWN = null;
    private final int value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightInviteStatus$Companion;", "", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        LinkRoomFightInviteStatus r100 = new LinkRoomFightInviteStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        LinkRoomFightInviteStatus r101 = new LinkRoomFightInviteStatus("ACCEPTABLE", 1, 1);
        ACCEPTABLE = r101;
        LinkRoomFightInviteStatus r102 = new LinkRoomFightInviteStatus("INVITING", 2, 2);
        INVITING = r102;
        LinkRoomFightInviteStatus r103 = new LinkRoomFightInviteStatus("MATCHING", 3, 3);
        MATCHING = r103;
        $VALUES = new LinkRoomFightInviteStatus[]{r100, r101, r102, r103};
        Companion = new Companion(null);
    }

    public static LinkRoomFightInviteStatus valueOf(String r100) {
        return (LinkRoomFightInviteStatus) a.a(LinkRoomFightInviteStatus.class, r100);
    }

    public static LinkRoomFightInviteStatus[] values() {
        return (LinkRoomFightInviteStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private LinkRoomFightInviteStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
