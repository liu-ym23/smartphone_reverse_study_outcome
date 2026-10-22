package p2;

import N9.j;
import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.ExitType;
import com.apm.insight.entity.Header;
import com.apm.insight.f;
import com.apm.insight.g;
import com.stepos.ability.task.executor.e;
import com.stepos.statsrpk.d;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import g2.C1452a;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import w2.AbstractC2095a;
import z2.b;

/* renamed from: p2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1790a {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f5537a = new AtomicBoolean(false);

    public static void a() {
        ActivityManager activityManager;
        List<ApplicationExitInfo> historicalProcessExitReasons;
        ApplicationExitInfo next;
        if (f5537a.compareAndSet(false, true)) {
            try {
                Context context = g.f2160a;
                F.g gVar = null;
                if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(context.getPackageName(), 0, 15)) == null || historicalProcessExitReasons.size() <= 0) {
                    historicalProcessExitReasons = null;
                }
                if (historicalProcessExitReasons == null || historicalProcessExitReasons.isEmpty()) {
                    return;
                }
                String strO = d.o();
                Iterator<ApplicationExitInfo> it = historicalProcessExitReasons.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (TextUtils.equals(next.getProcessName(), strO)) {
                            break;
                        }
                    }
                }
                if (next == null) {
                    return;
                }
                C1452a c1452aB = C1452a.b();
                int reason = next.getReason();
                String description = next.getDescription();
                int status = next.getStatus();
                c1452aB.getClass();
                C1452a.c(reason, status, description);
                if (b.j()) {
                    if (g.f2162q == ExitType.EXCEPTION.type && e.x(next.getReason())) {
                        return;
                    }
                    n2.a aVarO = u1.d.s().o(CrashType.EXIT, new Q.a(next, 8));
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(aVarO.f5345a);
                    jSONObject.put(SettingsConfig.KEY_DATA, jSONArray);
                    Header headerB = Header.b(next.getTimestamp());
                    String deviceId = "";
                    try {
                        deviceId = f.b.config().getDeviceId();
                        if (TextUtils.isEmpty(headerB.f2158a.optString("device_id"))) {
                            if (TextUtils.isEmpty(deviceId)) {
                                headerB.j();
                            } else {
                                headerB.f2158a.put("device_id", deviceId);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    String str = "android__" + deviceId + "_" + next.getTimestamp() + "_" + CrashType.EXIT;
                    JSONObject jSONObject2 = headerB.f2158a;
                    jSONObject2.put("unique_key", str);
                    jSONObject.put("header", jSONObject2);
                    String launchCrashUploadUrl = g.g.getLaunchCrashUploadUrl();
                    if (e.x(next.getReason())) {
                        AbstractC2095a.d(launchCrashUploadUrl, jSONObject.toString(), new F.g[0]);
                        return;
                    }
                    File fileE = j.e(next.getTimestamp(), next.getProcessName());
                    F.g gVar2 = (fileE == null || !fileE.exists()) ? null : new F.g(10, new FileInputStream(fileE), fileE.getName());
                    if (next.getTraceInputStream() != null) {
                        gVar = new F.g(10, next.getTraceInputStream(), next.getReason() == 5 ? "tombstone" : next.getReason() == 6 ? "anr_trace.txt" : "ext.dump");
                    }
                    AbstractC2095a.d(launchCrashUploadUrl, jSONObject.toString(), gVar, gVar2);
                }
            } catch (Throwable unused2) {
            }
        }
    }
}
