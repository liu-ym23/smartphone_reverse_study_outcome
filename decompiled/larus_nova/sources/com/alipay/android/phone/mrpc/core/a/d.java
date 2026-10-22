package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.alipay.sdk.m.u.l;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class d extends a {
    public d(Type r100, byte[] r101) {
        super(r100, r101);
    }

    @Override // com.alipay.android.phone.mrpc.core.a.c
    public final Object a() {
        String r100 = new String(this.f24996b);     // Catch: Exception -> L12
        ThreadMethodProxy.currentThread().getId();     // Catch: Exception -> L12
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L12
        int r102 = JSONObjectProtectorUtils.getInt(r101, l.f25863a);     // Catch: Exception -> L12
        if (r102 != 1000) goto L11;
        if (this.f24995a != String.class) goto L9;
        return r101.optString("result");
    L9:
        return com.alipay.sdk.m.e.e.a(r101.optString("result"), this.f24995a);
    L11:
        throw new RpcException(Integer.valueOf(r102), r101.optString("tips"));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        if (("response  =" + new String(this.f24996b) + ":" + e) != null) goto L16;
        String r103 = "";
    L18:
        throw new RpcException(10, r103);
    L16:
        r103 = e.getMessage();
        goto L18
    }
}
