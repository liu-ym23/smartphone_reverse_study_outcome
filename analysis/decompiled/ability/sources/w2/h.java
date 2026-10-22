package w2;

import com.apm.insight.CrashType;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentLinkedQueue f6837a = new ConcurrentLinkedQueue();

    public static void a(CrashType crashType, JSONObject jSONObject) {
        ConcurrentLinkedQueue concurrentLinkedQueue = f6837a;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        if (crashType == CrashType.LAUNCH) {
            ((JSONArray) jSONObject.opt(SettingsConfig.KEY_DATA)).optJSONObject(0);
        }
        jSONObject.optJSONObject("header");
        while (!f6837a.isEmpty()) {
            if (f6837a.poll() != null) {
                throw new ClassCastException();
            }
        }
        f6837a = null;
    }
}
