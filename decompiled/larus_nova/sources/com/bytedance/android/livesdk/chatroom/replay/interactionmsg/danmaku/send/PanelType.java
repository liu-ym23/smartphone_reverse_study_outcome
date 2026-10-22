package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/PanelType;", "", UserProfileEvent.POSITION_NONE, "KEYBOARD", "EMOJI", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelType extends Enum<PanelType> {
    public static final PanelType EMOJI = null;
    public static final PanelType KEYBOARD = null;
    public static final PanelType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelType[] f109074a = null;

    static {
        PanelType r100 = new PanelType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        PanelType r101 = new PanelType("KEYBOARD", 1);
        KEYBOARD = r101;
        PanelType r102 = new PanelType("EMOJI", 2);
        EMOJI = r102;
        f109074a = new PanelType[]{r100, r101, r102};
    }

    public static PanelType valueOf(String r100) {
        return (PanelType) a.a(PanelType.class, r100);
    }

    public static PanelType[] values() {
        return (PanelType[]) f109074a.clone();
    }

    public PanelType(String r100, int r101) {
        super(r100, r101);
    }
}
