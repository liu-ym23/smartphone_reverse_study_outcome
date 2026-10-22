package com.bytedance.android.livesdkapi.roomplayer;

import android.view.MotionEvent;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.model.VideoEffectSixDofLiteModeParams;
import com.bytedance.android.livesdkapi.vr.LiveVrEffectInfo;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u0000 72\u00020\u0001:\u000278J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\nH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\u0007H&J\b\u0010\u0017\u001a\u00020\u0007H&J@\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aH&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&J\u0012\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u0007H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\rH&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\rH&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0010H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0007H&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\nH&J\u0012\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0005H&J\u0018\u00103\u001a\u00020\u00032\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u000105H&J\u0010\u00106\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\rH&¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerVRController;", "", "applyVrEffect", "", "info", "Lcom/bytedance/android/livesdkapi/vr/LiveVrEffectInfo;", "disableConfigCover", "", "checkSeiRawForVrMode", "seiRaw", "", "disableVrRenderForStrategy", "getGyroStatusInitial", "", "getVRFov", "getVideoEffectSixDofLiteModeParams", "Lcom/bytedance/android/livesdkapi/model/VideoEffectSixDofLiteModeParams;", "getVrEffectContextId", "getVrEffectInfo", "getVrEffectManagerVrEffectInfoCopy", "gyroEnable", "enable", "isVrEffectPlusVersion", "isVrLive", "onHeadPoseUpdate", "quatX", "", "quatY", "quatZ", "quatW", "posX", "posY", "posZ", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "recenter", "zoomReset", "setGyroStatusInitial", "gyroStatusInitial", "setVrDirectMode", "mode", "setVrEffectLiteMode", "params", "setVrFovParsed", "parsed", "toggleVr", "updateVrEffectContextId", "contextId", "updateVrEffectInfo", "effectInfo", "updateVrEffectLayerStatus", "layerStatus", "", "vrWatchMode", "Companion", "VREvent", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerVRController {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerVRController$Companion;", "", "()V", "PANORAMA_DIRECT_MODE_BOTH_SENSOR_TOUCH", "", "getPANORAMA_DIRECT_MODE_BOTH_SENSOR_TOUCH", "()I", "PANORAMA_DIRECT_MODE_SENSOR", "getPANORAMA_DIRECT_MODE_SENSOR", "PANORAMA_DIRECT_MODE_TOUCH", "getPANORAMA_DIRECT_MODE_TOUCH", "PANORAMA_WATCH_MODE_FULLSCREEN", "getPANORAMA_WATCH_MODE_FULLSCREEN", "PANORAMA_WATCH_MODE_NORMAL", "getPANORAMA_WATCH_MODE_NORMAL", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final int PANORAMA_DIRECT_MODE_BOTH_SENSOR_TOUCH = 0;
        private static final int PANORAMA_DIRECT_MODE_SENSOR = 0;
        private static final int PANORAMA_DIRECT_MODE_TOUCH = 0;
        private static final int PANORAMA_WATCH_MODE_FULLSCREEN = 0;
        private static final int PANORAMA_WATCH_MODE_NORMAL = 0;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            PANORAMA_DIRECT_MODE_SENSOR = 1;
            PANORAMA_DIRECT_MODE_TOUCH = 2;
            PANORAMA_DIRECT_MODE_BOTH_SENSOR_TOUCH = 2 | 1;
            PANORAMA_WATCH_MODE_FULLSCREEN = 1;
        }

        public final int getPANORAMA_DIRECT_MODE_BOTH_SENSOR_TOUCH() {
            return PANORAMA_DIRECT_MODE_BOTH_SENSOR_TOUCH;
        }

        public final int getPANORAMA_DIRECT_MODE_SENSOR() {
            return PANORAMA_DIRECT_MODE_SENSOR;
        }

        public final int getPANORAMA_DIRECT_MODE_TOUCH() {
            return PANORAMA_DIRECT_MODE_TOUCH;
        }

        public final int getPANORAMA_WATCH_MODE_FULLSCREEN() {
            return PANORAMA_WATCH_MODE_FULLSCREEN;
        }

        public final int getPANORAMA_WATCH_MODE_NORMAL() {
            return PANORAMA_WATCH_MODE_NORMAL;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void recenter$default(ILivePlayerVRController r100, boolean r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = true;
        L6:
            r100.recenter(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recenter");
        }

        public static /* synthetic */ void applyVrEffect$default(ILivePlayerVRController r100, LiveVrEffectInfo r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            r100.applyVrEffect(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyVrEffect");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u001e\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerVRController$VREvent;", "", "vrBgLogUpdateOrSend", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdkapi/roomplayer/VrBgLogData;", "getVrBgLogUpdateOrSend", "()Landroidx/lifecycle/MutableLiveData;", "vrLive", "", "getVrLive", "vrViewAngleChange", "", "", "getVrViewAngleChange", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface VREvent {
        MutableLiveData<VrBgLogData> getVrBgLogUpdateOrSend();

        MutableLiveData<Boolean> getVrLive();

        MutableLiveData<List<Float>> getVrViewAngleChange();
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void applyVrEffect(LiveVrEffectInfo r100, boolean r101);

    boolean checkSeiRawForVrMode(String r100);

    void disableVrRenderForStrategy();

    int getGyroStatusInitial();

    int getVRFov();

    VideoEffectSixDofLiteModeParams getVideoEffectSixDofLiteModeParams();

    String getVrEffectContextId();

    LiveVrEffectInfo getVrEffectInfo();

    LiveVrEffectInfo getVrEffectManagerVrEffectInfoCopy();

    void gyroEnable(boolean r100);

    boolean isVrEffectPlusVersion();

    boolean isVrLive();

    void onHeadPoseUpdate(float r100, float r101, float r102, float r103, float r104, float r105, float r106);

    void onTouchEvent(MotionEvent r100);

    void recenter(boolean r100);

    void setGyroStatusInitial(int r100);

    void setVrDirectMode(int r100);

    void setVrEffectLiteMode(VideoEffectSixDofLiteModeParams r100);

    void setVrFovParsed(boolean r100);

    void toggleVr(boolean r100);

    void updateVrEffectContextId(String r100);

    void updateVrEffectInfo(LiveVrEffectInfo r100);

    void updateVrEffectLayerStatus(List<Integer> r100);

    void vrWatchMode(int r100);
}
