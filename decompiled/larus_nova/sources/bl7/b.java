package bl7;

import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ug.sdk.luckydog.api.model.CrossZoneUserType;
import com.bytedance.ug.sdk.luckydog.api.task.pendant.PendantStyle;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    void checkIsCrossZoneUser(long r100, CrossZoneUserType r101, boolean r102, kk7.b r103);

    void checkUpload();

    lk7.a getLastCheckRecord();

    ConcurrentHashMap<String, Class<? extends a>> getRegisteredActionExecutor();

    List<Class<? extends XBridgeMethod>> getXBridge();

    void handleSchema(String r100);

    boolean handleThirdPartyExchangeSchema(String r100);

    void init();

    boolean isThirdPartyExchangeSchema(String r100);

    void onAccountBindUpdate();

    void onAccountRefresh(boolean r100);

    void onBasicModeRefresh(boolean r100);

    void onDeviceIdUpdate(String r100);

    void onPrivacyOk();

    void onTeenModeRefresh(boolean r100);

    void registerBridgeV3(WebView r100, Lifecycle r101);

    void setConsumeDuration(String r100, int r101);

    void showPendantInFrameLayout(FrameLayout r100, FrameLayout.LayoutParams r101, int r102, PendantStyle r103);

    void showTimerTaskPendant(String r100, FrameLayout r101, FrameLayout.LayoutParams r102, int r103);

    void showTimerTaskPendantRobust(String r100, FrameLayout r101, FrameLayout.LayoutParams r102, int r103);

    void startTaskTimer(String r100);

    void startTaskTimer(String r100, int r101);

    void startTimer(String r100);

    void stopTaskById(String r100);

    void stopTaskTimer(String r100);

    void tryReportAppActivate();

    void updateDuration(int r100, int r101, Map<String, Integer> r102, boolean r103);

    void updateSchemaMap(JSONObject r100);

    void updateTaskSettings(JSONObject r100);
}
