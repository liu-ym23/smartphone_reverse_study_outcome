package com.bytedance.android.live.fifa.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/bytedance/android/live/fifa/core/IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel", "", "Lcom/bytedance/android/live/fifa/core/IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel;", "SILENT", "LEVEL_1", "LEVEL_2", "LEVEL_3", "LEVEL_4", "LEVEL_5", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel extends Enum<IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel> {
    public static final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel LEVEL_1 = null;
    public static final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel LEVEL_2 = null;
    public static final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel LEVEL_3 = null;
    public static final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel LEVEL_4 = null;
    public static final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel LEVEL_5 = null;
    public static final IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel SILENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel[] f68993a = null;

    static {
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r100 = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel("SILENT", 0);
        SILENT = r100;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r101 = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel("LEVEL_1", 1);
        LEVEL_1 = r101;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r102 = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel("LEVEL_2", 2);
        LEVEL_2 = r102;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r103 = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel("LEVEL_3", 3);
        LEVEL_3 = r103;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r104 = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel("LEVEL_4", 4);
        LEVEL_4 = r104;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r105 = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel("LEVEL_5", 5);
        LEVEL_5 = r105;
        f68993a = new IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel[]{r100, r101, r102, r103, r104, r105};
    }

    public static IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel valueOf(String r100) {
        return (IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel) a.a(IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel.class, r100);
    }

    public static IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel[] values() {
        return (IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel[]) f68993a.clone();
    }

    public IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel(String r100, int r101) {
        super(r100, r101);
    }
}
