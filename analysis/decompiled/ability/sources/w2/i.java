package w2;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class i {
    public static volatile i b;

    /* renamed from: a, reason: collision with root package name */
    public volatile Context f6838a;

    public static i a() {
        if (b == null) {
            Context context = com.apm.insight.g.f2160a;
            i iVar = new i();
            iVar.f6838a = context;
            b = iVar;
        }
        return b;
    }

    public final void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String exceptionUploadUrl = com.apm.insight.g.g.getExceptionUploadUrl();
            File file = new File(N9.j.f(this.f6838a), "ensure_" + com.apm.insight.g.f());
            M.a.l(file, file.getName(), exceptionUploadUrl, jSONObject);
            if (AbstractC2095a.g(exceptionUploadUrl, jSONObject.toString(), false).a()) {
                M.a.u(file);
            }
        } catch (Throwable th) {
            S0.b.p0(th);
        }
    }

    public final boolean c(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String javaCrashUploadUrl = com.apm.insight.g.g.getJavaCrashUploadUrl();
                File file = new File(N9.j.f(this.f6838a), "dart_" + com.apm.insight.g.f());
                M.a.l(file, file.getName(), javaCrashUploadUrl, jSONObject);
                jSONObject.put("upload_scene", "direct");
                if (AbstractC2095a.g(javaCrashUploadUrl, jSONObject.toString(), true).a()) {
                    M.a.u(file);
                    return true;
                }
            } catch (Throwable th) {
                S0.b.p0(th);
            }
        }
        return false;
    }

    public final boolean d(JSONObject jSONObject, long j5, boolean z10, String str, boolean z11, String str2) {
        File[] fileArr;
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String javaCrashUploadUrl = com.apm.insight.g.g.getJavaCrashUploadUrl();
                if (str2 == null) {
                    str2 = com.apm.insight.g.b(j5, CrashType.ANR, false, false);
                }
                File file = new File(N9.j.f(this.f6838a), str2);
                if (z11) {
                    M.a.l(file, file.getName(), javaCrashUploadUrl, jSONObject);
                }
                if (z10 && !Npth.isStopUpload()) {
                    jSONObject.put("upload_scene", "direct");
                    jSONObject.put("crash_uuid", file.getName());
                    if (z2.b.a("custom_event_settings", "npth_simple_setting", "enable_anr_all_process_trace") == 1) {
                        HashMap mapH = N9.j.h(j5);
                        fileArr = new File[mapH.size() + 2];
                        int i = 0;
                        for (Map.Entry entry : mapH.entrySet()) {
                            if (!((String) entry.getKey()).equals(com.stepos.statsrpk.d.o())) {
                                fileArr[i] = N9.j.g(this.f6838a, ((z2.m) entry.getValue()).f6936a);
                                i++;
                            }
                        }
                    } else {
                        fileArr = new File[2];
                    }
                    fileArr[fileArr.length - 1] = N9.j.g(this.f6838a, str);
                    fileArr[fileArr.length - 2] = N9.j.d(j5);
                    if (AbstractC2095a.a(javaCrashUploadUrl, jSONObject.toString(), fileArr).a()) {
                        M.a.u(file);
                        M.a.u(N9.j.g(this.f6838a, str));
                        M.a.u(N9.j.k(this.f6838a, str));
                        if (!Npth.hasCrash()) {
                            M.a.u(N9.j.p(com.apm.insight.g.f2160a));
                        }
                        H4.o.d(N9.j.D(com.apm.insight.g.f2160a), CrashType.ANR, file.getName());
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
