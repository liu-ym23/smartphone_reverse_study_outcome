package com.bytedance.android.live.revlink.impl.pk.service;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/service/ToolBarPic;", "", UserProfileEvent.POSITION_NONE, "PK_CLOSE_BROADCAST_OLD", "PK_CLOSE_BROADCAST", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ToolBarPic extends Enum<ToolBarPic> {
    public static final ToolBarPic NONE = null;
    public static final ToolBarPic PK_CLOSE_BROADCAST = null;
    public static final ToolBarPic PK_CLOSE_BROADCAST_OLD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolBarPic[] f96857a = null;

    static {
        ToolBarPic r100 = new ToolBarPic(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ToolBarPic r101 = new ToolBarPic("PK_CLOSE_BROADCAST_OLD", 1);
        PK_CLOSE_BROADCAST_OLD = r101;
        ToolBarPic r102 = new ToolBarPic("PK_CLOSE_BROADCAST", 2);
        PK_CLOSE_BROADCAST = r102;
        f96857a = new ToolBarPic[]{r100, r101, r102};
    }

    public static ToolBarPic valueOf(String r100) {
        return (ToolBarPic) r27.a.a(ToolBarPic.class, r100);
    }

    public static ToolBarPic[] values() {
        return (ToolBarPic[]) f96857a.clone();
    }

    public ToolBarPic(String r100, int r101) {
        super(r100, r101);
    }
}
