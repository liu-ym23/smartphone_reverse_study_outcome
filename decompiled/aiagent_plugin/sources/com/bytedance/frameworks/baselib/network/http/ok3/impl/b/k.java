package com.bytedance.frameworks.baselib.network.http.ok3.impl.b;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: URLDispatchAction.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends a {
    private static final String TAG = "k";
    private boolean j;

    static {
    }

    public abstract a.EnumC0191a a(m r1, String r2, List<String> r3);

    public abstract boolean a(JSONObject r1, List<Boolean> r2, String r3, long r4);

    public abstract int e();

    public int f() {
        return -555;
    }

    public k() {
        this.j = false;
    }

    public a.EnumC0191a a(m r6, String r7, List<String> r8, List<d> r9) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if (a(r6) == true) goto L5;
    L15:
        r10.set(0, r7);
        return a.EnumC0191a.f8430a;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L15;
        a.EnumC0191a r12 = a(r6, r7, r10);
        d r0 = new d();
        if (r12 == a.EnumC0191a.f8430a) goto L13;
        r0.f8442d = true;
        r0.f8440b = b();
        r0.f8441c = a();
        r0.f8443e = e();
        r0.f8439a = c();
        if (r12 != a.EnumC0191a.f8431b) goto L12;
        r0.g = (String) ZeusTransformUtils.preCheckCast(r10.get(0), String.class, "com.obric.aiagent.plugin");
        r0.f = g();
    L12:
        r6.a(this.i);
    L13:
        r11.add(r0);
        return r12;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a
    public boolean a(JSONObject r9, String r10, long r11) {
        ArrayList r6 = new ArrayList();
        r6.add(0, false);
        boolean r12 = a(r9, r6, r10, r11);
        this.j = ((Boolean) ZeusTransformUtils.preCheckCast(r6.get(0), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        return r12;
    }

    public boolean g() {
        return this.j;
    }
}
