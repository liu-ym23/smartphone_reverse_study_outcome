package com.bytedance.bdturing.ttnet;

import android.text.TextUtils;
import com.bytedance.retrofit2.ak;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: compiled from: BdTuringInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.retrofit2.d.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f6615b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f6616a;

    public static a a() {
        if (f6615b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6615b != null) goto L9;
        f6615b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f6615b;
    }

    private a() {
    }

    @Override // com.bytedance.retrofit2.d.b
    public ak a(com.bytedance.retrofit2.d.b.a r8) {
        com.bytedance.retrofit2.d.b.a r9 = (com.bytedance.retrofit2.d.b.a) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.retrofit2.d.b.a.class, "com.obric.aiagent.plugin");
        com.bytedance.retrofit2.b.c r0 = r9.a();
        LinkedList r2 = new LinkedList();
        r2.addAll(r0.c());
        Map<String, String> r7 = b();
        if (r7 == null) goto L9;
        Iterator<Map.Entry<String, String>> r10 = r7.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L9;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r2.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin")));
    L9:
        return r9.a(r0.m().a(r2).b());
    }

    private Map<String, String> b() {
        if (this.f6616a != null) goto L6;
        this.f6616a = new HashMap();
    L6:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.f6616a.get("x-vc-bdturing-sdk-version"), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        this.f6616a.put("x-vc-bdturing-sdk-version", "3.2.0.cn");
    L9:
        return this.f6616a;
    }
}
