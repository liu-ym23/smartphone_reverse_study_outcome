package com.bytedance.android.live.revlink.impl.multianchor;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/AnchorLinkInitType;", "", UserProfileEvent.POSITION_NONE, "PK_SWITCH_LINK", "LINK_SWITCH_CHANNEL", "REPLY_AGREE_API", "REPLY_AGREE_MSG", "PERMIT_AGREE_MSG", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AnchorLinkInitType extends Enum<AnchorLinkInitType> {
    public static final AnchorLinkInitType LINK_SWITCH_CHANNEL = null;
    public static final AnchorLinkInitType NONE = null;
    public static final AnchorLinkInitType PERMIT_AGREE_MSG = null;
    public static final AnchorLinkInitType PK_SWITCH_LINK = null;
    public static final AnchorLinkInitType REPLY_AGREE_API = null;
    public static final AnchorLinkInitType REPLY_AGREE_MSG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnchorLinkInitType[] f93067a = null;

    static {
        AnchorLinkInitType r100 = new AnchorLinkInitType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        AnchorLinkInitType r101 = new AnchorLinkInitType("PK_SWITCH_LINK", 1);
        PK_SWITCH_LINK = r101;
        AnchorLinkInitType r102 = new AnchorLinkInitType("LINK_SWITCH_CHANNEL", 2);
        LINK_SWITCH_CHANNEL = r102;
        AnchorLinkInitType r103 = new AnchorLinkInitType("REPLY_AGREE_API", 3);
        REPLY_AGREE_API = r103;
        AnchorLinkInitType r104 = new AnchorLinkInitType("REPLY_AGREE_MSG", 4);
        REPLY_AGREE_MSG = r104;
        AnchorLinkInitType r105 = new AnchorLinkInitType("PERMIT_AGREE_MSG", 5);
        PERMIT_AGREE_MSG = r105;
        f93067a = new AnchorLinkInitType[]{r100, r101, r102, r103, r104, r105};
    }

    public static AnchorLinkInitType valueOf(String r100) {
        return (AnchorLinkInitType) a.a(AnchorLinkInitType.class, r100);
    }

    public static AnchorLinkInitType[] values() {
        return (AnchorLinkInitType[]) f93067a.clone();
    }

    public AnchorLinkInitType(String r100, int r101) {
        super(r100, r101);
    }
}
