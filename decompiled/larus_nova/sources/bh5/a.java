package bh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.EmailInfoResult;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<EmailInfoResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19033a;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "email");
        this.f19033a = r100;
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        JSONObject r101 = new JSONObject(r100).optJSONObject("data");
        if (r101 == null) goto L10;
        JSONObject r102 = r101.optJSONObject("email_info");
        if (r102 == null) goto L10;
        String r103 = r102.optString(this.f19033a);
    L11:
        EmailInfoResult r104 = new EmailInfoResult();
        r104.setData(r103);
        return r104;
    L10:
        r103 = null;
        goto L11
    }
}
