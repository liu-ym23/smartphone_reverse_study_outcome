package com.stepos.stepclaw.base.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/stepclaw/base/util/MzAccountIdentityProvider;", "Lcom/stepos/stepclaw/base/util/AccountIdentityProvider;", "<init>", "()V", "Landroid/app/Application;", "app", "Lb5/a0;", "ensureInit", "(Landroid/app/Application;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getOAID", "(Landroid/app/Application;)Ljava/lang/String;", "getLocalAccountId", "()Ljava/lang/String;", "Lkotlin/Function0;", "listener", "addAccountsUpdatedListener", "(Lp5/a;)V", "Ln2/a;", "mzAuthenticator", "Ln2/a;", "Landroid/accounts/AccountManager;", "accountManager", "Landroid/accounts/AccountManager;", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MzAccountIdentityProvider implements AccountIdentityProvider {
    private AccountManager accountManager;
    private n2.a mzAuthenticator;

    private final void ensureInit(Application app) {
        if (this.mzAuthenticator == null) {
            this.mzAuthenticator = new n2.a(app);
            this.accountManager = AccountManager.get(app);
        }
    }

    @Override // com.stepos.stepclaw.base.util.AccountIdentityProvider
    public void addAccountsUpdatedListener(final p5.a listener) {
        p.e(listener, "listener");
        AccountManager accountManager = this.accountManager;
        if (accountManager != null) {
            accountManager.addOnAccountsUpdatedListener(new OnAccountsUpdateListener() { // from class: com.stepos.stepclaw.base.util.a
                @Override // android.accounts.OnAccountsUpdateListener
                public final void onAccountsUpdated(Account[] accountArr) {
                    listener.invoke();
                }
            }, null, false);
        }
    }

    @Override // com.stepos.stepclaw.base.util.AccountIdentityProvider
    public String getLocalAccountId() {
        n2.a aVar = this.mzAuthenticator;
        if (aVar != null) {
            Context context = aVar.f3974a;
            String str = null;
            Account account = null;
            if (context != null) {
                Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.meizu.account");
                if (accountsByType.length > 0) {
                    if (accountsByType.length != 1) {
                        Log.e("z", "more than 1 flyme account : " + accountsByType.length);
                    }
                    account = accountsByType[0];
                }
                str = account == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : account.name;
            }
            if (str != null) {
                return str;
            }
        }
        return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009e A[PHI: r3
      0x009e: PHI (r3v2 android.database.Cursor) = 
      (r3v1 android.database.Cursor)
      (r3v1 android.database.Cursor)
      (r3v1 android.database.Cursor)
      (r3v5 android.database.Cursor)
      (r3v5 android.database.Cursor)
     binds: [B:6:0x0028, B:9:0x0030, B:11:0x0034, B:40:0x0099, B:41:0x009b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.String] */
    @Override // com.stepos.stepclaw.base.util.AccountIdentityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getOAID(android.app.Application r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.String r0 = "app"
            kotlin.jvm.internal.p.e(r12, r0)
            r11.ensureInit(r12)
            g3.c r11 = g3.c.b()
            android.content.Context r12 = r12.getApplicationContext()
            java.lang.Object r0 = r11.f2955b
            g3.a r0 = (g3.a) r0
            long r1 = r0.f2950a
            long r3 = java.lang.System.currentTimeMillis()
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L22
            java.lang.String r11 = r0.f2951b
            goto La6
        L22:
            r1 = 1
            boolean r2 = r11.e(r12, r1)
            r3 = 0
            if (r2 != 0) goto L2c
            goto L9e
        L2c:
            g3.d r2 = r11.c(r12)
            if (r2 == 0) goto L9e
            boolean r4 = r2.f2962c
            if (r4 == 0) goto L9e
            java.lang.String r4 = r2.f2961b     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            android.net.Uri r6 = android.net.Uri.parse(r4)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            android.content.ContentResolver r5 = r12.getContentResolver()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.lang.String r4 = r0.f2952c     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            java.lang.String[] r9 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            r10 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r4 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L93
            r5 = 0
            if (r4 == 0) goto L80
            com.google.crypto.tink.shaded.protobuf.d r6 = g3.c.a(r4)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L7d
            java.lang.Object r7 = r6.d     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L7d
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L7d
            r0.f2951b = r7     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L77
            long r8 = r6.f1442c     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L77
            r0.f2950a = r8     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L77
            int r0 = r6.f1441b     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L77
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r0 == r3) goto L7b
            java.lang.String r0 = r2.f2960a     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L77
            r11.d(r12, r0)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L77
            boolean r0 = r11.e(r12, r5)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L77
            if (r0 != 0) goto L7b
            r11.e(r12, r1)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L77
            goto L7b
        L73:
            r0 = move-exception
            r11 = r0
            r3 = r4
            goto La0
        L77:
            r0 = move-exception
            r11 = r0
            r3 = r7
            goto L96
        L7b:
            r11 = r7
            goto L8a
        L7d:
            r0 = move-exception
            r11 = r0
            goto L96
        L80:
            boolean r0 = r11.e(r12, r5)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L7d
            if (r0 == 0) goto L89
            r11.e(r12, r1)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L7d
        L89:
            r11 = r3
        L8a:
            if (r4 == 0) goto La6
            r4.close()
            goto La6
        L90:
            r0 = move-exception
            r11 = r0
            goto La0
        L93:
            r0 = move-exception
            r11 = r0
            r4 = r3
        L96:
            r11.getMessage()     // Catch: java.lang.Throwable -> L73
            if (r4 == 0) goto L9e
            r4.close()
        L9e:
            r11 = r3
            goto La6
        La0:
            if (r3 == 0) goto La5
            r3.close()
        La5:
            throw r11
        La6:
            if (r11 != 0) goto Laa
            java.lang.String r11 = "unknown"
        Laa:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.util.MzAccountIdentityProvider.getOAID(android.app.Application):java.lang.String");
    }
}
