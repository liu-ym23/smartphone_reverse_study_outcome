package w0;

import android.os.Process;
import com.bytedance.services.apm.api.IFdCheck;
import com.stepos.aiengine.args.SingleFileBundle;
import java.io.File;
import org.json.JSONObject;

/* renamed from: w0.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2081b extends AbstractC2080a {
    public static IFdCheck i;
    public int g;
    public long h;

    @Override // w0.AbstractC2080a
    public final void b(JSONObject jSONObject) {
        this.g = jSONObject.optInt("fd_count_threshold", 800);
        this.h = jSONObject.optLong("collect_interval", 10L) * 60000;
    }

    @Override // w0.AbstractC2080a
    public final boolean h() {
        return true;
    }

    @Override // w0.AbstractC2080a
    public final void j() {
        int length;
        if (System.currentTimeMillis() - H.h.l > 1200000) {
            try {
                length = new File("/proc/" + Process.myPid() + "/fd").listFiles().length;
            } catch (Throwable unused) {
                length = 0;
            }
            if (length == 0) {
                return;
            }
            try {
                if (length <= 0 || length >= this.g) {
                    if (i == null) {
                        i = (IFdCheck) L2.a.a(IFdCheck.class);
                    }
                    IFdCheck iFdCheck = i;
                    if (iFdCheck == null) {
                        return;
                    }
                    String strO = S0.b.o("\n", iFdCheck.getFdList());
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("fd_count", length);
                    jSONObject.put("fd_detail", strO);
                    jSONObject.put("is_main_process", H.h.g());
                    jSONObject.put("process_name", H.h.c());
                    a(new P.e(SingleFileBundle.KEY_FILE_DESCRIPTOR, "", "", null, null, jSONObject));
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("fd_count", length);
                    jSONObject2.put("is_main_process", H.h.g());
                    jSONObject2.put("process_name", H.h.c());
                    a(new P.e(SingleFileBundle.KEY_FILE_DESCRIPTOR, "", "", null, null, jSONObject2));
                }
            } catch (Exception unused2) {
            }
        }
    }

    @Override // w0.AbstractC2080a
    public final long k() {
        return this.h;
    }
}
