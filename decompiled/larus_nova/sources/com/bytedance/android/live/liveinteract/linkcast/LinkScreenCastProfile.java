package com.bytedance.android.live.liveinteract.linkcast;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkcast/LinkScreenCastProfile;", "", "SCREEN_CAST_PROFILE_UNKNOWN", "SCREEN_CAST_PROFILE_15FPS", "SCREEN_CAST_PROFILE_30FPS", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkScreenCastProfile extends Enum<LinkScreenCastProfile> {
    public static final LinkScreenCastProfile SCREEN_CAST_PROFILE_15FPS = null;
    public static final LinkScreenCastProfile SCREEN_CAST_PROFILE_30FPS = null;
    public static final LinkScreenCastProfile SCREEN_CAST_PROFILE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkScreenCastProfile[] f74317a = null;

    static {
        LinkScreenCastProfile r100 = new LinkScreenCastProfile("SCREEN_CAST_PROFILE_UNKNOWN", 0);
        SCREEN_CAST_PROFILE_UNKNOWN = r100;
        LinkScreenCastProfile r101 = new LinkScreenCastProfile("SCREEN_CAST_PROFILE_15FPS", 1);
        SCREEN_CAST_PROFILE_15FPS = r101;
        LinkScreenCastProfile r102 = new LinkScreenCastProfile("SCREEN_CAST_PROFILE_30FPS", 2);
        SCREEN_CAST_PROFILE_30FPS = r102;
        f74317a = new LinkScreenCastProfile[]{r100, r101, r102};
    }

    public static LinkScreenCastProfile valueOf(String r100) {
        return (LinkScreenCastProfile) r27.a.a(LinkScreenCastProfile.class, r100);
    }

    public static LinkScreenCastProfile[] values() {
        return (LinkScreenCastProfile[]) f74317a.clone();
    }

    public LinkScreenCastProfile(String r100, int r101) {
        super(r100, r101);
    }
}
