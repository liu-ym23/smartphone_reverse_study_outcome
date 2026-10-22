package com.obric.autogui.resourcemanage;

import com.bytedance.crypto.platform.PlatformConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ResourceRequestParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f30686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f30687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f30688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f30689e;
    private final int f;
    private final List<Integer> g;
    private final Map<String, String> h;
    private final int i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;

    public static /* synthetic */ v a(v r14, String r15, int r16, int r17, String r18, int r19, int r20, List r21, Map r22, int r23, String r24, String r25, String r26, String r27, int r28, Object r29) {
        List<Integer> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        if ((r28 & 1) == 0) goto L5;
        String r4 = r14.f30685a;
    L7:
        if ((r28 & 2) == 0) goto L9;
        int r5 = r14.f30686b;
    L11:
        if ((r28 & 4) == 0) goto L13;
        int r6 = r14.f30687c;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r7 = r14.f30688d;
    L19:
        if ((r28 & 16) == 0) goto L21;
        int r8 = r14.f30689e;
    L23:
        if ((r28 & 32) == 0) goto L25;
        int r9 = r14.f;
    L27:
        if ((r28 & 64) == 0) goto L30;
        r2 = r14.g;
    L30:
        if ((r28 & 128) == 0) goto L33;
        r3 = r14.h;
    L33:
        if ((r28 & 256) == 0) goto L35;
        int r10 = r14.i;
    L37:
        if ((r28 & 512) == 0) goto L39;
        String r11 = r14.j;
    L41:
        if ((r28 & 1024) == 0) goto L43;
        String r12 = r14.k;
    L45:
        if ((r28 & 2048) == 0) goto L47;
        String r13 = r14.l;
    L49:
        if ((r28 & 4096) == 0) goto L51;
        String r1 = r14.m;
    L53:
        return r14.a(r4, r5, r6, r7, r8, r9, r2, r3, r10, r11, r12, r13, r1);
    L51:
        r1 = r27;
        goto L53
    L47:
        r13 = r26;
        goto L49
    L43:
        r12 = r25;
        goto L45
    L39:
        r11 = r24;
        goto L41
    L35:
        r10 = r23;
        goto L37
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r19;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }

    public final v a(String r17, int r18, int r19, String r20, int r21, int r22, List<Integer> r23, Map<String, String> r24, int r25, String r26, String r27, String r28, String r29) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r17, "sdkPkg");
        d.h.b.o.e(r20, "latestMd5");
        d.h.b.o.e(r9, "disabledSdkVerList");
        d.h.b.o.e(r10, "customTag");
        d.h.b.o.e(r26, "appPkg");
        d.h.b.o.e(r27, PlatformConst.BUNDLE_KEY_BRAND);
        d.h.b.o.e(r28, "model");
        d.h.b.o.e(r29, "hostAbi");
        return new v(r17, r18, r19, r20, r21, r22, r9, r10, r25, r26, r27, r28, r29);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, v.class) == true) goto L8;
        return false;
    L8:
        v r6 = (v) ZeusTransformUtils.preCheckCast(r5, v.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f30685a, r6.f30685a) == true) goto L12;
        return false;
    L12:
        if (this.f30686b == r6.f30686b) goto L15;
        return false;
    L15:
        if (this.f30687c == r6.f30687c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f30688d, r6.f30688d) == true) goto L21;
        return false;
    L21:
        if (this.f30689e == r6.f30689e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (d.h.b.o.a(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (d.h.b.o.a(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.f30685a.hashCode() * 31) + Integer.hashCode(this.f30686b)) * 31) + Integer.hashCode(this.f30687c)) * 31) + this.f30688d.hashCode()) * 31) + Integer.hashCode(this.f30689e)) * 31) + Integer.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + Integer.hashCode(this.i)) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ResourceRequestParams(sdkPkg=").append(this.f30685a).append(", sdkVer=").append(this.f30686b).append(", apiVer=").append(this.f30687c).append(", latestMd5=").append(this.f30688d).append(", minSdkVer=").append(this.f30689e).append(", maxSdkVer=").append(this.f).append(", disabledSdkVerList=").append(this.g).append(", customTag=").append(this.h).append(", osVer=").append(this.i).append(", appPkg=").append(this.j).append(", brand=").append(this.k).append(", model=");
        r0.append(this.l).append(", hostAbi=").append(this.m).append(')');
        return r0.toString();
    }

    public v(String r3, int r4, int r5, String r6, int r7, int r8, List<Integer> r9, Map<String, String> r10, int r11, String r12, String r13, String r14, String r15) {
        List<Integer> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r17 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "sdkPkg");
        d.h.b.o.e(r6, "latestMd5");
        d.h.b.o.e(r16, "disabledSdkVerList");
        d.h.b.o.e(r17, "customTag");
        d.h.b.o.e(r12, "appPkg");
        d.h.b.o.e(r13, PlatformConst.BUNDLE_KEY_BRAND);
        d.h.b.o.e(r14, "model");
        d.h.b.o.e(r15, "hostAbi");
        this.f30685a = r3;
        this.f30686b = r4;
        this.f30687c = r5;
        this.f30688d = r6;
        this.f30689e = r7;
        this.f = r8;
        this.g = r16;
        this.h = r17;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
    }

    public final String a() {
        return this.f30685a;
    }

    public final String b() {
        return this.f30685a + '#' + this.j;
    }

    public final String c() {
        JSONObject r0 = new JSONObject();
        r0.put("sdk_pkg", this.f30685a);
        r0.put("sdk_ver", this.f30686b);
        r0.put("api_ver", this.f30687c);
        r0.put("latest_md5", this.f30688d);
        r0.put("min_sdk_ver", this.f30689e);
        r0.put("max_sdk_ver", this.f);
        JSONArray r1 = new JSONArray();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.put(((Number) ZeusTransformUtils.preCheckCast(r2.next(), Number.class, "com.obric.aiagent.plugin")).intValue());
        goto L4
    L6:
        r0.put("disabled_sdk_ver_list", r1);
        JSONObject r3 = new JSONObject();
        Iterator<Map.Entry<String, String>> r4 = this.h.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r3.put((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r5.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L8
    L10:
        r0.put("custom_tag", r3);
        r0.put("os_ver", this.i);
        r0.put("app_pkg", this.j);
        r0.put(PlatformConst.BUNDLE_KEY_BRAND, this.k);
        r0.put("model", this.l);
        r0.put("host_abi", this.m);
        String r7 = r0.toString();
        d.h.b.o.c(r7, "toString(...)");
        return r7;
    }
}
