package com.ss.android.deviceregister.base;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: Oaid.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static n f37377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f37378b;

    public static n a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f37377a != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f37377a != null) goto L9;
        f37377a = new n(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return f37377a;
    }

    private n(Context r3) {
        this.f37378b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    Map<String, String> a(long r2) {
        if (com.ss.android.deviceregister.g.a() == false) goto L7;
        return com.bytedance.bdinstall.oaid.j.a(this.f37378b).a(r2);
    L7:
        return t.a(this.f37378b).a(r2);
    }

    public String a() {
        if (com.ss.android.deviceregister.g.a() == false) goto L7;
        return com.bytedance.bdinstall.oaid.j.a(this.f37378b).c();
    L7:
        return t.a(this.f37378b).b();
    }

    boolean b() {
        if (com.ss.android.deviceregister.g.a() == false) goto L7;
        return com.bytedance.bdinstall.oaid.j.a(this.f37378b).d();
    L7:
        return t.a(this.f37378b).c();
    }
}
