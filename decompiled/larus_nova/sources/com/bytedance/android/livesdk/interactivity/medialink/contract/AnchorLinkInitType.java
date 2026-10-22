package com.bytedance.android.livesdk.interactivity.medialink.contract;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/contract/AnchorLinkInitType;", "", UserProfileEvent.POSITION_NONE, "REPLY_AGREE_API", "REPLY_AGREE_MSG", "LINK_SWITCH_CHANNEL", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnchorLinkInitType extends Enum<AnchorLinkInitType> {
    public static final AnchorLinkInitType LINK_SWITCH_CHANNEL = null;
    public static final AnchorLinkInitType NONE = null;
    public static final AnchorLinkInitType REPLY_AGREE_API = null;
    public static final AnchorLinkInitType REPLY_AGREE_MSG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnchorLinkInitType[] f137982a = null;

    static {
        AnchorLinkInitType r100 = new AnchorLinkInitType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        AnchorLinkInitType r101 = new AnchorLinkInitType("REPLY_AGREE_API", 1);
        REPLY_AGREE_API = r101;
        AnchorLinkInitType r102 = new AnchorLinkInitType("REPLY_AGREE_MSG", 2);
        REPLY_AGREE_MSG = r102;
        AnchorLinkInitType r103 = new AnchorLinkInitType("LINK_SWITCH_CHANNEL", 3);
        LINK_SWITCH_CHANNEL = r103;
        f137982a = new AnchorLinkInitType[]{r100, r101, r102, r103};
    }

    public static AnchorLinkInitType valueOf(String r100) {
        return (AnchorLinkInitType) r27.a.a(AnchorLinkInitType.class, r100);
    }

    public static AnchorLinkInitType[] values() {
        return (AnchorLinkInitType[]) f137982a.clone();
    }

    public AnchorLinkInitType(String r100, int r101) {
        super(r100, r101);
    }
}
