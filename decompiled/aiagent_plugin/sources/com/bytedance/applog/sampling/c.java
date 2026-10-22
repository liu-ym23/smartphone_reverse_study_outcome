package com.bytedance.applog.sampling;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventSampling.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONArray f5978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONArray f5979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<a> f5980e;

    public c() {
        this.f5980e = new ArrayList();
    }

    public int a() {
        return this.f5976a;
    }

    public void a(int r1) {
        this.f5976a = r1;
    }

    public void b(int r1) {
        this.f5977b = r1;
    }

    public int b() {
        return this.f5977b;
    }

    public void a(JSONArray r1) {
        this.f5979d = r1;
    }

    public JSONArray c() {
        return this.f5979d;
    }

    public void b(JSONArray r1) {
        this.f5978c = r1;
    }

    public JSONArray d() {
        return this.f5978c;
    }

    public void a(int r3, int r4, Set<String> r5, Map<String, List<Set<String>>> r6, Map<String, List<Map<String, Object>>> r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (r4 != 1) goto L5;
        a r11 = new g(r3, r8, r9, r10);
    L18:
        a r12 = r11;
    L19:
        if (r12 == null) goto L22;
        this.f5980e.add(r12);
        return;
    L22:
        return;
    L5:
        if (r4 != 2) goto L7;
        r11 = new e(r3, r8, r9, r10);
        goto L18
    L7:
        if (r4 != 3) goto L9;
        r11 = new f(r3, r8, r9, r10);
        goto L18
    L9:
        if (r4 != 4) goto L11;
        r11 = new h(r3, r8, r9, r10);
        goto L18
    L11:
        if (r4 == 6) goto L13;
        r12 = null;
        goto L19
    L13:
        r11 = new i(r3, r8, r9, r10);
        goto L18
    }

    public boolean a(b r4, String r5, String r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        Iterator<a> r3 = this.f5980e.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin");
        if (r0.a(r5, r6) == false) goto L4;
        return r0.a(r7);
    L9:
        return false;
    }

    public boolean a(b r4, String r5, JSONObject r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        Iterator<a> r3 = this.f5980e.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin");
        if (r0.a(r5, r6) == false) goto L4;
        return r0.a(r7);
    L9:
        return false;
    }

    public boolean b(b r5, String r6, JSONObject r7) {
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        Iterator<a> r4 = this.f5980e.iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.aiagent.plugin");
        if (r0.a(r6, r7) == false) goto L4;
        if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L11;
        return false;
    L11:
        return r0.a(r8);
    L12:
        return false;
    }

    public boolean e() {
        return !this.f5980e.isEmpty();
    }
}
