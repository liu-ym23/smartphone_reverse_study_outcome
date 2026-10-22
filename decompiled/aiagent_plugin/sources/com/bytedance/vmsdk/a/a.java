package com.bytedance.vmsdk.a;

import android.util.Log;
import com.bytedance.vmsdk.a.a.b.f;
import com.bytedance.vmsdk.a.a.b.g;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ChromeDevtoolsServer.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements f {
    private static final String TAG = "ChromeDevtoolsServer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f11672a;

    public a(c r3) {
        this.f11672a = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.a.a.b.f
    public void a(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        a(TAG, "onOpen: ");
        this.f11672a.a(r4);
    }

    @Override // com.bytedance.vmsdk.a.a.b.f
    public void a(g r3, String r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        this.f11672a.a(r5, r4);
    }

    @Override // com.bytedance.vmsdk.a.a.b.f
    public void a(g r1, byte[] r2, int r3) {
        g r0 = (g) ZeusTransformUtils.wrapperContextForParams(r1, g.class, "com.obric.aiagent.plugin");
        b(TAG, "onMessage: byte");
    }

    @Override // com.bytedance.vmsdk.a.a.b.f
    public void a(g r2, int r3, String r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
        c(TAG, "onClose: " + r4);
        this.f11672a.b(r5);
    }

    @Override // com.bytedance.vmsdk.a.a.b.f
    public void a(g r3, Throwable r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        b(TAG, r4.getMessage());
        this.f11672a.b(r5);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
