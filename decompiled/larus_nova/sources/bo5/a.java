package bo5;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.templates.dependency.TemplateCreateResult;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<TemplateCreateResult> {
    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L32;
        JSONObject r102 = new JSONObject(r100);     // Catch: Throwable -> L27
        JSONObject r103 = r102.optJSONObject("data");     // Catch: Throwable -> L27
        String r104 = "0";
        if (r103 == null) goto L16;
        String r105 = r103.optString("obj_template_token");     // Catch: Throwable -> L27
        if (r105 == null) goto L16;
    L17:
        if (r103 == null) goto L22;
        String r106 = r103.optString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID);     // Catch: Throwable -> L27
        if (r106 == null) goto L22;
        r104 = r106;
    L22:
        if (r103 == null) goto L24;
        int r107 = r103.optInt("obj_type");     // Catch: Throwable -> L27
    L25:
        TemplateCreateResult r108 = new TemplateCreateResult(r105, r107, r104);     // Catch: Throwable -> L27
        r108.code = r102.optInt("code");     // Catch: Throwable -> L27
        r108.msg = r102.optString("msg");     // Catch: Throwable -> L27
        return r108;
    L24:
        r107 = 0;
    L16:
        r105 = "0";
    L27:
        th = move-exception;
        tt5.a.e("TemplateCreateParser", "parse()...err", th, false);
        return new TemplateCreateResult();
    L32:
        return new TemplateCreateResult();
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }
}
