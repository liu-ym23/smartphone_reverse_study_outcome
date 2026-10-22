package com.bytedance.android.live.fifa.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public interface IChannelLinkService {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/fifa/core/IChannelLinkService$ReleaseReason;", "", "Normal", "AudioSwitchClose", "RoomEnd", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ReleaseReason extends Enum<ReleaseReason> {
        public static final ReleaseReason AudioSwitchClose = null;
        public static final ReleaseReason Normal = null;
        public static final ReleaseReason RoomEnd = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReleaseReason[] f68994a = null;

        static {
            ReleaseReason r100 = new ReleaseReason("Normal", 0);
            Normal = r100;
            ReleaseReason r101 = new ReleaseReason("AudioSwitchClose", 1);
            AudioSwitchClose = r101;
            ReleaseReason r102 = new ReleaseReason("RoomEnd", 2);
            RoomEnd = r102;
            f68994a = new ReleaseReason[]{r100, r101, r102};
        }

        public static ReleaseReason valueOf(String r100) {
            return (ReleaseReason) a.a(ReleaseReason.class, r100);
        }

        public static ReleaseReason[] values() {
            return (ReleaseReason[]) f68994a.clone();
        }

        public ReleaseReason(String r100, int r101) {
            super(r100, r101);
        }
    }
}
