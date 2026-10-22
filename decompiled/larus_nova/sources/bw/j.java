package bw;

import com.bytedance.android.gamecp.host_api.service.IBaseHostService;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface j extends IBaseHostService {
    void A0();

    void H1(String r100, String r101, String r102, String r103, String r104, Map r105);

    String J0();

    void W(String r100);

    Map<String, Object> getAdLogExtra();

    Map<String, String> getFilterParamsByName(String r100);

    void logV3(String r100, Map<String, String> r101);

    void logV3NoPrefix(String r100, Map<String, String> r101);

    void sendLiveAdLog(String r100, String r101, Long r102, JSONObject r103, boolean r104);

    void y1();
}
