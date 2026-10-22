package bw;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.gamecp.host_api.service.IBaseHostService;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public interface i extends IBaseHostService {
    Object A(String r100, Type r101, Object r102, Boolean r103);

    void B();

    void B0(Activity r100, String r101, Bundle r102, lu.h r103, Map r104);

    void D();

    void M1();

    void O(String r100);

    void Q();

    void R0(s r100);

    Object dataCenterOperate(boolean r100, String r101, Object r102, Object r103);

    boolean e();

    dw.f e1();

    void fullDialogHoverStateChange(int r100, int r101, int r102);

    void gamePrivacyMonitorEnsureRelease();

    int getCurrentScene();

    String getEventLiveType();

    void getGamePromoteSceneSub();

    void getGameTraceMonitor();

    String getIfClearModeValueWithClick();

    String getIfClearModeValueWithIntroCardShow();

    dw.g getLiveFloatViewService();

    dw.j getLiveMiniGamePlayService();

    dw.k getLiveRoomLandScapeService();

    String getLiveSdkVersion();

    Map<String, Object> getLiveSettingMap();

    <T> T getLiveSettingsValue(String r100, T r101);

    String getLiveTypeForH5();

    String getPreviewEventLiveType();

    Map<String, Object> getPreviewTrackParams(String r100, String r101, String r102);

    Room getRoomData();

    Room getRoomDataByUniqueKey(String r100);

    long getStartRoomTime();

    long getTimeStamp();

    boolean hasFullWatchRight();

    boolean hideToolbar(boolean r100);

    boolean isAnchor();

    boolean isEqualOnVoice();

    boolean isLivePlayerClientMute();

    boolean isNewLandscape(String r100);

    boolean isPreviewMergeInteract();

    void l0();

    void muteLivePlayerClient();

    void onRoomExit(long r100);

    void p2(String r100, String r101);

    void pauseLive();

    void putFunctionTypeToLogMap(Map<String, String> r100, int r101);

    void s2(Activity r100, String r101, String r102, boolean r103, com.bytedance.android.gamecp.business.props.r r104);

    void setLiveLogData(HashMap<String, String> r100);

    void setPromoteInstanceId(String r100);

    boolean shouldRegisterAnimationListener(String r100, String r101);

    void showAnchorFloatBallGamePromoteNotice(Integer r100, String r101, String r102, String r103, String r104, long r105, String r106);

    void showInteractionAndEnterRoom(String r100);

    void showLiveAdLandingPage(Context r100, Bundle r101, FragmentManager r102);

    void u1(Function1<? super Boolean, Unit> r100);

    void unMuteLivePlayerClient();

    void updateAnchorFloatBallDownloadData(int r100, boolean r101, int r102, boolean r103, boolean r104);

    void w0(String r100);

    dw.i z2();
}
