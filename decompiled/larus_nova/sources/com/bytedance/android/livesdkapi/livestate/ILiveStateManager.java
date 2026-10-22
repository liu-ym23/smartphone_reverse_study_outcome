package com.bytedance.android.livesdkapi.livestate;

import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.livesdkapi.model.UserLiveStatusModel;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J!\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H&J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/livestate/ILiveStateManager;", "", "cancelLoop", "", "key", "", "checkRoomStatus", "request", "Lcom/bytedance/android/livesdkapi/livestate/LiveStateRequest;", "getRoomIdFromCache", "", "sceneId", "uid", "(JLjava/lang/String;)Ljava/lang/Long;", "getUserLiveStatusFromCache", "Lcom/bytedance/android/livesdkapi/model/UserLiveStatusModel;", "removeAllCache", "removeCache", "userId", "runInLoop", "owner", "Landroidx/lifecycle/LifecycleRegistry;", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/bytedance/android/livesdkapi/livestate/IDataProvider;", "setCachePeriod", "scene", "time", "Scene", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveStateManager {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/livestate/ILiveStateManager$Scene;", "", "scene", "", "(Ljava/lang/String;IJ)V", "getScene", "()J", "ToutiaoMicroSquare", "ToutiaoMicroAd", "LiveHead", "Unknow", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Scene extends Enum<Scene> {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final Scene LiveHead = null;
        public static final Scene ToutiaoMicroAd = null;
        public static final Scene ToutiaoMicroSquare = null;
        public static final Scene Unknow = null;
        private final long scene;

        static {
            Scene r100 = new Scene("ToutiaoMicroSquare", 0, 2);
            ToutiaoMicroSquare = r100;
            Scene r101 = new Scene("ToutiaoMicroAd", 1, 4);
            ToutiaoMicroAd = r101;
            Scene r102 = new Scene("LiveHead", 2, 3);
            LiveHead = r102;
            Scene r103 = new Scene("Unknow", 3, 183);
            Unknow = r103;
            $VALUES = new Scene[]{r100, r101, r102, r103};
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        public final long getScene() {
            return this.scene;
        }

        private Scene(String r100, int r101, long r102) {
            super(r100, r101);
            this.scene = r102;
        }
    }

    void cancelLoop(String r100);

    void checkRoomStatus(LiveStateRequest r100);

    Long getRoomIdFromCache(long r100, String r101);

    UserLiveStatusModel getUserLiveStatusFromCache(long r100, String r101);

    void removeAllCache();

    void removeCache(long r100);

    void removeCache(long r100, String r101);

    void runInLoop(String r100, LifecycleRegistry r101, IDataProvider r102);

    void setCachePeriod(long r100, long r101);
}
