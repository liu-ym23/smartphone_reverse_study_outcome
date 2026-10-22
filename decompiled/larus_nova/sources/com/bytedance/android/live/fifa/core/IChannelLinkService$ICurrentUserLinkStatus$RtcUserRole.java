package com.bytedance.android.live.fifa.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/android/live/fifa/core/IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole", "", "Lcom/bytedance/android/live/fifa/core/IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole;", "Unknown", "ChannelUser", "RtcGoneUser", "RtcVisibleUser", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole extends Enum<IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole> {
    public static final IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole ChannelUser = null;
    public static final IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole RtcGoneUser = null;
    public static final IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole RtcVisibleUser = null;
    public static final IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole[] f68992a = null;

    static {
        IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole r100 = new IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole("Unknown", 0);
        Unknown = r100;
        IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole r101 = new IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole("ChannelUser", 1);
        ChannelUser = r101;
        IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole r102 = new IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole("RtcGoneUser", 2);
        RtcGoneUser = r102;
        IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole r103 = new IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole("RtcVisibleUser", 3);
        RtcVisibleUser = r103;
        f68992a = new IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole[]{r100, r101, r102, r103};
    }

    public static IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole valueOf(String r100) {
        return (IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole) a.a(IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole.class, r100);
    }

    public static IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole[] values() {
        return (IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole[]) f68992a.clone();
    }

    public IChannelLinkService$ICurrentUserLinkStatus$RtcUserRole(String r100, int r101) {
        super(r100, r101);
    }
}
