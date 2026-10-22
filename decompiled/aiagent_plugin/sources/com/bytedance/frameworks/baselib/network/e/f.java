package com.bytedance.frameworks.baselib.network.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: QueryRemoveAction.java */
/* JADX INFO: loaded from: classes.dex */
class f extends c {
    private static final String TAG = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f8084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f8085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8087e;

    static {
    }

    public f(int r1) {
        super(r1);
        this.f8084b = new ArrayList();
        this.f8085c = new ArrayList();
        this.f8086d = false;
        this.f8087e = false;
    }

    @Override // com.bytedance.frameworks.baselib.network.e.c
    public void a(JSONObject r4) {
        b(r4);
        d.a(r4.optJSONArray("keep_list"), this.f8084b);
        d.a(r4.optJSONArray("remove_list"), this.f8085c);
        boolean r1 = false;
        if (r4.optInt("protect_background_request", 0) <= 0) goto L5;
        boolean r0 = true;
    L6:
        this.f8070a = r0;
        if (r4.optInt("add_background_rm_mark", 0) <= 0) goto L9;
        r1 = true;
    L9:
        this.f8087e = r1;
        if (this.f8084b.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.f8085c.isEmpty() == true) goto L16;
        this.f8086d = true;
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.frameworks.baselib.network.e.c
    public boolean a(com.bytedance.retrofit2.b.c r5, Map<String, List<String>> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (this.f8086d == false) goto L5;
    L44:
        return false;
    L5:
        if (a(r5) == false) goto L44;
        if (r7.isEmpty() == false) goto L11;
        return false;
    L11:
        if (this.f8084b.isEmpty() == true) goto L23;
        LinkedHashMap r8 = new LinkedHashMap();
        if (r7.containsKey("x-tt-encrypt-queries") == false) goto L15;
        r8.put("x-tt-encrypt-queries", (List) ZeusTransformUtils.preCheckCast(r7.get("x-tt-encrypt-queries"), List.class, "com.obric.aiagent.plugin"));
    L15:
        Iterator<String> r4 = this.f8084b.iterator();
    L17:
        if (r4.hasNext() == false) goto L21;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");
        if (r7.containsKey(r0) == false) goto L17;
        r8.put(r0, (List) ZeusTransformUtils.preCheckCast(r7.get(r0), List.class, "com.obric.aiagent.plugin"));
        goto L17
    L21:
        r7.clear();
        r7.putAll(r8);
        return true;
    L23:
        if (this.f8085c.isEmpty() == true) goto L55;
        Iterator<String> r1 = this.f8085c.iterator();
    L26:
        if (r1.hasNext() == false) goto L29;
        r7.remove((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin"));
        goto L26
    L29:
        if (r5.b() == null) goto L31;
        String r9 = r5.b();
    L33:
        if (this.f8087e == true) goto L35;
        return true;
    L35:
        if (r9.contains("bgrm") == true) goto L57;
        Iterator<String> r10 = this.f8085c.iterator();
    L38:
        if (r10.hasNext() == false) goto L58;
        if (r9.contains((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L38;
        ArrayList r11 = new ArrayList();
        r11.add("1");
        r7.put("bgrm", r11);
        return true;
    L58:
        return true;
    L57:
        return true;
    L31:
        r9 = "";
        goto L33
    L55:
        return true;
    }
}
