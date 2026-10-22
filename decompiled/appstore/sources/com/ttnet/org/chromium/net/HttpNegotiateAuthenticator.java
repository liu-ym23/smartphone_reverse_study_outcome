package com.ttnet.org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("net::android")
public class HttpNegotiateAuthenticator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f18370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18371b;

    public interface Natives {
        void setResult(long r10, HttpNegotiateAuthenticator r11, int r12, String r13);
    }

    public class a implements AccountManagerCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f18372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HttpNegotiateAuthenticator f18373b;

        public a(HttpNegotiateAuthenticator r10, c r11) {
            this.f18373b = r10;
            this.f18372a = r11;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture r11) {
            Account[] r12 = (Account[]) r11.getResult();     // Catch: Throwable -> L18
            if (r12.length != 0) goto L9;
            com.ttnet.org.chromium.base.j.h("net_auth", "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
            h.b().setResult(this.f18372a.f18378a, this.f18373b, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
            return;
        L9:
            if (r12.length <= 1) goto L13;
            com.ttnet.org.chromium.base.j.h("net_auth", "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", new Object[]{Integer.valueOf(r12.length)});
            h.b().setResult(this.f18372a.f18378a, this.f18373b, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
            return;
        L13:
            if (this.f18373b.b(com.ttnet.org.chromium.base.e.d(), "android.permission.USE_CREDENTIALS", true) == false) goto L16;
            com.ttnet.org.chromium.base.j.a("net_auth", "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: USE_CREDENTIALS permission not granted. Aborting authentication.", new Object[0]);
            h.b().setResult(this.f18372a.f18378a, this.f18373b, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT, null);
            return;
        L16:
            c r10 = this.f18372a;
            Account r13 = r12[0];
            r10.f18382e = r13;
            r10.f18379b.getAuthToken(r13, r10.f18381d, r10.f18380c, true, new b(this.f18373b, r10), new Handler(ThreadUtils.c()));
            return;
        L18:
            e = move-exception;
            com.ttnet.org.chromium.base.j.h("net_auth", "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", new Object[]{e});
            h.b().setResult(this.f18372a.f18378a, this.f18373b, -9, null);
        }
    }

    public class b implements AccountManagerCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f18374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HttpNegotiateAuthenticator f18375b;

        public class a extends BroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f18376a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f18377b;

            public a(b r10, Context r11) {
                this.f18377b = r10;
                this.f18376a = r11;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context r10, Intent r11) {
                this.f18376a.unregisterReceiver(this);
                AccountManager r12 = b.a(this.f18377b).f18379b;
                Account r13 = b.a(this.f18377b).f18382e;
                String r14 = b.a(this.f18377b).f18381d;
                Bundle r15 = b.a(this.f18377b).f18380c;
                b r16 = this.f18377b;
                r12.getAuthToken(r13, r14, r15, true, new b(r16.f18375b, b.a(r16)), null);
            }
        }

        public b(HttpNegotiateAuthenticator r10, c r11) {
            this.f18375b = r10;
            this.f18374a = r11;
        }

        public static /* synthetic */ c a(b r10) {
            return r10.f18374a;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture r10) {
            Bundle r11 = (Bundle) r10.getResult();     // Catch: Throwable -> L8
            if (r11.containsKey(MemorySourceLinkType.INTENT) == false) goto L6;
            Context r12 = com.ttnet.org.chromium.base.e.d();
            r12.registerReceiver(new a(this, r12), new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
            return;
        L6:
            HttpNegotiateAuthenticator.a(this.f18375b, r11, this.f18374a);
            return;
        L8:
            e = move-exception;
            com.ttnet.org.chromium.base.j.h("net_auth", "ERR_UNEXPECTED: Error while attempting to obtain a token.", new Object[]{e});
            h.b().setResult(this.f18374a.f18378a, this.f18375b, -9, null);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f18378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AccountManager f18379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bundle f18380c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f18381d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Account f18382e;

        public c() {
        }
    }

    static {
    }

    public HttpNegotiateAuthenticator(String r10) {
        this.f18371b = r10;
    }

    public static /* synthetic */ void a(HttpNegotiateAuthenticator r10, Bundle r11, c r12) {
        r10.c(r11, r12);
    }

    @CalledByNative
    @VisibleForTesting
    public static HttpNegotiateAuthenticator create(String r10) {
        return new HttpNegotiateAuthenticator(r10);
    }

    public boolean b(Context r10, String r11, boolean r12) {
        if (r12 == false) goto L6;
        return false;
    L6:
        if (r10.checkPermission(r11, Process.myPid(), Process.myUid()) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final void c(Bundle r10, c r11) {
        this.f18370a = r10.getBundle("spnegoContext");
        int r12 = -9;
        switch(r10.getInt("spnegoResult", 1)) {
            case 0: goto L13;
            case 1: goto L4;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        int r13 = r12;
        h.b().setResult(r11.f18378a, this, r13, r10.getString("authtoken"));
        return;
    L5:
        r12 = NetError.ERR_MALFORMED_IDENTITY;
        goto L4
    L6:
        r12 = NetError.ERR_UNDOCUMENTED_SECURITY_LIBRARY_STATUS;
        goto L4
    L7:
        r12 = NetError.ERR_MISSING_AUTH_CREDENTIALS;
        goto L4
    L8:
        r12 = NetError.ERR_UNSUPPORTED_AUTH_SCHEME;
        goto L4
    L9:
        r12 = NetError.ERR_INVALID_AUTH_CREDENTIALS;
        goto L4
    L10:
        r12 = NetError.ERR_INVALID_RESPONSE;
        goto L4
    L11:
        r12 = NetError.ERR_UNEXPECTED_SECURITY_LIBRARY_STATUS;
        goto L4
    L12:
        r12 = -3;
        goto L4
    L13:
        r12 = 0;
        goto L4
    }

    public final void d(Context r18, Activity r19, c r20, String[] r21) {
        if (b(r18, "android.permission.GET_ACCOUNTS", false) == false) goto L6;
        com.ttnet.org.chromium.base.j.a("net_auth", "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: %s permission not granted. Aborting authentication", new Object[]{"android.permission.GET_ACCOUNTS"});
        h.b().setResult(r20.f18378a, this, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT, null);
        return;
    L6:
        r20.f18379b.getAuthTokenByFeatures(this.f18371b, r20.f18381d, r21, r19, null, r20.f18380c, new b(this, r20), new Handler(ThreadUtils.c()));
    }

    public final void e(Context r10, c r11, String[] r12) {
        if (b(r10, "android.permission.GET_ACCOUNTS", true) == false) goto L6;
        com.ttnet.org.chromium.base.j.a("net_auth", "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: GET_ACCOUNTS permission not granted. Aborting authentication.", new Object[0]);
        h.b().setResult(r11.f18378a, this, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT, null);
        return;
    L6:
        r11.f18379b.getAccountsByTypeAndFeatures(this.f18371b, r12, new a(this, r11), new Handler(ThreadUtils.c()));
    }

    @CalledByNative
    @VisibleForTesting
    public void getNextAuthToken(long r10, String r11, String r12, boolean r13) {
        Context r14 = com.ttnet.org.chromium.base.e.d();
        c r15 = new c();
        r15.f18381d = "SPNEGO:HOSTBASED:" + r11;
        r15.f18379b = AccountManager.get(r14);
        r15.f18378a = r10;
        String[] r16 = {"SPNEGO"};
        Bundle r17 = new Bundle();
        r15.f18380c = r17;
        if (r12 == null) goto L5;
        r17.putString("incomingAuthToken", r12);
    L5:
        Bundle r18 = this.f18370a;
        if (r18 == null) goto L8;
        r15.f18380c.putBundle("spnegoContext", r18);
    L8:
        r15.f18380c.putBoolean("canDelegate", r13);
        Activity r19 = ApplicationStatus.c();
        if (r19 != null) goto L11;
        e(r14, r15, r16);
        return;
    L11:
        d(r14, r19, r15, r16);
    }
}
