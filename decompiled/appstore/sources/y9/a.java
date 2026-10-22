package y9;

import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.monitor.cloudmessage.callback.IABTestConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends x9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IABTestConsumer f26162b;

    public a() {
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.ABTEST;
    }

    @Override // x9.a
    public boolean e(w9.a r10) {
        JSONObject r11 = new JSONObject(r10.c());
        if (this.f26162b != null) goto L6;
        return false;
    L6:
        if (c(r11, r10) == false) goto L8;
        return true;
    L8:
        String r12 = r11.optString("field");
        if (TextUtils.isEmpty(r12) == false) goto L11;
        return false;
    L11:
        Object r13 = r11.get(CommonKey.KEY_VALUE);
        this.f26162b.notifyABTestModelUpdate(r12, r13);
        if (this.f26162b.isUpdateABTestInfoInSP() == false) goto L14;
        String r14 = r11.optString("spKey");
        this.f26162b.notifyABTestSPUpdate(r14, r13);
    L14:
        w9.b r15 = this.f26162b.getConsumerResult();
        if (r15.d() == false) goto L17;
        j(r10);
    L18:
        return true;
    L17:
        h(r15.b(), r15.c(), r10);
        goto L18
    }

    public void k(IABTestConsumer r10) {
        this.f26162b = r10;
    }
}
