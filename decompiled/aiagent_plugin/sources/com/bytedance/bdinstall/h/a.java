package com.bytedance.bdinstall.h;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.ba;
import com.bytedance.bdinstall.j.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

/* JADX INFO: compiled from: AbsDeviceParamsProvider.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements com.bytedance.bdinstall.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f6258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final k f6259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected d f6260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected b f6261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f6262e;
    protected String f;
    protected final String g;
    private volatile String h;

    private String b(boolean r1) {
        if (r1 == false) goto L4;
        return "_local";
    L4:
        return "";
    }

    public void a(k r1, d r2) {
    }

    a(Context r5, k r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        this.g = b(r6.c());
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f6258a = r0;
        this.f6259b = r6;
        this.f6260c = new j(r0, r6.b(), r6.h());
        if (com.bytedance.bdinstall.migrate.a.b(r7, r6.h()) == true) goto L11;
        b r1 = new b(r7, r6.f(), r6.h());
        this.f6261d = r1;
        this.f6260c.a(r1);
        b r2 = this.f6261d;
        if (p.E() == false) goto L9;
        if (p.a(r7) == true) goto L11;
    L9:
        if (r6.g() == false) goto L11;
        a(r6, r2);
    L11:
        a(r6.e());
    }

    @Override // com.bytedance.bdinstall.g.a
    public String a(boolean r7) {
        if (TextUtils.isEmpty(this.f6262e) == false) goto L5;
        String r8 = com.bytedance.bdinstall.j.g.a(this.f6258a);
        SharedPreferences r0 = com.bytedance.bdinstall.j.j.a(this.f6258a, this.f6259b.h());
        String r1 = r0.getString("openudid", null);
        if (ba.a(r8) == false) goto L12;
        if ("9774d56d682e549c".equals(r8) == false) goto L24;
    L12:
        if (ba.a(r1) == true) goto L23;
        r1 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L31
        if (r1.charAt(0) != '-') goto L16;
        r1 = r1.substring(1);     // Catch: Exception -> L31
    L16:
        int r3 = 13 - r1.length();     // Catch: Exception -> L31
        if (r3 <= 0) goto L23;
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L31
    L19:
        if (r3 <= 0) goto L21;
        r4.append('F');     // Catch: Exception -> L31
        r3 = r3 - 1;     // Catch: Exception -> L31
        goto L19
    L21:
        r4.append(r1);     // Catch: Exception -> L31
        r8 = r4.toString();     // Catch: Exception -> L31
    L23:
        r8 = r1;
    L24:
        SharedPreferences.Editor r2 = r0.edit();
        r2.putString("openudid", r8);
        r2.apply();
        if (TextUtils.isEmpty(r8) == true) goto L28;
        r8 = r8 + this.g;
    L28:
        if (TextUtils.isEmpty(r8) == true) goto L30;
        this.f6262e = r8;
    L30:
        return r8;
    L5:
        return this.f6262e;
    }

    @Override // com.bytedance.bdinstall.g.a
    public String a() {
        if (TextUtils.isEmpty(this.f) == false) goto L5;
        SharedPreferences r1 = com.bytedance.bdinstall.j.j.a(this.f6258a, this.f6259b.h());     // Catch: Exception -> L14
        String r2 = r1.getString("clientudid", null);     // Catch: Exception -> L14
        if (ba.a(r2) == true) goto L10;
        r2 = UUID.randomUUID().toString();     // Catch: Exception -> L14
        SharedPreferences.Editor r3 = r1.edit();     // Catch: Exception -> L14
        r3.putString("clientudid", r2);     // Catch: Exception -> L14
        r3.apply();     // Catch: Exception -> L14
    L10:
        if (TextUtils.isEmpty(r2) == true) goto L12;
        r2 = r2 + this.g;     // Catch: Exception -> L14
    L12:
        this.f = r2;     // Catch: Exception -> L14
        return r2;
    L14:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        return this.f;
    }

    @Override // com.bytedance.bdinstall.g.a
    public String b() {
        if (TextUtils.isEmpty(this.h) == false) goto L5;
        this.h = this.f6260c.f("", "");
        return this.h;
    L5:
        return this.h;
    }

    @Override // com.bytedance.bdinstall.g.a
    public void a(String r3) {
        if (ba.c(r3) == true) goto L5;
        return;
    L5:
        if (ba.a(r3, this.h) == true) goto L10;
        this.h = this.f6260c.f(r3, this.h);
        return;
    }

    public void a(Account r2) {
        b r0 = this.f6261d;
        if (r0 == null) goto L6;
        r0.a(this.f6259b.h().b(), r2);
        return;
    }
}
