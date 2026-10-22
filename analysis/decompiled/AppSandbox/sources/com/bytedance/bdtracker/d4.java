package com.bytedance.bdtracker;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class d4 extends f4 {
    public final AccountManager c;
    public Account d;
    public final ConcurrentHashMap<String, String> e = new ConcurrentHashMap<>();
    public final d f;

    public class a implements Runnable {
        public final /* synthetic */ Account a;

        public a(Account account) {
            this.a = account;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (d4.this.e.size() > 0 && d4.this.c != null) {
                    for (Map.Entry<String, String> entry : d4.this.e.entrySet()) {
                        if (entry != null) {
                            d4.this.c.setUserData(this.a, entry.getKey(), entry.getValue());
                        }
                    }
                    d4.this.e.clear();
                }
            } catch (Throwable th) {
                d4.this.f.D.error(Collections.singletonList("AccountCacheHelper"), "Set account failed", th, new Object[0]);
            }
        }
    }

    public d4(d dVar, Context context) {
        this.f = dVar;
        this.c = AccountManager.get(context);
    }

    public void a(Account account) {
        if (account != null) {
            this.d = account;
            if (this.e.size() <= 0) {
                return;
            }
            this.b.post(new a(account));
        }
    }

    @Override // com.bytedance.bdtracker.f4
    public void a(String str, String str2) {
        Account account = this.d;
        if (account == null) {
            this.e.put(str, str2);
            return;
        }
        if (str == null || str2 == null) {
            return;
        }
        try {
            this.c.setUserData(account, str, str2);
        } catch (Throwable th) {
            this.f.D.error(Collections.singletonList("AccountCacheHelper"), "Set user data failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.bdtracker.f4
    public void a(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return;
        }
        a(str, TextUtils.join("\n", strArr));
    }

    @Override // com.bytedance.bdtracker.f4
    public String b(String str) {
        Account account = this.d;
        if (account == null) {
            return this.e.get(str);
        }
        try {
            return this.c.getUserData(account, str);
        } catch (Throwable th) {
            this.f.D.error(Collections.singletonList("AccountCacheHelper"), "Get user data failed", th, new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.bdtracker.f4
    public String[] c(String str) {
        String strB = b(str);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return strB.split("\n");
    }

    @Override // com.bytedance.bdtracker.f4
    public void a(String str) {
        AccountManager accountManager;
        this.e.remove(str);
        try {
            Account account = this.d;
            if (account != null && (accountManager = this.c) != null) {
                accountManager.setUserData(account, str, null);
            }
        } catch (Throwable unused) {
        }
        f4 f4Var = this.a;
        if (f4Var != null) {
            f4Var.a(str);
        }
    }
}
