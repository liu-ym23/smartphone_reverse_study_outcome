package com.ss.android.deviceregister.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: OnePlusOaidImpl.java */
/* JADX INFO: loaded from: classes4.dex */
final class u implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f37395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ss.android.deviceregister.c.f<Boolean> f37396b;

    static /* synthetic */ String a(u r2, Context r3) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    u() {
        this(null);
    }

    u(o r3) {
        o r4 = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.aiagent.plugin");
        this.f37396b = new AnonymousClass1(this);
        this.f37395a = r4;
    }

    @Override // com.ss.android.deviceregister.base.o
    public boolean b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return false;
    L5:
        o r2 = this.f37395a;
        if (r2 == null) goto L12;
        if (r2.b(r5) == false) goto L12;
        return this.f37395a.b(r5);
    L12:
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f37396b.c(new Object[]{r5}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.ss.android.deviceregister.base.o
    public o.a c(Context r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o r0 = this.f37395a;
        if (r0 != null) goto L5;
    L8:
        Intent r1 = new Intent();
        r1.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        r1.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String r5 = (String) ZeusTransformUtils.preCheckCast(new ServiceBlockBinder(r7, r1, new AnonymousClass2(this, r7)).a(), String.class, "com.obric.aiagent.plugin");
        o.a r8 = new o.a();
        r8.f37379a = r5;
        return r8;
    L5:
        if (r0.b(r7) == false) goto L8;
        return this.f37395a.c(r7);
    }

    private String a(Context r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        PackageInfo r8 = r6.getPackageManager().getPackageInfo(r6.getPackageName(), 64);     // Catch: Exception -> L7
        if (r8 == null) goto L9;
        Signature[] r9 = r8.signatures;     // Catch: Exception -> L7
    L10:
        if (r9 != null) goto L12;
    L23:
        return null;
    L12:
        if (r9.length <= 0) goto L23;
        int r0 = 0;
        byte[] r10 = r9[0].toByteArray();
        MessageDigest r1 = MessageDigest.getInstance("SHA1");     // Catch: Exception -> L21
        if (r1 == null) goto L23;
        byte[] r11 = r1.digest(r10);     // Catch: Exception -> L21
        StringBuilder r2 = new StringBuilder();     // Catch: Exception -> L21
        int r3 = r11.length;     // Catch: Exception -> L21
    L17:
        if (r0 >= r3) goto L19;
        r2.append(Integer.toHexString((r11[r0] & 255) | 256).substring(1, 3));     // Catch: Exception -> L21
        r0 = r0 + 1;     // Catch: Exception -> L21
        goto L17
    L19:
        return r2.toString();
    L21:
        e = move-exception;
        e.printStackTrace();
    L9:
        r9 = null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }
}
