package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends f {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f7478q = "c";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DispatchStrategy f7479p;

    static {
    }

    public c() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.f
    public BaseDispatchAction.DispatchResultEnum q(String r10, List r11) {
        Logger.d(f7478q, "dispatch action " + this.f7479p.b());
        BaseDispatchAction.DispatchResultEnum r12 = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        Uri r13 = Uri.parse(r10);
        if (r13.getHost() != null) goto L5;
    L12:
        return r12;
    L5:
        if (i(r13) == false) goto L12;
        DispatchStrategy r14 = this.f7479p;
        if (r14 == null) goto L12;
        r12 = BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
        String r15 = r14.c(r13);
        if (r10.equals(r15) == true) goto L11;
        r11.set(0, r15);
        goto L12
    L11:
        r11.set(0, r10);
        goto L12
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.f
    public int r() {
        return this.f7479p.b().ordinal();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.f
    public boolean s(JSONObject r10, List r11, String r12, long r13) {
        j(r10);
        String r14 = r10.optString("service_name");
        if (TextUtils.isEmpty(r14) == true) goto L5;
        this.f7467k = r14;
    L5:
        int r15 = r10.optInt("dispatch_strategy", 0);
        JSONObject r16 = r10.optJSONObject("strategy_info");
        if (r15 >= 0) goto L8;
    L12:
        this.f7479p = null;
        return false;
    L8:
        if (r15 > 5) goto L12;
        DispatchStrategy r17 = DispatchStrategy.a(DispatchStrategy.DispatchStrategyType.values()[r15], r16, r12, r13, b());
        this.f7479p = r17;
        r11.set(0, Boolean.valueOf(r17.d()));
        return true;
    }
}
