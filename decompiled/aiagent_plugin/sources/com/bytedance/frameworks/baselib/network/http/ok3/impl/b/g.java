package com.bytedance.frameworks.baselib.network.http.ok3.impl.b;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: DispatchTypedAction.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends k {
    private static final String TAG = "g";
    private f j;

    static {
    }

    public g() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b.k
    public a.EnumC0191a a(m r6, String r7, List<String> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "dispatch action " + this.j.b());
    L5:
        a.EnumC0191a r0 = a.EnumC0191a.f8430a;
        Uri r1 = Uri.parse(r7);
        if (r1.getHost() != null) goto L8;
    L19:
        return r0;
    L8:
        if (a(r1) == false) goto L19;
        if (this.j == null) goto L19;
        r0 = a.EnumC0191a.f8431b;
        if (this.j.b() != f.a.g) goto L15;
        this.j.a(r6);
        r9.set(0, r7);
        return r0;
    L15:
        String r5 = this.j.a(r1);
        if (r7.equals(r5) == true) goto L18;
        r9.set(0, r5);
        goto L19
    L18:
        r9.set(0, r7);
        goto L19
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b.k
    public int e() {
        return this.j.b().ordinal();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b.k
    public boolean a(JSONObject r10, List<Boolean> r11, String r12, long r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        a(r10);
        String r0 = r10.optString("service_name");
        if (TextUtils.isEmpty(r0) == true) goto L5;
        this.h = r0;
    L5:
        int r1 = r10.optInt("dispatch_strategy", 0);
        JSONObject r4 = r10.optJSONObject("strategy_info");
        if (r1 >= 0) goto L8;
    L12:
        this.j = null;
        return false;
    L8:
        if (r1 > 6) goto L12;
        f r15 = f.a(f.a.values()[r1], r4, r12, r13, a());
        this.j = r15;
        r14.set(0, Boolean.valueOf(r15.a()));
        return true;
    }
}
