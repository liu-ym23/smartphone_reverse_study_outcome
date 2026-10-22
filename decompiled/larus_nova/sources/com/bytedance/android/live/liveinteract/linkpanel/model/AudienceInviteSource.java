package com.bytedance.android.live.liveinteract.linkpanel.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/model/AudienceInviteSource;", "", "", "value", "I", "getValue", "()I", UserProfileEvent.POSITION_NONE, "ORIGIN", "GAME_PANNEL", "PUBLIC_AREA_COMMENT", "USER_SEARCH", "REALTIME_CHORUS", "JoinRealTimeChorus", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AudienceInviteSource extends Enum<AudienceInviteSource> {
    public static final AudienceInviteSource GAME_PANNEL = null;
    public static final AudienceInviteSource JoinRealTimeChorus = null;
    public static final AudienceInviteSource NONE = null;
    public static final AudienceInviteSource ORIGIN = null;
    public static final AudienceInviteSource PUBLIC_AREA_COMMENT = null;
    public static final AudienceInviteSource REALTIME_CHORUS = null;
    public static final AudienceInviteSource USER_SEARCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudienceInviteSource[] f74968a = null;
    private final int value;

    static {
        AudienceInviteSource r100 = new AudienceInviteSource(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        AudienceInviteSource r101 = new AudienceInviteSource("ORIGIN", 1, 1);
        ORIGIN = r101;
        AudienceInviteSource r102 = new AudienceInviteSource("GAME_PANNEL", 2, 2);
        GAME_PANNEL = r102;
        AudienceInviteSource r103 = new AudienceInviteSource("PUBLIC_AREA_COMMENT", 3, 3);
        PUBLIC_AREA_COMMENT = r103;
        AudienceInviteSource r104 = new AudienceInviteSource("USER_SEARCH", 4, 4);
        USER_SEARCH = r104;
        AudienceInviteSource r105 = new AudienceInviteSource("REALTIME_CHORUS", 5, 5);
        REALTIME_CHORUS = r105;
        AudienceInviteSource r106 = new AudienceInviteSource("JoinRealTimeChorus", 6, 6);
        JoinRealTimeChorus = r106;
        f74968a = new AudienceInviteSource[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static AudienceInviteSource valueOf(String r100) {
        return (AudienceInviteSource) r27.a.a(AudienceInviteSource.class, r100);
    }

    public static AudienceInviteSource[] values() {
        return (AudienceInviteSource[]) f74968a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AudienceInviteSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
