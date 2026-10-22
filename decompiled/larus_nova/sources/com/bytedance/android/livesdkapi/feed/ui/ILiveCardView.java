package com.bytedance.android.livesdkapi.feed.ui;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f2\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000eH&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/ui/ILiveCardView;", "", "bindRoom", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "enterFromMerge", "", "liveCoverConfig", "Lcom/bytedance/android/livesdkapi/feed/model/LiveCoverConfig;", "roomJson", "params", "", "enablePreview", "", SendEventContainerMethodParamModel.EventKinds.onShow, "startPreview", "stopPreview", "destroyPlayer", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCardView {
    public static final Companion Companion = null;
    public static final String KEY_ENTER_FROM_MERGE = "key_enter_from_merge";
    public static final String KEY_LOG_PB = "key_log_pb";
    public static final String KEY_REQUEST_ID = "key_request_id";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/ui/ILiveCardView$Companion;", "", "()V", "KEY_ENTER_FROM_MERGE", "", "KEY_LOG_PB", "KEY_REQUEST_ID", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String KEY_ENTER_FROM_MERGE = "key_enter_from_merge";
        public static final String KEY_LOG_PB = "key_log_pb";
        public static final String KEY_REQUEST_ID = "key_request_id";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void bindRoom(Room r100, String r101, LiveCoverConfig r102);

    void bindRoom(String r100, Map<String, String> r101, LiveCoverConfig r102);

    boolean enablePreview();

    void onShow();

    void startPreview();

    void stopPreview(boolean r100);
}
