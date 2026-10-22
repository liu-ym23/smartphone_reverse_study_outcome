package U1;

import B.e;
import H.h;
import S0.b;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.services.apm.api.IHttpService;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f1265a = "https://mon.snssdk.com/monitor/collect/c/cloudcontrol/file";

    static {
        new HashMap();
        UUID.randomUUID().toString();
    }

    public static boolean a(String str, File file, int i, String str2, String str3, String str4, long j5, HashMap map) {
        if (TextUtils.isEmpty(str) || !file.exists()) {
            throw new IllegalArgumentException("url and file not be null ");
        }
        HashMap map2 = new HashMap();
        if (!TextUtils.isEmpty(h.f718w)) {
            map2.put("aid", h.a());
            map2.put("x-auth-token", h.f718w);
        }
        try {
            e eVarBuildMultipartUpload = ((IHttpService) L2.a.a(IHttpService.class)).buildMultipartUpload(str, "UTF-8", map2, false);
            eVarBuildMultipartUpload.a("status", String.valueOf(i));
            eVarBuildMultipartUpload.a("cid", str3);
            eVarBuildMultipartUpload.a("err_msg", str4);
            eVarBuildMultipartUpload.a("operate_time", String.valueOf(j5));
            Q1.a.b();
            eVarBuildMultipartUpload.a("aid", Q1.a.i);
            Q1.a.b();
            eVarBuildMultipartUpload.a("update_version_code", "");
            eVarBuildMultipartUpload.a("uid", h.e.getUserId());
            if (i == 2 || i == 3 || (i == 0 && map != null && !map.isEmpty())) {
                String strQ = b.q(Q1.a.b().c);
                HashMap map3 = new HashMap();
                map3.put("filetype", "command_commonparams");
                eVarBuildMultipartUpload.c("fileCommon", map3, "common_params.txt", strQ);
                String strQ2 = b.q(map);
                HashMap map4 = new HashMap();
                map4.put("filetype", "command_specificparams");
                eVarBuildMultipartUpload.c("fileSpecific", map4, "specific_params.txt", strQ2);
            }
            HashMap map5 = new HashMap();
            map5.put("filetype", str2);
            eVarBuildMultipartUpload.d(map5, file);
            B.b bVarA = eVarBuildMultipartUpload.a();
            if (bVarA != null && bVarA.f171a == 200) {
                Log.d("ApmInsight", U7.a.e(new String[]{"cloud upload success"}));
                return true;
            }
        } catch (Exception unused) {
        }
        Log.d("ApmInsight", U7.a.e(new String[]{"cloud upload failed"}));
        return false;
    }
}
