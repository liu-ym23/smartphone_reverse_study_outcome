package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0017\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveRoomPreloadService;", "", "onPreviewState", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "state", "Lcom/bytedance/android/livesdkapi/service/ILiveRoomPreloadService$TriggerState;", "preload", "roomId", "", "(Ljava/lang/Long;)V", "TriggerState", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRoomPreloadService {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveRoomPreloadService$TriggerState;", "", "(Ljava/lang/String;I)V", "SELECTED_TRIGGER", "UNSELECT_TRIGGER", "FIRST_FRAME_TRIGGER", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TriggerState extends Enum<TriggerState> {
        private static final /* synthetic */ TriggerState[] $VALUES = null;
        public static final TriggerState FIRST_FRAME_TRIGGER = null;
        public static final TriggerState SELECTED_TRIGGER = null;
        public static final TriggerState UNSELECT_TRIGGER = null;

        static {
            TriggerState r100 = new TriggerState("SELECTED_TRIGGER", 0);
            SELECTED_TRIGGER = r100;
            TriggerState r101 = new TriggerState("UNSELECT_TRIGGER", 1);
            UNSELECT_TRIGGER = r101;
            TriggerState r102 = new TriggerState("FIRST_FRAME_TRIGGER", 2);
            FIRST_FRAME_TRIGGER = r102;
            $VALUES = new TriggerState[]{r100, r101, r102};
        }

        public static TriggerState valueOf(String r100) {
            return (TriggerState) a.a(TriggerState.class, r100);
        }

        public static TriggerState[] values() {
            return (TriggerState[]) $VALUES.clone();
        }

        private TriggerState(String r100, int r101) {
            super(r100, r101);
        }
    }

    void onPreviewState(IRoom r100, TriggerState r101);

    void preload(Long r100);
}
