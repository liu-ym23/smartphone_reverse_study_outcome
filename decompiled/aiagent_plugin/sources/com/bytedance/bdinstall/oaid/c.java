package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.MsaIdInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CommonOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class c extends b<MsaIdInterface> {
    @Override // com.bytedance.bdinstall.oaid.k
    public String b() {
        return "Common";
    }

    c() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.bdinstall.oaid.b, com.bytedance.bdinstall.oaid.k
    public k.a c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        a(r4, r4.getPackageName());
        return super.c(r4);
    }

    @Override // com.bytedance.bdinstall.oaid.b
    public ServiceBlockBinder.a<MsaIdInterface, String> a() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.b
    public Intent a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Intent r4 = new Intent();
        r4.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        r4.setAction("com.bun.msa.action.bindto.service");
        r4.putExtra("com.bun.msa.param.pkgname", r2.getPackageName());
        return r4;
    }

    private void a(Context r4, String r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Intent r6 = new Intent();
        r6.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        r6.setAction("com.bun.msa.action.start.service");
        r6.putExtra("com.bun.msa.param.pkgname", r5);
        r6.putExtra("com.bun.msa.param.runinset", true);     // Catch: Exception -> L5
        ZeusTransformUtils.startService(r3, r6, "com.obric.aiagent.plugin");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
