package org.chromium.mpa;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.c.a;
import com.ttnet.org.chromium.net.ab;
import com.ttnet.org.chromium.net.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.chromium.CronetClient;

/* JADX INFO: loaded from: classes5.dex */
public class CronetMpaServiceImpl implements a {
    private static final String PRE_CNIT_KETNEL_FUNC = "preInitCronetKernel";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private ab.a mCronetAccAddressCallback;
    private d mCronetEngine;
    private ab.a mCronetInitCallback;
    private a.InterfaceC0186a mOuterAccAddressCallback;
    private a.InterfaceC0186a mOuterInitCallback;
    private ab mTTNetMpaService;

    public CronetMpaServiceImpl() {
        this.mCronetInitCallback = new AnonymousClass1(this);
        this.mCronetAccAddressCallback = new AnonymousClass2(this);
    }

    static /* synthetic */ a.InterfaceC0186a access$000(CronetMpaServiceImpl r0) {
        return r0.mOuterInitCallback;
    }

    static /* synthetic */ a.InterfaceC0186a access$100(CronetMpaServiceImpl r0) {
        return r0.mOuterAccAddressCallback;
    }

    static /* synthetic */ a.InterfaceC0186a access$102(CronetMpaServiceImpl r2, a.InterfaceC0186a r3) {
        a.InterfaceC0186a r4 = (a.InterfaceC0186a) ZeusTransformUtils.wrapperContextForParams(r3, a.InterfaceC0186a.class, "com.obric.aiagent.plugin");
        r2.mOuterAccAddressCallback = r4;
        return r4;
    }

    public void init(a.InterfaceC0186a r3) {
        a.InterfaceC0186a r4 = (a.InterfaceC0186a) ZeusTransformUtils.wrapperContextForParams(r3, a.InterfaceC0186a.class, "com.obric.aiagent.plugin");
        if (createMpaService() == true) goto L6;
        r4.a(false, "Create MpaService Failed");
        return;
    L6:
        this.mOuterInitCallback = r4;
        this.mTTNetMpaService.a(this.mCronetInitCallback);
    }

    private boolean createMpaService() {
        if (loadCronetKernel() == true) goto L7;
        return false;
    L7:
        if (this.mTTNetMpaService != null) goto L11;
        this.mTTNetMpaService = this.mCronetEngine.a();
        return true;
    L11:
        return true;
    }

    private boolean loadCronetKernel() {
        if (this.mCronetEngine == null) goto L12;
        return true;
    L12:
        Reflect.on(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.aiagent.plugin").newInstance()).call(PRE_CNIT_KETNEL_FUNC);     // Catch: Throwable -> L8
        d r0 = CronetClient.getCronetEngine();     // Catch: Throwable -> L8
        this.mCronetEngine = r0;     // Catch: Throwable -> L8
        if (r0 == null) goto L14;
        return true;
    L14:
        return false;
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public void setAccAddress(List<String> r4, a.InterfaceC0186a r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a.InterfaceC0186a r7 = (a.InterfaceC0186a) ZeusTransformUtils.wrapperContextForParams(r5, a.InterfaceC0186a.class, "com.obric.aiagent.plugin");
        if (this.mTTNetMpaService != null) goto L5;
        if (r7 == null) goto L23;
        r7.a(false, "TTNetMpaService is null");
        return;
    L23:
        return;
    L5:
        monitor-enter(CronetMpaServiceImpl.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.mOuterAccAddressCallback == null) goto L12;
        if (r7 == null) goto L10;
        r7.a(false, "setAccAddress is running");     // Catch: Throwable -> L15
    L10:
        monitor-exit(CronetMpaServiceImpl.class);     // Catch: Throwable -> L15
        return;
    L12:
        this.mOuterAccAddressCallback = r7;     // Catch: Throwable -> L15
        monitor-exit(CronetMpaServiceImpl.class);     // Catch: Throwable -> L15
        this.mTTNetMpaService.a(r6, this.mCronetAccAddressCallback);
    }

    public void start() {
        ab r0 = this.mTTNetMpaService;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public void stop() {
        ab r0 = this.mTTNetMpaService;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public void command(String r1, String r2) {
        ab r0 = this.mTTNetMpaService;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }
}
