package com.bytedance.android.live.profile.p004enum;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profile/enum/ProfileMode;", "", "NEVER", UserProfileEvent.POSITION_NONE, "USER_BEFORE", "USER_CURRENT", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ProfileMode extends Enum<ProfileMode> {
    public static final ProfileMode NEVER = null;
    public static final ProfileMode NONE = null;
    public static final ProfileMode USER_BEFORE = null;
    public static final ProfileMode USER_CURRENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProfileMode[] f86017a = null;

    static {
        ProfileMode r100 = new ProfileMode("NEVER", 0);
        NEVER = r100;
        ProfileMode r101 = new ProfileMode(UserProfileEvent.POSITION_NONE, 1);
        NONE = r101;
        ProfileMode r102 = new ProfileMode("USER_BEFORE", 2);
        USER_BEFORE = r102;
        ProfileMode r103 = new ProfileMode("USER_CURRENT", 3);
        USER_CURRENT = r103;
        f86017a = new ProfileMode[]{r100, r101, r102, r103};
    }

    public static ProfileMode valueOf(String r100) {
        return (ProfileMode) a.a(ProfileMode.class, r100);
    }

    public static ProfileMode[] values() {
        return (ProfileMode[]) f86017a.clone();
    }

    public ProfileMode(String r100, int r101) {
        super(r100, r101);
    }
}
