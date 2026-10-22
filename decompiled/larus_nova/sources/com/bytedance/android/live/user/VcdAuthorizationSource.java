package com.bytedance.android.live.user;

import com.bytedance.android.live.network.annotation.PbRequest;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/user/VcdAuthorizationSource;", "", "", "source", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "ROOM_CREATE", "LUCKY_BOX_SEND", "LUCKY_BOX_RUSH", "LINK_IN_ROOM", "LOTTERY_CREATE", "LOTTERY_PARTICIPATE", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VcdAuthorizationSource extends Enum<VcdAuthorizationSource> {
    public static final VcdAuthorizationSource LINK_IN_ROOM = null;
    public static final VcdAuthorizationSource LOTTERY_CREATE = null;
    public static final VcdAuthorizationSource LOTTERY_PARTICIPATE = null;
    public static final VcdAuthorizationSource LUCKY_BOX_RUSH = null;
    public static final VcdAuthorizationSource LUCKY_BOX_SEND = null;
    public static final VcdAuthorizationSource ROOM_CREATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VcdAuthorizationSource[] f102498a = null;
    private final String source;

    static {
        VcdAuthorizationSource r100 = new VcdAuthorizationSource("ROOM_CREATE", 0, "room_create");
        ROOM_CREATE = r100;
        VcdAuthorizationSource r101 = new VcdAuthorizationSource("LUCKY_BOX_SEND", 1, "lucky_box_send");
        LUCKY_BOX_SEND = r101;
        VcdAuthorizationSource r102 = new VcdAuthorizationSource("LUCKY_BOX_RUSH", 2, "lucky_box_rush");
        LUCKY_BOX_RUSH = r102;
        VcdAuthorizationSource r103 = new VcdAuthorizationSource("LINK_IN_ROOM", 3, PbRequest.SwitchType.LINKMIC_AUDIENCE);
        LINK_IN_ROOM = r103;
        VcdAuthorizationSource r104 = new VcdAuthorizationSource("LOTTERY_CREATE", 4, "lottery_create");
        LOTTERY_CREATE = r104;
        VcdAuthorizationSource r105 = new VcdAuthorizationSource("LOTTERY_PARTICIPATE", 5, "lottery_participate");
        LOTTERY_PARTICIPATE = r105;
        f102498a = new VcdAuthorizationSource[]{r100, r101, r102, r103, r104, r105};
    }

    public static VcdAuthorizationSource valueOf(String r100) {
        return (VcdAuthorizationSource) r27.a.a(VcdAuthorizationSource.class, r100);
    }

    public static VcdAuthorizationSource[] values() {
        return (VcdAuthorizationSource[]) f102498a.clone();
    }

    public final String getSource() {
        return this.source;
    }

    public VcdAuthorizationSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.source = r102;
    }
}
