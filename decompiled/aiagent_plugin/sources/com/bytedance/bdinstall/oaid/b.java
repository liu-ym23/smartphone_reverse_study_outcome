package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BaseOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
abstract class b<SERVICE> implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.bdinstall.j.r<Boolean> f6392b;

    public abstract Intent a(Context r1);

    public abstract ServiceBlockBinder.a<SERVICE, String> a();

    static /* synthetic */ String a(b r0) {
        return r0.f6391a;
    }

    b(String r2) {
        this.f6392b = new AnonymousClass1(this);
        this.f6391a = r2;
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public boolean b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return false;
    L6:
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f6392b.c(new Object[]{r5}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public k.a c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        return a((String) ZeusTransformUtils.preCheckCast(new ServiceBlockBinder(r6, a(r6), a()).a(), String.class, "com.obric.aiagent.plugin"));
    }

    private k.a a(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return null;
    L6:
        k.a r0 = new k.a();
        r0.f6412b = r1;
        return r0;
    }
}
