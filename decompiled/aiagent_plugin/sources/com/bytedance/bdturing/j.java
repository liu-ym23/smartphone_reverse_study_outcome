package com.bytedance.bdturing;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: PreCreateManager.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<VerifyDialog> f6586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6589d;

    /* JADX INFO: renamed from: com.bytedance.bdturing.j$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreCreateManager.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: PreCreateManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static j f6590a;

        static /* synthetic */ j a() {
            return f6590a;
        }

        static {
            f6590a = new j(null);
        }
    }

    /* synthetic */ j(AnonymousClass1 r1) {
        this();
    }

    private j() {
        this.f6589d = false;
    }

    public static j a() {
        return a.a();
    }

    public long b() {
        return this.f6587b;
    }

    public long c() {
        return this.f6588c;
    }

    public void d() {
        this.f6589d = true;
    }

    public boolean a(int r5) {
        WeakReference<VerifyDialog> r0 = this.f6586a;
        if (r0 != null) goto L5;
        return false;
    L5:
        VerifyDialog r1 = (VerifyDialog) ZeusTransformUtils.preCheckCast(r0.get(), VerifyDialog.class, "com.obric.aiagent.plugin");
        if (this.f6589d == false) goto L12;
        if (r1 == null) goto L12;
        if (r5 != r1.getRequest().getType()) goto L12;
        this.f6589d = false;
        this.f6588c = System.currentTimeMillis();
        r1.callJsCode(com.bytedance.bdturing.b.c.a(1, "bytedcert.refreshVerifyView", "call", new JSONObject(), "bytedcert.refreshVerifyView"));
        r1.show();
        return true;
    L12:
        return false;
    }
}
