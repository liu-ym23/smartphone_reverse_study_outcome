package com.bytedance.frameworks.baselib.network.http.ok3.impl.b;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: StaticDispatchStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends f {
    private static final String TAG = "i";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f8456a;

    static {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b.f
    public void a(m r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b.f
    public boolean a() {
        return false;
    }

    public i(JSONObject r5) {
        super(f.a.f8451b);
        this.f8456a = new HashMap();
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
        this.f8456a.put(r1, r2);
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b.f
    public String a(Uri r5) {
        String r0 = r5.getHost();
        String r6 = r5.toString();
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.f8456a.get(r0), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r6;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "replace host " + r4 + " for " + r0);
    L8:
        return r6.replaceFirst(r0, r4);
    }
}
