package com.bytedance.android.livesdkapi.room.controller;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider;", "", "businessType", "", "getController", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomController;", "roomId", "uniqueKey", "getStartLivePreviewController", "Lcom/bytedance/android/livesdkapi/room/controller/IStartLivePreviewController;", "substituteClearLiveRoomController", "", "ProviderSource", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRoomControllerProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider$ProviderSource;", "", "(Ljava/lang/String;I)V", "PREVIEW", "DEFAULT", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ProviderSource extends Enum<ProviderSource> {
        private static final /* synthetic */ ProviderSource[] $VALUES = null;
        public static final ProviderSource DEFAULT = null;
        public static final ProviderSource PREVIEW = null;

        static {
            ProviderSource r100 = new ProviderSource("PREVIEW", 0);
            PREVIEW = r100;
            ProviderSource r101 = new ProviderSource("DEFAULT", 1);
            DEFAULT = r101;
            $VALUES = new ProviderSource[]{r100, r101};
        }

        public static ProviderSource valueOf(String r100) {
            return (ProviderSource) a.a(ProviderSource.class, r100);
        }

        public static ProviderSource[] values() {
            return (ProviderSource[]) $VALUES.clone();
        }

        private ProviderSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    String businessType();

    ILiveRoomController getController(String r100, String r101);

    IStartLivePreviewController getStartLivePreviewController();

    void substituteClearLiveRoomController(String r100, String r101);
}
