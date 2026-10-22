package com.bytedance.bdinstall.d;

import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: CustomLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final an f6216e;

    h(an r3) {
        super(false, true);
        this.f6216e = r3;
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r5) {
        Map<String, Object> r4 = this.f6216e.t();
        if (r4 == null) goto L26;
    L14:
        e = move-exception;
        e.printStackTrace();
        return true;
    L5:
        if (r4.isEmpty() == true) goto L27;
        Iterator<Map.Entry<String, Object>> r6 = r4.entrySet().iterator();     // Catch: Exception -> L14
    L8:
        if (r6.hasNext() == false) goto L28;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        if (r1 == null) goto L8;
        r5.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), r1.getValue());     // Catch: Exception -> L14
        goto L8
    L28:
        return true;
    L27:
        return true;
    L26:
        return true;
    }
}
