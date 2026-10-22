package akb;

import com.bytedance.apm.ApmAgent;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4100a = 0;

    static {
    }

    public static void a(boolean r100, long r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("succeed", r100);
        JSONObject r104 = new JSONObject();
        r104.put(ChameleonOpenTracker.ParamKey.COST, r101);
        JSONObject r105 = new JSONObject();
        r105.put("error_msg", r102);
        ApmAgent.monitorEvent("ug_get_user_guide", r103, r104, r105);
    }

    public static void b(boolean r100, long r101, String r102, Integer r103, String r104) {
        JSONObject r105 = new JSONObject();
        r105.put("succeed", r100);
        r105.put("error_code", r103);
        r105.put("guide_keys", r102);
        JSONObject r106 = new JSONObject();
        r106.put(ChameleonOpenTracker.ParamKey.COST, r101);
        JSONObject r107 = new JSONObject();
        r107.put("error_msg", r104);
        ApmAgent.monitorEvent("ug_post_user_consuming_guide", r105, r106, r107);
    }
}
