package com.bytedance.bdinstall.h;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AccountCache.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends d {
    private static final String TAG = "AccountCache";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccountManager f6263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Account f6265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f6266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private an f6267e;

    static /* synthetic */ ConcurrentHashMap a(b r0) {
        return r0.f6266d;
    }

    static /* synthetic */ AccountManager b(b r0) {
        return r0.f6263a;
    }

    b(Context r3, String r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f6266d = new ConcurrentHashMap();
        this.f6263a = AccountManager.get(r6);
        this.f6264b = r4;
        this.f6267e = r5;
    }

    @Override // com.bytedance.bdinstall.h.d, com.bytedance.bdinstall.h.i
    public void a(String r2, String r3) {
        String r4 = c(r2);
        Account r0 = this.f6265c;
        if (r0 != null) goto L6;
        this.f6266d.put(r4, r3);
        return;
    L6:
        if (r3 != null) goto L13;
        return;
    L13:
        this.f6263a.setUserData(r0, r4, r3);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    private String c(String r2) {
        StringBuffer r0 = new StringBuffer(r2);
        r0.append(this.f6264b);
        if (this.f6267e.o() == true) goto L6;
        r0.append("_");
        r0.append(this.f6267e.b());
    L6:
        return r0.toString();
    }

    @Override // com.bytedance.bdinstall.h.d, com.bytedance.bdinstall.h.i
    public String a(String r4) {
        String r5 = c(r4);
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.f6266d.get(r5), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        Account r1 = this.f6265c;
        if (r1 != null) goto L13;
        return null;
    L13:
        return this.f6263a.getUserData(r1, r5);
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.bytedance.bdinstall.h.d
    public String[] b(String r1) {
        String r0 = a(r1);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }

    @Override // com.bytedance.bdinstall.h.d
    public void a(String r2, String[] r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        a(r2, TextUtils.join("\n", r3));
        return;
    L8:
        return;
    }

    void a(String r2, final Account r3) {
        if (r3 == null) goto L8;
        this.f6265c = r3;
        if (this.f6266d.size() > 0) goto L6;
        return;
    L6:
        w.b(r2, new AnonymousClass1(this, r3));
        return;
    }

    @Override // com.bytedance.bdinstall.h.d
    public void a(List<String> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = r8.iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        String r2 = c((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin"));
        this.f6266d.remove(r2);
        Account r3 = this.f6265c;     // Catch: Exception -> L17
        if (r3 == null) goto L7;
        AccountManager r4 = this.f6263a;     // Catch: Exception -> L17
        if (r4 == null) goto L7;
        r4.setUserData(r3, r2, null);     // Catch: Exception -> L17
        goto L7
    L15:
        super.a(r8);
    }
}
