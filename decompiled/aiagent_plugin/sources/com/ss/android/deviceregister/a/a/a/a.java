package com.ss.android.deviceregister.a.a.a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.ss.android.deviceregister.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: AccountCacheHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends b {
    private static final String TAG = "AccountCacheHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccountManager f37307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Account f37308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f37309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Set<String> f37310d;

    static /* synthetic */ ConcurrentHashMap a(a r0) {
        return r0.f37309c;
    }

    static /* synthetic */ AccountManager b(a r0) {
        return r0.f37307a;
    }

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f37309c = new ConcurrentHashMap();
        this.f37310d = null;
        this.f37307a = AccountManager.get(r4);
    }

    @Override // com.ss.android.deviceregister.a.a.a.b
    public void a(String r4, String r5) {
        o.b(o.f37441a, "AccountCacheHelper#cacheString key=" + r4 + " value=" + r5 + " mAccount=" + this.f37308b);
        if (this.f37308b != null) goto L6;
        this.f37309c.put(r4, r5);
        return;
    L6:
        if (r4 == null) goto L22;
        if (r5 == null) goto L23;
    L14:
        th = move-exception;
        if (Logger.debug() == false) goto L18;
        com.ss.android.common.util.e.e("save string error,please fix it : ", th);
    L18:
        th.printStackTrace();
        return;
    L10:
        if (Logger.debug() == false) goto L12;
        com.ss.android.common.util.e.b("AccountCacheHelper cache string : key = " + r4 + ",value = " + r5);     // Catch: Throwable -> L14
    L12:
        this.f37307a.setUserData(this.f37308b, r4, r5);     // Catch: Throwable -> L14
        return;
    L23:
        return;
    }

    @Override // com.ss.android.deviceregister.a.a.a.b
    public String a(String r4) {
        Account r0 = this.f37308b;
        if (r0 != null) goto L15;
        return null;
    L15:
        String r3 = this.f37307a.getUserData(r0, r4);     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L8;
        com.ss.android.common.util.e.b("AccountCacheHelper get cached string : key = " + r4 + ",value = " + r3);     // Catch: Throwable -> L9
    L8:
        return r3;
    L9:
        th = move-exception;
        if (Logger.debug() == false) goto L13;
        com.ss.android.common.util.e.e("get string error,please fix it : ");
    L13:
        th.printStackTrace();
        return null;
    }

    public void a(final Account r6) {
        if (r6 == null) goto L23;
        monitor-enter(this);
        this.f37308b = r6;     // Catch: Throwable -> L20
        if (this.f37309c.size() > 0) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L9:
        if (this.f37310d == null) goto L18;
        Iterator<String> r0 = this.f37310d.iterator();     // Catch: Throwable -> L20
    L12:
        if (r0.hasNext() == false) goto L18;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        this.f37307a.setUserData(this.f37308b, r1, null);     // Catch: Exception -> L16 Throwable -> L20
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        com.bytedance.common.utility.a.c.a(new AnonymousClass1(this, r6));
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.deviceregister.a.a.a.b
    public void b(String r4) {
        ConcurrentHashMap<String, String> r0 = this.f37309c;
        if (r0 != null) goto L5;
    L29:
        monitor-enter(this);     // Catch: Exception -> L28
    L23:
        th = move-exception;
        throw th;     // Catch: Exception -> L28
    L9:
        if (this.f37308b == null) goto L11;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L23
        Account r1 = this.f37308b;     // Catch: Exception -> L28
        if (r1 == null) goto L26;
        AccountManager r2 = this.f37307a;     // Catch: Exception -> L28
        if (r2 == null) goto L26;
        r2.setUserData(r1, r4, null);     // Catch: Exception -> L28
        goto L26
        goto L26
    L11:
        if (this.f37310d != null) goto L14;
        this.f37310d = new CopyOnWriteArraySet();     // Catch: Throwable -> L23
    L14:
        if (this.f37310d.contains(r4) == true) goto L16;
        this.f37310d.add(r4);     // Catch: Throwable -> L23
    L26:
        o.b(o.f37441a, "AccountCacheHelper#clear key=" + r4 + " mAccount=" + this.f37308b + " getCachedString(key)=" + a(r4));
        super.b(r4);
        return;
    L5:
        if (r0.containsKey(r4) == false) goto L29;
        this.f37309c.remove(r4);
        goto L29
    }
}
