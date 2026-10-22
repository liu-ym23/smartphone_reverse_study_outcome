package com.bytedance.frameworks.baselib.network.e;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: QueryEncryptAction.java */
/* JADX INFO: loaded from: classes.dex */
class b extends c {
    private static final String TAG = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f8067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8069d;

    static {
    }

    public b(int r1) {
        super(r1);
        this.f8067b = new ArrayList();
        this.f8068c = false;
        this.f8069d = false;
    }

    @Override // com.bytedance.frameworks.baselib.network.e.c
    public void a(JSONObject r3) {
        b(r3);
        d.a(r3.optJSONArray("encrypt_query_list"), this.f8067b);
        boolean r1 = false;
        if (r3.optInt("encrypt_body_enabled", 0) <= 0) goto L5;
        r1 = true;
    L5:
        this.f8069d = r1;
        if (this.f8067b.isEmpty() == true) goto L8;
        return;
    L8:
        if (this.f8069d == true) goto L12;
        this.f8068c = true;
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.e.c
    public boolean a(com.bytedance.retrofit2.b.c r11, Map<String, List<String>> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (this.f8068c == false) goto L5;
    L48:
        return r2;
    L5:
        if (a(r11) == false) goto L48;
        if (this.f8069d == false) goto L11;
        r11.b(true);
        r2 = true;
    L11:
        if (r13.isEmpty() == false) goto L14;
        return r2;
    L14:
        if (this.f8067b.isEmpty() == true) goto L48;
        if (r13.containsKey("x-tt-encrypt-queries") == true) goto L48;
        LinkedList r4 = new LinkedList();
        Iterator<String> r5 = this.f8067b.iterator();
    L20:
        if (r5.hasNext() == false) goto L25;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        if (r13.containsKey(r6) == false) goto L20;
        r4.add(new Pair(r6, (List) ZeusTransformUtils.preCheckCast(r13.get(r6), List.class, "com.obric.aiagent.plugin")));
        goto L20
    L25:
        if (r4.isEmpty() == false) goto L27;
        return r2;
    L27:
        String r7 = a(r4);
        if (TextUtils.isEmpty(r7) == false) goto L30;
        return r2;
    L30:
        byte[] r8 = null;
        r8 = r7.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L33
    L35:
        if (r8 != null) goto L37;
        return r2;
    L37:
        byte[] r9 = EncryptorUtil.a(r8, r8.length);
        if (r9 != null) goto L40;
        return r2;
    L40:
        String r3 = Base64.encodeToString(r9, 2);
        if (Logger.debug() == false) goto L43;
        Logger.d(TAG, "encryptBytes:" + r9 + " , encryptString:" + r3);
    L43:
        LinkedList r10 = new LinkedList();
        r10.add(r3);
        r11.a(true);
        r13.put("x-tt-encrypt-queries", r10);
        Iterator<String> r14 = this.f8067b.iterator();
    L45:
        if (r14.hasNext() == false) goto L47;
        r13.remove((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin"));
        goto L45
    L47:
        return true;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    }

    private static String a(List<Pair<String, List<String>>> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder();
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L17;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2.second, List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L4;
        if (r4.size() <= 0) goto L4;
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L4;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        if (r0.length() <= 0) goto L15;
        r0.append("&");
    L15:
        r0.append(r3);
        r0.append("=");
        r0.append(r9);
        goto L11
    L17:
        return r0.toString();
    }
}
