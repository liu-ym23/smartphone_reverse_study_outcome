package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/PlayModeUpdateType;", "", UserProfileEvent.POSITION_NONE, "ADD_PLAYMODE", "REMOVE_PLAYMODE", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PlayModeUpdateType extends Enum<PlayModeUpdateType> {
    public static final PlayModeUpdateType ADD_PLAYMODE = null;
    public static final PlayModeUpdateType NONE = null;
    public static final PlayModeUpdateType REMOVE_PLAYMODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayModeUpdateType[] f77077a = null;

    static {
        PlayModeUpdateType r100 = new PlayModeUpdateType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        PlayModeUpdateType r101 = new PlayModeUpdateType("ADD_PLAYMODE", 1);
        ADD_PLAYMODE = r101;
        PlayModeUpdateType r102 = new PlayModeUpdateType("REMOVE_PLAYMODE", 2);
        REMOVE_PLAYMODE = r102;
        f77077a = new PlayModeUpdateType[]{r100, r101, r102};
    }

    public static PlayModeUpdateType valueOf(String r100) {
        return (PlayModeUpdateType) a.a(PlayModeUpdateType.class, r100);
    }

    public static PlayModeUpdateType[] values() {
        return (PlayModeUpdateType[]) f77077a.clone();
    }

    public PlayModeUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
