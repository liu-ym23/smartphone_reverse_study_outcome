package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.honor.HonorOAIDCallback;
import com.bytedance.bdinstall.honor.HonorOAIDLimitCallback;
import com.bytedance.bdinstall.oaid.impl.IOAIDService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HonorOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends b<IOAIDService> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final HonorOAIDCallback f6399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final HonorOAIDLimitCallback f6400b;

    @Override // com.bytedance.bdinstall.oaid.k
    public String b() {
        return "HONOR";
    }

    @Override // com.bytedance.bdinstall.oaid.b, com.bytedance.bdinstall.oaid.k
    public /* synthetic */ boolean b(Context r3) {
        return super.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    f() {
        super("com.hihonor.id");
        this.f6399a = new HonorOAIDCallback();
        this.f6400b = new HonorOAIDLimitCallback();
    }

    @Override // com.bytedance.bdinstall.oaid.b
    public ServiceBlockBinder.a<IOAIDService, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.b
    public Intent a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Intent r3 = new Intent();
        r3.setAction("com.hihonor.id.HnOaIdService");
        r3.setPackage("com.hihonor.id");
        return r3;
    }

    @Override // com.bytedance.bdinstall.oaid.b, com.bytedance.bdinstall.oaid.k
    public k.a c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        k.a r0 = new k.a();
        new ServiceBlockBinder(r6, a(r6), a()).a();     // Catch: Exception -> L5
        r0.f6412b = this.f6399a.getOaid();     // Catch: Exception -> L5
        r0.f6413c = this.f6400b.isLimit();     // Catch: Exception -> L5
        com.bytedance.bdinstall.t.a("honor# getOaid " + r0.f6412b);     // Catch: Exception -> L5
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }
}
