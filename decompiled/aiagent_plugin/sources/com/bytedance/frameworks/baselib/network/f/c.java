package com.bytedance.frameworks.baselib.network.f;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTRequestAuditLog.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f8090a;

    /* JADX INFO: compiled from: TTRequestAuditLog.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set<String> f8091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Set<String> f8092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set<String> f8093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f8094d;

        static /* synthetic */ String a(a r0) {
            return r0.f8094d;
        }

        a(String r1) {
            this.f8094d = r1;
        }

        boolean a() {
            if (com.bytedance.common.utility.collection.a.a(this.f8091a) == true) goto L5;
        L9:
            return false;
        L5:
            if (com.bytedance.common.utility.collection.a.a(this.f8092b) == false) goto L9;
            if (com.bytedance.common.utility.collection.a.a(this.f8093c) == false) goto L9;
            return true;
        }
    }

    public c() {
        this.f8090a = new ArrayList();
    }

    void a(a r1) {
        if (r1 == null) goto L5;
        this.f8090a.add(r1);
        return;
    }

    public JSONObject a() {
        if (com.bytedance.common.utility.collection.a.a(this.f8090a) == false) goto L6;
        return null;
    L6:
        JSONObject r1 = new JSONObject();
        Iterator<a> r8 = this.f8090a.iterator();     // Catch: Exception -> L40
    L8:
        if (r8.hasNext() == false) goto L39;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L40
        if (r2 == null) goto L8;
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L40
        if (com.bytedance.common.utility.collection.a.a(r2.f8091a) == true) goto L20;
        JSONArray r4 = new JSONArray();     // Catch: Exception -> L40
        Iterator<String> r5 = r2.f8091a.iterator();     // Catch: Exception -> L40
    L16:
        if (r5.hasNext() == false) goto L18;
        r4.put((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L40
        goto L16
    L18:
        r3.put("rm_header", r4);     // Catch: Exception -> L40
    L20:
        if (com.bytedance.common.utility.collection.a.a(r2.f8092b) == true) goto L27;
        JSONArray r6 = new JSONArray();     // Catch: Exception -> L40
        Iterator<String> r7 = r2.f8092b.iterator();     // Catch: Exception -> L40
    L23:
        if (r7.hasNext() == false) goto L25;
        r6.put((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L40
        goto L23
    L25:
        r3.put("rm_query", r6);     // Catch: Exception -> L40
    L27:
        if (com.bytedance.common.utility.collection.a.a(r2.f8093c) == true) goto L34;
        JSONArray r9 = new JSONArray();     // Catch: Exception -> L40
        Iterator<String> r10 = r2.f8093c.iterator();     // Catch: Exception -> L40
    L30:
        if (r10.hasNext() == false) goto L32;
        r9.put((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L40
        goto L30
    L32:
        r3.put("add_query", r9);     // Catch: Exception -> L40
    L34:
        if (TextUtils.isEmpty(a.a(r2)) == false) goto L36;
        String r11 = "null";
    L37:
        r1.put(r11, r3);     // Catch: Exception -> L40
        goto L8
    L36:
        r11 = a.a(r2);     // Catch: Exception -> L40
    L39:
        return r1;
    }
}
