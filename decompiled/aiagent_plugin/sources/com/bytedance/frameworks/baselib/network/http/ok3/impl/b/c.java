package com.bytedance.frameworks.baselib.network.http.ok3.impl.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DelayTypedAction.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    private static final String TAG = "c";
    private int j;
    private int k;
    private int l;
    private final Map<String, Set<String>> m;

    static {
    }

    public c() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = new HashMap();
    }

    public a.EnumC0191a a(String r3, String r4, List<Integer> r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "take delay action");
    L6:
        if (d() == true) goto L8;
    L12:
        r6.set(0, 0);
        return a.EnumC0191a.f8430a;
    L8:
        if (TextUtils.isEmpty(r3) == true) goto L12;
        return b(r3, r4, r6);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a
    public boolean a(JSONObject r8, String r9, long r10) {
        a(r8);
        String r11 = r8.optString("tag");
        int r12 = 0;
        if (TextUtils.isEmpty(r11) == true) goto L17;
        String[] r13 = r11.split(";");
        int r14 = r13.length;
        int r0 = 0;
    L5:
        if (r0 >= r14) goto L17;
        String r1 = r13[r0];
        ArrayList r2 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.i.g.a(r1, ",", "=", r2) == false) goto L16;
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r3.next(), Pair.class, "com.obric.aiagent.plugin");
        Set<String> r5 = (Set) ZeusTransformUtils.preCheckCast(this.m.get(r4.first), Set.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L15;
        r5 = new HashSet();
    L15:
        r5.add((String) ZeusTransformUtils.preCheckCast(r4.second, String.class, "com.obric.aiagent.plugin"));
        this.m.put((String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.aiagent.plugin"), r5);
    L16:
        r0 = r0 + 1;
    L17:
        this.j = r8.optInt("delay");
        JSONArray r15 = r8.optJSONArray("random");
        if (this.j > 0) goto L37;
        if (r15 == null) goto L37;
        if (r15.length() == 2) goto L44;
        return false;
    L44:
        int r16 = r15.getInt(0);     // Catch: JSONException -> L28
        int r17 = r15.getInt(1);     // Catch: JSONException -> L26
    L31:
        if (r16 <= 0) goto L36;
        if (r17 <= 0) goto L36;
        if (r16 >= r17) goto L36;
        r12 = r16;
    L38:
        this.k = r12;
        this.l = r17;
        if (Logger.debug() == false) goto L41;
        Logger.d(TAG, "initwithparam tnc tag map is " + this.m);
    L41:
        return true;
    L36:
        return false;
    L26:
        e = e;
    L30:
        e.printStackTrace();
        r17 = 0;
    L28:
        e = e;
        r16 = 0;
    L37:
        r17 = 0;
        goto L38
    }

    /* JADX WARN: Multi-variable type inference failed */
    private a.EnumC0191a b(String r7, String r8, List<Integer> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Uri r11 = Uri.parse(r7);
        if (r11.getHost() == null) goto L59;
        if (a(r11) == false) goto L59;
        if (this.m.isEmpty() == false) goto L15;
        r10.set(0, Integer.valueOf(e()));
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "tnc tag map is empty, result delay time is " + r10.get(0));
    L13:
        return a.EnumC0191a.f8433d;
    L15:
        if (com.bytedance.frameworks.baselib.network.b.c() == true) goto L22;
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "this action with tag is not enabled");
    L20:
        return a.EnumC0191a.f8430a;
    L22:
        if ("".equals(r8) == false) goto L24;
        r8 = "s=0;p=0";
    L24:
        HashMap r12 = new HashMap();
        ArrayList r2 = new ArrayList();
        if (com.bytedance.frameworks.baselib.network.http.i.g.a(r8, ";", "=", r2) == false) goto L27;
        Iterator r3 = r2.iterator();
    L30:
        if (r3.hasNext() == false) goto L32;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r3.next(), Pair.class, "com.obric.aiagent.plugin");
        r12.put((String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.second, String.class, "com.obric.aiagent.plugin"));
        goto L30
    L32:
        String r5 = Integer.toString(com.bytedance.frameworks.baselib.network.b.a.f7972a.a());
        if (com.bytedance.frameworks.baselib.network.b.b() == com.bytedance.frameworks.baselib.network.b.a.f7972a) goto L35;
        r5 = Integer.toString(com.bytedance.frameworks.baselib.network.b.a().a());
    L35:
        r12.put("s", r5);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(l.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L38;
        boolean r13 = com.bytedance.frameworks.baselib.network.http.i.h.b(r6);
    L39:
        r12.put("p", Integer.toString(!r13));
        if (Logger.debug() == false) goto L42;
        Logger.d(TAG, "request tag string is " + r8);
    L42:
        a.EnumC0191a r14 = a.EnumC0191a.f8433d;
        Iterator<Map.Entry<String, Set<String>>> r15 = this.m.entrySet().iterator();
    L44:
        if (r15.hasNext() == false) goto L52;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r12.get(r16.getKey()), String.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L47;
        if (((Set) ZeusTransformUtils.preCheckCast(r16.getValue(), Set.class, "com.obric.aiagent.plugin")).contains(r17) == true) goto L44;
        r14 = a.EnumC0191a.f8430a;
        goto L52
    L47:
        r14 = a.EnumC0191a.f8430a;
    L52:
        if (r14 != a.EnumC0191a.f8433d) goto L55;
        r10.set(0, Integer.valueOf(e()));
    L55:
        if (Logger.debug() == false) goto L57;
        String r1 = TAG;
        Logger.d(r1, "match tag result is " + r14);
        Logger.d(r1, "will delay time is " + r10.get(0));
        Logger.d(r1, "request tag map is " + r12);
        Logger.d(r1, "tnc tag map is " + this.m);
    L57:
        return r14;
    L38:
        r13 = 1;
        goto L39
    L27:
        return a.EnumC0191a.f8430a;
    L59:
        return a.EnumC0191a.f8430a;
    }

    private int e() {
        int r0 = this.j;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        if (this.k < this.l) goto L8;
        return 0;
    L8:
        return new Random().nextInt(this.l - this.k) + this.k;
    }
}
