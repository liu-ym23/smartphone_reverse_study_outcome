package com.bytedance.ttnet.g;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ModeNormalDelay.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends i.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f11445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, Integer> f11446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<String> f11447e;
    private int f;

    public b() {
        this.f11445c = new f();
        this.f11446d = new ConcurrentHashMap();
        this.f11447e = new CopyOnWriteArraySet();
        this.f = 1000;
    }

    @Override // com.bytedance.retrofit2.f.a
    public void a(com.bytedance.retrofit2.b.c r8) {
        long r5 = d(r8);
        if (Logger.debug() == false) goto L5;
        Logger.d("ModeNormalDelay", "get normal delay time " + r5 + " " + r8.o());
    L5:
        this.f11483a.a(r8, false, true, r5);
    }

    @Override // com.bytedance.retrofit2.f.a
    public boolean a(com.bytedance.retrofit2.b.c r10, Executor r11, Runnable r12) {
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r11, Executor.class, "com.obric.aiagent.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r12, Runnable.class, "com.obric.aiagent.plugin");
        long r5 = d(r10);
        if (Logger.debug() == false) goto L6;
        Logger.d("ModeNormalDelay", "get normal delay time " + r5 + " " + r10.o());
    L6:
        return this.f11483a.a(r10, false, r5, r7, r8);
    }

    private int d(com.bytedance.retrofit2.b.c r3) {
        this.f11445c.a(r3);
        if (this.f11446d.isEmpty() == true) goto L9;
        Integer r2 = i.a(this.f11446d, r3.o());
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.intValue();
    L9:
        if (this.f11447e.isEmpty() == false) goto L11;
        return -1;
    L11:
        if (i.a(this.f11447e, r3.o()) == false) goto L13;
        return 0;
    L13:
        return this.f;
    }

    @Override // com.bytedance.ttnet.g.i.a
    public boolean a(JSONObject r6) {
        super.a(r6);
        if (r6.isNull("bl_with_delay_ms") == true) goto L5;
    L7:
        this.f11445c.a(r6);
        this.f11483a.a(r6, this.f11484b);
        JSONObject r0 = r6.optJSONObject("bl_with_delay_ms");
        if (r0 == null) goto L13;
        Iterator<String> r7 = r0.keys();
    L11:
        if (r7.hasNext() == false) goto L24;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        this.f11446d.put(r1, Integer.valueOf(r0.optInt(r1)));
    L24:
        if (this.f11445c.a() == false) goto L26;
    L29:
        return true;
    L26:
        if (this.f11446d.isEmpty() == false) goto L29;
        if (this.f11447e.isEmpty() == false) goto L29;
        return false;
    L13:
        JSONArray r2 = r6.optJSONArray("wl");
        if (r2 == null) goto L22;
        int r3 = 0;
    L17:
        if (r3 >= r2.length()) goto L22;
        String r4 = r2.optString(r3);
        if (TextUtils.isEmpty(r4) == true) goto L21;
        this.f11447e.add(r4);
    L21:
        r3 = r3 + 1;
    L22:
        this.f = r6.optInt("delay_time_ms", 1000);
        goto L24
    L5:
        if (r6.isNull("wl") == false) goto L7;
        return false;
    }

    @Override // com.bytedance.ttnet.g.i.a
    public void b() {
        super.b();
        this.f11483a.a();
    }

    @Override // com.bytedance.ttnet.g.i.a
    i.b c() {
        return i.b.f11490b;
    }
}
