package com.bytedance.bdturing.twiceverify;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.bdturing.verify.a.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: TwiceVerifyManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f6621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f6622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f6623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.bdturing.twiceverify.a f6624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.bdturing.verify.a.a f6625e;
    private b.a f;

    /* JADX INFO: compiled from: TwiceVerifyManager.java */
    public interface a {
        void a();

        void a(int r1, String r2);
    }

    static {
    }

    public c() {
        this.f = new AnonymousClass1(this);
    }

    public static c a() {
        if (f6621a != null) goto L13;
        monitor-enter(c.class);
        f6621a = new c();     // Catch: Throwable -> L9
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f6621a;
    }

    public void a(com.bytedance.bdturing.verify.a.a r3, HashMap<String, String> r4, a r5) {
        this.f6623c = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L12;
        if (c() == null) goto L7;
        c().a(r4, this.f);
        return;
    L7:
        a r2 = this.f6623c;
        if (r2 == null) goto L28;
        r2.a(-1, "start showCertVerify fail TwiceVerifyDepend is null");
        return;
    L28:
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.bdturing.verify.a.c.class) == true) goto L14;
        this.f6625e = r3;
        Activity r6 = ZeusTransformUtils.getActivity(r3, "com.obric.aiagent.plugin");
        if (r6 == null) goto L23;
        Intent r7 = new Intent();
        r7.setClass(r6, TwiceVerifyWebActivity.class);
        ZeusTransformUtils.startActivity(r6, r7, "com.obric.aiagent.plugin");
        return;
    L23:
        a r8 = this.f6623c;
        if (r8 == null) goto L32;
        r8.a(-1, "start verify error activity is null");
        return;
    L32:
        return;
    L14:
        if (c() == null) goto L16;
        c().b(r4, this.f);
        return;
    L16:
        a r9 = this.f6623c;
        if (r9 == null) goto L30;
        r9.a(-1, "start showCertLiveVerify fail TwiceVerifyDepend is null");
        return;
    }

    public boolean b() {
        if (this.f6622b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public b c() {
        return this.f6622b;
    }

    public com.bytedance.bdturing.twiceverify.a d() {
        return this.f6624d;
    }

    public a e() {
        return this.f6623c;
    }

    public com.bytedance.bdturing.verify.a.a f() {
        return this.f6625e;
    }

    public void g() {
        this.f6623c = null;
        this.f6625e = null;
    }
}
