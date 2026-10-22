package com.bytedance.bdturing.verify.a;

import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: SmarterVerifyRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f6661b;

    @Override // com.bytedance.bdturing.verify.a.a
    public int g() {
        return BdTuringConfig.DEFAULT_EVENT_COUNT;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public int getType() {
        return 5;
    }

    public final JSONObject i() {
        return this.f6661b;
    }

    public l(String r2, JSONObject r3) {
        d.h.b.o.d(r2, WsConstants.KEY_SERVICE);
        this.f6660a = r2;
        this.f6661b = r3;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public String f() {
        return this.f6660a;
    }

    @Override // com.bytedance.bdturing.verify.a.a
    public void a(StringBuilder r2) {
        d.h.b.o.d(r2, "queryBuilder");
        com.bytedance.bdturing.utils.d.a(r2, "use_dialog_size_v2", com.bytedance.bdturing.setting.h.f6610a.c());
    }
}
