package com.obric.matrix.platform.sdk.ones.account;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.n;
import d.x;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: OAccount.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OAccount {
    private static final String TAG = "AccountSDK_OAccount";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OAccount f33600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile AtomicBoolean f33601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CountDownLatch f33602c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.obric.matrix.platform.sdk.ones.account.a.a f33603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static com.obric.matrix.platform.sdk.ones.account.a.b f33604e;
    private static Handler f;
    private static IAccountService g;
    private static final ServiceConnection h = null;
    private static final d.f i = null;

    /* JADX INFO: compiled from: OAccount.kt */
    public static final class AsyncResultCallback extends IAccountActionCallback.Stub {
        private m<? super Integer, ? super String, x> _onFailed;
        private d.h.a.a<x> _onSuccess;
        private d.h.a.b<? super Bundle, x> _onSuccessEx;
        private final String methodName;

        /* JADX INFO: compiled from: OAccount.kt */
        static final class a extends p implements d.h.a.a<x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AsyncResultCallback f33605a;

            a(AsyncResultCallback r1) {
                this.f33605a = r1;
                super(0);
            }

            @Override // d.h.a.a
            public /* synthetic */ x invoke() {
                a();
                return x.f38692a;
            }

            public final void a() {
                AsyncResultCallback.access$set_onSuccess$p(this.f33605a, null);
                AsyncResultCallback.access$set_onFailed$p(this.f33605a, null);
                AsyncResultCallback.access$set_onSuccessEx$p(this.f33605a, null);
            }
        }

        public /* synthetic */ AsyncResultCallback(String r2, d.h.a.a r3, m r4, d.h.a.b r5, int r6, h r7) {
            d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            m r9 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
            d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
            if ((r6 & 8) == 0) goto L5;
            r10 = null;
        L5:
            this(r2, r8, r9, r10);
        }

        public static final /* synthetic */ void access$set_onFailed$p(AsyncResultCallback r2, m r3) {
            r2._onFailed = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        }

        public static final /* synthetic */ void access$set_onSuccess$p(AsyncResultCallback r2, d.h.a.a r3) {
            r2._onSuccess = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        }

        public static final /* synthetic */ void access$set_onSuccessEx$p(AsyncResultCallback r2, d.h.a.b r3) {
            r2._onSuccessEx = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        }

        public AsyncResultCallback(String r3, d.h.a.a<x> r4, m<? super Integer, ? super String, x> r5, d.h.a.b<? super Bundle, x> r6) {
            d.h.a.a<x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            m<? super Integer, ? super String, x> r8 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
            d.h.a.b<? super Bundle, x> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r3, "methodName");
            this.methodName = r3;
            this._onSuccess = r7;
            this._onFailed = r8;
            this._onSuccessEx = r9;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback
        public void onResult(boolean r9, Bundle r10) {
            OAccount.a(OAccount.f33600a, this.methodName, r9, r10, this._onSuccess, this._onSuccessEx, this._onFailed, (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OAccount.kt */
    static final class a extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33606a = null;

        static {
            f33606a = new a();
        }

        a() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f33619a.b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.sdk_account_unknown_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "sdk_account_unknown_error"));
        }
    }

    public static /* synthetic */ void lambda$ouvmikErs6mN4Sx7vLR82gUlw6E(boolean r0, String r1, d.h.a.b r2, Bundle r3, d.h.a.a r4, d.h.a.a r5, m r6) {
        a(r0, r1, r2, r3, r4, r5, r6);
    }

    private OAccount() {
    }

    public static final /* synthetic */ void a(IAccountService r2) {
        g = (IAccountService) ZeusTransformUtils.wrapperContextForParams(r2, IAccountService.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(OAccount r0) {
        r0.b();
    }

    public static final /* synthetic */ void a(OAccount r10, String r11, boolean r12, Bundle r13, d.h.a.a r14, d.h.a.b r15, m r16, d.h.a.a r17) {
        r10.a(r11, r12, r13, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.b.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.wrapperContextForParams(r16, m.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r17, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    static {
        f33600a = new OAccount();
        f33601b = new AtomicBoolean(false);
        f33602c = new CountDownLatch(1);
        f = new Handler(Looper.getMainLooper());
        h = (ServiceConnection) ZeusTransformUtils.preCheckCast(new OAccount$mAccountServiceCon$1(), ServiceConnection.class, "com.obric.aiagent.plugin");
        i = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(a.f33606a, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final String a() {
        return (String) ZeusTransformUtils.preCheckCast(i.b(), String.class, "com.obric.aiagent.plugin");
    }

    public final void a(Application r3, com.obric.matrix.platform.sdk.ones.account.a.d r4, com.obric.matrix.platform.sdk.ones.account.a.a r5) {
        Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        com.obric.matrix.platform.sdk.ones.account.a.d r7 = (com.obric.matrix.platform.sdk.ones.account.a.d) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.matrix.platform.sdk.ones.account.a.d.class, "com.obric.aiagent.plugin");
        com.obric.matrix.platform.sdk.ones.account.a.a r8 = (com.obric.matrix.platform.sdk.ones.account.a.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.matrix.platform.sdk.ones.account.a.a.class, "com.obric.aiagent.plugin");
        o.e(r6, "application");
        o.e(r7, "logger");
        o.e(r8, "bridge");
        a(r6, r7, r8, false);
    }

    private final void a(Application r2, com.obric.matrix.platform.sdk.ones.account.a.d r3, com.obric.matrix.platform.sdk.ones.account.a.a r4, boolean r5) {
        Application r1 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
        com.obric.matrix.platform.sdk.ones.account.a.d r6 = (com.obric.matrix.platform.sdk.ones.account.a.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.matrix.platform.sdk.ones.account.a.d.class, "com.obric.aiagent.plugin");
        com.obric.matrix.platform.sdk.ones.account.a.a r7 = (com.obric.matrix.platform.sdk.ones.account.a.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.matrix.platform.sdk.ones.account.a.a.class, "com.obric.aiagent.plugin");
        com.obric.matrix.platform.sdk.ones.account.b.a.b(TAG, "init, asyncInit: " + r5);
        AtomicBoolean r8 = f33601b;
        monitor-enter(r8);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f33601b.get() == false) goto L9;
        com.obric.matrix.platform.sdk.ones.account.b.a.c(TAG, "Init already.");     // Catch: Throwable -> L12
        monitor-exit(r8);
        return;
    L9:
        com.obric.matrix.platform.sdk.ones.account.b.a.f33614a.a(r6);     // Catch: Throwable -> L12
        OAccount r9 = f33600a;     // Catch: Throwable -> L12
        f33603d = r7;     // Catch: Throwable -> L12
        f33604e = (com.obric.matrix.platform.sdk.ones.account.a.b) ZeusTransformUtils.preCheckCast(f.f33622a, com.obric.matrix.platform.sdk.ones.account.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        r9.b(r5);     // Catch: Throwable -> L12
        f33601b.set(true);     // Catch: Throwable -> L12
        f33602c.countDown();     // Catch: Throwable -> L12
        r9.b();     // Catch: Throwable -> L12
        x r10 = x.f38692a;     // Catch: Throwable -> L12
        monitor-exit(r8);
    }

    private final void b(boolean r1) {
        com.obric.matrix.platform.sdk.ones.account.a.b r0 = f33604e;
        if (r0 != null) goto L5;
        o.c("mAccountManager");
        r0 = null;
    L5:
        r0.a(r1);
    }

    public static /* synthetic */ b a(OAccount r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.a(r1);
    }

    public final b a(boolean r3) {
        com.obric.matrix.platform.sdk.ones.account.a.b r1 = null;
        b(this, false, 1, null);
        com.obric.matrix.platform.sdk.ones.account.a.b r2 = f33604e;
        if (r2 != null) goto L5;
        o.c("mAccountManager");
    L7:
        return r1.d();
    L5:
        r1 = r2;
        goto L7
    }

    public final void a(com.obric.matrix.platform.sdk.ones.account.a.c r2) {
        com.obric.matrix.platform.sdk.ones.account.a.c r1 = (com.obric.matrix.platform.sdk.ones.account.a.c) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.matrix.platform.sdk.ones.account.a.c.class, "com.obric.aiagent.plugin");
        o.e(r1, "accountStatusListener");
        com.obric.matrix.platform.sdk.ones.account.a.b r3 = f33604e;
        if (r3 != null) goto L5;
        o.c("mAccountManager");
        r3 = null;
    L5:
        r3.a(r1);
    }

    public final void b(com.obric.matrix.platform.sdk.ones.account.a.c r2) {
        com.obric.matrix.platform.sdk.ones.account.a.c r1 = (com.obric.matrix.platform.sdk.ones.account.a.c) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.matrix.platform.sdk.ones.account.a.c.class, "com.obric.aiagent.plugin");
        o.e(r1, "accountStatusListener");
        com.obric.matrix.platform.sdk.ones.account.a.b r3 = f33604e;
        if (r3 != null) goto L5;
        o.c("mAccountManager");
        r3 = null;
    L5:
        r3.b(r1);
    }

    private final void b() {
        b(this, false, 1, null);
        com.obric.matrix.platform.sdk.ones.account.b.a.b(TAG, "startBindService: ");
        Intent r3 = new Intent();
        r3.setClassName("com.obric.matrix", "com.obric.matrix.account.service.OAccountService");
        n.a r4 = n.f38560a;     // Catch: Throwable -> L8
        OAccount r6 = (OAccount) ZeusTransformUtils.preCheckCast(this, OAccount.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (ZeusTransformUtils.bindService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f33619a.b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, h, 1, "com.obric.aiagent.plugin") == true) goto L6;
        com.obric.matrix.platform.sdk.ones.account.b.a.d(TAG, "startBindService: failed");     // Catch: Throwable -> L8
    L6:
        Object r7 = n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r8 = n.c(r7);
        if (r8 == null) goto L16;
        com.obric.matrix.platform.sdk.ones.account.b.a.f33614a.b(TAG, "onFailure startBindService: failed", r8);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        n.a r0 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L10
    }

    static /* synthetic */ void b(OAccount r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.c(r1);
    }

    private final void c(boolean r9) {
        if (r9 == false) goto L11;
        if (f33601b.get() == false) goto L15;
        return;
    L15:
        f33602c.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        return;
    L9:
        throw new com.obric.matrix.platform.sdk.ones.account.a(1002, "account init timeout", null, 4, null);
    L11:
        if (f33601b.get() == false) goto L14;
        return;
    L14:
        throw new com.obric.matrix.platform.sdk.ones.account.a(1001, "please call init first ", null, 4, null);
    }

    private final void a(final String r11, final boolean r12, final Bundle r13, d.h.a.a<x> r14, d.h.a.b<? super Bundle, x> r15, m<? super Integer, ? super String, x> r16, d.h.a.a<x> r17) {
        final d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        final d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.b.class, "com.obric.aiagent.plugin");
        final m r9 = (m) ZeusTransformUtils.wrapperContextForParams(r16, m.class, "com.obric.aiagent.plugin");
        final d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r17, d.h.a.a.class, "com.obric.aiagent.plugin");
        f.post(new $$Lambda$OAccount$ouvmikErs6mN4Sx7vLR82gUlw6E(r12, r11, r5, r13, r7, r8, r9));
    }

    private static final void a(boolean r3, String r4, d.h.a.b r5, Bundle r6, d.h.a.a r7, d.h.a.a r8, m r9) {
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r12 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        m r13 = (m) ZeusTransformUtils.wrapperContextForParams(r9, m.class, "com.obric.aiagent.plugin");
        o.e(r4, "$method");
        if (r3 == false) goto L11;
        com.obric.matrix.platform.sdk.ones.account.b.a.a(TAG, "asyncResult, " + r4 + ", success");
        if (r10 == null) goto L7;
        r10.invoke(r6);
    L9:
        if (r12 == null) goto L17;
        r12.invoke();
        return;
    L17:
        return;
    L7:
        if (r11 == null) goto L9;
        r11.invoke();
        goto L9
    L11:
        OAccount r14 = f33600a;
        int r15 = r14.a(r6, -1);
        String r16 = r14.a();
        o.c(r16, "defaultErrorMsg");
        String r17 = r14.a(r6, r16);
        com.obric.matrix.platform.sdk.ones.account.b.a.d(TAG, "asyncResult, " + r4 + " failed. errorCode: " + r15 + " errorMsg: " + r17 + '.');
        if (r13 == null) goto L14;
        r13.invoke(Integer.valueOf(r15), r17);
    L14:
        if (r12 == null) goto L19;
        r12.invoke();
        return;
    }

    private final int a(Bundle r1, int r2) {
        if (r1 != null) goto L4;
        return r2;
    L4:
        return r1.getInt("errorCode", r2);
    }

    private final String a(Bundle r1, String r2) {
        if (r1 == null) goto L4;
        String r0 = r1.getString("errorMsg", r2);
    L5:
        if (r0 != null) goto L8;
        return r2;
    L8:
        return r0;
    L4:
        r0 = null;
        goto L5
    }
}
