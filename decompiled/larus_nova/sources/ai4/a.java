package ai4;

import android.app.ApplicationExitInfo;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static void a(JSONObject r110) {
        List<ApplicationExitInfo> r100 = d.b();     // Catch: Throwable -> L28
        if (r100 != null) goto L5;
        return;
    L5:
        JSONObject r101 = r110.optJSONObject("custom");     // Catch: Throwable -> L28
        long r102 = r110.optLong("crash_time");     // Catch: Throwable -> L28
        int r103 = r110.optInt("pid");     // Catch: Throwable -> L28
        String r104 = r110.optString("process_name");     // Catch: Throwable -> L28
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L28
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L28
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L28
        Iterator<ApplicationExitInfo> r108 = r100.iterator();     // Catch: Throwable -> L28
    L7:
        if (r108.hasNext() == false) goto L22;
        ApplicationExitInfo r109 = r108.next();     // Catch: Throwable -> L28
        if (r109.getProcessName().equals(r104) == false) goto L7;
        if (r103 != r109.getPid()) goto L7;
        long r111 = r109.getTimestamp() - r102;     // Catch: Throwable -> L28
        if (r111 <= 0) goto L7;
        if (r111 > 30000) goto L7;
        if (r109.getReason() != 6) goto L20;
        r107.append(r109.getDescription() + ",");     // Catch: Throwable -> L28
    L20:
        r105.append(r109.getReason() + ",");     // Catch: Throwable -> L28
        r106.append("timestamp=" + r109.getTimestamp());     // Catch: Throwable -> L28
        r106.append(" crash_pid=" + r103);     // Catch: Throwable -> L28
        r106.append(" crash_time=" + r102 + " \n");     // Catch: Throwable -> L28
        r106.append(r109);     // Catch: Throwable -> L28
        r106.append("\n");     // Catch: Throwable -> L28
        goto L7
    L22:
        if (r106.length() <= 0) goto L24;
        r101.put("history_exit_process_list", r106);     // Catch: Throwable -> L28
    L24:
        r110.put("exit_reason", r105);     // Catch: Throwable -> L28
        if (r107.length() <= 0) goto L42;
        r110.put("anr_reason_from_exit", r107);     // Catch: Throwable -> L28
        return;
    L42:
        return;
    }
}
