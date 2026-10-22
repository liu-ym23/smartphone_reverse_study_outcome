package com.ttnet.org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class HttpNegotiateAuthenticator {
    private static final String TAG = "net_auth";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37793a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f37794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f37795c;

    class GetAccountsCallback implements AccountManagerCallback<Account[]> {
        private final b mRequestData;
        final /* synthetic */ HttpNegotiateAuthenticator this$0;

        public GetAccountsCallback(HttpNegotiateAuthenticator r1, b r2) {
            this.this$0 = r1;
            this.mRequestData = r2;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Account[]> r10) {
            Account[] r11 = (Account[]) ZeusTransformUtils.preCheckCast(((AccountManagerFuture) ZeusTransformUtils.wrapperContextForParams(r10, AccountManagerFuture.class, "com.obric.aiagent.plugin")).getResult(), Account[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
            if (r11.length != 0) goto L9;
            com.ttnet.org.chromium.base.j.d(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
            j.a().setResult(this.mRequestData.f37798a, this.this$0, -341, null);
            return;
        L9:
            if (r11.length <= 1) goto L17;
            com.ttnet.org.chromium.base.j.d(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", new Object[]{Integer.valueOf(r11.length)});
            j.a().setResult(this.mRequestData.f37798a, this.this$0, -341, null);
            return;
        L17:
            return;
        L12:
            e = move-exception;
            com.ttnet.org.chromium.base.j.d(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", new Object[]{e});
            j.a().setResult(this.mRequestData.f37798a, this.this$0, -9, null);
        }
    }

    class GetTokenCallback implements AccountManagerCallback<Bundle> {
        private final b mRequestData;
        final /* synthetic */ HttpNegotiateAuthenticator this$0;

        static /* synthetic */ b access$000(GetTokenCallback r0) {
            return r0.mRequestData;
        }

        public GetTokenCallback(HttpNegotiateAuthenticator r1, b r2) {
            this.this$0 = r1;
            this.mRequestData = r2;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> r9) {
            Bundle r10 = (Bundle) ZeusTransformUtils.preCheckCast(((AccountManagerFuture) ZeusTransformUtils.wrapperContextForParams(r9, AccountManagerFuture.class, "com.obric.aiagent.plugin")).getResult(), Bundle.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            if (r10.containsKey(MemorySourceLinkType.INTENT) == false) goto L7;
            final Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            ZeusTransformUtils.registerReceiver(r11, new AnonymousClass1(this, r11), new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"), "com.obric.aiagent.plugin");
            return;
        L7:
            HttpNegotiateAuthenticator.a(this.this$0, r10, this.mRequestData);
            return;
        L9:
            e = move-exception;
            com.ttnet.org.chromium.base.j.d(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to obtain a token.", new Object[]{e});
            j.a().setResult(this.mRequestData.f37798a, this.this$0, -9, null);
        }
    }

    interface a {
        void setResult(long r1, HttpNegotiateAuthenticator r3, int r4, String r5);
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f37798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AccountManager f37799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bundle f37800c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f37801d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Account f37802e;

        b() {
        }
    }

    static {
    }

    private void a(Context r1, Activity r2, b r3, String[] r4) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    private void a(Context r1, b r2, String[] r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
    }

    static /* synthetic */ void a(HttpNegotiateAuthenticator r0, Bundle r1, b r2) {
        r0.a(r1, r2);
    }

    public HttpNegotiateAuthenticator(String r2) {
        if (f37793a == false) goto L5;
    L9:
        this.f37795c = r2;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L9;
        throw new AssertionError();
    }

    static HttpNegotiateAuthenticator create(String r1) {
        return new HttpNegotiateAuthenticator(r1);
    }

    void getNextAuthToken(long r6, String r8, String r9, boolean r10) {
        if (f37793a == true) goto L8;
        if (r8 != null) goto L8;
        throw new AssertionError();
    L8:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        b r2 = new b();
        r2.f37801d = "SPNEGO:HOSTBASED:" + r8;
        r2.f37799b = AccountManager.get(r0);
        r2.f37798a = r6;
        String[] r7 = {"SPNEGO"};
        r2.f37800c = new Bundle();
        if (r9 == null) goto L12;
        r2.f37800c.putString("incomingAuthToken", r9);
    L12:
        if (this.f37794b == null) goto L14;
        r2.f37800c.putBundle("spnegoContext", this.f37794b);
    L14:
        r2.f37800c.putBoolean("canDelegate", r10);
        Activity r11 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApplicationStatus.b(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L17;
        a(r0, r2, r7);
        return;
    L17:
        a(r0, r11, r2, r7);
    }

    private void a(Bundle r9, b r10) {
        this.f37794b = r9.getBundle("spnegoContext");
        int r1 = -9;
        switch(r9.getInt("spnegoResult", 1)) {
            case 0: goto L13;
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L14;
        };
    L5:
        r1 = -329;
        goto L14
    L6:
        r1 = -344;
        goto L14
    L7:
        r1 = -341;
        goto L14
    L8:
        r1 = -339;
        goto L14
    L9:
        r1 = -338;
        goto L14
    L10:
        r1 = -320;
        goto L14
    L11:
        r1 = -342;
        goto L14
    L12:
        r1 = -3;
        goto L14
    L13:
        r1 = 0;
    L14:
        a r2 = j.a();
        long r3 = r10.f37798a;
        r2.setResult(r3, this, r1, r9.getString("authtoken"));
    }
}
