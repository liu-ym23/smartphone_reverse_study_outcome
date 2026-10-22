package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/IABRController;", "", "RejectedReason", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IABRController {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/IABRController$RejectedReason;", "", "(Ljava/lang/String;I)V", "FIXED_RESOLUTION", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RejectedReason extends Enum<RejectedReason> {
        private static final /* synthetic */ RejectedReason[] $VALUES = null;
        public static final RejectedReason FIXED_RESOLUTION = null;

        static {
            RejectedReason r100 = new RejectedReason("FIXED_RESOLUTION", 0);
            FIXED_RESOLUTION = r100;
            $VALUES = new RejectedReason[]{r100};
        }

        public static RejectedReason valueOf(String r100) {
            return (RejectedReason) a.a(RejectedReason.class, r100);
        }

        public static RejectedReason[] values() {
            return (RejectedReason[]) $VALUES.clone();
        }

        private RejectedReason(String r100, int r101) {
            super(r100, r101);
        }
    }
}
