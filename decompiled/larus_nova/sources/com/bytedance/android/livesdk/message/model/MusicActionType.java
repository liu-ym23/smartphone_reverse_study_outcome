package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/MusicActionType;", "", UserProfileEvent.POSITION_NONE, "RESUME", "PAUSE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MusicActionType extends Enum<MusicActionType> {
    public static final MusicActionType NONE = null;
    public static final MusicActionType PAUSE = null;
    public static final MusicActionType RESUME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MusicActionType[] f153576a = null;

    static {
        MusicActionType r100 = new MusicActionType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        MusicActionType r101 = new MusicActionType("RESUME", 1);
        RESUME = r101;
        MusicActionType r102 = new MusicActionType("PAUSE", 2);
        PAUSE = r102;
        f153576a = new MusicActionType[]{r100, r101, r102};
    }

    public static MusicActionType valueOf(String r100) {
        return (MusicActionType) r27.a.a(MusicActionType.class, r100);
    }

    public static MusicActionType[] values() {
        return (MusicActionType[]) f153576a.clone();
    }

    public MusicActionType(String r100, int r101) {
        super(r100, r101);
    }
}
