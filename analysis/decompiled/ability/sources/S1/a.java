package S1;

import B.e;
import H.h;
import J9.k;
import S0.b;
import a.AbstractC0291a;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.services.apm.api.IHttpService;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class a {
    static {
        new ArrayList();
    }

    public static void a(k kVar) {
        if (AbstractC0291a.c) {
            AbstractC0291a.m("uploadInfo=" + kVar);
        }
        if (TextUtils.isEmpty((String) kVar.d)) {
            return;
        }
        String str = U1.a.f1265a;
        int i = kVar.b;
        String str2 = (String) kVar.d;
        String str3 = (String) kVar.e;
        long j5 = kVar.c;
        HashMap map = (HashMap) kVar.f;
        if (!h.f719x) {
            if (h.b) {
                Log.d("ApmInsight", U7.a.e(new String[]{"can not report,cloud message post with file return"}));
                return;
            }
            return;
        }
        HashMap map2 = new HashMap();
        if (!TextUtils.isEmpty(h.f718w)) {
            map2.put("aid", h.a());
            map2.put("x-auth-token", h.f718w);
        }
        try {
            e eVarBuildMultipartUpload = ((IHttpService) L2.a.a(IHttpService.class)).buildMultipartUpload(str, "UTF-8", map2, false);
            eVarBuildMultipartUpload.a("status", String.valueOf(i));
            eVarBuildMultipartUpload.a("cid", str2);
            eVarBuildMultipartUpload.a("err_msg", str3);
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
            eVarBuildMultipartUpload.a();
        } catch (Exception unused) {
        }
    }
}
