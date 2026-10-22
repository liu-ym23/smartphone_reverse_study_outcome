package com.bytedance.frameworks.baselib.network.http.ok3.impl.b;

import android.net.Uri;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: RequestHeaderDispatchStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends f {
    private static final String TAG = "h";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f8455a;

    static {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b.f
    public boolean a() {
        return false;
    }

    public h(JSONObject r5) {
        super(f.a.g);
        this.f8455a = new HashMap();
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = r5.keys();
    L7:
        if (r0.hasNext() == false) goto L13;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        String r2 = r5.optString(r1);
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.f8455a.put(r1, r2);
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b.f
    public String a(Uri r1) {
        return r1.toString();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b.f
    public void a(m r7) {
        if (r7.d() == null) goto L8;
        Iterator<Map.Entry<String, String>> r6 = this.f8455a.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r7.d().add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L6
    L10:
        return;
    }
}
