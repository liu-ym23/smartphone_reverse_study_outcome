package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BaseOaidImpl.java */
/* JADX INFO: loaded from: classes4.dex */
abstract class c<SERVICE> implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f37364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ss.android.deviceregister.c.f<Boolean> f37365b;

    public abstract Intent a(Context r1);

    public abstract ServiceBlockBinder.a<SERVICE, String> a();

    static /* synthetic */ String a(c r0) {
        return r0.f37364a;
    }

    c(String r2) {
        this.f37365b = new AnonymousClass1(this);
        this.f37364a = r2;
    }

    @Override // com.ss.android.deviceregister.base.o
    public boolean b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return false;
    L6:
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f37365b.c(new Object[]{r5}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.ss.android.deviceregister.base.o
    public o.a c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        return a((String) ZeusTransformUtils.preCheckCast(new ServiceBlockBinder(r6, a(r6), a()).a(), String.class, "com.obric.aiagent.plugin"));
    }

    private o.a a(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return null;
    L6:
        o.a r0 = new o.a();
        r0.f37379a = r1;
        return r0;
    }
}
