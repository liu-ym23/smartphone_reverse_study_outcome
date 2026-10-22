package com.bytedance.ttnet;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.i.l;
import com.bytedance.retrofit2.aj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TNCRequestFlagHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements aj.d {
    private static final String TAG = "TNCRequestFlagHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f11433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f11434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f11435c;

    /* JADX INFO: compiled from: TNCRequestFlagHandler.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f11437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final List<String> f11438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final List<String> f11439d;

        a(int r3, int r4, List<String> r5, List<String> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            ArrayList r0 = new ArrayList();
            this.f11438c = r0;
            ArrayList r1 = new ArrayList();
            this.f11439d = r1;
            this.f11436a = r3;
            this.f11437b = r4;
            r0.addAll(r7);
            r1.addAll(r8);
        }
    }

    public f() {
        this.f11434b = new CopyOnWriteArrayList();
        this.f11435c = new AtomicBoolean(false);
    }

    public static f a() {
        if (f11433a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11433a != null) goto L9;
        f11433a = new f();     // Catch: Throwable -> L11
        aj.a(f11433a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f11433a;
    }

    @Override // com.bytedance.retrofit2.aj.d
    public com.bytedance.retrofit2.b.c a(com.bytedance.retrofit2.b.c r8) {
        if (r8 != null) goto L5;
        return r8;
    L5:
        if (ZeusTransformUtils.instanceOf(r8.l(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L12;
        int r0 = ((com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r8.l(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.aiagent.plugin")).E;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "handleFlag commonParamLevelInCtx: " + r0);
    L9:
        if (r0 <= 0) goto L12;
        r8.a(Math.max(r8.j(), r0));
    L12:
        if (this.f11435c.get() == true) goto L14;
        return r8;
    L14:
        Iterator<a> r7 = this.f11434b.iterator();
    L15:
        boolean r2 = true;
        if (r7.hasNext() == false) goto L47;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r7.next(), a.class, "com.obric.aiagent.plugin");
        Iterator<String> r4 = r1.f11438c.iterator();
    L19:
        if (r4.hasNext() == false) goto L23;
        if (l.a(r8.n(), (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L19;
        boolean r5 = true;
    L24:
        if (r5 == false) goto L15;
        List<String> r6 = r1.f11439d;
        if (r6 == null) goto L15;
        Iterator<String> r9 = r6.iterator();
    L31:
        if (r9.hasNext() == false) goto L37;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin");
        if (r8.o() == null) goto L31;
        if (r8.o().startsWith(r10) == false) goto L31;
    L38:
        if (r2 == false) goto L15;
        if (r8.l() != null) goto L44;
        com.bytedance.retrofit2.b.c.a r11 = r8.m();
        r11.a(new com.bytedance.ttnet.d.d());
        r8 = r11.b();
    L44:
        if (ZeusTransformUtils.instanceOf(r8.l(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L15;
        com.bytedance.frameworks.baselib.network.http.c r3 = (com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r8.l(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.aiagent.plugin");
        r3.r |= r1.f11436a;
        r3.m = r1.f11437b | r3.m;
        com.bytedance.retrofit2.b.c.a r12 = r8.m();
        r12.a(r3);
        r8 = r12.b();
        goto L15
    L37:
        r2 = false;
        goto L38
    L23:
        r5 = false;
        goto L24
    L47:
        if (ZeusTransformUtils.instanceOf(r8.l(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L85;
        com.bytedance.frameworks.baselib.network.http.c r13 = (com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r8.l(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.aiagent.plugin");
        if ((r13.m & 2048) <= 0) goto L51;
        boolean r14 = true;
    L53:
        if ((r13.m & 4096) > 0) goto L56;
        r2 = false;
    L56:
        if (r14 == true) goto L58;
        if (r2 == true) goto L58;
        return r8;
    L58:
        com.bytedance.retrofit2.b.c.a r15 = r8.m();
        ArrayList r16 = new ArrayList();
        r16.addAll(r8.c());
        if (r14 == false) goto L61;
        r16.add(new com.bytedance.retrofit2.b.b("x-metasec-bypass-ttnet-features", "1"));
    L61:
        if (r2 == false) goto L63;
        r16.add(new com.bytedance.retrofit2.b.b("x-tt-bypass-dp", "1"));
    L63:
        r15.a(r16);
        return r15.b();
    L51:
        r14 = false;
        goto L53
    L85:
        return r8;
    }

    @Override // com.bytedance.retrofit2.aj.d
    public boolean b(com.bytedance.retrofit2.b.c r3) {
        if (ZeusTransformUtils.instanceOf(r3.l(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L10;
        com.bytedance.frameworks.baselib.network.http.c r2 = (com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r3.l(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.aiagent.plugin");
        if ((r2.m & 1024) <= 0) goto L7;
    L8:
        return true;
    L7:
        if ((r2.m & 2048) > 0) goto L8;
        return false;
    L10:
        return false;
    }

    @Override // com.bytedance.retrofit2.aj.d
    public int c(com.bytedance.retrofit2.b.c r2) {
        if (ZeusTransformUtils.instanceOf(r2.l(), com.bytedance.frameworks.baselib.network.http.c.class) == true) goto L5;
        return -999;
    L5:
        return ((com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r2.l(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.aiagent.plugin")).D;
    }

    @Override // com.bytedance.retrofit2.aj.d
    public boolean d(com.bytedance.retrofit2.b.c r3) {
        if (ZeusTransformUtils.instanceOf(r3.l(), com.bytedance.frameworks.baselib.network.http.c.class) == true) goto L5;
        return false;
    L5:
        if ((((com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r3.l(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.aiagent.plugin")).m & 8192) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void a(JSONObject r14) {
        JSONArray r1 = r14.optJSONArray("request_flag_control");
        if (r1 != null) goto L5;
        return;
    L5:
        this.f11435c.set(false);
        this.f11434b.clear();
        ArrayList r2 = new ArrayList();     // Catch: JSONException -> L38
        int r4 = 0;
    L8:
        if (r4 >= r1.length()) goto L33;
        JSONObject r5 = r1.getJSONObject(r4);     // Catch: JSONException -> L38
        int r6 = r5.optInt("cronet_flags");     // Catch: JSONException -> L38
        int r7 = r5.optInt("ttnet_flags");     // Catch: JSONException -> L38
        JSONArray r8 = r5.optJSONArray("prefix_group");     // Catch: JSONException -> L38
        JSONArray r9 = r5.optJSONArray("host_group");     // Catch: JSONException -> L38
        ArrayList r10 = new ArrayList();     // Catch: JSONException -> L38
        if (r8 == null) goto L16;
        int r11 = 0;
    L14:
        if (r11 >= r8.length()) goto L16;
        r10.add(r8.optString(r11, ""));     // Catch: JSONException -> L38
        r11 = r11 + 1;     // Catch: JSONException -> L38
    L16:
        ArrayList r12 = new ArrayList();     // Catch: JSONException -> L38
        if (r9 == null) goto L22;
        int r13 = 0;
    L20:
        if (r13 >= r9.length()) goto L22;
        r12.add(r9.optString(r13, ""));     // Catch: JSONException -> L38
        r13 = r13 + 1;     // Catch: JSONException -> L38
    L22:
        if (r6 > 0) goto L25;
        if (r7 > 0) goto L25;
    L31:
        r4 = r4 + 1;     // Catch: JSONException -> L38
    L25:
        if (r10.isEmpty() == true) goto L31;
        if (r12.isEmpty() == true) goto L31;
        r2.add(new a(r6, r7, r12, r10));     // Catch: JSONException -> L38
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "paths: " + r10);     // Catch: JSONException -> L38
        Logger.d(TAG, "hosts: " + r12);     // Catch: JSONException -> L38
        Logger.d(TAG, "flag: " + r6);     // Catch: JSONException -> L38
        Logger.d(TAG, "type flag: " + r7);     // Catch: JSONException -> L38
        goto L31
    L33:
        if (r14.optInt("req_flag_ctl_enabled") > 0) goto L35;
        return;
    L35:
        if (r2.size() <= 0) goto L50;
        this.f11434b.addAll(r2);     // Catch: JSONException -> L38
        this.f11435c.set(true);     // Catch: JSONException -> L38
        return;
    L50:
        return;
    }
}
