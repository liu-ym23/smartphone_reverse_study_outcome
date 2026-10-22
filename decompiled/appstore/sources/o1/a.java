package o1;

import android.text.TextUtils;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicInteger f22463a;

    static {
        f22463a = new AtomicInteger(0);
    }

    public static void a(String r10, JSONObject r11) {
        JSONObject r12 = r11.optJSONObject("DATA_DOCTOR");
        if (r12 != null) goto L15;
        r12 = new JSONObject();
    L15:
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (r12.optInt("DATA_ID", -1) != (-1)) goto L11;
        r12.put("DATA_ID", f22463a.incrementAndGet());     // Catch: Exception -> L9
    L11:
        r12.put("DATA_PROCESS", af.a.a(r3.a.b()));     // Catch: Exception -> L9
        r12.put("DATA_TYPE", r10);     // Catch: Exception -> L9
        r12.put("DATA_AID", d3.a.h());     // Catch: Exception -> L9
        r11.put("DATA_DOCTOR", r12);     // Catch: Exception -> L9
        JSONObject r13 = new JSONObject(r11.toString());     // Catch: Exception -> L9
        DoctorManager.getInstance().a("DATA_DOWNGRADE", r13);     // Catch: Exception -> L9
    }

    public static void b(String r10, JSONObject r11, boolean r12) {
        JSONObject r13 = r11.optJSONObject("DATA_DOCTOR");
        if (r13 != null) goto L15;
        r13 = new JSONObject();
    L15:
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (r13.optInt("DATA_ID", -1) != (-1)) goto L11;
        r13.put("DATA_ID", f22463a.incrementAndGet());     // Catch: Exception -> L9
    L11:
        r13.put("DATA_PROCESS", af.a.a(r3.a.b()));     // Catch: Exception -> L9
        r13.put("DATA_TYPE", r10);     // Catch: Exception -> L9
        r13.put("DATA_SAMPLE", r12);     // Catch: Exception -> L9
        r13.put("DATA_AID", d3.a.h());     // Catch: Exception -> L9
        r11.put("DATA_DOCTOR", r13);     // Catch: Exception -> L9
        JSONObject r14 = new JSONObject(r11.toString());     // Catch: Exception -> L9
        DoctorManager.getInstance().a("DATA_RECEIVE", r14);     // Catch: Exception -> L9
        DoctorManager.getInstance().a("DATA_CACHE", r14);     // Catch: Exception -> L9
    }

    public static void c(JSONObject r10) {
        if (r10 != null) goto L7;
        return;
    L7:
        JSONObject r11 = new JSONObject(r10.toString());     // Catch: Exception -> L6
        DoctorManager.getInstance().a("DATA_SAVE_TO_DB", r11);     // Catch: Exception -> L6
        return;
    }

    public static void d(byte[] r10) {
        List r11 = i(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        Iterator r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        e((JSONObject) r12.next(), "DATA_SEND_BEGIN");
        goto L7
    }

    public static void e(JSONObject r10, String r11) {
        if (r10 != null) goto L7;
        return;
    L7:
        DoctorManager.getInstance().a(r11, r10);     // Catch: Exception -> L6
        return;
    }

    public static void f(byte[] r10) {
        Iterator r11 = i(r10).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        JSONObject r12 = (JSONObject) r11.next();
        e(r12, "DATA_SEND_FAIL");
        e(r12, "DATA_SEND_END");
        goto L4
    }

    public static void g(byte[] r10, JSONObject r11) {
        Iterator r12 = i(r10).iterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        JSONObject r13 = (JSONObject) r12.next();
        JSONObject r14 = new JSONObject(r11.toString());     // Catch: JSONException -> L9
        JSONObject r15 = r13.optJSONObject("DATA_DOCTOR");     // Catch: JSONException -> L9
        if (r15 == null) goto L11;
        r14.put("DATA_DOCTOR", r15);     // Catch: JSONException -> L9
    L11:
        e(r14, "DATA_SEND_RESPONSE");     // Catch: JSONException -> L9
        e(r13.put("response", r14), "DATA_SEND_RESPONSE_NEW");     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public static void h(byte[] r10) {
        Iterator r11 = i(r10).iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        JSONObject r12 = (JSONObject) r11.next();
        JSONObject r13 = r12.optJSONObject("DATA_DOCTOR");     // Catch: Exception -> L11
        if (r13 == null) goto L9;
        r13.put("DATA_SEND_RESULT", 200);     // Catch: Exception -> L11
    L9:
        e(r12, "DATA_SEND_SUCCESS");
        e(r12, "DATA_SEND_END");
        goto L4
    }

    public static List i(byte[] r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r11 = new String(r10);
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return null;
    L8:
        ArrayList r12 = new ArrayList();
        JSONObject r13 = new JSONObject(r11);     // Catch: Exception -> L35
        int r14 = 0;
        if (r13.has(ServerElements.LIST) == false) goto L29;
        JSONArray r15 = r13.optJSONArray(ServerElements.LIST);     // Catch: Exception -> L35
        if (r15 != null) goto L15;
        return null;
    L15:
        int r16 = 0;
    L17:
        if (r16 >= r15.length()) goto L34;
        JSONObject r17 = r15.getJSONObject(r16);     // Catch: Exception -> L35
        if (r17 == null) goto L28;
        JSONArray r18 = r17.optJSONArray("data");     // Catch: Exception -> L35
        if (r18 == null) goto L28;
        int r19 = 0;
    L26:
        if (r19 >= r18.length()) goto L28;
        r12.add(r18.getJSONObject(r19));     // Catch: Exception -> L35
        r19 = r19 + 1;     // Catch: Exception -> L35
    L28:
        r16 = r16 + 1;     // Catch: Exception -> L35
        goto L17
    L29:
        JSONArray r20 = r13.optJSONArray("data");     // Catch: Exception -> L35
    L31:
        if (r14 >= r20.length()) goto L34;
        r12.add(r20.getJSONObject(r14));     // Catch: Exception -> L35
        r14 = r14 + 1;
    L34:
        return r12;
    }
}
