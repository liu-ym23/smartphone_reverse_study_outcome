package com.obric.matrix.platform.sdk.ones.account;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.Unit;
import kotlin.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class OAccount {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OAccount f11867a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile AtomicBoolean f11868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CountDownLatch f11869c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Handler f11870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static IAccountService f11871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ServiceConnection f11872f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f11873g = null;

    public static final class AsyncResultCallback extends IAccountActionCallback.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function0 f11875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function2 f11876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function1 f11877d;

        public /* synthetic */ AsyncResultCallback(String r10, Function0 r11, Function2 r12, Function1 r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 8) == 0) goto L5;
            r13 = null;
        L5:
            this(r10, r11, r12, r13);
        }

        public static final /* synthetic */ void a(AsyncResultCallback r10, Function2 r11) {
            r10.f11876c = r11;
        }

        public static final /* synthetic */ void b(AsyncResultCallback r10, Function0 r11) {
            r10.f11875b = r11;
        }

        public static final /* synthetic */ void c(AsyncResultCallback r10, Function1 r11) {
            r10.f11877d = r11;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback
        public void onResult(boolean r10, Bundle r11) {
            OAccount.b(OAccount.f11867a, this.f11874a, r10, r11, this.f11875b, this.f11877d, this.f11876c, new OAccount$AsyncResultCallback$onResult$1(this));
        }

        public AsyncResultCallback(String r10, Function0 r11, Function2 r12, Function1 r13) {
            q.g(r10, "methodName");
            this.f11874a = r10;
            this.f11875b = r11;
            this.f11876c = r12;
            this.f11877d = r13;
        }
    }

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            q.g(r10, "name");
            q.g(r11, "service");
            bc.a.c("AccountSDK_OAccount", "onServiceConnected: ");
            OAccount r12 = OAccount.f11867a;
            OAccount.c(IAccountService.a.a(r11));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            q.g(r10, "name");
            bc.a.f("AccountSDK_OAccount", "onServiceDisconnected: name=" + r10);
            OAccount.c(null);
            OAccount.d(OAccount.f11867a);
        }
    }

    static {
        f11867a = new OAccount();
        f11868b = new AtomicBoolean(false);
        f11869c = new CountDownLatch(1);
        f11870d = new Handler(Looper.getMainLooper());
        f11872f = new a();
        f11873g = kotlin.b.b(OAccount$defaultErrorMsg$2.INSTANCE);
    }

    public OAccount() {
    }

    public static /* synthetic */ void a(boolean r10, String r11, Function1 r12, Bundle r13, Function0 r14, Function0 r15, Function2 r16) {
        f(r10, r11, r12, r13, r14, r15, r16);
    }

    public static final /* synthetic */ void b(OAccount r10, String r11, boolean r12, Bundle r13, Function0 r14, Function1 r15, Function2 r16, Function0 r17) {
        r10.e(r11, r12, r13, r14, r15, r16, r17);
    }

    public static final /* synthetic */ void c(IAccountService r10) {
        f11871e = r10;
    }

    public static final /* synthetic */ void d(OAccount r10) {
        r10.l();
    }

    public static final void f(boolean r10, String r11, Function1 r12, Bundle r13, Function0 r14, Function0 r15, Function2 r16) {
        q.g(r11, "$method");
        if (r10 == false) goto L11;
        bc.a.a("AccountSDK_OAccount", "asyncResult, " + r11 + ", success");
        if (r12 == null) goto L7;
        r12.invoke(r13);
    L9:
        if (r15 == null) goto L17;
        r15.invoke();
        return;
    L17:
        return;
    L7:
        if (r14 == null) goto L9;
        r14.invoke();
        goto L9
    L11:
        OAccount r17 = f11867a;
        int r18 = r17.j(r13, -1);
        String r19 = r17.i();
        q.f(r19, "defaultErrorMsg");
        String r20 = r17.k(r13, r19);
        bc.a.b("AccountSDK_OAccount", "asyncResult, " + r11 + " failed. errorCode: " + r18 + " errorMsg: " + r20 + '.');
        if (r16 == null) goto L14;
        r16.mo0invoke(Integer.valueOf(r18), r20);
    L14:
        if (r15 == null) goto L19;
        r15.invoke();
        return;
    }

    public static /* synthetic */ void h(OAccount r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = true;
    L5:
        r10.g(r11);
    }

    public final void e(final String r11, final boolean r12, final Bundle r13, final Function0 r14, final Function1 r15, final Function2 r16, final Function0 r17) {
        f11870d.post(new b(r12, r11, r15, r13, r14, r17, r16));
    }

    public final void g(boolean r10) {
        if (r10 == false) goto L11;
        if (f11868b.get() == false) goto L15;
        return;
    L15:
        f11869c.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        return;
    L9:
        throw new AccountException(1002, "account init timeout", null, 4, null);
    L11:
        if (f11868b.get() == false) goto L14;
        return;
    L14:
        throw new AccountException(1001, "please call init first ", null, 4, null);
    }

    public final String i() {
        return (String) f11873g.getValue();
    }

    public final int j(Bundle r10, int r11) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        return r10.getInt("errorCode", r11);
    }

    public final String k(Bundle r10, String r11) {
        if (r10 == null) goto L4;
        String r12 = r10.getString("errorMsg", r11);
    L5:
        if (r12 != null) goto L8;
        return r11;
    L8:
        return r12;
    L4:
        r12 = null;
        goto L5
    }

    public final void l() {
        h(this, false, 1, null);
        bc.a.c("AccountSDK_OAccount", "startBindService: ");
        Intent r10 = new Intent();
        r10.setClassName("com.obric.matrix", "com.obric.matrix.account.service.OAccountService");
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L6
        if (AppGlobals.f11863a.c().bindService(r10, f11872f, 1) == true) goto L8;
        bc.a.b("AccountSDK_OAccount", "startBindService: failed");     // Catch: Throwable -> L6
    L8:
        Object r12 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L6
    L11:
        Throwable r13 = Result.m38exceptionOrNullimpl(r12);
        if (r13 == null) goto L17;
        bc.a.f5978a.e("AccountSDK_OAccount", "onFailure startBindService: failed", r13);
        return;
    L17:
        return;
    L6:
        th = move-exception;
        Result.a r14 = Result.Companion;
        r12 = Result.m35constructorimpl(c.a(th));
        goto L11
    }
}
