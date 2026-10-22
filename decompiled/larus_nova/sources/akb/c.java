package akb;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends q5c.a {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f4102a = null;

        static {
            f4102a = new c(0);
        }
    }

    public c(int r100) {
    }

    public static void a(ErrorResult r100) {
        JSONObject r101 = new JSONObject();
        r101.put("errorCode", r100.getErrorCode());     // Catch: JSONException -> L6
        r101.put("error", r100.getDebugMsg());     // Catch: JSONException -> L6
    L4:
        Statistics.sendEvent("lark_guide_fetch_info_failed", r101);
    }
}
