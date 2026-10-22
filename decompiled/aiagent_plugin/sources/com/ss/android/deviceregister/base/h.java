package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.Intent;
import com.hihonor.cloudservice.oaid.IOAIDService;
import com.ss.android.deviceregister.base.honor.HonorOAIDCallback;
import com.ss.android.deviceregister.base.honor.HonorOAIDLimitCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HonorOaidImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class h extends c<IOAIDService> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final HonorOAIDCallback f37371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final HonorOAIDLimitCallback f37372b;

    @Override // com.ss.android.deviceregister.base.c, com.ss.android.deviceregister.base.o
    public /* synthetic */ boolean b(Context r3) {
        return super.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    h() {
        super("com.hihonor.id");
        this.f37371a = new HonorOAIDCallback();
        this.f37372b = new HonorOAIDLimitCallback();
    }

    @Override // com.ss.android.deviceregister.base.c
    public ServiceBlockBinder.a<IOAIDService, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.ss.android.deviceregister.base.c
    public Intent a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Intent r3 = new Intent();
        r3.setAction("com.hihonor.id.HnOaIdService");
        r3.setPackage("com.hihonor.id");
        return r3;
    }

    @Override // com.ss.android.deviceregister.base.c, com.ss.android.deviceregister.base.o
    public o.a c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.a r0 = new o.a();
        new ServiceBlockBinder(r6, a(r6), a()).a();     // Catch: Exception -> L5
        r0.f37379a = this.f37371a.getOaid();     // Catch: Exception -> L5
        r0.f37380b = this.f37372b.isLimit();     // Catch: Exception -> L5
        com.ss.android.deviceregister.o.b("honor# ", "getOaid " + r0.f37379a);     // Catch: Exception -> L5
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }
}
