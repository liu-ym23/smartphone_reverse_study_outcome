package bi5;

import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static String b() {
        String r100 = "";
        String r101 = (String) c.a.f206237a.d("biz_domain_config", "");
        if (TextUtils.isEmpty(r101) == true) goto L10;
        r100 = new JSONObject(r101).optJSONArray("scs_data").optString(0);     // Catch: Throwable -> L6
        tt5.a.h("RetentionLabelExecutor", "getRetentionHost()...result = " + r100);     // Catch: Throwable -> L6
        return r100;
    L6:
        tt5.a.d("RetentionLabelExecutor", "parse retentionHost error,  domainConfigStr = " + r101);
        return r100;
    L10:
        return "";
    }

    public static String a(int r100) {
        if (r100 != e.f541296g.f541317b) goto L7;
        return PreloadConfigModel.VERSION_CHECK_TYPE_DOC;
    L7:
        if (r100 != e.f541297h.f541317b) goto L11;
        return "SHEET";
    L11:
        if (r100 != e.f541298i.f541317b) goto L15;
        return "BITABLE";
    L15:
        if (r100 != e.f541300k.f541317b) goto L19;
        return PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE;
    L19:
        if (r100 != e.f541301l.f541317b) goto L23;
        return "FILE";
    L23:
        if (r100 != e.f541304o.f541317b) goto L27;
        return PreloadConfigModel.VERSION_CHECK_TYPE_DOCX;
    L27:
        if (r100 != e.f541302m.f541317b) goto L31;
        return "SLIDES";
    L31:
        if (r100 != e.f541307r.f541317b) goto L35;
        return "BITABLE_SHARE_FORM";
    L35:
        if (r100 != e.f541309t.f541317b) goto L39;
        return "CREATIVITY_MIAODA";
    L39:
        if (r100 != e.f541310u.f541317b) goto L42;
        return "CREATIVITY_MIAODA_APP_DEVELOPMENT";
    L42:
        tt5.a.d("RetentionLabelExecutor", "getEntityTypeByType()...illegal type, type = " + r100);
        return "";
    }
}
